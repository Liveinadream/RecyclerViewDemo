package com.ztn.recyclerviewdemo.game

/**
 * Created by 冒险者ztn on 2019/3/7.
 * 游戏 recyclerView 需要实现的功能
 *
 */
interface GameBox {

    //刷新
    fun refreshAll(position: ArrayList<Int>)

    //设置速度
    fun setSpeed()

    fun speedDown()

    fun speedUp()

    /**
     * 游戏部分
     */

    //设置敌人
    fun setEnemy()

    //向左
    fun toRight()

    //向右
    fun toLeft()

    //丢弃一个敌人，同时加一分
    fun dropEnemy()

    //重置
    fun reset()

}