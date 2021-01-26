package d.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import d.h.k.m;
import d.t.i.d;

/* compiled from: Fade */
public class c extends d0 {

    /* compiled from: Fade */
    public class a extends l {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ View f5454a;

        public a(c cVar, View view) {
            this.f5454a = view;
        }

        public void c(i iVar) {
            v.f5520a.a(this.f5454a, 1.0f);
            v.f5520a.a(this.f5454a);
            iVar.b((d) this);
        }
    }

    /* compiled from: Fade */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        public final View f5455a;

        /* renamed from: b reason: collision with root package name */
        public boolean f5456b = false;

        public b(View view) {
            this.f5455a = view;
        }

        public void onAnimationEnd(Animator animator) {
            v.f5520a.a(this.f5455a, 1.0f);
            if (this.f5456b) {
                this.f5455a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (m.w(this.f5455a) && this.f5455a.getLayerType() == 0) {
                this.f5456b = true;
                this.f5455a.setLayerType(2, null);
            }
        }
    }

    public c(int i2) {
        if ((i2 & -4) == 0) {
            this.I = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public final Animator a(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        v.f5520a.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, v.f5521b, new float[]{f3});
        ofFloat.addListener(new b(view));
        a((d) new a(this, view));
        return ofFloat;
    }

    public void c(q qVar) {
        d(qVar);
        qVar.f5511a.put("android:fade:transitionAlpha", Float.valueOf(v.b(qVar.f5512b)));
    }

    public Animator a(ViewGroup viewGroup, View view, q qVar, q qVar2) {
        float f2;
        v.f5520a.c(view);
        if (qVar != null) {
            Float f3 = (Float) qVar.f5511a.get("android:fade:transitionAlpha");
            if (f3 != null) {
                f2 = f3.floatValue();
                return a(view, f2, 0.0f);
            }
        }
        f2 = 1.0f;
        return a(view, f2, 0.0f);
    }
}
