package com.baidu.sapi2.bio;

import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.utils.Log;

/* compiled from: BiometricsManager */
public class a extends PassFaceRecogCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ PassFaceRecogCallback f2722a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ BiometricsManager f2723b;

    public a(BiometricsManager biometricsManager, PassFaceRecogCallback passFaceRecogCallback) {
        this.f2723b = biometricsManager;
        this.f2722a = passFaceRecogCallback;
    }

    /* renamed from: a */
    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
        this.f2722a.onFailure(passFaceRecogResult);
        Log.d(BiometricsManager.TAG, "result", passFaceRecogResult.toJSONObject());
    }

    /* renamed from: b */
    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
        this.f2722a.onSuccess(passFaceRecogResult);
        Log.e(BiometricsManager.TAG, "result", passFaceRecogResult.toJSONObject(), "callbackkey", passFaceRecogResult.callbackkey);
        Log.d(BiometricsManager.TAG, "faceimage", passFaceRecogResult.faceimage, "imgdigests", passFaceRecogResult.imgdigests, "originalImage", passFaceRecogResult.originalImage);
    }
}
