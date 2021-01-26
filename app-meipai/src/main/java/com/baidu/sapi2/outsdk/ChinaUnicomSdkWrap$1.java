package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.outsdk.c.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.sdk.base.api.CallBack;
import org.json.JSONObject;

public class ChinaUnicomSdkWrap$1 implements CallBack<Object> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiConfiguration f2803a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ a f2804b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ b f2805c;

    public ChinaUnicomSdkWrap$1(b bVar, SapiConfiguration sapiConfiguration, a aVar) {
        this.f2805c = bVar;
        this.f2803a = sapiConfiguration;
        this.f2804b = aVar;
    }

    public void onFailed(int i2, int i3, String str, String str2) {
        this.f2804b.onGetTokenComplete(new JSONObject());
        StringBuilder a2 = e.a.a.a.a.a("onFailure  code:   ", i2, "   status: ", i3, "  msg：");
        a2.append(str);
        Log.e(c.f2814a, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("");
        SapiStatUtil.statPreGetPhoneInfo(0, sb.toString(), c.f2819f, c.k, b.f2813c);
    }

    public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
        String str3 = "code";
        String str4 = c.k;
        String str5 = c.f2819f;
        StringBuilder a2 = e.a.a.a.a.a("onSuccess: code:", i2, "   status:", i3, "   msg:");
        a2.append(str);
        a2.append("    response: ");
        a2.append(obj);
        a2.append("    seq: ");
        a2.append(str2);
        boolean z = 0;
        Log.i(c.f2814a, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("");
        String sb2 = sb.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", z);
            jSONObject.put("appid", this.f2803a.context.getPackageName());
            JSONObject jSONObject2 = new JSONObject(obj.toString());
            jSONObject.put("CUVersion", "2");
            int optInt = jSONObject2.optInt(str3);
            jSONObject.put(str3, optInt);
            String str6 = "accessCode";
            if (optInt == 0) {
                jSONObject.put("token", jSONObject2.optString(str6));
            }
            int i4 = TextUtils.isEmpty(jSONObject2.optString(str6)) ^ true ? 1 : 0;
        } catch (Exception e2) {
            Log.e(e2);
        } finally {
            SapiStatUtil.statPreGetPhoneInfo(z, sb2, str5, str4, b.f2813c);
        }
        this.f2804b.onGetTokenComplete(jSONObject);
    }
}
