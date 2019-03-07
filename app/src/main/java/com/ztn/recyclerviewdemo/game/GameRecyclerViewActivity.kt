package com.ztn.recyclerviewdemo.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.Toast
import com.ztn.common.BaseActivity
import com.ztn.recyclerviewdemo.R
import com.ztn.recyclerviewdemo.game.adppter.GameRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_game.*
import java.util.ArrayList
import kotlin.random.Random

/**
 * Created by 冒险者ztn on 2018/1/24.
 * 一个游戏RecyclerView
 */

class GameRecyclerViewActivity : BaseActivity(), GameBox {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, GameRecyclerViewActivity::class.java)
        }

        const val NOGAME = 1            //当前没有游戏在进行
        const val STARTGAME = 2         //当前游戏已经开始
        const val ENDGAME = 3           //当前游戏已经结束
    }

    var gameState = NOGAME
    var speed = 1f
    lateinit var gameBean: MutableList<GameBean>
    lateinit var adapter: GameRecyclerViewAdapter
    val position = ArrayList<Int>()
    private val moren = Triple(false, second = false, third = false)
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

        toLeft.setOnClickListener {
            toLeft()
        }

        toRight.setOnClickListener {
            toRight()
        }

    }

    override fun refreshAll(position: ArrayList<Int>) {
        //已有敌人下降
        for (i in gameBean.size downTo 0) {
            if (i < 50) {
                gameBean[i + 7] = gameBean[i]
                if (gameBean[i + 7].gz.second && gameBean[selfNum + 48].gz.first) {
                    gameBean[i + 7].gz = Triple(true, second = true, third = true)
                }
            }
        }
        //生成新的敌人
        for (i in 0 until 7) {
            gameBean[i] = GameBean(moren)
        }

        position.forEach {
            gameBean[it] = GameBean(Triple(false, second = true, third = false))
        }

        //刷新
        adapter.notifyDataSetChanged()

    }

    override fun toRight() {
        if (selfNum < 7) {
            selfNum++
        }
    }

    override fun toLeft() {
        if (selfNum > 0) {
            selfNum--
        }

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
        val enemyPosition = Random(1).nextInt(0, 7)

        //在7个位置中生成对应的有敌人的位置
        for (i in 0 until enemyPosition) {
            giveNum()
        }

        refreshAll(position)
    }

    override fun dropEnemy() {

    }

    override fun reset() {
        score.text = "分数：0"
        gameEnd.visibility = View.GONE
        selfNum = 3
        gameState = NOGAME

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

    private fun giveNum() {
        val num = getNum()
        if (position.contains(num)) {
            getNum()
        } else {
            position.add(num)
        }
    }

    private fun getNum() = Random(1).nextInt(0, 7)

}
