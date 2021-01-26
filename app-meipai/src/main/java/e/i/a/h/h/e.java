package e.i.a.h.h;

import e.a.a.a.a;
import e.i.a.c;
import e.i.a.h.b;
import e.i.a.h.d.g;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownloadCall */
public class e extends b implements Comparable<e> {

    /* renamed from: j reason: collision with root package name */
    public static final ExecutorService f8831j;

    /* renamed from: b reason: collision with root package name */
    public final c f8832b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f8833c;

    /* renamed from: d reason: collision with root package name */
    public final ArrayList<f> f8834d;

    /* renamed from: e reason: collision with root package name */
    public volatile d f8835e;

    /* renamed from: f reason: collision with root package name */
    public volatile boolean f8836f;

    /* renamed from: g reason: collision with root package name */
    public volatile boolean f8837g;

    /* renamed from: h reason: collision with root package name */
    public volatile Thread f8838h;

    /* renamed from: i reason: collision with root package name */
    public final g f8839i;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.i.a.h.c.a("OkDownload Block", false));
        f8831j = threadPoolExecutor;
    }

    public e(c cVar, boolean z, g gVar) {
        ArrayList<f> arrayList = new ArrayList<>();
        StringBuilder a2 = a.a("download call: ");
        a2.append(cVar.f8649b);
        super(a2.toString());
        this.f8832b = cVar;
        this.f8833c = z;
        this.f8834d = arrayList;
        this.f8839i = gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c1 A[EDGE_INSN: B:145:0x02c1->B:109:0x02c1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x027f A[LOOP:0: B:1:0x0025->B:93:0x027f, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() throws java.lang.InterruptedException {
        /*
            r18 = this;
            r1 = r18
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r1.f8838h = r0
            e.i.a.e r0 = e.i.a.e.a()
            e.i.a.h.j.g r2 = r0.f8669f
            e.i.a.h.d.g r3 = r1.f8839i
            e.i.a.c r4 = r1.f8832b
            int r4 = r4.f8649b
            r3.d(r4)
            e.i.a.e r3 = e.i.a.e.a()
            e.i.a.h.g.a r3 = r3.f8665b
            e.i.a.a r3 = r3.f8757a
            e.i.a.c r4 = r1.f8832b
            r3.taskStart(r4)
            r3 = 0
        L_0x0025:
            e.i.a.c r4 = r1.f8832b
            java.lang.String r4 = r4.f8650c
            int r4 = r4.length()
            if (r4 > 0) goto L_0x004e
            e.i.a.h.h.d$a r0 = new e.i.a.h.h.d$a
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "unexpected url: "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            e.i.a.c r4 = r1.f8832b
            java.lang.String r4 = r4.f8650c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r2)
            r1.f8835e = r0
            goto L_0x02c1
        L_0x004e:
            boolean r4 = r1.f8836f
            if (r4 == 0) goto L_0x0054
            goto L_0x02c1
        L_0x0054:
            e.i.a.h.d.g r4 = r1.f8839i     // Catch:{ IOException -> 0x02d0 }
            e.i.a.c r5 = r1.f8832b     // Catch:{ IOException -> 0x02d0 }
            int r5 = r5.f8649b     // Catch:{ IOException -> 0x02d0 }
            e.i.a.h.d.c r4 = r4.get(r5)     // Catch:{ IOException -> 0x02d0 }
            if (r4 != 0) goto L_0x0068
            e.i.a.h.d.g r4 = r1.f8839i     // Catch:{ IOException -> 0x02d0 }
            e.i.a.c r5 = r1.f8832b     // Catch:{ IOException -> 0x02d0 }
            e.i.a.h.d.c r4 = r4.a(r5)     // Catch:{ IOException -> 0x02d0 }
        L_0x0068:
            e.i.a.c r5 = r1.f8832b     // Catch:{ IOException -> 0x02d0 }
            r5.f8653f = r4     // Catch:{ IOException -> 0x02d0 }
            boolean r5 = r1.f8836f
            if (r5 == 0) goto L_0x0072
            goto L_0x02c1
        L_0x0072:
            e.i.a.e r5 = e.i.a.e.a()
            e.i.a.h.j.g r5 = r5.f8669f
            e.i.a.c r6 = r1.f8832b
            e.i.a.h.d.g r7 = r1.f8839i
            if (r5 == 0) goto L_0x02ce
            e.i.a.h.j.f r5 = new e.i.a.h.j.f
            r5.<init>(r6, r4, r7)
            e.i.a.h.h.d r11 = new e.i.a.h.h.d
            r11.<init>(r5)
            r1.f8835e = r11
            e.i.a.h.h.b r5 = new e.i.a.h.h.b
            e.i.a.c r6 = r1.f8832b
            r5.<init>(r6, r4)
            r5.a()     // Catch:{ IOException -> 0x02c7 }
            e.i.a.c r6 = r1.f8832b
            java.lang.String r7 = r6.z
            r11.f8822a = r7
            e.i.a.h.j.c r7 = r2.f8879a
            java.io.File r6 = r6.g()
            java.lang.String r6 = r6.getAbsolutePath()
            r7.c(r6)
            e.i.a.e r6 = e.i.a.e.a()
            e.i.a.h.h.g r6 = r6.f8670g
            e.i.a.c r7 = r1.f8832b
            long r8 = r5.f8810d
            if (r6 == 0) goto L_0x02c5
            boolean r6 = r7.u
            if (r6 != 0) goto L_0x00b8
            goto L_0x0120
        L_0x00b8:
            e.i.a.e r6 = e.i.a.e.a()
            e.i.a.h.d.g r6 = r6.f8666c
            e.i.a.h.d.c r7 = r6.a(r7, r4)
            if (r7 != 0) goto L_0x00c5
            goto L_0x0120
        L_0x00c5:
            int r10 = r7.f8702a
            r6.remove(r10)
            long r12 = r7.e()
            e.i.a.e r6 = e.i.a.e.a()
            e.i.a.h.h.g r6 = r6.f8670g
            if (r6 == 0) goto L_0x02c3
            r14 = 10240(0x2800, double:5.059E-320)
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 > 0) goto L_0x00dd
            goto L_0x0120
        L_0x00dd:
            java.lang.String r6 = r7.f8704c
            if (r6 == 0) goto L_0x00ea
            java.lang.String r10 = r4.f8704c
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x00ea
            goto L_0x0120
        L_0x00ea:
            long r12 = r7.d()
            int r6 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x00f3
            goto L_0x0120
        L_0x00f3:
            java.io.File r6 = r7.c()
            if (r6 == 0) goto L_0x0120
            java.io.File r6 = r7.c()
            boolean r6 = r6.exists()
            if (r6 != 0) goto L_0x0104
            goto L_0x0120
        L_0x0104:
            java.util.List<e.i.a.h.d.a> r6 = r4.f8708g
            r6.clear()
            java.util.List<e.i.a.h.d.a> r6 = r4.f8708g
            java.util.List<e.i.a.h.d.a> r7 = r7.f8708g
            r6.addAll(r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Reuse another same info: "
            r6.append(r7)
            r6.append(r4)
            r6.toString()
        L_0x0120:
            boolean r6 = r5.f8808b     // Catch:{ IOException -> 0x02bb }
            java.lang.String r7 = " "
            if (r6 == 0) goto L_0x0167
            long r8 = r5.f8810d     // Catch:{ IOException -> 0x02bb }
            e.i.a.h.h.a r6 = new e.i.a.h.h.a     // Catch:{ IOException -> 0x02bb }
            e.i.a.c r10 = r1.f8832b     // Catch:{ IOException -> 0x02bb }
            r6.<init>(r10, r4, r8)     // Catch:{ IOException -> 0x02bb }
            r6.a()     // Catch:{ IOException -> 0x02bb }
            boolean r8 = r6.f8800a     // Catch:{ IOException -> 0x02bb }
            if (r8 == 0) goto L_0x015d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02bb }
            r8.<init>()     // Catch:{ IOException -> 0x02bb }
            java.lang.String r9 = "breakpoint invalid: download from beginning because of local check is dirty "
            r8.append(r9)     // Catch:{ IOException -> 0x02bb }
            e.i.a.c r9 = r1.f8832b     // Catch:{ IOException -> 0x02bb }
            int r9 = r9.f8649b     // Catch:{ IOException -> 0x02bb }
            r8.append(r9)     // Catch:{ IOException -> 0x02bb }
            r8.append(r7)     // Catch:{ IOException -> 0x02bb }
            r8.append(r6)     // Catch:{ IOException -> 0x02bb }
            r8.toString()     // Catch:{ IOException -> 0x02bb }
            e.i.a.c r7 = r1.f8832b     // Catch:{ IOException -> 0x02bb }
            r2.a(r7)     // Catch:{ IOException -> 0x02bb }
            e.i.a.h.e.b r6 = r6.b()     // Catch:{ IOException -> 0x02bb }
            r1.a(r4, r5, r6)     // Catch:{ IOException -> 0x02bb }
            goto L_0x018d
        L_0x015d:
            e.i.a.h.g.a r5 = r0.f8665b     // Catch:{ IOException -> 0x02bb }
            e.i.a.a r5 = r5.f8757a     // Catch:{ IOException -> 0x02bb }
            e.i.a.c r6 = r1.f8832b     // Catch:{ IOException -> 0x02bb }
            r5.downloadFromBreakpoint(r6, r4)     // Catch:{ IOException -> 0x02bb }
            goto L_0x018d
        L_0x0167:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02bb }
            r6.<init>()     // Catch:{ IOException -> 0x02bb }
            java.lang.String r8 = "breakpoint invalid: download from beginning because of remote check not resumable "
            r6.append(r8)     // Catch:{ IOException -> 0x02bb }
            e.i.a.c r8 = r1.f8832b     // Catch:{ IOException -> 0x02bb }
            int r8 = r8.f8649b     // Catch:{ IOException -> 0x02bb }
            r6.append(r8)     // Catch:{ IOException -> 0x02bb }
            r6.append(r7)     // Catch:{ IOException -> 0x02bb }
            r6.append(r5)     // Catch:{ IOException -> 0x02bb }
            r6.toString()     // Catch:{ IOException -> 0x02bb }
            e.i.a.c r6 = r1.f8832b     // Catch:{ IOException -> 0x02bb }
            r2.a(r6)     // Catch:{ IOException -> 0x02bb }
            e.i.a.h.e.b r6 = r5.f8809c     // Catch:{ IOException -> 0x02bb }
            if (r6 == 0) goto L_0x02a2
            r1.a(r4, r5, r6)     // Catch:{ IOException -> 0x02bb }
        L_0x018d:
            int r12 = r4.b()
            java.util.ArrayList r13 = new java.util.ArrayList
            int r5 = r4.b()
            r13.<init>(r5)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r5 = 0
            r15 = r5
        L_0x01a1:
            if (r15 >= r12) goto L_0x0208
            e.i.a.h.d.a r5 = r4.a(r15)
            long r6 = r5.a()
            long r8 = r5.f8696b
            boolean r6 = e.i.a.h.c.a(r6, r8)
            if (r6 == 0) goto L_0x01b6
            r16 = r0
            goto L_0x0203
        L_0x01b6:
            long r6 = r5.a()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x01c1
            goto L_0x01cb
        L_0x01c1:
            long r6 = r5.a()
            long r8 = r5.f8696b
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x01cd
        L_0x01cb:
            r6 = 1
            goto L_0x01ce
        L_0x01cd:
            r6 = 0
        L_0x01ce:
            if (r6 == 0) goto L_0x01e7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "block is dirty so have to reset: "
            r6.append(r7)
            r6.append(r5)
            r6.toString()
            java.util.concurrent.atomic.AtomicLong r5 = r5.f8697c
            r6 = 0
            r5.set(r6)
        L_0x01e7:
            e.i.a.c r7 = r1.f8832b
            e.i.a.h.d.g r10 = r1.f8839i
            e.i.a.h.h.f r9 = new e.i.a.h.h.f
            r5 = r9
            r6 = r15
            r8 = r4
            r16 = r0
            r0 = r9
            r9 = r11
            r5.<init>(r6, r7, r8, r9, r10)
            r13.add(r0)
            int r0 = r0.f8840a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.add(r0)
        L_0x0203:
            int r15 = r15 + 1
            r0 = r16
            goto L_0x01a1
        L_0x0208:
            r16 = r0
            boolean r0 = r1.f8836f
            if (r0 == 0) goto L_0x020f
            goto L_0x025c
        L_0x020f:
            e.i.a.h.j.f r0 = r11.a()
            r0.u = r14
            java.util.ArrayList r4 = new java.util.ArrayList
            int r0 = r13.size()
            r4.<init>(r0)
            java.util.Iterator r0 = r13.iterator()     // Catch:{ all -> 0x0284 }
        L_0x0222:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x0284 }
            if (r5 == 0) goto L_0x0238
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x0284 }
            e.i.a.h.h.f r5 = (e.i.a.h.h.f) r5     // Catch:{ all -> 0x0284 }
            java.util.concurrent.ExecutorService r6 = f8831j     // Catch:{ all -> 0x0284 }
            java.util.concurrent.Future r5 = r6.submit(r5)     // Catch:{ all -> 0x0284 }
            r4.add(r5)     // Catch:{ all -> 0x0284 }
            goto L_0x0222
        L_0x0238:
            java.util.ArrayList<e.i.a.h.h.f> r0 = r1.f8834d     // Catch:{ all -> 0x0284 }
            r0.addAll(r13)     // Catch:{ all -> 0x0284 }
            java.util.Iterator r0 = r4.iterator()     // Catch:{ all -> 0x0284 }
        L_0x0241:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x0284 }
            if (r5 == 0) goto L_0x0257
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x0284 }
            java.util.concurrent.Future r5 = (java.util.concurrent.Future) r5     // Catch:{ all -> 0x0284 }
            boolean r6 = r5.isDone()     // Catch:{ all -> 0x0284 }
            if (r6 != 0) goto L_0x0241
            r5.get()     // Catch:{ CancellationException | ExecutionException -> 0x0241 }
            goto L_0x0241
        L_0x0257:
            java.util.ArrayList<e.i.a.h.h.f> r0 = r1.f8834d
            r0.removeAll(r13)
        L_0x025c:
            boolean r0 = r1.f8836f
            if (r0 == 0) goto L_0x0261
            goto L_0x02c1
        L_0x0261:
            boolean r0 = r11.f8824c
            if (r0 == 0) goto L_0x0276
            int r0 = r3 + 1
            r4 = 1
            if (r3 >= r4) goto L_0x0275
            e.i.a.h.d.g r3 = r1.f8839i
            e.i.a.c r4 = r1.f8832b
            int r4 = r4.f8649b
            r3.remove(r4)
            r3 = 1
            goto L_0x027c
        L_0x0275:
            r3 = r0
        L_0x0276:
            r0 = 0
            r17 = r3
            r3 = r0
            r0 = r17
        L_0x027c:
            if (r3 != 0) goto L_0x027f
            goto L_0x02c1
        L_0x027f:
            r3 = r0
            r0 = r16
            goto L_0x0025
        L_0x0284:
            r0 = move-exception
            java.util.Iterator r2 = r4.iterator()     // Catch:{ all -> 0x029b }
        L_0x0289:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x029b }
            if (r3 == 0) goto L_0x029a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x029b }
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3     // Catch:{ all -> 0x029b }
            r4 = 1
            r3.cancel(r4)     // Catch:{ all -> 0x029b }
            goto L_0x0289
        L_0x029a:
            throw r0     // Catch:{ all -> 0x029b }
        L_0x029b:
            r0 = move-exception
            java.util.ArrayList<e.i.a.h.h.f> r2 = r1.f8834d
            r2.removeAll(r13)
            throw r0
        L_0x02a2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x02bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02bb }
            r2.<init>()     // Catch:{ IOException -> 0x02bb }
            java.lang.String r3 = "No cause find with resumable: "
            r2.append(r3)     // Catch:{ IOException -> 0x02bb }
            boolean r3 = r5.f8808b     // Catch:{ IOException -> 0x02bb }
            r2.append(r3)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x02bb }
            r0.<init>(r2)     // Catch:{ IOException -> 0x02bb }
            throw r0     // Catch:{ IOException -> 0x02bb }
        L_0x02bb:
            r0 = move-exception
            r2 = 1
            r11.f8827f = r2
            r11.f8830i = r0
        L_0x02c1:
            r0 = 0
            goto L_0x02da
        L_0x02c3:
            r0 = 0
            throw r0
        L_0x02c5:
            r0 = 0
            throw r0
        L_0x02c7:
            r0 = move-exception
            r2 = r0
            r0 = 0
            r11.a(r2)
            goto L_0x02da
        L_0x02ce:
            r0 = 0
            throw r0
        L_0x02d0:
            r0 = move-exception
            r2 = 0
            e.i.a.h.h.d$a r3 = new e.i.a.h.h.d$a
            r3.<init>(r0)
            r1.f8835e = r3
            r0 = r2
        L_0x02da:
            r2 = 1
            r1.f8837g = r2
            java.util.ArrayList<e.i.a.h.h.f> r2 = r1.f8834d
            r2.clear()
            e.i.a.h.h.d r2 = r1.f8835e
            boolean r3 = r1.f8836f
            if (r3 != 0) goto L_0x0317
            if (r2 != 0) goto L_0x02eb
            goto L_0x0317
        L_0x02eb:
            boolean r3 = r2.f8826e
            if (r3 != 0) goto L_0x0310
            boolean r3 = r2.f8827f
            if (r3 != 0) goto L_0x0310
            boolean r3 = r2.f8824c
            if (r3 == 0) goto L_0x02f8
            goto L_0x0310
        L_0x02f8:
            boolean r3 = r2.f8828g
            if (r3 == 0) goto L_0x02ff
            e.i.a.h.e.a r3 = e.i.a.h.e.a.FILE_BUSY
            goto L_0x030a
        L_0x02ff:
            boolean r3 = r2.f8829h
            if (r3 == 0) goto L_0x0308
            e.i.a.h.e.a r0 = e.i.a.h.e.a.PRE_ALLOCATE_FAILED
            java.io.IOException r3 = r2.f8830i
            goto L_0x0314
        L_0x0308:
            e.i.a.h.e.a r3 = e.i.a.h.e.a.COMPLETED
        L_0x030a:
            r17 = r3
            r3 = r0
            r0 = r17
            goto L_0x0314
        L_0x0310:
            e.i.a.h.e.a r0 = e.i.a.h.e.a.ERROR
            java.io.IOException r3 = r2.f8830i
        L_0x0314:
            r1.a(r2, r0, r3)
        L_0x0317:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.e.a():void");
    }

    public void b() {
        e.i.a.e.a().f8664a.a(this);
        int i2 = this.f8832b.f8649b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        android.os.SystemClock.uptimeMillis();
        e.i.a.e.a().f8664a.b(r7);
        r2 = r7.f8835e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r2 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r2.f8825d = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        r3 = r7.f8834d.toArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r3 == null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r3.length != 0) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r4 = r3.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        if (r1 >= r4) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        r5 = r3[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        if ((r5 instanceof e.i.a.h.h.f) == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        r5 = (e.i.a.h.h.f) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        if (r5.o.get() != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (r5.l != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        r5.l.interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0052, code lost:
        if (r7.f8838h == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
        r1 = r7.f8832b.f8649b;
        r7.f8838h.interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        if (r2 == null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
        r1 = r2.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0063, code lost:
        if (r1 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
        e.i.a.h.j.f.y.execute(new e.i.a.h.j.e(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0072, code lost:
        r1 = r7.f8832b.f8649b;
        android.os.SystemClock.uptimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f8836f     // Catch:{ all -> 0x007a }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r7)     // Catch:{ all -> 0x007a }
            return r1
        L_0x0008:
            boolean r0 = r7.f8837g     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r7)     // Catch:{ all -> 0x007a }
            return r1
        L_0x000e:
            r0 = 1
            r7.f8836f = r0     // Catch:{ all -> 0x007a }
            monitor-exit(r7)     // Catch:{ all -> 0x007a }
            android.os.SystemClock.uptimeMillis()
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.g.b r2 = r2.f8664a
            r2.b(r7)
            e.i.a.h.h.d r2 = r7.f8835e
            if (r2 == 0) goto L_0x0024
            r2.f8825d = r0
        L_0x0024:
            java.util.ArrayList<e.i.a.h.h.f> r3 = r7.f8834d
            java.lang.Object[] r3 = r3.toArray()
            if (r3 == 0) goto L_0x0050
            int r4 = r3.length
            if (r4 != 0) goto L_0x0030
            goto L_0x0050
        L_0x0030:
            int r4 = r3.length
        L_0x0031:
            if (r1 >= r4) goto L_0x005d
            r5 = r3[r1]
            boolean r6 = r5 instanceof e.i.a.h.h.f
            if (r6 == 0) goto L_0x004d
            e.i.a.h.h.f r5 = (e.i.a.h.h.f) r5
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.o
            boolean r6 = r6.get()
            if (r6 != 0) goto L_0x004d
            java.lang.Thread r6 = r5.l
            if (r6 != 0) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            java.lang.Thread r5 = r5.l
            r5.interrupt()
        L_0x004d:
            int r1 = r1 + 1
            goto L_0x0031
        L_0x0050:
            java.lang.Thread r1 = r7.f8838h
            if (r1 == 0) goto L_0x005d
            e.i.a.c r1 = r7.f8832b
            int r1 = r1.f8649b
            java.lang.Thread r1 = r7.f8838h
            r1.interrupt()
        L_0x005d:
            if (r2 == 0) goto L_0x0072
            e.i.a.h.j.f r1 = r2.a()
            if (r1 == 0) goto L_0x0070
            java.util.concurrent.ExecutorService r2 = e.i.a.h.j.f.y
            e.i.a.h.j.e r3 = new e.i.a.h.j.e
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0072
        L_0x0070:
            r0 = 0
            throw r0
        L_0x0072:
            e.i.a.c r1 = r7.f8832b
            int r1 = r1.f8649b
            android.os.SystemClock.uptimeMillis()
            return r0
        L_0x007a:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x007a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.e.c():boolean");
    }

    @SuppressFBWarnings(justification = "This special case is just for task priority", value = {"Eq"})
    public int compareTo(Object obj) {
        return ((e) obj).f8832b.f8654g - this.f8832b.f8654g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r2.f8839i.a(r2.f8832b.f8649b, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r4 != e.i.a.h.e.a.COMPLETED) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r2.f8839i.e(r2.f8832b.f8649b);
        r0 = e.i.a.e.a().f8669f;
        r3.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        e.i.a.e.a().f8665b.f8757a.taskEnd(r2.f8832b, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(e.i.a.h.h.d r3, e.i.a.h.e.a r4, java.lang.Exception r5) {
        /*
            r2 = this;
            e.i.a.h.e.a r0 = e.i.a.h.e.a.CANCELED
            if (r4 == r0) goto L_0x0044
            monitor-enter(r2)
            boolean r0 = r2.f8836f     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r2)     // Catch:{ all -> 0x0041 }
            return
        L_0x000b:
            r0 = 1
            r2.f8837g = r0     // Catch:{ all -> 0x0041 }
            monitor-exit(r2)     // Catch:{ all -> 0x0041 }
            e.i.a.h.d.g r0 = r2.f8839i
            e.i.a.c r1 = r2.f8832b
            int r1 = r1.f8649b
            r0.a(r1, r4, r5)
            e.i.a.h.e.a r0 = e.i.a.h.e.a.COMPLETED
            if (r4 != r0) goto L_0x0033
            e.i.a.h.d.g r0 = r2.f8839i
            e.i.a.c r1 = r2.f8832b
            int r1 = r1.f8649b
            r0.e(r1)
            e.i.a.e r0 = e.i.a.e.a()
            e.i.a.h.j.g r0 = r0.f8669f
            r3.a()
            if (r0 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            throw r3
        L_0x0033:
            e.i.a.e r3 = e.i.a.e.a()
            e.i.a.h.g.a r3 = r3.f8665b
            e.i.a.a r3 = r3.f8757a
            e.i.a.c r0 = r2.f8832b
            r3.taskEnd(r0, r4, r5)
            return
        L_0x0041:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0041 }
            throw r3
        L_0x0044:
            java.lang.IllegalAccessError r3 = new java.lang.IllegalAccessError
            java.lang.String r4 = "can't recognize cancelled on here"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.e.a(e.i.a.h.h.d, e.i.a.h.e.a, java.lang.Exception):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(e.i.a.h.d.c r22, e.i.a.h.h.b r23, e.i.a.h.e.b r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            e.i.a.c r3 = r0.f8832b
            long r4 = r2.f8810d
            boolean r2 = r2.f8807a
            e.i.a.e r6 = e.i.a.e.a()
            e.i.a.h.h.g r6 = r6.f8670g
            r7 = 0
            if (r6 == 0) goto L_0x0098
            e.i.a.e r6 = e.i.a.e.a()
            e.i.a.h.j.a$a r6 = r6.f8668e
            e.i.a.h.j.b$a r6 = (e.i.a.h.j.b.a) r6
            if (r6 == 0) goto L_0x0097
            if (r2 == 0) goto L_0x0058
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.h.g r2 = r2.f8670g
            if (r2 == 0) goto L_0x0057
            java.lang.Integer r2 = r3.l
            if (r2 == 0) goto L_0x0032
            int r2 = r2.intValue()
            goto L_0x0059
        L_0x0032:
            r2 = 1048576(0x100000, double:5.180654E-318)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x003a
            goto L_0x0058
        L_0x003a:
            r2 = 5242880(0x500000, double:2.590327E-317)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0043
            r2 = 2
            goto L_0x0059
        L_0x0043:
            r2 = 52428800(0x3200000, double:2.5903269E-316)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x004c
            r2 = 3
            goto L_0x0059
        L_0x004c:
            r2 = 104857600(0x6400000, double:5.1806538E-316)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0055
            r2 = 4
            goto L_0x0059
        L_0x0055:
            r2 = 5
            goto L_0x0059
        L_0x0057:
            throw r7
        L_0x0058:
            r2 = 1
        L_0x0059:
            java.util.List<e.i.a.h.d.a> r3 = r1.f8708g
            r3.clear()
            long r6 = (long) r2
            long r8 = r4 / r6
            r3 = 0
            r10 = 0
            r12 = r10
        L_0x0065:
            if (r3 >= r2) goto L_0x0087
            long r10 = r10 + r12
            if (r3 != 0) goto L_0x006e
            long r12 = r4 % r6
            long r12 = r12 + r8
            goto L_0x006f
        L_0x006e:
            r12 = r8
        L_0x006f:
            e.i.a.h.d.a r15 = new e.i.a.h.d.a
            r19 = 0
            r14 = r15
            r23 = r2
            r2 = r15
            r15 = r10
            r17 = r12
            r14.<init>(r15, r17, r19)
            java.util.List<e.i.a.h.d.a> r14 = r1.f8708g
            r14.add(r2)
            int r3 = r3 + 1
            r2 = r23
            goto L_0x0065
        L_0x0087:
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.g.a r2 = r2.f8665b
            e.i.a.a r2 = r2.f8757a
            e.i.a.c r3 = r0.f8832b
            r4 = r24
            r2.downloadFromBeginning(r3, r1, r4)
            return
        L_0x0097:
            throw r7
        L_0x0098:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.e.a(e.i.a.h.d.c, e.i.a.h.h.b, e.i.a.h.e.b):void");
    }
}
