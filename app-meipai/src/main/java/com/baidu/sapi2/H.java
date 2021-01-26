package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount.DispersionCertification;
import com.baidu.sapi2.SapiAccount.ExtraProperty;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetTplStokenResult.FailureType;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.Log;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class H extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ GetTplStokenCallback f2135a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ GetTplStokenResult f2136b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiAccount f2137c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ List f2138d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ boolean f2139e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ String f2140f;

    /* renamed from: g reason: collision with root package name */
    public final /* synthetic */ L f2141g;

    public H(L l, Looper looper, GetTplStokenCallback getTplStokenCallback, GetTplStokenResult getTplStokenResult, SapiAccount sapiAccount, List list, boolean z, String str) {
        this.f2141g = l;
        this.f2135a = getTplStokenCallback;
        this.f2136b = getTplStokenResult;
        this.f2137c = sapiAccount;
        this.f2138d = list;
        this.f2139e = z;
        this.f2140f = str;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        if (!TextUtils.isEmpty(this.f2140f)) {
            this.f2136b.setResultCode(i2);
            this.f2135a.onFailure(this.f2136b);
        }
    }

    public void onFinish() {
        this.f2135a.onFinish();
    }

    public void onStart() {
        this.f2135a.onStart();
    }

    public void onSuccess(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.f2136b.setResultCode(parseInt);
            if (parseInt != 0) {
                String str2 = "errmsg";
                if (parseInt != 8) {
                    if (!TextUtils.isEmpty(this.f2140f)) {
                        this.f2136b.setResultMsg(jSONObject.optString(str2));
                        this.f2135a.onFailure(this.f2136b);
                    }
                    return;
                }
                if (!TextUtils.isEmpty(this.f2140f)) {
                    String optString = jSONObject.optString("ssnerror");
                    if (TextUtils.isEmpty(optString)) {
                        optString = "0";
                    }
                    int parseInt2 = Integer.parseInt(optString);
                    FailureType failureType = FailureType.BDUSS_PTOKEN_NOT_MATCH;
                    if (parseInt2 == 1) {
                        this.f2136b.failureType = FailureType.BDUSS_PTOKEN_NOT_MATCH;
                    } else {
                        FailureType failureType2 = FailureType.BDUSS_EXPIRED;
                        if (parseInt2 == 2) {
                            this.f2136b.failureType = FailureType.BDUSS_EXPIRED;
                        }
                    }
                    this.f2136b.setResultMsg(jSONObject.optString(str2));
                    this.f2135a.onFailure(this.f2136b);
                }
                return;
            }
            Map<String, String> tplStokenMap = DispersionCertification.getTplStokenMap(jSONObject.optJSONObject(ExtraProperty.EXTRA_TPL_STOKEN_LIST));
            this.f2136b.tplStokenMap = tplStokenMap;
            ExtraProperty extraProperty = new ExtraProperty();
            if (!TextUtils.isEmpty(this.f2137c.extra)) {
                extraProperty = ExtraProperty.fromJSONObject(new JSONObject(this.f2137c.extra));
            }
            extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
            this.f2137c.extra = extraProperty.toJSONObject().toString();
            if (this.f2138d.size() == tplStokenMap.size()) {
                if (this.f2139e) {
                    SapiShareClient.getInstance().validate(this.f2137c);
                } else {
                    SapiContext.getInstance().setCurrentAccount(this.f2137c);
                    SapiAccountManager.getInstance().preFetchStoken(this.f2137c, false);
                    SapiContext.getInstance().addLoginAccount(this.f2137c);
                    new m().a(false);
                }
                this.f2135a.onSuccess(this.f2136b);
                return;
            }
            this.f2136b.setResultCode(-306);
            this.f2135a.onFailure(this.f2136b);
        } catch (Exception e2) {
            Log.e(e2);
            if (!TextUtils.isEmpty(this.f2140f)) {
                this.f2136b.setResultCode(-205);
                this.f2135a.onFailure(this.f2136b);
            }
        }
    }
}
