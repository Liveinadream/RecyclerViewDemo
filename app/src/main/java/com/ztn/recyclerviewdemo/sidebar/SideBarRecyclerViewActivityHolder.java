package com.ztn.recyclerviewdemo.sidebar;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ztn.common.BaseViewFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by ztn on 2017/3/28
 *
 * @see SideBarRecyclerViewActivity
 */

class SideBarRecyclerViewActivityHolder extends BaseViewFinder {
    RecyclerView recyclerView;
    TextView textView;

    SideBarRecyclerViewActivityHolder(Activity activity) {
        super(activity);
        recyclerView = activity.findViewById(R.id.sidebar_activity_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        textView = activity.findViewById(R.id.sidebar_activity_tv);
    }
}
