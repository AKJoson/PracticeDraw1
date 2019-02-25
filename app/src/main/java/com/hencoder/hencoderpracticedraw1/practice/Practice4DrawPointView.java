package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {
    private Paint mSquarePaint;
    private Paint mRoundPaint;

    public Practice4DrawPointView(Context context) {
        this(context,null);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSquarePaint = new Paint();
        mSquarePaint.setStrokeCap(Paint.Cap.SQUARE);
        mRoundPaint = new Paint();
        mRoundPaint.setStrokeCap(Paint.Cap.ROUND);
        mSquarePaint.setColor(Color.BLACK);
        mSquarePaint.setAntiAlias(true);
        mRoundPaint.setColor(Color.BLACK);
        mRoundPaint.setAntiAlias(true);
        mRoundPaint.setStrokeWidth(40);
        mSquarePaint.setStrokeWidth(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        canvas.drawPoint(300,400,mRoundPaint);
        canvas.drawPoint(600,400,mSquarePaint);
    }
}
