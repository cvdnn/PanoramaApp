package g.d0.f;

import com.baidu.pass.http.b;
import com.baidubce.http.Headers;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.facebook.stetho.websocket.WebSocketHandler;
import g.d0.c;
import g.j;
import g.k;
import g.q;
import g.s;
import g.t;
import g.x;
import g.y;
import g.z;
import h.l;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: BridgeInterceptor */
public final class a implements s {

    /* renamed from: a reason: collision with root package name */
    public final k f9231a;

    public a(k kVar) {
        this.f9231a = kVar;
    }

    public z intercept(g.s.a aVar) throws IOException {
        boolean z;
        f fVar = (f) aVar;
        x xVar = fVar.f9242f;
        if (xVar != null) {
            g.x.a aVar2 = new g.x.a(xVar);
            y yVar = xVar.f9598d;
            String str = "Content-Type";
            String str2 = "Content-Length";
            if (yVar != null) {
                t contentType = yVar.contentType();
                if (contentType != null) {
                    aVar2.b(str, contentType.f9559a);
                }
                long contentLength = yVar.contentLength();
                int i2 = (contentLength > -1 ? 1 : (contentLength == -1 ? 0 : -1));
                String str3 = Headers.TRANSFER_ENCODING;
                if (i2 != 0) {
                    aVar2.b(str2, Long.toString(contentLength));
                    aVar2.f9603c.a(str3);
                } else {
                    aVar2.b(str3, "chunked");
                    aVar2.f9603c.a(str2);
                }
            }
            q qVar = xVar.f9597c;
            String str4 = Headers.HOST;
            if (qVar.a(str4) == null) {
                aVar2.b(str4, c.a(xVar.f9595a, false));
            }
            q qVar2 = xVar.f9597c;
            String str5 = WebSocketHandler.HEADER_CONNECTION;
            if (qVar2.a(str5) == null) {
                aVar2.b(str5, "Keep-Alive");
            }
            q qVar3 = xVar.f9597c;
            String str6 = Headers.ACCEPT_ENCODING;
            String a2 = qVar3.a(str6);
            String str7 = DecompressionHelper.GZIP_ENCODING;
            if (a2 == null && xVar.f9597c.a(Headers.RANGE) == null) {
                aVar2.b(str6, str7);
                z = true;
            } else {
                z = false;
            }
            if (((g.k.a) this.f9231a) != null) {
                List emptyList = Collections.emptyList();
                if (!emptyList.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    int size = emptyList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (i3 > 0) {
                            sb.append("; ");
                        }
                        j jVar = (j) emptyList.get(i3);
                        sb.append(jVar.f9509a);
                        sb.append('=');
                        sb.append(jVar.f9510b);
                    }
                    aVar2.b(b.f1949d, sb.toString());
                }
                String str8 = "User-Agent";
                if (xVar.f9597c.a(str8) == null) {
                    aVar2.b(str8, "okhttp/3.9.0");
                }
                z a3 = fVar.a(aVar2.a(), fVar.f9238b, fVar.f9239c, fVar.f9240d);
                e.a(this.f9231a, xVar.f9595a, a3.f9619f);
                g.z.a aVar3 = new g.z.a(a3);
                aVar3.f9624a = xVar;
                if (z) {
                    q qVar4 = a3.f9619f;
                    String str9 = Headers.CONTENT_ENCODING;
                    String a4 = qVar4.a(str9);
                    if (a4 == null) {
                        a4 = null;
                    }
                    if (str7.equalsIgnoreCase(a4) && e.b(a3)) {
                        l lVar = new l(a3.f9620g.source());
                        g.q.a a5 = a3.f9619f.a();
                        a5.a(str9);
                        a5.a(str2);
                        List<String> list = a5.f9533a;
                        String[] strArr = (String[]) list.toArray(new String[list.size()]);
                        g.q.a aVar4 = new g.q.a();
                        Collections.addAll(aVar4.f9533a, strArr);
                        aVar3.f9629f = aVar4;
                        String a6 = a3.f9619f.a(str);
                        if (a6 == null) {
                            a6 = null;
                        }
                        aVar3.f9630g = new g(a6, -1, new h.s(lVar));
                    }
                }
                return aVar3.a();
            }
            throw null;
        }
        throw null;
    }
}
