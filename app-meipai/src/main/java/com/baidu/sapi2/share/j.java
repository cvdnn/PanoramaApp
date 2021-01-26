package com.baidu.sapi2.share;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: SapiShareClient */
public class j implements ActivityLifecycleCallbacks {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiShareClient f2936a;

    public j(SapiShareClient sapiShareClient) {
        this.f2936a = sapiShareClient;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.f2936a.l == 0) {
            if (this.f2936a.m) {
                this.f2936a.m = false;
            } else {
                new m().a(true);
            }
        }
        this.f2936a.l = this.f2936a.l + 1;
    }

    public void onActivityStopped(Activity activity) {
        this.f2936a.l = this.f2936a.l - 1;
    }
}
