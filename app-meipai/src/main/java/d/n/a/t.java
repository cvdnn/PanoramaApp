package d.n.a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.e.a;

/* compiled from: FragmentTransition */
public final class t implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Fragment f5216a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Fragment f5217b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ boolean f5218c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ a f5219d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ View f5220e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ a0 f5221f;

    /* renamed from: g reason: collision with root package name */
    public final /* synthetic */ Rect f5222g;

    public t(Fragment fragment, Fragment fragment2, boolean z, a aVar, View view, a0 a0Var, Rect rect) {
        this.f5216a = fragment;
        this.f5217b = fragment2;
        this.f5218c = z;
        this.f5219d = aVar;
        this.f5220e = view;
        this.f5221f = a0Var;
        this.f5222g = rect;
    }

    public void run() {
        v.a(this.f5216a, this.f5217b, this.f5218c, this.f5219d, false);
        View view = this.f5220e;
        if (view != null) {
            this.f5221f.a(view, this.f5222g);
        }
    }
}
