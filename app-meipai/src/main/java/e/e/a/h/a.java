package e.e.a.h;

import android.util.Log;

/* compiled from: BleLog */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static boolean f8024a = true;

    public static void a(String str) {
        if (f8024a && str != null) {
            Log.e("FastBle", str);
        }
    }

    public static void b(String str) {
        if (f8024a && str != null) {
            Log.i("FastBle", str);
        }
    }

    public static void c(String str) {
        if (f8024a && str != null) {
            Log.w("FastBle", str);
        }
    }
}
