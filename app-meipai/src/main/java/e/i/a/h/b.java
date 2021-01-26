package e.i.a.h;

/* compiled from: NamedRunnable */
public abstract class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final String f8691a;

    public b(String str) {
        this.f8691a = str;
    }

    public abstract void a() throws InterruptedException;

    public abstract void b();

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        java.lang.Thread.currentThread().setName(r0);
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.String r2 = r3.f8691a
            r1.setName(r2)
            r3.a()     // Catch:{ InterruptedException -> 0x0021 }
        L_0x0014:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.setName(r0)
            r3.b()
            goto L_0x0029
        L_0x001f:
            r1 = move-exception
            goto L_0x002a
        L_0x0021:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001f }
            r1.interrupt()     // Catch:{ all -> 0x001f }
            goto L_0x0014
        L_0x0029:
            return
        L_0x002a:
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.setName(r0)
            r3.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.b.run():void");
    }
}
