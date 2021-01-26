package com.baidu.sapi2;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.result.RealNameFaceIDResult;

/* renamed from: com.baidu.sapi2.l reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0173l extends PassFaceRecogCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ RealNameFaceIDResult f2762a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ VerifyUserFaceIDCallback f2763b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2764c;

    public C0173l(PassportSDK passportSDK, RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
        this.f2764c = passportSDK;
        this.f2762a = realNameFaceIDResult;
        this.f2763b = verifyUserFaceIDCallback;
    }

    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        this.f2762a.setResultCode(passFaceRecogResult.getResultCode());
        this.f2762a.setResultMsg(passFaceRecogResult.getResultMsg());
        this.f2763b.onFailure(this.f2762a);
    }

    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        this.f2762a.setResultCode(passFaceRecogResult.getResultCode());
        this.f2762a.setResultMsg(passFaceRecogResult.getResultMsg());
        RealNameFaceIDResult realNameFaceIDResult = this.f2762a;
        realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
        realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
        realNameFaceIDResult.setResultCode(0);
        this.f2763b.onSuccess(this.f2762a);
    }
}
