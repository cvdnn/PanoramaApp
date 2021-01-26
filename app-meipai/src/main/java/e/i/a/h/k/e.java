package e.i.a.h.k;

import e.i.a.h.f.a.C0121a;
import e.i.a.h.h.d;
import e.i.a.h.h.f;
import e.i.a.h.i.c;
import e.i.a.h.i.g;
import java.io.IOException;

/* compiled from: RetryInterceptor */
public class e implements c, d {
    public long a(f fVar) throws IOException {
        try {
            return fVar.e();
        } catch (IOException e2) {
            fVar.f8843d.a(e2);
            throw e2;
        }
    }

    public C0121a b(f fVar) throws IOException {
        d dVar = fVar.f8843d;
        while (true) {
            try {
                if (!dVar.b()) {
                    return fVar.d();
                }
                throw c.f8856a;
            } catch (IOException e2) {
                if (e2 instanceof g) {
                    fVar.f8846g = 1;
                    fVar.f();
                } else {
                    fVar.f8843d.a(e2);
                    fVar.c().t.add(Integer.valueOf(fVar.f8840a));
                    throw e2;
                }
            }
        }
    }
}
