package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SmsService;
import com.baidu.sapi2.callback.RequestSMSCallback;
import e.a.a.a.a;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SapiCoreUtil */
public class g {

    /* renamed from: a reason: collision with root package name */
    public static final String f3074a = "g";

    /* renamed from: b reason: collision with root package name */
    public static final String f3075b = "file:///android_asset/";

    @TargetApi(4)
    public static void a(Context context, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, RequestSMSCallback requestSMSCallback) {
        try {
            SmsService.sendSms(context, str2, str, pendingIntent, pendingIntent2, requestSMSCallback);
        } catch (Throwable unused) {
            requestSMSCallback.sendSmsResult(false);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("r", Integer.valueOf(4));
        hashMap.put(Config.DEVICE_WIDTH, Integer.valueOf(2));
        int i2 = 1;
        hashMap.put(Config.EVENT_HEAT_X, Integer.valueOf(1));
        hashMap.put("-", Integer.valueOf(0));
        String str2 = "";
        int i3 = 0;
        while (i2 < 10) {
            int i4 = i2 + 1;
            Integer num = (Integer) hashMap.get(str.substring(i2, i4));
            if (num == null) {
                return null;
            }
            int intValue = num.intValue() + i3;
            if (i2 % 3 == 0) {
                str2 = a.a(str2, intValue);
                i3 = 0;
            } else {
                i3 = intValue;
            }
            i2 = i4;
        }
        if (str2.length() != 3) {
            return null;
        }
        return str2;
    }

    public static void a(Context context, Handler handler, RequestSMSCallback requestSMSCallback) {
        try {
            SmsService.registerReceiver(context, handler, requestSMSCallback);
        } catch (Throwable unused) {
            requestSMSCallback.receiverResult(null);
        }
    }

    public static InputStream a(Context context, String str) {
        String str2 = f3075b;
        try {
            if (!str.startsWith(str2)) {
                return new FileInputStream(str);
            }
            return context.getAssets().open(str.replace(str2, ""));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v4, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r6v9, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v6
  assigns: []
  uses: []
  mth insns count: 106
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 12 */
    @android.annotation.TargetApi(4)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r10, java.io.File r11) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = -1
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00e8, all -> 0x00e6 }
            java.lang.String r5 = r10.getPackageName()     // Catch:{ Exception -> 0x00e8, all -> 0x00e6 }
            r6 = r1
        L_0x000d:
            java.lang.String r7 = r11.getName()     // Catch:{ Exception -> 0x00e3 }
            boolean r7 = r5.equals(r7)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r8 = "chmod 701 "
            if (r7 != 0) goto L_0x0050
            boolean r7 = r11.isDirectory()     // Catch:{ Exception -> 0x00e3 }
            if (r7 == 0) goto L_0x0033
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
            r7.<init>()     // Catch:{ Exception -> 0x00e3 }
            r7.append(r8)     // Catch:{ Exception -> 0x00e3 }
            r7.append(r11)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00e3 }
            java.lang.Process r6 = r4.exec(r7)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x0048
        L_0x0033:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
            r7.<init>()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r8 = "chmod 664 "
            r7.append(r8)     // Catch:{ Exception -> 0x00e3 }
            r7.append(r11)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00e3 }
            java.lang.Process r6 = r4.exec(r7)     // Catch:{ Exception -> 0x00e3 }
        L_0x0048:
            java.io.File r11 = r11.getParentFile()     // Catch:{ Exception -> 0x004d }
            goto L_0x000d
        L_0x004d:
            r10 = move-exception
            goto L_0x00ea
        L_0x0050:
            android.content.pm.ApplicationInfo r10 = r10.getApplicationInfo()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r10 = r10.dataDir     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r10 = a(r10)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r10 = b(r10)     // Catch:{ Exception -> 0x00e3 }
            boolean r5 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00e3 }
            r7 = 3
            r9 = 2
            if (r5 == 0) goto L_0x0078
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
            r10.<init>()     // Catch:{ Exception -> 0x00e3 }
            r10.append(r8)     // Catch:{ Exception -> 0x00e3 }
            r10.append(r11)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r1 = r10.toString()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r10 = "701"
            goto L_0x00a1
        L_0x0078:
            java.lang.String r5 = r10.substring(r9, r7)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r8 = "0"
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x00e3 }
            if (r5 == 0) goto L_0x00a1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
            r1.<init>()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r5 = "chmod "
            r1.append(r5)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r5 = r10.substring(r2, r9)     // Catch:{ Exception -> 0x00e3 }
            r1.append(r5)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r5 = "1 "
            r1.append(r5)     // Catch:{ Exception -> 0x00e3 }
            r1.append(r11)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00e3 }
        L_0x00a1:
            java.lang.String r11 = f3074a     // Catch:{ Exception -> 0x00e3 }
            r5 = 5
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r8 = "chmodFile"
            r5[r2] = r8     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r8 = "command"
            r5[r0] = r8     // Catch:{ Exception -> 0x00e3 }
            r5[r9] = r1     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r8 = "originPer"
            r5[r7] = r8     // Catch:{ Exception -> 0x00e3 }
            r7 = 4
            r5[r7] = r10     // Catch:{ Exception -> 0x00e3 }
            com.baidu.sapi2.utils.Log.e(r11, r5)     // Catch:{ Exception -> 0x00e3 }
            if (r1 == 0) goto L_0x00d5
            java.lang.Process r6 = r4.exec(r1)     // Catch:{ Exception -> 0x00e3 }
            com.baidu.sapi2.SapiContext r11 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x004d }
            java.lang.String r11 = r11.getPackageDirExecutePer()     // Catch:{ Exception -> 0x004d }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x004d }
            if (r11 == 0) goto L_0x00d5
            com.baidu.sapi2.SapiContext r11 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x004d }
            r11.setPackageDirExecutePer(r10)     // Catch:{ Exception -> 0x004d }
        L_0x00d5:
            if (r6 == 0) goto L_0x00db
            int r3 = r6.waitFor()     // Catch:{ Exception -> 0x004d }
        L_0x00db:
            if (r6 == 0) goto L_0x00f2
            r6.destroy()
            goto L_0x00f2
        L_0x00e1:
            r10 = move-exception
            goto L_0x00f7
        L_0x00e3:
            r10 = move-exception
            r1 = r6
            goto L_0x00e9
        L_0x00e6:
            r10 = move-exception
            goto L_0x00f8
        L_0x00e8:
            r10 = move-exception
        L_0x00e9:
            r6 = r1
        L_0x00ea:
            com.baidu.sapi2.utils.Log.e(r10)     // Catch:{ all -> 0x00e1 }
            if (r6 == 0) goto L_0x00f2
            r6.destroy()
        L_0x00f2:
            if (r3 != 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r0 = r2
        L_0x00f6:
            return r0
        L_0x00f7:
            r1 = r6
        L_0x00f8:
            if (r1 == 0) goto L_0x00fd
            r1.destroy()
        L_0x00fd:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.g.a(android.content.Context, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x01ce, code lost:
        if ("business_from_one_key_login".equals(r7) != false) goto L_0x01d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.sapi2.shell.response.SapiAccountResponse b(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "<client>([\\S\\s]*?)</client>"
            java.lang.String r8 = a(r0, r8)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            r0 = 0
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch:{ all -> 0x0220 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0220 }
            byte[] r8 = r8.getBytes()     // Catch:{ all -> 0x0220 }
            r3.<init>(r8)     // Catch:{ all -> 0x0220 }
            java.lang.String r8 = "UTF-8"
            r2.setInput(r3, r8)     // Catch:{ all -> 0x0220 }
            int r8 = r2.getEventType()     // Catch:{ all -> 0x0220 }
            r3 = r0
        L_0x0026:
            r4 = 1
            if (r8 == r4) goto L_0x0224
            r5 = 2
            if (r8 == r5) goto L_0x002e
            goto L_0x0216
        L_0x002e:
            java.lang.String r8 = r2.getName()     // Catch:{ all -> 0x0220 }
            java.lang.String r5 = "data"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0044
            if (r1 != 0) goto L_0x0216
            com.baidu.sapi2.shell.response.SapiAccountResponse r8 = new com.baidu.sapi2.shell.response.SapiAccountResponse     // Catch:{ all -> 0x0220 }
            r8.<init>()     // Catch:{ all -> 0x0220 }
        L_0x0041:
            r1 = r8
            goto L_0x0216
        L_0x0044:
            if (r1 != 0) goto L_0x0061
            java.lang.String r5 = "error_code"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0061
            com.baidu.sapi2.shell.response.SapiAccountResponse r8 = new com.baidu.sapi2.shell.response.SapiAccountResponse     // Catch:{ all -> 0x0220 }
            r8.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = r2.nextText()     // Catch:{ all -> 0x005e }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x005e }
            r8.errorCode = r1     // Catch:{ all -> 0x005e }
            goto L_0x0041
        L_0x005e:
            r7 = move-exception
            goto L_0x021e
        L_0x0061:
            if (r1 != 0) goto L_0x0077
            java.lang.String r5 = "error_description"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0077
            com.baidu.sapi2.shell.response.SapiAccountResponse r8 = new com.baidu.sapi2.shell.response.SapiAccountResponse     // Catch:{ all -> 0x0220 }
            r8.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = r2.nextText()     // Catch:{ all -> 0x005e }
            r8.errorMsg = r1     // Catch:{ all -> 0x005e }
            goto L_0x0041
        L_0x0077:
            if (r1 == 0) goto L_0x0216
            java.lang.String r5 = "errno"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x008d
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0220 }
            r1.errorCode = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x008d:
            java.lang.String r5 = "uname"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x009d
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.username = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x009d:
            java.lang.String r5 = "errmsg"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x00ad
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.errorMsg = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x00ad:
            java.lang.String r5 = "bduss"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x00bd
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.bduss = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x00bd:
            java.lang.String r5 = "ptoken"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x00cd
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.ptoken = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x00cd:
            java.lang.String r5 = "stoken"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x00f9
            if (r3 != r4) goto L_0x00f1
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            java.lang.String r5 = "#"
            java.lang.String[] r8 = r8.split(r5)     // Catch:{ all -> 0x0220 }
            if (r8 == 0) goto L_0x0216
            int r5 = r8.length     // Catch:{ all -> 0x0220 }
            if (r5 <= r4) goto L_0x0216
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.tplStokenMap     // Catch:{ all -> 0x0220 }
            r6 = r8[r0]     // Catch:{ all -> 0x0220 }
            r8 = r8[r4]     // Catch:{ all -> 0x0220 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x00f1:
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.stoken = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x00f9:
            java.lang.String r5 = "displayname"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0109
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.displayname = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x0109:
            java.lang.String r5 = "uid"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0119
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.uid = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x0119:
            java.lang.String r5 = "authsid"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0130
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.authSid = r8     // Catch:{ all -> 0x0220 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0220 }
            r8 = r8 ^ r4
            r1.newReg = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x0130:
            java.lang.String r5 = "stoken_list"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x013b
            r3 = r4
            goto L_0x0216
        L_0x013b:
            java.lang.String r4 = "os_headurl"
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x014b
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.socialPortraitUrl = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x014b:
            java.lang.String r4 = "os_type"
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x0163
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0220 }
            com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.getSocialType(r8)     // Catch:{ all -> 0x0220 }
            r1.socialType = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x0163:
            java.lang.String r4 = "incomplete_user"
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x0191
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "0"
            boolean r4 = r4.equals(r8)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x017d
            com.baidu.sapi2.utils.enums.AccountType r8 = com.baidu.sapi2.utils.enums.AccountType.NORMAL     // Catch:{ all -> 0x0220 }
            r1.accountType = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x017d:
            java.lang.String r4 = "1"
            boolean r8 = r4.equals(r8)     // Catch:{ all -> 0x0220 }
            if (r8 == 0) goto L_0x018b
            com.baidu.sapi2.utils.enums.AccountType r8 = com.baidu.sapi2.utils.enums.AccountType.INCOMPLETE_USER     // Catch:{ all -> 0x0220 }
            r1.accountType = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x018b:
            com.baidu.sapi2.utils.enums.AccountType r8 = com.baidu.sapi2.utils.enums.AccountType.UNKNOWN     // Catch:{ all -> 0x0220 }
            r1.accountType = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x0191:
            java.lang.String r4 = "actiontype"
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x01a1
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.actionType = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x01a1:
            java.lang.String r4 = "livinguname"
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x01b4
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            java.lang.String r8 = java.net.URLDecoder.decode(r8)     // Catch:{ all -> 0x0220 }
            r1.livingUname = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x01b4:
            java.lang.String r4 = "loginType"
            boolean r4 = r4.equals(r8)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x01e3
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "oneKeyLogin"
            boolean r4 = r4.equals(r8)     // Catch:{ all -> 0x0220 }
            if (r4 != 0) goto L_0x01d0
            java.lang.String r4 = "business_from_one_key_login"
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x01d9
        L_0x01d0:
            com.baidu.sapi2.outsdk.c r8 = new com.baidu.sapi2.outsdk.c     // Catch:{ all -> 0x0220 }
            r8.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r8 = r8.c()     // Catch:{ all -> 0x0220 }
        L_0x01d9:
            com.baidu.sapi2.SapiContext r4 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ all -> 0x0220 }
            java.lang.String r5 = "pre_login_type"
            r4.put(r5, r8)     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x01e3:
            java.lang.String r4 = "mobilephone"
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x01f9
            com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "last_login_phone"
            java.lang.String r5 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r8.putEncryptStr(r4, r5)     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x01f9:
            java.lang.String r4 = "app"
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x0208
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.app = r8     // Catch:{ all -> 0x0220 }
            goto L_0x0216
        L_0x0208:
            java.lang.String r4 = "extra"
            boolean r8 = r8.equals(r4)     // Catch:{ all -> 0x0220 }
            if (r8 == 0) goto L_0x0216
            java.lang.String r8 = r2.nextText()     // Catch:{ all -> 0x0220 }
            r1.extra = r8     // Catch:{ all -> 0x0220 }
        L_0x0216:
            int r8 = r2.next()     // Catch:{ all -> 0x021c }
            goto L_0x0026
        L_0x021c:
            r7 = move-exception
            r8 = r1
        L_0x021e:
            r1 = r8
            goto L_0x0221
        L_0x0220:
            r7 = move-exception
        L_0x0221:
            com.baidu.sapi2.utils.Log.e(r7)
        L_0x0224:
            if (r1 == 0) goto L_0x0236
            java.lang.String r7 = r1.bduss
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0236
            int r7 = r1.errorCode
            r8 = -100
            if (r7 != r8) goto L_0x0236
            r1.errorCode = r0
        L_0x0236:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.g.b(java.lang.String, java.lang.String):com.baidu.sapi2.shell.response.SapiAccountResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044 A[SYNTHETIC, Splitter:B:24:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0051 A[SYNTHETIC, Splitter:B:34:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            r2.<init>()     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            java.lang.String r3 = "ls -ld "
            r2.append(r3)     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            r2.append(r5)     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ IOException -> 0x004d, all -> 0x0040 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003e, all -> 0x0039 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003e, all -> 0x0039 }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ IOException -> 0x003e, all -> 0x0039 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x003e, all -> 0x0039 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003e, all -> 0x0039 }
            java.lang.String r0 = r1.readLine()     // Catch:{ IOException -> 0x004f, all -> 0x0033 }
            r1.close()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            r5.destroy()
            return r0
        L_0x0033:
            r0 = move-exception
            r4 = r1
            r1 = r5
            r5 = r0
            r0 = r4
            goto L_0x0042
        L_0x0039:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
            goto L_0x0042
        L_0x003e:
            r1 = r0
            goto L_0x004f
        L_0x0040:
            r5 = move-exception
            r1 = r0
        L_0x0042:
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.destroy()
        L_0x004c:
            throw r5
        L_0x004d:
            r5 = r0
            r1 = r5
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            if (r5 == 0) goto L_0x0059
            r5.destroy()
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.g.a(java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2) {
        Pattern compile = Pattern.compile(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        Matcher matcher = compile.matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }

    public static void a(String str, String str2, String str3, Context context, com.baidu.sapi2.callback.a.a aVar) {
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta charset=\"utf-8\"><script> ");
        sb.append(str);
        sb.append(str2);
        sb.append(" </script></head></html>");
        WebView webView2 = webView;
        webView2.loadDataWithBaseURL("", sb.toString(), SapiWebView.f2394i, "UTF-8", "");
        webView.setWebViewClient(new f(webView, a.a("javascript:moonshade(", str3, ")"), aVar));
    }
}
