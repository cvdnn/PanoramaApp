package e.c.f;

/* compiled from: BaiduLog */
public final class c {
    static {
        new ThreadLocal();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2 = new java.io.StringWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.printStackTrace(new java.io.PrintWriter(r2));
        r3 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r0 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[SYNTHETIC, Splitter:B:23:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.Throwable r3) {
        /*
            r0 = r3
        L_0x0001:
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x000f
            boolean r2 = r0 instanceof java.net.UnknownHostException
            if (r2 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Throwable r0 = r0.getCause()     // Catch:{ all -> 0x0039 }
            goto L_0x0001
        L_0x000f:
            r0 = 0
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ all -> 0x002d }
            r2.<init>()     // Catch:{ all -> 0x002d }
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ all -> 0x002a }
            r0.<init>(r2)     // Catch:{ all -> 0x002a }
            r3.printStackTrace(r0)     // Catch:{ all -> 0x002a }
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x002a }
            r2.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0039 }
        L_0x0029:
            return r3
        L_0x002a:
            r3 = move-exception
            r0 = r2
            goto L_0x002e
        L_0x002d:
            r3 = move-exception
        L_0x002e:
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0039 }
        L_0x0038:
            throw r3     // Catch:{ all -> 0x0039 }
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.c.a(java.lang.Throwable):java.lang.String");
    }

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }

    public static void d() {
    }
}
