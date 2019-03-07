package com.ztn.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ztn.recyclerviewdemo.R;


/**
 * Created by ztn on 2017/3/28
 */

public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    MainRecyclerViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.simple_tv);
    }

    public void initView(final String string, final MainRecyclerViewAdapter.OnClickItemListener onClickItemListener, final int position) {
        textView.setText(string);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener != null)
                    onClickItemListener.onClick(string, position);
            }
        });
    }
}
