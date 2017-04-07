package com.ztn.common;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.view.View;

/**
 * Created by ztn on 2017/4/7
 * 统一的跳转动画
 */

public class SceneChangeUtils {
    private SceneChangeUtils() {
    }
    public static void viewClick(Activity activity, View v, Intent intent) {
        int startX = v.getWidth() / 2;
        int startY = v.getHeight() / 2;
//        Bundle bundle = ActivityOptionsCompat.makeScaleUpAnimation(v, startX, startY, 0, 0).toBundle();
        ActivityCompat.startActivity(activity, intent, null);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void viewClick(Activity activity, Intent intent) {
        ActivityCompat.startActivity(activity, intent, null);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void viewClick(Activity activity, Intent intent, int requestCode) {
        ActivityCompat.startActivityForResult(activity, intent, requestCode, null);
    }
}
