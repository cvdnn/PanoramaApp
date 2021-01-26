package com.arashivision.onecamera;

import android.util.Log;
import com.arashivision.onecamera.OneDriver.NativeLibsLoader;
import com.arashivision.onecamera.OneDriverInfo.PhotographyOptions;

public class PhotoOptions {
    public static final String TAG = "PhotoOptions";
    public long mNativeInstance;
    public State mState = State.Working;

    public enum State {
        Working,
        Release
    }

    static {
        NativeLibsLoader.load();
    }

    public PhotoOptions() {
        nativeCreate();
    }

    private native void nativeCreate();

    private native boolean nativeGetBoolean(String str);

    private native double nativeGetDouble(String str);

    private native int nativeGetInt32(String str);

    private native long nativeGetInt64(String str);

    private native int[] nativeGetIntArray(String str);

    private native String nativeGetString(String str);

    private native void nativeRelease();

    private native void nativeSetBoolean(String str, boolean z);

    private native void nativeSetDouble(String str, double d2);

    private native void nativeSetInt32(String str, int i2);

    private native void nativeSetInt64(String str, long j2);

    private native void nativeSetIntArray(String str, int[] iArr);

    private native void nativeSetString(String str, String str2);

    private void setStillExposureOptionISO(int i2) {
        nativeSetInt32("still_exposure_options-iso", i2);
    }

    private void setStillExposureOptionShutter(double d2) {
        nativeSetDouble("still_exposure_options-shutter_speed", d2);
    }

    private void setVideoExposureOptionISO(int i2) {
        nativeSetInt32("video_exposure_options-iso", i2);
    }

    private void setVideoExposureOptionShutter(double d2) {
        nativeSetDouble("video_exposure_options-shutter_speed", d2);
    }

    public void finalize() throws Throwable {
        if (this.mState != State.Release) {
            release();
        } else {
            Log.e(TAG, "finalize(): PhotoOptions already released");
        }
        super.finalize();
    }

    public int getAEBCaptureNum() {
        return nativeGetInt32(PhotographyOptions.AEB_CAPTURE_NUM);
    }

    public int[] getAEManualMeterWeight() {
        return nativeGetIntArray(PhotographyOptions.AE_MANUAL_METER_WEIGHT);
    }

    public int getAEMeterMode() {
        return nativeGetInt32(PhotographyOptions.AE_METER_MODE);
    }

    public int getBrightness() {
        return nativeGetInt32("brightness");
    }

    public int getChannel() {
        return nativeGetInt32("channel");
    }

    public int getContrast() {
        return nativeGetInt32("contrast");
    }

    public int getEVIndex() {
        return nativeGetInt32(PhotographyOptions.EV_INDEX);
    }

    public int getExposureBias() {
        return nativeGetInt32(PhotographyOptions.EXPOSURE_BIAS);
    }

    public int getFlicker() {
        return nativeGetInt32(PhotographyOptions.FLICKER);
    }

    public boolean getFlowStateEnable() {
        return nativeGetBoolean(PhotographyOptions.FLOW_STATE_ENABLE);
    }

    public int getFovType() {
        return nativeGetInt32("fov_type");
    }

    public int getHue() {
        return nativeGetInt32(PhotographyOptions.HUE);
    }

    public boolean getLogModeEnable() {
        return nativeGetBoolean(PhotographyOptions.LOG_MODE_ENABLE);
    }

    public int getPhotoSelfTimer() {
        return nativeGetInt32(PhotographyOptions.PHOTOGRAPHY_SELF_TIMER);
    }

    public int getPhotoSize() {
        return nativeGetInt32(PhotographyOptions.PHOTO_SIZE_ID);
    }

    public boolean getPreviewMctfEnable() {
        return nativeGetBoolean(PhotographyOptions.PREVIEW_MCTF_ENABLE);
    }

    public int getPreviewSportLevel() {
        return nativeGetInt32(PhotographyOptions.PREVIEW_SPORT_LEVEL);
    }

    public boolean getPreviewSportModeModeEnable() {
        return nativeGetBoolean(PhotographyOptions.PREVIEW_SPORT_MODE_ENABLE);
    }

    public int getRawCaptureType() {
        return nativeGetInt32(PhotographyOptions.RAW_CAPTURE_TYPE);
    }

    public int getRecordDuration() {
        return nativeGetInt32(PhotographyOptions.RECORD_DURAION);
    }

    public int getSaturation() {
        return nativeGetInt32("saturation");
    }

    public int getSharpness() {
        return nativeGetInt32("sharpness");
    }

    public int getStillExposureOptionISO() {
        return nativeGetInt32("still_exposure_options-iso");
    }

    public int getStillExposureOptionProgram() {
        return nativeGetInt32(PhotographyOptions.STILL_EXPOSURE_OPTIONS);
    }

    public double getStillExposureOptionShutter() {
        return nativeGetDouble("still_exposure_options-shutter_speed");
    }

    public int getVideoBitrate() {
        return nativeGetInt32("video_bitrate");
    }

    public int getVideoExposureOptionISO() {
        return nativeGetInt32("video_exposure_options-iso");
    }

    public int getVideoExposureOptionProgram() {
        return nativeGetInt32(PhotographyOptions.VIDEO_EXPOSURE_OPTIONS);
    }

    public double getVideoExposureOptionShutter() {
        return nativeGetDouble("video_exposure_options-shutter_speed");
    }

    public int getVideoISOTopLimit() {
        return nativeGetInt32(PhotographyOptions.VIDEO_ISO_TOP_LIMIT);
    }

    public int getVideoResolution() {
        return nativeGetInt32(PhotographyOptions.RECORD_RESOLUTION);
    }

    public int getWhiteBalance() {
        return nativeGetInt32(PhotographyOptions.WHITE_BALANCE);
    }

    public void release() {
        Log.i(TAG, "release");
        nativeRelease();
        this.mState = State.Release;
    }

    public void setAEBCaptureNum(int i2) {
        nativeSetInt32(PhotographyOptions.AEB_CAPTURE_NUM, i2);
    }

    public void setAEManualMeterWeight(int[] iArr) {
        nativeSetIntArray(PhotographyOptions.AE_MANUAL_METER_WEIGHT, iArr);
    }

    public void setAEMeterMode(int i2) {
        nativeSetInt32(PhotographyOptions.AE_METER_MODE, i2);
    }

    public void setBrightness(int i2) {
        nativeSetInt32("brightness", i2);
    }

    public void setChannel(int i2) {
        nativeSetInt32("channel", i2);
    }

    public void setContrast(int i2) {
        nativeSetInt32("contrast", i2);
    }

    public void setExposureBias(int i2) {
        nativeSetInt32(PhotographyOptions.EXPOSURE_BIAS, i2);
    }

    public void setFlicker(int i2) {
        nativeSetInt32(PhotographyOptions.FLICKER, i2);
    }

    public void setFlowStateEnable(boolean z) {
        nativeSetBoolean(PhotographyOptions.FLOW_STATE_ENABLE, z);
    }

    public void setFovType(int i2) {
        nativeSetInt32("fov_type", i2);
    }

    public void setHue(int i2) {
        nativeSetInt32(PhotographyOptions.HUE, i2);
    }

    public void setLogModeEnable(boolean z) {
        nativeSetBoolean(PhotographyOptions.LOG_MODE_ENABLE, z);
    }

    public void setPhotoSelfTimer(int i2) {
        nativeSetInt32(PhotographyOptions.PHOTOGRAPHY_SELF_TIMER, i2);
    }

    public void setPhotoSize(int i2) {
        nativeSetInt32(PhotographyOptions.PHOTO_SIZE_ID, i2);
    }

    public void setPreviewMctfEnable(boolean z) {
        nativeSetBoolean(PhotographyOptions.PREVIEW_MCTF_ENABLE, z);
    }

    public void setPreviewSportLevel(int i2) {
        nativeSetInt32(PhotographyOptions.PREVIEW_SPORT_LEVEL, i2);
    }

    public void setPreviewSportModeModeEnable(boolean z) {
        nativeSetBoolean(PhotographyOptions.PREVIEW_SPORT_MODE_ENABLE, z);
    }

    public void setRawCaptureType(int i2) {
        nativeSetInt32(PhotographyOptions.RAW_CAPTURE_TYPE, i2);
    }

    public void setRecordDuration(int i2) {
        nativeSetInt32(PhotographyOptions.RECORD_DURAION, i2);
    }

    public void setSaturation(int i2) {
        nativeSetInt32("saturation", i2);
    }

    public void setSharpness(int i2) {
        nativeSetInt32("sharpness", i2);
    }

    public void setStillExposureOption(int i2, int i3, double d2) {
        setStillExposureOptionProgram(i2);
        setStillExposureOptionISO(i3);
        setStillExposureOptionShutter(d2);
    }

    public void setStillExposureOptionProgram(int i2) {
        nativeSetInt32(PhotographyOptions.STILL_EXPOSURE_OPTIONS, i2);
    }

    public void setVideoBitrate(int i2) {
        nativeSetInt32("video_bitrate", i2);
    }

    public void setVideoExposureOption(int i2, int i3, double d2) {
        setVideoExposureOptionProgram(i2);
        setVideoExposureOptionISO(i3);
        setVideoExposureOptionShutter(d2);
    }

    public void setVideoExposureOptionProgram(int i2) {
        nativeSetInt32(PhotographyOptions.VIDEO_EXPOSURE_OPTIONS, i2);
    }

    public void setVideoISOTopLimit(int i2) {
        nativeSetInt32(PhotographyOptions.VIDEO_ISO_TOP_LIMIT, i2);
    }

    public void setVideoResolution(int i2) {
        nativeSetInt32(PhotographyOptions.RECORD_RESOLUTION, i2);
    }

    public void setWhiteBalance(int i2) {
        nativeSetInt32(PhotographyOptions.WHITE_BALANCE, i2);
    }
}
