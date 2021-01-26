package com.arashivision.arvbmg.exporter;

import android.util.Log;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public class OneTrimExport extends OneExport {
    public static final String TAG = "OneTrimExport";
    public TrimExportListener mTrimExportListener;

    public interface TrimExportListener {
        void onKeyFrame();
    }

    public OneTrimExport(String[] strArr, String[] strArr2, long j2, long j3, boolean z) {
        super(createNativeWrap(strArr, strArr2, j2, j3, z), TAG);
        emptyListener();
        nativeSetupCallback();
    }

    public static native long createNativeWrap(String[] strArr, String[] strArr2, long j2, long j3, boolean z);

    private void emptyListener() {
        this.mTrimExportListener = new TrimExportListener() {
            public void onKeyFrame() {
                Log.i(OneTrimExport.TAG, " empty onKeyFrame");
            }
        };
    }

    private native long[] nativeGetFirstTimestampsMs();

    private native void nativeSetupCallback();

    private void onKeyFrame(VideoSampleGroup videoSampleGroup) {
        if (videoSampleGroup != null) {
            videoSampleGroup.free();
        }
        this.mTrimExportListener.onKeyFrame();
    }

    public long getFirstTimestampsMs() {
        long[] nativeGetFirstTimestampsMs = nativeGetFirstTimestampsMs();
        if (nativeGetFirstTimestampsMs.length > 0) {
            return nativeGetFirstTimestampsMs[0];
        }
        Log.e(TAG, " getFirstTimestampsMs empty ");
        return -1;
    }

    public long[] getFirstTimestampsMsS() {
        return nativeGetFirstTimestampsMs();
    }

    public void setCallback(TrimExportListener trimExportListener) {
        this.mTrimExportListener = trimExportListener;
    }
}
