package com.baidu.pass.biometrics.base.callback;

import com.baidu.pass.biometrics.base.result.PassBiometricResult;

public interface PassBiometricCallback<R extends PassBiometricResult> {
    void onFailure(R r);

    void onFinish();

    void onStart();

    void onSuccess(R r);
}
