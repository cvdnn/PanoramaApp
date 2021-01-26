package e.l.a.m;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.lang.reflect.Method;

/* compiled from: ContextSource */
public class b extends c {

    /* renamed from: a reason: collision with root package name */
    public Context f8973a;

    public b(Context context) {
        this.f8973a = context;
    }

    public Context a() {
        return this.f8973a;
    }

    public void a(Intent intent) {
        intent.addFlags(268435456);
        this.f8973a.startActivity(intent);
    }

    public void a(Intent intent, int i2) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    public boolean a(String str) {
        PackageManager packageManager = this.f8973a.getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class});
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, new Object[]{str})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
