package com.arashivision.graphicpath.lifecycle;

import com.arashivision.insbase.nativeref.NativeObjectRef;
import java.lang.ref.WeakReference;

public abstract class RenderLifecycleObserverAdapter extends NativeObjectRef implements RenderLifecycleObserver {
    public boolean mDiscarded;
    public boolean mEnabled;
    public WeakReference<RenderLifecycle> mLifecycle;
    public boolean mRenderDeinited;
    public boolean mRenderInited;
    public boolean mRenderTickTriggered;

    public RenderLifecycleObserverAdapter(RenderLifecycle renderLifecycle) {
        super(0, "RenderLifecycleObserverAdapter");
        this.mLifecycle = new WeakReference<>(renderLifecycle);
    }

    public void discard() {
        if (!this.mDiscarded) {
            this.mDiscarded = true;
            RenderLifecycle renderLifecycle = getRenderLifecycle();
            if (renderLifecycle != null) {
                renderLifecycle.removeRenderLifecycleObserver(this);
            }
        }
    }

    public void enable() {
        if (!this.mEnabled) {
            if (!this.mDiscarded) {
                RenderLifecycle renderLifecycle = getRenderLifecycle();
                if (renderLifecycle != null) {
                    this.mEnabled = true;
                    renderLifecycle.addRenderLifecycleObserver(this);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("shouldn't enable a discarded RenderLifecycleObserver: ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
    }

    public RenderLifecycle getRenderLifecycle() {
        return (RenderLifecycle) this.mLifecycle.get();
    }

    public boolean isDiscarded() {
        return this.mDiscarded;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isRenderDeinited() {
        return this.mRenderDeinited;
    }

    public boolean isRenderInited() {
        return this.mRenderInited;
    }

    public boolean isRenderObserverValid() {
        return this.mEnabled && !this.mDiscarded && this.mRenderInited && !this.mRenderDeinited;
    }

    public boolean isRenderTickTriggered() {
        return this.mRenderTickTriggered;
    }

    public void onRenderInited() {
        this.mRenderInited = true;
    }

    public void onRenderTick() {
        this.mRenderTickTriggered = true;
    }

    public final void onRenderWillDeinit() {
        this.mRenderDeinited = true;
        onRenderWillDeinit2();
    }

    public abstract void onRenderWillDeinit2();

    public RenderLifecycleObserverAdapter(long j2, String str, RenderLifecycle renderLifecycle) {
        super(j2, str);
        this.mLifecycle = new WeakReference<>(renderLifecycle);
    }
}
