package e.d.a.n.o;

import android.net.Uri;
import android.text.TextUtils;
import e.c.f.n.n;
import e.d.a.n.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

/* compiled from: GlideUrl */
public class g implements f {

    /* renamed from: b reason: collision with root package name */
    public final h f7554b;

    /* renamed from: c reason: collision with root package name */
    public final URL f7555c;

    /* renamed from: d reason: collision with root package name */
    public final String f7556d;

    /* renamed from: e reason: collision with root package name */
    public String f7557e;

    /* renamed from: f reason: collision with root package name */
    public URL f7558f;

    /* renamed from: g reason: collision with root package name */
    public volatile byte[] f7559g;

    /* renamed from: h reason: collision with root package name */
    public int f7560h;

    public g(URL url) {
        h hVar = h.f7561a;
        String str = "Argument must not be null";
        n.a(url, str);
        this.f7555c = url;
        this.f7556d = null;
        n.a(hVar, str);
        this.f7554b = hVar;
    }

    public String a() {
        String str = this.f7556d;
        if (str != null) {
            return str;
        }
        URL url = this.f7555c;
        n.a(url, "Argument must not be null");
        return url.toString();
    }

    public URL b() throws MalformedURLException {
        if (this.f7558f == null) {
            if (TextUtils.isEmpty(this.f7557e)) {
                String str = this.f7556d;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.f7555c;
                    n.a(url, "Argument must not be null");
                    str = url.toString();
                }
                this.f7557e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f7558f = new URL(this.f7557e);
        }
        return this.f7558f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!a().equals(gVar.a()) || !this.f7554b.equals(gVar.f7554b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f7560h == 0) {
            int hashCode = a().hashCode();
            this.f7560h = hashCode;
            this.f7560h = this.f7554b.hashCode() + (hashCode * 31);
        }
        return this.f7560h;
    }

    public String toString() {
        return a();
    }

    public void a(MessageDigest messageDigest) {
        if (this.f7559g == null) {
            this.f7559g = a().getBytes(f.f7225a);
        }
        messageDigest.update(this.f7559g);
    }

    public g(String str) {
        h hVar = h.f7561a;
        this.f7555c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f7556d = str;
            n.a(hVar, "Argument must not be null");
            this.f7554b = hVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
