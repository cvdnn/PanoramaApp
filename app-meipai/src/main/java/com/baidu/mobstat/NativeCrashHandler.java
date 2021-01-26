package com.baidu.mobstat;

import android.content.Context;
import java.io.File;

public final class NativeCrashHandler {

    /* renamed from: a reason: collision with root package name */
    public static boolean f1456a = true;

    /* renamed from: b reason: collision with root package name */
    public static Context f1457b;

    static {
        try {
            System.loadLibrary("crash_analysis");
        } catch (Throwable unused) {
        }
    }

    public static void doNativeCrash() {
        if (f1456a) {
            try {
                nativeException();
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context) {
        if (context != null) {
            f1457b = context;
            if (f1456a) {
                File cacheDir = context.getCacheDir();
                if (cacheDir.exists() && cacheDir.isDirectory()) {
                    try {
                        nativeInit(cacheDir.getAbsolutePath());
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static native void nativeException();

    public static native void nativeInit(String str);

    public static native void nativeProcess(String str);

    public static native void nativeUnint();

    public static void onCrashCallbackFromNative(String str) {
        ExceptionAnalysis.getInstance().saveCrashInfo(f1457b, System.currentTimeMillis(), str, "NativeException", 1, 0);
    }

    public static void process(String str) {
        if (str != null && str.length() != 0 && f1456a) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    nativeProcess(str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void uninit() {
        if (f1456a) {
            try {
                nativeUnint();
            } catch (Throwable unused) {
            }
        }
    }
}
