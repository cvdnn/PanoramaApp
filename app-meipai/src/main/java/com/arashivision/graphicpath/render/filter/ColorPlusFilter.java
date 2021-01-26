package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class ColorPlusFilter extends FilterObject {
    public ColorPlusFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "ColorPlusFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    public native int getMode();

    public native int getProcessType();

    public native void setMode(int i2);

    public native void setProcessType(int i2);
}
