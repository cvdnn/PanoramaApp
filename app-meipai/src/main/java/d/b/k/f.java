package d.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import d.e.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: AppCompatDelegate */
public abstract class f {

    /* renamed from: a reason: collision with root package name */
    public static final c<WeakReference<f>> f3991a = new c<>();

    /* renamed from: b reason: collision with root package name */
    public static final Object f3992b = new Object();

    public static f a(Activity activity, e eVar) {
        return new g(activity, null, eVar, activity);
    }

    public static void b(f fVar) {
        synchronized (f3992b) {
            c(fVar);
        }
    }

    public static void c(f fVar) {
        synchronized (f3992b) {
            Iterator it = f3991a.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) ((WeakReference) it.next()).get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void a();

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i2);

    public abstract void b();

    public abstract void b(int i2);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract void c();

    public static f a(Dialog dialog, e eVar) {
        return new g(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    public static void a(f fVar) {
        synchronized (f3992b) {
            c(fVar);
            f3991a.add(new WeakReference(fVar));
        }
    }
}
