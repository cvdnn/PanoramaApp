package com.baidu.sapi2.views;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ViewUtility */
public class s implements OnTouchListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ float f3246a;

    public s(float f2) {
        this.f3246a = f2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(this.f3246a);
        } else if (action == 1) {
            view.setAlpha(1.0f);
        } else if (action == 3) {
            view.setAlpha(1.0f);
        }
        return false;
    }
}
