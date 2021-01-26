package d.t;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: RectEvaluator */
public class g implements TypeEvaluator<Rect> {
    public Object evaluate(float f2, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        int i2 = rect.left;
        int i3 = i2 + ((int) (((float) (rect2.left - i2)) * f2));
        int i4 = rect.top;
        int i5 = i4 + ((int) (((float) (rect2.top - i4)) * f2));
        int i6 = rect.right;
        int i7 = i6 + ((int) (((float) (rect2.right - i6)) * f2));
        int i8 = rect.bottom;
        return new Rect(i3, i5, i7, i8 + ((int) (((float) (rect2.bottom - i8)) * f2)));
    }
}
