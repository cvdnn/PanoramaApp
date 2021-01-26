package com.arashivision.graphicpath.render;

import android.text.TextUtils;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;
import com.arashivision.graphicpath.render.source.Source;
import com.arashivision.insbase.arlog.Log;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class HybridRender extends NativeObjectRef {
    public static final String TAG = "ins";
    public boolean inited_;
    public boolean mDestroyed;
    public EglContextGroup mEglContextGroup;
    public long mEglContextShared;
    public RenderLifecycle mLifecycle;
    public String mName;
    public Notify mNotify;
    public RenderCallback mRenderCallback;
    public boolean mStarted;
    public Object mUser;

    public interface Notify {
        void onRenderNotify(HybridRender hybridRender, int i2, int i3, int i4);
    }

    public interface RenderCallback {
        void onRender(HybridRender hybridRender);
    }

    public static class ResultCache {
        public EglContextGroup eglContextGroup;
        public long eglContextShared;
        public long nativeWrap;
        public Object user;

        public ResultCache(long j2, long j3, Object obj, EglContextGroup eglContextGroup2) {
            this.nativeWrap = j2;
            this.eglContextShared = j3;
            this.user = obj;
            this.eglContextGroup = eglContextGroup2;
        }
    }

    static {
        RenderLibsLoader.load();
    }

    public HybridRender(String str) {
        this(setupAndCreateNativeWrap(null), str);
    }

    public static native long createNativeWrap(long j2);

    private native void nativeDestroy();

    private native void nativeInit();

    private native void nativePrepareRenderModels(RenderModel[] renderModelArr);

    private native void nativeResume();

    private native void nativeSetRootRenderModel(RenderModel renderModel);

    private void onNotify(int i2, int i3, int i4) {
        if (i2 == 1) {
            Log.i("ins", "render inited");
            Thread currentThread = Thread.currentThread();
            StringBuilder sb = new StringBuilder();
            sb.append(this.mName);
            sb.append("-render");
            currentThread.setName(sb.toString());
            this.mLifecycle.onRenderInited();
            this.inited_ = true;
        }
        if (i2 == 2) {
            this.mLifecycle.onRenderWillDeinit();
        }
        Notify notify = this.mNotify;
        if (notify != null) {
            notify.onRenderNotify(this, i2, i3, i4);
        }
    }

    private void onRender() {
        if (!this.inited_) {
            Thread currentThread = Thread.currentThread();
            StringBuilder sb = new StringBuilder();
            sb.append(this.mName);
            sb.append("-render");
            currentThread.setName(sb.toString());
            this.mLifecycle.onRenderInited();
            this.inited_ = true;
            Log.e("ins", "render running without inited notification");
        }
        this.mLifecycle.onRenderTick();
        RenderCallback renderCallback = this.mRenderCallback;
        if (renderCallback != null) {
            renderCallback.onRender(this);
        }
    }

    public static ResultCache setupAndCreateNativeWrap(EglContextGroup eglContextGroup) {
        if (eglContextGroup != null) {
            Object obj = new Object();
            long acquireEglContext = eglContextGroup.acquireEglContext(obj);
            ResultCache resultCache = new ResultCache(createNativeWrap(acquireEglContext), acquireEglContext, obj, eglContextGroup);
            return resultCache;
        }
        ResultCache resultCache2 = new ResultCache(createNativeWrap(0), 0, null, null);
        return resultCache2;
    }

    public void finalize() throws Throwable {
        if (!this.mDestroyed) {
            Log.e("ins", "HybridRender: finalize: not destroyed! Should release it manually! Force release...");
            free();
        }
        super.finalize();
    }

    public void free() {
        if (!this.mDestroyed) {
            this.mDestroyed = true;
            nativeDestroy();
            super.free();
            EglContextGroup eglContextGroup = this.mEglContextGroup;
            if (eglContextGroup != null) {
                eglContextGroup.releaseEglContext(this.mUser, this.mEglContextShared);
                this.mUser = null;
                this.mEglContextShared = 0;
                this.mEglContextGroup = null;
            }
        }
    }

    public RenderLifecycle getRenderLifecycle() {
        return this.mLifecycle;
    }

    public native Source getSource();

    public native void pause();

    public void prepareRenderModels(RenderModel[] renderModelArr) {
        nativePrepareRenderModels(renderModelArr);
    }

    public void resume() {
        nativeResume();
        this.mStarted = true;
    }

    public native void setClearColor(float f2, float f3, float f4, float f5);

    public native void setFps(double d2);

    public void setNotify(Notify notify) {
        this.mNotify = notify;
    }

    public void setRenderCallback(RenderCallback renderCallback) {
        this.mRenderCallback = renderCallback;
    }

    public void setRootRenderModel(RenderModel renderModel) {
        if (!this.mStarted || this.mLifecycle.isInsideRenderThread()) {
            if (renderModel != null) {
                renderModel.enable();
            }
            nativeSetRootRenderModel(renderModel);
            return;
        }
        if (!this.inited_) {
            Log.e("ins", "render init notify not happen?");
        }
        throw new RuntimeException("set root render model outside render thread while started");
    }

    public native void setSource(Source source);

    public HybridRender(EglContextGroup eglContextGroup, String str) {
        this(setupAndCreateNativeWrap(eglContextGroup), str);
    }

    public HybridRender(ResultCache resultCache, String str) {
        String str2 = "HybridRender";
        super(resultCache.nativeWrap, TextUtils.isEmpty(str) ? str2 : str);
        this.mLifecycle = new RenderLifecycle();
        this.inited_ = false;
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        this.mName = str;
        this.mEglContextGroup = resultCache.eglContextGroup;
        this.mEglContextShared = resultCache.eglContextShared;
        this.mUser = resultCache.user;
        nativeInit();
    }
}
