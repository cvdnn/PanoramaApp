package e.i.a.h.k.f;

import com.baidubce.http.Headers;
import e.i.a.e;
import e.i.a.h.f.a;
import e.i.a.h.f.a.C0121a;
import e.i.a.h.h.f;
import e.i.a.h.h.g;
import e.i.a.h.i.i;
import e.i.a.h.k.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HeaderInterceptor */
public class b implements c {
    public C0121a b(f fVar) throws IOException {
        e.i.a.h.d.c cVar = fVar.f8842c;
        a b2 = fVar.b();
        e.i.a.c cVar2 = fVar.f8841b;
        Map<String, List<String>> map = cVar2.f8652e;
        if (map != null) {
            e.i.a.h.c.b(map, b2);
        }
        String str = "User-Agent";
        if (map == null || !map.containsKey(str)) {
            b2.a(str, "OkDownload/1.0.6");
        }
        int i2 = fVar.f8840a;
        e.i.a.h.d.a a2 = cVar.a(i2);
        if (a2 != null) {
            StringBuilder a3 = e.a.a.a.a.a("bytes=");
            a3.append(a2.b());
            a3.append("-");
            StringBuilder a4 = e.a.a.a.a.a(a3.toString());
            a4.append((a2.f8695a + a2.f8696b) - 1);
            b2.a(Headers.RANGE, a4.toString());
            a2.b();
            a2.a();
            String str2 = cVar.f8704c;
            if (!e.i.a.h.c.a((CharSequence) str2)) {
                b2.a("If-Match", str2);
            }
            if (!fVar.f8843d.b()) {
                e.a().f8665b.f8757a.connectStart(cVar2, i2, b2.e());
                C0121a d2 = fVar.d();
                if (!fVar.f8843d.b()) {
                    Map c2 = d2.c();
                    if (c2 == null) {
                        c2 = new HashMap();
                    }
                    e.a().f8665b.f8757a.connectEnd(cVar2, i2, d2.f(), c2);
                    if (e.a().f8670g != null) {
                        e.i.a.h.d.a a5 = cVar.a(i2);
                        int f2 = d2.f();
                        boolean z = false;
                        e.i.a.h.e.b a6 = e.a().f8670g.a(f2, a5.a() != 0, cVar, d2.a("Etag"));
                        if (a6 == null) {
                            g gVar = e.a().f8670g;
                            if (a5.a() != 0) {
                                z = true;
                            }
                            if (!gVar.a(f2, z)) {
                                String a7 = d2.a("Content-Length");
                                long j2 = -1;
                                if (a7 == null || a7.length() == 0) {
                                    String a8 = d2.a(Headers.CONTENT_RANGE);
                                    if (!(a8 == null || a8.length() == 0)) {
                                        try {
                                            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(a8);
                                            if (matcher.find()) {
                                                j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                            }
                                        } catch (Exception e2) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("parse content-length from content-range failed ");
                                            sb.append(e2);
                                            sb.toString();
                                        }
                                    }
                                } else {
                                    try {
                                        j2 = Long.parseLong(a7);
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                fVar.f8848i = j2;
                                return d2;
                            }
                            throw new i(f2, a5.a());
                        }
                        throw new e.i.a.h.i.f(a6);
                    }
                    throw null;
                }
                throw e.i.a.h.i.c.f8856a;
            }
            throw e.i.a.h.i.c.f8856a;
        }
        throw new IOException(e.a.a.a.a.a("No block-info found on ", i2));
    }
}
