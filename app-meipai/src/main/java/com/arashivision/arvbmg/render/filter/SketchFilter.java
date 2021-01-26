package com.arashivision.arvbmg.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class SketchFilter extends BMGFilterObject {
    public SketchFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "SketchFilter", renderLifecycle);
    }

    public static native long createNativeWrap();
}
