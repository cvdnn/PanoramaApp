package com.deepai.library.ui.gesture;

import android.content.Context;
import android.view.MotionEvent;

public abstract class BaseGestureDetector {
    protected static final float PRESSURE_THRESHOLD = 0.67f;
    protected final Context mContext;
    protected MotionEvent mCurrEvent;
    protected float mCurrFocusX;
    protected float mCurrFocusY;
    protected float mCurrPressure;
    protected boolean mGestureInProgress;
    protected MotionEvent mPrevEvent;
    protected float mPrevPressure;
    protected long mTimeDelta;

    /* access modifiers changed from: protected */
    public abstract void handleInProgressEvent(int i, MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    public abstract void handleStartProgressEvent(int i, MotionEvent motionEvent);

    public BaseGestureDetector(Context context) {
        this.mContext = context;
    }

    public boolean onTouchEvent(MotionEvent event) {
        int actionCode = event.getAction() & 255;
        if (!this.mGestureInProgress) {
            handleStartProgressEvent(actionCode, event);
        } else {
            handleInProgressEvent(actionCode, event);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateStateByEvent(MotionEvent curr) {
        int div;
        boolean pointerUp = true;
        MotionEvent prev = this.mCurrEvent;
        if (this.mCurrEvent != null) {
            this.mCurrEvent.recycle();
            this.mCurrEvent = null;
        }
        this.mCurrEvent = MotionEvent.obtain(curr);
        if (curr.getActionMasked() != 1) {
            pointerUp = false;
        }
        int skipIndex = pointerUp ? curr.getActionIndex() : -1;
        int count = curr.getPointerCount();
        if (pointerUp) {
            div = count - 1;
        } else {
            div = count;
        }
        float sumX = 0.0f;
        float sumY = 0.0f;
        for (int i = 0; i < count; i++) {
            if (skipIndex != i) {
                sumX += curr.getX(i);
                sumY += curr.getY(i);
            }
        }
        this.mCurrFocusX = sumX / ((float) div);
        this.mCurrFocusY = sumY / ((float) div);
        if (prev != null) {
            this.mPrevPressure = prev.getPressure(prev.getActionIndex());
            this.mTimeDelta = curr.getEventTime() - prev.getEventTime();
            this.mCurrPressure = curr.getPressure(curr.getActionIndex());
        }
    }

    public float getFocusX() {
        return this.mCurrFocusX;
    }

    public float getFocusY() {
        return this.mCurrFocusY;
    }

    /* access modifiers changed from: protected */
    public void resetState() {
        if (this.mPrevEvent != null) {
            this.mPrevEvent.recycle();
            this.mPrevEvent = null;
        }
        if (this.mCurrEvent != null) {
            this.mCurrEvent.recycle();
            this.mCurrEvent = null;
        }
        this.mGestureInProgress = false;
    }

    public boolean isInProgress() {
        return this.mGestureInProgress;
    }

    public long getTimeDelta() {
        return this.mTimeDelta;
    }

    public long getEventTime() {
        return this.mCurrEvent.getEventTime();
    }
}
