package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.a.b;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.outsdk.c.a;
import com.baidu.sapi2.result.OneKeyLoginResult;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.f reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0167f implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginCallback f2733a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f2734b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ boolean f2735c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ Context f2736d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2737e;

    public C0167f(PassportSDK passportSDK, OneKeyLoginCallback oneKeyLoginCallback, String str, boolean z, Context context) {
        this.f2737e = passportSDK;
        this.f2733a = oneKeyLoginCallback;
        this.f2734b = str;
        this.f2735c = z;
        this.f2736d = context;
    }

    public void onGetTokenComplete(JSONObject jSONObject) {
        String optString = jSONObject.optString("token");
        if (!TextUtils.isEmpty(optString)) {
            SapiAccountManager.getInstance().getAccountService().a(this.f2733a, optString, this.f2734b, (b) new C0166e(this));
        } else {
            new c().a(this.f2733a, (int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL, (String) null);
        }
    }
}
