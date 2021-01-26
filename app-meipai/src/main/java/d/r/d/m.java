package d.r.d;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import androidx.recyclerview.widget.RecyclerView.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker */
public final class m implements Runnable {

    /* renamed from: e reason: collision with root package name */
    public static final ThreadLocal<m> f5372e = new ThreadLocal<>();

    /* renamed from: f reason: collision with root package name */
    public static Comparator<c> f5373f = new a();

    /* renamed from: a reason: collision with root package name */
    public ArrayList<RecyclerView> f5374a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    public long f5375b;

    /* renamed from: c reason: collision with root package name */
    public long f5376c;

    /* renamed from: d reason: collision with root package name */
    public ArrayList<c> f5377d = new ArrayList<>();

    /* compiled from: GapWorker */
    public static class a implements Comparator<c> {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r6.f5385d == null) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            if (r0 != false) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(java.lang.Object r6, java.lang.Object r7) {
            /*
                r5 = this;
                d.r.d.m$c r6 = (d.r.d.m.c) r6
                d.r.d.m$c r7 = (d.r.d.m.c) r7
                androidx.recyclerview.widget.RecyclerView r0 = r6.f5385d
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x000c
                r0 = r2
                goto L_0x000d
            L_0x000c:
                r0 = r1
            L_0x000d:
                androidx.recyclerview.widget.RecyclerView r3 = r7.f5385d
                if (r3 != 0) goto L_0x0013
                r3 = r2
                goto L_0x0014
            L_0x0013:
                r3 = r1
            L_0x0014:
                r4 = -1
                if (r0 == r3) goto L_0x001f
                androidx.recyclerview.widget.RecyclerView r6 = r6.f5385d
                if (r6 != 0) goto L_0x001d
            L_0x001b:
                r1 = r2
                goto L_0x0039
            L_0x001d:
                r1 = r4
                goto L_0x0039
            L_0x001f:
                boolean r0 = r6.f5382a
                boolean r3 = r7.f5382a
                if (r0 == r3) goto L_0x0028
                if (r0 == 0) goto L_0x001b
                goto L_0x001d
            L_0x0028:
                int r0 = r7.f5383b
                int r2 = r6.f5383b
                int r0 = r0 - r2
                if (r0 == 0) goto L_0x0031
                r1 = r0
                goto L_0x0039
            L_0x0031:
                int r6 = r6.f5384c
                int r7 = r7.f5384c
                int r6 = r6 - r7
                if (r6 == 0) goto L_0x0039
                r1 = r6
            L_0x0039:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: d.r.d.m.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* compiled from: GapWorker */
    public static class b implements androidx.recyclerview.widget.RecyclerView.LayoutManager.c {

        /* renamed from: a reason: collision with root package name */
        public int f5378a;

        /* renamed from: b reason: collision with root package name */
        public int f5379b;

        /* renamed from: c reason: collision with root package name */
        public int[] f5380c;

        /* renamed from: d reason: collision with root package name */
        public int f5381d;

        public void a(RecyclerView recyclerView, boolean z) {
            this.f5381d = 0;
            int[] iArr = this.f5380c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.c()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f5378a, this.f5379b, recyclerView.mState, this);
                }
                int i2 = this.f5381d;
                if (i2 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i2;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.d();
                }
            }
        }

        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f5381d * 2;
                int[] iArr = this.f5380c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f5380c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[(i4 * 2)];
                    this.f5380c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f5380c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f5381d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public boolean a(int i2) {
            if (this.f5380c != null) {
                int i3 = this.f5381d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f5380c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: GapWorker */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        public boolean f5382a;

        /* renamed from: b reason: collision with root package name */
        public int f5383b;

        /* renamed from: c reason: collision with root package name */
        public int f5384c;

        /* renamed from: d reason: collision with root package name */
        public RecyclerView f5385d;

        /* renamed from: e reason: collision with root package name */
        public int f5386e;
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f5375b == 0) {
            this.f5375b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.f5378a = i2;
        bVar.f5379b = i3;
    }

    public void run() {
        try {
            Trace.beginSection(RecyclerView.TRACE_PREFETCH_TAG);
            if (!this.f5374a.isEmpty()) {
                int size = this.f5374a.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = (RecyclerView) this.f5374a.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 == 0) {
                    this.f5375b = 0;
                    Trace.endSection();
                    return;
                }
                a(TimeUnit.MILLISECONDS.toNanos(j2) + this.f5376c);
                this.f5375b = 0;
                Trace.endSection();
            }
        } finally {
            this.f5375b = 0;
            Trace.endSection();
        }
    }

    public void a(long j2) {
        c cVar;
        int size = this.f5374a.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = (RecyclerView) this.f5374a.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f5381d;
            }
        }
        this.f5377d.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f5374a.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f5379b) + Math.abs(bVar.f5378a);
                for (int i6 = 0; i6 < bVar.f5381d * 2; i6 += 2) {
                    if (i4 >= this.f5377d.size()) {
                        cVar = new c();
                        this.f5377d.add(cVar);
                    } else {
                        cVar = (c) this.f5377d.get(i4);
                    }
                    int i7 = bVar.f5380c[i6 + 1];
                    cVar.f5382a = i7 <= abs;
                    cVar.f5383b = abs;
                    cVar.f5384c = i7;
                    cVar.f5385d = recyclerView2;
                    cVar.f5386e = bVar.f5380c[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f5377d, f5373f);
        int i8 = 0;
        while (i8 < this.f5377d.size()) {
            c cVar2 = (c) this.f5377d.get(i8);
            if (cVar2.f5385d != null) {
                d0 a2 = a(cVar2.f5385d, cVar2.f5386e, cVar2.f5382a ? RecyclerView.FOREVER_NS : j2);
                if (a2 != null && a2.mNestedRecyclerView != null && a2.isBound() && !a2.isInvalid()) {
                    RecyclerView recyclerView3 = (RecyclerView) a2.mNestedRecyclerView.get();
                    if (recyclerView3 != null) {
                        if (recyclerView3.mDataSetHasChangedAfterLayout && recyclerView3.mChildHelper.b() != 0) {
                            recyclerView3.removeAndRecycleViews();
                        }
                        b bVar2 = recyclerView3.mPrefetchRegistry;
                        bVar2.a(recyclerView3, true);
                        if (bVar2.f5381d != 0) {
                            try {
                                Trace.beginSection(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                                a0 a0Var = recyclerView3.mState;
                                g gVar = recyclerView3.mAdapter;
                                a0Var.f1015d = 1;
                                a0Var.f1016e = gVar.getItemCount();
                                a0Var.f1018g = false;
                                a0Var.f1019h = false;
                                a0Var.f1020i = false;
                                for (int i9 = 0; i9 < bVar2.f5381d * 2; i9 += 2) {
                                    a(recyclerView3, bVar2.f5380c[i9], j2);
                                }
                            } finally {
                                Trace.endSection();
                            }
                        }
                    }
                }
                cVar2.f5382a = false;
                cVar2.f5383b = 0;
                cVar2.f5384c = 0;
                cVar2.f5385d = null;
                cVar2.f5386e = 0;
                i8++;
            } else {
                return;
            }
        }
    }

    public final d0 a(RecyclerView recyclerView, int i2, long j2) {
        boolean z;
        int b2 = recyclerView.mChildHelper.b();
        int i3 = 0;
        while (true) {
            if (i3 >= b2) {
                z = false;
                break;
            }
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            return null;
        }
        u uVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            d0 a2 = uVar.a(i2, false, j2);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    uVar.a(a2, false);
                } else {
                    uVar.a(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }
}
