package e.g.b.e0;

import e.g.b.c0.p;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader */
public class a implements Closeable {
    public static final char[] p = ")]}'\n".toCharArray();

    /* renamed from: a reason: collision with root package name */
    public final Reader f8540a;

    /* renamed from: b reason: collision with root package name */
    public boolean f8541b = false;

    /* renamed from: c reason: collision with root package name */
    public final char[] f8542c = new char[1024];

    /* renamed from: d reason: collision with root package name */
    public int f8543d = 0;

    /* renamed from: e reason: collision with root package name */
    public int f8544e = 0;

    /* renamed from: f reason: collision with root package name */
    public int f8545f = 0;

    /* renamed from: g reason: collision with root package name */
    public int f8546g = 0;

    /* renamed from: h reason: collision with root package name */
    public int f8547h = 0;

    /* renamed from: i reason: collision with root package name */
    public long f8548i;

    /* renamed from: j reason: collision with root package name */
    public int f8549j;
    public String k;
    public int[] l;
    public int m;
    public String[] n;
    public int[] o;

    /* renamed from: e.g.b.e0.a$a reason: collision with other inner class name */
    /* compiled from: JsonReader */
    public static class C0118a extends p {
    }

    static {
        p.f8497a = new C0118a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        this.m = 0;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader != null) {
            this.f8540a = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public b A() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final char B() throws IOException {
        int i2;
        int i3;
        String str = "Unterminated escape sequence";
        if (this.f8543d != this.f8544e || a(1)) {
            char[] cArr = this.f8542c;
            int i4 = this.f8543d;
            int i5 = i4 + 1;
            this.f8543d = i5;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.f8545f++;
                this.f8546g = i5;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    a("Invalid escape sequence");
                    throw null;
                } else if (i5 + 4 <= this.f8544e || a(4)) {
                    char c3 = 0;
                    int i6 = this.f8543d;
                    int i7 = i6 + 4;
                    while (i6 < i7) {
                        char c4 = this.f8542c[i6];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i3 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                StringBuilder a2 = e.a.a.a.a.a("\\u");
                                a2.append(new String(this.f8542c, this.f8543d, 4));
                                throw new NumberFormatException(a2.toString());
                            } else {
                                i3 = c4 - 'A';
                            }
                            i2 = i3 + 10;
                        } else {
                            i2 = c4 - '0';
                        }
                        c3 = (char) (i2 + c5);
                        i6++;
                    }
                    this.f8543d += 4;
                    return c3;
                } else {
                    a(str);
                    throw null;
                }
            }
            return c2;
        }
        a(str);
        throw null;
    }

    public final void C() throws IOException {
        char c2;
        do {
            if (this.f8543d < this.f8544e || a(1)) {
                char[] cArr = this.f8542c;
                int i2 = this.f8543d;
                int i3 = i2 + 1;
                this.f8543d = i3;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.f8545f++;
                    this.f8546g = i3;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    public void D() throws IOException {
        int i2;
        int i3 = 0;
        do {
            int i4 = this.f8547h;
            if (i4 == 0) {
                i4 = e();
            }
            if (i4 == 3) {
                b(1);
            } else if (i4 == 1) {
                b(3);
            } else {
                if (i4 == 4) {
                    this.m--;
                } else if (i4 == 2) {
                    this.m--;
                } else if (i4 == 14 || i4 == 10) {
                    while (true) {
                        i2 = 0;
                        while (true) {
                            int i5 = this.f8543d + i2;
                            if (i5 < this.f8544e) {
                                char c2 = this.f8542c[i5];
                                if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                                    if (c2 != '#') {
                                        if (c2 != ',') {
                                            if (!(c2 == '/' || c2 == '=')) {
                                                if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                                    if (c2 != ';') {
                                                        switch (c2) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.f8543d = i5;
                                if (!a(1)) {
                                }
                            }
                        }
                    }
                    d();
                    this.f8543d += i2;
                    this.f8547h = 0;
                } else if (i4 == 8 || i4 == 12) {
                    c('\'');
                    this.f8547h = 0;
                } else if (i4 == 9 || i4 == 13) {
                    c('\"');
                    this.f8547h = 0;
                } else {
                    if (i4 == 16) {
                        this.f8543d += this.f8549j;
                    }
                    this.f8547h = 0;
                }
                i3--;
                this.f8547h = 0;
            }
            i3++;
            this.f8547h = 0;
        } while (i3 != 0);
        int[] iArr = this.o;
        int i6 = this.m;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.n[i6 - 1] = "null";
    }

    public void a() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 3) {
            b(1);
            this.o[this.m - 1] = 0;
            this.f8547h = 0;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected BEGIN_ARRAY but was ");
        a2.append(A());
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public void b() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 1) {
            b(3);
            this.f8547h = 0;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected BEGIN_OBJECT but was ");
        a2.append(A());
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public final void c(char c2) throws IOException {
        char[] cArr = this.f8542c;
        do {
            int i2 = this.f8543d;
            int i3 = this.f8544e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f8543d = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f8543d = i4;
                    B();
                    i2 = this.f8543d;
                    i3 = this.f8544e;
                } else {
                    if (c3 == 10) {
                        this.f8545f++;
                        this.f8546g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f8543d = i2;
        } while (a(1));
        a("Unterminated string");
        throw null;
    }

    public void close() throws IOException {
        this.f8547h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.f8540a.close();
    }

    public final void d() throws IOException {
        if (!this.f8541b) {
            a("Use JsonReader.setLenient(true) to accept malformed JSON");
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f8, code lost:
        if (r9 == 6) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0210, code lost:
        if (a(r6) != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0212, code lost:
        if (r9 != 2) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0214, code lost:
        if (r15 == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x021a, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x021c, code lost:
        if (r16 == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0220, code lost:
        if (r11 != 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0222, code lost:
        if (r16 != false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0224, code lost:
        if (r16 == false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0227, code lost:
        r11 = -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0228, code lost:
        r0.f8548i = r11;
        r0.f8543d += r19;
        r6 = 15;
        r0.f8547h = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0235, code lost:
        if (r9 == 2) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0238, code lost:
        if (r9 == 4) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x023b, code lost:
        if (r9 != 7) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x023d, code lost:
        r0.f8549j = r19;
        r6 = 16;
        r0.f8547h = 16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0174 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e() throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            int[] r1 = r0.l
            int r2 = r0.m
            int r3 = r2 + -1
            r3 = r1[r3]
            r7 = 93
            r8 = 59
            r9 = 44
            r10 = 3
            r11 = 6
            r12 = 7
            r13 = 5
            r14 = 2
            r15 = 0
            r5 = 4
            r6 = 0
            r4 = 1
            if (r3 != r4) goto L_0x0020
            int r2 = r2 - r4
            r1[r2] = r14
            goto L_0x00d1
        L_0x0020:
            if (r3 != r14) goto L_0x003a
            int r1 = r0.a(r4)
            if (r1 == r9) goto L_0x00d1
            if (r1 == r8) goto L_0x0035
            if (r1 != r7) goto L_0x002f
            r0.f8547h = r5
            return r5
        L_0x002f:
            java.lang.String r1 = "Unterminated array"
            r0.a(r1)
            throw r15
        L_0x0035:
            r20.d()
            goto L_0x00d1
        L_0x003a:
            if (r3 == r10) goto L_0x02c8
            if (r3 != r13) goto L_0x0040
            goto L_0x02c8
        L_0x0040:
            if (r3 != r5) goto L_0x0074
            int r2 = r2 - r4
            r1[r2] = r13
            int r1 = r0.a(r4)
            r2 = 58
            if (r1 == r2) goto L_0x00d1
            r2 = 61
            if (r1 != r2) goto L_0x006e
            r20.d()
            int r1 = r0.f8543d
            int r2 = r0.f8544e
            if (r1 < r2) goto L_0x0060
            boolean r1 = r0.a(r4)
            if (r1 == 0) goto L_0x00d1
        L_0x0060:
            char[] r1 = r0.f8542c
            int r2 = r0.f8543d
            char r1 = r1[r2]
            r5 = 62
            if (r1 != r5) goto L_0x00d1
            int r2 = r2 + r4
            r0.f8543d = r2
            goto L_0x00d1
        L_0x006e:
            java.lang.String r1 = "Expected ':'"
            r0.a(r1)
            throw r15
        L_0x0074:
            if (r3 != r11) goto L_0x00b6
            boolean r1 = r0.f8541b
            if (r1 == 0) goto L_0x00ae
            r0.a(r4)
            int r1 = r0.f8543d
            int r1 = r1 - r4
            r0.f8543d = r1
            char[] r2 = p
            int r5 = r2.length
            int r1 = r1 + r5
            int r5 = r0.f8544e
            if (r1 <= r5) goto L_0x0092
            int r1 = r2.length
            boolean r1 = r0.a(r1)
            if (r1 != 0) goto L_0x0092
            goto L_0x00ae
        L_0x0092:
            r1 = r6
        L_0x0093:
            char[] r2 = p
            int r5 = r2.length
            if (r1 >= r5) goto L_0x00a8
            char[] r5 = r0.f8542c
            int r15 = r0.f8543d
            int r15 = r15 + r1
            char r5 = r5[r15]
            char r2 = r2[r1]
            if (r5 == r2) goto L_0x00a4
            goto L_0x00ae
        L_0x00a4:
            int r1 = r1 + 1
            r15 = 0
            goto L_0x0093
        L_0x00a8:
            int r1 = r0.f8543d
            int r2 = r2.length
            int r1 = r1 + r2
            r0.f8543d = r1
        L_0x00ae:
            int[] r1 = r0.l
            int r2 = r0.m
            int r2 = r2 - r4
            r1[r2] = r12
            goto L_0x00d1
        L_0x00b6:
            if (r3 != r12) goto L_0x00cd
            int r1 = r0.a(r6)
            r2 = -1
            if (r1 != r2) goto L_0x00c4
            r1 = 17
            r0.f8547h = r1
            return r1
        L_0x00c4:
            r20.d()
            int r1 = r0.f8543d
            int r1 = r1 - r4
            r0.f8543d = r1
            goto L_0x00d1
        L_0x00cd:
            r1 = 8
            if (r3 == r1) goto L_0x02c0
        L_0x00d1:
            int r1 = r0.a(r4)
            r2 = 34
            if (r1 == r2) goto L_0x02bb
            r2 = 39
            if (r1 == r2) goto L_0x02b3
            if (r1 == r9) goto L_0x029a
            if (r1 == r8) goto L_0x029a
            r2 = 91
            if (r1 == r2) goto L_0x0297
            if (r1 == r7) goto L_0x0290
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x028c
            int r1 = r0.f8543d
            int r1 = r1 - r4
            r0.f8543d = r1
            char[] r2 = r0.f8542c
            char r1 = r2[r1]
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L_0x011a
            r2 = 84
            if (r1 != r2) goto L_0x00fd
            goto L_0x011a
        L_0x00fd:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x0114
            r2 = 70
            if (r1 != r2) goto L_0x0106
            goto L_0x0114
        L_0x0106:
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x010e
            r2 = 78
            if (r1 != r2) goto L_0x0169
        L_0x010e:
            java.lang.String r1 = "null"
            java.lang.String r2 = "NULL"
            r3 = r12
            goto L_0x011f
        L_0x0114:
            java.lang.String r1 = "false"
            java.lang.String r2 = "FALSE"
            r3 = r11
            goto L_0x011f
        L_0x011a:
            java.lang.String r1 = "true"
            java.lang.String r2 = "TRUE"
            r3 = r13
        L_0x011f:
            int r5 = r1.length()
            r7 = r4
        L_0x0124:
            if (r7 >= r5) goto L_0x014d
            int r8 = r0.f8543d
            int r8 = r8 + r7
            int r9 = r0.f8544e
            if (r8 < r9) goto L_0x0136
            int r8 = r7 + 1
            boolean r8 = r0.a(r8)
            if (r8 != 0) goto L_0x0136
            goto L_0x0169
        L_0x0136:
            char[] r8 = r0.f8542c
            int r9 = r0.f8543d
            int r9 = r9 + r7
            char r8 = r8[r9]
            char r9 = r1.charAt(r7)
            if (r8 == r9) goto L_0x014a
            char r9 = r2.charAt(r7)
            if (r8 == r9) goto L_0x014a
            goto L_0x0169
        L_0x014a:
            int r7 = r7 + 1
            goto L_0x0124
        L_0x014d:
            int r1 = r0.f8543d
            int r1 = r1 + r5
            int r2 = r0.f8544e
            if (r1 < r2) goto L_0x015c
            int r1 = r5 + 1
            boolean r1 = r0.a(r1)
            if (r1 == 0) goto L_0x016b
        L_0x015c:
            char[] r1 = r0.f8542c
            int r2 = r0.f8543d
            int r2 = r2 + r5
            char r1 = r1[r2]
            boolean r1 = r0.a(r1)
            if (r1 == 0) goto L_0x016b
        L_0x0169:
            r3 = r6
            goto L_0x0172
        L_0x016b:
            int r1 = r0.f8543d
            int r1 = r1 + r5
            r0.f8543d = r1
            r0.f8547h = r3
        L_0x0172:
            if (r3 == 0) goto L_0x0175
            return r3
        L_0x0175:
            char[] r1 = r0.f8542c
            int r2 = r0.f8543d
            int r3 = r0.f8544e
            r7 = 0
            r15 = r4
            r5 = r6
            r9 = r5
            r16 = r9
            r11 = r7
        L_0x0183:
            int r6 = r2 + r5
            if (r6 != r3) goto L_0x019d
            int r2 = r1.length
            if (r5 != r2) goto L_0x018d
        L_0x018a:
            r6 = 0
            goto L_0x026e
        L_0x018d:
            int r2 = r5 + 1
            boolean r2 = r0.a(r2)
            if (r2 != 0) goto L_0x0199
            r19 = r5
            goto L_0x0212
        L_0x0199:
            int r2 = r0.f8543d
            int r3 = r0.f8544e
        L_0x019d:
            int r6 = r2 + r5
            char r6 = r1[r6]
            r13 = 43
            if (r6 == r13) goto L_0x0262
            r13 = 69
            if (r6 == r13) goto L_0x0258
            r13 = 101(0x65, float:1.42E-43)
            if (r6 == r13) goto L_0x0258
            r13 = 45
            if (r6 == r13) goto L_0x024c
            r13 = 46
            if (r6 == r13) goto L_0x0246
            r13 = 48
            if (r6 < r13) goto L_0x020a
            r13 = 57
            if (r6 <= r13) goto L_0x01be
            goto L_0x020a
        L_0x01be:
            if (r9 == r4) goto L_0x01fe
            if (r9 != 0) goto L_0x01c3
            goto L_0x01fe
        L_0x01c3:
            if (r9 != r14) goto L_0x01ed
            int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x01ca
            goto L_0x018a
        L_0x01ca:
            r17 = 10
            long r17 = r17 * r11
            int r6 = r6 + -48
            r19 = r5
            long r4 = (long) r6
            long r17 = r17 - r4
            r4 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x01e7
            if (r4 != 0) goto L_0x01e5
            int r4 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x01e5
            goto L_0x01e7
        L_0x01e5:
            r4 = 0
            goto L_0x01e8
        L_0x01e7:
            r4 = 1
        L_0x01e8:
            r15 = r15 & r4
            r11 = r17
            r4 = 6
            goto L_0x0206
        L_0x01ed:
            r19 = r5
            if (r9 != r10) goto L_0x01f4
            r4 = 6
            r9 = 4
            goto L_0x0206
        L_0x01f4:
            r4 = 5
            if (r9 == r4) goto L_0x01fb
            r4 = 6
            if (r9 != r4) goto L_0x0206
            goto L_0x01fc
        L_0x01fb:
            r4 = 6
        L_0x01fc:
            r9 = 7
            goto L_0x0206
        L_0x01fe:
            r19 = r5
            r4 = 6
            int r6 = r6 + -48
            int r5 = -r6
            long r11 = (long) r5
            r9 = r14
        L_0x0206:
            r6 = r19
            goto L_0x0268
        L_0x020a:
            r19 = r5
            boolean r1 = r0.a(r6)
            if (r1 != 0) goto L_0x018a
        L_0x0212:
            if (r9 != r14) goto L_0x0235
            if (r15 == 0) goto L_0x0235
            r1 = -9223372036854775808
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x021e
            if (r16 == 0) goto L_0x0235
        L_0x021e:
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0224
            if (r16 != 0) goto L_0x0235
        L_0x0224:
            if (r16 == 0) goto L_0x0227
            goto L_0x0228
        L_0x0227:
            long r11 = -r11
        L_0x0228:
            r0.f8548i = r11
            int r1 = r0.f8543d
            int r1 = r1 + r19
            r0.f8543d = r1
            r6 = 15
            r0.f8547h = r6
            goto L_0x026e
        L_0x0235:
            if (r9 == r14) goto L_0x023d
            r1 = 4
            if (r9 == r1) goto L_0x023d
            r1 = 7
            if (r9 != r1) goto L_0x018a
        L_0x023d:
            r6 = r19
            r0.f8549j = r6
            r6 = 16
            r0.f8547h = r6
            goto L_0x026e
        L_0x0246:
            r6 = r5
            r4 = 6
            if (r9 != r14) goto L_0x018a
            r4 = r10
            goto L_0x0267
        L_0x024c:
            r6 = r5
            r4 = 6
            if (r9 != 0) goto L_0x0254
            r9 = 1
            r16 = 1
            goto L_0x0268
        L_0x0254:
            r5 = 5
            if (r9 != r5) goto L_0x018a
            goto L_0x0267
        L_0x0258:
            r6 = r5
            r4 = 6
            r5 = 5
            if (r9 == r14) goto L_0x0260
            r4 = 4
            if (r9 != r4) goto L_0x018a
        L_0x0260:
            r9 = r5
            goto L_0x0268
        L_0x0262:
            r6 = r5
            r5 = 5
            if (r9 != r5) goto L_0x018a
            r4 = 6
        L_0x0267:
            r9 = r4
        L_0x0268:
            int r5 = r6 + 1
            r4 = 1
            r13 = 5
            goto L_0x0183
        L_0x026e:
            if (r6 == 0) goto L_0x0271
            return r6
        L_0x0271:
            char[] r1 = r0.f8542c
            int r2 = r0.f8543d
            char r1 = r1[r2]
            boolean r1 = r0.a(r1)
            if (r1 == 0) goto L_0x0285
            r20.d()
            r1 = 10
            r0.f8547h = r1
            return r1
        L_0x0285:
            java.lang.String r1 = "Expected value"
            r0.a(r1)
            r1 = 0
            throw r1
        L_0x028c:
            r1 = r4
            r0.f8547h = r1
            return r1
        L_0x0290:
            r1 = r4
            if (r3 != r1) goto L_0x029b
            r2 = 4
            r0.f8547h = r2
            return r2
        L_0x0297:
            r0.f8547h = r10
            return r10
        L_0x029a:
            r1 = r4
        L_0x029b:
            if (r3 == r1) goto L_0x02a7
            if (r3 != r14) goto L_0x02a0
            goto L_0x02a7
        L_0x02a0:
            java.lang.String r1 = "Unexpected value"
            r0.a(r1)
            r1 = 0
            throw r1
        L_0x02a7:
            r20.d()
            int r2 = r0.f8543d
            int r2 = r2 - r1
            r0.f8543d = r2
            r1 = 7
            r0.f8547h = r1
            return r1
        L_0x02b3:
            r20.d()
            r1 = 8
            r0.f8547h = r1
            return r1
        L_0x02bb:
            r1 = 9
            r0.f8547h = r1
            return r1
        L_0x02c0:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x02c8:
            int[] r1 = r0.l
            int r2 = r0.m
            r4 = 1
            int r2 = r2 - r4
            r5 = 4
            r1[r2] = r5
            r1 = 125(0x7d, float:1.75E-43)
            r2 = 5
            if (r3 != r2) goto L_0x02ef
            int r2 = r0.a(r4)
            if (r2 == r9) goto L_0x02ed
            if (r2 == r8) goto L_0x02ea
            if (r2 != r1) goto L_0x02e3
            r0.f8547h = r14
            return r14
        L_0x02e3:
            java.lang.String r1 = "Unterminated object"
            r0.a(r1)
            r1 = 0
            throw r1
        L_0x02ea:
            r20.d()
        L_0x02ed:
            r2 = 1
            goto L_0x02f0
        L_0x02ef:
            r2 = r4
        L_0x02f0:
            int r4 = r0.a(r2)
            r5 = 34
            if (r4 == r5) goto L_0x032c
            r5 = 39
            if (r4 == r5) goto L_0x0324
            java.lang.String r5 = "Expected name"
            if (r4 == r1) goto L_0x0319
            r20.d()
            int r1 = r0.f8543d
            int r1 = r1 - r2
            r0.f8543d = r1
            char r1 = (char) r4
            boolean r1 = r0.a(r1)
            if (r1 == 0) goto L_0x0314
            r1 = 14
            r0.f8547h = r1
            return r1
        L_0x0314:
            r0.a(r5)
            r1 = 0
            throw r1
        L_0x0319:
            r1 = 0
            r2 = 5
            if (r3 == r2) goto L_0x0320
            r0.f8547h = r14
            return r14
        L_0x0320:
            r0.a(r5)
            throw r1
        L_0x0324:
            r20.d()
            r1 = 12
            r0.f8547h = r1
            return r1
        L_0x032c:
            r1 = 13
            r0.f8547h = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.e0.a.e():int");
    }

    public void i() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 4) {
            int i3 = this.m - 1;
            this.m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f8547h = 0;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected END_ARRAY but was ");
        a2.append(A());
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public void l() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 2) {
            int i3 = this.m - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f8547h = 0;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected END_OBJECT but was ");
        a2.append(A());
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public String m() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean q() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public String r() {
        StringBuilder a2 = e.a.a.a.a.a(" at line ", this.f8545f + 1, " column ", (this.f8543d - this.f8546g) + 1, " path ");
        a2.append(m());
        return a2.toString();
    }

    public boolean s() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 5) {
            this.f8547h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f8547h = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Expected a boolean but was ");
            a2.append(A());
            a2.append(r());
            throw new IllegalStateException(a2.toString());
        }
    }

    public double t() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.f8547h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.f8548i;
        }
        if (i2 == 16) {
            this.k = new String(this.f8542c, this.f8543d, this.f8549j);
            this.f8543d += this.f8549j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.k = z();
        } else if (i2 != 11) {
            StringBuilder a2 = e.a.a.a.a.a("Expected a double but was ");
            a2.append(A());
            a2.append(r());
            throw new IllegalStateException(a2.toString());
        }
        this.f8547h = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (this.f8541b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.k = null;
            this.f8547h = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JSON forbids NaN and infinities: ");
        sb.append(parseDouble);
        sb.append(r());
        throw new d(sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(r());
        return sb.toString();
    }

    public int u() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        String str = "Expected an int but was ";
        if (i2 == 15) {
            long j2 = this.f8548i;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.f8547h = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            StringBuilder a2 = e.a.a.a.a.a(str);
            a2.append(this.f8548i);
            a2.append(r());
            throw new NumberFormatException(a2.toString());
        }
        if (i2 == 16) {
            this.k = new String(this.f8542c, this.f8543d, this.f8549j);
            this.f8543d += this.f8549j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = z();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f8547h = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder a3 = e.a.a.a.a.a(str);
            a3.append(A());
            a3.append(r());
            throw new IllegalStateException(a3.toString());
        }
        this.f8547h = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.k = null;
            this.f8547h = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        StringBuilder a4 = e.a.a.a.a.a(str);
        a4.append(this.k);
        a4.append(r());
        throw new NumberFormatException(a4.toString());
    }

    public long v() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.f8547h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f8548i;
        }
        String str = "Expected a long but was ";
        if (i2 == 16) {
            this.k = new String(this.f8542c, this.f8543d, this.f8549j);
            this.f8543d += this.f8549j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = z();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f8547h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder a2 = e.a.a.a.a.a(str);
            a2.append(A());
            a2.append(r());
            throw new IllegalStateException(a2.toString());
        }
        this.f8547h = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.k = null;
            this.f8547h = 0;
            int[] iArr3 = this.o;
            int i5 = this.m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        StringBuilder a3 = e.a.a.a.a.a(str);
        a3.append(this.k);
        a3.append(r());
        throw new NumberFormatException(a3.toString());
    }

    public String w() throws IOException {
        String str;
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 14) {
            str = z();
        } else if (i2 == 12) {
            str = b('\'');
        } else if (i2 == 13) {
            str = b('\"');
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Expected a name but was ");
            a2.append(A());
            a2.append(r());
            throw new IllegalStateException(a2.toString());
        }
        this.f8547h = 0;
        this.n[this.m - 1] = str;
        return str;
    }

    public void x() throws IOException {
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 7) {
            this.f8547h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected null but was ");
        a2.append(A());
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public String y() throws IOException {
        String str;
        int i2 = this.f8547h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 10) {
            str = z();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f8548i);
        } else if (i2 == 16) {
            str = new String(this.f8542c, this.f8543d, this.f8549j);
            this.f8543d += this.f8549j;
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Expected a string but was ");
            a2.append(A());
            a2.append(r());
            throw new IllegalStateException(a2.toString());
        }
        this.f8547h = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String z() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r0
        L_0x0003:
            int r3 = r6.f8543d
            int r4 = r3 + r2
            int r5 = r6.f8544e
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.f8542c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.d()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.f8542c
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.f8542c
            int r4 = r6.f8543d
            r1.append(r3, r4, r2)
            int r3 = r6.f8543d
            int r3 = r3 + r2
            r6.f8543d = r3
            r2 = 1
            boolean r2 = r6.a(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f8542c
            int r3 = r6.f8543d
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.f8542c
            int r3 = r6.f8543d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.f8543d
            int r2 = r2 + r0
            r6.f8543d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.e0.a.z():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r4) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        r2.append(r0, r4, r3 - r4);
        r10.f8543d = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(char r11) throws java.io.IOException {
        /*
            r10 = this;
            char[] r0 = r10.f8542c
            r1 = 0
            r2 = r1
        L_0x0004:
            int r3 = r10.f8543d
            int r4 = r10.f8544e
        L_0x0008:
            r5 = r4
            r4 = r3
        L_0x000a:
            r6 = 16
            r7 = 1
            if (r3 >= r5) goto L_0x005d
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L_0x0029
            r10.f8543d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L_0x0021
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r4, r8)
            return r11
        L_0x0021:
            r2.append(r0, r4, r8)
            java.lang.String r11 = r2.toString()
            return r11
        L_0x0029:
            r9 = 92
            if (r3 != r9) goto L_0x0050
            r10.f8543d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L_0x0041
            int r2 = r8 + 1
            int r2 = r2 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r3.<init>(r2)
            r2 = r3
        L_0x0041:
            r2.append(r0, r4, r8)
            char r3 = r10.B()
            r2.append(r3)
            int r3 = r10.f8543d
            int r4 = r10.f8544e
            goto L_0x0008
        L_0x0050:
            r6 = 10
            if (r3 != r6) goto L_0x005b
            int r3 = r10.f8545f
            int r3 = r3 + r7
            r10.f8545f = r3
            r10.f8546g = r8
        L_0x005b:
            r3 = r8
            goto L_0x000a
        L_0x005d:
            if (r2 != 0) goto L_0x006d
            int r2 = r3 - r4
            int r2 = r2 * 2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r5.<init>(r2)
            r2 = r5
        L_0x006d:
            int r5 = r3 - r4
            r2.append(r0, r4, r5)
            r10.f8543d = r3
            boolean r3 = r10.a(r7)
            if (r3 == 0) goto L_0x007b
            goto L_0x0004
        L_0x007b:
            java.lang.String r11 = "Unterminated string"
            r10.a(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.e0.a.b(char):java.lang.String");
    }

    public final boolean a(char c2) throws IOException {
        if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
            if (c2 != '#') {
                if (c2 != ',') {
                    if (!(c2 == '/' || c2 == '=')) {
                        if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                            if (c2 != ';') {
                                switch (c2) {
                                    case '[':
                                    case ']':
                                        break;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            d();
        }
        return false;
    }

    public final boolean a(int i2) throws IOException {
        char[] cArr = this.f8542c;
        int i3 = this.f8546g;
        int i4 = this.f8543d;
        this.f8546g = i3 - i4;
        int i5 = this.f8544e;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.f8544e = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.f8544e = 0;
        }
        this.f8543d = 0;
        do {
            Reader reader = this.f8540a;
            int i7 = this.f8544e;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.f8544e + read;
            this.f8544e = i8;
            if (this.f8545f == 0) {
                int i9 = this.f8546g;
                if (i9 == 0 && i8 > 0 && cArr[0] == 65279) {
                    this.f8543d++;
                    this.f8546g = i9 + 1;
                    i2++;
                }
            }
        } while (this.f8544e < i2);
        return true;
    }

    public final int a(boolean z) throws IOException {
        char[] cArr = this.f8542c;
        int i2 = this.f8543d;
        int i3 = this.f8544e;
        while (true) {
            boolean z2 = true;
            if (i2 == i3) {
                this.f8543d = i2;
                if (a(1)) {
                    i2 = this.f8543d;
                    i3 = this.f8544e;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder a2 = e.a.a.a.a.a("End of input");
                    a2.append(r());
                    throw new EOFException(a2.toString());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == 10) {
                this.f8545f++;
                this.f8546g = i4;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.f8543d = i4;
                    if (i4 == i3) {
                        this.f8543d = i4 - 1;
                        boolean a3 = a(2);
                        this.f8543d++;
                        if (!a3) {
                            return c2;
                        }
                    }
                    d();
                    int i5 = this.f8543d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f8543d = i5 + 1;
                        while (true) {
                            int i6 = 0;
                            if (this.f8543d + 2 > this.f8544e && !a(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.f8542c;
                            int i7 = this.f8543d;
                            if (cArr2[i7] != 10) {
                                while (i6 < 2) {
                                    if (this.f8542c[this.f8543d + i6] == "*/".charAt(i6)) {
                                        i6++;
                                    }
                                }
                                break;
                            }
                            this.f8545f++;
                            this.f8546g = i7 + 1;
                            this.f8543d++;
                        }
                        if (z2) {
                            i2 = this.f8543d + 2;
                            i3 = this.f8544e;
                        } else {
                            a("Unterminated comment");
                            throw null;
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f8543d = i5 + 1;
                        C();
                        i2 = this.f8543d;
                        i3 = this.f8544e;
                    }
                } else if (c2 == '#') {
                    this.f8543d = i4;
                    d();
                    C();
                    i2 = this.f8543d;
                    i3 = this.f8544e;
                } else {
                    this.f8543d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    public final void b(int i2) {
        int i3 = this.m;
        int[] iArr = this.l;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            int[] iArr3 = new int[(i3 * 2)];
            String[] strArr = new String[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.o, 0, iArr3, 0, this.m);
            System.arraycopy(this.n, 0, strArr, 0, this.m);
            this.l = iArr2;
            this.o = iArr3;
            this.n = strArr;
        }
        int[] iArr4 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr4[i4] = i2;
    }

    public final IOException a(String str) throws IOException {
        StringBuilder a2 = e.a.a.a.a.a(str);
        a2.append(r());
        throw new d(a2.toString());
    }
}
