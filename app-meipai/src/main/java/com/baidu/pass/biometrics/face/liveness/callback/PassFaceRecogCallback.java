package com.baidu.pass.biometrics.face.liveness.callback;

import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;

public abstract class PassFaceRecogCallback implements PassBiometricCallback<PassFaceRecogResult> {
    public void onFinish() {
    }

    public void onStart() {
    }
}
