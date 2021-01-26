package g;

import g.d0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec */
public final class i {

    /* renamed from: e reason: collision with root package name */
    public static final g[] f9497e = {g.m, g.o, g.n, g.p, g.r, g.q, g.f9486i, g.k, g.f9487j, g.l, g.f9484g, g.f9485h, g.f9482e, g.f9483f, g.f9481d};

    /* renamed from: f reason: collision with root package name */
    public static final i f9498f;

    /* renamed from: g reason: collision with root package name */
    public static final i f9499g = new i(new a(false));

    /* renamed from: a reason: collision with root package name */
    public final boolean f9500a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f9501b;

    /* renamed from: c reason: collision with root package name */
    public final String[] f9502c;

    /* renamed from: d reason: collision with root package name */
    public final String[] f9503d;

    /* compiled from: ConnectionSpec */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public boolean f9504a;

        /* renamed from: b reason: collision with root package name */
        public String[] f9505b;

        /* renamed from: c reason: collision with root package name */
        public String[] f9506c;

        /* renamed from: d reason: collision with root package name */
        public boolean f9507d;

        public a(boolean z) {
            this.f9504a = z;
        }

        public a a(String... strArr) {
            if (!this.f9504a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f9505b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a b(String... strArr) {
            if (!this.f9504a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f9506c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a(i iVar) {
            this.f9504a = iVar.f9500a;
            this.f9505b = iVar.f9502c;
            this.f9506c = iVar.f9503d;
            this.f9507d = iVar.f9501b;
        }

        public a a(c0... c0VarArr) {
            if (this.f9504a) {
                String[] strArr = new String[c0VarArr.length];
                for (int i2 = 0; i2 < c0VarArr.length; i2++) {
                    strArr[i2] = c0VarArr[i2].f9153a;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

    static {
        a aVar = new a(true);
        g[] gVarArr = f9497e;
        if (aVar.f9504a) {
            String[] strArr = new String[gVarArr.length];
            for (int i2 = 0; i2 < gVarArr.length; i2++) {
                strArr[i2] = gVarArr[i2].f9488a;
            }
            aVar.a(strArr);
            aVar.a(c0.TLS_1_3, c0.TLS_1_2, c0.TLS_1_1, c0.TLS_1_0);
            String str = "no TLS extensions for cleartext connections";
            if (aVar.f9504a) {
                aVar.f9507d = true;
                i iVar = new i(aVar);
                f9498f = iVar;
                a aVar2 = new a(iVar);
                aVar2.a(c0.TLS_1_0);
                if (aVar2.f9504a) {
                    aVar2.f9507d = true;
                    new i(aVar2);
                    return;
                }
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(str);
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    public i(a aVar) {
        this.f9500a = aVar.f9504a;
        this.f9502c = aVar.f9505b;
        this.f9503d = aVar.f9506c;
        this.f9501b = aVar.f9507d;
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f9500a) {
            return false;
        }
        String[] strArr = this.f9503d;
        if (strArr != null && !c.b(c.p, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f9502c;
        if (strArr2 == null || c.b(g.f9479b, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        i iVar = (i) obj;
        boolean z = this.f9500a;
        if (z != iVar.f9500a) {
            return false;
        }
        return !z || (Arrays.equals(this.f9502c, iVar.f9502c) && Arrays.equals(this.f9503d, iVar.f9503d) && this.f9501b == iVar.f9501b);
    }

    public int hashCode() {
        if (this.f9500a) {
            return ((((527 + Arrays.hashCode(this.f9502c)) * 31) + Arrays.hashCode(this.f9503d)) * 31) + (this.f9501b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        String str;
        Object obj;
        if (!this.f9500a) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.f9502c;
        List list = null;
        String str2 = "[all enabled]";
        if (strArr != null) {
            if (strArr != null) {
                ArrayList arrayList = new ArrayList(strArr.length);
                for (String a2 : strArr) {
                    arrayList.add(g.a(a2));
                }
                obj = Collections.unmodifiableList(arrayList);
            } else {
                obj = null;
            }
            str = obj.toString();
        } else {
            str = str2;
        }
        String[] strArr2 = this.f9503d;
        if (strArr2 != null) {
            if (strArr2 != null) {
                list = c0.a(strArr2);
            }
            str2 = list.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectionSpec(cipherSuites=");
        sb.append(str);
        sb.append(", tlsVersions=");
        sb.append(str2);
        sb.append(", supportsTlsExtensions=");
        sb.append(this.f9501b);
        sb.append(")");
        return sb.toString();
    }
}
