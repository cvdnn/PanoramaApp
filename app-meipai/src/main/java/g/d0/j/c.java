package g.d0.j;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificateChainCleaner */
public abstract class c {
    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
