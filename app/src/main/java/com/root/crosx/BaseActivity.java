package com.root.crosx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
        initListener();
    }

    public abstract int setLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    /**
     * 通过xml查找相应的ID，通用方法
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }

    protected <T extends View> T $(View view, @IdRes int id) {
        return (T) view.findViewById(id);
    }

    protected void toActivity(Class clzss) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        startActivity(intent);
    }

    protected void toActivity(Class clzss, int flag) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        intent.setFlags(flag);
        startActivity(intent);
    }

    protected void toActivityWithFinish(Class clzss) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        startActivity(intent);
        finish();
    }

    protected void toActivity4result(Class clzss, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clzss);
        startActivityForResult(intent, requestCode);
    }
}
