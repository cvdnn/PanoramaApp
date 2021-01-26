package d.t;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29 */
public class a0 extends z {
    public void a(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    public float b(View view) {
        return view.getTransitionAlpha();
    }

    public void a(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    public void b(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    public void a(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }
}
