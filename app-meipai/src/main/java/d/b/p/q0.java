package d.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.baidubce.auth.NTLMEngineImpl;
import d.b.b;
import d.b.d;
import d.b.j;
import d.b.k.a.c;

/* compiled from: ScrollingTabContainerView */
public class q0 extends HorizontalScrollView implements OnItemSelectedListener {

    /* renamed from: a reason: collision with root package name */
    public Runnable f4423a;

    /* renamed from: b reason: collision with root package name */
    public boolean f4424b;

    /* renamed from: c reason: collision with root package name */
    public int f4425c;

    /* renamed from: d reason: collision with root package name */
    public int f4426d;

    /* renamed from: e reason: collision with root package name */
    public int f4427e;

    /* renamed from: f reason: collision with root package name */
    public int f4428f;

    /* compiled from: ScrollingTabContainerView */
    public class a extends LinearLayout {

        /* renamed from: a reason: collision with root package name */
        public c f4429a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ q0 f4430b;

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (this.f4430b.f4425c > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = this.f4430b.f4425c;
                if (measuredWidth > i4) {
                    super.onMeasure(MeasureSpec.makeMeasureSpec(i4, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), i3);
                }
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f4423a;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.ActionBar, d.b.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!context.getResources().getBoolean(b.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.f4426d = context.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f4423a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((a) view).f4429a.a();
    }

    public void onMeasure(int i2, int i3) {
        setFillViewport(MeasureSpec.getMode(i2) == 1073741824);
        throw null;
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f4424b = z;
    }

    public void setContentHeight(int i2) {
        this.f4427e = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f4428f = i2;
        throw null;
    }
}
