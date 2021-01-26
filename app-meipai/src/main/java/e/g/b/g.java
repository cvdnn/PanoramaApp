package e.g.b;

import e.g.b.e0.a;
import e.g.b.e0.b;
import e.g.b.e0.c;
import java.io.IOException;

/* compiled from: Gson */
public final class g extends z<Number> {
    public void a(c cVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            cVar.m();
        } else {
            cVar.d(number.toString());
        }
    }

    public Object a(a aVar) throws IOException {
        if (aVar.A() != b.NULL) {
            return Long.valueOf(aVar.v());
        }
        aVar.x();
        return null;
    }
}
