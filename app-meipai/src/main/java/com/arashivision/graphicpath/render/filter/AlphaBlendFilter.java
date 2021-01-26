package com.arashivision.graphicpath.render.filter;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.source.ImageAsset;

public class AlphaBlendFilter extends FilterObject {
    public AlphaBlendFilter(RenderLifecycle renderLifecycle) {
        super(createNativeWrap(), "AlphaBlendFilter", renderLifecycle);
    }

    public static native long createNativeWrap();

    public native float getAlpha();

    public native void setAlpha(float f2);

    public native void setInputBackgroundImage(ImageAsset imageAsset);
}
