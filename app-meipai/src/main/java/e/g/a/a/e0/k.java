package e.g.a.a.e0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import e.g.a.a.e0.m.f;
import java.util.ArrayList;

/* compiled from: ShapeAppearancePathProvider */
public class k {

    /* renamed from: a reason: collision with root package name */
    public final m[] f8115a = new m[4];

    /* renamed from: b reason: collision with root package name */
    public final Matrix[] f8116b = new Matrix[4];

    /* renamed from: c reason: collision with root package name */
    public final Matrix[] f8117c = new Matrix[4];

    /* renamed from: d reason: collision with root package name */
    public final PointF f8118d = new PointF();

    /* renamed from: e reason: collision with root package name */
    public final m f8119e = new m();

    /* renamed from: f reason: collision with root package name */
    public final float[] f8120f = new float[2];

    /* renamed from: g reason: collision with root package name */
    public final float[] f8121g = new float[2];

    /* compiled from: ShapeAppearancePathProvider */
    public interface a {
    }

    public k() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f8115a[i2] = new m();
            this.f8116b[i2] = new Matrix();
            this.f8117c[i2] = new Matrix();
        }
    }

    public void a(j jVar, float f2, RectF rectF, a aVar, Path path) {
        float f3;
        f fVar;
        char c2;
        char c3;
        c cVar;
        d dVar;
        j jVar2 = jVar;
        float f4 = f2;
        RectF rectF2 = rectF;
        Path path2 = path;
        path.rewind();
        char c4 = 0;
        int i2 = 0;
        while (i2 < 4) {
            if (i2 == 1) {
                cVar = jVar2.f8101g;
            } else if (i2 == 2) {
                cVar = jVar2.f8102h;
            } else if (i2 != 3) {
                cVar = jVar2.f8100f;
            } else {
                cVar = jVar2.f8099e;
            }
            if (i2 == 1) {
                dVar = jVar2.f8097c;
            } else if (i2 == 2) {
                dVar = jVar2.f8098d;
            } else if (i2 != 3) {
                dVar = jVar2.f8096b;
            } else {
                dVar = jVar2.f8095a;
            }
            m mVar = this.f8115a[i2];
            if (dVar != null) {
                dVar.a(mVar, 90.0f, f4, cVar.a(rectF2));
                int i3 = i2 + 1;
                float f5 = (float) (i3 * 90);
                this.f8116b[i2].reset();
                PointF pointF = this.f8118d;
                if (i2 == 1) {
                    pointF.set(rectF2.right, rectF2.bottom);
                } else if (i2 == 2) {
                    pointF.set(rectF2.left, rectF2.bottom);
                } else if (i2 != 3) {
                    pointF.set(rectF2.right, rectF2.top);
                } else {
                    pointF.set(rectF2.left, rectF2.top);
                }
                Matrix matrix = this.f8116b[i2];
                PointF pointF2 = this.f8118d;
                matrix.setTranslate(pointF2.x, pointF2.y);
                this.f8116b[i2].preRotate(f5);
                float[] fArr = this.f8120f;
                m[] mVarArr = this.f8115a;
                fArr[0] = mVarArr[i2].f8126c;
                fArr[1] = mVarArr[i2].f8127d;
                this.f8116b[i2].mapPoints(fArr);
                this.f8117c[i2].reset();
                Matrix matrix2 = this.f8117c[i2];
                float[] fArr2 = this.f8120f;
                matrix2.setTranslate(fArr2[0], fArr2[1]);
                this.f8117c[i2].preRotate(f5);
                i2 = i3;
            } else {
                throw null;
            }
        }
        int i4 = 0;
        while (i4 < 4) {
            float[] fArr3 = this.f8120f;
            m[] mVarArr2 = this.f8115a;
            fArr3[c4] = mVarArr2[i4].f8124a;
            fArr3[1] = mVarArr2[i4].f8125b;
            this.f8116b[i4].mapPoints(fArr3);
            if (i4 == 0) {
                float[] fArr4 = this.f8120f;
                path2.moveTo(fArr4[c4], fArr4[1]);
            } else {
                float[] fArr5 = this.f8120f;
                path2.lineTo(fArr5[c4], fArr5[1]);
            }
            this.f8115a[i4].a(this.f8116b[i4], path2);
            if (aVar != null) {
                m mVar2 = this.f8115a[i4];
                Matrix matrix3 = this.f8116b[i4];
                f[] fVarArr = g.this.f8073b;
                mVar2.a(mVar2.f8129f);
                fVarArr[i4] = new l(mVar2, new ArrayList(mVar2.f8131h), matrix3);
            }
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            float[] fArr6 = this.f8120f;
            m[] mVarArr3 = this.f8115a;
            fArr6[c4] = mVarArr3[i4].f8126c;
            fArr6[1] = mVarArr3[i4].f8127d;
            this.f8116b[i4].mapPoints(fArr6);
            float[] fArr7 = this.f8121g;
            m[] mVarArr4 = this.f8115a;
            fArr7[c4] = mVarArr4[i6].f8124a;
            fArr7[1] = mVarArr4[i6].f8125b;
            this.f8116b[i6].mapPoints(fArr7);
            float[] fArr8 = this.f8120f;
            float f6 = fArr8[c4];
            float[] fArr9 = this.f8121g;
            float max = Math.max(((float) Math.hypot((double) (f6 - fArr9[c4]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, 0.0f);
            float[] fArr10 = this.f8120f;
            m[] mVarArr5 = this.f8115a;
            fArr10[c4] = mVarArr5[i4].f8126c;
            fArr10[1] = mVarArr5[i4].f8127d;
            this.f8116b[i4].mapPoints(fArr10);
            if (i4 == 1 || i4 == 3) {
                f3 = Math.abs(rectF.centerX() - this.f8120f[c4]);
            } else {
                f3 = Math.abs(rectF.centerY() - this.f8120f[1]);
            }
            this.f8119e.a(0.0f, 0.0f, 270.0f, 0.0f);
            if (i4 != 1) {
                c3 = 2;
                if (i4 != 2) {
                    c2 = 3;
                    if (i4 != 3) {
                        fVar = jVar2.f8104j;
                    } else {
                        fVar = jVar2.f8103i;
                    }
                } else {
                    c2 = 3;
                    fVar = jVar2.l;
                }
            } else {
                c3 = 2;
                c2 = 3;
                fVar = jVar2.k;
            }
            fVar.a(max, f3, f4, this.f8119e);
            this.f8119e.a(this.f8117c[i4], path2);
            if (aVar != null) {
                m mVar3 = this.f8119e;
                Matrix matrix4 = this.f8117c[i4];
                f[] fVarArr2 = g.this.f8074c;
                mVar3.a(mVar3.f8129f);
                fVarArr2[i4] = new l(mVar3, new ArrayList(mVar3.f8131h), matrix4);
            }
            char c5 = c3;
            i4 = i5;
            char c6 = c2;
            c4 = 0;
        }
        path.close();
    }
}
