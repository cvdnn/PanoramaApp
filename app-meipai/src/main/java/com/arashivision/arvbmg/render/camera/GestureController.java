package com.arashivision.arvbmg.render.camera;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.arashivision.arvbmg.render.camera.MyGestureDetector.OnGestureListener;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import e.a.a.a.a;

public class GestureController implements OnGestureListener {
    public static final int CLICK = 3;
    public static final int CONSTANT_REBOUND_ANIMATION_DURATION = 250;
    public static final int CONSTANT_ZOOM_COUNTER = 500;
    public static final float CONSTANT_ZOOM_IN = 1.115f;
    public static final float CONSTANT_ZOOM_OUT = 0.95f;
    public static int DISTANCE_TO_ROTATE_FACTOR = 750;
    public static final int DOUBLE_POINT_DISTANCE = 10;
    public static final int DOUBLE_TOUCH = 5;
    public static final int DRAG = 1;
    public static final int LONGCLICK = 4;
    public static int MIN_DURATION_X = 325;
    public static int MIN_DURATION_Y = 100;
    public static final int NONE = 0;
    public static int SPEED_DISTANT_FACTOR = 250;
    public static int SPEED_DURATION_FACTOR = 300;
    public static float TOUCH_SCALE_FACTOR = 0.001f;
    public static final int ZOOM = 2;
    public static final float ZOOM_FACTOR = 0.1f;
    public float mCalculateMaxDistance;
    public float mCalculateMaxFov;
    public float mCalculateMinDistance;
    public float mCalculateMinFov;
    public BaseCameraController mCameraController;
    public float mDistance;
    public boolean mDistanceChangeEnabled = true;
    public boolean mEnabled;
    public float mFov;
    public boolean mFovChangeEnabled = true;
    public OnGestureChangeListener mGestureChangeListener;
    public MyGestureDetector mGestureDetector;
    public boolean mHorizontalEnabled = true;
    public boolean mIsPivotMode = false;
    public float[] mLockPitchRange = null;
    public float[] mLockYawRange = null;
    public float mMaxDistance;
    public float mMaxFov;
    public float mMinDistance;
    public float mMinFov;
    public boolean mNeedRebound = true;
    public float mPrevDist = 1.0f;
    public float mPrevSlope;
    public ReboundAnimator mReboundAnimator;
    public float[] mRotate = new float[2];
    public boolean mVerticalEnabled = true;
    public float mZoomCounter = 1.0f;
    public boolean mZoomEnabled = true;
    public int mode = 0;
    public QuaternaionAnimator quaternaionAnimator;

    public interface OnGestureChangeListener {
        void onActionUp();

        boolean onDown(MotionEvent motionEvent);

        void onFlingAnimation();

        void onFlingAnimationEnd();

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);

        void onZoom();

        void onZoomAnimation();

        void onZoomAnimationEnd();
    }

    public class QuaternaionAnimator implements AnimatorUpdateListener {
        public boolean mAnimationEnabled = true;
        public ValueAnimator mAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        public float mLastValue = 0.0f;
        public float mSpeedX;
        public float mSpeedY;

        public QuaternaionAnimator(float f2, float f3) {
            this.mSpeedX = f2;
            this.mSpeedY = f3;
            long j2 = 0;
            if (Math.abs(f2) > Math.abs(this.mSpeedY)) {
                long abs = (long) (((float) (Math.abs((int) (this.mSpeedX * ((float) GestureController.SPEED_DURATION_FACTOR))) + GestureController.MIN_DURATION_X)) * 0.5f);
                ValueAnimator valueAnimator = this.mAnimator;
                if (abs > 0) {
                    j2 = abs;
                }
                valueAnimator.setDuration(j2);
                this.mSpeedY = 0.0f;
            } else {
                long abs2 = (long) (((float) (Math.abs((int) (this.mSpeedY * ((float) GestureController.SPEED_DURATION_FACTOR))) + GestureController.MIN_DURATION_Y)) * 0.5f);
                ValueAnimator valueAnimator2 = this.mAnimator;
                if (abs2 > 0) {
                    j2 = abs2;
                }
                valueAnimator2.setDuration(j2);
                this.mSpeedX = 0.0f;
            }
            this.mAnimator.setInterpolator(new TimeInterpolator(GestureController.this) {
                public float getInterpolation(float f2) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3) + 1.0f;
                }
            });
            this.mAnimator.addUpdateListener(this);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.mAnimationEnabled) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    if (this.mLastValue > floatValue) {
                        this.mLastValue = floatValue;
                    }
                    GestureController gestureController = GestureController.this;
                    float f2 = this.mSpeedX * ((float) GestureController.SPEED_DISTANT_FACTOR);
                    float f3 = this.mLastValue;
                    gestureController.mRotate = gestureController.calculateRotate(((floatValue - f3) * f2) / ((float) GestureController.DISTANCE_TO_ROTATE_FACTOR), (((floatValue - f3) * (this.mSpeedY * ((float) GestureController.SPEED_DISTANT_FACTOR))) * 0.5f) / ((float) GestureController.DISTANCE_TO_ROTATE_FACTOR));
                    this.mLastValue = floatValue;
                    if (GestureController.this.mGestureChangeListener != null && (GestureController.this.mHorizontalEnabled || GestureController.this.mVerticalEnabled)) {
                        GestureController.this.mGestureChangeListener.onFlingAnimation();
                        if (floatValue >= 1.0f) {
                            GestureController.this.mGestureChangeListener.onFlingAnimationEnd();
                        }
                    }
                }
            }
        }

        public void start() {
            this.mLastValue = 0.0f;
            this.mAnimator.start();
        }

        public void stop() {
            this.mAnimationEnabled = false;
            if (this.mAnimator != null && Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    this.mAnimator.cancel();
                } catch (Exception unused) {
                }
            }
            this.mAnimator = null;
        }
    }

    public class ReboundAnimator implements AnimatorUpdateListener {
        public boolean mAnimationEnabled = true;
        public ValueAnimator mAnimator;
        public float mBetweenDistance;
        public float mBetweenFov;
        public float mDstDistance;
        public float mDstFov;
        public float mSrcDistance;
        public float mSrcFov;

        public ReboundAnimator(float f2, float f3) {
            if (GestureController.this.mCameraController != null) {
                this.mDstFov = f2;
                this.mDstDistance = f3;
                this.mAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.mSrcFov = GestureController.this.mCameraController.getFov();
                float distance = GestureController.this.mCameraController.getDistance();
                this.mSrcDistance = distance;
                float f4 = this.mDstFov - this.mSrcFov;
                this.mBetweenFov = f4;
                this.mBetweenDistance = this.mDstDistance - distance;
                if (f4 != 0.0f) {
                    this.mAnimator.setDuration(250);
                } else {
                    this.mAnimator.setDuration(250);
                }
                this.mAnimator.setInterpolator(new DecelerateInterpolator());
                this.mAnimator.addUpdateListener(this);
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.mAnimationEnabled) {
                float min = Math.min(1.0f, Math.max(0.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                float f2 = (this.mBetweenFov * min) + this.mSrcFov;
                float f3 = (this.mBetweenDistance * min) + this.mSrcDistance;
                if (GestureController.this.mFovChangeEnabled) {
                    GestureController.this.mFov = f2;
                }
                if (GestureController.this.mDistanceChangeEnabled) {
                    GestureController.this.mDistance = f3;
                }
                if (GestureController.this.mGestureChangeListener != null && GestureController.this.mZoomEnabled) {
                    GestureController.this.mGestureChangeListener.onZoomAnimation();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onAnimationUpdate newFov:");
                sb.append(f2);
                sb.append(" newDistance:");
                sb.append(f3);
                Log.i("GestureController", sb.toString());
                if (min == 1.0f) {
                    stop();
                    if (GestureController.this.mGestureChangeListener != null && GestureController.this.mZoomEnabled) {
                        GestureController.this.mGestureChangeListener.onZoomAnimationEnd();
                    }
                }
            }
        }

        public void start() {
            this.mAnimator.start();
        }

        public void stop() {
            this.mAnimationEnabled = false;
            if (this.mAnimator != null && Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    this.mAnimator.cancel();
                } catch (Exception unused) {
                }
            }
            this.mAnimator = null;
        }
    }

    public GestureController(Context context) {
        this.mGestureDetector = new MyGestureDetector(context, (OnGestureListener) this);
    }

    /* access modifiers changed from: private */
    public float[] calculateRotate(float f2, float f3) {
        float[] fArr = this.mRotate;
        return new float[]{fArr[0] + f2, fArr[1] + f3};
    }

    public static float calculateSlope(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        return (motionEvent.getY(1) - motionEvent.getY(0)) / (motionEvent.getX(1) - x);
    }

    private float[] checkLockRange(float[] fArr) {
        float[] fArr2 = this.mLockPitchRange;
        if (fArr2 != null) {
            if (fArr[0] < fArr2[0]) {
                fArr[0] = fArr2[0];
            } else if (fArr[0] > fArr2[1]) {
                fArr[0] = fArr2[1];
            }
        }
        float[] fArr3 = this.mLockYawRange;
        if (fArr3 != null) {
            if (fArr[1] < fArr3[0]) {
                fArr[1] = fArr3[0];
            } else if (fArr[1] > fArr3[1]) {
                fArr[1] = fArr3[1];
            }
        }
        return fArr;
    }

    private void checkZoomBound() {
        BaseCameraController baseCameraController = this.mCameraController;
        String str = "GestureController";
        if (baseCameraController == null) {
            Log.e(str, "CameraController is null");
            return;
        }
        float fov = baseCameraController.getFov();
        float distance = this.mCameraController.getDistance();
        float f2 = this.mMaxFov;
        if (fov <= f2) {
            f2 = this.mMinFov;
            if (fov >= f2) {
                f2 = fov;
            }
        }
        float f3 = this.mMaxDistance;
        if (distance <= f3) {
            f3 = this.mMinDistance;
            if (distance >= f3) {
                f3 = distance;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dstFov:");
        sb.append(f2);
        sb.append(" dstDistance:");
        sb.append(f3);
        Log.i(str, sb.toString());
        if (!(f2 == fov && f3 == distance) && this.mNeedRebound) {
            ReboundAnimator reboundAnimator = this.mReboundAnimator;
            if (reboundAnimator != null) {
                reboundAnimator.stop();
                this.mReboundAnimator = null;
            }
            ReboundAnimator reboundAnimator2 = new ReboundAnimator(f2, f3);
            this.mReboundAnimator = reboundAnimator2;
            reboundAnimator2.start();
        }
    }

    private float getScaleFactor(float f2, float f3) {
        float f4 = 0.0f;
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float f5 = 0.1f * f2;
        float abs = Math.abs(f3 - 1.0f) - (this.mZoomCounter / 500.0f);
        if (abs > 0.0f) {
            f4 = abs;
        }
        this.mZoomCounter += 1.0f;
        if (f3 > 1.0f) {
            f4 *= -1.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("betweenValue:");
        sb.append(f2);
        sb.append(" srcScale:");
        sb.append(f4);
        Log.i("xym", sb.toString());
        return f5 * f4;
    }

    private void onHandleMultiTouch(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            this.mode = 5;
            this.mPrevDist = spacing(motionEvent);
            this.mPrevSlope = calculateSlope(motionEvent);
            return;
        }
        Log.e("GestureController", "multitouch unhandle!!");
    }

    private void onHandleTouch(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 2) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mGestureDetector.onTouchEvent(motionEvent);
            if (this.mEnabled) {
                OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
                if (onGestureChangeListener != null) {
                    onGestureChangeListener.onActionUp();
                }
            }
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        Log.d("GestureController", "onTouch");
        int action = motionEvent.getAction() & 255;
        if (action == 5) {
            onHandleMultiTouch(motionEvent);
        } else if (action != 6) {
            onHandleTouch(motionEvent);
        } else {
            onTouchDoubleUp(motionEvent);
        }
    }

    private void onTouchDoubleUp(MotionEvent motionEvent) {
        this.mZoomCounter = 1.0f;
        checkZoomBound();
        this.mode = 0;
    }

    private void reset() {
        QuaternaionAnimator quaternaionAnimator2 = this.quaternaionAnimator;
        if (quaternaionAnimator2 != null) {
            quaternaionAnimator2.stop();
            this.quaternaionAnimator = null;
        }
        ReboundAnimator reboundAnimator = this.mReboundAnimator;
        if (reboundAnimator != null) {
            reboundAnimator.stop();
            this.mReboundAnimator = null;
        }
    }

    public static float spacing(MotionEvent motionEvent) {
        float f2;
        float f3 = 0.0f;
        try {
            f2 = motionEvent.getX(0) - motionEvent.getX(1);
            try {
                f3 = motionEvent.getY(0) - motionEvent.getY(1);
            } catch (IllegalArgumentException e2) {
                e = e2;
                Log.e("GestureController", e.getMessage());
                return (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            f2 = 0.0f;
            Log.e("GestureController", e.getMessage());
            return (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
        }
        return (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
    }

    private void zoom(MotionEvent motionEvent) {
        float f2;
        float f3;
        BaseCameraController baseCameraController = this.mCameraController;
        String str = "GestureController";
        if (baseCameraController == null) {
            Log.e(str, "CameraController is null");
            return;
        }
        float fov = baseCameraController.getFov();
        float distance = this.mCameraController.getDistance();
        float spacing = spacing(motionEvent);
        float f4 = spacing / this.mPrevDist;
        this.mPrevDist = spacing;
        if (this.mFovChangeEnabled) {
            float f5 = this.mCalculateMaxFov - this.mCalculateMinFov;
            float zoomScale = getZoomScale(f5, f4) + fov;
            if (zoomScale <= this.mCalculateMaxFov || f4 >= 1.0f) {
                if (zoomScale < this.mCalculateMinFov && f4 > 1.0f) {
                    f3 = getScaleFactor(f5, 1.115f);
                }
                StringBuilder a2 = a.a("minFov:");
                a2.append(this.mMinFov);
                a2.append(" maxFov:");
                a2.append(this.mMaxFov);
                a2.append(" newFov:");
                a2.append(zoomScale);
                Log.i(str, a2.toString());
                this.mFov = zoomScale;
            } else {
                f3 = getScaleFactor(f5, 0.95f);
            }
            zoomScale = fov + f3;
            StringBuilder a22 = a.a("minFov:");
            a22.append(this.mMinFov);
            a22.append(" maxFov:");
            a22.append(this.mMaxFov);
            a22.append(" newFov:");
            a22.append(zoomScale);
            Log.i(str, a22.toString());
            this.mFov = zoomScale;
        }
        if (this.mDistanceChangeEnabled) {
            float f6 = this.mCalculateMaxDistance - this.mCalculateMinDistance;
            float zoomScale2 = getZoomScale(f6, f4) + distance;
            if (zoomScale2 <= this.mCalculateMaxDistance || f4 >= 1.0f) {
                if (zoomScale2 < this.mCalculateMinDistance && f4 > 1.0f) {
                    f2 = getScaleFactor(f6, 1.115f);
                }
                StringBuilder a3 = a.a("minDistance:");
                a3.append(this.mMinDistance);
                a3.append(" maxDistance:");
                a3.append(this.mMaxDistance);
                a3.append(" newDistance:");
                a3.append(zoomScale2);
                Log.i(str, a3.toString());
                this.mDistance = zoomScale2;
            } else {
                f2 = getScaleFactor(f6, 0.95f);
            }
            zoomScale2 = distance + f2;
            StringBuilder a32 = a.a("minDistance:");
            a32.append(this.mMinDistance);
            a32.append(" maxDistance:");
            a32.append(this.mMaxDistance);
            a32.append(" newDistance:");
            a32.append(zoomScale2);
            Log.i(str, a32.toString());
            this.mDistance = zoomScale2;
        }
        OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
        if (onGestureChangeListener != null && this.mZoomEnabled) {
            onGestureChangeListener.onZoom();
        }
    }

    public void destroy() {
        this.mGestureChangeListener = null;
        QuaternaionAnimator quaternaionAnimator2 = this.quaternaionAnimator;
        if (quaternaionAnimator2 != null) {
            quaternaionAnimator2.stop();
            this.quaternaionAnimator = null;
        }
        this.mGestureDetector = null;
        ReboundAnimator reboundAnimator = this.mReboundAnimator;
        if (reboundAnimator != null) {
            reboundAnimator.stop();
            this.mReboundAnimator = null;
        }
    }

    public float getDistance() {
        return this.mDistance;
    }

    public float getFov() {
        return this.mFov;
    }

    public float[] getRotate() {
        return this.mRotate;
    }

    public float getZoomScale(float f2, float f3) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float abs = Math.abs(f3 - 1.0f);
        if (f3 > 1.0f) {
            abs *= -1.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("betweenValue:");
        sb.append(f2);
        sb.append(" srcScale:");
        sb.append(abs);
        Log.i("xym", sb.toString());
        return f2 * abs;
    }

    public boolean isDistanceChangeEnabled() {
        return this.mDistanceChangeEnabled;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isFovChangeEnabled() {
        return this.mFovChangeEnabled;
    }

    public boolean isHorizontalEnabled() {
        return this.mHorizontalEnabled;
    }

    public boolean isVerticalEnabled() {
        return this.mVerticalEnabled;
    }

    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public void lockPitchRange(float[] fArr) {
        this.mLockPitchRange = fArr;
        if (fArr != null) {
            this.mRotate = checkLockRange(this.mRotate);
        }
    }

    public void lockYawRange(float[] fArr) {
        this.mLockYawRange = fArr;
        if (fArr != null) {
            this.mRotate = checkLockRange(this.mRotate);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.mEnabled) {
            Log.i("GestureController", "onDown");
            this.mode = 1;
            QuaternaionAnimator quaternaionAnimator2 = this.quaternaionAnimator;
            if (quaternaionAnimator2 != null) {
                quaternaionAnimator2.stop();
                this.quaternaionAnimator = null;
            }
            OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
            if (onGestureChangeListener != null) {
                return onGestureChangeListener.onDown(motionEvent);
            }
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.mHorizontalEnabled && !this.mVerticalEnabled) {
            return true;
        }
        String str = "GestureController";
        Log.i(str, "onFling");
        if (this.mode == 1) {
            QuaternaionAnimator quaternaionAnimator2 = this.quaternaionAnimator;
            if (quaternaionAnimator2 != null) {
                quaternaionAnimator2.stop();
                this.quaternaionAnimator = null;
            }
            if (!this.mHorizontalEnabled) {
                f2 = 0.0f;
            }
            if (!this.mVerticalEnabled) {
                f3 = 0.0f;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("velocityX:");
            sb.append(f2);
            sb.append(" velocityY:");
            sb.append(f3);
            Log.i(str, sb.toString());
            QuaternaionAnimator quaternaionAnimator3 = new QuaternaionAnimator(f2 / 1000.0f, f3 / 1000.0f);
            this.quaternaionAnimator = quaternaionAnimator3;
            quaternaionAnimator3.start();
        }
        this.mode = 0;
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.mEnabled) {
            Log.i("GestureController", "onLongPress");
            this.mode = 4;
            OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
            if (onGestureChangeListener != null) {
                onGestureChangeListener.onLongPress(motionEvent);
            }
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        int i2 = this.mode;
        if (i2 == 5) {
            double degrees = Math.toDegrees(Math.atan((double) calculateSlope(motionEvent2))) / Math.toDegrees(Math.atan((double) this.mPrevSlope));
            if (!(((double) spacing(motionEvent2)) / ((double) this.mPrevDist) == 1.0d && degrees == 1.0d) && this.mZoomEnabled) {
                this.mode = 2;
                zoom(motionEvent2);
            }
        } else if (i2 == 2) {
            zoom(motionEvent2);
        } else if (i2 == 1 || (this.mIsPivotMode && i2 == 4)) {
            f2 *= -1.0f;
            f3 *= -1.0f;
            if (!this.mHorizontalEnabled) {
                f2 = 0.0f;
            }
            if (!this.mVerticalEnabled) {
                f3 = 0.0f;
            }
            int i3 = DISTANCE_TO_ROTATE_FACTOR;
            this.mRotate = calculateRotate(f2 / ((float) i3), f3 / ((float) i3));
        }
        if (this.mGestureChangeListener == null || (!this.mHorizontalEnabled && !this.mVerticalEnabled)) {
            return false;
        }
        return this.mGestureChangeListener.onScroll(motionEvent, motionEvent2, f2, f3);
    }

    public void onShowPress(MotionEvent motionEvent) {
        if (this.mEnabled) {
            Log.i("GestureController", "onShowPress");
            OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
            if (onGestureChangeListener != null) {
                onGestureChangeListener.onShowPress(motionEvent);
            }
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.mEnabled) {
            Log.i("GestureController", "onSingleTapUp");
            this.mode = 3;
            OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
            if (onGestureChangeListener != null) {
                return onGestureChangeListener.onSingleTapUp(motionEvent);
            }
        }
        return false;
    }

    public void onUpdate(MotionEvent motionEvent) {
        onTouch(motionEvent);
    }

    public void setCameraController(BaseCameraController baseCameraController) {
        this.mCameraController = baseCameraController;
        if (baseCameraController != null) {
            this.mFov = baseCameraController.getFov();
            this.mDistance = this.mCameraController.getDistance();
        }
    }

    public void setDistance(float f2) {
        this.mDistance = f2;
        float min = Math.min(f2, this.mMaxDistance);
        this.mDistance = min;
        float max = Math.max(min, this.mMinDistance);
        this.mDistance = max;
        if (f2 != max) {
            StringBuilder sb = new StringBuilder();
            sb.append("setDistance, distance is updated from ");
            sb.append(f2);
            sb.append(" to ");
            sb.append(this.mDistance);
            sb.append("(");
            sb.append(this.mMinDistance);
            sb.append("-");
            sb.append(this.mMaxDistance);
            sb.append(")");
            Log.d("GestureController", sb.toString());
        }
    }

    public void setDistanceChangeEnabled(boolean z) {
        this.mDistanceChangeEnabled = z;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        reset();
    }

    public void setFov(float f2) {
        this.mFov = f2;
        float min = Math.min(f2, this.mMaxFov);
        this.mFov = min;
        float max = Math.max(min, this.mMinFov);
        this.mFov = max;
        if (f2 != max) {
            StringBuilder sb = new StringBuilder();
            sb.append("setFov, fov is updated from ");
            sb.append(f2);
            sb.append(" to ");
            sb.append(this.mFov);
            sb.append("(");
            sb.append(this.mMinFov);
            sb.append("-");
            sb.append(this.mMaxFov);
            sb.append(")");
            Log.d("GestureController", sb.toString());
        }
    }

    public void setFovChangeEnabled(boolean z) {
        this.mFovChangeEnabled = z;
    }

    public void setFovDistanceCalculateMinMax(float f2, float f3, float f4, float f5) {
        this.mCalculateMinFov = f2;
        this.mCalculateMaxFov = f3;
        this.mCalculateMinDistance = f4;
        this.mCalculateMaxDistance = f5;
    }

    public void setFovDistanceConstraint(float f2, float f3, float f4, float f5) {
        this.mMinFov = f2;
        this.mMaxFov = f3;
        setFov(this.mFov);
        this.mMinDistance = f4;
        this.mMaxDistance = f5;
        setDistance(this.mDistance);
    }

    public void setHorizontalEnabled(boolean z) {
        this.mHorizontalEnabled = z;
    }

    public void setOnGestureChangeListener(OnGestureChangeListener onGestureChangeListener) {
        this.mGestureChangeListener = onGestureChangeListener;
    }

    public void setPivotMode(boolean z) {
        this.mIsPivotMode = z;
        this.mGestureDetector.setPivotMode(z);
    }

    public void setRotate(float[] fArr) {
        this.mRotate = checkLockRange(fArr);
    }

    public void setVerticalEnabled(boolean z) {
        this.mVerticalEnabled = z;
    }

    public void setZoomEnabled(boolean z) {
        this.mZoomEnabled = z;
    }
}
