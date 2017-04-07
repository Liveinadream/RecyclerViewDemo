package com.ztn.recyclerviewdemo;

import android.app.Application;

/**
 * Created by ztn on 2017/3/28
 */
public class BossApplication extends Application implements Thread.UncaughtExceptionHandler {

    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println("uncaughtException");
        System.exit(0);
    }
}
