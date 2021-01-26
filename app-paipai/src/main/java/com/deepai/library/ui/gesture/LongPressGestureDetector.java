package com.deepai.library.ui.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.view.ViewConfiguration;

public class LongPressGestureDetector {
    private Runnable callback = new Runnable() {
        public void run() {
            if (LongPressGestureDetector.this.pressing) {
                LongPressGestureDetector.this.listener.onLongPressBegin(LongPressGestureDetector.this);
            }
        }
    };
    private int delay;
    private float downX;
    private float downY;
    private Handler handler = new Handler();
    /* access modifiers changed from: private */
    public OnLongPressGestureListener listener;
    /* access modifiers changed from: private */
    public boolean pressing;
    private int slop;

    public interface OnLongPressGestureListener {
        void onLongPressBegin(LongPressGestureDetector longPressGestureDetector);

        void onLongPressEnd(LongPressGestureDetector longPressGestureDetector);
    }

    public LongPressGestureDetector(Context context, OnLongPressGestureListener listener2) {
        this.listener = listener2;
        ViewConfiguration vc = ViewConfiguration.get(context);
        this.delay = ViewConfiguration.getLongPressTimeout();
        this.slop = vc.getScaledTouchSlop() * 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
        if (r1 < ((float) r7.slop)) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r6 = 1
            int r2 = r8.getActionMasked()
            switch(r2) {
                case 0: goto L_0x001c;
                case 1: goto L_0x0008;
                case 2: goto L_0x0035;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r2 = r7.pressing
            if (r2 == 0) goto L_0x0011
            com.deepai.library.ui.gesture.LongPressGestureDetector$OnLongPressGestureListener r2 = r7.listener
            r2.onLongPressEnd(r7)
        L_0x0011:
            r2 = 0
            r7.pressing = r2
            android.os.Handler r2 = r7.handler
            java.lang.Runnable r3 = r7.callback
            r2.removeCallbacks(r3)
        L_0x001b:
            return r6
        L_0x001c:
            r7.pressing = r6
            float r2 = r8.getX()
            r7.downX = r2
            float r2 = r8.getY()
            r7.downY = r2
            android.os.Handler r2 = r7.handler
            java.lang.Runnable r3 = r7.callback
            int r4 = r7.delay
            long r4 = (long) r4
            r2.postDelayed(r3, r4)
            goto L_0x001b
        L_0x0035:
            float r2 = r8.getX()
            float r3 = r7.downX
            float r2 = r2 - r3
            float r0 = java.lang.Math.abs(r2)
            float r2 = r8.getY()
            float r3 = r7.downY
            float r2 = r2 - r3
            float r1 = java.lang.Math.abs(r2)
            int r2 = r7.slop
            float r2 = (float) r2
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0008
            int r2 = r7.slop
            float r2 = (float) r2
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0008
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepai.library.ui.gesture.LongPressGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public PointF getPointF() {
        return new PointF(this.downX, this.downY);
    }
}
