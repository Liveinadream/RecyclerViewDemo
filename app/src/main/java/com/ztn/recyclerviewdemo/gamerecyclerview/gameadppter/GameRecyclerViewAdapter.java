package com.ztn.recyclerviewdemo.gamerecyclerview.gameadppter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.gamerecyclerview.GameBean;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageBean;

import java.util.List;

/**
 * Created by 冒险者ztn on 2018/1/24.
 */

public class GameRecyclerViewAdapter extends
        SimpleRecycleViewAdapter<GameBean, GameRecyclerViewHolder> {

    public GameRecyclerViewAdapter(Context context, List<GameBean> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     */
    @Override
    protected GameRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new GameRecyclerViewHolder(inflater.inflate(R.layout.activity_game_item, parent, false));
    }

    /**
     * 给view设置数据
     */

    @Override
    protected void onBindItemViewHolder(GameRecyclerViewHolder gameRecyclerViewHolder, int position) {
        gameRecyclerViewHolder.initView(listData.get(position));
    }

}
