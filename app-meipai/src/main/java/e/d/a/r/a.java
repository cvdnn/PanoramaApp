package e.d.a.r;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidubce.auth.NTLMEngineImpl;
import e.c.f.n.n;
import e.d.a.f;
import e.d.a.n.g;
import e.d.a.n.h;
import e.d.a.n.l;
import e.d.a.n.n.k;
import e.d.a.n.p.c.o;
import e.d.a.n.p.g.c;
import e.d.a.r.a;
import e.d.a.t.b;
import e.d.a.t.j;
import java.util.Map;

/* compiled from: BaseRequestOptions */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    public int f7855a;

    /* renamed from: b reason: collision with root package name */
    public float f7856b = 1.0f;

    /* renamed from: c reason: collision with root package name */
    public k f7857c = k.f7437c;

    /* renamed from: d reason: collision with root package name */
    public f f7858d = f.NORMAL;

    /* renamed from: e reason: collision with root package name */
    public Drawable f7859e;

    /* renamed from: f reason: collision with root package name */
    public int f7860f;

    /* renamed from: g reason: collision with root package name */
    public Drawable f7861g;

    /* renamed from: h reason: collision with root package name */
    public int f7862h;

    /* renamed from: i reason: collision with root package name */
    public boolean f7863i = true;

    /* renamed from: j reason: collision with root package name */
    public int f7864j = -1;
    public int k = -1;
    public e.d.a.n.f l = e.d.a.s.a.f7896b;
    public boolean m;
    public boolean n = true;
    public Drawable o;
    public int p;
    public h q = new h();
    public Map<Class<?>, l<?>> r = new b();
    public Class<?> s = Object.class;
    public boolean t;
    public Theme u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public boolean z;

    public static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public T a(k kVar) {
        if (this.v) {
            return clone().a(kVar);
        }
        n.a(kVar, "Argument must not be null");
        this.f7857c = kVar;
        this.f7855a |= 4;
        a();
        return this;
    }

    public T b(boolean z2) {
        if (this.v) {
            return clone().b(z2);
        }
        this.z = z2;
        this.f7855a |= 1048576;
        a();
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.f7856b, this.f7856b) == 0 && this.f7860f == aVar.f7860f && j.b(this.f7859e, aVar.f7859e) && this.f7862h == aVar.f7862h && j.b(this.f7861g, aVar.f7861g) && this.p == aVar.p && j.b(this.o, aVar.o) && this.f7863i == aVar.f7863i && this.f7864j == aVar.f7864j && this.k == aVar.k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.f7857c.equals(aVar.f7857c) && this.f7858d == aVar.f7858d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && j.b(this.l, aVar.l) && j.b(this.u, aVar.u)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return j.a((Object) this.u, j.a((Object) this.l, j.a((Object) this.s, j.a((Object) this.r, j.a((Object) this.q, j.a((Object) this.f7858d, j.a((Object) this.f7857c, (((((((((((((j.a((Object) this.o, (j.a((Object) this.f7861g, (j.a((Object) this.f7859e, (j.a(this.f7856b) * 31) + this.f7860f) * 31) + this.f7862h) * 31) + this.p) * 31) + (this.f7863i ? 1 : 0)) * 31) + this.f7864j) * 31) + this.k) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0))))))));
    }

    public T clone() {
        try {
            T t2 = (a) super.clone();
            h hVar = new h();
            t2.q = hVar;
            hVar.a(this.q);
            b bVar = new b();
            t2.r = bVar;
            bVar.putAll(this.r);
            t2.t = false;
            t2.v = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final T b(e.d.a.n.p.c.l lVar, l<Bitmap> lVar2) {
        if (this.v) {
            return clone().b(lVar, lVar2);
        }
        g<e.d.a.n.p.c.l> gVar = e.d.a.n.p.c.l.f7690f;
        n.a(lVar, "Argument must not be null");
        a(gVar, (Y) lVar);
        return a(lVar2, true);
    }

    public T a(f fVar) {
        if (this.v) {
            return clone().a(fVar);
        }
        n.a(fVar, "Argument must not be null");
        this.f7858d = fVar;
        this.f7855a |= 8;
        a();
        return this;
    }

    public T a(Drawable drawable) {
        if (this.v) {
            return clone().a(drawable);
        }
        this.f7861g = drawable;
        int i2 = this.f7855a | 64;
        this.f7855a = i2;
        this.f7862h = 0;
        this.f7855a = i2 & -129;
        a();
        return this;
    }

    public T a(boolean z2) {
        if (this.v) {
            return clone().a(true);
        }
        this.f7863i = !z2;
        this.f7855a |= 256;
        a();
        return this;
    }

    public T a(int i2, int i3) {
        if (this.v) {
            return clone().a(i2, i3);
        }
        this.k = i2;
        this.f7864j = i3;
        this.f7855a |= 512;
        a();
        return this;
    }

    public T a(e.d.a.n.f fVar) {
        if (this.v) {
            return clone().a(fVar);
        }
        n.a(fVar, "Argument must not be null");
        this.l = fVar;
        this.f7855a |= 1024;
        a();
        return this;
    }

    public <Y> T a(g<Y> gVar, Y y2) {
        if (this.v) {
            return clone().a(gVar, y2);
        }
        String str = "Argument must not be null";
        n.a(gVar, str);
        n.a(y2, str);
        this.q.f7231b.put(gVar, y2);
        a();
        return this;
    }

    public T a(Class<?> cls) {
        if (this.v) {
            return clone().a(cls);
        }
        n.a(cls, "Argument must not be null");
        this.s = cls;
        this.f7855a |= 4096;
        a();
        return this;
    }

    public final T a(e.d.a.n.p.c.l lVar, l<Bitmap> lVar2) {
        if (this.v) {
            return clone().a(lVar, lVar2);
        }
        g<e.d.a.n.p.c.l> gVar = e.d.a.n.p.c.l.f7690f;
        n.a(lVar, "Argument must not be null");
        a(gVar, (Y) lVar);
        return a(lVar2, false);
    }

    public T a(l<Bitmap> lVar, boolean z2) {
        if (this.v) {
            return clone().a(lVar, z2);
        }
        o oVar = new o(lVar, z2);
        a(Bitmap.class, lVar, z2);
        a(Drawable.class, oVar, z2);
        a(BitmapDrawable.class, oVar, z2);
        a(c.class, new e.d.a.n.p.g.f(lVar), z2);
        a();
        return this;
    }

    public <Y> T a(Class<Y> cls, l<Y> lVar, boolean z2) {
        if (this.v) {
            return clone().a(cls, lVar, z2);
        }
        String str = "Argument must not be null";
        n.a(cls, str);
        n.a(lVar, str);
        this.r.put(cls, lVar);
        int i2 = this.f7855a | 2048;
        this.f7855a = i2;
        this.n = true;
        int i3 = i2 | 65536;
        this.f7855a = i3;
        this.y = false;
        if (z2) {
            this.f7855a = i3 | 131072;
            this.m = true;
        }
        a();
        return this;
    }

    public T a(a<?> aVar) {
        if (this.v) {
            return clone().a(aVar);
        }
        if (b(aVar.f7855a, 2)) {
            this.f7856b = aVar.f7856b;
        }
        if (b(aVar.f7855a, 262144)) {
            this.w = aVar.w;
        }
        if (b(aVar.f7855a, 1048576)) {
            this.z = aVar.z;
        }
        if (b(aVar.f7855a, 4)) {
            this.f7857c = aVar.f7857c;
        }
        if (b(aVar.f7855a, 8)) {
            this.f7858d = aVar.f7858d;
        }
        if (b(aVar.f7855a, 16)) {
            this.f7859e = aVar.f7859e;
            this.f7860f = 0;
            this.f7855a &= -33;
        }
        if (b(aVar.f7855a, 32)) {
            this.f7860f = aVar.f7860f;
            this.f7859e = null;
            this.f7855a &= -17;
        }
        if (b(aVar.f7855a, 64)) {
            this.f7861g = aVar.f7861g;
            this.f7862h = 0;
            this.f7855a &= -129;
        }
        if (b(aVar.f7855a, 128)) {
            this.f7862h = aVar.f7862h;
            this.f7861g = null;
            this.f7855a &= -65;
        }
        if (b(aVar.f7855a, 256)) {
            this.f7863i = aVar.f7863i;
        }
        if (b(aVar.f7855a, 512)) {
            this.k = aVar.k;
            this.f7864j = aVar.f7864j;
        }
        if (b(aVar.f7855a, 1024)) {
            this.l = aVar.l;
        }
        if (b(aVar.f7855a, 4096)) {
            this.s = aVar.s;
        }
        if (b(aVar.f7855a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.f7855a &= -16385;
        }
        if (b(aVar.f7855a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.f7855a &= -8193;
        }
        if (b(aVar.f7855a, 32768)) {
            this.u = aVar.u;
        }
        if (b(aVar.f7855a, 65536)) {
            this.n = aVar.n;
        }
        if (b(aVar.f7855a, 131072)) {
            this.m = aVar.m;
        }
        if (b(aVar.f7855a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (b(aVar.f7855a, (int) NTLMEngineImpl.FLAG_REQUEST_NTLM2_SESSION)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            int i2 = this.f7855a & -2049;
            this.f7855a = i2;
            this.m = false;
            this.f7855a = i2 & -131073;
            this.y = true;
        }
        this.f7855a |= aVar.f7855a;
        this.q.a(aVar.q);
        a();
        return this;
    }

    public final T a() {
        if (!this.t) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }
}
