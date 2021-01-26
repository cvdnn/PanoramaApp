package com.arashivision.arvbmg.trimjson;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import java.util.List;

public class TrimJson extends BMGNativeObjectRef {
    public ITrimJsonCallback mTrimJsonCallback;

    public interface ITrimJsonCallback {
        void onTrimResult(TrimResult trimResult);
    }

    public TrimJson() {
        this(NativeCreateTrimObj());
    }

    public static native long NativeCreateTrimObj();

    private native int nativeReadJsonList(List<JsonTrimInfo> list);

    private native void nativeSetDebug(boolean z);

    private native void nativeSetTrimCallback();

    private native void nativeStartTrim();

    private void onTrimResult(TrimResult trimResult) {
        ITrimJsonCallback iTrimJsonCallback = this.mTrimJsonCallback;
        if (iTrimJsonCallback != null) {
            iTrimJsonCallback.onTrimResult(trimResult);
        }
    }

    public int readJsonList(List<JsonTrimInfo> list) {
        return nativeReadJsonList(list);
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public void setTrimJsonCallback(ITrimJsonCallback iTrimJsonCallback) {
        this.mTrimJsonCallback = iTrimJsonCallback;
    }

    public void startTrim() {
        nativeStartTrim();
    }

    public TrimJson(long j2) {
        super(j2, "trim json");
        nativeSetTrimCallback();
    }
}
