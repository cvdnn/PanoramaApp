package e.c.f.n;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import e.c.f.c;
import java.io.File;

/* compiled from: NewUid */
public final class i {

    /* renamed from: a reason: collision with root package name */
    public static String f7072a = "";

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x0152 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ca A[SYNTHETIC, Splitter:B:36:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0132 A[Catch:{ all -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013f A[Catch:{ all -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0157 A[SYNTHETIC, Splitter:B:71:0x0157] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r11) {
        /*
            java.lang.String r0 = f7072a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x016c
            java.lang.String r0 = b(r11)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0080
            java.lang.String r0 = c(r11)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x007d
            java.lang.String r0 = d(r11)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x007a
            java.lang.String r0 = e.c.f.n.c.e(r11)
            java.lang.String r1 = e.c.f.n.c.f(r11)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x0057
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x0057
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "1|"
            r0.<init>(r1)
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = e.c.f.n.h.a(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0078
        L_0x0057:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "0|"
            r4.<init>(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r1)
            java.lang.String r0 = r5.toString()
            java.lang.String r0 = e.c.f.n.h.a(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x0078:
            r1 = r2
            goto L_0x007e
        L_0x007a:
            r4 = r2
            r1 = r3
            goto L_0x0083
        L_0x007d:
            r1 = r3
        L_0x007e:
            r4 = r1
            goto L_0x0083
        L_0x0080:
            r1 = r3
            r2 = r1
            r4 = r2
        L_0x0083:
            r5 = 0
            if (r2 != 0) goto L_0x0090
            java.lang.String r2 = b(r11)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00ed
        L_0x0090:
            java.lang.String r2 = "leroadcfg"
            r6 = 4
            android.content.SharedPreferences r7 = r11.getSharedPreferences(r2, r6)     // Catch:{ all -> 0x00ae }
            r7.edit()     // Catch:{ all -> 0x00ae }
            android.content.SharedPreferences r2 = r11.getSharedPreferences(r2, r6)     // Catch:{ all -> 0x00ae }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = "re_po_rt"
            android.content.SharedPreferences r6 = r11.getSharedPreferences(r7, r6)     // Catch:{ all -> 0x00ac }
            r6.edit()     // Catch:{ all -> 0x00ac }
            goto L_0x00b7
        L_0x00ac:
            r6 = move-exception
            goto L_0x00b1
        L_0x00ae:
            r2 = move-exception
            r6 = r2
            r2 = r5
        L_0x00b1:
            r6.getMessage()
            e.c.f.c.c()
        L_0x00b7:
            java.lang.String r6 = "UTF-8"
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r8 = "rpnewuidn"
            if (r7 == 0) goto L_0x00ca
            java.lang.String r6 = ""
            r2.putString(r8, r6)
            r2.commit()
            goto L_0x00ed
        L_0x00ca:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = "MzAyMTIxMDJkaWN1ZGlhYg=="
            byte[] r9 = r9.getBytes()     // Catch:{ all -> 0x00ea }
            byte[] r10 = r0.getBytes(r6)     // Catch:{ all -> 0x00ea }
            byte[] r9 = e.c.d.n.e.b(r9, r10)     // Catch:{ all -> 0x00ea }
            r10 = 10
            byte[] r9 = android.util.Base64.encode(r9, r10)     // Catch:{ all -> 0x00ea }
            r7.<init>(r9, r6)     // Catch:{ all -> 0x00ea }
            r2.putString(r8, r7)
            r2.commit()
            goto L_0x00ed
        L_0x00ea:
            e.c.f.c.d()
        L_0x00ed:
            if (r4 != 0) goto L_0x00f9
            java.lang.String r2 = c(r11)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0106
        L_0x00f9:
            java.lang.String r2 = "com.q.zi.i"
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ all -> 0x0103 }
            android.provider.Settings.System.putString(r4, r2, r0)     // Catch:{ all -> 0x0103 }
            goto L_0x0106
        L_0x0103:
            e.c.f.c.d()
        L_0x0106:
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r2 = a(r11, r2)
            if (r2 == 0) goto L_0x016a
            if (r1 != 0) goto L_0x011a
            java.lang.String r11 = d(r11)
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x016a
        L_0x011a:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x0152 }
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = ".zp"
            r11.<init>(r1, r2)     // Catch:{ all -> 0x0152 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = ".icosc"
            r1.<init>(r11, r2)     // Catch:{ all -> 0x0152 }
            boolean r2 = r11.exists()     // Catch:{ all -> 0x0152 }
            if (r2 == 0) goto L_0x013f
            boolean r2 = r11.isDirectory()     // Catch:{ all -> 0x0152 }
            if (r2 != 0) goto L_0x0142
            r11.delete()     // Catch:{ all -> 0x0152 }
            r11.mkdirs()     // Catch:{ all -> 0x0152 }
            goto L_0x0142
        L_0x013f:
            r11.mkdirs()     // Catch:{ all -> 0x0152 }
        L_0x0142:
            java.io.FileWriter r11 = new java.io.FileWriter     // Catch:{ all -> 0x0152 }
            r11.<init>(r1, r3)     // Catch:{ all -> 0x0152 }
            r11.write(r0)     // Catch:{ all -> 0x0151 }
            r11.flush()     // Catch:{ all -> 0x0151 }
            r11.close()     // Catch:{ all -> 0x015b }
            goto L_0x016a
        L_0x0151:
            r5 = r11
        L_0x0152:
            e.c.f.c.d()     // Catch:{ all -> 0x015f }
            if (r5 == 0) goto L_0x016a
            r5.close()     // Catch:{ all -> 0x015b }
            goto L_0x016a
        L_0x015b:
            e.c.f.c.d()
            goto L_0x016a
        L_0x015f:
            r11 = move-exception
            if (r5 == 0) goto L_0x0169
            r5.close()     // Catch:{ all -> 0x0166 }
            goto L_0x0169
        L_0x0166:
            e.c.f.c.d()
        L_0x0169:
            throw r11
        L_0x016a:
            f7072a = r0
        L_0x016c:
            java.lang.String r11 = f7072a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.i.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r3v6, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0055 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042 A[SYNTHETIC, Splitter:B:14:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ all -> 0x0095, all -> 0x009a }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060 A[Catch:{ all -> 0x0095, all -> 0x009a }] */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r11) {
        /*
            java.lang.String r0 = "rpnewuidn"
            java.lang.String r1 = ""
            java.lang.String r2 = "leroadcfg"
            r3 = 0
            r4 = 4
            android.content.SharedPreferences r5 = r11.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            r5.edit()     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences r2 = r11.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences$Editor r3 = r2.edit()     // Catch:{ all -> 0x0021 }
            java.lang.String r5 = "re_po_rt"
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x0021 }
            r11.edit()     // Catch:{ all -> 0x0021 }
            goto L_0x0031
        L_0x0021:
            r11 = move-exception
            r10 = r3
            r3 = r2
            r2 = r10
            goto L_0x0028
        L_0x0026:
            r11 = move-exception
            r2 = r3
        L_0x0028:
            r11.getMessage()     // Catch:{ all -> 0x009a }
            e.c.f.c.c()     // Catch:{ all -> 0x009a }
            r10 = r3
            r3 = r2
            r2 = r10
        L_0x0031:
            java.lang.String r11 = r2.getString(r0, r1)     // Catch:{ all -> 0x009a }
            boolean r4 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x009a }
            java.lang.String r5 = "UTF-8"
            r6 = 10
            java.lang.String r7 = "MzAyMTIxMDJkaWN1ZGlhYg=="
            if (r4 == 0) goto L_0x0042
            goto L_0x0058
        L_0x0042:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0055 }
            byte[] r8 = r7.getBytes()     // Catch:{ all -> 0x0055 }
            byte[] r11 = android.util.Base64.decode(r11, r6)     // Catch:{ all -> 0x0055 }
            r9 = 1
            byte[] r11 = e.c.d.n.e.a(r8, r11, r9)     // Catch:{ all -> 0x0055 }
            r4.<init>(r11, r5)     // Catch:{ all -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            e.c.f.c.d()     // Catch:{ all -> 0x009a }
        L_0x0058:
            r4 = r1
        L_0x0059:
            boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x009a }
            if (r11 != 0) goto L_0x0060
            return r4
        L_0x0060:
            java.lang.String r11 = "rpnewuid"
            java.lang.String r11 = r2.getString(r11, r1)     // Catch:{ all -> 0x009a }
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x009a }
            if (r2 != 0) goto L_0x0099
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x0079
            r3.putString(r0, r1)     // Catch:{ all -> 0x009a }
            r3.commit()     // Catch:{ all -> 0x009a }
            goto L_0x0098
        L_0x0079:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0095 }
            byte[] r4 = r7.getBytes()     // Catch:{ all -> 0x0095 }
            byte[] r7 = r11.getBytes(r5)     // Catch:{ all -> 0x0095 }
            byte[] r4 = e.c.d.n.e.b(r4, r7)     // Catch:{ all -> 0x0095 }
            byte[] r4 = android.util.Base64.encode(r4, r6)     // Catch:{ all -> 0x0095 }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x0095 }
            r3.putString(r0, r2)     // Catch:{ all -> 0x009a }
            r3.commit()     // Catch:{ all -> 0x009a }
            goto L_0x0098
        L_0x0095:
            e.c.f.c.d()     // Catch:{ all -> 0x009a }
        L_0x0098:
            return r11
        L_0x0099:
            return r1
        L_0x009a:
            e.c.f.c.d()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.i.b(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r1) {
        /*
            java.lang.String r0 = "com.q.zi.i"
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x000b }
            java.lang.String r1 = android.provider.Settings.System.getString(r1, r0)     // Catch:{ all -> 0x000b }
            goto L_0x000f
        L_0x000b:
            e.c.f.c.d()     // Catch:{ all -> 0x0010 }
            r1 = 0
        L_0x000f:
            return r1
        L_0x0010:
            e.c.f.c.d()
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.i.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        String str = "";
        try {
            if (!a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                return str;
            }
            File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
            if (file.exists()) {
                return a(file);
            }
            return str;
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r1 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003b, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0026 }
            r1.<init>(r5)     // Catch:{ all -> 0x0026 }
            r5 = 8192(0x2000, float:1.14794E-41)
            char[] r5 = new char[r5]     // Catch:{ all -> 0x0027 }
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch:{ all -> 0x0027 }
            r2.<init>()     // Catch:{ all -> 0x0027 }
        L_0x000f:
            int r3 = r1.read(r5)     // Catch:{ all -> 0x0027 }
            if (r3 <= 0) goto L_0x001a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0027 }
            r1.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            e.c.f.c.d()
        L_0x0025:
            return r5
        L_0x0026:
            r1 = r0
        L_0x0027:
            e.c.f.c.d()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0033
        L_0x0030:
            e.c.f.c.d()
        L_0x0033:
            return r0
        L_0x0034:
            r5 = move-exception
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            e.c.f.c.d()
        L_0x003e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.i.a(java.io.File):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable unused) {
            c.d();
            return false;
        }
    }
}
