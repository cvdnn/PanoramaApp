package g.d0.h;

import com.baidu.mobstat.Config;
import h.h;

/* compiled from: Header */
public final class c {

    /* renamed from: d reason: collision with root package name */
    public static final h f9288d = h.c(Config.TRACE_TODAY_VISIT_SPLIT);

    /* renamed from: e reason: collision with root package name */
    public static final h f9289e = h.c(":status");

    /* renamed from: f reason: collision with root package name */
    public static final h f9290f = h.c(":method");

    /* renamed from: g reason: collision with root package name */
    public static final h f9291g = h.c(":path");

    /* renamed from: h reason: collision with root package name */
    public static final h f9292h = h.c(":scheme");

    /* renamed from: i reason: collision with root package name */
    public static final h f9293i = h.c(":authority");

    /* renamed from: a reason: collision with root package name */
    public final h f9294a;

    /* renamed from: b reason: collision with root package name */
    public final h f9295b;

    /* renamed from: c reason: collision with root package name */
    public final int f9296c;

    public c(String str, String str2) {
        this(h.c(str), h.c(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f9294a.equals(cVar.f9294a) || !this.f9295b.equals(cVar.f9295b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f9295b.hashCode() + ((this.f9294a.hashCode() + 527) * 31);
    }

    public String toString() {
        return g.d0.c.a("%s: %s", this.f9294a.g(), this.f9295b.g());
    }

    public c(h hVar, String str) {
        this(hVar, h.c(str));
    }

    public c(h hVar, h hVar2) {
        this.f9294a = hVar;
        this.f9295b = hVar2;
        this.f9296c = hVar2.d() + hVar.d() + 32;
    }
}
