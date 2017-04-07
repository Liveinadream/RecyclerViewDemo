package com.ztn.common;

import android.app.Activity;

/**
 * * Created by ztn on 2017/3/28
 * <p>
 * 所有activity的界面holder都继承这个Base,以便于界面功能分离 ,记得在app的gradle中，对common进行依赖
 */

public abstract class BaseViewFinder {
    protected Activity activity;

    protected BaseViewFinder(Activity activity) {
        this.activity = activity;
    }
}
