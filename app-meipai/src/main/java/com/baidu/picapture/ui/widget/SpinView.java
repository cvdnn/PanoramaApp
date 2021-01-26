package com.baidu.picapture.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import e.c.b.e.Utils;
import e.c.d.m.i.c;
import e.c.d.m.i.d;
import e.c.d.m.i.j.k;
import e.c.f.n.n;
import e.d.a.j;
import e.d.a.n.f;
import e.d.a.o.l;
import java.io.File;
import java.util.Collection;
import java.util.Map;

public class SpinView extends k {

    /* renamed from: j reason: collision with root package name */
    public static final float f2007j = ((float) Utils.b(10.0f));

    /* renamed from: c reason: collision with root package name */
    public e.c.d.d.f.b<b> f2008c;

    /* renamed from: d reason: collision with root package name */
    public e.c.d.d.f.b<a> f2009d;

    /* renamed from: e reason: collision with root package name */
    public float f2010e = 0.0f;

    /* renamed from: f reason: collision with root package name */
    public int f2011f = 0;

    /* renamed from: g reason: collision with root package name */
    public File[] f2012g;

    /* renamed from: h reason: collision with root package name */
    public int f2013h = 0;

    /* renamed from: i reason: collision with root package name */
    public boolean f2014i = true;

    public interface a {
        void a(int i2);
    }

    public interface b {
        void onChange(float f2);
    }

    public SpinView(Context context) {
        super(context);
        c();
    }

    public /* synthetic */ void a(RectF rectF) {
        float scale = getScale();
        if (((double) scale) <= 1.001d) {
            this.f2014i = true;
        } else {
            this.f2014i = false;
        }
        this.f2008c.c(new e.c.d.m.i.b(scale));
    }

    public /* synthetic */ void b(a aVar) {
        aVar.a(this.f2011f);
    }

    public final void c() {
        this.f2008c = new e.c.d.d.f.b<>();
        this.f2009d = new e.c.d.d.f.b<>();
        setOnMatrixChangeListener(new d(this));
        setOnPhotoTouchListener(new c(this));
    }

    public final void d() {
        j jVar;
        l b2 = e.d.a.b.b(getContext());
        if (b2 != null) {
            if (e.d.a.t.j.b()) {
                jVar = b2.a(getContext().getApplicationContext());
            } else {
                n.a(this, "Argument must not be null");
                n.a(getContext(), "Unable to obtain a request manager for a view without a Context");
                Activity c2 = l.c(getContext());
                if (c2 == null) {
                    jVar = b2.a(getContext().getApplicationContext());
                } else if (c2 instanceof d.n.a.d) {
                    d.n.a.d dVar = (d.n.a.d) c2;
                    b2.f7824f.clear();
                    l.a((Collection<Fragment>) dVar.b0().a(), (Map<View, Fragment>) b2.f7824f);
                    View findViewById = dVar.findViewById(16908290);
                    Fragment fragment = null;
                    for (View view = this; !view.equals(findViewById); view = (View) view.getParent()) {
                        fragment = (Fragment) b2.f7824f.getOrDefault(view, null);
                        if (fragment != null || !(view.getParent() instanceof View)) {
                            break;
                        }
                    }
                    b2.f7824f.clear();
                    if (fragment != null) {
                        n.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
                        if (e.d.a.t.j.b()) {
                            jVar = b2.a(fragment.getContext().getApplicationContext());
                        } else {
                            jVar = b2.a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
                        }
                    } else {
                        jVar = b2.a(dVar);
                    }
                } else {
                    b2.f7825g.clear();
                    b2.a(c2.getFragmentManager(), b2.f7825g);
                    View findViewById2 = c2.findViewById(16908290);
                    android.app.Fragment fragment2 = null;
                    for (View view2 = this; !view2.equals(findViewById2); view2 = (View) view2.getParent()) {
                        fragment2 = (android.app.Fragment) b2.f7825g.getOrDefault(view2, null);
                        if (fragment2 != null || !(view2.getParent() instanceof View)) {
                            break;
                        }
                    }
                    b2.f7825g.clear();
                    if (fragment2 == null) {
                        jVar = b2.a(c2);
                    } else if (fragment2.getActivity() == null) {
                        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
                    } else if (!e.d.a.t.j.b()) {
                        jVar = b2.a((Context) fragment2.getActivity(), fragment2.getChildFragmentManager(), fragment2, fragment2.isVisible());
                    } else {
                        jVar = b2.a(fragment2.getActivity().getApplicationContext());
                    }
                }
            }
            e.d.a.i iVar = (e.d.a.i) ((e.d.a.i) jVar.a(this.f2012g[this.f2011f]).a((f) new e.d.a.s.b(Long.valueOf(this.f2012g[this.f2011f].lastModified())))).a(getDrawable());
            if (iVar != null) {
                e.d.a.r.a b3 = iVar.b(e.d.a.n.p.c.l.f7686b, (e.d.a.n.l<Bitmap>) new e.d.a.n.p.c.j<Bitmap>());
                b3.y = true;
                ((e.d.a.i) b3).a((ImageView) this);
                return;
            }
            throw null;
        }
        throw null;
    }

    public void setImages(File[] fileArr) {
        this.f2012g = fileArr;
        this.f2011f = 0;
        if (fileArr != null && fileArr.length > 0) {
            d();
        }
    }

    public /* synthetic */ void a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (motionEvent.getAction() == 0) {
            this.f2010e = motionEvent.getX();
            return;
        }
        int i2 = action & 255;
        if (i2 == 5) {
            this.f2013h++;
        } else if (i2 == 6) {
            this.f2013h--;
        } else if (motionEvent.getAction() == 2 && this.f2013h <= 0 && this.f2014i) {
            float x = motionEvent.getX();
            if (Math.abs(x - this.f2010e) > f2007j) {
                if (x > this.f2010e) {
                    int i3 = this.f2011f + 1;
                    this.f2011f = i3;
                    if (i3 >= this.f2012g.length) {
                        this.f2011f = 0;
                    }
                    d();
                    this.f2009d.observable(new e.c.d.m.i.a(this));
                } else {
                    int i4 = this.f2011f - 1;
                    this.f2011f = i4;
                    if (i4 < 0) {
                        this.f2011f = this.f2012g.length - 1;
                    }
                    d();
                    this.f2009d.observable(new e.c.d.m.i.f(this));
                }
                this.f2010e = x;
            }
        }
    }

    public SpinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public SpinView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    public /* synthetic */ void a(a aVar) {
        aVar.a(this.f2011f);
    }
}
