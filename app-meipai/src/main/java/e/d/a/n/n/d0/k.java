package e.d.a.n.n.d0;

import d.h.j.c;
import e.c.f.n.n;
import e.d.a.n.f;
import e.d.a.t.g;
import e.d.a.t.j;
import e.d.a.t.k.a.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator */
public class k {

    /* renamed from: a reason: collision with root package name */
    public final g<f, String> f7372a = new g<>(1000);

    /* renamed from: b reason: collision with root package name */
    public final c<b> f7373b = e.d.a.t.k.a.a(10, new a(this));

    /* compiled from: SafeKeyGenerator */
    public class a implements e.d.a.t.k.a.b<b> {
        public a(k kVar) {
        }

        public Object create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SafeKeyGenerator */
    public static final class b implements d {

        /* renamed from: a reason: collision with root package name */
        public final MessageDigest f7374a;

        /* renamed from: b reason: collision with root package name */
        public final e.d.a.t.k.d f7375b = new e.d.a.t.k.d.b();

        public b(MessageDigest messageDigest) {
            this.f7374a = messageDigest;
        }

        public e.d.a.t.k.d a() {
            return this.f7375b;
        }
    }

    public String a(f fVar) {
        String str;
        synchronized (this.f7372a) {
            str = (String) this.f7372a.a(fVar);
        }
        if (str == null) {
            Object a2 = this.f7373b.a();
            n.a(a2, "Argument must not be null");
            b bVar = (b) a2;
            try {
                fVar.a(bVar.f7374a);
                str = j.a(bVar.f7374a.digest());
            } finally {
                this.f7373b.a(bVar);
            }
        }
        synchronized (this.f7372a) {
            this.f7372a.b(fVar, str);
        }
        return str;
    }
}
