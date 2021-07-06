package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {
    private Paint mRectPaint;


    public Practice3DrawRectView(Context context) {
        this(context, null);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRectPaint = new Paint();
        mRectPaint.setColor(Color.BLUE);

    }

    private int mWidthValue, mHeightValue;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidthValue = MeasureSpec.getSize(widthMeasureSpec);
        mHeightValue = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawRect() 方法画矩形
//        Rect rect = new Rect(300, 300, 600, 600);
        RectF rectF = new RectF(0.25f * mWidthValue, 0.25f * mWidthValue, 0.75f * mWidthValue, 0.75f * mHeightValue);
        canvas.drawRect(rectF, mRectPaint);
    }
}
