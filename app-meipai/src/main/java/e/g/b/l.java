package e.g.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class l extends o implements Iterable<o> {

    /* renamed from: a reason: collision with root package name */
    public final List<o> f8583a = new ArrayList();

    public boolean a() {
        if (this.f8583a.size() == 1) {
            return ((o) this.f8583a.get(0)).a();
        }
        throw new IllegalStateException();
    }

    public float b() {
        if (this.f8583a.size() == 1) {
            return ((o) this.f8583a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    public int c() {
        if (this.f8583a.size() == 1) {
            return ((o) this.f8583a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).f8583a.equals(this.f8583a));
    }

    public String g() {
        if (this.f8583a.size() == 1) {
            return ((o) this.f8583a.get(0)).g();
        }
        throw new IllegalStateException();
    }

    public o get(int i2) {
        return (o) this.f8583a.get(i2);
    }

    public int hashCode() {
        return this.f8583a.hashCode();
    }

    public Iterator<o> iterator() {
        return this.f8583a.iterator();
    }

    public int size() {
        return this.f8583a.size();
    }
}
