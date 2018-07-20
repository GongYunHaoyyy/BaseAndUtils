package com.gongyunhao.baseandutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gongyunhao.baseandutils.application.BaseApplication;
import com.gongyunhao.baseandutils.provider.INetWorkProvider;
import com.gongyunhao.baseandutils.util.NetWorkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        INetWorkProvider iNetWorkProvider = (INetWorkProvider) ARouter.getInstance().build("/network/service").navigation();
        iNetWorkProvider.isWifiConnected( BaseApplication.getContext() );
    }

}
