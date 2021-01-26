package g.d0.e;

import com.tencent.connect.common.Constants;
import g.d0.f.f;
import g.s;
import g.u;
import g.x;
import g.z;
import java.io.IOException;

/* compiled from: ConnectInterceptor */
public final class a implements s {

    /* renamed from: a reason: collision with root package name */
    public final u f9193a;

    public a(u uVar) {
        this.f9193a = uVar;
    }

    public z intercept(g.s.a aVar) throws IOException {
        f fVar = (f) aVar;
        x xVar = fVar.f9242f;
        g gVar = fVar.f9238b;
        return fVar.a(xVar, gVar, gVar.a(this.f9193a, aVar, !xVar.f9596b.equals(Constants.HTTP_GET)), gVar.c());
    }
}
