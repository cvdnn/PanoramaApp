package com.baidu.sapi2.httpwrap;

import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("client", SapiDeviceInfo.f3010c);
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        if (isAccountManager != null) {
            SapiConfiguration confignation = isAccountManager.getConfignation();
            if (confignation != null) {
                hashMap.put("cuid", confignation.clientId);
                hashMap.put("clientid", confignation.clientId);
                hashMap.put(Config.ZID, isAccountManager.getCurrentZid(confignation.context));
                hashMap.put("clientip", confignation.clientIp);
                hashMap.put("appid", confignation.appId);
                hashMap.put("tpl", confignation.tpl);
                hashMap.put("app_version", SapiUtils.getVersionName(confignation.context));
                hashMap.put(SapiContext.KEY_SDK_VERSION, isAccountManager.getVersionName());
                hashMap.put("sdkversion", isAccountManager.getVersionName());
            }
        }
        return hashMap;
    }
}
