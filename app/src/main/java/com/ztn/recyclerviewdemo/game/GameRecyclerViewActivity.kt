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
        //敌人下降


        //生成新的敌人


    }

    override fun toRight() {

    }

    override fun toLeft() {

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
        gameState = NOGAME

        gameBean.clear()
        for (i in 0 until 7 * 8) {
            gameBean.add(GameBean(Triple(first = false, second = false, third = false)))
        }

        gameBean[52].gz = Triple(first = true, second = false, third = false)
        adapter.notifyDataSetChanged()

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
