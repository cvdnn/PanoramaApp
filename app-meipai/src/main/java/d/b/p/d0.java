package d.b.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;
import d.b.o.i.m.a;
import d.h.k.r;

/* compiled from: DecorToolbar */
public interface d0 {
    r a(int i2, long j2);

    void a(int i2);

    void a(Menu menu, a aVar);

    void a(q0 q0Var);

    void a(boolean z);

    boolean a();

    void b();

    void b(int i2);

    void b(boolean z);

    void c(int i2);

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    void g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    int i();

    ViewGroup j();

    int k();

    void l();

    void m();

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setWindowCallback(Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
