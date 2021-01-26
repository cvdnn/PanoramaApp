package d.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import d.h.k.m;

/* compiled from: ChangeBounds */
public class b extends i {
    public static final String[] L = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> M = new C0056b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> N;
    public static final Property<k, PointF> O;
    public static final Property<View, PointF> P;
    public static final Property<View, PointF> Q;
    public static final Property<View, PointF> R = new g(PointF.class, "position");
    public static g S = new g();
    public int[] I = new int[2];
    public boolean J = false;
    public boolean K = false;

    /* compiled from: ChangeBounds */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5430a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f5431b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ View f5432c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ float f5433d;

        public a(b bVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.f5430a = viewGroup;
            this.f5431b = bitmapDrawable;
            this.f5432c = view;
            this.f5433d = f2;
        }

        public void onAnimationEnd(Animator animator) {
            u a2 = v.a(this.f5430a);
            ((t) a2).f5519a.remove(this.f5431b);
            v.f5520a.a(this.f5432c, this.f5433d);
        }
    }

    /* renamed from: d.t.b$b reason: collision with other inner class name */
    /* compiled from: ChangeBounds */
    public static class C0056b extends Property<Drawable, PointF> {

        /* renamed from: a reason: collision with root package name */
        public Rect f5434a = new Rect();

        public C0056b(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.f5434a);
            Rect rect = this.f5434a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        public void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.f5434a);
            this.f5434a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f5434a);
        }
    }

    /* compiled from: ChangeBounds */
    public static class c extends Property<k, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            k kVar = (k) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            k kVar = (k) obj;
            PointF pointF = (PointF) obj2;
            if (kVar != null) {
                kVar.f5445a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                kVar.f5446b = round;
                int i2 = kVar.f5450f + 1;
                kVar.f5450f = i2;
                if (i2 == kVar.f5451g) {
                    v.a(kVar.f5449e, kVar.f5445a, round, kVar.f5447c, kVar.f5448d);
                    kVar.f5450f = 0;
                    kVar.f5451g = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* compiled from: ChangeBounds */
    public static class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            k kVar = (k) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            k kVar = (k) obj;
            PointF pointF = (PointF) obj2;
            if (kVar != null) {
                kVar.f5447c = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                kVar.f5448d = round;
                int i2 = kVar.f5451g + 1;
                kVar.f5451g = i2;
                if (kVar.f5450f == i2) {
                    v.a(kVar.f5449e, kVar.f5445a, kVar.f5446b, kVar.f5447c, round);
                    kVar.f5450f = 0;
                    kVar.f5451g = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* compiled from: ChangeBounds */
    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            v.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds */
    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            v.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds */
    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            v.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ k f5435a;
        public k mViewBounds = this.f5435a;

        public h(b bVar, k kVar) {
            this.f5435a = kVar;
        }
    }

    /* compiled from: ChangeBounds */
    public class i extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        public boolean f5436a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ View f5437b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ Rect f5438c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ int f5439d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ int f5440e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ int f5441f;

        /* renamed from: g reason: collision with root package name */
        public final /* synthetic */ int f5442g;

        public i(b bVar, View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f5437b = view;
            this.f5438c = rect;
            this.f5439d = i2;
            this.f5440e = i3;
            this.f5441f = i4;
            this.f5442g = i5;
        }

        public void onAnimationCancel(Animator animator) {
            this.f5436a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f5436a) {
                m.a(this.f5437b, this.f5438c);
                v.a(this.f5437b, this.f5439d, this.f5440e, this.f5441f, this.f5442g);
            }
        }
    }

    /* compiled from: ChangeBounds */
    public class j extends l {

        /* renamed from: a reason: collision with root package name */
        public boolean f5443a = false;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5444b;

        public j(b bVar, ViewGroup viewGroup) {
            this.f5444b = viewGroup;
        }

        public void b(i iVar) {
            s.a(this.f5444b, false);
        }

        public void c(i iVar) {
            if (!this.f5443a) {
                s.a(this.f5444b, false);
            }
            iVar.b((d.t.i.d) this);
        }

        public void d(i iVar) {
            s.a(this.f5444b, false);
            this.f5443a = true;
        }

        public void e(i iVar) {
            s.a(this.f5444b, true);
        }
    }

    /* compiled from: ChangeBounds */
    public static class k {

        /* renamed from: a reason: collision with root package name */
        public int f5445a;

        /* renamed from: b reason: collision with root package name */
        public int f5446b;

        /* renamed from: c reason: collision with root package name */
        public int f5447c;

        /* renamed from: d reason: collision with root package name */
        public int f5448d;

        /* renamed from: e reason: collision with root package name */
        public View f5449e;

        /* renamed from: f reason: collision with root package name */
        public int f5450f;

        /* renamed from: g reason: collision with root package name */
        public int f5451g;

        public k(View view) {
            this.f5449e = view;
        }
    }

    static {
        String str = "topLeft";
        N = new c(PointF.class, str);
        String str2 = "bottomRight";
        O = new d(PointF.class, str2);
        P = new e(PointF.class, str2);
        Q = new f(PointF.class, str);
    }

    public void a(q qVar) {
        d(qVar);
    }

    public String[] b() {
        return L;
    }

    public void c(q qVar) {
        d(qVar);
    }

    public final void d(q qVar) {
        View view = qVar.f5512b;
        if (m.z(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            qVar.f5511a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            qVar.f5511a.put("android:changeBounds:parent", qVar.f5512b.getParent());
            if (this.K) {
                qVar.f5512b.getLocationInWindow(this.I);
                qVar.f5511a.put("android:changeBounds:windowX", Integer.valueOf(this.I[0]));
                qVar.f5511a.put("android:changeBounds:windowY", Integer.valueOf(this.I[1]));
            }
            if (this.J) {
                qVar.f5511a.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator a(android.view.ViewGroup r19, d.t.q r20, d.t.q r21) {
        /*
            r18 = this;
            r8 = r18
            r0 = r20
            r1 = r21
            if (r0 == 0) goto L_0x0268
            if (r1 != 0) goto L_0x000c
            goto L_0x0268
        L_0x000c:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r0.f5511a
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.f5511a
            java.lang.String r5 = "android:changeBounds:parent"
            java.lang.Object r3 = r3.get(r5)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            java.lang.Object r4 = r4.get(r5)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            if (r3 == 0) goto L_0x0266
            if (r4 != 0) goto L_0x0024
            goto L_0x0266
        L_0x0024:
            android.view.View r9 = r1.f5512b
            boolean r5 = r8.K
            r10 = 1
            if (r5 == 0) goto L_0x003b
            d.t.q r5 = r8.b(r3, r10)
            if (r5 != 0) goto L_0x0034
            if (r3 != r4) goto L_0x0039
            goto L_0x003b
        L_0x0034:
            android.view.View r3 = r5.f5512b
            if (r4 != r3) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r3 = 0
            goto L_0x003c
        L_0x003b:
            r3 = r10
        L_0x003c:
            if (r3 == 0) goto L_0x01bd
            java.util.Map<java.lang.String, java.lang.Object> r3 = r0.f5511a
            java.lang.String r4 = "android:changeBounds:bounds"
            java.lang.Object r3 = r3.get(r4)
            android.graphics.Rect r3 = (android.graphics.Rect) r3
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.f5511a
            java.lang.Object r4 = r5.get(r4)
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r5 = r3.left
            int r7 = r4.left
            int r11 = r3.top
            int r12 = r4.top
            int r13 = r3.right
            int r14 = r4.right
            int r3 = r3.bottom
            int r15 = r4.bottom
            int r4 = r13 - r5
            int r2 = r3 - r11
            int r10 = r14 - r7
            int r6 = r15 - r12
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.f5511a
            r16 = r9
            java.lang.String r9 = "android:changeBounds:clip"
            java.lang.Object r0 = r0.get(r9)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f5511a
            java.lang.Object r1 = r1.get(r9)
            r9 = r1
            android.graphics.Rect r9 = (android.graphics.Rect) r9
            if (r4 == 0) goto L_0x0081
            if (r2 != 0) goto L_0x0085
        L_0x0081:
            if (r10 == 0) goto L_0x0094
            if (r6 == 0) goto L_0x0094
        L_0x0085:
            if (r5 != r7) goto L_0x008c
            if (r11 == r12) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r1 = 0
            goto L_0x008d
        L_0x008c:
            r1 = 1
        L_0x008d:
            if (r13 != r14) goto L_0x0091
            if (r3 == r15) goto L_0x0095
        L_0x0091:
            int r1 = r1 + 1
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            if (r0 == 0) goto L_0x009d
            boolean r17 = r0.equals(r9)
            if (r17 == 0) goto L_0x00a1
        L_0x009d:
            if (r0 != 0) goto L_0x00a3
            if (r9 == 0) goto L_0x00a3
        L_0x00a1:
            int r1 = r1 + 1
        L_0x00a3:
            if (r1 <= 0) goto L_0x01f6
            r19 = r9
            boolean r9 = r8.J
            r20 = r0
            r0 = 2
            if (r9 != 0) goto L_0x0134
            r9 = r16
            d.t.v.a(r9, r5, r11, r13, r3)
            if (r1 != r0) goto L_0x010b
            if (r4 != r10) goto L_0x00cb
            if (r2 != r6) goto L_0x00cb
            d.t.e r0 = r8.E
            float r1 = (float) r5
            float r2 = (float) r11
            float r3 = (float) r7
            float r4 = (float) r12
            android.graphics.Path r0 = r0.a(r1, r2, r3, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r1 = R
            android.animation.ObjectAnimator r0 = a.a.a.a.b.a.a(r9, r1, r0)
            goto L_0x01a2
        L_0x00cb:
            d.t.b$k r1 = new d.t.b$k
            r1.<init>(r9)
            d.t.e r2 = r8.E
            float r4 = (float) r5
            float r5 = (float) r11
            float r6 = (float) r7
            float r7 = (float) r12
            android.graphics.Path r2 = r2.a(r4, r5, r6, r7)
            android.util.Property<d.t.b$k, android.graphics.PointF> r4 = N
            android.animation.ObjectAnimator r2 = a.a.a.a.b.a.a(r1, r4, r2)
            d.t.e r4 = r8.E
            float r5 = (float) r13
            float r3 = (float) r3
            float r6 = (float) r14
            float r7 = (float) r15
            android.graphics.Path r3 = r4.a(r5, r3, r6, r7)
            android.util.Property<d.t.b$k, android.graphics.PointF> r4 = O
            android.animation.ObjectAnimator r3 = a.a.a.a.b.a.a(r1, r4, r3)
            android.animation.AnimatorSet r4 = new android.animation.AnimatorSet
            r4.<init>()
            android.animation.Animator[] r0 = new android.animation.Animator[r0]
            r5 = 0
            r0[r5] = r2
            r2 = 1
            r0[r2] = r3
            r4.playTogether(r0)
            d.t.b$h r0 = new d.t.b$h
            r0.<init>(r8, r1)
            r4.addListener(r0)
            r0 = r4
            goto L_0x01a2
        L_0x010b:
            if (r5 != r7) goto L_0x0122
            if (r11 == r12) goto L_0x0110
            goto L_0x0122
        L_0x0110:
            d.t.e r0 = r8.E
            float r1 = (float) r13
            float r2 = (float) r3
            float r3 = (float) r14
            float r4 = (float) r15
            android.graphics.Path r0 = r0.a(r1, r2, r3, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r1 = P
            android.animation.ObjectAnimator r0 = a.a.a.a.b.a.a(r9, r1, r0)
            goto L_0x01a2
        L_0x0122:
            d.t.e r0 = r8.E
            float r1 = (float) r5
            float r2 = (float) r11
            float r3 = (float) r7
            float r4 = (float) r12
            android.graphics.Path r0 = r0.a(r1, r2, r3, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r1 = Q
            android.animation.ObjectAnimator r0 = a.a.a.a.b.a.a(r9, r1, r0)
            goto L_0x01a2
        L_0x0134:
            r9 = r16
            int r1 = java.lang.Math.max(r4, r10)
            int r3 = java.lang.Math.max(r2, r6)
            int r1 = r1 + r5
            int r3 = r3 + r11
            d.t.v.a(r9, r5, r11, r1, r3)
            if (r5 != r7) goto L_0x014a
            if (r11 == r12) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r11 = 0
            goto L_0x015b
        L_0x014a:
            d.t.e r1 = r8.E
            float r3 = (float) r5
            float r5 = (float) r11
            float r11 = (float) r7
            float r13 = (float) r12
            android.graphics.Path r1 = r1.a(r3, r5, r11, r13)
            android.util.Property<android.view.View, android.graphics.PointF> r3 = R
            android.animation.ObjectAnimator r1 = a.a.a.a.b.a.a(r9, r3, r1)
            r11 = r1
        L_0x015b:
            if (r20 != 0) goto L_0x0164
            android.graphics.Rect r1 = new android.graphics.Rect
            r3 = 0
            r1.<init>(r3, r3, r4, r2)
            goto L_0x0167
        L_0x0164:
            r3 = 0
            r1 = r20
        L_0x0167:
            if (r19 != 0) goto L_0x016f
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>(r3, r3, r10, r6)
            goto L_0x0171
        L_0x016f:
            r2 = r19
        L_0x0171:
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L_0x019d
            d.h.k.m.a(r9, r1)
            d.t.g r4 = S
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r3] = r1
            r1 = 1
            r0[r1] = r2
            java.lang.String r1 = "clipBounds"
            android.animation.ObjectAnimator r10 = android.animation.ObjectAnimator.ofObject(r9, r1, r4, r0)
            d.t.b$i r13 = new d.t.b$i
            r0 = r13
            r1 = r18
            r2 = r9
            r3 = r19
            r4 = r7
            r5 = r12
            r6 = r14
            r7 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r10.addListener(r13)
            r2 = r10
            goto L_0x019e
        L_0x019d:
            r2 = 0
        L_0x019e:
            android.animation.Animator r0 = d.t.p.a(r11, r2)
        L_0x01a2:
            android.view.ViewParent r1 = r9.getParent()
            boolean r1 = r1 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x01bc
            android.view.ViewParent r1 = r9.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = 1
            d.t.s.a(r1, r2)
            d.t.b$j r2 = new d.t.b$j
            r2.<init>(r8, r1)
            r8.a(r2)
        L_0x01bc:
            return r0
        L_0x01bd:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r0.f5511a
            java.lang.String r3 = "android:changeBounds:windowX"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.f5511a
            java.lang.String r4 = "android:changeBounds:windowY"
            java.lang.Object r0 = r0.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.f5511a
            java.lang.Object r3 = r5.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f5511a
            java.lang.Object r1 = r1.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r2 != r3) goto L_0x01f8
            if (r0 == r1) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r0 = 0
            return r0
        L_0x01f8:
            int[] r4 = r8.I
            r5 = r19
            r5.getLocationInWindow(r4)
            int r4 = r9.getWidth()
            int r6 = r9.getHeight()
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r6, r7)
            android.graphics.Canvas r6 = new android.graphics.Canvas
            r6.<init>(r4)
            r9.draw(r6)
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable
            r6.<init>(r4)
            float r7 = d.t.v.b(r9)
            r4 = 0
            d.t.b0 r10 = d.t.v.f5520a
            r10.a(r9, r4)
            android.view.ViewOverlay r4 = r19.getOverlay()
            r4.add(r6)
            d.t.e r4 = r8.E
            int[] r10 = r8.I
            r11 = 0
            r12 = r10[r11]
            int r2 = r2 - r12
            float r2 = (float) r2
            r12 = 1
            r13 = r10[r12]
            int r0 = r0 - r13
            float r0 = (float) r0
            r13 = r10[r11]
            int r3 = r3 - r13
            float r3 = (float) r3
            r10 = r10[r12]
            int r1 = r1 - r10
            float r1 = (float) r1
            android.graphics.Path r0 = r4.a(r2, r0, r3, r1)
            android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF> r1 = M
            r2 = 0
            android.animation.PropertyValuesHolder r0 = android.animation.PropertyValuesHolder.ofObject(r1, r2, r0)
            android.animation.PropertyValuesHolder[] r1 = new android.animation.PropertyValuesHolder[r12]
            r2 = 0
            r1[r2] = r0
            android.animation.ObjectAnimator r10 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r6, r1)
            d.t.b$a r11 = new d.t.b$a
            r0 = r11
            r1 = r18
            r2 = r19
            r3 = r6
            r4 = r9
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r10.addListener(r11)
            return r10
        L_0x0266:
            r0 = 0
            return r0
        L_0x0268:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.t.b.a(android.view.ViewGroup, d.t.q, d.t.q):android.animation.Animator");
    }
}
