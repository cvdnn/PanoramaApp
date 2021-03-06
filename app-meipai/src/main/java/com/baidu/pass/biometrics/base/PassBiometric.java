package com.baidu.pass.biometrics.base;

import android.content.Context;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;

public interface PassBiometric {
    void config(PassBiometricConfiguration passBiometricConfiguration);

    void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context);
}
