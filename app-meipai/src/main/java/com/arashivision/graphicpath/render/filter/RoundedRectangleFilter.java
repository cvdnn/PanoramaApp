package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class RoundedRectangleFilter extends FilterObject {
    public RoundedRectangleFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "RoundedRectangleFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    public native float getBorderWidth();

    public native float getRadius();

    public native void setBorderWidth(float f2);

    public native void setRadius(float f2);
}
