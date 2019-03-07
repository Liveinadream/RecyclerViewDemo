package com.ztn.recyclerviewdemo.recyclerviewsample;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.ztn.common.BaseViewFinder;
import com.ztn.recyclerviewdemo.R;

/**
 * Created by ztn on 2017/6/9
 *
 * @see RecyclerViewSampleActivity
 */

class RecyclerViewSampleActivityHolder extends BaseViewFinder {


    TabLayout tabLayout;
    ViewPager viewPager;

    RecyclerViewSampleActivityHolder(Activity activity) {
        super(activity);
        tabLayout = activity.findViewById(R.id.viewpager_title);
        viewPager = activity.findViewById(R.id.sample_viewpager);
    }
}
