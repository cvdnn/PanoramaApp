package d.h.i;

import java.util.Locale;

/* compiled from: BidiFormatter */
public final class a {

    /* renamed from: d reason: collision with root package name */
    public static final c f4872d = d.f4893c;

    /* renamed from: e reason: collision with root package name */
    public static final String f4873e = Character.toString(8206);

    /* renamed from: f reason: collision with root package name */
    public static final String f4874f = Character.toString(8207);

    /* renamed from: g reason: collision with root package name */
    public static final a f4875g = new a(false, 2, f4872d);

    /* renamed from: h reason: collision with root package name */
    public static final a f4876h = new a(true, 2, f4872d);

    /* renamed from: a reason: collision with root package name */
    public final boolean f4877a;

    /* renamed from: b reason: collision with root package name */
    public final int f4878b;

    /* renamed from: c reason: collision with root package name */
    public final c f4879c;

    /* renamed from: d.h.i.a$a reason: collision with other inner class name */
    /* compiled from: BidiFormatter */
    public static class C0038a {

        /* renamed from: f reason: collision with root package name */
        public static final byte[] f4880f = new byte[1792];

        /* renamed from: a reason: collision with root package name */
        public final CharSequence f4881a;

        /* renamed from: b reason: collision with root package name */
        public final boolean f4882b;

        /* renamed from: c reason: collision with root package name */
        public final int f4883c;

        /* renamed from: d reason: collision with root package name */
        public int f4884d;

        /* renamed from: e reason: collision with root package name */
        public char f4885e;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f4880f[i2] = Character.getDirectionality(i2);
            }
        }

        public C0038a(CharSequence charSequence, boolean z) {
            this.f4881a = charSequence;
            this.f4882b = z;
            this.f4883c = charSequence.length();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
            r7.f4884d = r0;
            r7.f4885e = '>';
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte a() {
            /*
                r7 = this;
                java.lang.CharSequence r0 = r7.f4881a
                int r1 = r7.f4884d
                int r1 = r1 + -1
                char r0 = r0.charAt(r1)
                r7.f4885e = r0
                boolean r0 = java.lang.Character.isLowSurrogate(r0)
                if (r0 == 0) goto L_0x0028
                java.lang.CharSequence r0 = r7.f4881a
                int r1 = r7.f4884d
                int r0 = java.lang.Character.codePointBefore(r0, r1)
                int r1 = r7.f4884d
                int r2 = java.lang.Character.charCount(r0)
                int r1 = r1 - r2
                r7.f4884d = r1
                byte r0 = java.lang.Character.getDirectionality(r0)
                return r0
            L_0x0028:
                int r0 = r7.f4884d
                int r0 = r0 + -1
                r7.f4884d = r0
                char r0 = r7.f4885e
                r1 = 1792(0x700, float:2.511E-42)
                if (r0 >= r1) goto L_0x0039
                byte[] r1 = f4880f
                byte r0 = r1[r0]
                goto L_0x003d
            L_0x0039:
                byte r0 = java.lang.Character.getDirectionality(r0)
            L_0x003d:
                boolean r1 = r7.f4882b
                if (r1 == 0) goto L_0x00aa
                char r1 = r7.f4885e
                r2 = 12
                r3 = 13
                r4 = 62
                if (r1 != r4) goto L_0x0087
                int r0 = r7.f4884d
            L_0x004d:
                int r1 = r7.f4884d
                if (r1 <= 0) goto L_0x0082
                java.lang.CharSequence r5 = r7.f4881a
                int r1 = r1 + -1
                r7.f4884d = r1
                char r1 = r5.charAt(r1)
                r7.f4885e = r1
                r5 = 60
                if (r1 != r5) goto L_0x0062
                goto L_0x00a1
            L_0x0062:
                if (r1 != r4) goto L_0x0065
                goto L_0x0082
            L_0x0065:
                r5 = 34
                if (r1 == r5) goto L_0x006d
                r5 = 39
                if (r1 != r5) goto L_0x004d
            L_0x006d:
                char r1 = r7.f4885e
            L_0x006f:
                int r5 = r7.f4884d
                if (r5 <= 0) goto L_0x004d
                java.lang.CharSequence r6 = r7.f4881a
                int r5 = r5 + -1
                r7.f4884d = r5
                char r5 = r6.charAt(r5)
                r7.f4885e = r5
                if (r5 == r1) goto L_0x004d
                goto L_0x006f
            L_0x0082:
                r7.f4884d = r0
                r7.f4885e = r4
                goto L_0x00a9
            L_0x0087:
                r4 = 59
                if (r1 != r4) goto L_0x00aa
                int r0 = r7.f4884d
            L_0x008d:
                int r1 = r7.f4884d
                if (r1 <= 0) goto L_0x00a5
                java.lang.CharSequence r5 = r7.f4881a
                int r1 = r1 + -1
                r7.f4884d = r1
                char r1 = r5.charAt(r1)
                r7.f4885e = r1
                r5 = 38
                if (r1 != r5) goto L_0x00a3
            L_0x00a1:
                r0 = r2
                goto L_0x00aa
            L_0x00a3:
                if (r1 != r4) goto L_0x008d
            L_0x00a5:
                r7.f4884d = r0
                r7.f4885e = r4
            L_0x00a9:
                r0 = r3
            L_0x00aa:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: d.h.i.a.C0038a.a():byte");
        }
    }

    public a(boolean z, int i2, c cVar) {
        this.f4877a = z;
        this.f4878b = i2;
        this.f4879c = cVar;
    }

    public static a a() {
        boolean z = true;
        if (e.a(Locale.getDefault()) != 1) {
            z = false;
        }
        c cVar = f4872d;
        if (cVar == f4872d) {
            return z ? f4876h : f4875g;
        }
        return new a(z, 2, cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r2 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(java.lang.CharSequence r6) {
        /*
            d.h.i.a$a r0 = new d.h.i.a$a
            r1 = 0
            r0.<init>(r6, r1)
            int r6 = r0.f4883c
            r0.f4884d = r6
            r6 = r1
        L_0x000b:
            r2 = r6
        L_0x000c:
            int r3 = r0.f4884d
            r4 = 1
            if (r3 <= 0) goto L_0x0041
            byte r3 = r0.a()
            if (r3 == 0) goto L_0x0039
            if (r3 == r4) goto L_0x0032
            r5 = 2
            if (r3 == r5) goto L_0x0032
            r5 = 9
            if (r3 == r5) goto L_0x000c
            switch(r3) {
                case 14: goto L_0x002c;
                case 15: goto L_0x002c;
                case 16: goto L_0x0029;
                case 17: goto L_0x0029;
                case 18: goto L_0x0026;
                default: goto L_0x0023;
            }
        L_0x0023:
            if (r6 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0029:
            if (r6 != r2) goto L_0x002f
            goto L_0x0034
        L_0x002c:
            if (r6 != r2) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            int r2 = r2 + -1
            goto L_0x000c
        L_0x0032:
            if (r2 != 0) goto L_0x0036
        L_0x0034:
            r1 = r4
            goto L_0x0041
        L_0x0036:
            if (r6 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0039:
            if (r2 != 0) goto L_0x003d
        L_0x003b:
            r1 = -1
            goto L_0x0041
        L_0x003d:
            if (r6 != 0) goto L_0x000c
        L_0x003f:
            r6 = r2
            goto L_0x000b
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.i.a.b(java.lang.CharSequence):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.CharSequence r13) {
        /*
            d.h.i.a$a r0 = new d.h.i.a$a
            r1 = 0
            r0.<init>(r13, r1)
            r0.f4884d = r1
            r13 = -1
            r2 = 1
            r3 = r1
            r4 = r3
            r5 = r4
        L_0x000d:
            int r6 = r0.f4884d
            int r7 = r0.f4883c
            if (r6 >= r7) goto L_0x00dc
            if (r3 != 0) goto L_0x00dc
            java.lang.CharSequence r7 = r0.f4881a
            char r6 = r7.charAt(r6)
            r0.f4885e = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L_0x003a
            java.lang.CharSequence r6 = r0.f4881a
            int r7 = r0.f4884d
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.f4884d
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.f4884d = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L_0x00b5
        L_0x003a:
            int r6 = r0.f4884d
            int r6 = r6 + r2
            r0.f4884d = r6
            char r6 = r0.f4885e
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L_0x004a
            byte[] r7 = d.h.i.a.C0038a.f4880f
            byte r6 = r7[r6]
            goto L_0x004e
        L_0x004a:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L_0x004e:
            boolean r7 = r0.f4882b
            r8 = 12
            if (r7 == 0) goto L_0x00b5
            char r7 = r0.f4885e
            r9 = 60
            if (r7 != r9) goto L_0x0099
            int r6 = r0.f4884d
        L_0x005c:
            int r7 = r0.f4884d
            int r10 = r0.f4883c
            if (r7 >= r10) goto L_0x0092
            java.lang.CharSequence r10 = r0.f4881a
            int r11 = r7 + 1
            r0.f4884d = r11
            char r7 = r10.charAt(r7)
            r0.f4885e = r7
            r10 = 62
            if (r7 != r10) goto L_0x0073
            goto L_0x00b4
        L_0x0073:
            r10 = 34
            if (r7 == r10) goto L_0x007b
            r10 = 39
            if (r7 != r10) goto L_0x005c
        L_0x007b:
            char r7 = r0.f4885e
        L_0x007d:
            int r10 = r0.f4884d
            int r11 = r0.f4883c
            if (r10 >= r11) goto L_0x005c
            java.lang.CharSequence r11 = r0.f4881a
            int r12 = r10 + 1
            r0.f4884d = r12
            char r10 = r11.charAt(r10)
            r0.f4885e = r10
            if (r10 == r7) goto L_0x005c
            goto L_0x007d
        L_0x0092:
            r0.f4884d = r6
            r0.f4885e = r9
            r6 = 13
            goto L_0x00b5
        L_0x0099:
            r9 = 38
            if (r7 != r9) goto L_0x00b5
        L_0x009d:
            int r6 = r0.f4884d
            int r7 = r0.f4883c
            if (r6 >= r7) goto L_0x00b4
            java.lang.CharSequence r7 = r0.f4881a
            int r9 = r6 + 1
            r0.f4884d = r9
            char r6 = r7.charAt(r6)
            r0.f4885e = r6
            r7 = 59
            if (r6 == r7) goto L_0x00b4
            goto L_0x009d
        L_0x00b4:
            r6 = r8
        L_0x00b5:
            if (r6 == 0) goto L_0x00d6
            if (r6 == r2) goto L_0x00d3
            r7 = 2
            if (r6 == r7) goto L_0x00d3
            r7 = 9
            if (r6 == r7) goto L_0x000d
            switch(r6) {
                case 14: goto L_0x00ce;
                case 15: goto L_0x00ce;
                case 16: goto L_0x00c9;
                case 17: goto L_0x00c9;
                case 18: goto L_0x00c4;
                default: goto L_0x00c3;
            }
        L_0x00c3:
            goto L_0x00d9
        L_0x00c4:
            int r5 = r5 + -1
            r4 = r1
            goto L_0x000d
        L_0x00c9:
            int r5 = r5 + 1
            r4 = r2
            goto L_0x000d
        L_0x00ce:
            int r5 = r5 + 1
            r4 = r13
            goto L_0x000d
        L_0x00d3:
            if (r5 != 0) goto L_0x00d9
            goto L_0x00f4
        L_0x00d6:
            if (r5 != 0) goto L_0x00d9
            goto L_0x00f8
        L_0x00d9:
            r3 = r5
            goto L_0x000d
        L_0x00dc:
            if (r3 != 0) goto L_0x00df
            goto L_0x00fd
        L_0x00df:
            if (r4 == 0) goto L_0x00e3
            r1 = r4
            goto L_0x00fd
        L_0x00e3:
            int r4 = r0.f4884d
            if (r4 <= 0) goto L_0x00fd
            byte r4 = r0.a()
            switch(r4) {
                case 14: goto L_0x00f6;
                case 15: goto L_0x00f6;
                case 16: goto L_0x00f2;
                case 17: goto L_0x00f2;
                case 18: goto L_0x00ef;
                default: goto L_0x00ee;
            }
        L_0x00ee:
            goto L_0x00e3
        L_0x00ef:
            int r5 = r5 + 1
            goto L_0x00e3
        L_0x00f2:
            if (r3 != r5) goto L_0x00fa
        L_0x00f4:
            r1 = r2
            goto L_0x00fd
        L_0x00f6:
            if (r3 != r5) goto L_0x00fa
        L_0x00f8:
            r1 = r13
            goto L_0x00fd
        L_0x00fa:
            int r5 = r5 + -1
            goto L_0x00e3
        L_0x00fd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.i.a.a(java.lang.CharSequence):int");
    }
}
