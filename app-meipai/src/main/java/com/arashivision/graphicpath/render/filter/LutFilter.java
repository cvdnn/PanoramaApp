package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import java.nio.ByteBuffer;

public class LutFilter extends FilterObject {
    public LutFilter(RenderLifecycle renderLifecycle, String str) {
        super(createNativeWrap(), str, renderLifecycle);
    }

    public static native long createNativeWrap();

    private native float getIntensity();

    private native void nativeSetLut(float[] fArr, byte[] bArr);

    private native void setIntensity(float f2);

    private native void setLut(int i2, int i3, int i4, ByteBuffer byteBuffer);

    public void setLut(float[] fArr, byte[] bArr) {
        nativeSetLut(fArr, bArr);
    }

    public LutFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "LutFilter", renderLifecycle);
    }
}
