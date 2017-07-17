package com.ztn.recyclerviewdemo.recyclerviewsample.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ztn.common.BaseViewItemFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by Administrator on 2017/6/19
 */

public class AddOrDeleteHolder extends BaseViewItemFinder {
    RecyclerView recyclerView;
    Button increase, delete, notify;

    protected AddOrDeleteHolder(View view) {
        super(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.simple_rl);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        increase = (Button) view.findViewById(R.id.button1);
        delete = (Button) view.findViewById(R.id.button2);
        notify = (Button) view.findViewById(R.id.button3);
    }
}
