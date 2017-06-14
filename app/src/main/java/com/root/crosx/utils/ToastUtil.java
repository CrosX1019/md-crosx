package com.root.crosx.utils;

import android.widget.Toast;

import com.root.crosx.common.BaseConstant;


/**
 * Created by CrosX on 2017/6/14.
 */

public class ToastUtil {
    private static Toast toast = null;

    public static void show(String text) {

        if (toast == null) {
            toast = Toast.makeText(BaseConstant.context, text, Toast.LENGTH_SHORT);
        } else {
            //如果当前Toast没有消失， 直接显示内容，不需要重新设置
            toast.setText(text);
        }
        toast.show();
    }
}
