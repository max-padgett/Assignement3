package com.maxpadgett.assignement3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


public class Oval extends View {
    private static final String COLOR_HEX = "#37FDFC";
    private final Paint drawPaint;
    private RectF r = new RectF(250 , 50 , 350, 400);
    private int sizeL = 300;
    private int sizeW = 300;

    public Oval(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        drawPaint = new Paint();
        drawPaint.setColor(Color.parseColor(COLOR_HEX));
        drawPaint.setAntiAlias(true);

    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(r, drawPaint);
    }
}
