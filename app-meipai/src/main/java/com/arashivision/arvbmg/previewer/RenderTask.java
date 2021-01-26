package com.arashivision.arvbmg.previewer;

import android.util.Log;

public abstract class RenderTask implements Runnable {
    public static final String TAG = "RenderTask";

    public abstract void doTask();

    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }
}
