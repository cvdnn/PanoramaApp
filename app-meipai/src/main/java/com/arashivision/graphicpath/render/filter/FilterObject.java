package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.FreeNativeOnDeinit;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.lifecycle.RenderLifecycleNativeObserverAdapter;
import com.arashivision.graphicpath.render.RenderLibsLoader;

public abstract class FilterObject extends RenderLifecycleNativeObserverAdapter {
    static {
        RenderLibsLoader.load();
    }

    public FilterObject(long j2, String str, RenderLifecycle renderLifecycle) {
        super(j2, str, renderLifecycle, FreeNativeOnDeinit.YES);
    }

    public native String getName();

    public native String getNickName();
}
