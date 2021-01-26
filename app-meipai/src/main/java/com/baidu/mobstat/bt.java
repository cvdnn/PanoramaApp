package com.baidu.mobstat;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class bt {

    public static class a {
        public static String a(byte[] bArr) {
            try {
                return bt.b(MessageDigest.getInstance("md5"), bArr);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static class b {
        public static String a(byte[] bArr) {
            try {
                return bt.b(MessageDigest.getInstance("SHA-256"), bArr);
            } catch (Exception unused) {
                return "";
            }
        }

        public static String a(File file) {
            try {
                return bt.b(MessageDigest.getInstance("SHA-256"), file);
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
    }

    public static String b(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return a(messageDigest.digest());
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >> 4) & 15;
            byte b2 = bArr[i2] & 15;
            sb.append((char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48));
            sb.append((char) (b2 >= 10 ? (b2 + 97) - 10 : b2 + 48));
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0028 A[SYNTHETIC, Splitter:B:22:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.security.MessageDigest r3, java.io.File r4) {
        /*
            boolean r0 = r4.isFile()
            if (r0 == 0) goto L_0x003a
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002c, all -> 0x0025 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002c, all -> 0x0025 }
            r4 = 4048(0xfd0, float:5.672E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
        L_0x0010:
            int r0 = r1.read(r4)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r2 = -1
            if (r0 != r2) goto L_0x001b
            r1.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0031
        L_0x001b:
            r2 = 0
            r3.update(r4, r2, r0)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r3 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x0023:
            r0 = r1
            goto L_0x002c
        L_0x0025:
            r3 = move-exception
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            throw r3
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            byte[] r3 = r3.digest()
            java.lang.String r3 = a(r3)
            return r3
        L_0x003a:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bt.b(java.security.MessageDigest, java.io.File):java.lang.String");
    }
}
