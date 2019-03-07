package com.ztn.recyclerviewdemo.game

/**
 * Created by 冒险者ztn on 2019/3/7.
 * 游戏各自 bean
 * 1：自己。2：敌人。3：是否碰撞
 */
data class GameBean(var gz: Triple<Boolean, Boolean, Boolean>)