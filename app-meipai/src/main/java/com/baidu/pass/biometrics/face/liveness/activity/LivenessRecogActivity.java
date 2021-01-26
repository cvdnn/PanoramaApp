package com.baidu.pass.biometrics.face.liveness.activity;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.arashivision.onecamera.OneDriverInfo;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceSDK.AlignMethodType;
import com.baidu.idl.facesdk.FaceSDK.ImgType;
import com.baidu.idl.facesdk.FaceSDK.ParsMethodType;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceTracker.ActionType;
import com.baidu.idl.facesdk.FaceTracker.ErrCode;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.armor.RimArmor;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions.LivenessConfigOption;
import com.baidu.pass.biometrics.base.dynamicupdate.SoManager;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.R;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface.CameraSize;
import com.baidu.pass.biometrics.face.liveness.camera.CameraSurfaceView;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.pass.biometrics.face.liveness.utils.BioSensorManager;
import com.baidu.pass.biometrics.face.liveness.utils.BioSensorManager.SensorCallback;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.BioAlertDialog;
import com.baidu.pass.biometrics.face.liveness.view.ConstrastLoadingView;
import com.baidu.pass.biometrics.face.liveness.view.CustomAlertDialog;
import com.baidu.pass.biometrics.face.liveness.view.XfordView;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import e.a.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(3)
public class LivenessRecogActivity extends LivenessBaseActivity implements Callback {
    public static final int COUNTDOWNINTERVAL = 200;
    public static final String EXTRA_TIME_POINT_START = "time_point_start";
    public static final int HEAD_DOWN = 1;
    public static final int HEAD_EYES_BLINK = 0;
    public static final int HEAD_MOUTH_OPEN = 5;
    public static final int HEAD_POSE_STATE_OPEN = 1;
    public static final int HEAD_TURN_LEFT = 3;
    public static final int HEAD_TURN_RIGHT = 4;
    public static final int HEAD_UP = 2;
    public static final int IS_BRIGHTNESS_TOO_DARK = 2;
    public static final int IS_FACE_OUT_OR_RANGE = 4;
    public static final int IS_LOSE_FACE_FROM_CAMREA = 3;
    public static final int IS_TOO_FAR_FROM_CAMREA = 1;
    public static final int IS_TOO_NEAR_FROM_CAMERA = 0;
    public static final int MILLISINFUTURE = 5000;
    public static final int PERMISSION_REQUEST_CODE_CAMERA = 2002;
    public static final int SCREEN_MAX_BRIGHTNESS = 255;
    public static final String TAG = "LivenessRecog";
    public static final ActionType action = ActionType.RECOGNIZE;
    public AnimState animState;
    public int[] argbData = null;
    public ImageView backBtn;
    public Map<Integer, SoftReference<Bitmap>> bitmapCache = new ConcurrentHashMap();
    public PassFaceRecogCallback callback;
    public int cameraAngle;
    public byte[] cameraData;
    public List<int[]> cameraDataCache = new ArrayList();
    public CameraInterface cameraInterface;
    public int[] canvasBitmapSize;
    public ConstrastLoadingView constrastLoadingView;
    public int currentConstrastBeanPos;
    public ErrCode errorCode;
    public byte[] faceData;
    public byte[] faceDigest;
    public FaceInfo[] faceInfos;
    public FaceRecognitionTask faceRecognitionTask;
    public ImageView faceStateIv;
    public FaceTracker faceTracker;
    public long firstLivenessRcogType;
    public int firstLivenessRecogTime;
    public boolean firstillumCallback = true;
    public int frameStack = 0;
    public boolean guideLiveness = true;
    public boolean hasCameraReadyStatistics;
    public int headMode;
    public String[] headPoses;
    public int illumValue;
    public boolean isActivityFinished = false;
    public boolean isFinish = false;
    public boolean isLast = false;
    public long lastCurMills;
    public int lastFaceId = -1;
    public int lastWaringType = -1;
    public boolean lifeCyclePause = false;
    public LivenessConfigOption livenessConfig;
    public LivenessStat livenessStat = new LivenessStat();
    public BioAlertDialog permissionAlertDialog;
    public ArrayList<HashMap<String, byte[]>> portraitList;
    public FrameLayout poseTipFl;
    public TextView poseTipTv;
    public FrameLayout poseTipWarningFl;
    public ImageView poseTipWarningIv;
    public TextView poseTipWarningTv;
    public PreviewCallback previewCallback = new PreviewCallback() {
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (!(LivenessRecogActivity.this.processState.stateFlag == 0 || LivenessRecogActivity.this.processState.stateFlag == 10 || LivenessRecogActivity.this.processState.stateFlag == 17 || LivenessRecogActivity.this.processState.stateFlag == 19 || LivenessRecogActivity.this.processState.stateFlag == 18)) {
                try {
                    if (LivenessRecogActivity.this.frameStack <= 0) {
                        LivenessRecogActivity.this.cameraData = bArr;
                        LivenessRecogActivity.this.doSomethingWithPreviewSize(camera);
                        LivenessRecogActivity.this.faceRecognitionTask = new FaceRecognitionTask();
                        LivenessRecogActivity.this.faceRecognitionTask.execute(new Void[0]);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    };
    public int previewHeight;
    public int previewWidth;
    public ProcessState processState;
    public Runnable recogTimeCountRunnable = new Runnable() {
        public void run() {
            int i2 = (LivenessRecogActivity.this.firstLivenessRcogType > 2 ? 1 : (LivenessRecogActivity.this.firstLivenessRcogType == 2 ? 0 : -1));
            String str = LivenessRecogActivity.TAG;
            if (i2 == 0) {
                LivenessRecogActivity.this.processState.stateFlag = 5;
                StringBuilder a2 = a.a("timePointLivingEyeStart");
                a2.append(LivenessRecogActivity.this.livenessStat.timePointLivingEyeStart);
                Log.w(str, a2.toString());
                LivenessRecogActivity.this.headMode = 0;
            } else {
                LivenessRecogActivity.this.processState.stateFlag = 7;
                StringBuilder a3 = a.a("timePointLivingMouthStart");
                a3.append(LivenessRecogActivity.this.livenessStat.timePointLivingMouthStart);
                Log.w(str, a3.toString());
                LivenessRecogActivity.this.headMode = 5;
            }
            long currentTimeMillis = 20000 - (System.currentTimeMillis() - LivenessRecogActivity.this.processState.wholeProcessStartTime);
            if (currentTimeMillis < Config.BPLUS_DELAY_TIME) {
                LivenessRecogActivity.this.processState.wholeProcessTimeOut = 25000 - currentTimeMillis;
            }
        }
    };
    public BioSensorManager sensorManager;
    public CameraSurfaceView surfaceView;
    public TimeCount timerCount;
    public int totalConstrastBeanCount;
    public Handler uiHandler;
    public ViewGroup viewGroup;
    public String voiceCredential;
    public boolean whiteBgFlag = false;
    public XfordView xfordView;

    public class AnimState {
        public static final int POSE_BOTTOM_TO_MIDDLE = 0;
        public static final int POSE_MIDDLE_TO_TOP = 1;
        public static final int POSE_STATE_BLINK = 1;
        public static final int POSE_STATE_MOUTH_OPEN = 3;
        public static final int POSE_STATE_NOD_HEAD = 2;
        public static final int POSE_STATE_PUSH_FACE_ROUND = 0;
        public boolean startBlinkAnimFlag = false;
        public boolean startMouthOpenAnimFlag = false;
        public boolean startWarningFlag = false;
        public boolean swipFaceFlag = false;

        public AnimState() {
        }
    }

    public class FaceRecognitionTask extends AsyncTask<Void, Void, String> {
        public FaceRecognitionTask() {
        }

        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.access$2004(LivenessRecogActivity.this);
            LivenessRecogActivity.this.faceRecognize();
            return null;
        }

        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessRecogActivity.access$2006(LivenessRecogActivity.this);
        }
    }

    public class ProcessState {
        public static final int DEFAULT_WHOLE_PROCESS_TIME_OUT = 20000;
        public static final int LIVENESS_RECOG_MIN_TIME = 5000;
        public static final int STAET_VIDEO_UNRECOGNIZED = 18;
        public static final int STATE_BEFORE_TRACK_BLINK = 5;
        public static final int STATE_BEFORE_TRACK_MOUTH_OPEN = 7;
        public static final int STATE_FACE_RECOG_DONE = 10;
        public static final int STATE_FACE_RECOG_TIME_OUT = 17;
        public static final int STATE_FIND_FACE = 2;
        public static final int STATE_FIND_FACE_SPECIAL_ANIM_DONE = 4;
        public static final int STATE_FIND_FACE_SPECIAL_ANIM_START = 3;
        public static final int STATE_LIVE_NESS = 9;
        public static final int STATE_LOST_FACE = 11;
        public static final int STATE_NO_CAMERA_PERMISSION = 19;
        public static final int STATE_NO_GUIDE_LIVENESS = 20;
        public static final int STATE_OPEN_APP = 0;
        public static final int STATE_START_RECOGNIZE = 1;
        public static final int STATE_START_TRACK_BLICK = 6;
        public static final int STATE_START_TRACK_MOUTH_OPEN = 8;
        public boolean blickFindFaceFlag = false;
        public boolean firstFindFaceFlag = false;
        public boolean permissionFlag = false;
        public int stateFlag = 0;
        public boolean timeOutFlag = false;
        public long wholeProcessStartTime;
        public long wholeProcessTimeOut = 20000;

        public ProcessState() {
        }
    }

    public class TimeCount extends CountDownTimer {
        public TimeCount(long j2, long j3) {
            super(j2, j3);
        }

        public void onFinish() {
            if (!LivenessRecogActivity.this.isActivityFinished) {
                LivenessRecogActivity.this.timerCount.start();
            }
        }

        public void onTick(long j2) {
            if (!(LivenessRecogActivity.this.processState.stateFlag == 0 || LivenessRecogActivity.this.processState.stateFlag == 17 || LivenessRecogActivity.this.processState.stateFlag == 19 || LivenessRecogActivity.this.processState.stateFlag == 18 || LivenessRecogActivity.this.processState.stateFlag == 10)) {
                FaceInfo[] access$2600 = LivenessRecogActivity.this.faceInfos;
                int i2 = LivenessRecogActivity.this.processState.stateFlag;
                String str = LivenessRecogActivity.TAG;
                if (i2 != 1) {
                    if (LivenessRecogActivity.this.processState.stateFlag == 4) {
                        if (LivenessRecogActivity.this.isTimeOut()) {
                            LivenessRecogActivity.this.handleTimeOut();
                            return;
                        } else if (LivenessRecogActivity.this.isHasFace(access$2600)) {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                            if (LivenessRecogActivity.this.isFaceInsideRound(access$2600)) {
                                if (LivenessRecogActivity.this.meetStartTrackRequirement(access$2600)) {
                                    if (LivenessRecogActivity.this.firstLivenessRcogType == 1) {
                                        LivenessRecogActivity.this.processState.stateFlag = 5;
                                    } else {
                                        LivenessRecogActivity.this.processState.stateFlag = 7;
                                    }
                                    LivenessRecogActivity.this.livenessStat.timePointLivingEyeStart = System.currentTimeMillis();
                                    LivenessRecogActivity.this.livenessStat.timePointLivingMouthStart = System.currentTimeMillis();
                                    StringBuilder a2 = a.a("timePointLivingMouthStart");
                                    a2.append(LivenessRecogActivity.this.livenessStat.timePointLivingMouthStart);
                                    Log.w(str, a2.toString());
                                    LivenessRecogActivity.this.liveNessDetect(access$2600);
                                    long access$4300 = (long) (LivenessRecogActivity.this.firstLivenessRecogTime * 1000);
                                    if (access$4300 < 20000) {
                                        LivenessRecogActivity.this.uiHandler.postDelayed(LivenessRecogActivity.this.recogTimeCountRunnable, access$4300);
                                    }
                                } else {
                                    LivenessRecogActivity.this.processState.stateFlag = 1;
                                    LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                                    LivenessRecogActivity.this.livenessStat.resetTimePoint();
                                    Log.w(str, "STATE_FIND_FACE_SPECIAL_ANIM_DONE, livenessStat.resetTimePoint()");
                                    LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                                    LivenessRecogActivity.this.livenessStat.findFaceLast = 0;
                                    LivenessRecogActivity.this.livenessStat.timePointStartFindFace = System.currentTimeMillis();
                                    return;
                                }
                            }
                        } else {
                            LivenessRecogActivity.this.processState.stateFlag = 1;
                            LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                            LivenessRecogActivity.this.livenessStat.resetTimePoint();
                            Log.w(str, "STATE_FIND_FACE_SPECIAL_ANIM_DONE NO FACE, livenessStat.resetTimePoint()");
                            LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                            LivenessRecogActivity.this.livenessStat.findFaceLast = 0;
                            LivenessRecogActivity.this.livenessStat.timePointStartFindFace = System.currentTimeMillis();
                            return;
                        }
                    }
                    if (LivenessRecogActivity.this.processState.stateFlag == 5) {
                        if (LivenessRecogActivity.this.isHasFace(access$2600)) {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                        }
                        if (!LivenessRecogActivity.this.animState.startBlinkAnimFlag) {
                            LivenessRecogActivity.this.startPoseTipAnim(1);
                            LivenessRecogActivity.this.animState.startBlinkAnimFlag = true;
                        }
                    } else if (LivenessRecogActivity.this.processState.stateFlag == 7) {
                        if (LivenessRecogActivity.this.isHasFace(access$2600)) {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                        }
                        if (!LivenessRecogActivity.this.animState.startMouthOpenAnimFlag) {
                            LivenessRecogActivity.this.startPoseTipAnim(3);
                            LivenessRecogActivity.this.animState.startMouthOpenAnimFlag = true;
                        }
                    }
                    Log.e(str, "state STATE_START_TRACK_BLICK state", Integer.valueOf(LivenessRecogActivity.this.processState.stateFlag));
                    if (LivenessRecogActivity.this.processState.stateFlag == 6 || LivenessRecogActivity.this.processState.stateFlag == 8) {
                        Log.e(str, "state STATE_START_TRACK_BLICK");
                        if (LivenessRecogActivity.this.isTimeOut()) {
                            LivenessRecogActivity.this.handleTimeOut();
                            return;
                        } else if (!LivenessRecogActivity.this.isHasFace(access$2600)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(3);
                            LivenessRecogActivity.this.processState.blickFindFaceFlag = false;
                        } else if (LivenessRecogActivity.this.errorCode == ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.startPoseWarningAnim(2);
                            return;
                        } else {
                            LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                            if (livenessRecogActivity.isAngleOfRange(access$2600[0], livenessRecogActivity.errorCode)) {
                                LivenessRecogActivity.this.startPoseWarningAnim(4);
                                return;
                            } else if (!LivenessRecogActivity.this.isFaceInsideRound(access$2600)) {
                                LivenessRecogActivity.this.lastWaringType = -1;
                                LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                                return;
                            } else if (PassBiometricUtil.isTooFarFromCamera(access$2600[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                                LivenessRecogActivity.this.startPoseWarningAnim(1);
                                return;
                            } else if (PassBiometricUtil.isTooNearFromCamera(access$2600[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                                LivenessRecogActivity.this.startPoseWarningAnim(0);
                                return;
                            } else {
                                LivenessRecogActivity.this.lastWaringType = -1;
                                LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                                LivenessRecogActivity.this.liveNessDetect(access$2600);
                            }
                        }
                    }
                    if (LivenessRecogActivity.this.processState.stateFlag == 9) {
                        if (LivenessRecogActivity.this.isTimeOut()) {
                            LivenessRecogActivity.this.handleTimeOut();
                            return;
                        } else if (!LivenessRecogActivity.this.isHasFace(access$2600)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(3);
                            LivenessRecogActivity.this.processState.blickFindFaceFlag = false;
                            return;
                        } else if (LivenessRecogActivity.this.errorCode == ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.startPoseWarningAnim(2);
                            return;
                        } else {
                            LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                            if (livenessRecogActivity2.isAngleOfRange(access$2600[0], livenessRecogActivity2.errorCode)) {
                                LivenessRecogActivity.this.startPoseWarningAnim(4);
                                return;
                            } else if (LivenessRecogActivity.this.isFaceInsideRound(access$2600)) {
                                if (PassBiometricUtil.isTooFarFromCamera(access$2600[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                                    LivenessRecogActivity.this.startPoseWarningAnim(1);
                                    return;
                                } else if (PassBiometricUtil.isTooNearFromCamera(access$2600[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                                    LivenessRecogActivity.this.startPoseWarningAnim(0);
                                    return;
                                } else {
                                    LivenessRecogActivity.this.lastWaringType = -1;
                                    LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                                }
                            }
                        }
                    }
                    StringBuilder a3 = a.a("onTick|state");
                    a3.append(LivenessRecogActivity.this.processState.stateFlag);
                    a3.append("|errcode|");
                    a3.append(LivenessRecogActivity.this.errorCode);
                    Log.w(str, a3.toString());
                    if (LivenessRecogActivity.this.isHasFace(access$2600) && !LivenessRecogActivity.this.isActivityFinished && ((LivenessRecogActivity.this.processState.stateFlag == 9 || LivenessRecogActivity.this.processState.stateFlag == 20) && LivenessRecogActivity.this.errorCode == ErrCode.OK)) {
                        FaceVerifyData[] faceVerifyDataArr = LivenessRecogActivity.this.faceTracker.get_FaceVerifyData(0);
                        LivenessRecogActivity.this.livenessStat.isLivenessSuc = true;
                        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
                            LivenessRecogActivity.this.livenessStat.getIDLPicture = 0;
                        } else {
                            LivenessRecogActivity.this.livenessStat.getIDLPicture = 1;
                        }
                        Object[] objArr = new Object[1];
                        StringBuilder a4 = a.a("livenessdone|faceVerifyDatas length|");
                        a4.append(faceVerifyDataArr != null ? Integer.valueOf(faceVerifyDataArr.length) : "0");
                        a4.append("|state|");
                        a4.append(LivenessRecogActivity.this.processState.stateFlag);
                        objArr[0] = a4.toString();
                        Log.w(str, objArr);
                        LivenessRecogActivity livenessRecogActivity3 = LivenessRecogActivity.this;
                        if (livenessRecogActivity3.shouldPhotograph(access$2600[0], livenessRecogActivity3.errorCode) && faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                            LivenessRecogActivity.this.processState.stateFlag = 10;
                            LivenessRecogActivity.this.uiHandler.removeCallbacks(LivenessRecogActivity.this.recogTimeCountRunnable);
                            LivenessRecogActivity.this.timerCount.cancel();
                            LivenessRecogActivity.this.cameraInterface.stopPreview();
                            LivenessRecogActivity.this.constrastLoadingView.setVisible(0);
                            LivenessRecogActivity.this.constrastPortrait(LivenessRecogActivity.this.revertData(faceVerifyDataArr));
                        }
                    }
                } else if (LivenessRecogActivity.this.isTimeOut()) {
                    LivenessRecogActivity.this.handleTimeOut();
                } else if (!LivenessRecogActivity.this.isHasFace(access$2600)) {
                    LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                    LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                    LivenessRecogActivity.this.lastWaringType = -1;
                    LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                } else if (LivenessRecogActivity.this.errorCode == ErrCode.POOR_ILLUMINATION) {
                    LivenessRecogActivity.this.startPoseWarningAnim(2);
                } else {
                    LivenessRecogActivity livenessRecogActivity4 = LivenessRecogActivity.this;
                    if (livenessRecogActivity4.isAngleOfRange(access$2600[0], livenessRecogActivity4.errorCode)) {
                        LivenessRecogActivity.this.startPoseWarningAnim(4);
                    } else if (!LivenessRecogActivity.this.isFaceInsideRound(access$2600)) {
                        LivenessRecogActivity.this.lastWaringType = -1;
                        LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                        LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                        LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                        LivenessRecogActivity.this.livenessStat.findFaceLast = 0;
                        Log.w(str, "STATE_START_RECOGNIZE, livenessStat.resetTimePoint()");
                    } else if (PassBiometricUtil.isTooFarFromCamera(access$2600[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                        LivenessRecogActivity.this.startPoseWarningAnim(1);
                    } else if (PassBiometricUtil.isTooNearFromCamera(access$2600[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                        LivenessRecogActivity.this.startPoseWarningAnim(0);
                    } else {
                        LivenessRecogActivity.this.lastWaringType = -1;
                        LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                        LivenessRecogActivity.this.processState.stateFlag = 2;
                        if (!LivenessRecogActivity.this.processState.firstFindFaceFlag) {
                            LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_successed));
                            LivenessRecogActivity.this.lastCurMills = System.currentTimeMillis();
                            LivenessRecogActivity.this.processState.firstFindFaceFlag = true;
                        }
                        LivenessRecogActivity.this.startRecognizingAnim();
                        LivenessRecogActivity.this.liveNessDetect(access$2600);
                    }
                }
            }
        }
    }

    public static /* synthetic */ int access$2004(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.frameStack + 1;
        livenessRecogActivity.frameStack = i2;
        return i2;
    }

    public static /* synthetic */ int access$2006(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.frameStack - 1;
        livenessRecogActivity.frameStack = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    public void activityFinish(int i2) {
        Log.w(TAG, "activityFinish");
        this.livenessStat.timePointEnd = System.currentTimeMillis();
        PassFaceRecogDTO passFaceRecogDTO = this.passFaceRecogDTO;
        if (passFaceRecogDTO != null) {
            this.livenessStat.guideLiveness = passFaceRecogDTO.guideLiveness ? 1 : 0;
        }
        LivenessStat livenessStat2 = this.livenessStat;
        livenessStat2.errCode = i2;
        PassFaceRecogDTO passFaceRecogDTO2 = this.passFaceRecogDTO;
        livenessStat2.recogType = passFaceRecogDTO2 != null ? passFaceRecogDTO2.livenessType.getRecogTypeName() : "unknown_type";
        this.livenessStat.onStat(this);
        TimeCount timeCount = this.timerCount;
        if (timeCount != null) {
            timeCount.cancel();
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        finish();
    }

    /* access modifiers changed from: private */
    public String argb2String(int[] iArr) {
        CameraSize previewSize = this.cameraInterface.getPreviewSize();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, previewSize.height, previewSize.width, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new String(Base64Utils.encode(byteArray));
    }

    private void bindSurfaceView(CameraSize cameraSize) {
        LayoutParams layoutParams = new LayoutParams(this.surfaceView.getLayoutParams());
        CameraSize surfaceViewSize = getSurfaceViewSize(cameraSize);
        if (surfaceViewSize == null || (surfaceViewSize.width == cameraSize.width && surfaceViewSize.height == cameraSize.height)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = surfaceViewSize.width;
            layoutParams.height = surfaceViewSize.height;
        }
        this.surfaceView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void btnBackStat() {
        int i2 = this.processState.stateFlag;
        if (i2 < 4) {
            this.livenessStat.clickCloseType = LivenessStat.TYPE_CLOSE_FIND_FACE;
        } else if (i2 >= 4 && i2 < 9) {
            int i3 = this.headMode;
            if (i3 == 0) {
                this.livenessStat.clickCloseType = LivenessStat.TYPE_CLOSE_FIND_EYE;
            } else if (i3 == 5) {
                this.livenessStat.clickCloseType = LivenessStat.TYPE_CLOSE_FIND_MOUTH;
            }
        }
    }

    /* access modifiers changed from: private */
    public void callbackFailureOrContinueFaceDetect(int i2, String str) {
        if (this.currentConstrastBeanPos == this.totalConstrastBeanCount) {
            this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
            if (this.callback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(i2);
                passFaceRecogResult.setResultMsg(str);
                this.callback.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        dofaceDetect();
    }

    private void clearBitmapCache() {
        for (SoftReference softReference : this.bitmapCache.values()) {
            Bitmap bitmap = (Bitmap) softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* access modifiers changed from: private */
    public void constrastPortrait(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() {
            public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr) {
                LivenessRecogActivity.this.totalConstrastBeanCount = 0;
                LivenessRecogActivity.this.currentConstrastBeanPos = 0;
                ArrayList<HashMap<String, byte[]>> arrayList = new ArrayList<>();
                for (FaceVerifyData faceVerifyData : faceVerifyDataArr) {
                    int[] iArr = faceVerifyData.mRegImg;
                    byte[] bArr = faceVerifyData.mRegDigest;
                    if (iArr != null && iArr.length > 0 && bArr != null && bArr.length > 0) {
                        int i2 = faceVerifyData.rows;
                        int i3 = faceVerifyData.cols;
                        Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
                        if (createBitmap != null) {
                            createBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i2);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                            if (!createBitmap.isRecycled()) {
                                createBitmap.recycle();
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA, byteArrayOutputStream.toByteArray());
                            hashMap.put("digest", bArr);
                            arrayList.add(hashMap);
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                return arrayList;
            }

            public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
                if (arrayList == null || arrayList.size() <= 0) {
                    if (LivenessRecogActivity.this.callback != null) {
                        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                        passFaceRecogResult.setResultCode(-306);
                        passFaceRecogResult.setResultMsg(PassFaceRecogResult.ERROR_MSG_IMAGE_FILE_EMPTY);
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(-306);
                    return;
                }
                LivenessRecogActivity.this.totalConstrastBeanCount = arrayList.size();
                LivenessRecogActivity.this.portraitList = arrayList;
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                PassFaceRecogDTO passFaceRecogDTO = livenessRecogActivity.passFaceRecogDTO;
                if (passFaceRecogDTO == null) {
                    return;
                }
                if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                    if (livenessRecogActivity.livenessConfig != null) {
                        LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                        livenessRecogActivity2.totalConstrastBeanCount = livenessRecogActivity2.livenessConfig.getRecogUploadPortraitCount(LivenessRecogActivity.this.totalConstrastBeanCount);
                    }
                    LivenessRecogActivity.this.dofaceDetect();
                    return;
                }
                livenessRecogActivity.dofaceMatch();
            }
        }.execute(faceVerifyDataArr);
    }

    /* access modifiers changed from: private */
    @TargetApi(9)
    public void doSomethingWithPreviewSize(Camera camera) {
        if (this.previewWidth == 0) {
            Size previewSize = camera.getParameters().getPreviewSize();
            CameraInfo cameraInfo = new CameraInfo();
            if (this.cameraInterface.isFrontCamera()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.previewWidth = previewSize.width;
            this.previewHeight = previewSize.height;
            this.cameraAngle = cameraInfo.orientation;
        }
        if (this.canvasBitmapSize == null) {
            int[] iArr = new int[2];
            this.canvasBitmapSize = iArr;
            iArr[0] = this.previewHeight;
            iArr[1] = this.previewWidth;
        }
        LivenessConfigOption livenessConfigOption = this.livenessConfig;
        if (livenessConfigOption == null || TextUtils.isEmpty(livenessConfigOption.minFaceSize)) {
            if (this.previewWidth <= 640 || this.previewHeight <= 480) {
                this.faceTracker.set_min_face_size(100);
            } else {
                this.faceTracker.set_min_face_size(200);
            }
        }
        if (this.argbData == null) {
            this.argbData = new int[(this.previewWidth * this.previewHeight)];
        }
    }

    /* access modifiers changed from: private */
    public void dofaceDetect() {
        boolean z = true;
        int i2 = this.currentConstrastBeanPos + 1;
        this.currentConstrastBeanPos = i2;
        ArrayList<HashMap<String, byte[]>> arrayList = this.portraitList;
        if (arrayList != null && i2 <= this.totalConstrastBeanCount && i2 <= arrayList.size()) {
            this.faceData = (byte[]) ((HashMap) this.portraitList.get(this.currentConstrastBeanPos - 1)).get(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA);
            this.faceDigest = (byte[]) ((HashMap) this.portraitList.get(this.currentConstrastBeanPos - 1)).get("digest");
            if (this.currentConstrastBeanPos != this.portraitList.size()) {
                z = false;
            }
            this.isLast = z;
            faceDetectHttp(this.faceDigest != null ? new String(this.faceDigest) : null, Base64Utils.encodeToString(this.faceData), this.isLast);
        }
    }

    /* access modifiers changed from: private */
    public void dofaceMatch() {
        String str;
        boolean z = this.isLast;
        String str2 = LivenessStat.TYPE_FACE_MATCH_FAIL;
        if (z) {
            if (this.callback != null) {
                this.livenessStat.faceMatchType = str2;
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-206);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                this.callback.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult.getResultCode());
            }
            return;
        }
        boolean z2 = true;
        int i2 = this.currentConstrastBeanPos + 1;
        this.currentConstrastBeanPos = i2;
        ArrayList<HashMap<String, byte[]>> arrayList = this.portraitList;
        if (arrayList == null || i2 > arrayList.size()) {
            if (this.callback != null) {
                this.livenessStat.faceMatchType = str2;
                PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
                passFaceRecogResult2.setResultCode(-206);
                passFaceRecogResult2.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                this.callback.onFailure(passFaceRecogResult2);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult2.getResultCode());
            }
            return;
        }
        byte[] bArr = (byte[]) ((HashMap) this.portraitList.get(this.currentConstrastBeanPos - 1)).get(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA);
        byte[] bArr2 = (byte[]) ((HashMap) this.portraitList.get(this.currentConstrastBeanPos - 1)).get("digest");
        if (this.currentConstrastBeanPos != this.portraitList.size()) {
            z2 = false;
        }
        this.isLast = z2;
        String str3 = null;
        if (bArr2 == null) {
            str = null;
        } else {
            str = new String(bArr2);
        }
        if (bArr != null) {
            str3 = Base64Utils.encodeToString(bArr);
        }
        portraitContrast(str, str3, this.isLast, this.voiceCredential);
    }

    private void faceDetectHttp(String str, String str2, boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.passFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
        httpHashMapWrap.put("imgdigests", str);
        httpHashMapWrap.put("image", str2);
        httpHashMapWrap.put("last", z ? "1" : "0");
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th, int i2, String str) {
                LivenessRecogActivity.this.callbackFailureOrContinueFaceDetect(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            }

            public void onSuccess(int i2, String str) {
                Log.i(LivenessRecogActivity.TAG, a.a("faceDetectHttp|responseBody|", str));
                final PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("result");
                    passFaceRecogResult.extraJson = jSONObject;
                    String optString = jSONObject.optString("faceid");
                    passFaceRecogResult.callbackkey = optString;
                    if (TextUtils.isEmpty(optString)) {
                        LivenessRecogActivity.this.callbackFailureOrContinueFaceDetect(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                    } else if (LivenessRecogActivity.this.callback != null) {
                        new AsyncTask<Void, Void, PassFaceRecogResult>() {
                            public PassFaceRecogResult doInBackground(Void... voidArr) {
                                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                                if (livenessRecogActivity.passFaceRecogDTO != null) {
                                    if (livenessRecogActivity.cameraDataCache != null && LivenessRecogActivity.this.cameraDataCache.size() > 0) {
                                        PassFaceRecogResult passFaceRecogResult = passFaceRecogResult;
                                        LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                                        passFaceRecogResult.originalImage = livenessRecogActivity2.argb2String((int[]) livenessRecogActivity2.cameraDataCache.get(LivenessRecogActivity.this.cameraDataCache.size() - LivenessRecogActivity.this.currentConstrastBeanPos));
                                    }
                                    if (LivenessRecogActivity.this.faceData != null) {
                                        byte[] encode = Base64Utils.encode(LivenessRecogActivity.this.faceData);
                                        if (encode != null) {
                                            passFaceRecogResult.faceimage = new String(encode);
                                        }
                                    }
                                    if (LivenessRecogActivity.this.faceDigest != null) {
                                        passFaceRecogResult.imgdigests = new String(LivenessRecogActivity.this.faceDigest);
                                    }
                                }
                                return passFaceRecogResult;
                            }

                            public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
                                super.onPostExecute(passFaceRecogResult);
                                passFaceRecogResult.setResultCode(0);
                                LivenessRecogActivity.this.callback.onSuccess(passFaceRecogResult);
                                LivenessRecogActivity.this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_PASS;
                                LivenessRecogActivity.this.activityFinish(passFaceRecogResult.getResultCode());
                            }
                        }.execute(new Void[0]);
                    }
                } catch (JSONException unused) {
                    LivenessRecogActivity.this.callbackFailureOrContinueFaceDetect(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    @TargetApi(9)
    public void faceRecognize() {
        String str = TAG;
        if (this.cameraData != null && this.argbData != null && !this.isActivityFinished) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                FaceSDK.getARGBFromYUVimg(this.cameraData, this.argbData, this.previewWidth, this.previewHeight, this.cameraAngle, 1);
                this.errorCode = this.faceTracker.face_verification(this.argbData, this.previewWidth, this.previewHeight, ImgType.ARGB, action, "", "", "");
                StringBuilder sb = new StringBuilder();
                sb.append("errorcode:");
                sb.append(this.errorCode);
                Log.w(str, sb.toString());
                FaceInfo[] faceInfoArr = this.faceTracker.get_TrackedFaceInfo();
                this.faceInfos = faceInfoArr;
                int i2 = (faceInfoArr == null || faceInfoArr.length <= 0 || faceInfoArr[0] == null) ? 0 : faceInfoArr[0].face_id;
                if (!(i2 == 0 || i2 == this.lastFaceId)) {
                    this.cameraDataCache.clear();
                }
                this.lastFaceId = i2;
                if (this.errorCode == ErrCode.DATA_HIT_ONE) {
                    if (this.isFinish) {
                        this.cameraDataCache.clear();
                        this.isFinish = false;
                    }
                    if (this.argbData != null) {
                        this.cameraDataCache.add(Arrays.copyOf(this.argbData, this.argbData.length));
                    }
                } else if (this.errorCode == ErrCode.DATA_HIT_LAST) {
                    if (this.argbData != null) {
                        this.cameraDataCache.add(Arrays.copyOf(this.argbData, this.argbData.length));
                    }
                    this.isFinish = true;
                }
                this.cameraData = null;
                if (this.faceInfos != null && this.faceInfos.length > 0 && this.faceInfos[0] != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("idl tracker time");
                    sb2.append(currentTimeMillis2);
                    Log.w(str, sb2.toString());
                    this.livenessStat.timePointIdlTrackTimeAll += currentTimeMillis2;
                    this.livenessStat.timePointIdlTrackCounts++;
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    private CameraSize getDisplaySize() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        return new CameraSize(defaultDisplay.getWidth(), PassBioDisplayUtil.getNavigationBarHeight(this) + defaultDisplay.getHeight());
    }

    /* access modifiers changed from: private */
    public int getHeadMode() {
        if (this.firstLivenessRcogType == 1) {
            this.headMode = 0;
        } else {
            this.headMode = 5;
        }
        return this.headMode;
    }

    private int getOnlineIllum() {
        List aBtestIllumList = this.livenessConfig.getABtestIllumList();
        int illumVlaueGray = LocalConfigOptions.getInstance(this).getIllumVlaueGray();
        String str = TAG;
        if (illumVlaueGray == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            illumVlaueGray = random.nextInt(aBtestIllumList.size());
            LocalConfigOptions.getInstance(this).setIllumValueGray(illumVlaueGray);
            Log.w(str, a.a("getOnlineIllum random", illumVlaueGray));
        }
        Log.w(str, a.a("getOnlineIllum", illumVlaueGray));
        return ((Integer) aBtestIllumList.get(illumVlaueGray)).intValue();
    }

    /* access modifiers changed from: private */
    public Bitmap getScaleBitmap(int i2) {
        if (this.bitmapCache.containsKey(Integer.valueOf(i2)) && this.bitmapCache.get(Integer.valueOf(i2)) != null) {
            Bitmap bitmap = (Bitmap) ((SoftReference) this.bitmapCache.get(Integer.valueOf(i2))).get();
            if (bitmap != null) {
                return bitmap;
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_width);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i2, options);
        options.inSampleSize = PassBiometricUtil.calculateInSampleSize(options, dimensionPixelSize2, dimensionPixelSize);
        options.inJustDecodeBounds = false;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i2, options);
        this.bitmapCache.put(Integer.valueOf(i2), new SoftReference(decodeResource));
        return decodeResource;
    }

    private CameraSize getSurfaceViewSize(CameraSize cameraSize) {
        if (cameraSize == null) {
            return null;
        }
        CameraSize displaySize = getDisplaySize();
        CameraSize cameraSize2 = new CameraSize(cameraSize.width, cameraSize.height);
        float f2 = ((float) cameraSize.width) / ((float) cameraSize.height);
        float f3 = ((float) displaySize.height) / ((float) displaySize.width);
        if (((double) Math.abs(f2 - f3)) <= 0.02d) {
            return cameraSize2;
        }
        if (f2 < f3) {
            int i2 = displaySize.height;
            cameraSize2.width = (cameraSize.height * i2) / cameraSize.width;
            cameraSize2.height = i2;
        } else {
            cameraSize2.width = displaySize.width;
            cameraSize2.height = (displaySize.width * cameraSize.width) / cameraSize.height;
        }
        return cameraSize2;
    }

    @TargetApi(3)
    private void goToFaceMatchResult(final ContrastPortraitResult contrastPortraitResult) {
        if (this.callback != null && contrastPortraitResult != null) {
            new AsyncTask<Void, Void, PassFaceRecogResult>() {
                public PassFaceRecogResult doInBackground(Void... voidArr) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    int i2 = 0;
                    if (contrastPortraitResult.isProcessPass()) {
                        LivenessRecogActivity.this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_PASS;
                        passFaceRecogResult.setResultCode(0);
                    } else {
                        LivenessRecogActivity.this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
                        passFaceRecogResult.setResultCode(-302);
                    }
                    ContrastPortraitResult contrastPortraitResult = contrastPortraitResult;
                    passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
                    if (!TextUtils.isEmpty(contrastPortraitResult.imgdigests) && LivenessRecogActivity.this.portraitList != null && LivenessRecogActivity.this.portraitList.size() > 0) {
                        int size = LivenessRecogActivity.this.portraitList.size();
                        while (true) {
                            if (i2 >= size) {
                                i2 = -1;
                                break;
                            }
                            byte[] bArr = (byte[]) ((HashMap) LivenessRecogActivity.this.portraitList.get(i2)).get("digest");
                            if (bArr != null && contrastPortraitResult.imgdigests.equals(new String(bArr))) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            PassFaceRecogDTO passFaceRecogDTO = LivenessRecogActivity.this.passFaceRecogDTO;
                            if (passFaceRecogDTO != null) {
                                if (passFaceRecogDTO.isReturnOriginImage() && LivenessRecogActivity.this.cameraDataCache != null && LivenessRecogActivity.this.cameraDataCache.size() > 0) {
                                    LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                                    passFaceRecogResult.originalImage = livenessRecogActivity.argb2String((int[]) livenessRecogActivity.cameraDataCache.get((LivenessRecogActivity.this.cameraDataCache.size() - i2) - 1));
                                }
                                if (LivenessRecogActivity.this.passFaceRecogDTO.isReturnCutImage()) {
                                    byte[] bArr2 = (byte[]) ((HashMap) LivenessRecogActivity.this.portraitList.get(i2)).get(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA);
                                    if (bArr2 != null) {
                                        byte[] encode = Base64Utils.encode(bArr2);
                                        if (encode != null) {
                                            passFaceRecogResult.faceimage = new String(encode);
                                        }
                                    }
                                    passFaceRecogResult.imgdigests = new String(contrastPortraitResult.imgdigests);
                                }
                            }
                        }
                    }
                    passFaceRecogResult.authSid = contrastPortraitResult.authsid;
                    return passFaceRecogResult;
                }

                public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
                    super.onPostExecute(passFaceRecogResult);
                    if (contrastPortraitResult.isProcessPass()) {
                        LivenessRecogActivity.this.callback.onSuccess(passFaceRecogResult);
                    } else {
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(passFaceRecogResult.getResultCode());
                }
            }.execute(new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    public void handlePortraitContrastFail(ContrastPortraitResult contrastPortraitResult) {
        if (this.isLast) {
            this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
            if (this.callback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(contrastPortraitResult.getResultCode());
                passFaceRecogResult.setResultMsg(contrastPortraitResult.getResultMsg());
                this.callback.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        dofaceMatch();
    }

    /* access modifiers changed from: private */
    public void handlePortraitContrastSuc(ContrastPortraitResult contrastPortraitResult) {
        if (contrastPortraitResult.getResultCode() != 0) {
            handlePortraitContrastFail(contrastPortraitResult);
            this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
            return;
        }
        this.voiceCredential = contrastPortraitResult.callbackkey;
        if (!contrastPortraitResult.isFinish()) {
            dofaceMatch();
        } else if (contrastPortraitResult.isProcessPass()) {
            goToFaceMatchResult(contrastPortraitResult);
        } else {
            goToFaceMatchResult(contrastPortraitResult);
        }
    }

    /* access modifiers changed from: private */
    public void handleTimeOut() {
        ProcessState processState2 = this.processState;
        processState2.wholeProcessStartTime = 0;
        if (!processState2.timeOutFlag) {
            showVerifyTimeoutDialog();
            this.processState.timeOutFlag = true;
            return;
        }
        showChangeDeviceDialog();
    }

    private void init() {
        this.headPoses = getResources().getStringArray(R.array.pass_liveness_head_pose);
        this.uiHandler = new Handler(Looper.getMainLooper(), this);
        this.processState = new ProcessState();
        this.animState = new AnimState();
        TimeCount timeCount = new TimeCount(Config.BPLUS_DELAY_TIME, 200);
        this.timerCount = timeCount;
        this.processState.wholeProcessStartTime = System.currentTimeMillis();
        this.livenessStat.subPro = this.passFaceRecogDTO.getSpno();
        this.callback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        initOnlineConfig();
        this.headMode = getHeadMode();
        initLiveness();
        int onlineIllum = getOnlineIllum();
        this.illumValue = onlineIllum;
        this.livenessStat.onLineIllum = onlineIllum;
        this.sensorManager = new BioSensorManager(this);
    }

    private void initFaceTracker() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (!TextUtils.isEmpty(token)) {
            String str = "frfsd_ai";
            if (!TextUtils.isEmpty(str)) {
                try {
                    FaceTracker faceTracker2 = new FaceTracker(getAssets(), this, str, token, "", AlignMethodType.SDM_7PTS, ParsMethodType.NOT_USE);
                    this.faceTracker = faceTracker2;
                    faceTracker2.set_isFineAlign(false);
                    this.faceTracker.set_isVerifyLive(true);
                    this.faceTracker.set_min_face_size(this.livenessConfig.getMinFaceSize());
                    this.faceTracker.set_illum_thr((float) this.livenessConfig.getIllumThr());
                    this.faceTracker.set_track_by_detection_interval(this.livenessConfig.getTrackInterval());
                    this.faceTracker.set_detect_in_video_interval(this.livenessConfig.getDetectInterval());
                    this.faceTracker.set_eulur_angle_thr(this.livenessConfig.getYaw(), this.livenessConfig.getPitch(), this.livenessConfig.getRoll());
                    this.faceTracker.set_max_reg_img_num(this.livenessConfig.getMaxRegImgNum());
                    this.faceTracker.set_prefetch_reg_img_interval(this.livenessConfig.getPrefetchRegImgInterval());
                    this.faceTracker.set_cropFaceSize(this.livenessConfig.getCropFaceSize());
                    this.faceTracker.set_cropFaceEnlargeRatio((float) this.livenessConfig.getCropFaceRatio());
                    return;
                } catch (Exception e2) {
                    StringBuilder a2 = a.a("init faceTracker failure: ");
                    a2.append(e2.getMessage());
                    throw new Exception(a2.toString());
                }
            }
        }
        throw new Exception("idlToken or apiKey is empty");
    }

    private void initLiveness() {
        try {
            loadSo();
            initFaceTracker();
        } catch (Exception unused) {
            if (this.callback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL);
                this.callback.onFailure(passFaceRecogResult);
            }
            setActivityResult(0);
            activityFinish(PassFaceRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL);
        }
    }

    private void initOnlineConfig() {
        LivenessConfigOption livenessConfigOption = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.livenessConfig = livenessConfigOption;
        this.firstLivenessRecogTime = livenessConfigOption.getRecogtimeInterval();
        this.firstLivenessRcogType = (long) this.livenessConfig.getRecogActionType();
    }

    /* access modifiers changed from: private */
    public boolean isAngleOfRange(FaceInfo faceInfo, ErrCode errCode) {
        if (errCode == ErrCode.YAW_OUT_OF_RANGE || errCode == ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == ErrCode.OK && faceInfo.headPose.length == 3) {
            float abs = Math.abs(faceInfo.headPose[0]);
            LivenessConfigOption livenessConfigOption = this.livenessConfig;
            int i2 = 15;
            if (abs < ((float) (livenessConfigOption != null ? livenessConfigOption.getPitch() : 15))) {
                float abs2 = Math.abs(faceInfo.headPose[1]);
                LivenessConfigOption livenessConfigOption2 = this.livenessConfig;
                if (livenessConfigOption2 != null) {
                    i2 = livenessConfigOption2.getYaw();
                }
                if (abs2 >= ((float) i2)) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isFaceInsideRound(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length <= 0 || !PassBiometricUtil.isFaceInsideRound(faceInfoArr[0].landmarks, this.canvasBitmapSize)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isHasFace(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* access modifiers changed from: private */
    public boolean isTimeOut() {
        Log.e(TAG, "processState.wholeProcessStartTime", Long.valueOf(this.processState.wholeProcessStartTime));
        long currentTimeMillis = System.currentTimeMillis();
        ProcessState processState2 = this.processState;
        long j2 = processState2.wholeProcessStartTime;
        return currentTimeMillis - j2 > processState2.wholeProcessTimeOut && j2 > 0;
    }

    /* access modifiers changed from: private */
    public boolean isUpdateWhiteBg(float f2) {
        StringBuilder a2 = a.a("whiteBgIllumThr");
        a2.append(this.illumValue);
        Log.w(TAG, a2.toString());
        return f2 <= ((float) this.illumValue);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r0 == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r0 == false) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void liveNessDetect(com.baidu.idl.facesdk.FaceInfo[] r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0110
            int r0 = r10.length
            if (r0 <= 0) goto L_0x0110
            com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$ProcessState r0 = r9.processState
            int r0 = r0.stateFlag
            r1 = 1
            if (r0 < r1) goto L_0x0110
            r2 = 9
            if (r0 >= r2) goto L_0x0110
            int r0 = r9.headMode
            r3 = 0
            if (r0 == 0) goto L_0x0055
            if (r0 == r1) goto L_0x004c
            r4 = 2
            if (r0 == r4) goto L_0x0045
            r4 = 3
            if (r0 == r4) goto L_0x003e
            r4 = 4
            if (r0 == r4) goto L_0x0037
            r4 = 5
            if (r0 == r4) goto L_0x0026
            r10 = r3
            r0 = r10
            goto L_0x0053
        L_0x0026:
            r0 = r10[r3]
            boolean r0 = r0.is_live_mouth()
            r10 = r10[r3]
            boolean r10 = r10.is_live()
            if (r10 != 0) goto L_0x006a
            if (r0 == 0) goto L_0x0066
            goto L_0x006a
        L_0x0037:
            r10 = r10[r3]
            boolean r10 = r10.is_live_head_turn_right()
            goto L_0x0052
        L_0x003e:
            r10 = r10[r3]
            boolean r10 = r10.is_live_head_turn_left()
            goto L_0x0052
        L_0x0045:
            r10 = r10[r3]
            boolean r10 = r10.is_live_head_up()
            goto L_0x0052
        L_0x004c:
            r10 = r10[r3]
            boolean r10 = r10.is_live_head_down()
        L_0x0052:
            r0 = r3
        L_0x0053:
            r4 = r0
            goto L_0x006d
        L_0x0055:
            r0 = r10[r3]
            boolean r0 = r0.is_live_mouth()
            r10 = r10[r3]
            boolean r10 = r10.is_live()
            if (r10 != 0) goto L_0x006a
            if (r0 == 0) goto L_0x0066
            goto L_0x006a
        L_0x0066:
            r4 = r0
            r0 = r10
            r10 = r3
            goto L_0x006d
        L_0x006a:
            r4 = r0
            r0 = r10
            r10 = r1
        L_0x006d:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "liveNessDetect|isLiveNess|"
            r6.append(r7)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            r5[r3] = r6
            java.lang.String r6 = "LivenessRecog"
            com.baidu.pass.biometrics.base.debug.Log.w(r6, r5)
            if (r10 == 0) goto L_0x0110
            java.lang.String r10 = "mouth"
            java.lang.String r5 = "eye"
            if (r0 == 0) goto L_0x00b9
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r0 = r9.livenessStat
            int r4 = r0.livingPassEyesNum
            int r4 = r4 + r1
            r0.livingPassEyesNum = r4
            long r7 = java.lang.System.currentTimeMillis()
            r0.timePointLivingEyePass = r7
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r0 = r9.livenessStat
            r0.livingPassType = r5
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r4 = "timePointLivingEyePass:"
            java.lang.StringBuilder r4 = e.a.a.a.a.a(r4)
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r7 = r9.livenessStat
            long r7 = r7.timePointLivingEyePass
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0[r3] = r4
            com.baidu.pass.biometrics.base.debug.Log.w(r6, r0)
            goto L_0x00e4
        L_0x00b9:
            if (r4 == 0) goto L_0x00e4
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r0 = r9.livenessStat
            int r4 = r0.livingPassMouthNum
            int r4 = r4 + r1
            r0.livingPassMouthNum = r4
            long r7 = java.lang.System.currentTimeMillis()
            r0.timePointLivingMouthPass = r7
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r0 = r9.livenessStat
            r0.livingPassType = r10
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r4 = "timePointLivingMouthPass:"
            java.lang.StringBuilder r4 = e.a.a.a.a.a(r4)
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r7 = r9.livenessStat
            long r7 = r7.timePointLivingMouthPass
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0[r3] = r4
            com.baidu.pass.biometrics.base.debug.Log.w(r6, r0)
        L_0x00e4:
            com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$ProcessState r0 = r9.processState
            int r0 = r0.stateFlag
            r4 = 7
            if (r0 >= r4) goto L_0x00f0
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r10 = r9.livenessStat
            r10.livingPassPeriod = r5
            goto L_0x00f4
        L_0x00f0:
            com.baidu.pass.biometrics.face.liveness.stat.LivenessStat r0 = r9.livenessStat
            r0.livingPassPeriod = r10
        L_0x00f4:
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r0 = "isLiveNess ProcessState:"
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$ProcessState r1 = r9.processState
            int r1 = r1.stateFlag
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10[r3] = r0
            com.baidu.pass.biometrics.base.debug.Log.w(r6, r10)
            com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$ProcessState r10 = r9.processState
            r10.stateFlag = r2
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.liveNessDetect(com.baidu.idl.facesdk.FaceInfo[]):void");
    }

    private void loadSo() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putString(OneDriverInfo.Options.ONE_UUID, this.passFaceRecogDTO.processid);
        bundle.putString("tpl", BeanConstants.tpl);
        bundle.putString("productId", this.passFaceRecogDTO.getSpno());
        if (!SoManager.load(this, bundle)) {
            throw new Exception("load so failure");
        }
    }

    /* access modifiers changed from: private */
    public boolean meetStartTrackRequirement(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        if (faceInfoArr.length <= 0 || (!PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, this.canvasBitmapSize) && !PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, this.canvasBitmapSize))) {
            return true;
        }
        return false;
    }

    private boolean openCamera() {
        this.surfaceView.setVisibility(4);
        boolean doOpenCamera = this.cameraInterface.doOpenCamera(this, 3);
        if (!doOpenCamera) {
            showPermissionDialog();
        } else {
            CameraSize previewSize = this.cameraInterface.getPreviewSize();
            bindSurfaceView(previewSize);
            this.cameraInterface.setPreviewCallback(this.previewCallback);
            this.surfaceView.startPreview();
            LivenessStat livenessStat2 = this.livenessStat;
            StringBuilder sb = new StringBuilder();
            sb.append(previewSize.height);
            sb.append(",");
            sb.append(previewSize.width);
            livenessStat2.previewSize = sb.toString();
        }
        this.surfaceView.setVisibility(0);
        return doOpenCamera;
    }

    private void portraitContrast(String str, String str2, boolean z, String str3) {
        final ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.passFaceRecogDTO.processid);
        PassFaceRecogType passFaceRecogType = this.passFaceRecogDTO.livenessType;
        String str4 = "type";
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            httpHashMapWrap.put(str4, "contrastportrait");
            httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.passFaceRecogDTO)));
        } else {
            String str5 = "exuid";
            if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                String str6 = "certinfo";
                httpHashMapWrap.put(str4, str6);
                httpHashMapWrap.put(str5, this.passFaceRecogDTO.exUid);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.passFaceRecogDTO.realName);
                    jSONObject.put("cert", this.passFaceRecogDTO.idCardNum);
                    jSONObject.put("bankmobile", this.passFaceRecogDTO.phoneNum);
                    httpHashMapWrap.put(str6, PassBioDataEncryptor.encryptParams(jSONObject.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                String str7 = "authtoken";
                httpHashMapWrap.put(str4, str7);
                httpHashMapWrap.put(str7, this.passFaceRecogDTO.authToken);
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
                httpHashMapWrap.put(str4, "outer");
                httpHashMapWrap.put(str5, this.passFaceRecogDTO.exUid);
            }
        }
        httpHashMapWrap.put("service_type", this.passFaceRecogDTO.serviceType);
        httpHashMapWrap.put("imgdigests", str);
        httpHashMapWrap.put("image", str2);
        String zid = PassBioGlobalUtils.getZid(getApplicationContext());
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put(Config.ZID, zid);
        }
        httpHashMapWrap.put("last", z ? "1" : "0");
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("callbackkey", str3);
        }
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th, int i2, String str) {
                contrastPortraitResult.setResultCode(-206);
                contrastPortraitResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                LivenessRecogActivity.this.handlePortraitContrastFail(contrastPortraitResult);
            }

            public void onSuccess(int i2, String str) {
                String str2 = LivenessRecogActivity.TAG;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("portraitContrast|responseBody|");
                    sb.append(str);
                    Log.i(str2, sb.toString());
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("retCode");
                    String optString = jSONObject.optString("retMsg");
                    contrastPortraitResult.setResultCode(optInt);
                    contrastPortraitResult.setResultMsg(optString);
                    if (contrastPortraitResult.getResultCode() == 0) {
                        JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                        if (LivenessRecogActivity.this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                            contrastPortraitResult.authsid = optJSONObject.optString("authsid");
                        }
                        contrastPortraitResult.callbackkey = optJSONObject.optString("callbackkey");
                        contrastPortraitResult.contrastres = optJSONObject.optInt("contrastres");
                        contrastPortraitResult.finalres = optJSONObject.optInt("finalres");
                        contrastPortraitResult.finish = optJSONObject.optInt("finish");
                        contrastPortraitResult.imgdigests = optJSONObject.optString("imgdigests");
                        contrastPortraitResult.recordvideo = optJSONObject.optInt("recordvideo");
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                    contrastPortraitResult.setResultCode(-206);
                    contrastPortraitResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                }
                LivenessRecogActivity.this.handlePortraitContrastSuc(contrastPortraitResult);
            }
        });
    }

    @TargetApi(23)
    private void requestCameraPermission() {
        String str = "android.permission.CAMERA";
        if (checkSelfPermission(str) == 0) {
            this.livenessStat.timePointStartRecog = System.currentTimeMillis();
            startLiveness();
            if (openCamera()) {
                LivenessStat livenessStat2 = this.livenessStat;
                livenessStat2.withCameraPermission = 1;
                livenessStat2.timePointCameraReady = System.currentTimeMillis();
            }
        } else if (!this.configuration.showPmnRationaleDialog) {
            this.processState.permissionFlag = true;
            requestPermissions(new String[]{str}, 2002);
        } else if (shouldShowRequestPermissionRationale(str)) {
            final CustomAlertDialog customAlertDialog = new CustomAlertDialog(this);
            customAlertDialog.setPositiveBtn(getString(R.string.pass_bio_pmn_ok), new OnClickListener() {
                public void onClick(View view) {
                    ViewUtility.dismissDialog(LivenessRecogActivity.this, customAlertDialog);
                    LivenessRecogActivity.this.processState.permissionFlag = true;
                    LivenessRecogActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
                }
            });
            customAlertDialog.setNegativeBtn(getString(R.string.pass_bio_pmn_cancel), new OnClickListener() {
                public void onClick(View view) {
                    ViewUtility.dismissDialog(LivenessRecogActivity.this, customAlertDialog);
                    if (LivenessRecogActivity.this.callback != null) {
                        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                        passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                }
            });
            customAlertDialog.setTitleText(String.format(getString(R.string.pass_bio_pmn_title_liveness), new Object[]{PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)}));
            customAlertDialog.setMessageText(String.format(getString(R.string.pass_bio_pmn_msg_liveness), new Object[]{PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)}));
            customAlertDialog.show();
        } else {
            this.processState.permissionFlag = true;
            requestPermissions(new String[]{str}, 2002);
        }
    }

    /* access modifiers changed from: private */
    public void resetViews() {
        this.poseTipWarningFl.setVisibility(4);
        this.lastWaringType = -1;
        this.poseTipTv.setText(R.string.pass_liveness_put_face_round);
        if (this.faceStateIv != null) {
            this.faceStateIv.setImageBitmap(getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
        }
    }

    /* access modifiers changed from: private */
    public FaceVerifyData[] revertData(FaceVerifyData[] faceVerifyDataArr) {
        String str;
        String str2;
        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
            return null;
        }
        int length = faceVerifyDataArr.length;
        int i2 = 0;
        while (true) {
            str = "    :";
            str2 = "hello";
            if (i2 >= length) {
                break;
            }
            StringBuilder a2 = a.a("原始数据照片签名", i2, str);
            a2.append(faceVerifyDataArr[i2].mRegDigest);
            Log.d(str2, a2.toString());
            i2++;
        }
        FaceVerifyData[] faceVerifyDataArr2 = new FaceVerifyData[faceVerifyDataArr.length];
        for (int i3 = 0; i3 < length; i3++) {
            faceVerifyDataArr2[i3] = faceVerifyDataArr[(length - 1) - i3];
            StringBuilder a3 = a.a("翻转后数据照片签名", i3, str);
            a3.append(faceVerifyDataArr[i3].mRegDigest);
            Log.d(str2, a3.toString());
        }
        return faceVerifyDataArr2;
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf((float) i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    private void setupViews() {
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        ImageView imageView = (ImageView) findViewById(R.id.btn_cancel);
        this.backBtn = imageView;
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LivenessRecogActivity.this.userCancel();
                LivenessRecogActivity.this.btnBackStat();
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.activityFinish(-204);
                LivenessRecogActivity.this.cameraInterface.doStopCamera();
            }
        });
        this.poseTipFl = (FrameLayout) findViewById(R.id.layout_pose_tip);
        this.poseTipTv = (TextView) findViewById(R.id.tv_pose_tip);
        this.poseTipWarningFl = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.poseTipWarningIv = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.poseTipWarningTv = (TextView) findViewById(R.id.tv_pose_warning_tip);
        this.constrastLoadingView = (ConstrastLoadingView) findViewById(R.id.constrastLoadingView);
        ImageView imageView2 = (ImageView) findViewById(R.id.img_face_recognized_state);
        this.faceStateIv = imageView2;
        imageView2.setImageBitmap(getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
        this.surfaceView = new CameraSurfaceView(this, null);
        this.viewGroup.addView(this.surfaceView, 0, new ViewGroup.LayoutParams(-2, -1));
        CameraInterface cameraInterface2 = new CameraInterface();
        this.cameraInterface = cameraInterface2;
        this.surfaceView.setCameraInterface(cameraInterface2);
        this.surfaceView.setVisibility(4);
        this.xfordView = (XfordView) findViewById(R.id.xfordview);
    }

    /* access modifiers changed from: private */
    public boolean shouldPhotograph(FaceInfo faceInfo, ErrCode errCode) {
        return faceInfo != null && this.errorCode == ErrCode.OK;
    }

    private void showChangeDeviceDialog() {
        this.livenessStat.tipOverTimeAgain = 1;
        this.processState.stateFlag = 17;
        this.uiHandler.removeCallbacks(this.recogTimeCountRunnable);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.pass_liveness_recog_fail_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.pass_bio_alert_dialog_btn_ok), new OnClickListener() {
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.livenessStat.tipOverTimeSure = 1;
                LivenessRecogActivity.this.setActivityResult(-1);
                if (LivenessRecogActivity.this.callback != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-301);
                    LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                }
                LivenessRecogActivity.this.activityFinish(-301);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void showPermissionDialog() {
        this.processState.permissionFlag = true;
        if (this.permissionAlertDialog == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            this.permissionAlertDialog = bioAlertDialog;
            bioAlertDialog.setTitleMsg(getString(R.string.pass_bio_permission_request));
            this.permissionAlertDialog.setTitleVisible(true);
            this.permissionAlertDialog.setDialogMsg(String.format(getString(R.string.pass_liveness_permission_camera), new Object[]{PassBiometricUtil.getAppName(this)}));
            this.permissionAlertDialog.setBtnCount(1);
            this.permissionAlertDialog.setNeutralBtn(getString(R.string.pass_bio_alert_dialog_btn_ok), new OnClickListener() {
                public void onClick(View view) {
                    LivenessRecogActivity.this.permissionAlertDialog.dismiss();
                    LivenessRecogActivity.this.processState.permissionFlag = false;
                    if (LivenessRecogActivity.this.callback != null) {
                        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                        passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                }
            });
        }
        this.permissionAlertDialog.setCancelable(false);
        if (!isFinishing() && !this.permissionAlertDialog.isShowing()) {
            this.permissionAlertDialog.show();
        }
    }

    private void showVerifyTimeoutDialog() {
        this.livenessStat.tipOverTime = 1;
        this.processState.stateFlag = 17;
        this.uiHandler.removeCallbacks(this.recogTimeCountRunnable);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.pass_face_timeout_dialog_title));
        bioAlertDialog.setTimeOutVisible(0);
        bioAlertDialog.setMessageText(getString(R.string.pass_face_timeout_dialog_msg));
        bioAlertDialog.setPositiveBtn(getString(R.string.pass_liveness_dialog_recognized_fail_cancel), new OnClickListener() {
            public void onClick(View view) {
                Log.w(LivenessRecogActivity.TAG, "showVerifyTimeoutDialog, livenessStat.resetTimePoint()");
                LivenessRecogActivity.this.livenessStat.resetTimePoint();
                LivenessRecogActivity.this.livenessStat.tipOverTimeRetry = 1;
                LivenessRecogActivity.this.resetViews();
                LivenessRecogActivity.this.processState.stateFlag = 1;
                LivenessRecogActivity.this.startLiveness();
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.headMode = livenessRecogActivity.getHeadMode();
                LivenessRecogActivity.this.animState.startBlinkAnimFlag = false;
                LivenessRecogActivity.this.animState.startMouthOpenAnimFlag = false;
                LivenessRecogActivity.this.processState.wholeProcessStartTime = System.currentTimeMillis();
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.pass_bio_cancel), new OnClickListener() {
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.userCancel();
                LivenessRecogActivity.this.cameraInterface.doStopCamera();
                LivenessRecogActivity.this.livenessStat.tipOverTimeCancel = 1;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.activityFinish(-204);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public void startLiveness() {
        this.processState.wholeProcessStartTime = System.currentTimeMillis();
        startPoseTipAnim(0);
        this.timerCount.start();
        this.livenessStat.timePointStartFindFace = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    @TargetApi(11)
    public void startPoseTipAnim(int i2) {
        updatePoseTip(i2);
        ProcessState processState2 = this.processState;
        int i3 = processState2.stateFlag;
        if (i3 == 0) {
            processState2.stateFlag = 1;
        } else if (i3 == 5) {
            processState2.stateFlag = 6;
        } else if (i3 == 7) {
            processState2.stateFlag = 8;
        }
        this.poseTipFl.setVisibility(0);
        this.poseTipTv.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void startPoseWarningAnim(int i2) {
        this.poseTipWarningFl.setVisibility(0);
        if (this.lastWaringType != i2) {
            if (i2 == 1) {
                this.livenessStat.tipDistanceFarNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_tofar_from_camera));
            } else if (i2 == 0) {
                this.livenessStat.tipDistanceNearNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_tonear_from_camera));
            } else if (i2 == 2) {
                this.livenessStat.tipLightLowNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_brightness_too_dark));
            } else if (i2 == 4) {
                this.livenessStat.tipEyeSlopeNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_face_to_screen));
            } else {
                this.livenessStat.tipPutFaceRoundNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_put_face_round));
            }
            final Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    LivenessRecogActivity.this.poseTipWarningIv.startAnimation(loadAnimation);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            if (!this.animState.startWarningFlag) {
                this.poseTipWarningIv.startAnimation(loadAnimation);
                this.animState.startWarningFlag = true;
            }
        }
        this.lastWaringType = i2;
    }

    /* access modifiers changed from: private */
    public void startRecognizingAnim() {
        ProcessState processState2 = this.processState;
        processState2.stateFlag = 3;
        if (this.guideLiveness) {
            processState2.stateFlag = 4;
        } else {
            processState2.stateFlag = 20;
        }
        this.faceStateIv.setImageBitmap(getScaleBitmap(R.drawable.pass_liveness_recog_face_successed));
        this.livenessStat.timePointFindFaceDone = System.currentTimeMillis();
        StringBuilder a2 = a.a("livenessStat.timePointFindFaceDone:");
        a2.append(this.livenessStat.timePointFindFaceDone);
        Log.w(TAG, a2.toString());
        LivenessStat livenessStat2 = this.livenessStat;
        livenessStat2.findFaceNum++;
        livenessStat2.findFaceLast = 1;
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
            view.setBackgroundResource(0);
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                if (i2 < viewGroup2.getChildCount()) {
                    unbindDrawables(viewGroup2.getChildAt(i2));
                    i2++;
                } else {
                    viewGroup2.removeAllViews();
                    view.setBackgroundResource(0);
                    return;
                }
            }
        }
    }

    private void updatePoseTip(int i2) {
        if (i2 == 0) {
            this.poseTipTv.setText(R.string.pass_liveness_put_face_round);
        } else if (i2 == 1) {
            String[] strArr = this.headPoses;
            if (strArr != null) {
                int i3 = this.headMode;
                if (i3 < strArr.length) {
                    this.poseTipTv.setText(strArr[i3]);
                }
            }
        } else if (i2 == 2) {
            String[] strArr2 = this.headPoses;
            if (strArr2 != null) {
                int i4 = this.headMode;
                if (i4 < strArr2.length) {
                    this.poseTipTv.setText(strArr2[i4]);
                }
            }
        } else if (i2 == 3) {
            String[] strArr3 = this.headPoses;
            if (strArr3 != null) {
                int i5 = this.headMode;
                if (i5 < strArr3.length) {
                    this.poseTipTv.setText(strArr3[i5]);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(11)
    public void updateWhiteBg(float f2) {
        if (!this.whiteBgFlag) {
            this.livenessStat.illumValue = f2;
            if (isUpdateWhiteBg(f2)) {
                this.whiteBgFlag = true;
                this.livenessStat.whiteBg = 1;
                this.sensorManager.unRegisterSensorListener();
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(200);
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.setIntValues(new int[]{1, 100});
                valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public IntEvaluator mEvaluator = new IntEvaluator();

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float intValue = ((float) ((Integer) valueAnimator.getAnimatedValue()).intValue()) / 100.0f;
                        IntEvaluator intEvaluator = this.mEvaluator;
                        Integer valueOf = Integer.valueOf(255);
                        int intValue2 = intEvaluator.evaluate(intValue, valueOf, Integer.valueOf(51)).intValue();
                        LivenessRecogActivity.this.poseTipTv.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                        int intValue3 = this.mEvaluator.evaluate(intValue, Integer.valueOf(0), valueOf).intValue();
                        int intValue4 = this.mEvaluator.evaluate(intValue, Integer.valueOf(66), valueOf).intValue();
                        if (LivenessRecogActivity.this.xfordView != null) {
                            LivenessRecogActivity.this.xfordView.setBgPaintColor(Color.argb(intValue4, intValue3, intValue3, intValue3));
                            LivenessRecogActivity.this.xfordView.postInvalidate();
                        }
                    }
                });
                valueAnimator.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void userCancel() {
        if (this.callback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
            passFaceRecogResult.setResultCode(-204);
            this.callback.onFailure(passFaceRecogResult);
        }
    }

    public boolean handleMessage(Message message) {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        setRequestedOrientation(1);
        super.onCreate(bundle);
        if (bundle != null) {
            this.hasCameraReadyStatistics = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        requestWindowFeature(1);
        getWindow().addFlags(67108864);
        getWindow().addFlags(128);
        ViewGroup viewGroup2 = (ViewGroup) View.inflate(this, R.layout.layout_pass_liveness_recognize, null);
        this.viewGroup = viewGroup2;
        setContentView(viewGroup2);
        this.livenessStat.timePointStart = getIntent().getLongExtra(EXTRA_TIME_POINT_START, System.currentTimeMillis());
        this.livenessStat.asyncGetPortraitType = 1;
        if (this.passFaceRecogDTO == null) {
            PassFaceRecogCallback passFaceRecogCallback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
            if (passFaceRecogCallback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-205);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
            activityFinish(-205);
            return;
        }
        init();
        if (!this.livenessConfig.closeSkipLiving) {
            this.guideLiveness = this.passFaceRecogDTO.guideLiveness;
        }
        setupViews();
        this.sensorManager.registerSensorListener(new SensorCallback() {
            public void onChange(float f2) {
                if (LivenessRecogActivity.this.firstillumCallback) {
                    LivenessRecogActivity.this.firstillumCallback = false;
                    if (LivenessRecogActivity.this.isUpdateWhiteBg(f2)) {
                        LivenessRecogActivity.this.firstLivenessRcogType = 2;
                        LivenessRecogActivity.this.headMode = 5;
                    }
                }
                LivenessRecogActivity.this.updateWhiteBg(f2);
            }
        });
        requestCameraPermission();
    }

    public void onDestroy() {
        super.onDestroy();
        BioSensorManager bioSensorManager = this.sensorManager;
        if (bioSensorManager != null) {
            bioSensorManager.unRegisterSensorListener();
        }
        this.isActivityFinished = true;
        this.argbData = null;
        this.cameraData = null;
        this.cameraDataCache.clear();
        this.cameraDataCache = null;
        try {
            clearBitmapCache();
            this.viewGroup.removeView(this.surfaceView);
            this.surfaceView = null;
            unbindDrawables(this.viewGroup);
            this.viewGroup.removeCallbacks(null);
            this.viewGroup = null;
            this.uiHandler.removeCallbacksAndMessages(null);
            System.gc();
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            userCancel();
            btnBackStat();
            this.cameraInterface.doStopCamera();
            setActivityResult(0);
            activityFinish(-204);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public void onPause() {
        super.onPause();
        this.lifeCyclePause = true;
        if (!this.processState.permissionFlag) {
            this.timerCount.cancel();
            this.cameraInterface.doStopCamera();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.processState.permissionFlag = false;
        if (i2 != 2002) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionDialog();
            return;
        }
        LivenessStat livenessStat2 = this.livenessStat;
        livenessStat2.withCameraPermission = 1;
        livenessStat2.openCameraPermissionSuc = 1;
        livenessStat2.timePointStartRecog = System.currentTimeMillis();
        startLiveness();
        if (openCamera()) {
            this.livenessStat.timePointCameraReady = System.currentTimeMillis();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.lifeCyclePause) {
            this.lifeCyclePause = false;
            ProcessState processState2 = this.processState;
            if (!processState2.permissionFlag) {
                int i2 = processState2.stateFlag;
                if (i2 < 10) {
                    startLiveness();
                    openCamera();
                } else if (i2 == 17) {
                    openCamera();
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.hasCameraReadyStatistics);
    }

    public void onStop() {
        super.onStop();
    }

    public void setActivityResult(int i2) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        setResult(i2, intent);
    }
}
