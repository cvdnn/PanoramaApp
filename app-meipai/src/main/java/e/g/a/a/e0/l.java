package e.g.a.a.e0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import e.g.a.a.d0.a;
import e.g.a.a.e0.m.f;
import java.util.List;

/* compiled from: ShapePath */
public class l extends f {

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ List f8122b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ Matrix f8123c;

    public l(m mVar, List list, Matrix matrix) {
        this.f8122b = list;
        this.f8123c = matrix;
    }

    public void a(Matrix matrix, a aVar, int i2, Canvas canvas) {
        for (f a2 : this.f8122b) {
            a2.a(this.f8123c, aVar, i2, canvas);
        }
    }
}
