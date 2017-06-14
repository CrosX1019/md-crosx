package com.root.crosx;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.root.crosx.utils.LogUtil;

/**
 * Created by CrosX on 2017/6/14.
 */

public class App extends Application {

    //全局App实例
    private static volatile App instance = null;

    /**
     * 获取实例
     * 双重加锁
     */
    public static App getInstance() {
        if (instance == null) {
            synchronized (App.class) {
                if (instance == null) {
                    instance = new App();
                }
            }
        }
        return instance;
    }

    //全局Context
    private static Context mContext;

    /**
     * 获取全局Context方法
     */
    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LogUtil.init(true, Log.VERBOSE);
    }
}
