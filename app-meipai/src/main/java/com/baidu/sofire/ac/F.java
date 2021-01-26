package com.baidu.sofire.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import e.c.f.c;
import e.c.f.f.d;
import e.c.f.f.f;
import e.c.f.f.g;
import e.c.f.f.h;
import e.c.f.n.a;
import e.c.f.n.k;
import java.util.Map;

public class F implements FI {
    public static F instance;
    public static Asc sAsc;

    public static synchronized F getInstance() {
        F f2;
        synchronized (F.class) {
            if (instance == null) {
                instance = new F();
            }
            f2 = instance;
        }
        return f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r5.length == 0) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] ad(byte[] r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "5"
            r1 = 0
            if (r6 == 0) goto L_0x0047
            int r2 = r6.length     // Catch:{ all -> 0x0044 }
            if (r2 <= 0) goto L_0x0047
            if (r5 == 0) goto L_0x0047
            int r2 = r5.length     // Catch:{ all -> 0x0044 }
            if (r2 > 0) goto L_0x000e
            goto L_0x0047
        L_0x000e:
            java.lang.String r2 = "3"
            e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0044 }
            r2 = 1
            byte[] r2 = e.c.d.n.e.a(r6, r5, r2)     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x001e
            int r3 = r2.length     // Catch:{ all -> 0x0044 }
            if (r3 <= 0) goto L_0x001e
            return r2
        L_0x001e:
            com.baidu.sofire.jni.Asc r2 = sAsc     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x0029
            com.baidu.sofire.jni.Asc r2 = new com.baidu.sofire.jni.Asc     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            sAsc = r2     // Catch:{ all -> 0x0044 }
        L_0x0029:
            java.lang.String r2 = "4"
            e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0044 }
            com.baidu.sofire.jni.Asc r2 = sAsc     // Catch:{ all -> 0x003d }
            byte[] r5 = r2.dc(r5, r6)     // Catch:{ all -> 0x003d }
            if (r5 == 0) goto L_0x0039
            int r6 = r5.length     // Catch:{ all -> 0x0044 }
            if (r6 != 0) goto L_0x003c
        L_0x0039:
            e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0044 }
        L_0x003c:
            return r5
        L_0x003d:
            e.c.f.c.d()     // Catch:{ all -> 0x0044 }
            e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0044 }
            return r1
        L_0x0044:
            e.c.f.c.d()
        L_0x0047:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.ad(byte[], byte[]):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r5.length == 0) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] ae(byte[] r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "2"
            r1 = 0
            if (r6 == 0) goto L_0x0046
            int r2 = r6.length     // Catch:{ all -> 0x0043 }
            if (r2 <= 0) goto L_0x0046
            if (r5 == 0) goto L_0x0046
            int r2 = r5.length     // Catch:{ all -> 0x0043 }
            if (r2 > 0) goto L_0x000e
            goto L_0x0046
        L_0x000e:
            java.lang.String r2 = "0"
            e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0043 }
            byte[] r2 = e.c.d.n.e.b(r6, r5)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x001d
            int r3 = r2.length     // Catch:{ all -> 0x0043 }
            if (r3 <= 0) goto L_0x001d
            return r2
        L_0x001d:
            com.baidu.sofire.jni.Asc r2 = sAsc     // Catch:{ all -> 0x0043 }
            if (r2 != 0) goto L_0x0028
            com.baidu.sofire.jni.Asc r2 = new com.baidu.sofire.jni.Asc     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            sAsc = r2     // Catch:{ all -> 0x0043 }
        L_0x0028:
            java.lang.String r2 = "1"
            e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0043 }
            com.baidu.sofire.jni.Asc r2 = sAsc     // Catch:{ all -> 0x003c }
            byte[] r5 = r2.ac(r5, r6)     // Catch:{ all -> 0x003c }
            if (r5 == 0) goto L_0x0038
            int r6 = r5.length     // Catch:{ all -> 0x0043 }
            if (r6 != 0) goto L_0x003b
        L_0x0038:
            e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0043 }
        L_0x003b:
            return r5
        L_0x003c:
            e.c.f.c.d()     // Catch:{ all -> 0x0043 }
            e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0043 }
            return r1
        L_0x0043:
            e.c.f.c.d()
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.ae(byte[], byte[]):byte[]");
    }

    public boolean chh(Context context, String str) {
        return true;
    }

    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        String str4 = ", ";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str4);
            sb.append(str2);
            sb.append(str4);
            sb.append(str3);
            sb.append(str4);
            sb.append(callback);
            c.a();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    g gVar = g.f6978g;
                    if (gVar == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                        return;
                    }
                    ApkInfo c2 = gVar.c(str2);
                    if (gVar.c(str) == null || c2 == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                        return;
                    }
                    Class a2 = ((f) c2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                    Object a3 = a.a(a2.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a2, new Object[]{null}), str3, clsArr, objArr);
                    new StringBuilder().append(a3);
                    if (callback != null) {
                        callback.onEnd(a3);
                    }
                    return;
                }
            }
            if (callback != null) {
                callback.onEnd(new Object[0]);
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    public Pair<Integer, Object> cmsi(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            d dVar = d.f6938e;
            if (dVar == null) {
                return new Pair<>(Integer.valueOf(4), null);
            }
            return dVar.a(i2, str, clsArr, objArr);
        } catch (Throwable unused) {
            c.d();
            return new Pair<>(Integer.valueOf(3), null);
        }
    }

    public Map<Integer, String> gpd() {
        try {
            e.c.f.d.a aVar = e.c.f.d.a.f6914f;
            if (aVar != null) {
                return aVar.b();
            }
        } catch (Throwable unused) {
            c.d();
        }
        return null;
    }

    public String gs(String str) {
        String str2 = "";
        try {
            g gVar = g.f6978g;
            if (gVar == null) {
                return str2;
            }
            ApkInfo c2 = gVar.c(str);
            return c2 != null ? c2.libPath : str2;
        } catch (Throwable unused) {
            c.d();
            return str2;
        }
    }

    public String gta(Context context) {
        try {
            k.a(context);
            return k.e();
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    public String gzd(Context context) {
        return e.c.f.n.c.b(context);
    }

    public String p(String str) {
        try {
            ApkInfo apkInfo = (ApkInfo) g.f6978g.f6985d.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        String str4 = ", ";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str4);
            sb.append(intentFilter);
            sb.append(str4);
            sb.append(str2);
            sb.append(str4);
            sb.append(str3);
            c.a();
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    g gVar = g.f6978g;
                    new StringBuilder("h=").append(gVar);
                    if (gVar != null) {
                        gVar.a(new h(str, intentFilter, str2, str3));
                    }
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] rd(byte[] r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L_0x002f
            int r1 = r5.length     // Catch:{ all -> 0x002c }
            if (r1 <= 0) goto L_0x002f
            if (r4 == 0) goto L_0x002f
            int r1 = r4.length     // Catch:{ all -> 0x002c }
            if (r1 > 0) goto L_0x000c
            goto L_0x002f
        L_0x000c:
            byte[] r1 = e.c.d.n.e.c(r4, r5)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0016
            int r2 = r1.length     // Catch:{ all -> 0x002c }
            if (r2 <= 0) goto L_0x0016
            return r1
        L_0x0016:
            com.baidu.sofire.jni.Asc r1 = sAsc     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0021
            com.baidu.sofire.jni.Asc r1 = new com.baidu.sofire.jni.Asc     // Catch:{ all -> 0x002c }
            r1.<init>()     // Catch:{ all -> 0x002c }
            sAsc = r1     // Catch:{ all -> 0x002c }
        L_0x0021:
            com.baidu.sofire.jni.Asc r1 = sAsc     // Catch:{ all -> 0x0028 }
            byte[] r4 = r1.dr(r4, r5)     // Catch:{ all -> 0x0028 }
            return r4
        L_0x0028:
            e.c.f.c.d()     // Catch:{ all -> 0x002c }
            return r0
        L_0x002c:
            e.c.f.c.d()
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.rd(byte[], byte[]):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r5.length == 0) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] re(byte[] r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "8"
            r1 = 0
            if (r6 == 0) goto L_0x0046
            int r2 = r6.length     // Catch:{ all -> 0x0043 }
            if (r2 <= 0) goto L_0x0046
            if (r5 == 0) goto L_0x0046
            int r2 = r5.length     // Catch:{ all -> 0x0043 }
            if (r2 > 0) goto L_0x000e
            goto L_0x0046
        L_0x000e:
            java.lang.String r2 = "6"
            e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0043 }
            byte[] r2 = e.c.d.n.e.c(r5, r6)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x001d
            int r3 = r2.length     // Catch:{ all -> 0x0043 }
            if (r3 <= 0) goto L_0x001d
            return r2
        L_0x001d:
            com.baidu.sofire.jni.Asc r2 = sAsc     // Catch:{ all -> 0x0043 }
            if (r2 != 0) goto L_0x0028
            com.baidu.sofire.jni.Asc r2 = new com.baidu.sofire.jni.Asc     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            sAsc = r2     // Catch:{ all -> 0x0043 }
        L_0x0028:
            java.lang.String r2 = "7"
            e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0043 }
            com.baidu.sofire.jni.Asc r2 = sAsc     // Catch:{ all -> 0x003c }
            byte[] r5 = r2.ar(r5, r6)     // Catch:{ all -> 0x003c }
            if (r5 == 0) goto L_0x0038
            int r6 = r5.length     // Catch:{ all -> 0x0043 }
            if (r6 != 0) goto L_0x003b
        L_0x0038:
            e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0043 }
        L_0x003b:
            return r5
        L_0x003c:
            e.c.f.c.d()     // Catch:{ all -> 0x0043 }
            e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0043 }
            return r1
        L_0x0043:
            e.c.f.c.d()
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.re(byte[], byte[]):byte[]");
    }

    public void rf(Context context) {
        try {
            new U(context.getApplicationContext(), 5, true).start();
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(int r5, boolean r6) {
        /*
            r4 = this;
            e.c.f.d.a r0 = e.c.f.d.a.f6914f     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0036
            if (r6 == 0) goto L_0x0008
            r6 = 1
            goto L_0x0009
        L_0x0008:
            r6 = 0
        L_0x0009:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x0037 }
            r1.<init>()     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = "s"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0037 }
            r1.put(r2, r6)     // Catch:{ all -> 0x0037 }
            android.database.sqlite.SQLiteDatabase r6 = r0.f6918d     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "pgn"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "k="
            r2.<init>(r3)     // Catch:{ all -> 0x0033 }
            r2.append(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = " and n=1"
            r2.append(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0033 }
            r2 = 0
            r6.update(r0, r1, r5, r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            e.c.f.c.d()     // Catch:{ all -> 0x0037 }
        L_0x0036:
            return
        L_0x0037:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.s(int, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sp(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            e.c.f.d.a r0 = e.c.f.d.a.f6914f     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x002a
            r1 = 1
            r2 = 0
            if (r7 == 0) goto L_0x000a
            r7 = r1
            goto L_0x000b
        L_0x000a:
            r7 = r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x002b }
            r3.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "s"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x002b }
            r3.put(r4, r7)     // Catch:{ all -> 0x002b }
            android.database.sqlite.SQLiteDatabase r7 = r0.f6918d     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = "pgn"
            java.lang.String r4 = "p=? and n=1"
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x0027 }
            r1[r2] = r6     // Catch:{ all -> 0x0027 }
            r7.update(r0, r3, r4, r1)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            e.c.f.c.d()     // Catch:{ all -> 0x002b }
        L_0x002a:
            return
        L_0x002b:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.sp(java.lang.String, boolean):void");
    }

    public void u(String str) {
        try {
            d.f6938e.a(str);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    g gVar = g.f6978g;
                    if (gVar != null) {
                        gVar.b(new h(str, intentFilter, str2, str3));
                    }
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
    }
}
