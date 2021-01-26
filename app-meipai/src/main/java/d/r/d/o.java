package d.r.d;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.z;
import androidx.recyclerview.widget.RecyclerView.z.a;

/* compiled from: LinearSmoothScroller */
public class o extends z {
    public static final boolean DEBUG = false;
    public static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    public static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    public static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    public final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    public final DisplayMetrics mDisplayMetrics;
    public boolean mHasCalculatedMillisPerPixel = false;
    public int mInterimTargetDx = 0;
    public int mInterimTargetDy = 0;
    public final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    public float mMillisPerPixel;
    public PointF mTargetVector;

    public o(Context context) {
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private int clampApplyScroll(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    private float getSpeedPerPixel() {
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return this.mMillisPerPixel;
    }

    public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int calculateDxToMakeVisible(View view, int i2) {
        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        androidx.recyclerview.widget.RecyclerView.o oVar = (androidx.recyclerview.widget.RecyclerView.o) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedLeft(view) - oVar.leftMargin, layoutManager.getDecoratedRight(view) + oVar.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i2);
    }

    public int calculateDyToMakeVisible(View view, int i2) {
        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        androidx.recyclerview.widget.RecyclerView.o oVar = (androidx.recyclerview.widget.RecyclerView.o) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedTop(view) - oVar.topMargin, layoutManager.getDecoratedBottom(view) + oVar.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i2);
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int calculateTimeForDeceleration(int i2) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(i2)) / 0.3356d);
    }

    public int calculateTimeForScrolling(int i2) {
        return (int) Math.ceil((double) (((float) Math.abs(i2)) * getSpeedPerPixel()));
    }

    public int getHorizontalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public void onSeekTargetStep(int i2, int i3, a0 a0Var, a aVar) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i2);
        int clampApplyScroll = clampApplyScroll(this.mInterimTargetDy, i3);
        this.mInterimTargetDy = clampApplyScroll;
        if (this.mInterimTargetDx == 0 && clampApplyScroll == 0) {
            updateActionForInterimTarget(aVar);
        }
    }

    public void onStart() {
    }

    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    public void onTargetFound(View view, a0 a0Var, a aVar) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((double) ((calculateDyToMakeVisible * calculateDyToMakeVisible) + (calculateDxToMakeVisible * calculateDxToMakeVisible))));
        if (calculateTimeForDeceleration > 0) {
            aVar.a(-calculateDxToMakeVisible, -calculateDyToMakeVisible, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    public void updateActionForInterimTarget(a aVar) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f)) {
            aVar.f1065d = getTargetPosition();
            stop();
            return;
        }
        normalize(computeScrollVectorForPosition);
        this.mTargetVector = computeScrollVectorForPosition;
        this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
        this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
        aVar.a((int) (((float) this.mInterimTargetDx) * 1.2f), (int) (((float) this.mInterimTargetDy) * 1.2f), (int) (((float) calculateTimeForScrolling(TARGET_SEEK_SCROLL_DISTANCE_PX)) * 1.2f), this.mLinearInterpolator);
    }
}
