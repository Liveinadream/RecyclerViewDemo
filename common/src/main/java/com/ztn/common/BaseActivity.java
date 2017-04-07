package com.ztn.common;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * 上层基类
 * Created by ztn on 2017/3/28
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
//    private static final String ACTION_BASS_FINISH = "bass_finish";
//
//    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            switch (action) {
//                case ACTION_BASS_FINISH:
//                    getContext().finish();
//                    break;
//            }
//        }
//    };

    /**
     * 使用应用自身字体大小
     * @return 原大小字体
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(ACTION_BASS_FINISH);
//        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, filter);
//    }

    public BaseActivity getContext() {
        return this;
    }

//    /**
//     * 发送关闭界面广播
//     */
//    protected void sendBassFinshBroadcastReceiver() {
//        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ACTION_BASS_FINISH));
//    }


//    @Override
//    protected void onDestroy() {
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
//        super.onDestroy();
//    }
}
