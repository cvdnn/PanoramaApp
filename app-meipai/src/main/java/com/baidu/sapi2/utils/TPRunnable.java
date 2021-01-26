package com.baidu.sapi2.utils;

import android.os.Looper;
import com.baidu.sapi2.NoProguard;

public class TPRunnable implements Runnable, NoProguard {
    public Runnable runable;

    public TPRunnable(Runnable runnable) {
        this.runable = runnable;
    }

    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.runable.run();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
