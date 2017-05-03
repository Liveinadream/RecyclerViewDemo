package com.ztn.recyclerviewdemo.sidebarrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.ztn.common.BaseActivity;
import com.ztn.recyclerviewdemo.R;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.sidebaradapter.SideBarRecyclerViewAdapter;
import com.ztn.recyclerviewdemo.sidebarrecyclerview.sidebaradapter.SideBarRecyclerViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by ztn on 2017/4/13
 */
public class SideBarRecyclerViewActivity extends BaseActivity {
    SideBarRecyclerViewActivityHolder sideBarRecyclerViewActivityHolder;
    List<SideBarType> sideBarTypeList;
    SideBarType sideBarType = SideBarType.ONE;
    SideBarRecyclerViewAdapter sideBarRecyclerViewAdapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, SideBarRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar);
        sideBarRecyclerViewActivityHolder = new SideBarRecyclerViewActivityHolder(this);
        sideBarTypeList = new ArrayList<>();

        //数组中加入需要的侧边栏，这里我用的枚举，随意构造了一个类型
        sideBarTypeList = Arrays.asList(SideBarType.ONE,
                SideBarType.TWO,
                SideBarType.THREE,
                SideBarType.FOUR,
                SideBarType.FIVE,
                SideBarType.SIX,
                SideBarType.SEVEN,
                SideBarType.EIGHT,
                SideBarType.NIGHT,
                SideBarType.TEN,
                SideBarType.ELEVEN,
                SideBarType.TWELVE,
                SideBarType.THIRTEEN,
                SideBarType.FOURTEEN);

        sideBarRecyclerViewAdapter = new SideBarRecyclerViewAdapter(getContext(), sideBarTypeList);
        sideBarRecyclerViewActivityHolder.recyclerView.setAdapter(sideBarRecyclerViewAdapter);
        //点击侧边栏后的效果
        sideBarRecyclerViewAdapter.setOnClickItemListener(new SideBarRecyclerViewAdapter.OnClickItemListener() {
            @Override
            public void onClick(SideBarType sideBarType1) {
                sideBarType = sideBarType1;
                reTypedata(sideBarType);
                Toast.makeText(getContext(), "点击了" + sideBarType.content, Toast.LENGTH_SHORT).show();
            }
        });
        reTypedata(sideBarType);
    }

    /**
     * 重置数据，保证看起来只有一个被选中
     */
    private void reTypedata(SideBarType sideBarType) {
        for (SideBarType sideBarType1 : sideBarTypeList) {
            sideBarType1.isChecked = sideBarType1 == sideBarType;
        }
        sideBarRecyclerViewActivityHolder.textView.setText(sideBarType.text);
        sideBarRecyclerViewAdapter.notifyDataSetChanged();
    }

}
