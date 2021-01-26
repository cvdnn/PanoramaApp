package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bt.a;
import com.sina.weibo.sdk.constant.WBConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

public class bg {

    /* renamed from: a reason: collision with root package name */
    public static volatile boolean f1725a;

    /* renamed from: b reason: collision with root package name */
    public static volatile boolean f1726b;

    /* renamed from: c reason: collision with root package name */
    public static volatile boolean f1727c;

    public static String a() {
        return "https://dxp.baidu.com/vizParser";
    }

    public static boolean a(int i2) {
        if (i2 == 0) {
            return f1725a;
        }
        if (i2 == 1) {
            return f1726b;
        }
        if (i2 != 2) {
            return false;
        }
        return f1727c;
    }

    public static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? "" : "mtj_auto.config" : "mtj_autoTracker.js" : "mtj_vizParser.js";
    }

    public static void a(int i2, boolean z) {
        if (i2 == 0) {
            f1725a = z;
        } else if (i2 == 1) {
            f1726b = z;
        } else if (i2 == 2) {
            f1727c = z;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:30|31|32|(3:34|35|36)|37|38|(1:41)|42|(1:44)|45|(4:(2:48|(1:50)(1:51))(1:52)|(3:54|55|56)|59|60)(1:61)) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0121, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012d, code lost:
        if (r4 != null) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012f, code lost:
        r4.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0132, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0134, code lost:
        if (r4 != null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0138, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0089 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[Catch:{ Exception -> 0x0133, all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb A[Catch:{ Exception -> 0x0133, all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012c A[Catch:{ Exception -> 0x0134, all -> 0x012c }, ExcHandler: all (r10v2 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{  }]), PHI: r4 
  PHI: (r4v4 java.net.HttpURLConnection) = (r4v1 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection) binds: [B:30:0x0070, B:31:?, B:37:0x0089, B:59:0x0123, B:60:?, B:55:0x011d, B:56:?, B:35:0x007d] A[DONT_GENERATE, DONT_INLINE], Splitter:B:37:0x0089] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r10, java.lang.String r11, int r12, boolean r13) {
        /*
            java.lang.Class<com.baidu.mobstat.bg> r0 = com.baidu.mobstat.bg.class
            monitor-enter(r0)
            boolean r1 = a(r12)     // Catch:{ all -> 0x0139 }
            r2 = 1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            r1 = 0
            if (r10 != 0) goto L_0x0011
            monitor-exit(r0)
            return r1
        L_0x0011:
            java.lang.String r11 = a(r10, r11, r12)     // Catch:{ all -> 0x0139 }
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0139 }
            if (r3 == 0) goto L_0x001d
            monitor-exit(r0)
            return r1
        L_0x001d:
            com.baidu.mobstat.bd r3 = com.baidu.mobstat.bd.c()     // Catch:{ all -> 0x0139 }
            boolean r3 = r3.b()     // Catch:{ all -> 0x0139 }
            if (r3 == 0) goto L_0x0041
            if (r13 == 0) goto L_0x0041
            com.baidu.mobstat.bd r3 = com.baidu.mobstat.bd.c()     // Catch:{ all -> 0x0139 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0139 }
            r4.<init>()     // Catch:{ all -> 0x0139 }
            java.lang.String r5 = "requestUrl:"
            r4.append(r5)     // Catch:{ all -> 0x0139 }
            r4.append(r11)     // Catch:{ all -> 0x0139 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0139 }
            r3.a(r4)     // Catch:{ all -> 0x0139 }
        L_0x0041:
            com.baidu.mobstat.bh r3 = com.baidu.mobstat.bh.c()     // Catch:{ all -> 0x0139 }
            boolean r3 = r3.b()     // Catch:{ all -> 0x0139 }
            if (r3 == 0) goto L_0x0063
            com.baidu.mobstat.bh r3 = com.baidu.mobstat.bh.c()     // Catch:{ all -> 0x0139 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0139 }
            r4.<init>()     // Catch:{ all -> 0x0139 }
            java.lang.String r5 = "requestUrl:"
            r4.append(r5)     // Catch:{ all -> 0x0139 }
            r4.append(r11)     // Catch:{ all -> 0x0139 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0139 }
            r3.a(r4)     // Catch:{ all -> 0x0139 }
        L_0x0063:
            java.lang.String r3 = b(r12)     // Catch:{ all -> 0x0139 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0139 }
            if (r4 == 0) goto L_0x006f
            monitor-exit(r0)
            return r1
        L_0x006f:
            r4 = 0
            java.net.HttpURLConnection r4 = com.baidu.mobstat.bo.d(r10, r11)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r4.connect()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r5 = 0
            if (r12 != r2) goto L_0x0089
            java.lang.String r11 = "X-INTERVAL"
            java.lang.String r11 = r4.getHeaderField(r11)     // Catch:{ Exception -> 0x0089, all -> 0x012c }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0089, all -> 0x012c }
            long r5 = r11.longValue()     // Catch:{ Exception -> 0x0089, all -> 0x012c }
        L_0x0089:
            int r11 = r4.getResponseCode()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            int r7 = r4.getContentLength()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            com.baidu.mobstat.bd r8 = com.baidu.mobstat.bd.c()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            boolean r8 = r8.b()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            if (r8 == 0) goto L_0x00bd
            if (r13 == 0) goto L_0x00bd
            com.baidu.mobstat.bd r13 = com.baidu.mobstat.bd.c()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r8.<init>()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.String r9 = "contentLength:"
            r8.append(r9)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r8.append(r7)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.String r9 = " fileName:"
            r8.append(r9)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r8.append(r3)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r13.a(r8)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
        L_0x00bd:
            com.baidu.mobstat.bh r13 = com.baidu.mobstat.bh.c()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            boolean r13 = r13.b()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            if (r13 == 0) goto L_0x00e7
            com.baidu.mobstat.bh r13 = com.baidu.mobstat.bh.c()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r8.<init>()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.String r9 = "contentLength:"
            r8.append(r9)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r8.append(r7)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.String r9 = " fileName:"
            r8.append(r9)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r8.append(r3)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r13.a(r8)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
        L_0x00e7:
            r13 = 200(0xc8, float:2.8E-43)
            if (r11 != r13) goto L_0x0127
            if (r12 == r2) goto L_0x00fd
            r11 = 2
            if (r12 == r11) goto L_0x00f1
            goto L_0x010f
        L_0x00f1:
            com.baidu.mobstat.bq r11 = com.baidu.mobstat.bq.a()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r11.c(r10, r5)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            goto L_0x010f
        L_0x00fd:
            com.baidu.mobstat.bq r11 = com.baidu.mobstat.bq.a()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r11.a(r10, r8)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            com.baidu.mobstat.bq r11 = com.baidu.mobstat.bq.a()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            r11.b(r10, r5)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
        L_0x010f:
            if (r7 <= 0) goto L_0x0123
            java.io.FileOutputStream r10 = r10.openFileOutput(r3, r1)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            java.io.InputStream r11 = r4.getInputStream()     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            boolean r11 = com.baidu.mobstat.bu.a(r11, r10)     // Catch:{ Exception -> 0x0133, all -> 0x012c }
            com.baidu.mobstat.bu.a(r10)     // Catch:{ Exception -> 0x0121, all -> 0x012c }
            goto L_0x0123
        L_0x0121:
            r2 = r11
            goto L_0x0134
        L_0x0123:
            a(r12, r2)     // Catch:{ Exception -> 0x0134, all -> 0x012c }
            goto L_0x0128
        L_0x0127:
            r2 = r1
        L_0x0128:
            r4.disconnect()     // Catch:{ all -> 0x0139 }
            goto L_0x0137
        L_0x012c:
            r10 = move-exception
            if (r4 == 0) goto L_0x0132
            r4.disconnect()     // Catch:{ all -> 0x0139 }
        L_0x0132:
            throw r10     // Catch:{ all -> 0x0139 }
        L_0x0133:
            r2 = r1
        L_0x0134:
            if (r4 == 0) goto L_0x0137
            goto L_0x0128
        L_0x0137:
            monitor-exit(r0)
            return r2
        L_0x0139:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bg.a(android.content.Context, java.lang.String, int, boolean):boolean");
    }

    public static String a(Context context, String str, int i2) {
        if (i2 == 0) {
            return a();
        }
        if (i2 != 1) {
            return i2 != 2 ? "" : a(context, str);
        }
        return a(context);
    }

    public static String a(Context context) {
        String str = "UTF-8";
        String a2 = bo.a(context, "mtj_autoTracker.js");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = a.a(a2.getBytes());
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(new Pair("sign", a3));
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), str);
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), str);
                String str2 = "=";
                if (TextUtils.isEmpty(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(encode);
                    sb2.append(str2);
                    sb2.append(encode2);
                    sb.append(sb2.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("&");
                    sb3.append(encode);
                    sb3.append(str2);
                    sb3.append(encode2);
                    sb.append(sb3.toString());
                }
            } catch (Exception unused) {
            }
        }
        String sb4 = sb.toString();
        String str3 = "https://dxp.baidu.com/autoTracker";
        return !TextUtils.isEmpty(sb4) ? e.a.a.a.a.a(str3, "?", sb4) : str3;
    }

    public static String a(Context context, String str) {
        String str2 = "UTF-8";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("sdkVersion", StatService.getSdkVersion()));
        String str3 = "";
        arrayList.add(new Pair(WBConstants.SSO_APP_KEY, e.a.a.a.a.a(str3, str)));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("imei", CooperService.instance().getDevicImei(context)));
        arrayList.add(new Pair("platform", "Android"));
        arrayList.add(new Pair("model", Build.MODEL));
        arrayList.add(new Pair("s", e.a.a.a.a.a(new StringBuilder(), VERSION.SDK_INT, str3)));
        arrayList.add(new Pair(Config.OS, VERSION.RELEASE));
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), str2);
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), str2);
                String str4 = "=";
                if (TextUtils.isEmpty(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(encode);
                    sb2.append(str4);
                    sb2.append(encode2);
                    sb.append(sb2.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("&");
                    sb3.append(encode);
                    sb3.append(str4);
                    sb3.append(encode2);
                    sb.append(sb3.toString());
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder a2 = e.a.a.a.a.a("https://dxp.baidu.com/circleConfig?");
        a2.append(sb.toString());
        return a2.toString();
    }
}
