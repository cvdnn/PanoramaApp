package com.baidu.sapi2.outsdk;

import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c.a;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class ChinaTelecomSdkWrap {

    /* renamed from: a reason: collision with root package name */
    public static final int f2787a = 30000;

    /* renamed from: b reason: collision with root package name */
    public static final int f2788b = 15000;

    /* renamed from: c reason: collision with root package name */
    public static final int f2789c = 15000;

    /* renamed from: d reason: collision with root package name */
    public static String f2790d;

    public interface PreLoginCallback {
        void onError(int i2);

        void onSuccess();
    }

    public void a(SapiConfiguration sapiConfiguration, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Log.i(c.f2814a, "in china telecom login pre get phone info");
        CtAuth.getInstance().init(sapiConfiguration.context, sapiConfiguration.chinaTelecomAppKey, sapiConfiguration.chinaTelecomAppSecret, null);
        f2790d = str2;
        a(str, str2, (PreLoginCallback) null, oneKeyLoginCallback);
    }

    public void a(final SapiConfiguration sapiConfiguration, final a aVar) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > SapiContext.getInstance().getLong("china_telecom_expired_time", currentTimeMillis)) {
            a(c.k, f2790d, (PreLoginCallback) new PreLoginCallback() {
                public void onError(int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                        jSONObject.put("code", i2);
                        jSONObject.put("msg", "request pre login error");
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    aVar.onGetTokenComplete(jSONObject);
                }

                public void onSuccess() {
                    ChinaTelecomSdkWrap.this.a(sapiConfiguration, c.q, aVar);
                }
            }, (OneKeyLoginCallback) null);
            return;
        }
        a(sapiConfiguration, c.q, aVar);
    }

    private void a(String str, String str2, PreLoginCallback preLoginCallback, OneKeyLoginCallback oneKeyLoginCallback) {
        CtSetting ctSetting = new CtSetting(15000, 15000, 30000);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        CtAuth instance = CtAuth.getInstance();
        final PreLoginCallback preLoginCallback2 = preLoginCallback;
        final OneKeyLoginCallback oneKeyLoginCallback2 = oneKeyLoginCallback;
        final String str3 = str;
        final String str4 = str2;
        AnonymousClass2 r5 = new ResultListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e1, code lost:
                r10 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e2, code lost:
                r4 = r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e4, code lost:
                r10 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e5, code lost:
                r3 = com.baidu.pass.biometrics.face.liveness.stat.LivenessStat.TYPE_STRING_DEFAULT;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e8, code lost:
                r10 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e9, code lost:
                r3 = "-202";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
                com.baidu.sapi2.utils.Log.e(r10);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ee, code lost:
                com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(0, r3, r0, r11, r12);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f6, code lost:
                r10 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f7, code lost:
                com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(r4, r3, r0, r11, r12);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fe, code lost:
                throw r10;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x00e8 A[ExcHandler: Exception (r10v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0013] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResult(java.lang.String r10) {
                /*
                    r9 = this;
                    java.lang.String r0 = "CT"
                    r1 = 1
                    java.lang.Object[] r2 = new java.lang.Object[r1]
                    java.lang.String r3 = "requestPreLogin result = "
                    java.lang.String r3 = e.a.a.a.a.a(r3, r10)
                    r4 = 0
                    r2[r4] = r3
                    java.lang.String r3 = "OneKeyLogin"
                    com.baidu.sapi2.utils.Log.i(r3, r2)
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    r2.<init>(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    java.lang.String r10 = "result"
                    int r10 = r2.optInt(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    r3.<init>()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    r3.append(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    java.lang.String r5 = ""
                    r3.append(r5)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
                    r5 = 0
                    r6 = -101(0xffffffffffffff9b, float:NaN)
                    if (r10 == 0) goto L_0x004f
                    com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap$PreLoginCallback r1 = r7     // Catch:{ Exception -> 0x00e8 }
                    if (r1 == 0) goto L_0x003d
                    com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap$PreLoginCallback r1 = r7     // Catch:{ Exception -> 0x00e8 }
                    r1.onError(r10)     // Catch:{ Exception -> 0x00e8 }
                L_0x003d:
                    com.baidu.sapi2.outsdk.c r10 = new com.baidu.sapi2.outsdk.c     // Catch:{ Exception -> 0x00e8 }
                    r10.<init>()     // Catch:{ Exception -> 0x00e8 }
                    com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r8     // Catch:{ Exception -> 0x00e8 }
                    r10.b(r1, r6, r5)     // Catch:{ Exception -> 0x00e8 }
                    java.lang.String r10 = r11
                    java.lang.String r1 = r12
                    com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(r4, r3, r0, r10, r1)
                    return
                L_0x004f:
                    java.lang.String r10 = "data"
                    org.json.JSONObject r10 = r2.optJSONObject(r10)     // Catch:{ Exception -> 0x00e8 }
                    java.lang.String r2 = "operatorType"
                    java.lang.String r2 = r10.optString(r2)     // Catch:{ Exception -> 0x00e8 }
                    boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x00e8 }
                    if (r2 != 0) goto L_0x007e
                    com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap$PreLoginCallback r10 = r7     // Catch:{ Exception -> 0x00e8 }
                    if (r10 == 0) goto L_0x006c
                    com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap$PreLoginCallback r10 = r7     // Catch:{ Exception -> 0x00e8 }
                    r1 = -202(0xffffffffffffff36, float:NaN)
                    r10.onError(r1)     // Catch:{ Exception -> 0x00e8 }
                L_0x006c:
                    com.baidu.sapi2.outsdk.c r10 = new com.baidu.sapi2.outsdk.c     // Catch:{ Exception -> 0x00e8 }
                    r10.<init>()     // Catch:{ Exception -> 0x00e8 }
                    com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r8     // Catch:{ Exception -> 0x00e8 }
                    r10.b(r1, r6, r5)     // Catch:{ Exception -> 0x00e8 }
                    java.lang.String r10 = r11
                    java.lang.String r1 = r12
                    com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(r4, r3, r0, r10, r1)
                    return
                L_0x007e:
                    java.lang.String r2 = "accessCode"
                    java.lang.String r2 = r10.optString(r2)     // Catch:{ Exception -> 0x00e8 }
                    com.baidu.sapi2.outsdk.c.q = r2     // Catch:{ Exception -> 0x00e8 }
                    java.lang.String r2 = "number"
                    java.lang.String r2 = r10.optString(r2)     // Catch:{ Exception -> 0x00e8 }
                    com.baidu.sapi2.outsdk.c.p = r2     // Catch:{ Exception -> 0x00e8 }
                    java.lang.String r2 = com.baidu.sapi2.outsdk.c.q     // Catch:{ Exception -> 0x00e8 }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00e8 }
                    r1 = r1 ^ r2
                    java.lang.String r2 = com.baidu.sapi2.outsdk.c.p     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    if (r2 != 0) goto L_0x00b1
                    com.baidu.sapi2.callback.OneKeyLoginCallback r2 = r8     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    if (r2 == 0) goto L_0x00b1
                    com.baidu.sapi2.SapiAccountManager r2 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    com.baidu.sapi2.SapiAccountService r2 = r2.getAccountService()     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    com.baidu.sapi2.callback.OneKeyLoginCallback r5 = r8     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    java.lang.String r6 = com.baidu.sapi2.outsdk.c.p     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    r2.checkOneKeyLoginIsAvailable(r5, r6)     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    goto L_0x00bb
                L_0x00b1:
                    com.baidu.sapi2.outsdk.c r2 = new com.baidu.sapi2.outsdk.c     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    r2.<init>()     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    com.baidu.sapi2.callback.OneKeyLoginCallback r7 = r8     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    r2.b(r7, r6, r5)     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                L_0x00bb:
                    java.lang.String r2 = "expiredTime"
                    long r5 = r10.optLong(r2)     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    long r7 = r9     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    long r7 = r7 + r5
                    r5 = 30
                    long r7 = r7 - r5
                    com.baidu.sapi2.SapiContext r10 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    java.lang.String r2 = "china_telecom_expired_time"
                    r10.put(r2, r7)     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap$PreLoginCallback r10 = r7     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    if (r10 == 0) goto L_0x00d9
                    com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap$PreLoginCallback r10 = r7     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                    r10.onSuccess()     // Catch:{ Exception -> 0x00e8, all -> 0x00e1 }
                L_0x00d9:
                    java.lang.String r10 = r11
                    java.lang.String r2 = r12
                    com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(r1, r3, r0, r10, r2)
                    goto L_0x00f5
                L_0x00e1:
                    r10 = move-exception
                    r4 = r1
                    goto L_0x00f7
                L_0x00e4:
                    r10 = move-exception
                    java.lang.String r3 = "-1"
                    goto L_0x00f7
                L_0x00e8:
                    r10 = move-exception
                    java.lang.String r3 = "-202"
                    com.baidu.sapi2.utils.Log.e(r10)     // Catch:{ all -> 0x00f6 }
                    java.lang.String r10 = r11
                    java.lang.String r1 = r12
                    com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(r4, r3, r0, r10, r1)
                L_0x00f5:
                    return
                L_0x00f6:
                    r10 = move-exception
                L_0x00f7:
                    java.lang.String r1 = r11
                    java.lang.String r2 = r12
                    com.baidu.sapi2.utils.SapiStatUtil.statPreGetPhoneInfo(r4, r3, r0, r1, r2)
                    throw r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.AnonymousClass2.onResult(java.lang.String):void");
            }
        };
        instance.requestPreLogin(ctSetting, r5);
    }

    /* access modifiers changed from: private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final a aVar) {
        CtAuth.getInstance().requestLogin(str, new CtSetting(15000, 15000, 30000), new ResultListener() {
            public void onResult(String str) {
                String str2 = "result";
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                    JSONObject jSONObject2 = new JSONObject(str);
                    if (jSONObject2.optInt(str2) == 0) {
                        jSONObject.put("token", jSONObject2.optJSONObject("responseData").optString("accessToken"));
                    }
                    jSONObject.put("code", jSONObject2.optInt(str2));
                    SapiContext.getInstance().put("china_telecom_expired_time", 0);
                    String str3 = c.f2814a;
                    Object[] objArr = new Object[1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("in china telecom get token: ");
                    sb.append(jSONObject.toString());
                    objArr[0] = sb.toString();
                    Log.i(str3, objArr);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                aVar.onGetTokenComplete(jSONObject);
            }
        });
    }
}
