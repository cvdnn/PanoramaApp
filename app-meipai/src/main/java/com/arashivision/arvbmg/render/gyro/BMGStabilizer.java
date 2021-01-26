package com.arashivision.arvbmg.render.gyro;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import com.arashivision.graphicpath.render.util.Stabilizer;

public abstract class BMGStabilizer extends Stabilizer {
    static {
        ARVBMGLibsLoader.load();
    }

    public BMGStabilizer(long j2) {
        super(j2);
    }

    private native boolean nativeLoadData();

    private native void nativeUpdateStabType(int i2);

    public boolean startLoadData() {
        return nativeLoadData();
    }

    public void updateStabType(int i2) {
        nativeUpdateStabType(i2);
    }
}
