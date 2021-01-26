package com.deepai.library.ui.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class ClickGestureDetector {
    private Runnable callback = new Runnable() {
        public void run() {
            if (ClickGestureDetector.this.pressing) {
                ClickGestureDetector.this.pressing = false;
            }
        }
    };
    private int delay;
    private Handler handler = new Handler();
    private float mDownX;
    private float mDownY;
    private OnClickGestureListener mListener;
    /* access modifiers changed from: private */
    public boolean pressing;
    private int slop;

    public interface OnClickGestureListener {
        void onSingleClick(ClickGestureDetector clickGestureDetector);
    }

    public ClickGestureDetector(Context context, OnClickGestureListener listener) {
        this.mListener = listener;
        ViewConfiguration vc = ViewConfiguration.get(context);
        this.delay = ViewConfiguration.getTapTimeout();
        this.slop = vc.getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent event) {
        checkSingleClick(event);
        return true;
    }

    private void checkSingleClick(MotionEvent event) {
        switch (event.getActionMasked()) {
            case 0:
                this.pressing = true;
                this.mDownX = event.getX();
                this.mDownY = event.getY();
                this.handler.postDelayed(this.callback, (long) this.delay);
                return;
            case 2:
                float deltaX = Math.abs(event.getX() - this.mDownX);
                float deltaY = Math.abs(event.getY() - this.mDownY);
                if (deltaX >= ((float) this.slop) || deltaY >= ((float) this.slop)) {
                    this.pressing = false;
                    break;
                } else {
                    return;
                }
                break;
        }
        if (this.pressing) {
            this.mListener.onSingleClick(this);
            this.pressing = false;
        }
        this.handler.removeCallbacks(this.callback);
    }

    public PointF getPointF() {
        return new PointF(this.mDownX, this.mDownY);
    }
}
