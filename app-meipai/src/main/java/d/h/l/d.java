package d.h.l;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* compiled from: ScrollerCompat */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public OverScroller f4991a;

    public d(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator != null) {
            overScroller = new OverScroller(context, interpolator);
        } else {
            overScroller = new OverScroller(context);
        }
        this.f4991a = overScroller;
    }

    @Deprecated
    public int a() {
        return this.f4991a.getCurrX();
    }

    @Deprecated
    public int b() {
        return this.f4991a.getCurrY();
    }
}
