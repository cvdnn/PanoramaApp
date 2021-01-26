package g.d0.f;

import g.a0;
import g.t;

/* compiled from: RealResponseBody */
public final class g extends a0 {

    /* renamed from: a reason: collision with root package name */
    public final String f9247a;

    /* renamed from: b reason: collision with root package name */
    public final long f9248b;

    /* renamed from: c reason: collision with root package name */
    public final h.g f9249c;

    public g(String str, long j2, h.g gVar) {
        this.f9247a = str;
        this.f9248b = j2;
        this.f9249c = gVar;
    }

    public long contentLength() {
        return this.f9248b;
    }

    public t contentType() {
        String str = this.f9247a;
        if (str != null) {
            return t.a(str);
        }
        return null;
    }

    public h.g source() {
        return this.f9249c;
    }
}
