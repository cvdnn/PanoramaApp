package d.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import d.b.j;
import d.b.o.i.g;
import d.h.k.m;
import d.h.k.r;
import d.h.k.s;

/* compiled from: AbsActionBarView */
public abstract class a extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    public final C0028a f4257a;

    /* renamed from: b reason: collision with root package name */
    public final Context f4258b;

    /* renamed from: c reason: collision with root package name */
    public ActionMenuView f4259c;

    /* renamed from: d reason: collision with root package name */
    public c f4260d;

    /* renamed from: e reason: collision with root package name */
    public int f4261e;

    /* renamed from: f reason: collision with root package name */
    public r f4262f;

    /* renamed from: g reason: collision with root package name */
    public boolean f4263g;

    /* renamed from: h reason: collision with root package name */
    public boolean f4264h;

    /* renamed from: d.b.p.a$a reason: collision with other inner class name */
    /* compiled from: AbsActionBarView */
    public class C0028a implements s {

        /* renamed from: a reason: collision with root package name */
        public boolean f4265a = false;

        /* renamed from: b reason: collision with root package name */
        public int f4266b;

        public C0028a() {
        }

        public void a(View view) {
            this.f4265a = true;
        }

        public void b(View view) {
            if (!this.f4265a) {
                a aVar = a.this;
                aVar.f4262f = null;
                a.super.setVisibility(this.f4266b);
            }
        }

        public void c(View view) {
            a.super.setVisibility(0);
            this.f4265a = false;
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public int getAnimatedVisibility() {
        if (this.f4262f != null) {
            return this.f4257a.f4266b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f4261e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.ActionBar, d.b.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f4260d;
        if (cVar != null) {
            Configuration configuration2 = cVar.f4152b.getResources().getConfiguration();
            int i2 = configuration2.screenWidthDp;
            int i3 = configuration2.screenHeightDp;
            int i4 = (configuration2.smallestScreenWidthDp > 600 || i2 > 600 || (i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960)) ? 5 : (i2 >= 500 || (i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640)) ? 4 : i2 >= 360 ? 3 : 2;
            cVar.p = i4;
            g gVar = cVar.f4153c;
            if (gVar != null) {
                gVar.b(true);
            }
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4264h = false;
        }
        if (!this.f4264h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f4264h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f4264h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4263g = false;
        }
        if (!this.f4263g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f4263g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4263g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            r rVar = this.f4262f;
            if (rVar != null) {
                rVar.a();
            }
            super.setVisibility(i2);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r a(int i2, long j2) {
        r rVar = this.f4262f;
        if (rVar != null) {
            rVar.a();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            r a2 = m.a(this);
            a2.a(1.0f);
            a2.a(j2);
            C0028a aVar = this.f4257a;
            a.this.f4262f = a2;
            aVar.f4266b = i2;
            View view = (View) a2.f4940a.get();
            if (view != null) {
                a2.a(view, aVar);
            }
            return a2;
        }
        r a3 = m.a(this);
        a3.a(0.0f);
        a3.a(j2);
        C0028a aVar2 = this.f4257a;
        a.this.f4262f = a3;
        aVar2.f4266b = i2;
        View view2 = (View) a3.f4940a.get();
        if (view2 != null) {
            a3.a(view2, aVar2);
        }
        return a3;
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4257a = new C0028a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(d.b.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f4258b = context;
        } else {
            this.f4258b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public int a(View view, int i2, int i3, int i4) {
        view.measure(MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    public int a(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
