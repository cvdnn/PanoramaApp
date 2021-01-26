package d.j.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import d.e.i;
import d.h.k.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper */
public abstract class a extends d.h.k.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b<d.h.k.w.b> o = new C0046a();
    public static final c<i<d.h.k.w.b>, d.h.k.w.b> p = new b();

    /* renamed from: d reason: collision with root package name */
    public final Rect f5013d = new Rect();

    /* renamed from: e reason: collision with root package name */
    public final Rect f5014e = new Rect();

    /* renamed from: f reason: collision with root package name */
    public final Rect f5015f = new Rect();

    /* renamed from: g reason: collision with root package name */
    public final int[] f5016g = new int[2];

    /* renamed from: h reason: collision with root package name */
    public final AccessibilityManager f5017h;

    /* renamed from: i reason: collision with root package name */
    public final View f5018i;

    /* renamed from: j reason: collision with root package name */
    public c f5019j;
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    /* renamed from: d.j.b.a$a reason: collision with other inner class name */
    /* compiled from: ExploreByTouchHelper */
    public static class C0046a implements b<d.h.k.w.b> {
        public void a(Object obj, Rect rect) {
            ((d.h.k.w.b) obj).f4953a.getBoundsInParent(rect);
        }
    }

    /* compiled from: ExploreByTouchHelper */
    public static class b implements c<i<d.h.k.w.b>, d.h.k.w.b> {
    }

    /* compiled from: ExploreByTouchHelper */
    public class c extends d.h.k.w.c {
        public c() {
        }

        public d.h.k.w.b a(int i2) {
            return new d.h.k.w.b(AccessibilityNodeInfo.obtain(a.this.d(i2).f4953a));
        }

        public d.h.k.w.b b(int i2) {
            int i3 = i2 == 2 ? a.this.k : a.this.l;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return new d.h.k.w.b(AccessibilityNodeInfo.obtain(a.this.d(i3).f4953a));
        }

        public boolean a(int i2, int i3, Bundle bundle) {
            a aVar = a.this;
            if (i2 == -1) {
                return m.a(aVar.f5018i, i3, bundle);
            }
            boolean z = true;
            if (i3 == 1) {
                return aVar.e(i2);
            }
            if (i3 == 2) {
                return aVar.b(i2);
            }
            if (i3 == 64) {
                if (aVar.f5017h.isEnabled() && aVar.f5017h.isTouchExplorationEnabled()) {
                    int i4 = aVar.k;
                    if (i4 != i2) {
                        if (i4 != Integer.MIN_VALUE) {
                            aVar.a(i4);
                        }
                        aVar.k = i2;
                        aVar.f5018i.invalidate();
                        aVar.a(i2, 32768);
                        return z;
                    }
                }
                z = false;
                return z;
            } else if (i3 != 128) {
                return aVar.a(i2, i3, bundle);
            } else {
                return aVar.a(i2);
            }
        }
    }

    public a(View view) {
        if (view != null) {
            this.f5018i = view;
            this.f5017h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (m.j(view) == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public d.h.k.w.c a(View view) {
        if (this.f5019j == null) {
            this.f5019j = new c();
        }
        return this.f5019j;
    }

    public abstract void a(int i2, d.h.k.w.b bVar);

    public abstract void a(List<Integer> list);

    public abstract boolean a(int i2, int i3, Bundle bundle);

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f4909a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public final d.h.k.w.b c(int i2) {
        d.h.k.w.b o2 = d.h.k.w.b.o();
        o2.f4953a.setEnabled(true);
        o2.f4953a.setFocusable(true);
        o2.f4953a.setClassName("android.view.View");
        o2.f4953a.setBoundsInParent(n);
        o2.f4953a.setBoundsInScreen(n);
        View view = this.f5018i;
        o2.f4954b = -1;
        o2.f4953a.setParent(view);
        a(i2, o2);
        if (o2.g() == null && o2.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        o2.f4953a.getBoundsInParent(this.f5014e);
        if (!this.f5014e.equals(n)) {
            int b2 = o2.b();
            if ((b2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((b2 & 128) == 0) {
                o2.f4953a.setPackageName(this.f5018i.getContext().getPackageName());
                View view2 = this.f5018i;
                o2.f4955c = i2;
                o2.f4953a.setSource(view2, i2);
                boolean z = false;
                if (this.k == i2) {
                    o2.f4953a.setAccessibilityFocused(true);
                    o2.f4953a.addAction(128);
                } else {
                    o2.f4953a.setAccessibilityFocused(false);
                    o2.f4953a.addAction(64);
                }
                boolean z2 = this.l == i2;
                if (z2) {
                    o2.f4953a.addAction(2);
                } else if (o2.k()) {
                    o2.f4953a.addAction(1);
                }
                o2.f4953a.setFocused(z2);
                this.f5018i.getLocationOnScreen(this.f5016g);
                o2.f4953a.getBoundsInScreen(this.f5013d);
                if (this.f5013d.equals(n)) {
                    o2.f4953a.getBoundsInParent(this.f5013d);
                    if (o2.f4954b != -1) {
                        d.h.k.w.b o3 = d.h.k.w.b.o();
                        for (int i3 = o2.f4954b; i3 != -1; i3 = o3.f4954b) {
                            View view3 = this.f5018i;
                            o3.f4954b = -1;
                            o3.f4953a.setParent(view3, -1);
                            o3.f4953a.setBoundsInParent(n);
                            a(i3, o3);
                            o3.f4953a.getBoundsInParent(this.f5014e);
                            Rect rect = this.f5013d;
                            Rect rect2 = this.f5014e;
                            rect.offset(rect2.left, rect2.top);
                        }
                        o3.f4953a.recycle();
                    }
                    this.f5013d.offset(this.f5016g[0] - this.f5018i.getScrollX(), this.f5016g[1] - this.f5018i.getScrollY());
                }
                if (this.f5018i.getLocalVisibleRect(this.f5015f)) {
                    this.f5015f.offset(this.f5016g[0] - this.f5018i.getScrollX(), this.f5016g[1] - this.f5018i.getScrollY());
                    if (this.f5013d.intersect(this.f5015f)) {
                        o2.f4953a.setBoundsInScreen(this.f5013d);
                        Rect rect3 = this.f5013d;
                        if (rect3 != null && !rect3.isEmpty() && this.f5018i.getWindowVisibility() == 0) {
                            ViewParent parent = this.f5018i.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view4 = (View) parent;
                                    if (view4.getAlpha() <= 0.0f || view4.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view4.getParent();
                                } else if (parent != null) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            o2.f4953a.setVisibleToUser(true);
                        }
                    }
                }
                return o2;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    public d.h.k.w.b d(int i2) {
        if (i2 != -1) {
            return c(i2);
        }
        d.h.k.w.b bVar = new d.h.k.w.b(AccessibilityNodeInfo.obtain(this.f5018i));
        m.a(this.f5018i, bVar);
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        if (bVar.c() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                bVar.f4953a.addChild(this.f5018i, ((Integer) arrayList.get(i3)).intValue());
            }
            return bVar;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public final boolean e(int i2) {
        if (!this.f5018i.isFocused() && !this.f5018i.requestFocus()) {
            return false;
        }
        int i3 = this.l;
        if (i3 == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            b(i3);
        }
        this.l = i2;
        com.google.android.material.chip.Chip.b bVar = (com.google.android.material.chip.Chip.b) this;
        if (i2 == 1) {
            Chip chip = Chip.this;
            chip.l = true;
            chip.refreshDrawableState();
        }
        a(i2, 8);
        return true;
    }

    public final void f(int i2) {
        int i3 = this.m;
        if (i3 != i2) {
            this.m = i2;
            a(i2, 128);
            a(i3, 256);
        }
    }

    public final boolean b(int i2) {
        if (this.l != i2) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        com.google.android.material.chip.Chip.b bVar = (com.google.android.material.chip.Chip.b) this;
        if (i2 == 1) {
            Chip chip = Chip.this;
            chip.l = false;
            chip.refreshDrawableState();
        }
        a(i2, 8);
        return true;
    }

    public void a(View view, d.h.k.w.b bVar) {
        this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar.f4953a);
        com.google.android.material.chip.Chip.b bVar2 = (com.google.android.material.chip.Chip.b) this;
        bVar.f4953a.setCheckable(Chip.this.c());
        bVar.f4953a.setClickable(Chip.this.isClickable());
        if (Chip.this.c() || Chip.this.isClickable()) {
            bVar.f4953a.setClassName(Chip.this.c() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            bVar.f4953a.setClassName("android.view.View");
        }
        bVar.f4953a.setText(Chip.this.getText());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x0138;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0142 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r20, android.graphics.Rect r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0.a(r3)
            d.e.i r4 = new d.e.i
            r5 = 10
            r4.<init>(r5)
            r5 = 0
            r6 = r5
        L_0x0017:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0027
            d.h.k.w.b r7 = r0.c(r6)
            r4.c(r6, r7)
            int r6 = r6 + 1
            goto L_0x0017
        L_0x0027:
            int r3 = r0.l
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 != r7) goto L_0x002f
            r3 = 0
            goto L_0x0035
        L_0x002f:
            java.lang.Object r3 = r4.a(r3)
            d.h.k.w.b r3 = (d.h.k.w.b) r3
        L_0x0035:
            r8 = 2
            r9 = -1
            r10 = 1
            if (r1 == r10) goto L_0x0147
            if (r1 == r8) goto L_0x0147
            r8 = 130(0x82, float:1.82E-43)
            r11 = 66
            r12 = 33
            r13 = 17
            if (r1 == r13) goto L_0x0055
            if (r1 == r12) goto L_0x0055
            if (r1 == r11) goto L_0x0055
            if (r1 != r8) goto L_0x004d
            goto L_0x0055
        L_0x004d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1.<init>(r2)
            throw r1
        L_0x0055:
            android.graphics.Rect r14 = new android.graphics.Rect
            r14.<init>()
            int r15 = r0.l
            java.lang.String r6 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            if (r15 == r7) goto L_0x006a
            d.h.k.w.b r2 = r0.d(r15)
            android.view.accessibility.AccessibilityNodeInfo r2 = r2.f4953a
            r2.getBoundsInParent(r14)
            goto L_0x0097
        L_0x006a:
            if (r2 == 0) goto L_0x0070
            r14.set(r2)
            goto L_0x0097
        L_0x0070:
            android.view.View r2 = r0.f5018i
            int r15 = r2.getWidth()
            int r2 = r2.getHeight()
            if (r1 == r13) goto L_0x0094
            if (r1 == r12) goto L_0x0090
            if (r1 == r11) goto L_0x008c
            if (r1 != r8) goto L_0x0086
            r14.set(r5, r9, r15, r9)
            goto L_0x0097
        L_0x0086:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r6)
            throw r1
        L_0x008c:
            r14.set(r9, r5, r9, r2)
            goto L_0x0097
        L_0x0090:
            r14.set(r5, r2, r15, r2)
            goto L_0x0097
        L_0x0094:
            r14.set(r15, r5, r15, r2)
        L_0x0097:
            d.j.b.c<d.e.i<d.h.k.w.b>, d.h.k.w.b> r2 = p
            d.j.b.b<d.h.k.w.b> r15 = o
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>(r14)
            if (r1 == r13) goto L_0x00cb
            if (r1 == r12) goto L_0x00c2
            if (r1 == r11) goto L_0x00b8
            if (r1 != r8) goto L_0x00b2
            int r6 = r14.height()
            int r6 = r6 + r10
            int r6 = -r6
            r7.offset(r5, r6)
            goto L_0x00d3
        L_0x00b2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r6)
            throw r1
        L_0x00b8:
            int r6 = r14.width()
            int r6 = r6 + r10
            int r6 = -r6
            r7.offset(r6, r5)
            goto L_0x00d3
        L_0x00c2:
            int r6 = r14.height()
            int r6 = r6 + r10
            r7.offset(r5, r6)
            goto L_0x00d3
        L_0x00cb:
            int r6 = r14.width()
            int r6 = r6 + r10
            r7.offset(r6, r5)
        L_0x00d3:
            d.j.b.a$b r2 = (d.j.b.a.b) r2
            if (r2 == 0) goto L_0x0145
            int r2 = r4.b()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            r8 = r5
            r16 = 0
        L_0x00e3:
            if (r8 >= r2) goto L_0x01b9
            boolean r11 = r4.f4604a
            if (r11 == 0) goto L_0x00ec
            r4.a()
        L_0x00ec:
            java.lang.Object[] r11 = r4.f4606c
            r11 = r11[r8]
            d.h.k.w.b r11 = (d.h.k.w.b) r11
            if (r11 != r3) goto L_0x00f5
            goto L_0x0142
        L_0x00f5:
            r12 = r15
            d.j.b.a$a r12 = (d.j.b.a.C0046a) r12
            r12.a(r11, r6)
            boolean r12 = a.a.a.a.b.a.a(r14, r6, r1)
            if (r12 != 0) goto L_0x0102
            goto L_0x013a
        L_0x0102:
            boolean r12 = a.a.a.a.b.a.a(r14, r7, r1)
            if (r12 != 0) goto L_0x0109
            goto L_0x0138
        L_0x0109:
            boolean r12 = a.a.a.a.b.a.a(r1, r14, r6, r7)
            if (r12 == 0) goto L_0x0110
            goto L_0x0138
        L_0x0110:
            boolean r12 = a.a.a.a.b.a.a(r1, r14, r7, r6)
            if (r12 == 0) goto L_0x0117
            goto L_0x013a
        L_0x0117:
            int r12 = a.a.a.a.b.a.b(r1, r14, r6)
            int r13 = a.a.a.a.b.a.c(r1, r14, r6)
            int r17 = r12 * 13
            int r17 = r17 * r12
            int r13 = r13 * r13
            int r13 = r13 + r17
            int r12 = a.a.a.a.b.a.b(r1, r14, r7)
            int r17 = a.a.a.a.b.a.c(r1, r14, r7)
            int r18 = r12 * 13
            int r18 = r18 * r12
            int r17 = r17 * r17
            int r12 = r17 + r18
            if (r13 >= r12) goto L_0x013a
        L_0x0138:
            r12 = r10
            goto L_0x013b
        L_0x013a:
            r12 = r5
        L_0x013b:
            if (r12 == 0) goto L_0x0142
            r7.set(r6)
            r16 = r11
        L_0x0142:
            int r8 = r8 + 1
            goto L_0x00e3
        L_0x0145:
            r1 = 0
            throw r1
        L_0x0147:
            android.view.View r2 = r0.f5018i
            int r2 = d.h.k.m.m(r2)
            if (r2 != r10) goto L_0x0151
            r2 = r10
            goto L_0x0152
        L_0x0151:
            r2 = r5
        L_0x0152:
            d.j.b.c<d.e.i<d.h.k.w.b>, d.h.k.w.b> r6 = p
            d.j.b.b<d.h.k.w.b> r7 = o
            d.j.b.a$b r6 = (d.j.b.a.b) r6
            if (r6 == 0) goto L_0x01df
            int r6 = r4.b()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r6)
            r12 = r5
        L_0x0164:
            if (r12 >= r6) goto L_0x0179
            boolean r13 = r4.f4604a
            if (r13 == 0) goto L_0x016d
            r4.a()
        L_0x016d:
            java.lang.Object[] r13 = r4.f4606c
            r13 = r13[r12]
            d.h.k.w.b r13 = (d.h.k.w.b) r13
            r11.add(r13)
            int r12 = r12 + 1
            goto L_0x0164
        L_0x0179:
            d.j.b.d r6 = new d.j.b.d
            r6.<init>(r2, r7)
            java.util.Collections.sort(r11, r6)
            if (r1 == r10) goto L_0x01a3
            if (r1 != r8) goto L_0x019b
            int r1 = r11.size()
            if (r3 != 0) goto L_0x018d
            r2 = r9
            goto L_0x0191
        L_0x018d:
            int r2 = r11.lastIndexOf(r3)
        L_0x0191:
            int r2 = r2 + r10
            if (r2 >= r1) goto L_0x0199
            java.lang.Object r6 = r11.get(r2)
            goto L_0x01b5
        L_0x0199:
            r6 = 0
            goto L_0x01b5
        L_0x019b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}."
            r1.<init>(r2)
            throw r1
        L_0x01a3:
            int r1 = r11.size()
            if (r3 != 0) goto L_0x01aa
            goto L_0x01ae
        L_0x01aa:
            int r1 = r11.indexOf(r3)
        L_0x01ae:
            int r1 = r1 + r9
            if (r1 < 0) goto L_0x0199
            java.lang.Object r6 = r11.get(r1)
        L_0x01b5:
            r16 = r6
            d.h.k.w.b r16 = (d.h.k.w.b) r16
        L_0x01b9:
            r1 = r16
            if (r1 != 0) goto L_0x01c0
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x01da
        L_0x01c0:
            boolean r2 = r4.f4604a
            if (r2 == 0) goto L_0x01c7
            r4.a()
        L_0x01c7:
            int r2 = r4.f4607d
            if (r5 >= r2) goto L_0x01d6
            java.lang.Object[] r2 = r4.f4606c
            r2 = r2[r5]
            if (r2 != r1) goto L_0x01d3
            r9 = r5
            goto L_0x01d6
        L_0x01d3:
            int r5 = r5 + 1
            goto L_0x01c7
        L_0x01d6:
            int r7 = r4.b(r9)
        L_0x01da:
            boolean r1 = r0.e(r7)
            return r1
        L_0x01df:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.j.b.a.a(int, android.graphics.Rect):boolean");
    }

    public final boolean a(int i2, int i3) {
        AccessibilityEvent accessibilityEvent;
        if (i2 == Integer.MIN_VALUE || !this.f5017h.isEnabled()) {
            return false;
        }
        ViewParent parent = this.f5018i.getParent();
        if (parent == null) {
            return false;
        }
        if (i2 != -1) {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            d.h.k.w.b d2 = d(i2);
            accessibilityEvent.getText().add(d2.g());
            accessibilityEvent.setContentDescription(d2.e());
            accessibilityEvent.setScrollable(d2.m());
            accessibilityEvent.setPassword(d2.f4953a.isPassword());
            accessibilityEvent.setEnabled(d2.j());
            accessibilityEvent.setChecked(d2.f4953a.isChecked());
            if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
                accessibilityEvent.setClassName(d2.d());
                accessibilityEvent.setSource(this.f5018i, i2);
                accessibilityEvent.setPackageName(this.f5018i.getContext().getPackageName());
            } else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        } else {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            this.f5018i.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        return parent.requestSendAccessibilityEvent(this.f5018i, accessibilityEvent);
    }

    public final boolean a(int i2) {
        if (this.k != i2) {
            return false;
        }
        this.k = Integer.MIN_VALUE;
        this.f5018i.invalidate();
        a(i2, 65536);
        return true;
    }
}
