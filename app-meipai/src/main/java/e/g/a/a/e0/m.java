package e.g.a.a.e0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapePath */
public class m {
    @Deprecated

    /* renamed from: a reason: collision with root package name */
    public float f8124a;
    @Deprecated

    /* renamed from: b reason: collision with root package name */
    public float f8125b;
    @Deprecated

    /* renamed from: c reason: collision with root package name */
    public float f8126c;
    @Deprecated

    /* renamed from: d reason: collision with root package name */
    public float f8127d;
    @Deprecated

    /* renamed from: e reason: collision with root package name */
    public float f8128e;
    @Deprecated

    /* renamed from: f reason: collision with root package name */
    public float f8129f;

    /* renamed from: g reason: collision with root package name */
    public final List<e> f8130g = new ArrayList();

    /* renamed from: h reason: collision with root package name */
    public final List<f> f8131h = new ArrayList();

    /* compiled from: ShapePath */
    public static class a extends f {

        /* renamed from: b reason: collision with root package name */
        public final c f8132b;

        public a(c cVar) {
            this.f8132b = cVar;
        }

        public void a(Matrix matrix, e.g.a.a.d0.a aVar, int i2, Canvas canvas) {
            e.g.a.a.d0.a aVar2 = aVar;
            int i3 = i2;
            Canvas canvas2 = canvas;
            c cVar = this.f8132b;
            float f2 = cVar.f8141f;
            float f3 = cVar.f8142g;
            c cVar2 = this.f8132b;
            RectF rectF = new RectF(cVar2.f8137b, cVar2.f8138c, cVar2.f8139d, cVar2.f8140e);
            boolean z = f3 < 0.0f;
            Path path = aVar2.f8067g;
            if (z) {
                int[] iArr = e.g.a.a.d0.a.f8060j;
                iArr[0] = 0;
                iArr[1] = aVar2.f8066f;
                iArr[2] = aVar2.f8065e;
                iArr[3] = aVar2.f8064d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f2, f3);
                path.close();
                float f4 = (float) (-i3);
                rectF.inset(f4, f4);
                int[] iArr2 = e.g.a.a.d0.a.f8060j;
                iArr2[0] = 0;
                iArr2[1] = aVar2.f8064d;
                iArr2[2] = aVar2.f8065e;
                iArr2[3] = aVar2.f8066f;
            }
            float width = 1.0f - (((float) i3) / (rectF.width() / 2.0f));
            float f5 = ((1.0f - width) / 2.0f) + width;
            float[] fArr = e.g.a.a.d0.a.k;
            fArr[1] = width;
            fArr[2] = f5;
            Paint paint = aVar2.f8062b;
            RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, e.g.a.a.d0.a.f8060j, e.g.a.a.d0.a.k, TileMode.CLAMP);
            paint.setShader(radialGradient);
            canvas.save();
            canvas2.concat(matrix);
            if (!z) {
                canvas2.clipPath(path, Op.DIFFERENCE);
            }
            canvas.drawArc(rectF, f2, f3, true, aVar2.f8062b);
            canvas.restore();
        }
    }

    /* compiled from: ShapePath */
    public static class b extends f {

        /* renamed from: b reason: collision with root package name */
        public final d f8133b;

        /* renamed from: c reason: collision with root package name */
        public final float f8134c;

        /* renamed from: d reason: collision with root package name */
        public final float f8135d;

        public b(d dVar, float f2, float f3) {
            this.f8133b = dVar;
            this.f8134c = f2;
            this.f8135d = f3;
        }

        public void a(Matrix matrix, e.g.a.a.d0.a aVar, int i2, Canvas canvas) {
            d dVar = this.f8133b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (dVar.f8144c - this.f8135d), (double) (dVar.f8143b - this.f8134c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f8134c, this.f8135d);
            matrix2.preRotate(a());
            if (aVar != null) {
                rectF.bottom += (float) i2;
                rectF.offset(0.0f, (float) (-i2));
                int[] iArr = e.g.a.a.d0.a.f8058h;
                iArr[0] = aVar.f8066f;
                iArr[1] = aVar.f8065e;
                iArr[2] = aVar.f8064d;
                Paint paint = aVar.f8063c;
                float f2 = rectF.left;
                LinearGradient linearGradient = new LinearGradient(f2, rectF.top, f2, rectF.bottom, e.g.a.a.d0.a.f8058h, e.g.a.a.d0.a.f8059i, TileMode.CLAMP);
                paint.setShader(linearGradient);
                canvas.save();
                canvas.concat(matrix2);
                canvas.drawRect(rectF, aVar.f8063c);
                canvas.restore();
                return;
            }
            throw null;
        }

        public float a() {
            d dVar = this.f8133b;
            return (float) Math.toDegrees(Math.atan((double) ((dVar.f8144c - this.f8135d) / (dVar.f8143b - this.f8134c))));
        }
    }

    /* compiled from: ShapePath */
    public static class c extends e {

        /* renamed from: h reason: collision with root package name */
        public static final RectF f8136h = new RectF();
        @Deprecated

        /* renamed from: b reason: collision with root package name */
        public float f8137b;
        @Deprecated

        /* renamed from: c reason: collision with root package name */
        public float f8138c;
        @Deprecated

        /* renamed from: d reason: collision with root package name */
        public float f8139d;
        @Deprecated

        /* renamed from: e reason: collision with root package name */
        public float f8140e;
        @Deprecated

        /* renamed from: f reason: collision with root package name */
        public float f8141f;
        @Deprecated

        /* renamed from: g reason: collision with root package name */
        public float f8142g;

        public c(float f2, float f3, float f4, float f5) {
            this.f8137b = f2;
            this.f8138c = f3;
            this.f8139d = f4;
            this.f8140e = f5;
        }

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f8145a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f8136h.set(this.f8137b, this.f8138c, this.f8139d, this.f8140e);
            path.arcTo(f8136h, this.f8141f, this.f8142g, false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath */
    public static class d extends e {

        /* renamed from: b reason: collision with root package name */
        public float f8143b;

        /* renamed from: c reason: collision with root package name */
        public float f8144c;

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f8145a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f8143b, this.f8144c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath */
    public static abstract class e {

        /* renamed from: a reason: collision with root package name */
        public final Matrix f8145a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* compiled from: ShapePath */
    public static abstract class f {

        /* renamed from: a reason: collision with root package name */
        public static final Matrix f8146a = new Matrix();

        public abstract void a(Matrix matrix, e.g.a.a.d0.a aVar, int i2, Canvas canvas);
    }

    public m() {
        a(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3) {
        d dVar = new d();
        dVar.f8143b = f2;
        dVar.f8144c = f3;
        this.f8130g.add(dVar);
        b bVar = new b(dVar, this.f8126c, this.f8127d);
        float a2 = bVar.a() + 270.0f;
        a(bVar.a() + 270.0f);
        this.f8131h.add(bVar);
        this.f8128e = a2;
        this.f8126c = f2;
        this.f8127d = f3;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f8141f = f6;
        cVar.f8142g = f7;
        this.f8130g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        a(f6);
        this.f8131h.add(aVar);
        this.f8128e = f9;
        double d2 = (double) f8;
        this.f8126c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f8127d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public void a(Matrix matrix, Path path) {
        int size = this.f8130g.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((e) this.f8130g.get(i2)).a(matrix, path);
        }
    }

    public final void a(float f2) {
        float f3 = this.f8128e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.f8126c;
                float f6 = this.f8127d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.f8141f = this.f8128e;
                cVar.f8142g = f4;
                this.f8131h.add(new a(cVar));
                this.f8128e = f2;
            }
        }
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f8124a = f2;
        this.f8125b = f3;
        this.f8126c = f2;
        this.f8127d = f3;
        this.f8128e = f4;
        this.f8129f = (f4 + f5) % 360.0f;
        this.f8130g.clear();
        this.f8131h.clear();
    }
}
