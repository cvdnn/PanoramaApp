package e.i.a.h.h;

import com.baidubce.http.Headers;
import e.i.a.h.f.a.C0121a;
import e.i.a.h.i.a;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ConnectTrial */
public class c {

    /* renamed from: h reason: collision with root package name */
    public static final Pattern f8813h = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: i reason: collision with root package name */
    public static final Pattern f8814i = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    /* renamed from: a reason: collision with root package name */
    public final e.i.a.c f8815a;

    /* renamed from: b reason: collision with root package name */
    public final e.i.a.h.d.c f8816b;

    /* renamed from: c reason: collision with root package name */
    public boolean f8817c;

    /* renamed from: d reason: collision with root package name */
    public long f8818d;

    /* renamed from: e reason: collision with root package name */
    public String f8819e;

    /* renamed from: f reason: collision with root package name */
    public String f8820f;

    /* renamed from: g reason: collision with root package name */
    public int f8821g;

    public c(e.i.a.c cVar, e.i.a.h.d.c cVar2) {
        this.f8815a = cVar;
        this.f8816b = cVar2;
    }

    public static String a(C0121a aVar) throws IOException {
        String str;
        String a2 = aVar.a(Headers.CONTENT_DISPOSITION);
        if (a2 == null) {
            return null;
        }
        try {
            Matcher matcher = f8813h.matcher(a2);
            if (matcher.find()) {
                str = matcher.group(1);
            } else {
                Matcher matcher2 = f8814i.matcher(a2);
                str = matcher2.find() ? matcher2.group(1) : null;
            }
            if (str != null) {
                if (str.contains("../")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The filename [");
                    sb.append(str);
                    sb.append("] from");
                    sb.append(" the response is not allowable, because it contains '../', which ");
                    sb.append("can raise the directory traversal vulnerability");
                    throw new a(sb.toString());
                }
            }
            return str;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b(e.i.a.h.f.a.C0121a r8) {
        /*
            java.lang.String r0 = "Content-Range"
            java.lang.String r0 = r8.a(r0)
            java.lang.String r1 = "ConnectTrial"
            r2 = 1
            r3 = -1
            if (r0 != 0) goto L_0x000e
            goto L_0x0033
        L_0x000e:
            java.lang.String r5 = "/"
            java.lang.String[] r5 = r0.split(r5)
            int r6 = r5.length
            r7 = 2
            if (r6 < r7) goto L_0x0033
            r5 = r5[r2]     // Catch:{ NumberFormatException -> 0x001f }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0034
        L_0x001f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "parse instance length failed with "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            e.i.a.h.c.b(r1, r0)
        L_0x0033:
            r5 = r3
        L_0x0034:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0039
            return r5
        L_0x0039:
            java.lang.String r0 = "Transfer-Encoding"
            java.lang.String r8 = r8.a(r0)
            if (r8 == 0) goto L_0x004a
            java.lang.String r0 = "chunked"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 != 0) goto L_0x0052
            java.lang.String r8 = "Transfer-Encoding isn't chunked but there is no valid instance length found either!"
            e.i.a.h.c.b(r1, r8)
        L_0x0052:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.c.b(e.i.a.h.f.a$a):long");
    }
}
