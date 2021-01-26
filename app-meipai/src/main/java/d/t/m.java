package d.t;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import d.t.i.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager */
public class m {

    /* renamed from: a reason: collision with root package name */
    public static i f5501a = new a();

    /* renamed from: b reason: collision with root package name */
    public static ThreadLocal<WeakReference<d.e.a<ViewGroup, ArrayList<i>>>> f5502b = new ThreadLocal<>();

    /* renamed from: c reason: collision with root package name */
    public static ArrayList<ViewGroup> f5503c = new ArrayList<>();

    /* compiled from: TransitionManager */
    public static class a implements OnPreDrawListener, OnAttachStateChangeListener {

        /* renamed from: a reason: collision with root package name */
        public i f5504a;

        /* renamed from: b reason: collision with root package name */
        public ViewGroup f5505b;

        /* renamed from: d.t.m$a$a reason: collision with other inner class name */
        /* compiled from: TransitionManager */
        public class C0058a extends l {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ d.e.a f5506a;

            public C0058a(d.e.a aVar) {
                this.f5506a = aVar;
            }

            public void c(i iVar) {
                ((ArrayList) this.f5506a.get(a.this.f5505b)).remove(iVar);
                iVar.b((d) this);
            }
        }

        public a(i iVar, ViewGroup viewGroup) {
            this.f5504a = iVar;
            this.f5505b = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x02b0  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onPreDraw() {
            /*
                r19 = this;
                r0 = r19
                android.view.ViewGroup r1 = r0.f5505b
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                r1.removeOnPreDrawListener(r0)
                android.view.ViewGroup r1 = r0.f5505b
                r1.removeOnAttachStateChangeListener(r0)
                java.util.ArrayList<android.view.ViewGroup> r1 = d.t.m.f5503c
                android.view.ViewGroup r2 = r0.f5505b
                boolean r1 = r1.remove(r2)
                r2 = 1
                if (r1 != 0) goto L_0x001c
                return r2
            L_0x001c:
                d.e.a r1 = d.t.m.a()
                android.view.ViewGroup r3 = r0.f5505b
                java.lang.Object r3 = r1.get(r3)
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                r4 = 0
                if (r3 != 0) goto L_0x0036
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                android.view.ViewGroup r5 = r0.f5505b
                r1.put(r5, r3)
                goto L_0x0042
            L_0x0036:
                int r5 = r3.size()
                if (r5 <= 0) goto L_0x0042
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>(r3)
                goto L_0x0043
            L_0x0042:
                r5 = r4
            L_0x0043:
                d.t.i r6 = r0.f5504a
                r3.add(r6)
                d.t.i r3 = r0.f5504a
                d.t.m$a$a r6 = new d.t.m$a$a
                r6.<init>(r1)
                r3.a(r6)
                d.t.i r1 = r0.f5504a
                android.view.ViewGroup r3 = r0.f5505b
                r6 = 0
                r1.a(r3, r6)
                if (r5 == 0) goto L_0x0072
                java.util.Iterator r1 = r5.iterator()
            L_0x0060:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0072
                java.lang.Object r3 = r1.next()
                d.t.i r3 = (d.t.i) r3
                android.view.ViewGroup r5 = r0.f5505b
                r3.e(r5)
                goto L_0x0060
            L_0x0072:
                d.t.i r1 = r0.f5504a
                android.view.ViewGroup r8 = r0.f5505b
                if (r1 == 0) goto L_0x02b0
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r1.t = r3
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r1.u = r3
                d.t.r r3 = r1.p
                d.t.r r5 = r1.q
                d.e.a r7 = new d.e.a
                d.e.a<android.view.View, d.t.q> r9 = r3.f5514a
                r7.<init>(r9)
                d.e.a r9 = new d.e.a
                d.e.a<android.view.View, d.t.q> r10 = r5.f5514a
                r9.<init>(r10)
                r10 = r6
            L_0x0099:
                int[] r11 = r1.s
                int r12 = r11.length
                if (r10 >= r12) goto L_0x01ee
                r11 = r11[r10]
                if (r11 == r2) goto L_0x01ae
                r12 = 2
                if (r11 == r12) goto L_0x0160
                r12 = 3
                if (r11 == r12) goto L_0x010c
                r12 = 4
                if (r11 == r12) goto L_0x00ae
            L_0x00ab:
                r17 = r3
                goto L_0x0108
            L_0x00ae:
                d.e.e<android.view.View> r11 = r3.f5516c
                d.e.e<android.view.View> r12 = r5.f5516c
                int r13 = r11.e()
                r14 = r6
            L_0x00b7:
                if (r14 >= r13) goto L_0x00ab
                java.lang.Object r15 = r11.b(r14)
                android.view.View r15 = (android.view.View) r15
                if (r15 == 0) goto L_0x00fe
                boolean r16 = r1.b(r15)
                if (r16 == 0) goto L_0x00fe
                r17 = r3
                long r2 = r11.a(r14)
                java.lang.Object r2 = r12.b(r2)
                android.view.View r2 = (android.view.View) r2
                if (r2 == 0) goto L_0x0100
                boolean r3 = r1.b(r2)
                if (r3 == 0) goto L_0x0100
                java.lang.Object r3 = r7.getOrDefault(r15, r4)
                d.t.q r3 = (d.t.q) r3
                java.lang.Object r18 = r9.getOrDefault(r2, r4)
                r6 = r18
                d.t.q r6 = (d.t.q) r6
                if (r3 == 0) goto L_0x0100
                if (r6 == 0) goto L_0x0100
                java.util.ArrayList<d.t.q> r4 = r1.t
                r4.add(r3)
                java.util.ArrayList<d.t.q> r3 = r1.u
                r3.add(r6)
                r7.remove(r15)
                r9.remove(r2)
                goto L_0x0100
            L_0x00fe:
                r17 = r3
            L_0x0100:
                int r14 = r14 + 1
                r3 = r17
                r2 = 1
                r4 = 0
                r6 = 0
                goto L_0x00b7
            L_0x0108:
                r2 = r17
                goto L_0x01e4
            L_0x010c:
                r2 = r3
                android.util.SparseArray<android.view.View> r3 = r2.f5515b
                android.util.SparseArray<android.view.View> r4 = r5.f5515b
                int r6 = r3.size()
                r11 = 0
            L_0x0116:
                if (r11 >= r6) goto L_0x01e4
                java.lang.Object r12 = r3.valueAt(r11)
                android.view.View r12 = (android.view.View) r12
                if (r12 == 0) goto L_0x015b
                boolean r13 = r1.b(r12)
                if (r13 == 0) goto L_0x015b
                int r13 = r3.keyAt(r11)
                java.lang.Object r13 = r4.get(r13)
                android.view.View r13 = (android.view.View) r13
                if (r13 == 0) goto L_0x015b
                boolean r14 = r1.b(r13)
                if (r14 == 0) goto L_0x015b
                r14 = 0
                java.lang.Object r15 = r7.getOrDefault(r12, r14)
                d.t.q r15 = (d.t.q) r15
                java.lang.Object r17 = r9.getOrDefault(r13, r14)
                r14 = r17
                d.t.q r14 = (d.t.q) r14
                if (r15 == 0) goto L_0x015b
                if (r14 == 0) goto L_0x015b
                java.util.ArrayList<d.t.q> r0 = r1.t
                r0.add(r15)
                java.util.ArrayList<d.t.q> r0 = r1.u
                r0.add(r14)
                r7.remove(r12)
                r9.remove(r13)
            L_0x015b:
                int r11 = r11 + 1
                r0 = r19
                goto L_0x0116
            L_0x0160:
                r2 = r3
                d.e.a<java.lang.String, android.view.View> r0 = r2.f5517d
                d.e.a<java.lang.String, android.view.View> r3 = r5.f5517d
                int r4 = r0.f4602c
                r6 = 0
            L_0x0168:
                if (r6 >= r4) goto L_0x01e4
                java.lang.Object r11 = r0.e(r6)
                android.view.View r11 = (android.view.View) r11
                if (r11 == 0) goto L_0x01ab
                boolean r12 = r1.b(r11)
                if (r12 == 0) goto L_0x01ab
                java.lang.Object r12 = r0.c(r6)
                java.lang.Object r12 = r3.get(r12)
                android.view.View r12 = (android.view.View) r12
                if (r12 == 0) goto L_0x01ab
                boolean r13 = r1.b(r12)
                if (r13 == 0) goto L_0x01ab
                r13 = 0
                java.lang.Object r14 = r7.getOrDefault(r11, r13)
                d.t.q r14 = (d.t.q) r14
                java.lang.Object r15 = r9.getOrDefault(r12, r13)
                d.t.q r15 = (d.t.q) r15
                if (r14 == 0) goto L_0x01ab
                if (r15 == 0) goto L_0x01ab
                java.util.ArrayList<d.t.q> r13 = r1.t
                r13.add(r14)
                java.util.ArrayList<d.t.q> r13 = r1.u
                r13.add(r15)
                r7.remove(r11)
                r9.remove(r12)
            L_0x01ab:
                int r6 = r6 + 1
                goto L_0x0168
            L_0x01ae:
                r2 = r3
                int r0 = r7.f4602c
            L_0x01b1:
                int r0 = r0 + -1
                if (r0 < 0) goto L_0x01e4
                java.lang.Object r3 = r7.c(r0)
                android.view.View r3 = (android.view.View) r3
                if (r3 == 0) goto L_0x01b1
                boolean r4 = r1.b(r3)
                if (r4 == 0) goto L_0x01b1
                java.lang.Object r3 = r9.remove(r3)
                d.t.q r3 = (d.t.q) r3
                if (r3 == 0) goto L_0x01b1
                android.view.View r4 = r3.f5512b
                boolean r4 = r1.b(r4)
                if (r4 == 0) goto L_0x01b1
                java.lang.Object r4 = r7.d(r0)
                d.t.q r4 = (d.t.q) r4
                java.util.ArrayList<d.t.q> r6 = r1.t
                r6.add(r4)
                java.util.ArrayList<d.t.q> r4 = r1.u
                r4.add(r3)
                goto L_0x01b1
            L_0x01e4:
                int r10 = r10 + 1
                r3 = r2
                r2 = 1
                r4 = 0
                r6 = 0
                r0 = r19
                goto L_0x0099
            L_0x01ee:
                r0 = 0
            L_0x01ef:
                int r2 = r7.f4602c
                if (r0 >= r2) goto L_0x020f
                java.lang.Object r2 = r7.e(r0)
                d.t.q r2 = (d.t.q) r2
                android.view.View r3 = r2.f5512b
                boolean r3 = r1.b(r3)
                if (r3 == 0) goto L_0x020c
                java.util.ArrayList<d.t.q> r3 = r1.t
                r3.add(r2)
                java.util.ArrayList<d.t.q> r2 = r1.u
                r3 = 0
                r2.add(r3)
            L_0x020c:
                int r0 = r0 + 1
                goto L_0x01ef
            L_0x020f:
                r0 = 0
            L_0x0210:
                int r2 = r9.f4602c
                if (r0 >= r2) goto L_0x0230
                java.lang.Object r2 = r9.e(r0)
                d.t.q r2 = (d.t.q) r2
                android.view.View r3 = r2.f5512b
                boolean r3 = r1.b(r3)
                if (r3 == 0) goto L_0x022d
                java.util.ArrayList<d.t.q> r3 = r1.u
                r3.add(r2)
                java.util.ArrayList<d.t.q> r2 = r1.t
                r3 = 0
                r2.add(r3)
            L_0x022d:
                int r0 = r0 + 1
                goto L_0x0210
            L_0x0230:
                d.e.a r0 = d.t.i.f()
                int r2 = r0.f4602c
                d.t.f0 r3 = d.t.v.c(r8)
                r4 = 1
                int r2 = r2 - r4
            L_0x023c:
                if (r2 < 0) goto L_0x029f
                java.lang.Object r4 = r0.c(r2)
                android.animation.Animator r4 = (android.animation.Animator) r4
                if (r4 == 0) goto L_0x029c
                r5 = 0
                java.lang.Object r6 = r0.getOrDefault(r4, r5)
                d.t.i$b r6 = (d.t.i.b) r6
                if (r6 == 0) goto L_0x029c
                android.view.View r5 = r6.f5493a
                if (r5 == 0) goto L_0x029c
                d.t.f0 r5 = r6.f5496d
                boolean r5 = r3.equals(r5)
                if (r5 == 0) goto L_0x029c
                d.t.q r5 = r6.f5495c
                android.view.View r7 = r6.f5493a
                r9 = 1
                d.t.q r10 = r1.c(r7, r9)
                d.t.q r11 = r1.b(r7, r9)
                if (r10 != 0) goto L_0x0277
                if (r11 != 0) goto L_0x0277
                d.t.r r9 = r1.q
                d.e.a<android.view.View, d.t.q> r9 = r9.f5514a
                java.lang.Object r7 = r9.get(r7)
                r11 = r7
                d.t.q r11 = (d.t.q) r11
            L_0x0277:
                if (r10 != 0) goto L_0x027b
                if (r11 == 0) goto L_0x0285
            L_0x027b:
                d.t.i r6 = r6.f5497e
                boolean r5 = r6.a(r5, r11)
                if (r5 == 0) goto L_0x0285
                r5 = 1
                goto L_0x0286
            L_0x0285:
                r5 = 0
            L_0x0286:
                if (r5 == 0) goto L_0x029c
                boolean r5 = r4.isRunning()
                if (r5 != 0) goto L_0x0299
                boolean r5 = r4.isStarted()
                if (r5 == 0) goto L_0x0295
                goto L_0x0299
            L_0x0295:
                r0.remove(r4)
                goto L_0x029c
            L_0x0299:
                r4.cancel()
            L_0x029c:
                int r2 = r2 + -1
                goto L_0x023c
            L_0x029f:
                d.t.r r9 = r1.p
                d.t.r r10 = r1.q
                java.util.ArrayList<d.t.q> r11 = r1.t
                java.util.ArrayList<d.t.q> r12 = r1.u
                r7 = r1
                r7.a(r8, r9, r10, r11, r12)
                r1.c()
                r0 = 1
                return r0
            L_0x02b0:
                r0 = r4
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: d.t.m.a.onPreDraw():boolean");
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.f5505b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f5505b.removeOnAttachStateChangeListener(this);
            m.f5503c.remove(this.f5505b);
            ArrayList arrayList = (ArrayList) m.a().get(this.f5505b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).e(this.f5505b);
                }
            }
            this.f5504a.a(true);
        }
    }

    public static d.e.a<ViewGroup, ArrayList<i>> a() {
        WeakReference weakReference = (WeakReference) f5502b.get();
        if (weakReference != null) {
            d.e.a<ViewGroup, ArrayList<i>> aVar = (d.e.a) weakReference.get();
            if (aVar != null) {
                return aVar;
            }
        }
        d.e.a<ViewGroup, ArrayList<i>> aVar2 = new d.e.a<>();
        f5502b.set(new WeakReference(aVar2));
        return aVar2;
    }
}
