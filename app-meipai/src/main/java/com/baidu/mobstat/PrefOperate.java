package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;

public class PrefOperate {
    public static String getAppKey(Context context) {
        return CooperService.instance().getAppKey(context);
    }

    public static void loadMetaDataConfig(Context context) {
        String str = "true";
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        try {
            String a2 = bw.a(context, Config.EXCEPTION_LOG_META_NAME);
            if (!TextUtils.isEmpty(a2) && str.equals(a2)) {
                ExceptionAnalysis.getInstance().openExceptionAnalysis(context, false);
            }
        } catch (Exception unused) {
        }
        try {
            String a3 = bw.a(context, Config.SEND_STRATEGY_META_NAME);
            if (!TextUtils.isEmpty(a3)) {
                SendStrategyEnum sendStrategyEnum2 = SendStrategyEnum.APP_START;
                if (a3.equals("APP_START")) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    bq.a().a(context, 0);
                } else {
                    SendStrategyEnum sendStrategyEnum3 = SendStrategyEnum.ONCE_A_DAY;
                    if (a3.equals("ONCE_A_DAY")) {
                        sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                        bq.a().a(context, 1);
                        bq.a().b(context, 24);
                    } else {
                        SendStrategyEnum sendStrategyEnum4 = SendStrategyEnum.SET_TIME_INTERVAL;
                        if (a3.equals("SET_TIME_INTERVAL")) {
                            sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                            bq.a().a(context, 2);
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            String a4 = bw.a(context, Config.TIME_INTERVAL_META_NAME);
            if (!TextUtils.isEmpty(a4)) {
                int parseInt = Integer.parseInt(a4);
                int ordinal = sendStrategyEnum.ordinal();
                SendStrategyEnum sendStrategyEnum5 = SendStrategyEnum.SET_TIME_INTERVAL;
                if (ordinal == 2 && parseInt > 0 && parseInt <= 24) {
                    bq.a().b(context, parseInt);
                }
            }
        } catch (Exception unused3) {
        }
        try {
            String a5 = bw.a(context, Config.ONLY_WIFI_META_NAME);
            if (TextUtils.isEmpty(a5)) {
                return;
            }
            if (str.equals(a5)) {
                bq.a().a(context, true);
            } else if ("false".equals(a5)) {
                bq.a().a(context, false);
            }
        } catch (Exception unused4) {
        }
    }

    public static void setAppChannel(String str) {
        if (str == null || str.equals("")) {
            bc.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
    }

    public static void setAppKey(String str) {
        CooperService.instance().getHeadObject().f1420e = str;
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        String str2 = "";
        if (str == null || str.equals(str2)) {
            bc.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
        if (z && str != null && !str.equals(str2)) {
            bq.a().d(context, str);
            bq.a().b(context, true);
        }
        if (!z) {
            bq.a().d(context, str2);
            bq.a().b(context, false);
        }
    }
}
