package d.t;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21 */
public class x extends w {

    /* renamed from: d reason: collision with root package name */
    public static boolean f5523d = true;

    /* renamed from: e reason: collision with root package name */
    public static boolean f5524e = true;

    @SuppressLint({"NewApi"})
    public void a(View view, Matrix matrix) {
        if (f5523d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f5523d = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(View view, Matrix matrix) {
        if (f5524e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f5524e = false;
            }
        }
    }
}
