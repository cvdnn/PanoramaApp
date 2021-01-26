package com.baidu.sapi2;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.n reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0175n implements SapiCallback<SapiResult> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ int f2769a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ExtendSysWebViewMethodCallback f2770b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ JSONObject f2771c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ ExtendSysWebViewMethodResult f2772d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ Context f2773e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2774f;

    public C0175n(PassportSDK passportSDK, int i2, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, Context context) {
        this.f2774f = passportSDK;
        this.f2769a = i2;
        this.f2770b = extendSysWebViewMethodCallback;
        this.f2771c = jSONObject;
        this.f2772d = extendSysWebViewMethodResult;
        this.f2773e = context;
    }

    public void onFailure(SapiResult sapiResult) {
        this.f2772d.setResultCode(sapiResult.getResultCode());
        this.f2772d.setResultMsg(sapiResult.getResultMsg());
        this.f2770b.onFinish(this.f2772d);
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(SapiResult sapiResult) {
        int i2 = this.f2769a;
        String str = "retCode";
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.f2774f.a(this.f2770b, this.f2771c, i2, this.f2772d);
                return;
            case 5:
                this.f2774f.z = this.f2770b;
                String optString = this.f2771c.optString("url");
                String optString2 = this.f2771c.optString("title");
                Intent intent = new Intent(this.f2773e, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                intent.putExtra("extra_external_url", optString);
                intent.setFlags(268435456);
                this.f2773e.startActivity(intent);
                return;
            case 6:
                JSONArray optJSONArray = this.f2771c.optJSONArray("di_keys");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i3))) {
                        arrayList.add(optJSONArray.optString(i3));
                    }
                }
                String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                this.f2772d.params.put(str, "0");
                this.f2772d.params.put("result", diCookieInfo);
                this.f2770b.onFinish(this.f2772d);
                return;
            default:
                this.f2772d.params.put(str, "-301");
                Map<String, Object> map = this.f2772d.params;
                StringBuilder a2 = a.a("action :");
                a2.append(this.f2769a);
                a2.append(" is not support");
                map.put("retMsg", a2.toString());
                this.f2770b.onFinish(this.f2772d);
                return;
        }
    }
}
