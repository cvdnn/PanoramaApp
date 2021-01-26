package d.t;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi22 */
public class y extends x {

    /* renamed from: f reason: collision with root package name */
    public static boolean f5525f = true;

    @SuppressLint({"NewApi"})
    public void a(View view, int i2, int i3, int i4, int i5) {
        if (f5525f) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f5525f = false;
            }
        }
    }
}
