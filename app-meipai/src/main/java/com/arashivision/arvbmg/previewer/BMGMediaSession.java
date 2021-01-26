package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public abstract class BMGMediaSession {
    public FrameOutput frameOutput;
    public Context mContext;
    public boolean mDebug;
    public int mFrameCount;
    public SessionCallback mSessionCallback;
    public long mStartTime;

    public interface FrameOutput {
        void onFrame(VideoSampleGroup videoSampleGroup);
    }

    public interface SessionCallback {
        void onComplete(int i2);

        void onDecodeReport(int i2, int i3);

        void onFail(int i2, String str, String str2);

        void onFpsNotify(double d2);

        void onPrepared();

        void onReBuffer(int i2, int i3);

        void onSeek(int i2, int i3, String str, String str2);

        void onSubStreamDecodeReport(int i2, int i3);

        void onSubStreamFail(int i2, String str, String str2);

        void onSubStreamPrepared();

        void onSubStreamReBuffer(int i2, int i3);

        void onSubStreamSeek(int i2, int i3, String str, String str2);
    }

    public BMGMediaSession(Context context) {
        this.mContext = context;
    }

    public abstract void clearPreviewer();

    public void enableDebug() {
        this.mDebug = true;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public void notifyFps(int i2) {
        long nanoTime = System.nanoTime();
        int i3 = this.mFrameCount + 1;
        this.mFrameCount = i3;
        if (i3 % i2 == 0) {
            long j2 = this.mStartTime;
            if (j2 != 0) {
                double d2 = ((double) (i2 * 1000)) / (((double) (nanoTime - j2)) / 1000000.0d);
                if (isDebug()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("preview decode fps: ");
                    sb.append(d2);
                    Log.i(BMGConstants.TAG, sb.toString());
                }
                SessionCallback sessionCallback = this.mSessionCallback;
                if (sessionCallback != null) {
                    sessionCallback.onFpsNotify(d2);
                }
            }
            this.mStartTime = nanoTime;
        }
    }

    public void onComplete(int i2) {
        this.mSessionCallback.onComplete(i2);
    }

    public void onDecodeReport(int i2, int i3) {
        this.mSessionCallback.onDecodeReport(i2, i3);
    }

    public void onFail(int i2, String str, String str2) {
        this.mSessionCallback.onFail(i2, str, str2);
    }

    public void onReBuffer(int i2, int i3) {
        this.mSessionCallback.onReBuffer(i2, i3);
    }

    public void onSubStreamDecodeReport(int i2, int i3) {
        this.mSessionCallback.onSubStreamDecodeReport(i2, i3);
    }

    public void onSubStreamFail(int i2, String str, String str2) {
        this.mSessionCallback.onSubStreamFail(i2, str, str2);
    }

    public void onSubStreamReBuffer(int i2, int i3) {
        this.mSessionCallback.onSubStreamReBuffer(i2, i3);
    }

    public void onSubStreamSeek(int i2, int i3, String str, String str2) {
        this.mSessionCallback.onSubStreamSeek(i2, i3, str, str2);
    }

    public void setFrameOutput(FrameOutput frameOutput2) {
        if (frameOutput2 != this.frameOutput) {
            this.frameOutput = frameOutput2;
            if (frameOutput2 == null) {
                clearPreviewer();
            } else {
                setupPreviewer();
            }
        }
    }

    public final void setSessionCallback(SessionCallback sessionCallback) {
        this.mSessionCallback = sessionCallback;
    }

    public abstract void setupPreviewer();

    public void terminate() {
        clearPreviewer();
    }
}
