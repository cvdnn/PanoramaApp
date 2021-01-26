package e.g.b;

import e.g.b.e0.a;
import e.g.b.e0.b;
import e.g.b.e0.c;
import java.io.IOException;

/* compiled from: TypeAdapter */
public class y extends z<T> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ z f8591a;

    public y(z zVar) {
        this.f8591a = zVar;
    }

    public void a(c cVar, T t) throws IOException {
        if (t == null) {
            cVar.m();
        } else {
            this.f8591a.a(cVar, t);
        }
    }

    public T a(a aVar) throws IOException {
        if (aVar.A() != b.NULL) {
            return this.f8591a.a(aVar);
        }
        aVar.x();
        return null;
    }
}
