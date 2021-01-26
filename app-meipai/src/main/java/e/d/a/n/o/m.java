package e.d.a.n.o;

import e.d.a.t.g;
import e.d.a.t.j;
import java.util.Queue;

/* compiled from: ModelCache */
public class m<A, B> {

    /* renamed from: a reason: collision with root package name */
    public final g<b<A>, B> f7573a;

    /* compiled from: ModelCache */
    public class a extends g<b<A>, B> {
        public a(m mVar, long j2) {
            super(j2);
        }

        public void a(Object obj, Object obj2) {
            ((b) obj).a();
        }
    }

    /* compiled from: ModelCache */
    public static final class b<A> {

        /* renamed from: d reason: collision with root package name */
        public static final Queue<b<?>> f7574d = j.a(0);

        /* renamed from: a reason: collision with root package name */
        public int f7575a;

        /* renamed from: b reason: collision with root package name */
        public int f7576b;

        /* renamed from: c reason: collision with root package name */
        public A f7577c;

        public static <A> b<A> a(A a2, int i2, int i3) {
            b<A> bVar;
            synchronized (f7574d) {
                bVar = (b) f7574d.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.f7577c = a2;
            bVar.f7576b = i2;
            bVar.f7575a = i3;
            return bVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f7576b == bVar.f7576b && this.f7575a == bVar.f7575a && this.f7577c.equals(bVar.f7577c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f7577c.hashCode() + (((this.f7575a * 31) + this.f7576b) * 31);
        }

        public void a() {
            synchronized (f7574d) {
                f7574d.offer(this);
            }
        }
    }

    public m(long j2) {
        this.f7573a = new a(this, j2);
    }
}
