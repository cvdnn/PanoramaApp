package d.t;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ViewUtilsApi23 */
public class z extends y {

    /* renamed from: g reason: collision with root package name */
    public static boolean f5526g = true;

    @SuppressLint({"NewApi"})
    public void a(View view, int i2) {
        if (VERSION.SDK_INT == 28) {
            super.a(view, i2);
        } else if (f5526g) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f5526g = false;
            }
        }
    }
}
