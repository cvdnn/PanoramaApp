package e.g.a.a.w;

import android.content.Context;
import e.c.f.n.n;
import e.g.a.a.b;

/* compiled from: ElevationOverlayProvider */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final boolean f8395a;

    /* renamed from: b reason: collision with root package name */
    public final int f8396b;

    /* renamed from: c reason: collision with root package name */
    public final int f8397c;

    /* renamed from: d reason: collision with root package name */
    public final float f8398d;

    public a(Context context) {
        this.f8395a = n.a(context, b.elevationOverlayEnabled, false);
        this.f8396b = n.a(context, b.elevationOverlayColor, 0);
        this.f8397c = n.a(context, b.colorSurface, 0);
        this.f8398d = context.getResources().getDisplayMetrics().density;
    }
}
