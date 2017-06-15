package com.root.crosx.weight.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by CrosX on 2017/6/14.
 */

public class BaseBezier extends View {

    public BaseBezier(Context context) {
        super(context);
    }

    public BaseBezier(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Paint mPaint = new Paint();


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xff66CCFF);

        Path mPath = new Path();
        mPath.moveTo(100, 300);
        mPath.quadTo(200, 200, 300, 300);
        mPath.quadTo(400, 400, 500, 300);

        canvas.drawPath(mPath, mPaint);
    }
}
