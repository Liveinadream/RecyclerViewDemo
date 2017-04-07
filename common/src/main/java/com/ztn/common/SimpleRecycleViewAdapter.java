package com.ztn.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 *  Created by ztn on 2017/3/28
 */
public abstract class SimpleRecycleViewAdapter<T, ItemHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final LayoutInflater inflater;
    protected Context context;
    protected List<T> listData;


    public SimpleRecycleViewAdapter(Context context, List<T> listData) {
        this.context = context;
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateItemViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindItemViewHolder((ItemHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    /**
     * 创建 view
     * @param parent
     * @return
     */

    protected abstract ItemHolder onCreateItemViewHolder(ViewGroup parent);

    /**
     * 给view中的控件设置数据
     * @param itemHolder
     * @param position
     */
    protected abstract void onBindItemViewHolder(ItemHolder itemHolder, int position);
}
