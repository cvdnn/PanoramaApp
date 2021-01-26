package e.c.f.n;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: DbUtil */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public static String f7049a = "";

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r3v6, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[Catch:{ all -> 0x005a }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r7) {
        /*
            java.lang.String r0 = "xyus"
            java.lang.String r1 = ""
            java.lang.String r2 = "leroadcfg"
            r3 = 0
            r4 = 4
            android.content.SharedPreferences r5 = r7.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            r5.edit()     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences$Editor r3 = r2.edit()     // Catch:{ all -> 0x0021 }
            java.lang.String r5 = "re_po_rt"
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x0021 }
            r7.edit()     // Catch:{ all -> 0x0021 }
            goto L_0x0031
        L_0x0021:
            r7 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0028
        L_0x0026:
            r7 = move-exception
            r2 = r3
        L_0x0028:
            r7.getMessage()     // Catch:{ all -> 0x005a }
            e.c.f.c.c()     // Catch:{ all -> 0x005a }
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0031:
            java.lang.String r7 = "xyusec"
            java.lang.String r7 = r2.getString(r7, r1)     // Catch:{ all -> 0x005a }
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x003e
            return
        L_0x003e:
            java.lang.String r7 = e.c.f.n.a.f(r7)     // Catch:{ all -> 0x005a }
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0049
            return
        L_0x0049:
            java.lang.String r1 = r2.getString(r0, r1)     // Catch:{ all -> 0x005a }
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0059
            r3.putString(r0, r7)     // Catch:{ all -> 0x005a }
            r3.commit()     // Catch:{ all -> 0x005a }
        L_0x0059:
            return
        L_0x005a:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.a(android.content.Context):void");
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:41|42) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        e.c.f.c.d();
        r9 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0139, code lost:
        return r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0133 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b A[SYNTHETIC, Splitter:B:21:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006c A[Catch:{ all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String b(android.content.Context r9) {
        /*
            java.lang.Class<e.c.f.n.c> r0 = e.c.f.n.c.class
            monitor-enter(r0)
            java.lang.String r1 = f7049a     // Catch:{ all -> 0x0133 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0133 }
            if (r1 != 0) goto L_0x000f
            java.lang.String r9 = f7049a     // Catch:{ all -> 0x0133 }
            monitor-exit(r0)
            return r9
        L_0x000f:
            java.lang.String r1 = "leroadcfg"
            r2 = 0
            r3 = 4
            android.content.SharedPreferences r4 = r9.getSharedPreferences(r1, r3)     // Catch:{ all -> 0x0031 }
            r4.edit()     // Catch:{ all -> 0x0031 }
            android.content.SharedPreferences r1 = r9.getSharedPreferences(r1, r3)     // Catch:{ all -> 0x0031 }
            android.content.SharedPreferences$Editor r2 = r1.edit()     // Catch:{ all -> 0x002c }
            java.lang.String r4 = "re_po_rt"
            android.content.SharedPreferences r3 = r9.getSharedPreferences(r4, r3)     // Catch:{ all -> 0x002c }
            r3.edit()     // Catch:{ all -> 0x002c }
            goto L_0x003d
        L_0x002c:
            r3 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L_0x0034
        L_0x0031:
            r1 = move-exception
            r3 = r1
            r1 = r2
        L_0x0034:
            r3.getMessage()     // Catch:{ all -> 0x0133 }
            e.c.f.c.c()     // Catch:{ all -> 0x0133 }
            r8 = r2
            r2 = r1
            r1 = r8
        L_0x003d:
            java.lang.String r3 = "xyusec"
            java.lang.String r4 = ""
            java.lang.String r3 = r1.getString(r3, r4)     // Catch:{ all -> 0x0133 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0133 }
            if (r4 != 0) goto L_0x005c
            java.lang.String r3 = e.c.f.n.a.f(r3)     // Catch:{ all -> 0x0059 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0059 }
            if (r4 != 0) goto L_0x005c
            f7049a = r3     // Catch:{ all -> 0x0059 }
            monitor-exit(r0)
            return r3
        L_0x0059:
            e.c.f.c.d()     // Catch:{ all -> 0x0133 }
        L_0x005c:
            java.lang.String r3 = "xyus"
            java.lang.String r4 = ""
            java.lang.String r3 = r1.getString(r3, r4)     // Catch:{ all -> 0x0133 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0133 }
            r5 = 10
            if (r4 != 0) goto L_0x0093
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = "30212102dicudiab"
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "UTF-8"
            byte[] r4 = r3.getBytes(r4)     // Catch:{ all -> 0x0133 }
            byte[] r1 = e.c.d.n.e.b(r1, r4)     // Catch:{ all -> 0x0133 }
            byte[] r1 = android.util.Base64.encode(r1, r5)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "UTF-8"
            r9.<init>(r1, r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = "xyusec"
            r2.putString(r1, r9)     // Catch:{ all -> 0x0133 }
            r2.commit()     // Catch:{ all -> 0x0133 }
            f7049a = r3     // Catch:{ all -> 0x0133 }
            monitor-exit(r0)
            return r3
        L_0x0093:
            java.lang.String r3 = ""
            java.lang.String r4 = e(r9)     // Catch:{ all -> 0x009e }
            java.lang.String r3 = f(r9)     // Catch:{ all -> 0x009f }
            goto L_0x00a2
        L_0x009e:
            r4 = r3
        L_0x009f:
            e.c.f.c.d()     // Catch:{ all -> 0x0133 }
        L_0x00a2:
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0133 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r7.<init>()     // Catch:{ all -> 0x0133 }
            r7.append(r4)     // Catch:{ all -> 0x0133 }
            r7.append(r3)     // Catch:{ all -> 0x0133 }
            r7.append(r6)     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0133 }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x0133 }
            r4 = 1
            java.lang.String r3 = a(r3, r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = e(r9)     // Catch:{ all -> 0x0133 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0133 }
            if (r4 == 0) goto L_0x00d1
            java.lang.String r9 = "0"
        L_0x00d1:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ all -> 0x0133 }
            r4.<init>(r9)     // Catch:{ all -> 0x0133 }
            java.lang.StringBuffer r9 = r4.reverse()     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r4.<init>()     // Catch:{ all -> 0x0133 }
            r4.append(r3)     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = "|"
            r4.append(r3)     // Catch:{ all -> 0x0133 }
            r4.append(r9)     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "30212102dicudiab"
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x0133 }
            java.lang.String r6 = "UTF-8"
            byte[] r6 = r9.getBytes(r6)     // Catch:{ all -> 0x0133 }
            byte[] r4 = e.c.d.n.e.b(r4, r6)     // Catch:{ all -> 0x0133 }
            byte[] r4 = android.util.Base64.encode(r4, r5)     // Catch:{ all -> 0x0133 }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "xyus"
            java.lang.String r5 = ""
            java.lang.String r1 = r1.getString(r4, r5)     // Catch:{ all -> 0x0133 }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0133 }
            if (r4 == 0) goto L_0x012f
            java.lang.String r1 = "xyus"
            r2.putString(r1, r9)     // Catch:{ all -> 0x0133 }
            r2.commit()     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = "xyusec"
            r2.putString(r1, r3)     // Catch:{ all -> 0x0133 }
            r2.commit()     // Catch:{ all -> 0x0133 }
            f7049a = r9     // Catch:{ all -> 0x0133 }
            monitor-exit(r0)
            return r9
        L_0x012f:
            f7049a = r1     // Catch:{ all -> 0x0133 }
            monitor-exit(r0)
            return r1
        L_0x0133:
            e.c.f.c.d()     // Catch:{ all -> 0x013a }
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x013a:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.b(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r3v6, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[Catch:{ all -> 0x0090 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r7) {
        /*
            java.lang.String r0 = "sgud"
            java.lang.String r1 = ""
            java.lang.String r2 = "leroadcfg"
            r3 = 0
            r4 = 4
            android.content.SharedPreferences r5 = r7.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            r5.edit()     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences$Editor r3 = r2.edit()     // Catch:{ all -> 0x0021 }
            java.lang.String r5 = "re_po_rt"
            android.content.SharedPreferences r4 = r7.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x0021 }
            r4.edit()     // Catch:{ all -> 0x0021 }
            goto L_0x0031
        L_0x0021:
            r4 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r3
        L_0x0028:
            r4.getMessage()     // Catch:{ all -> 0x0090 }
            e.c.f.c.c()     // Catch:{ all -> 0x0090 }
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0031:
            java.lang.String r2 = r2.getString(r0, r1)     // Catch:{ all -> 0x0090 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x003c
            return r2
        L_0x003c:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0090 }
            r4 = 25
            if (r2 <= r4) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.String r2 = e(r7)     // Catch:{ all -> 0x0090 }
            java.lang.String r7 = f(r7)     // Catch:{ all -> 0x0090 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x0058
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x0058
            return r1
        L_0x0058:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r4.<init>()     // Catch:{ all -> 0x0090 }
            r4.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = ":"
            r4.append(r2)     // Catch:{ all -> 0x0090 }
            r4.append(r7)     // Catch:{ all -> 0x0090 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0090 }
            byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x0090 }
            r2 = 0
        L_0x0071:
            int r4 = r7.length     // Catch:{ all -> 0x0090 }
            if (r2 >= r4) goto L_0x007e
            byte r4 = r7[r2]     // Catch:{ all -> 0x0090 }
            r4 = r4 ^ 246(0xf6, float:3.45E-43)
            byte r4 = (byte) r4     // Catch:{ all -> 0x0090 }
            r7[r2] = r4     // Catch:{ all -> 0x0090 }
            int r2 = r2 + 1
            goto L_0x0071
        L_0x007e:
            java.lang.String r7 = e.c.f.n.h.a(r7)     // Catch:{ all -> 0x0090 }
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0089
            return r1
        L_0x0089:
            r3.putString(r0, r7)     // Catch:{ all -> 0x0090 }
            r3.commit()     // Catch:{ all -> 0x0090 }
            return r7
        L_0x0090:
            e.c.f.c.d()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.c(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = f(r5)     // Catch:{ all -> 0x0091 }
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch:{ all -> 0x001f }
            java.lang.String r3 = "ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="
            java.lang.String r3 = e.c.f.n.a.f(r3)     // Catch:{ all -> 0x001f }
            java.lang.String r2 = android.provider.Settings.System.getString(r2, r3)     // Catch:{ all -> 0x001f }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0023
            java.lang.String r2 = e(r5)     // Catch:{ all -> 0x0020 }
            goto L_0x0023
        L_0x001f:
            r2 = r0
        L_0x0020:
            e.c.f.c.d()     // Catch:{ all -> 0x0091 }
        L_0x0023:
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"
            java.lang.String r4 = e.c.f.n.a.f(r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = android.provider.Settings.System.getString(r3, r4)     // Catch:{ all -> 0x0091 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0091 }
            if (r4 == 0) goto L_0x0060
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r3.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE="
            java.lang.String r4 = e.c.f.n.a.f(r4)     // Catch:{ all -> 0x0091 }
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            r3.append(r2)     // Catch:{ all -> 0x0091 }
            r3.append(r1)     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0091 }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x0091 }
            r2 = 1
            java.lang.String r1 = a(r1, r2)     // Catch:{ all -> 0x0091 }
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = android.provider.Settings.System.getString(r2, r1)     // Catch:{ all -> 0x0091 }
        L_0x0060:
            if (r3 != 0) goto L_0x0063
            return r0
        L_0x0063:
            java.lang.String r5 = e(r5)     // Catch:{ all -> 0x0091 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x006f
            java.lang.String r5 = "0"
        L_0x006f:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x0091 }
            r1.<init>(r5)     // Catch:{ all -> 0x0091 }
            java.lang.StringBuffer r5 = r1.reverse()     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r1.<init>()     // Catch:{ all -> 0x0091 }
            r1.append(r3)     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch:{ all -> 0x0091 }
            r1.append(r5)     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0091 }
            return r5
        L_0x0091:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.d(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[Catch:{ all -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "com.baidu.input_huawei"
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0051 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x000f
            return r0
        L_0x000f:
            java.lang.String r1 = "leroadcfg"
            r2 = 0
            r3 = 4
            android.content.SharedPreferences r4 = r5.getSharedPreferences(r1, r3)     // Catch:{ all -> 0x002f }
            r4.edit()     // Catch:{ all -> 0x002b }
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r1, r3)     // Catch:{ all -> 0x002b }
            r2.edit()     // Catch:{ all -> 0x002b }
            java.lang.String r1 = "re_po_rt"
            android.content.SharedPreferences r1 = r5.getSharedPreferences(r1, r3)     // Catch:{ all -> 0x002b }
            r1.edit()     // Catch:{ all -> 0x002b }
            goto L_0x0039
        L_0x002b:
            r1 = move-exception
            r3 = r2
            r2 = r4
            goto L_0x0031
        L_0x002f:
            r1 = move-exception
            r3 = r2
        L_0x0031:
            r1.getMessage()     // Catch:{ all -> 0x0051 }
            e.c.f.c.c()     // Catch:{ all -> 0x0051 }
            r4 = r2
            r2 = r3
        L_0x0039:
            java.lang.String r1 = "appinv_sai"
            r3 = 0
            int r1 = r4.getInt(r1, r3)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = "s_a_pl"
            boolean r1 = r2.getBoolean(r1, r3)     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            java.lang.String r5 = e.c.f.b.a.a(r5)     // Catch:{ all -> 0x0051 }
            return r5
        L_0x0050:
            return r0
        L_0x0051:
            e.c.f.c.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.e(android.content.Context):java.lang.String");
    }

    public static String f(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String g(Context context) {
        String str = "";
        try {
            String string = System.getString(context.getContentResolver(), a.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
            if (TextUtils.isEmpty(string)) {
                string = e(context);
            }
            try {
                String e2 = e(context);
                if (TextUtils.isEmpty(e2)) {
                    e2 = "0";
                }
                String stringBuffer = new StringBuffer(e2).reverse().toString();
                String a2 = a(string);
                if (!TextUtils.isEmpty(a2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a2);
                    sb.append("|");
                    sb.append(stringBuffer);
                    return sb.toString();
                }
            } catch (Throwable unused) {
                e.c.f.c.d();
                return str;
            }
        } catch (Exception unused2) {
        }
        return str;
    }

    public static String h(Context context) {
        String str;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            String str2 = "*";
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                StringBuilder sb = new StringBuilder();
                sb.append(displayMetrics.widthPixels);
                sb.append(str2);
                sb.append(displayMetrics.heightPixels);
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(displayMetrics.heightPixels);
                sb2.append(str2);
                sb2.append(displayMetrics.widthPixels);
                str = sb2.toString();
            }
            return str;
        } catch (Exception unused) {
            e.c.f.c.d();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ all -> 0x0011 }
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x0014
            java.lang.String r2 = r2.getSubscriberId()     // Catch:{ all -> 0x0011 }
            goto L_0x0015
        L_0x0011:
            e.c.f.c.d()
        L_0x0014:
            r2 = r0
        L_0x0015:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x001c
            return r0
        L_0x001c:
            java.lang.String r1 = "46000"
            boolean r1 = r2.startsWith(r1)
            if (r1 != 0) goto L_0x0044
            java.lang.String r1 = "46002"
            boolean r1 = r2.startsWith(r1)
            if (r1 == 0) goto L_0x002d
            goto L_0x0044
        L_0x002d:
            java.lang.String r1 = "46001"
            boolean r1 = r2.startsWith(r1)
            if (r1 == 0) goto L_0x0038
            java.lang.String r2 = "2"
            return r2
        L_0x0038:
            java.lang.String r1 = "46003"
            boolean r2 = r2.startsWith(r1)
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = "3"
            return r2
        L_0x0043:
            return r0
        L_0x0044:
            java.lang.String r2 = "1"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.i(android.content.Context):java.lang.String");
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            String str = "";
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            e.c.f.c.d();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        e.c.f.c.d();
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0087 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r9) {
        /*
            java.lang.String r0 = "30212102dicudiab"
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            java.io.File r1 = new java.io.File
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY="
            java.lang.String r5 = e.c.f.n.a.f(r5)
            r4.append(r5)
            java.lang.String r5 = "/"
            r4.append(r5)
            java.lang.String r5 = "u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="
            java.lang.String r5 = e.c.f.n.a.f(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.<init>(r3, r4)
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x00a6 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00a6 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a6 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r3.<init>()     // Catch:{ Exception -> 0x00a6 }
        L_0x0043:
            java.lang.String r4 = r1.readLine()     // Catch:{ Exception -> 0x00a6 }
            if (r4 == 0) goto L_0x0052
            r3.append(r4)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "\r\n"
            r3.append(r4)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x0043
        L_0x0052:
            r1.close()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a6 }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x00a6 }
            r4 = 0
            byte[] r3 = android.util.Base64.decode(r3, r4)     // Catch:{ Exception -> 0x00a6 }
            r5 = 2
            javax.crypto.spec.SecretKeySpec r6 = new javax.crypto.spec.SecretKeySpec     // Catch:{ all -> 0x0087 }
            byte[] r7 = r0.getBytes()     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = "AES"
            r6.<init>(r7, r8)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)     // Catch:{ all -> 0x0087 }
            javax.crypto.spec.IvParameterSpec r8 = new javax.crypto.spec.IvParameterSpec     // Catch:{ all -> 0x0087 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0087 }
            r8.<init>(r0)     // Catch:{ all -> 0x0087 }
            r7.init(r5, r6, r8)     // Catch:{ all -> 0x0087 }
            byte[] r0 = r7.doFinal(r3)     // Catch:{ all -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            e.c.f.c.d()     // Catch:{ Exception -> 0x00a6 }
            r0 = 0
        L_0x008b:
            r1.<init>(r0)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r0 = "="
            java.lang.String[] r0 = r1.split(r0)     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x00a9
            int r1 = r0.length     // Catch:{ Exception -> 0x00a6 }
            if (r1 != r5) goto L_0x00a9
            r1 = r0[r4]     // Catch:{ Exception -> 0x00a6 }
            boolean r9 = r9.equals(r1)     // Catch:{ Exception -> 0x00a6 }
            if (r9 == 0) goto L_0x00a9
            r9 = 1
            r9 = r0[r9]     // Catch:{ Exception -> 0x00a6 }
            r2 = r9
            goto L_0x00a9
        L_0x00a6:
            e.c.f.c.d()
        L_0x00a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.c.a(java.lang.String):java.lang.String");
    }
}
