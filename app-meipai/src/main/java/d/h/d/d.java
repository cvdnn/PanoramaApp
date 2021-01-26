package d.h.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import d.h.k.c;
import d.h.k.c.a;
import d.h.k.m;
import d.p.e.b;
import d.p.h;
import d.p.i;
import d.p.p;

/* compiled from: ComponentActivity */
public class d extends Activity implements h, a {

    /* renamed from: a reason: collision with root package name */
    public i f4787a = new i(this);

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !m.b(decorView, keyEvent)) {
            return c.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !m.b(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.a((Activity) this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f4787a.a(b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
