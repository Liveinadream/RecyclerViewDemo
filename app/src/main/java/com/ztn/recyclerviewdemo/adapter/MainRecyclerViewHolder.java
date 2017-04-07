package com.ztn.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ztn.recyclerviewdemo.R;


/**
 * Created by ztn on 2017/3/28
 */

public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public MainRecyclerViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.simple_tv);
    }

    public void initView(Context context, final String string, final MainRecyclerViewAdapter.OnClickItemListener onClickItemListener, final int position) {
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
