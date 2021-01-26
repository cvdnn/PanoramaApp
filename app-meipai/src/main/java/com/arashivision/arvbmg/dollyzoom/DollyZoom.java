package com.arashivision.arvbmg.dollyzoom;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.HybridRender;

public class DollyZoom extends BMGNativeObjectRef {
    public IDollyzoomCallback mDollyzoomCallback;
    public IDollyzoomRectCallback mDollyzoomRectCallback;
    public IDollzoomInitCallback mDollzoomInitCallback;

    public interface IDollyzoomCallback {
        void onNotify(int i2, float f2, Object obj);
    }

    public interface IDollyzoomRectCallback {
        void updateRect(Object obj);
    }

    public interface IDollzoomInitCallback {
        void initCallback(boolean z, int i2, String str, Object obj);
    }

    public DollyZoom() {
        this(nativeCreateDollyObject());
    }

    private void checkRect(float[] fArr) {
        if (fArr == null) {
            throw new NullPointerException("rect shoud not null");
        } else if (fArr.length != 4) {
            throw new IllegalArgumentException("rect shoud four size ,left top right bottom");
        }
    }

    public static native long nativeCreateDollyObject();

    private native void nativeDeInit();

    private native Object nativeGetRenderFaceRect(float[] fArr);

    private native void nativeInitDollyzoom(int i2, int i3, double d2, double d3, int i4, int i5, float f2, float f3, float f4, int i6, int i7, String str, HybridRender hybridRender);

    private native void nativeLoadModel(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    private native void nativeSetDebug(boolean z);

    private native void nativeSetDollyCallback();

    private native void nativeStartDollyzoom(float f2, float f3, float f4, float f5, float f6, HybridRender hybridRender);

    private native void nativeStopRender(HybridRender hybridRender);

    private native void nativeUpdateRender(HybridRender hybridRender);

    private void onInitCallback(boolean z, int i2, String str, Object obj) {
        IDollzoomInitCallback iDollzoomInitCallback = this.mDollzoomInitCallback;
        if (iDollzoomInitCallback != null) {
            iDollzoomInitCallback.initCallback(z, i2, str, obj);
        }
    }

    private void onNotify(int i2, float f2, Object obj) {
        IDollyzoomCallback iDollyzoomCallback = this.mDollyzoomCallback;
        if (iDollyzoomCallback != null) {
            iDollyzoomCallback.onNotify(i2, f2, obj);
        }
    }

    private void onUpdateRect(Object obj) {
        IDollyzoomRectCallback iDollyzoomRectCallback = this.mDollyzoomRectCallback;
        if (iDollyzoomRectCallback != null) {
            iDollyzoomRectCallback.updateRect(obj);
        }
    }

    public void deInit() {
        nativeDeInit();
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public Object getRenderFaceRect(float[] fArr) {
        return nativeGetRenderFaceRect(fArr);
    }

    public void init(DollyZoomInfo dollyZoomInfo, HybridRender hybridRender) {
        DollyZoomInfo dollyZoomInfo2 = dollyZoomInfo;
        nativeInitDollyzoom(dollyZoomInfo2.mode, dollyZoomInfo2.interval, dollyZoomInfo2.screenX, dollyZoomInfo2.screenY, dollyZoomInfo2.firstWidth, dollyZoomInfo2.firstHeight, dollyZoomInfo2.minFov, dollyZoomInfo2.maxFov, dollyZoomInfo2.currentFov, dollyZoomInfo2.offscreenWidth, dollyZoomInfo2.offscreenHeight, dollyZoomInfo2.firstFramePath, hybridRender);
    }

    public void loadModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        nativeLoadModel(str, str2, str3, str4, str5, str6, str7);
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public void setDollyzoomCallback(IDollyzoomCallback iDollyzoomCallback) {
        this.mDollyzoomCallback = iDollyzoomCallback;
    }

    public void setDollyzoomRectCallback(IDollyzoomRectCallback iDollyzoomRectCallback) {
        this.mDollyzoomRectCallback = iDollyzoomRectCallback;
    }

    public void setDollzoomInitCallback(IDollzoomInitCallback iDollzoomInitCallback) {
        this.mDollzoomInitCallback = iDollzoomInitCallback;
    }

    public void start(float f2, float[] fArr, HybridRender hybridRender) {
        checkRect(fArr);
        nativeStartDollyzoom(f2, fArr[0], fArr[1], fArr[2], fArr[3], hybridRender);
    }

    public void stop(HybridRender hybridRender) {
        nativeStopRender(hybridRender);
    }

    public void update(HybridRender hybridRender) {
        nativeUpdateRender(hybridRender);
    }

    public DollyZoom(long j2) {
        super(j2, "DollyZoom");
        nativeSetDollyCallback();
    }
}
