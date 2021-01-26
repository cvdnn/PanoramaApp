package d.n.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import d.e.g;
import d.h.k.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition */
public class v {

    /* renamed from: a reason: collision with root package name */
    public static final int[] f5233a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b reason: collision with root package name */
    public static final a0 f5234b = new w();

    /* renamed from: c reason: collision with root package name */
    public static final a0 f5235c;

    /* compiled from: FragmentTransition */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public Fragment f5236a;

        /* renamed from: b reason: collision with root package name */
        public boolean f5237b;

        /* renamed from: c reason: collision with root package name */
        public a f5238c;

        /* renamed from: d reason: collision with root package name */
        public Fragment f5239d;

        /* renamed from: e reason: collision with root package name */
        public boolean f5240e;

        /* renamed from: f reason: collision with root package name */
        public a f5241f;
    }

    static {
        a0 a0Var;
        try {
            a0Var = (a0) Class.forName("d.t.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            a0Var = null;
        }
        f5235c = a0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x044f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0222 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(d.n.a.j r39, java.util.ArrayList<d.n.a.a> r40, java.util.ArrayList<java.lang.Boolean> r41, int r42, int r43, boolean r44) {
        /*
            r0 = r39
            r1 = r40
            r2 = r41
            r3 = r43
            r4 = r44
            int r5 = r0.o
            r6 = 1
            if (r5 >= r6) goto L_0x0010
            return
        L_0x0010:
            android.util.SparseArray r5 = new android.util.SparseArray
            r5.<init>()
            r7 = r42
        L_0x0017:
            r8 = 0
            if (r7 >= r3) goto L_0x0068
            java.lang.Object r9 = r1.get(r7)
            d.n.a.a r9 = (d.n.a.a) r9
            java.lang.Object r10 = r2.get(r7)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x004e
            d.n.a.j r8 = r9.r
            d.n.a.e r8 = r8.q
            boolean r8 = r8.a()
            if (r8 != 0) goto L_0x0037
            goto L_0x0065
        L_0x0037:
            java.util.ArrayList<d.n.a.q$a> r8 = r9.f5189a
            int r8 = r8.size()
            int r8 = r8 - r6
        L_0x003e:
            if (r8 < 0) goto L_0x0065
            java.util.ArrayList<d.n.a.q$a> r10 = r9.f5189a
            java.lang.Object r10 = r10.get(r8)
            d.n.a.q$a r10 = (d.n.a.q.a) r10
            a(r9, r10, r5, r6, r4)
            int r8 = r8 + -1
            goto L_0x003e
        L_0x004e:
            java.util.ArrayList<d.n.a.q$a> r10 = r9.f5189a
            int r10 = r10.size()
            r11 = r8
        L_0x0055:
            if (r11 >= r10) goto L_0x0065
            java.util.ArrayList<d.n.a.q$a> r12 = r9.f5189a
            java.lang.Object r12 = r12.get(r11)
            d.n.a.q$a r12 = (d.n.a.q.a) r12
            a(r9, r12, r5, r8, r4)
            int r11 = r11 + 1
            goto L_0x0055
        L_0x0065:
            int r7 = r7 + 1
            goto L_0x0017
        L_0x0068:
            int r7 = r5.size()
            if (r7 == 0) goto L_0x0463
            android.view.View r7 = new android.view.View
            d.n.a.h r9 = r0.p
            android.content.Context r9 = r9.f5122b
            r7.<init>(r9)
            int r15 = r5.size()
            r14 = r8
        L_0x007c:
            if (r14 >= r15) goto L_0x0463
            int r9 = r5.keyAt(r14)
            d.e.a r13 = new d.e.a
            r13.<init>()
            int r10 = r3 + -1
            r12 = r42
        L_0x008b:
            if (r10 < r12) goto L_0x00f6
            java.lang.Object r11 = r1.get(r10)
            d.n.a.a r11 = (d.n.a.a) r11
            boolean r16 = r11.b(r9)
            if (r16 != 0) goto L_0x009a
            goto L_0x00eb
        L_0x009a:
            java.lang.Object r16 = r2.get(r10)
            java.lang.Boolean r16 = (java.lang.Boolean) r16
            boolean r16 = r16.booleanValue()
            java.util.ArrayList<java.lang.String> r6 = r11.n
            if (r6 == 0) goto L_0x00eb
            int r6 = r6.size()
            if (r16 == 0) goto L_0x00b3
            java.util.ArrayList<java.lang.String> r8 = r11.n
            java.util.ArrayList<java.lang.String> r11 = r11.o
            goto L_0x00bc
        L_0x00b3:
            java.util.ArrayList<java.lang.String> r8 = r11.n
            java.util.ArrayList<java.lang.String> r11 = r11.o
            r38 = r11
            r11 = r8
            r8 = r38
        L_0x00bc:
            r1 = 0
        L_0x00bd:
            if (r1 >= r6) goto L_0x00eb
            java.lang.Object r16 = r11.get(r1)
            r2 = r16
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r16 = r8.get(r1)
            r3 = r16
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r16 = r13.remove(r3)
            r17 = r6
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00df
            r13.put(r2, r6)
            goto L_0x00e2
        L_0x00df:
            r13.put(r2, r3)
        L_0x00e2:
            int r1 = r1 + 1
            r2 = r41
            r3 = r43
            r6 = r17
            goto L_0x00bd
        L_0x00eb:
            int r10 = r10 + -1
            r1 = r40
            r2 = r41
            r3 = r43
            r6 = 1
            r8 = 0
            goto L_0x008b
        L_0x00f6:
            java.lang.Object r1 = r5.valueAt(r14)
            d.n.a.v$a r1 = (d.n.a.v.a) r1
            if (r4 == 0) goto L_0x02ec
            d.n.a.e r3 = r0.q
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x010f
            d.n.a.e r3 = r0.q
            android.view.View r3 = r3.a(r9)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            goto L_0x0110
        L_0x010f:
            r3 = 0
        L_0x0110:
            if (r3 != 0) goto L_0x011a
        L_0x0112:
            r31 = r5
            r32 = r14
            r33 = r15
            goto L_0x02e5
        L_0x011a:
            androidx.fragment.app.Fragment r6 = r1.f5236a
            androidx.fragment.app.Fragment r8 = r1.f5239d
            d.n.a.a0 r9 = a(r8, r6)
            if (r9 != 0) goto L_0x0125
            goto L_0x0112
        L_0x0125:
            boolean r10 = r1.f5237b
            boolean r11 = r1.f5240e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r31 = r5
            java.lang.Object r5 = a(r9, r6, r10)
            java.lang.Object r11 = b(r9, r8, r11)
            androidx.fragment.app.Fragment r12 = r1.f5236a
            r32 = r14
            androidx.fragment.app.Fragment r14 = r1.f5239d
            r33 = r15
            if (r12 == 0) goto L_0x014f
            android.view.View r15 = r12.requireView()
            r0 = 0
            r15.setVisibility(r0)
        L_0x014f:
            if (r12 == 0) goto L_0x01ef
            if (r14 != 0) goto L_0x0155
            goto L_0x01ef
        L_0x0155:
            boolean r0 = r1.f5237b
            boolean r15 = r13.isEmpty()
            if (r15 == 0) goto L_0x0161
            r34 = r10
            r15 = 0
            goto L_0x0167
        L_0x0161:
            java.lang.Object r15 = a(r9, r12, r14, r0)
            r34 = r10
        L_0x0167:
            d.e.a r10 = b(r9, r13, r15, r1)
            r35 = r6
            d.e.a r6 = a(r9, r13, r15, r1)
            boolean r16 = r13.isEmpty()
            if (r16 == 0) goto L_0x0183
            if (r10 == 0) goto L_0x017c
            r10.clear()
        L_0x017c:
            if (r6 == 0) goto L_0x0181
            r6.clear()
        L_0x0181:
            r15 = 0
            goto L_0x0195
        L_0x0183:
            r16 = r15
            java.util.Set r15 = r13.keySet()
            a(r4, r10, r15)
            java.util.Collection r15 = r13.values()
            a(r2, r6, r15)
            r15 = r16
        L_0x0195:
            if (r5 != 0) goto L_0x019e
            if (r11 != 0) goto L_0x019e
            if (r15 != 0) goto L_0x019e
            r37 = r2
            goto L_0x01f5
        L_0x019e:
            r36 = r13
            r13 = 1
            a(r12, r14, r0, r10, r13)
            if (r15 == 0) goto L_0x01d4
            r2.add(r7)
            r9.b(r15, r7, r4)
            boolean r13 = r1.f5240e
            r37 = r2
            d.n.a.a r2 = r1.f5241f
            r16 = r9
            r17 = r15
            r18 = r11
            r19 = r10
            r20 = r13
            r21 = r2
            a(r16, r17, r18, r19, r20, r21)
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.view.View r1 = a(r6, r1, r5, r0)
            if (r1 == 0) goto L_0x01cf
            r9.a(r5, r2)
        L_0x01cf:
            r27 = r1
            r29 = r2
            goto L_0x01da
        L_0x01d4:
            r37 = r2
            r27 = 0
            r29 = 0
        L_0x01da:
            d.n.a.t r1 = new d.n.a.t
            r22 = r1
            r23 = r12
            r24 = r14
            r25 = r0
            r26 = r6
            r28 = r9
            r22.<init>(r23, r24, r25, r26, r27, r28, r29)
            d.h.k.l.a(r3, r1)
            goto L_0x01f8
        L_0x01ef:
            r37 = r2
            r35 = r6
            r34 = r10
        L_0x01f5:
            r36 = r13
            r15 = 0
        L_0x01f8:
            if (r5 != 0) goto L_0x0200
            if (r15 != 0) goto L_0x0200
            if (r11 != 0) goto L_0x0200
            goto L_0x02e5
        L_0x0200:
            java.util.ArrayList r0 = a(r9, r11, r8, r4, r7)
            r1 = r35
            r2 = r37
            java.util.ArrayList r6 = a(r9, r5, r1, r2, r7)
            r10 = 4
            a(r6, r10)
            r16 = r9
            r17 = r5
            r18 = r11
            r19 = r15
            r20 = r1
            r21 = r34
            java.lang.Object r1 = a(r16, r17, r18, r19, r20, r21)
            if (r1 == 0) goto L_0x02e5
            if (r8 == 0) goto L_0x0247
            if (r11 == 0) goto L_0x0247
            boolean r10 = r8.mAdded
            if (r10 == 0) goto L_0x0247
            boolean r10 = r8.mHidden
            if (r10 == 0) goto L_0x0247
            boolean r10 = r8.mHiddenChanged
            if (r10 == 0) goto L_0x0247
            r10 = 1
            r8.setHideReplaced(r10)
            android.view.View r10 = r8.getView()
            r9.a(r11, r10, r0)
            android.view.ViewGroup r8 = r8.mContainer
            d.n.a.r r10 = new d.n.a.r
            r10.<init>(r0)
            d.h.k.l.a(r8, r10)
        L_0x0247:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            int r10 = r2.size()
            r12 = 0
        L_0x0251:
            if (r12 >= r10) goto L_0x0267
            java.lang.Object r13 = r2.get(r12)
            android.view.View r13 = (android.view.View) r13
            java.lang.String r14 = d.h.k.m.s(r13)
            r8.add(r14)
            r14 = 0
            r13.setTransitionName(r14)
            int r12 = r12 + 1
            goto L_0x0251
        L_0x0267:
            r22 = r9
            r23 = r1
            r24 = r5
            r25 = r6
            r26 = r11
            r27 = r0
            r28 = r15
            r29 = r2
            r22.a(r23, r24, r25, r26, r27, r28, r29)
            r9.a(r3, r1)
            int r0 = r2.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5 = 0
        L_0x0287:
            if (r5 >= r0) goto L_0x02c7
            java.lang.Object r10 = r4.get(r5)
            android.view.View r10 = (android.view.View) r10
            java.lang.String r11 = d.h.k.m.s(r10)
            r1.add(r11)
            if (r11 != 0) goto L_0x029b
            r13 = r36
            goto L_0x02c2
        L_0x029b:
            r14 = 0
            r10.setTransitionName(r14)
            r13 = r36
            java.lang.Object r10 = r13.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            r12 = 0
        L_0x02a8:
            if (r12 >= r0) goto L_0x02c2
            java.lang.Object r14 = r8.get(r12)
            boolean r14 = r10.equals(r14)
            if (r14 == 0) goto L_0x02be
            java.lang.Object r10 = r2.get(r12)
            android.view.View r10 = (android.view.View) r10
            r10.setTransitionName(r11)
            goto L_0x02c2
        L_0x02be:
            int r12 = r12 + 1
            r14 = 0
            goto L_0x02a8
        L_0x02c2:
            int r5 = r5 + 1
            r36 = r13
            goto L_0x0287
        L_0x02c7:
            d.n.a.x r5 = new d.n.a.x
            r22 = r5
            r23 = r9
            r24 = r0
            r25 = r2
            r26 = r8
            r27 = r4
            r28 = r1
            r22.<init>(r23, r24, r25, r26, r27, r28)
            d.h.k.l.a(r3, r5)
            r0 = 0
            a(r6, r0)
            r9.b(r15, r4, r2)
            goto L_0x02e6
        L_0x02e5:
            r0 = 0
        L_0x02e6:
            r27 = r32
            r30 = r33
            goto L_0x044f
        L_0x02ec:
            r31 = r5
            r32 = r14
            r33 = r15
            r0 = 0
            r2 = r39
            d.n.a.e r3 = r2.q
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0308
            d.n.a.e r3 = r2.q
            android.view.View r3 = r3.a(r9)
            r14 = r3
            android.view.ViewGroup r14 = (android.view.ViewGroup) r14
            r3 = r14
            goto L_0x0309
        L_0x0308:
            r3 = 0
        L_0x0309:
            if (r3 != 0) goto L_0x030c
            goto L_0x02e6
        L_0x030c:
            androidx.fragment.app.Fragment r4 = r1.f5236a
            androidx.fragment.app.Fragment r5 = r1.f5239d
            d.n.a.a0 r6 = a(r5, r4)
            if (r6 != 0) goto L_0x0317
            goto L_0x02e6
        L_0x0317:
            boolean r8 = r1.f5237b
            boolean r9 = r1.f5240e
            java.lang.Object r8 = a(r6, r4, r8)
            java.lang.Object r12 = b(r6, r5, r9)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            androidx.fragment.app.Fragment r9 = r1.f5236a
            androidx.fragment.app.Fragment r15 = r1.f5239d
            if (r9 == 0) goto L_0x03cf
            if (r15 != 0) goto L_0x0337
            goto L_0x03cf
        L_0x0337:
            boolean r14 = r1.f5237b
            boolean r16 = r13.isEmpty()
            if (r16 == 0) goto L_0x0341
            r0 = 0
            goto L_0x0347
        L_0x0341:
            java.lang.Object r16 = a(r6, r9, r15, r14)
            r0 = r16
        L_0x0347:
            d.e.a r2 = b(r6, r13, r0, r1)
            boolean r16 = r13.isEmpty()
            if (r16 == 0) goto L_0x0353
            r0 = 0
            goto L_0x035e
        L_0x0353:
            r16 = r0
            java.util.Collection r0 = r2.values()
            r11.addAll(r0)
            r0 = r16
        L_0x035e:
            if (r8 != 0) goto L_0x0366
            if (r12 != 0) goto L_0x0366
            if (r0 != 0) goto L_0x0366
            goto L_0x03cf
        L_0x0366:
            r22 = r4
            r4 = 1
            a(r9, r15, r14, r2, r4)
            if (r0 == 0) goto L_0x0395
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r6.b(r0, r7, r11)
            r20 = r9
            boolean r9 = r1.f5240e
            r21 = r10
            d.n.a.a r10 = r1.f5241f
            r23 = r14
            r14 = r6
            r24 = r15
            r15 = r0
            r16 = r12
            r17 = r2
            r18 = r9
            r19 = r10
            a(r14, r15, r16, r17, r18, r19)
            if (r8 == 0) goto L_0x039e
            r6.a(r8, r4)
            goto L_0x039e
        L_0x0395:
            r20 = r9
            r21 = r10
            r23 = r14
            r24 = r15
            r4 = 0
        L_0x039e:
            d.n.a.u r2 = new d.n.a.u
            r16 = r20
            r9 = r2
            r15 = r21
            r10 = r6
            r14 = r11
            r11 = r13
            r25 = r5
            r5 = r12
            r12 = r0
            r26 = r0
            r0 = r13
            r13 = r1
            r28 = r14
            r27 = r32
            r29 = 0
            r14 = r15
            r32 = r15
            r30 = r33
            r15 = r7
            r17 = r24
            r18 = r23
            r19 = r28
            r20 = r8
            r21 = r4
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            d.h.k.l.a(r3, r2)
            r20 = r26
            goto L_0x03e1
        L_0x03cf:
            r22 = r4
            r25 = r5
            r28 = r11
            r5 = r12
            r0 = r13
            r27 = r32
            r30 = r33
            r29 = 0
            r32 = r10
            r20 = r29
        L_0x03e1:
            if (r8 != 0) goto L_0x03e9
            if (r20 != 0) goto L_0x03e9
            if (r5 != 0) goto L_0x03e9
            goto L_0x044f
        L_0x03e9:
            r2 = r25
            r4 = r28
            java.util.ArrayList r2 = a(r6, r5, r2, r4, r7)
            if (r2 == 0) goto L_0x03fc
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x03fa
            goto L_0x03fc
        L_0x03fa:
            r29 = r5
        L_0x03fc:
            r6.a(r8, r7)
            boolean r1 = r1.f5237b
            r14 = r6
            r15 = r8
            r16 = r29
            r17 = r20
            r18 = r22
            r19 = r1
            java.lang.Object r1 = a(r14, r15, r16, r17, r18, r19)
            if (r1 == 0) goto L_0x044f
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r14 = r6
            r15 = r1
            r16 = r8
            r17 = r4
            r18 = r29
            r19 = r2
            r21 = r32
            r14.a(r15, r16, r17, r18, r19, r20, r21)
            d.n.a.s r5 = new d.n.a.s
            r9 = r5
            r10 = r8
            r11 = r6
            r12 = r7
            r13 = r22
            r14 = r32
            r15 = r4
            r16 = r2
            r17 = r29
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            d.h.k.l.a(r3, r5)
            d.n.a.y r2 = new d.n.a.y
            r4 = r32
            r2.<init>(r6, r4, r0)
            d.h.k.l.a(r3, r2)
            r6.a(r3, r1)
            d.n.a.z r1 = new d.n.a.z
            r1.<init>(r6, r4, r0)
            d.h.k.l.a(r3, r1)
        L_0x044f:
            int r14 = r27 + 1
            r0 = r39
            r1 = r40
            r2 = r41
            r3 = r43
            r4 = r44
            r15 = r30
            r5 = r31
            r6 = 1
            r8 = 0
            goto L_0x007c
        L_0x0463:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.v.a(d.n.a.j, java.util.ArrayList, java.util.ArrayList, int, int, boolean):void");
    }

    public static Object b(a0 a0Var, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return a0Var.b(obj);
    }

    public static d.e.a<String, View> b(a0 a0Var, d.e.a<String, String> aVar, Object obj, a aVar2) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = aVar2.f5239d;
        d.e.a<String, View> aVar3 = new d.e.a<>();
        a0Var.a((Map<String, View>) aVar3, fragment.requireView());
        a aVar4 = aVar2.f5241f;
        if (aVar2.f5240e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar4.o;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar4.n;
        }
        g.a((Map<K, V>) aVar3, (Collection<?>) arrayList);
        g.a((Map<K, V>) aVar, (Collection<?>) aVar3.keySet());
        return aVar3;
    }

    public static a0 a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        a0 a0Var = f5234b;
        if (a0Var != null && a(a0Var, (List<Object>) arrayList)) {
            return f5234b;
        }
        a0 a0Var2 = f5235c;
        if (a0Var2 != null && a(a0Var2, (List<Object>) arrayList)) {
            return f5235c;
        }
        if (f5234b == null && f5235c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static boolean a(a0 a0Var, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!a0Var.a(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static Object a(a0 a0Var, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return a0Var.c(a0Var.b(obj));
    }

    public static Object a(a0 a0Var, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return a0Var.b(obj);
    }

    public static void a(ArrayList<View> arrayList, d.e.a<String, View> aVar, Collection<String> collection) {
        for (int i2 = aVar.f4602c - 1; i2 >= 0; i2--) {
            View view = (View) aVar.e(i2);
            if (collection.contains(m.s(view))) {
                arrayList.add(view);
            }
        }
    }

    public static d.e.a<String, View> a(a0 a0Var, d.e.a<String, String> aVar, Object obj, a aVar2) {
        ArrayList<String> arrayList;
        Fragment fragment = aVar2.f5236a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        d.e.a<String, View> aVar3 = new d.e.a<>();
        a0Var.a((Map<String, View>) aVar3, view);
        a aVar4 = aVar2.f5238c;
        if (aVar2.f5237b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar4.n;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar4.o;
        }
        if (arrayList != null) {
            g.a((Map<K, V>) aVar3, (Collection<?>) arrayList);
            g.a((Map<K, V>) aVar3, aVar.values());
        }
        int i2 = aVar.f4602c;
        while (true) {
            i2--;
            if (i2 < 0) {
                return aVar3;
            }
            if (!aVar3.containsKey((String) aVar.e(i2))) {
                aVar.d(i2);
            }
        }
    }

    public static View a(d.e.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        String str;
        a aVar3 = aVar2.f5238c;
        if (!(obj == null || aVar == null)) {
            ArrayList<String> arrayList = aVar3.n;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (z) {
                    str = (String) aVar3.n.get(0);
                } else {
                    str = (String) aVar3.o.get(0);
                }
                return (View) aVar.get(str);
            }
        }
        return null;
    }

    public static void a(a0 a0Var, Object obj, Object obj2, d.e.a<String, View> aVar, boolean z, a aVar2) {
        String str;
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = (String) aVar2.o.get(0);
            } else {
                str = (String) aVar2.n.get(0);
            }
            View view = (View) aVar.get(str);
            a0Var.c(obj, view);
            if (obj2 != null) {
                a0Var.c(obj2, view);
            }
        }
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z, d.e.a<String, View> aVar, boolean z2) {
        if (z) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static ArrayList<View> a(a0 a0Var, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            a0Var.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        a0Var.a(obj, arrayList2);
        return arrayList2;
    }

    public static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i2);
            }
        }
    }

    public static Object a(a0 a0Var, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        if (z2) {
            return a0Var.b(obj2, obj, obj3);
        }
        return a0Var.a(obj2, obj, obj3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r10.mAdded != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0074, code lost:
        if (r10.mPostponedAlpha >= 0.0f) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x007d, code lost:
        if (r10.mHidden == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007f, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0091, code lost:
        if (r10.mHidden == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0093, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(d.n.a.a r16, d.n.a.q.a r17, android.util.SparseArray<d.n.a.v.a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.Fragment r10 = r1.f5200b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f5233a
            int r1 = r1.f5199a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f5199a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x0086
            r6 = 3
            if (r1 == r6) goto L_0x005f
            r6 = 4
            if (r1 == r6) goto L_0x0047
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x005f
            r6 = 7
            if (r1 == r6) goto L_0x0086
            r1 = r4
            r12 = r1
            r13 = r12
            goto L_0x009a
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x0095
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0095
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0095
            goto L_0x0093
        L_0x0044:
            boolean r1 = r10.mHidden
            goto L_0x0096
        L_0x0047:
            if (r20 == 0) goto L_0x0056
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x0081
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0081
            boolean r1 = r10.mHidden
            if (r1 == 0) goto L_0x0081
            goto L_0x007f
        L_0x0056:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0081
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0081
            goto L_0x007f
        L_0x005f:
            if (r20 == 0) goto L_0x0077
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x0081
            android.view.View r1 = r10.mView
            if (r1 == 0) goto L_0x0081
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0081
            float r1 = r10.mPostponedAlpha
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0081
            goto L_0x007f
        L_0x0077:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0081
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0081
        L_0x007f:
            r1 = r5
            goto L_0x0082
        L_0x0081:
            r1 = r4
        L_0x0082:
            r13 = r1
            r1 = r4
            r12 = r5
            goto L_0x009a
        L_0x0086:
            if (r20 == 0) goto L_0x008b
            boolean r1 = r10.mIsNewlyAdded
            goto L_0x0096
        L_0x008b:
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x0095
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0095
        L_0x0093:
            r1 = r5
            goto L_0x0096
        L_0x0095:
            r1 = r4
        L_0x0096:
            r12 = r4
            r13 = r12
            r4 = r1
            r1 = r5
        L_0x009a:
            java.lang.Object r6 = r2.get(r11)
            d.n.a.v$a r6 = (d.n.a.v.a) r6
            if (r4 == 0) goto L_0x00b3
            if (r6 != 0) goto L_0x00ad
            d.n.a.v$a r4 = new d.n.a.v$a
            r4.<init>()
            r2.put(r11, r4)
            r6 = r4
        L_0x00ad:
            r6.f5236a = r10
            r6.f5237b = r3
            r6.f5238c = r0
        L_0x00b3:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00da
            if (r1 == 0) goto L_0x00da
            if (r14 == 0) goto L_0x00c1
            androidx.fragment.app.Fragment r1 = r14.f5239d
            if (r1 != r10) goto L_0x00c1
            r14.f5239d = r15
        L_0x00c1:
            d.n.a.j r4 = r0.r
            int r1 = r10.mState
            if (r1 >= r5) goto L_0x00da
            int r1 = r4.o
            if (r1 < r5) goto L_0x00da
            boolean r1 = r0.p
            if (r1 != 0) goto L_0x00da
            r4.f(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.a(r5, r6, r7, r8, r9)
        L_0x00da:
            if (r13 == 0) goto L_0x00f3
            if (r14 == 0) goto L_0x00e2
            androidx.fragment.app.Fragment r1 = r14.f5239d
            if (r1 != 0) goto L_0x00f3
        L_0x00e2:
            if (r14 != 0) goto L_0x00ed
            d.n.a.v$a r1 = new d.n.a.v$a
            r1.<init>()
            r2.put(r11, r1)
            r14 = r1
        L_0x00ed:
            r14.f5239d = r10
            r14.f5240e = r3
            r14.f5241f = r0
        L_0x00f3:
            if (r20 != 0) goto L_0x00ff
            if (r12 == 0) goto L_0x00ff
            if (r14 == 0) goto L_0x00ff
            androidx.fragment.app.Fragment r0 = r14.f5236a
            if (r0 != r10) goto L_0x00ff
            r14.f5236a = r15
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.v.a(d.n.a.a, d.n.a.q$a, android.util.SparseArray, boolean, boolean):void");
    }
}
