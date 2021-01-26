package e.d.a.n.p.g;

import e.d.a.m.a.C0079a;
import e.d.a.n.n.c0.d;

/* compiled from: GifBitmapProvider */
public final class b implements C0079a {

    /* renamed from: a reason: collision with root package name */
    public final d f7756a;

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.n.n.c0.b f7757b;

    public b(d dVar, e.d.a.n.n.c0.b bVar) {
        this.f7756a = dVar;
        this.f7757b = bVar;
    }

    public byte[] a(int i2) {
        e.d.a.n.n.c0.b bVar = this.f7757b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.b(i2, byte[].class);
    }
}
