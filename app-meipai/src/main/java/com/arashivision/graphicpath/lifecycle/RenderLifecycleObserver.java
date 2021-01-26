package com.arashivision.graphicpath.lifecycle;

public interface RenderLifecycleObserver extends LifecycleObserver {
    void discard();

    void enable();

    RenderLifecycle getRenderLifecycle();

    void onRenderInited();

    void onRenderTick();

    void onRenderWillDeinit();
}
