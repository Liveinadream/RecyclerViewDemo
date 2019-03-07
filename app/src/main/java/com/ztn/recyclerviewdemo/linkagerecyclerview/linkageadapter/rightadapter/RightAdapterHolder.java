package com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter.rightadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ztn.recyclerviewdemo.R;

import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageBean;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageRecyclerViewActivity;

/**
 * Created by ztn on 2017/5/3
 */
class RightAdapterHolder extends RecyclerView.ViewHolder {

    private TextView year;
    private RecyclerView recyclerView;
    private LinkageRecyclerViewActivity linkageRecyclerViewActivity;


    RightAdapterHolder(View itemView) {
        super(itemView);
        year = itemView.findViewById(R.id.tv_year);
        recyclerView = itemView.findViewById(R.id.rl_week);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        });
        linkageRecyclerViewActivity = (LinkageRecyclerViewActivity) itemView.getContext();
        recyclerView.setHasFixedSize(true);
    }

    public void initView(final Context context, final LinkageBean.Data data,
                         final int position) {

        year.setText(data.year);
        LinkageWeekAdapter linkageWeekAdapter = new LinkageWeekAdapter(context, data.weeks, position);
        recyclerView.setAdapter(linkageWeekAdapter);
        linkageWeekAdapter.setOnClickItemListener(new LinkageWeekAdapter.OnClickItemListener() {
            @Override
            public void onClick(LinkageBean.Data.Weeks data) {
                linkageRecyclerViewActivity.setToast(position, data.weekTitle);
            }
        });
    }

}
