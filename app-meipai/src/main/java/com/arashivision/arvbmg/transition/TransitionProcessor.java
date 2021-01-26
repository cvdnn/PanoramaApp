package com.arashivision.arvbmg.transition;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class TransitionProcessor extends BMGNativeObjectRef {
    public TransitionProcessor(TransState transState, LayerInfo layerInfo, long j2, long j3) {
        this(nativeCreateTransObj(transState, layerInfo, j2, j3));
    }

    public static native long nativeCreateTransObj(TransState transState, LayerInfo layerInfo, long j2, long j3);

    private native long nativeGetDuration();

    private native TransState nativeGetTransitionState(long j2);

    private native String nativeGetVersion();

    private native boolean nativeOpenLayer();

    public static native TransitionInfo nativeReadTransitionJson(String str);

    public static native TransitionInfo nativeReadTransitionJsonStr(String str);

    public static TransitionInfo readTransitionJson(String str) {
        return nativeReadTransitionJson(str);
    }

    public static TransitionInfo readTransitionJsonStr(String str) {
        return nativeReadTransitionJsonStr(str);
    }

    public long getDuration() {
        return nativeGetDuration();
    }

    public TransState getTransitionState(long j2) {
        return nativeGetTransitionState(j2);
    }

    public String getVersion() {
        return nativeGetVersion();
    }

    public boolean isOpen() {
        return nativeOpenLayer();
    }

    public TransitionProcessor(long j2) {
        super(j2, "TransitionProcessor");
    }
}
