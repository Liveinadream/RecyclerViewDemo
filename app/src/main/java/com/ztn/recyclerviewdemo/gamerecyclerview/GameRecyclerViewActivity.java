package com.ztn.recyclerviewdemo.gamerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ztn.common.BaseActivity;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.gamerecyclerview.gameadppter.GameRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import kotlin.Triple;

/**
 * Created by 冒险者ztn on 2018/1/24.
 * 一个游戏RecyclerView
 */

public class GameRecyclerViewActivity extends BaseActivity implements GameBox {

    List<GameBean> gameBean;
    GameRecyclerViewAdapter adapter;
    GameRecyclerViewHolder gameRecyclerViewHolder;
    RecyclerView gameRv;


    public static Intent newIntent(Context context) {
        return new Intent(context, GameRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameRv = findViewById(R.id.game_rv);

        gameBean = new ArrayList<>();
        gameRv.setLayoutManager(new StaggeredGridLayoutManager(8, 1));

        for (int i = 1; i < 8 * 8; i++) {
            gameBean.add(new GameBean(new Triple<>(false, false, false)));
        }
        adapter = new GameRecyclerViewAdapter(this, gameBean);

        gameRecyclerViewHolder = new GameRecyclerViewHolder(this);

        gameRv.setAdapter(adapter);


    }

    @Override
    public void refreshAll() {

    }

    @Override
    public void toRight() {

    }

    @Override
    public void toLeft() {

    }

    @Override
    public void setSpeed() {

    }

    @Override
    public void speedDown() {

    }

    @Override
    public void speedUp() {

    }

    @Override
    public void setAEnemy() {

    }

    @Override
    public void dropEnemy() {

    }
}
