package com.baidu.pass.biometrics.base;

import android.content.Context;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;

public class PassBiometricDefaultFactory extends PassBiometricFactory {
    public static final int VERSION_CODE = 8;
    public static final String VERSION_NAME = "1.3.0";
    public static PassBiometricDefaultFactory defaultFactory;

    private PassBiometric defaultBiometric() {
        return new PassBiometric() {
            public void config(PassBiometricConfiguration passBiometricConfiguration) {
                Log.e(PassBiometricFactory.class.getSimpleName(), "ERROR with implement Biometric!");
            }

            public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
                Log.e(PassBiometricFactory.class.getSimpleName(), "ERROR with implement Biometric!");
            }
        };
    }

    public static PassBiometricDefaultFactory getInstance() {
        if (defaultFactory == null) {
            synchronized (PassBiometricDefaultFactory.class) {
                if (defaultFactory == null) {
                    defaultFactory = new PassBiometricDefaultFactory();
                }
            }
        }
        return defaultFactory;
    }

    public PassBiometric getBiometric(int i2) {
        try {
            return (PassBiometric) Class.forName(BiometricType.getClass(i2)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e(e2);
            return defaultBiometric();
        }
    }
}
