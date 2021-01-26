package d.r.d;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.z.b;

/* compiled from: LinearSnapHelper */
public class p extends x {

    /* renamed from: a reason: collision with root package name */
    public t f5396a;

    /* renamed from: b reason: collision with root package name */
    public t f5397b;

    public final int a(View view, t tVar) {
        return ((tVar.b(view) / 2) + tVar.d(view)) - ((tVar.g() / 2) + tVar.f());
    }

    public int[] calculateDistanceToFinalSnap(LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final View findCenterView(LayoutManager layoutManager, t tVar) {
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
        int i4;
        int i5;
        if (!(layoutManager instanceof b)) {
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View findSnapView = findSnapView(layoutManager);
        if (findSnapView == null) {
            return -1;
        }
        int position = layoutManager.getPosition(findSnapView);
        if (position == -1) {
            return -1;
        }
        int i6 = itemCount - 1;
        PointF computeScrollVectorForPosition = ((b) layoutManager).computeScrollVectorForPosition(i6);
        if (computeScrollVectorForPosition == null) {
            return -1;
        }
        int i7 = 0;
        if (layoutManager.canScrollHorizontally()) {
            i4 = a(layoutManager, getHorizontalHelper(layoutManager), i2, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = a(layoutManager, getVerticalHelper(layoutManager), 0, i3);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i8 = position + i4;
        if (i8 >= 0) {
            i7 = i8;
        }
        if (i7 < itemCount) {
            i6 = i7;
        }
        return i6;
    }

    public final t getHorizontalHelper(LayoutManager layoutManager) {
        t tVar = this.f5397b;
        if (tVar == null || tVar.f5399a != layoutManager) {
            this.f5397b = new r(layoutManager);
        }
        return this.f5397b;
    }

    public final t getVerticalHelper(LayoutManager layoutManager) {
        t tVar = this.f5396a;
        if (tVar == null || tVar.f5399a != layoutManager) {
            this.f5396a = new s(layoutManager);
        }
        return this.f5396a;
    }

    public final int a(LayoutManager layoutManager, t tVar, int i2, int i3) {
        int[] calculateScrollDistance = calculateScrollDistance(i2, i3);
        int childCount = layoutManager.getChildCount();
        float f2 = 1.0f;
        if (childCount != 0) {
            View view = null;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            View view2 = null;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = layoutManager.getChildAt(i6);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i5) {
                        view = childAt;
                        i5 = position;
                    }
                    if (position > i4) {
                        view2 = childAt;
                        i4 = position;
                    }
                }
            }
            if (!(view == null || view2 == null)) {
                int max = Math.max(tVar.a(view), tVar.a(view2)) - Math.min(tVar.d(view), tVar.d(view2));
                if (max != 0) {
                    f2 = (((float) max) * 1.0f) / ((float) ((i4 - i5) + 1));
                }
            }
        }
        if (f2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1])) / f2);
    }
}
