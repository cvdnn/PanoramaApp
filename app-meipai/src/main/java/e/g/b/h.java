package e.g.b;

import e.g.b.e0.a;
import e.g.b.e0.c;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Gson */
public final class h extends z<AtomicLong> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ z f8570a;

    public h(z zVar) {
        this.f8570a = zVar;
    }

    public void a(c cVar, Object obj) throws IOException {
        this.f8570a.a(cVar, Long.valueOf(((AtomicLong) obj).get()));
    }

    public Object a(a aVar) throws IOException {
        return new AtomicLong(((Number) this.f8570a.a(aVar)).longValue());
    }
}
