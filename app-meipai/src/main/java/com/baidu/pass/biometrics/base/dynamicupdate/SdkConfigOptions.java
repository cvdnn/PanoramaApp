package com.baidu.pass.biometrics.base.dynamicupdate;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkConfigOptions {
    public static final String HOST_VERSION = "3.0.0";
    public static final String KEY_DISTRIBUTED_SDK = "distributedSdk";
    public static final String KEY_GLOBAL_ENABLE = "so_global_enable";
    public static final String KEY_GRAY = "gray";
    public static final String KEY_HOST_VERSION = "host_version";
    public static final String KEY_LIVENESS_CONFIG_OPTION = "liveness_config_option";
    public static final String KEY_SO_CPU = "cpu";
    public static final String KEY_SO_ENABLE = "enable";
    public static final String KEY_SO_FILE = "file";
    public static final String KEY_SO_FILES = "files";
    public static final String KEY_SO_LIST = "face_sdk";
    public static final String KEY_UPDATE_FAIL = "updateFail";
    public static final String KEY_ZIP_VERSION = "zip_version";
    public static final String TAG = "SdkConfigOptions";
    public DistributedFile distributedSdk;
    public boolean enable;
    public boolean globalEnable;
    public int grayThreshold;
    public String hostVersion;
    public LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
    public boolean updateFail;
    public String zipVersion;

    public static class DistributedFile {
        public static final String KEY_FILE_DOWNLOAD_URL = "url";
        public static final String KEY_FILE_HASH = "hash";
        public static final String KEY_FILE_NAME = "name";
        public String downloadUrl = null;
        public String fileName = null;
        public String hash = null;

        public static DistributedFile fromJSON(JSONObject jSONObject) {
            DistributedFile distributedFile = new DistributedFile();
            if (jSONObject == null) {
                return distributedFile;
            }
            distributedFile.fileName = jSONObject.optString("name");
            distributedFile.downloadUrl = jSONObject.optString("url");
            distributedFile.hash = jSONObject.optString("hash");
            return distributedFile;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.fileName);
                jSONObject.put("url", this.downloadUrl);
                jSONObject.put("hash", this.hash);
                return jSONObject;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    public static class LivenessConfigOption {
        public static final String CROP_FACE_RATIO = "crop_face_ratio";
        public static final String CROP_FACE_SIZE = "crop_face_size";
        public static final int DEFAULT_CROP_FACE_RATIO = 3;
        public static final int DEFAULT_CROP_FACE_SIZE = 256;
        public static final int DEFAULT_DETECT_INTERVAL = 300;
        public static final int DEFAULT_FIRST_LIVENESS_RECOG_TIME = 6;
        public static final int DEFAULT_ILLUM_THR = 40;
        public static final int DEFAULT_MAX_REG_IMG_NUM = 3;
        public static final int DEFAULT_MIN_FACE_SIZE = 100;
        public static final int DEFAULT_PITCH = 15;
        public static final int DEFAULT_PREFETCH_REG_IMG_INTERVAL = 300;
        public static final int DEFAULT_RECOG_UPLOAD_PORTRAIT_COUNT = 3;
        public static final int DEFAULT_ROLL = 15;
        public static final int DEFAULT_TRACK_INTERVAL = 300;
        public static final int DEFAULT_WHITE_BG_ILLUM_THR = 10;
        public static final int DEFAULT_YAW = 15;
        public static final String DETECT_INTERVAL = "detect_interval";
        public static final String ILLUM_THR = "illum_thr";
        public static final String KEY_ABTEST_ILLUM_LIST = "abtest_illum_list";
        public static final String KEY_CLOSE_SKIP_LIVING = "close_skip_living";
        public static final String KEY_WHITE_BG_ILLUM_THR = "white_bg_illum_thr";
        public static final int LIVENESS_RECOG_TYPE_BLINK = 1;
        public static final int LIVENESS_RECOG_TYPE_OPEN_MOUTH = 2;
        public static final String MAX_REG_IMG_NUM = "max_reg_img_num";
        public static final String MIN_FACE_SIZE = "min_face_size";
        public static final String PITCH_RANGE = "pitch";
        public static final String PREFETCH_REG_IMG_INTERVAL = "prefetch_reg_img_interval";
        public static final String RECOG_ACTION_TYPE = "recog_action_type";
        public static final String RECOG_TIME_INTERVAL = "recog_time_interval";
        public static final String RECOG_UPLOAD_PORTRAIT_COUNT = "recog_upload_portrait_count";
        public static final String ROLL_RANGE = "roll";
        public static final String SWITCH_RECORD_VIDEO = "switch_record_video";
        public static final String TRACK_INTERVAL = "track_interval";
        public static final String YAW_RANGE = "yaw";
        public boolean closeSkipLiving = false;
        public String cropFaceRatio = String.valueOf(256);
        public String cropFaceSize = String.valueOf(3);
        public String detectInterval = String.valueOf(300);
        public List<Integer> illumList = new ArrayList();
        public String illumThr = String.valueOf(40);
        public String maxRegImgNum = String.valueOf(3);
        public String minFaceSize = String.valueOf(100);
        public String pitch = String.valueOf(15);
        public String prefetchRegImgInterval = String.valueOf(300);
        public String recogActionType;
        public String recogTimeInterval;
        public String recogUploadPortraitCount;
        public String roll = String.valueOf(15);
        public String switchRecordVideo;
        public String trackInterval = String.valueOf(300);
        public int whiteBgIllumThr;
        public String yaw = String.valueOf(15);

        public static LivenessConfigOption fromJson(JSONObject jSONObject) {
            LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
            if (jSONObject == null) {
                return livenessConfigOption;
            }
            livenessConfigOption.minFaceSize = jSONObject.optString(MIN_FACE_SIZE);
            livenessConfigOption.illumThr = jSONObject.optString(ILLUM_THR);
            livenessConfigOption.trackInterval = jSONObject.optString(TRACK_INTERVAL);
            livenessConfigOption.detectInterval = jSONObject.optString(DETECT_INTERVAL);
            livenessConfigOption.yaw = jSONObject.optString(YAW_RANGE);
            livenessConfigOption.pitch = jSONObject.optString(PITCH_RANGE);
            livenessConfigOption.roll = jSONObject.optString(ROLL_RANGE);
            livenessConfigOption.maxRegImgNum = jSONObject.optString(MAX_REG_IMG_NUM);
            livenessConfigOption.prefetchRegImgInterval = jSONObject.optString(PREFETCH_REG_IMG_INTERVAL);
            livenessConfigOption.cropFaceSize = jSONObject.optString(CROP_FACE_SIZE);
            livenessConfigOption.cropFaceRatio = jSONObject.optString(CROP_FACE_RATIO);
            livenessConfigOption.switchRecordVideo = jSONObject.optString(SWITCH_RECORD_VIDEO);
            livenessConfigOption.recogActionType = jSONObject.optString(RECOG_ACTION_TYPE);
            livenessConfigOption.recogTimeInterval = jSONObject.optString(RECOG_TIME_INTERVAL);
            livenessConfigOption.recogUploadPortraitCount = jSONObject.optString(RECOG_UPLOAD_PORTRAIT_COUNT);
            livenessConfigOption.whiteBgIllumThr = jSONObject.optInt(KEY_WHITE_BG_ILLUM_THR, 10);
            livenessConfigOption.closeSkipLiving = jSONObject.optBoolean(KEY_CLOSE_SKIP_LIVING, false);
            setJsonArrayToList(jSONObject.optJSONArray(KEY_ABTEST_ILLUM_LIST), livenessConfigOption.illumList);
            return livenessConfigOption;
        }

        public static void setJsonArrayToList(JSONArray jSONArray, List<Integer> list) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                        list.add(Integer.valueOf(jSONArray.optInt(i2)));
                    }
                }
            }
        }

        public static void setListToJsonArray(JSONObject jSONObject, String str, List<Integer> list) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (Integer intValue : list) {
                jSONArray.put(intValue.intValue());
            }
            jSONObject.put(str, jSONArray);
        }

        public List<Integer> getABtestIllumList() {
            List<Integer> asList = Arrays.asList(new Integer[]{Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(10)});
            List<Integer> list = this.illumList;
            return (list == null || list.isEmpty()) ? asList : this.illumList;
        }

        public int getCropFaceRatio() {
            int i2 = 3;
            if (!TextUtils.isEmpty(this.cropFaceRatio)) {
                try {
                    int parseInt = Integer.parseInt(this.cropFaceRatio);
                    if (parseInt >= 1 && parseInt <= 3) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 3;
        }

        public int getCropFaceSize() {
            int i2 = 256;
            if (!TextUtils.isEmpty(this.cropFaceSize)) {
                try {
                    int parseInt = Integer.parseInt(this.cropFaceSize);
                    if (parseInt >= 256 && parseInt <= 768) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 256;
        }

        public int getDetectInterval() {
            int i2 = 300;
            if (!TextUtils.isEmpty(this.detectInterval)) {
                try {
                    int parseInt = Integer.parseInt(this.detectInterval);
                    if (parseInt >= 100 && parseInt <= 500) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 300;
        }

        public int getIllumThr() {
            int i2 = 40;
            if (!TextUtils.isEmpty(this.illumThr)) {
                try {
                    int parseInt = Integer.parseInt(this.illumThr);
                    if (parseInt >= 0 && parseInt <= 255) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 40;
        }

        public int getMaxRegImgNum() {
            int i2 = 3;
            if (!TextUtils.isEmpty(this.maxRegImgNum)) {
                try {
                    int parseInt = Integer.parseInt(this.maxRegImgNum);
                    if (parseInt >= 1 && parseInt <= 3) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 3;
        }

        public int getMinFaceSize() {
            int i2 = 100;
            if (!TextUtils.isEmpty(this.minFaceSize)) {
                try {
                    int parseInt = Integer.parseInt(this.minFaceSize);
                    if (parseInt >= 30 && parseInt <= 200) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 100;
        }

        public int getPitch() {
            int i2 = 15;
            if (!TextUtils.isEmpty(this.pitch)) {
                try {
                    int parseInt = Integer.parseInt(this.pitch);
                    if (parseInt >= 10 && parseInt <= 15) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 15;
        }

        public int getPrefetchRegImgInterval() {
            int i2 = 300;
            if (!TextUtils.isEmpty(this.prefetchRegImgInterval)) {
                try {
                    int parseInt = Integer.parseInt(this.prefetchRegImgInterval);
                    if (parseInt >= 100 && parseInt <= 300) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 300;
        }

        public int getRecogActionType() {
            try {
                if (!TextUtils.isEmpty(this.recogActionType)) {
                    return Integer.valueOf(this.recogActionType).intValue();
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return 1;
        }

        public int getRecogUploadPortraitCount(int i2) {
            try {
                if (!TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                    return Math.min(i2, Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue()));
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return 3;
        }

        public int getRecogtimeInterval() {
            try {
                if (!TextUtils.isEmpty(this.recogTimeInterval)) {
                    return Integer.valueOf(this.recogTimeInterval).intValue();
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return 6;
        }

        public int getRoll() {
            int i2 = 15;
            if (!TextUtils.isEmpty(this.roll)) {
                try {
                    int parseInt = Integer.parseInt(this.roll);
                    if (parseInt >= 10 && parseInt <= 15) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 15;
        }

        public int getTrackInterval() {
            int i2 = 300;
            if (!TextUtils.isEmpty(this.trackInterval)) {
                try {
                    int parseInt = Integer.parseInt(this.trackInterval);
                    if (parseInt >= 100 && parseInt <= 300) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 300;
        }

        public int getYaw() {
            int i2 = 15;
            if (!TextUtils.isEmpty(this.yaw)) {
                try {
                    int parseInt = Integer.parseInt(this.yaw);
                    if (parseInt >= 10 && parseInt <= 15) {
                        i2 = parseInt;
                    }
                    return i2;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 15;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MIN_FACE_SIZE, this.minFaceSize);
                jSONObject.put(ILLUM_THR, this.illumThr);
                jSONObject.put(TRACK_INTERVAL, this.trackInterval);
                jSONObject.put(DETECT_INTERVAL, this.detectInterval);
                jSONObject.put(YAW_RANGE, this.yaw);
                jSONObject.put(PITCH_RANGE, this.pitch);
                jSONObject.put(ROLL_RANGE, this.roll);
                jSONObject.put(MAX_REG_IMG_NUM, this.maxRegImgNum);
                jSONObject.put(PREFETCH_REG_IMG_INTERVAL, this.prefetchRegImgInterval);
                jSONObject.put(CROP_FACE_SIZE, this.cropFaceSize);
                jSONObject.put(CROP_FACE_RATIO, this.cropFaceRatio);
                jSONObject.put(SWITCH_RECORD_VIDEO, this.switchRecordVideo);
                jSONObject.put(RECOG_ACTION_TYPE, this.recogActionType);
                jSONObject.put(RECOG_TIME_INTERVAL, this.recogTimeInterval);
                jSONObject.put(RECOG_UPLOAD_PORTRAIT_COUNT, this.recogUploadPortraitCount);
                jSONObject.put(KEY_WHITE_BG_ILLUM_THR, this.whiteBgIllumThr);
                jSONObject.put(KEY_CLOSE_SKIP_LIVING, this.closeSkipLiving);
                setListToJsonArray(jSONObject, KEY_ABTEST_ILLUM_LIST, this.illumList);
                return jSONObject;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.hostVersion = jSONObject.optString("host_version");
        sdkConfigOptions.zipVersion = jSONObject.optString("zip_version");
        sdkConfigOptions.updateFail = jSONObject.optBoolean(KEY_UPDATE_FAIL);
        sdkConfigOptions.globalEnable = jSONObject.optBoolean(KEY_GLOBAL_ENABLE);
        sdkConfigOptions.enable = jSONObject.optBoolean(KEY_SO_ENABLE);
        sdkConfigOptions.grayThreshold = jSONObject.optInt("gray");
        sdkConfigOptions.distributedSdk = DistributedFile.fromJSON(jSONObject.optJSONObject(KEY_DISTRIBUTED_SDK));
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(KEY_LIVENESS_CONFIG_OPTION));
        return sdkConfigOptions;
    }

    public static SdkConfigOptions fromOnLineJSON(JSONObject jSONObject) {
        String str;
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_SO_LIST);
        if (optJSONArray == null) {
            return sdkConfigOptions;
        }
        JSONObject jSONObject2 = null;
        try {
            int length = optJSONArray.length();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                str = "host_version";
                if (i3 >= length) {
                    break;
                }
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i3);
                if (jSONObject3 != null && "3.0.0".equals(jSONObject3.optString(str))) {
                    jSONObject2 = jSONObject3;
                    break;
                }
                i3++;
            }
            if (jSONObject2 == null) {
                return sdkConfigOptions;
            }
            sdkConfigOptions.globalEnable = jSONObject.optBoolean(KEY_GLOBAL_ENABLE, true);
            sdkConfigOptions.hostVersion = jSONObject2.optString(str);
            sdkConfigOptions.zipVersion = jSONObject2.optString("zip_version");
            sdkConfigOptions.enable = jSONObject2.optBoolean(KEY_SO_ENABLE, true);
            sdkConfigOptions.grayThreshold = jSONObject2.optInt("gray");
            JSONArray jSONArray = jSONObject2.optJSONObject("files").getJSONArray(KEY_SO_FILE);
            if (jSONArray == null) {
                return sdkConfigOptions;
            }
            String cpuType = PassBiometricUtil.getCpuType();
            if (PassBiometricUtil.CPU_TYPE_ARMEABI.equals(cpuType)) {
                cpuType = PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
            }
            int length2 = jSONArray.length();
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                if (jSONObject4 != null && cpuType.equals(jSONObject4.optString(KEY_SO_CPU))) {
                    sdkConfigOptions.distributedSdk = DistributedFile.fromJSON(jSONObject4);
                    break;
                }
                i2++;
            }
            return sdkConfigOptions;
        } catch (JSONException e2) {
            Log.e(TAG, (Throwable) e2);
        }
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("3.0.0", this.hostVersion);
            jSONObject.put("zip_version", this.zipVersion);
            jSONObject.put(KEY_UPDATE_FAIL, this.updateFail);
            jSONObject.put(KEY_GLOBAL_ENABLE, this.globalEnable);
            jSONObject.put(KEY_SO_ENABLE, this.enable);
            jSONObject.put("gray", this.grayThreshold);
            Object obj = "";
            jSONObject.put(KEY_DISTRIBUTED_SDK, this.distributedSdk == null ? obj : this.distributedSdk.toJSON());
            String str = KEY_LIVENESS_CONFIG_OPTION;
            if (this.livenessConfigOption != null) {
                obj = this.livenessConfigOption.toJSON();
            }
            jSONObject.put(str, obj);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
