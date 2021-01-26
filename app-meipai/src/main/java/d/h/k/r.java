package d.h.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import d.b.k.o;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public final class r {

    /* renamed from: a reason: collision with root package name */
    public WeakReference<View> f4940a;

    /* renamed from: b reason: collision with root package name */
    public Runnable f4941b = null;

    /* renamed from: c reason: collision with root package name */
    public Runnable f4942c = null;

    /* renamed from: d reason: collision with root package name */
    public int f4943d = -1;

    /* compiled from: ViewPropertyAnimatorCompat */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ s f4944a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ View f4945b;

        public a(r rVar, s sVar, View view) {
            this.f4944a = sVar;
            this.f4945b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f4944a.a(this.f4945b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f4944a.b(this.f4945b);
        }

        public void onAnimationStart(Animator animator) {
            this.f4944a.c(this.f4945b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    public class b implements AnimatorUpdateListener {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ u f4946a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ View f4947b;

        public b(r rVar, u uVar, View view) {
            this.f4946a = uVar;
            this.f4947b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) o.this.f4048f.getParent()).invalidate();
        }
    }

    public r(View view) {
        this.f4940a = new WeakReference<>(view);
    }

    public r a(long j2) {
        View view = (View) this.f4940a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public r b(float f2) {
        View view = (View) this.f4940a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public r a(float f2) {
        View view = (View) this.f4940a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void a() {
        View view = (View) this.f4940a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public r a(s sVar) {
        View view = (View) this.f4940a.get();
        if (view != null) {
            a(view, sVar);
        }
        return this;
    }

    public final void a(View view, s sVar) {
        if (sVar != null) {
            view.animate().setListener(new a(this, sVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public r a(u uVar) {
        View view = (View) this.f4940a.get();
        if (view != null) {
            b bVar = null;
            if (uVar != null) {
                bVar = new b(this, uVar, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }
}
