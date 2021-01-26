package g;

import com.baidu.mobstat.Config;
import g.d0.j.c;
import h.h;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner */
public final class f {

    /* renamed from: c reason: collision with root package name */
    public static final f f9473c = new f(new LinkedHashSet(new ArrayList()), null);

    /* renamed from: a reason: collision with root package name */
    public final Set<a> f9474a;

    /* renamed from: b reason: collision with root package name */
    public final c f9475b;

    /* compiled from: CertificatePinner */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public final String f9476a;

        /* renamed from: b reason: collision with root package name */
        public final String f9477b;

        /* renamed from: c reason: collision with root package name */
        public final h f9478c;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            String str = ((a) obj).f9476a;
            throw null;
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            new StringBuilder().append(null);
            throw null;
        }
    }

    public f(Set<a> set, c cVar) {
        this.f9474a = set;
        this.f9475b = cVar;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        String str2;
        List emptyList = Collections.emptyList();
        Iterator it = this.f9474a.iterator();
        if (it.hasNext()) {
            if (((a) it.next()) != null) {
                throw null;
            }
            throw null;
        } else if (!emptyList.isEmpty()) {
            c cVar = this.f9475b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = emptyList.size();
                h hVar = null;
                h hVar2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    a aVar = (a) emptyList.get(i3);
                    if (aVar.f9477b.equals("sha256/")) {
                        if (hVar == null) {
                            hVar = h.a(x509Certificate.getPublicKey().getEncoded()).a("SHA-256");
                        }
                        if (aVar.f9478c.equals(hVar)) {
                            return;
                        }
                    } else if (aVar.f9477b.equals("sha1/")) {
                        if (hVar2 == null) {
                            hVar2 = h.a(x509Certificate.getPublicKey().getEncoded()).a("SHA-1");
                        }
                        if (aVar.f9478c.equals(hVar2)) {
                            return;
                        }
                    } else {
                        StringBuilder a2 = e.a.a.a.a.a("unsupported hashAlgorithm: ");
                        a2.append(aVar.f9477b);
                        throw new AssertionError(a2.toString());
                    }
                }
            }
            StringBuilder b2 = e.a.a.a.a.b("Certificate pinning failure!", "\n  Peer certificate chain:");
            int size3 = list.size();
            int i4 = 0;
            while (true) {
                str2 = "\n    ";
                if (i4 >= size3) {
                    break;
                }
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                b2.append(str2);
                b2.append(a(x509Certificate2));
                b2.append(": ");
                b2.append(x509Certificate2.getSubjectDN().getName());
                i4++;
            }
            b2.append("\n  Pinned certificates for ");
            b2.append(str);
            b2.append(Config.TRACE_TODAY_VISIT_SPLIT);
            int size4 = emptyList.size();
            for (int i5 = 0; i5 < size4; i5++) {
                a aVar2 = (a) emptyList.get(i5);
                b2.append(str2);
                b2.append(aVar2);
            }
            throw new SSLPeerUnverifiedException(b2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r3.f9474a.equals(r4.f9474a) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            if (r4 != r3) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof g.f
            if (r1 == 0) goto L_0x001f
            g.d0.j.c r1 = r3.f9475b
            g.f r4 = (g.f) r4
            g.d0.j.c r2 = r4.f9475b
            boolean r1 = g.d0.c.a(r1, r2)
            if (r1 == 0) goto L_0x001f
            java.util.Set<g.f$a> r1 = r3.f9474a
            java.util.Set<g.f$a> r4 = r4.f9474a
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        c cVar = this.f9475b;
        return this.f9474a.hashCode() + ((cVar != null ? cVar.hashCode() : 0) * 31);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder a2 = e.a.a.a.a.a("sha256/");
            a2.append(h.a(((X509Certificate) certificate).getPublicKey().getEncoded()).a("SHA-256").a());
            return a2.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
}
