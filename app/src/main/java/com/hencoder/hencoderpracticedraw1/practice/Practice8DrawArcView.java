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
    private Paint mTopArcPaint, mLinePaint;

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
        mTopArcPaint.setColor(Color.BLACK);
        mLinePaint.setColor(Color.BLACK);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(2);
        mTopArcPaint.setAntiAlias(true);
        mLinePaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(300, 200, 600, 500);
        RectF rectF1 = new RectF(300, 300, 600, 500);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        canvas.drawArc(rectF, 190, 50, false, mLinePaint);
        canvas.drawArc(rectF, 260, 90, true, mTopArcPaint);
       canvas.drawArc(rectF1, 0, 180, true, mTopArcPaint);
    }
}
