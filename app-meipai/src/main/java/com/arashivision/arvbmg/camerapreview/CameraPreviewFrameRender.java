package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import com.arashivision.graphicpath.render.HybridRender;

public class CameraPreviewFrameRender {
    static {
        ARVBMGLibsLoader.load();
    }

    public static native int nativeRender(HybridRender hybridRender, int i2, int i3, String str, int i4, boolean z);
}
