package com.root.crosx.ui;

import android.view.WindowManager;

import com.root.crosx.BaseActivity;
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

    }
}
