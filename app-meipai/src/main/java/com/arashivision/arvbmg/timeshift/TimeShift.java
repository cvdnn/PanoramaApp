package com.arashivision.arvbmg.timeshift;

import com.arashivision.arvbmg.common.TrackerSequence;
import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class TimeShift extends BMGNativeObjectRef {
    public ITimeShiftCallback mITimeShiftCallback;

    public interface ITimeShiftCallback {
        void onGetResult(TimeShiftResult timeShiftResult);
    }

    public TimeShift() {
        this(nativeCreateTimeShift(), "TimeShift");
        nativeSetTimeshiftCallback();
    }

    private void checkInputUrls(String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("input urls should not empty");
        }
    }

    private native boolean nativeAppalyDirect(TrackerSequence trackerSequence);

    private native boolean nativeConfigOptions(TimeShiftConfig timeShiftConfig, String[] strArr);

    public static native long nativeCreateTimeShift();

    private native void nativeFinishGetResult();

    private native boolean nativeIsTracking();

    private native boolean nativePreocessTimeFrame(FrameExporterSample frameExporterSample);

    private native void nativeProcessFrame(long j2);

    private native void nativeSetTimeshiftCallback();

    private void onGetTimeShiftResult(TimeShiftResult timeShiftResult) {
        ITimeShiftCallback iTimeShiftCallback = this.mITimeShiftCallback;
        if (iTimeShiftCallback != null) {
            iTimeShiftCallback.onGetResult(timeShiftResult);
        }
    }

    public boolean appalyDirect(TrackerSequence trackerSequence) {
        return nativeAppalyDirect(trackerSequence);
    }

    public boolean configOptions(TimeShiftConfig timeShiftConfig, String[] strArr) {
        checkInputUrls(strArr);
        return nativeConfigOptions(timeShiftConfig, strArr);
    }

    public void finishGetResult() {
        nativeFinishGetResult();
    }

    public boolean isTracking() {
        return nativeIsTracking();
    }

    public void processFrame(long j2) {
        nativeProcessFrame(j2);
    }

    public boolean processTimeFrame(FrameExporterSample frameExporterSample) {
        if (frameExporterSample == null) {
            return false;
        }
        return nativePreocessTimeFrame(frameExporterSample);
    }

    public void setTimeShiftCallback(ITimeShiftCallback iTimeShiftCallback) {
        this.mITimeShiftCallback = iTimeShiftCallback;
    }

    public TimeShift(long j2, String str) {
        super(j2, str);
    }
}
