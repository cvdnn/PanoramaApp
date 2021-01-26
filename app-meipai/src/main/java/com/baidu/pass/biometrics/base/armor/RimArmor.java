package com.baidu.pass.biometrics.base.armor;

public class RimArmor {
    public static RimArmor ins;

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (ins == null) {
                ins = new RimArmor();
            }
            rimArmor = ins;
        }
        return rimArmor;
    }

    public native String getToken();
}
