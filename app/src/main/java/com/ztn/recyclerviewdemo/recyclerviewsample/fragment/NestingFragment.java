package com.ztn.recyclerviewdemo.recyclerviewsample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.ztn.common.LazyFragment;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.recyclerviewsample.fragment.adapter.NestingRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19
 */

public class NestingFragment extends LazyFragment {
    NestingHolder nestingHolder;
    public List<String> show;
    NestingRecyclerViewAdapter nestingRecyclerViewAdapter;

    public static Fragment newInstance() {
        return new NestingFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.nesting);
        nestingHolder = new NestingHolder(getContentView());
        show = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            show.add(i + " ");
        }
        nestingRecyclerViewAdapter = new NestingRecyclerViewAdapter(getContext(), show);
        nestingHolder.recyclerView.setAdapter(nestingRecyclerViewAdapter);
    }
}
