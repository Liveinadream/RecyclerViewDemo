package com.ztn.recyclerviewdemo.sidebarrecyclerview.sidebaradapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.SideBarRecyclerViewActivity;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.SideBarType;

/**
 * Created by ztn on 2017/4/28
 */

public class SideBarRecyclerViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkBox;

    public SideBarRecyclerViewHolder(View itemView) {
        super(itemView);
        checkBox = (CheckBox) itemView.findViewById(R.id.sidebar_item_cb);
    }

    public void initView(Context context, final SideBarType sideBarType,
                         final SideBarRecyclerViewAdapter.OnClickItemListener onClickItemListener,
                         final int position) {

        checkBox.setCompoundDrawablesWithIntrinsicBounds(0, sideBarType.resid, 0, 0);
        checkBox.setChecked(sideBarType.isChecked);
        checkBox.setText(sideBarType.text);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener != null)
                    onClickItemListener.onClick(sideBarType);
            }
        });
    }
}
