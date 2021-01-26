package d.h.d;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Build.VERSION;
import android.os.Bundle;

/* compiled from: ActivityCompat */
public class a extends d.h.e.a {

    /* renamed from: d.h.d.a$a reason: collision with other inner class name */
    /* compiled from: ActivityCompat */
    public interface C0034a {
    }

    /* compiled from: ActivityCompat */
    public interface b {
        void b(int i2);
    }

    public static C0034a a() {
        return null;
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        activity.startActivityForResult(intent, i2, bundle);
    }

    public static void b(Activity activity) {
        if (VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (!b.a(activity)) {
            activity.recreate();
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void a(Activity activity, String[] strArr, int i2) {
        if (activity instanceof b) {
            ((b) activity).b(i2);
        }
        activity.requestPermissions(strArr, i2);
    }

    public static boolean a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
