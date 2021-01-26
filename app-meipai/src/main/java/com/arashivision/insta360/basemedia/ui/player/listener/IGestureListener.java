package com.arashivision.insta360.basemedia.ui.player.listener;

import android.view.MotionEvent;

public interface IGestureListener {
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
