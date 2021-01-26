package d.h.k;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: OneShotPreDrawListener */
public final class l implements OnPreDrawListener, OnAttachStateChangeListener {

    /* renamed from: a reason: collision with root package name */
    public final View f4924a;

    /* renamed from: b reason: collision with root package name */
    public ViewTreeObserver f4925b;

    /* renamed from: c reason: collision with root package name */
    public final Runnable f4926c;

    public l(View view, Runnable runnable) {
        this.f4924a = view;
        this.f4925b = view.getViewTreeObserver();
        this.f4926c = runnable;
    }

    public static l a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            l lVar = new l(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(lVar);
            view.addOnAttachStateChangeListener(lVar);
            return lVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        a();
        this.f4926c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f4925b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f4925b.isAlive()) {
            this.f4925b.removeOnPreDrawListener(this);
        } else {
            this.f4924a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4924a.removeOnAttachStateChangeListener(this);
    }
}
