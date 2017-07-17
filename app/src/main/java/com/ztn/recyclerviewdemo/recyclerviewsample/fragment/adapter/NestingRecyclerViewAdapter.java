package com.ztn.recyclerviewdemo.recyclerviewsample.fragment.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by ztn on 2017/6/19
 */

public class NestingRecyclerViewAdapter extends SimpleRecycleViewAdapter<String, NestingRecyclerViewHolder> {
    private OnClickItemListener onClickItemListener;

    public NestingRecyclerViewAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected NestingRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new NestingRecyclerViewHolder(inflater.inflate(R.layout.nesting_recyclerview, parent, false));
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
    protected void onBindItemViewHolder(NestingRecyclerViewHolder nestingRecyclerViewHolder, int position) {
        nestingRecyclerViewHolder.initView(context, listData.get(position), onClickItemListener, position);
    }

    /**
     * 便于实现点击事件
     */

    public interface OnClickItemListener {
        void onClick(String string, int position);
    }
}
