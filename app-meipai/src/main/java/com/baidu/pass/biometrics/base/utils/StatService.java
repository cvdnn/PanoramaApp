package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class StatService {
    public static final String DOMAIN_NSCLICK_URL = "https://nsclick.baidu.com/v.gif";
    public static final String TAG = "StatService";
    public static final Map<String, String> commonParams;

    static {
        HashMap hashMap = new HashMap();
        commonParams = hashMap;
        hashMap.put("pid", "111");
        commonParams.put("type", "1023");
        commonParams.put(Config.DEVICE_PART, SapiDeviceInfo.f3010c);
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        String str2 = "v";
        if (!TextUtils.isEmpty(str)) {
            try {
                if (NetworkUtils.isNetworkAvailable(context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(commonParams);
                    map.put(str2, String.valueOf(System.currentTimeMillis()));
                    hashMap.put("name", str);
                    hashMap.put("model", Build.MODEL);
                    hashMap.put("tpl", BeanConstants.tpl);
                    hashMap.put("clientfrom", "mobilesdk_enhanced");
                    hashMap.put("app_version", PassBioBaseUtil.getVersionName(context));
                    hashMap.put(SapiContext.KEY_SDK_VERSION, PassBiometricDefaultFactory.VERSION_NAME);
                    hashMap.put("cuid", PassBioBaseUtil.getClientId(context));
                    hashMap.put(str2, String.valueOf(System.currentTimeMillis()));
                    for (Entry entry : map.entrySet()) {
                        if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                            hashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
                    passHttpParamDTO.url = DOMAIN_NSCLICK_URL;
                    passHttpParamDTO.paramsMap.putAll(hashMap);
                    new PassHttpClient().get(context.getApplicationContext(), passHttpParamDTO, new HttpResponseHandler(Looper.getMainLooper()) {
                        public void onFailure(Throwable th, String str) {
                        }

                        public void onSuccess(int i2, String str) {
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }
}
