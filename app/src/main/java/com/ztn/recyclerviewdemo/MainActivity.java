package com.ztn.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ztn.common.BaseActivity;
import com.ztn.common.SceneChangeUtils;
import com.ztn.recyclerviewdemo.adapter.MainRecyclerViewAdapter;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageRecyclerViewActivity;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.SideBarRecyclerViewActivity;
import com.ztn.recyclerviewdemo.timerecyclerview.TimeRecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztn on 2017/3/28
 */
public class MainActivity extends BaseActivity {
    MainActivityHolder mainActivityHolder;
    List<String> main;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityHolder = new MainActivityHolder(this);
        main = new ArrayList<>();
        main.add("简单的RecyclerView");
        main.add("点击开始的计时器RecyclerView");
        main.add("侧边栏RecyclerView");
        main.add("左右联动的Recyclerview");
        for (int i = 0; i < 40; i++) {
            main.add(i + "");
        }
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getContext(), main);
        mainActivityHolder.recyclerView.setAdapter(mainRecyclerViewAdapter);
        mainRecyclerViewAdapter.notifyDataSetChanged();
        mainRecyclerViewAdapter.setOnClickItemListener(new MainRecyclerViewAdapter.OnClickItemListener() {
            @Override
            public void onClick(String string, int position) {
                if (position == 0) {
                    Toast.makeText(getContext(), "本界面就是一个简单的Recyclerview", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    //跳转到一个计时器界面
                    SceneChangeUtils.viewClick(getContext(), TimeRecyclerViewActivity.newIntent(getContext()));
                } else if (position == 2) {
                    //跳转到侧边栏界面
                    SceneChangeUtils.viewClick(getContext(), SideBarRecyclerViewActivity.newIntent(getContext()));
                } else if (position == 3) {
                    //跳转到联动界面
                    SceneChangeUtils.viewClick(getContext(), LinkageRecyclerViewActivity.newIntent(getContext()));
                } else {
                    Toast.makeText(getContext(), "准备中的Recyclerview", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
