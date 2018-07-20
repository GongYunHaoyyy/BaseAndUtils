package com.gongyunhao.baseandutils.provider;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/18
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public interface INetWorkProvider extends IProvider{
    /**
     * 检测当前是否有网络
     * @return
     */
    boolean isNetworkConnected(Context context);
    /**
     * 检测Wifi时候可用
     * @param context
     * @return
     */
    boolean isWifiConnected(Context context);
    /**
     * 检测移动信号是否可用
     * @param context
     * @return
     */
    boolean isMobileConnected(Context context);
    /**
     * 判断当前网络类型 0是移动网络，1是wifi
     * @param context
     * @return
     */
    int getConnectedType(Context context);

}
