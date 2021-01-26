package e.c.d.l.b.c;

import com.baidubce.http.Headers;
import e.c.d.d.c.e;
import g.d0.f.f;
import g.s;
import g.s.a;
import g.x;
import g.z;
import java.io.IOException;
import java.util.Date;

/* compiled from: TransferInterceptor */
public class b implements s {
    public z intercept(a aVar) throws IOException {
        String str;
        if (e.f6006d.a() != null) {
            StringBuilder a2 = e.a.a.a.a.a("BDUSS=");
            a2.append(e.f6006d.a().bduss);
            str = a2.toString();
        } else {
            str = "";
        }
        x xVar = ((f) aVar).f9242f;
        if (xVar != null) {
            x.a aVar2 = new x.a(xVar);
            aVar2.a(Headers.ACCEPT_ENCODING, "gzip,deflate");
            aVar2.a("Charset", "UTF-8");
            aVar2.a("X_baiduvr_orign", "baidu");
            aVar2.a("X_baiduvr_timestamp", String.valueOf(new Date().getTime()));
            aVar2.a(com.baidu.pass.http.b.f1949d, str);
            return ((f) aVar).a(aVar2.a());
        }
        throw null;
    }
}
