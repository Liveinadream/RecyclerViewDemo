package com.ztn.recyclerviewdemo.timerecyclerview;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ztn.common.BaseViewFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by ztn on 2017/3/28
 *
 * @see TimeRecyclerViewActivity
 */

public class TimeRecyclerViewActivityHolder extends BaseViewFinder {
    RecyclerView recyclerView;

    protected TimeRecyclerViewActivityHolder(Activity activity) {
        super(activity);
        recyclerView = (RecyclerView) activity.findViewById(R.id.time_activity_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }
}
