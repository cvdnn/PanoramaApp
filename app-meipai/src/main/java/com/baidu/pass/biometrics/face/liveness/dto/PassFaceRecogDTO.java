package com.baidu.pass.biometrics.face.liveness.dto;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PassFaceRecogDTO extends PassBiometricDto {
    public static final int IMAGE_FLAG_CUT_AND_ORIGIN_IMAGE = 3;
    public static final int IMAGE_FLAG_CUT_IMAGE = 1;
    public static final int IMAGE_FLAG_ORIGIN_IMAGE = 2;
    public static final int IMAGE_FLAG_WITHOUT_IMAGE = 0;
    public static final String KEY_EXTRA_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXTRA_PASS_PRODUCT_ID = "sp_no";
    public String authToken;
    public String bduss;
    public String exUid;
    public Map<String, String> extraParamsMap = new HashMap();
    public boolean guideLiveness = true;
    public String idCardNum;
    public String imageFlag = "0";
    public PassFaceRecogType livenessType = PassFaceRecogType.RECOG_TYPE_BDUSS;
    public String passProductId;
    public String phoneNum;
    public String processid;
    public String realName;
    public String serviceType;
    public String stoken;
    public String uid;

    private int returnImageFlag() {
        PassBiometricDto cacheData = BeanDataCache.getInstance().getCacheData(BeanDataCache.KEY);
        if (cacheData != null && (cacheData instanceof PassFaceRecogDTO)) {
            PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) cacheData;
            if (!TextUtils.isEmpty(passFaceRecogDTO.imageFlag)) {
                try {
                    return Integer.parseInt(passFaceRecogDTO.imageFlag);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return 0;
    }

    public String getAccessToken() {
        return (String) this.extraParamsMap.get("access_token");
    }

    public String getSpParams() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : this.extraParamsMap.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                String str = "=";
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append((String) entry.getKey());
                    sb.append(str);
                    sb.append((String) entry.getValue());
                } else {
                    sb.append("&");
                    sb.append((String) entry.getKey());
                    sb.append(str);
                    sb.append((String) entry.getValue());
                }
            }
        }
        return sb.toString();
    }

    public String getSpno() {
        return (String) this.extraParamsMap.get(KEY_EXTRA_PASS_PRODUCT_ID);
    }

    public boolean isReturnCutImage() {
        return (returnImageFlag() & 1) == 1;
    }

    public boolean isReturnOriginImage() {
        return (returnImageFlag() & 2) == 2;
    }
}
