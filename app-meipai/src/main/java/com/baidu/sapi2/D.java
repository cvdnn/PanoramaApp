package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class D extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallBack f2118a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ boolean f2119b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiDataEncryptor f2120c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ String f2121d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ String f2122e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ L f2123f;

    public D(L l, Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
        this.f2123f = l;
        this.f2118a = sapiCallBack;
        this.f2119b = z;
        this.f2120c = sapiDataEncryptor;
        this.f2121d = str;
        this.f2122e = str2;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        if (i2 == -201) {
            this.f2118a.onNetworkFailed();
        } else {
            this.f2118a.onSystemError(i2);
        }
    }

    public void onSuccess(int i2, String str) {
        super.onSuccess(i2, str);
        if (!TextUtils.isEmpty(str)) {
            this.f2123f.a(-100, this.f2118a, str, this.f2119b, this.f2120c);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cert");
            this.f2123f.a(this.f2118a, optString, jSONObject.optString("cert_id"), this.f2121d, this.f2122e, this.f2119b, this.f2120c);
        } catch (Exception e2) {
            this.f2123f.a(-100, this.f2118a, str, this.f2119b, this.f2120c);
            Log.e(e2);
        }
    }
}
