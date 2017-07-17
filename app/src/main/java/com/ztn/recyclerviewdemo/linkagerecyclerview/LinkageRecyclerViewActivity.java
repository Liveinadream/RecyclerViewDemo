package com.ztn.recyclerviewdemo.linkagerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.ztn.common.BaseActivity;
import com.ztn.common.CustomSGLayoutManager;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter.LinkageYearRecyclerViewAdapter;
import com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter.rightadapter.RightAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztn on 2017/5/3
 */
public class LinkageRecyclerViewActivity extends BaseActivity {
    LinkageRecyclerViewActivityHolder linkageRecyclerViewActivityHolder;

    List<LinkageBean.Data> datas;
    List<LinkageBean.Data.Weeks> weekses;
    LinkageBean.Data data;
    LinkageBean.Data.Weeks weeks;

    //左侧年的adapter
    LinkageYearRecyclerViewAdapter linkageYearRecyclerViewAdapter;
    //右侧的adapter
    RightAdapter rightAdapter;

    //结束的年份
    int year = 2017;
    //开始被选中的年份是第几个
    private int hadselected = 0;

    //年份是否被点击
    private boolean isTouch;

    CustomSGLayoutManager yearLinearLayoutManager;

    public static Intent newIntent(Context context) {
        return new Intent(context, LinkageRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkage);
        linkageRecyclerViewActivityHolder = new LinkageRecyclerViewActivityHolder(this);
        datas = new ArrayList<>();
        //时间上倒序排序 i<的东西为左侧显示的年份数量,创建数据
        for (int i = 0; i < 30; i++) {
            data = new LinkageBean.Data();
            data.year = year - i + "年";
            weekses = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                weeks = new LinkageBean.Data.Weeks();
                //采用倒序排序
                weeks.weekTitle = "第" + (50 - j) + "周(XX月XX日-YY月YY日)";
//                weeks.weekId = j + ""; //虚拟的对weekId赋值
                weekses.add(weeks);
            }
            data.weeks = weekses;
            datas.add(data);
        }
        yearLinearLayoutManager = new CustomSGLayoutManager(getContext());//实例化自定义类
        yearLinearLayoutManager.setSpeedSlow(0.3f);//设置其速度因子
        linkageRecyclerViewActivityHolder.year.setLayoutManager(yearLinearLayoutManager);

        linkageYearRecyclerViewAdapter = new LinkageYearRecyclerViewAdapter(getContext(), datas);
        linkageRecyclerViewActivityHolder.year.setAdapter(linkageYearRecyclerViewAdapter);
        //获取yearRecyclerview的manager

        rightAdapter = new RightAdapter(getContext(), datas);
        linkageRecyclerViewActivityHolder.week.setAdapter(rightAdapter);
        //获取weekRecyclerview的manager
        final LinearLayoutManager weekLinearLayoutManager =
                (LinearLayoutManager) linkageRecyclerViewActivityHolder.week.getLayoutManager();

        //年份点击时所发生的事件
        linkageYearRecyclerViewAdapter.setOnClickChooseListener(new LinkageYearRecyclerViewAdapter.
                OnClickChooseListener() {
            @Override
            public void onChoose(LinkageBean.Data data, int checked) {
                forceStopRecyclerViewScroll(linkageRecyclerViewActivityHolder.week);
                isTouch = false;
                weekLinearLayoutManager.scrollToPositionWithOffset(checked, 0);
                hadselected = checked;
                reTypedata(checked);
            }
        });


        linkageRecyclerViewActivityHolder.week.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event != null) {
                    isTouch = true;
                }
                return false;
            }
        });

        linkageRecyclerViewActivityHolder.week.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isTouch) {
                    if (dy > 0) {
                        //上拉
                        if (hadselected < weekLinearLayoutManager.findFirstVisibleItemPosition()) {
                            hadselected++;
                            reTypedata(hadselected);
                        }
                    } else if (dy < 0) {
                        //下滑
                        if (hadselected > weekLinearLayoutManager.findFirstVisibleItemPosition()) {
                            hadselected--;
                            reTypedata(hadselected);
                        }
                    }
                }
            }
        });
        reTypedata(hadselected);
    }

    //停止滑动
    public static void forceStopRecyclerViewScroll(RecyclerView mRecyclerView) {
        mRecyclerView.dispatchTouchEvent(MotionEvent.obtain(1,
                1, MotionEvent.ACTION_DOWN, mRecyclerView.getWidth(), mRecyclerView.getHeight(), 0));
    }

    private void reTypedata(int i) {
        linkageYearRecyclerViewAdapter.setChecked(i);
        linkageYearRecyclerViewAdapter.notifyDataSetChanged();
        hadselected = i;
//        linkageRecyclerViewActivityHolder.year.smoothScrollToPosition(i);     //添加滑动事件会稍有卡顿
        yearLinearLayoutManager.scrollToPositionWithOffset(i, 0);
    }

    public void setToast(int yearPosition, String week) {
        Toast.makeText(getContext(), "选中了第" + datas.get(yearPosition).year + week, Toast.LENGTH_SHORT).show();
//        finish(); //实际需求中可能需要关闭改界面
        reTypedata(yearPosition);
    }
}
