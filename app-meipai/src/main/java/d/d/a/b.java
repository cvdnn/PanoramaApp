package d.d.a;

import android.content.res.ColorStateList;

/* compiled from: CardViewApi21Impl */
public class b implements d {
    public void a(c cVar, float f2) {
        e a2 = a(cVar);
        boolean b2 = cVar.b();
        boolean a3 = cVar.a();
        if (f2 != a2.f4545b || a2.f4546c != b2 || a2.f4547d != a3) {
            a2.f4545b = f2;
            a2.f4546c = b2;
            a2.f4547d = a3;
            a2.a(null);
            throw null;
        } else if (!cVar.b()) {
            cVar.a(0, 0, 0, 0);
        } else {
            float f3 = a(cVar).f4545b;
            float f4 = a(cVar).f4544a;
            int ceil = (int) Math.ceil((double) f.a(f3, f4, cVar.a()));
            int ceil2 = (int) Math.ceil((double) f.b(f3, f4, cVar.a()));
            cVar.a(ceil, ceil2, ceil, ceil2);
        }
    }

    public float b(c cVar) {
        return a(cVar).f4545b;
    }

    public float c(c cVar) {
        return a(cVar).f4544a;
    }

    public void a(c cVar, ColorStateList colorStateList) {
        e a2 = a(cVar);
        if (a2 != null) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            a2.f4548e = colorStateList;
            colorStateList.getColorForState(a2.getState(), a2.f4548e.getDefaultColor());
            throw null;
        }
        throw null;
    }

    public final e a(c cVar) {
        return (e) cVar.c();
    }
}
