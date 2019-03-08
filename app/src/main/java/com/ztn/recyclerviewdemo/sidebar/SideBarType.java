package com.ztn.recyclerviewdemo.sidebar;

import com.ztn.recyclerviewdemo.R;

/**
 * Created by ztn on 2017/4/19
 */

public enum SideBarType {
    ONE("SideBar\n第一个", "SideBar第一个", R.drawable.sidebar_icon, 1, true),
    TWO("SideBar\n第二个", "SideBar第二个", R.drawable.sidebar_icon, 2, false),
    THREE("SideBar\n第三个", "SideBar第三个", R.drawable.sidebar_icon, 3, false),
    FOUR("SideBar\n第四个", "SideBar第四个", R.drawable.sidebar_icon, 4, false),
    FIVE("SideBar\n第五个", "SideBar第五个", R.drawable.sidebar_icon, 5, false),
    SIX("SideBar\n第六个", "SideBar第六个", R.drawable.sidebar_icon, 6, false),
    SEVEN("SideBar\n第七个", "SideBar第七个", R.drawable.sidebar_icon, 7, false),
    EIGHT("SideBar\n第八个", "SideBar第八个", R.drawable.sidebar_icon, 8, false),
    NIGHT("SideBar\n第九个", "SideBar第九个", R.drawable.sidebar_icon, 9, false),
    TEN("SideBar\n第十个", "SideBar第十个", R.drawable.sidebar_icon, 10, false),
    ELEVEN("SideBar\n第十一个", "SideBar第十一个", R.drawable.sidebar_icon, 11, false),
    TWELVE("SideBar\n第十二个", "SideBar第十二个", R.drawable.sidebar_icon, 12, false),
    THIRTEEN("SideBar\n第十三个", "SideBar第十三个", R.drawable.sidebar_icon, 13, false),
    FOURTEEN("SideBar\n第十四个", "SideBar第十四个", R.drawable.sidebar_icon, 14, false);

    public String text;//左边显示
    public String content;//右边显示
    public int resid;//类型图片
    public int type;//类型标志
    public boolean isChecked;//是否选中

    SideBarType(String text, String content,int resid, int type, boolean isChecked) {
        this.text = text;
        this.content=content;
        this.resid = resid;
        this.type = type;
        this.isChecked = isChecked;
    }
}