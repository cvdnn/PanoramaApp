package com.arashivision.sdkmedia.player.listener;

import android.view.MotionEvent;

public interface PlayerGestureListener {
    boolean onDown(MotionEvent motionEvent);

    void onFlingAnimation();

    void onFlingAnimationEnd();

    void onLongPress(MotionEvent motionEvent);

    void onScroll();

    boolean onTap(MotionEvent motionEvent);

    void onUp();

    void onZoom();

    void onZoomAnimation();

    void onZoomAnimationEnd();
}
