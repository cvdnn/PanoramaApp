package g;

import g.d0.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake */
public final class p {

    /* renamed from: a reason: collision with root package name */
    public final c0 f9528a;

    /* renamed from: b reason: collision with root package name */
    public final g f9529b;

    /* renamed from: c reason: collision with root package name */
    public final List<Certificate> f9530c;

    /* renamed from: d reason: collision with root package name */
    public final List<Certificate> f9531d;

    public p(c0 c0Var, g gVar, List<Certificate> list, List<Certificate> list2) {
        this.f9528a = c0Var;
        this.f9529b = gVar;
        this.f9530c = list;
        this.f9531d = list2;
    }

    public static p a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            g a2 = g.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                c0 a3 = c0.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = c.a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = c.a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new p(a3, a2, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f9528a.equals(pVar.f9528a) && this.f9529b.equals(pVar.f9529b) && this.f9530c.equals(pVar.f9530c) && this.f9531d.equals(pVar.f9531d)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f9531d.hashCode() + ((this.f9530c.hashCode() + ((this.f9529b.hashCode() + ((this.f9528a.hashCode() + 527) * 31)) * 31)) * 31);
    }
}
