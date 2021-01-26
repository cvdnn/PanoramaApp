package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback;

public class AutoTrack {
    public static final int JOB_TYPE_BGSEND = 2;
    public static final int JOB_TYPE_SESSIONTIME = 1;

    public static class MyActivityLifeCallback implements IActivityLifeCallback {

        /* renamed from: a reason: collision with root package name */
        public int f1244a;

        public MyActivityLifeCallback(int i2) {
            this.f1244a = i2;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            Context applicationContext = activity.getApplicationContext();
            int i2 = this.f1244a;
            if (i2 == 1) {
                BDStatCore.instance().autoTrackSessionEndTime(applicationContext);
            } else if (i2 == 2) {
                BDStatCore.instance().doSendLogCheck(applicationContext);
            }
        }

        public void onActivityResumed(Activity activity) {
            Context applicationContext = activity.getApplicationContext();
            int i2 = this.f1244a;
            if (i2 == 1) {
                BDStatCore.instance().autoTrackSessionStartTime(applicationContext);
            } else if (i2 == 2) {
                BDStatCore.instance().cancelSendLogCheck();
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }
}
