package g.d0.i;

import e.a.a.a.a;
import g.d0.j.b;
import g.d0.j.c;
import g.d0.j.f;
import g.u;
import g.v;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform */
public class e {

    /* renamed from: a reason: collision with root package name */
    public static final e f9461a;

    /* renamed from: b reason: collision with root package name */
    public static final Logger f9462b = Logger.getLogger(u.class.getName());

    static {
        e a2 = a.a();
        if (a2 == null) {
            a2 = b.a();
            if (a2 == null) {
                a2 = c.a();
                if (a2 == null) {
                    a2 = new e();
                }
            }
        }
        f9461a = a2;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
    }

    public f b(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public void a(int i2, String str, Throwable th) {
        f9462b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f9462b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = a.a(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<v> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = (v) list.get(i2);
            if (vVar != v.HTTP_1_0) {
                arrayList.add(vVar.f9586a);
            }
        }
        return arrayList;
    }

    public c a(X509TrustManager x509TrustManager) {
        return new g.d0.j.a(b(x509TrustManager));
    }
}
