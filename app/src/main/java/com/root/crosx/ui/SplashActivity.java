package com.root.crosx.ui;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.root.crosx.BaseActivity;
import com.root.crosx.MainActivity;
import com.root.crosx.R;

public class SplashActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void initData() {
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Thread() {
            @Override
            public void run() {
                toActivityWithFinish(MainActivity.class);
            }
        }, 3000);
    }

    @Override
    public void initListener() {

    }

}
