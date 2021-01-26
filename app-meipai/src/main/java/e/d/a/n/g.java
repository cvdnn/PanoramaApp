package e.d.a.n;

import android.text.TextUtils;
import e.c.f.n.n;
import java.security.MessageDigest;

/* compiled from: Option */
public final class g<T> {

    /* renamed from: e reason: collision with root package name */
    public static final b<Object> f7226e = new a();

    /* renamed from: a reason: collision with root package name */
    public final T f7227a;

    /* renamed from: b reason: collision with root package name */
    public final b<T> f7228b;

    /* renamed from: c reason: collision with root package name */
    public final String f7229c;

    /* renamed from: d reason: collision with root package name */
    public volatile byte[] f7230d;

    /* compiled from: Option */
    public class a implements b<Object> {
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option */
    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public g(String str, T t, b<T> bVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f7229c = str;
            this.f7227a = t;
            n.a(bVar, "Argument must not be null");
            this.f7228b = bVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T> g<T> a(String str, T t) {
        return new g<>(str, t, f7226e);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f7229c.equals(((g) obj).f7229c);
    }

    public int hashCode() {
        return this.f7229c.hashCode();
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Option{key='");
        a2.append(this.f7229c);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
