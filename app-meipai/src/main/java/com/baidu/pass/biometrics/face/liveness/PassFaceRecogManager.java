package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricOperation;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.base.dynamicupdate.SoManager;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation.OperationType;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;

public class PassFaceRecogManager implements PassBiometric {
    public static final long MAX_CALL_INTERNAL_TIME = 300;
    public static PassFaceRecogManager instance;
    public PassBiometricConfiguration configuration;
    public long lastCallTime;
    public PassFaceRecogCallback passFaceRecogCallback;

    public static synchronized PassFaceRecogManager getInstance() {
        PassFaceRecogManager passFaceRecogManager;
        synchronized (PassFaceRecogManager.class) {
            if (instance == null) {
                instance = new PassFaceRecogManager();
            }
            passFaceRecogManager = instance;
        }
        return passFaceRecogManager;
    }

    private void initData() {
        this.lastCallTime = System.currentTimeMillis();
    }

    private boolean meetFrequencyControl() {
        return System.currentTimeMillis() - this.lastCallTime < 300;
    }

    private void preInitLinessRecogDTO(PassFaceRecogDTO passFaceRecogDTO) {
        boolean isEmpty = TextUtils.isEmpty(passFaceRecogDTO.passProductId);
        String str = PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID;
        if (!isEmpty || (!passFaceRecogDTO.extraParamsMap.isEmpty() && !TextUtils.isEmpty((CharSequence) passFaceRecogDTO.extraParamsMap.get(str)))) {
            if (TextUtils.isEmpty(passFaceRecogDTO.serviceType)) {
                passFaceRecogDTO.serviceType = "1008";
            }
            if (TextUtils.isEmpty((CharSequence) passFaceRecogDTO.extraParamsMap.get(str))) {
                passFaceRecogDTO.extraParamsMap.put(str, passFaceRecogDTO.passProductId);
            }
            passFaceRecogDTO.processid = PassBiometricUtil.getUUID();
            BeanDataCache.getInstance().addToCache(BeanDataCache.KEY, passFaceRecogDTO);
            return;
        }
        throw new IllegalArgumentException("PassFaceRecogDTO.passProductId can't be empty");
    }

    private void startLivenessRecogize(PassFaceRecogCallback passFaceRecogCallback2, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        if (passFaceRecogDTO == null) {
            passFaceRecogResult.setResultCode(-205);
            if (passFaceRecogCallback2 != null) {
                passFaceRecogCallback2.onFailure(passFaceRecogResult);
            }
            return;
        }
        PassFaceRecogType passFaceRecogType = passFaceRecogDTO.livenessType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(passFaceRecogDTO.bduss) || TextUtils.isEmpty(passFaceRecogDTO.stoken)) {
                passFaceRecogResult.setResultCode(101);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NO_LOGIN);
                if (passFaceRecogCallback2 != null) {
                    passFaceRecogCallback2.onFailure(passFaceRecogResult);
                }
                return;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(passFaceRecogDTO.authToken)) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback2 != null) {
                    passFaceRecogCallback2.onFailure(passFaceRecogResult);
                }
                return;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(passFaceRecogDTO.realName) || TextUtils.isEmpty(passFaceRecogDTO.idCardNum)) && TextUtils.isEmpty(passFaceRecogDTO.getAccessToken())) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback2 != null) {
                    passFaceRecogCallback2.onFailure(passFaceRecogResult);
                }
                return;
            } else if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogDTO.exUid = "1";
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback2 != null) {
                    passFaceRecogCallback2.onFailure(passFaceRecogResult);
                }
                return;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
            passFaceRecogResult.setResultCode(-205);
            if (passFaceRecogCallback2 != null) {
                passFaceRecogCallback2.onFailure(passFaceRecogResult);
            }
            return;
        }
        this.passFaceRecogCallback = passFaceRecogCallback2;
        Intent intent = new Intent(context, LivenessRecogActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void cleanPassFaceRecogCallback() {
        this.passFaceRecogCallback = null;
    }

    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        if (passBiometricConfiguration == null) {
            throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
        } else if (TextUtils.isEmpty(passBiometricConfiguration.tpl) || TextUtils.isEmpty(passBiometricConfiguration.appId) || TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        } else {
            this.configuration = passBiometricConfiguration;
            ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
            BeanConstants.tpl = passBiometricConfiguration.tpl;
            BeanConstants.appid = passBiometricConfiguration.appId;
            BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
            SoManager.checkVersion(getInstance().getConfiguration());
        }
    }

    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
        String str = " can't be null";
        if (passBiometricCallback == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PassBiometricCallback.class.getSimpleName());
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (passBiometricOperation == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PassBiometricOperation.class.getSimpleName());
            sb2.append(str);
            throw new IllegalArgumentException(sb2.toString());
        } else if (passBiometricDto == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(PassBiometricDto.class.getSimpleName());
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        } else if (((PassFaceOperation) passBiometricOperation).operationType == OperationType.RECOGNIZE && !meetFrequencyControl()) {
            initData();
            PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) passBiometricDto;
            PassFaceRecogCallback passFaceRecogCallback2 = (PassFaceRecogCallback) passBiometricCallback;
            preInitLinessRecogDTO(passFaceRecogDTO);
            startLivenessRecogize(passFaceRecogCallback2, passFaceRecogDTO, context);
        }
    }

    public PassBiometricConfiguration getConfiguration() {
        return this.configuration;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        return this.passFaceRecogCallback;
    }
}
