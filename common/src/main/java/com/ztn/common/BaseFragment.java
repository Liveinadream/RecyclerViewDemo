package com.ztn.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Administrator on 2017/6/9
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 继承BaseFragment的碎片必须实现的方法，用于返回碎片使用的布局 return inflater.inflate(R.layout.xxx,container,false)
     * 最先被执行
     */
//    @Override
//    public abstract View onCreateView(LayoutInflater inflater,
//                                      ViewGroup container, Bundle savedInstanceState);

    /**
     * 最后被执行
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    /**
     * 其次被执行
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        registeredEvents();
    }

    /**
     * 继承BaseFragment的碎片必须实现的方法，用于找到控件的引用ID
     */
    protected abstract void findViews(View view);


    /**
     * 继承BaseFragment的碎片必须要实现的方法，在填充界面时，初始化数据使用
     */
    protected abstract void init();


    /**
     * 继承BaseFragment的碎片，如果要实现监听器均在此方法中实现
     */
    protected void registeredEvents() {
    }


}
