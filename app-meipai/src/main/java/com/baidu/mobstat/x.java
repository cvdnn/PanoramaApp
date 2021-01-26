package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.bt.b;
import dalvik.system.DexClassLoader;
import java.io.File;

public class x {

    /* renamed from: a reason: collision with root package name */
    public static volatile DexClassLoader f1908a = null;

    /* renamed from: b reason: collision with root package name */
    public static volatile boolean f1909b = false;

    public static class a extends Thread {

        /* renamed from: a reason: collision with root package name */
        public Context f1910a;

        /* renamed from: b reason: collision with root package name */
        public a f1911b;

        public a(Context context, a aVar) {
            this.f1910a = context;
            this.f1911b = aVar;
        }

        private void a(Context context) {
            this.f1911b.a(context, System.currentTimeMillis());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
            if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String b(android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = "UTF-8"
                java.lang.String r1 = ".remote.jar"
                java.io.File r2 = r8.getFileStreamPath(r1)
                java.lang.String r3 = "33"
                if (r2 == 0) goto L_0x003f
                boolean r2 = r2.exists()
                if (r2 == 0) goto L_0x003f
                java.io.File r1 = r8.getFileStreamPath(r1)
                if (r1 == 0) goto L_0x003f
                java.lang.String r1 = r1.getAbsolutePath()
                java.lang.String r1 = com.baidu.mobstat.x.b(r1)
                com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "startDownload remote jar file version = "
                r4.append(r5)
                r4.append(r1)
                java.lang.String r4 = r4.toString()
                r2.a(r4)
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 != 0) goto L_0x003f
                goto L_0x0040
            L_0x003f:
                r1 = r3
            L_0x0040:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                android.util.Pair r4 = new android.util.Pair
                java.lang.String r5 = ""
                java.lang.String r1 = e.a.a.a.a.a(r5, r1)
                java.lang.String r6 = "dynamicVersion"
                r4.<init>(r6, r1)
                r2.add(r4)
                android.util.Pair r1 = new android.util.Pair
                java.lang.String r4 = com.baidu.mobstat.bw.t(r8)
                java.lang.String r6 = "packageName"
                r1.<init>(r6, r4)
                r2.add(r1)
                android.util.Pair r1 = new android.util.Pair
                java.lang.String r4 = com.baidu.mobstat.bw.g(r8)
                java.lang.String r6 = "appVersion"
                r1.<init>(r6, r4)
                r2.add(r1)
                android.util.Pair r1 = new android.util.Pair
                java.lang.String r8 = com.baidu.mobstat.bw.a(r8)
                java.lang.String r4 = "cuid"
                r1.<init>(r4, r8)
                r2.add(r1)
                android.util.Pair r8 = new android.util.Pair
                java.lang.String r1 = "platform"
                java.lang.String r4 = "Android"
                r8.<init>(r1, r4)
                r2.add(r8)
                android.util.Pair r8 = new android.util.Pair
                java.lang.String r1 = android.os.Build.MODEL
                java.lang.String r4 = "m"
                r8.<init>(r4, r1)
                r2.add(r8)
                android.util.Pair r8 = new android.util.Pair
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r4 = android.os.Build.VERSION.SDK_INT
                java.lang.String r1 = e.a.a.a.a.a(r1, r4, r5)
                java.lang.String r4 = "s"
                r8.<init>(r4, r1)
                r2.add(r8)
                android.util.Pair r8 = new android.util.Pair
                java.lang.String r1 = android.os.Build.VERSION.RELEASE
                java.lang.String r4 = "o"
                r8.<init>(r4, r1)
                r2.add(r8)
                android.util.Pair r8 = new android.util.Pair
                java.lang.String r1 = "i"
                r8.<init>(r1, r3)
                r2.add(r8)
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.util.Iterator r1 = r2.iterator()
            L_0x00cb:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x012c
                java.lang.Object r2 = r1.next()
                android.util.Pair r2 = (android.util.Pair) r2
                java.lang.Object r3 = r2.first     // Catch:{ Exception -> 0x00cb }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00cb }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00cb }
                java.lang.String r3 = java.net.URLEncoder.encode(r3, r0)     // Catch:{ Exception -> 0x00cb }
                java.lang.Object r2 = r2.second     // Catch:{ Exception -> 0x00cb }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00cb }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00cb }
                java.lang.String r2 = java.net.URLEncoder.encode(r2, r0)     // Catch:{ Exception -> 0x00cb }
                java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x00cb }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00cb }
                java.lang.String r5 = "="
                if (r4 == 0) goto L_0x0111
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb }
                r4.<init>()     // Catch:{ Exception -> 0x00cb }
                r4.append(r3)     // Catch:{ Exception -> 0x00cb }
                r4.append(r5)     // Catch:{ Exception -> 0x00cb }
                r4.append(r2)     // Catch:{ Exception -> 0x00cb }
                java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00cb }
                r8.append(r2)     // Catch:{ Exception -> 0x00cb }
                goto L_0x00cb
            L_0x0111:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb }
                r4.<init>()     // Catch:{ Exception -> 0x00cb }
                java.lang.String r6 = "&"
                r4.append(r6)     // Catch:{ Exception -> 0x00cb }
                r4.append(r3)     // Catch:{ Exception -> 0x00cb }
                r4.append(r5)     // Catch:{ Exception -> 0x00cb }
                r4.append(r2)     // Catch:{ Exception -> 0x00cb }
                java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00cb }
                r8.append(r2)     // Catch:{ Exception -> 0x00cb }
                goto L_0x00cb
            L_0x012c:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = com.baidu.mobstat.aa.f1492c
                r0.append(r1)
                java.lang.String r1 = "?"
                r0.append(r1)
                java.lang.String r8 = r8.toString()
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.x.a.b(android.content.Context):java.lang.String");
        }

        public void run() {
            try {
                int i2 = aa.f1490a ? 3 : 10;
                bb c2 = bb.c();
                StringBuilder sb = new StringBuilder();
                sb.append("start version check in ");
                sb.append(i2);
                sb.append("s");
                c2.a(sb.toString());
                Thread.sleep((long) (i2 * 1000));
                a();
                a(this.f1910a);
            } catch (Exception e2) {
                bb.c().a((Throwable) e2);
            }
            x.f1909b = false;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ea A[Catch:{ all -> 0x0104 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00f3 A[Catch:{ all -> 0x0104 }] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x00c6=Splitter:B:15:0x00c6, B:25:0x00da=Splitter:B:25:0x00da} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized void a() throws java.lang.Exception {
            /*
                r10 = this;
                monitor-enter(r10)
                com.baidu.mobstat.bb r0 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0109 }
                java.lang.String r1 = "start get config and download jar"
                r0.a(r1)     // Catch:{ all -> 0x0109 }
                android.content.Context r0 = r10.f1910a     // Catch:{ all -> 0x0109 }
                com.baidu.mobstat.a r1 = r10.f1911b     // Catch:{ all -> 0x0109 }
                java.lang.String r2 = r10.b(r0)     // Catch:{ all -> 0x0109 }
                com.baidu.mobstat.bb r3 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0109 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
                r4.<init>()     // Catch:{ all -> 0x0109 }
                java.lang.String r5 = "update req url is:"
                r4.append(r5)     // Catch:{ all -> 0x0109 }
                r4.append(r2)     // Catch:{ all -> 0x0109 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0109 }
                r3.c(r4)     // Catch:{ all -> 0x0109 }
                java.net.HttpURLConnection r2 = com.baidu.mobstat.bo.d(r0, r2)     // Catch:{ all -> 0x0109 }
                r2.connect()     // Catch:{ all -> 0x0104 }
                java.lang.String r3 = "X-CONFIG"
                java.lang.String r3 = r2.getHeaderField(r3)     // Catch:{ all -> 0x0104 }
                com.baidu.mobstat.bb r4 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0104 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
                r5.<init>()     // Catch:{ all -> 0x0104 }
                java.lang.String r6 = "config is: "
                r5.append(r6)     // Catch:{ all -> 0x0104 }
                r5.append(r3)     // Catch:{ all -> 0x0104 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0104 }
                r4.a(r5)     // Catch:{ all -> 0x0104 }
                java.lang.String r4 = "X-SIGN"
                java.lang.String r4 = r2.getHeaderField(r4)     // Catch:{ all -> 0x0104 }
                com.baidu.mobstat.bb r5 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0104 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
                r6.<init>()     // Catch:{ all -> 0x0104 }
                java.lang.String r7 = "sign is: "
                r6.append(r7)     // Catch:{ all -> 0x0104 }
                r6.append(r4)     // Catch:{ all -> 0x0104 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0104 }
                r5.a(r6)     // Catch:{ all -> 0x0104 }
                int r5 = r2.getResponseCode()     // Catch:{ all -> 0x0104 }
                com.baidu.mobstat.bb r6 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0104 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
                r7.<init>()     // Catch:{ all -> 0x0104 }
                java.lang.String r8 = "update response code is: "
                r7.append(r8)     // Catch:{ all -> 0x0104 }
                r7.append(r5)     // Catch:{ all -> 0x0104 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0104 }
                r6.a(r7)     // Catch:{ all -> 0x0104 }
                int r6 = r2.getContentLength()     // Catch:{ all -> 0x0104 }
                com.baidu.mobstat.bb r7 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0104 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
                r8.<init>()     // Catch:{ all -> 0x0104 }
                java.lang.String r9 = "update response content length is: "
                r8.append(r9)     // Catch:{ all -> 0x0104 }
                r8.append(r6)     // Catch:{ all -> 0x0104 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0104 }
                r7.a(r8)     // Catch:{ all -> 0x0104 }
                r7 = 200(0xc8, float:2.8E-43)
                r8 = 0
                if (r5 != r7) goto L_0x00de
                if (r6 <= 0) goto L_0x00de
                java.lang.String r5 = ".remote.jar"
                r6 = 0
                java.io.FileOutputStream r5 = r0.openFileOutput(r5, r6)     // Catch:{ IOException -> 0x00ce, all -> 0x00cc }
                java.io.InputStream r6 = r2.getInputStream()     // Catch:{ IOException -> 0x00ca }
                boolean r6 = com.baidu.mobstat.bu.a(r6, r5)     // Catch:{ IOException -> 0x00ca }
                if (r6 == 0) goto L_0x00c6
                com.baidu.mobstat.bb r6 = com.baidu.mobstat.bb.c()     // Catch:{ IOException -> 0x00ca }
                java.lang.String r7 = "save remote jar success"
                r6.a(r7)     // Catch:{ IOException -> 0x00ca }
            L_0x00c6:
                com.baidu.mobstat.bu.a(r5)     // Catch:{ all -> 0x0104 }
                goto L_0x00de
            L_0x00ca:
                r6 = move-exception
                goto L_0x00d0
            L_0x00cc:
                r0 = move-exception
                goto L_0x00da
            L_0x00ce:
                r6 = move-exception
                r5 = r8
            L_0x00d0:
                com.baidu.mobstat.bb r7 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x00d8 }
                r7.b(r6)     // Catch:{ all -> 0x00d8 }
                goto L_0x00c6
            L_0x00d8:
                r0 = move-exception
                r8 = r5
            L_0x00da:
                com.baidu.mobstat.bu.a(r8)     // Catch:{ all -> 0x0104 }
                throw r0     // Catch:{ all -> 0x0104 }
            L_0x00de:
                com.baidu.mobstat.x.f1908a = r8     // Catch:{ all -> 0x0104 }
                com.baidu.mobstat.u.a()     // Catch:{ all -> 0x0104 }
                boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0104 }
                if (r5 != 0) goto L_0x00ed
                r1.a(r0, r3)     // Catch:{ all -> 0x0104 }
            L_0x00ed:
                boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0104 }
                if (r3 != 0) goto L_0x00f6
                r1.b(r0, r4)     // Catch:{ all -> 0x0104 }
            L_0x00f6:
                r2.disconnect()     // Catch:{ all -> 0x0109 }
                com.baidu.mobstat.bb r0 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0109 }
                java.lang.String r1 = "finish get config and download jar"
                r0.a(r1)     // Catch:{ all -> 0x0109 }
                monitor-exit(r10)
                return
            L_0x0104:
                r0 = move-exception
                r2.disconnect()     // Catch:{ all -> 0x0109 }
                throw r0     // Catch:{ all -> 0x0109 }
            L_0x0109:
                r0 = move-exception
                monitor-exit(r10)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.x.a.a():void");
        }
    }

    public static boolean b(Context context, String str) {
        int i2;
        String b2 = b(str);
        boolean z = false;
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        try {
            i2 = Integer.valueOf(b2).intValue();
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            i2 = 0;
        }
        if (i2 >= 4) {
            z = true;
        }
        return z;
    }

    public static boolean c(Context context, String str) {
        String a2 = b.a(new File(str));
        bb c2 = bb.c();
        StringBuilder sb = new StringBuilder();
        sb.append("remote.jar local file digest value digest = ");
        sb.append(a2);
        c2.a(sb.toString());
        if (TextUtils.isEmpty(a2)) {
            bb.c().a("remote.jar local file digest value fail");
            return false;
        }
        String b2 = b(str);
        bb c3 = bb.c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("remote.jar local file digest value version = ");
        sb2.append(b2);
        c3.a(sb2.toString());
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String d2 = d(context, b2);
        bb c4 = bb.c();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("remote.jar config digest value remoteJarMd5 = ");
        sb3.append(d2);
        c4.a(sb3.toString());
        if (!TextUtils.isEmpty(d2)) {
            return a2.equals(d2);
        }
        bb.c().a("remote.jar config digest value lost");
        return false;
    }

    public static String d(Context context, String str) {
        return y.a(context).c(str);
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        DexClassLoader a2 = a(context);
        if (a2 == null) {
            return null;
        }
        return a2.loadClass(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b A[SYNTHETIC, Splitter:B:21:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073 A[SYNTHETIC, Splitter:B:27:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r7) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0049 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0049 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0049 }
            if (r2 == 0) goto L_0x0028
            com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()     // Catch:{ Exception -> 0x0049 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049 }
            r3.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "file size: "
            r3.append(r4)     // Catch:{ Exception -> 0x0049 }
            long r4 = r1.length()     // Catch:{ Exception -> 0x0049 }
            r3.append(r4)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0049 }
            r2.b(r1)     // Catch:{ Exception -> 0x0049 }
        L_0x0028:
            java.util.jar.JarFile r1 = new java.util.jar.JarFile     // Catch:{ Exception -> 0x0049 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0049 }
            java.util.jar.Manifest r0 = r1.getManifest()     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.util.jar.Attributes r0 = r0.getMainAttributes()     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.lang.String r2 = "Plugin-Version"
            java.lang.String r7 = r0.getValue(r2)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r1.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            return r7
        L_0x003f:
            r7 = move-exception
            r0 = r1
            goto L_0x0071
        L_0x0042:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x004a
        L_0x0047:
            r7 = move-exception
            goto L_0x0071
        L_0x0049:
            r1 = move-exception
        L_0x004a:
            com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0047 }
            r2.a(r1)     // Catch:{ all -> 0x0047 }
            com.baidu.mobstat.bb r1 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r2.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = "baidu remote sdk is not ready"
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            r2.append(r7)     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0047 }
            r1.a(r7)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ Exception -> 0x006e }
        L_0x006e:
            java.lang.String r7 = ""
            return r7
        L_0x0071:
            if (r0 == 0) goto L_0x0076
            r0.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.x.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized dalvik.system.DexClassLoader a(android.content.Context r5) {
        /*
            java.lang.Class<com.baidu.mobstat.x> r0 = com.baidu.mobstat.x.class
            monitor-enter(r0)
            dalvik.system.DexClassLoader r1 = f1908a     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x000b
            dalvik.system.DexClassLoader r5 = f1908a     // Catch:{ all -> 0x007f }
            monitor-exit(r0)
            return r5
        L_0x000b:
            java.lang.String r1 = ".remote.jar"
            java.io.File r1 = r5.getFileStreamPath(r1)     // Catch:{ all -> 0x007f }
            r2 = 0
            if (r1 == 0) goto L_0x001c
            boolean r3 = r1.isFile()     // Catch:{ all -> 0x007f }
            if (r3 != 0) goto L_0x001c
            monitor-exit(r0)
            return r2
        L_0x001c:
            java.lang.String r3 = r1.getAbsolutePath()     // Catch:{ all -> 0x007f }
            boolean r3 = b(r5, r3)     // Catch:{ all -> 0x007f }
            if (r3 != 0) goto L_0x003a
            com.baidu.mobstat.bb r5 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = "remote jar version lower than min limit, need delete"
            r5.a(r3)     // Catch:{ all -> 0x007f }
            boolean r5 = r1.isFile()     // Catch:{ all -> 0x007f }
            if (r5 == 0) goto L_0x0038
            r1.delete()     // Catch:{ all -> 0x007f }
        L_0x0038:
            monitor-exit(r0)
            return r2
        L_0x003a:
            java.lang.String r3 = r1.getAbsolutePath()     // Catch:{ all -> 0x007f }
            boolean r3 = c(r5, r3)     // Catch:{ all -> 0x007f }
            if (r3 != 0) goto L_0x0058
            com.baidu.mobstat.bb r5 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = "remote jar md5 is not right, need delete"
            r5.a(r3)     // Catch:{ all -> 0x007f }
            boolean r5 = r1.isFile()     // Catch:{ all -> 0x007f }
            if (r5 == 0) goto L_0x0056
            r1.delete()     // Catch:{ all -> 0x007f }
        L_0x0056:
            monitor-exit(r0)
            return r2
        L_0x0058:
            java.lang.String r3 = "outdex"
            r4 = 0
            java.io.File r3 = r5.getDir(r3, r4)     // Catch:{ all -> 0x007f }
            dalvik.system.DexClassLoader r4 = new dalvik.system.DexClassLoader     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0073 }
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ Exception -> 0x0073 }
            r4.<init>(r1, r3, r2, r5)     // Catch:{ Exception -> 0x0073 }
            f1908a = r4     // Catch:{ Exception -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r5 = move-exception
            com.baidu.mobstat.bb r1 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x007f }
            r1.a(r5)     // Catch:{ all -> 0x007f }
        L_0x007b:
            dalvik.system.DexClassLoader r5 = f1908a     // Catch:{ all -> 0x007f }
            monitor-exit(r0)
            return r5
        L_0x007f:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.x.a(android.content.Context):dalvik.system.DexClassLoader");
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (x.class) {
            if (!f1909b) {
                if (!bw.q(context)) {
                    bb.c().a("isWifiAvailable = false, will not to update");
                } else if (!aVar.a(context)) {
                    bb.c().a("check time, will not to update");
                } else {
                    bb.c().a("can start update config");
                    new a(context, aVar).start();
                    f1909b = true;
                }
            }
        }
    }
}
