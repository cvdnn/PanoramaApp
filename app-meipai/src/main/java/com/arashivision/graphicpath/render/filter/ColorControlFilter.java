package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class ColorControlFilter extends FilterObject {
    public ColorControlFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "ColorControlFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    public native float getBrightness();

    public native float getContrast();

    public native float getSaturation();

    public native void setBrightness(float f2);

    public native void setContrast(float f2);

    public native void setSaturation(float f2);
}
