package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;

/* compiled from: SapiAccountService */
public class M extends GetTplStokenCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Context f2156a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ SapiAccountService f2157b;

    public M(SapiAccountService sapiAccountService, Context context) {
        this.f2157b = sapiAccountService;
        this.f2156a = context;
    }

    public void onFailure(GetTplStokenResult getTplStokenResult) {
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        SapiAccountService.a(this.f2156a, (String) getTplStokenResult.tplStokenMap.get("pp"));
    }
}
