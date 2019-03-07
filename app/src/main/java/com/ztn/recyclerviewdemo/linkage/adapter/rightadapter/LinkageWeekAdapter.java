package com.ztn.recyclerviewdemo.linkage.adapter.rightadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.linkage.LinkageBean;

import java.util.List;

/**
 * Created by ztn on 2017/5/3
 */
public class LinkageWeekAdapter extends SimpleRecycleViewAdapter<LinkageBean.Data.Weeks, LinkageWeekAdapterHolder> {

    private OnClickItemListener onClickItemListener;
    private int parentPosition;

    LinkageWeekAdapter(Context context, List<LinkageBean.Data.Weeks> listData, int parentPosition) {
        super(context, listData);
        this.parentPosition = parentPosition;
    }

    /**
     * 创建View
     */
    @Override
    protected LinkageWeekAdapterHolder onCreateItemViewHolder(ViewGroup parent) {
        return new LinkageWeekAdapterHolder(inflater.inflate(R.layout.activity_linkage_right_rl_week_item, parent, false));
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    /**
     * 给View设置数据
     */
    @Override
    protected void onBindItemViewHolder(LinkageWeekAdapterHolder homePageReprotSearchHolder, int position) {
        homePageReprotSearchHolder.initView(context, listData.get(position), onClickItemListener, parentPosition);
    }

    public interface OnClickItemListener {
        void onClick(LinkageBean.Data.Weeks data);
    }
}
