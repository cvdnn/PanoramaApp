package e.d.a.n.n;

import e.d.a.n.f;
import e.d.a.n.m.d.a;
import e.d.a.n.o.n;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator */
public class d implements g, a<Object> {

    /* renamed from: a reason: collision with root package name */
    public final List<f> f7334a;

    /* renamed from: b reason: collision with root package name */
    public final h<?> f7335b;

    /* renamed from: c reason: collision with root package name */
    public final g.a f7336c;

    /* renamed from: d reason: collision with root package name */
    public int f7337d = -1;

    /* renamed from: e reason: collision with root package name */
    public f f7338e;

    /* renamed from: f reason: collision with root package name */
    public List<n<File, ?>> f7339f;

    /* renamed from: g reason: collision with root package name */
    public int f7340g;

    /* renamed from: h reason: collision with root package name */
    public volatile n.a<?> f7341h;

    /* renamed from: i reason: collision with root package name */
    public File f7342i;

    public d(h<?> hVar, g.a aVar) {
        List<f> a2 = hVar.a();
        this.f7334a = a2;
        this.f7335b = hVar;
        this.f7336c = aVar;
    }

    public boolean a() {
        while (true) {
            List<n<File, ?>> list = this.f7339f;
            if (list != null) {
                if (this.f7340g < list.size()) {
                    this.f7341h = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.f7340g < this.f7339f.size())) {
                            break;
                        }
                        List<n<File, ?>> list2 = this.f7339f;
                        int i2 = this.f7340g;
                        this.f7340g = i2 + 1;
                        n nVar = (n) list2.get(i2);
                        File file = this.f7342i;
                        h<?> hVar = this.f7335b;
                        this.f7341h = nVar.a(file, hVar.f7395e, hVar.f7396f, hVar.f7399i);
                        if (this.f7341h != null && this.f7335b.c(this.f7341h.f7580c.a())) {
                            this.f7341h.f7580c.a(this.f7335b.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i3 = this.f7337d + 1;
            this.f7337d = i3;
            if (i3 >= this.f7334a.size()) {
                return false;
            }
            f fVar = (f) this.f7334a.get(this.f7337d);
            File a2 = this.f7335b.b().a(new e(fVar, this.f7335b.n));
            this.f7342i = a2;
            if (a2 != null) {
                this.f7338e = fVar;
                this.f7339f = this.f7335b.f7393c.f7102b.a(a2);
                this.f7340g = 0;
            }
        }
    }

    public void cancel() {
        n.a<?> aVar = this.f7341h;
        if (aVar != null) {
            aVar.f7580c.cancel();
        }
    }

    public d(List<f> list, h<?> hVar, g.a aVar) {
        this.f7334a = list;
        this.f7335b = hVar;
        this.f7336c = aVar;
    }

    public void a(Object obj) {
        this.f7336c.a(this.f7338e, obj, this.f7341h.f7580c, e.d.a.n.a.DATA_DISK_CACHE, this.f7338e);
    }

    public void a(Exception exc) {
        this.f7336c.a(this.f7338e, exc, this.f7341h.f7580c, e.d.a.n.a.DATA_DISK_CACHE);
    }
}
