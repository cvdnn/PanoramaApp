package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class SharpnessFilter extends FilterObject {
    public SharpnessFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "SharpnessFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    public native float getSharpness();

    public native void setSharpness(float f2);
}
