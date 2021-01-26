package g;

import com.baidu.mobstat.Config;
import g.d0.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public final r f9126a;

    /* renamed from: b reason: collision with root package name */
    public final m f9127b;

    /* renamed from: c reason: collision with root package name */
    public final SocketFactory f9128c;

    /* renamed from: d reason: collision with root package name */
    public final b f9129d;

    /* renamed from: e reason: collision with root package name */
    public final List<v> f9130e;

    /* renamed from: f reason: collision with root package name */
    public final List<i> f9131f;

    /* renamed from: g reason: collision with root package name */
    public final ProxySelector f9132g;

    /* renamed from: h reason: collision with root package name */
    public final Proxy f9133h;

    /* renamed from: i reason: collision with root package name */
    public final SSLSocketFactory f9134i;

    /* renamed from: j reason: collision with root package name */
    public final HostnameVerifier f9135j;
    public final f k;

    public a(String str, int i2, m mVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, b bVar, Proxy proxy, List<v> list, List<i> list2, ProxySelector proxySelector) {
        String str2 = str;
        int i3 = i2;
        m mVar2 = mVar;
        SocketFactory socketFactory2 = socketFactory;
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        b bVar2 = bVar;
        ProxySelector proxySelector2 = proxySelector;
        g.r.a aVar = new g.r.a();
        String str3 = "https";
        String str4 = "http";
        String str5 = sSLSocketFactory2 != null ? str3 : str4;
        if (str5.equalsIgnoreCase(str4)) {
            aVar.f9543a = str4;
        } else if (str5.equalsIgnoreCase(str3)) {
            aVar.f9543a = str3;
        } else {
            throw new IllegalArgumentException(e.a.a.a.a.a("unexpected scheme: ", str5));
        }
        if (str2 != null) {
            String a2 = g.r.a.a(str, 0, str.length());
            if (a2 != null) {
                aVar.f9546d = a2;
                if (i3 <= 0 || i3 > 65535) {
                    throw new IllegalArgumentException(e.a.a.a.a.a("unexpected port: ", i2));
                }
                aVar.f9547e = i3;
                this.f9126a = aVar.a();
                if (mVar2 != null) {
                    this.f9127b = mVar2;
                    if (socketFactory2 != null) {
                        this.f9128c = socketFactory2;
                        if (bVar2 != null) {
                            this.f9129d = bVar2;
                            if (list != null) {
                                this.f9130e = c.a(list);
                                if (list2 != null) {
                                    this.f9131f = c.a(list2);
                                    if (proxySelector2 != null) {
                                        this.f9132g = proxySelector2;
                                        this.f9133h = proxy;
                                        this.f9134i = sSLSocketFactory2;
                                        this.f9135j = hostnameVerifier;
                                        this.k = fVar;
                                        return;
                                    }
                                    throw new NullPointerException("proxySelector == null");
                                }
                                throw new NullPointerException("connectionSpecs == null");
                            }
                            throw new NullPointerException("protocols == null");
                        }
                        throw new NullPointerException("proxyAuthenticator == null");
                    }
                    throw new NullPointerException("socketFactory == null");
                }
                throw new NullPointerException("dns == null");
            }
            throw new IllegalArgumentException(e.a.a.a.a.a("unexpected host: ", str));
        }
        throw new NullPointerException("host == null");
    }

    public boolean a(a aVar) {
        return this.f9127b.equals(aVar.f9127b) && this.f9129d.equals(aVar.f9129d) && this.f9130e.equals(aVar.f9130e) && this.f9131f.equals(aVar.f9131f) && this.f9132g.equals(aVar.f9132g) && c.a((Object) this.f9133h, (Object) aVar.f9133h) && c.a((Object) this.f9134i, (Object) aVar.f9134i) && c.a((Object) this.f9135j, (Object) aVar.f9135j) && c.a((Object) this.k, (Object) aVar.k) && this.f9126a.f9539e == aVar.f9126a.f9539e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f9126a.equals(aVar.f9126a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f9132g.hashCode() + ((this.f9131f.hashCode() + ((this.f9130e.hashCode() + ((this.f9129d.hashCode() + ((this.f9127b.hashCode() + ((this.f9126a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Proxy proxy = this.f9133h;
        int i2 = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f9134i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f9135j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        f fVar = this.k;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Address{");
        a2.append(this.f9126a.f9538d);
        a2.append(Config.TRACE_TODAY_VISIT_SPLIT);
        a2.append(this.f9126a.f9539e);
        if (this.f9133h != null) {
            a2.append(", proxy=");
            a2.append(this.f9133h);
        } else {
            a2.append(", proxySelector=");
            a2.append(this.f9132g);
        }
        a2.append("}");
        return a2.toString();
    }
}
