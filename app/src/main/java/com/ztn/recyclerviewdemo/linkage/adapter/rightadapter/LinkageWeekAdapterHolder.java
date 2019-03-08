package com.ztn.recyclerviewdemo.linkage.adapter.rightadapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.linkage.LinkageBean;

/**
 * Created by ztn on 2017/5/3
 */
class LinkageWeekAdapterHolder extends RecyclerView.ViewHolder {

    private TextView week;

    LinkageWeekAdapterHolder(View itemView) {
        super(itemView);
        week = (TextView) itemView.findViewById(R.id.tv_week);
    }

    public void initView(Context context, final LinkageBean.Data.Weeks data,
                         final LinkageWeekAdapter.OnClickItemListener onClickItemListener, final int parentPositon) {
        String left = data.weekTitle.substring(0, data.weekTitle.indexOf("周"));
        final SpannableStringBuilder builder = new SpannableStringBuilder(data.weekTitle);
        ForegroundColorSpan BlackSpan = new ForegroundColorSpan(
                ContextCompat.getColor(itemView.getContext(), R.color.black));
        builder.setSpan(BlackSpan, 0, left.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        week.setText(builder);
        week.setTextSize(12);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener != null) onClickItemListener.onClick(data);{
                }
            }
        });
    }

}
