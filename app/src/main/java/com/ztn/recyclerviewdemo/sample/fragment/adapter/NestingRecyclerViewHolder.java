package com.ztn.recyclerviewdemo.sample.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ztn.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ztn on 2017/6/19
 */

public class NestingRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    RecyclerView recyclerView;
    NestingRecyclerViewChildAdapter nestingRecyclerViewChildAdapter;
    private List<String> num;

    public NestingRecyclerViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.nesting_rv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        num = new ArrayList<>();
        num.add(Math.random() + "");
        num.add(Math.random() + "");
        num.add(Math.random() + "");
        num.add(Math.random() + "");
    }

    public void initView(final Context context, final String string,
                         final NestingRecyclerViewAdapter.OnClickItemListener onClickItemListener,
                         final int position,Nest nest) {
        textView.setText(string);
        nestingRecyclerViewChildAdapter = new NestingRecyclerViewChildAdapter(context, num);
        recyclerView.setAdapter(nestingRecyclerViewChildAdapter);
        nestingRecyclerViewChildAdapter.setOnClickItemListener(new NestingRecyclerViewChildAdapter.OnClickItemListener() {
            @Override
            public void onClick(String string, int position) {
                Toast.makeText(context, string,Toast.LENGTH_SHORT).show();
            }
        });
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onClickItemListener != null)
//                    onClickItemListener.onClick(string, position);
//            }
//        });
    }
}
