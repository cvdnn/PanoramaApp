package d.n.a;

import a.a.a.a.b.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentHostCallback */
public abstract class h<E> extends e {

    /* renamed from: a reason: collision with root package name */
    public final Activity f5121a;

    /* renamed from: b reason: collision with root package name */
    public final Context f5122b;

    /* renamed from: c reason: collision with root package name */
    public final Handler f5123c;

    /* renamed from: d reason: collision with root package name */
    public final int f5124d;

    /* renamed from: e reason: collision with root package name */
    public final j f5125e = new j();

    public h(d dVar) {
        Handler handler = new Handler();
        this.f5121a = dVar;
        a.a(dVar, (Object) "context == null");
        this.f5122b = dVar;
        a.a(handler, (Object) "handler == null");
        this.f5123c = handler;
        this.f5124d = 0;
    }

    public abstract void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle);
}
