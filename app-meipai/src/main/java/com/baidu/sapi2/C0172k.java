package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;

/* renamed from: com.baidu.sapi2.k reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0172k extends GetTplStokenCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Context f2757a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ FaceIDVerifyDTO f2758b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ VerifyUserFaceIDCallback f2759c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ RealNameFaceIDResult f2760d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2761e;

    public C0172k(PassportSDK passportSDK, Context context, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        this.f2761e = passportSDK;
        this.f2757a = context;
        this.f2758b = faceIDVerifyDTO;
        this.f2759c = verifyUserFaceIDCallback;
        this.f2760d = realNameFaceIDResult;
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onFailure(GetTplStokenResult getTplStokenResult) {
        this.f2760d.setResultCode(getTplStokenResult.getResultCode());
        this.f2760d.setResultMsg(getTplStokenResult.getResultMsg());
        this.f2759c.onFailure(this.f2760d);
    }

    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        String str = (String) getTplStokenResult.tplStokenMap.get("pp");
        if (!TextUtils.isEmpty(str)) {
            PassportSDK passportSDK = this.f2761e;
            Context context = this.f2757a;
            FaceIDVerifyDTO faceIDVerifyDTO = this.f2758b;
            passportSDK.a(context, faceIDVerifyDTO.subpro, null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f2759c, this.f2760d);
            return;
        }
        this.f2760d.setResultCode(-402);
        this.f2760d.setResultMsg("服务异常，请稍后再试");
        this.f2759c.onFailure(this.f2760d);
    }
}
