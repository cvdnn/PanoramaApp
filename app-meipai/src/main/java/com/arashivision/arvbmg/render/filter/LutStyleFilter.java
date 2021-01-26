package com.arashivision.arvbmg.render.filter;

import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.FilterName;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class LutStyleFilter extends LutFilter {
    public LutStyleFilter(RenderLifecycle renderLifecycle) {
        super(renderLifecycle, FilterName.LUT_STYLE_FILTER);
    }

    private native void nativeSetIntensity(float f2);

    public void setIntensity(float f2) {
        nativeSetIntensity(f2);
    }
}
