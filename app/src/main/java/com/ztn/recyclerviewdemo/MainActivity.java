package com.ztn.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ztn.common.BaseActivity;
import com.ztn.recyclerviewdemo.adapter.MainRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztn on 2017/3/28
 */
public class MainActivity extends BaseActivity {
    MainActivityHolder mainActivityHolder;
    List<String> main;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityHolder = new MainActivityHolder(this);
        main = new ArrayList<>();
        main.add("简单的RecyclerView");
        for (int i = 0; i < 40; i++) {
            main.add(i + "");
        }
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getContext(), main);
        mainActivityHolder.recyclerView.setAdapter(mainRecyclerViewAdapter);
        mainRecyclerViewAdapter.notifyDataSetChanged();
        mainRecyclerViewAdapter.setOnClickItemListener(new MainRecyclerViewAdapter.OnClickItemListener() {
            @Override
            public void onClick(String string, int position) {
                if (position == 0) {
                    Toast.makeText(getContext(), "本界面就是一个简单的Recyclerview", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "准备中的Recyclerview", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
