package com.ztn.recyclerviewdemo.subsectionloadingrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.ztn.common.BaseActivity;
import com.ztn.common.CustomSGLayoutManager;
import com.ztn.recyclerviewdemo.MainActivityHolder;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.adapter.MainRecyclerViewAdapter;
import com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter.LinkageYearRecyclerViewAdapter;
import com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter.rightadapter.RightAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ztn on 2017/6/8
 * 分段加载Recyclerview
 */

public class SubsectionRecyclerViewActivity extends BaseActivity {
    List<String> time;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    SimpleDateFormat formatter;
    Timer timer;
    SubsectionRecyclerViewActivityHolder subsectionRecyclerViewActivityHolder;

    public static Intent newIntent(Context context) {
        return new Intent(context, SubsectionRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subsectionRecyclerViewActivityHolder = new SubsectionRecyclerViewActivityHolder(this);
        formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss", Locale.CHINA);
        time = new ArrayList<>();
        time.add(formatter.format(System.currentTimeMillis()));

        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getContext(), time);
        subsectionRecyclerViewActivityHolder.recyclerView.setAdapter(mainRecyclerViewAdapter);

        timer = new Timer();
        //0.5秒后执行任务,根据实际需求放在合适的位置，如加载的数据是网络数据，应该放在网络数据加载成功后执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        }, 500, 500);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    //加载20条数据，实际根据data的size定
                    if (time.size() < 20) {

                        time.add(formatter.format(System.currentTimeMillis()));
                        mainRecyclerViewAdapter.notifyItemChanged(time.size());
                    } else {
                        //停止
                        timer.purge();
                    }
                    break;
                case 2:
                    timer.purge();
                    break;

            }
            return false;
        }
    });
}
