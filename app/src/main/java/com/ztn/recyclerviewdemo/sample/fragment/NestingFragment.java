package com.ztn.recyclerviewdemo.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ztn.common.LazyFragment;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.sample.fragment.adapter.Nest;
import com.ztn.recyclerviewdemo.sample.fragment.adapter.NestingRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19
 */

public class NestingFragment extends LazyFragment {
    NestingHolder nestingHolder;
    public List<String> show;
    NestingRecyclerViewAdapter nestingRecyclerViewAdapter;
    public ArrayList<Nest> checkedList;

    public static Fragment newInstance() {
        return new NestingFragment();
    }

    public boolean[] check = new boolean[4];

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.nesting);
        nestingHolder = new NestingHolder(getContentView());
        checkedList = new ArrayList<>();
        show = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            show.add(i + " ");
            checkedList.add(new Nest(check));
        }
        nestingRecyclerViewAdapter = new NestingRecyclerViewAdapter(getContext(), show, checkedList);
        nestingHolder.recyclerView.setAdapter(nestingRecyclerViewAdapter);
    }
}
