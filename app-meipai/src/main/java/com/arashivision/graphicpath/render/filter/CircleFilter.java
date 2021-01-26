package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class CircleFilter extends FilterObject {
    public CircleFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "CircleFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    public native void setCircleCenter(int i2, int i3);

    public native void setCircleRadius(int i2);

    public native void setSampleCenter(int i2, int i3);

    public native void setSampleRadius(int i2);
}
