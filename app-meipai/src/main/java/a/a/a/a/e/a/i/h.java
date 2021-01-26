package a.a.a.a.e.a.i;

import a.a.a.a.e.a.i.f.e;
import a.a.a.a.e.a.j.b;
import a.a.a.a.e.a.j.c;
import a.a.a.a.e.a.j.d;
import a.a.a.a.e.a.j.f;
import a.a.a.a.e.a.j.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class h implements Comparable<h>, Cloneable {

    /* renamed from: a reason: collision with root package name */
    public int f613a;

    /* renamed from: b reason: collision with root package name */
    public a f614b;

    /* renamed from: c reason: collision with root package name */
    public int[] f615c;

    /* renamed from: d reason: collision with root package name */
    public String f616d;

    /* renamed from: e reason: collision with root package name */
    public List<e> f617e;

    /* renamed from: f reason: collision with root package name */
    public String f618f;

    /* renamed from: g reason: collision with root package name */
    public transient b f619g;

    /* renamed from: h reason: collision with root package name */
    public boolean f620h = true;

    /* renamed from: i reason: collision with root package name */
    public boolean f621i = true;

    /* renamed from: j reason: collision with root package name */
    public boolean f622j = false;

    public enum a {
        PIVOTPOINT,
        SMARTTRACK,
        VIEWFINDER
    }

    public h(int i2, a aVar, int[] iArr, String str, List<e> list, b bVar, boolean z, boolean z2, boolean z3) {
        this.f613a = i2;
        this.f614b = aVar;
        this.f615c = iArr;
        this.f616d = str;
        this.f617e = list;
        if (bVar == null) {
            bVar = new a.a.a.a.e.a.j.a();
        }
        this.f619g = bVar;
        this.f618f = bVar.getName();
        this.f620h = z;
        this.f621i = z2;
        this.f622j = z3;
    }

    public e a() {
        if (this.f617e.size() <= 0) {
            return null;
        }
        List<e> list = this.f617e;
        return (e) list.get(list.size() - 1);
    }

    public e b() {
        if (this.f617e.size() > 0) {
            return (e) this.f617e.get(0);
        }
        return null;
    }

    public b c() {
        if (this.f619g == null) {
            int ordinal = c.a(this.f618f).ordinal();
            b bVar = ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? new a.a.a.a.e.a.j.a() : new f() : new g() : new d() : new a.a.a.a.e.a.j.e() : new a.a.a.a.e.a.j.a();
            this.f619g = bVar;
        }
        return this.f619g;
    }

    public h clone() {
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(this.f617e).iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).clone());
        }
        c();
        h hVar = new h(this.f613a, this.f614b, this.f615c, this.f616d, arrayList, this.f619g, this.f620h, this.f621i, this.f622j);
        return hVar;
    }

    public int compareTo(Object obj) {
        h hVar = (h) obj;
        if (hVar == null) {
            return 0;
        }
        return (int) (e() - hVar.e());
    }

    public double e() {
        e b2 = b();
        double d2 = -1.0d;
        double d3 = b2 != null ? b2.f604c : -1.0d;
        e a2 = a();
        if (a2 != null) {
            d2 = a2.f604c;
        }
        return (d3 + d2) / 2.0d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        c();
        hVar.c();
        if (this.f613a != hVar.f613a || this.f614b != hVar.f614b || !Arrays.equals(this.f615c, hVar.f615c) || !Objects.equals(this.f616d, hVar.f616d) || !Objects.equals(this.f617e, hVar.f617e) || !Objects.equals(this.f618f, hVar.f618f) || !Objects.equals(this.f619g, hVar.f619g) || !Objects.equals(Boolean.valueOf(this.f620h), Boolean.valueOf(hVar.f620h)) || !Objects.equals(Boolean.valueOf(this.f621i), Boolean.valueOf(hVar.f621i)) || !Objects.equals(Boolean.valueOf(this.f622j), Boolean.valueOf(hVar.f622j))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        c();
        return Objects.hash(new Object[]{Integer.valueOf(this.f613a), this.f614b, this.f615c, this.f616d, this.f617e, this.f618f, this.f619g, Boolean.valueOf(this.f620h), Boolean.valueOf(this.f621i), Boolean.valueOf(this.f622j)});
    }
}
