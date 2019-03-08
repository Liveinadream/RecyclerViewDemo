package com.ztn.recyclerviewdemo.subsection;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ztn.common.BaseViewFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by ztn on 2017/5/3
 *
 * @see SubsectionRecyclerViewActivity
 */

class SubsectionRecyclerViewActivityHolder extends BaseViewFinder {

    RecyclerView recyclerView;

    SubsectionRecyclerViewActivityHolder(Activity activity) {
        super(activity);
        recyclerView = activity.findViewById(R.id.main_activity_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }
}
