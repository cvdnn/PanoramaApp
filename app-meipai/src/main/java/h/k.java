package h;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public class k extends y {

    /* renamed from: e reason: collision with root package name */
    public y f9655e;

    public k(y yVar) {
        if (yVar != null) {
            this.f9655e = yVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public y a(long j2, TimeUnit timeUnit) {
        return this.f9655e.a(j2, timeUnit);
    }

    public y b() {
        return this.f9655e.b();
    }

    public long c() {
        return this.f9655e.c();
    }

    public boolean d() {
        return this.f9655e.d();
    }

    public void e() throws IOException {
        this.f9655e.e();
    }

    public y a(long j2) {
        return this.f9655e.a(j2);
    }

    public y a() {
        return this.f9655e.a();
    }
}
