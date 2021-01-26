package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import e.c.a.a.b.b;
import e.c.b.e.Utils;
import java.util.UUID;

public class PassBiometricUtil {
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";
    public static final int STANDARD_BG_HEIGHT = 1335;
    public static final int STANDARD_BG_WIDTH = 750;
    public static final int STANDARD_FACE_INSIDE_MAX_HEIGHT = 620;
    public static final int STANDARD_FACE_INSIDE_MAX_WIDTH = 480;
    public static final int STANDARD_FACE_MIDDLE_MARGIN_TOP = 728;
    public static final int STANDARD_FACE_WIDTH = 480;
    public static final int STANDARD_MAX_FACE_WIDTH = 480;
    public static final int STANDARD_MIN_FACE_WIDTH = 192;
    public static final String TAG = "PassBiometricUtil";

    public static int calculateInSampleSize(Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 <= i3 && i5 <= i2) {
            return 1;
        }
        int round = Math.round(((float) i4) / ((float) i3));
        int round2 = Math.round(((float) i5) / ((float) i2));
        return round < round2 ? round : round2;
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getClientId(Context context) {
        try {
            return b.b(context);
        } catch (Throwable unused) {
            return "123456789";
        }
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r2v15, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b5, code lost:
        if (r2 != 0) goto L_0x0095;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00af A[SYNTHETIC, Splitter:B:26:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0189 A[SYNTHETIC, Splitter:B:72:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0191 A[Catch:{ IOException -> 0x018d }] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCpuType() {
        /*
            java.lang.String r0 = "\\s+"
            java.lang.String r1 = "PassBiometricUtil"
            java.lang.String r2 = "/proc/cpuinfo"
            java.lang.String r3 = ""
            java.lang.String[] r3 = new java.lang.String[]{r3, r3}
            r4 = 0
            r5 = 1
            r6 = 0
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ IOException -> 0x00a7, all -> 0x00a3 }
            r7.<init>(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a3 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a0, all -> 0x009b }
            r8 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r7, r8)     // Catch:{ IOException -> 0x00a0, all -> 0x009b }
            java.lang.String r8 = r2.readLine()     // Catch:{ IOException -> 0x0099 }
            java.lang.String[] r9 = r8.split(r0)     // Catch:{ IOException -> 0x0099 }
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0099 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0099 }
            r11.<init>()     // Catch:{ IOException -> 0x0099 }
            java.lang.String r12 = "getCpuType()str2:"
            r11.append(r12)     // Catch:{ IOException -> 0x0099 }
            r11.append(r8)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r8 = r11.toString()     // Catch:{ IOException -> 0x0099 }
            r10[r6] = r8     // Catch:{ IOException -> 0x0099 }
            com.baidu.pass.biometrics.base.debug.Log.d(r1, r10)     // Catch:{ IOException -> 0x0099 }
            r8 = 2
            r10 = r8
        L_0x003d:
            int r11 = r9.length     // Catch:{ IOException -> 0x0099 }
            if (r10 >= r11) goto L_0x005d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0099 }
            r11.<init>()     // Catch:{ IOException -> 0x0099 }
            r12 = r3[r6]     // Catch:{ IOException -> 0x0099 }
            r11.append(r12)     // Catch:{ IOException -> 0x0099 }
            r12 = r9[r10]     // Catch:{ IOException -> 0x0099 }
            r11.append(r12)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r12 = " "
            r11.append(r12)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0099 }
            r3[r6] = r11     // Catch:{ IOException -> 0x0099 }
            int r10 = r10 + 1
            goto L_0x003d
        L_0x005d:
            java.lang.String r9 = r2.readLine()     // Catch:{ IOException -> 0x0099 }
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0099 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0099 }
            r11.<init>()     // Catch:{ IOException -> 0x0099 }
            java.lang.String r12 = "getCpuType()str2"
            r11.append(r12)     // Catch:{ IOException -> 0x0099 }
            r11.append(r9)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0099 }
            r10[r6] = r11     // Catch:{ IOException -> 0x0099 }
            com.baidu.pass.biometrics.base.debug.Log.d(r1, r10)     // Catch:{ IOException -> 0x0099 }
            java.lang.String[] r0 = r9.split(r0)     // Catch:{ IOException -> 0x0099 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0099 }
            r9.<init>()     // Catch:{ IOException -> 0x0099 }
            r10 = r3[r5]     // Catch:{ IOException -> 0x0099 }
            r9.append(r10)     // Catch:{ IOException -> 0x0099 }
            r0 = r0[r8]     // Catch:{ IOException -> 0x0099 }
            r9.append(r0)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r0 = r9.toString()     // Catch:{ IOException -> 0x0099 }
            r3[r5] = r0     // Catch:{ IOException -> 0x0099 }
            r7.close()     // Catch:{ IOException -> 0x00b3 }
        L_0x0095:
            r2.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00bb
        L_0x0099:
            r0 = move-exception
            goto L_0x00aa
        L_0x009b:
            r0 = move-exception
        L_0x009c:
            r1 = r4
            r4 = r7
            goto L_0x0187
        L_0x00a0:
            r0 = move-exception
            r2 = r4
            goto L_0x00aa
        L_0x00a3:
            r0 = move-exception
            r1 = r4
            goto L_0x0187
        L_0x00a7:
            r0 = move-exception
            r2 = r4
            r7 = r2
        L_0x00aa:
            r0.printStackTrace()     // Catch:{ all -> 0x0183 }
            if (r7 == 0) goto L_0x00b5
            r7.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b5
        L_0x00b3:
            r0 = move-exception
            goto L_0x00b8
        L_0x00b5:
            if (r2 == 0) goto L_0x00bb
            goto L_0x0095
        L_0x00b8:
            r0.printStackTrace()
        L_0x00bb:
            java.lang.String r0 = android.os.Build.CPU_ABI
            java.lang.Class<android.os.Build> r2 = android.os.Build.class
            java.lang.String r7 = "cpuAbi2"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r7)     // Catch:{ Exception -> 0x00cc }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00cc }
            goto L_0x00e7
        L_0x00cc:
            r2 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r7 = "getCpuType() abi2"
            java.lang.StringBuilder r7 = e.a.a.a.a.a(r7)
            java.lang.String r2 = r2.toString()
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r4[r6] = r2
            com.baidu.pass.biometrics.base.debug.Log.w(r1, r4)
            java.lang.String r2 = "none"
        L_0x00e7:
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r7 = "getCpuType()"
            java.lang.StringBuilder r7 = e.a.a.a.a.a(r7)
            r8 = r3[r6]
            r7.append(r8)
            r5 = r3[r5]
            r7.append(r5)
            r7.append(r0)
            r7.append(r2)
            java.lang.String r5 = r7.toString()
            r4[r6] = r5
            com.baidu.pass.biometrics.base.debug.Log.i(r1, r4)
            java.lang.String r1 = "armeabi"
            boolean r4 = r0.equals(r1)
            if (r4 != 0) goto L_0x0182
            boolean r4 = r2.equals(r1)
            if (r4 == 0) goto L_0x0117
            goto L_0x0182
        L_0x0117:
            java.lang.String r4 = "armeabi-v7a"
            boolean r5 = r0.equals(r4)
            if (r5 != 0) goto L_0x0181
            boolean r5 = r2.equals(r4)
            if (r5 == 0) goto L_0x0126
            goto L_0x0181
        L_0x0126:
            java.lang.String r5 = "arm64-v8a"
            boolean r7 = r0.equals(r5)
            if (r7 != 0) goto L_0x0180
            boolean r7 = r2.equals(r5)
            if (r7 == 0) goto L_0x0135
            goto L_0x0180
        L_0x0135:
            java.lang.String r7 = "x86"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x017f
            boolean r0 = r2.equals(r7)
            if (r0 == 0) goto L_0x0144
            goto L_0x017f
        L_0x0144:
            r0 = r3[r6]
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r2 = "armv7"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0153
            return r4
        L_0x0153:
            r0 = r3[r6]
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r2 = "arm"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0162
            return r1
        L_0x0162:
            r0 = r3[r6]
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r2 = "arm64"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0171
            return r5
        L_0x0171:
            r0 = r3[r6]
            java.lang.String r0 = r0.toLowerCase()
            boolean r0 = r0.contains(r7)
            if (r0 == 0) goto L_0x017e
            return r7
        L_0x017e:
            return r1
        L_0x017f:
            return r7
        L_0x0180:
            return r5
        L_0x0181:
            return r4
        L_0x0182:
            return r1
        L_0x0183:
            r0 = move-exception
            r4 = r2
            goto L_0x009c
        L_0x0187:
            if (r4 == 0) goto L_0x018f
            r4.close()     // Catch:{ IOException -> 0x018d }
            goto L_0x018f
        L_0x018d:
            r1 = move-exception
            goto L_0x0195
        L_0x018f:
            if (r1 == 0) goto L_0x0198
            r1.close()     // Catch:{ IOException -> 0x018d }
            goto L_0x0198
        L_0x0195:
            r1.printStackTrace()
        L_0x0198:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.base.utils.PassBiometricUtil.getCpuType():java.lang.String");
    }

    public static Rect getCurrentFaceRect(int[] iArr) {
        Point point = new Point();
        Point point2 = new Point();
        if (iArr.length > 2) {
            point.x = iArr[0];
            point.y = iArr[1];
            point2.x = iArr[0];
            point2.y = iArr[1];
        }
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i3 = i2 << 1;
            float f2 = (float) iArr[i3];
            float f3 = (float) iArr[i3 + 1];
            if (f2 < ((float) point.x)) {
                point.x = (int) f2;
            }
            if (f3 < ((float) point.y)) {
                point.y = (int) f3;
            }
            if (f2 > ((float) point2.x)) {
                point2.x = (int) f2;
            }
            if (f3 > ((float) point2.y)) {
                point2.y = (int) f3;
            }
        }
        return new Rect(point.x, point.y, point2.x, point2.y);
    }

    public static Rect getFaceInsideRoundRect(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return new Rect(0, 0, 0, 0);
        }
        int i2 = ((iArr[0] * 480) / STANDARD_BG_WIDTH) / 2;
        int i3 = ((iArr[1] * STANDARD_FACE_INSIDE_MAX_HEIGHT) / STANDARD_BG_HEIGHT) / 2;
        Point point = new Point();
        point.set(iArr[0] / 2, (iArr[1] * STANDARD_FACE_MIDDLE_MARGIN_TOP) / STANDARD_BG_HEIGHT);
        int i4 = point.x;
        int i5 = i4 - i2;
        int i6 = point.y;
        return new Rect(i5, i6 - i3, i4 + i2, i6 + i3);
    }

    public static String getOSModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : LivenessStat.TYPE_STRING_DEFAULT;
    }

    public static String getOSVersion() {
        return !TextUtils.isEmpty(VERSION.RELEASE) ? VERSION.RELEASE : LivenessStat.TYPE_STRING_DEFAULT;
    }

    public static String getPackageSign(Context context, String str) {
        String str2 = "";
        if (context == null || TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures.length > 0) {
                return Utils.a(packageInfo.signatures[0].toByteArray(), false);
            }
            return str2;
        } catch (Throwable th) {
            Log.e(th);
            return str2;
        }
    }

    public static String getUA(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("pass_bio");
        String str2 = "-p-";
        sb.append(str2);
        sb.append(SapiDeviceInfo.f3010c);
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append(getVersionCode(context));
        sb.append(str2);
        sb.append(PassBiometricDefaultFactory.VERSION_NAME);
        sb.append(str2);
        sb.append(getOSModel());
        sb.append(str2);
        sb.append(getOSVersion());
        return sb.toString();
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public static int getVersionCode(Context context) {
        int i2 = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i2).versionCode;
        } catch (Exception unused) {
            return i2;
        }
    }

    public static boolean isFaceInsideRound(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect currentFaceRect = getCurrentFaceRect(iArr);
        Rect faceInsideRoundRect = getFaceInsideRoundRect(iArr2);
        if (faceInsideRoundRect.bottom <= currentFaceRect.bottom || faceInsideRoundRect.top >= currentFaceRect.top) {
            return false;
        }
        return true;
    }

    public static boolean isTooFarFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 != null && iArr2.length == 2) {
            Rect currentFaceRect = getCurrentFaceRect(iArr);
            if (currentFaceRect.right - currentFaceRect.left < (iArr2[0] * STANDARD_MIN_FACE_WIDTH) / STANDARD_BG_WIDTH) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTooNearFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 != null && iArr2.length == 2) {
            Rect currentFaceRect = getCurrentFaceRect(iArr);
            if (currentFaceRect.right - currentFaceRect.left > (iArr2[0] * 480) / STANDARD_BG_WIDTH) {
                return true;
            }
        }
        return false;
    }
}
