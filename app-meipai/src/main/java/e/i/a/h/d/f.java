package e.i.a.h.d;

import android.util.SparseArray;
import e.i.a.c;
import e.i.a.h.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: BreakpointStoreOnCache */
public class f implements g {

    /* renamed from: a reason: collision with root package name */
    public final SparseArray<c> f8718a;

    /* renamed from: b reason: collision with root package name */
    public final HashMap<String, String> f8719b;

    /* renamed from: c reason: collision with root package name */
    public final h f8720c;

    /* renamed from: d reason: collision with root package name */
    public final SparseArray<a> f8721d = new SparseArray<>();

    /* renamed from: e reason: collision with root package name */
    public final List<Integer> f8722e;

    /* renamed from: f reason: collision with root package name */
    public final List<Integer> f8723f;

    public f(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> hashMap) {
        this.f8718a = sparseArray;
        this.f8723f = list;
        this.f8719b = hashMap;
        this.f8720c = new h();
        int size = sparseArray.size();
        this.f8722e = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f8722e.add(Integer.valueOf(((c) sparseArray.valueAt(i2)).f8702a));
        }
        Collections.sort(this.f8722e);
    }

    public void a(c cVar, int i2, long j2) throws IOException {
        c cVar2 = (c) this.f8718a.get(cVar.f8702a);
        if (cVar == cVar2) {
            ((a) cVar2.f8708g.get(i2)).f8697c.addAndGet(j2);
            return;
        }
        throw new IOException("Info not on store!");
    }

    public boolean a() {
        return true;
    }

    public synchronized int b(c cVar) {
        h hVar = this.f8720c;
        Integer num = (Integer) hVar.f8724a.get(hVar.a(cVar));
        if (num == null) {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        int size = this.f8718a.size();
        int i2 = 0;
        while (i2 < size) {
            c cVar2 = (c) this.f8718a.valueAt(i2);
            if (cVar2 == null || !cVar2.a(cVar)) {
                i2++;
            } else {
                return cVar2.f8702a;
            }
        }
        int size2 = this.f8721d.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a aVar = (a) this.f8721d.valueAt(i3);
            if (aVar != null) {
                if (aVar.a(cVar)) {
                    return aVar.b();
                }
            }
        }
        int b2 = b();
        SparseArray<a> sparseArray = this.f8721d;
        if (cVar != null) {
            sparseArray.put(b2, new c.a(b2, cVar));
            h hVar2 = this.f8720c;
            String a2 = hVar2.a(cVar);
            hVar2.f8724a.put(a2, Integer.valueOf(b2));
            hVar2.f8725b.put(b2, a2);
            return b2;
        }
        throw null;
    }

    public c b(int i2) {
        return null;
    }

    public boolean c(int i2) {
        return this.f8723f.contains(Integer.valueOf(i2));
    }

    public void d(int i2) {
    }

    public boolean e(int i2) {
        boolean remove;
        synchronized (this.f8723f) {
            remove = this.f8723f.remove(Integer.valueOf(i2));
        }
        return remove;
    }

    public c get(int i2) {
        return (c) this.f8718a.get(i2);
    }

    public synchronized void remove(int i2) {
        this.f8718a.remove(i2);
        if (this.f8721d.get(i2) == null) {
            this.f8722e.remove(Integer.valueOf(i2));
        }
        h hVar = this.f8720c;
        String str = (String) hVar.f8725b.get(i2);
        if (str != null) {
            hVar.f8724a.remove(str);
            hVar.f8725b.remove(i2);
        }
    }

    public void a(int i2, e.i.a.h.e.a aVar, Exception exc) {
        if (aVar == e.i.a.h.e.a.COMPLETED) {
            remove(i2);
        }
    }

    public boolean a(int i2) {
        if (!this.f8723f.contains(Integer.valueOf(i2))) {
            synchronized (this.f8723f) {
                if (!this.f8723f.contains(Integer.valueOf(i2))) {
                    this.f8723f.add(Integer.valueOf(i2));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(c cVar) {
        String str = cVar.f8707f.f8854a;
        if (cVar.f8709h && str != null) {
            this.f8719b.put(cVar.f8703b, str);
        }
        c cVar2 = (c) this.f8718a.get(cVar.f8702a);
        if (cVar2 == null) {
            return false;
        }
        if (cVar2 == cVar) {
            return true;
        }
        synchronized (this) {
            this.f8718a.put(cVar.f8702a, cVar.a());
        }
        return true;
    }

    public synchronized int b() {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = 1;
            if (i4 >= this.f8722e.size()) {
                i4 = 0;
                break;
            }
            Integer num = (Integer) this.f8722e.get(i4);
            if (num == null) {
                i3 = i5 + 1;
                break;
            }
            int intValue = num.intValue();
            if (i5 != 0) {
                int i6 = i5 + 1;
                if (intValue != i6) {
                    i3 = i6;
                    break;
                }
            } else if (intValue != 1) {
                i4 = 0;
                i3 = 1;
                break;
            }
            i4++;
            i5 = intValue;
        }
        if (i3 != 0) {
            i2 = i3;
        } else if (!this.f8722e.isEmpty()) {
            i2 = 1 + ((Integer) this.f8722e.get(this.f8722e.size() - 1)).intValue();
            i4 = this.f8722e.size();
        }
        this.f8722e.add(i4, Integer.valueOf(i2));
        return i2;
    }

    public c a(c cVar, c cVar2) {
        SparseArray clone;
        synchronized (this) {
            clone = this.f8718a.clone();
        }
        int size = clone.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar3 = (c) clone.valueAt(i2);
            if (cVar3 != cVar2 && cVar3.a(cVar)) {
                return cVar3;
            }
        }
        return null;
    }

    public String a(String str) {
        return (String) this.f8719b.get(str);
    }

    public c a(c cVar) {
        int i2 = cVar.f8649b;
        c cVar2 = new c(i2, cVar.f8650c, cVar.x, cVar.v.f8854a);
        synchronized (this) {
            this.f8718a.put(i2, cVar2);
            this.f8721d.remove(i2);
        }
        return cVar2;
    }
}
