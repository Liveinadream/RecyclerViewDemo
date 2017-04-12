package com.ztn.recyclerviewdemo.timerecyclerview.timeadapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.timerecyclerview.TimeRecyclerViewActivity;

import java.util.HashMap;
import java.util.List;


/**
 * Created by ztn on 2017/3/28
 */

public class TimeRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    CountDownTimer countDownTimer;
    TimeRecyclerViewHolder timeRecyclerViewHolder;

    public TimeRecyclerViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.simple_tv);
        timeRecyclerViewHolder = this;
    }

    public void initView(Context context, final CountDownTimer countDownTimer,
                         final TimeRecyclerViewAdapter.OnClickItemListener onClickItemListener,
                         final int position, TimeRecyclerViewActivity timeRecyclerViewActivity) {
        this.countDownTimer = countDownTimer;
        if (timeRecyclerViewActivity.IsTimeStart.get(position)) {
            if (timeRecyclerViewActivity.IsTimeGone.get(position)) {
                textView.setText("倒计时结束了");
            }
        } else {
            textView.setText("我是第" + position + "个计时器");
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener != null)
                    onClickItemListener.onClick(countDownTimer, position);
            }
        });
    }

    public void setTextViewText(String text) {
        textView.setText(text);
    }
}
