package e.l.a.k.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import e.l.a.m.c;

/* compiled from: MSettingPage */
public class b {

    /* renamed from: b reason: collision with root package name */
    public static final String f8958b = Build.MANUFACTURER.toLowerCase();

    /* renamed from: a reason: collision with root package name */
    public c f8959a;

    public b(c cVar) {
        this.f8959a = cVar;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        if (a(context, intent)) {
            return intent;
        }
        return a(context);
    }

    public static boolean a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
