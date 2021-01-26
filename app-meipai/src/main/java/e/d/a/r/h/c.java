package e.d.a.r.h;

import android.graphics.drawable.Drawable;
import e.d.a.r.b;
import e.d.a.t.j;

/* compiled from: CustomTarget */
public abstract class c<T> implements h<T> {

    /* renamed from: a reason: collision with root package name */
    public final int f7882a;

    /* renamed from: b reason: collision with root package name */
    public final int f7883b;

    /* renamed from: c reason: collision with root package name */
    public b f7884c;

    public c() {
        if (j.a(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.f7882a = Integer.MIN_VALUE;
            this.f7883b = Integer.MIN_VALUE;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(Integer.MIN_VALUE);
        sb.append(" and height: ");
        sb.append(Integer.MIN_VALUE);
        throw new IllegalArgumentException(sb.toString());
    }

    public void a() {
    }

    public void a(Drawable drawable) {
    }

    public final void a(b bVar) {
        this.f7884c = bVar;
    }

    public final void a(g gVar) {
    }

    public void b() {
    }

    public void b(Drawable drawable) {
    }

    public final void b(g gVar) {
        gVar.a(this.f7882a, this.f7883b);
    }

    public final b c() {
        return this.f7884c;
    }

    public void onStart() {
    }
}
