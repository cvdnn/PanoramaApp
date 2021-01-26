package e.g.a.a.b0;

import android.graphics.Typeface;
import e.g.a.a.z.b;

/* compiled from: CancelableFontCallback */
public final class a extends d {

    /* renamed from: a reason: collision with root package name */
    public final Typeface f8037a;

    /* renamed from: b reason: collision with root package name */
    public final C0106a f8038b;

    /* renamed from: c reason: collision with root package name */
    public boolean f8039c;

    /* renamed from: e.g.a.a.b0.a$a reason: collision with other inner class name */
    /* compiled from: CancelableFontCallback */
    public interface C0106a {
    }

    public a(C0106a aVar, Typeface typeface) {
        this.f8037a = typeface;
        this.f8038b = aVar;
    }

    public void a(Typeface typeface, boolean z) {
        a(typeface);
    }

    public void a(int i2) {
        a(this.f8037a);
    }

    public final void a(Typeface typeface) {
        if (!this.f8039c) {
            b bVar = ((e.g.a.a.z.a) this.f8038b).f8432a;
            a aVar = bVar.v;
            boolean z = true;
            if (aVar != null) {
                aVar.f8039c = true;
            }
            if (bVar.s != typeface) {
                bVar.s = typeface;
            } else {
                z = false;
            }
            if (z) {
                bVar.e();
            }
        }
    }
}
