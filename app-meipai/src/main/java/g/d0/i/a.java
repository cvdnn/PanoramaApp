package g.d0.i;

import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import g.d0.j.f;
import g.v;
import h.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: AndroidPlatform */
public class a extends e {

    /* renamed from: c reason: collision with root package name */
    public final d<Socket> f9436c;

    /* renamed from: d reason: collision with root package name */
    public final d<Socket> f9437d;

    /* renamed from: e reason: collision with root package name */
    public final d<Socket> f9438e;

    /* renamed from: f reason: collision with root package name */
    public final d<Socket> f9439f;

    /* renamed from: g reason: collision with root package name */
    public final c f9440g;

    /* renamed from: g.d0.i.a$a reason: collision with other inner class name */
    /* compiled from: AndroidPlatform */
    public static final class C0140a extends g.d0.j.c {

        /* renamed from: a reason: collision with root package name */
        public final Object f9441a;

        /* renamed from: b reason: collision with root package name */
        public final Method f9442b;

        public C0140a(Object obj, Method method) {
            this.f9441a = obj;
            this.f9442b = method;
        }

        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f9442b.invoke(this.f9441a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0140a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform */
    public static final class b implements f {

        /* renamed from: a reason: collision with root package name */
        public final X509TrustManager f9443a;

        /* renamed from: b reason: collision with root package name */
        public final Method f9444b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f9444b = method;
            this.f9443a = x509TrustManager;
        }

        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f9444b.invoke(this.f9443a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw g.d0.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f9443a.equals(bVar.f9443a) || !this.f9444b.equals(bVar.f9444b)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.f9444b.hashCode() * 31) + this.f9443a.hashCode();
        }
    }

    /* compiled from: AndroidPlatform */
    public static final class c {

        /* renamed from: a reason: collision with root package name */
        public final Method f9445a;

        /* renamed from: b reason: collision with root package name */
        public final Method f9446b;

        /* renamed from: c reason: collision with root package name */
        public final Method f9447c;

        public c(Method method, Method method2, Method method3) {
            this.f9445a = method;
            this.f9446b = method2;
            this.f9447c = method3;
        }
    }

    public a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls2.getMethod("get", new Class[0]);
            method = cls2.getMethod(LivenessStat.TYPE_VOICE_OPEN, new Class[]{String.class});
            method2 = cls2.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method2 = null;
            method = null;
        }
        this.f9440g = new c(method3, method, method2);
        this.f9436c = dVar;
        this.f9437d = dVar2;
        this.f9438e = dVar3;
        this.f9439f = dVar4;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (g.d0.c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        }
    }

    public String b(SSLSocket sSLSocket) {
        d<Socket> dVar = this.f9438e;
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (!(dVar.a(sSLSocket.getClass()) != null)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f9438e.c(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, g.d0.c.f9183j);
        }
        return str;
    }

    public boolean b(String str) {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            throw g.d0.c.a("unable to determine cleartext support", e2);
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
        if (str != null) {
            this.f9436c.b(sSLSocket, Boolean.valueOf(true));
            this.f9437d.b(sSLSocket, str);
        }
        d<Socket> dVar = this.f9439f;
        if (dVar != null) {
            if (dVar.a(sSLSocket.getClass()) != null) {
                Object[] objArr = new Object[1];
                e eVar = new e();
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    v vVar = (v) list.get(i2);
                    if (vVar != v.HTTP_1_0) {
                        eVar.writeByte(vVar.f9586a.length());
                        eVar.c(vVar.f9586a);
                    }
                }
                objArr[0] = eVar.f();
                this.f9439f.c(sSLSocket, objArr);
            }
        }
    }

    public f b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return new g.d0.j.b(x509TrustManager.getAcceptedIssuers());
        }
    }

    public void a(int i2, String str, Throwable th) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
            str = sb.toString();
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    public Object a(String str) {
        c cVar = this.f9440g;
        Method method = cVar.f9445a;
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, new Object[0]);
            cVar.f9446b.invoke(invoke, new Object[]{str});
            return invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(String str, Object obj) {
        c cVar = this.f9440g;
        if (cVar != null) {
            boolean z = false;
            if (obj != null) {
                try {
                    cVar.f9447c.invoke(obj, new Object[0]);
                    z = true;
                } catch (Exception unused) {
                }
            }
            if (!z) {
                a(5, str, (Throwable) null);
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r2 = ((java.lang.Boolean) r7.getMethod(r0, new java.lang.Class[0]).invoke(r8, new java.lang.Object[0])).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r6, java.lang.Class<?> r7, java.lang.Object r8) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        /*
            r5 = this;
            java.lang.String r0 = "isCleartextTrafficPermitted"
            r1 = 0
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r3[r1] = r4     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.reflect.Method r3 = r7.getMethod(r0, r3)     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x001d }
            r4[r1] = r6     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Object r6 = r3.invoke(r8, r4)     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ NoSuchMethodException -> 0x001d }
            boolean r6 = r6.booleanValue()     // Catch:{ NoSuchMethodException -> 0x001d }
            return r6
        L_0x001d:
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.reflect.Method r6 = r7.getMethod(r0, r6)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Object r6 = r6.invoke(r8, r7)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ NoSuchMethodException -> 0x002f }
            boolean r2 = r6.booleanValue()     // Catch:{ NoSuchMethodException -> 0x002f }
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.i.a.a(java.lang.String, java.lang.Class, java.lang.Object):boolean");
    }

    public g.d0.j.c a(X509TrustManager x509TrustManager) {
        Class<String> cls = String.class;
        try {
            Class cls2 = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0140a(cls2.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls2.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls, cls}));
        } catch (Exception unused) {
            return new g.d0.j.a(b(x509TrustManager));
        }
    }

    public static e a() {
        Class cls;
        boolean z;
        d dVar;
        d dVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class cls3 = cls;
        d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d(null, "setHostname", String.class);
        if (Security.getProvider("GMSCore_OpenSSL") == null) {
            try {
                Class.forName("android.net.Network");
            } catch (ClassNotFoundException unused3) {
                z = false;
            }
        }
        z = true;
        if (z) {
            d dVar5 = new d(cls2, "getAlpnSelectedProtocol", new Class[0]);
            dVar = new d(null, "setAlpnProtocols", cls2);
            dVar2 = dVar5;
        } else {
            dVar2 = null;
            dVar = null;
        }
        a aVar = new a(cls3, dVar3, dVar4, dVar2, dVar);
        return aVar;
    }
}
