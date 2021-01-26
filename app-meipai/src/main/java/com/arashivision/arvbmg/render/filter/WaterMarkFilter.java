package com.arashivision.arvbmg.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.source.ImageAsset;

public class WaterMarkFilter extends BMGFilterObject {
    public WaterMarkFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "WaterMarkFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    private native void nativeSetWaterMark(ImageAsset imageAsset, float[] fArr);

    public void setWaterMark(ImageAsset imageAsset, float[] fArr) {
        nativeSetWaterMark(imageAsset, fArr);
    }
}
