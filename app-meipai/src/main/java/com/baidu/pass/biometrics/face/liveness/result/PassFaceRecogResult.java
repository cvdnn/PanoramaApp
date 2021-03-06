package com.baidu.pass.biometrics.face.liveness.result;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.pass.biometrics.face.R;
import org.json.JSONException;
import org.json.JSONObject;

public class PassFaceRecogResult extends PassBiometricResult {
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_IMAGE_FILE_EMPTY = -306;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public static final String ERROR_MSG_CONTRAST_FAIL = ResUtils.getString(R.string.pass_bio_error_msg_contrast_fail);
    public static final String ERROR_MSG_FACE_SDK_INIT_FAIL = ResUtils.getString(R.string.pass_bio_error_msg_face_sdk_init_fail);
    public static final String ERROR_MSG_IMAGE_FILE_EMPTY = ResUtils.getString(R.string.pass_bio_error_msg_image_file_empty);
    public static final String ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT = ResUtils.getString(R.string.pass_bio_error_msg_liveness_recognize_time_out);
    public static final String ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION = ResUtils.getString(R.string.pass_bio_error_msg_may_be_no_camera_permission);
    public static final String ERROR_MSG_OPEN_CAMERA_FAILURE = ResUtils.getString(R.string.pass_bio_error_msg_open_camera_failure);
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String faceimage;
    public String imgdigests;
    public String originalImage;
    public String video;

    public PassFaceRecogResult() {
        this.msgMap.put(-305, ERROR_MSG_OPEN_CAMERA_FAILURE);
        this.msgMap.put(-301, ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
        this.msgMap.put(ERROR_CODE_FACE_SDK_INIT_FAIL, ERROR_MSG_FACE_SDK_INIT_FAIL);
        this.msgMap.put(ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION, ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
        this.msgMap.put(-306, ERROR_MSG_IMAGE_FILE_EMPTY);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", getResultCode());
            jSONObject.put("errmsg", getResultMsg());
            if (this.resultCode == 0) {
                if (!TextUtils.isEmpty(this.callbackkey)) {
                    jSONObject.put("credentialKey", this.callbackkey);
                }
                if (!TextUtils.isEmpty(this.authSid)) {
                    jSONObject.put("authsid", this.authSid);
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }
}
