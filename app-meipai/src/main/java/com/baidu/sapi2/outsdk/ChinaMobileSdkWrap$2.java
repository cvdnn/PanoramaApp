package com.baidu.sapi2.outsdk;

import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.outsdk.c.a;
import com.baidu.sapi2.utils.Log;
import com.cmic.sso.sdk.auth.TokenListener;
import org.json.JSONException;
import org.json.JSONObject;

public class ChinaMobileSdkWrap$2 implements TokenListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiConfiguration f2784a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ a f2785b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ a f2786c;

    public ChinaMobileSdkWrap$2(a aVar, SapiConfiguration sapiConfiguration, a aVar2) {
        this.f2786c = aVar;
        this.f2784a = sapiConfiguration;
        this.f2785b = aVar2;
    }

    public void onGetTokenComplete(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        jSONObject.put("errno", 0);
        jSONObject.put("appid", this.f2784a.chinaMobileAppID);
        jSONObject.put("code", jSONObject.optString("resultCode"));
        String str = c.f2814a;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("in china mobile get token: ");
        sb.append(jSONObject.toString());
        objArr[0] = sb.toString();
        Log.i(str, objArr);
        this.f2785b.onGetTokenComplete(jSONObject);
    }
}
