package com.gongyunhao.baseandutils.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gongyunhao.baseandutils.util.NetWorkUtil;

/**
 * Created by acer on 2018/2/1.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Activity mthis;
    protected int mScreenWidth;
    protected int mScreenHeight;
    public static final String Tag = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mthis=this;
        Log.d(Tag,"---->onCreate");
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;

        setContentView();
        //initViews();
        initListeners();
        initData();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(Tag,"---->onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(Tag,"---->onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Context context = mthis.getApplicationContext();
        if(NetWorkUtil.isNetworkConnected(context)){
            Log.d(Tag,"网络状态： "+NetWorkUtil.getConnectedType(context));
        }

        Log.d(Tag,"---->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag,"---->onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag,"---->onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag,"---->onStop");
    }

    public Toast toast;
    public void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(mthis, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    public void showToast(BaseActivity activity, String text) {
        if (toast == null) {
            toast = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    /**
     * 显示带图片的Toast
     * @param text  需要显示的文字
     * @param imgId 需要显示的图片
     */
    public void showImageToast(String text, int imgId) {
        Toast toast = Toast.makeText(mthis, text, Toast.LENGTH_SHORT);
        toast.setText(text);
        LinearLayout toastView = (LinearLayout) toast.getView();
        toastView.setGravity( Gravity.CENTER);
        ImageView toastImg = new ImageView(mthis);
        toastImg.setLayoutParams(new LinearLayout.LayoutParams(dp2px(25), dp2px(25)));
        toastImg.setScaleType( ImageView.ScaleType.FIT_XY);
        toastImg.setImageResource(imgId);
        toastView.addView(toastImg, 0);
        toast.show();
    }

    public void showToast(int textId) {
        showToast(getString(textId));
    }

    public BaseActivity getActivity() {
        return this;
    }

    public Intent getIntent(Class clazz) {
        return new Intent(mthis, clazz);
    }

    public void startIntent(Class clazz) {
        startActivity(getIntent(clazz));
    }

    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, dp,
                mthis.getResources().getDisplayMetrics());
    }

    public abstract void setContentView();

    public abstract void initViews();

    public abstract void initListeners();

    public abstract void initData();


}
