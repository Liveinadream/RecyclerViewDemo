package com.ztn.recyclerviewdemo.timerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.ztn.common.BaseActivity;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.timerecyclerview.timeadapter.TimeRecyclerViewAdapter;
import com.ztn.recyclerviewdemo.timerecyclerview.timeadapter.TimeRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztn on 2017/4/5
 */
public class TimeRecyclerViewActivity extends BaseActivity {
    TimeRecyclerViewActivityHolder timeRecyclerViewActivityHolder;
    TimeRecyclerViewAdapter timeRecyclerViewAdapter;
    List<CountDownTimer> countDownTimers;

    public List<Boolean> IsTimeStart;//用来确定是否已经开始计算时间,即是否进行了点击
    public List<Boolean> IsTimeGone;//用来确定是否已经结束计算时间,即点击后时间是否已经结束
    TimeRecyclerViewActivity timeRecyclerViewActivity;

    public static Intent newIntent(Context context) {
        return new Intent(context, TimeRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        timeRecyclerViewActivityHolder = new TimeRecyclerViewActivityHolder(this);
        timeRecyclerViewActivity = this;
        countDownTimers = new ArrayList<>();
        IsTimeStart = new ArrayList<>();
        IsTimeGone = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            IsTimeStart.add(false);
            IsTimeGone.add(false);
            countDownTimers.add(getCountDownTimer(i));
        }
        timeRecyclerViewAdapter = new TimeRecyclerViewAdapter(getContext(), countDownTimers, timeRecyclerViewActivity);
        timeRecyclerViewActivityHolder.recyclerView.setAdapter(timeRecyclerViewAdapter);
        timeRecyclerViewAdapter.notifyDataSetChanged();
        timeRecyclerViewAdapter.setOnClickItemListener(new TimeRecyclerViewAdapter.OnClickItemListener() {
            @Override
            public void onClick(CountDownTimer countDownTimer, int position) {
                IsTimeStart.set(position, true);
                countDownTimer.start();
                Toast.makeText(getContext(), "第" + position + "个countDownTimer开始了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 通过viewholder的标签获得对应的viewholder
     * @param position 位置
     * @return
     */
    private TimeRecyclerViewHolder getState(int position) {
        return (TimeRecyclerViewHolder) timeRecyclerViewActivityHolder.recyclerView.
                getChildViewHolder(timeRecyclerViewActivityHolder.recyclerView.findViewWithTag(position));
    }


    private CountDownTimer getCountDownTimer(final int position) {
//        return null;
        return new CountDownTimer(36000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                try {
                    IsTimeGone.set(position, false);
                    TimeRecyclerViewHolder timeRecyclerViewHolder = getState(position);
                    timeRecyclerViewHolder.setTextViewText(String.valueOf(millisUntilFinished));
                } catch (NullPointerException ignore) {
                }
            }

            @Override
            public void onFinish() {
                try {
                    IsTimeGone.set(position, true);
                    TimeRecyclerViewHolder timeRecyclerViewHolder = getState(position);
                    timeRecyclerViewHolder.setTextViewText("倒计时结束了");
                } catch (NullPointerException ignore) {
                }
            }
        };
    }
}
