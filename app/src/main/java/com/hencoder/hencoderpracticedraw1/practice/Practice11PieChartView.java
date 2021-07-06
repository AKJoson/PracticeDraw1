package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mChartPaint = new Paint();
        mChartPaint.setAntiAlias(true);
    }

    private Paint mChartPaint;
    private int mWidthValue, mHeightValue;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidthValue = MeasureSpec.getSize(widthMeasureSpec);
        mHeightValue = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //所有区域先画在一个RectF中，完事之后,移动RectF使得错位分割。
        RectF rectF = new RectF(0.25f * mWidthValue, 0.25f * mHeightValue, 0.75f * mWidthValue, 0.75f * mHeightValue);
        mChartPaint.setColor(Color.argb(255, (int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random())));
        canvas.drawArc(rectF, 0, 75, true, mChartPaint);
        RectF newRectF1 = new RectF(0.25f * mWidthValue-20, 0.25f * mHeightValue-20, 0.75f * mWidthValue-20, 0.75f * mHeightValue);
        mChartPaint.setColor(Color.argb(255, (int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random())));
        canvas.drawArc(newRectF1, 75, 225, true, mChartPaint);

        RectF newRectF2 = new RectF(0.25f * mWidthValue+20, 0.25f * mHeightValue, 0.75f * mWidthValue+20, 0.75f * mHeightValue);
        mChartPaint.setColor(Color.argb(255, (int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random())));
        canvas.drawArc(newRectF2, 300, 60, true, mChartPaint);
    }
}
