package e.i.a.h.g;

import e.c.f.n.n;
import e.i.a.h.c;
import e.i.a.h.d.a;
import e.i.a.h.d.g;
import e.i.a.h.h.e;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DownloadDispatcher */
public class b {
    @SuppressFBWarnings(justification = "Not so urgency", value = {"IS"})

    /* renamed from: a reason: collision with root package name */
    public int f8791a = 5;

    /* renamed from: b reason: collision with root package name */
    public final List<e> f8792b;

    /* renamed from: c reason: collision with root package name */
    public final List<e> f8793c;

    /* renamed from: d reason: collision with root package name */
    public final List<e> f8794d;

    /* renamed from: e reason: collision with root package name */
    public final List<e> f8795e;

    /* renamed from: f reason: collision with root package name */
    public final AtomicInteger f8796f = new AtomicInteger();

    /* renamed from: g reason: collision with root package name */
    public volatile ExecutorService f8797g;

    /* renamed from: h reason: collision with root package name */
    public final AtomicInteger f8798h = new AtomicInteger();
    @SuppressFBWarnings(justification = "Not so urgency", value = {"IS"})

    /* renamed from: i reason: collision with root package name */
    public g f8799i;

    public b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.f8792b = arrayList;
        this.f8793c = arrayList2;
        this.f8794d = arrayList3;
        this.f8795e = arrayList4;
    }

    public synchronized ExecutorService a() {
        if (this.f8797g == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkDownload Download", false));
            this.f8797g = threadPoolExecutor;
        }
        return this.f8797g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(e.i.a.c r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "DownloadDispatcher"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r1.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "enqueueLocked for single task: "
            r1.append(r2)     // Catch:{ all -> 0x0058 }
            r1.append(r4)     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0058 }
            e.i.a.h.c.a(r0, r1)     // Catch:{ all -> 0x0058 }
            boolean r0 = r3.c(r4)     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x001f
            monitor-exit(r3)
            return
        L_0x001f:
            java.util.List<e.i.a.h.h.e> r0 = r3.f8792b     // Catch:{ all -> 0x0058 }
            r1 = 0
            boolean r0 = r3.a(r4, r0, r1, r1)     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x003b
            java.util.List<e.i.a.h.h.e> r0 = r3.f8793c     // Catch:{ all -> 0x0058 }
            boolean r0 = r3.a(r4, r0, r1, r1)     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x003b
            java.util.List<e.i.a.h.h.e> r0 = r3.f8794d     // Catch:{ all -> 0x0058 }
            boolean r0 = r3.a(r4, r0, r1, r1)     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r0 = 0
            goto L_0x003c
        L_0x003b:
            r0 = 1
        L_0x003c:
            if (r0 == 0) goto L_0x0040
            monitor-exit(r3)
            return
        L_0x0040:
            java.util.List<e.i.a.h.h.e> r0 = r3.f8792b     // Catch:{ all -> 0x0058 }
            int r0 = r0.size()     // Catch:{ all -> 0x0058 }
            r3.a(r4)     // Catch:{ all -> 0x0058 }
            java.util.List<e.i.a.h.h.e> r4 = r3.f8792b     // Catch:{ all -> 0x0058 }
            int r4 = r4.size()     // Catch:{ all -> 0x0058 }
            if (r0 == r4) goto L_0x0056
            java.util.List<e.i.a.h.h.e> r4 = r3.f8792b     // Catch:{ all -> 0x0058 }
            java.util.Collections.sort(r4)     // Catch:{ all -> 0x0058 }
        L_0x0056:
            monitor-exit(r3)
            return
        L_0x0058:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.g.b.b(e.i.a.c):void");
    }

    public boolean c(e.i.a.c cVar) {
        long length;
        boolean z;
        if (!cVar.n) {
            return false;
        }
        if (!(n.a(cVar) == e.i.a.g.COMPLETED)) {
            return false;
        }
        if (cVar.v.f8854a == null) {
            if (e.i.a.e.a().f8670g != null) {
                String a2 = e.i.a.e.a().f8666c.a(cVar.f8650c);
                if (a2 == null) {
                    z = false;
                } else {
                    cVar.v.f8854a = a2;
                    z = true;
                }
                if (!z) {
                    return false;
                }
            } else {
                throw null;
            }
        }
        e.i.a.h.h.g gVar = e.i.a.e.a().f8670g;
        g gVar2 = this.f8799i;
        if (gVar != null) {
            e.i.a.h.d.c b2 = gVar2.b(cVar.f8649b);
            if (b2 == null) {
                b2 = new e.i.a.h.d.c(cVar.f8649b, cVar.f8650c, cVar.x, cVar.v.f8854a);
                if (c.b(cVar.f8651d)) {
                    length = c.a(cVar.f8651d);
                } else {
                    File g2 = cVar.g();
                    if (g2 == null) {
                        length = 0;
                        StringBuilder sb = new StringBuilder();
                        sb.append("file is not ready on valid info for task on complete state ");
                        sb.append(cVar);
                        sb.toString();
                    } else {
                        length = g2.length();
                    }
                }
                long j2 = length;
                a aVar = new a(0, j2, j2);
                b2.f8708g.add(aVar);
            }
            cVar.f8653f = b2;
            e.i.a.e.a().f8665b.f8757a.taskEnd(cVar, e.i.a.h.e.a.COMPLETED, null);
            return true;
        }
        throw null;
    }

    public synchronized boolean d(e.i.a.c cVar) {
        String str = "DownloadDispatcher";
        StringBuilder sb = new StringBuilder();
        sb.append("is file conflict after run: ");
        sb.append(cVar.f8649b);
        c.a(str, sb.toString());
        File g2 = cVar.g();
        if (g2 == null) {
            return false;
        }
        for (e eVar : this.f8794d) {
            if (!eVar.f8836f) {
                if (eVar.f8832b != cVar) {
                    File g3 = eVar.f8832b.g();
                    if (g3 != null && g2.equals(g3)) {
                        return true;
                    }
                }
            }
        }
        for (e eVar2 : this.f8793c) {
            if (!eVar2.f8836f) {
                if (eVar2.f8832b != cVar) {
                    File g4 = eVar2.f8832b.g();
                    if (g4 != null && g2.equals(g4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public synchronized boolean e(e.i.a.c cVar) {
        String str = "DownloadDispatcher";
        StringBuilder sb = new StringBuilder();
        sb.append("isPending: ");
        sb.append(cVar.f8649b);
        c.a(str, sb.toString());
        for (e eVar : this.f8792b) {
            if (!eVar.f8836f) {
                if (eVar.f8832b.equals(cVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized boolean f(e.i.a.c cVar) {
        String str = "DownloadDispatcher";
        StringBuilder sb = new StringBuilder();
        sb.append("isRunning: ");
        sb.append(cVar.f8649b);
        c.a(str, sb.toString());
        for (e eVar : this.f8794d) {
            if (!eVar.f8836f) {
                if (eVar.f8832b.equals(cVar)) {
                    return true;
                }
            }
        }
        for (e eVar2 : this.f8793c) {
            if (!eVar2.f8836f) {
                if (eVar2.f8832b.equals(cVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final synchronized void a(e.i.a.c cVar) {
        e eVar = new e(cVar, true, this.f8799i);
        if (c() < this.f8791a) {
            this.f8793c.add(eVar);
            a().execute(eVar);
        } else {
            this.f8792b.add(eVar);
        }
    }

    public synchronized void b(e eVar) {
        int i2 = eVar.f8832b.f8649b;
        if (eVar.f8833c) {
            this.f8796f.incrementAndGet();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized boolean a(e.i.a.h.a aVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str = "DownloadDispatcher";
        StringBuilder sb = new StringBuilder();
        sb.append("cancel manually: ");
        sb.append(aVar.b());
        c.a(str, sb.toString());
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        try {
            a(aVar, arrayList, arrayList2);
            a(arrayList, arrayList2);
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            throw th;
        }
        return arrayList.size() > 0 || arrayList2.size() > 0;
    }

    public final synchronized void b() {
        if (this.f8798h.get() <= 0) {
            if (c() < this.f8791a) {
                if (!this.f8792b.isEmpty()) {
                    Iterator it = this.f8792b.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        it.remove();
                        e.i.a.c cVar = eVar.f8832b;
                        if (d(cVar)) {
                            e.i.a.e.a().f8665b.f8757a.taskEnd(cVar, e.i.a.h.e.a.FILE_BUSY, null);
                        } else {
                            this.f8793c.add(eVar);
                            a().execute(eVar);
                            if (c() >= this.f8791a) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(e.i.a.h.a r5, java.util.List<e.i.a.h.h.e> r6, java.util.List<e.i.a.h.h.e> r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List<e.i.a.h.h.e> r0 = r4.f8792b     // Catch:{ all -> 0x0086 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0086 }
            e.i.a.h.h.e r1 = (e.i.a.h.h.e) r1     // Catch:{ all -> 0x0086 }
            e.i.a.c r2 = r1.f8832b     // Catch:{ all -> 0x0086 }
            if (r2 == r5) goto L_0x0021
            e.i.a.c r2 = r1.f8832b     // Catch:{ all -> 0x0086 }
            int r2 = r2.f8649b     // Catch:{ all -> 0x0086 }
            int r3 = r5.b()     // Catch:{ all -> 0x0086 }
            if (r2 != r3) goto L_0x0007
        L_0x0021:
            boolean r5 = r1.f8836f     // Catch:{ all -> 0x0086 }
            if (r5 != 0) goto L_0x0032
            boolean r5 = r1.f8837g     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x002a
            goto L_0x0032
        L_0x002a:
            r0.remove()     // Catch:{ all -> 0x0086 }
            r6.add(r1)     // Catch:{ all -> 0x0086 }
            monitor-exit(r4)
            return
        L_0x0032:
            monitor-exit(r4)
            return
        L_0x0034:
            java.util.List<e.i.a.h.h.e> r0 = r4.f8793c     // Catch:{ all -> 0x0086 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0086 }
        L_0x003a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0086 }
            e.i.a.h.h.e r1 = (e.i.a.h.h.e) r1     // Catch:{ all -> 0x0086 }
            e.i.a.c r2 = r1.f8832b     // Catch:{ all -> 0x0086 }
            if (r2 == r5) goto L_0x0054
            e.i.a.c r2 = r1.f8832b     // Catch:{ all -> 0x0086 }
            int r2 = r2.f8649b     // Catch:{ all -> 0x0086 }
            int r3 = r5.b()     // Catch:{ all -> 0x0086 }
            if (r2 != r3) goto L_0x003a
        L_0x0054:
            r6.add(r1)     // Catch:{ all -> 0x0086 }
            r7.add(r1)     // Catch:{ all -> 0x0086 }
            monitor-exit(r4)
            return
        L_0x005c:
            java.util.List<e.i.a.h.h.e> r0 = r4.f8794d     // Catch:{ all -> 0x0086 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0062:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x0084
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0086 }
            e.i.a.h.h.e r1 = (e.i.a.h.h.e) r1     // Catch:{ all -> 0x0086 }
            e.i.a.c r2 = r1.f8832b     // Catch:{ all -> 0x0086 }
            if (r2 == r5) goto L_0x007c
            e.i.a.c r2 = r1.f8832b     // Catch:{ all -> 0x0086 }
            int r2 = r2.f8649b     // Catch:{ all -> 0x0086 }
            int r3 = r5.b()     // Catch:{ all -> 0x0086 }
            if (r2 != r3) goto L_0x0062
        L_0x007c:
            r6.add(r1)     // Catch:{ all -> 0x0086 }
            r7.add(r1)     // Catch:{ all -> 0x0086 }
            monitor-exit(r4)
            return
        L_0x0084:
            monitor-exit(r4)
            return
        L_0x0086:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.g.b.a(e.i.a.h.a, java.util.List, java.util.List):void");
    }

    public final int c() {
        return this.f8793c.size() - this.f8796f.get();
    }

    public final synchronized void a(List<e> list, List<e> list2) {
        String str = "DownloadDispatcher";
        StringBuilder sb = new StringBuilder();
        sb.append("handle cancel calls, cancel calls: ");
        sb.append(list2.size());
        c.a(str, sb.toString());
        if (!list2.isEmpty()) {
            for (e eVar : list2) {
                if (!eVar.c()) {
                    list.remove(eVar);
                }
            }
        }
        list.size();
        if (!list.isEmpty()) {
            if (list.size() <= 1) {
                e.i.a.e.a().f8665b.f8757a.taskEnd(((e) list.get(0)).f8832b, e.i.a.h.e.a.CANCELED, null);
            } else {
                ArrayList arrayList = new ArrayList();
                for (e eVar2 : list) {
                    arrayList.add(eVar2.f8832b);
                }
                e.i.a.e.a().f8665b.a(arrayList);
            }
        }
    }

    public synchronized void a(e eVar) {
        List<e> list;
        boolean z = eVar.f8833c;
        if (this.f8795e.contains(eVar)) {
            list = this.f8795e;
        } else if (z) {
            list = this.f8793c;
        } else {
            list = this.f8794d;
        }
        if (list.remove(eVar)) {
            if (z && eVar.f8836f) {
                this.f8796f.decrementAndGet();
            }
            if (z) {
                b();
            }
        } else {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }

    public boolean a(e.i.a.c cVar, Collection<e> collection, Collection<e.i.a.c> collection2, Collection<e.i.a.c> collection3) {
        a aVar = e.i.a.e.a().f8665b;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (!eVar.f8836f) {
                if (!eVar.f8832b.equals(cVar)) {
                    File g2 = eVar.f8832b.g();
                    File g3 = cVar.g();
                    if (!(g2 == null || g3 == null || !g2.equals(g3))) {
                        if (collection3 != null) {
                            collection3.add(cVar);
                        } else {
                            aVar.f8757a.taskEnd(cVar, e.i.a.h.e.a.FILE_BUSY, null);
                        }
                        return true;
                    }
                } else if (eVar.f8837g) {
                    int i2 = cVar.f8649b;
                    this.f8795e.add(eVar);
                    it.remove();
                    return false;
                } else {
                    if (collection2 != null) {
                        collection2.add(cVar);
                    } else {
                        aVar.f8757a.taskEnd(cVar, e.i.a.h.e.a.SAME_TASK_BUSY, null);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
