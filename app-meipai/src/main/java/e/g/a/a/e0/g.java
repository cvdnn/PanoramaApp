package e.g.a.a.e0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import e.c.f.n.n;
import e.g.a.a.e0.m.f;
import java.util.Objects;

/* compiled from: MaterialShapeDrawable */
public class g extends Drawable implements n {
    public static final Paint v = new Paint(1);

    /* renamed from: a reason: collision with root package name */
    public b f8072a;

    /* renamed from: b reason: collision with root package name */
    public final f[] f8073b;

    /* renamed from: c reason: collision with root package name */
    public final f[] f8074c;

    /* renamed from: d reason: collision with root package name */
    public boolean f8075d;

    /* renamed from: e reason: collision with root package name */
    public final Matrix f8076e;

    /* renamed from: f reason: collision with root package name */
    public final Path f8077f;

    /* renamed from: g reason: collision with root package name */
    public final Path f8078g;

    /* renamed from: h reason: collision with root package name */
    public final RectF f8079h;

    /* renamed from: i reason: collision with root package name */
    public final RectF f8080i;

    /* renamed from: j reason: collision with root package name */
    public final Region f8081j;
    public final Region k;
    public j l;
    public final Paint m;
    public final Paint n;
    public final e.g.a.a.d0.a o;
    public final e.g.a.a.e0.k.a p;
    public final k q;
    public PorterDuffColorFilter r;
    public PorterDuffColorFilter s;
    public Rect t;
    public final RectF u;

    /* compiled from: MaterialShapeDrawable */
    public class a implements e.g.a.a.e0.k.a {
        public a() {
        }
    }

    /* compiled from: MaterialShapeDrawable */
    public static final class b extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        public j f8083a;

        /* renamed from: b reason: collision with root package name */
        public e.g.a.a.w.a f8084b;

        /* renamed from: c reason: collision with root package name */
        public ColorFilter f8085c;

        /* renamed from: d reason: collision with root package name */
        public ColorStateList f8086d = null;

        /* renamed from: e reason: collision with root package name */
        public ColorStateList f8087e = null;

        /* renamed from: f reason: collision with root package name */
        public ColorStateList f8088f = null;

        /* renamed from: g reason: collision with root package name */
        public ColorStateList f8089g = null;

        /* renamed from: h reason: collision with root package name */
        public Mode f8090h = Mode.SRC_IN;

        /* renamed from: i reason: collision with root package name */
        public Rect f8091i = null;

        /* renamed from: j reason: collision with root package name */
        public float f8092j = 1.0f;
        public float k = 1.0f;
        public float l;
        public int m = 255;
        public float n = 0.0f;
        public float o = 0.0f;
        public float p = 0.0f;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Style v = Style.FILL_AND_STROKE;

        public b(j jVar, e.g.a.a.w.a aVar) {
            this.f8083a = jVar;
            this.f8084b = aVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f8075d = true;
            return gVar;
        }

        public b(b bVar) {
            this.f8083a = bVar.f8083a;
            this.f8084b = bVar.f8084b;
            this.l = bVar.l;
            this.f8085c = bVar.f8085c;
            this.f8086d = bVar.f8086d;
            this.f8087e = bVar.f8087e;
            this.f8090h = bVar.f8090h;
            this.f8089g = bVar.f8089g;
            this.m = bVar.m;
            this.f8092j = bVar.f8092j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.k = bVar.k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f8088f = bVar.f8088f;
            this.v = bVar.v;
            if (bVar.f8091i != null) {
                this.f8091i = new Rect(bVar.f8091i);
            }
        }
    }

    public g() {
        this(new j());
    }

    public static g a(Context context, float f2) {
        int a2 = n.a(context, e.g.a.a.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.f8072a.f8084b = new e.g.a.a.w.a(context);
        gVar.j();
        gVar.a(ColorStateList.valueOf(a2));
        b bVar = gVar.f8072a;
        if (bVar.o != f2) {
            bVar.o = f2;
            gVar.j();
        }
        return gVar;
    }

    public void b(ColorStateList colorStateList) {
        b bVar = this.f8072a;
        if (bVar.f8087e != colorStateList) {
            bVar.f8087e = colorStateList;
            onStateChange(getState());
        }
    }

    public final RectF c() {
        RectF b2 = b();
        float f2 = f();
        this.f8080i.set(b2.left + f2, b2.top + f2, b2.right - f2, b2.bottom - f2);
        return this.f8080i;
    }

    public int d() {
        b bVar = this.f8072a;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    /* JADX INFO: used method not loaded: e.g.a.a.e0.j.a(android.graphics.RectF):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00db, code lost:
        if ((!r2.f8083a.a(b()) && !r14.f8077f.isConvex()) != false) goto L_0x00dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r15) {
        /*
            r14 = this;
            android.graphics.Paint r0 = r14.m
            android.graphics.PorterDuffColorFilter r1 = r14.r
            r0.setColorFilter(r1)
            android.graphics.Paint r0 = r14.m
            int r0 = r0.getAlpha()
            android.graphics.Paint r1 = r14.m
            e.g.a.a.e0.g$b r2 = r14.f8072a
            int r2 = r2.m
            int r3 = r2 >>> 7
            int r2 = r2 + r3
            int r2 = r2 * r0
            int r2 = r2 >>> 8
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r14.n
            android.graphics.PorterDuffColorFilter r2 = r14.s
            r1.setColorFilter(r2)
            android.graphics.Paint r1 = r14.n
            e.g.a.a.e0.g$b r2 = r14.f8072a
            float r2 = r2.l
            r1.setStrokeWidth(r2)
            android.graphics.Paint r1 = r14.n
            int r1 = r1.getAlpha()
            android.graphics.Paint r2 = r14.n
            e.g.a.a.e0.g$b r3 = r14.f8072a
            int r3 = r3.m
            int r4 = r3 >>> 7
            int r3 = r3 + r4
            int r3 = r3 * r1
            int r3 = r3 >>> 8
            r2.setAlpha(r3)
            boolean r2 = r14.f8075d
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x00b6
            float r2 = r14.f()
            float r2 = -r2
            e.g.a.a.e0.g$b r5 = r14.f8072a
            e.g.a.a.e0.j r5 = r5.f8083a
            if (r5 == 0) goto L_0x00b5
            e.g.a.a.e0.j$b r6 = new e.g.a.a.e0.j$b
            r6.<init>(r5)
            e.g.a.a.e0.c r7 = r5.f8099e
            boolean r8 = r7 instanceof e.g.a.a.e0.h
            if (r8 == 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            e.g.a.a.e0.b r8 = new e.g.a.a.e0.b
            r8.<init>(r2, r7)
            r7 = r8
        L_0x0064:
            r6.f8109e = r7
            e.g.a.a.e0.c r7 = r5.f8100f
            boolean r8 = r7 instanceof e.g.a.a.e0.h
            if (r8 == 0) goto L_0x006d
            goto L_0x0073
        L_0x006d:
            e.g.a.a.e0.b r8 = new e.g.a.a.e0.b
            r8.<init>(r2, r7)
            r7 = r8
        L_0x0073:
            r6.f8110f = r7
            e.g.a.a.e0.c r7 = r5.f8102h
            boolean r8 = r7 instanceof e.g.a.a.e0.h
            if (r8 == 0) goto L_0x007c
            goto L_0x0082
        L_0x007c:
            e.g.a.a.e0.b r8 = new e.g.a.a.e0.b
            r8.<init>(r2, r7)
            r7 = r8
        L_0x0082:
            r6.f8112h = r7
            e.g.a.a.e0.c r5 = r5.f8101g
            boolean r7 = r5 instanceof e.g.a.a.e0.h
            if (r7 == 0) goto L_0x008b
            goto L_0x0091
        L_0x008b:
            e.g.a.a.e0.b r7 = new e.g.a.a.e0.b
            r7.<init>(r2, r5)
            r5 = r7
        L_0x0091:
            r6.f8111g = r5
            e.g.a.a.e0.j r8 = r6.a()
            r14.l = r8
            e.g.a.a.e0.k r7 = r14.q
            e.g.a.a.e0.g$b r2 = r14.f8072a
            float r9 = r2.k
            android.graphics.RectF r10 = r14.c()
            android.graphics.Path r12 = r14.f8078g
            r11 = 0
            r7.a(r8, r9, r10, r11, r12)
            android.graphics.RectF r2 = r14.b()
            android.graphics.Path r5 = r14.f8077f
            r14.a(r2, r5)
            r14.f8075d = r4
            goto L_0x00b6
        L_0x00b5:
            throw r3
        L_0x00b6:
            e.g.a.a.e0.g$b r2 = r14.f8072a
            int r5 = r2.q
            r6 = 2
            r7 = 1
            if (r5 == r7) goto L_0x00df
            int r8 = r2.r
            if (r8 <= 0) goto L_0x00df
            if (r5 == r6) goto L_0x00dd
            e.g.a.a.e0.j r2 = r2.f8083a
            android.graphics.RectF r5 = r14.b()
            boolean r2 = r2.a(r5)
            if (r2 != 0) goto L_0x00da
            android.graphics.Path r2 = r14.f8077f
            boolean r2 = r2.isConvex()
            if (r2 != 0) goto L_0x00da
            r2 = r7
            goto L_0x00db
        L_0x00da:
            r2 = r4
        L_0x00db:
            if (r2 == 0) goto L_0x00df
        L_0x00dd:
            r2 = r7
            goto L_0x00e0
        L_0x00df:
            r2 = r4
        L_0x00e0:
            if (r2 == 0) goto L_0x01b2
            r15.save()
            int r2 = r14.d()
            int r5 = r14.e()
            float r2 = (float) r2
            float r5 = (float) r5
            r15.translate(r2, r5)
            android.graphics.RectF r2 = r14.u
            float r2 = r2.width()
            android.graphics.Rect r5 = r14.getBounds()
            int r5 = r5.width()
            float r5 = (float) r5
            float r2 = r2 - r5
            int r2 = (int) r2
            android.graphics.RectF r5 = r14.u
            float r5 = r5.height()
            android.graphics.Rect r8 = r14.getBounds()
            int r8 = r8.height()
            float r8 = (float) r8
            float r5 = r5 - r8
            int r5 = (int) r5
            android.graphics.RectF r8 = r14.u
            float r8 = r8.width()
            int r8 = (int) r8
            e.g.a.a.e0.g$b r9 = r14.f8072a
            int r9 = r9.r
            int r9 = r9 * r6
            int r9 = r9 + r8
            int r9 = r9 + r2
            android.graphics.RectF r8 = r14.u
            float r8 = r8.height()
            int r8 = (int) r8
            e.g.a.a.e0.g$b r10 = r14.f8072a
            int r10 = r10.r
            int r10 = r10 * r6
            int r10 = r10 + r8
            int r10 = r10 + r5
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r9, r10, r6)
            android.graphics.Canvas r8 = new android.graphics.Canvas
            r8.<init>(r6)
            android.graphics.Rect r9 = r14.getBounds()
            int r9 = r9.left
            e.g.a.a.e0.g$b r10 = r14.f8072a
            int r10 = r10.r
            int r9 = r9 - r10
            int r9 = r9 - r2
            float r2 = (float) r9
            android.graphics.Rect r9 = r14.getBounds()
            int r9 = r9.top
            e.g.a.a.e0.g$b r10 = r14.f8072a
            int r10 = r10.r
            int r9 = r9 - r10
            int r9 = r9 - r5
            float r5 = (float) r9
            float r9 = -r2
            float r10 = -r5
            r8.translate(r9, r10)
            e.g.a.a.e0.g$b r9 = r14.f8072a
            int r9 = r9.s
            if (r9 == 0) goto L_0x0169
            android.graphics.Path r9 = r14.f8077f
            e.g.a.a.d0.a r10 = r14.o
            android.graphics.Paint r10 = r10.f8061a
            r8.drawPath(r9, r10)
        L_0x0169:
            r9 = r4
        L_0x016a:
            r10 = 4
            if (r9 >= r10) goto L_0x018e
            e.g.a.a.e0.m$f[] r10 = r14.f8073b
            r10 = r10[r9]
            e.g.a.a.d0.a r11 = r14.o
            e.g.a.a.e0.g$b r12 = r14.f8072a
            int r12 = r12.r
            android.graphics.Matrix r13 = e.g.a.a.e0.m.f.f8146a
            r10.a(r13, r11, r12, r8)
            e.g.a.a.e0.m$f[] r10 = r14.f8074c
            r10 = r10[r9]
            e.g.a.a.d0.a r11 = r14.o
            e.g.a.a.e0.g$b r12 = r14.f8072a
            int r12 = r12.r
            android.graphics.Matrix r13 = e.g.a.a.e0.m.f.f8146a
            r10.a(r13, r11, r12, r8)
            int r9 = r9 + 1
            goto L_0x016a
        L_0x018e:
            int r9 = r14.d()
            int r10 = r14.e()
            int r11 = -r9
            float r11 = (float) r11
            int r12 = -r10
            float r12 = (float) r12
            r8.translate(r11, r12)
            android.graphics.Path r11 = r14.f8077f
            android.graphics.Paint r12 = v
            r8.drawPath(r11, r12)
            float r9 = (float) r9
            float r10 = (float) r10
            r8.translate(r9, r10)
            r15.drawBitmap(r6, r2, r5, r3)
            r6.recycle()
            r15.restore()
        L_0x01b2:
            e.g.a.a.e0.g$b r2 = r14.f8072a
            android.graphics.Paint$Style r2 = r2.v
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r2 == r3) goto L_0x01be
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            if (r2 != r3) goto L_0x01bf
        L_0x01be:
            r4 = r7
        L_0x01bf:
            if (r4 == 0) goto L_0x01d2
            android.graphics.Paint r7 = r14.m
            android.graphics.Path r8 = r14.f8077f
            e.g.a.a.e0.g$b r2 = r14.f8072a
            e.g.a.a.e0.j r9 = r2.f8083a
            android.graphics.RectF r10 = r14.b()
            r5 = r14
            r6 = r15
            r5.a(r6, r7, r8, r9, r10)
        L_0x01d2:
            boolean r2 = r14.h()
            if (r2 == 0) goto L_0x01e7
            android.graphics.Paint r5 = r14.n
            android.graphics.Path r6 = r14.f8078g
            e.g.a.a.e0.j r7 = r14.l
            android.graphics.RectF r8 = r14.c()
            r3 = r14
            r4 = r15
            r3.a(r4, r5, r6, r7, r8)
        L_0x01e7:
            android.graphics.Paint r15 = r14.m
            r15.setAlpha(r0)
            android.graphics.Paint r15 = r14.n
            r15.setAlpha(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.a.e0.g.draw(android.graphics.Canvas):void");
    }

    public int e() {
        b bVar = this.f8072a;
        return (int) (Math.cos(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public final float f() {
        if (h()) {
            return this.n.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float g() {
        return this.f8072a.f8083a.f8099e.a(b());
    }

    public ConstantState getConstantState() {
        return this.f8072a;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        b bVar = this.f8072a;
        if (bVar.q != 2) {
            if (bVar.f8083a.a(b())) {
                outline.setRoundRect(getBounds(), g());
                return;
            }
            a(b(), this.f8077f);
            if (this.f8077f.isConvex()) {
                outline.setConvexPath(this.f8077f);
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.t;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.f8081j.set(getBounds());
        a(b(), this.f8077f);
        this.k.setPath(this.f8077f, this.f8081j);
        this.f8081j.op(this.k, Op.DIFFERENCE);
        return this.f8081j;
    }

    public final boolean h() {
        Style style = this.f8072a.v;
        return (style == Style.FILL_AND_STROKE || style == Style.STROKE) && this.n.getStrokeWidth() > 0.0f;
    }

    public final boolean i() {
        PorterDuffColorFilter porterDuffColorFilter = this.r;
        PorterDuffColorFilter porterDuffColorFilter2 = this.s;
        b bVar = this.f8072a;
        this.r = a(bVar.f8089g, bVar.f8090h, this.m, true);
        b bVar2 = this.f8072a;
        this.s = a(bVar2.f8088f, bVar2.f8090h, this.n, false);
        b bVar3 = this.f8072a;
        if (bVar3.u) {
            this.o.a(bVar3.f8089g.getColorForState(getState(), 0));
        }
        if (!Objects.equals(porterDuffColorFilter, this.r) || !Objects.equals(porterDuffColorFilter2, this.s)) {
            return true;
        }
        return false;
    }

    public void invalidateSelf() {
        this.f8075d = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        if (!super.isStateful()) {
            ColorStateList colorStateList = this.f8072a.f8089g;
            if (colorStateList == null || !colorStateList.isStateful()) {
                ColorStateList colorStateList2 = this.f8072a.f8088f;
                if (colorStateList2 == null || !colorStateList2.isStateful()) {
                    ColorStateList colorStateList3 = this.f8072a.f8087e;
                    if (colorStateList3 == null || !colorStateList3.isStateful()) {
                        ColorStateList colorStateList4 = this.f8072a.f8086d;
                        if (colorStateList4 == null || !colorStateList4.isStateful()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public final void j() {
        b bVar = this.f8072a;
        float f2 = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil((double) (0.75f * f2));
        this.f8072a.s = (int) Math.ceil((double) (f2 * 0.25f));
        i();
        super.invalidateSelf();
    }

    public Drawable mutate() {
        this.f8072a = new b(this.f8072a);
        return this;
    }

    public void onBoundsChange(Rect rect) {
        this.f8075d = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z = a(iArr) || i();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void setAlpha(int i2) {
        b bVar = this.f8072a;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f8072a.f8085c = colorFilter;
        super.invalidateSelf();
    }

    public void setShapeAppearanceModel(j jVar) {
        this.f8072a.f8083a = jVar;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f8072a.f8089g = colorStateList;
        i();
        super.invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        b bVar = this.f8072a;
        if (bVar.f8090h != mode) {
            bVar.f8090h = mode;
            i();
            super.invalidateSelf();
        }
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public g(b bVar) {
        this.f8073b = new f[4];
        this.f8074c = new f[4];
        this.f8076e = new Matrix();
        this.f8077f = new Path();
        this.f8078g = new Path();
        this.f8079h = new RectF();
        this.f8080i = new RectF();
        this.f8081j = new Region();
        this.k = new Region();
        this.m = new Paint(1);
        this.n = new Paint(1);
        this.o = new e.g.a.a.d0.a();
        this.q = new k();
        this.u = new RectF();
        this.f8072a = bVar;
        this.n.setStyle(Style.STROKE);
        this.m.setStyle(Style.FILL);
        v.setColor(-1);
        v.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        i();
        a(getState());
        this.p = new a();
    }

    public RectF b() {
        Rect bounds = getBounds();
        this.f8079h.set((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom);
        return this.f8079h;
    }

    public void b(float f2) {
        b bVar = this.f8072a;
        if (bVar.k != f2) {
            bVar.k = f2;
            this.f8075d = true;
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        b bVar = this.f8072a;
        if (bVar.f8086d != colorStateList) {
            bVar.f8086d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void b(RectF rectF, Path path) {
        k kVar = this.q;
        b bVar = this.f8072a;
        j jVar = bVar.f8083a;
        float f2 = bVar.k;
        kVar.a(jVar, f2, rectF, this.p, path);
    }

    public void a(float f2, int i2) {
        this.f8072a.l = f2;
        invalidateSelf();
        b(ColorStateList.valueOf(i2));
    }

    public void a(float f2, ColorStateList colorStateList) {
        this.f8072a.l = f2;
        invalidateSelf();
        b(colorStateList);
    }

    public void a(Context context) {
        this.f8072a.f8084b = new e.g.a.a.w.a(context);
        j();
    }

    public final int a(int i2) {
        b bVar = this.f8072a;
        float f2 = bVar.o + bVar.p + bVar.n;
        e.g.a.a.w.a aVar = bVar.f8084b;
        if (aVar == null || !aVar.f8395a) {
            return i2;
        }
        if (!(d.h.f.a.b(i2, 255) == aVar.f8397c)) {
            return i2;
        }
        float f3 = aVar.f8398d;
        float f4 = 0.0f;
        if (f3 > 0.0f && f2 > 0.0f) {
            f4 = Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return d.h.f.a.b(n.a(d.h.f.a.b(i2, 255), aVar.f8396b, f4), Color.alpha(i2));
    }

    public void a(float f2) {
        b bVar = this.f8072a;
        if (bVar.o != f2) {
            bVar.o = f2;
            j();
        }
    }

    public final void a(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (jVar.a(rectF)) {
            float a2 = jVar.f8100f.a(rectF);
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void a(RectF rectF, Path path) {
        b(rectF, path);
        if (this.f8072a.f8092j != 1.0f) {
            this.f8076e.reset();
            Matrix matrix = this.f8076e;
            float f2 = this.f8072a.f8092j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f8076e);
        }
        path.computeBounds(this.u, true);
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode, Paint paint, boolean z) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (colorStateList == null || mode == null) {
            if (z) {
                int color = paint.getColor();
                int a2 = a(color);
                if (a2 != color) {
                    porterDuffColorFilter = new PorterDuffColorFilter(a2, Mode.SRC_IN);
                    return porterDuffColorFilter;
                }
            }
            porterDuffColorFilter = null;
            return porterDuffColorFilter;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = a(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int[] r5) {
        /*
            r4 = this;
            e.g.a.a.e0.g$b r0 = r4.f8072a
            android.content.res.ColorStateList r0 = r0.f8086d
            r1 = 1
            if (r0 == 0) goto L_0x001e
            android.graphics.Paint r0 = r4.m
            int r0 = r0.getColor()
            e.g.a.a.e0.g$b r2 = r4.f8072a
            android.content.res.ColorStateList r2 = r2.f8086d
            int r2 = r2.getColorForState(r5, r0)
            if (r0 == r2) goto L_0x001e
            android.graphics.Paint r0 = r4.m
            r0.setColor(r2)
            r0 = r1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            e.g.a.a.e0.g$b r2 = r4.f8072a
            android.content.res.ColorStateList r2 = r2.f8087e
            if (r2 == 0) goto L_0x003b
            android.graphics.Paint r2 = r4.n
            int r2 = r2.getColor()
            e.g.a.a.e0.g$b r3 = r4.f8072a
            android.content.res.ColorStateList r3 = r3.f8087e
            int r5 = r3.getColorForState(r5, r2)
            if (r2 == r5) goto L_0x003b
            android.graphics.Paint r0 = r4.n
            r0.setColor(r5)
            goto L_0x003c
        L_0x003b:
            r1 = r0
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.a.e0.g.a(int[]):boolean");
    }
}
