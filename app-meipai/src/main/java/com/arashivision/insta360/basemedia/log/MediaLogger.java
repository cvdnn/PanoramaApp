package com.arashivision.insta360.basemedia.log;

import android.util.Log;
import e.a.a.a.a;

public class MediaLogger {
    public boolean mEnabled;
    public String mName;

    public MediaLogger(String str, boolean z) {
        this.mName = str;
        this.mEnabled = z;
    }

    public static MediaLogger getLogger(Class cls) {
        StringBuilder a2 = a.a("Logger: ");
        a2.append(cls.getSimpleName());
        return new MediaLogger(a2.toString(), true);
    }

    public static MediaLogger getLogger(Class cls, boolean z) {
        StringBuilder a2 = a.a("Logger: ");
        a2.append(cls.getSimpleName());
        return new MediaLogger(a2.toString(), z);
    }

    public static MediaLogger getLogger(String str) {
        return new MediaLogger(a.a("Logger: ", str), true);
    }

    public static MediaLogger getLogger(String str, boolean z) {
        return new MediaLogger(a.a("Logger: ", str), z);
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
