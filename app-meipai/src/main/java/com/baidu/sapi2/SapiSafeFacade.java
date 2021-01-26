package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.d;

public final class SapiSafeFacade {
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;

    /* renamed from: a reason: collision with root package name */
    public static SapiSafeFacade f2385a;

    public static synchronized SapiSafeFacade a() {
        SapiSafeFacade sapiSafeFacade;
        synchronized (SapiSafeFacade.class) {
            if (f2385a == null) {
                f2385a = new SapiSafeFacade();
            }
            sapiSafeFacade = f2385a;
        }
        return sapiSafeFacade;
    }

    public String getCurrentZid(Context context) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String zidAndCheckSafe = getZidAndCheckSafe(context, currentAccount != null ? currentAccount.uid : null, 1);
        return TextUtils.isEmpty(zidAndCheckSafe) ? "NoZidYet" : zidAndCheckSafe;
    }

    public String getDeviceAuthToken(Context context, String str, int i2) {
        return d.a().a(context, SapiAccountManager.getInstance().getSapiConfiguration().tpl, str, i2);
    }

    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return d.a().a(context, str, i2);
    }
}
