package g;

import d.r.d.o;
import g.d0.c;
import g.d0.d.e;
import g.d0.e.g;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: OkHttpClient */
public class u implements Cloneable {
    public static final List<v> B = c.a((T[]) new v[]{v.HTTP_2, v.HTTP_1_1});
    public static final List<i> C = c.a((T[]) new i[]{i.f9498f, i.f9499g});
    public final int A;

    /* renamed from: a reason: collision with root package name */
    public final l f9561a;

    /* renamed from: b reason: collision with root package name */
    public final Proxy f9562b;

    /* renamed from: c reason: collision with root package name */
    public final List<v> f9563c;

    /* renamed from: d reason: collision with root package name */
    public final List<i> f9564d;

    /* renamed from: e reason: collision with root package name */
    public final List<s> f9565e;

    /* renamed from: f reason: collision with root package name */
    public final List<s> f9566f;

    /* renamed from: g reason: collision with root package name */
    public final g.n.b f9567g;

    /* renamed from: h reason: collision with root package name */
    public final ProxySelector f9568h;

    /* renamed from: i reason: collision with root package name */
    public final k f9569i;

    /* renamed from: j reason: collision with root package name */
    public final c f9570j;
    public final e k;
    public final SocketFactory l;
    public final SSLSocketFactory m;
    public final g.d0.j.c n;
    public final HostnameVerifier o;
    public final f p;
    public final b q;
    public final b r;
    public final h s;
    public final m t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final int x;
    public final int y;
    public final int z;

    /* compiled from: OkHttpClient */
    public class a extends g.d0.a {
        public g.d0.e.c a(h hVar, a aVar, g gVar, b0 b0Var) {
            for (g.d0.e.c cVar : hVar.f9493d) {
                if (cVar.a(aVar, b0Var)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }

        public Socket a(h hVar, a aVar, g gVar) {
            for (g.d0.e.c cVar : hVar.f9493d) {
                if (cVar.a(aVar, null) && cVar.a() && cVar != gVar.c()) {
                    if (gVar.n == null && gVar.f9229j.n.size() == 1) {
                        Reference reference = (Reference) gVar.f9229j.n.get(0);
                        Socket a2 = gVar.a(true, false, false);
                        gVar.f9229j = cVar;
                        cVar.n.add(reference);
                        return a2;
                    }
                    throw new IllegalStateException();
                }
            }
            return null;
        }

        public void a(g.q.a aVar, String str, String str2) {
            aVar.f9533a.add(str);
            aVar.f9533a.add(str2.trim());
        }
    }

    /* compiled from: OkHttpClient */
    public static final class b {
        public int A;

        /* renamed from: a reason: collision with root package name */
        public l f9571a;

        /* renamed from: b reason: collision with root package name */
        public Proxy f9572b;

        /* renamed from: c reason: collision with root package name */
        public List<v> f9573c;

        /* renamed from: d reason: collision with root package name */
        public List<i> f9574d;

        /* renamed from: e reason: collision with root package name */
        public final List<s> f9575e;

        /* renamed from: f reason: collision with root package name */
        public final List<s> f9576f;

        /* renamed from: g reason: collision with root package name */
        public g.n.b f9577g;

        /* renamed from: h reason: collision with root package name */
        public ProxySelector f9578h;

        /* renamed from: i reason: collision with root package name */
        public k f9579i;

        /* renamed from: j reason: collision with root package name */
        public c f9580j;
        public e k;
        public SocketFactory l;
        public SSLSocketFactory m;
        public g.d0.j.c n;
        public HostnameVerifier o;
        public f p;
        public b q;
        public b r;
        public h s;
        public m t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b() {
            this.f9575e = new ArrayList();
            this.f9576f = new ArrayList();
            this.f9571a = new l();
            this.f9573c = u.B;
            this.f9574d = u.C;
            this.f9577g = new o(n.f9526a);
            this.f9578h = ProxySelector.getDefault();
            this.f9579i = k.f9518a;
            this.l = SocketFactory.getDefault();
            this.o = g.d0.j.e.f9472a;
            this.p = f.f9473c;
            b bVar = b.f9143a;
            this.q = bVar;
            this.r = bVar;
            this.s = new h(5, 5, TimeUnit.MINUTES);
            this.t = m.f9525a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = o.TARGET_SEEK_SCROLL_DISTANCE_PX;
            this.y = o.TARGET_SEEK_SCROLL_DISTANCE_PX;
            this.z = o.TARGET_SEEK_SCROLL_DISTANCE_PX;
            this.A = 0;
        }

        public b a(long j2, TimeUnit timeUnit) {
            this.x = c.a("timeout", j2, timeUnit);
            return this;
        }

        public b b(long j2, TimeUnit timeUnit) {
            this.y = c.a("timeout", j2, timeUnit);
            return this;
        }

        public b c(long j2, TimeUnit timeUnit) {
            this.z = c.a("timeout", j2, timeUnit);
            return this;
        }

        public b a(List<v> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(v.HTTP_1_1)) {
                StringBuilder sb = new StringBuilder();
                sb.append("protocols doesn't contain http/1.1: ");
                sb.append(arrayList);
                throw new IllegalArgumentException(sb.toString());
            } else if (arrayList.contains(v.HTTP_1_0)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("protocols must not contain http/1.0: ");
                sb2.append(arrayList);
                throw new IllegalArgumentException(sb2.toString());
            } else if (!arrayList.contains(null)) {
                arrayList.remove(v.SPDY_3);
                this.f9573c = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public b(u uVar) {
            this.f9575e = new ArrayList();
            this.f9576f = new ArrayList();
            this.f9571a = uVar.f9561a;
            this.f9572b = uVar.f9562b;
            this.f9573c = uVar.f9563c;
            this.f9574d = uVar.f9564d;
            this.f9575e.addAll(uVar.f9565e);
            this.f9576f.addAll(uVar.f9566f);
            this.f9577g = uVar.f9567g;
            this.f9578h = uVar.f9568h;
            this.f9579i = uVar.f9569i;
            this.k = uVar.k;
            this.f9580j = null;
            this.l = uVar.l;
            this.m = uVar.m;
            this.n = uVar.n;
            this.o = uVar.o;
            this.p = uVar.p;
            this.q = uVar.q;
            this.r = uVar.r;
            this.s = uVar.s;
            this.t = uVar.t;
            this.u = uVar.u;
            this.v = uVar.v;
            this.w = uVar.w;
            this.x = uVar.x;
            this.y = uVar.y;
            this.z = uVar.z;
            this.A = uVar.A;
        }
    }

    static {
        g.d0.a.f9172a = new a();
    }

    public u() {
        this(new b());
    }

    public e a(x xVar) {
        w wVar = new w(this, xVar, false);
        wVar.f9589c = ((o) this.f9567g).f9527a;
        return wVar;
    }

    public u(b bVar) {
        boolean z2;
        String str = "No System TLS";
        this.f9561a = bVar.f9571a;
        this.f9562b = bVar.f9572b;
        this.f9563c = bVar.f9573c;
        this.f9564d = bVar.f9574d;
        this.f9565e = c.a(bVar.f9575e);
        this.f9566f = c.a(bVar.f9576f);
        this.f9567g = bVar.f9577g;
        this.f9568h = bVar.f9578h;
        this.f9569i = bVar.f9579i;
        this.f9570j = null;
        this.k = bVar.k;
        this.l = bVar.l;
        Iterator it = this.f9564d.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                i iVar = (i) it.next();
                if (z2 || iVar.f9500a) {
                    z2 = true;
                }
            }
        }
        if (bVar.m != null || !z2) {
            this.m = bVar.m;
            this.n = bVar.n;
        } else {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(null);
                TrustManager[] trustManagers = instance.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected default trust managers:");
                    sb.append(Arrays.toString(trustManagers));
                    throw new IllegalStateException(sb.toString());
                }
                X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
                try {
                    SSLContext instance2 = SSLContext.getInstance("TLS");
                    instance2.init(null, new TrustManager[]{x509TrustManager}, null);
                    this.m = instance2.getSocketFactory();
                    this.n = g.d0.i.e.f9461a.a(x509TrustManager);
                } catch (GeneralSecurityException e2) {
                    throw c.a(str, (Exception) e2);
                }
            } catch (GeneralSecurityException e3) {
                throw c.a(str, (Exception) e3);
            }
        }
        this.o = bVar.o;
        f fVar = bVar.p;
        g.d0.j.c cVar = this.n;
        if (!c.a((Object) fVar.f9475b, (Object) cVar)) {
            fVar = new f(fVar.f9474a, cVar);
        }
        this.p = fVar;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.x = bVar.x;
        this.y = bVar.y;
        this.z = bVar.z;
        this.A = bVar.A;
        if (this.f9565e.contains(null)) {
            StringBuilder a2 = e.a.a.a.a.a("Null interceptor: ");
            a2.append(this.f9565e);
            throw new IllegalStateException(a2.toString());
        } else if (this.f9566f.contains(null)) {
            StringBuilder a3 = e.a.a.a.a.a("Null network interceptor: ");
            a3.append(this.f9566f);
            throw new IllegalStateException(a3.toString());
        }
    }
}
