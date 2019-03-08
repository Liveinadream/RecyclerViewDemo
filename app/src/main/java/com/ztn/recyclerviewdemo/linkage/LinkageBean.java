package com.ztn.recyclerviewdemo.linkage;

import java.util.List;

/**
 *  Created by ztn on 2017/5/3
 */


public class LinkageBean {
    public List<Data> data;

    public static class Data {
        public String year;
        public List<Weeks> weeks;

        public static class Weeks {
//            public String weekId;       //网络请求时的幕后工作者
            public String weekTitle;    //作为界面中的展示内容
        }
    }
}