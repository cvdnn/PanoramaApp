package com.arashivision.onecamera;

import android.util.Log;
import com.arashivision.onecamera.OneDriver.NativeLibsLoader;
import com.arashivision.onecamera.cameranotification.BatteryStatus;
import com.arashivision.onecamera.cameranotification.StorageState;
import com.arashivision.onecamera.camerarequest.WifiInfo;
import com.arashivision.onecamera.options.ButtonPressOptions;

public class Options {
    public static final String TAG = "Options";
    public long mNativeInstance;
    public State mState = State.Working;

    public enum State {
        Working,
        Release
    }

    static {
        NativeLibsLoader.load();
    }

    public Options() {
        Log.d(TAG, "Options create");
        nativeCreate();
    }

    private native void nativeCreate();

    private native boolean nativeGetBoolean(String str);

    private native int nativeGetInt32(String str);

    private native long nativeGetInt64(String str);

    private native String nativeGetString(String str);

    private native void nativeRelease();

    private native void nativeSetBoolean(String str, boolean z);

    private native void nativeSetInt32(String str, int i2);

    private native void nativeSetInt64(String str, long j2);

    private native void nativeSetString(String str, String str2);

    private void setPhotoHeight(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.PHOTO_SIZE_HEIGHT, i2);
    }

    private void setPhotoWidth(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.PHOTO_SIZE_WIDTH, i2);
    }

    private void setVideoFps(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_RESULUTION_FPS, i2);
    }

    private void setVideoHeight(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_RESULUTION_HEIGHT, i2);
    }

    private void setVideoWidth(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_RESULUTION_WIDTH, i2);
    }

    public void enableInternalFlowState(boolean z) {
        nativeSetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.INTERNAL_FLOWSTATE, z);
    }

    public void finalize() throws Throwable {
        if (this.mState != State.Release) {
            release();
        } else {
            Log.e(TAG, "finalize(): Options already released");
        }
        super.finalize();
    }

    public int getAccFullRange() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.ACC_FULL_SCALE_RANGE);
    }

    public long getActiveTime() {
        return nativeGetInt64(com.arashivision.onecamera.OneDriverInfo.Options.ACTIVATE_TIME);
    }

    public int getAdoptionSystem() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.APOPTION_SYSTEM);
    }

    public int getAudioBitrate() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.AUDIO_BITRATE);
    }

    public int getAudioSampleRate() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.AUDIO_SAMPLERATE);
    }

    public String getAuthorizationID() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.AUTHORIZATION_ID);
    }

    public BatteryStatus getBatteryStatus() {
        BatteryStatus batteryStatus = new BatteryStatus();
        batteryStatus.power_type = getBatteryStatusPowerType();
        batteryStatus.battery_level = getBatteryStatusBatteryLevel();
        batteryStatus.battery_scale = getBatteryStatusBatteryScale();
        return batteryStatus;
    }

    public int getBatteryStatusBatteryLevel() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BATTERY_LEVEL);
    }

    public int getBatteryStatusBatteryScale() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BATTERY_SCALE);
    }

    public int getBatteryStatusPowerType() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BATTERY_POWER_TYPE);
    }

    public ButtonPressOptions getButtonPressOption() {
        ButtonPressOptions buttonPressOptions = new ButtonPressOptions();
        buttonPressOptions.click = getClickint();
        buttonPressOptions.double_click = getDoubelClickint();
        buttonPressOptions.triple_click = getTripleClickint();
        buttonPressOptions.long_press = getLongPressint();
        buttonPressOptions.shutdown_click = getShutdownClickint();
        buttonPressOptions.shutdown_short_press = getShutdownShortPressint();
        return buttonPressOptions;
    }

    public String getCPUType() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.CPU_TYPE);
    }

    public String getCalibrateOffset3D() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.CALIBRATION_OFFSET_3D);
    }

    public String getCalibrationOffset() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.CALIBRATION_OFFSET);
    }

    public String getCameraType() {
        return nativeGetString("camera_type");
    }

    public int getCaptureLimitTime() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.CAPTURE_TIME_LIMIT);
    }

    public int getClickint() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_CLICK);
    }

    public int getDoubelClickint() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_DOUBLE_CLICK);
    }

    public int getEVOStatusMode() {
        return nativeGetInt32("evo_status_mode");
    }

    public String getFWVersion() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.FIRMWAREREVISION);
    }

    public int getGPSTimeout() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.GPS_TIMEOUT);
    }

    public int getGyroFullRange() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.GYRO_FULL_SCALE_RANGE);
    }

    public int getGyroSampleRate() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.GYRO_SAMPLE_RATE);
    }

    public int getImageFilcker() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.IMAGE_FLICKER);
    }

    public boolean getInternalFlowState() {
        return nativeGetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.INTERNAL_FLOWSTATE);
    }

    public int getLensIndex() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.LENS_INDEX);
    }

    public long getLocalTime() {
        return nativeGetInt64(com.arashivision.onecamera.OneDriverInfo.Options.LOCAL_TIME);
    }

    public boolean getLogMode() {
        return nativeGetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.LOG_MODE);
    }

    public int getLongPressint() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_LONG_PRESS);
    }

    public boolean getMCTFEnable() {
        return nativeGetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.MCTF_ENABLE);
    }

    public String getMediaOffset() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.MEDIA_OFFSET);
    }

    public String getMediaOffset3D() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.MEDIA_OFFSET_3D);
    }

    public long getMediaTime() {
        return nativeGetInt64(com.arashivision.onecamera.OneDriverInfo.Options.MEDIA_TIME);
    }

    public boolean getMute() {
        return nativeGetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.MUTE);
    }

    public String getOriginOffset() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.ORIGIN_OFFSET);
    }

    public String getOriginOffset3D() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.ORIGIN_OFFSET_3D);
    }

    public int getPhotoHeight() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.PHOTO_SIZE_HEIGHT);
    }

    public int getPhotoWidth() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.PHOTO_SIZE_WIDTH);
    }

    public int getQualitySetting() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.QUALITY_SETTING);
    }

    public int getRemainCaptureTime() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.REMAINING_CAPTURE_TIME);
    }

    public int getRemainPictures() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.REMAINIG_PICTURES);
    }

    public int getRemoteType() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BT_REMOTE_TYPE);
    }

    public String getRemoteVersion() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.BT_REMOTE_VERSION);
    }

    public String getSN() {
        return nativeGetString("serial_number");
    }

    public int getSecodStreamRes() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.SECOND_STREAM_RES);
    }

    public int getSelfTimer() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.SELF_TIMER);
    }

    public String getSensor0Serial() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.SENSOR0_SERIAL_VR360);
    }

    public String getSensor1Serial() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.SENSOR1_SERIAL_VR360);
    }

    public int getShutdownClickint() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_SHUTDOWN_CLICK);
    }

    public int getShutdownShortPressint() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_SHUTDOWN_SHORT_PRESS);
    }

    public boolean getSportModeEnable() {
        return nativeGetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.SPORT_MODE_ENABLE);
    }

    public int getStorageCardState() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.STORAGE_CARD_STATE);
    }

    public long getStorageFreeSpace() {
        return nativeGetInt64(com.arashivision.onecamera.OneDriverInfo.Options.STORAGE_FREE_SPACE);
    }

    public StorageState getStorageState() {
        StorageState storageState = new StorageState();
        storageState.total_space = getStorageTotalSpace();
        storageState.free_space = getStorageFreeSpace();
        storageState.card_state = getStorageCardState();
        return storageState;
    }

    public long getStorageTotalSpace() {
        return nativeGetInt64(com.arashivision.onecamera.OneDriverInfo.Options.STORAGE_TOTAL_SPACE);
    }

    public int getSubPhotoMode() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.PHOTO_SUB_MODE);
    }

    public int getSubVideoMode() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_SUB_MODE);
    }

    public boolean getTakeRawPicture() {
        return nativeGetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.TAKE_RAW_PICTURE);
    }

    public int getTimezoneSecodeFromGMT() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.TIME_ZONE);
    }

    public int getTripleClickint() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_TRIPLE_CLICK);
    }

    public String getUUID() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.ONE_UUID);
    }

    public int getVideoBitrate() {
        return nativeGetInt32("video_bitrate");
    }

    public int getVideoEncodeType() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_ENCODE_TYPE);
    }

    public int getVideoFPS() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_RESULUTION_FPS);
    }

    public int getVideoHeight() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_RESULUTION_HEIGHT);
    }

    public int getVideoWidth() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_RESULUTION_WIDTH);
    }

    public String getWifiChannelCounty() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_CH_COUNTY);
    }

    public WifiInfo getWifiInfo() {
        WifiInfo wifiInfo = new WifiInfo();
        wifiInfo.setSsid(nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_SSID));
        wifiInfo.setPwd(nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_PWD));
        wifiInfo.setChannel(nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_CH));
        wifiInfo.setMode(nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_MODE));
        return wifiInfo;
    }

    public int getWifiStatus() {
        return nativeGetInt32(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_STATUS);
    }

    public String getwideLensSerial() {
        return nativeGetString(com.arashivision.onecamera.OneDriverInfo.Options.SENSOR_SERIAL_VR180);
    }

    public boolean isSelfie() {
        return nativeGetBoolean("is_selfie");
    }

    public void release() {
        nativeRelease();
        this.mState = State.Release;
    }

    public void setAccFullRange(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.ACC_FULL_SCALE_RANGE, i2);
    }

    public void setActiveTime(long j2) {
        nativeSetInt64(com.arashivision.onecamera.OneDriverInfo.Options.ACTIVATE_TIME, j2);
    }

    public void setAdoptionSystem(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.APOPTION_SYSTEM, i2);
    }

    public void setAudioBitrate(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.AUDIO_BITRATE, i2);
    }

    public void setAudioSampleRate(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.AUDIO_SAMPLERATE, i2);
    }

    public void setAuthorizationID(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.AUTHORIZATION_ID, str);
    }

    public void setButtonPressOption(ButtonPressOptions buttonPressOptions) {
        setClickint(buttonPressOptions.click);
        setDoubleint(buttonPressOptions.double_click);
        setTripleint(buttonPressOptions.triple_click);
        setLongPressint(buttonPressOptions.long_press);
        setShutdownClickint(buttonPressOptions.shutdown_click);
        setShutdownShortPressint(buttonPressOptions.shutdown_short_press);
    }

    public void setCalibrateOffset3D(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.CALIBRATION_OFFSET_3D, str);
    }

    public void setCalibrationOffset(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.CALIBRATION_OFFSET, str);
    }

    public void setCaptureLimitTime(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.CAPTURE_TIME_LIMIT, i2);
    }

    public void setClickint(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_CLICK, i2);
    }

    public void setDoubleint(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_DOUBLE_CLICK, i2);
    }

    public void setEVOStatusMode(int i2) {
        nativeSetInt32("evo_status_mode", i2);
    }

    public void setGPSTimeout(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.GPS_TIMEOUT, i2);
    }

    public void setGyroFullRange(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.GYRO_FULL_SCALE_RANGE, i2);
    }

    public void setGyroSampleRate(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.GYRO_SAMPLE_RATE, i2);
    }

    public void setImageFilcker(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.IMAGE_FLICKER, i2);
    }

    public void setLocalTime(long j2) {
        nativeSetInt64(com.arashivision.onecamera.OneDriverInfo.Options.LOCAL_TIME, j2);
    }

    public void setLogMode(boolean z) {
        nativeSetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.LOG_MODE, z);
    }

    public void setLongPressint(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_LONG_PRESS, i2);
    }

    public void setMCTFEnable(boolean z) {
        nativeSetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.MCTF_ENABLE, z);
    }

    public void setMediaOffset(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.MEDIA_OFFSET, str);
    }

    public void setMediaOffset3D(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.MEDIA_OFFSET_3D, str);
    }

    public void setMute(boolean z) {
        nativeSetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.MUTE, z);
    }

    public void setOriginOffset(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.ORIGIN_OFFSET, str);
    }

    public void setOriginOffset3D(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.ORIGIN_OFFSET_3D, str);
    }

    public void setPhotoSize(int i2, int i3) {
        setPhotoHeight(i3);
        setPhotoWidth(i2);
    }

    public void setQualitySetting(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.QUALITY_SETTING, i2);
    }

    public void setRemoteType(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BT_REMOTE_TYPE, i2);
    }

    public void setRemoteVersion(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.BT_REMOTE_VERSION, str);
    }

    public void setSN(String str) {
        nativeSetString("serial_number", str);
    }

    public void setSecodStreamRes(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.SECOND_STREAM_RES, i2);
    }

    public void setSelfTimer(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.SELF_TIMER, i2);
    }

    public void setSelfie(boolean z) {
        nativeSetBoolean("is_selfie", z);
    }

    public void setSensor0Serial(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.SENSOR0_SERIAL_VR360, str);
    }

    public void setSensor1Serial(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.SENSOR1_SERIAL_VR360, str);
    }

    public void setShutdownClickint(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_SHUTDOWN_CLICK, i2);
    }

    public void setShutdownShortPressint(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_SHUTDOWN_SHORT_PRESS, i2);
    }

    public void setSportModeEnable(boolean z) {
        nativeSetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.SPORT_MODE_ENABLE, z);
    }

    public void setSubPhotoMode(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.PHOTO_SUB_MODE, i2);
    }

    public void setSubVideoMode(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_SUB_MODE, i2);
    }

    public void setTakeRawPicture(boolean z) {
        nativeSetBoolean(com.arashivision.onecamera.OneDriverInfo.Options.TAKE_RAW_PICTURE, z);
    }

    public void setTimezoneSecodeFromGMT(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.TIME_ZONE, i2);
    }

    public void setTripleint(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.BUTTON_PRESS_TRIPLE_CLICK, i2);
    }

    public void setVideoBitrate(int i2) {
        nativeSetInt32("video_bitrate", i2);
    }

    public void setVideoEncodeType(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.VIDEO_ENCODE_TYPE, i2);
    }

    public void setVideoResolution(int i2, int i3, int i4) {
        setVideoFps(i2);
        setVideoHeight(i4);
        setVideoWidth(i3);
    }

    public void setWifiChannelCounty(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_CH_COUNTY, str);
    }

    public void setWifiInfo(WifiInfo wifiInfo) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_SSID, wifiInfo.getSsid());
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_PWD, wifiInfo.getPwd());
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_CH, wifiInfo.getChannel());
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_MODE, wifiInfo.getMode());
    }

    public void setWifiStatus(int i2) {
        nativeSetInt32(com.arashivision.onecamera.OneDriverInfo.Options.WIFI_STATUS, i2);
    }

    public void setwideLensSerial(String str) {
        nativeSetString(com.arashivision.onecamera.OneDriverInfo.Options.SENSOR_SERIAL_VR180, str);
    }
}
