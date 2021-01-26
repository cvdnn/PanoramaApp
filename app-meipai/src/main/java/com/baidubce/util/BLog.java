package com.baidubce.util;

import android.util.Log;

public class BLog {
    public static String LOG_TAG = "BOS";
    public static boolean enableLog;

    public static void debug(String str) {
        if (enableLog) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static void error(String str) {
        if (enableLog) {
            Log.e(LOG_TAG, String.valueOf(str));
        }
    }

    public static void info(String str) {
        if (enableLog) {
            Log.i(LOG_TAG, str);
        }
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    public static void warn(String str) {
        if (enableLog) {
            Log.w(LOG_TAG, String.valueOf(str));
        }
    }

    public static void debug(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            Log.d(str2, sb.toString());
        }
    }

    public static void error(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            Log.e(str2, sb.toString());
        }
    }

    public static void info(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            Log.i(str2, sb.toString());
        }
    }

    public static void warn(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            Log.w(str2, sb.toString());
        }
    }

    public static void debug(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            sb.append(obj2);
            Log.d(str2, sb.toString());
        }
    }

    public static void error(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            sb.append(obj2);
            Log.e(str2, sb.toString());
        }
    }

    public static void info(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            sb.append(obj2);
            Log.i(str2, sb.toString());
        }
    }

    public static void warn(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            sb.append(obj2);
            Log.w(str2, sb.toString());
        }
    }

    public static void debug(String str, Throwable th) {
        if (enableLog) {
            Log.d(LOG_TAG, str, th);
        }
    }

    public static void error(String str, Throwable th) {
        if (enableLog) {
            Log.e(LOG_TAG, str, th);
        }
    }

    public static void info(String str, Throwable th) {
        if (enableLog) {
            Log.i(LOG_TAG, str, th);
        }
    }

    public static void warn(String str, Throwable th) {
        if (enableLog) {
            Log.w(LOG_TAG, str, th);
        }
    }

    public static void debug(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.d(str3, sb.toString(), th);
        }
    }

    public static void error(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.e(str3, sb.toString(), th);
        }
    }

    public static void info(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.i(str3, sb.toString(), th);
        }
    }

    public static void warn(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.w(str3, sb.toString(), th);
        }
    }
}
