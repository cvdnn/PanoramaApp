package g.d0.h;

import g.d0.b;
import g.d0.h.r.a;
import h.e;
import java.io.IOException;

/* compiled from: Http2Connection */
public class j extends b {

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ int f9374b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ e f9375c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ int f9376d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ boolean f9377e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ g f9378f;

    public j(g gVar, String str, Object[] objArr, int i2, e eVar, int i3, boolean z) {
        this.f9378f = gVar;
        this.f9374b = i2;
        this.f9375c = eVar;
        this.f9376d = i3;
        this.f9377e = z;
        super(str, objArr);
    }

    public void a() {
        try {
            r rVar = this.f9378f.f9342j;
            e eVar = this.f9375c;
            int i2 = this.f9376d;
            if (((a) rVar) != null) {
                eVar.skip((long) i2);
                this.f9378f.q.a(this.f9374b, b.CANCEL);
                synchronized (this.f9378f) {
                    this.f9378f.s.remove(Integer.valueOf(this.f9374b));
                }
                return;
            }
            throw null;
        } catch (IOException unused) {
        }
    }
}
