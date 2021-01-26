package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class HDRProFilter extends FilterObject {
    public HDRProFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "HDRProFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    private native boolean nativeSetPaths(String str, String str2);

    public boolean setPaths(String str, String str2) {
        return nativeSetPaths(str, str2);
    }
}
