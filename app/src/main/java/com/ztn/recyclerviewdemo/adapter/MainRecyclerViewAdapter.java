package com.ztn.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by ztn on 2017/3/28
 */

public class MainRecyclerViewAdapter extends SimpleRecycleViewAdapter<String, MainRecyclerViewHolder> {
    private OnClickItemListener onClickItemListener;

    public MainRecyclerViewAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected MainRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new MainRecyclerViewHolder(inflater.inflate(R.layout.a_simple_text_view, parent, false));
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    /**
     * 给View设置数据
     *
     * @param mainRecyclerViewHolder
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(MainRecyclerViewHolder mainRecyclerViewHolder, int position) {
        mainRecyclerViewHolder.initView(listData.get(position), onClickItemListener,position);
    }

    /**
     * 便于实现点击事件
     */

    public interface OnClickItemListener {
        void onClick(String string, int position);
    }
}
