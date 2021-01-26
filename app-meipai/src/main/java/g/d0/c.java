package g.d0;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobstat.Config;
import g.a0;
import g.r;
import g.t;
import g.y;
import h.e;
import h.g;
import h.h;
import h.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: Util */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public static final byte[] f9174a;

    /* renamed from: b reason: collision with root package name */
    public static final String[] f9175b = new String[0];

    /* renamed from: c reason: collision with root package name */
    public static final a0 f9176c;

    /* renamed from: d reason: collision with root package name */
    public static final y f9177d = y.create((t) null, f9174a);

    /* renamed from: e reason: collision with root package name */
    public static final h f9178e = h.b("efbbbf");

    /* renamed from: f reason: collision with root package name */
    public static final h f9179f = h.b("feff");

    /* renamed from: g reason: collision with root package name */
    public static final h f9180g = h.b("fffe");

    /* renamed from: h reason: collision with root package name */
    public static final h f9181h = h.b("0000ffff");

    /* renamed from: i reason: collision with root package name */
    public static final h f9182i = h.b("ffff0000");

    /* renamed from: j reason: collision with root package name */
    public static final Charset f9183j = Charset.forName("UTF-8");
    public static final Charset k = Charset.forName("UTF-16BE");
    public static final Charset l = Charset.forName("UTF-16LE");
    public static final Charset m = Charset.forName("UTF-32BE");
    public static final Charset n = Charset.forName("UTF-32LE");
    public static final TimeZone o = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> p = new a();
    public static final Pattern q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* compiled from: Util */
    public class a implements Comparator<String> {
        public int compare(Object obj, Object obj2) {
            return ((String) obj).compareTo((String) obj2);
        }
    }

    /* compiled from: Util */
    public class b implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f9184a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean f9185b;

        public b(String str, boolean z) {
            this.f9184a = str;
            this.f9185b = z;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f9184a);
            thread.setDaemon(this.f9185b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f9174a = bArr;
        f9176c = a0.create((t) null, bArr);
        Charset.forName("ISO-8859-1");
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean b(x xVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c2 = xVar.timeout().d() ? xVar.timeout().c() - nanoTime : Long.MAX_VALUE;
        xVar.timeout().a(Math.min(c2, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            e eVar = new e();
            while (xVar.read(eVar, 8192) != -1) {
                eVar.a();
            }
            if (c2 == RecyclerView.FOREVER_NS) {
                xVar.timeout().a();
            } else {
                xVar.timeout().a(nanoTime + c2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c2 == RecyclerView.FOREVER_NS) {
                xVar.timeout().a();
            } else {
                xVar.timeout().a(nanoTime + c2);
            }
            return false;
        } catch (Throwable th) {
            if (c2 == RecyclerView.FOREVER_NS) {
                xVar.timeout().a();
            } else {
                xVar.timeout().a(nanoTime + c2);
            }
            throw th;
        }
    }

    public static int c(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String d(String str, int i2, int i3) {
        int b2 = b(str, i2, i3);
        return str.substring(b2, c(str, b2, i3));
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(x xVar, int i2, TimeUnit timeUnit) {
        try {
            return b(xVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new b(str, z);
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int b(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress inetAddress;
        int i2 = -1;
        int i3 = 0;
        if (str.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = a(str, 0, str.length());
            } else {
                inetAddress = a(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < address.length) {
                    int i6 = i4;
                    while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                        i6 += 2;
                    }
                    int i7 = i6 - i4;
                    if (i7 > i5 && i7 >= 4) {
                        i2 = i4;
                        i5 = i7;
                    }
                    i4 = i6 + 2;
                }
                e eVar = new e();
                while (i3 < address.length) {
                    if (i3 == i2) {
                        eVar.writeByte(58);
                        i3 += i5;
                        if (i3 == 16) {
                            eVar.writeByte(58);
                        }
                    } else {
                        if (i3 > 0) {
                            eVar.writeByte(58);
                        }
                        eVar.d((long) (((address[i3] & 255) << 8) | (address[i3 + 1] & 255)));
                        i3 += 2;
                    }
                }
                return eVar.e();
            }
            throw new AssertionError(e.a.a.a.a.a("Invalid IPv6 address: '", str, "'"));
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i8 = 0;
            while (true) {
                if (i8 >= lowerCase.length()) {
                    break;
                }
                char charAt = lowerCase.charAt(i8);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i8++;
                }
            }
            i3 = 1;
            if (i3 != 0) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(g gVar, Charset charset) throws IOException {
        if (gVar.a(0, f9178e)) {
            gVar.skip((long) f9178e.d());
            return f9183j;
        } else if (gVar.a(0, f9179f)) {
            gVar.skip((long) f9179f.d());
            return k;
        } else if (gVar.a(0, f9180g)) {
            gVar.skip((long) f9180g.d());
            return l;
        } else if (gVar.a(0, f9181h)) {
            gVar.skip((long) f9181h.d());
            return m;
        } else if (!gVar.a(0, f9182i)) {
            return charset;
        } else {
            gVar.skip((long) f9182i.d());
            return n;
        }
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException(e.a.a.a.a.a(str, " < 0"));
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(e.a.a.a.a.a(str, " too large."));
            } else if (millis != 0 || i2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(e.a.a.a.a.a(str, " too small."));
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static AssertionError a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    public static String a(r rVar, boolean z) {
        String str;
        String str2 = rVar.f9538d;
        String str3 = Config.TRACE_TODAY_VISIT_SPLIT;
        if (str2.contains(str3)) {
            str = e.a.a.a.a.a(e.a.a.a.a.a("["), rVar.f9538d, "]");
        } else {
            str = rVar.f9538d;
        }
        if (!z && rVar.f9539e == r.a(rVar.f9535a)) {
            return str;
        }
        StringBuilder b2 = e.a.a.a.a.b(str, str3);
        b2.append(rVar.f9539e);
        return b2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00db, code lost:
        if (r7 == r0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00de, code lost:
        if (r8 != -1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e0, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e1, code lost:
        r1 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r1, r1);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f3, code lost:
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f9, code lost:
        throw new java.lang.AssertionError();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.InetAddress a(java.lang.String r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r18
            r2 = 16
            byte[] r3 = new byte[r2]
            r4 = -1
            r5 = 0
            r6 = r17
            r8 = r4
            r9 = r8
            r7 = r5
        L_0x000f:
            r10 = 0
            if (r6 >= r1) goto L_0x00da
            if (r7 != r2) goto L_0x0015
            return r10
        L_0x0015:
            int r11 = r6 + 2
            r12 = 255(0xff, float:3.57E-43)
            r13 = 4
            if (r11 > r1) goto L_0x0034
            r14 = 2
            java.lang.String r15 = "::"
            boolean r14 = r0.regionMatches(r6, r15, r5, r14)
            if (r14 == 0) goto L_0x0034
            if (r8 == r4) goto L_0x0028
            return r10
        L_0x0028:
            int r7 = r7 + 2
            if (r11 != r1) goto L_0x0030
            r0 = r2
            r8 = r7
            goto L_0x00db
        L_0x0030:
            r8 = r7
            r9 = r11
            goto L_0x00a7
        L_0x0034:
            if (r7 == 0) goto L_0x00a6
            r11 = 1
            java.lang.String r14 = ":"
            boolean r14 = r0.regionMatches(r6, r14, r5, r11)
            if (r14 == 0) goto L_0x0043
            int r6 = r6 + 1
            goto L_0x00a6
        L_0x0043:
            java.lang.String r14 = "."
            boolean r6 = r0.regionMatches(r6, r14, r5, r11)
            if (r6 == 0) goto L_0x00a5
            int r6 = r7 + -2
            r14 = r6
        L_0x004e:
            if (r9 >= r1) goto L_0x0097
            if (r14 != r2) goto L_0x0054
        L_0x0052:
            r11 = r5
            goto L_0x009d
        L_0x0054:
            if (r14 == r6) goto L_0x0061
            char r15 = r0.charAt(r9)
            r11 = 46
            if (r15 == r11) goto L_0x005f
            goto L_0x0052
        L_0x005f:
            int r9 = r9 + 1
        L_0x0061:
            r15 = r5
            r11 = r9
        L_0x0063:
            if (r11 >= r1) goto L_0x0085
            char r5 = r0.charAt(r11)
            r2 = 48
            if (r5 < r2) goto L_0x0085
            r4 = 57
            if (r5 <= r4) goto L_0x0072
            goto L_0x0085
        L_0x0072:
            if (r15 != 0) goto L_0x0077
            if (r9 == r11) goto L_0x0077
            goto L_0x009a
        L_0x0077:
            int r15 = r15 * 10
            int r15 = r15 + r5
            int r15 = r15 - r2
            if (r15 <= r12) goto L_0x007e
            goto L_0x009a
        L_0x007e:
            int r11 = r11 + 1
            r2 = 16
            r4 = -1
            r5 = 0
            goto L_0x0063
        L_0x0085:
            int r2 = r11 - r9
            if (r2 != 0) goto L_0x008a
            goto L_0x009a
        L_0x008a:
            int r2 = r14 + 1
            byte r4 = (byte) r15
            r3[r14] = r4
            r14 = r2
            r9 = r11
            r2 = 16
            r4 = -1
            r5 = 0
            r11 = 1
            goto L_0x004e
        L_0x0097:
            int r6 = r6 + r13
            if (r14 == r6) goto L_0x009c
        L_0x009a:
            r11 = 0
            goto L_0x009d
        L_0x009c:
            r11 = 1
        L_0x009d:
            if (r11 != 0) goto L_0x00a0
            return r10
        L_0x00a0:
            int r7 = r7 + 2
            r0 = 16
            goto L_0x00db
        L_0x00a5:
            return r10
        L_0x00a6:
            r9 = r6
        L_0x00a7:
            r6 = r9
            r2 = 0
        L_0x00a9:
            if (r6 >= r1) goto L_0x00bd
            char r4 = r0.charAt(r6)
            int r4 = a(r4)
            r5 = -1
            if (r4 != r5) goto L_0x00b7
            goto L_0x00bd
        L_0x00b7:
            int r2 = r2 << 4
            int r2 = r2 + r4
            int r6 = r6 + 1
            goto L_0x00a9
        L_0x00bd:
            int r4 = r6 - r9
            if (r4 == 0) goto L_0x00d9
            if (r4 <= r13) goto L_0x00c4
            goto L_0x00d9
        L_0x00c4:
            int r4 = r7 + 1
            int r5 = r2 >>> 8
            r5 = r5 & r12
            byte r5 = (byte) r5
            r3[r7] = r5
            int r7 = r4 + 1
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r3[r4] = r2
            r2 = 16
            r4 = -1
            r5 = 0
            goto L_0x000f
        L_0x00d9:
            return r10
        L_0x00da:
            r0 = r2
        L_0x00db:
            if (r7 == r0) goto L_0x00ef
            r1 = -1
            if (r8 != r1) goto L_0x00e1
            return r10
        L_0x00e1:
            int r1 = r7 - r8
            int r2 = 16 - r1
            java.lang.System.arraycopy(r3, r8, r3, r2, r1)
            int r2 = 16 - r7
            int r2 = r2 + r8
            r0 = 0
            java.util.Arrays.fill(r3, r8, r2, r0)
        L_0x00ef:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r3)     // Catch:{ UnknownHostException -> 0x00f4 }
            return r0
        L_0x00f4:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.c.a(java.lang.String, int, int):java.net.InetAddress");
    }
}
