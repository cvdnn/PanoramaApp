package a.a.a.a.e.a.e;

import a.a.a.a.e.a.e.k.e;
import a.a.a.a.e.a.i.a;
import a.a.a.a.e.a.i.a.C0001a;
import a.a.a.a.e.a.i.a.b;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import java.util.List;

public class h {

    /* renamed from: a reason: collision with root package name */
    public e f521a;

    /* renamed from: b reason: collision with root package name */
    public a.a.a.a.e.a.i.e f522b;

    public BlendImageInfo a(double d2, double d3, b bVar) {
        for (a aVar : this.f521a.getFlashDataList()) {
            if (aVar.f578a <= d3 && aVar.f579b >= d3) {
                List<C0001a> list = aVar.f580c;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    C0001a aVar2 = (C0001a) list.get(i2);
                    if (aVar2.f581a >= d3) {
                        if (i2 != 0) {
                            int i3 = (Math.abs(((C0001a) list.get(i2 - 1)).f581a - d3) > Math.abs(aVar2.f581a - d3) ? 1 : (Math.abs(((C0001a) list.get(i2 - 1)).f581a - d3) == Math.abs(aVar2.f581a - d3) ? 0 : -1));
                        }
                    } else if (i2 == list.size() - 1) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return null;
    }
}
