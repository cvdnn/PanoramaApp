package e.c.d.l.c;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import e.c.d.i.c.n;
import e.c.d.i.c.r;
import e.c.d.i.c.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.SocketFactory;

/* compiled from: NetworkBindService */
public class h {

    /* renamed from: j reason: collision with root package name */
    public static volatile h f6385j;

    /* renamed from: a reason: collision with root package name */
    public ConnectivityManager f6386a;

    /* renamed from: b reason: collision with root package name */
    public Map<Integer, e> f6387b = new ConcurrentHashMap();

    /* renamed from: c reason: collision with root package name */
    public ExecutorService f6388c = Executors.newSingleThreadExecutor();

    /* renamed from: d reason: collision with root package name */
    public e.c.d.d.f.b<c> f6389d;

    /* renamed from: e reason: collision with root package name */
    public e.c.d.d.f.b<f> f6390e;

    /* renamed from: f reason: collision with root package name */
    public d f6391f = d.NONE;

    /* renamed from: g reason: collision with root package name */
    public boolean f6392g = false;

    /* renamed from: h reason: collision with root package name */
    public NetworkCallback f6393h = new a();

    /* renamed from: i reason: collision with root package name */
    public NetworkCallback f6394i = new b();

    /* compiled from: NetworkBindService */
    public class a extends NetworkCallback {
        public a() {
        }

        public /* synthetic */ void a(e eVar) {
            h hVar = h.this;
            if (hVar.a()) {
                hVar.a(eVar);
                hVar.a(d.CELLULAR);
            } else if (((e) hVar.f6387b.get(Integer.valueOf(1))) != null) {
                hVar.a(d.WIFI);
            } else {
                hVar.a(d.CELLULAR);
            }
            hVar.f6387b.put(Integer.valueOf(0), eVar);
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            network.toString();
            e eVar = new e(null);
            eVar.f6402b = false;
            eVar.f6401a = network;
            h.this.f6388c.execute(new b(this, eVar));
        }

        public void onLost(Network network) {
            super.onLost(network);
            network.toString();
            h.this.f6388c.execute(new a(this));
        }

        public /* synthetic */ void a() {
            h hVar = h.this;
            Map<Integer, e> map = hVar.f6387b;
            Integer valueOf = Integer.valueOf(0);
            e eVar = (e) map.get(valueOf);
            if (eVar != null) {
                if (eVar.f6402b) {
                    hVar.f6386a.bindProcessToNetwork(null);
                    eVar.f6402b = false;
                }
                hVar.f6387b.remove(valueOf);
            }
            if (((e) hVar.f6387b.get(Integer.valueOf(1))) != null) {
                hVar.a(d.WIFI);
            } else {
                hVar.a(d.NONE);
            }
        }
    }

    /* compiled from: NetworkBindService */
    public class b extends NetworkCallback {
        public b() {
        }

        public /* synthetic */ void a(e eVar) {
            h hVar = h.this;
            hVar.f6387b.put(Integer.valueOf(1), eVar);
            boolean a2 = hVar.a();
            hVar.f6392g = a2;
            if (a2) {
                hVar.f6390e.contains(e.f6382a);
            }
            e eVar2 = (e) hVar.f6387b.get(Integer.valueOf(0));
            if (eVar2 == null) {
                hVar.a(d.WIFI);
            } else if (!hVar.f6392g || eVar2.f6402b) {
                hVar.f6386a.bindProcessToNetwork(null);
                eVar2.f6402b = false;
                hVar.a(d.WIFI);
            } else {
                hVar.a(eVar2);
                hVar.a(d.CELLULAR);
            }
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            network.toString();
            e eVar = new e(null);
            eVar.f6401a = network;
            h.this.f6388c.execute(new d(this, eVar));
        }

        public void onLost(Network network) {
            super.onLost(network);
            network.toString();
            h.this.f6388c.execute(new c(this));
        }

        public /* synthetic */ void a() {
            h hVar = h.this;
            if (hVar != null) {
                r.f6218b.a(SocketFactory.getDefault());
                hVar.f6387b.remove(Integer.valueOf(1));
                if (hVar.f6392g) {
                    hVar.f6392g = false;
                    hVar.f6390e.contains(f.f6383a);
                }
                if (((e) hVar.f6387b.get(Integer.valueOf(0))) == null) {
                    hVar.a(d.NONE);
                } else {
                    hVar.a(d.CELLULAR);
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: NetworkBindService */
    public interface c {
        void a(d dVar);
    }

    /* compiled from: NetworkBindService */
    public enum d {
        NONE,
        CELLULAR,
        WIFI
    }

    /* compiled from: NetworkBindService */
    public static class e {

        /* renamed from: a reason: collision with root package name */
        public Network f6401a;

        /* renamed from: b reason: collision with root package name */
        public boolean f6402b = false;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
        }
    }

    /* compiled from: NetworkBindService */
    public interface f {
        void a(boolean z);
    }

    public static h c() {
        if (f6385j == null) {
            synchronized (h.class) {
                if (f6385j == null) {
                    f6385j = new h();
                }
            }
        }
        return f6385j;
    }

    public final boolean a() {
        if (r.f6218b == null) {
            throw null;
        } else if (n.f6212c != null) {
            return s.f6220b.a();
        } else {
            throw null;
        }
    }

    public void b() {
        this.f6386a.unregisterNetworkCallback(this.f6393h);
        this.f6386a.unregisterNetworkCallback(this.f6394i);
        this.f6387b.clear();
        this.f6388c.shutdownNow();
        this.f6386a = null;
    }

    public final void a(e eVar) {
        this.f6386a.bindProcessToNetwork(eVar.f6401a);
        eVar.f6402b = true;
        e eVar2 = (e) this.f6387b.get(Integer.valueOf(1));
        if (eVar2 != null) {
            r.f6218b.a(eVar2.f6401a.getSocketFactory());
        }
    }

    public final void a(d dVar) {
        if (this.f6391f != dVar) {
            this.f6391f = dVar;
            this.f6389d.observable(new g(dVar));
        }
    }

    public void a(c cVar) {
        if (this.f6389d.contains(cVar)) {
            this.f6389d.unregisterObserver(cVar);
        }
    }
}
