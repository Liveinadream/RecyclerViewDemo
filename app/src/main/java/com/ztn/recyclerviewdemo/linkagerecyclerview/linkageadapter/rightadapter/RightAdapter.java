package com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter.rightadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ztn.common.SimpleRecycleViewAdapter;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageBean;

import java.util.List;
import com.ztn.recyclerviewdemo.R;
/**
 * Created by ztn on 2017/5/3
 */
public class RightAdapter extends SimpleRecycleViewAdapter<LinkageBean.Data, RightAdapterHolder> {

    private OnClickItemListener onClickItemListener;

    public RightAdapter(Context context, List<LinkageBean.Data> listData) {
        super(context, listData);
    }

    /**
     * 创建View
     *
     * @param parent
     * @return
     */
    @Override
    protected RightAdapterHolder onCreateItemViewHolder(ViewGroup parent) {
        return new RightAdapterHolder(inflater.inflate(R.layout.activity_linkage_right_rl_item, parent, false));
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    /**
     * 给View设置数据
     *
     * @param rightAdapterHolder
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(RightAdapterHolder rightAdapterHolder, int position) {
        rightAdapterHolder.initView(context, listData.get(position), position);
    }

    public interface OnClickItemListener {
        void onClick(LinkageBean.Data data);
    }
}
