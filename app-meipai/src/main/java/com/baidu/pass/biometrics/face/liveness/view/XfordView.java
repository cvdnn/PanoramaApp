package com.baidu.pass.biometrics.face.liveness.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.pass.biometrics.face.R;

public class XfordView extends ImageView {
    public Rect destRect;
    public Paint paint = null;
    public Bitmap srcBitmap = null;
    public Rect srcRect;
    public Xfermode xfermode;

    public XfordView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (this.paint == null) {
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setColor(1711276032);
        }
        if (this.srcBitmap == null) {
            this.srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pass_liveness_recog_face_mask);
        }
        if (this.xfermode == null) {
            this.xfermode = new PorterDuffXfermode(Mode.SRC_OUT);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.srcBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.srcBitmap.recycle();
            this.srcBitmap = null;
        }
        System.gc();
        this.xfermode = null;
        this.srcRect = null;
        this.destRect = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_width);
        int width = (getWidth() - dimensionPixelSize2) / 2;
        int height = (getHeight() - dimensionPixelSize) / 2;
        if (this.destRect == null) {
            this.destRect = new Rect(width, height, dimensionPixelSize2 + width, dimensionPixelSize + height);
        }
        if (this.srcRect == null) {
            this.srcRect = new Rect(0, 0, this.srcBitmap.getWidth(), this.srcBitmap.getHeight());
        }
        canvas.drawBitmap(this.srcBitmap, this.srcRect, this.destRect, this.paint);
        this.paint.setXfermode(this.xfermode);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.paint);
        this.paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setBgPaintColor(int i2) {
        if (this.paint == null) {
            this.paint = new Paint();
        }
        this.paint.setColor(i2);
    }

    public XfordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
