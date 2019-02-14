package com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageBean;

import java.util.List;

/**
 * Created by ztn on 2017/5/3
 */

public class LinkageYearRecyclerViewAdapter
        extends SimpleRecycleViewAdapter<LinkageBean.Data, LinkageYearRecyclerViewHolder> {


    private OnClickChooseListener onClickChooseListener;
    private int checked = 0;

    public LinkageYearRecyclerViewAdapter(Context context, List<LinkageBean.Data> listData) {
        super(context, listData);
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected LinkageYearRecyclerViewHolder onCreateItemViewHolder(ViewGroup parent) {
        return new LinkageYearRecyclerViewHolder(inflater.inflate(R.layout.activity_linkage_leftl_year_item, parent, false));
    }

    public void setOnClickChooseListener(OnClickChooseListener onClickChooseListener) {
        this.onClickChooseListener = onClickChooseListener;
    }

    /**
     * 给View设置数据
     *
     * @param linkageYearRecyclerViewHolder
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(LinkageYearRecyclerViewHolder linkageYearRecyclerViewHolder, int position) {
        linkageYearRecyclerViewHolder.initView(context, listData.get(position), onClickChooseListener, checked, position);
    }

    /**
     * 选中事件
     */

    public interface OnClickChooseListener {
        void onChoose(LinkageBean.Data data, int checked);
    }
}