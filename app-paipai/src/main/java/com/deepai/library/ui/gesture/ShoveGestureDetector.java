package com.deepai.library.ui.gesture;

import android.content.Context;
import android.view.MotionEvent;

public class ShoveGestureDetector extends TwoFingerGestureDetector {
    private float mCurrAverageY;
    private final OnShoveGestureListener mListener;
    private float mPrevAverageY;
    private boolean mSloppyGesture;

    public interface OnShoveGestureListener {
        boolean onShove(ShoveGestureDetector shoveGestureDetector);

        boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector);
    }

    public static class SimpleOnShoveGestureListener implements OnShoveGestureListener {
        public boolean onShove(ShoveGestureDetector detector) {
            return false;
        }

        public boolean onShoveBegin(ShoveGestureDetector detector) {
            return true;
        }

        public void onShoveEnd(ShoveGestureDetector detector) {
        }
    }

    public ShoveGestureDetector(Context context, OnShoveGestureListener listener) {
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
                        this.mGestureInProgress = this.mListener.onShoveBegin(this);
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
                    this.mGestureInProgress = this.mListener.onShoveBegin(this);
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
                if (this.mCurrPressure / this.mPrevPressure > 0.67f && Math.abs(getShovePixelsDelta()) > 0.5f && this.mListener.onShove(this)) {
                    this.mPrevEvent.recycle();
                    this.mPrevEvent = MotionEvent.obtain(event);
                    return;
                }
                return;
            case 3:
                if (!this.mSloppyGesture) {
                    this.mListener.onShoveEnd(this);
                }
                resetState();
                return;
            case 6:
                updateStateByEvent(event);
                if (!this.mSloppyGesture) {
                    this.mListener.onShoveEnd(this);
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
        this.mPrevAverageY = 0.0f;
        this.mCurrAverageY = 0.0f;
    }

    /* access modifiers changed from: protected */
    public void updateStateByEvent(MotionEvent curr) {
        super.updateStateByEvent(curr);
        MotionEvent prev = this.mPrevEvent;
        this.mPrevAverageY = (prev.getY(0) + prev.getY(1)) / 2.0f;
        this.mCurrAverageY = (curr.getY(0) + curr.getY(1)) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture(MotionEvent event) {
        if (super.isSloppyGesture(event)) {
            return true;
        }
        double angle = Math.abs(Math.atan2((double) this.mCurrFingerDiffY, (double) this.mCurrFingerDiffX));
        if ((0.0d >= angle || angle >= 0.3499999940395355d) && (2.7899999618530273d >= angle || angle >= 3.141592653589793d)) {
            return true;
        }
        return false;
    }

    public float getShovePixelsDelta() {
        return this.mCurrAverageY - this.mPrevAverageY;
    }
}
