package com.ztn.recyclerviewdemo.linkagerecyclerview;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ztn.common.BaseViewFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by ztn on 2017/5/3
 *
 * @see LinkageRecyclerViewActivity
 */

public class LinkageRecyclerViewActivityHolder extends BaseViewFinder {
    RecyclerView year, week;

    protected LinkageRecyclerViewActivityHolder(Activity activity) {
        super(activity);
        year = (RecyclerView) activity.findViewById(R.id.linkage_avtivity_year_rv);
//        year.setLayoutManager(new LinearLayoutManager(activity));
        year.setHasFixedSize(true);

        week = (RecyclerView) activity.findViewById(R.id.linkage_avtivity_week_rv);
        week.setLayoutManager(new LinearLayoutManager(activity));
        week.setHasFixedSize(true);

    }
}
