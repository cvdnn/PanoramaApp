package com.baidu.sapi2;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;

/* renamed from: com.baidu.sapi2.o reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0176o extends PassFaceRecogCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ExtendSysWebViewMethodResult f2775a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ExtendSysWebViewMethodCallback f2776b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2777c;

    public C0176o(PassportSDK passportSDK, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        this.f2777c = passportSDK;
        this.f2775a = extendSysWebViewMethodResult;
        this.f2776b = extendSysWebViewMethodCallback;
    }

    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f2775a;
        extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
        this.f2776b.onFinish(extendSysWebViewMethodResult);
    }

    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f2775a;
        extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
        this.f2776b.onFinish(extendSysWebViewMethodResult);
    }
}
