package com.deepai.library.ui.gesture;

import android.content.Context;
import android.view.MotionEvent;

public class RotateGestureDetector extends TwoFingerGestureDetector {
    private final OnRotateGestureListener mListener;
    private boolean mSloppyGesture;

    public interface OnRotateGestureListener {
        boolean onRotate(RotateGestureDetector rotateGestureDetector);

        boolean onRotateBegin(RotateGestureDetector rotateGestureDetector);

        void onRotateEnd(RotateGestureDetector rotateGestureDetector);
    }

    public static class SimpleOnRotateGestureListener implements OnRotateGestureListener {
        public boolean onRotate(RotateGestureDetector detector) {
            return false;
        }

        public boolean onRotateBegin(RotateGestureDetector detector) {
            return true;
        }

        public void onRotateEnd(RotateGestureDetector detector) {
        }
    }

    public RotateGestureDetector(Context context, OnRotateGestureListener listener) {
        super(context);
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public void handleStartProgressEvent(int actionCode, MotionEvent event) {
        switch (actionCode) {
            case 2:
                if (this.mSloppyGesture) {
                    this.mSloppyGesture = isSloppyGesture(event);
                    if (!this.mSloppyGesture) {
                        this.mGestureInProgress = this.mListener.onRotateBegin(this);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                resetState();
                this.mPrevEvent = MotionEvent.obtain(event);
                this.mTimeDelta = 0;
                updateStateByEvent(event);
                this.mSloppyGesture = isSloppyGesture(event);
                if (!this.mSloppyGesture) {
                    this.mGestureInProgress = this.mListener.onRotateBegin(this);
                    return;
                }
                return;
            case 6:
                if (!this.mSloppyGesture) {
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void handleInProgressEvent(int actionCode, MotionEvent event) {
        switch (actionCode) {
            case 2:
                updateStateByEvent(event);
                if (this.mCurrPressure / this.mPrevPressure > 0.67f && this.mListener.onRotate(this)) {
                    this.mPrevEvent.recycle();
                    this.mPrevEvent = MotionEvent.obtain(event);
                    return;
                }
                return;
            case 3:
                if (!this.mSloppyGesture) {
                    this.mListener.onRotateEnd(this);
                }
                resetState();
                return;
            case 6:
                updateStateByEvent(event);
                if (!this.mSloppyGesture) {
                    this.mListener.onRotateEnd(this);
                }
                resetState();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void resetState() {
        super.resetState();
        this.mSloppyGesture = false;
    }

    public float getRotationDegreesDelta() {
        return (float) ((180.0d * (Math.atan2((double) this.mPrevFingerDiffY, (double) this.mPrevFingerDiffX) - Math.atan2((double) this.mCurrFingerDiffY, (double) this.mCurrFingerDiffX))) / 3.141592653589793d);
    }
}
