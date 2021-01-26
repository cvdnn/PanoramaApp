package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.cmic.sso.sdk.auth.TokenListener;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

public class ChinaMobileSdkWrap$1 implements TokenListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginCallback f2778a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f2779b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ String f2780c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ a f2781d;

    public ChinaMobileSdkWrap$1(a aVar, OneKeyLoginCallback oneKeyLoginCallback, String str, String str2) {
        this.f2781d = aVar;
        this.f2778a = oneKeyLoginCallback;
        this.f2779b = str;
        this.f2780c = str2;
    }

    public void onGetTokenComplete(final JSONObject jSONObject) {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
            public void run() {
                String str;
                boolean z = false;
                Log.i(c.f2814a, "getPhoneInfo", jSONObject);
                JSONObject jSONObject = jSONObject;
                if (jSONObject != null) {
                    str = jSONObject.optString("resultCode");
                    if (str.equals("103000") && jSONObject.optString(SocialConstants.PARAM_APP_DESC).equals("true")) {
                        String str2 = "securityphone";
                        if (!TextUtils.isEmpty(jSONObject.optString(str2))) {
                            c.o = jSONObject.optString(str2);
                            if (ChinaMobileSdkWrap$1.this.f2778a != null) {
                                SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(ChinaMobileSdkWrap$1.this.f2778a, c.o);
                            }
                            z = !TextUtils.isEmpty(c.o);
                        }
                    }
                    new c().b(ChinaMobileSdkWrap$1.this.f2778a, -101, null);
                    z = !TextUtils.isEmpty(c.o);
                } else {
                    new c().b(ChinaMobileSdkWrap$1.this.f2778a, -101, null);
                    str = LivenessStat.TYPE_STRING_DEFAULT;
                }
                ChinaMobileSdkWrap$1 chinaMobileSdkWrap$1 = ChinaMobileSdkWrap$1.this;
                String str3 = chinaMobileSdkWrap$1.f2779b;
                String str4 = chinaMobileSdkWrap$1.f2780c;
                SapiStatUtil.statPreGetPhoneInfo(z ? 1 : 0, str, c.f2818e, str3, str4);
            }
        }));
    }
}
