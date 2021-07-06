package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private Paint mTopArcPaint, mLinePaint, mRectBgPaint;

    public Practice8DrawArcView(Context context) {
        this(context, null);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTopArcPaint = new Paint();
        mLinePaint = new Paint();
        mTopArcPaint.setColor(Color.BLUE);
        mLinePaint.setColor(Color.BLACK);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(2);
        mTopArcPaint.setAntiAlias(true);
        mLinePaint.setAntiAlias(true);

        mRectBgPaint = new Paint();
        mRectBgPaint.setColor(Color.RED);
        mRectBgPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(300, 200, 600, 500);
        RectF rectF1 = new RectF(300, 300, 600, 500);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        canvas.drawArc(rectF, 190, 50, false, mLinePaint);
        canvas.drawArc(rectF, 260, 90, true, mTopArcPaint);

        canvas.drawRect(rectF1, mRectBgPaint);
        //Notice: drawArc() 第二个参数，表示开始角度，x轴水平正向为0,顺时针为正，逆时针为负。
        //                   第三个参数，表示从开始划过的总共角度,最大值为360
        canvas.drawArc(rectF1, -45, 90, true, mTopArcPaint);
    }
}
