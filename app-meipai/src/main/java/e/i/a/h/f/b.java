package e.i.a.h.f;

import com.baidubce.http.Headers;
import e.c.f.n.n;
import e.i.a.d;
import e.i.a.h.f.a.C0121a;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadUrlConnection */
public class b implements a, C0121a {

    /* renamed from: a reason: collision with root package name */
    public URLConnection f8751a;

    /* renamed from: b reason: collision with root package name */
    public a f8752b = null;

    /* renamed from: c reason: collision with root package name */
    public URL f8753c;

    /* renamed from: d reason: collision with root package name */
    public d f8754d;

    /* compiled from: DownloadUrlConnection */
    public static class a {
    }

    /* renamed from: e.i.a.h.f.b$b reason: collision with other inner class name */
    /* compiled from: DownloadUrlConnection */
    public static class C0122b implements e.i.a.h.f.a.b {

        /* renamed from: a reason: collision with root package name */
        public final a f8755a = null;

        public a a(String str) throws IOException {
            return new b(str);
        }
    }

    /* compiled from: DownloadUrlConnection */
    public static final class c implements d {

        /* renamed from: a reason: collision with root package name */
        public String f8756a;
    }

    public b(String str) throws IOException {
        URL url = new URL(str);
        c cVar = new c();
        this.f8753c = url;
        this.f8754d = cVar;
        g();
    }

    public void a(String str, String str2) {
        this.f8751a.addRequestProperty(str, str2);
    }

    public InputStream b() throws IOException {
        return this.f8751a.getInputStream();
    }

    public Map<String, List<String>> c() {
        return this.f8751a.getHeaderFields();
    }

    public C0121a d() throws IOException {
        Map e2 = e();
        this.f8751a.connect();
        c cVar = (c) this.f8754d;
        if (cVar != null) {
            int f2 = f();
            int i2 = 0;
            while (n.b(f2)) {
                release();
                i2++;
                if (i2 <= 10) {
                    String a2 = a(Headers.LOCATION);
                    if (a2 != null) {
                        cVar.f8756a = a2;
                        this.f8753c = new URL(cVar.f8756a);
                        g();
                        e.i.a.h.c.a(e2, (a) this);
                        this.f8751a.connect();
                        f2 = f();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Response code is ");
                        sb.append(f2);
                        sb.append(" but can't find Location field");
                        throw new ProtocolException(sb.toString());
                    }
                } else {
                    throw new ProtocolException(e.a.a.a.a.a("Too many redirect requests: ", i2));
                }
            }
            return this;
        }
        throw null;
    }

    public Map<String, List<String>> e() {
        return this.f8751a.getRequestProperties();
    }

    public int f() throws IOException {
        URLConnection uRLConnection = this.f8751a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    public void g() throws IOException {
        StringBuilder a2 = e.a.a.a.a.a("config connection for ");
        a2.append(this.f8753c);
        e.i.a.h.c.a("DownloadUrlConnection", a2.toString());
        this.f8751a = this.f8753c.openConnection();
    }

    public void release() {
        try {
            InputStream inputStream = this.f8751a.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
    }

    public String a(String str) {
        return this.f8751a.getHeaderField(str);
    }

    public boolean b(String str) throws ProtocolException {
        URLConnection uRLConnection = this.f8751a;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    public String a() {
        return ((c) this.f8754d).f8756a;
    }
}
