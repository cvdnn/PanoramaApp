package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Map;

/* compiled from: SapiAccountService */
public class N implements SapiCallback<OAuthResult> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Map f2158a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ SapiAccount f2159b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiAccountService f2160c;

    public N(SapiAccountService sapiAccountService, Map map, SapiAccount sapiAccount) {
        this.f2160c = sapiAccountService;
        this.f2158a = map;
        this.f2159b = sapiAccount;
    }

    /* renamed from: a */
    public void onFailure(OAuthResult oAuthResult) {
    }

    /* renamed from: b */
    public void onSuccess(OAuthResult oAuthResult) {
        if (!TextUtils.isEmpty(oAuthResult.openid)) {
            this.f2158a.put(oAuthResult.openid, this.f2159b.uid);
            SapiContext.getInstance().put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(this.f2158a, false));
        }
    }

    public void onFinish() {
    }

    public void onStart() {
    }
}
