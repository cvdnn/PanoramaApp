package e.d.a.n.n;

import e.a.a.a.a;
import e.d.a.n.f;
import e.d.a.n.h;
import e.d.a.n.l;
import e.d.a.n.n.c0.b;
import e.d.a.t.g;
import e.d.a.t.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey */
public final class y implements f {

    /* renamed from: j reason: collision with root package name */
    public static final g<Class<?>, byte[]> f7525j = new g<>(50);

    /* renamed from: b reason: collision with root package name */
    public final b f7526b;

    /* renamed from: c reason: collision with root package name */
    public final f f7527c;

    /* renamed from: d reason: collision with root package name */
    public final f f7528d;

    /* renamed from: e reason: collision with root package name */
    public final int f7529e;

    /* renamed from: f reason: collision with root package name */
    public final int f7530f;

    /* renamed from: g reason: collision with root package name */
    public final Class<?> f7531g;

    /* renamed from: h reason: collision with root package name */
    public final h f7532h;

    /* renamed from: i reason: collision with root package name */
    public final l<?> f7533i;

    public y(b bVar, f fVar, f fVar2, int i2, int i3, l<?> lVar, Class<?> cls, h hVar) {
        this.f7526b = bVar;
        this.f7527c = fVar;
        this.f7528d = fVar2;
        this.f7529e = i2;
        this.f7530f = i3;
        this.f7533i = lVar;
        this.f7531g = cls;
        this.f7532h = hVar;
    }

    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f7526b.a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f7529e).putInt(this.f7530f).array();
        this.f7528d.a(messageDigest);
        this.f7527c.a(messageDigest);
        messageDigest.update(bArr);
        l<?> lVar = this.f7533i;
        if (lVar != null) {
            lVar.a(messageDigest);
        }
        this.f7532h.a(messageDigest);
        byte[] bArr2 = (byte[]) f7525j.a(this.f7531g);
        if (bArr2 == null) {
            bArr2 = this.f7531g.getName().getBytes(f.f7225a);
            f7525j.b(this.f7531g, bArr2);
        }
        messageDigest.update(bArr2);
        this.f7526b.a(bArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (this.f7530f != yVar.f7530f || this.f7529e != yVar.f7529e || !j.b(this.f7533i, yVar.f7533i) || !this.f7531g.equals(yVar.f7531g) || !this.f7527c.equals(yVar.f7527c) || !this.f7528d.equals(yVar.f7528d) || !this.f7532h.equals(yVar.f7532h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((((this.f7528d.hashCode() + (this.f7527c.hashCode() * 31)) * 31) + this.f7529e) * 31) + this.f7530f;
        l<?> lVar = this.f7533i;
        if (lVar != null) {
            hashCode = (hashCode * 31) + lVar.hashCode();
        }
        return this.f7532h.hashCode() + ((this.f7531g.hashCode() + (hashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder a2 = a.a("ResourceCacheKey{sourceKey=");
        a2.append(this.f7527c);
        a2.append(", signature=");
        a2.append(this.f7528d);
        a2.append(", width=");
        a2.append(this.f7529e);
        a2.append(", height=");
        a2.append(this.f7530f);
        a2.append(", decodedResourceClass=");
        a2.append(this.f7531g);
        a2.append(", transformation='");
        a2.append(this.f7533i);
        a2.append('\'');
        a2.append(", options=");
        a2.append(this.f7532h);
        a2.append('}');
        return a2.toString();
    }
}
