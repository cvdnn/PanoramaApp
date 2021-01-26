package e.g.a.a.l;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: ImageMatrixProperty */
public class e extends Property<ImageView, Matrix> {

    /* renamed from: a reason: collision with root package name */
    public final Matrix f8226a = new Matrix();

    public e() {
        super(Matrix.class, "imageMatrixProperty");
    }

    public Object get(Object obj) {
        this.f8226a.set(((ImageView) obj).getImageMatrix());
        return this.f8226a;
    }

    public void set(Object obj, Object obj2) {
        ((ImageView) obj).setImageMatrix((Matrix) obj2);
    }
}
