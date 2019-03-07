package com.ztn.recyclerviewdemo.recyclerviewsample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.ztn.common.BaseActivity;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.recyclerviewsample.fragment.AddOrDeleteFragment;
import com.ztn.recyclerviewdemo.recyclerviewsample.fragment.NestingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztn on 2017/6/9
 * RecyclerView示例
 */

public class RecyclerViewSampleActivity extends BaseActivity {

    RecyclerViewSampleActivityHolder recyclerViewSampleActivityHolder;
    ContentPagerAdapter contentPagerAdapter;
    List<Fragment> fragmentList;
    public AppCompatCheckedTextView[] appCompatCheckedTextViews;
    public AppCompatCheckedTextView bt_0, bt_1;

    public static Intent newIntent(Context context) {
        return new Intent(context, RecyclerViewSampleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        recyclerViewSampleActivityHolder = new RecyclerViewSampleActivityHolder(this);

        fragmentList = new ArrayList<>();
        fragmentList.add(NestingFragment.newInstance());
        fragmentList.add(AddOrDeleteFragment.newInstance());
        contentPagerAdapter = new ContentPagerAdapter(getSupportFragmentManager(), fragmentList);

        recyclerViewSampleActivityHolder.viewPager.setAdapter(contentPagerAdapter);
        recyclerViewSampleActivityHolder.viewPager.setOffscreenPageLimit(contentPagerAdapter.getCount());
        recyclerViewSampleActivityHolder.tabLayout.setupWithViewPager(recyclerViewSampleActivityHolder.viewPager, true);

        appCompatCheckedTextViews = new AppCompatCheckedTextView[2];

        bt_0 = createButton(getContext(), "嵌套", 0);
        bt_1 = createButton(getContext(), "增加删除", 0);
        appCompatCheckedTextViews[0] = bt_0;
        appCompatCheckedTextViews[1] = bt_1;

        recyclerViewSampleActivityHolder.tabLayout.addTab(recyclerViewSampleActivityHolder.tabLayout.newTab().setCustomView(appCompatCheckedTextViews[0]));
        recyclerViewSampleActivityHolder.tabLayout.addTab(recyclerViewSampleActivityHolder.tabLayout.newTab().setCustomView(appCompatCheckedTextViews[1]));

        recyclerViewSampleActivityHolder.tabLayout.removeTabAt(1);
        recyclerViewSampleActivityHolder.tabLayout.removeTabAt(0);

        recyclerViewSampleActivityHolder.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(recyclerViewSampleActivityHolder.tabLayout) {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                onChangedSize(position);
            }
        });
        onChangedSize(0);
    }

    public class ContentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        ContentPagerAdapter(FragmentManager fm, List<Fragment>
                fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }


    public void onChangedSize(int position) {
        for (int i = 0; i < appCompatCheckedTextViews.length; i++) {
            if (i == position) {
                appCompatCheckedTextViews[i].setTextSize(17);
                appCompatCheckedTextViews[i].setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
            } else {
                appCompatCheckedTextViews[i].setTextSize(15);
                appCompatCheckedTextViews[i].setTextColor(ContextCompat.getColor(getContext(), R.color.black_6d));
            }
        }

    }

    public AppCompatCheckedTextView createButton(Context ctx, CharSequence text, int resId) {
        AppCompatCheckedTextView button = new AppCompatCheckedTextView(ctx);
        button.setCheckMarkDrawable(new ColorDrawable(Color.TRANSPARENT));
        button.setText(text);
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        button.setGravity(Gravity.CENTER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        button.setTextColor(ContextCompat.getColorStateList(ctx, R.color.green_and_gray));
        button.setCompoundDrawablesWithIntrinsicBounds(0, resId, 0, 0);
        return button;
    }
}
