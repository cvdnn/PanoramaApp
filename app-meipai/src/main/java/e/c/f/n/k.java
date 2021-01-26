package e.c.f.n;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Base64;
import com.sina.weibo.sdk.statistic.LogBuilder;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: TDIDManager */
public class k {

    /* renamed from: c reason: collision with root package name */
    public static k f7074c;

    /* renamed from: d reason: collision with root package name */
    public static String f7075d;

    /* renamed from: a reason: collision with root package name */
    public Context f7076a;

    /* renamed from: b reason: collision with root package name */
    public l f7077b;

    public k(Context context) {
        this.f7076a = context;
        this.f7077b = new l(context);
        f7075d = e();
    }

    public static k a(Context context) {
        synchronized (k.class) {
            if (f7074c == null) {
                f7074c = new k(context);
            }
        }
        return f7074c;
    }

    public static String e() {
        try {
            byte[] bytes = "Pnu1RZ`M22vl6bg0".getBytes();
            byte[] bArr = new byte[bytes.length];
            int i2 = 0;
            for (byte b2 : bytes) {
                bArr[i2] = (byte) (b2 ^ 3);
                i2++;
            }
            return new String(bArr);
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    public static j f() {
        try {
            FileReader fileReader = new FileReader(new File(Environment.getExternalStorageDirectory(), "backups/.tdidv2"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            fileReader.close();
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return null;
            }
            byte[] decode = Base64.decode(sb2, 0);
            byte[] bArr = new byte[decode.length];
            for (int i2 = 0; i2 < decode.length; i2++) {
                bArr[i2] = (byte) (decode[i2] ^ 2);
            }
            return b(new String(bArr));
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0080 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String b() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = ""
            e.c.f.n.j r1 = r5.c()     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0014
            java.lang.String r2 = r1.f7073a     // Catch:{ all -> 0x0080 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0080 }
            if (r2 != 0) goto L_0x0014
            java.lang.String r0 = r1.f7073a     // Catch:{ all -> 0x0080 }
            goto L_0x0083
        L_0x0014:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "com.baidu.action.SOFIRE.VIEW"
            r1.<init>(r2)     // Catch:{ all -> 0x0080 }
            android.content.Context r2 = r5.f7076a     // Catch:{ all -> 0x0080 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0080 }
            r3 = 0
            java.util.List r1 = r2.queryIntentServices(r1, r3)     // Catch:{ all -> 0x0080 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0080 }
        L_0x002a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0080 }
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2     // Catch:{ all -> 0x0080 }
            android.content.pm.ServiceInfo r3 = r2.serviceInfo     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x002a
            android.content.pm.ServiceInfo r3 = r2.serviceInfo     // Catch:{ all -> 0x0080 }
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x002a
            android.content.pm.ServiceInfo r2 = r2.serviceInfo     // Catch:{ all -> 0x0080 }
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo     // Catch:{ all -> 0x0080 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r4.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.dataDir     // Catch:{ all -> 0x0080 }
            r4.append(r2)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x0080 }
            r4.append(r2)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "files"
            r4.append(r2)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0080 }
            r3.<init>(r2)     // Catch:{ all -> 0x0080 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = "libtdidv2.so"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0080 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x002a
            e.c.f.n.j r2 = a(r2)     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x002a
            java.lang.String r0 = r2.f7073a     // Catch:{ all -> 0x0080 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0080 }
            if (r2 != 0) goto L_0x002a
            r5.a(r0)     // Catch:{ all -> 0x0080 }
            goto L_0x0083
        L_0x0080:
            e.c.f.c.d()     // Catch:{ all -> 0x0085 }
        L_0x0083:
            monitor-exit(r5)
            return r0
        L_0x0085:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.b():java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:3|4|5|6|7|8|9|(3:(3:17|18|(3:20|21|22))|(3:24|25|(3:27|28|29))|(3:31|32|(3:34|35|36)))(3:13|14|15)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e.c.f.n.j c() {
        /*
            r9 = this;
            java.lang.Class<e.c.f.n.k> r0 = e.c.f.n.k.class
            monitor-enter(r0)
            r1 = 0
            e.c.f.n.j r2 = r9.d()     // Catch:{ all -> 0x0084 }
            e.c.f.n.j r3 = f()     // Catch:{ all -> 0x0084 }
            e.c.f.l r4 = r9.f7077b     // Catch:{ all -> 0x002b }
            android.content.SharedPreferences r4 = r4.f7028a     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "t_d_i_dv2"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.getString(r5, r6)     // Catch:{ all -> 0x002b }
            e.c.f.l r5 = r9.f7077b     // Catch:{ all -> 0x002b }
            android.content.SharedPreferences r5 = r5.f7028a     // Catch:{ all -> 0x002b }
            java.lang.String r6 = "t_d_i_d_tv2"
            r7 = 0
            r5.getLong(r6, r7)     // Catch:{ all -> 0x002b }
            e.c.f.n.j r5 = new e.c.f.n.j     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            r5.f7073a = r4     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002b:
            e.c.f.c.d()     // Catch:{ all -> 0x0084 }
            r5 = r1
        L_0x002f:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r6.<init>()     // Catch:{ all -> 0x0084 }
            android.content.Context r7 = r9.f7076a     // Catch:{ all -> 0x0084 }
            java.io.File r7 = r7.getFilesDir()     // Catch:{ all -> 0x0084 }
            r6.append(r7)     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ all -> 0x0084 }
            r6.append(r7)     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = "libtdidv2.so"
            r6.append(r7)     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0084 }
            r4.<init>(r6)     // Catch:{ all -> 0x0084 }
            e.c.f.n.j r4 = a(r4)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0060
            java.lang.String r6 = r2.f7073a     // Catch:{ all -> 0x0084 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0084 }
            if (r6 != 0) goto L_0x0060
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r2
        L_0x0060:
            if (r3 == 0) goto L_0x006c
            java.lang.String r2 = r3.f7073a     // Catch:{ all -> 0x0084 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0084 }
            if (r2 != 0) goto L_0x006c
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r3
        L_0x006c:
            if (r5 == 0) goto L_0x0078
            java.lang.String r2 = r5.f7073a     // Catch:{ all -> 0x0084 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0084 }
            if (r2 != 0) goto L_0x0078
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r5
        L_0x0078:
            if (r4 == 0) goto L_0x0087
            java.lang.String r2 = r4.f7073a     // Catch:{ all -> 0x0084 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0084 }
            if (r2 != 0) goto L_0x0087
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r4
        L_0x0084:
            e.c.f.c.d()     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r1
        L_0x0089:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.c():e.c.f.n.j");
    }

    public final j d() {
        try {
            String string = System.getString(this.f7076a.getContentResolver(), "setting_tdidv2");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            byte[] decode = Base64.decode(string, 0);
            byte[] bArr = new byte[decode.length];
            for (int i2 = 0; i2 < decode.length; i2++) {
                bArr[i2] = (byte) (decode[i2] ^ 2);
            }
            return b(new String(bArr));
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x016e, code lost:
        return "";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0151 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0168 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String a() {
        /*
            r13 = this;
            monitor-enter(r13)
            r0 = 78
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x0168 }
            android.content.Context r1 = r13.f7076a     // Catch:{ all -> 0x0168 }
            byte[] r1 = e.c.f.n.l.a(r1)     // Catch:{ all -> 0x0168 }
            r0.put(r1)     // Catch:{ all -> 0x0168 }
            android.content.Context r2 = r13.f7076a     // Catch:{ all -> 0x0168 }
            java.lang.String[] r2 = e.c.f.n.a.e(r2)     // Catch:{ all -> 0x0168 }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0031
            int r5 = r2.length     // Catch:{ all -> 0x0168 }
            r6 = 2
            if (r5 != r6) goto L_0x0031
            r5 = r2[r4]     // Catch:{ all -> 0x0168 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0168 }
            if (r5 != 0) goto L_0x0031
            r5 = r2[r3]     // Catch:{ all -> 0x0168 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0168 }
            if (r5 != 0) goto L_0x0031
            r2 = r2[r4]     // Catch:{ all -> 0x0168 }
            goto L_0x0033
        L_0x0031:
            java.lang.String r2 = "0"
        L_0x0033:
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0168 }
            if (r5 == 0) goto L_0x003b
            java.lang.String r2 = "0"
        L_0x003b:
            long r5 = e.c.d.n.e.a(r2)     // Catch:{ all -> 0x0168 }
            int r5 = (int) r5     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ all -> 0x0168 }
            byte[] r5 = e.c.f.n.l.a(r5)     // Catch:{ all -> 0x0168 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0168 }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            int r6 = (int) r6     // Catch:{ all -> 0x0168 }
            r7 = 4
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r7)     // Catch:{ all -> 0x0168 }
            java.lang.String r6 = java.lang.Integer.toHexString(r6)     // Catch:{ all -> 0x0086 }
            int r9 = r6.length()     // Catch:{ all -> 0x0086 }
            r10 = 8
            if (r9 >= r10) goto L_0x007e
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ all -> 0x0086 }
            r9.<init>()     // Catch:{ all -> 0x0086 }
            r11 = r4
        L_0x0067:
            int r12 = r6.length()     // Catch:{ all -> 0x0086 }
            int r12 = 8 - r12
            if (r11 >= r12) goto L_0x0077
            java.lang.String r12 = "0"
            r9.append(r12)     // Catch:{ all -> 0x0086 }
            int r11 = r11 + 1
            goto L_0x0067
        L_0x0077:
            r9.append(r6)     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0086 }
        L_0x007e:
            byte[] r6 = e.c.f.n.l.a(r6)     // Catch:{ all -> 0x0086 }
            r8.put(r6)     // Catch:{ all -> 0x0086 }
            goto L_0x0089
        L_0x0086:
            e.c.f.c.d()     // Catch:{ all -> 0x0168 }
        L_0x0089:
            byte[] r6 = r8.array()     // Catch:{ all -> 0x0168 }
            r0.put(r5)     // Catch:{ all -> 0x0168 }
            r0.put(r6)     // Catch:{ all -> 0x0168 }
            r0.put(r5)     // Catch:{ all -> 0x0168 }
            r0.put(r6)     // Catch:{ all -> 0x0168 }
            byte[] r8 = new byte[r3]     // Catch:{ all -> 0x0168 }
            r8[r4] = r3     // Catch:{ all -> 0x0168 }
            r0.put(r8)     // Catch:{ all -> 0x0168 }
            byte[] r8 = new byte[r3]     // Catch:{ all -> 0x0168 }
            r8[r4] = r3     // Catch:{ all -> 0x0168 }
            r0.put(r8)     // Catch:{ all -> 0x0168 }
            byte[] r8 = e.c.f.n.l.a(r4)     // Catch:{ all -> 0x0168 }
            r0.put(r8)     // Catch:{ all -> 0x0168 }
            r8 = 2147483647(0x7fffffff, float:NaN)
            byte[] r8 = e.c.f.n.l.a(r8)     // Catch:{ all -> 0x0168 }
            r0.put(r8)     // Catch:{ all -> 0x0168 }
            r0.put(r6)     // Catch:{ all -> 0x0168 }
            r9 = 44
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.allocate(r9)     // Catch:{ all -> 0x0168 }
            java.nio.ByteBuffer r1 = r9.put(r1)     // Catch:{ all -> 0x0168 }
            java.nio.ByteBuffer r1 = r1.put(r8)     // Catch:{ all -> 0x0168 }
            java.nio.ByteBuffer r1 = r1.put(r5)     // Catch:{ all -> 0x0168 }
            r1.put(r6)     // Catch:{ all -> 0x0168 }
            r1 = 16
            byte[] r5 = new byte[r1]     // Catch:{ all -> 0x0168 }
            byte[] r6 = r9.array()     // Catch:{ all -> 0x0168 }
            java.lang.String r6 = e.c.f.n.h.a(r6)     // Catch:{ all -> 0x0168 }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x0168 }
            java.lang.System.arraycopy(r6, r4, r5, r4, r1)     // Catch:{ all -> 0x0168 }
            r0.put(r5)     // Catch:{ all -> 0x0168 }
            byte[] r0 = r0.array()     // Catch:{ all -> 0x0168 }
            java.lang.String r1 = f7075d     // Catch:{ all -> 0x0168 }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x0168 }
            byte[] r0 = e.c.d.n.e.e(r1, r0)     // Catch:{ all -> 0x0168 }
            int r1 = r0.length     // Catch:{ all -> 0x0168 }
            int r1 = r1 - r7
            byte[] r5 = new byte[r1]     // Catch:{ all -> 0x0168 }
            e.c.f.l r6 = r13.f7077b     // Catch:{ all -> 0x0168 }
            int r6 = r6.a()     // Catch:{ all -> 0x0168 }
            byte[] r8 = e.c.f.n.l.a(r6)     // Catch:{ all -> 0x0168 }
            int r6 = r6 % 128
            byte r6 = (byte) r6     // Catch:{ all -> 0x0168 }
            r5[r4] = r6     // Catch:{ all -> 0x0168 }
        L_0x0107:
            if (r3 >= r1) goto L_0x0119
            int r6 = r3 + -1
            byte r6 = r5[r6]     // Catch:{ all -> 0x0168 }
            int r6 = r6 * 5
            int r6 = r6 + 7
            int r6 = r6 % 128
            byte r6 = (byte) r6     // Catch:{ all -> 0x0168 }
            r5[r3] = r6     // Catch:{ all -> 0x0168 }
            int r3 = r3 + 1
            goto L_0x0107
        L_0x0119:
            int r1 = r1 + r7
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ all -> 0x0168 }
            java.nio.ByteBuffer r3 = r1.put(r5)     // Catch:{ all -> 0x0168 }
            r3.put(r8)     // Catch:{ all -> 0x0168 }
            byte[] r1 = r1.array()     // Catch:{ all -> 0x0168 }
            int r3 = r0.length     // Catch:{ all -> 0x0168 }
            byte[] r5 = new byte[r3]     // Catch:{ all -> 0x0168 }
        L_0x012c:
            int r6 = r0.length     // Catch:{ all -> 0x0168 }
            if (r4 >= r6) goto L_0x013a
            byte r6 = r0[r4]     // Catch:{ all -> 0x0168 }
            byte r9 = r1[r4]     // Catch:{ all -> 0x0168 }
            r6 = r6 ^ r9
            byte r6 = (byte) r6     // Catch:{ all -> 0x0168 }
            r5[r4] = r6     // Catch:{ all -> 0x0168 }
            int r4 = r4 + 1
            goto L_0x012c
        L_0x013a:
            int r3 = r3 + r7
            int r3 = r3 + r7
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ all -> 0x0168 }
            r0.put(r5)     // Catch:{ all -> 0x0168 }
            r0.put(r8)     // Catch:{ all -> 0x0168 }
            byte[] r1 = new byte[r7]     // Catch:{ all -> 0x0168 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0151 }
            byte[] r1 = e.c.f.n.l.a(r2)     // Catch:{ all -> 0x0151 }
            goto L_0x0154
        L_0x0151:
            e.c.f.c.d()     // Catch:{ all -> 0x0168 }
        L_0x0154:
            r0.put(r1)     // Catch:{ all -> 0x0168 }
            byte[] r0 = r0.array()     // Catch:{ all -> 0x0168 }
            r1 = 11
            byte[] r0 = android.util.Base64.encode(r0, r1)     // Catch:{ all -> 0x0168 }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0168 }
            r1.<init>(r0)     // Catch:{ all -> 0x0168 }
            monitor-exit(r13)
            return r1
        L_0x0168:
            e.c.f.c.d()     // Catch:{ all -> 0x016f }
            java.lang.String r0 = ""
            monitor-exit(r13)
            return r0
        L_0x016f:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.a():java.lang.String");
    }

    public final void b(String str, long j2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                byte[] bytes = c(str, j2).getBytes();
                byte[] bArr = new byte[bytes.length];
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    bArr[i2] = (byte) (bytes[i2] ^ 2);
                }
                byte[] encode = Base64.encode(bArr, 0);
                FileOutputStream openFileOutput = this.f7076a.openFileOutput("libtdidv2.so", 1);
                openFileOutput.write(encode);
                openFileOutput.close();
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static String c(String str, long j2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tdid", str);
            jSONObject.put(LogBuilder.KEY_TIME, j2);
            return jSONObject.toString();
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    public static j b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("tdid");
            jSONObject.optLong(LogBuilder.KEY_TIME);
            j jVar = new j();
            jVar.f7073a = optString;
            return jVar;
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:52|53|(2:55|56)|(1:58)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:46|47|72|73|74|75) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bb, code lost:
        if (r3 != 0) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c0, code lost:
        if (r5 != 0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c2, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c5, code lost:
        if (r6 != 0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c8, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c9, code lost:
        if (r3 != 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ce, code lost:
        if (r5 != 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d0, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d3, code lost:
        if (r6 != 0) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d5, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f6, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00d9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x00f2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.Class<e.c.f.n.k> r0 = e.c.f.n.k.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return
        L_0x000b:
            r12 = move-exception
            goto L_0x00f7
        L_0x000e:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f2 }
            java.lang.String r3 = ""
            r4 = 1
            java.lang.String r12 = r11.a(r12, r3, r4)     // Catch:{ all -> 0x00f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x0020
            goto L_0x0040
        L_0x0020:
            e.c.f.l r3 = r11.f7077b     // Catch:{ all -> 0x003d }
            android.content.SharedPreferences$Editor r4 = r3.f7029b     // Catch:{ all -> 0x003d }
            java.lang.String r5 = "t_d_i_dv2"
            r4.putString(r5, r12)     // Catch:{ all -> 0x003d }
            android.content.SharedPreferences$Editor r3 = r3.f7029b     // Catch:{ all -> 0x003d }
            r3.commit()     // Catch:{ all -> 0x003d }
            e.c.f.l r3 = r11.f7077b     // Catch:{ all -> 0x003d }
            android.content.SharedPreferences$Editor r4 = r3.f7029b     // Catch:{ all -> 0x003d }
            java.lang.String r5 = "t_d_i_d_tv2"
            r4.putLong(r5, r1)     // Catch:{ all -> 0x003d }
            android.content.SharedPreferences$Editor r3 = r3.f7029b     // Catch:{ all -> 0x003d }
            r3.commit()     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            e.c.f.c.d()     // Catch:{ all -> 0x00f2 }
        L_0x0040:
            java.lang.String r3 = ""
            r4 = 2
            java.lang.String r12 = r11.a(r12, r3, r4)     // Catch:{ all -> 0x00f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00f2 }
            if (r3 != 0) goto L_0x00dd
            r3 = 0
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00b6 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x00b6 }
            java.lang.String r7 = "backups/.tdidv2"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00b6 }
            java.io.File r6 = r5.getParentFile()     // Catch:{ all -> 0x00b6 }
            boolean r7 = r6.exists()     // Catch:{ all -> 0x00b6 }
            if (r7 != 0) goto L_0x0066
            r6.mkdir()     // Catch:{ all -> 0x00b6 }
        L_0x0066:
            boolean r6 = r5.exists()     // Catch:{ all -> 0x00b6 }
            if (r6 != 0) goto L_0x006f
            r5.createNewFile()     // Catch:{ all -> 0x00b6 }
        L_0x006f:
            java.lang.String r6 = c(r12, r1)     // Catch:{ all -> 0x00b6 }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x00b6 }
            int r7 = r6.length     // Catch:{ all -> 0x00b6 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x00b6 }
            r8 = 0
            r9 = r8
        L_0x007c:
            int r10 = r6.length     // Catch:{ all -> 0x00b6 }
            if (r9 >= r10) goto L_0x0088
            byte r10 = r6[r9]     // Catch:{ all -> 0x00b6 }
            r10 = r10 ^ r4
            byte r10 = (byte) r10     // Catch:{ all -> 0x00b6 }
            r7[r9] = r10     // Catch:{ all -> 0x00b6 }
            int r9 = r9 + 1
            goto L_0x007c
        L_0x0088:
            byte[] r4 = android.util.Base64.encode(r7, r8)     // Catch:{ all -> 0x00b6 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b6 }
            r6.<init>(r5)     // Catch:{ all -> 0x00b6 }
            java.nio.channels.FileChannel r5 = r6.getChannel()     // Catch:{ all -> 0x00b4 }
            java.nio.channels.FileLock r3 = r5.tryLock()     // Catch:{ all -> 0x00b8 }
            if (r3 == 0) goto L_0x00a4
            boolean r7 = r3.isValid()     // Catch:{ all -> 0x00b8 }
            if (r7 == 0) goto L_0x00a4
            r6.write(r4)     // Catch:{ all -> 0x00b8 }
        L_0x00a4:
            if (r3 == 0) goto L_0x00a9
            r3.release()     // Catch:{ all -> 0x00b0 }
        L_0x00a9:
            r5.close()     // Catch:{ all -> 0x00b0 }
        L_0x00ac:
            r6.close()     // Catch:{ all -> 0x00b0 }
            goto L_0x00dd
        L_0x00b0:
            e.c.f.c.d()     // Catch:{ all -> 0x00f2 }
            goto L_0x00dd
        L_0x00b4:
            r5 = r3
            goto L_0x00b8
        L_0x00b6:
            r5 = r3
            r6 = r5
        L_0x00b8:
            e.c.f.c.d()     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x00c0
            r3.release()     // Catch:{ all -> 0x00b0 }
        L_0x00c0:
            if (r5 == 0) goto L_0x00c5
            r5.close()     // Catch:{ all -> 0x00b0 }
        L_0x00c5:
            if (r6 == 0) goto L_0x00dd
            goto L_0x00ac
        L_0x00c8:
            r12 = move-exception
            if (r3 == 0) goto L_0x00ce
            r3.release()     // Catch:{ all -> 0x00d9 }
        L_0x00ce:
            if (r5 == 0) goto L_0x00d3
            r5.close()     // Catch:{ all -> 0x00d9 }
        L_0x00d3:
            if (r6 == 0) goto L_0x00dc
            r6.close()     // Catch:{ all -> 0x00d9 }
            goto L_0x00dc
        L_0x00d9:
            e.c.f.c.d()     // Catch:{ all -> 0x00f2 }
        L_0x00dc:
            throw r12     // Catch:{ all -> 0x00f2 }
        L_0x00dd:
            java.lang.String r3 = ""
            r4 = 3
            java.lang.String r12 = r11.a(r12, r3, r4)     // Catch:{ all -> 0x00f2 }
            r11.a(r12, r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r3 = ""
            r4 = 7
            java.lang.String r12 = r11.a(r12, r3, r4)     // Catch:{ all -> 0x00f2 }
            r11.b(r12, r1)     // Catch:{ all -> 0x00f2 }
            goto L_0x00f5
        L_0x00f2:
            e.c.f.c.d()     // Catch:{ all -> 0x000b }
        L_0x00f5:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return
        L_0x00f7:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, long r7) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r6 = c(r6, r7)     // Catch:{ all -> 0x005d }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x005d }
            int r7 = r6.length     // Catch:{ all -> 0x005d }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x005d }
            r8 = 0
            r0 = r8
        L_0x0014:
            int r1 = r6.length     // Catch:{ all -> 0x005d }
            if (r0 >= r1) goto L_0x0021
            byte r1 = r6[r0]     // Catch:{ all -> 0x005d }
            r1 = r1 ^ 2
            byte r1 = (byte) r1     // Catch:{ all -> 0x005d }
            r7[r0] = r1     // Catch:{ all -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0021:
            byte[] r6 = android.util.Base64.encode(r7, r8)     // Catch:{ all -> 0x005d }
            android.content.Context r7 = r5.f7076a     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x005d }
            r1 = r8
        L_0x002e:
            if (r1 > 0) goto L_0x0049
            r2 = r0[r8]     // Catch:{ all -> 0x0045 }
            int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x0045 }
            int r4 = android.os.Process.myUid()     // Catch:{ all -> 0x0045 }
            int r2 = r7.checkPermission(r2, r3, r4)     // Catch:{ all -> 0x0045 }
            r3 = -1
            if (r2 != r3) goto L_0x0042
            goto L_0x004a
        L_0x0042:
            int r1 = r1 + 1
            goto L_0x002e
        L_0x0045:
            e.c.f.c.d()     // Catch:{ all -> 0x005d }
            goto L_0x004a
        L_0x0049:
            r8 = 1
        L_0x004a:
            if (r8 == 0) goto L_0x005c
            android.content.Context r7 = r5.f7076a     // Catch:{ all -> 0x005d }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "setting_tdidv2"
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x005d }
            r0.<init>(r6)     // Catch:{ all -> 0x005d }
            android.provider.Settings.System.putString(r7, r8, r0)     // Catch:{ all -> 0x005d }
        L_0x005c:
            return
        L_0x005d:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.a(java.lang.String, long):void");
    }

    public static j a(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return null;
            }
            byte[] decode = Base64.decode(sb2, 0);
            byte[] bArr = new byte[decode.length];
            for (int i2 = 0; i2 < decode.length; i2++) {
                bArr[i2] = (byte) (decode[i2] ^ 2);
            }
            return b(new String(bArr));
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0081 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            byte[] r1 = a(r11, r0)     // Catch:{ all -> 0x0097 }
            int r2 = r1.length     // Catch:{ all -> 0x0097 }
            r3 = 4
            int r2 = r2 - r3
            byte[] r4 = new byte[r2]     // Catch:{ all -> 0x0097 }
            byte[] r5 = e.c.f.n.l.a(r12)     // Catch:{ all -> 0x0097 }
            int r12 = r12 % 128
            byte r12 = (byte) r12     // Catch:{ all -> 0x0097 }
            r4[r0] = r12     // Catch:{ all -> 0x0097 }
            r12 = 1
            r6 = r12
        L_0x0015:
            if (r6 >= r2) goto L_0x0027
            int r7 = r6 + -1
            byte r7 = r4[r7]     // Catch:{ all -> 0x0097 }
            int r7 = r7 * 5
            int r7 = r7 + 7
            int r7 = r7 % 128
            byte r7 = (byte) r7     // Catch:{ all -> 0x0097 }
            r4[r6] = r7     // Catch:{ all -> 0x0097 }
            int r6 = r6 + 1
            goto L_0x0015
        L_0x0027:
            int r2 = r2 + r3
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r4 = r2.put(r4)     // Catch:{ all -> 0x0097 }
            r4.put(r5)     // Catch:{ all -> 0x0097 }
            byte[] r2 = r2.array()     // Catch:{ all -> 0x0097 }
            int r4 = r1.length     // Catch:{ all -> 0x0097 }
            byte[] r6 = new byte[r4]     // Catch:{ all -> 0x0097 }
            r7 = r0
        L_0x003b:
            int r8 = r1.length     // Catch:{ all -> 0x0097 }
            if (r7 >= r8) goto L_0x0049
            byte r8 = r1[r7]     // Catch:{ all -> 0x0097 }
            byte r9 = r2[r7]     // Catch:{ all -> 0x0097 }
            r8 = r8 ^ r9
            byte r8 = (byte) r8     // Catch:{ all -> 0x0097 }
            r6[r7] = r8     // Catch:{ all -> 0x0097 }
            int r7 = r7 + 1
            goto L_0x003b
        L_0x0049:
            int r4 = r4 + r3
            int r4 = r4 + r3
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r4)     // Catch:{ all -> 0x0097 }
            r1.put(r6)     // Catch:{ all -> 0x0097 }
            r1.put(r5)     // Catch:{ all -> 0x0097 }
            byte[] r2 = new byte[r3]     // Catch:{ all -> 0x0097 }
            android.content.Context r3 = r10.f7076a     // Catch:{ all -> 0x0081 }
            java.lang.String[] r3 = e.c.f.n.a.e(r3)     // Catch:{ all -> 0x0081 }
            if (r3 == 0) goto L_0x0076
            int r4 = r3.length     // Catch:{ all -> 0x0081 }
            r5 = 2
            if (r4 != r5) goto L_0x0076
            r4 = r3[r0]     // Catch:{ all -> 0x0081 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0081 }
            if (r4 != 0) goto L_0x0076
            r12 = r3[r12]     // Catch:{ all -> 0x0081 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0081 }
            if (r12 != 0) goto L_0x0076
            r12 = r3[r0]     // Catch:{ all -> 0x0081 }
            goto L_0x0078
        L_0x0076:
            java.lang.String r12 = "0"
        L_0x0078:
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ all -> 0x0081 }
            byte[] r2 = e.c.f.n.l.a(r12)     // Catch:{ all -> 0x0081 }
            goto L_0x0084
        L_0x0081:
            e.c.f.c.d()     // Catch:{ all -> 0x0097 }
        L_0x0084:
            r1.put(r2)     // Catch:{ all -> 0x0097 }
            byte[] r12 = r1.array()     // Catch:{ all -> 0x0097 }
            r0 = 11
            byte[] r12 = android.util.Base64.encode(r12, r0)     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0097 }
            r0.<init>(r12)     // Catch:{ all -> 0x0097 }
            return r0
        L_0x0097:
            e.c.f.c.d()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.a(java.lang.String, int):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00a1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            r9 = this;
            r0 = 1
            byte[] r1 = a(r10, r0)     // Catch:{ all -> 0x00b7 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00b7 }
            r11 = 0
            if (r12 <= 0) goto L_0x0016
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x00b7 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x00b7 }
            r2[r11] = r12     // Catch:{ all -> 0x00b7 }
            r12 = 48
            java.lang.System.arraycopy(r2, r11, r1, r12, r0)     // Catch:{ all -> 0x00b7 }
        L_0x0016:
            java.lang.String r12 = f7075d     // Catch:{ all -> 0x00b7 }
            byte[] r12 = r12.getBytes()     // Catch:{ all -> 0x00b7 }
            byte[] r12 = e.c.d.n.e.e(r12, r1)     // Catch:{ all -> 0x00b7 }
            int r1 = r12.length     // Catch:{ all -> 0x00b7 }
            r2 = 4
            int r1 = r1 - r2
            byte[] r3 = new byte[r1]     // Catch:{ all -> 0x00b7 }
            e.c.f.l r4 = r9.f7077b     // Catch:{ all -> 0x00b7 }
            int r4 = r4.a()     // Catch:{ all -> 0x00b7 }
            byte[] r5 = e.c.f.n.l.a(r4)     // Catch:{ all -> 0x00b7 }
            int r4 = r4 % 128
            byte r4 = (byte) r4     // Catch:{ all -> 0x00b7 }
            r3[r11] = r4     // Catch:{ all -> 0x00b7 }
            r4 = r0
        L_0x0035:
            if (r4 >= r1) goto L_0x0047
            int r6 = r4 + -1
            byte r6 = r3[r6]     // Catch:{ all -> 0x00b7 }
            int r6 = r6 * 5
            int r6 = r6 + 7
            int r6 = r6 % 128
            byte r6 = (byte) r6     // Catch:{ all -> 0x00b7 }
            r3[r4] = r6     // Catch:{ all -> 0x00b7 }
            int r4 = r4 + 1
            goto L_0x0035
        L_0x0047:
            int r1 = r1 + r2
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ all -> 0x00b7 }
            java.nio.ByteBuffer r3 = r1.put(r3)     // Catch:{ all -> 0x00b7 }
            r3.put(r5)     // Catch:{ all -> 0x00b7 }
            byte[] r1 = r1.array()     // Catch:{ all -> 0x00b7 }
            int r3 = r12.length     // Catch:{ all -> 0x00b7 }
            byte[] r4 = new byte[r3]     // Catch:{ all -> 0x00b7 }
            r6 = r11
        L_0x005b:
            int r7 = r12.length     // Catch:{ all -> 0x00b7 }
            if (r6 >= r7) goto L_0x0069
            byte r7 = r12[r6]     // Catch:{ all -> 0x00b7 }
            byte r8 = r1[r6]     // Catch:{ all -> 0x00b7 }
            r7 = r7 ^ r8
            byte r7 = (byte) r7     // Catch:{ all -> 0x00b7 }
            r4[r6] = r7     // Catch:{ all -> 0x00b7 }
            int r6 = r6 + 1
            goto L_0x005b
        L_0x0069:
            int r3 = r3 + r2
            int r3 = r3 + r2
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ all -> 0x00b7 }
            r12.put(r4)     // Catch:{ all -> 0x00b7 }
            r12.put(r5)     // Catch:{ all -> 0x00b7 }
            byte[] r1 = new byte[r2]     // Catch:{ all -> 0x00b7 }
            android.content.Context r2 = r9.f7076a     // Catch:{ all -> 0x00a1 }
            java.lang.String[] r2 = e.c.f.n.a.e(r2)     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x0096
            int r3 = r2.length     // Catch:{ all -> 0x00a1 }
            r4 = 2
            if (r3 != r4) goto L_0x0096
            r3 = r2[r11]     // Catch:{ all -> 0x00a1 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a1 }
            if (r3 != 0) goto L_0x0096
            r0 = r2[r0]     // Catch:{ all -> 0x00a1 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x0096
            r11 = r2[r11]     // Catch:{ all -> 0x00a1 }
            goto L_0x0098
        L_0x0096:
            java.lang.String r11 = "0"
        L_0x0098:
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ all -> 0x00a1 }
            byte[] r1 = e.c.f.n.l.a(r11)     // Catch:{ all -> 0x00a1 }
            goto L_0x00a4
        L_0x00a1:
            e.c.f.c.d()     // Catch:{ all -> 0x00b7 }
        L_0x00a4:
            r12.put(r1)     // Catch:{ all -> 0x00b7 }
            byte[] r11 = r12.array()     // Catch:{ all -> 0x00b7 }
            r12 = 11
            byte[] r11 = android.util.Base64.encode(r11, r12)     // Catch:{ all -> 0x00b7 }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x00b7 }
            r12.<init>(r11)     // Catch:{ all -> 0x00b7 }
            return r12
        L_0x00b7:
            e.c.f.c.d()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.k.a(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public static byte[] a(String str, boolean z) {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] bArr = new byte[4];
            int length = (decode.length - 4) - 4;
            byte[] bArr2 = new byte[length];
            System.arraycopy(decode, (decode.length - 4) - 4, bArr, 0, 4);
            System.arraycopy(decode, 0, bArr2, 0, (decode.length - 4) - 4);
            int length2 = (decode.length - 8) - 4;
            byte[] bArr3 = new byte[length2];
            int i2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                i2 += (bArr[i3] & 255) << ((3 - i3) * 8);
            }
            bArr3[0] = (byte) (i2 % 128);
            for (int i4 = 1; i4 < length2; i4++) {
                bArr3[i4] = (byte) (((bArr3[i4 - 1] * 5) + 7) % 128);
            }
            ByteBuffer allocate = ByteBuffer.allocate(length2 + 4);
            allocate.put(bArr3).put(bArr);
            byte[] array = allocate.array();
            byte[] bArr4 = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                bArr4[i5] = (byte) (bArr2[i5] ^ array[i5]);
            }
            return z ? e.a(f7075d.getBytes(), bArr4, false) : bArr4;
        } catch (Throwable unused) {
            c.d();
            return new byte[0];
        }
    }
}
