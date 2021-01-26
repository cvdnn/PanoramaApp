package e.g.a.a.e0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import e.c.f.n.n;
import e.g.a.a.k;

/* compiled from: ShapeAppearanceModel */
public class j {

    /* renamed from: a reason: collision with root package name */
    public d f8095a;

    /* renamed from: b reason: collision with root package name */
    public d f8096b;

    /* renamed from: c reason: collision with root package name */
    public d f8097c;

    /* renamed from: d reason: collision with root package name */
    public d f8098d;

    /* renamed from: e reason: collision with root package name */
    public c f8099e;

    /* renamed from: f reason: collision with root package name */
    public c f8100f;

    /* renamed from: g reason: collision with root package name */
    public c f8101g;

    /* renamed from: h reason: collision with root package name */
    public c f8102h;

    /* renamed from: i reason: collision with root package name */
    public f f8103i;

    /* renamed from: j reason: collision with root package name */
    public f f8104j;
    public f k;
    public f l;

    /* compiled from: ShapeAppearanceModel */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        public d f8105a = new i();

        /* renamed from: b reason: collision with root package name */
        public d f8106b = new i();

        /* renamed from: c reason: collision with root package name */
        public d f8107c = new i();

        /* renamed from: d reason: collision with root package name */
        public d f8108d = new i();

        /* renamed from: e reason: collision with root package name */
        public c f8109e = new a(0.0f);

        /* renamed from: f reason: collision with root package name */
        public c f8110f = new a(0.0f);

        /* renamed from: g reason: collision with root package name */
        public c f8111g = new a(0.0f);

        /* renamed from: h reason: collision with root package name */
        public c f8112h = new a(0.0f);

        /* renamed from: i reason: collision with root package name */
        public f f8113i = new f();

        /* renamed from: j reason: collision with root package name */
        public f f8114j = new f();
        public f k = new f();
        public f l = new f();

        public b() {
        }

        public b a(float f2) {
            this.f8112h = new a(f2);
            return this;
        }

        public b b(float f2) {
            this.f8111g = new a(f2);
            return this;
        }

        public b c(float f2) {
            this.f8109e = new a(f2);
            return this;
        }

        public b d(float f2) {
            this.f8110f = new a(f2);
            return this;
        }

        public static float a(d dVar) {
            if (dVar instanceof i) {
                return ((i) dVar).f8094a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f8071a;
            }
            return -1.0f;
        }

        public j a() {
            return new j(this, null);
        }

        public b(j jVar) {
            this.f8105a = jVar.f8095a;
            this.f8106b = jVar.f8096b;
            this.f8107c = jVar.f8097c;
            this.f8108d = jVar.f8098d;
            this.f8109e = jVar.f8099e;
            this.f8110f = jVar.f8100f;
            this.f8111g = jVar.f8101g;
            this.f8112h = jVar.f8102h;
            this.f8113i = jVar.f8103i;
            this.f8114j = jVar.f8104j;
            this.k = jVar.k;
            this.l = jVar.l;
        }
    }

    public /* synthetic */ j(b bVar, a aVar) {
        this.f8095a = bVar.f8105a;
        this.f8096b = bVar.f8106b;
        this.f8097c = bVar.f8107c;
        this.f8098d = bVar.f8108d;
        this.f8099e = bVar.f8109e;
        this.f8100f = bVar.f8110f;
        this.f8101g = bVar.f8111g;
        this.f8102h = bVar.f8112h;
        this.f8103i = bVar.f8113i;
        this.f8104j = bVar.f8114j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a((float) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(k.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(k.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, (c) aVar);
    }

    public static b a(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            Context contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, k.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(k.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(k.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(k.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(k.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(k.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c a2 = a(obtainStyledAttributes, k.ShapeAppearance_cornerSize, cVar);
            c a3 = a(obtainStyledAttributes, k.ShapeAppearance_cornerSizeTopLeft, a2);
            c a4 = a(obtainStyledAttributes, k.ShapeAppearance_cornerSizeTopRight, a2);
            c a5 = a(obtainStyledAttributes, k.ShapeAppearance_cornerSizeBottomRight, a2);
            c a6 = a(obtainStyledAttributes, k.ShapeAppearance_cornerSizeBottomLeft, a2);
            b bVar = new b();
            d a7 = n.a(i5);
            bVar.f8105a = a7;
            float a8 = b.a(a7);
            if (a8 != -1.0f) {
                bVar.c(a8);
            }
            bVar.f8109e = a3;
            d a9 = n.a(i6);
            bVar.f8106b = a9;
            float a10 = b.a(a9);
            if (a10 != -1.0f) {
                bVar.d(a10);
            }
            bVar.f8110f = a4;
            d a11 = n.a(i7);
            bVar.f8107c = a11;
            float a12 = b.a(a11);
            if (a12 != -1.0f) {
                bVar.b(a12);
            }
            bVar.f8111g = a5;
            d a13 = n.a(i8);
            bVar.f8108d = a13;
            float a14 = b.a(a13);
            if (a14 != -1.0f) {
                bVar.a(a14);
            }
            bVar.f8112h = a6;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public j() {
        this.f8095a = new i();
        this.f8096b = new i();
        this.f8097c = new i();
        this.f8098d = new i();
        this.f8099e = new a(0.0f);
        this.f8100f = new a(0.0f);
        this.f8101g = new a(0.0f);
        this.f8102h = new a(0.0f);
        this.f8103i = new f();
        this.f8104j = new f();
        this.k = new f();
        this.l = new f();
    }

    public static c a(TypedArray typedArray, int i2, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cVar;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new h(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public j a(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        bVar.d(f2);
        bVar.b(f2);
        bVar.a(f2);
        return bVar.a();
    }

    public boolean a(RectF rectF) {
        Class<f> cls = f.class;
        boolean z = this.l.getClass().equals(cls) && this.f8104j.getClass().equals(cls) && this.f8103i.getClass().equals(cls) && this.k.getClass().equals(cls);
        float a2 = this.f8099e.a(rectF);
        boolean z2 = this.f8100f.a(rectF) == a2 && this.f8102h.a(rectF) == a2 && this.f8101g.a(rectF) == a2;
        boolean z3 = (this.f8096b instanceof i) && (this.f8095a instanceof i) && (this.f8097c instanceof i) && (this.f8098d instanceof i);
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }
}
