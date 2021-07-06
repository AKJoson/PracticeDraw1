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

    private int widthPixels, heightPixels;
    private Paint mLTPaint, mRTPaint, mLBPaint, mRBPaint, mLinePaint, mRBTestPaint;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLTPaint = new Paint();
        mRTPaint = new Paint();
        mLBPaint = new Paint();
        mRBPaint = new Paint();
        mLinePaint = new Paint();
        mRBTestPaint = new Paint();

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

        mRBTestPaint.setStyle(Paint.Style.STROKE);
        mRBTestPaint.setColor(Color.RED);

        mLinePaint.setStrokeWidth(10);
        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setStrokeCap(Paint.Cap.ROUND);
        mLinePaint.setColor(Color.GREEN);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthPixels = MeasureSpec.getSize(widthMeasureSpec);
        heightPixels = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * ok，baby,let's start
         */
        //先画两条线，分成四个区域
        float[] partingLines = {0.25f * widthPixels, 0.5f * heightPixels, 0.75f * widthPixels, 0.5f * heightPixels,
                0.5f * widthPixels, 0.25f * heightPixels, 0.5f * widthPixels, 0.75f * heightPixels};
        canvas.drawLines(partingLines, mLinePaint);
        canvas.drawCircle(widthPixels / 4, widthPixels / 4, 130, mLTPaint);
        canvas.drawCircle(3 * widthPixels / 4, widthPixels / 4, 130, mRTPaint);
        canvas.drawCircle(widthPixels / 4, 3 * widthPixels / 4, 130, mLBPaint);

        canvas.drawCircle(3 * widthPixels / 4, 3 * widthPixels / 4, 130, mRBPaint);
        //用mRBTestPaint画笔可以很清楚的看出来，描边是向外描一半，向内描一半
        canvas.drawCircle(3 * widthPixels / 4, 3 * widthPixels / 4, 130, mRBTestPaint);
    }
}
