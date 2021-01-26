package e.d.a.t;

import e.a.a.a.a;

/* compiled from: MultiClassKey */
public class i {

    /* renamed from: a reason: collision with root package name */
    public Class<?> f7918a;

    /* renamed from: b reason: collision with root package name */
    public Class<?> f7919b;

    /* renamed from: c reason: collision with root package name */
    public Class<?> f7920c;

    public i() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f7918a.equals(iVar.f7918a) && this.f7919b.equals(iVar.f7919b) && j.b(this.f7920c, iVar.f7920c);
    }

    public int hashCode() {
        int hashCode = (this.f7919b.hashCode() + (this.f7918a.hashCode() * 31)) * 31;
        Class<?> cls = this.f7920c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder a2 = a.a("MultiClassKey{first=");
        a2.append(this.f7918a);
        a2.append(", second=");
        a2.append(this.f7919b);
        a2.append('}');
        return a2.toString();
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f7918a = cls;
        this.f7919b = cls2;
        this.f7920c = cls3;
    }
}
