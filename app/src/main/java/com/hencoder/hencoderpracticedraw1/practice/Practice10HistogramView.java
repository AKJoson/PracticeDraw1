package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {


    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private Paint mLinePant, mBarChart, mBarChartText;

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLinePant = new Paint();
        mBarChart = new Paint();
        mBarChartText = new Paint();

        mLinePant.setColor(Color.BLACK);
        mLinePant.setStrokeWidth(4);
        mLinePant.setAntiAlias(true);

        mBarChart.setStyle(Paint.Style.FILL);
        mBarChart.setAntiAlias(true);

        mBarChartText.setColor(Color.WHITE);
        mBarChartText.setAntiAlias(true);
        mBarChartText.setTextSize(24);
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
        //画柱状区域
        //1. 计算,总长度
        int drawCharSize = 5;
        int totalLength = (int) (mWidthValue * 0.5);
        int totalHeight = (int) (mHeightValue * 0.5);
        int spacing = 10; //间距10个像素
        int eachLength = (totalLength - (drawCharSize + 1) * spacing) / drawCharSize;
        //X开始点
        int startX = (int) (0.25 * mWidthValue);
        String[] text = {"小泽", "波多", "麻生希", "苍老师", "杏梨"};
        for (int i = 0; i < drawCharSize; i++) {
            float curStartX = spacing * (i + 1) + eachLength * i + startX;
            RectF rectF = new RectF(curStartX, (float) (0.25f * mHeightValue + 1.0f * totalHeight * Math.random()), spacing * (i + 1) + eachLength * i + startX + eachLength, 0.75f * mHeightValue);
            mBarChart.setColor(Color.argb(255, (int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random())));
            canvas.drawRect(rectF, mBarChart);
            mBarChartText.setColor(Color.argb(255, (int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random())));
            float textWidth = mBarChartText.measureText(text[i], 0, text[i].length());
            //画文字
            canvas.drawText(text[i], curStartX + (eachLength - textWidth) / 2, 0.75f * mHeightValue + spacing * 3, mBarChartText);
        }

        //画线
        float[] lines = {0.25f * mWidthValue, 0.25f * mHeightValue, 0.25f * mWidthValue, 0.75f * mHeightValue,
                0.25f * mWidthValue, 0.75f * mHeightValue, 0.75f * mWidthValue, 0.75f * mHeightValue};
        canvas.drawLines(lines, mLinePant);
    }
}
