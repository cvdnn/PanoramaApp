package a.a.a.a.e.a.i.f;

import a.a.a.a.b.a;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Quaternionfc;
import java.util.List;

public class g extends c {
    public e a(double d2) {
        e eVar = (e) this.f597a.get(0);
        List<e> list = this.f597a;
        e eVar2 = (e) list.get(list.size() - 1);
        double d3 = eVar2.f604c;
        double d4 = eVar.f604c;
        double cos = (double) (((float) (Math.cos(((double) (((((float) (d2 - d4)) * 1.0f) / ((float) (d3 - d4))) + 1.0f)) * 3.141592653589793d) / 2.0d)) + 0.5f);
        float f2 = eVar.f608g;
        float round = (((float) (((int) Math.round(((double) (eVar2.f608g - f2)) / 6.283185307179586d)) * 2)) * 3.1415927f) + f2;
        eVar.f608g = round;
        double d5 = (((double) (eVar2.f608g - round)) * cos) + ((double) round);
        float f3 = eVar.f602a;
        double d6 = (((double) (eVar2.f602a - f3)) * cos) + ((double) f3);
        float f4 = eVar.f603b;
        return a.a(a.a(eVar).slerp((Quaternionfc) a.a(eVar2), (float) cos, new Quaternionf()), (float) d5, (float) d6, (float) ((((double) (eVar2.f603b - f4)) * cos) + ((double) f4)), d2, (double[]) null);
    }
}
