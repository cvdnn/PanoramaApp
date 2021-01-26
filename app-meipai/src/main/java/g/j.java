package g;

import androidx.recyclerview.widget.RecyclerView;
import g.d0.c;
import g.d0.f.d;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Cookie */
public final class j {

    /* renamed from: j reason: collision with root package name */
    public static final Pattern f9508j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a reason: collision with root package name */
    public final String f9509a;

    /* renamed from: b reason: collision with root package name */
    public final String f9510b;

    /* renamed from: c reason: collision with root package name */
    public final long f9511c;

    /* renamed from: d reason: collision with root package name */
    public final String f9512d;

    /* renamed from: e reason: collision with root package name */
    public final String f9513e;

    /* renamed from: f reason: collision with root package name */
    public final boolean f9514f;

    /* renamed from: g reason: collision with root package name */
    public final boolean f9515g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f9516h;

    /* renamed from: i reason: collision with root package name */
    public final boolean f9517i;

    public j(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f9509a = str;
        this.f9510b = str2;
        this.f9511c = j2;
        this.f9512d = str3;
        this.f9513e = str4;
        this.f9514f = z;
        this.f9515g = z2;
        this.f9517i = z3;
        this.f9516h = z4;
    }

    public static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(l).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(k).matches()) {
                i7 = k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f9508j).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += RecyclerView.MAX_SCROLL_DURATION;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.o);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f9509a.equals(this.f9509a) && jVar.f9510b.equals(this.f9510b) && jVar.f9512d.equals(this.f9512d) && jVar.f9513e.equals(this.f9513e) && jVar.f9511c == this.f9511c && jVar.f9514f == this.f9514f && jVar.f9515g == this.f9515g && jVar.f9516h == this.f9516h && jVar.f9517i == this.f9517i) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int hashCode = (this.f9513e.hashCode() + ((this.f9512d.hashCode() + ((this.f9510b.hashCode() + ((this.f9509a.hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        long j2 = this.f9511c;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f9514f ^ true ? 1 : 0)) * 31) + (this.f9515g ^ true ? 1 : 0)) * 31) + (this.f9516h ^ true ? 1 : 0)) * 31) + (this.f9517i ^ true ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9509a);
        sb.append('=');
        sb.append(this.f9510b);
        if (this.f9516h) {
            if (this.f9511c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(((DateFormat) d.f9234a.get()).format(new Date(this.f9511c)));
            }
        }
        if (!this.f9517i) {
            sb.append("; domain=");
            sb.append(this.f9512d);
        }
        sb.append("; path=");
        sb.append(this.f9513e);
        if (this.f9514f) {
            sb.append("; secure");
        }
        if (this.f9515g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ec, code lost:
        if (r0 == null) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ab, code lost:
        if (r25 <= 0) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0189, code lost:
        if ((r0.equals(r9) || (r0.endsWith(r9) && r0.charAt((r0.length() - r9.length()) - 1) == '.' && !g.d0.c.q.matcher(r0).matches())) == false) goto L_0x01ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0230 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<g.j> a(g.r r35, g.q r36) {
        /*
            java.lang.String r0 = "Set-Cookie"
            r1 = r36
            java.util.List r1 = r1.b(r0)
            int r2 = r1.size()
            r3 = 0
            r5 = r3
            r6 = 0
        L_0x000f:
            if (r5 >= r2) goto L_0x0234
            java.lang.Object r0 = r1.get(r5)
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            long r8 = java.lang.System.currentTimeMillis()
            int r10 = r7.length()
            r11 = 59
            int r0 = g.d0.c.a(r7, r3, r10, r11)
            r12 = 61
            int r13 = g.d0.c.a(r7, r3, r0, r12)
            if (r13 != r0) goto L_0x0032
        L_0x002e:
            r7 = r35
            goto L_0x01ee
        L_0x0032:
            java.lang.String r15 = g.d0.c.d(r7, r3, r13)
            boolean r14 = r15.isEmpty()
            if (r14 != 0) goto L_0x021f
            int r14 = g.d0.c.b(r15)
            r4 = -1
            if (r14 == r4) goto L_0x0045
            goto L_0x021f
        L_0x0045:
            int r13 = r13 + 1
            java.lang.String r16 = g.d0.c.d(r7, r13, r0)
            int r13 = g.d0.c.b(r16)
            if (r13 == r4) goto L_0x0052
            goto L_0x002e
        L_0x0052:
            int r0 = r0 + 1
            r17 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r4 = 1
            r21 = r3
            r22 = r21
            r24 = r22
            r23 = r4
            r27 = r17
            r25 = -1
            r29 = 0
            r30 = 0
        L_0x006a:
            r31 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r33 = -9223372036854775808
            if (r0 >= r10) goto L_0x0120
            int r13 = g.d0.c.a(r7, r0, r10, r11)
            int r14 = g.d0.c.a(r7, r0, r13, r12)
            java.lang.String r0 = g.d0.c.d(r7, r0, r14)
            if (r14 >= r13) goto L_0x0088
            int r14 = r14 + 1
            java.lang.String r14 = g.d0.c.d(r7, r14, r13)
            goto L_0x008a
        L_0x0088:
            java.lang.String r14 = ""
        L_0x008a:
            java.lang.String r11 = "expires"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x009b
            int r0 = r14.length()     // Catch:{ IllegalArgumentException -> 0x011a }
            long r27 = a(r14, r3, r0)     // Catch:{ IllegalArgumentException -> 0x011a }
            goto L_0x00c5
        L_0x009b:
            java.lang.String r11 = "max-age"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00c9
            long r25 = java.lang.Long.parseLong(r14)     // Catch:{ NumberFormatException -> 0x00ae }
            r31 = 0
            int r0 = (r25 > r31 ? 1 : (r25 == r31 ? 0 : -1))
            if (r0 > 0) goto L_0x00c5
            goto L_0x00c0
        L_0x00ae:
            r0 = move-exception
            r11 = r0
            java.lang.String r0 = "-?\\d+"
            boolean r0 = r14.matches(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = "-"
            boolean r0 = r14.startsWith(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x00c3
        L_0x00c0:
            r25 = r33
            goto L_0x00c5
        L_0x00c3:
            r25 = r31
        L_0x00c5:
            r24 = r4
            goto L_0x011a
        L_0x00c8:
            throw r11     // Catch:{  }
        L_0x00c9:
            java.lang.String r11 = "domain"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00fa
            java.lang.String r0 = "."
            boolean r11 = r14.endsWith(r0)     // Catch:{ IllegalArgumentException -> 0x011a }
            if (r11 != 0) goto L_0x00f4
            boolean r0 = r14.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x011a }
            if (r0 == 0) goto L_0x00e3
            java.lang.String r14 = r14.substring(r4)     // Catch:{ IllegalArgumentException -> 0x011a }
        L_0x00e3:
            java.lang.String r0 = g.d0.c.a(r14)     // Catch:{ IllegalArgumentException -> 0x011a }
            if (r0 == 0) goto L_0x00ee
            r29 = r0
            r23 = r3
            goto L_0x011a
        L_0x00ee:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x011a }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x011a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x011a }
        L_0x00f4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x011a }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x011a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x011a }
        L_0x00fa:
            java.lang.String r11 = "path"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x0105
            r30 = r14
            goto L_0x011a
        L_0x0105:
            java.lang.String r11 = "secure"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x0110
            r21 = r4
            goto L_0x011a
        L_0x0110:
            java.lang.String r11 = "httponly"
            boolean r0 = r0.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x011a
            r22 = r4
        L_0x011a:
            int r0 = r13 + 1
            r11 = 59
            goto L_0x006a
        L_0x0120:
            int r0 = (r25 > r33 ? 1 : (r25 == r33 ? 0 : -1))
            if (r0 != 0) goto L_0x0129
            r7 = r35
            r17 = r33
            goto L_0x0153
        L_0x0129:
            r10 = -1
            int r0 = (r25 > r10 ? 1 : (r25 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x014f
            r10 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r25 > r10 ? 1 : (r25 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x013c
            r10 = 1000(0x3e8, double:4.94E-321)
            long r31 = r25 * r10
        L_0x013c:
            long r31 = r8 + r31
            int r0 = (r31 > r8 ? 1 : (r31 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x014c
            int r0 = (r31 > r17 ? 1 : (r31 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0147
            goto L_0x014c
        L_0x0147:
            r7 = r35
            r17 = r31
            goto L_0x0153
        L_0x014c:
            r7 = r35
            goto L_0x0153
        L_0x014f:
            r7 = r35
            r17 = r27
        L_0x0153:
            java.lang.String r0 = r7.f9538d
            r8 = 46
            r9 = r29
            if (r9 != 0) goto L_0x015d
            r9 = r0
            goto L_0x018c
        L_0x015d:
            boolean r10 = r0.equals(r9)
            if (r10 == 0) goto L_0x0164
            goto L_0x0186
        L_0x0164:
            boolean r10 = r0.endsWith(r9)
            if (r10 == 0) goto L_0x0188
            int r10 = r0.length()
            int r11 = r9.length()
            int r10 = r10 - r11
            int r10 = r10 - r4
            char r10 = r0.charAt(r10)
            if (r10 != r8) goto L_0x0188
            java.util.regex.Pattern r10 = g.d0.c.q
            java.util.regex.Matcher r10 = r10.matcher(r0)
            boolean r10 = r10.matches()
            if (r10 != 0) goto L_0x0188
        L_0x0186:
            r10 = r4
            goto L_0x0189
        L_0x0188:
            r10 = r3
        L_0x0189:
            if (r10 != 0) goto L_0x018c
            goto L_0x01ee
        L_0x018c:
            int r0 = r0.length()
            int r10 = r9.length()
            if (r0 == r10) goto L_0x01f3
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f9931h
            if (r0 == 0) goto L_0x01f1
            java.lang.String r10 = java.net.IDN.toUnicode(r9)
            java.lang.String r11 = "\\."
            java.lang.String[] r10 = r10.split(r11)
            java.lang.String[] r0 = r0.a(r10)
            int r12 = r10.length
            int r13 = r0.length
            r14 = 33
            if (r12 != r13) goto L_0x01b8
            r12 = r0[r3]
            char r12 = r12.charAt(r3)
            if (r12 == r14) goto L_0x01b8
            r0 = 0
            goto L_0x01ec
        L_0x01b8:
            r12 = r0[r3]
            char r12 = r12.charAt(r3)
            if (r12 != r14) goto L_0x01c3
            int r4 = r10.length
            int r0 = r0.length
            goto L_0x01c7
        L_0x01c3:
            int r10 = r10.length
            int r0 = r0.length
            int r0 = r0 + r4
            r4 = r10
        L_0x01c7:
            int r4 = r4 - r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String[] r10 = r9.split(r11)
        L_0x01d1:
            int r11 = r10.length
            if (r4 >= r11) goto L_0x01df
            r11 = r10[r4]
            r0.append(r11)
            r0.append(r8)
            int r4 = r4 + 1
            goto L_0x01d1
        L_0x01df:
            int r4 = r0.length()
            r8 = -1
            int r4 = r4 + r8
            r0.deleteCharAt(r4)
            java.lang.String r0 = r0.toString()
        L_0x01ec:
            if (r0 != 0) goto L_0x01f3
        L_0x01ee:
            r0 = 0
            r4 = 0
            goto L_0x0223
        L_0x01f1:
            r4 = 0
            throw r4
        L_0x01f3:
            r4 = 0
            java.lang.String r0 = "/"
            r8 = r30
            if (r8 == 0) goto L_0x0204
            boolean r10 = r8.startsWith(r0)
            if (r10 != 0) goto L_0x0201
            goto L_0x0204
        L_0x0201:
            r20 = r8
            goto L_0x0216
        L_0x0204:
            java.lang.String r8 = r35.b()
            r10 = 47
            int r10 = r8.lastIndexOf(r10)
            if (r10 == 0) goto L_0x0214
            java.lang.String r0 = r8.substring(r3, r10)
        L_0x0214:
            r20 = r0
        L_0x0216:
            g.j r0 = new g.j
            r14 = r0
            r19 = r9
            r14.<init>(r15, r16, r17, r19, r20, r21, r22, r23, r24)
            goto L_0x0223
        L_0x021f:
            r4 = 0
            r7 = r35
            r0 = r4
        L_0x0223:
            if (r0 != 0) goto L_0x0226
            goto L_0x0230
        L_0x0226:
            if (r6 != 0) goto L_0x022d
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x022d:
            r6.add(r0)
        L_0x0230:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x0234:
            if (r6 == 0) goto L_0x023b
            java.util.List r0 = java.util.Collections.unmodifiableList(r6)
            goto L_0x023f
        L_0x023b:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x023f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.j.a(g.r, g.q):java.util.List");
    }
}
