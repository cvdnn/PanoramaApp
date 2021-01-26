package e.d.a.n.n;

import e.d.a.d;
import e.d.a.n.f;
import e.d.a.n.l;
import e.d.a.n.o.n;
import e.d.a.n.o.n.a;
import e.d.a.n.p.b;
import e.d.a.q.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: DecodeHelper */
public final class h<Transcode> {

    /* renamed from: a reason: collision with root package name */
    public final List<a<?>> f7391a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    public final List<f> f7392b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public d f7393c;

    /* renamed from: d reason: collision with root package name */
    public Object f7394d;

    /* renamed from: e reason: collision with root package name */
    public int f7395e;

    /* renamed from: f reason: collision with root package name */
    public int f7396f;

    /* renamed from: g reason: collision with root package name */
    public Class<?> f7397g;

    /* renamed from: h reason: collision with root package name */
    public i.d f7398h;

    /* renamed from: i reason: collision with root package name */
    public e.d.a.n.h f7399i;

    /* renamed from: j reason: collision with root package name */
    public Map<Class<?>, l<?>> f7400j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public f n;
    public e.d.a.f o;
    public k p;
    public boolean q;
    public boolean r;

    public <Data> u<Data, ?, Transcode> a(Class<Data> cls) {
        Class<Data> cls2 = cls;
        e.d.a.h hVar = this.f7393c.f7102b;
        Class<?> cls3 = this.f7397g;
        Class<Transcode> cls4 = this.k;
        u a2 = hVar.f7128i.a(cls2, cls3, cls4);
        if (hVar.f7128i == null) {
            throw null;
        } else if (c.f7842c.equals(a2)) {
            return null;
        } else {
            if (a2 == null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) hVar.f7122c.b(cls2, cls3)).iterator();
                while (it.hasNext()) {
                    Class cls5 = (Class) it.next();
                    Iterator it2 = ((ArrayList) hVar.f7125f.b(cls5, cls4)).iterator();
                    while (it2.hasNext()) {
                        Class cls6 = (Class) it2.next();
                        j jVar = r1;
                        j jVar2 = new j(cls, cls5, cls6, hVar.f7122c.a(cls2, cls5), hVar.f7125f.a(cls5, cls6), hVar.f7129j);
                        arrayList.add(jVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    a2 = null;
                } else {
                    a2 = new u(cls, cls3, cls4, arrayList, hVar.f7129j);
                }
                hVar.f7128i.a(cls2, cls3, cls4, a2);
            }
            return a2;
        }
    }

    public e.d.a.n.n.d0.a b() {
        return ((l.c) this.f7398h).a();
    }

    public boolean c(Class<?> cls) {
        return a(cls) != null;
    }

    public <Z> l<Z> b(Class<Z> cls) {
        l<Z> lVar = (l) this.f7400j.get(cls);
        if (lVar == null) {
            Iterator it = this.f7400j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f7400j.isEmpty() || !this.q) {
            return (b) b.f7655b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing transformation for ");
        sb.append(cls);
        sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(sb.toString());
    }

    public List<a<?>> c() {
        if (!this.l) {
            this.l = true;
            this.f7391a.clear();
            List a2 = this.f7393c.f7102b.a(this.f7394d);
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a a3 = ((n) a2.get(i2)).a(this.f7394d, this.f7395e, this.f7396f, this.f7399i);
                if (a3 != null) {
                    this.f7391a.add(a3);
                }
            }
        }
        return this.f7391a;
    }

    public List<f> a() {
        if (!this.m) {
            this.m = true;
            this.f7392b.clear();
            List c2 = c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) c2.get(i2);
                if (!this.f7392b.contains(aVar.f7578a)) {
                    this.f7392b.add(aVar.f7578a);
                }
                for (int i3 = 0; i3 < aVar.f7579b.size(); i3++) {
                    if (!this.f7392b.contains(aVar.f7579b.get(i3))) {
                        this.f7392b.add(aVar.f7579b.get(i3));
                    }
                }
            }
        }
        return this.f7392b;
    }
}
