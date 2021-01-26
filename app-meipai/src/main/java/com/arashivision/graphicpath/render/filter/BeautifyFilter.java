package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class BeautifyFilter extends FilterObject {
    public BeautifyFilter(int i2, RenderLifecycle renderLifecycle) {
        super(createNativeWrap(i2), "BeautifyFilter", renderLifecycle);
    }

    public static native long createNativeWrap(int i2);
}
