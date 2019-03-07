package com.ztn.recyclerviewdemo.sample.fragment.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by ztn on 2017/6/19
 */

public class NestingRecyclerViewChildAdapter extends SimpleRecycleViewAdapter<String, NestingRecyclerViewChildHolder> {
    private OnClickItemListener onClickItemListener;

    public NestingRecyclerViewChildAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected NestingRecyclerViewChildHolder onCreateItemViewHolder(ViewGroup parent) {
        return new NestingRecyclerViewChildHolder(inflater.inflate(R.layout.a_simple_text_view, parent, false));
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    /**
     * 给View设置数据
     *
     * @param nestingRecyclerViewHolder
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(NestingRecyclerViewChildHolder nestingRecyclerViewHolder, int position) {
        nestingRecyclerViewHolder.initView(context, listData.get(position), onClickItemListener, position);
    }

    /**
     * 便于实现点击事件
     */

    public interface OnClickItemListener {
        void onClick(String string, int position);
    }
}
