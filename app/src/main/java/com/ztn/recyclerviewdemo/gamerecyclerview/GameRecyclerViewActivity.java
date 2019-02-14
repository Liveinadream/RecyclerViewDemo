package com.ztn.recyclerviewdemo.gamerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ztn.common.BaseActivity;
import com.ztn.recyclerviewdemo.R;

import java.util.ArrayList;

/**
 * Created by 冒险者ztn on 2018/1/24.
 * 一个游戏recyclerview
 */

public class GameRecyclerViewActivity extends BaseActivity {

    GameBean gameBean;
    GameRecyclerViewHolder gameRecyclerViewHolder;


    public static Intent newIntent(Context context) {
        return new Intent(context, GameRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameBean = new GameBean();
        gameBean.game = new ArrayList<>();

        gameRecyclerViewHolder = new GameRecyclerViewHolder(this);




    }

    public void setGameData(ArrayList<Boolean> checkList){
        //清除选中数组中的
        gameBean.game.clear();

    }


    public void getGameData(){

    }
}
