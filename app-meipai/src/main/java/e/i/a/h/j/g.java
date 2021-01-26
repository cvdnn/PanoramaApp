package e.i.a.h.j;

import e.i.a.c;
import e.i.a.e;
import e.i.a.h.j.b.a;
import java.io.File;
import java.io.IOException;

/* compiled from: ProcessFileStrategy */
public class g {

    /* renamed from: a reason: collision with root package name */
    public final c f8879a = new c();

    public void a(c cVar) throws IOException {
        File g2 = cVar.g();
        if (g2 != null && g2.exists() && !g2.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public boolean b(c cVar) {
        if (((a) e.a().f8668e) != null) {
            Boolean bool = cVar.m;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        throw null;
    }
}
