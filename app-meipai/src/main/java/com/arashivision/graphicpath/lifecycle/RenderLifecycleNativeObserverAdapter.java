package com.arashivision.graphicpath.lifecycle;

public class RenderLifecycleNativeObserverAdapter extends RenderLifecycleObserverAdapter {
    public FreeNativeOnDeinit mFreeNativeOnDeinit;

    public RenderLifecycleNativeObserverAdapter(long j2, String str, RenderLifecycle renderLifecycle, FreeNativeOnDeinit freeNativeOnDeinit) {
        super(j2, str, renderLifecycle);
        this.mFreeNativeOnDeinit = freeNativeOnDeinit;
    }

    public void onRenderWillDeinit2() {
        if (this.mFreeNativeOnDeinit == FreeNativeOnDeinit.YES) {
            free();
        }
    }
}
