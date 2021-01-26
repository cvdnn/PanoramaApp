package d.h.j;

import e.a.a.a.a;
import java.util.Objects;

/* compiled from: Pair */
public class b<F, S> {

    /* renamed from: a reason: collision with root package name */
    public final F f4903a;

    /* renamed from: b reason: collision with root package name */
    public final S f4904b;

    public b(F f2, S s) {
        this.f4903a = f2;
        this.f4904b = s;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (Objects.equals(bVar.f4903a, this.f4903a) && Objects.equals(bVar.f4904b, this.f4904b)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        F f2 = this.f4903a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f4904b;
        if (s != null) {
            i2 = s.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder a2 = a.a("Pair{");
        a2.append(String.valueOf(this.f4903a));
        a2.append(" ");
        a2.append(String.valueOf(this.f4904b));
        a2.append("}");
        return a2.toString();
    }
}
