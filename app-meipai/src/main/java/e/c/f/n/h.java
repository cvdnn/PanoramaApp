package e.c.f.n;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.http.b;
import com.tencent.connect.common.Constants;
import e.c.f.c;
import java.security.MessageDigest;

/* compiled from: MD5Util */
public final class h {

    /* renamed from: a reason: collision with root package name */
    public static final String[] f7071a = {"0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "9", Config.APP_VERSION_CODE, b.f1946a, "c", "d", "e", "f"};

    public static String a(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str4 = new String(str);
            try {
                str2 = b(MessageDigest.getInstance("MD5").digest(str4.getBytes()));
            } catch (Throwable unused) {
                str3 = str4;
                c.d();
                str2 = str3;
                return str2;
            }
        } catch (Throwable unused2) {
            c.d();
            str2 = str3;
            return str2;
        }
        return str2;
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = b2 < 0 ? b2 + 256 : b2;
            int i4 = i3 / 16;
            int i5 = i3 % 16;
            StringBuilder sb = new StringBuilder();
            sb.append(f7071a[i4]);
            sb.append(f7071a[i5]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return b(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|26|(2:28|29)|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
        throw r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0075
            boolean r1 = r8.exists()
            if (r1 != 0) goto L_0x000a
            goto L_0x0075
        L_0x000a:
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ all -> 0x005c }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x005c }
            r2.<init>(r8)     // Catch:{ all -> 0x005c }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x005d }
        L_0x0019:
            int r3 = r2.read(r8)     // Catch:{ all -> 0x005d }
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L_0x0025
            r1.update(r8, r5, r3)     // Catch:{ all -> 0x005d }
            goto L_0x0019
        L_0x0025:
            byte[] r8 = r1.digest()     // Catch:{ all -> 0x005d }
            r1 = 16
            char[] r1 = new char[r1]     // Catch:{ all -> 0x005d }
            r1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102} // fill-array     // Catch:{ all -> 0x005d }
            int r3 = r8.length     // Catch:{ all -> 0x005d }
            int r3 = r3 * 2
            char[] r3 = new char[r3]     // Catch:{ all -> 0x005d }
        L_0x0035:
            int r4 = r8.length     // Catch:{ all -> 0x005d }
            if (r5 >= r4) goto L_0x004f
            byte r4 = r8[r5]     // Catch:{ all -> 0x005d }
            int r6 = r5 * 2
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r1[r7]     // Catch:{ all -> 0x005d }
            r3[r6] = r7     // Catch:{ all -> 0x005d }
            int r6 = r6 + 1
            r4 = r4 & 15
            char r4 = r1[r4]     // Catch:{ all -> 0x005d }
            r3[r6] = r4     // Catch:{ all -> 0x005d }
            int r5 = r5 + 1
            goto L_0x0035
        L_0x004f:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x005d }
            r8.<init>(r3)     // Catch:{ all -> 0x005d }
            r2.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005b
        L_0x0058:
            e.c.f.c.d()
        L_0x005b:
            return r8
        L_0x005c:
            r2 = r0
        L_0x005d:
            e.c.f.c.d()     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0069
        L_0x0066:
            e.c.f.c.d()
        L_0x0069:
            return r0
        L_0x006a:
            r8 = move-exception
            if (r2 == 0) goto L_0x0074
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0074
        L_0x0071:
            e.c.f.c.d()
        L_0x0074:
            throw r8
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.h.a(java.io.File):java.lang.String");
    }
}
