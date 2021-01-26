package e.g.a.a.f0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import d.h.k.m;
import e.g.a.a.k;
import e.g.a.a.z.h;

/* compiled from: BaseTransientBottomBar */
public class d extends FrameLayout {

    /* renamed from: f reason: collision with root package name */
    public static final OnTouchListener f8147f = new a();

    /* renamed from: a reason: collision with root package name */
    public c f8148a;

    /* renamed from: b reason: collision with root package name */
    public b f8149b;

    /* renamed from: c reason: collision with root package name */
    public int f8150c;

    /* renamed from: d reason: collision with root package name */
    public final float f8151d;

    /* renamed from: e reason: collision with root package name */
    public final float f8152e;

    /* compiled from: BaseTransientBottomBar */
    public static class a implements OnTouchListener {
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public d(Context context) {
        this(context, null);
    }

    public float getActionTextColorAlpha() {
        return this.f8152e;
    }

    public int getAnimationMode() {
        return this.f8150c;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f8151d;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f8149b;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        m.E(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f8149b;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        c cVar = this.f8148a;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setAnimationMode(int i2) {
        this.f8150c = i2;
    }

    public void setOnAttachStateChangeListener(b bVar) {
        this.f8149b = bVar;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f8147f);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(c cVar) {
        this.f8148a = cVar;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(h.b(context, attributeSet, 0, 0), attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(k.SnackbarLayout_elevation)) {
            m.a((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_elevation, 0));
        }
        this.f8150c = obtainStyledAttributes.getInt(k.SnackbarLayout_animationMode, 0);
        this.f8151d = obtainStyledAttributes.getFloat(k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        this.f8152e = obtainStyledAttributes.getFloat(k.SnackbarLayout_actionTextColorAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f8147f);
        setFocusable(true);
    }
}
