package e.g.a.a.t;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import e.c.f.n.n;

/* compiled from: CircularRevealWidget */
public interface c {

    /* compiled from: CircularRevealWidget */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b reason: collision with root package name */
        public static final TypeEvaluator<e> f8307b = new b();

        /* renamed from: a reason: collision with root package name */
        public final e f8308a = new e(null);

        public Object evaluate(float f2, Object obj, Object obj2) {
            e eVar = (e) obj;
            e eVar2 = (e) obj2;
            e eVar3 = this.f8308a;
            float a2 = n.a(eVar.f8311a, eVar2.f8311a, f2);
            float a3 = n.a(eVar.f8312b, eVar2.f8312b, f2);
            float a4 = n.a(eVar.f8313c, eVar2.f8313c, f2);
            eVar3.f8311a = a2;
            eVar3.f8312b = a3;
            eVar3.f8313c = a4;
            return this.f8308a;
        }
    }

    /* renamed from: e.g.a.a.t.c$c reason: collision with other inner class name */
    /* compiled from: CircularRevealWidget */
    public static class C0111c extends Property<c, e> {

        /* renamed from: a reason: collision with root package name */
        public static final Property<c, e> f8309a = new C0111c("circularReveal");

        public C0111c(String str) {
            super(e.class, str);
        }

        public Object get(Object obj) {
            return ((c) obj).getRevealInfo();
        }

        public void set(Object obj, Object obj2) {
            ((c) obj).setRevealInfo((e) obj2);
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class d extends Property<c, Integer> {

        /* renamed from: a reason: collision with root package name */
        public static final Property<c, Integer> f8310a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        public Object get(Object obj) {
            return Integer.valueOf(((c) obj).getCircularRevealScrimColor());
        }

        public void set(Object obj, Object obj2) {
            ((c) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class e {

        /* renamed from: a reason: collision with root package name */
        public float f8311a;

        /* renamed from: b reason: collision with root package name */
        public float f8312b;

        /* renamed from: c reason: collision with root package name */
        public float f8313c;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
        }

        public e(float f2, float f3, float f4) {
            this.f8311a = f2;
            this.f8312b = f3;
            this.f8313c = f4;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(e eVar);
}
