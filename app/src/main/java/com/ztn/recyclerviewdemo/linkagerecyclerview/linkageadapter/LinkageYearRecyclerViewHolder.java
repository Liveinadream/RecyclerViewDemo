package com.ztn.recyclerviewdemo.linkagerecyclerview.linkageadapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.linkagerecyclerview.LinkageBean;

/**
 * Created by ztn on 2017/5/3
 */

public class LinkageYearRecyclerViewHolder extends RecyclerView.ViewHolder {
    private CheckBox checkBox;

    LinkageYearRecyclerViewHolder(View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.linkage_year_item_cb);
    }

    public void initView(final LinkageBean.Data data,
                         final LinkageYearRecyclerViewAdapter.OnClickChooseListener onClickChooseListener, final int checked,
                         final int position) {

        checkBox.setText(data.year);

        checkBox.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.itemclick_bg_year, 0, 0);
        boolean isChecked;
        isChecked = checked == position;
        checkBox.setChecked(isChecked);

        if (isChecked) {
            checkBox.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.blue));
        } else {
            checkBox.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.black));
        }

        itemView.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickChooseListener != null)
                    onClickChooseListener.onChoose(data, position);
            }
        }
        );
    }
}
