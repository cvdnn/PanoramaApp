package e.d.a.n.m;

import android.text.TextUtils;
import android.util.Log;
import com.baidubce.http.Headers;
import e.d.a.f;
import e.d.a.n.e;
import e.d.a.n.o.g;
import e.d.a.t.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HttpUrlFetcher */
public class j implements d<InputStream> {

    /* renamed from: g reason: collision with root package name */
    public static final b f7250g = new a();

    /* renamed from: a reason: collision with root package name */
    public final g f7251a;

    /* renamed from: b reason: collision with root package name */
    public final int f7252b;

    /* renamed from: c reason: collision with root package name */
    public final b f7253c;

    /* renamed from: d reason: collision with root package name */
    public HttpURLConnection f7254d;

    /* renamed from: e reason: collision with root package name */
    public InputStream f7255e;

    /* renamed from: f reason: collision with root package name */
    public volatile boolean f7256f;

    /* compiled from: HttpUrlFetcher */
    public static class a implements b {
    }

    /* compiled from: HttpUrlFetcher */
    public interface b {
    }

    public j(g gVar, int i2) {
        b bVar = f7250g;
        this.f7251a = gVar;
        this.f7252b = i2;
        this.f7253c = bVar;
    }

    public void a(f fVar, e.d.a.n.m.d.a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = "Finished http url fetcher fetch in ";
        String str2 = "HttpUrlFetcher";
        long a2 = e.d.a.t.f.a();
        try {
            aVar.a(a(this.f7251a.b(), 0, null, this.f7251a.f7554b.a()));
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(e.d.a.t.f.a(a2));
                Log.v(str2, sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Failed to load data for url", e2);
            }
            aVar.a((Exception) e2);
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder a3 = e.a.a.a.a.a(str);
                a3.append(e.d.a.t.f.a(a2));
                Log.v(str2, a3.toString());
            }
            throw th;
        }
    }

    public void b() {
        InputStream inputStream = this.f7255e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f7254d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f7254d = null;
    }

    public e.d.a.n.a c() {
        return e.d.a.n.a.REMOTE;
    }

    public void cancel() {
        this.f7256f = true;
    }

    public final InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            if (((a) this.f7253c) != null) {
                this.f7254d = (HttpURLConnection) url.openConnection();
                for (Entry entry : map.entrySet()) {
                    this.f7254d.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                this.f7254d.setConnectTimeout(this.f7252b);
                this.f7254d.setReadTimeout(this.f7252b);
                boolean z = false;
                this.f7254d.setUseCaches(false);
                this.f7254d.setDoInput(true);
                this.f7254d.setInstanceFollowRedirects(false);
                this.f7254d.connect();
                this.f7255e = this.f7254d.getInputStream();
                if (this.f7256f) {
                    return null;
                }
                int responseCode = this.f7254d.getResponseCode();
                int i3 = responseCode / 100;
                if (i3 == 2) {
                    HttpURLConnection httpURLConnection = this.f7254d;
                    if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                        this.f7255e = new c(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                    } else {
                        String str = "HttpUrlFetcher";
                        if (Log.isLoggable(str, 3)) {
                            StringBuilder a2 = e.a.a.a.a.a("Got non empty content encoding: ");
                            a2.append(httpURLConnection.getContentEncoding());
                            Log.d(str, a2.toString());
                        }
                        this.f7255e = httpURLConnection.getInputStream();
                    }
                    return this.f7255e;
                }
                if (i3 == 3) {
                    z = true;
                }
                if (z) {
                    String headerField = this.f7254d.getHeaderField(Headers.LOCATION);
                    if (!TextUtils.isEmpty(headerField)) {
                        URL url3 = new URL(url, headerField);
                        b();
                        return a(url3, i2 + 1, url, map);
                    }
                    throw new e("Received empty or null redirect url");
                } else if (responseCode == -1) {
                    throw new e(responseCode);
                } else {
                    throw new e(this.f7254d.getResponseMessage(), responseCode);
                }
            } else {
                throw null;
            }
        } else {
            throw new e("Too many (> 5) redirects!");
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
