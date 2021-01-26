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
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import com.deepai.library.support.utils.BitmapUtil;
import com.deepai.library.ui.gesture.MoveGestureDetector;
import com.deepai.library.ui.gesture.MoveGestureDetector.SimpleOnMoveGestureListener;
import com.panoramagl.PLConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BigIVJust360 extends View {
    public static final int INTERSECT = -3;
    public static final int OUT_LIMIT = -2;
    public static final int RESULT_OK = -1;
    private AutoPlayRunnable autoPlayRunnable;
    private int defaultOverlaysLimit;
    private Bitmap displayBm;
    private boolean drawableOverlay = false;
    private boolean hasImg;
    private boolean isPlaying = false;
    private BitmapRegionDecoder mDecoder;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public int mImgFileSize;
    private int mImgHeight;
    /* access modifiers changed from: private */
    public volatile Rect mImgRect = new Rect();
    private int mImgWidth;
    private OnOverlayClickListener mListener;
    private MoveGestureDetector mMoveDetector;
    private int mRealHeight;
    private int mRealWidth;
    private ScaleGestureDetector mScaleDetector;
    /* access modifiers changed from: private */
    public volatile Rect mSubstituteRect = new Rect();
    /* access modifiers changed from: private */
    public int mSubstituteState = 0;
    private Rect mViewRect = new Rect();
    private float maxScaleRatio;
    private float minScaleRatio;
    private Options options;
    private List<Overlay> overlays;
    /* access modifiers changed from: private */
    public float scaleRatio;

    private class AutoPlayRunnable implements Runnable {
        int delay = 0;
        int speed = 20;

        public AutoPlayRunnable() {
            if (BigIVJust360.this.mImgFileSize <= 400) {
                this.delay = PLConstants.kSensorialRotationThreshold;
            } else if (BigIVJust360.this.mImgFileSize <= 500) {
                this.delay = 100;
            } else if (BigIVJust360.this.mImgFileSize <= 600) {
                this.delay = 50;
            } else if (BigIVJust360.this.mImgFileSize <= 700) {
                this.delay = 20;
            } else if (BigIVJust360.this.mImgFileSize <= 800) {
                this.delay = 15;
            } else if (BigIVJust360.this.mImgFileSize <= 900) {
                this.delay = 10;
            } else if (BigIVJust360.this.mImgFileSize <= 1000) {
                this.delay = 5;
            } else {
                this.delay = 0;
            }
        }

        public void run() {
            BigIVJust360.this.mImgRect.offset(this.speed, 0);
            if (BigIVJust360.this.mSubstituteState > 0) {
                BigIVJust360.this.mSubstituteRect.offset(this.speed, 0);
            }
            BigIVJust360.this.checkWidth();
            BigIVJust360.this.drawDisplayBitmap();
            BigIVJust360.this.mHandler.postDelayed(this, (long) this.delay);
        }
    }

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
            return new PointF(((float) (this.point.x - BigIVJust360.this.mImgRect.left)) * BigIVJust360.this.scaleRatio, ((float) (this.point.y - BigIVJust360.this.mImgRect.top)) * BigIVJust360.this.scaleRatio);
        }

        public PointF getOverlayTopMidPointF2View() {
            PointF pointF = getCenterPointF2View();
            pointF.y -= (float) getOverlayHalf();
            return pointF;
        }

        public int getOverlayHalf() {
            return (int) (((float) this.scaleHalf) * BigIVJust360.this.scaleRatio);
        }
    }

    public BigIVJust360(Context context) {
        super(context);
        init(context);
    }

    public BigIVJust360(Context context, AttributeSet attrs) {
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
        this.mListener = listener;
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
            this.mImgFileSize = (int) (new File(filePath).length() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
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
                BigIVJust360.this.moveImg(detector);
                return true;
            }
        });
        this.mScaleDetector = new ScaleGestureDetector(context, new SimpleOnScaleGestureListener() {
            public void onScaleEnd(ScaleGestureDetector detector) {
            }
        });
        this.hasImg = false;
    }

    public void moveImg(MoveGestureDetector detector) {
        PointF d = detector.getFocusDelta();
        int offsetX = (int) (((double) (d.x / this.scaleRatio)) + 0.5d);
        int offsetY = (int) (((double) (d.y / this.scaleRatio)) + 0.5d);
        this.mImgRect.offset(-offsetX, 0);
        if (this.mSubstituteState > 0) {
            this.mSubstituteRect.offset(-offsetX, 0);
        }
        checkWidth();
        this.mImgRect.offset(0, -offsetY);
        this.mSubstituteRect.offset(0, -offsetY);
        checkHeight();
        drawDisplayBitmap();
    }

    private void scaleImg(ScaleGestureDetector detector) {
        float tempS = this.scaleRatio;
        this.scaleRatio /= detector.getScaleFactor();
        if (this.scaleRatio < this.minScaleRatio) {
            this.scaleRatio = this.minScaleRatio;
        }
        if (this.scaleRatio > this.maxScaleRatio) {
            this.scaleRatio = this.maxScaleRatio;
        }
        float scaleChange = this.scaleRatio / tempS;
        if (this.scaleRatio != 1.0f) {
            this.mImgRect.left = (int) ((((float) this.mImgRect.left) / scaleChange) + 0.5f);
            this.mImgRect.top = (int) ((((float) this.mImgRect.top) / scaleChange) + 0.5f);
            this.mImgRect.right = (int) ((((float) this.mImgRect.right) / scaleChange) + 0.5f);
            this.mImgRect.bottom = (int) ((((float) this.mImgRect.bottom) / scaleChange) + 0.5f);
            if (this.mSubstituteState > 0) {
                this.mSubstituteRect.left = (int) ((((float) this.mSubstituteRect.left) / scaleChange) + 0.5f);
                this.mSubstituteRect.top = (int) ((((float) this.mSubstituteRect.top) / scaleChange) + 0.5f);
                this.mSubstituteRect.right = (int) ((((float) this.mSubstituteRect.right) / scaleChange) + 0.5f);
                this.mSubstituteRect.bottom = (int) ((((float) this.mSubstituteRect.bottom) / scaleChange) + 0.5f);
            }
        }
        checkWidth();
        checkHeight();
        drawDisplayBitmap();
    }

    /* access modifiers changed from: private */
    public void checkWidth() {
        int imgWidth = this.mImgWidth;
        if (this.mImgRect.left < 0 && this.mImgRect.right > 0) {
            this.mImgRect.left = 0;
            this.mSubstituteRect.left = imgWidth - (this.mRealWidth - this.mImgRect.width());
            this.mSubstituteRect.right = imgWidth;
            this.mSubstituteState = 1;
        } else if (this.mImgRect.right <= 0) {
            this.mSubstituteRect.left -= this.mImgRect.width();
            this.mImgRect.set(this.mSubstituteRect);
            this.mSubstituteRect.left = 0;
            this.mSubstituteRect.right = 0;
            this.mSubstituteState = 0;
        }
        if (this.mSubstituteRect.left < imgWidth && this.mSubstituteRect.right > imgWidth) {
            this.mSubstituteRect.right = imgWidth;
            this.mImgRect.left = 0;
            this.mImgRect.right = this.mRealWidth - this.mSubstituteRect.width();
            this.mSubstituteState = 1;
        } else if (this.mSubstituteRect.left >= imgWidth) {
            this.mImgRect.right += this.mSubstituteRect.width();
            this.mSubstituteRect.left = 0;
            this.mSubstituteRect.right = 0;
            this.mSubstituteState = 0;
        }
        if (this.mImgRect.left < imgWidth && this.mImgRect.right > imgWidth) {
            this.mImgRect.right = imgWidth;
            this.mSubstituteRect.left = 0;
            this.mSubstituteRect.right = this.mRealWidth - this.mImgRect.width();
            this.mSubstituteState = 2;
        } else if (this.mImgRect.left >= imgWidth) {
            this.mSubstituteRect.right += this.mImgRect.width();
            this.mImgRect.set(this.mSubstituteRect);
            this.mSubstituteRect.left = 0;
            this.mSubstituteRect.right = 0;
            this.mSubstituteState = 0;
        }
        if (this.mSubstituteRect.left < 0 && this.mSubstituteRect.right > 0) {
            this.mSubstituteRect.left = 0;
            this.mImgRect.right = imgWidth;
            this.mImgRect.left = imgWidth - (this.mRealWidth - this.mSubstituteRect.width());
            this.mSubstituteState = 2;
        } else if (this.mSubstituteRect.right <= 0) {
            this.mImgRect.left -= this.mSubstituteRect.width();
            this.mSubstituteRect.left = 0;
            this.mSubstituteRect.right = 0;
            this.mSubstituteState = 0;
        }
    }

    private void checkHeight() {
        int imageHeight = this.mImgHeight;
        if (this.mImgRect.bottom > imageHeight) {
            this.mImgRect.bottom = imageHeight;
            this.mImgRect.top = imageHeight - ((int) ((((float) getHeight()) / this.scaleRatio) + 0.5f));
        }
        if (this.mImgRect.top < 0) {
            this.mImgRect.top = 0;
            this.mImgRect.bottom = (int) ((((float) getHeight()) / this.scaleRatio) + 0.5f);
        }
        if (this.mSubstituteRect.bottom > imageHeight) {
            this.mSubstituteRect.bottom = imageHeight;
            this.mSubstituteRect.top = imageHeight - ((int) ((((float) getHeight()) / this.scaleRatio) + 0.5f));
        }
        if (this.mSubstituteRect.top < 0) {
            this.mSubstituteRect.top = 0;
            this.mSubstituteRect.bottom = (int) ((((float) getHeight()) / this.scaleRatio) + 0.5f);
        }
    }

    /* access modifiers changed from: private */
    public void drawDisplayBitmap() {
        createDisplayBitmap();
        invalidate();
    }

    private void createDisplayBitmap() {
        if (this.displayBm != null && !this.displayBm.isRecycled()) {
            this.displayBm.recycle();
            this.displayBm = null;
        }
        this.displayBm = Bitmap.createBitmap(this.mRealWidth, this.mRealHeight, Config.RGB_565);
        Canvas canvas = new Canvas(this.displayBm);
        Bitmap bm = this.mDecoder.decodeRegion(this.mImgRect, this.options);
        if (this.mSubstituteState == 0) {
            canvas.drawBitmap(bm, 0.0f, 0.0f, null);
        } else if (this.mSubstituteState > 0) {
            Bitmap bmConnect = this.mDecoder.decodeRegion(this.mSubstituteRect, this.options);
            if (this.mSubstituteState == 1) {
                canvas.drawBitmap(bmConnect, 0.0f, 0.0f, null);
                canvas.drawBitmap(bm, (float) this.mSubstituteRect.width(), 0.0f, null);
            } else if (this.mSubstituteState == 2) {
                canvas.drawBitmap(bm, 0.0f, 0.0f, null);
                canvas.drawBitmap(bmConnect, (float) this.mImgRect.width(), 0.0f, null);
            }
        }
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
        int result = getRect2Img((int) ((pointF.x / this.scaleRatio) + ((float) this.mImgRect.left) + 0.5f), (int) ((pointF.y / this.scaleRatio) + ((float) this.mImgRect.top) + 0.5f), imgRes, true);
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
        int half = (int) (((((float) bm.getWidth()) / this.scaleRatio) / 2.0f) + 0.5f);
        Rect rect = new Rect(centerX - half, centerY - half, centerX + half, centerY + half);
        for (int i = 0; i < this.overlays.size(); i++) {
            Overlay overlay = (Overlay) this.overlays.get(i);
            if (rect.intersect(overlay.rect)) {
                bm.recycle();
                if (this.mListener != null) {
                    this.mListener.onOverlayClick(i, overlay);
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
        if (singleAdd && this.mListener != null) {
            this.mListener.onAddOverlayClick(overlay2);
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
                } else if (((Overlay) this.overlays.get(i)).rect.contains((int) ((pointF.x / this.scaleRatio) + ((float) this.mImgRect.left) + 0.5f), (int) ((pointF.y / this.scaleRatio) + ((float) this.mImgRect.top) + 0.5f))) {
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
            if (imgWidth > imgHeight) {
                this.scaleRatio = ((float) height) / ((float) imgHeight);
            } else {
                this.scaleRatio = ((float) width) / ((float) imgWidth);
            }
            this.minScaleRatio = this.scaleRatio / 3.0f;
            this.maxScaleRatio = this.scaleRatio;
            this.mViewRect.left = 0;
            this.mViewRect.top = 0;
            this.mViewRect.right = width;
            this.mViewRect.bottom = height;
            this.mImgRect.left = (int) ((((float) this.mViewRect.left) / this.scaleRatio) + 0.5f);
            this.mImgRect.top = (int) ((((float) this.mViewRect.top) / this.scaleRatio) + 0.5f);
            this.mImgRect.right = (int) ((((float) this.mViewRect.right) / this.scaleRatio) + 0.5f);
            this.mImgRect.bottom = (int) ((((float) this.mViewRect.bottom) / this.scaleRatio) + 0.5f);
            this.mRealWidth = this.mImgRect.width();
            this.mRealHeight = this.mImgRect.height();
            this.mSubstituteRect.left = 0;
            this.mSubstituteRect.top = 0;
            this.mSubstituteRect.right = (int) ((((float) this.mViewRect.right) / this.scaleRatio) + 0.5f);
            this.mSubstituteRect.bottom = (int) ((((float) this.mViewRect.bottom) / this.scaleRatio) + 0.5f);
            createDisplayBitmap();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.hasImg) {
            if (event.getPointerCount() == 1) {
                this.mMoveDetector.onTouchEvent(event);
            } else {
                this.mScaleDetector.onTouchEvent(event);
            }
        }
        return true;
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
        if (this.autoPlayRunnable != null) {
            this.mHandler.removeCallbacks(this.autoPlayRunnable);
        }
        if (this.isPlaying) {
            this.isPlaying = false;
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

    public void startPlay() {
        if (this.hasImg) {
            if (this.autoPlayRunnable == null) {
                this.autoPlayRunnable = new AutoPlayRunnable();
            }
            this.mHandler.postDelayed(this.autoPlayRunnable, 0);
            this.isPlaying = true;
        }
    }

    public void stopPlay() {
        if (this.autoPlayRunnable != null) {
            this.mHandler.removeCallbacks(this.autoPlayRunnable);
        }
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
