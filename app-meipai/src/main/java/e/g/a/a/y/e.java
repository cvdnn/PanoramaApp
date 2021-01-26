package e.g.a.a.y;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.h.k.m;
import e.c.f.n.n;
import e.g.a.a.e0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FloatingActionButtonImpl */
public class e {
    public static final TimeInterpolator A = e.g.a.a.l.a.f8219c;
    public static final int[] B = {16842919, 16842910};
    public static final int[] C = {16843623, 16842908, 16842910};
    public static final int[] D = {16842908, 16842910};
    public static final int[] E = {16843623, 16842910};
    public static final int[] F = {16842910};
    public static final int[] G = new int[0];

    /* renamed from: a reason: collision with root package name */
    public j f8412a;

    /* renamed from: b reason: collision with root package name */
    public e.g.a.a.e0.g f8413b;

    /* renamed from: c reason: collision with root package name */
    public boolean f8414c;

    /* renamed from: d reason: collision with root package name */
    public boolean f8415d = true;

    /* renamed from: e reason: collision with root package name */
    public float f8416e;

    /* renamed from: f reason: collision with root package name */
    public float f8417f;

    /* renamed from: g reason: collision with root package name */
    public float f8418g;

    /* renamed from: h reason: collision with root package name */
    public final e.g.a.a.z.f f8419h;

    /* renamed from: i reason: collision with root package name */
    public e.g.a.a.l.g f8420i;

    /* renamed from: j reason: collision with root package name */
    public e.g.a.a.l.g f8421j;
    public Animator k;
    public e.g.a.a.l.g l;
    public e.g.a.a.l.g m;
    public float n;
    public float o = 1.0f;
    public int p = 0;
    public ArrayList<AnimatorListener> q;
    public ArrayList<AnimatorListener> r;
    public ArrayList<C0114e> s;
    public final FloatingActionButton t;
    public final e.g.a.a.d0.b u;
    public final Rect v = new Rect();
    public final RectF w = new RectF();
    public final RectF x = new RectF();
    public final Matrix y = new Matrix();
    public OnPreDrawListener z;

    /* compiled from: FloatingActionButtonImpl */
    public class a extends e.g.a.a.l.f {
        public a() {
        }

        public Object evaluate(float f2, Object obj, Object obj2) {
            Matrix matrix = (Matrix) obj;
            Matrix matrix2 = (Matrix) obj2;
            e.this.o = f2;
            matrix.getValues(this.f8227a);
            matrix2.getValues(this.f8228b);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f8228b;
                float f3 = fArr[i2];
                float[] fArr2 = this.f8227a;
                fArr[i2] = ((f3 - fArr2[i2]) * f2) + fArr2[i2];
            }
            this.f8229c.setValues(this.f8228b);
            return this.f8229c;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    public class b extends h {
        public b(e eVar) {
            super(null);
        }

        public float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    public class c extends h {
        public c() {
            super(null);
        }

        public float a() {
            e eVar = e.this;
            return eVar.f8416e + eVar.f8417f;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    public class d extends h {
        public d() {
            super(null);
        }

        public float a() {
            e eVar = e.this;
            return eVar.f8416e + eVar.f8418g;
        }
    }

    /* renamed from: e.g.a.a.y.e$e reason: collision with other inner class name */
    /* compiled from: FloatingActionButtonImpl */
    public interface C0114e {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl */
    public interface f {
    }

    /* compiled from: FloatingActionButtonImpl */
    public class g extends h {
        public g() {
            super(null);
        }

        public float a() {
            return e.this.f8416e;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    public abstract class h extends AnimatorListenerAdapter implements AnimatorUpdateListener {

        /* renamed from: a reason: collision with root package name */
        public boolean f8426a;

        /* renamed from: b reason: collision with root package name */
        public float f8427b;

        /* renamed from: c reason: collision with root package name */
        public float f8428c;

        public /* synthetic */ h(c cVar) {
        }

        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            if (e.this != null) {
                this.f8426a = false;
                return;
            }
            throw null;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            if (!this.f8426a) {
                e.g.a.a.e0.g gVar = e.this.f8413b;
                if (gVar == null) {
                    f2 = 0.0f;
                } else {
                    f2 = gVar.f8072a.o;
                }
                this.f8427b = f2;
                this.f8428c = a();
                this.f8426a = true;
            }
            e eVar = e.this;
            valueAnimator.getAnimatedFraction();
            if (eVar == null) {
                throw null;
            }
        }
    }

    public e(FloatingActionButton floatingActionButton, e.g.a.a.d0.b bVar) {
        this.t = floatingActionButton;
        this.u = bVar;
        e.g.a.a.z.f fVar = new e.g.a.a.z.f();
        this.f8419h = fVar;
        fVar.a(B, a((h) new d()));
        this.f8419h.a(C, a((h) new c()));
        this.f8419h.a(D, a((h) new c()));
        this.f8419h.a(E, a((h) new c()));
        this.f8419h.a(F, a((h) new g()));
        this.f8419h.a(G, a((h) new b(this)));
        this.n = this.t.getRotation();
    }

    public float a() {
        throw null;
    }

    public final void a(float f2) {
        this.o = f2;
        Matrix matrix = this.y;
        matrix.reset();
        this.t.getDrawable();
        this.t.setImageMatrix(matrix);
    }

    public void a(float f2, float f3, float f4) {
        throw null;
    }

    public void a(ColorStateList colorStateList) {
        throw null;
    }

    public void a(int[] iArr) {
        throw null;
    }

    public boolean b() {
        boolean z2 = false;
        if (this.t.getVisibility() == 0) {
            if (this.p == 1) {
                z2 = true;
            }
            return z2;
        }
        if (this.p != 2) {
            z2 = true;
        }
        return z2;
    }

    public boolean c() {
        boolean z2 = false;
        if (this.t.getVisibility() != 0) {
            if (this.p == 2) {
                z2 = true;
            }
            return z2;
        }
        if (this.p != 1) {
            z2 = true;
        }
        return z2;
    }

    public void d() {
        throw null;
    }

    public void e() {
        throw null;
    }

    public void f() {
        ArrayList<C0114e> arrayList = this.s;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C0114e) it.next()).b();
            }
        }
    }

    public void g() {
        ArrayList<C0114e> arrayList = this.s;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C0114e) it.next()).a();
            }
        }
    }

    public boolean h() {
        throw null;
    }

    public boolean i() {
        throw null;
    }

    public final boolean j() {
        return m.z(this.t) && !this.t.isInEditMode();
    }

    public final boolean k() {
        return !this.f8414c || this.t.getSizeDimension() >= 0;
    }

    public void l() {
        throw null;
    }

    public final void m() {
        Rect rect = this.v;
        a(rect);
        a.a.a.a.b.a.a(null, (Object) "Didn't initialize content background");
        if (i()) {
            InsetDrawable insetDrawable = new InsetDrawable(null, rect.left, rect.top, rect.right, rect.bottom);
            com.google.android.material.floatingactionbutton.FloatingActionButton.b bVar = (com.google.android.material.floatingactionbutton.FloatingActionButton.b) this.u;
            if (bVar != null) {
                e.super.setBackgroundDrawable(insetDrawable);
            } else {
                throw null;
            }
        } else if (((com.google.android.material.floatingactionbutton.FloatingActionButton.b) this.u) == null) {
            throw null;
        }
        e.g.a.a.d0.b bVar2 = this.u;
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        com.google.android.material.floatingactionbutton.FloatingActionButton.b bVar3 = (com.google.android.material.floatingactionbutton.FloatingActionButton.b) bVar2;
        FloatingActionButton.this.k.set(i2, i3, i4, i5);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i6 = floatingActionButton.f3397i;
        floatingActionButton.setPadding(i2 + i6, i3 + i6, i4 + i6, i5 + i6);
    }

    public final AnimatorSet a(e.g.a.a.l.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.t, View.ALPHA, new float[]{f2});
        gVar.a("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t, View.SCALE_X, new float[]{f3});
        String str = "scale";
        gVar.a(str).a(ofFloat2);
        if (VERSION.SDK_INT == 26) {
            ofFloat2.setEvaluator(new f(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.t, View.SCALE_Y, new float[]{f3});
        gVar.a(str).a(ofFloat3);
        if (VERSION.SDK_INT == 26) {
            ofFloat3.setEvaluator(new f(this));
        }
        arrayList.add(ofFloat3);
        this.y.reset();
        this.t.getDrawable();
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.t, new e.g.a.a.l.e(), new a(), new Matrix[]{new Matrix(this.y)});
        gVar.a("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        n.a(animatorSet, (List<Animator>) arrayList);
        return animatorSet;
    }

    public void a(Rect rect) {
        int i2 = 0;
        if (this.f8414c) {
            i2 = (0 - this.t.getSizeDimension()) / 2;
        }
        float a2 = this.f8415d ? a() + this.f8418g : 0.0f;
        int max = Math.max(i2, (int) Math.ceil((double) a2));
        int max2 = Math.max(i2, (int) Math.ceil((double) (a2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public final ValueAnimator a(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(A);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }
}
