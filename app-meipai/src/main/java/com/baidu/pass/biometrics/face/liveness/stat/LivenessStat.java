package com.baidu.pass.biometrics.face.liveness.stat;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.NetworkUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.StatService;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import e.a.a.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public class LivenessStat {
    public static final int DEFAULT_INT_NUM = 0;
    public static final String KEY_NAME_LIVENESS_STAT = "living_recog";
    public static final String TAG = "LivenessStat";
    public static final int TYPE_BOOLEAN_DEFAULT = -1;
    public static final String TYPE_CLOSE_FIND_EYE = "find_eye";
    public static final String TYPE_CLOSE_FIND_FACE = "find_face";
    public static final String TYPE_CLOSE_FIND_MOUTH = "find_mouth";
    public static final String TYPE_FACE_MATCH_FAIL = "fail";
    public static final String TYPE_FACE_MATCH_PASS = "pass";
    public static final int TYPE_FALSE = 0;
    public static final String TYPE_LIVING_EYE = "eye";
    public static final String TYPE_LIVING_MOUTH = "mouth";
    public static final String TYPE_STRING_DEFAULT = "-1";
    public static final int TYPE_TRUE = 1;
    public static final String TYPE_VOICE_CLOSE = "close";
    public static final String TYPE_VOICE_OPEN = "open";
    public int asyncGetPortraitType = -1;
    public String clickCloseType;
    public String clickVoiceType;
    public int errCode;
    public String faceMatchType;
    public int findFaceLast = -1;
    public int findFaceNum = 0;
    public int getIDLPicture;
    public int guideLiveness;
    public float illumValue;
    public boolean isLivenessSuc;
    public int livingPassEyesNum = 0;
    public int livingPassMouthNum = 0;
    public String livingPassPeriod;
    public String livingPassType;
    public int onLineIllum;
    public int openCameraPermissionSuc = -1;
    public String previewSize;
    public String recogType;
    public String subPro;
    public long timePointCameraReady;
    public long timePointEnd;
    public long timePointFindFaceDone;
    public int timePointIdlTrackCounts;
    public long timePointIdlTrackTimeAll;
    public long timePointLivingEyePass;
    public long timePointLivingEyeStart;
    public long timePointLivingMouthPass;
    public long timePointLivingMouthStart;
    public long timePointStart;
    public long timePointStartFindFace;
    public long timePointStartRecog;
    public int tipDistanceFarNum;
    public int tipDistanceNearNum;
    public int tipEyeSlopeNum;
    public int tipLightLowNum;
    public int tipOverTime;
    public int tipOverTimeAgain;
    public int tipOverTimeCancel;
    public int tipOverTimeRetry;
    public int tipOverTimeSure;
    public int tipPutFaceRoundNum;
    public int whiteBg;
    public int withCameraPermission = -1;

    public LivenessStat() {
        String str = "";
        this.recogType = str;
        this.subPro = str;
        String str2 = TYPE_STRING_DEFAULT;
        this.livingPassType = str2;
        this.whiteBg = -1;
        this.illumValue = -1.0f;
        this.onLineIllum = -1;
        this.guideLiveness = 0;
        this.livingPassPeriod = str2;
        this.getIDLPicture = -1;
        this.faceMatchType = str2;
        this.clickCloseType = str2;
        this.clickVoiceType = str2;
        this.tipDistanceNearNum = 0;
        this.tipDistanceFarNum = 0;
        this.tipEyeSlopeNum = 0;
        this.tipPutFaceRoundNum = 0;
        this.tipLightLowNum = 0;
        this.tipOverTime = -1;
        this.tipOverTimeCancel = -1;
        this.tipOverTimeRetry = -1;
        this.tipOverTimeAgain = -1;
        this.tipOverTimeSure = -1;
        this.timePointStartRecog = 0;
        this.timePointCameraReady = 0;
        this.timePointIdlTrackTimeAll = 0;
        this.timePointIdlTrackCounts = 0;
        this.timePointStartFindFace = 0;
        this.timePointFindFaceDone = 0;
        this.timePointLivingEyeStart = 0;
        this.timePointLivingEyePass = 0;
        this.timePointLivingMouthStart = 0;
        this.timePointLivingMouthPass = 0;
        this.timePointEnd = 0;
        this.errCode = 0;
        this.isLivenessSuc = false;
    }

    public void onStat(Context context) {
        HashMap hashMap = new HashMap();
        Log.w(TAG, "onStat");
        String str = "";
        if (this.withCameraPermission != -1) {
            a.a(new StringBuilder(), this.withCameraPermission, str, hashMap, "camera_with_per");
        }
        if (this.openCameraPermissionSuc != -1) {
            a.a(new StringBuilder(), this.openCameraPermissionSuc, str, hashMap, "camera_open_per");
        }
        if (this.asyncGetPortraitType != -1) {
            a.a(new StringBuilder(), this.asyncGetPortraitType, str, hashMap, "net_get_potrt");
        }
        if (this.findFaceLast != -1) {
            a.a(new StringBuilder(), this.findFaceLast, str, hashMap, "find_face_last");
        }
        if (this.findFaceNum != 0) {
            a.a(new StringBuilder(), this.findFaceNum, str, hashMap, "find_face_num");
        }
        if (this.livingPassEyesNum != 0) {
            a.a(new StringBuilder(), this.livingPassEyesNum, str, hashMap, "living_pass_eye_num");
        }
        if (this.livingPassMouthNum != 0) {
            a.a(new StringBuilder(), this.livingPassMouthNum, str, hashMap, "living_pass_mouth_num");
        }
        String str2 = this.livingPassType;
        String str3 = TYPE_STRING_DEFAULT;
        if (str2 != str3 && this.isLivenessSuc) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.livingPassType);
            sb.append(str);
            hashMap.put("living_pass_type", sb.toString());
        }
        if (this.livingPassPeriod != str3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.livingPassPeriod);
            sb2.append(str);
            hashMap.put("living_pass_period", sb2.toString());
        }
        if (this.getIDLPicture != -1) {
            a.a(new StringBuilder(), this.getIDLPicture, str, hashMap, "get_idl_pic");
        }
        if (this.faceMatchType != str3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.faceMatchType);
            sb3.append(str);
            hashMap.put("face_match_type", sb3.toString());
        }
        if (this.clickCloseType != str3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.clickCloseType);
            sb4.append(str);
            hashMap.put("click_close_type", sb4.toString());
        }
        if (this.clickVoiceType != str3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.clickVoiceType);
            sb5.append(str);
            hashMap.put("click_voice_type", sb5.toString());
        }
        if (this.tipLightLowNum != 0) {
            a.a(new StringBuilder(), this.tipLightLowNum, str, hashMap, "tip_light_low_num");
        }
        if (this.tipDistanceNearNum != 0) {
            a.a(new StringBuilder(), this.tipDistanceNearNum, str, hashMap, "tip_distance_near_num");
        }
        if (this.tipDistanceFarNum != 0) {
            a.a(new StringBuilder(), this.tipDistanceFarNum, str, hashMap, "tip_distance_far_num");
        }
        if (this.tipEyeSlopeNum != 0) {
            a.a(new StringBuilder(), this.tipEyeSlopeNum, str, hashMap, "tip_eye_slope_num");
        }
        if (this.tipPutFaceRoundNum != 0) {
            a.a(new StringBuilder(), this.tipPutFaceRoundNum, str, hashMap, "tip_put_face_round_num");
        }
        if (this.tipOverTime != -1) {
            a.a(new StringBuilder(), this.tipOverTime, str, hashMap, "tip_overtime");
        }
        if (this.tipOverTimeCancel != -1) {
            a.a(new StringBuilder(), this.tipOverTimeCancel, str, hashMap, "tip_overtime_cancel");
        }
        if (this.tipOverTimeRetry != -1) {
            a.a(new StringBuilder(), this.tipOverTimeRetry, str, hashMap, "tip_overtime_retry");
        }
        if (this.tipOverTimeAgain != -1) {
            a.a(new StringBuilder(), this.tipOverTimeAgain, str, hashMap, "tip_overtime_again");
        }
        if (this.tipOverTimeSure != -1) {
            a.a(new StringBuilder(), this.tipOverTimeSure, str, hashMap, "tip_overtime_sure");
        }
        if (this.timePointCameraReady != 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.timePointCameraReady - this.timePointStartRecog);
            sb6.append(str);
            hashMap.put("time_camera_ready", sb6.toString());
        }
        if (this.timePointFindFaceDone != 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.timePointFindFaceDone - this.timePointStartFindFace);
            sb7.append(str);
            hashMap.put("time_find_face", sb7.toString());
        }
        if (this.timePointLivingMouthStart != 0 && this.timePointLivingMouthPass != 0) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(this.timePointLivingMouthPass - this.timePointLivingMouthStart);
            sb8.append(str);
            hashMap.put("time_mouth_pass", sb8.toString());
        } else if (!(this.timePointLivingEyeStart == 0 || this.timePointLivingEyePass == 0)) {
            String str4 = TAG;
            StringBuilder a2 = a.a("timePointLivingEyePass:");
            a2.append(this.timePointLivingEyePass);
            a2.append(",timePointStartFindFace");
            a2.append(this.timePointLivingEyeStart);
            Log.w(str4, a2.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(this.timePointLivingEyePass - this.timePointLivingEyeStart);
            sb9.append(str);
            hashMap.put("time_eyes_pass", sb9.toString());
        }
        if (!(this.timePointIdlTrackTimeAll == 0 || this.timePointIdlTrackCounts == 0)) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(this.timePointIdlTrackTimeAll / ((long) this.timePointIdlTrackCounts));
            sb10.append(str);
            hashMap.put("time_idl_face_track", sb10.toString());
        }
        String str5 = "time_contrast";
        if (this.timePointLivingMouthPass != 0) {
            StringBuilder sb11 = new StringBuilder();
            sb11.append(this.timePointEnd - this.timePointLivingMouthPass);
            sb11.append(str);
            hashMap.put(str5, sb11.toString());
        } else if (this.timePointLivingEyePass != 0) {
            StringBuilder sb12 = new StringBuilder();
            sb12.append(this.timePointEnd - this.timePointLivingEyePass);
            sb12.append(str);
            hashMap.put(str5, sb12.toString());
        }
        if (this.whiteBg != -1) {
            a.a(new StringBuilder(), this.whiteBg, str, hashMap, "white_bg");
        }
        StringBuilder sb13 = new StringBuilder();
        sb13.append(this.illumValue);
        sb13.append(str);
        hashMap.put("illum", sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append(this.onLineIllum);
        sb14.append(str);
        hashMap.put("abtest_illum", sb14.toString());
        StringBuilder sb15 = new StringBuilder();
        sb15.append(this.timePointEnd - this.timePointStart);
        sb15.append(str);
        hashMap.put("time_whole", sb15.toString());
        a.a(new StringBuilder(), this.errCode, str, hashMap, WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
        hashMap.put("recog_type", this.recogType);
        a.a(new StringBuilder(), this.guideLiveness, str, hashMap, "guide_liveness");
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        StringBuilder sb16 = new StringBuilder();
        sb16.append(defaultDisplay.getWidth());
        sb16.append(",");
        sb16.append(defaultDisplay.getHeight());
        hashMap.put("screen_size", sb16.toString());
        hashMap.put("os_ver", PassBiometricUtil.getOSVersion());
        if (!TextUtils.isEmpty(this.subPro)) {
            hashMap.put("subpro", this.subPro);
        }
        hashMap.put("net_type", NetworkUtils.getNetworkClass(context));
        if (!TextUtils.isEmpty(this.previewSize)) {
            hashMap.put("pre_size", this.previewSize);
        }
        String str6 = TAG;
        StringBuilder a3 = a.a("onStat|map|");
        a3.append(new JSONObject(hashMap));
        Log.w(str6, a3.toString());
        StatService.onEvent(context, KEY_NAME_LIVENESS_STAT, hashMap);
    }

    public void resetTimePoint() {
        this.timePointStartFindFace = 0;
        this.timePointFindFaceDone = 0;
        this.timePointLivingEyeStart = 0;
        this.timePointLivingEyePass = 0;
        this.timePointLivingMouthStart = 0;
        this.timePointLivingMouthPass = 0;
    }
}
