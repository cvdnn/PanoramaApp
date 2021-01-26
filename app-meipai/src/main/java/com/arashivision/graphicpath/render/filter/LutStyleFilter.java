package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class LutStyleFilter extends LutFilter {
    public LutStyleFilter(RenderLifecycle renderLifecycle) {
        super(renderLifecycle, "LutStyleFilter");
    }

    private native void nativeSetIntensity(float f2);

    public void setIntensity(float f2) {
        nativeSetIntensity(f2);
    }
}
