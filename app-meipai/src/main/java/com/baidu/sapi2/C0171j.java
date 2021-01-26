package com.baidu.sapi2;

import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.result.SapiResult;

/* renamed from: com.baidu.sapi2.j reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0171j extends AuthWidgetCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ RegisterUserFaceIDCallback f2754a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ FaceIDRegDTO f2755b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2756c;

    public C0171j(PassportSDK passportSDK, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        this.f2756c = passportSDK;
        this.f2754a = registerUserFaceIDCallback;
        this.f2755b = faceIDRegDTO;
    }

    public void onFailure(SapiResult sapiResult) {
        this.f2754a.onFailure(sapiResult);
    }

    public void onSuccess(String str) {
        PassportSDK passportSDK = this.f2756c;
        RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f2754a;
        FaceIDRegDTO faceIDRegDTO = this.f2755b;
        passportSDK.b(registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
    }
}
