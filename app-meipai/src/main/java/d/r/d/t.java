package d.r.d;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

/* compiled from: OrientationHelper */
public abstract class t {

    /* renamed from: a reason: collision with root package name */
    public final LayoutManager f5399a;

    /* renamed from: b reason: collision with root package name */
    public int f5400b = Integer.MIN_VALUE;

    /* renamed from: c reason: collision with root package name */
    public final Rect f5401c = new Rect();

    public /* synthetic */ t(LayoutManager layoutManager, r rVar) {
        this.f5399a = layoutManager;
    }

    public static t a(LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return new r(layoutManager);
        }
        if (i2 == 1) {
            return new s(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i2);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f5400b) {
            return 0;
        }
        return g() - this.f5400b;
    }
}
