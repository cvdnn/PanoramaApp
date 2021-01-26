package com.arashivision.graphicpath.render.debug;

import android.view.Surface;
import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class NativeGLContext extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public NativeGLContext(int i2, Surface surface) {
        this(createNativeWrap(i2, surface), "NativeGLContext");
        setRequireFreeManually();
    }

    public static native long createNativeWrap(int i2, Surface surface);

    public native void swapBuffers();

    public NativeGLContext(long j2, String str) {
        super(j2, str);
    }
}
