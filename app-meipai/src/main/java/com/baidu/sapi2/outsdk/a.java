package com.baidu.sapi2.outsdk;

import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.cmic.sso.sdk.auth.AuthnHelper;
import org.json.JSONObject;

/* compiled from: ChinaMobileSdkWrap */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final String f2810a = "rsa2048";

    public void a(SapiConfiguration sapiConfiguration, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        String str3 = c.f2814a;
        try {
            Object[] objArr = new Object[1];
            objArr[0] = "in china mobile login pre get phone info";
            Log.i(str3, objArr);
            AuthnHelper.getInstance(sapiConfiguration.context, f2810a).getPhoneInfo(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new ChinaMobileSdkWrap$1(this, oneKeyLoginCallback, str, str2));
        } catch (Throwable th) {
            Log.e(th);
            SapiStatUtil.statPreGetPhoneInfo(0, "-202", c.f2818e, str, str2);
            new c().b(oneKeyLoginCallback, -101, null);
        }
    }

    public void a(SapiConfiguration sapiConfiguration, com.baidu.sapi2.outsdk.c.a aVar) {
        try {
            AuthnHelper.getInstance(sapiConfiguration.context, f2810a).loginAuth(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new ChinaMobileSdkWrap$2(this, sapiConfiguration, aVar));
        } catch (Throwable th) {
            Log.e(th);
            aVar.onGetTokenComplete(new JSONObject());
        }
    }
}
