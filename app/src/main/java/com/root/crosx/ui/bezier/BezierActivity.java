package com.root.crosx.ui.bezier;

import android.view.View;
import android.widget.Button;

import com.root.crosx.BaseActivity;
import com.root.crosx.R;
import com.root.crosx.utils.LogUtil;
import com.root.crosx.utils.ToastUtil;
import com.root.crosx.weight.bezier.TouchBezier;

public class BezierActivity extends BaseActivity {

    private Button mBtnReset;
    private TouchBezier mTouchBezierView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_bezier;
    }

    @Override
    public void initView() {
        mBtnReset = $(R.id.btn_reset);
        mTouchBezierView = $(R.id.touch_bezier_view);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTouchBezierView.reset();
                ToastUtil.show("重置");
            }
        });
    }


}
