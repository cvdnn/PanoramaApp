package com.arashivision.onestream;

import android.annotation.SuppressLint;
import android.content.Context;

public class AppContextStab {
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;

    public static Context getContext() {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("context not set for AppContextStab");
    }

    public static void setContext(Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
        }
    }
}
