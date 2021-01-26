package h;

import java.io.IOException;

/* compiled from: AsyncTimeout */
public class a implements w {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ w f9634a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ c f9635b;

    public a(c cVar, w wVar) {
        this.f9635b = cVar;
        this.f9634a = wVar;
    }

    public void a(e eVar, long j2) throws IOException {
        z.a(eVar.f9647b, 0, j2);
        while (true) {
            long j3 = 0;
            if (j2 > 0) {
                t tVar = eVar.f9646a;
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    j3 += (long) (tVar.f9681c - tVar.f9680b);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    }
                    tVar = tVar.f9684f;
                }
                this.f9635b.f();
                try {
                    this.f9634a.a(eVar, j3);
                    j2 -= j3;
                    this.f9635b.a(true);
                } catch (IOException e2) {
                    e = e2;
                    c cVar = this.f9635b;
                    if (cVar.g()) {
                        e = cVar.a(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    this.f9635b.a(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        this.f9635b.f();
        try {
            this.f9634a.close();
            this.f9635b.a(true);
        } catch (IOException e2) {
            e = e2;
            c cVar = this.f9635b;
            if (cVar.g()) {
                e = cVar.a(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f9635b.a(false);
            throw th;
        }
    }

    public void flush() throws IOException {
        this.f9635b.f();
        try {
            this.f9634a.flush();
            this.f9635b.a(true);
        } catch (IOException e2) {
            e = e2;
            c cVar = this.f9635b;
            if (cVar.g()) {
                e = cVar.a(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f9635b.a(false);
            throw th;
        }
    }

    public y timeout() {
        return this.f9635b;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("AsyncTimeout.sink(");
        a2.append(this.f9634a);
        a2.append(")");
        return a2.toString();
    }
}
