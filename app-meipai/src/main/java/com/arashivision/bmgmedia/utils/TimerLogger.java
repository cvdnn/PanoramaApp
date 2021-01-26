package com.arashivision.bmgmedia.utils;

import android.os.SystemClock;
import com.arashivision.insbase.arlog.Log;
import e.a.a.a.a;

public class TimerLogger {
    public String mName;
    public long mStartTimeMs;
    public String mTag;

    public TimerLogger(String str) {
        this(str, "ins");
    }

    public void printElapsed() {
        printElapsed("default");
    }

    public void printElapsedAndReset() {
        printElapsed();
        reset();
    }

    public void reset() {
        this.mStartTimeMs = SystemClock.elapsedRealtime();
    }

    public TimerLogger(String str, String str2) {
        this.mTag = str2;
        this.mName = str;
        reset();
    }

    public void printElapsed(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTimeMs;
        String str2 = this.mTag;
        StringBuilder a2 = a.a("[");
        a.a(a2, this.mName, "] op: ", str, " elapsed: ");
        a2.append(elapsedRealtime);
        a2.append("ms");
        Log.i(str2, a2.toString());
    }
}
