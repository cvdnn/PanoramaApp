package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.filter.LottieUpdateInfo;

public class CompositeRenderModel extends RenderModel {
    public CompositeRenderModel(CompositeRenderModelSetup compositeRenderModelSetup, RenderLifecycle renderLifecycle) {
        this(compositeRenderModelSetup, "CompositeRenderModel", renderLifecycle);
    }

    public static native long createNativeWrap(CompositeRenderModelSetup compositeRenderModelSetup);

    public static native void nativeUpdateLottie(CompositeRenderModel compositeRenderModel, LottieUpdateInfo lottieUpdateInfo);

    public static void updateLottile(CompositeRenderModel compositeRenderModel, LottieUpdateInfo lottieUpdateInfo) {
        nativeUpdateLottie(compositeRenderModel, lottieUpdateInfo);
    }

    public void discard() {
        super.discard();
    }

    public void free() {
        super.free();
    }

    public CompositeRenderModel(CompositeRenderModelSetup compositeRenderModelSetup, String str, RenderLifecycle renderLifecycle) {
        super(createNativeWrap(compositeRenderModelSetup), str, renderLifecycle);
    }
}
