package com.arashivision.arvbmg.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class OverlayFilter extends BMGFilterObject {
    public OverlayFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "OverlayFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    private native void nativeSetOverlayData(byte[] bArr, int i2, int i3);

    public void setOverlayData(byte[] bArr, int i2, int i3) {
        nativeSetOverlayData(bArr, i2, i3);
    }
}
