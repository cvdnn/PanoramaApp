package d.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import d.t.i.d;

/* compiled from: Visibility */
public abstract class d0 extends i {
    public static final String[] J = {"android:visibility:visibility", "android:visibility:parent"};
    public int I = 3;

    /* compiled from: Visibility */
    public static class a extends AnimatorListenerAdapter implements d {

        /* renamed from: a reason: collision with root package name */
        public final View f5470a;

        /* renamed from: b reason: collision with root package name */
        public final int f5471b;

        /* renamed from: c reason: collision with root package name */
        public final ViewGroup f5472c;

        /* renamed from: d reason: collision with root package name */
        public final boolean f5473d;

        /* renamed from: e reason: collision with root package name */
        public boolean f5474e;

        /* renamed from: f reason: collision with root package name */
        public boolean f5475f = false;

        public a(View view, int i2, boolean z) {
            this.f5470a = view;
            this.f5471b = i2;
            this.f5472c = (ViewGroup) view.getParent();
            this.f5473d = z;
            a(true);
        }

        public final void a() {
            if (!this.f5475f) {
                v.f5520a.a(this.f5470a, this.f5471b);
                ViewGroup viewGroup = this.f5472c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        public void a(i iVar) {
        }

        public void b(i iVar) {
            a(false);
        }

        public void c(i iVar) {
            a();
            iVar.b((d) this);
        }

        public void d(i iVar) {
        }

        public void e(i iVar) {
            a(true);
        }

        public void onAnimationCancel(Animator animator) {
            this.f5475f = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f5475f) {
                v.f5520a.a(this.f5470a, this.f5471b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f5475f) {
                v.f5520a.a(this.f5470a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public final void a(boolean z) {
            if (this.f5473d && this.f5474e != z) {
                ViewGroup viewGroup = this.f5472c;
                if (viewGroup != null) {
                    this.f5474e = z;
                    s.a(viewGroup, z);
                }
            }
        }
    }

    /* compiled from: Visibility */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public boolean f5476a;

        /* renamed from: b reason: collision with root package name */
        public boolean f5477b;

        /* renamed from: c reason: collision with root package name */
        public int f5478c;

        /* renamed from: d reason: collision with root package name */
        public int f5479d;

        /* renamed from: e reason: collision with root package name */
        public ViewGroup f5480e;

        /* renamed from: f reason: collision with root package name */
        public ViewGroup f5481f;
    }

    public abstract Animator a(ViewGroup viewGroup, View view, q qVar, q qVar2);

    public void a(q qVar) {
        d(qVar);
    }

    public String[] b() {
        return J;
    }

    public final void d(q qVar) {
        String str = "android:visibility:visibility";
        qVar.f5511a.put(str, Integer.valueOf(qVar.f5512b.getVisibility()));
        qVar.f5511a.put("android:visibility:parent", qVar.f5512b.getParent());
        int[] iArr = new int[2];
        qVar.f5512b.getLocationOnScreen(iArr);
        qVar.f5511a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (b(b(r13, false), c(r13, false)).f5476a != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e1, code lost:
        if (r12.v != false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator a(android.view.ViewGroup r13, d.t.q r14, d.t.q r15) {
        /*
            r12 = this;
            d.t.d0$b r0 = r12.b(r14, r15)
            boolean r1 = r0.f5476a
            r2 = 0
            if (r1 == 0) goto L_0x0162
            android.view.ViewGroup r1 = r0.f5480e
            if (r1 != 0) goto L_0x0011
            android.view.ViewGroup r1 = r0.f5481f
            if (r1 == 0) goto L_0x0162
        L_0x0011:
            boolean r1 = r0.f5477b
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0061
            int r13 = r12.I
            r13 = r13 & r3
            if (r13 != r3) goto L_0x0060
            if (r15 != 0) goto L_0x001f
            goto L_0x0060
        L_0x001f:
            if (r14 != 0) goto L_0x003a
            android.view.View r13 = r15.f5512b
            android.view.ViewParent r13 = r13.getParent()
            android.view.View r13 = (android.view.View) r13
            d.t.q r0 = r12.b(r13, r4)
            d.t.q r13 = r12.c(r13, r4)
            d.t.d0$b r13 = r12.b(r0, r13)
            boolean r13 = r13.f5476a
            if (r13 == 0) goto L_0x003a
            goto L_0x0060
        L_0x003a:
            android.view.View r13 = r15.f5512b
            r15 = r12
            d.t.c r15 = (d.t.c) r15
            r0 = 0
            if (r14 == 0) goto L_0x0053
            java.util.Map<java.lang.String, java.lang.Object> r14 = r14.f5511a
            java.lang.String r1 = "android:fade:transitionAlpha"
            java.lang.Object r14 = r14.get(r1)
            java.lang.Float r14 = (java.lang.Float) r14
            if (r14 == 0) goto L_0x0053
            float r14 = r14.floatValue()
            goto L_0x0054
        L_0x0053:
            r14 = r0
        L_0x0054:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r2 != 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r0 = r14
        L_0x005c:
            android.animation.Animator r2 = r15.a(r13, r0, r1)
        L_0x0060:
            return r2
        L_0x0061:
            int r0 = r0.f5479d
            int r1 = r12.I
            r5 = 2
            r1 = r1 & r5
            if (r1 == r5) goto L_0x006b
            goto L_0x0162
        L_0x006b:
            if (r14 != 0) goto L_0x006f
            goto L_0x0162
        L_0x006f:
            android.view.View r1 = r14.f5512b
            if (r15 == 0) goto L_0x0076
            android.view.View r6 = r15.f5512b
            goto L_0x0077
        L_0x0076:
            r6 = r2
        L_0x0077:
            int r7 = d.t.f.save_overlay_view
            java.lang.Object r7 = r1.getTag(r7)
            android.view.View r7 = (android.view.View) r7
            if (r7 == 0) goto L_0x0085
            r6 = r2
            r8 = r3
            goto L_0x00eb
        L_0x0085:
            if (r6 == 0) goto L_0x0098
            android.view.ViewParent r7 = r6.getParent()
            if (r7 != 0) goto L_0x008e
            goto L_0x0098
        L_0x008e:
            r7 = 4
            if (r0 != r7) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            if (r1 != r6) goto L_0x009d
        L_0x0094:
            r8 = r4
            r7 = r6
            r6 = r2
            goto L_0x00a0
        L_0x0098:
            if (r6 == 0) goto L_0x009d
            r7 = r2
            r8 = r4
            goto L_0x00a0
        L_0x009d:
            r6 = r2
            r7 = r6
            r8 = r3
        L_0x00a0:
            if (r8 == 0) goto L_0x00e7
            android.view.ViewParent r8 = r1.getParent()
            if (r8 != 0) goto L_0x00a9
            goto L_0x00e3
        L_0x00a9:
            android.view.ViewParent r8 = r1.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x00e7
            android.view.ViewParent r8 = r1.getParent()
            android.view.View r8 = (android.view.View) r8
            d.t.q r9 = r12.c(r8, r3)
            d.t.q r10 = r12.b(r8, r3)
            d.t.d0$b r9 = r12.b(r9, r10)
            boolean r9 = r9.f5476a
            if (r9 != 0) goto L_0x00cc
            android.view.View r6 = d.t.p.a(r13, r1, r8)
            goto L_0x00e7
        L_0x00cc:
            int r9 = r8.getId()
            android.view.ViewParent r8 = r8.getParent()
            if (r8 != 0) goto L_0x00e7
            r8 = -1
            if (r9 == r8) goto L_0x00e7
            android.view.View r8 = r13.findViewById(r9)
            if (r8 == 0) goto L_0x00e7
            boolean r8 = r12.v
            if (r8 == 0) goto L_0x00e7
        L_0x00e3:
            r8 = r4
            r6 = r7
            r7 = r1
            goto L_0x00eb
        L_0x00e7:
            r8 = r4
            r11 = r7
            r7 = r6
            r6 = r11
        L_0x00eb:
            if (r7 == 0) goto L_0x013d
            if (r8 != 0) goto L_0x011f
            java.util.Map<java.lang.String, java.lang.Object> r0 = r14.f5511a
            java.lang.String r2 = "android:visibility:screenLocation"
            java.lang.Object r0 = r0.get(r2)
            int[] r0 = (int[]) r0
            r2 = r0[r4]
            r0 = r0[r3]
            int[] r5 = new int[r5]
            r13.getLocationOnScreen(r5)
            r4 = r5[r4]
            int r2 = r2 - r4
            int r4 = r7.getLeft()
            int r2 = r2 - r4
            r7.offsetLeftAndRight(r2)
            r2 = r5[r3]
            int r0 = r0 - r2
            int r2 = r7.getTop()
            int r0 = r0 - r2
            r7.offsetTopAndBottom(r0)
            android.view.ViewGroupOverlay r0 = r13.getOverlay()
            r0.add(r7)
        L_0x011f:
            android.animation.Animator r2 = r12.a(r13, r7, r14, r15)
            if (r8 != 0) goto L_0x0162
            if (r2 != 0) goto L_0x012f
            android.view.ViewGroupOverlay r13 = r13.getOverlay()
            r13.remove(r7)
            goto L_0x0162
        L_0x012f:
            int r14 = d.t.f.save_overlay_view
            r1.setTag(r14, r7)
            d.t.c0 r14 = new d.t.c0
            r14.<init>(r12, r13, r7, r1)
            r12.a(r14)
            goto L_0x0162
        L_0x013d:
            if (r6 == 0) goto L_0x0162
            int r1 = r6.getVisibility()
            d.t.b0 r2 = d.t.v.f5520a
            r2.a(r6, r4)
            android.animation.Animator r2 = r12.a(r13, r6, r14, r15)
            if (r2 == 0) goto L_0x015d
            d.t.d0$a r13 = new d.t.d0$a
            r13.<init>(r6, r0, r3)
            r2.addListener(r13)
            r2.addPauseListener(r13)
            r12.a(r13)
            goto L_0x0162
        L_0x015d:
            d.t.b0 r13 = d.t.v.f5520a
            r13.a(r6, r1)
        L_0x0162:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.t.d0.a(android.view.ViewGroup, d.t.q, d.t.q):android.animation.Animator");
    }

    public final b b(q qVar, q qVar2) {
        b bVar = new b();
        bVar.f5476a = false;
        bVar.f5477b = false;
        String str = "android:visibility:parent";
        String str2 = "android:visibility:visibility";
        if (qVar == null || !qVar.f5511a.containsKey(str2)) {
            bVar.f5478c = -1;
            bVar.f5480e = null;
        } else {
            bVar.f5478c = ((Integer) qVar.f5511a.get(str2)).intValue();
            bVar.f5480e = (ViewGroup) qVar.f5511a.get(str);
        }
        if (qVar2 == null || !qVar2.f5511a.containsKey(str2)) {
            bVar.f5479d = -1;
            bVar.f5481f = null;
        } else {
            bVar.f5479d = ((Integer) qVar2.f5511a.get(str2)).intValue();
            bVar.f5481f = (ViewGroup) qVar2.f5511a.get(str);
        }
        if (qVar == null || qVar2 == null) {
            if (qVar == null && bVar.f5479d == 0) {
                bVar.f5477b = true;
                bVar.f5476a = true;
            } else if (qVar2 == null && bVar.f5478c == 0) {
                bVar.f5477b = false;
                bVar.f5476a = true;
            }
        } else if (bVar.f5478c == bVar.f5479d && bVar.f5480e == bVar.f5481f) {
            return bVar;
        } else {
            int i2 = bVar.f5478c;
            int i3 = bVar.f5479d;
            if (i2 != i3) {
                if (i2 == 0) {
                    bVar.f5477b = false;
                    bVar.f5476a = true;
                } else if (i3 == 0) {
                    bVar.f5477b = true;
                    bVar.f5476a = true;
                }
            } else if (bVar.f5481f == null) {
                bVar.f5477b = false;
                bVar.f5476a = true;
            } else if (bVar.f5480e == null) {
                bVar.f5477b = true;
                bVar.f5476a = true;
            }
        }
        return bVar;
    }

    public boolean a(q qVar, q qVar2) {
        boolean z = false;
        if (qVar == null && qVar2 == null) {
            return false;
        }
        if (!(qVar == null || qVar2 == null)) {
            String str = "android:visibility:visibility";
            if (qVar2.f5511a.containsKey(str) != qVar.f5511a.containsKey(str)) {
                return false;
            }
        }
        b b2 = b(qVar, qVar2);
        if (b2.f5476a && (b2.f5478c == 0 || b2.f5479d == 0)) {
            z = true;
        }
        return z;
    }
}
