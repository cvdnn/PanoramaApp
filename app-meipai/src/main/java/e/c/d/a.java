package e.c.d;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.baidu.picapture.App;
import com.baidu.picapture.model.device.LanguageUtils;

/* compiled from: App */
public class a implements ActivityLifecycleCallbacks {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ App f5943a;

    public a(App app) {
        this.f5943a = app;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (LanguageUtils.isIsSystemLanguageChange()) {
            App.a(this.f5943a);
        }
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
    }

    public void onActivityStopped(Activity activity) {
    }
}
