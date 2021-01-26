package com.arashivision.arvbmg.render.filter;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.filter.FilterObject;

public abstract class BMGFilterObject extends FilterObject {
    static {
        ARVBMGLibsLoader.load();
    }

    public BMGFilterObject(long j2, String str, RenderLifecycle renderLifecycle) {
        super(j2, str, renderLifecycle);
        setRequireFreeManually();
    }

    public static native void nativeSetFilterAssetDirectory(String str);

    public static void setFilterAssetDirectory(String str) {
        nativeSetFilterAssetDirectory(str);
    }
}
