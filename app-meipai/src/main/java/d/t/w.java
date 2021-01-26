package d.t;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19 */
public class w extends b0 {

    /* renamed from: c reason: collision with root package name */
    public static boolean f5522c = true;

    public void a(View view) {
    }

    @SuppressLint({"NewApi"})
    public void a(View view, float f2) {
        if (f5522c) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f5522c = false;
            }
        }
        view.setAlpha(f2);
    }

    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (f5522c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f5522c = false;
            }
        }
        return view.getAlpha();
    }

    public void c(View view) {
    }
}
