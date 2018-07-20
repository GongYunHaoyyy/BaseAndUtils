package com.gongyunhao.baseandutils.application;

import android.app.Application;
import android.content.Context;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/13
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public class BaseApplication extends Application{
    private static Context mthis;

    @Override
    public void onCreate() {
        super.onCreate( );
        mthis = this;
//        在Application创建的时候调用，一般用于初始化一些东西，如全局的对象，环境的配置等。
    }

    public static Context getContext(){
        return mthis;
    }

}
