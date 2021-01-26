package a.a.a.a.e.a.l;

import a.a.a.a.e.a.i.h;
import java.util.Comparator;

public final class g implements Comparator<h> {
    public int compare(Object obj, Object obj2) {
        h hVar = (h) obj;
        h hVar2 = (h) obj2;
        double d2 = hVar.b().f604c - hVar2.b().f604c;
        if (d2 <= 0.0d) {
            if (d2 >= 0.0d) {
                double d3 = hVar.a().f604c - hVar2.a().f604c;
                if (d3 <= 0.0d) {
                    if (d3 >= 0.0d) {
                        return 0;
                    }
                }
            }
            return -1;
        }
        return 1;
    }
}
