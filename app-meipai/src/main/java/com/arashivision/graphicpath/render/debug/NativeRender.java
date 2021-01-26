package com.arashivision.graphicpath.render.debug;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public abstract class NativeRender extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public NativeRender(long j2) {
        this(j2, "NativeRender");
    }

    public native void nativeRender(int i2);

    public abstract void render(int i2);

    public NativeRender(long j2, String str) {
        super(j2, str);
    }
}
