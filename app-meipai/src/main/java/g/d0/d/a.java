package g.d0.d;

import g.d0.c;
import h.e;
import h.f;
import h.g;
import h.x;
import h.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheInterceptor */
public class a implements x {

    /* renamed from: a reason: collision with root package name */
    public boolean f9186a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ g f9187b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ c f9188c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ f f9189d;

    public a(b bVar, g gVar, c cVar, f fVar) {
        this.f9187b = gVar;
        this.f9188c = cVar;
        this.f9189d = fVar;
    }

    public void close() throws IOException {
        if (!this.f9186a && !c.a((x) this, 100, TimeUnit.MILLISECONDS)) {
            this.f9186a = true;
            this.f9188c.a();
        }
        this.f9187b.close();
    }

    public long read(e eVar, long j2) throws IOException {
        try {
            long read = this.f9187b.read(eVar, j2);
            if (read == -1) {
                if (!this.f9186a) {
                    this.f9186a = true;
                    this.f9189d.close();
                }
                return -1;
            }
            eVar.a(this.f9189d.c(), eVar.f9647b - read, read);
            this.f9189d.h();
            return read;
        } catch (IOException e2) {
            if (!this.f9186a) {
                this.f9186a = true;
                this.f9188c.a();
            }
            throw e2;
        }
    }

    public y timeout() {
        return this.f9187b.timeout();
    }
}
