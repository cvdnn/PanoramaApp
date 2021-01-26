package com.arashivision.arvbmg.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class ImageBlendFilter extends BMGFilterObject {
    public ImageBlendFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "ImageBlendFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    private native void nativeSetBlendImageInfo(BlendImageInfo blendImageInfo);

    public void setBlendImageInfo(BlendImageInfo blendImageInfo) {
        nativeSetBlendImageInfo(blendImageInfo);
    }
}
