package d.u.a.a;

import a.a.a.a.b.a;
import android.animation.TypeEvaluator;
import d.h.f.b;

/* compiled from: AnimatorInflaterCompat */
public class d implements TypeEvaluator<b[]> {

    /* renamed from: a reason: collision with root package name */
    public b[] f5548a;

    public Object evaluate(float f2, Object obj, Object obj2) {
        b[] bVarArr = (b[]) obj;
        b[] bVarArr2 = (b[]) obj2;
        if (a.a(bVarArr, bVarArr2)) {
            if (!a.a(this.f5548a, bVarArr)) {
                this.f5548a = a.a(bVarArr);
            }
            int i2 = 0;
            while (i2 < bVarArr.length) {
                b bVar = this.f5548a[i2];
                b bVar2 = bVarArr[i2];
                b bVar3 = bVarArr2[i2];
                if (bVar != null) {
                    bVar.f4808a = bVar2.f4808a;
                    int i3 = 0;
                    while (true) {
                        float[] fArr = bVar2.f4809b;
                        if (i3 >= fArr.length) {
                            break;
                        }
                        bVar.f4809b[i3] = (bVar3.f4809b[i3] * f2) + ((1.0f - f2) * fArr[i3]);
                        i3++;
                    }
                    i2++;
                } else {
                    throw null;
                }
            }
            return this.f5548a;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
