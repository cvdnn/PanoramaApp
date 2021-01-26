package e.c.d.i.b;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;

/* compiled from: CoordinateTransformer */
public class m {

    /* renamed from: a reason: collision with root package name */
    public final Matrix f6187a;

    /* renamed from: b reason: collision with root package name */
    public final Matrix f6188b;

    /* renamed from: c reason: collision with root package name */
    public RectF f6189c;

    public m(CameraCharacteristics cameraCharacteristics, int i2, RectF rectF) {
        if (!a(rectF)) {
            this.f6188b = null;
            this.f6187a = null;
            return;
        }
        this.f6189c = new RectF((Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        boolean z = num != null && num.intValue() == 0;
        Matrix matrix = new Matrix();
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) (-i2));
        matrix.mapRect(rectF);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF, this.f6189c, ScaleToFit.FILL);
        matrix.setConcat(matrix2, matrix);
        this.f6187a = matrix;
        this.f6188b = a(z, i2, rectF);
    }

    public final Matrix a(boolean z, int i2, RectF rectF) {
        RectF rectF2 = new RectF(-1000.0f, -1000.0f, 1000.0f, 1000.0f);
        Matrix matrix = new Matrix();
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) i2);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF2, rectF, ScaleToFit.FILL);
        matrix.setConcat(matrix2, matrix);
        return matrix;
    }

    public final boolean a(RectF rectF) {
        return (rectF.width() == 0.0f || rectF.height() == 0.0f) ? false : true;
    }

    public m(boolean z, int i2, RectF rectF) {
        if (!a(rectF)) {
            this.f6188b = null;
            this.f6187a = null;
            return;
        }
        Matrix a2 = a(z, i2, rectF);
        this.f6188b = a2;
        Matrix matrix = new Matrix();
        a2.invert(matrix);
        this.f6187a = matrix;
    }
}
