package i.b.b;

import i.b.b.j.h;
import i.b.b.j.h.b;

/* compiled from: Property */
public class f {

    /* renamed from: a reason: collision with root package name */
    public final int f9798a;

    /* renamed from: b reason: collision with root package name */
    public final Class<?> f9799b;

    /* renamed from: c reason: collision with root package name */
    public final String f9800c;

    /* renamed from: d reason: collision with root package name */
    public final boolean f9801d;

    /* renamed from: e reason: collision with root package name */
    public final String f9802e;

    public f(int i2, Class<?> cls, String str, boolean z, String str2) {
        this.f9798a = i2;
        this.f9799b = cls;
        this.f9800c = str;
        this.f9801d = z;
        this.f9802e = str2;
    }

    public h a(Object obj) {
        return new b(this, "=?", obj);
    }

    public h b(Object obj) {
        return new b(this, "<?", obj);
    }
}
