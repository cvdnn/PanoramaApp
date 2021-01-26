package e.d.a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import e.d.a.n.n.k;
import e.d.a.o.c;
import e.d.a.o.f;
import e.d.a.o.h;
import e.d.a.o.i;
import e.d.a.o.m;
import e.d.a.o.n;
import e.d.a.o.p;
import e.d.a.r.d;
import e.d.a.r.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager */
public class j implements ComponentCallbacks2, i {
    public static final e l;

    /* renamed from: a reason: collision with root package name */
    public final b f7132a;

    /* renamed from: b reason: collision with root package name */
    public final Context f7133b;

    /* renamed from: c reason: collision with root package name */
    public final h f7134c;

    /* renamed from: d reason: collision with root package name */
    public final n f7135d;

    /* renamed from: e reason: collision with root package name */
    public final m f7136e;

    /* renamed from: f reason: collision with root package name */
    public final p f7137f = new p();

    /* renamed from: g reason: collision with root package name */
    public final Runnable f7138g = new a();

    /* renamed from: h reason: collision with root package name */
    public final Handler f7139h = new Handler(Looper.getMainLooper());

    /* renamed from: i reason: collision with root package name */
    public final c f7140i;

    /* renamed from: j reason: collision with root package name */
    public final CopyOnWriteArrayList<d<Object>> f7141j;
    public e k;

    /* compiled from: RequestManager */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j jVar = j.this;
            jVar.f7134c.a(jVar);
        }
    }

    /* compiled from: RequestManager */
    public class b implements e.d.a.o.c.a {

        /* renamed from: a reason: collision with root package name */
        public final n f7143a;

        public b(n nVar) {
            this.f7143a = nVar;
        }

        public void a(boolean z) {
            if (z) {
                synchronized (j.this) {
                    n nVar = this.f7143a;
                    Iterator it = ((ArrayList) e.d.a.t.j.a((Collection<T>) nVar.f7827a)).iterator();
                    while (it.hasNext()) {
                        e.d.a.r.b bVar = (e.d.a.r.b) it.next();
                        if (!bVar.c() && !bVar.a()) {
                            bVar.clear();
                            if (!nVar.f7829c) {
                                bVar.b();
                            } else {
                                nVar.f7828b.add(bVar);
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        e eVar = (e) new e().a(Bitmap.class);
        eVar.t = true;
        l = eVar;
        ((e) new e().a(e.d.a.n.p.g.c.class)).t = true;
        e eVar2 = (e) ((e) ((e) new e().a(k.f7436b)).a(f.LOW)).a(true);
    }

    public j(b bVar, h hVar, m mVar, Context context) {
        c cVar;
        n nVar = new n();
        e.d.a.o.d dVar = bVar.f7089g;
        this.f7132a = bVar;
        this.f7134c = hVar;
        this.f7136e = mVar;
        this.f7135d = nVar;
        this.f7133b = context;
        Context applicationContext = context.getApplicationContext();
        b bVar2 = new b(nVar);
        if (((f) dVar) != null) {
            boolean z = d.h.e.a.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
            }
            if (z) {
                cVar = new e.d.a.o.e(applicationContext, bVar2);
            } else {
                cVar = new e.d.a.o.j();
            }
            this.f7140i = cVar;
            if (e.d.a.t.j.b()) {
                this.f7139h.post(this.f7138g);
            } else {
                hVar.a(this);
            }
            hVar.a(this.f7140i);
            this.f7141j = new CopyOnWriteArrayList<>(bVar.f7085c.f7105e);
            a(bVar.f7085c.a());
            bVar.a(this);
            return;
        }
        throw null;
    }

    public synchronized void a(e eVar) {
        e eVar2 = (e) eVar.clone();
        if (eVar2.t) {
            if (!eVar2.v) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
        }
        eVar2.v = true;
        eVar2.t = true;
        this.k = eVar2;
    }

    public synchronized void b() {
        e();
        this.f7137f.b();
    }

    public synchronized e d() {
        return this.k;
    }

    public synchronized void e() {
        n nVar = this.f7135d;
        nVar.f7829c = true;
        Iterator it = ((ArrayList) e.d.a.t.j.a((Collection<T>) nVar.f7827a)).iterator();
        while (it.hasNext()) {
            e.d.a.r.b bVar = (e.d.a.r.b) it.next();
            if (bVar.isRunning()) {
                bVar.d();
                nVar.f7828b.add(bVar);
            }
        }
    }

    public synchronized void f() {
        n nVar = this.f7135d;
        nVar.f7829c = false;
        Iterator it = ((ArrayList) e.d.a.t.j.a((Collection<T>) nVar.f7827a)).iterator();
        while (it.hasNext()) {
            e.d.a.r.b bVar = (e.d.a.r.b) it.next();
            if (!bVar.c() && !bVar.isRunning()) {
                bVar.b();
            }
        }
        nVar.f7828b.clear();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        f();
        this.f7137f.onStart();
    }

    public void onTrimMemory(int i2) {
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{tracker=");
        sb.append(this.f7135d);
        sb.append(", treeNode=");
        sb.append(this.f7136e);
        sb.append("}");
        return sb.toString();
    }

    public synchronized boolean b(e.d.a.r.h.h<?> hVar) {
        e.d.a.r.b c2 = hVar.c();
        if (c2 == null) {
            return true;
        }
        if (!this.f7135d.a(c2)) {
            return false;
        }
        this.f7137f.f7837a.remove(hVar);
        hVar.a((e.d.a.r.b) null);
        return true;
    }

    public synchronized void a() {
        this.f7137f.a();
        for (e.d.a.r.h.h a2 : e.d.a.t.j.a((Collection<T>) this.f7137f.f7837a)) {
            a(a2);
        }
        this.f7137f.f7837a.clear();
        n nVar = this.f7135d;
        Iterator it = ((ArrayList) e.d.a.t.j.a((Collection<T>) nVar.f7827a)).iterator();
        while (it.hasNext()) {
            nVar.a((e.d.a.r.b) it.next());
        }
        nVar.f7828b.clear();
        this.f7134c.b(this);
        this.f7134c.b(this.f7140i);
        this.f7139h.removeCallbacks(this.f7138g);
        this.f7132a.b(this);
    }

    public i<Drawable> a(File file) {
        i<Drawable> iVar = new i<>(this.f7132a, this, Drawable.class, this.f7133b);
        iVar.F = file;
        iVar.I = true;
        return iVar;
    }

    public void a(e.d.a.r.h.h<?> hVar) {
        if (hVar != null) {
            boolean b2 = b(hVar);
            e.d.a.r.b c2 = hVar.c();
            if (!b2 && !this.f7132a.a(hVar) && c2 != null) {
                hVar.a((e.d.a.r.b) null);
                c2.clear();
            }
        }
    }

    public synchronized void a(e.d.a.r.h.h<?> hVar, e.d.a.r.b bVar) {
        this.f7137f.f7837a.add(hVar);
        n nVar = this.f7135d;
        nVar.f7827a.add(bVar);
        if (!nVar.f7829c) {
            bVar.b();
        } else {
            bVar.clear();
            String str = "RequestTracker";
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "Paused, delaying request");
            }
            nVar.f7828b.add(bVar);
        }
    }
}
