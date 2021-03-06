package com.baidu.pass.biometrics.base;

public abstract class PassBiometricFactory {
    public static PassBiometricFactory getDefaultFactory() {
        return PassBiometricDefaultFactory.getInstance();
    }

    public abstract PassBiometric getBiometric(int i2);
}
