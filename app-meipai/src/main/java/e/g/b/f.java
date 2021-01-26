package e.g.b;

import e.g.b.e0.a;
import e.g.b.e0.b;
import e.g.b.e0.c;
import java.io.IOException;

/* compiled from: Gson */
public class f extends z<Number> {
    public f(j jVar) {
    }

    public void a(c cVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            cVar.m();
            return;
        }
        j.a((double) number.floatValue());
        cVar.a(number);
    }

    public Object a(a aVar) throws IOException {
        if (aVar.A() != b.NULL) {
            return Float.valueOf((float) aVar.t());
        }
        aVar.x();
        return null;
    }
}
