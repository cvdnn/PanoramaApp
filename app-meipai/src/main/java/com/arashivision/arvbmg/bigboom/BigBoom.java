package com.arashivision.arvbmg.bigboom;

import android.util.Log;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import e.a.a.a.a;
import java.nio.ByteBuffer;

public class BigBoom extends BMGNativeObjectRef {
    public static final String TAG = "com.arashivision.arvbmg.bigboom.BigBoom";
    public IFinishTrackCallback mFinishCallback;

    public interface IFinishTrackCallback {
        void onFinishTrack(TrackerDatas trackerDatas);
    }

    public BigBoom() {
        this(nativeCreateObject());
    }

    private void getTracker(Object obj) {
        IFinishTrackCallback iFinishTrackCallback = this.mFinishCallback;
        if (iFinishTrackCallback != null) {
            TrackerDatas trackerDatas = (TrackerDatas) obj;
            iFinishTrackCallback.onFinishTrack(trackerDatas);
            String str = TAG;
            StringBuilder a2 = a.a("trackdatas = ");
            a2.append(trackerDatas.toString());
            Log.d(str, a2.toString());
        }
    }

    private native void nativeCancel();

    private native void nativeConfigModel(String str, String str2);

    public static native long nativeCreateObject();

    private native void nativeFinish();

    private native void nativeGetCurrentBigBoom();

    private native String nativeGetVersion();

    private native void nativeProcessTrack(String str, long j2);

    private native void nativeProcessTrack2(ByteBuffer byteBuffer, int i2, int i3, long j2);

    private native void nativeReadVideo(BigBoomCfg bigBoomCfg);

    private native void nativeRelease();

    private native void nativeSetCallback();

    private native void nativeSetVideoInfo(int i2, int i3, long j2);

    private void release() {
        nativeRelease();
    }

    public void cancel() {
        nativeCancel();
    }

    public void configModel(String str, String str2) {
        nativeConfigModel(str, str2);
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void finish() {
        nativeFinish();
    }

    public void getCurrentBigBoom() {
        nativeGetCurrentBigBoom();
    }

    public String getVersion() {
        return nativeGetVersion();
    }

    public void processBigBoom(String str, long j2) {
        nativeProcessTrack(str, j2);
    }

    public void processBigBoom2(ByteBuffer byteBuffer, int i2, int i3, long j2) {
        nativeProcessTrack2(byteBuffer, i2, i3, j2);
    }

    public void readVideo(BigBoomCfg bigBoomCfg) {
        nativeReadVideo(bigBoomCfg);
    }

    public void setFinsihCallback(IFinishTrackCallback iFinishTrackCallback) {
        this.mFinishCallback = iFinishTrackCallback;
    }

    public void setVideoInfo(int i2, int i3, long j2) {
        nativeSetVideoInfo(i2, i3, j2);
    }

    public BigBoom(long j2) {
        super(j2, "BigBoom");
        nativeSetCallback();
    }
}
