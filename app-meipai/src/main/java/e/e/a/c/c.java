package e.e.a.c;

import e.e.a.a.C0102a;
import e.e.a.h.b;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: MultipleBluetoothController */
public class c {

    /* renamed from: a reason: collision with root package name */
    public final b<String, a> f7967a = new b<>(C0102a.f7939a.f7935g);

    /* renamed from: b reason: collision with root package name */
    public final HashMap<String, a> f7968b = new HashMap<>();

    public synchronized a a(e.e.a.e.b bVar) {
        a aVar;
        aVar = new a(bVar);
        if (!this.f7968b.containsKey(aVar.e())) {
            this.f7968b.put(aVar.e(), aVar);
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(e.e.a.c.a r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            e.e.a.h.b<java.lang.String, e.e.a.c.a> r0 = r2.f7967a     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r3.e()     // Catch:{ all -> 0x001c }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            e.e.a.h.b<java.lang.String, e.e.a.c.a> r0 = r2.f7967a     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x001c }
            r0.remove(r3)     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.e.a.c.c.b(e.e.a.c.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(e.e.a.c.a r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            java.util.HashMap<java.lang.String, e.e.a.c.a> r0 = r2.f7968b     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r3.e()     // Catch:{ all -> 0x001c }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            java.util.HashMap<java.lang.String, e.e.a.c.a> r0 = r2.f7968b     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x001c }
            r0.remove(r3)     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.e.a.c.c.c(e.e.a.c.a):void");
    }

    public synchronized boolean d(e.e.a.e.b bVar) {
        boolean z;
        if (bVar != null) {
            if (this.f7967a.containsKey(bVar.a())) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(e.e.a.c.a r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            e.e.a.h.b<java.lang.String, e.e.a.c.a> r0 = r2.f7967a     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r3.e()     // Catch:{ all -> 0x001c }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x001a
            e.e.a.h.b<java.lang.String, e.e.a.c.a> r0 = r2.f7967a     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r3.e()     // Catch:{ all -> 0x001c }
            r0.put(r1, r3)     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.e.a.c.c.a(e.e.a.c.a):void");
    }

    public synchronized void b(e.e.a.e.b bVar) {
        if (d(bVar)) {
            c(bVar).c();
        }
    }

    public synchronized a c(e.e.a.e.b bVar) {
        if (bVar != null) {
            if (this.f7967a.containsKey(bVar.a())) {
                return (a) this.f7967a.get(bVar.a());
            }
        }
        return null;
    }

    public synchronized void a() {
        for (Entry value : this.f7967a.entrySet()) {
            ((a) value.getValue()).c();
        }
        this.f7967a.clear();
    }
}
