package e.l.a.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* compiled from: ActivitySource */
public class a extends c {

    /* renamed from: a reason: collision with root package name */
    public Activity f8972a;

    public a(Activity activity) {
        this.f8972a = activity;
    }

    public Context a() {
        return this.f8972a;
    }

    public void a(Intent intent) {
        this.f8972a.startActivity(intent);
    }

    public void a(Intent intent, int i2) {
        this.f8972a.startActivityForResult(intent, i2);
    }

    public boolean a(String str) {
        return this.f8972a.shouldShowRequestPermissionRationale(str);
    }
}
