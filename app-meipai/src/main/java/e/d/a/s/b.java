package e.d.a.s;

import e.a.a.a.a;
import e.c.f.n.n;
import e.d.a.n.f;
import java.security.MessageDigest;

/* compiled from: ObjectKey */
public final class b implements f {

    /* renamed from: b reason: collision with root package name */
    public final Object f7897b;

    public b(Object obj) {
        n.a(obj, "Argument must not be null");
        this.f7897b = obj;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f7897b.toString().getBytes(f.f7225a));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f7897b.equals(((b) obj).f7897b);
    }

    public int hashCode() {
        return this.f7897b.hashCode();
    }

    public String toString() {
        StringBuilder a2 = a.a("ObjectKey{object=");
        a2.append(this.f7897b);
        a2.append('}');
        return a2.toString();
    }
}
