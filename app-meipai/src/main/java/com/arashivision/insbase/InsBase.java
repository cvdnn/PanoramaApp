package com.arashivision.insbase;

import android.content.Context;
import com.arashivision.insbase.arlog.Log;
import com.arashivision.insbase.sys.SysInfo;

public class InsBase {
    public static boolean sInited;

    public static synchronized void init(Context context) {
        synchronized (InsBase.class) {
            if (context == null) {
                throw new NullPointerException();
            } else if (!sInited) {
                SysInfo.init(context.getApplicationContext());
                NativeLibsLoader.load();
                sInited = true;
            }
        }
    }

    public static void initLog(boolean z, boolean z2, String str, boolean z3, boolean z4) {
        Log.configure(z, z2, str, z3, z4);
    }
}
