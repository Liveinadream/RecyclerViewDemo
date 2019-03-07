package com.ztn.recyclerviewdemo;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ztn.common.BaseViewFinder;

/**
 * Created by ztn on 2017/3/28
 *
 * @see MainActivity
 */

public class MainActivityHolder extends BaseViewFinder {
    RecyclerView recyclerView;

    MainActivityHolder(Activity activity) {
        super(activity);
        recyclerView = (RecyclerView) activity.findViewById(R.id.main_activity_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }
}
