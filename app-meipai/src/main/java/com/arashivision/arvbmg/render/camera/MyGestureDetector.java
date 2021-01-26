package com.arashivision.arvbmg.render.camera;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class MyGestureDetector {
    public static final int DOUBLE_TAP_MIN_TIME = 40;
    public static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    public static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    public static final int LONG_PRESS = 2;
    public static final int SHOW_PRESS = 1;
    public static final int TAP = 3;
    public static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    public boolean mAlwaysInBiggerTapRegion;
    public boolean mAlwaysInTapRegion;
    public OnContextClickListener mContextClickListener;
    public MotionEvent mCurrentDownEvent;
    public boolean mDeferConfirmSingleTap;
    public OnDoubleTapListener mDoubleTapListener;
    public int mDoubleTapSlopSquare;
    public int mDoubleTapTouchSlopSquare;
    public float mDownFocusX;
    public float mDownFocusY;
    public final Handler mHandler;
    public boolean mIgnoreNextUpEvent;
    public boolean mInContextClick;
    public boolean mInLongPress;
    public boolean mIsDoubleTapping;
    public boolean mIsLongpressEnabled;
    public boolean mIsPivotMode;
    public float mLastFocusX;
    public float mLastFocusY;
    public final OnGestureListener mListener;
    public int mMaximumFlingVelocity;
    public int mMinimumFlingVelocity;
    public MotionEvent mPreviousUpEvent;
    public boolean mStillDown;
    public int mTouchSlopSquare;
    public VelocityTracker mVelocityTracker;

    public class GestureHandler extends Handler {
        public GestureHandler() {
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                MyGestureDetector.this.mListener.onShowPress(MyGestureDetector.this.mCurrentDownEvent);
            } else if (i2 == 2) {
                MyGestureDetector.this.dispatchLongPress();
            } else if (i2 != 3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown message ");
                sb.append(message);
                throw new RuntimeException(sb.toString());
            } else if (MyGestureDetector.this.mDoubleTapListener == null) {
            } else {
                if (!MyGestureDetector.this.mStillDown) {
                    MyGestureDetector.this.mDoubleTapListener.onSingleTapConfirmed(MyGestureDetector.this.mCurrentDownEvent);
                } else {
                    MyGestureDetector.this.mDeferConfirmSingleTap = true;
                }
            }
        }

        public GestureHandler(Handler handler) {
            super(handler.getLooper());
        }
    }

    public interface OnContextClickListener {
        boolean onContextClick(MotionEvent motionEvent);
    }

    public interface OnDoubleTapListener {
        boolean onDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    public interface OnGestureListener {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public static class SimpleOnGestureListener implements OnGestureListener, OnDoubleTapListener, OnContextClickListener {
        public boolean onContextClick(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    @Deprecated
    public MyGestureDetector(OnGestureListener onGestureListener, Handler handler) {
        this(null, onGestureListener, handler);
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = false;
        this.mInContextClick = false;
        this.mIgnoreNextUpEvent = false;
    }

    private void cancelTaps() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = false;
        this.mInContextClick = false;
        this.mIgnoreNextUpEvent = false;
    }

    /* access modifiers changed from: private */
    public void dispatchLongPress() {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = true;
        this.mListener.onLongPress(this.mCurrentDownEvent);
    }

    private void init(Context context) {
        int i2;
        int i3;
        if (this.mListener != null) {
            this.mIsLongpressEnabled = true;
            int i4 = 100;
            if (context == null) {
                i2 = ViewConfiguration.getTouchSlop();
                this.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                this.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                i3 = 100;
                i4 = i2;
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                i3 = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                i2 = scaledTouchSlop;
            }
            this.mTouchSlopSquare = i2 * i2;
            this.mDoubleTapTouchSlopSquare = i4 * i4;
            this.mDoubleTapSlopSquare = i3 * i3;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        int i2;
        boolean z = false;
        if (!this.mAlwaysInBiggerTapRegion) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime <= ((long) DOUBLE_TAP_TIMEOUT) && eventTime >= 40) {
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((motionEvent.getFlags() & 8) != 0) {
                i2 = 0;
            } else {
                i2 = this.mDoubleTapSlopSquare;
            }
            if ((y * y) + (x * x) < i2) {
                z = true;
            }
        }
        return z;
    }

    public boolean isLongpressEnabled() {
        return this.mIsLongpressEnabled;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int actionButton = motionEvent.getActionButton();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 11) {
            if (actionMasked == 12 && this.mInContextClick && (actionButton == 32 || actionButton == 2)) {
                this.mInContextClick = false;
                this.mIgnoreNextUpEvent = true;
            }
        } else if (this.mContextClickListener != null && !this.mInContextClick && !this.mInLongPress && ((actionButton == 32 || actionButton == 2) && this.mContextClickListener.onContextClick(motionEvent))) {
            this.mInContextClick = true;
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x023f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = r14.getAction()
            android.view.VelocityTracker r1 = r13.mVelocityTracker
            if (r1 != 0) goto L_0x000e
            android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
            r13.mVelocityTracker = r1
        L_0x000e:
            android.view.VelocityTracker r1 = r13.mVelocityTracker
            r1.addMovement(r14)
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 6
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x001c
            r4 = r2
            goto L_0x001d
        L_0x001c:
            r4 = r3
        L_0x001d:
            if (r4 == 0) goto L_0x0024
            int r5 = r14.getActionIndex()
            goto L_0x0025
        L_0x0024:
            r5 = -1
        L_0x0025:
            int r6 = r14.getFlags()
            r6 = r6 & 8
            if (r6 == 0) goto L_0x002f
            r6 = r2
            goto L_0x0030
        L_0x002f:
            r6 = r3
        L_0x0030:
            int r7 = r14.getPointerCount()
            r8 = 0
            r9 = r3
            r10 = r8
            r11 = r10
        L_0x0038:
            if (r9 >= r7) goto L_0x004a
            if (r5 != r9) goto L_0x003d
            goto L_0x0047
        L_0x003d:
            float r12 = r14.getX(r9)
            float r10 = r10 + r12
            float r12 = r14.getY(r9)
            float r11 = r11 + r12
        L_0x0047:
            int r9 = r9 + 1
            goto L_0x0038
        L_0x004a:
            if (r4 == 0) goto L_0x004f
            int r4 = r7 + -1
            goto L_0x0050
        L_0x004f:
            r4 = r7
        L_0x0050:
            float r4 = (float) r4
            float r10 = r10 / r4
            float r11 = r11 / r4
            r4 = 2
            r5 = 3
            if (r0 == 0) goto L_0x01df
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r0 == r2) goto L_0x0148
            if (r0 == r4) goto L_0x00c3
            if (r0 == r5) goto L_0x00be
            r2 = 5
            if (r0 == r2) goto L_0x00b1
            if (r0 == r1) goto L_0x0066
            goto L_0x026a
        L_0x0066:
            r13.mLastFocusX = r10
            r13.mDownFocusX = r10
            r13.mLastFocusY = r11
            r13.mDownFocusY = r11
            android.view.VelocityTracker r0 = r13.mVelocityTracker
            int r1 = r13.mMaximumFlingVelocity
            float r1 = (float) r1
            r0.computeCurrentVelocity(r9, r1)
            int r0 = r14.getActionIndex()
            int r1 = r14.getPointerId(r0)
            android.view.VelocityTracker r2 = r13.mVelocityTracker
            float r2 = r2.getXVelocity(r1)
            android.view.VelocityTracker r4 = r13.mVelocityTracker
            float r1 = r4.getYVelocity(r1)
            r4 = r3
        L_0x008b:
            if (r4 >= r7) goto L_0x026a
            if (r4 != r0) goto L_0x0090
            goto L_0x00ae
        L_0x0090:
            int r5 = r14.getPointerId(r4)
            android.view.VelocityTracker r6 = r13.mVelocityTracker
            float r6 = r6.getXVelocity(r5)
            float r6 = r6 * r2
            android.view.VelocityTracker r9 = r13.mVelocityTracker
            float r5 = r9.getYVelocity(r5)
            float r5 = r5 * r1
            float r5 = r5 + r6
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x00ae
            android.view.VelocityTracker r14 = r13.mVelocityTracker
            r14.clear()
            goto L_0x026a
        L_0x00ae:
            int r4 = r4 + 1
            goto L_0x008b
        L_0x00b1:
            r13.mLastFocusX = r10
            r13.mDownFocusX = r10
            r13.mLastFocusY = r11
            r13.mDownFocusY = r11
            r13.cancelTaps()
            goto L_0x026a
        L_0x00be:
            r13.cancel()
            goto L_0x026a
        L_0x00c3:
            boolean r0 = r13.mInLongPress
            if (r0 == 0) goto L_0x00cb
            boolean r0 = r13.mIsPivotMode
            if (r0 == 0) goto L_0x026a
        L_0x00cb:
            boolean r0 = r13.mInContextClick
            if (r0 == 0) goto L_0x00d1
            goto L_0x026a
        L_0x00d1:
            float r0 = r13.mLastFocusX
            float r0 = r0 - r10
            float r1 = r13.mLastFocusY
            float r1 = r1 - r11
            boolean r7 = r13.mIsDoubleTapping
            if (r7 == 0) goto L_0x00e4
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnDoubleTapListener r0 = r13.mDoubleTapListener
            boolean r14 = r0.onDoubleTapEvent(r14)
            r3 = r3 | r14
            goto L_0x026a
        L_0x00e4:
            boolean r7 = r13.mAlwaysInTapRegion
            if (r7 == 0) goto L_0x0128
            float r7 = r13.mDownFocusX
            float r7 = r10 - r7
            int r7 = (int) r7
            float r8 = r13.mDownFocusY
            float r8 = r11 - r8
            int r8 = (int) r8
            int r7 = r7 * r7
            int r8 = r8 * r8
            int r8 = r8 + r7
            if (r6 == 0) goto L_0x00f9
            r7 = r3
            goto L_0x00fb
        L_0x00f9:
            int r7 = r13.mTouchSlopSquare
        L_0x00fb:
            if (r8 <= r7) goto L_0x011b
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnGestureListener r7 = r13.mListener
            android.view.MotionEvent r9 = r13.mCurrentDownEvent
            boolean r14 = r7.onScroll(r9, r14, r0, r1)
            r13.mLastFocusX = r10
            r13.mLastFocusY = r11
            r13.mAlwaysInTapRegion = r3
            android.os.Handler r0 = r13.mHandler
            r0.removeMessages(r5)
            android.os.Handler r0 = r13.mHandler
            r0.removeMessages(r2)
            android.os.Handler r0 = r13.mHandler
            r0.removeMessages(r4)
            goto L_0x011c
        L_0x011b:
            r14 = r3
        L_0x011c:
            if (r6 == 0) goto L_0x0120
            r0 = r3
            goto L_0x0122
        L_0x0120:
            int r0 = r13.mDoubleTapTouchSlopSquare
        L_0x0122:
            if (r8 <= r0) goto L_0x01dc
            r13.mAlwaysInBiggerTapRegion = r3
            goto L_0x01dc
        L_0x0128:
            float r2 = java.lang.Math.abs(r0)
            r4 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x013a
            float r2 = java.lang.Math.abs(r1)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x026a
        L_0x013a:
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnGestureListener r2 = r13.mListener
            android.view.MotionEvent r3 = r13.mCurrentDownEvent
            boolean r3 = r2.onScroll(r3, r14, r0, r1)
            r13.mLastFocusX = r10
            r13.mLastFocusY = r11
            goto L_0x026a
        L_0x0148:
            r13.mStillDown = r3
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r14)
            boolean r1 = r13.mIsDoubleTapping
            if (r1 == 0) goto L_0x015a
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnDoubleTapListener r1 = r13.mDoubleTapListener
            boolean r14 = r1.onDoubleTapEvent(r14)
            r14 = r14 | r3
            goto L_0x01b9
        L_0x015a:
            boolean r1 = r13.mInLongPress
            if (r1 == 0) goto L_0x0166
            android.os.Handler r14 = r13.mHandler
            r14.removeMessages(r5)
            r13.mInLongPress = r3
            goto L_0x01b8
        L_0x0166:
            boolean r1 = r13.mAlwaysInTapRegion
            if (r1 == 0) goto L_0x0181
            boolean r1 = r13.mIgnoreNextUpEvent
            if (r1 != 0) goto L_0x0181
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnGestureListener r1 = r13.mListener
            boolean r1 = r1.onSingleTapUp(r14)
            boolean r5 = r13.mDeferConfirmSingleTap
            if (r5 == 0) goto L_0x017f
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnDoubleTapListener r5 = r13.mDoubleTapListener
            if (r5 == 0) goto L_0x017f
            r5.onSingleTapConfirmed(r14)
        L_0x017f:
            r14 = r1
            goto L_0x01b9
        L_0x0181:
            boolean r1 = r13.mIgnoreNextUpEvent
            if (r1 != 0) goto L_0x01b8
            android.view.VelocityTracker r1 = r13.mVelocityTracker
            int r5 = r14.getPointerId(r3)
            int r6 = r13.mMaximumFlingVelocity
            float r6 = (float) r6
            r1.computeCurrentVelocity(r9, r6)
            float r6 = r1.getYVelocity(r5)
            float r1 = r1.getXVelocity(r5)
            float r5 = java.lang.Math.abs(r6)
            int r7 = r13.mMinimumFlingVelocity
            float r7 = (float) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x01af
            float r5 = java.lang.Math.abs(r1)
            int r7 = r13.mMinimumFlingVelocity
            float r7 = (float) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b8
        L_0x01af:
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnGestureListener r5 = r13.mListener
            android.view.MotionEvent r7 = r13.mCurrentDownEvent
            boolean r14 = r5.onFling(r7, r14, r1, r6)
            goto L_0x01b9
        L_0x01b8:
            r14 = r3
        L_0x01b9:
            android.view.MotionEvent r1 = r13.mPreviousUpEvent
            if (r1 == 0) goto L_0x01c0
            r1.recycle()
        L_0x01c0:
            r13.mPreviousUpEvent = r0
            android.view.VelocityTracker r0 = r13.mVelocityTracker
            if (r0 == 0) goto L_0x01cc
            r0.recycle()
            r0 = 0
            r13.mVelocityTracker = r0
        L_0x01cc:
            r13.mIsDoubleTapping = r3
            r13.mDeferConfirmSingleTap = r3
            r13.mIgnoreNextUpEvent = r3
            android.os.Handler r0 = r13.mHandler
            r0.removeMessages(r2)
            android.os.Handler r0 = r13.mHandler
            r0.removeMessages(r4)
        L_0x01dc:
            r3 = r14
            goto L_0x026a
        L_0x01df:
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnDoubleTapListener r0 = r13.mDoubleTapListener
            if (r0 == 0) goto L_0x021b
            android.os.Handler r0 = r13.mHandler
            boolean r0 = r0.hasMessages(r5)
            if (r0 == 0) goto L_0x01f0
            android.os.Handler r1 = r13.mHandler
            r1.removeMessages(r5)
        L_0x01f0:
            android.view.MotionEvent r1 = r13.mCurrentDownEvent
            if (r1 == 0) goto L_0x0213
            android.view.MotionEvent r6 = r13.mPreviousUpEvent
            if (r6 == 0) goto L_0x0213
            if (r0 == 0) goto L_0x0213
            boolean r0 = r13.isConsideredDoubleTap(r1, r6, r14)
            if (r0 == 0) goto L_0x0213
            r13.mIsDoubleTapping = r2
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnDoubleTapListener r0 = r13.mDoubleTapListener
            android.view.MotionEvent r1 = r13.mCurrentDownEvent
            boolean r0 = r0.onDoubleTap(r1)
            r0 = r0 | r3
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnDoubleTapListener r1 = r13.mDoubleTapListener
            boolean r1 = r1.onDoubleTapEvent(r14)
            r0 = r0 | r1
            goto L_0x021c
        L_0x0213:
            android.os.Handler r0 = r13.mHandler
            int r1 = DOUBLE_TAP_TIMEOUT
            long r6 = (long) r1
            r0.sendEmptyMessageDelayed(r5, r6)
        L_0x021b:
            r0 = r3
        L_0x021c:
            r13.mLastFocusX = r10
            r13.mDownFocusX = r10
            r13.mLastFocusY = r11
            r13.mDownFocusY = r11
            android.view.MotionEvent r1 = r13.mCurrentDownEvent
            if (r1 == 0) goto L_0x022b
            r1.recycle()
        L_0x022b:
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
            r13.mCurrentDownEvent = r1
            r13.mAlwaysInTapRegion = r2
            r13.mAlwaysInBiggerTapRegion = r2
            r13.mStillDown = r2
            r13.mInLongPress = r3
            r13.mDeferConfirmSingleTap = r3
            boolean r1 = r13.mIsLongpressEnabled
            if (r1 == 0) goto L_0x0253
            android.os.Handler r1 = r13.mHandler
            r1.removeMessages(r4)
            android.os.Handler r1 = r13.mHandler
            android.view.MotionEvent r3 = r13.mCurrentDownEvent
            long r5 = r3.getDownTime()
            int r3 = LONGPRESS_TIMEOUT
            long r7 = (long) r3
            long r5 = r5 + r7
            r1.sendEmptyMessageAtTime(r4, r5)
        L_0x0253:
            android.os.Handler r1 = r13.mHandler
            android.view.MotionEvent r3 = r13.mCurrentDownEvent
            long r3 = r3.getDownTime()
            int r5 = TAP_TIMEOUT
            long r5 = (long) r5
            long r3 = r3 + r5
            r1.sendEmptyMessageAtTime(r2, r3)
            com.arashivision.arvbmg.render.camera.MyGestureDetector$OnGestureListener r1 = r13.mListener
            boolean r14 = r1.onDown(r14)
            r3 = r0 | r14
        L_0x026a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.render.camera.MyGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setContextClickListener(OnContextClickListener onContextClickListener) {
        this.mContextClickListener = onContextClickListener;
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mIsLongpressEnabled = z;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mDoubleTapListener = onDoubleTapListener;
    }

    public void setPivotMode(boolean z) {
        this.mIsPivotMode = z;
    }

    @Deprecated
    public MyGestureDetector(OnGestureListener onGestureListener) {
        this(null, onGestureListener, null);
    }

    public MyGestureDetector(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public MyGestureDetector(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.mIsPivotMode = false;
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        } else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
        }
        if (onGestureListener instanceof OnContextClickListener) {
            setContextClickListener((OnContextClickListener) onGestureListener);
        }
        init(context);
    }

    public MyGestureDetector(Context context, OnGestureListener onGestureListener, Handler handler, boolean z) {
        this(context, onGestureListener, handler);
    }
}
