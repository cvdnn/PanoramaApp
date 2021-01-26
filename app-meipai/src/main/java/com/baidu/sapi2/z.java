package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.utils.Log;

/* compiled from: SapiAccountRepository */
public class z extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ A f3258a;

    public z(A a2, Looper looper) {
        this.f3258a = a2;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        String a2 = L.f2152a;
        StringBuilder sb = new StringBuilder();
        sb.append("onFailure, error = ");
        sb.append(th);
        sb.append(", errorCode = ");
        sb.append(i2);
        sb.append(", responseBody = ");
        sb.append(str);
        Log.d(a2, sb.toString());
        new c().a(this.f3258a.f2104a, -100, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d6 A[Catch:{ Exception -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f1 A[Catch:{ Exception -> 0x00fe }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(int r6, java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.String> r8) {
        /*
            r5 = this;
            java.lang.String r0 = com.baidu.sapi2.L.f2152a
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onSuccess, statusCode = "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = ", response = "
            r2.append(r6)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            r2 = 0
            r1[r2] = r6
            com.baidu.sapi2.utils.Log.d(r0, r1)
            r6 = -100
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fe }
            r1.<init>(r7)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r7 = "errInfo"
            org.json.JSONObject r7 = r1.optJSONObject(r7)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r2 = "no"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r3 = "msg"
            java.lang.String r7 = r7.optString(r3)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r3 = "0"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r4 = "data"
            if (r3 == 0) goto L_0x007a
            com.baidu.sapi2.A r7 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.L r7 = r7.f2106c     // Catch:{ Exception -> 0x00fe }
            r7.a(r8)     // Catch:{ Exception -> 0x00fe }
            org.json.JSONObject r7 = r1.optJSONObject(r4)     // Catch:{ Exception -> 0x00fe }
            if (r7 == 0) goto L_0x006d
            java.lang.String r8 = "xml"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.SapiAccountManager r8 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.SapiAccountService r8 = r8.getAccountService()     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.A r1 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r1.f2104a     // Catch:{ Exception -> 0x00fe }
            r8.handleOneKeyLoginResult(r1, r7)     // Catch:{ Exception -> 0x00fe }
            goto L_0x0079
        L_0x006d:
            com.baidu.sapi2.outsdk.c r7 = new com.baidu.sapi2.outsdk.c     // Catch:{ Exception -> 0x00fe }
            r7.<init>()     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.A r8 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.callback.OneKeyLoginCallback r8 = r8.f2104a     // Catch:{ Exception -> 0x00fe }
            r7.a(r8, r6, r0)     // Catch:{ Exception -> 0x00fe }
        L_0x0079:
            return
        L_0x007a:
            java.lang.String r8 = "400101"
            boolean r8 = r8.equals(r2)     // Catch:{ Exception -> 0x00fe }
            if (r8 != 0) goto L_0x00c2
            java.lang.String r8 = "400031"
            boolean r8 = r8.equals(r2)     // Catch:{ Exception -> 0x00fe }
            if (r8 != 0) goto L_0x00c2
            java.lang.String r8 = "400023"
            boolean r8 = r8.equals(r2)     // Catch:{ Exception -> 0x00fe }
            if (r8 == 0) goto L_0x0093
            goto L_0x00c2
        L_0x0093:
            java.lang.String r8 = "400704"
            boolean r8 = r8.equals(r2)     // Catch:{ Exception -> 0x00fe }
            if (r8 != 0) goto L_0x00b5
            java.lang.String r8 = "400706"
            boolean r8 = r8.equals(r2)     // Catch:{ Exception -> 0x00fe }
            if (r8 == 0) goto L_0x00a4
            goto L_0x00b5
        L_0x00a4:
            com.baidu.sapi2.outsdk.c r8 = new com.baidu.sapi2.outsdk.c     // Catch:{ Exception -> 0x00fe }
            r8.<init>()     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.A r1 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r1.f2104a     // Catch:{ Exception -> 0x00fe }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x00fe }
            r8.a(r1, r2, r7)     // Catch:{ Exception -> 0x00fe }
            return
        L_0x00b5:
            org.json.JSONObject r7 = r1.optJSONObject(r4)     // Catch:{ Exception -> 0x00fe }
            if (r7 == 0) goto L_0x00cf
            java.lang.String r8 = "ppDatau"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00d0
        L_0x00c2:
            org.json.JSONObject r7 = r1.optJSONObject(r4)     // Catch:{ Exception -> 0x00fe }
            if (r7 == 0) goto L_0x00cf
            java.lang.String r8 = "verifyUrl"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00d0
        L_0x00cf:
            r7 = r0
        L_0x00d0:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00fe }
            if (r8 != 0) goto L_0x00f1
            com.baidu.sapi2.result.OneKeyLoginResult r8 = new com.baidu.sapi2.result.OneKeyLoginResult     // Catch:{ Exception -> 0x00fe }
            r8.<init>()     // Catch:{ Exception -> 0x00fe }
            r1 = -104(0xffffffffffffff98, float:NaN)
            r8.setResultCode(r1)     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.A r1 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r1.f2104a     // Catch:{ Exception -> 0x00fe }
            r1.onGuideProcess(r8)     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.A r8 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.callback.a.b r8 = r8.f2105b     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = ""
            r8.a(r1, r7)     // Catch:{ Exception -> 0x00fe }
            goto L_0x010e
        L_0x00f1:
            com.baidu.sapi2.outsdk.c r7 = new com.baidu.sapi2.outsdk.c     // Catch:{ Exception -> 0x00fe }
            r7.<init>()     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.A r8 = r5.f3258a     // Catch:{ Exception -> 0x00fe }
            com.baidu.sapi2.callback.OneKeyLoginCallback r8 = r8.f2104a     // Catch:{ Exception -> 0x00fe }
            r7.a(r8, r6, r0)     // Catch:{ Exception -> 0x00fe }
            goto L_0x010e
        L_0x00fe:
            r7 = move-exception
            com.baidu.sapi2.utils.Log.e(r7)
            com.baidu.sapi2.outsdk.c r7 = new com.baidu.sapi2.outsdk.c
            r7.<init>()
            com.baidu.sapi2.A r8 = r5.f3258a
            com.baidu.sapi2.callback.OneKeyLoginCallback r8 = r8.f2104a
            r7.a(r8, r6, r0)
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.z.onSuccess(int, java.lang.String, java.util.HashMap):void");
    }
}
