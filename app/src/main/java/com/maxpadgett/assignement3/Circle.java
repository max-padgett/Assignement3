package com.maxpadgett.assignement3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class Circle extends View {

    private static final String COLOR_HEX = "#E74300";
    private final Paint drawPaint;
    private float size = 50;

    public Circle(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        drawPaint = new Paint();
        drawPaint.setColor(Color.parseColor(COLOR_HEX));
        drawPaint.setAntiAlias(true);

    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(size, size, size, drawPaint);
    }


}