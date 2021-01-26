package e.i.a.h.k;

import com.baidubce.http.Headers;
import e.i.a.e;
import e.i.a.h.d.c;
import e.i.a.h.e.b;
import e.i.a.h.f.a.C0121a;
import e.i.a.h.h.f;
import e.i.a.h.i.g;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BreakpointInterceptor */
public class a implements c, d {

    /* renamed from: a reason: collision with root package name */
    public static final Pattern f8880a = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    public long a(f fVar) throws IOException {
        long j2 = fVar.f8848i;
        int i2 = fVar.f8840a;
        boolean z = true;
        boolean z2 = j2 != -1;
        long j3 = 0;
        e.i.a.h.j.f c2 = fVar.c();
        while (true) {
            try {
                if (fVar.f8847h == fVar.f8845f.size()) {
                    fVar.f8847h--;
                }
                long e2 = fVar.e();
                if (e2 == -1) {
                    break;
                }
                j3 += e2;
            } finally {
                fVar.a();
                if (!fVar.f8843d.f8825d) {
                    c2.b(i2);
                }
            }
        }
        if (z2) {
            e.i.a.h.d.a aVar = (e.i.a.h.d.a) c2.f8874i.f8708g.get(i2);
            if (aVar.a() != aVar.f8696b) {
                z = false;
            }
            if (!z) {
                StringBuilder a2 = e.a.a.a.a.a("The current offset on block-info isn't update correct, ");
                a2.append(aVar.a());
                a2.append(" != ");
                a2.append(aVar.f8696b);
                a2.append(" on ");
                a2.append(i2);
                throw new IOException(a2.toString());
            } else if (j3 != j2) {
                StringBuilder a3 = e.a.a.a.a.a("Fetch-length isn't equal to the response content-length, ", j3, "!= ");
                a3.append(j2);
                throw new IOException(a3.toString());
            }
        }
        return j3;
    }

    public C0121a b(f fVar) throws IOException {
        f fVar2 = fVar;
        String str = "Update store failed!";
        C0121a d2 = fVar.d();
        c cVar = fVar2.f8842c;
        if (!fVar2.f8843d.b()) {
            boolean z = true;
            if (cVar.b() == 1 && !cVar.f8710i) {
                String a2 = d2.a(Headers.CONTENT_RANGE);
                long j2 = -1;
                if (!e.i.a.h.c.a((CharSequence) a2)) {
                    Matcher matcher = f8880a.matcher(a2);
                    long parseLong = matcher.find() ? Long.parseLong(matcher.group(1)) : -1;
                    if (parseLong > 0) {
                        j2 = parseLong + 1;
                    }
                }
                if (j2 < 0) {
                    String a3 = d2.a("Content-Length");
                    if (!e.i.a.h.c.a((CharSequence) a3)) {
                        j2 = Long.parseLong(a3);
                    }
                }
                long j3 = j2;
                long d3 = cVar.d();
                if (j3 > 0 && j3 != d3) {
                    if (cVar.a(0).b() == 0) {
                        z = false;
                    }
                    e.i.a.h.d.a aVar = new e.i.a.h.d.a(0, j3, 0);
                    cVar.f8708g.clear();
                    cVar.f8708g.add(aVar);
                    if (!z) {
                        e.a().f8665b.f8757a.downloadFromBeginning(fVar2.f8841b, cVar, b.CONTENT_LENGTH_CHANGED);
                    } else {
                        throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                    }
                }
            }
            try {
                if (fVar2.n.a(cVar)) {
                    return d2;
                }
                throw new IOException(str);
            } catch (Exception e2) {
                throw new IOException(str, e2);
            }
        } else {
            throw e.i.a.h.i.c.f8856a;
        }
    }
}
