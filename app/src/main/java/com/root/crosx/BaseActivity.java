package com.root.crosx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    protected void toActivity(Class clzss) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        startActivity(intent);
    }

    protected void toActivityWithFinish(Class clzss) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        startActivity(intent);
        finish();
    }

    protected void toActivity(Class clzss, int flag) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        intent.setFlags(flag);
        startActivity(intent);
    }

    protected void toActivity4result(Class clzss, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        startActivityForResult(intent, requestCode);
    }
}
