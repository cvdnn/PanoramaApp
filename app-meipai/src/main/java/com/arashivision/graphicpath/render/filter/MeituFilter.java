package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class MeituFilter extends FilterObject {
    public MeituFilter(String str, RenderLifecycle renderLifecycle) {
        super(createNativeWrap(str), str, renderLifecycle);
    }

    public static native long createNativeWrap(String str);
}
