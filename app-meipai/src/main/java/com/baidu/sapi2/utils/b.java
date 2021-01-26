package com.baidu.sapi2.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PtokenStat */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final String f3024a = "login_";

    /* renamed from: b reason: collision with root package name */
    public static final String f3025b = "login_pop";

    /* renamed from: c reason: collision with root package name */
    public static final String f3026c = "modifyPWD_widge";

    /* renamed from: d reason: collision with root package name */
    public static final String f3027d = "normal_incomplete";

    /* renamed from: e reason: collision with root package name */
    public static final String f3028e = "normal_guest";

    /* renamed from: f reason: collision with root package name */
    public static final String f3029f = "fillname_widge";

    /* renamed from: g reason: collision with root package name */
    public static final String f3030g = "web2native";

    /* renamed from: h reason: collision with root package name */
    public static final String f3031h = "native2web";

    /* renamed from: i reason: collision with root package name */
    public static final String f3032i = "sapi_action_bduss_changed";

    public void a(String str) {
        String str2;
        if (TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            HashMap hashMap = new HashMap();
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put("sys_version", VERSION.RELEASE);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                str2 = "uid_is_empty";
            } else {
                str2 = currentAccount.uid;
            }
            hashMap.put("uid", str2);
            hashMap.put("scenes", str);
            t.a("ptoken_is_null", (Map<String, String>) hashMap);
        }
    }
}
