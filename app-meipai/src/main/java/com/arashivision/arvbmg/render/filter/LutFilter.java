package com.arashivision.arvbmg.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class LutFilter extends BMGFilterObject {
    public LutFilter(RenderLifecycle renderLifecycle, String str) {
        super(createNativeWrap(), str, renderLifecycle);
    }

    public static native long createNativeWrap();

    private native void nativeSetLut(float[] fArr, byte[] bArr);

    public void setLut(float[] fArr, byte[] bArr) {
        nativeSetLut(fArr, bArr);
    }
}
