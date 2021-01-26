package com.arashivision.arvbmg.render.rendermodel;

import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class BMGCompositeRenderModel extends RenderModel {
    static {
        ARVBMGLibsLoader.load();
    }

    public BMGCompositeRenderModel(BMGCompositeSetup bMGCompositeSetup, RenderLifecycle renderLifecycle) {
        this(bMGCompositeSetup, "BMGCompositeRenderModel", renderLifecycle);
    }

    public static native long createNativeWrap(BMGCompositeSetup bMGCompositeSetup);

    private native void nativeUpdate2(LottieUpdateInfo lottieUpdateInfo);

    private native void nativeUpdateMultiViewInfo(MultiViewRectInfo multiViewRectInfo);

    private native void nativeUpdateMultiViewState(boolean z);

    public void discard() {
        super.discard();
    }

    public void free() {
        super.free();
    }

    public void update(LottieUpdateInfo lottieUpdateInfo) {
        nativeUpdate2(lottieUpdateInfo);
    }

    public void updateMultiViewInfo(MultiViewRectInfo multiViewRectInfo) {
        nativeUpdateMultiViewInfo(multiViewRectInfo);
    }

    public void updateMultiViewState(boolean z) {
        nativeUpdateMultiViewState(z);
    }

    public BMGCompositeRenderModel(BMGCompositeSetup bMGCompositeSetup, String str, RenderLifecycle renderLifecycle) {
        super(createNativeWrap(bMGCompositeSetup), str, renderLifecycle);
    }
}
