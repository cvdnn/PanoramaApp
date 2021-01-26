package e.d.a.n.n;

import d.h.j.c;
import e.a.a.a.a;
import e.c.f.n.n;
import e.d.a.n.h;
import e.d.a.n.m.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath */
public class u<Data, ResourceType, Transcode> {

    /* renamed from: a reason: collision with root package name */
    public final c<List<Throwable>> f7507a;

    /* renamed from: b reason: collision with root package name */
    public final List<? extends j<Data, ResourceType, Transcode>> f7508b;

    /* renamed from: c reason: collision with root package name */
    public final String f7509c;

    public u(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<j<Data, ResourceType, Transcode>> list, c<List<Throwable>> cVar) {
        this.f7507a = cVar;
        if (!list.isEmpty()) {
            this.f7508b = list;
            StringBuilder a2 = a.a("Failed LoadPath{");
            a2.append(cls.getSimpleName());
            String str = "->";
            a2.append(str);
            a2.append(cls2.getSimpleName());
            a2.append(str);
            a2.append(cls3.getSimpleName());
            a2.append("}");
            this.f7509c = a2.toString();
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public w<Transcode> a(e<Data> eVar, h hVar, int i2, int i3, j.a<ResourceType> aVar) throws r {
        w<Transcode> wVar;
        Object a2 = this.f7507a.a();
        n.a(a2, "Argument must not be null");
        List list = (List) a2;
        try {
            int size = this.f7508b.size();
            wVar = null;
            for (int i4 = 0; i4 < size; i4++) {
                wVar = ((j) this.f7508b.get(i4)).a(eVar, i2, i3, hVar, aVar);
                if (wVar != null) {
                    break;
                }
            }
        } catch (r e2) {
            list.add(e2);
        } catch (Throwable th) {
            this.f7507a.a(list);
            throw th;
        }
        if (wVar != null) {
            this.f7507a.a(list);
            return wVar;
        }
        throw new r(this.f7509c, (List<Throwable>) new ArrayList<Throwable>(list));
    }

    public String toString() {
        StringBuilder a2 = a.a("LoadPath{decodePaths=");
        a2.append(Arrays.toString(this.f7508b.toArray()));
        a2.append('}');
        return a2.toString();
    }
}
