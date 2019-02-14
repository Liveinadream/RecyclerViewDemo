package com.ztn.recyclerviewdemo.gamerecyclerview;

import java.util.List;

/**
 * Created by 冒险者ztn on 2018/1/24.
 * 游戏中被选中的黑格子
 */

public class GameBean {

    public List<checkedList> game;

    public static class checkedList {
        public List<Boolean> checked;
    }
}
