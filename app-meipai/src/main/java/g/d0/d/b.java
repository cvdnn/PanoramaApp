package g.d0.d;

import com.baidubce.http.Headers;
import com.facebook.stetho.websocket.WebSocketHandler;
import g.s;
import g.z;
import g.z.a;

/* compiled from: CacheInterceptor */
public final class b implements s {

    /* renamed from: a reason: collision with root package name */
    public final e f9190a;

    public b(e eVar) {
        this.f9190a = eVar;
    }

    public static z a(z zVar) {
        if (zVar == null || zVar.f9620g == null) {
            return zVar;
        }
        a aVar = new a(zVar);
        aVar.f9630g = null;
        return aVar.a();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [g.x, g.z] */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015b, code lost:
        if (r4 > 0) goto L_0x015d;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v1, types: [g.x, g.z]
  assigns: []
  uses: [g.x, g.z]
  mth insns count: 442
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02fd A[SYNTHETIC, Splitter:B:144:0x02fd] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01c6  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g.z intercept(g.s.a r27) throws java.io.IOException {
        /*
            r26 = this;
            r1 = r26
            g.d0.d.e r0 = r1.f9190a
            if (r0 == 0) goto L_0x0012
            r3 = r27
            g.d0.f.f r3 = (g.d0.f.f) r3
            g.x r3 = r3.f9242f
            g.z r0 = r0.b(r3)
            r3 = r0
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            long r4 = java.lang.System.currentTimeMillis()
            r0 = r27
            g.d0.f.f r0 = (g.d0.f.f) r0
            g.x r6 = r0.f9242f
            if (r3 == 0) goto L_0x008b
            long r11 = r3.k
            long r13 = r3.l
            g.q r15 = r3.f9619f
            int r8 = r15.b()
            r9 = 0
            r10 = -1
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0037:
            if (r9 >= r8) goto L_0x009c
            java.lang.String r2 = r15.a(r9)
            java.lang.String r7 = r15.b(r9)
            r22 = r8
            java.lang.String r8 = "Date"
            boolean r8 = r8.equalsIgnoreCase(r2)
            if (r8 == 0) goto L_0x0052
            java.util.Date r16 = g.d0.f.d.a(r7)
            r21 = r7
            goto L_0x0086
        L_0x0052:
            java.lang.String r8 = "Expires"
            boolean r8 = r8.equalsIgnoreCase(r2)
            if (r8 == 0) goto L_0x005f
            java.util.Date r17 = g.d0.f.d.a(r7)
            goto L_0x0086
        L_0x005f:
            java.lang.String r8 = "Last-Modified"
            boolean r8 = r8.equalsIgnoreCase(r2)
            if (r8 == 0) goto L_0x006e
            java.util.Date r18 = g.d0.f.d.a(r7)
            r20 = r7
            goto L_0x0086
        L_0x006e:
            java.lang.String r8 = "ETag"
            boolean r8 = r8.equalsIgnoreCase(r2)
            if (r8 == 0) goto L_0x0079
            r19 = r7
            goto L_0x0086
        L_0x0079:
            java.lang.String r8 = "Age"
            boolean r2 = r8.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0086
            r2 = -1
            int r10 = g.d0.f.e.a(r7, r2)
        L_0x0086:
            int r9 = r9 + 1
            r8 = r22
            goto L_0x0037
        L_0x008b:
            r10 = -1
            r11 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x009c:
            java.lang.String r2 = "Warning"
            if (r3 != 0) goto L_0x00a7
            g.d0.d.d r4 = new g.d0.d.d
            r8 = 0
            r4.<init>(r6, r8)
            goto L_0x00c9
        L_0x00a7:
            r8 = 0
            g.r r9 = r6.f9595a
            java.lang.String r9 = r9.f9535a
            java.lang.String r15 = "https"
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x00be
            g.p r9 = r3.f9618e
            if (r9 != 0) goto L_0x00be
            g.d0.d.d r4 = new g.d0.d.d
            r4.<init>(r6, r8)
            goto L_0x00c9
        L_0x00be:
            boolean r9 = g.d0.d.d.a(r3, r6)
            if (r9 != 0) goto L_0x00cf
            g.d0.d.d r4 = new g.d0.d.d
            r4.<init>(r6, r8)
        L_0x00c9:
            r25 = r0
            r0 = r6
        L_0x00cc:
            r1 = 0
            goto L_0x028f
        L_0x00cf:
            g.d r8 = r6.a()
            boolean r9 = r8.f9154a
            if (r9 != 0) goto L_0x0286
            g.q r9 = r6.f9597c
            java.lang.String r15 = "If-Modified-Since"
            java.lang.String r9 = r9.a(r15)
            java.lang.String r7 = "If-None-Match"
            if (r9 != 0) goto L_0x00ee
            g.q r9 = r6.f9597c
            java.lang.String r9 = r9.a(r7)
            if (r9 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r9 = 0
            goto L_0x00ef
        L_0x00ee:
            r9 = 1
        L_0x00ef:
            if (r9 == 0) goto L_0x00f3
            goto L_0x0286
        L_0x00f3:
            g.d r9 = r3.a()
            r23 = r7
            boolean r7 = r9.l
            if (r7 == 0) goto L_0x0109
            g.d0.d.d r4 = new g.d0.d.d
            r5 = 0
            r4.<init>(r5, r3)
            r25 = r0
            r1 = r5
            r0 = r6
            goto L_0x028f
        L_0x0109:
            if (r16 == 0) goto L_0x011d
            long r24 = r16.getTime()
            r7 = r0
            long r0 = r13 - r24
            r24 = r6
            r25 = r7
            r6 = 0
            long r0 = java.lang.Math.max(r6, r0)
            goto L_0x0123
        L_0x011d:
            r25 = r0
            r24 = r6
            r0 = 0
        L_0x0123:
            r6 = -1
            if (r10 == r6) goto L_0x0133
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            r7 = r9
            long r9 = (long) r10
            long r9 = r6.toMillis(r9)
            long r0 = java.lang.Math.max(r0, r9)
            goto L_0x0134
        L_0x0133:
            r7 = r9
        L_0x0134:
            long r9 = r13 - r11
            long r4 = r4 - r13
            long r0 = r0 + r9
            long r0 = r0 + r4
            g.d r4 = r3.a()
            int r4 = r4.f9156c
            r5 = -1
            if (r4 == r5) goto L_0x014a
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            long r9 = (long) r4
            long r4 = r5.toMillis(r9)
            goto L_0x015d
        L_0x014a:
            if (r17 == 0) goto L_0x0161
            if (r16 == 0) goto L_0x0152
            long r13 = r16.getTime()
        L_0x0152:
            long r4 = r17.getTime()
            long r4 = r4 - r13
            r9 = 0
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0193
        L_0x015d:
            r9 = r4
            r4 = 0
            goto L_0x0196
        L_0x0161:
            if (r18 == 0) goto L_0x0193
            g.x r4 = r3.f9614a
            g.r r4 = r4.f9595a
            java.util.List<java.lang.String> r5 = r4.f9540f
            if (r5 != 0) goto L_0x016d
            r4 = 0
            goto L_0x017b
        L_0x016d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.List<java.lang.String> r4 = r4.f9540f
            g.r.a(r5, r4)
            java.lang.String r4 = r5.toString()
        L_0x017b:
            if (r4 != 0) goto L_0x0193
            if (r16 == 0) goto L_0x0183
            long r11 = r16.getTime()
        L_0x0183:
            long r4 = r18.getTime()
            long r11 = r11 - r4
            r4 = 0
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0195
            r9 = 10
            long r9 = r11 / r9
            goto L_0x0196
        L_0x0193:
            r4 = 0
        L_0x0195:
            r9 = r4
        L_0x0196:
            int r6 = r8.f9156c
            r11 = -1
            if (r6 == r11) goto L_0x01a6
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS
            long r13 = (long) r6
            long r12 = r12.toMillis(r13)
            long r9 = java.lang.Math.min(r9, r12)
        L_0x01a6:
            int r6 = r8.f9162i
            if (r6 == r11) goto L_0x01b2
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS
            long r13 = (long) r6
            long r12 = r12.toMillis(r13)
            goto L_0x01b3
        L_0x01b2:
            r12 = r4
        L_0x01b3:
            boolean r6 = r7.f9160g
            if (r6 != 0) goto L_0x01c2
            int r6 = r8.f9161h
            if (r6 == r11) goto L_0x01c2
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            long r5 = (long) r6
            long r4 = r4.toMillis(r5)
        L_0x01c2:
            boolean r6 = r7.f9154a
            if (r6 != 0) goto L_0x0226
            long r12 = r12 + r0
            long r4 = r4 + r9
            int r4 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0226
            g.z$a r4 = new g.z$a
            r4.<init>(r3)
            int r5 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x01ea
            java.lang.String r5 = "110 HttpURLConnection \"Response is stale\""
            g.q$a r6 = r4.f9629f
            r6.b(r2, r5)
            java.util.List<java.lang.String> r7 = r6.f9533a
            r7.add(r2)
            java.util.List<java.lang.String> r6 = r6.f9533a
            java.lang.String r5 = r5.trim()
            r6.add(r5)
        L_0x01ea:
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0216
            g.d r0 = r3.a()
            int r0 = r0.f9156c
            r1 = -1
            if (r0 != r1) goto L_0x01fe
            if (r17 != 0) goto L_0x01fe
            r0 = 1
            goto L_0x01ff
        L_0x01fe:
            r0 = 0
        L_0x01ff:
            if (r0 == 0) goto L_0x0216
            java.lang.String r0 = "113 HttpURLConnection \"Heuristic expiration\""
            g.q$a r1 = r4.f9629f
            r1.b(r2, r0)
            java.util.List<java.lang.String> r5 = r1.f9533a
            r5.add(r2)
            java.util.List<java.lang.String> r1 = r1.f9533a
            java.lang.String r0 = r0.trim()
            r1.add(r0)
        L_0x0216:
            g.d0.d.d r0 = new g.d0.d.d
            g.z r1 = r4.a()
            r4 = 0
            r0.<init>(r4, r1)
            r1 = r4
            r4 = r0
            r0 = r24
            goto L_0x028f
        L_0x0226:
            if (r19 == 0) goto L_0x022d
            r15 = r23
        L_0x022a:
            r0 = r24
            goto L_0x0237
        L_0x022d:
            if (r18 == 0) goto L_0x0232
            r19 = r20
            goto L_0x022a
        L_0x0232:
            if (r16 == 0) goto L_0x027d
            r19 = r21
            goto L_0x022a
        L_0x0237:
            g.q r1 = r0.f9597c
            g.q$a r1 = r1.a()
            g.d0.a r4 = g.d0.a.f9172a
            g.u$a r4 = (g.u.a) r4
            if (r4 == 0) goto L_0x027b
            java.util.List<java.lang.String> r4 = r1.f9533a
            r4.add(r15)
            java.util.List<java.lang.String> r4 = r1.f9533a
            java.lang.String r5 = r19.trim()
            r4.add(r5)
            g.x$a r4 = new g.x$a
            r4.<init>(r0)
            java.util.List<java.lang.String> r1 = r1.f9533a
            int r5 = r1.size()
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r1 = r1.toArray(r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            g.q$a r5 = new g.q$a
            r5.<init>()
            java.util.List<java.lang.String> r6 = r5.f9533a
            java.util.Collections.addAll(r6, r1)
            r4.f9603c = r5
            g.x r1 = r4.a()
            g.d0.d.d r4 = new g.d0.d.d
            r4.<init>(r1, r3)
            goto L_0x00cc
        L_0x027b:
            r1 = 0
            throw r1
        L_0x027d:
            r0 = r24
            r1 = 0
            g.d0.d.d r4 = new g.d0.d.d
            r4.<init>(r0, r1)
            goto L_0x028f
        L_0x0286:
            r25 = r0
            r0 = r6
            r1 = 0
            g.d0.d.d r4 = new g.d0.d.d
            r4.<init>(r0, r1)
        L_0x028f:
            g.x r5 = r4.f9191a
            if (r5 == 0) goto L_0x02a0
            g.d r0 = r0.a()
            boolean r0 = r0.f9163j
            if (r0 == 0) goto L_0x02a0
            g.d0.d.d r4 = new g.d0.d.d
            r4.<init>(r1, r1)
        L_0x02a0:
            g.x r0 = r4.f9191a
            g.z r1 = r4.f9192b
            r5 = r26
            g.d0.d.e r6 = r5.f9190a
            if (r6 == 0) goto L_0x02ad
            r6.a(r4)
        L_0x02ad:
            if (r3 == 0) goto L_0x02b6
            if (r1 != 0) goto L_0x02b6
            g.a0 r4 = r3.f9620g
            g.d0.c.a(r4)
        L_0x02b6:
            if (r0 != 0) goto L_0x02e4
            if (r1 != 0) goto L_0x02e4
            g.z$a r0 = new g.z$a
            r0.<init>()
            r4 = r25
            g.x r1 = r4.f9242f
            r0.f9624a = r1
            g.v r1 = g.v.HTTP_1_1
            r0.f9625b = r1
            r1 = 504(0x1f8, float:7.06E-43)
            r0.f9626c = r1
            java.lang.String r1 = "Unsatisfiable Request (only-if-cached)"
            r0.f9627d = r1
            g.a0 r1 = g.d0.c.f9176c
            r0.f9630g = r1
            r1 = -1
            r0.k = r1
            long r1 = java.lang.System.currentTimeMillis()
            r0.l = r1
            g.z r0 = r0.a()
            return r0
        L_0x02e4:
            r4 = r25
            if (r0 != 0) goto L_0x02fd
            if (r1 == 0) goto L_0x02fb
            g.z$a r0 = new g.z$a
            r0.<init>(r1)
            g.z r1 = a(r1)
            r0.a(r1)
            g.z r0 = r0.a()
            return r0
        L_0x02fb:
            r0 = 0
            throw r0
        L_0x02fd:
            g.d0.e.g r6 = r4.f9238b     // Catch:{ all -> 0x047a }
            g.d0.f.c r7 = r4.f9239c     // Catch:{ all -> 0x047a }
            g.d0.e.c r8 = r4.f9240d     // Catch:{ all -> 0x047a }
            g.z r4 = r4.a(r0, r6, r7, r8)     // Catch:{ all -> 0x047a }
            if (r4 != 0) goto L_0x0310
            if (r3 == 0) goto L_0x0310
            g.a0 r3 = r3.f9620g
            g.d0.c.a(r3)
        L_0x0310:
            java.lang.String r3 = "networkResponse"
            if (r1 == 0) goto L_0x03cd
            int r6 = r4.f9616c
            r7 = 304(0x130, float:4.26E-43)
            if (r6 != r7) goto L_0x03c8
            g.z$a r0 = new g.z$a
            r0.<init>(r1)
            g.q r6 = r1.f9619f
            g.q r7 = r4.f9619f
            g.q$a r8 = new g.q$a
            r8.<init>()
            int r9 = r6.b()
            r10 = 0
        L_0x032d:
            if (r10 >= r9) goto L_0x035a
            java.lang.String r11 = r6.a(r10)
            java.lang.String r12 = r6.b(r10)
            boolean r13 = r2.equalsIgnoreCase(r11)
            if (r13 == 0) goto L_0x0346
            java.lang.String r13 = "1"
            boolean r13 = r12.startsWith(r13)
            if (r13 == 0) goto L_0x0346
            goto L_0x0357
        L_0x0346:
            boolean r13 = a(r11)
            if (r13 == 0) goto L_0x0352
            java.lang.String r13 = r7.a(r11)
            if (r13 != 0) goto L_0x0357
        L_0x0352:
            g.d0.a r13 = g.d0.a.f9172a
            r13.a(r8, r11, r12)
        L_0x0357:
            int r10 = r10 + 1
            goto L_0x032d
        L_0x035a:
            int r2 = r7.b()
            r6 = 0
        L_0x035f:
            if (r6 >= r2) goto L_0x0380
            java.lang.String r9 = r7.a(r6)
            java.lang.String r10 = "Content-Length"
            boolean r10 = r10.equalsIgnoreCase(r9)
            if (r10 == 0) goto L_0x036e
            goto L_0x037d
        L_0x036e:
            boolean r10 = a(r9)
            if (r10 == 0) goto L_0x037d
            g.d0.a r10 = g.d0.a.f9172a
            java.lang.String r11 = r7.b(r6)
            r10.a(r8, r9, r11)
        L_0x037d:
            int r6 = r6 + 1
            goto L_0x035f
        L_0x0380:
            java.util.List<java.lang.String> r2 = r8.f9533a
            int r6 = r2.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r2 = r2.toArray(r6)
            java.lang.String[] r2 = (java.lang.String[]) r2
            g.q$a r6 = new g.q$a
            r6.<init>()
            java.util.List<java.lang.String> r7 = r6.f9533a
            java.util.Collections.addAll(r7, r2)
            r0.f9629f = r6
            long r6 = r4.k
            r0.k = r6
            long r6 = r4.l
            r0.l = r6
            g.z r2 = a(r1)
            r0.a(r2)
            g.z r2 = a(r4)
            if (r2 == 0) goto L_0x03b2
            r0.a(r3, r2)
        L_0x03b2:
            r0.f9631h = r2
            g.z r0 = r0.a()
            g.a0 r2 = r4.f9620g
            r2.close()
            g.d0.d.e r2 = r5.f9190a
            r2.a()
            g.d0.d.e r2 = r5.f9190a
            r2.a(r1, r0)
            return r0
        L_0x03c8:
            g.a0 r2 = r1.f9620g
            g.d0.c.a(r2)
        L_0x03cd:
            if (r4 == 0) goto L_0x0478
            g.z$a r2 = new g.z$a
            r2.<init>(r4)
            g.z r1 = a(r1)
            r2.a(r1)
            g.z r1 = a(r4)
            if (r1 == 0) goto L_0x03e4
            r2.a(r3, r1)
        L_0x03e4:
            r2.f9631h = r1
            g.z r1 = r2.a()
            g.d0.d.e r2 = r5.f9190a
            if (r2 == 0) goto L_0x0477
            boolean r2 = g.d0.f.e.b(r1)
            if (r2 == 0) goto L_0x0442
            boolean r2 = g.d0.d.d.a(r1, r0)
            if (r2 == 0) goto L_0x0442
            g.d0.d.e r0 = r5.f9190a
            g.d0.d.c r0 = r0.a(r1)
            if (r0 != 0) goto L_0x0403
            goto L_0x0441
        L_0x0403:
            h.w r2 = r0.body()
            if (r2 != 0) goto L_0x040a
            goto L_0x0441
        L_0x040a:
            g.a0 r3 = r1.f9620g
            h.g r3 = r3.source()
            h.f r2 = h.o.a(r2)
            g.d0.d.a r4 = new g.d0.d.a
            r4.<init>(r5, r3, r0, r2)
            g.q r0 = r1.f9619f
            java.lang.String r2 = "Content-Type"
            java.lang.String r0 = r0.a(r2)
            if (r0 == 0) goto L_0x0425
            r2 = r0
            goto L_0x0426
        L_0x0425:
            r2 = 0
        L_0x0426:
            g.a0 r0 = r1.f9620g
            long r6 = r0.contentLength()
            g.z$a r0 = new g.z$a
            r0.<init>(r1)
            g.d0.f.g r1 = new g.d0.f.g
            h.s r3 = new h.s
            r3.<init>(r4)
            r1.<init>(r2, r6, r3)
            r0.f9630g = r1
            g.z r1 = r0.a()
        L_0x0441:
            return r1
        L_0x0442:
            java.lang.String r2 = r0.f9596b
            java.lang.String r3 = "POST"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x046f
            java.lang.String r3 = "PATCH"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x046f
            java.lang.String r3 = "PUT"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x046f
            java.lang.String r3 = "DELETE"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x046f
            java.lang.String r3 = "MOVE"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x046d
            goto L_0x046f
        L_0x046d:
            r8 = 0
            goto L_0x0470
        L_0x046f:
            r8 = 1
        L_0x0470:
            if (r8 == 0) goto L_0x0477
            g.d0.d.e r2 = r5.f9190a     // Catch:{ IOException -> 0x0477 }
            r2.a(r0)     // Catch:{ IOException -> 0x0477 }
        L_0x0477:
            return r1
        L_0x0478:
            r0 = 0
            throw r0
        L_0x047a:
            r0 = move-exception
            if (r3 == 0) goto L_0x0482
            g.a0 r1 = r3.f9620g
            g.d0.c.a(r1)
        L_0x0482:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.d.b.intercept(g.s$a):g.z");
    }

    public static boolean a(String str) {
        return !WebSocketHandler.HEADER_CONNECTION.equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !Headers.TRANSFER_ENCODING.equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }
}
