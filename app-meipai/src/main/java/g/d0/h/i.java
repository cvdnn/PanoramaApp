package g.d0.h;

import g.d0.b;
import g.d0.h.r.a;
import java.io.IOException;
import java.util.List;

/* compiled from: Http2Connection */
public class i extends b {

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ int f9370b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ List f9371c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ boolean f9372d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ g f9373e;

    public i(g gVar, String str, Object[] objArr, int i2, List list, boolean z) {
        this.f9373e = gVar;
        this.f9370b = i2;
        this.f9371c = list;
        this.f9372d = z;
        super(str, objArr);
    }

    public void a() {
        g gVar = this.f9373e;
        r rVar = gVar.f9342j;
        int i2 = this.f9370b;
        if (((a) rVar) != null) {
            try {
                gVar.q.a(i2, b.CANCEL);
                synchronized (this.f9373e) {
                    this.f9373e.s.remove(Integer.valueOf(this.f9370b));
                }
            } catch (IOException unused) {
            }
        } else {
            throw null;
        }
    }
}
