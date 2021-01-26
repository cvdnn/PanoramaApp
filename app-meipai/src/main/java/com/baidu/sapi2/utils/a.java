package com.baidu.sapi2.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: FileUtil */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static final int f3023a = 2048;

    public static boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e2) {
            Log.i(Log.TAG, e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r2) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            int r2 = r1.available()     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.read(r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.close()
            return r0
        L_0x0018:
            r2 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001b:
            r0 = r1
            goto L_0x0024
        L_0x001d:
            r2 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()
        L_0x0023:
            throw r2
        L_0x0024:
            if (r0 == 0) goto L_0x0029
            r0.close()
        L_0x0029:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.a.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r2, byte[] r3, boolean r4) throws java.io.IOException {
        /*
            r0 = 0
            boolean r1 = r2.exists()     // Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0011
            java.io.File r1 = r2.getParentFile()     // Catch:{ all -> 0x0025 }
            r1.mkdirs()     // Catch:{ all -> 0x0025 }
            r2.createNewFile()     // Catch:{ all -> 0x0025 }
        L_0x0011:
            boolean r1 = r2.canWrite()     // Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0018
            return r0
        L_0x0018:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0025 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0025 }
            r1.write(r3)     // Catch:{ all -> 0x0026 }
            r1.close()
            r2 = 1
            return r2
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r1.close()
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.a.a(java.io.File, byte[], boolean):boolean");
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws Exception, IOException {
        String str = Log.TAG;
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        int i2 = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i2 += read;
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    Log.e(str, (Throwable) e2);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    Log.e(str, (Throwable) e3);
                }
            }
        }
        bufferedOutputStream.flush();
        try {
        } catch (IOException e4) {
            Log.e(str, (Throwable) e4);
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e5) {
            Log.e(str, (Throwable) e5);
        }
        return i2;
    }
}
