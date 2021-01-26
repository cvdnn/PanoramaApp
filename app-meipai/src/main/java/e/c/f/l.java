package e.c.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: SofirePreferences */
public final class l {

    /* renamed from: a reason: collision with root package name */
    public SharedPreferences f7028a;

    /* renamed from: b reason: collision with root package name */
    public Editor f7029b;

    public l(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
            this.f7028a = sharedPreferences;
            this.f7029b = sharedPreferences.edit();
        } catch (Throwable unused) {
            c.d();
        }
    }

    public final int a() {
        return this.f7028a.getInt("td_a_c", 0);
    }
}
