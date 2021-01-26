package com.deepai.library.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import com.deepai.library.support.utils.BitmapUtil;
import com.deepai.library.ui.gesture.MoveGestureDetector;
import com.deepai.library.ui.gesture.MoveGestureDetector.SimpleOnMoveGestureListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BigImageView extends View {
    public static final int INTERSECT = -3;
    public static final int OUT_LIMIT = -2;
    public static final int RESULT_OK = -1;
    private int defaultOverlaysLimit;
    private Bitmap displayBm;
    private boolean drawableOverlay = false;
    private boolean hasImg;
    private BitmapRegionDecoder mDecoder;
    private int mImgHeight;
    /* access modifiers changed from: private */
    public volatile Rect mImgRect = new Rect();
    private int mImgWidth;
    private OnOverlayClickListener mListner;
    private MoveGestureDetector mMoveDetector;
    private ScaleGestureDetector mScaleDetector;
    private Rect mViewRect = new Rect();
    private Options options;
    private List<Overlay> overlays;
    /* access modifiers changed from: private */
    public float scaleRatio;

    public interface OnOverlayClickListener {
        void onAddOverlayClick(Overlay overlay);

        void onOverlayClick(int i, Overlay overlay);
    }

    public class Overlay {
        Bitmap bm;
        Point point;
        Rect rect;
        int scaleHalf;

        private Overlay(Bitmap bm2, Rect rect2, Point point2, int scaleHalf2) {
            this.bm = bm2;
            this.rect = rect2;
            this.point = point2;
            this.scaleHalf = scaleHalf2;
        }

        public Point getCenterPoint2Img() {
            return this.point;
        }

        public PointF getCenterPointF2View() {
            return new PointF(((float) (this.point.x - BigImageView.this.mImgRect.left)) * BigImageView.this.scaleRatio, ((float) (this.point.y - BigImageView.this.mImgRect.top)) * BigImageView.this.scaleRatio);
        }

        public PointF getOverlayTopMidPointF2View() {
            PointF pointF = getCenterPointF2View();
            pointF.y -= (float) getOverlayHalf();
            return pointF;
        }

        public int getOverlayHalf() {
            return (int) (((float) this.scaleHalf) * BigImageView.this.scaleRatio);
        }
    }

    public BigImageView(Context context) {
        super(context);
        init(context);
    }

    public BigImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setDrawableOverlay(boolean drawableOverlay2) {
        this.drawableOverlay = drawableOverlay2;
        if (this.overlays == null) {
            this.overlays = new ArrayList();
        }
    }

    public void setOnOverlayClickListener(OnOverlayClickListener listener) {
        this.mListner = listener;
    }

    public void setImage(InputStream is) {
        try {
            this.mDecoder = BitmapRegionDecoder.newInstance(is, false);
            Options tmpOptions = new Options();
            tmpOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, tmpOptions);
            setImgSize(tmpOptions);
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e3) {
                }
            }
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e4) {
                }
            }
        }
    }

    public void setImage(String filePath) {
        try {
            this.mDecoder = BitmapRegionDecoder.newInstance(filePath, false);
            Options tmpOptions = new Options();
            tmpOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, tmpOptions);
            this.mImgWidth = tmpOptions.outWidth;
            this.mImgHeight = tmpOptions.outHeight;
            setImgSize(tmpOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setImgSize(Options tmpOptions) {
        this.mImgWidth = tmpOptions.outWidth;
        this.mImgHeight = tmpOptions.outHeight;
        this.hasImg = true;
        requestLayout();
        invalidate();
    }

    private void init(Context context) {
        this.options = new Options();
        this.options.inPreferredConfig = Config.RGB_565;
        this.defaultOverlaysLimit = 10;
        this.mMoveDetector = new MoveGestureDetector(context, new SimpleOnMoveGestureListener() {
            public boolean onMove(MoveGestureDetector detector) {
                BigImageView.this.moveImg(detector);
                return true;
            }
        });
        this.mScaleDetector = new ScaleGestureDetector(context, new SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector detector) {
                return true;
            }
        });
        this.hasImg = false;
    }

    public void moveImg(MoveGestureDetector detector) {
        PointF d = detector.getFocusDelta();
        float moveX = d.x;
        float moveY = d.y;
        this.mImgRect.offset(Math.round((-moveX) / this.scaleRatio), 0);
        checkWidth();
        this.mImgRect.offset(0, Math.round((-moveY) / this.scaleRatio));
        checkHeight();
        drawDisplayBitmap();
    }

    private void checkWidth() {
        Rect rect = this.mImgRect;
        int imgWidth = this.mImgWidth;
        if (rect.right > imgWidth) {
            rect.left = 0;
            rect.right = Math.round(((float) getWidth()) / this.scaleRatio);
        }
        if (rect.left < 0) {
            rect.left = imgWidth - Math.round(((float) getWidth()) / this.scaleRatio);
            rect.right = imgWidth;
        }
    }

    private void checkHeight() {
        Rect rect = this.mImgRect;
        int i = this.mImgWidth;
        int imageHeight = this.mImgHeight;
        if (rect.bottom > imageHeight) {
            rect.bottom = imageHeight;
            rect.top = imageHeight - ((int) (((float) getHeight()) / this.scaleRatio));
        }
        if (rect.top < 0) {
            rect.top = 0;
            rect.bottom = (int) (((float) getHeight()) / this.scaleRatio);
        }
    }

    private void drawDisplayBitmap() {
        createDisplayBitmap();
        invalidate();
    }

    private void createDisplayBitmap() {
        Bitmap bm = this.mDecoder.decodeRegion(this.mImgRect, this.options);
        if (this.displayBm != null && !this.displayBm.isRecycled()) {
            this.displayBm.recycle();
            this.displayBm = null;
        }
        this.displayBm = Bitmap.createBitmap(this.mImgRect.width(), this.mImgRect.height(), Config.RGB_565);
        Canvas canvas = new Canvas(this.displayBm);
        canvas.drawBitmap(bm, 0.0f, 0.0f, null);
        if (this.drawableOverlay && this.overlays != null && this.overlays.size() > 0) {
            Rect rectOverlay = new Rect();
            for (Overlay overlay : this.overlays) {
                if (this.mImgRect.contains(overlay.rect)) {
                    rectOverlay.set(overlay.rect);
                    rectOverlay.offset(-this.mImgRect.left, -this.mImgRect.top);
                    canvas.drawBitmap(overlay.bm, null, rectOverlay, null);
                }
            }
        }
        canvas.save();
    }

    public int addOverlay(PointF pointF, int imgRes) {
        int result = getRect2Img(Math.round((pointF.x / this.scaleRatio) + ((float) this.mImgRect.left)), Math.round((pointF.y / this.scaleRatio) + ((float) this.mImgRect.top)), imgRes, true);
        if (result == -1) {
            drawDisplayBitmap();
        }
        return result;
    }

    public void addMultiOverlay(List<Point> points, int imgRes) {
        for (Point point : points) {
            getRect2Img(point.x, point.y, imgRes, false);
        }
        drawDisplayBitmap();
    }

    private int getRect2Img(int centerX, int centerY, int imgRes, boolean singleAdd) {
        Bitmap bm = BitmapUtil.decodeRawResource(getResources(), imgRes);
        int half = Math.round((((float) bm.getWidth()) / this.scaleRatio) / 2.0f);
        Rect rect = new Rect(centerX - half, centerY - half, centerX + half, centerY + half);
        if (this.overlays == null) {
            this.overlays = new ArrayList();
        }
        for (int i = 0; i < this.overlays.size(); i++) {
            Overlay overlay = (Overlay) this.overlays.get(i);
            if (rect.intersect(overlay.rect)) {
                bm.recycle();
                if (this.mListner != null) {
                    this.mListner.onOverlayClick(i, overlay);
                }
                return -3;
            }
        }
        if (this.overlays.size() == this.defaultOverlaysLimit) {
            bm.recycle();
            return -2;
        }
        checkOverlayRectSide(half, rect);
        Overlay overlay2 = new Overlay(bm, rect, new Point(centerX, centerY), half);
        this.overlays.add(overlay2);
        if (singleAdd && this.mListner != null) {
            this.mListner.onAddOverlayClick(overlay2);
        }
        return -1;
    }

    private void checkOverlayRectSide(int half, Rect rect) {
        if (rect.right > this.mImgWidth) {
            rect.right = this.mImgWidth;
            rect.left = this.mImgWidth - (half * 2);
        }
        if (rect.left < 0) {
            rect.left = 0;
            rect.right = half * 2;
        }
        if (rect.bottom > this.mImgHeight) {
            rect.bottom = this.mImgHeight;
            rect.top = this.mImgHeight - (half * 2);
        }
        if (rect.top < 0) {
            rect.top = 0;
            rect.bottom = half * 2;
        }
    }

    public int removeOverlay(PointF pointF) {
        int index = -1;
        if (this.overlays != null && this.overlays.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.overlays.size()) {
                    break;
                } else if (((Overlay) this.overlays.get(i)).rect.contains(Math.round((pointF.x / this.scaleRatio) + ((float) this.mImgRect.left)), Math.round((pointF.y / this.scaleRatio) + ((float) this.mImgRect.top)))) {
                    index = i;
                    break;
                } else {
                    i++;
                }
            }
            if (index >= 0) {
                Overlay overlay = (Overlay) this.overlays.get(index);
                if (overlay.bm != null && !overlay.bm.isRecycled()) {
                    overlay.bm.recycle();
                }
                this.overlays.remove(index);
                drawDisplayBitmap();
            }
        }
        return index;
    }

    public List<Overlay> getAllOverlay() {
        return this.overlays;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.hasImg) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            int imgWidth = this.mImgWidth;
            int imgHeight = this.mImgHeight;
            if (imgWidth > width && imgHeight > height) {
                this.scaleRatio = 1.0f;
            } else if (imgWidth > imgHeight) {
                this.scaleRatio = ((float) height) / ((float) imgHeight);
            } else {
                this.scaleRatio = ((float) width) / ((float) imgWidth);
            }
            this.mViewRect.left = 0;
            this.mViewRect.top = 0;
            this.mViewRect.right = width;
            this.mViewRect.bottom = height;
            this.mImgRect.left = (int) (((float) this.mViewRect.left) / this.scaleRatio);
            this.mImgRect.top = (int) (((float) this.mViewRect.top) / this.scaleRatio);
            this.mImgRect.right = (int) (((float) this.mViewRect.right) / this.scaleRatio);
            this.mImgRect.bottom = (int) (((float) this.mViewRect.bottom) / this.scaleRatio);
            createDisplayBitmap();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.hasImg) {
            return true;
        }
        this.mMoveDetector.onTouchEvent(event);
        this.mScaleDetector.onTouchEvent(event);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.hasImg) {
            canvas.drawBitmap(this.displayBm, null, this.mViewRect, null);
        }
    }

    public void release() {
        if (this.displayBm != null) {
            this.displayBm = null;
        }
        if (this.mDecoder != null && !this.mDecoder.isRecycled()) {
            this.mDecoder.recycle();
            this.mDecoder = null;
        }
        if (this.overlays != null) {
            for (Overlay overlay : this.overlays) {
                if (overlay.bm != null && !overlay.bm.isRecycled()) {
                    overlay.bm.recycle();
                }
            }
            this.overlays.clear();
            this.overlays = null;
        }
    }

    public PointF getPointF2Img(PointF pointF) {
        PointF p2Img = new PointF();
        p2Img.x = (pointF.x / this.scaleRatio) + ((float) this.mImgRect.left);
        p2Img.y = (pointF.y / this.scaleRatio) + ((float) this.mImgRect.top);
        return p2Img;
    }

    public float getScaleRatio() {
        return this.scaleRatio;
    }
}
