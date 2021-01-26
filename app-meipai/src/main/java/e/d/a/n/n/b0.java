package e.d.a.n.n;

import android.util.Log;
import e.d.a.h.e;
import e.d.a.n.d;
import e.d.a.n.n.g.a;
import e.d.a.n.o.n;
import e.d.a.t.f;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator */
public class b0 implements g, a {

    /* renamed from: a reason: collision with root package name */
    public final h<?> f7289a;

    /* renamed from: b reason: collision with root package name */
    public final a f7290b;

    /* renamed from: c reason: collision with root package name */
    public int f7291c;

    /* renamed from: d reason: collision with root package name */
    public d f7292d;

    /* renamed from: e reason: collision with root package name */
    public Object f7293e;

    /* renamed from: f reason: collision with root package name */
    public volatile n.a<?> f7294f;

    /* renamed from: g reason: collision with root package name */
    public e f7295g;

    public b0(h<?> hVar, a aVar) {
        this.f7289a = hVar;
        this.f7290b = aVar;
    }

    /* JADX INFO: finally extract failed */
    public boolean a() {
        Object obj = this.f7293e;
        if (obj != null) {
            this.f7293e = null;
            String str = "SourceGenerator";
            long a2 = f.a();
            try {
                d a3 = this.f7289a.f7393c.f7102b.f7121b.a(obj.getClass());
                if (a3 != null) {
                    f fVar = new f(a3, obj, this.f7289a.f7399i);
                    this.f7295g = new e(this.f7294f.f7578a, this.f7289a.n);
                    this.f7289a.b().a(this.f7295g, fVar);
                    if (Log.isLoggable(str, 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Finished encoding source to cache, key: ");
                        sb.append(this.f7295g);
                        sb.append(", data: ");
                        sb.append(obj);
                        sb.append(", encoder: ");
                        sb.append(a3);
                        sb.append(", duration: ");
                        sb.append(f.a(a2));
                        Log.v(str, sb.toString());
                    }
                    this.f7294f.f7580c.b();
                    this.f7292d = new d(Collections.singletonList(this.f7294f.f7578a), this.f7289a, this);
                } else {
                    throw new e(obj.getClass());
                }
            } catch (Throwable th) {
                this.f7294f.f7580c.b();
                throw th;
            }
        }
        d dVar = this.f7292d;
        if (dVar != null && dVar.a()) {
            return true;
        }
        this.f7292d = null;
        this.f7294f = null;
        boolean z = false;
        while (!z) {
            if (!(this.f7291c < this.f7289a.c().size())) {
                break;
            }
            List c2 = this.f7289a.c();
            int i2 = this.f7291c;
            this.f7291c = i2 + 1;
            this.f7294f = (n.a) c2.get(i2);
            if (this.f7294f != null && (this.f7289a.p.a(this.f7294f.f7580c.c()) || this.f7289a.c(this.f7294f.f7580c.a()))) {
                this.f7294f.f7580c.a(this.f7289a.o, new a0(this, this.f7294f));
                z = true;
            }
        }
        return z;
    }

    public void b() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        n.a<?> aVar = this.f7294f;
        if (aVar != null) {
            aVar.f7580c.cancel();
        }
    }

    public void a(e.d.a.n.f fVar, Object obj, e.d.a.n.m.d<?> dVar, e.d.a.n.a aVar, e.d.a.n.f fVar2) {
        this.f7290b.a(fVar, obj, dVar, this.f7294f.f7580c.c(), fVar);
    }

    public void a(e.d.a.n.f fVar, Exception exc, e.d.a.n.m.d<?> dVar, e.d.a.n.a aVar) {
        this.f7290b.a(fVar, exc, dVar, this.f7294f.f7580c.c());
    }
}
