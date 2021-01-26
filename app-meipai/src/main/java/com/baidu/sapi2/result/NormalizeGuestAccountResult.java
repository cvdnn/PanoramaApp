package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;

public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";

    /* renamed from: a reason: collision with root package name */
    public HashMap<String, Integer> f2852a;
    public Activity activity;

    /* renamed from: b reason: collision with root package name */
    public String f2853b;
    public boolean isAccountMerge;

    public NormalizeGuestAccountResult() {
        HashMap<String, Integer> hashMap = new HashMap<>(3);
        this.f2852a = hashMap;
        hashMap.put("sms_upgrade", Integer.valueOf(1));
        this.f2852a.put("sms_upgrade_exist", Integer.valueOf(2));
        this.f2852a.put("pwd_upgrade", Integer.valueOf(3));
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.f2852a.containsKey(this.f2853b)) {
            return ((Integer) this.f2852a.get(this.f2853b)).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.f2853b = str;
    }
}
