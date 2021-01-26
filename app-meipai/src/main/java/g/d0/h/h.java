package g.d0.h;

import g.d0.b;
import java.io.IOException;

/* compiled from: Http2Connection */
public class h extends b {

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ boolean f9365b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ int f9366c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ int f9367d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ q f9368e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ g f9369f;

    public h(g gVar, String str, Object[] objArr, boolean z, int i2, int i3, q qVar) {
        this.f9369f = gVar;
        this.f9365b = z;
        this.f9366c = i2;
        this.f9367d = i3;
        this.f9368e = qVar;
        super(str, objArr);
    }

    public void a() {
        try {
            this.f9369f.a(this.f9365b, this.f9366c, this.f9367d, this.f9368e);
        } catch (IOException unused) {
        }
    }
}
