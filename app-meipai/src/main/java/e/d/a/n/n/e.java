package e.d.a.n.n;

import e.a.a.a.a;
import e.d.a.n.f;
import java.security.MessageDigest;

/* compiled from: DataCacheKey */
public final class e implements f {

    /* renamed from: b reason: collision with root package name */
    public final f f7376b;

    /* renamed from: c reason: collision with root package name */
    public final f f7377c;

    public e(f fVar, f fVar2) {
        this.f7376b = fVar;
        this.f7377c = fVar2;
    }

    public void a(MessageDigest messageDigest) {
        this.f7376b.a(messageDigest);
        this.f7377c.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f7376b.equals(eVar.f7376b) || !this.f7377c.equals(eVar.f7377c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7377c.hashCode() + (this.f7376b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a2 = a.a("DataCacheKey{sourceKey=");
        a2.append(this.f7376b);
        a2.append(", signature=");
        a2.append(this.f7377c);
        a2.append('}');
        return a2.toString();
    }
}
