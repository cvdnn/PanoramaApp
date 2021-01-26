package com.arashivision.arvbmg.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class MeituFilter extends BMGFilterObject {
    public MeituFilter(String str, RenderLifecycle renderLifecycle) {
        super(createNativeWrap(str), str, renderLifecycle);
    }

    public static native long createNativeWrap(String str);
}
