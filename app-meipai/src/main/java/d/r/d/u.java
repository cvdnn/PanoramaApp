package d.r.d;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.z.b;

/* compiled from: PagerSnapHelper */
public class u extends x {
    public static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    public t mHorizontalHelper;
    public t mVerticalHelper;

    /* compiled from: PagerSnapHelper */
    public class a extends o {
        public a(Context context) {
            super(context);
        }

        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        public int calculateTimeForScrolling(int i2) {
            return Math.min(100, super.calculateTimeForScrolling(i2));
        }

        public void onTargetFound(View view, a0 a0Var, androidx.recyclerview.widget.RecyclerView.z.a aVar) {
            u uVar = u.this;
            int[] calculateDistanceToFinalSnap = uVar.calculateDistanceToFinalSnap(uVar.mRecyclerView.getLayoutManager(), view);
            int i2 = calculateDistanceToFinalSnap[0];
            int i3 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
            if (calculateTimeForDeceleration > 0) {
                aVar.a(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private int distanceToCenter(LayoutManager layoutManager, View view, t tVar) {
        return ((tVar.b(view) / 2) + tVar.d(view)) - ((tVar.g() / 2) + tVar.f());
    }

    private View findCenterView(LayoutManager layoutManager, t tVar) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int g2 = (tVar.g() / 2) + tVar.f();
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int abs = Math.abs(((tVar.b(childAt) / 2) + tVar.d(childAt)) - g2);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    private t getHorizontalHelper(LayoutManager layoutManager) {
        t tVar = this.mHorizontalHelper;
        if (tVar == null || tVar.f5399a != layoutManager) {
            this.mHorizontalHelper = new r(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    private t getOrientationHelper(LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return getVerticalHelper(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return getHorizontalHelper(layoutManager);
        }
        return null;
    }

    private t getVerticalHelper(LayoutManager layoutManager) {
        t tVar = this.mVerticalHelper;
        if (tVar == null || tVar.f5399a != layoutManager) {
            this.mVerticalHelper = new s(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(LayoutManager layoutManager, int i2, int i3) {
        boolean z = true;
        if (layoutManager.canScrollHorizontally()) {
            if (i2 <= 0) {
                z = false;
            }
            return z;
        }
        if (i3 <= 0) {
            z = false;
        }
        return z;
    }

    private boolean isReverseLayout(LayoutManager layoutManager) {
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof b)) {
            return false;
        }
        PointF computeScrollVectorForPosition = ((b) layoutManager).computeScrollVectorForPosition(itemCount - 1);
        if (computeScrollVectorForPosition == null) {
            return false;
        }
        if (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f) {
            return true;
        }
        return false;
    }

    public int[] calculateDistanceToFinalSnap(LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(layoutManager, view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public o createSnapScroller(LayoutManager layoutManager) {
        if (!(layoutManager instanceof b)) {
            return null;
        }
        return new a(this.mRecyclerView.getContext());
    }

    public View findSnapView(LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    public int findTargetSnapPosition(LayoutManager layoutManager, int i2, int i3) {
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        t orientationHelper = getOrientationHelper(layoutManager);
        if (orientationHelper == null) {
            return -1;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = layoutManager.getChildAt(i6);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(layoutManager, childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i4) {
                    view2 = childAt;
                    i4 = distanceToCenter;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i5) {
                    view = childAt;
                    i5 = distanceToCenter;
                }
            }
        }
        boolean isForwardFling = isForwardFling(layoutManager, i2, i3);
        if (isForwardFling && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!isForwardFling && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (isForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view) + (isReverseLayout(layoutManager) == isForwardFling ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
