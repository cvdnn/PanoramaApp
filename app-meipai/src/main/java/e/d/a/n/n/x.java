package e.d.a.n.n;

import e.d.a.h;
import e.d.a.n.f;
import e.d.a.n.l;
import e.d.a.n.m.d.a;
import e.d.a.n.o.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ResourceCacheGenerator */
public class x implements g, a<Object> {

    /* renamed from: a reason: collision with root package name */
    public final g.a f7515a;

    /* renamed from: b reason: collision with root package name */
    public final h<?> f7516b;

    /* renamed from: c reason: collision with root package name */
    public int f7517c;

    /* renamed from: d reason: collision with root package name */
    public int f7518d = -1;

    /* renamed from: e reason: collision with root package name */
    public f f7519e;

    /* renamed from: f reason: collision with root package name */
    public List<n<File, ?>> f7520f;

    /* renamed from: g reason: collision with root package name */
    public int f7521g;

    /* renamed from: h reason: collision with root package name */
    public volatile n.a<?> f7522h;

    /* renamed from: i reason: collision with root package name */
    public File f7523i;

    /* renamed from: j reason: collision with root package name */
    public y f7524j;

    public x(h<?> hVar, g.a aVar) {
        this.f7516b = hVar;
        this.f7515a = aVar;
    }

    public boolean a() {
        List a2 = this.f7516b.a();
        if (a2.isEmpty()) {
            return false;
        }
        h<?> hVar = this.f7516b;
        h hVar2 = hVar.f7393c.f7102b;
        Class cls = hVar.f7394d.getClass();
        Class<?> cls2 = hVar.f7397g;
        Class<Transcode> cls3 = hVar.k;
        List a3 = hVar2.f7127h.a(cls, cls2, cls3);
        if (a3 == 0) {
            ArrayList arrayList = new ArrayList();
            for (Class b2 : hVar2.f7120a.a(cls)) {
                Iterator it = ((ArrayList) hVar2.f7122c.b(b2, cls2)).iterator();
                while (it.hasNext()) {
                    Class cls4 = (Class) it.next();
                    if (!((ArrayList) hVar2.f7125f.b(cls4, cls3)).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            hVar2.f7127h.a(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            a3 = arrayList;
        }
        if (!a3.isEmpty()) {
            while (true) {
                List<n<File, ?>> list = this.f7520f;
                if (list != null) {
                    if (this.f7521g < list.size()) {
                        this.f7522h = null;
                        boolean z = false;
                        while (!z) {
                            if (!(this.f7521g < this.f7520f.size())) {
                                break;
                            }
                            List<n<File, ?>> list2 = this.f7520f;
                            int i2 = this.f7521g;
                            this.f7521g = i2 + 1;
                            n nVar = (n) list2.get(i2);
                            File file = this.f7523i;
                            h<?> hVar3 = this.f7516b;
                            this.f7522h = nVar.a(file, hVar3.f7395e, hVar3.f7396f, hVar3.f7399i);
                            if (this.f7522h != null && this.f7516b.c(this.f7522h.f7580c.a())) {
                                this.f7522h.f7580c.a(this.f7516b.o, this);
                                z = true;
                            }
                        }
                        return z;
                    }
                }
                int i3 = this.f7518d + 1;
                this.f7518d = i3;
                if (i3 >= a3.size()) {
                    int i4 = this.f7517c + 1;
                    this.f7517c = i4;
                    if (i4 >= a2.size()) {
                        return false;
                    }
                    this.f7518d = 0;
                }
                f fVar = (f) a2.get(this.f7517c);
                Class cls5 = (Class) a3.get(this.f7518d);
                l b3 = this.f7516b.b(cls5);
                h<?> hVar4 = this.f7516b;
                y yVar = new y(hVar4.f7393c.f7101a, fVar, hVar4.n, hVar4.f7395e, hVar4.f7396f, b3, cls5, hVar4.f7399i);
                this.f7524j = yVar;
                File a4 = this.f7516b.b().a(this.f7524j);
                this.f7523i = a4;
                if (a4 != null) {
                    this.f7519e = fVar;
                    this.f7520f = this.f7516b.f7393c.f7102b.a(a4);
                    this.f7521g = 0;
                }
            }
        } else if (File.class.equals(this.f7516b.k)) {
            return false;
        } else {
            StringBuilder a5 = e.a.a.a.a.a("Failed to find any load path from ");
            a5.append(this.f7516b.f7394d.getClass());
            a5.append(" to ");
            a5.append(this.f7516b.k);
            throw new IllegalStateException(a5.toString());
        }
    }

    public void cancel() {
        n.a<?> aVar = this.f7522h;
        if (aVar != null) {
            aVar.f7580c.cancel();
        }
    }

    public void a(Object obj) {
        this.f7515a.a(this.f7519e, obj, this.f7522h.f7580c, e.d.a.n.a.RESOURCE_DISK_CACHE, this.f7524j);
    }

    public void a(Exception exc) {
        this.f7515a.a(this.f7524j, exc, this.f7522h.f7580c, e.d.a.n.a.RESOURCE_DISK_CACHE);
    }
}
