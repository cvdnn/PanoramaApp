package g;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: CipherSuite */
public final class g {

    /* renamed from: b reason: collision with root package name */
    public static final Comparator<String> f9479b = new a();

    /* renamed from: c reason: collision with root package name */
    public static final Map<String, g> f9480c = new TreeMap(f9479b);

    /* renamed from: d reason: collision with root package name */
    public static final g f9481d = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: e reason: collision with root package name */
    public static final g f9482e = a("TLS_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: f reason: collision with root package name */
    public static final g f9483f = a("TLS_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: g reason: collision with root package name */
    public static final g f9484g = a("TLS_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: h reason: collision with root package name */
    public static final g f9485h = a("TLS_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: i reason: collision with root package name */
    public static final g f9486i = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");

    /* renamed from: j reason: collision with root package name */
    public static final g f9487j = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
    public static final g k = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    public static final g l = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    public static final g m = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final g n = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final g o = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final g p = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final g q = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final g r = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");

    /* renamed from: a reason: collision with root package name */
    public final String f9488a;

    /* compiled from: CipherSuite */
    public class a implements Comparator<String> {
        public int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            int min = Math.min(str.length(), str2.length());
            int i2 = 4;
            while (true) {
                if (i2 < min) {
                    char charAt = str.charAt(i2);
                    char charAt2 = str2.charAt(i2);
                    if (charAt == charAt2) {
                        i2++;
                    } else if (charAt < charAt2) {
                        return -1;
                    }
                } else {
                    int length = str.length();
                    int length2 = str2.length();
                    if (length == length2) {
                        return 0;
                    }
                    if (length < length2) {
                        return -1;
                    }
                }
            }
            return 1;
        }
    }

    static {
        a("SSL_RSA_WITH_NULL_MD5");
        a("SSL_RSA_WITH_NULL_SHA");
        a("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        a("SSL_RSA_WITH_RC4_128_MD5");
        a("SSL_RSA_WITH_RC4_128_SHA");
        a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_RSA_WITH_DES_CBC_SHA");
        a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        a("SSL_DH_anon_WITH_RC4_128_MD5");
        a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_DH_anon_WITH_DES_CBC_SHA");
        a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        a("TLS_KRB5_WITH_DES_CBC_SHA");
        a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        a("TLS_KRB5_WITH_RC4_128_SHA");
        a("TLS_KRB5_WITH_DES_CBC_MD5");
        a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        a("TLS_KRB5_WITH_RC4_128_MD5");
        a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        a("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        a("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        a("TLS_RSA_WITH_NULL_SHA256");
        a("TLS_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_RSA_WITH_AES_256_CBC_SHA256");
        a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        a("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        a("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        a("TLS_PSK_WITH_RC4_128_SHA");
        a("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        a("TLS_PSK_WITH_AES_128_CBC_SHA");
        a("TLS_PSK_WITH_AES_256_CBC_SHA");
        a("TLS_RSA_WITH_SEED_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        a("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        a("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        a("TLS_FALLBACK_SCSV");
        a("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        a("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_RSA_WITH_NULL_SHA");
        a("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        a("TLS_ECDHE_RSA_WITH_NULL_SHA");
        a("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_anon_WITH_NULL_SHA");
        a("TLS_ECDH_anon_WITH_RC4_128_SHA");
        a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
    }

    public g(String str) {
        if (str != null) {
            this.f9488a = str;
            return;
        }
        throw null;
    }

    public static synchronized g a(String str) {
        g gVar;
        synchronized (g.class) {
            gVar = (g) f9480c.get(str);
            if (gVar == null) {
                gVar = new g(str);
                f9480c.put(str, gVar);
            }
        }
        return gVar;
    }

    public String toString() {
        return this.f9488a;
    }
}
