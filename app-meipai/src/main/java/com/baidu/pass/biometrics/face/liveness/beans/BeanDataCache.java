package com.baidu.pass.biometrics.face.liveness.beans;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;

public class BeanDataCache {
    public static BeanDataCache INSTANCE = null;
    public static final String KEY = "request_data";
    public HashMap<String, PassBiometricDto> mRequestList = new HashMap<>();

    public static BeanDataCache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BeanDataCache();
        }
        return INSTANCE;
    }

    public void addToCache(String str, PassBiometricDto passBiometricDto) {
        if (this.mRequestList == null) {
            this.mRequestList = new HashMap<>();
        }
        this.mRequestList.put(str, passBiometricDto);
    }

    public PassBiometricDto getCacheData(String str) {
        HashMap<String, PassBiometricDto> hashMap = this.mRequestList;
        if (hashMap != null) {
            return (PassBiometricDto) hashMap.get(str);
        }
        return null;
    }

    public void removeCache() {
        HashMap<String, PassBiometricDto> hashMap = this.mRequestList;
        if (hashMap != null) {
            hashMap.clear();
            this.mRequestList = null;
        }
    }
}
