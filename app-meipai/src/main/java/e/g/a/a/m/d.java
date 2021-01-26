package e.g.a.a.m;

import a.a.a.a.b.a;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import d.h.k.m;
import d.h.k.v;

/* compiled from: HeaderScrollingViewBehavior */
public abstract class d extends e<View> {

    /* renamed from: d reason: collision with root package name */
    public final Rect f8255d = new Rect();

    /* renamed from: e reason: collision with root package name */
    public final Rect f8256e = new Rect();

    /* renamed from: f reason: collision with root package name */
    public int f8257f = 0;

    /* renamed from: g reason: collision with root package name */
    public int f8258g;

    public d() {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        int i6 = view.getLayoutParams().height;
        if (i6 == -1 || i6 == -2) {
            AppBarLayout a2 = ((ScrollingViewBehavior) this).a(coordinatorLayout.a(view));
            if (a2 != null) {
                int size = MeasureSpec.getSize(i4);
                if (size <= 0) {
                    size = coordinatorLayout.getHeight();
                } else if (m.i(a2)) {
                    v lastWindowInsets = coordinatorLayout.getLastWindowInsets();
                    if (lastWindowInsets != null) {
                        size += lastWindowInsets.a() + lastWindowInsets.d();
                    }
                }
                coordinatorLayout.a(view, i2, i3, MeasureSpec.makeMeasureSpec((size + a2.getTotalScrollRange()) - a2.getMeasuredHeight(), i6 == -1 ? NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH : Integer.MIN_VALUE), i5);
                return true;
            }
        }
        return false;
    }

    public void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        AppBarLayout a2 = ((ScrollingViewBehavior) this).a(coordinatorLayout.a(view));
        if (a2 != null) {
            f fVar = (f) view.getLayoutParams();
            Rect rect = this.f8255d;
            rect.set(coordinatorLayout.getPaddingLeft() + fVar.leftMargin, a2.getBottom() + fVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - fVar.rightMargin, ((a2.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - fVar.bottomMargin);
            v lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && m.i(coordinatorLayout) && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.b() + rect.left;
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f8256e;
            int i3 = fVar.f858c;
            if (i3 == 0) {
                i3 = 8388659;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int a3 = a(a2);
            view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
            this.f8257f = rect2.top - a2.getBottom();
            return;
        }
        coordinatorLayout.b(view, i2);
        this.f8257f = 0;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int a(View view) {
        if (this.f8258g == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            c cVar = ((f) appBarLayout.getLayoutParams()).f856a;
            int c2 = cVar instanceof BaseBehavior ? ((BaseBehavior) cVar).c() : 0;
            if (downNestedPreScrollRange == 0 || totalScrollRange + c2 > downNestedPreScrollRange) {
                int i2 = totalScrollRange - downNestedPreScrollRange;
                if (i2 != 0) {
                    f2 = 1.0f + (((float) c2) / ((float) i2));
                }
            }
        }
        int i3 = this.f8258g;
        return a.a((int) (f2 * ((float) i3)), 0, i3);
    }
}
