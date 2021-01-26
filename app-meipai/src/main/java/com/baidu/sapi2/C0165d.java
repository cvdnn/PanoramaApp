package com.baidu.sapi2;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.Map;

/* renamed from: com.baidu.sapi2.d reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0165d extends GetTplStokenCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ String f2724a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Map f2725b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ String f2726c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ SapiAccount f2727d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ PassFaceRecogCallback f2728e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ ExtendSysWebViewMethodResult f2729f;

    /* renamed from: g reason: collision with root package name */
    public final /* synthetic */ ExtendSysWebViewMethodCallback f2730g;

    /* renamed from: h reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2731h;

    public C0165d(PassportSDK passportSDK, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        this.f2731h = passportSDK;
        this.f2724a = str;
        this.f2725b = map;
        this.f2726c = str2;
        this.f2727d = sapiAccount;
        this.f2728e = passFaceRecogCallback;
        this.f2729f = extendSysWebViewMethodResult;
        this.f2730g = extendSysWebViewMethodCallback;
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onFailure(GetTplStokenResult getTplStokenResult) {
        this.f2729f.params.put("retCode", Integer.valueOf(getTplStokenResult.getResultCode()));
        this.f2729f.params.put("retMsg", getTplStokenResult.getResultMsg());
        this.f2730g.onFinish(this.f2729f);
    }

    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        BiometricsManager.getInstance().recogWithBduss(this.f2731h.E, this.f2724a, this.f2725b, this.f2726c, this.f2727d.bduss, (String) getTplStokenResult.tplStokenMap.get("pp"), this.f2728e);
    }
}
