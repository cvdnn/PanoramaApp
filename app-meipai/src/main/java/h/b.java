package h;

import e.a.a.a.a;
import java.io.IOException;

/* compiled from: AsyncTimeout */
public class b implements x {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ x f9636a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ c f9637b;

    public b(c cVar, x xVar) {
        this.f9637b = cVar;
        this.f9636a = xVar;
    }

    public void close() throws IOException {
        this.f9637b.f();
        try {
            this.f9636a.close();
            this.f9637b.a(true);
        } catch (IOException e2) {
            e = e2;
            c cVar = this.f9637b;
            if (cVar.g()) {
                e = cVar.a(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f9637b.a(false);
            throw th;
        }
    }

    public long read(e eVar, long j2) throws IOException {
        this.f9637b.f();
        try {
            long read = this.f9636a.read(eVar, j2);
            this.f9637b.a(true);
            return read;
        } catch (IOException e2) {
            e = e2;
            c cVar = this.f9637b;
            if (cVar.g()) {
                e = cVar.a(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f9637b.a(false);
            throw th;
        }
    }

    public y timeout() {
        return this.f9637b;
    }

    public String toString() {
        StringBuilder a2 = a.a("AsyncTimeout.source(");
        a2.append(this.f9636a);
        a2.append(")");
        return a2.toString();
    }
}
