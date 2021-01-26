package d.h.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import java.io.File;

/* compiled from: ContextCompat */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final Object f4788a = new Object();

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static File[] b(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] a(Context context) {
        return context.getExternalCacheDirs();
    }

    public static Drawable b(Context context, int i2) {
        return context.getDrawable(i2);
    }

    public static int a(Context context, int i2) {
        return context.getColor(i2);
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
