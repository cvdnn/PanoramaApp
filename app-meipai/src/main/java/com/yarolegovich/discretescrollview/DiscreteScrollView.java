package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.d0;
import e.m.a.c.C0136c;
import e.m.a.e;
import e.m.a.f;
import java.util.ArrayList;
import java.util.List;

public class DiscreteScrollView extends RecyclerView {

    /* renamed from: e reason: collision with root package name */
    public static final int f3978e = 0;

    /* renamed from: a reason: collision with root package name */
    public e.m.a.c f3979a;

    /* renamed from: b reason: collision with root package name */
    public List<c> f3980b;

    /* renamed from: c reason: collision with root package name */
    public List<b> f3981c;

    /* renamed from: d reason: collision with root package name */
    public boolean f3982d;

    public interface b<T extends d0> {
        void a(T t, int i2);
    }

    public interface c<T extends d0> {
        void a(float f2, int i2, int i3, T t, T t2);

        void a(T t, int i2);

        void b(T t, int i2);
    }

    public class d implements C0136c {
        public /* synthetic */ d(a aVar) {
        }
    }

    static {
        e.m.a.a aVar = e.m.a.a.HORIZONTAL;
    }

    public DiscreteScrollView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public final void a(AttributeSet attributeSet) {
        this.f3980b = new ArrayList();
        this.f3981c = new ArrayList();
        int i2 = f3978e;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.DiscreteScrollView);
            i2 = obtainStyledAttributes.getInt(f.DiscreteScrollView_dsv_orientation, f3978e);
            obtainStyledAttributes.recycle();
        }
        this.f3982d = getOverScrollMode() != 2;
        e.m.a.c cVar = new e.m.a.c(getContext(), new d(null), e.m.a.a.values()[i2]);
        this.f3979a = cVar;
        setLayoutManager(cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if ((r9 >= 0 && r9 < r1.A.c()) != false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fling(int r8, int r9) {
        /*
            r7 = this;
            boolean r0 = super.fling(r8, r9)
            if (r0 == 0) goto L_0x006c
            e.m.a.c r1 = r7.f3979a
            e.m.a.a$c r2 = r1.n
            int r8 = r2.c(r8, r9)
            boolean r9 = r1.v
            r2 = 1
            if (r9 == 0) goto L_0x001c
            int r9 = r1.u
            int r9 = r8 / r9
            int r9 = java.lang.Math.abs(r9)
            goto L_0x001d
        L_0x001c:
            r9 = r2
        L_0x001d:
            int r3 = r1.k
            e.m.a.b r4 = e.m.a.b.c(r8)
            int r9 = r4.a(r9)
            int r9 = r9 + r3
            e.m.a.g r3 = r1.A
            int r3 = r3.c()
            int r4 = r1.k
            r5 = 0
            if (r4 == 0) goto L_0x0037
            if (r9 >= 0) goto L_0x0037
            r9 = r5
            goto L_0x0040
        L_0x0037:
            int r4 = r1.k
            int r6 = r3 + -1
            if (r4 == r6) goto L_0x0040
            if (r9 < r3) goto L_0x0040
            r9 = r6
        L_0x0040:
            int r3 = r1.f8991i
            int r8 = r8 * r3
            if (r8 < 0) goto L_0x0047
            r8 = r2
            goto L_0x0048
        L_0x0047:
            r8 = r5
        L_0x0048:
            if (r8 == 0) goto L_0x005a
            if (r9 < 0) goto L_0x0056
            e.m.a.g r8 = r1.A
            int r8 = r8.c()
            if (r9 >= r8) goto L_0x0056
            r8 = r2
            goto L_0x0057
        L_0x0056:
            r8 = r5
        L_0x0057:
            if (r8 == 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r2 = r5
        L_0x005b:
            if (r2 == 0) goto L_0x0061
            r1.a(r9)
            goto L_0x0078
        L_0x0061:
            int r8 = r1.f8991i
            int r8 = -r8
            r1.f8992j = r8
            if (r8 == 0) goto L_0x0078
            r1.f()
            goto L_0x0078
        L_0x006c:
            e.m.a.c r8 = r7.f3979a
            int r9 = r8.f8991i
            int r9 = -r9
            r8.f8992j = r9
            if (r9 == 0) goto L_0x0078
            r8.f()
        L_0x0078:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yarolegovich.discretescrollview.DiscreteScrollView.fling(int, int):boolean");
    }

    public int getCurrentItem() {
        return this.f3979a.k;
    }

    public void setClampTransformProgressAfter(int i2) {
        if (i2 > 1) {
            e.m.a.c cVar = this.f3979a;
            cVar.s = i2;
            cVar.a();
            return;
        }
        throw new IllegalArgumentException("must be >= 1");
    }

    public void setItemTransformer(e.m.a.h.a aVar) {
        this.f3979a.z = aVar;
    }

    public void setItemTransitionTimeMillis(int i2) {
        this.f3979a.q = i2;
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager instanceof e.m.a.c) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException(getContext().getString(e.dsv_ex_msg_dont_set_lm));
    }

    public void setOffscreenItems(int i2) {
        e.m.a.c cVar = this.f3979a;
        cVar.r = i2;
        cVar.f8988f = cVar.f8989g * i2;
        cVar.A.f8995a.requestLayout();
    }

    public void setOrientation(e.m.a.a aVar) {
        e.m.a.c cVar = this.f3979a;
        if (cVar != null) {
            cVar.n = aVar.a();
            cVar.A.f8995a.removeAllViews();
            cVar.A.f8995a.requestLayout();
            return;
        }
        throw null;
    }

    public void setOverScrollEnabled(boolean z) {
        this.f3982d = z;
        setOverScrollMode(2);
    }

    public void setSlideOnFling(boolean z) {
        this.f3979a.v = z;
    }

    public void setSlideOnFlingThreshold(int i2) {
        this.f3979a.u = i2;
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public d0 a(int i2) {
        View findViewByPosition = this.f3979a.findViewByPosition(i2);
        if (findViewByPosition != null) {
            return getChildViewHolder(findViewByPosition);
        }
        return null;
    }

    public final void a(d0 d0Var, int i2) {
        for (b a2 : this.f3981c) {
            a2.a(d0Var, i2);
        }
    }

    public static /* synthetic */ void a(DiscreteScrollView discreteScrollView) {
        if (!discreteScrollView.f3981c.isEmpty()) {
            int i2 = discreteScrollView.f3979a.k;
            discreteScrollView.a(discreteScrollView.a(i2), i2);
        }
    }
}
