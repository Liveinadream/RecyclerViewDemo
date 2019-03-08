package com.ztn.recyclerviewdemo.game

/**
 * Created by 冒险者ztn on 2019/3/7.
 * 游戏各自 bean
 * 1：自己。2：敌人。3：是否碰撞
 * 说实话，第三个参数没啥用，但是懒得改了
 */
data class GameBean(var gz: Triple<Boolean, Boolean, Boolean>)