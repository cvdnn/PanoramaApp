package e.g.b;

import e.g.b.c0.r.e;

/* compiled from: JsonObject */
public final class r extends o {

    /* renamed from: a reason: collision with root package name */
    public final e.g.b.c0.r<String, o> f8585a = new e.g.b.c0.r<>();

    public o a(String str) {
        e a2 = this.f8585a.a((Object) str);
        return (o) (a2 != null ? a2.f8519g : null);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof r) && ((r) obj).f8585a.equals(this.f8585a));
    }

    public int hashCode() {
        return this.f8585a.hashCode();
    }
}
