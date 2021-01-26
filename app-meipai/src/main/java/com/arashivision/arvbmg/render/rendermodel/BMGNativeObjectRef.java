package com.arashivision.arvbmg.render.rendermodel;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class BMGNativeObjectRef extends NativeObjectRef {
    static {
        ARVBMGLibsLoader.load();
    }

    public BMGNativeObjectRef(long j2, String str) {
        super(j2, str);
    }
}
