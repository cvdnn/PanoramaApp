package e.g.a.a.y;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* compiled from: FloatingActionButtonImpl */
public class f implements TypeEvaluator<Float> {

    /* renamed from: a reason: collision with root package name */
    public FloatEvaluator f8430a = new FloatEvaluator();

    public f(e eVar) {
    }

    public Object evaluate(float f2, Object obj, Object obj2) {
        float floatValue = this.f8430a.evaluate(f2, (Float) obj, (Float) obj2).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
