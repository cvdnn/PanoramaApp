package e.i.a.h.l.c;

import android.util.SparseArray;
import e.i.a.h.l.c.a.c;
import e.i.a.h.l.c.b.C0130b;

/* compiled from: Listener4Assist */
public class a<T extends c> {

    /* renamed from: a reason: collision with root package name */
    public b f8888a = this;

    /* renamed from: b reason: collision with root package name */
    public C0129a f8889b;

    /* renamed from: c reason: collision with root package name */
    public final c<T> f8890c;

    /* renamed from: e.i.a.h.l.c.a$a reason: collision with other inner class name */
    /* compiled from: Listener4Assist */
    public interface C0129a {
    }

    /* compiled from: Listener4Assist */
    public interface b {
        void blockEnd(e.i.a.c cVar, int i2, e.i.a.h.d.a aVar);

        void infoReady(e.i.a.c cVar, e.i.a.h.d.c cVar2, boolean z, c cVar3);

        void progress(e.i.a.c cVar, long j2);

        void progressBlock(e.i.a.c cVar, int i2, long j2);

        void taskEnd(e.i.a.c cVar, e.i.a.h.e.a aVar, Exception exc, c cVar2);
    }

    /* compiled from: Listener4Assist */
    public static class c implements e.i.a.h.l.c.c.a {

        /* renamed from: a reason: collision with root package name */
        public final int f8891a;

        /* renamed from: b reason: collision with root package name */
        public e.i.a.h.d.c f8892b;

        /* renamed from: c reason: collision with root package name */
        public long f8893c;

        /* renamed from: d reason: collision with root package name */
        public SparseArray<Long> f8894d;

        public c(int i2) {
            this.f8891a = i2;
        }

        public int a() {
            return this.f8891a;
        }

        public void a(e.i.a.h.d.c cVar) {
            this.f8892b = cVar;
            this.f8893c = cVar.e();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int b2 = cVar.b();
            for (int i2 = 0; i2 < b2; i2++) {
                sparseArray.put(i2, Long.valueOf(cVar.a(i2).a()));
            }
            this.f8894d = sparseArray;
        }
    }

    public a(e.i.a.h.l.c.c.b<T> bVar) {
        this.f8890c = new c<>(bVar);
    }

    public void a(e.i.a.c cVar, e.i.a.h.d.c cVar2, boolean z) {
        c cVar3 = (c) this.f8890c.a(cVar, cVar2);
        C0129a aVar = this.f8889b;
        if (aVar != null) {
            e.i.a.h.l.c.b.a aVar2 = ((b) aVar).f8895a;
            if (aVar2 != null) {
                aVar2.infoReady(cVar, cVar2, z, (C0130b) cVar3);
            }
            return;
        }
        b bVar = this.f8888a;
        if (bVar != null) {
            bVar.infoReady(cVar, cVar2, z, cVar3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(e.i.a.c r3, e.i.a.h.e.a r4, java.lang.Exception r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            e.i.a.h.l.c.c<T> r0 = r2.f8890c     // Catch:{ all -> 0x003c }
            e.i.a.h.d.c r1 = r3.h()     // Catch:{ all -> 0x003c }
            e.i.a.h.l.c.c$a r0 = r0.c(r3, r1)     // Catch:{ all -> 0x003c }
            e.i.a.h.l.c.a$c r0 = (e.i.a.h.l.c.a.c) r0     // Catch:{ all -> 0x003c }
            e.i.a.h.l.c.a$a r1 = r2.f8889b     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0031
            e.i.a.h.l.c.a$a r1 = r2.f8889b     // Catch:{ all -> 0x003c }
            e.i.a.h.l.c.b r1 = (e.i.a.h.l.c.b) r1     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x002f
            e.i.a.h.l.c.b$b r0 = (e.i.a.h.l.c.b.C0130b) r0     // Catch:{ all -> 0x003c }
            e.i.a.f r0 = r0.f8896e     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0021
            r0.a()     // Catch:{ all -> 0x003c }
            goto L_0x0026
        L_0x0021:
            e.i.a.f r0 = new e.i.a.f     // Catch:{ all -> 0x003c }
            r0.<init>()     // Catch:{ all -> 0x003c }
        L_0x0026:
            e.i.a.h.l.c.b$a r1 = r1.f8895a     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x002d
            r1.taskEnd(r3, r4, r5, r0)     // Catch:{ all -> 0x003c }
        L_0x002d:
            monitor-exit(r2)
            return
        L_0x002f:
            r3 = 0
            throw r3     // Catch:{ all -> 0x003c }
        L_0x0031:
            e.i.a.h.l.c.a$b r1 = r2.f8888a     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003a
            e.i.a.h.l.c.a$b r1 = r2.f8888a     // Catch:{ all -> 0x003c }
            r1.taskEnd(r3, r4, r5, r0)     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r2)
            return
        L_0x003c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.l.c.a.a(e.i.a.c, e.i.a.h.e.a, java.lang.Exception):void");
    }
}
