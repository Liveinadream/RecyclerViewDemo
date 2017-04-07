package com.ztn.recyclerviewdemo.timerecyclerview.timeadapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.timerecyclerview.TimeRecyclerViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ztn on 2017/3/28
 */

public class TimeRecyclerViewAdapter extends SimpleRecycleViewAdapter<CountDownTimer, TimeRecyclerViewHolder> {
    private OnClickItemListener onClickItemListener;
    private TimeRecyclerViewActivity timeRecyclerViewActivity;

    public TimeRecyclerViewAdapter(Context context, List<CountDownTimer> listData,
                                   TimeRecyclerViewActivity timeRecyclerViewActivity) {
        super(context, listData);
        this.timeRecyclerViewActivity = timeRecyclerViewActivity;
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected TimeRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new TimeRecyclerViewHolder(inflater.inflate(R.layout.a_simple_text_view, parent, false));
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    /**
     * 重写了onBindViewHolder,对viewholder设置了标签
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //设置标签
        holder.itemView.setTag(position);
        holder.setIsRecyclable(false);
        super.onBindViewHolder(holder, position);
    }

    /**
     * 给View设置数据
     *
     * @param timeRecyclerViewHolder
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(TimeRecyclerViewHolder timeRecyclerViewHolder, int position) {
        timeRecyclerViewHolder.initView(context, listData.get(position), onClickItemListener, position
        ,timeRecyclerViewActivity);
    }

    /**
     * 便于实现点击事件
     */

    public interface OnClickItemListener {
        void onClick(CountDownTimer countDownTimer, int position);
    }
}
