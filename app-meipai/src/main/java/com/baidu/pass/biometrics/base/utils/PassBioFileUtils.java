package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import java.io.File;
import java.io.IOException;

public class PassBioFileUtils {
    public static final String TAG = "PassBioFileUtils";

    public static boolean checkAndCreadFile(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!isFileExist(str)) {
            return true;
        }
        return deleteFile(new File(str));
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        return write(file, bArr, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean write(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r3.exists()     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x0012
            java.io.File r2 = r3.getParentFile()     // Catch:{ all -> 0x0027 }
            r2.mkdirs()     // Catch:{ all -> 0x0027 }
            r3.createNewFile()     // Catch:{ all -> 0x0027 }
        L_0x0012:
            boolean r2 = r3.canWrite()     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x0019
            return r0
        L_0x0019:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0027 }
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0027 }
            r2.write(r4)     // Catch:{ all -> 0x0026 }
            r2.close()
            r3 = 1
            return r3
        L_0x0026:
            r1 = r2
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.base.utils.PassBioFileUtils.write(java.io.File, byte[], boolean):boolean");
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e2) {
            Log.e(e2);
            return false;
        }
    }
}
