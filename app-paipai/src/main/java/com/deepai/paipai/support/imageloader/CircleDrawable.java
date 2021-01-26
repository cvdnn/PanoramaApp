package com.deepai.paipai.support.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class CircleDrawable extends Drawable {
    public static final String TAG = "CircleDrawable";
    protected final BitmapShader bitmapShader;
    protected final int margin;
    protected Bitmap oBitmap;
    protected final Paint paint;
    protected float radius;

    public CircleDrawable(Bitmap bitmap) {
        this(bitmap, 0);
    }

    public CircleDrawable(Bitmap bitmap, int margin2) {
        this.margin = margin2;
        this.oBitmap = bitmap;
        this.bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setShader(this.bitmapShader);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        computeBitmapShaderSize();
        computeRadius();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawCircle(((float) bounds.width()) / 2.0f, ((float) bounds.height()) / 2.0f, this.radius, this.paint);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.paint.setColorFilter(cf);
    }

    public void computeBitmapShaderSize() {
        float scale;
        Rect bounds = getBounds();
        if (bounds != null) {
            Matrix matrix = new Matrix();
            float scaleX = ((float) bounds.width()) / ((float) this.oBitmap.getWidth());
            float scaleY = ((float) bounds.height()) / ((float) this.oBitmap.getHeight());
            if (scaleX > scaleY) {
                scale = scaleX;
            } else {
                scale = scaleY;
            }
            matrix.postScale(scale, scale);
            this.bitmapShader.setLocalMatrix(matrix);
        }
    }

    public void computeRadius() {
        float height;
        Rect bounds = getBounds();
        if (bounds.width() < bounds.height()) {
            height = (((float) bounds.width()) / 2.0f) - ((float) this.margin);
        } else {
            height = (((float) bounds.height()) / 2.0f) - ((float) this.margin);
        }
        this.radius = height;
    }
}
