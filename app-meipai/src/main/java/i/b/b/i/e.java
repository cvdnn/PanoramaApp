package i.b.b.i;

import i.b.b.g.a;
import i.b.b.g.d;

/* compiled from: TableStatements */
public class e {

    /* renamed from: a reason: collision with root package name */
    public final a f9832a;

    /* renamed from: b reason: collision with root package name */
    public final String f9833b;

    /* renamed from: c reason: collision with root package name */
    public final String[] f9834c;

    /* renamed from: d reason: collision with root package name */
    public final String[] f9835d;

    /* renamed from: e reason: collision with root package name */
    public d f9836e;

    /* renamed from: f reason: collision with root package name */
    public d f9837f;

    /* renamed from: g reason: collision with root package name */
    public d f9838g;

    public e(a aVar, String str, String[] strArr, String[] strArr2) {
        this.f9832a = aVar;
        this.f9833b = str;
        this.f9834c = strArr;
        this.f9835d = strArr2;
    }

    public d a() {
        if (this.f9838g == null) {
            d b2 = this.f9832a.b(d.a(this.f9833b, this.f9835d));
            synchronized (this) {
                if (this.f9838g == null) {
                    this.f9838g = b2;
                }
            }
            if (this.f9838g != b2) {
                b2.f9804a.close();
            }
        }
        return this.f9838g;
    }

    public d b() {
        if (this.f9836e == null) {
            d b2 = this.f9832a.b(d.a("INSERT OR REPLACE INTO ", this.f9833b, this.f9834c));
            synchronized (this) {
                if (this.f9836e == null) {
                    this.f9836e = b2;
                }
            }
            if (this.f9836e != b2) {
                b2.f9804a.close();
            }
        }
        return this.f9836e;
    }

    public d c() {
        if (this.f9837f == null) {
            d b2 = this.f9832a.b(d.a(this.f9833b, this.f9834c, this.f9835d));
            synchronized (this) {
                if (this.f9837f == null) {
                    this.f9837f = b2;
                }
            }
            if (this.f9837f != b2) {
                b2.f9804a.close();
            }
        }
        return this.f9837f;
    }
}
