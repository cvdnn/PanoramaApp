package com.deepai.library.ui.gesture;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class TwoFingerGestureDetector extends BaseGestureDetector {
    private float mBottomSlopEdge;
    protected float mCurrFingerDiffX;
    protected float mCurrFingerDiffY;
    private float mCurrLen;
    private final float mEdgeSlop;
    protected float mPrevFingerDiffX;
    protected float mPrevFingerDiffY;
    private float mPrevLen;
    private float mRightSlopEdge;

    /* access modifiers changed from: protected */
    public abstract void handleInProgressEvent(int i, MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    public abstract void handleStartProgressEvent(int i, MotionEvent motionEvent);

    public TwoFingerGestureDetector(Context context) {
        super(context);
        this.mEdgeSlop = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    /* access modifiers changed from: protected */
    public void updateStateByEvent(MotionEvent curr) {
        super.updateStateByEvent(curr);
        MotionEvent prev = this.mPrevEvent;
        this.mCurrLen = -1.0f;
        this.mPrevLen = -1.0f;
        float px0 = prev.getX(0);
        float py0 = prev.getY(0);
        float pvy = prev.getY(1) - py0;
        this.mPrevFingerDiffX = prev.getX(1) - px0;
        this.mPrevFingerDiffY = pvy;
        float cx0 = curr.getX(0);
        float cy0 = curr.getY(0);
        float cvy = curr.getY(1) - cy0;
        this.mCurrFingerDiffX = curr.getX(1) - cx0;
        this.mCurrFingerDiffY = cvy;
    }

    public float getCurrentSpan() {
        if (this.mCurrLen == -1.0f) {
            float cvx = this.mCurrFingerDiffX;
            float cvy = this.mCurrFingerDiffY;
            this.mCurrLen = (float) Math.sqrt((double) ((cvx * cvx) + (cvy * cvy)));
        }
        return this.mCurrLen;
    }

    public float getPreviousSpan() {
        if (this.mPrevLen == -1.0f) {
            float pvx = this.mPrevFingerDiffX;
            float pvy = this.mPrevFingerDiffY;
            this.mPrevLen = (float) Math.sqrt((double) ((pvx * pvx) + (pvy * pvy)));
        }
        return this.mPrevLen;
    }

    protected static float getRawX(MotionEvent event, int pointerIndex) {
        float offset = event.getX() - event.getRawX();
        if (pointerIndex < event.getPointerCount()) {
            return event.getX(pointerIndex) + offset;
        }
        return 0.0f;
    }

    protected static float getRawY(MotionEvent event, int pointerIndex) {
        float offset = event.getY() - event.getRawY();
        if (pointerIndex < event.getPointerCount()) {
            return event.getY(pointerIndex) + offset;
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture(MotionEvent event) {
        boolean p0sloppy;
        boolean p1sloppy;
        DisplayMetrics metrics = this.mContext.getResources().getDisplayMetrics();
        this.mRightSlopEdge = ((float) metrics.widthPixels) - this.mEdgeSlop;
        this.mBottomSlopEdge = ((float) metrics.heightPixels) - this.mEdgeSlop;
        float edgeSlop = this.mEdgeSlop;
        float rightSlop = this.mRightSlopEdge;
        float bottomSlop = this.mBottomSlopEdge;
        float x0 = event.getRawX();
        float y0 = event.getRawY();
        float x1 = getRawX(event, 1);
        float y1 = getRawY(event, 1);
        if (x0 < edgeSlop || y0 < edgeSlop || x0 > rightSlop || y0 > bottomSlop) {
            p0sloppy = true;
        } else {
            p0sloppy = false;
        }
        if (x1 < edgeSlop || y1 < edgeSlop || x1 > rightSlop || y1 > bottomSlop) {
            p1sloppy = true;
        } else {
            p1sloppy = false;
        }
        if ((!p0sloppy || !p1sloppy) && !p0sloppy && !p1sloppy) {
            return false;
        }
        return true;
    }
}
