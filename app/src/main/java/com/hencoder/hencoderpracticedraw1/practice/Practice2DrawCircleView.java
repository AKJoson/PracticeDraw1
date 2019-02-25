package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.MutableLong;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private int widthPixels,heightPixels;
    private Paint mLTPaint,mRTPaint,mLBPaint,mRBPaint;

    public Practice2DrawCircleView(Context context) {
        this(context,null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        mLTPaint = new Paint();
        mRTPaint = new Paint();
        mLBPaint =new Paint();
        mRBPaint = new Paint();

        mLTPaint.setColor(Color.BLACK);
        mLTPaint.setStyle(Paint.Style.FILL);
        mLTPaint.setAntiAlias(true);

        mRTPaint.setColor(Color.BLACK);
        mRTPaint.setStrokeWidth(1);
        mRTPaint.setStyle(Paint.Style.STROKE);
        mRTPaint.setAntiAlias(true);

        mLBPaint.setColor(Color.BLUE);

        mRBPaint.setStrokeWidth(30);
        mRBPaint.setStyle(Paint.Style.STROKE);
        mRBPaint.setColor(Color.BLACK);
        mRBPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        /**
         * ok，baby,let's start
         */
        //左上角的黑色circle
        canvas.drawCircle(widthPixels/4,widthPixels/4,150,mLTPaint);
        canvas.drawCircle(3*widthPixels/4,widthPixels/4,150, mRTPaint);
        canvas.drawCircle(widthPixels/4,11*widthPixels/20,150,mLBPaint);
        canvas.drawCircle(3*widthPixels/4,11*widthPixels/20,120,mRBPaint);

    }
}
