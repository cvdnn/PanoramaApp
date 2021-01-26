package e.c.b.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class h {

    /* renamed from: a reason: collision with root package name */
    public static SharedPreferences f5906a;

    /* renamed from: b reason: collision with root package name */
    public static Editor f5907b;

    public static void a(Context context) {
        if (f5906a == null) {
            f5906a = context.getSharedPreferences("crab_app_life", 0);
        }
        if (f5907b == null) {
            f5907b = f5906a.edit();
        }
    }
}
