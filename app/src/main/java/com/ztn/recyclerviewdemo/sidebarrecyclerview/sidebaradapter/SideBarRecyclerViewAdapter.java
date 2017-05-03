package com.ztn.recyclerviewdemo.sidebarrecyclerview.sidebaradapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.SideBarRecyclerViewActivity;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.SideBarType;

import java.util.List;

/**
 * Created by ztn on 2017/4/28
 */

public class SideBarRecyclerViewAdapter extends SimpleRecycleViewAdapter<SideBarType, SideBarRecyclerViewHolder> {
    private OnClickItemListener onClickItemListener;

    public SideBarRecyclerViewAdapter(Context context, List<SideBarType> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected SideBarRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new SideBarRecyclerViewHolder(inflater.inflate(R.layout.activity_sidebar_rl_item, parent, false));
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    /**
     * 给View设置数据
     *
     * @param sideBarRecyclerViewHolder
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(SideBarRecyclerViewHolder sideBarRecyclerViewHolder, int position) {
        sideBarRecyclerViewHolder.initView(context, listData.get(position), onClickItemListener, position);
    }

    /**
     * 便于实现点击事件
     */

    public interface OnClickItemListener {
        void onClick(SideBarType sideBarType);
    }
}