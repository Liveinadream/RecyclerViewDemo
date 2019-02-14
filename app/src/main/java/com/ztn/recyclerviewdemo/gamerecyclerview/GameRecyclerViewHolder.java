package com.ztn.recyclerviewdemo.gamerecyclerview;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.ztn.common.BaseViewFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by 冒险者ztn on 2018/1/24.
 * 游戏界面view
 */

public class GameRecyclerViewHolder extends BaseViewFinder {
    Button toLeft, toRight, start;
    TextView endGame, score;
    RecyclerView recyclerView;


    protected GameRecyclerViewHolder(Activity activity) {
        super(activity);

        toLeft = (Button) activity.findViewById(R.id.to_left);
        toRight = (Button) activity.findViewById(R.id.to_right);
        start = (Button) activity.findViewById(R.id.start_game);

        endGame = (TextView) activity.findViewById(R.id.game_end);
        score = (TextView) activity.findViewById(R.id.score);

        recyclerView = (RecyclerView) activity.findViewById(R.id.game_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(activity,7));




    }


    public void getSelf(){

    }

    public void getAnim(){

    }

    public void setToLeft(){

    }

    public void startGame(){

    }


}
