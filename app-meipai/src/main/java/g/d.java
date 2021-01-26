package g;

import java.util.concurrent.TimeUnit;

/* compiled from: CacheControl */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public final boolean f9154a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f9155b;

    /* renamed from: c reason: collision with root package name */
    public final int f9156c;

    /* renamed from: d reason: collision with root package name */
    public final int f9157d;

    /* renamed from: e reason: collision with root package name */
    public final boolean f9158e;

    /* renamed from: f reason: collision with root package name */
    public final boolean f9159f;

    /* renamed from: g reason: collision with root package name */
    public final boolean f9160g;

    /* renamed from: h reason: collision with root package name */
    public final int f9161h;

    /* renamed from: i reason: collision with root package name */
    public final int f9162i;

    /* renamed from: j reason: collision with root package name */
    public final boolean f9163j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* compiled from: CacheControl */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public boolean f9164a;

        /* renamed from: b reason: collision with root package name */
        public boolean f9165b;

        /* renamed from: c reason: collision with root package name */
        public int f9166c = -1;

        /* renamed from: d reason: collision with root package name */
        public int f9167d = -1;

        /* renamed from: e reason: collision with root package name */
        public int f9168e = -1;

        /* renamed from: f reason: collision with root package name */
        public boolean f9169f;

        /* renamed from: g reason: collision with root package name */
        public boolean f9170g;

        /* renamed from: h reason: collision with root package name */
        public boolean f9171h;
    }

    static {
        a aVar = new a();
        aVar.f9164a = true;
        new d(aVar);
        a aVar2 = new a();
        aVar2.f9169f = true;
        int i2 = Integer.MAX_VALUE;
        long seconds = TimeUnit.SECONDS.toSeconds((long) Integer.MAX_VALUE);
        if (seconds <= 2147483647L) {
            i2 = (int) seconds;
        }
        aVar2.f9167d = i2;
        new d(aVar2);
    }

    public d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.f9154a = z;
        this.f9155b = z2;
        this.f9156c = i2;
        this.f9157d = i3;
        this.f9158e = z3;
        this.f9159f = z4;
        this.f9160g = z5;
        this.f9161h = i4;
        this.f9162i = i5;
        this.f9163j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 191 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        if (r0 == 9) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static g.d a(g.q r22) {
        /*
            r0 = r22
            int r1 = r22.b()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0150
            java.lang.String r2 = r0.a(r6)
            java.lang.String r4 = r0.b(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0149
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0149
            java.lang.String r3 = "=,;"
            int r3 = g.d0.f.e.a(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x00a9
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x00a9
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0079
            goto L_0x00a9
        L_0x0066:
            int r0 = r4.length()
            if (r3 >= r0) goto L_0x007c
            char r0 = r4.charAt(r3)
            r5 = 32
            if (r0 == r5) goto L_0x0079
            r5 = 9
            if (r0 == r5) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            int r3 = r3 + 1
            goto L_0x0066
        L_0x007c:
            int r0 = r4.length()
            if (r3 >= r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 34
            if (r0 != r5) goto L_0x0099
            int r3 = r3 + 1
            java.lang.String r0 = "\""
            int r0 = g.d0.f.e.a(r4, r3, r0)
            java.lang.String r3 = r4.substring(r3, r0)
            r5 = 1
            int r0 = r0 + r5
            goto L_0x00ae
        L_0x0099:
            r5 = 1
            java.lang.String r0 = ",;"
            int r0 = g.d0.f.e.a(r4, r3, r0)
            java.lang.String r3 = r4.substring(r3, r0)
            java.lang.String r3 = r3.trim()
            goto L_0x00ae
        L_0x00a9:
            r5 = 1
            int r3 = r3 + 1
            r0 = r3
            r3 = 0
        L_0x00ae:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ba
            r5 = -1
            r9 = 1
            goto L_0x0144
        L_0x00ba:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c6
            r5 = -1
            r10 = 1
            goto L_0x0144
        L_0x00c6:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d5
            r5 = -1
            int r11 = g.d0.f.e.a(r3, r5)
            goto L_0x0144
        L_0x00d5:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e3
            r5 = -1
            int r12 = g.d0.f.e.a(r3, r5)
            goto L_0x0144
        L_0x00e3:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ee
            r5 = -1
            r13 = 1
            goto L_0x0144
        L_0x00ee:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f9
            r5 = -1
            r14 = 1
            goto L_0x0144
        L_0x00f9:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r5 = -1
            r15 = 1
            goto L_0x0144
        L_0x0104:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0115
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = g.d0.f.e.a(r3, r2)
            r5 = -1
            goto L_0x0144
        L_0x0115:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0123
            r5 = -1
            int r17 = g.d0.f.e.a(r3, r5)
            goto L_0x0144
        L_0x0123:
            r5 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x012f
            r18 = 1
            goto L_0x0144
        L_0x012f:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x013a
            r19 = 1
            goto L_0x0144
        L_0x013a:
            java.lang.String r3 = "immutable"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0144
            r20 = 1
        L_0x0144:
            r2 = r0
            r0 = r22
            goto L_0x003b
        L_0x0149:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x0150:
            if (r7 != 0) goto L_0x0155
            r21 = 0
            goto L_0x0157
        L_0x0155:
            r21 = r8
        L_0x0157:
            g.d r0 = new g.d
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d.a(g.q):g.d");
    }

    public String toString() {
        String str = this.m;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f9154a) {
                sb.append("no-cache, ");
            }
            if (this.f9155b) {
                sb.append("no-store, ");
            }
            String str2 = ", ";
            if (this.f9156c != -1) {
                sb.append("max-age=");
                sb.append(this.f9156c);
                sb.append(str2);
            }
            if (this.f9157d != -1) {
                sb.append("s-maxage=");
                sb.append(this.f9157d);
                sb.append(str2);
            }
            if (this.f9158e) {
                sb.append("private, ");
            }
            if (this.f9159f) {
                sb.append("public, ");
            }
            if (this.f9160g) {
                sb.append("must-revalidate, ");
            }
            if (this.f9161h != -1) {
                sb.append("max-stale=");
                sb.append(this.f9161h);
                sb.append(str2);
            }
            if (this.f9162i != -1) {
                sb.append("min-fresh=");
                sb.append(this.f9162i);
                sb.append(str2);
            }
            if (this.f9163j) {
                sb.append("only-if-cached, ");
            }
            if (this.k) {
                sb.append("no-transform, ");
            }
            if (this.l) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                str = "";
            } else {
                sb.delete(sb.length() - 2, sb.length());
                str = sb.toString();
            }
            this.m = str;
        }
        return str;
    }

    public d(a aVar) {
        this.f9154a = aVar.f9164a;
        this.f9155b = aVar.f9165b;
        this.f9156c = aVar.f9166c;
        this.f9157d = -1;
        this.f9158e = false;
        this.f9159f = false;
        this.f9160g = false;
        this.f9161h = aVar.f9167d;
        this.f9162i = aVar.f9168e;
        this.f9163j = aVar.f9169f;
        this.k = aVar.f9170g;
        this.l = aVar.f9171h;
    }
}
