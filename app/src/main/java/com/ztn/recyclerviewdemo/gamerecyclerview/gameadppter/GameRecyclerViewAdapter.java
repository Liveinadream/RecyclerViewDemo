package com.ztn.recyclerviewdemo.gamerecyclerview.gameadppter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageBean;

import java.util.List;

/**
 * Created by 冒险者ztn on 2018/1/24.
 * 介绍 todo
 */

public class GameRecyclerViewAdapter extends
        SimpleRecycleViewAdapter<LinkageBean.Data, GameRecyclerViewHolder> {


    public GameRecyclerViewAdapter(Context context, List<LinkageBean.Data> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected GameRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new GameRecyclerViewHolder(inflater.inflate(R.layout.activity_linkage_leftl_year_item, parent, false));
    }

    /**
     * 给view设置数据
     * @param gameRecyclerViewHolder
     * @param position
     */

    @Override
    protected void onBindItemViewHolder(GameRecyclerViewHolder gameRecyclerViewHolder, int position) {
        gameRecyclerViewHolder.initView(context, listData.get(position), position);
    }

}
