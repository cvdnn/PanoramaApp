package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class SketchFilter extends FilterObject {
    public SketchFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "SketchFilter", renderLifecycle);
    }

    public static native long createNativeWrap();
}
