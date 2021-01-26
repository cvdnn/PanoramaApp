package d.r.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.z;

/* compiled from: SnapHelper */
public abstract class x extends q {
    public static final float MILLISECONDS_PER_INCH = 100.0f;
    public Scroller mGravityScroller;
    public RecyclerView mRecyclerView;
    public final s mScrollListener = new a();

    /* compiled from: SnapHelper */
    public class a extends s {

        /* renamed from: a reason: collision with root package name */
        public boolean f5408a = false;

        public a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.f5408a) {
                this.f5408a = false;
                x.this.snapToTargetExistingView();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.f5408a = true;
            }
        }
    }

    /* compiled from: SnapHelper */
    public class b extends o {
        public b(Context context) {
            super(context);
        }

        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        public void onTargetFound(View view, a0 a0Var, androidx.recyclerview.widget.RecyclerView.z.a aVar) {
            x xVar = x.this;
            RecyclerView recyclerView = xVar.mRecyclerView;
            if (recyclerView != null) {
                int[] calculateDistanceToFinalSnap = xVar.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                int i2 = calculateDistanceToFinalSnap[0];
                int i3 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                if (calculateTimeForDeceleration > 0) {
                    aVar.a(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(LayoutManager layoutManager, int i2, int i3) {
        if (!(layoutManager instanceof androidx.recyclerview.widget.RecyclerView.z.b)) {
            return false;
        }
        z createScroller = createScroller(layoutManager);
        if (createScroller == null) {
            return false;
        }
        int findTargetSnapPosition = findTargetSnapPosition(layoutManager, i2, i3);
        if (findTargetSnapPosition == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
                this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
                snapToTargetExistingView();
            }
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(LayoutManager layoutManager, View view);

    public int[] calculateScrollDistance(int i2, int i3) {
        this.mGravityScroller.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    public z createScroller(LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    @Deprecated
    public o createSnapScroller(LayoutManager layoutManager) {
        if (!(layoutManager instanceof androidx.recyclerview.widget.RecyclerView.z.b)) {
            return null;
        }
        return new b(this.mRecyclerView.getContext());
    }

    public abstract View findSnapView(LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(LayoutManager layoutManager, int i2, int i3);

    public boolean onFling(int i2, int i3) {
        LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        boolean z = false;
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && snapFromFling(layoutManager, i2, i3)) {
            z = true;
        }
        return z;
    }

    public void snapToTargetExistingView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                View findSnapView = findSnapView(layoutManager);
                if (findSnapView != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
                    if (!(calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0)) {
                        this.mRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    }
                }
            }
        }
    }
}
