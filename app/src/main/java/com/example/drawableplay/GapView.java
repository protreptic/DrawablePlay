package com.example.drawableplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created on 11/02/16 20:17 by
 *
 * @author Peter Bukhal (petr@taxik.ru)
 */
public class GapView extends View {

    public GapView(Context context) {
        super(context);

        init();
    }

    public GapView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initAttrs(attrs, 0);
        init();
    }

    public GapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttrs(attrs, defStyleAttr);
        init();
    }

    private Path path;
    private Paint paint;

    private void initAttrs(AttributeSet attrs, int defStyleAttr) {

    }

    private void init() {
        paint = new Paint();
        paint.setColor(0xFFFFFF);
        paint.setAlpha(0);
        //eraserPaint.setXfermode(xfermode);
        paint.setAntiAlias(true);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int steps = getWidth() / 10;
        float stepSize = steps / 2;
        float x, y;

        x = 0.0f;
        y = 0.0f;

        path.reset();
        path.moveTo(x, y);

        for (int step = 0; step < steps; step++) {
            path.lineTo((x += stepSize), stepSize);
            path.lineTo((x += stepSize), y);
        }

        path.close();

        canvas.drawPath(path, paint);
    }

}
