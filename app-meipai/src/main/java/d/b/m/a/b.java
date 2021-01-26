package d.b.m.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.SparseArray;

/* compiled from: DrawableContainer */
public class b extends Drawable implements Callback {

    /* renamed from: a reason: collision with root package name */
    public c f4071a;

    /* renamed from: b reason: collision with root package name */
    public Rect f4072b;

    /* renamed from: c reason: collision with root package name */
    public Drawable f4073c;

    /* renamed from: d reason: collision with root package name */
    public Drawable f4074d;

    /* renamed from: e reason: collision with root package name */
    public int f4075e = 255;

    /* renamed from: f reason: collision with root package name */
    public boolean f4076f;

    /* renamed from: g reason: collision with root package name */
    public int f4077g = -1;

    /* renamed from: h reason: collision with root package name */
    public boolean f4078h;

    /* renamed from: i reason: collision with root package name */
    public Runnable f4079i;

    /* renamed from: j reason: collision with root package name */
    public long f4080j;
    public long k;
    public C0025b l;

    /* compiled from: DrawableContainer */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: d.b.m.a.b$b reason: collision with other inner class name */
    /* compiled from: DrawableContainer */
    public static class C0025b implements Callback {

        /* renamed from: a reason: collision with root package name */
        public Callback f4082a;

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Callback callback = this.f4082a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Callback callback = this.f4082a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* compiled from: DrawableContainer */
    public static abstract class c extends ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a reason: collision with root package name */
        public final b f4083a;

        /* renamed from: b reason: collision with root package name */
        public Resources f4084b;

        /* renamed from: c reason: collision with root package name */
        public int f4085c = 160;

        /* renamed from: d reason: collision with root package name */
        public int f4086d;

        /* renamed from: e reason: collision with root package name */
        public int f4087e;

        /* renamed from: f reason: collision with root package name */
        public SparseArray<ConstantState> f4088f;

        /* renamed from: g reason: collision with root package name */
        public Drawable[] f4089g;

        /* renamed from: h reason: collision with root package name */
        public int f4090h;

        /* renamed from: i reason: collision with root package name */
        public boolean f4091i;

        /* renamed from: j reason: collision with root package name */
        public boolean f4092j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public c(c cVar, b bVar, Resources resources) {
            this.f4091i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f4083a = bVar;
            Resources resources2 = resources != null ? resources : cVar != null ? cVar.f4084b : null;
            this.f4084b = resources2;
            int a2 = b.a(resources, cVar != null ? cVar.f4085c : 0);
            this.f4085c = a2;
            if (cVar != null) {
                this.f4086d = cVar.f4086d;
                this.f4087e = cVar.f4087e;
                this.v = true;
                this.w = true;
                this.f4091i = cVar.f4091i;
                this.l = cVar.l;
                this.x = cVar.x;
                this.y = cVar.y;
                this.z = cVar.z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.f4085c == a2) {
                    if (cVar.f4092j) {
                        this.k = new Rect(cVar.k);
                        this.f4092j = true;
                    }
                    if (cVar.m) {
                        this.n = cVar.n;
                        this.o = cVar.o;
                        this.p = cVar.p;
                        this.q = cVar.q;
                        this.m = true;
                    }
                }
                if (cVar.r) {
                    this.s = cVar.s;
                    this.r = true;
                }
                if (cVar.t) {
                    this.u = cVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = cVar.f4089g;
                this.f4089g = new Drawable[drawableArr.length];
                this.f4090h = cVar.f4090h;
                SparseArray<ConstantState> sparseArray = cVar.f4088f;
                if (sparseArray != null) {
                    this.f4088f = sparseArray.clone();
                } else {
                    this.f4088f = new SparseArray<>(this.f4090h);
                }
                int i2 = this.f4090h;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f4088f.put(i3, constantState);
                        } else {
                            this.f4089g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f4089g = new Drawable[10];
            this.f4090h = 0;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f4090h;
            if (i2 >= this.f4089g.length) {
                int i3 = i2 + 10;
                d.b.m.a.d.a aVar = (d.b.m.a.d.a) this;
                Drawable[] drawableArr = new Drawable[i3];
                System.arraycopy(aVar.f4089g, 0, drawableArr, 0, i2);
                aVar.f4089g = drawableArr;
                int[][] iArr = new int[i3][];
                System.arraycopy(aVar.J, 0, iArr, 0, i2);
                aVar.J = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f4083a);
            this.f4089g[i2] = drawable;
            this.f4090h++;
            this.f4087e = drawable.getChangingConfigurations() | this.f4087e;
            this.r = false;
            this.t = false;
            this.k = null;
            this.f4092j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        public void b() {
            this.m = true;
            c();
            int i2 = this.f4090h;
            Drawable[] drawableArr = this.f4089g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final void c() {
            SparseArray<ConstantState> sparseArray = this.f4088f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = this.f4088f.keyAt(i2);
                    ConstantState constantState = (ConstantState) this.f4088f.valueAt(i2);
                    Drawable[] drawableArr = this.f4089g;
                    Drawable newDrawable = constantState.newDrawable(this.f4084b);
                    newDrawable.setLayoutDirection(this.z);
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.f4083a);
                    drawableArr[keyAt] = mutate;
                }
                this.f4088f = null;
            }
        }

        public boolean canApplyTheme() {
            int i2 = this.f4090h;
            Drawable[] drawableArr = this.f4089g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    ConstantState constantState = (ConstantState) this.f4088f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public abstract void d();

        public int getChangingConfigurations() {
            return this.f4086d | this.f4087e;
        }

        public final Drawable a(int i2) {
            Drawable drawable = this.f4089g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<ConstantState> sparseArray = this.f4088f;
            if (sparseArray != null) {
                int indexOfKey = sparseArray.indexOfKey(i2);
                if (indexOfKey >= 0) {
                    Drawable newDrawable = ((ConstantState) this.f4088f.valueAt(indexOfKey)).newDrawable(this.f4084b);
                    newDrawable.setLayoutDirection(this.z);
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.f4083a);
                    this.f4089g[i2] = mutate;
                    this.f4088f.removeAt(indexOfKey);
                    if (this.f4088f.size() == 0) {
                        this.f4088f = null;
                    }
                    return mutate;
                }
            }
            return null;
        }

        public final void a(Resources resources) {
            if (resources != null) {
                this.f4084b = resources;
                int a2 = b.a(resources, this.f4085c);
                int i2 = this.f4085c;
                this.f4085c = a2;
                if (i2 != a2) {
                    this.m = false;
                    this.f4092j = false;
                }
            }
        }

        public synchronized boolean a() {
            if (this.v) {
                return this.w;
            }
            c();
            this.v = true;
            int i2 = this.f4090h;
            Drawable[] drawableArr = this.f4089g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    public c a() {
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r10) {
        /*
            r9 = this;
            int r0 = r9.f4077g
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            d.b.m.a.b$c r0 = r9.f4071a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f4074d
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f4073c
            if (r0 == 0) goto L_0x0029
            r9.f4074d = r0
            d.b.m.a.b$c r0 = r9.f4071a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.k = r0
            goto L_0x0035
        L_0x0029:
            r9.f4074d = r4
            r9.k = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f4073c
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            d.b.m.a.b$c r0 = r9.f4071a
            int r1 = r0.f4090h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.a(r10)
            r9.f4073c = r0
            r9.f4077g = r10
            if (r0 == 0) goto L_0x005a
            d.b.m.a.b$c r10 = r9.f4071a
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f4080j = r2
        L_0x0051:
            r9.a(r0)
            goto L_0x005a
        L_0x0055:
            r9.f4073c = r4
            r10 = -1
            r9.f4077g = r10
        L_0x005a:
            long r0 = r9.f4080j
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L_0x0067
            long r1 = r9.k
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r10 = r9.f4079i
            if (r10 != 0) goto L_0x0073
            d.b.m.a.b$a r10 = new d.b.m.a.b$a
            r10.<init>()
            r9.f4079i = r10
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r10)
        L_0x0076:
            r9.a(r0)
        L_0x0079:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.m.a.b.a(int):boolean");
    }

    public boolean canApplyTheme() {
        return this.f4071a.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f4073c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f4074d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.f4075e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f4071a.getChangingConfigurations();
    }

    public final ConstantState getConstantState() {
        if (!this.f4071a.a()) {
            return null;
        }
        this.f4071a.f4086d = getChangingConfigurations();
        return this.f4071a;
    }

    public Drawable getCurrent() {
        return this.f4073c;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f4072b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        c cVar = this.f4071a;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.o;
        }
        Drawable drawable = this.f4073c;
        return drawable != null ? drawable.getIntrinsicHeight() : -1;
    }

    public int getIntrinsicWidth() {
        c cVar = this.f4071a;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.n;
        }
        Drawable drawable = this.f4073c;
        return drawable != null ? drawable.getIntrinsicWidth() : -1;
    }

    public int getMinimumHeight() {
        c cVar = this.f4071a;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.q;
        }
        Drawable drawable = this.f4073c;
        return drawable != null ? drawable.getMinimumHeight() : 0;
    }

    public int getMinimumWidth() {
        c cVar = this.f4071a;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.p;
        }
        Drawable drawable = this.f4073c;
        return drawable != null ? drawable.getMinimumWidth() : 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f4073c;
        int i2 = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        c cVar = this.f4071a;
        if (cVar.r) {
            return cVar.s;
        }
        cVar.c();
        int i3 = cVar.f4090h;
        Drawable[] drawableArr = cVar.f4089g;
        if (i3 > 0) {
            i2 = drawableArr[0].getOpacity();
        }
        for (int i4 = 1; i4 < i3; i4++) {
            i2 = Drawable.resolveOpacity(i2, drawableArr[i4].getOpacity());
        }
        cVar.s = i2;
        cVar.r = true;
        return i2;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f4073c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        c cVar = this.f4071a;
        Rect rect2 = null;
        boolean z2 = false;
        if (!cVar.f4091i) {
            if (cVar.k != null || cVar.f4092j) {
                rect2 = cVar.k;
            } else {
                cVar.c();
                Rect rect3 = new Rect();
                int i2 = cVar.f4090h;
                Drawable[] drawableArr = cVar.f4089g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect3)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i4 = rect3.left;
                        if (i4 > rect2.left) {
                            rect2.left = i4;
                        }
                        int i5 = rect3.top;
                        if (i5 > rect2.top) {
                            rect2.top = i5;
                        }
                        int i6 = rect3.right;
                        if (i6 > rect2.right) {
                            rect2.right = i6;
                        }
                        int i7 = rect3.bottom;
                        if (i7 > rect2.bottom) {
                            rect2.bottom = i7;
                        }
                    }
                }
                cVar.f4092j = true;
                cVar.k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            z = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.f4073c;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f4071a.C && getLayoutDirection() == 1) {
            z2 = true;
        }
        if (z2) {
            int i8 = rect.left;
            rect.left = rect.right;
            rect.right = i8;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f4071a;
        if (cVar != null) {
            cVar.r = false;
            cVar.t = false;
        }
        if (drawable == this.f4073c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f4071a.C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f4074d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f4074d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f4073c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f4076f) {
                this.f4073c.setAlpha(this.f4075e);
            }
        }
        if (this.k != 0) {
            this.k = 0;
            z = true;
        }
        if (this.f4080j != 0) {
            this.f4080j = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f4078h && super.mutate() == this) {
            c a2 = a();
            a2.d();
            a(a2);
            this.f4078h = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4074d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f4073c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        c cVar = this.f4071a;
        int i3 = this.f4077g;
        int i4 = cVar.f4090h;
        Drawable[] drawableArr = cVar.f4089g;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            if (drawableArr[i5] != null) {
                boolean layoutDirection = drawableArr[i5].setLayoutDirection(i2);
                if (i5 == i3) {
                    z = layoutDirection;
                }
            }
        }
        cVar.z = i2;
        return z;
    }

    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f4074d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f4073c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f4073c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f4076f || this.f4075e != i2) {
            this.f4076f = true;
            this.f4075e = i2;
            Drawable drawable = this.f4073c;
            if (drawable == null) {
                return;
            }
            if (this.f4080j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        c cVar = this.f4071a;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f4073c;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f4071a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f4073c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        c cVar = this.f4071a;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f4073c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f4073c;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f4072b;
        if (rect == null) {
            this.f4072b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f4073c;
        if (drawable != null) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f4071a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            a.a.a.a.b.a.a(this.f4073c, colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        c cVar = this.f4071a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            a.a.a.a.b.a.a(this.f4073c, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f4074d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f4073c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f4073c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public final void a(Drawable drawable) {
        if (this.l == null) {
            this.l = new C0025b();
        }
        C0025b bVar = this.l;
        bVar.f4082a = drawable.getCallback();
        drawable.setCallback(bVar);
        try {
            if (this.f4071a.A <= 0 && this.f4076f) {
                drawable.setAlpha(this.f4075e);
            }
            if (this.f4071a.E) {
                drawable.setColorFilter(this.f4071a.D);
            } else {
                if (this.f4071a.H) {
                    drawable.setTintList(this.f4071a.F);
                }
                if (this.f4071a.I) {
                    drawable.setTintMode(this.f4071a.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f4071a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.f4071a.C);
            Rect rect = this.f4072b;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            C0025b bVar2 = this.l;
            Callback callback = bVar2.f4082a;
            bVar2.f4082a = null;
            drawable.setCallback(callback);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f4076f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f4073c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0036
            long r9 = r13.f4080j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0038
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.f4075e
            r3.setAlpha(r9)
            r13.f4080j = r7
            goto L_0x0038
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            d.b.m.a.b$c r10 = r13.f4071a
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f4075e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L_0x0039
        L_0x0036:
            r13.f4080j = r7
        L_0x0038:
            r3 = r6
        L_0x0039:
            android.graphics.drawable.Drawable r9 = r13.f4074d
            if (r9 == 0) goto L_0x0061
            long r10 = r13.k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0063
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f4074d = r0
            r13.k = r7
            goto L_0x0063
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            d.b.m.a.b$c r4 = r13.f4071a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f4075e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0064
        L_0x0061:
            r13.k = r7
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r14 == 0) goto L_0x0070
            if (r0 == 0) goto L_0x0070
            java.lang.Runnable r14 = r13.f4079i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.m.a.b.a(boolean):void");
    }

    public void a(c cVar) {
        this.f4071a = cVar;
        int i2 = this.f4077g;
        if (i2 >= 0) {
            Drawable a2 = cVar.a(i2);
            this.f4073c = a2;
            if (a2 != null) {
                a(a2);
            }
        }
        this.f4074d = null;
    }

    public static int a(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }
}
