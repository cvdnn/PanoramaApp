package g.d0.e;

import g.d0.a;
import g.d0.c;
import g.g;
import g.i;
import g.u;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public final List<i> f9194a;

    /* renamed from: b reason: collision with root package name */
    public int f9195b = 0;

    /* renamed from: c reason: collision with root package name */
    public boolean f9196c;

    /* renamed from: d reason: collision with root package name */
    public boolean f9197d;

    public b(List<i> list) {
        this.f9194a = list;
    }

    public i a(SSLSocket sSLSocket) throws IOException {
        i iVar;
        boolean z;
        String[] strArr;
        String[] strArr2;
        int i2 = this.f9195b;
        int size = this.f9194a.size();
        while (true) {
            if (i2 >= size) {
                iVar = null;
                break;
            }
            iVar = (i) this.f9194a.get(i2);
            if (iVar.a(sSLSocket)) {
                this.f9195b = i2 + 1;
                break;
            }
            i2++;
        }
        if (iVar != null) {
            int i3 = this.f9195b;
            while (true) {
                if (i3 >= this.f9194a.size()) {
                    z = false;
                    break;
                } else if (((i) this.f9194a.get(i3)).a(sSLSocket)) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            this.f9196c = z;
            a aVar = a.f9172a;
            boolean z2 = this.f9197d;
            if (((u.a) aVar) != null) {
                if (iVar.f9502c != null) {
                    strArr = c.a(g.f9479b, sSLSocket.getEnabledCipherSuites(), iVar.f9502c);
                } else {
                    strArr = sSLSocket.getEnabledCipherSuites();
                }
                if (iVar.f9503d != null) {
                    strArr2 = c.a(c.p, sSLSocket.getEnabledProtocols(), iVar.f9503d);
                } else {
                    strArr2 = sSLSocket.getEnabledProtocols();
                }
                String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
                int a2 = c.a(g.f9479b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
                if (z2 && a2 != -1) {
                    String str = supportedCipherSuites[a2];
                    int length = strArr.length + 1;
                    String[] strArr3 = new String[length];
                    System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
                    strArr3[length - 1] = str;
                    strArr = strArr3;
                }
                i.a aVar2 = new i.a(iVar);
                aVar2.a(strArr);
                aVar2.b(strArr2);
                i iVar2 = new i(aVar2);
                String[] strArr4 = iVar2.f9503d;
                if (strArr4 != null) {
                    sSLSocket.setEnabledProtocols(strArr4);
                }
                String[] strArr5 = iVar2.f9502c;
                if (strArr5 != null) {
                    sSLSocket.setEnabledCipherSuites(strArr5);
                }
                return iVar;
            }
            throw null;
        }
        StringBuilder a3 = e.a.a.a.a.a("Unable to find acceptable protocols. isFallback=");
        a3.append(this.f9197d);
        a3.append(", modes=");
        a3.append(this.f9194a);
        a3.append(", supported protocols=");
        a3.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(a3.toString());
    }
}
