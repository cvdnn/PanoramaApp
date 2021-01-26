package com.deepai.library.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class ScaleImageView extends ImageView implements OnTouchListener {
    private static final int DRAG = 1;
    private static final float MAX_SCALE = 10.0f;
    private static final int MAX_SIZE = 2048;
    private static final int NONE = 0;
    private static final String TAG = "ScaleImageView";
    private static final int ZOOM = 2;
    private Bitmap bitmap;
    private float dist;
    private DisplayMetrics dm;
    private Context mContext;
    private int mImgHeight;
    private int mImgWidth;
    private int mInSampleSize;
    private PointF mVertex;
    private Matrix matrix;
    private PointF mid;
    private float minScaleR;
    private int mode;
    private Options options;
    private PointF prev;
    private Matrix savedMatrix;

    public ScaleImageView(Context context) {
        super(context);
        this.matrix = new Matrix();
        this.savedMatrix = new Matrix();
        this.minScaleR = 0.2f;
        this.mode = 0;
        this.prev = new PointF();
        this.mid = new PointF();
        this.dist = 1.0f;
        this.mContext = context;
        init();
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.matrix = new Matrix();
        this.savedMatrix = new Matrix();
        this.minScaleR = 0.2f;
        this.mode = 0;
        this.prev = new PointF();
        this.mid = new PointF();
        this.dist = 1.0f;
        this.mContext = context;
        init();
    }

    private void init() {
        setOnTouchListener(this);
        this.dm = new DisplayMetrics();
        ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
        setImageMatrix(this.matrix);
        this.options = new Options();
        this.options.inPreferredConfig = Config.RGB_565;
    }

    public void setImgFile(String filePath) {
        this.options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, this.options);
        this.mImgWidth = this.options.outWidth;
        this.mImgHeight = this.options.outHeight;
        if (this.mImgWidth > 2048 && this.mImgHeight > 2048) {
            if (this.mImgWidth >= this.mImgHeight) {
                this.mInSampleSize = this.mImgWidth / 2048;
            } else {
                this.mInSampleSize = this.mImgHeight / 2048;
            }
        }
        if (this.mInSampleSize == 0) {
            this.mInSampleSize = 1;
        }
        this.options.inJustDecodeBounds = false;
        this.options.inSampleSize = this.mInSampleSize;
        this.bitmap = BitmapFactory.decodeFile(filePath, this.options);
        setImageBitmap(this.bitmap);
    }

    public void recycle() {
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & 255) {
            case 0:
                this.savedMatrix.set(this.matrix);
                this.prev.set(event.getX(), event.getY());
                this.mode = 1;
                break;
            case 1:
            case 6:
                this.mode = 0;
                break;
            case 2:
                if (this.mode != 1) {
                    if (this.mode == 2) {
                        float newDist = spacing(event);
                        if (newDist > 10.0f) {
                            this.matrix.set(this.savedMatrix);
                            float tScale = newDist / this.dist;
                            this.matrix.postScale(tScale, tScale, this.mid.x, this.mid.y);
                            break;
                        }
                    }
                } else {
                    this.matrix.set(this.savedMatrix);
                    this.matrix.postTranslate(event.getX() - this.prev.x, event.getY() - this.prev.y);
                    break;
                }
                break;
            case 5:
                this.dist = spacing(event);
                if (spacing(event) > 10.0f) {
                    this.savedMatrix.set(this.matrix);
                    midPoint(this.mid, event);
                    this.mode = 2;
                    break;
                }
                break;
        }
        setImageMatrix(this.matrix);
        checkView();
        return true;
    }

    private void checkView() {
        float[] p = new float[9];
        this.matrix.getValues(p);
        if (this.mode == 2) {
            if (p[0] < this.minScaleR) {
                this.matrix.setScale(this.minScaleR, this.minScaleR, this.mid.x, this.mid.y);
            }
            if (p[0] > 10.0f) {
                this.matrix.set(this.savedMatrix);
            }
        }
    }

    private void minZoom() {
        this.minScaleR = Math.min(((float) this.dm.widthPixels) / ((float) this.bitmap.getWidth()), ((float) this.dm.heightPixels) / ((float) this.bitmap.getHeight()));
        if (((double) this.minScaleR) < 1.0d) {
            this.matrix.postScale(this.minScaleR, this.minScaleR);
        }
    }

    /* access modifiers changed from: protected */
    public void center(boolean horizontal, boolean vertical) {
        Matrix m = new Matrix();
        m.set(this.matrix);
        RectF rect = new RectF(0.0f, 0.0f, (float) this.bitmap.getWidth(), (float) this.bitmap.getHeight());
        m.mapRect(rect);
        float height = rect.height();
        float width = rect.width();
        float deltaX = 0.0f;
        float deltaY = 0.0f;
        if (vertical) {
            int screenHeight = this.dm.heightPixels;
            if (height < ((float) screenHeight)) {
                deltaY = ((((float) screenHeight) - height) / 2.0f) - rect.top;
            } else if (rect.top > 0.0f) {
                deltaY = -rect.top;
            } else if (rect.bottom < ((float) screenHeight)) {
                deltaY = ((float) getHeight()) - rect.bottom;
            }
        }
        if (horizontal) {
            int screenWidth = this.dm.widthPixels;
            if (width < ((float) screenWidth)) {
                deltaX = ((((float) screenWidth) - width) / 2.0f) - rect.left;
            } else if (rect.left > 0.0f) {
                deltaX = -rect.left;
            } else if (rect.right < ((float) screenWidth)) {
                deltaX = ((float) screenWidth) - rect.right;
            }
        }
        this.matrix.postTranslate(deltaX, deltaY);
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private void midPoint(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }

    public PointF getVertex() {
        float[] values = getMatrixValue();
        if (this.mVertex == null) {
            this.mVertex = new PointF(0.0f, 0.0f);
        }
        this.mVertex.x = values[2];
        this.mVertex.y = values[5];
        return this.mVertex;
    }

    public double getScaleValue() {
        return (double) ((1.0f / ((float) this.mInSampleSize)) * getMatrixValue()[0]);
    }

    private float[] getMatrixValue() {
        float[] values = new float[9];
        this.matrix.getValues(values);
        return values;
    }
}
