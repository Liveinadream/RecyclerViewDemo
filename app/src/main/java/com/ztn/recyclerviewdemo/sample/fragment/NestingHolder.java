package com.ztn.recyclerviewdemo.sample.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ztn.common.BaseViewItemFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by Administrator on 2017/6/19
 */

public class NestingHolder extends BaseViewItemFinder {
    RecyclerView recyclerView;

    protected NestingHolder(View view) {
        super(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.nesting_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}
