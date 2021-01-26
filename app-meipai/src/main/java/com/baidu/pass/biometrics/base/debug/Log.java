package com.baidu.pass.biometrics.base.debug;

import e.a.a.a.a;

public final class Log {
    public static final String TAG = "SAPI_BIOMETRIC";
    public static boolean enabled = false;

    public static String converArrayToString(String str, Object[] objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = objArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Throwable th = objArr[i2];
                        if (th != null) {
                            if (i2 != 0) {
                                stringBuffer.append("|");
                            }
                            try {
                                if (th instanceof Throwable) {
                                    stringBuffer.append(android.util.Log.getStackTraceString(th));
                                } else {
                                    stringBuffer.append(th.toString());
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    return stringBuffer.toString();
                }
            } catch (Throwable th2) {
                StringBuilder a2 = a.a("converArrayToString t: ");
                a2.append(th2.toString());
                android.util.Log.e(str, a2.toString());
                return "converArrayToString null";
            }
        }
        return "";
    }

    public static void d(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.d(str, converArrayToString(str, objArr));
        }
    }

    public static void e(Throwable th) {
        e(TAG, th);
    }

    public static void enable(boolean z) {
        enabled = z;
    }

    public static void i(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.i(str, converArrayToString(str, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.w(str, converArrayToString(str, objArr));
        }
    }

    public static void e(String str, Throwable th) {
        e(str, th);
    }

    public static void d(Object... objArr) {
        d(TAG, objArr);
    }

    public static void e(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.e(str, converArrayToString(str, objArr));
        }
    }

    public static void i(Object... objArr) {
        i(TAG, objArr);
    }

    public static void w(Object... objArr) {
        w(TAG, objArr);
    }
}
