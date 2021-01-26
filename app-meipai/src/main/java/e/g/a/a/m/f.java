package e.g.a.a.m;

import android.view.View;
import d.h.k.m;

/* compiled from: ViewOffsetHelper */
public class f {

    /* renamed from: a reason: collision with root package name */
    public final View f8262a;

    /* renamed from: b reason: collision with root package name */
    public int f8263b;

    /* renamed from: c reason: collision with root package name */
    public int f8264c;

    /* renamed from: d reason: collision with root package name */
    public int f8265d;

    /* renamed from: e reason: collision with root package name */
    public int f8266e;

    /* renamed from: f reason: collision with root package name */
    public boolean f8267f = true;

    /* renamed from: g reason: collision with root package name */
    public boolean f8268g = true;

    public f(View view) {
        this.f8262a = view;
    }

    public void a() {
        View view = this.f8262a;
        m.d(view, this.f8265d - (view.getTop() - this.f8263b));
        View view2 = this.f8262a;
        view2.offsetLeftAndRight(this.f8266e - (view2.getLeft() - this.f8264c));
    }
}
