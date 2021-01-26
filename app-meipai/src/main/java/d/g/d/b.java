package d.g.d;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtils */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final ThreadLocal<Matrix> f4767a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    public static final ThreadLocal<RectF> f4768b = new ThreadLocal<>();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = (Matrix) f4767a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f4767a.set(matrix);
        } else {
            matrix.reset();
        }
        a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f4768b.get();
        if (rectF == null) {
            rectF = new RectF();
            f4768b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
