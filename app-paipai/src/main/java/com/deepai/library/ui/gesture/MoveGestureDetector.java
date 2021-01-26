package com.deepai.library.ui.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class MoveGestureDetector extends BaseGestureDetector {
    private static final PointF FOCUS_DELTA_ZERO = new PointF();
    private PointF mCurrFocusInternal;
    private PointF mFocusDeltaExternal = new PointF();
    private PointF mFocusExternal = new PointF();
    private final OnMoveGestureListener mListener;
    private PointF mPrevFocusInternal;

    public interface OnMoveGestureListener {
        boolean onMove(MoveGestureDetector moveGestureDetector);

        boolean onMoveBegin(MoveGestureDetector moveGestureDetector);

        void onMoveEnd(MoveGestureDetector moveGestureDetector);
    }

    public static class SimpleOnMoveGestureListener implements OnMoveGestureListener {
        public boolean onMove(MoveGestureDetector detector) {
            return false;
        }

        public boolean onMoveBegin(MoveGestureDetector detector) {
            return true;
        }

        public void onMoveEnd(MoveGestureDetector detector) {
        }
    }

    public MoveGestureDetector(Context context, OnMoveGestureListener listener) {
        super(context);
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public void handleStartProgressEvent(int actionCode, MotionEvent event) {
        switch (actionCode) {
            case 0:
                resetState();
                this.mPrevEvent = MotionEvent.obtain(event);
                this.mTimeDelta = 0;
                updateStateByEvent(event);
                return;
            case 2:
                this.mGestureInProgress = this.mListener.onMoveBegin(this);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void handleInProgressEvent(int actionCode, MotionEvent event) {
        switch (actionCode) {
            case 1:
            case 3:
                this.mListener.onMoveEnd(this);
                resetState();
                return;
            case 2:
                updateStateByEvent(event);
                if (this.mCurrPressure / this.mPrevPressure > 0.67f && this.mListener.onMove(this)) {
                    this.mPrevEvent.recycle();
                    this.mPrevEvent = MotionEvent.obtain(event);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void updateStateByEvent(MotionEvent curr) {
        super.updateStateByEvent(curr);
        MotionEvent prev = this.mPrevEvent;
        this.mCurrFocusInternal = determineFocalPoint(curr);
        this.mPrevFocusInternal = determineFocalPoint(prev);
        this.mFocusDeltaExternal = prev.getPointerCount() != curr.getPointerCount() ? FOCUS_DELTA_ZERO : new PointF(this.mCurrFocusInternal.x - this.mPrevFocusInternal.x, this.mCurrFocusInternal.y - this.mPrevFocusInternal.y);
        this.mFocusExternal.x += this.mFocusDeltaExternal.x;
        this.mFocusExternal.y += this.mFocusDeltaExternal.y;
    }

    private PointF determineFocalPoint(MotionEvent e) {
        int pCount = e.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i = 0; i < pCount; i++) {
            x += e.getX(i);
            y += e.getY(i);
        }
        return new PointF(x / ((float) pCount), y / ((float) pCount));
    }

    public float getFocusX() {
        return this.mFocusExternal.x;
    }

    public float getFocusY() {
        return this.mFocusExternal.y;
    }

    public PointF getFocusDelta() {
        return this.mFocusDeltaExternal;
    }
}
