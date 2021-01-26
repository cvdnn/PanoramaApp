package com.arashivision.insta360.basecamera.log;

import android.util.Log;
import e.a.a.a.a;

public class CameraLogger {
    public boolean mEnabled;
    public String mName;

    public CameraLogger(String str, boolean z) {
        this.mName = str;
        this.mEnabled = z;
    }

    public static CameraLogger getLogger(Class cls) {
        StringBuilder a2 = a.a("Logger: ");
        a2.append(cls.getSimpleName());
        return new CameraLogger(a2.toString(), true);
    }

    public static CameraLogger getLogger(Class cls, boolean z) {
        StringBuilder a2 = a.a("Logger: ");
        a2.append(cls.getSimpleName());
        return new CameraLogger(a2.toString(), z);
    }

    public static CameraLogger getLogger(String str) {
        return new CameraLogger(a.a("Logger: ", str), true);
    }

    public static CameraLogger getLogger(String str, boolean z) {
        return new CameraLogger(a.a("Logger: ", str), z);
    }

    public void d(String str) {
        if (this.mEnabled) {
            Log.d(this.mName, str);
        }
    }

    public void e(String str) {
        if (this.mEnabled) {
            Log.e(this.mName, str);
        }
    }

    public void i(String str) {
        if (this.mEnabled) {
            Log.i(this.mName, str);
        }
    }

    public void v(String str) {
        if (this.mEnabled) {
            Log.v(this.mName, str);
        }
    }

    public void w(String str) {
        if (this.mEnabled) {
            Log.w(this.mName, str);
        }
    }
}
