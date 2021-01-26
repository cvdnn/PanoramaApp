package h;

import e.a.a.a.a;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Okio */
public final class n implements w {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ y f9665a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ OutputStream f9666b;

    public n(y yVar, OutputStream outputStream) {
        this.f9665a = yVar;
        this.f9666b = outputStream;
    }

    public void a(e eVar, long j2) throws IOException {
        z.a(eVar.f9647b, 0, j2);
        while (j2 > 0) {
            this.f9665a.e();
            t tVar = eVar.f9646a;
            int min = (int) Math.min(j2, (long) (tVar.f9681c - tVar.f9680b));
            this.f9666b.write(tVar.f9679a, tVar.f9680b, min);
            int i2 = tVar.f9680b + min;
            tVar.f9680b = i2;
            long j3 = (long) min;
            j2 -= j3;
            eVar.f9647b -= j3;
            if (i2 == tVar.f9681c) {
                eVar.f9646a = tVar.a();
                u.a(tVar);
            }
        }
    }

    public void close() throws IOException {
        this.f9666b.close();
    }

    public void flush() throws IOException {
        this.f9666b.flush();
    }

    public y timeout() {
        return this.f9665a;
    }

    public String toString() {
        StringBuilder a2 = a.a("sink(");
        a2.append(this.f9666b);
        a2.append(")");
        return a2.toString();
    }
}
