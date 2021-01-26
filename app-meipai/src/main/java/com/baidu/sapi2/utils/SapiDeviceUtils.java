package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.ServiceManager;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Collections;

public class SapiDeviceUtils {

    public static class DeviceCrypto implements NoProguard {
        public static String base64Encode(byte[] bArr) {
            int i2;
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
            int length = bArr.length * 8;
            int i3 = 6;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            do {
                if (i4 > 0 && i3 > 0) {
                    int i8 = (bArr[i5] & 255) << i3;
                    int i9 = 8 - i3;
                    i7 = (byte) (((byte) (i8 | ((bArr[i5 + 1] & 255) >> i9))) & 63);
                    int i10 = i9;
                    i3 = 6 - i9;
                    i4 = i10;
                } else if (i4 == 0) {
                    i7 = (byte) ((bArr[i5] & 255) >> (8 - i3));
                    i4 = 2;
                    i3 = 4;
                } else if (i3 == 0) {
                    i7 = (byte) (bArr[i5] & 63);
                    i3 = 6;
                    i4 = 0;
                }
                sb.append(str.charAt(i7));
                i6 += 6;
                i5 = i6 / 8;
                i2 = length - i6;
            } while (i2 >= 6);
            if (i2 > 0) {
                sb.append(str.charAt((byte) ((bArr[bArr.length - 1] << (6 - i2)) & 63)));
            }
            int i11 = length % 3;
            for (int i12 = 0; i12 < i11; i12++) {
                sb.append("=");
            }
            return sb.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6) {
        /*
            java.lang.String r0 = "SAPI"
            r1 = 0
            if (r6 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r6 = 0
            r2 = 1
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = "/system/etc/hosts"
            r3.<init>(r4)     // Catch:{ all -> 0x0052 }
            int r6 = r3.available()     // Catch:{ all -> 0x004d }
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x004d }
            r3.read(r6)     // Catch:{ all -> 0x004d }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x004d }
            r4.<init>(r6)     // Catch:{ all -> 0x004d }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x004d }
            if (r6 != 0) goto L_0x003c
            java.lang.String r6 = "passport.baidu.com"
            boolean r6 = r4.contains(r6)     // Catch:{ all -> 0x004d }
            if (r6 == 0) goto L_0x003c
            r3.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x003b
        L_0x002f:
            r6 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r3[r1] = r6
            com.baidu.sapi2.utils.Log.e(r0, r3)
        L_0x003b:
            return r2
        L_0x003c:
            r3.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x004c
        L_0x0040:
            r6 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r2[r1] = r6
            com.baidu.sapi2.utils.Log.e(r0, r2)
        L_0x004c:
            return r1
        L_0x004d:
            r6 = move-exception
            r5 = r3
            r3 = r6
            r6 = r5
            goto L_0x0053
        L_0x0052:
            r3 = move-exception
        L_0x0053:
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0071 }
            r4[r1] = r3     // Catch:{ all -> 0x0071 }
            com.baidu.sapi2.utils.Log.e(r0, r4)     // Catch:{ all -> 0x0071 }
            if (r6 == 0) goto L_0x0070
            r6.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0070
        L_0x0064:
            r6 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r2[r1] = r6
            com.baidu.sapi2.utils.Log.e(r0, r2)
        L_0x0070:
            return r1
        L_0x0071:
            r3 = move-exception
            if (r6 == 0) goto L_0x0084
            r6.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x0084
        L_0x0078:
            r6 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r2[r1] = r6
            com.baidu.sapi2.utils.Log.e(r0, r2)
        L_0x0084:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.SapiDeviceUtils.a(android.content.Context):boolean");
    }

    public static String b(Context context) {
        String str = "";
        try {
            if (!ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                return str;
            }
            String deviceId = ((TelephonyManager) context.getSystemService(SapiAccount.f2185e)).getDeviceId();
            if (deviceId != null) {
                str = deviceId;
            }
            return str;
        } catch (Exception unused) {
        }
    }

    public static String c(Context context) {
        String str = Config.DEF_MAC_ID;
        try {
            if (!ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                return str;
            }
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(valueOf)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString().toLowerCase();
                }
            }
            return str;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public static String b() {
        String str = "";
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? str : Build.BRAND, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a() {
        String str = "";
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? str : Build.MODEL, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
