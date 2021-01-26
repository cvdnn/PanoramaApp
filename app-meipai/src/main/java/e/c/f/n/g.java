package e.c.f.n;

import android.annotation.SuppressLint;
import android.content.Context;
import e.c.f.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

@SuppressLint({"NewApi"})
/* compiled from: HttpUtil */
public final class g {

    /* renamed from: g reason: collision with root package name */
    public static SSLSocketFactory f7062g;

    /* renamed from: a reason: collision with root package name */
    public Context f7063a;

    /* renamed from: b reason: collision with root package name */
    public String f7064b;

    /* renamed from: c reason: collision with root package name */
    public String f7065c;

    /* renamed from: d reason: collision with root package name */
    public int f7066d = 120000;

    /* renamed from: e reason: collision with root package name */
    public int f7067e = 120000;

    /* renamed from: f reason: collision with root package name */
    public boolean f7068f = false;

    /* compiled from: HttpUtil */
    public class a implements X509TrustManager {

        /* renamed from: a reason: collision with root package name */
        public X509TrustManager f7069a = null;

        public a(X509TrustManager x509TrustManager) {
            this.f7069a = x509TrustManager;
        }

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            c.a();
            this.f7069a.checkClientTrusted(x509CertificateArr, str);
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            c.a();
            try {
                this.f7069a.checkServerTrusted(x509CertificateArr, str);
            } catch (Throwable th) {
                c.d();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        a.a(g.this.f7063a.getApplicationContext(), "1003121", (Map<String, Object>) hashMap);
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    throw th;
                }
                throw new CertificateException();
            }
        }

        public final X509Certificate[] getAcceptedIssuers() {
            c.a();
            return this.f7069a.getAcceptedIssuers();
        }
    }

    public g(Context context) {
        this.f7063a = context;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC, Splitter:B:23:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0034 A[Catch:{ all -> 0x0038 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r2, byte[] r3) throws java.io.IOException, java.lang.InterruptedException, android.accounts.NetworkErrorException {
        /*
            r1 = this;
            r0 = 155648(0x26000, float:2.1811E-40)
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x0007 }
            goto L_0x000a
        L_0x0007:
            e.c.f.c.d()
        L_0x000a:
            java.lang.String r0 = "POST"
            r1.f7064b = r0     // Catch:{ all -> 0x0038 }
            r1.f7065c = r2     // Catch:{ all -> 0x0038 }
            r2 = 0
            java.net.HttpURLConnection r0 = r1.a()     // Catch:{ all -> 0x002b }
            java.io.InputStream r2 = r1.a(r3, r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = r1.a(r2)     // Catch:{ all -> 0x0029 }
            r2.close()     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0025
            r0.disconnect()     // Catch:{ all -> 0x0038 }
        L_0x0025:
            e.c.f.n.n.a()
            return r3
        L_0x0029:
            r3 = move-exception
            goto L_0x002d
        L_0x002b:
            r3 = move-exception
            r0 = r2
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.close()     // Catch:{ all -> 0x0038 }
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.disconnect()     // Catch:{ all -> 0x0038 }
        L_0x0037:
            throw r3     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r2 = move-exception
            e.c.f.n.n.a()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.g.a(java.lang.String, byte[]):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:21|22|(5:25|26|27|(1:29)(1:30)|31)|32|33|(2:35|36)|(1:38)|39|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005b */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0066 A[Catch:{ all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0070 A[SYNTHETIC, Splitter:B:46:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0075 A[Catch:{ all -> 0x0078 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r5, java.io.File r6) {
        /*
            r4 = this;
            r0 = 155648(0x26000, float:2.1811E-40)
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x0007 }
            goto L_0x000a
        L_0x0007:
            e.c.f.c.d()
        L_0x000a:
            e.c.f.c.a()     // Catch:{ all -> 0x007c }
            android.content.Context r0 = r4.f7063a     // Catch:{ all -> 0x007c }
            boolean r0 = e.c.f.n.a.d(r0)     // Catch:{ all -> 0x007c }
            r1 = 0
            if (r0 != 0) goto L_0x001a
            e.c.f.n.n.a()
            return r1
        L_0x001a:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0024
            e.c.f.n.n.a()
            return r1
        L_0x0024:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "f= "
            r0.<init>(r2)     // Catch:{ all -> 0x007c }
            r0.append(r6)     // Catch:{ all -> 0x007c }
            r0 = 0
            java.lang.String r2 = "GET"
            r4.f7064b = r2     // Catch:{ all -> 0x006d }
            r4.f7065c = r5     // Catch:{ all -> 0x006d }
            java.net.HttpURLConnection r5 = r4.a()     // Catch:{ all -> 0x006d }
            android.content.Context r2 = r4.f7063a     // Catch:{ all -> 0x006e }
            boolean r2 = e.c.f.n.a.d(r2)     // Catch:{ all -> 0x006e }
            if (r2 != 0) goto L_0x0042
            goto L_0x005b
        L_0x0042:
            if (r5 != 0) goto L_0x0045
            goto L_0x005b
        L_0x0045:
            java.lang.String r2 = "gzip"
            java.lang.String r3 = r5.getContentEncoding()     // Catch:{ IOException -> 0x005b }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x005b }
            if (r2 == 0) goto L_0x0055
            r2 = 1
            r4.f7068f = r2     // Catch:{ IOException -> 0x005b }
            goto L_0x0057
        L_0x0055:
            r4.f7068f = r1     // Catch:{ IOException -> 0x005b }
        L_0x0057:
            java.io.InputStream r0 = r5.getInputStream()     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            boolean r6 = r4.a(r0, r6)     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0064
            r0.close()     // Catch:{ all -> 0x0069 }
        L_0x0064:
            if (r5 == 0) goto L_0x0069
            r5.disconnect()     // Catch:{ all -> 0x0069 }
        L_0x0069:
            e.c.f.n.n.a()
            return r6
        L_0x006d:
            r5 = r0
        L_0x006e:
            if (r0 == 0) goto L_0x0073
            r0.close()     // Catch:{ all -> 0x0078 }
        L_0x0073:
            if (r5 == 0) goto L_0x0078
            r5.disconnect()     // Catch:{ all -> 0x0078 }
        L_0x0078:
            e.c.f.n.n.a()
            return r1
        L_0x007c:
            r5 = move-exception
            e.c.f.n.n.a()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.g.a(java.lang.String, java.io.File):boolean");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.security.KeyStore, javax.net.ssl.KeyManager[]] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0, types: [java.security.KeyStore, javax.net.ssl.KeyManager[]]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.security.KeyStore, javax.net.ssl.KeyManager[], ?[OBJECT, ARRAY]]
  mth insns count: 157
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection a() throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = r10.f7064b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ad
            java.lang.String r0 = r10.f7065c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ad
            java.lang.String r0 = r10.f7064b
            java.lang.String r1 = "POST"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r10.f7064b
            java.lang.String r2 = "GET"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0026
            r10.f7064b = r1
        L_0x0026:
            java.net.URL r0 = new java.net.URL
            java.lang.String r2 = r10.f7065c
            r0.<init>(r2)
            android.content.Context r2 = r10.f7063a
            boolean r2 = e.c.f.n.a.c(r2)
            r3 = -1
            r4 = 0
            r5 = 0
            if (r2 != 0) goto L_0x0058
            java.util.Properties r2 = java.lang.System.getProperties()
            java.lang.String r6 = "http.proxyHost"
            java.lang.String r2 = r2.getProperty(r6)
            java.util.Properties r6 = java.lang.System.getProperties()
            java.lang.String r7 = "http.proxyPort"
            java.lang.String r6 = r6.getProperty(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0053
            goto L_0x005a
        L_0x0053:
            int r3 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x005a }
            goto L_0x005a
        L_0x0058:
            r2 = r4
            r3 = r5
        L_0x005a:
            if (r2 == 0) goto L_0x0070
            if (r3 <= 0) goto L_0x0070
            java.net.InetSocketAddress r2 = java.net.InetSocketAddress.createUnresolved(r2, r3)
            java.net.Proxy r3 = new java.net.Proxy
            java.net.Proxy$Type r6 = java.net.Proxy.Type.HTTP
            r3.<init>(r6, r2)
            java.net.URLConnection r2 = r0.openConnection(r3)
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            goto L_0x0076
        L_0x0070:
            java.net.URLConnection r2 = r0.openConnection()
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
        L_0x0076:
            java.lang.String r0 = r0.getProtocol()
            java.lang.String r3 = "https"
            boolean r0 = r3.equals(r0)
            r3 = 1
            if (r0 == 0) goto L_0x00f4
            r0 = r2
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            javax.net.ssl.SSLSocketFactory r6 = f7062g     // Catch:{ all -> 0x00f1 }
            if (r6 == 0) goto L_0x0095
            org.apache.http.conn.ssl.X509HostnameVerifier r6 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ all -> 0x00f1 }
            r0.setHostnameVerifier(r6)     // Catch:{ all -> 0x00f1 }
            javax.net.ssl.SSLSocketFactory r6 = f7062g     // Catch:{ all -> 0x00f1 }
            r0.setSSLSocketFactory(r6)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x0095:
            java.lang.String r6 = "TLS"
            javax.net.ssl.SSLContext r6 = javax.net.ssl.SSLContext.getInstance(r6)     // Catch:{ all -> 0x00f1 }
            java.lang.String r7 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ all -> 0x00f1 }
            javax.net.ssl.TrustManagerFactory r7 = javax.net.ssl.TrustManagerFactory.getInstance(r7)     // Catch:{ all -> 0x00f1 }
            r7.init(r4)     // Catch:{ all -> 0x00f1 }
            javax.net.ssl.TrustManager[] r7 = r7.getTrustManagers()     // Catch:{ all -> 0x00f1 }
            int r8 = r7.length     // Catch:{ all -> 0x00f1 }
            if (r8 <= 0) goto L_0x00d9
            r8 = r7[r5]     // Catch:{ all -> 0x00f1 }
            boolean r8 = r8 instanceof javax.net.ssl.X509TrustManager     // Catch:{ all -> 0x00f1 }
            if (r8 == 0) goto L_0x00d9
            javax.net.ssl.TrustManager[] r8 = new javax.net.ssl.TrustManager[r3]     // Catch:{ all -> 0x00f1 }
            e.c.f.n.g$a r9 = new e.c.f.n.g$a     // Catch:{ all -> 0x00f1 }
            r7 = r7[r5]     // Catch:{ all -> 0x00f1 }
            javax.net.ssl.X509TrustManager r7 = (javax.net.ssl.X509TrustManager) r7     // Catch:{ all -> 0x00f1 }
            r9.<init>(r7)     // Catch:{ all -> 0x00f1 }
            r8[r5] = r9     // Catch:{ all -> 0x00f1 }
            java.security.SecureRandom r7 = new java.security.SecureRandom     // Catch:{ all -> 0x00f1 }
            r7.<init>()     // Catch:{ all -> 0x00f1 }
            r6.init(r4, r8, r7)     // Catch:{ all -> 0x00f1 }
            javax.net.ssl.SSLSocketFactory r6 = r6.getSocketFactory()     // Catch:{ all -> 0x00f1 }
            f7062g = r6     // Catch:{ all -> 0x00f1 }
            org.apache.http.conn.ssl.X509HostnameVerifier r6 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ all -> 0x00f1 }
            r0.setHostnameVerifier(r6)     // Catch:{ all -> 0x00f1 }
            javax.net.ssl.SSLSocketFactory r6 = f7062g     // Catch:{ all -> 0x00f1 }
            r0.setSSLSocketFactory(r6)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00d9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            java.lang.String r8 = "Unexpected default trust managers:"
            r6.<init>(r8)     // Catch:{ all -> 0x00f1 }
            java.lang.String r7 = java.util.Arrays.toString(r7)     // Catch:{ all -> 0x00f1 }
            r6.append(r7)     // Catch:{ all -> 0x00f1 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00f1 }
            r0.<init>(r6)     // Catch:{ all -> 0x00f1 }
            throw r0     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            e.c.f.c.d()
        L_0x00f4:
            java.lang.String r0 = r10.f7064b
            r2.setRequestMethod(r0)
            r2.setDoInput(r3)
            java.lang.String r0 = r10.f7064b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0107
            r2.setDoOutput(r3)
        L_0x0107:
            r2.setInstanceFollowRedirects(r3)
            int r0 = r10.f7066d
            r2.setConnectTimeout(r0)
            int r0 = r10.f7067e
            r2.setReadTimeout(r0)
            android.content.Context r0 = r10.f7063a
            java.lang.String[] r0 = e.c.f.n.a.e(r0)
            r0 = r0[r5]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "eos"
            r1.append(r3)
            java.lang.String r3 = "/"
            r1.append(r3)
            r1.append(r0)
            r1.append(r3)
            android.content.Context r0 = r10.f7063a
            android.content.pm.PackageManager r3 = r0.getPackageManager()     // Catch:{ all -> 0x0144 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0144 }
            r5 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r0 = r3.getPackageInfo(r0, r5)     // Catch:{ all -> 0x0144 }
            java.lang.String r4 = r0.versionName     // Catch:{ all -> 0x0144 }
            goto L_0x0147
        L_0x0144:
            e.c.f.c.d()
        L_0x0147:
            r1.append(r4)
            java.lang.String r0 = "/3.3.9.8.2"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "User-Agent"
            r2.setRequestProperty(r1, r0)
            java.lang.String r0 = "Pragma"
            java.lang.String r1 = "no-cache"
            r2.setRequestProperty(r0, r1)
            java.lang.String r0 = "Accept"
            java.lang.String r1 = "*/*"
            r2.setRequestProperty(r0, r1)
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = "application/x-www-form-urlencoded"
            r2.setRequestProperty(r0, r1)
            java.lang.String r0 = "Accept-Encoding"
            java.lang.String r1 = "gzip,deflate"
            r2.setRequestProperty(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getCountry()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Accept-Language"
            r2.setRequestProperty(r1, r0)
            android.content.Context r0 = r10.f7063a
            java.lang.String r0 = e.c.f.n.c.b(r0)
            java.lang.String r0 = e.c.f.n.h.a(r0)
            java.lang.String r1 = "x-device-id"
            r2.setRequestProperty(r1, r0)
            return r2
        L_0x01ad:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.g.a():java.net.HttpURLConnection");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0074 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream a(byte[] r8, java.net.HttpURLConnection r9) throws java.io.IOException, android.accounts.NetworkErrorException {
        /*
            r7 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            java.lang.String r2 = "gzip"
            r3 = 0
            r4 = 200(0xc8, float:2.8E-43)
            if (r8 != 0) goto L_0x0036
            int r8 = r9.getResponseCode()     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            if (r8 != r4) goto L_0x002c
            java.lang.String r8 = r9.getContentEncoding()     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            if (r4 != 0) goto L_0x0025
            boolean r8 = r2.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            if (r8 == 0) goto L_0x0025
            r7.f7068f = r1     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            goto L_0x0027
        L_0x0025:
            r7.f7068f = r3     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
        L_0x0027:
            java.io.InputStream r8 = r9.getInputStream()     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            return r8
        L_0x002c:
            android.accounts.NetworkErrorException r9 = new android.accounts.NetworkErrorException     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            r9.<init>(r8)     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            throw r9     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
        L_0x0036:
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            java.io.OutputStream r6 = r9.getOutputStream()     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0081, NetworkErrorException -> 0x007f, all -> 0x0074 }
            r5.write(r8)     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            r5.flush()     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            int r8 = r9.getResponseCode()     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            if (r8 != r4) goto L_0x0062
            java.lang.String r8 = r9.getContentEncoding()     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            boolean r8 = r2.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            if (r8 == 0) goto L_0x0058
            r7.f7068f = r1     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            goto L_0x005a
        L_0x0058:
            r7.f7068f = r3     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
        L_0x005a:
            java.io.InputStream r8 = r9.getInputStream()     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            r5.close()     // Catch:{ all -> 0x0061 }
        L_0x0061:
            return r8
        L_0x0062:
            android.accounts.NetworkErrorException r9 = new android.accounts.NetworkErrorException     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            r9.<init>(r8)     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
            throw r9     // Catch:{ IOException -> 0x0071, NetworkErrorException -> 0x006e, all -> 0x006c }
        L_0x006c:
            r0 = r5
            goto L_0x0074
        L_0x006e:
            r8 = move-exception
            r0 = r5
            goto L_0x0080
        L_0x0071:
            r8 = move-exception
            r0 = r5
            goto L_0x0082
        L_0x0074:
            e.c.f.c.d()     // Catch:{ all -> 0x007d }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x007d }
            r8.<init>()     // Catch:{ all -> 0x007d }
            throw r8     // Catch:{ all -> 0x007d }
        L_0x007d:
            r8 = move-exception
            goto L_0x0083
        L_0x007f:
            r8 = move-exception
        L_0x0080:
            throw r8     // Catch:{ all -> 0x007d }
        L_0x0081:
            r8 = move-exception
        L_0x0082:
            throw r8     // Catch:{ all -> 0x007d }
        L_0x0083:
            if (r0 == 0) goto L_0x0088
            r0.close()     // Catch:{ all -> 0x0088 }
        L_0x0088:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.g.a(byte[], java.net.HttpURLConnection):java.io.InputStream");
    }

    public final String a(InputStream inputStream) throws IOException, InterruptedException {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (byteArray != null) {
                    if (this.f7068f) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        byte[] bArr2 = new byte[2048];
                        while (true) {
                            int read2 = gZIPInputStream.read(bArr2, 0, 2048);
                            if (read2 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read2);
                        }
                        gZIPInputStream.close();
                        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                        byteArray = byteArray2;
                    }
                    if (byteArray != null) {
                        return new String(byteArray);
                    }
                    throw new IOException();
                }
                throw new IOException("responseBytes");
            } catch (Throwable unused) {
                c.d();
                throw new IOException();
            }
        } else {
            throw new IOException("InputStream");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|27|(2:29|30)|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0041, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0044, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0045, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0046, code lost:
        if (r1 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004c, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004f, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r5, java.io.File r6) {
        /*
            r4 = this;
            boolean r0 = r4.f7068f
            if (r0 == 0) goto L_0x000e
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x000b }
            r0.<init>(r5)     // Catch:{ IOException -> 0x000b }
            r5 = r0
            goto L_0x000e
        L_0x000b:
            e.c.f.c.d()
        L_0x000e:
            r0 = 0
            if (r5 != 0) goto L_0x0012
            return r0
        L_0x0012:
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0037 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0037 }
            r2.<init>(r6)     // Catch:{ all -> 0x0037 }
            r1.<init>(r2)     // Catch:{ all -> 0x0037 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0038 }
        L_0x0020:
            int r2 = r5.read(r6)     // Catch:{ all -> 0x0038 }
            r3 = -1
            if (r2 == r3) goto L_0x002e
            r1.write(r6, r0, r2)     // Catch:{ all -> 0x0038 }
            r1.flush()     // Catch:{ all -> 0x0038 }
            goto L_0x0020
        L_0x002e:
            r1.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0035
        L_0x0032:
            e.c.f.c.d()
        L_0x0035:
            r5 = 1
            return r5
        L_0x0037:
            r1 = 0
        L_0x0038:
            e.c.f.c.d()     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0044
        L_0x0041:
            e.c.f.c.d()
        L_0x0044:
            return r0
        L_0x0045:
            r5 = move-exception
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x004f
        L_0x004c:
            e.c.f.c.d()
        L_0x004f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.g.a(java.io.InputStream, java.io.File):boolean");
    }
}
