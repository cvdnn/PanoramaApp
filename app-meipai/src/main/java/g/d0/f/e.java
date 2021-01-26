package g.d0.f;

import com.baidubce.http.Headers;
import g.j;
import g.k;
import g.k.a;
import g.q;
import g.r;
import g.z;
import java.util.regex.Pattern;

/* compiled from: HttpHeaders */
public final class e {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(z zVar) {
        String a2 = zVar.f9619f.a("Content-Length");
        if (a2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(a2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean b(z zVar) {
        if (zVar.f9614a.f9596b.equals("HEAD")) {
            return false;
        }
        int i2 = zVar.f9616c;
        if (((i2 >= 100 && i2 < 200) || i2 == 204 || i2 == 304) && a(zVar) == -1) {
            String a2 = zVar.f9619f.a(Headers.TRANSFER_ENCODING);
            if (a2 == null) {
                a2 = null;
            }
            if ("chunked".equalsIgnoreCase(a2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void a(k kVar, r rVar, q qVar) {
        if (kVar != k.f9518a && !j.a(rVar, qVar).isEmpty() && ((a) kVar) == null) {
            throw null;
        }
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }
}
