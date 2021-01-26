package com.arashivision.bmgmedia.test;

import android.os.SystemClock;
import com.arashivision.insbase.arlog.Log;

public class FpsLoggr {
    public long mFrameCount;
    public String mName;
    public int mNumFrameToPrint = 30;
    public long mPrintTime;
    public long mStartTimeMs;

    public FpsLoggr(String str) {
        this.mName = str;
    }

    public void inc() {
        if (this.mFrameCount == 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mStartTimeMs = elapsedRealtime;
            this.mPrintTime = elapsedRealtime;
        }
        long j2 = this.mFrameCount + 1;
        this.mFrameCount = j2;
        if (j2 % ((long) this.mNumFrameToPrint) == 0) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j3 = elapsedRealtime2 - this.mPrintTime;
            this.mPrintTime = elapsedRealtime2;
            double d2 = (((double) this.mNumFrameToPrint) * 1000.0d) / ((double) j3);
            StringBuilder sb = new StringBuilder();
            sb.append(this.mName);
            sb.append(" fps: ");
            sb.append(d2);
            Log.i("ins", sb.toString());
        }
    }

    public void summarize() {
        long j2 = this.mPrintTime - this.mStartTimeMs;
        double d2 = (((double) this.mFrameCount) * 1000.0d) / ((double) j2);
        StringBuilder sb = new StringBuilder();
        sb.append(this.mName);
        sb.append(" summary: total frame: ");
        sb.append(this.mFrameCount);
        sb.append(", elapsed: ");
        sb.append(j2);
        sb.append("ms, avg fps: ");
        sb.append(d2);
        Log.i("ins", sb.toString());
    }
}
