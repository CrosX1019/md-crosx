package com.root.crosx;


import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.root.crosx.ui.bezier.BezierActivity;
import com.root.crosx.ui.rxjava.RxJavaActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private Button mBtnBaseBezier, mBtnTouchBezier;

    private PieChart pieChart;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mBtnBaseBezier = $(R.id.btn_base_bezier);
        mBtnTouchBezier = $(R.id.btn_touch_bezier);
        pieChart = $(R.id.consume_pie_chart);
    }

    @Override
    public void initData() {
        initChart();
    }

    @Override
    public void initListener() {

        mBtnBaseBezier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(RxJavaActivity.class);
            }
        });

        mBtnTouchBezier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, getString(R.string.app_name), Toast.LENGTH_SHORT).show();
                toActivity(BezierActivity.class);
            }
        });
    }

    private void initChart() {
        pieChart.setUsePercentValues(true);//设置value是否用显示百分数,默认为false
        Description description = new Description();
        description.setText("全年消费情况");
        pieChart.setDescription(description);//设置描述
        pieChart.setCenterTextSize(20);//设置描述字体大小
        //pieChart.setDescriptionColor(); //设置描述颜色
        //pieChart.setDescriptionTypeface();//设置描述字体

        pieChart.setExtraOffsets(5, 5, 5, 5);//设置饼状图距离上下左右的偏移量

        pieChart.setDragDecelerationFrictionCoef(0.95f);//设置阻尼系数,范围在[0,1]之间,越小饼状图转动越困难

        pieChart.setDrawCenterText(true);//是否绘制中间的文字
        pieChart.setCenterTextColor(Color.RED);//中间的文字颜色
        pieChart.setCenterTextSize(24);//中间的文字字体大小

        pieChart.setDrawHoleEnabled(true);//是否绘制饼状图中间的圆
        pieChart.setHoleColor(Color.WHITE);//饼状图中间的圆的绘制颜色
        pieChart.setHoleRadius(58f);//饼状图中间的圆的半径大小

        pieChart.setTransparentCircleColor(Color.BLACK);//设置圆环的颜色
        pieChart.setTransparentCircleAlpha(110);//设置圆环的透明度[0,255]
        pieChart.setTransparentCircleRadius(60f);//设置圆环的半径值

        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);//设置饼状图是否可以旋转(默认为true)
        pieChart.setRotationAngle(10);//设置饼状图旋转的角度

        pieChart.setHighlightPerTapEnabled(true);//设置旋转的时候点中的tab是否高亮(默认为true)

        Legend l = pieChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);//设置每个tab的显示位置
        l.setXEntrySpace(0f);
        l.setYEntrySpace(0f);//设置tab之间Y轴方向上的空白间距值
        l.setYOffset(0f);

        // entry label styling
        pieChart.setDrawEntryLabels(true);//设置是否绘制Label
        pieChart.setEntryLabelColor(Color.BLACK);//设置绘制Label的颜色
        //pieChart.setEntryLabelTypeface(mTfRegular);
        pieChart.setEntryLabelTextSize(10f);//设置绘制Label的字体大小

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });//设值点击时候的回调
        pieChart.animateY(3400, Easing.EasingOption.EaseInQuad);//设置Y轴上的绘制动画
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        PieEntry pieEntry1 = new PieEntry(1145f, "第1个");
        PieEntry pieEntry2 = new PieEntry(568.5f, "第2个");
        PieEntry pieEntry3 = new PieEntry(3232.6f, "第3个");
        PieEntry pieEntry4 = new PieEntry(1324.6f, "第3个");
        pieEntries.add(pieEntry1);
        pieEntries.add(pieEntry2);
        pieEntries.add(pieEntry3);
        pieEntries.add(pieEntry4);

        //        for (ConsumeTypeMoneyPo typeMoneyVo : consumeTypeMoneyVoList) {
        //            PieEntry pieEntry = new PieEntry((float) typeMoneyVo.getTotalMoney(), typeMoneyVo.getConsumeTypeName());
        //            pieEntries.add(pieEntry);
        //            totalMoney += typeMoneyVo.getTotalMoney();
        //        }
        //        String centerText = mQueryYear + "年消费\n¥" + totalMoney;
        pieChart.setCenterText("123");//设置中间的文字
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(Color.YELLOW, Color.RED, Color.GRAY, Color.GREEN, Color.BLACK);
        pieDataSet.setSliceSpace(3f);//设置选中的Tab离两边的距离
        pieDataSet.setSelectionShift(5f);//设置选中的tab的多出来的
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(12f);
        pieData.setValueTextColor(Color.BLUE);

        pieChart.setData(pieData);
        // undo all highlights
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }
}
