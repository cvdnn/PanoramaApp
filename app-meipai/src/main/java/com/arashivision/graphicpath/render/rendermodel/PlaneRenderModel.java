package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;

public class PlaneRenderModel extends RenderModel {
    public PlaneRenderModel(RenderLifecycle renderLifecycle) {
        this(createNativeWrap(null), renderLifecycle);
    }

    public static native long createNativeWrap(RenderModelType renderModelType);

    public PlaneRenderModel(RenderModelType renderModelType, RenderLifecycle renderLifecycle) {
        this(createNativeWrap(renderModelType), renderLifecycle);
    }

    public PlaneRenderModel(long j2, RenderLifecycle renderLifecycle) {
        super(j2, renderLifecycle);
    }
}
