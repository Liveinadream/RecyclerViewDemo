package com.ztn.recyclerviewdemo.recyclerviewsample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.ztn.common.LazyFragment;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.adapter.MainRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19
 */

public class AddOrDeleteFragment extends LazyFragment {
    AddOrDeleteHolder addOrDeleteHolder;
    List<String> num;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;

    public static Fragment newInstance() {
        return new AddOrDeleteFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.addordelete);
        num = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            num.add(i + "");
        }
        addOrDeleteHolder = new AddOrDeleteHolder(getContentView());
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getContext(), num);
        addOrDeleteHolder.recyclerView.setAdapter(mainRecyclerViewAdapter);

        //增加
        addOrDeleteHolder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.add(3, "增加的view");
                mainRecyclerViewAdapter.notifyItemInserted(3);
            }
        });

        //删除
        addOrDeleteHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addOrDeleteHolder.recyclerView.getChildCount() > 3) {
                    num.remove(3);
                    mainRecyclerViewAdapter.notifyItemRemoved(3);
                } else {
                    Toast.makeText(getContext(), "3位置上没有view", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addOrDeleteHolder.notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainRecyclerViewAdapter.notifyItemRangeChanged(0, num.size() - 2);
            }
        });


        mainRecyclerViewAdapter.setOnClickItemListener(new MainRecyclerViewAdapter.OnClickItemListener() {
            @Override
            public void onClick(String string, int position) {
                Toast.makeText(getContext(), "这个位置的position：" + position, Toast.LENGTH_SHORT).show();
                Logger.d("当前num中的各个值：" + num.toString());
            }
        });
    }
}
