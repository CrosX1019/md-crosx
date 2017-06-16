package com.root.crosx;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.root.crosx.ui.bezier.BezierActivity;

public class MainActivity extends BaseActivity {

    private Button mBtnBaseBezier, mBtnTouchBezier;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mBtnBaseBezier = $(R.id.btn_base_bezier);
        mBtnTouchBezier = $(R.id.btn_touch_bezier);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        mBtnTouchBezier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, getString(R.string.app_name), Toast.LENGTH_SHORT).show();
                toActivity(BezierActivity.class);
            }
        });
    }
}
