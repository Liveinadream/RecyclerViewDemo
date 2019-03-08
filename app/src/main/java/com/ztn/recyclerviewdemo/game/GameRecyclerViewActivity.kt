package com.ztn.recyclerviewdemo.game

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ztn.common.BaseActivity
import com.ztn.recyclerviewdemo.R
import com.ztn.recyclerviewdemo.game.adppter.GameRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*


/**
 * Created by 冒险者ztn on 2018/1/24.
 * 一个游戏RecyclerView
 */

class GameRecyclerViewActivity : BaseActivity(), GameBox {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, GameRecyclerViewActivity::class.java)
        }

        const val NO_GAME = 1            //当前没有游戏在进行
        const val START_GAME = 2         //当前游戏已经开始
        const val END_GAME = 3           //当前游戏已经结束
    }

//    private val mHandler = object : Handler() {
//       override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            when (msg.what) {
//                START_GAME ->{
//                    //在这里去执行定时操作逻辑
//                    val message =obtainMessage(START_GAME)
//                    this.sendMessageDelayed(message, 1000)
//                }
//
//                else -> {
//                }
//            }
//        }
//    }
//
//    class MyHandler :Handler(){
//
//
//        override fun handleMessage(msg: Message?) {
//            super.handleMessage(msg)
//
//
//        }
//    }

    private var gameState = NO_GAME
    private var speed = 1f
    private var useScore = 0
    private lateinit var gameBean: MutableList<GameBean>
    private lateinit var adapter: GameRecyclerViewAdapter
    private lateinit var timer: CountDownTimer
    val position = ArrayList<Int>()
    private val default = Triple(false, second = false, third = false)
    private var selfNum = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        gameBean = ArrayList()
        game_rv.layoutManager = StaggeredGridLayoutManager(7, 1)

        for (i in 0 until 7 * 8) {
            gameBean.add(GameBean(Triple(first = false, second = false, third = false)))
        }
        adapter = GameRecyclerViewAdapter(this, gameBean)

        game_rv.adapter = adapter

        reset()

        initListener()
        initTask()
    }

    private fun initListener() {
        toLeft.setOnClickListener {
            toLeft()
        }

        toRight.setOnClickListener {
            toRight()
        }

        startGame.setOnClickListener {
            startGame()
        }

        speedDown.setOnClickListener {
            speedDown()
        }

        speedUp.setOnClickListener {
            speedUp()
        }
    }

    private fun initTask() {
        timer = object : CountDownTimer(36000, 1000 * speed.toLong()) {
            override fun onTick(millisUntilFinished: Long) {
                if (gameState == START_GAME)
                    setEnemy()
            }

            override fun onFinish() {

                gameState = END_GAME
                gameEnd.visibility = View.VISIBLE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun refreshAll(position: ArrayList<Int>) {
        Log.d("获取到的数组：", position.toString())
        //已有敌人下降
        for (i in gameBean.size downTo 0) {
            if (i < 49) {
                gameBean[i + 7] = gameBean[i]
                if ((i + 7) == (selfNum + 48) && gameBean[i + 7].gz.second && gameBean[selfNum + 48].gz.first) {
                    gameBean[i + 7].gz = Triple(true, second = true, third = true)
                    gameEnd()
                }
            }
        }
        //生成新的敌人
        for (i in 0 until 7) {
            gameBean[i] = GameBean(default)
        }

        position.forEach {
            gameBean[it] = GameBean(Triple(false, second = true, third = false))
        }

        //刷新
        adapter.notifyDataSetChanged()
        if (gameState != END_GAME) {
            useScore++
            score.text = "${useScore}分"

        }

    }

    override fun toRight() {
        if (selfNum < 7 && gameState == START_GAME) {
            selfNum++
            showSelf()
        }
    }

    override fun toLeft() {
        if (selfNum > 0 && gameState == START_GAME) {
            selfNum--
            showSelf()
        }

    }

    private fun showSelf() {
        gameBean[selfNum + 48] = GameBean(Triple(first = true, second = false, third = false))
        adapter.notifyItemChanged(selfNum + 48)
    }

    override fun setSpeed() {

    }

    override fun speedDown() {
        speed += 0.1f
    }

    override fun speedUp() {
        if (speed > 0.1f) {
            speed -= 0.1f
        } else {
            Toast.makeText(this, "速度已经是最快了", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setEnemy() {
        position.clear()
        //生成的敌人个数 最多生成6个
        val enemyPosition = Random().nextInt(7)
        Log.d("生成的敌人个数：", enemyPosition.toString())
        //在7个位置中生成对应的有敌人的位置
        for (i in 0 until enemyPosition) {
            giveNum()
        }

        refreshAll(position)
    }

    override fun dropEnemy() {

    }

    override fun reset() {
        useScore = 0
        score.text = "分数：0"
        gameEnd.visibility = View.GONE
        selfNum = 3
        gameState = NO_GAME

        gameBean.clear()
        for (i in 0 until 7 * 8) {
            gameBean.add(GameBean(Triple(first = false, second = false, third = false)))
        }

        gameBean[52].gz = Triple(first = true, second = false, third = false)
        adapter.notifyDataSetChanged()
    }

    override fun setSelf() {
        gameBean[selfNum + 48] = GameBean(Triple(true, second = false, third = false))
        adapter.notifyItemChanged(selfNum + 48)

    }

    override fun gameEnd() {
        timer.onFinish()

    }

    override fun startGame() {
        reset()
        gameState = START_GAME
        timer.start()

    }

    private fun giveNum() {
        val num = getNum()
        if (position.contains(num)) {
            getNum()
        } else {
            position.add(num)
        }
    }

    private fun getNum() = Random().nextInt( 7)

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

}
