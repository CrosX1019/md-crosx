package com.root.crosx;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.root.crosx.common.BaseConstant;

/**
 * Created by CrosX on 2017/6/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = BaseConstant.context;
        setContentView(setLayoutId());
        initView();
        initData();
    }

    public abstract int setLayoutId();

    public abstract void initView();

    public abstract void initData();
}
