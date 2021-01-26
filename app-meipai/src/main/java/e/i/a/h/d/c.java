package e.i.a.h.d;

import e.i.a.h.h.g.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BreakpointInfo */
public class c {

    /* renamed from: a reason: collision with root package name */
    public final int f8702a;

    /* renamed from: b reason: collision with root package name */
    public final String f8703b;

    /* renamed from: c reason: collision with root package name */
    public String f8704c;

    /* renamed from: d reason: collision with root package name */
    public final File f8705d;

    /* renamed from: e reason: collision with root package name */
    public File f8706e;

    /* renamed from: f reason: collision with root package name */
    public final a f8707f;

    /* renamed from: g reason: collision with root package name */
    public final List<a> f8708g = new ArrayList();

    /* renamed from: h reason: collision with root package name */
    public final boolean f8709h;

    /* renamed from: i reason: collision with root package name */
    public boolean f8710i;

    public c(int i2, String str, File file, String str2) {
        this.f8702a = i2;
        this.f8703b = str;
        this.f8705d = file;
        if (e.i.a.h.c.a((CharSequence) str2)) {
            this.f8707f = new a();
            this.f8709h = true;
            return;
        }
        this.f8707f = new a(str2);
        this.f8709h = false;
        this.f8706e = new File(file, str2);
    }

    public a a(int i2) {
        return (a) this.f8708g.get(i2);
    }

    public int b() {
        return this.f8708g.size();
    }

    public File c() {
        String str = this.f8707f.f8854a;
        if (str == null) {
            return null;
        }
        if (this.f8706e == null) {
            this.f8706e = new File(this.f8705d, str);
        }
        return this.f8706e;
    }

    public long d() {
        if (this.f8710i) {
            return e();
        }
        long j2 = 0;
        Object[] array = this.f8708g.toArray();
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    j2 += ((a) obj).f8696b;
                }
            }
        }
        return j2;
    }

    public long e() {
        Object[] array = this.f8708g.toArray();
        long j2 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    j2 += ((a) obj).a();
                }
            }
        }
        return j2;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("id[");
        a2.append(this.f8702a);
        String str = "]";
        a2.append(str);
        a2.append(" url[");
        a2.append(this.f8703b);
        a2.append(str);
        a2.append(" etag[");
        a2.append(this.f8704c);
        a2.append(str);
        a2.append(" taskOnlyProvidedParentPath[");
        a2.append(this.f8709h);
        a2.append(str);
        a2.append(" parent path[");
        a2.append(this.f8705d);
        a2.append(str);
        a2.append(" filename[");
        a2.append(this.f8707f.f8854a);
        a2.append(str);
        a2.append(" block(s):");
        a2.append(this.f8708g.toString());
        return a2.toString();
    }

    public c a() {
        c cVar = new c(this.f8702a, this.f8703b, this.f8705d, this.f8707f.f8854a, this.f8709h);
        cVar.f8710i = this.f8710i;
        for (a aVar : this.f8708g) {
            List<a> list = cVar.f8708g;
            a aVar2 = new a(aVar.f8695a, aVar.f8696b, aVar.f8697c.get());
            list.add(aVar2);
        }
        return cVar;
    }

    public boolean a(e.i.a.c cVar) {
        boolean z = false;
        if (!this.f8705d.equals(cVar.x) || !this.f8703b.equals(cVar.f8650c)) {
            return false;
        }
        String str = cVar.v.f8854a;
        if (str != null && str.equals(this.f8707f.f8854a)) {
            return true;
        }
        if (this.f8709h) {
            if (!cVar.u) {
                return false;
            }
            if (str == null || str.equals(this.f8707f.f8854a)) {
                z = true;
            }
        }
        return z;
    }

    public c(int i2, String str, File file, String str2, boolean z) {
        this.f8702a = i2;
        this.f8703b = str;
        this.f8705d = file;
        if (e.i.a.h.c.a((CharSequence) str2)) {
            this.f8707f = new a();
        } else {
            this.f8707f = new a(str2);
        }
        this.f8709h = z;
    }
}
