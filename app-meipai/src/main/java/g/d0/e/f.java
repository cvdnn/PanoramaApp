package g.d0.e;

import g.b0;
import g.d0.c;
import g.e;
import g.n;
import g.r;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: RouteSelector */
public final class f {

    /* renamed from: a reason: collision with root package name */
    public final g.a f9210a;

    /* renamed from: b reason: collision with root package name */
    public final d f9211b;

    /* renamed from: c reason: collision with root package name */
    public final e f9212c;

    /* renamed from: d reason: collision with root package name */
    public final n f9213d;

    /* renamed from: e reason: collision with root package name */
    public List<Proxy> f9214e = Collections.emptyList();

    /* renamed from: f reason: collision with root package name */
    public int f9215f;

    /* renamed from: g reason: collision with root package name */
    public List<InetSocketAddress> f9216g = Collections.emptyList();

    /* renamed from: h reason: collision with root package name */
    public final List<b0> f9217h = new ArrayList();

    /* compiled from: RouteSelector */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public final List<b0> f9218a;

        /* renamed from: b reason: collision with root package name */
        public int f9219b = 0;

        public a(List<b0> list) {
            this.f9218a = list;
        }

        public boolean a() {
            return this.f9219b < this.f9218a.size();
        }
    }

    public f(g.a aVar, d dVar, e eVar, n nVar) {
        List<Proxy> list;
        this.f9210a = aVar;
        this.f9211b = dVar;
        this.f9212c = eVar;
        this.f9213d = nVar;
        r rVar = aVar.f9126a;
        Proxy proxy = aVar.f9133h;
        if (proxy != null) {
            this.f9214e = Collections.singletonList(proxy);
        } else {
            List select = aVar.f9132g.select(rVar.f());
            if (select == null || select.isEmpty()) {
                list = c.a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = c.a(select);
            }
            this.f9214e = list;
        }
        this.f9215f = 0;
    }

    public boolean a() {
        return b() || !this.f9217h.isEmpty();
    }

    public final boolean b() {
        return this.f9215f < this.f9214e.size();
    }
}
