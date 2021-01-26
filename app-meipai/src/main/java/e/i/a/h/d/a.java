package e.i.a.h.d;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BlockInfo */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final long f8695a;

    /* renamed from: b reason: collision with root package name */
    public final long f8696b;

    /* renamed from: c reason: collision with root package name */
    public final AtomicLong f8697c;

    public a(long j2, long j3, long j4) {
        if (j2 < 0 || ((j3 < 0 && j3 != -1) || j4 < 0)) {
            throw new IllegalArgumentException();
        }
        this.f8695a = j2;
        this.f8696b = j3;
        this.f8697c = new AtomicLong(j4);
    }

    public long a() {
        return this.f8697c.get();
    }

    public long b() {
        return this.f8697c.get() + this.f8695a;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("[");
        a2.append(this.f8695a);
        a2.append(", ");
        a2.append((this.f8695a + this.f8696b) - 1);
        a2.append(")");
        a2.append("-current:");
        a2.append(this.f8697c);
        return a2.toString();
    }
}
