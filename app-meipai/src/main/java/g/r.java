package g;

import g.d0.c;
import h.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpUrl */
public final class r {

    /* renamed from: i reason: collision with root package name */
    public static final char[] f9534i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a reason: collision with root package name */
    public final String f9535a;

    /* renamed from: b reason: collision with root package name */
    public final String f9536b;

    /* renamed from: c reason: collision with root package name */
    public final String f9537c;

    /* renamed from: d reason: collision with root package name */
    public final String f9538d;

    /* renamed from: e reason: collision with root package name */
    public final int f9539e;

    /* renamed from: f reason: collision with root package name */
    public final List<String> f9540f;

    /* renamed from: g reason: collision with root package name */
    public final String f9541g;

    /* renamed from: h reason: collision with root package name */
    public final String f9542h;

    /* compiled from: HttpUrl */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public String f9543a;

        /* renamed from: b reason: collision with root package name */
        public String f9544b;

        /* renamed from: c reason: collision with root package name */
        public String f9545c;

        /* renamed from: d reason: collision with root package name */
        public String f9546d;

        /* renamed from: e reason: collision with root package name */
        public int f9547e = -1;

        /* renamed from: f reason: collision with root package name */
        public final List<String> f9548f;

        /* renamed from: g reason: collision with root package name */
        public List<String> f9549g;

        /* renamed from: h reason: collision with root package name */
        public String f9550h;

        /* renamed from: g.r$a$a reason: collision with other inner class name */
        /* compiled from: HttpUrl */
        public enum C0141a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            String str = "";
            this.f9544b = str;
            this.f9545c = str;
            ArrayList arrayList = new ArrayList();
            this.f9548f = arrayList;
            arrayList.add(str);
        }

        public a a(String str) {
            List<String> list;
            if (str != null) {
                list = r.b(r.a(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f9549g = list;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f9543a);
            sb.append("://");
            if (!this.f9544b.isEmpty() || !this.f9545c.isEmpty()) {
                sb.append(this.f9544b);
                if (!this.f9545c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f9545c);
                }
                sb.append('@');
            }
            if (this.f9546d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f9546d);
                sb.append(']');
            } else {
                sb.append(this.f9546d);
            }
            int i2 = this.f9547e;
            if (i2 == -1) {
                i2 = r.a(this.f9543a);
            }
            if (i2 != r.a(this.f9543a)) {
                sb.append(':');
                sb.append(i2);
            }
            List<String> list = this.f9548f;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb.append('/');
                sb.append((String) list.get(i3));
            }
            if (this.f9549g != null) {
                sb.append('?');
                r.a(sb, this.f9549g);
            }
            if (this.f9550h != null) {
                sb.append('#');
                sb.append(this.f9550h);
            }
            return sb.toString();
        }

        public r a() {
            if (this.f9543a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f9546d != null) {
                return new r(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ef, code lost:
            if (r1 <= 65535) goto L_0x01f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
            if (r7 == ':') goto L_0x0062;
         */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x01fb  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x020d  */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0210  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x024a  */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x00ac A[EDGE_INSN: B:183:0x00ac->B:46:0x00ac ?: BREAK  
EDGE_INSN: B:183:0x00ac->B:46:0x00ac ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:193:0x01cc A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0105  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01b2  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x01d1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public g.r.a.C0141a a(g.r r34, java.lang.String r35) {
            /*
                r33 = this;
                r0 = r33
                r1 = r34
                r10 = r35
                int r2 = r35.length()
                r11 = 0
                int r8 = g.d0.c.b(r10, r11, r2)
                int r2 = r35.length()
                int r12 = g.d0.c.c(r10, r8, r2)
                int r2 = r12 - r8
                r9 = 2
                r13 = 58
                r14 = -1
                r15 = 1
                if (r2 >= r9) goto L_0x0022
            L_0x0020:
                r2 = r14
                goto L_0x0062
            L_0x0022:
                char r2 = r10.charAt(r8)
                r3 = 90
                r4 = 122(0x7a, float:1.71E-43)
                r5 = 65
                r6 = 97
                if (r2 < r6) goto L_0x0032
                if (r2 <= r4) goto L_0x0037
            L_0x0032:
                if (r2 < r5) goto L_0x0020
                if (r2 <= r3) goto L_0x0037
                goto L_0x0020
            L_0x0037:
                r2 = r8
            L_0x0038:
                int r2 = r2 + r15
                if (r2 >= r12) goto L_0x0020
                char r7 = r10.charAt(r2)
                if (r7 < r6) goto L_0x0043
                if (r7 <= r4) goto L_0x005f
            L_0x0043:
                if (r7 < r5) goto L_0x0047
                if (r7 <= r3) goto L_0x005f
            L_0x0047:
                r3 = 48
                if (r7 < r3) goto L_0x004f
                r3 = 57
                if (r7 <= r3) goto L_0x005f
            L_0x004f:
                r3 = 43
                if (r7 == r3) goto L_0x005f
                r3 = 45
                if (r7 == r3) goto L_0x005f
                r3 = 46
                if (r7 != r3) goto L_0x005c
                goto L_0x005f
            L_0x005c:
                if (r7 != r13) goto L_0x0020
                goto L_0x0062
            L_0x005f:
                r3 = 90
                goto L_0x0038
            L_0x0062:
                if (r2 == r14) goto L_0x0091
                r3 = 1
                r6 = 0
                r7 = 6
                java.lang.String r5 = "https:"
                r2 = r35
                r4 = r8
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x0079
                java.lang.String r2 = "https"
                r0.f9543a = r2
                int r8 = r8 + 6
                goto L_0x0097
            L_0x0079:
                r3 = 1
                r6 = 0
                r7 = 5
                java.lang.String r5 = "http:"
                r2 = r35
                r4 = r8
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x008e
                java.lang.String r2 = "http"
                r0.f9543a = r2
                int r8 = r8 + 5
                goto L_0x0097
            L_0x008e:
                g.r$a$a r1 = g.r.a.C0141a.UNSUPPORTED_SCHEME
                return r1
            L_0x0091:
                if (r1 == 0) goto L_0x034f
                java.lang.String r2 = r1.f9535a
                r0.f9543a = r2
            L_0x0097:
                r2 = r8
                r3 = r11
            L_0x0099:
                r7 = 47
                r6 = 92
                if (r2 >= r12) goto L_0x00ac
                char r4 = r10.charAt(r2)
                if (r4 == r6) goto L_0x00a7
                if (r4 != r7) goto L_0x00ac
            L_0x00a7:
                int r3 = r3 + 1
                int r2 = r2 + 1
                goto L_0x0099
            L_0x00ac:
                r5 = 63
                r4 = 35
                if (r3 >= r9) goto L_0x00f2
                if (r1 == 0) goto L_0x00f2
                java.lang.String r2 = r1.f9535a
                java.lang.String r9 = r0.f9543a
                boolean r2 = r2.equals(r9)
                if (r2 != 0) goto L_0x00bf
                goto L_0x00f2
            L_0x00bf:
                java.lang.String r2 = r34.e()
                r0.f9544b = r2
                java.lang.String r2 = r34.a()
                r0.f9545c = r2
                java.lang.String r2 = r1.f9538d
                r0.f9546d = r2
                int r2 = r1.f9539e
                r0.f9547e = r2
                java.util.List<java.lang.String> r2 = r0.f9548f
                r2.clear()
                java.util.List<java.lang.String> r2 = r0.f9548f
                java.util.List r3 = r34.c()
                r2.addAll(r3)
                if (r8 == r12) goto L_0x00e9
                char r2 = r10.charAt(r8)
                if (r2 != r4) goto L_0x0211
            L_0x00e9:
                java.lang.String r1 = r34.d()
                r0.a(r1)
                goto L_0x0211
            L_0x00f2:
                int r8 = r8 + r3
                r2 = r8
                r16 = r11
                r17 = r16
            L_0x00f8:
                java.lang.String r1 = "@/\\?#"
                int r9 = g.d0.c.a(r10, r2, r12, r1)
                if (r9 == r12) goto L_0x0105
                char r1 = r10.charAt(r9)
                goto L_0x0106
            L_0x0105:
                r1 = r14
            L_0x0106:
                if (r1 == r14) goto L_0x01ae
                if (r1 == r4) goto L_0x01ae
                if (r1 == r7) goto L_0x01ae
                if (r1 == r6) goto L_0x01ae
                if (r1 == r5) goto L_0x01ae
                r3 = 64
                if (r1 == r3) goto L_0x0116
                goto L_0x01a1
            L_0x0116:
                java.lang.String r8 = "%40"
                if (r16 != 0) goto L_0x0177
                int r3 = g.d0.c.a(r10, r2, r9, r13)
                r18 = 1
                r19 = 0
                r20 = 0
                r21 = 1
                r22 = 0
                java.lang.String r23 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r35
                r34 = r3
                r11 = r4
                r4 = r23
                r11 = r5
                r5 = r18
                r11 = r6
                r6 = r19
                r11 = r7
                r7 = r20
                r11 = r8
                r8 = r21
                r14 = r9
                r9 = r22
                java.lang.String r1 = g.r.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                if (r17 == 0) goto L_0x015a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r0.f9544b
                r2.append(r3)
                r2.append(r11)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
            L_0x015a:
                r0.f9544b = r1
                r1 = r34
                if (r1 == r14) goto L_0x0174
                int r2 = r1 + 1
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r9 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r35
                r3 = r14
                java.lang.String r1 = g.r.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0.f9545c = r1
                r16 = r15
            L_0x0174:
                r17 = r15
                goto L_0x019f
            L_0x0177:
                r11 = r8
                r14 = r9
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r1 = r0.f9545c
                r9.append(r1)
                r9.append(r11)
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r11 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r35
                r3 = r14
                r15 = r9
                r9 = r11
                java.lang.String r1 = g.r.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r15.append(r1)
                java.lang.String r1 = r15.toString()
                r0.f9545c = r1
            L_0x019f:
                int r2 = r14 + 1
            L_0x01a1:
                r4 = 35
                r5 = 63
                r6 = 92
                r7 = 47
                r11 = 0
                r14 = -1
                r15 = 1
                goto L_0x00f8
            L_0x01ae:
                r14 = r9
                r9 = r2
            L_0x01b0:
                if (r9 >= r14) goto L_0x01cc
                char r1 = r10.charAt(r9)
                if (r1 == r13) goto L_0x01cd
                r3 = 91
                if (r1 == r3) goto L_0x01be
                r1 = 1
                goto L_0x01ca
            L_0x01be:
                r1 = 1
            L_0x01bf:
                int r9 = r9 + r1
                if (r9 >= r14) goto L_0x01ca
                char r3 = r10.charAt(r9)
                r4 = 93
                if (r3 != r4) goto L_0x01bf
            L_0x01ca:
                int r9 = r9 + r1
                goto L_0x01b0
            L_0x01cc:
                r9 = r14
            L_0x01cd:
                int r3 = r9 + 1
                if (r3 >= r14) goto L_0x01fb
                java.lang.String r1 = a(r10, r2, r9)
                r0.f9546d = r1
                java.lang.String r4 = ""
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 1
                r9 = 0
                r1 = r35
                r2 = r3
                r3 = r14
                java.lang.String r1 = g.r.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NumberFormatException -> 0x01f2 }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x01f2 }
                if (r1 <= 0) goto L_0x01f2
                r2 = 65535(0xffff, float:9.1834E-41)
                if (r1 > r2) goto L_0x01f2
                goto L_0x01f3
            L_0x01f2:
                r1 = -1
            L_0x01f3:
                r0.f9547e = r1
                r2 = -1
                if (r1 != r2) goto L_0x0209
                g.r$a$a r1 = g.r.a.C0141a.INVALID_PORT
                return r1
            L_0x01fb:
                java.lang.String r1 = a(r10, r2, r9)
                r0.f9546d = r1
                java.lang.String r1 = r0.f9543a
                int r1 = g.r.a(r1)
                r0.f9547e = r1
            L_0x0209:
                java.lang.String r1 = r0.f9546d
                if (r1 != 0) goto L_0x0210
                g.r$a$a r1 = g.r.a.C0141a.INVALID_HOST
                return r1
            L_0x0210:
                r8 = r14
            L_0x0211:
                java.lang.String r1 = "?#"
                int r1 = g.d0.c.a(r10, r8, r12, r1)
                if (r8 != r1) goto L_0x021b
                goto L_0x0309
            L_0x021b:
                char r2 = r10.charAt(r8)
                java.lang.String r3 = ""
                r4 = 47
                if (r2 == r4) goto L_0x0239
                r4 = 92
                if (r2 != r4) goto L_0x022a
                goto L_0x0239
            L_0x022a:
                java.util.List<java.lang.String> r2 = r0.f9548f
                int r4 = r2.size()
                r5 = 1
                int r4 = r4 - r5
                r2.set(r4, r3)
                r6 = r0
                r2 = r1
                r4 = r10
                goto L_0x0248
            L_0x0239:
                r5 = 1
                java.util.List<java.lang.String> r2 = r0.f9548f
                r2.clear()
                java.util.List<java.lang.String> r2 = r0.f9548f
                r2.add(r3)
                r6 = r0
                r2 = r1
                r4 = r10
            L_0x0247:
                int r8 = r8 + r5
            L_0x0248:
                if (r8 >= r2) goto L_0x0309
                java.lang.String r5 = "/\\"
                int r5 = g.d0.c.a(r4, r8, r2, r5)
                if (r5 >= r2) goto L_0x0254
                r7 = 1
                goto L_0x0255
            L_0x0254:
                r7 = 0
            L_0x0255:
                r28 = 1
                r29 = 0
                r30 = 0
                r31 = 1
                r32 = 0
                java.lang.String r27 = " \"<>^`{}|/\\?#"
                r24 = r4
                r25 = r8
                r26 = r5
                java.lang.String r8 = g.r.a(r24, r25, r26, r27, r28, r29, r30, r31, r32)
                java.lang.String r9 = "."
                boolean r9 = r8.equals(r9)
                if (r9 != 0) goto L_0x027e
                java.lang.String r9 = "%2e"
                boolean r9 = r8.equalsIgnoreCase(r9)
                if (r9 == 0) goto L_0x027c
                goto L_0x027e
            L_0x027c:
                r9 = 0
                goto L_0x027f
            L_0x027e:
                r9 = 1
            L_0x027f:
                if (r9 == 0) goto L_0x0284
                r11 = -1
                goto L_0x0303
            L_0x0284:
                java.lang.String r9 = ".."
                boolean r9 = r8.equals(r9)
                if (r9 != 0) goto L_0x02a7
                java.lang.String r9 = "%2e."
                boolean r9 = r8.equalsIgnoreCase(r9)
                if (r9 != 0) goto L_0x02a7
                java.lang.String r9 = ".%2e"
                boolean r9 = r8.equalsIgnoreCase(r9)
                if (r9 != 0) goto L_0x02a7
                java.lang.String r9 = "%2e%2e"
                boolean r9 = r8.equalsIgnoreCase(r9)
                if (r9 == 0) goto L_0x02a5
                goto L_0x02a7
            L_0x02a5:
                r9 = 0
                goto L_0x02a8
            L_0x02a7:
                r9 = 1
            L_0x02a8:
                if (r9 == 0) goto L_0x02d7
                java.util.List<java.lang.String> r8 = r6.f9548f
                int r9 = r8.size()
                r11 = -1
                int r9 = r9 + r11
                java.lang.Object r8 = r8.remove(r9)
                java.lang.String r8 = (java.lang.String) r8
                boolean r8 = r8.isEmpty()
                if (r8 == 0) goto L_0x02d1
                java.util.List<java.lang.String> r8 = r6.f9548f
                boolean r8 = r8.isEmpty()
                if (r8 != 0) goto L_0x02d1
                java.util.List<java.lang.String> r8 = r6.f9548f
                int r9 = r8.size()
                int r9 = r9 + r11
                r8.set(r9, r3)
                goto L_0x0303
            L_0x02d1:
                java.util.List<java.lang.String> r8 = r6.f9548f
                r8.add(r3)
                goto L_0x0303
            L_0x02d7:
                r11 = -1
                java.util.List<java.lang.String> r9 = r6.f9548f
                int r13 = r9.size()
                r14 = 1
                int r13 = r13 - r14
                java.lang.Object r9 = r9.get(r13)
                java.lang.String r9 = (java.lang.String) r9
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x02f7
                java.util.List<java.lang.String> r9 = r6.f9548f
                int r13 = r9.size()
                int r13 = r13 - r14
                r9.set(r13, r8)
                goto L_0x02fc
            L_0x02f7:
                java.util.List<java.lang.String> r9 = r6.f9548f
                r9.add(r8)
            L_0x02fc:
                if (r7 == 0) goto L_0x0303
                java.util.List<java.lang.String> r8 = r6.f9548f
                r8.add(r3)
            L_0x0303:
                r8 = r5
                if (r7 == 0) goto L_0x0248
                r5 = 1
                goto L_0x0247
            L_0x0309:
                if (r1 >= r12) goto L_0x0330
                char r2 = r10.charAt(r1)
                r3 = 63
                if (r2 != r3) goto L_0x0330
                r2 = 35
                int r11 = g.d0.c.a(r10, r1, r12, r2)
                int r2 = r1 + 1
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 1
                r9 = 0
                java.lang.String r4 = " \"'<>#"
                r1 = r35
                r3 = r11
                java.lang.String r1 = g.r.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                java.util.List r1 = g.r.b(r1)
                r0.f9549g = r1
                r1 = r11
            L_0x0330:
                if (r1 >= r12) goto L_0x034c
                char r2 = r10.charAt(r1)
                r3 = 35
                if (r2 != r3) goto L_0x034c
                r2 = 1
                int r2 = r2 + r1
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                java.lang.String r4 = ""
                r1 = r35
                r3 = r12
                java.lang.String r1 = g.r.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0.f9550h = r1
            L_0x034c:
                g.r$a$a r1 = g.r.a.C0141a.SUCCESS
                return r1
            L_0x034f:
                g.r$a$a r1 = g.r.a.C0141a.MISSING_SCHEME
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: g.r.a.a(g.r, java.lang.String):g.r$a$a");
        }

        public static String a(String str, int i2, int i3) {
            return c.a(r.a(str, i2, i3, false));
        }
    }

    public r(a aVar) {
        this.f9535a = aVar.f9543a;
        this.f9536b = a(aVar.f9544b, false);
        this.f9537c = a(aVar.f9545c, false);
        this.f9538d = aVar.f9546d;
        int i2 = aVar.f9547e;
        if (i2 == -1) {
            i2 = a(aVar.f9543a);
        }
        this.f9539e = i2;
        a(aVar.f9548f, false);
        List<String> list = aVar.f9549g;
        String str = null;
        this.f9540f = list != null ? a(list, true) : null;
        String str2 = aVar.f9550h;
        if (str2 != null) {
            str = a(str2, 0, str2.length(), false);
        }
        this.f9541g = str;
        this.f9542h = aVar.toString();
    }

    public String a() {
        if (this.f9537c.isEmpty()) {
            return "";
        }
        return this.f9542h.substring(this.f9542h.indexOf(58, this.f9535a.length() + 3) + 1, this.f9542h.indexOf(64));
    }

    public String b() {
        int indexOf = this.f9542h.indexOf(47, this.f9535a.length() + 3);
        String str = this.f9542h;
        return this.f9542h.substring(indexOf, c.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> c() {
        int indexOf = this.f9542h.indexOf(47, this.f9535a.length() + 3);
        String str = this.f9542h;
        int a2 = c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.f9542h, i2, a2, '/');
            arrayList.add(this.f9542h.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String d() {
        if (this.f9540f == null) {
            return null;
        }
        int indexOf = this.f9542h.indexOf(63) + 1;
        String str = this.f9542h;
        return this.f9542h.substring(indexOf, c.a(str, indexOf + 1, str.length(), '#'));
    }

    public String e() {
        if (this.f9536b.isEmpty()) {
            return "";
        }
        int length = this.f9535a.length() + 3;
        String str = this.f9542h;
        return this.f9542h.substring(length, c.a(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && ((r) obj).f9542h.equals(this.f9542h);
    }

    public URI f() {
        String str;
        a aVar = new a();
        aVar.f9543a = this.f9535a;
        aVar.f9544b = e();
        aVar.f9545c = a();
        aVar.f9546d = this.f9538d;
        aVar.f9547e = this.f9539e != a(this.f9535a) ? this.f9539e : -1;
        aVar.f9548f.clear();
        aVar.f9548f.addAll(c());
        aVar.a(d());
        if (this.f9541g == null) {
            str = null;
        } else {
            str = this.f9542h.substring(this.f9542h.indexOf(35) + 1);
        }
        aVar.f9550h = str;
        int size = aVar.f9548f.size();
        for (int i2 = 0; i2 < size; i2++) {
            aVar.f9548f.set(i2, a((String) aVar.f9548f.get(i2), "[]", true, true, false, true));
        }
        List<String> list = aVar.f9549g;
        if (list != null) {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str2 = (String) aVar.f9549g.get(i3);
                if (str2 != null) {
                    aVar.f9549g.set(i3, a(str2, "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str3 = aVar.f9550h;
        if (str3 != null) {
            aVar.f9550h = a(str3, " \"#<>\\^`{|}", true, true, false, false);
        }
        String aVar2 = aVar.toString();
        try {
            return new URI(aVar2);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public int hashCode() {
        return this.f9542h.hashCode();
    }

    public String toString() {
        return this.f9542h;
    }

    public static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = (String) list.get(i2);
            String str2 = (String) list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    public final List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = (String) list.get(i2);
            arrayList.add(str != null ? a(str, 0, str.length(), z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String a(String str, int i2, int i3, boolean z) {
        int i4 = i2;
        while (i4 < i3) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                e eVar = new e();
                eVar.b(str, i2, i4);
                while (i4 < i3) {
                    int codePointAt = str.codePointAt(i4);
                    if (codePointAt == 37) {
                        int i5 = i4 + 2;
                        if (i5 < i3) {
                            int a2 = c.a(str.charAt(i4 + 1));
                            int a3 = c.a(str.charAt(i5));
                            if (!(a2 == -1 || a3 == -1)) {
                                eVar.writeByte((a2 << 4) + a3);
                                i4 = i5;
                                i4 += Character.charCount(codePointAt);
                            }
                            eVar.b(codePointAt);
                            i4 += Character.charCount(codePointAt);
                        }
                    }
                    if (codePointAt == 43 && z) {
                        eVar.writeByte(32);
                        i4 += Character.charCount(codePointAt);
                    }
                    eVar.b(codePointAt);
                    i4 += Character.charCount(codePointAt);
                }
                return eVar.e();
            }
            i4++;
        }
        return str.substring(i2, i3);
    }

    public static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || c.a(str.charAt(i2 + 1)) == -1 || c.a(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i4 = i3;
        String str4 = str2;
        Charset charset2 = charset;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str3.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str3, i5, i4)))) || (codePointAt == 43 && z3)))) {
                e eVar = new e();
                eVar.b(str3, i2, i5);
                e eVar2 = null;
                while (i5 < i4) {
                    int codePointAt2 = str3.codePointAt(i5);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 == 43 && z3) {
                            eVar.c(z ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z4) || str4.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z || (z2 && !a(str3, i5, i4)))))) {
                            if (eVar2 == null) {
                                eVar2 = new e();
                            }
                            if (charset2 == null || charset2.equals(c.f9183j)) {
                                eVar2.b(codePointAt2);
                            } else {
                                eVar2.a(str3, i5, Character.charCount(codePointAt2) + i5, charset2);
                            }
                            while (!eVar2.g()) {
                                byte readByte = eVar2.readByte() & 255;
                                eVar.writeByte(37);
                                eVar.writeByte((int) f9534i[(readByte >> 4) & 15]);
                                eVar.writeByte((int) f9534i[readByte & 15]);
                            }
                        } else {
                            eVar.b(codePointAt2);
                        }
                    }
                    i5 += Character.charCount(codePointAt2);
                }
                return eVar.e();
            }
            i5 += Character.charCount(codePointAt);
        }
        int i6 = i2;
        return str.substring(i2, i3);
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
