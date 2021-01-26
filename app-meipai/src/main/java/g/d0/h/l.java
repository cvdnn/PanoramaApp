package g.d0.h;

import g.d0.b;
import g.d0.h.g.f;
import java.io.IOException;

/* compiled from: Http2Connection */
public class l extends b {

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ s f9382b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ f f9383c;

    public l(f fVar, String str, Object[] objArr, s sVar) {
        this.f9383c = fVar;
        this.f9382b = sVar;
        super(str, objArr);
    }

    public void a() {
        try {
            g.this.q.a(this.f9382b);
        } catch (IOException unused) {
        }
    }
}
