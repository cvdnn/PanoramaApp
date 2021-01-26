package e.d.a.n.n;

import e.a.a.a.a;
import e.c.f.n.n;
import e.d.a.n.f;
import e.d.a.n.h;
import e.d.a.n.l;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey */
public class o implements f {

    /* renamed from: b reason: collision with root package name */
    public final Object f7481b;

    /* renamed from: c reason: collision with root package name */
    public final int f7482c;

    /* renamed from: d reason: collision with root package name */
    public final int f7483d;

    /* renamed from: e reason: collision with root package name */
    public final Class<?> f7484e;

    /* renamed from: f reason: collision with root package name */
    public final Class<?> f7485f;

    /* renamed from: g reason: collision with root package name */
    public final f f7486g;

    /* renamed from: h reason: collision with root package name */
    public final Map<Class<?>, l<?>> f7487h;

    /* renamed from: i reason: collision with root package name */
    public final h f7488i;

    /* renamed from: j reason: collision with root package name */
    public int f7489j;

    public o(Object obj, f fVar, int i2, int i3, Map<Class<?>, l<?>> map, Class<?> cls, Class<?> cls2, h hVar) {
        String str = "Argument must not be null";
        n.a(obj, str);
        this.f7481b = obj;
        n.a(fVar, "Signature must not be null");
        this.f7486g = fVar;
        this.f7482c = i2;
        this.f7483d = i3;
        n.a(map, str);
        this.f7487h = map;
        n.a(cls, "Resource class must not be null");
        this.f7484e = cls;
        n.a(cls2, "Transcode class must not be null");
        this.f7485f = cls2;
        n.a(hVar, str);
        this.f7488i = hVar;
    }

    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.f7481b.equals(oVar.f7481b) || !this.f7486g.equals(oVar.f7486g) || this.f7483d != oVar.f7483d || this.f7482c != oVar.f7482c || !this.f7487h.equals(oVar.f7487h) || !this.f7484e.equals(oVar.f7484e) || !this.f7485f.equals(oVar.f7485f) || !this.f7488i.equals(oVar.f7488i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f7489j == 0) {
            int hashCode = this.f7481b.hashCode();
            this.f7489j = hashCode;
            int hashCode2 = this.f7486g.hashCode() + (hashCode * 31);
            this.f7489j = hashCode2;
            int i2 = (hashCode2 * 31) + this.f7482c;
            this.f7489j = i2;
            int i3 = (i2 * 31) + this.f7483d;
            this.f7489j = i3;
            int hashCode3 = this.f7487h.hashCode() + (i3 * 31);
            this.f7489j = hashCode3;
            int hashCode4 = this.f7484e.hashCode() + (hashCode3 * 31);
            this.f7489j = hashCode4;
            int hashCode5 = this.f7485f.hashCode() + (hashCode4 * 31);
            this.f7489j = hashCode5;
            this.f7489j = this.f7488i.hashCode() + (hashCode5 * 31);
        }
        return this.f7489j;
    }

    public String toString() {
        StringBuilder a2 = a.a("EngineKey{model=");
        a2.append(this.f7481b);
        a2.append(", width=");
        a2.append(this.f7482c);
        a2.append(", height=");
        a2.append(this.f7483d);
        a2.append(", resourceClass=");
        a2.append(this.f7484e);
        a2.append(", transcodeClass=");
        a2.append(this.f7485f);
        a2.append(", signature=");
        a2.append(this.f7486g);
        a2.append(", hashCode=");
        a2.append(this.f7489j);
        a2.append(", transformations=");
        a2.append(this.f7487h);
        a2.append(", options=");
        a2.append(this.f7488i);
        a2.append('}');
        return a2.toString();
    }
}
