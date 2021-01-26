package com.baidu.sapi2.utils;

import android.app.Activity;
import android.view.View;

/* compiled from: SoftKeyBoardListener */
public class p {

    /* renamed from: a reason: collision with root package name */
    public View f3110a;

    /* renamed from: b reason: collision with root package name */
    public int f3111b;

    /* renamed from: c reason: collision with root package name */
    public a f3112c;

    /* compiled from: SoftKeyBoardListener */
    public interface a {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    public p(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f3110a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
    }

    private void a(a aVar) {
        this.f3112c = aVar;
    }

    public static void a(Activity activity, a aVar) {
        new p(activity).a(aVar);
    }
}
