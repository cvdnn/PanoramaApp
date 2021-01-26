package e.d.a.n;

import d.e.a;
import e.d.a.t.b;
import java.security.MessageDigest;

/* compiled from: Options */
public final class h implements f {

    /* renamed from: b reason: collision with root package name */
    public final a<g<?>, Object> f7231b = new b();

    public void a(h hVar) {
        this.f7231b.a((d.e.h<? extends K, ? extends V>) hVar.f7231b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f7231b.equals(((h) obj).f7231b);
    }

    public int hashCode() {
        return this.f7231b.hashCode();
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Options{values=");
        a2.append(this.f7231b);
        a2.append('}');
        return a2.toString();
    }

    public <T> T a(g<T> gVar) {
        if (this.f7231b.a((Object) gVar) >= 0) {
            return this.f7231b.getOrDefault(gVar, null);
        }
        return gVar.f7227a;
    }

    public void a(MessageDigest messageDigest) {
        int i2 = 0;
        while (true) {
            a<g<?>, Object> aVar = this.f7231b;
            if (i2 < aVar.f4602c) {
                g gVar = (g) aVar.c(i2);
                Object e2 = this.f7231b.e(i2);
                g.b<T> bVar = gVar.f7228b;
                if (gVar.f7230d == null) {
                    gVar.f7230d = gVar.f7229c.getBytes(f.f7225a);
                }
                bVar.a(gVar.f7230d, e2, messageDigest);
                i2++;
            } else {
                return;
            }
        }
    }
}
