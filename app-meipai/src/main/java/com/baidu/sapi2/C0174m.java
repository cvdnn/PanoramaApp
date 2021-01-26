package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.m reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0174m extends PassFaceRecogCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ UnRealNameFaceIDResult f2765a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f2766b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ FaceIDCallback f2767c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2768d;

    public C0174m(PassportSDK passportSDK, UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
        this.f2768d = passportSDK;
        this.f2765a = unRealNameFaceIDResult;
        this.f2766b = str;
        this.f2767c = faceIDCallback;
    }

    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        this.f2765a.setResultCode(passFaceRecogResult.getResultCode());
        this.f2767c.onFailure(this.f2765a);
    }

    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        this.f2765a.setResultMsg(passFaceRecogResult.getResultMsg());
        if (this.f2766b.equals("faceDetect")) {
            JSONObject jSONObject = passFaceRecogResult.extraJson;
            if (jSONObject != null) {
                this.f2765a.registerResult = jSONObject.toString();
            }
        }
        UnRealNameFaceIDResult unRealNameFaceIDResult = this.f2765a;
        String str = passFaceRecogResult.callbackkey;
        unRealNameFaceIDResult.callBackKey = str;
        if (TextUtils.isEmpty(str)) {
            this.f2765a.setResultCode(-205);
            this.f2767c.onFailure(this.f2765a);
            return;
        }
        this.f2765a.setResultCode(0);
        this.f2767c.onSuccess(this.f2765a);
    }
}
