package e.m.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import androidx.recyclerview.widget.RecyclerView.u;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.DiscreteScrollView.d;
import d.r.d.o;
import java.util.Locale;

/* compiled from: DiscreteScrollLayoutManager */
public class c extends LayoutManager {
    public g A;

    /* renamed from: a reason: collision with root package name */
    public Point f8983a = new Point();

    /* renamed from: b reason: collision with root package name */
    public Point f8984b = new Point();

    /* renamed from: c reason: collision with root package name */
    public Point f8985c = new Point();

    /* renamed from: d reason: collision with root package name */
    public int f8986d;

    /* renamed from: e reason: collision with root package name */
    public int f8987e;

    /* renamed from: f reason: collision with root package name */
    public int f8988f;

    /* renamed from: g reason: collision with root package name */
    public int f8989g;

    /* renamed from: h reason: collision with root package name */
    public int f8990h;

    /* renamed from: i reason: collision with root package name */
    public int f8991i;

    /* renamed from: j reason: collision with root package name */
    public int f8992j;
    public int k = -1;
    public int l = -1;
    public SparseArray<View> m = new SparseArray<>();
    public e.m.a.a.c n;
    public boolean o;
    public Context p;
    public int q = 300;
    public int r;
    public int s;
    public boolean t;
    public int u = 2100;
    public boolean v = false;
    public int w;
    public int x;
    public final C0136c y;
    public e.m.a.h.a z;

    /* compiled from: DiscreteScrollLayoutManager */
    public class a extends o {
        public a(Context context) {
            super(context);
        }

        public int calculateDxToMakeVisible(View view, int i2) {
            c cVar = c.this;
            return cVar.n.b(-cVar.f8992j);
        }

        public int calculateDyToMakeVisible(View view, int i2) {
            c cVar = c.this;
            return cVar.n.a(-cVar.f8992j);
        }

        public int calculateTimeForScrolling(int i2) {
            return (int) (Math.max(0.01f, ((float) Math.min(Math.abs(i2), c.this.f8989g)) / ((float) c.this.f8989g)) * ((float) c.this.q));
        }

        public PointF computeScrollVectorForPosition(int i2) {
            c cVar = c.this;
            float b2 = (float) cVar.n.b(cVar.f8992j);
            c cVar2 = c.this;
            return new PointF(b2, (float) cVar2.n.a(cVar2.f8992j));
        }
    }

    /* compiled from: DiscreteScrollLayoutManager */
    public interface b {
        int a();
    }

    /* renamed from: e.m.a.c$c reason: collision with other inner class name */
    /* compiled from: DiscreteScrollLayoutManager */
    public interface C0136c {
    }

    public c(Context context, C0136c cVar, a aVar) {
        this.p = context;
        this.y = cVar;
        this.n = aVar.a();
        this.A = new g(this);
        this.s = 1;
    }

    public final void a(u uVar, b bVar, int i2) {
        b bVar2 = bVar;
        int a2 = bVar2.a(1);
        int i3 = this.l;
        boolean z2 = i3 == -1 || !bVar2.b(i3 - this.k);
        Point point = this.f8983a;
        Point point2 = this.f8985c;
        point.set(point2.x, point2.y);
        int i4 = this.k;
        while (true) {
            i4 += a2;
            if (i4 >= 0 && i4 < this.A.c()) {
                if (i4 == this.l) {
                    z2 = true;
                }
                this.n.a(bVar2, this.f8989g, this.f8983a);
                if (this.n.a(this.f8983a, this.f8986d, this.f8987e, i2, this.f8988f)) {
                    a(uVar, i4, this.f8983a);
                } else {
                    u uVar2 = uVar;
                    if (z2) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public final int b() {
        if (getItemCount() == 0) {
            return 0;
        }
        return (getItemCount() - 1) * this.f8989g;
    }

    public View c() {
        return this.A.a(0);
    }

    public boolean canScrollHorizontally() {
        return this.n.b();
    }

    public boolean canScrollVertically() {
        return this.n.a();
    }

    public int computeHorizontalScrollExtent(a0 a0Var) {
        return computeScrollExtent(a0Var);
    }

    public int computeHorizontalScrollOffset(a0 a0Var) {
        return computeScrollOffset(a0Var);
    }

    public int computeHorizontalScrollRange(a0 a0Var) {
        return b();
    }

    public final int computeScrollExtent(a0 a0Var) {
        if (getItemCount() == 0) {
            return 0;
        }
        return (int) (((float) b()) / ((float) getItemCount()));
    }

    public final int computeScrollOffset(a0 a0Var) {
        int computeScrollExtent = computeScrollExtent(a0Var);
        return (this.k * computeScrollExtent) + ((int) ((((float) this.f8991i) / ((float) this.f8989g)) * ((float) computeScrollExtent)));
    }

    public int computeVerticalScrollExtent(a0 a0Var) {
        return computeScrollExtent(a0Var);
    }

    public int computeVerticalScrollOffset(a0 a0Var) {
        return computeScrollOffset(a0Var);
    }

    public int computeVerticalScrollRange(a0 a0Var) {
        return b();
    }

    public View d() {
        g gVar = this.A;
        return gVar.a(gVar.a() - 1);
    }

    public final boolean e() {
        return ((float) Math.abs(this.f8991i)) >= ((float) this.f8989g) * 0.6f;
    }

    public final void f() {
        a aVar = new a(this.p);
        aVar.setTargetPosition(this.k);
        this.A.f8995a.startSmoothScroll(aVar);
    }

    public RecyclerView.o generateDefaultLayoutParams() {
        return new RecyclerView.o(-2, -2);
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public void onAdapterChanged(g gVar, g gVar2) {
        this.l = -1;
        this.f8992j = 0;
        this.f8991i = 0;
        if (gVar2 instanceof b) {
            this.k = ((b) gVar2).a();
        } else {
            this.k = 0;
        }
        this.A.f8995a.removeAllViews();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.A.a() > 0) {
            accessibilityEvent.setFromIndex(getPosition(c()));
            accessibilityEvent.setToIndex(getPosition(d()));
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        int i4 = this.k;
        if (i4 == -1) {
            i4 = 0;
        } else if (i4 >= i2) {
            i4 = Math.min(i4 + i3, this.A.c() - 1);
        }
        if (this.k != i4) {
            this.k = i4;
            this.t = true;
        }
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.k = Math.min(Math.max(0, this.k), this.A.c() - 1);
        this.t = true;
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        int i4 = this.k;
        if (this.A.c() == 0) {
            i4 = -1;
        } else {
            int i5 = this.k;
            if (i5 >= i2) {
                if (i5 < i2 + i3) {
                    this.k = -1;
                }
                i4 = Math.max(0, this.k - i3);
            }
        }
        if (this.k != i4) {
            this.k = i4;
            this.t = true;
        }
    }

    public void onLayoutChildren(u uVar, a0 a0Var) {
        if (a0Var.a() == 0) {
            this.A.f8995a.removeAndRecycleAllViews(uVar);
            this.l = -1;
            this.k = -1;
            this.f8992j = 0;
            this.f8991i = 0;
            return;
        }
        int i2 = this.k;
        if (i2 == -1 || i2 >= a0Var.a()) {
            this.k = 0;
        }
        boolean z2 = true;
        if (!a0Var.f1020i && !(this.A.d() == this.w && this.A.b() == this.x)) {
            this.w = this.A.d();
            this.x = this.A.b();
            this.A.f8995a.removeAllViews();
        }
        this.f8984b.set(this.A.d() / 2, this.A.b() / 2);
        if (!this.o) {
            if (this.A.a() != 0) {
                z2 = false;
            }
            this.o = z2;
            if (z2) {
                g gVar = this.A;
                if (gVar != null) {
                    View view = uVar.a(0, false, RecyclerView.FOREVER_NS).itemView;
                    gVar.f8995a.addView(view);
                    gVar.f8995a.measureChildWithMargins(view, 0, 0);
                    g gVar2 = this.A;
                    if (gVar2 != null) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                        int decoratedMeasuredWidth = gVar2.f8995a.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                        g gVar3 = this.A;
                        if (gVar3 != null) {
                            MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                            int decoratedMeasuredHeight = gVar3.f8995a.getDecoratedMeasuredHeight(view) + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                            this.f8986d = decoratedMeasuredWidth / 2;
                            this.f8987e = decoratedMeasuredHeight / 2;
                            int b2 = this.n.b(decoratedMeasuredWidth, decoratedMeasuredHeight);
                            this.f8989g = b2;
                            this.f8988f = b2 * this.r;
                            this.A.f8995a.detachAndScrapView(view, uVar);
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
        }
        this.A.f8995a.detachAndScrapAttachedViews(uVar);
        a(uVar);
        a();
    }

    public void onLayoutCompleted(a0 a0Var) {
        if (this.o) {
            d dVar = (d) this.y;
            DiscreteScrollView.this.post(new d(dVar));
            this.o = false;
        } else if (this.t) {
            DiscreteScrollView.a(DiscreteScrollView.this);
            this.t = false;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.k = ((Bundle) parcelable).getInt("extra_position");
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int i2 = this.l;
        if (i2 != -1) {
            this.k = i2;
        }
        bundle.putInt("extra_position", this.k);
        return bundle;
    }

    public void onScrollStateChanged(int i2) {
        int i3 = this.f8990h;
        if (i3 == 0 && i3 != i2) {
            d dVar = (d) this.y;
            if (!DiscreteScrollView.this.f3980b.isEmpty()) {
                DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
                int i4 = discreteScrollView.f3979a.k;
                d0 a2 = discreteScrollView.a(i4);
                if (a2 != null) {
                    for (com.yarolegovich.discretescrollview.DiscreteScrollView.c a3 : DiscreteScrollView.this.f3980b) {
                        a3.a(a2, i4);
                    }
                }
            }
        }
        boolean z2 = false;
        if (i2 == 0) {
            int i5 = this.l;
            if (i5 != -1) {
                this.k = i5;
                this.l = -1;
                this.f8991i = 0;
            }
            b c2 = b.c(this.f8991i);
            if (Math.abs(this.f8991i) == this.f8989g) {
                this.k = c2.a(1) + this.k;
                this.f8991i = 0;
            }
            if (e()) {
                this.f8992j = b.c(this.f8991i).a(this.f8989g - Math.abs(this.f8991i));
            } else {
                this.f8992j = -this.f8991i;
            }
            if (this.f8992j == 0) {
                z2 = true;
            } else {
                f();
            }
            if (z2) {
                d dVar2 = (d) this.y;
                if (!DiscreteScrollView.this.f3981c.isEmpty() || !DiscreteScrollView.this.f3980b.isEmpty()) {
                    DiscreteScrollView discreteScrollView2 = DiscreteScrollView.this;
                    int i6 = discreteScrollView2.f3979a.k;
                    d0 a4 = discreteScrollView2.a(i6);
                    if (a4 != null) {
                        for (com.yarolegovich.discretescrollview.DiscreteScrollView.c b2 : DiscreteScrollView.this.f3980b) {
                            b2.b(a4, i6);
                        }
                        DiscreteScrollView.this.a(a4, i6);
                    }
                }
            } else {
                return;
            }
        } else if (i2 == 1) {
            if (Math.abs(this.f8991i) > this.f8989g) {
                int i7 = this.f8991i;
                int i8 = this.f8989g;
                int i9 = i7 / i8;
                this.k += i9;
                this.f8991i = i7 - (i9 * i8);
            }
            if (e()) {
                this.k = b.c(this.f8991i).a(1) + this.k;
                this.f8991i = -b.c(this.f8991i).a(this.f8989g - Math.abs(this.f8991i));
            }
            this.l = -1;
            this.f8992j = 0;
        }
        this.f8990h = i2;
    }

    public int scrollHorizontallyBy(int i2, u uVar, a0 a0Var) {
        return a(i2, uVar);
    }

    public void scrollToPosition(int i2) {
        if (this.k != i2) {
            this.k = i2;
            this.A.f8995a.requestLayout();
        }
    }

    public int scrollVerticallyBy(int i2, u uVar, a0 a0Var) {
        return a(i2, uVar);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, a0 a0Var, int i2) {
        if (this.k != i2 && this.l == -1) {
            if (i2 < 0 || i2 >= a0Var.a()) {
                throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(a0Var.a())}));
            }
            if (this.k == -1) {
                this.k = i2;
            } else {
                a(i2);
            }
        }
    }

    public void a(u uVar, int i2, Point point) {
        if (i2 >= 0) {
            View view = (View) this.m.get(i2);
            if (view == null) {
                g gVar = this.A;
                if (gVar != null) {
                    View view2 = uVar.a(i2, false, RecyclerView.FOREVER_NS).itemView;
                    gVar.f8995a.addView(view2);
                    gVar.f8995a.measureChildWithMargins(view2, 0, 0);
                    g gVar2 = this.A;
                    int i3 = point.x;
                    int i4 = this.f8986d;
                    int i5 = i3 - i4;
                    int i6 = point.y;
                    int i7 = this.f8987e;
                    gVar2.f8995a.layoutDecoratedWithMargins(view2, i5, i6 - i7, i3 + i4, i6 + i7);
                } else {
                    throw null;
                }
            } else {
                this.A.f8995a.attachView(view);
                this.m.remove(i2);
            }
        }
    }

    public void a(u uVar) {
        this.m.clear();
        int i2 = 0;
        for (int i3 = 0; i3 < this.A.a(); i3++) {
            View a2 = this.A.a(i3);
            this.m.put(this.A.f8995a.getPosition(a2), a2);
        }
        for (int i4 = 0; i4 < this.m.size(); i4++) {
            View view = (View) this.m.valueAt(i4);
            this.A.f8995a.detachView(view);
        }
        this.n.a(this.f8984b, this.f8991i, this.f8985c);
        int a3 = this.n.a(this.A.d(), this.A.b());
        if (this.n.a(this.f8985c, this.f8986d, this.f8987e, a3, this.f8988f)) {
            a(uVar, this.k, this.f8985c);
        }
        a(uVar, b.START, a3);
        a(uVar, b.END, a3);
        while (i2 < this.m.size()) {
            View view2 = (View) this.m.valueAt(i2);
            if (this.A != null) {
                uVar.a(view2);
                i2++;
            } else {
                throw null;
            }
        }
        this.m.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int r12, androidx.recyclerview.widget.RecyclerView.u r13) {
        /*
            r11 = this;
            e.m.a.g r0 = r11.A
            int r0 = r0.a()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            e.m.a.b r0 = e.m.a.b.c(r12)
            int r2 = r11.f8992j
            r3 = 1
            if (r2 == 0) goto L_0x0019
            int r2 = java.lang.Math.abs(r2)
            goto L_0x0088
        L_0x0019:
            int r2 = r11.f8991i
            int r2 = r0.a(r2)
            if (r2 <= 0) goto L_0x0023
            r2 = r3
            goto L_0x0024
        L_0x0023:
            r2 = r1
        L_0x0024:
            e.m.a.b r4 = e.m.a.b.START
            if (r0 != r4) goto L_0x003d
            int r4 = r11.k
            if (r4 != 0) goto L_0x003d
            int r2 = r11.f8991i
            if (r2 != 0) goto L_0x0032
            r2 = r3
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            if (r2 == 0) goto L_0x0036
            goto L_0x0055
        L_0x0036:
            int r4 = r11.f8991i
            int r4 = java.lang.Math.abs(r4)
            goto L_0x0075
        L_0x003d:
            e.m.a.b r4 = e.m.a.b.END
            if (r0 != r4) goto L_0x005e
            int r4 = r11.k
            e.m.a.g r5 = r11.A
            int r5 = r5.c()
            int r5 = r5 - r3
            if (r4 != r5) goto L_0x005e
            int r2 = r11.f8991i
            if (r2 != 0) goto L_0x0052
            r2 = r3
            goto L_0x0053
        L_0x0052:
            r2 = r1
        L_0x0053:
            if (r2 == 0) goto L_0x0057
        L_0x0055:
            r4 = r1
            goto L_0x0075
        L_0x0057:
            int r4 = r11.f8991i
            int r4 = java.lang.Math.abs(r4)
            goto L_0x0075
        L_0x005e:
            if (r2 == 0) goto L_0x006a
            int r2 = r11.f8989g
            int r4 = r11.f8991i
            int r4 = java.lang.Math.abs(r4)
            int r2 = r2 - r4
            goto L_0x0073
        L_0x006a:
            int r2 = r11.f8989g
            int r4 = r11.f8991i
            int r4 = java.lang.Math.abs(r4)
            int r2 = r2 + r4
        L_0x0073:
            r4 = r2
            r2 = r1
        L_0x0075:
            e.m.a.c$c r5 = r11.y
            com.yarolegovich.discretescrollview.DiscreteScrollView$d r5 = (com.yarolegovich.discretescrollview.DiscreteScrollView.d) r5
            com.yarolegovich.discretescrollview.DiscreteScrollView r5 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
            boolean r6 = r5.f3982d
            if (r6 == 0) goto L_0x0087
            if (r2 == 0) goto L_0x0083
            r2 = r1
            goto L_0x0084
        L_0x0083:
            r2 = 2
        L_0x0084:
            r5.setOverScrollMode(r2)
        L_0x0087:
            r2 = r4
        L_0x0088:
            if (r2 > 0) goto L_0x008b
            return r1
        L_0x008b:
            int r12 = java.lang.Math.abs(r12)
            int r12 = java.lang.Math.min(r2, r12)
            int r12 = r0.a(r12)
            int r0 = r11.f8991i
            int r0 = r0 + r12
            r11.f8991i = r0
            int r0 = r11.f8992j
            if (r0 == 0) goto L_0x00a3
            int r0 = r0 - r12
            r11.f8992j = r0
        L_0x00a3:
            e.m.a.a$c r0 = r11.n
            int r1 = -r12
            e.m.a.g r2 = r11.A
            r0.a(r1, r2)
            e.m.a.a$c r0 = r11.n
            boolean r0 = r0.a(r11)
            if (r0 == 0) goto L_0x00b6
            r11.a(r13)
        L_0x00b6:
            int r13 = r11.l
            r0 = -1
            if (r13 == r0) goto L_0x00c5
            int r13 = r11.f8991i
            int r1 = r11.f8992j
            int r13 = r13 + r1
            int r13 = java.lang.Math.abs(r13)
            goto L_0x00c7
        L_0x00c5:
            int r13 = r11.f8989g
        L_0x00c7:
            float r13 = (float) r13
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = r11.f8991i
            float r2 = (float) r2
            float r2 = r2 / r13
            float r13 = java.lang.Math.max(r1, r2)
            r1 = 1065353216(0x3f800000, float:1.0)
            float r13 = java.lang.Math.min(r13, r1)
            float r13 = -r13
            e.m.a.c$c r1 = r11.y
            com.yarolegovich.discretescrollview.DiscreteScrollView$d r1 = (com.yarolegovich.discretescrollview.DiscreteScrollView.d) r1
            com.yarolegovich.discretescrollview.DiscreteScrollView r2 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
            java.util.List<com.yarolegovich.discretescrollview.DiscreteScrollView$c> r2 = r2.f3980b
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00e8
            goto L_0x0133
        L_0x00e8:
            com.yarolegovich.discretescrollview.DiscreteScrollView r2 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
            int r2 = r2.getCurrentItem()
            com.yarolegovich.discretescrollview.DiscreteScrollView r4 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
            e.m.a.c r4 = r4.f3979a
            int r5 = r4.f8991i
            if (r5 != 0) goto L_0x00f9
            int r0 = r4.k
            goto L_0x010a
        L_0x00f9:
            int r6 = r4.l
            if (r6 == r0) goto L_0x00ff
            r0 = r6
            goto L_0x010a
        L_0x00ff:
            int r0 = r4.k
            e.m.a.b r4 = e.m.a.b.c(r5)
            int r3 = r4.a(r3)
            int r0 = r0 + r3
        L_0x010a:
            if (r2 == r0) goto L_0x0133
            com.yarolegovich.discretescrollview.DiscreteScrollView r3 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
            androidx.recyclerview.widget.RecyclerView$d0 r10 = r3.a(r2)
            com.yarolegovich.discretescrollview.DiscreteScrollView r1 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
            androidx.recyclerview.widget.RecyclerView$d0 r1 = r1.a(r0)
            java.util.List<com.yarolegovich.discretescrollview.DiscreteScrollView$c> r3 = r3.f3980b
            java.util.Iterator r3 = r3.iterator()
        L_0x011e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0133
            java.lang.Object r4 = r3.next()
            com.yarolegovich.discretescrollview.DiscreteScrollView$c r4 = (com.yarolegovich.discretescrollview.DiscreteScrollView.c) r4
            r5 = r13
            r6 = r2
            r7 = r0
            r8 = r10
            r9 = r1
            r4.a(r5, r6, r7, r8, r9)
            goto L_0x011e
        L_0x0133:
            r11.a()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e.m.a.c.a(int, androidx.recyclerview.widget.RecyclerView$u):int");
    }

    public void a() {
        if (this.z != null) {
            int i2 = this.f8989g * this.s;
            for (int i3 = 0; i3 < this.A.a(); i3++) {
                View a2 = this.A.a(i3);
                this.z.a(a2, Math.min(Math.max(-1.0f, this.n.a(this.f8984b, getDecoratedLeft(a2) + this.f8986d, getDecoratedTop(a2) + this.f8987e) / ((float) i2)), 1.0f));
            }
        }
    }

    public final void a(int i2) {
        int i3 = this.k;
        if (i3 != i2) {
            this.f8992j = -this.f8991i;
            b c2 = b.c(i2 - i3);
            int abs = Math.abs(i2 - this.k) * this.f8989g;
            this.f8992j = c2.a(abs) + this.f8992j;
            this.l = i2;
            f();
        }
    }
}
