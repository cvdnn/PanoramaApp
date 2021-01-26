package e.e.a.g;

import android.annotation.TargetApi;
import e.e.a.a.C0102a;
import e.e.a.e.c;

@TargetApi(18)
/* compiled from: BleScanner */
public class f {

    /* renamed from: a reason: collision with root package name */
    public c f8021a = c.STATE_IDLE;

    /* renamed from: b reason: collision with root package name */
    public b f8022b = new a();

    /* compiled from: BleScanner */
    public class a extends b {
        public a() {
        }
    }

    /* compiled from: BleScanner */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public static final f f8023a = new f();
    }

    public synchronized void a() {
        C0102a.f7939a.f7931c.stopLeScan(this.f8022b);
        this.f8021a = c.STATE_IDLE;
        b bVar = this.f8022b;
        bVar.k = false;
        bVar.f8005i.quit();
        bVar.f8004h.removeCallbacksAndMessages(null);
        bVar.f8006j.removeCallbacksAndMessages(null);
        bVar.f8004h.post(new c(bVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.UUID[] r11, java.lang.String[] r12, java.lang.String r13, boolean r14, boolean r15, long r16, e.e.a.d.j r18) {
        /*
            r10 = this;
            r1 = r10
            r0 = r18
            monitor-enter(r10)
            e.e.a.e.c r2 = r1.f8021a     // Catch:{ all -> 0x003f }
            e.e.a.e.c r3 = e.e.a.e.c.STATE_IDLE     // Catch:{ all -> 0x003f }
            if (r2 == r3) goto L_0x0017
            java.lang.String r2 = "scan action already exists, complete the previous scan action first"
            e.e.a.h.a.c(r2)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0015
            r2 = 0
            r0.onScanStarted(r2)     // Catch:{ all -> 0x003f }
        L_0x0015:
            monitor-exit(r10)
            return
        L_0x0017:
            e.e.a.g.b r2 = r1.f8022b     // Catch:{ all -> 0x003f }
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r9 = r18
            r2.a(r3, r4, r5, r6, r7, r9)     // Catch:{ all -> 0x003f }
            e.e.a.a r0 = e.e.a.a.C0102a.f7939a     // Catch:{ all -> 0x003f }
            android.bluetooth.BluetoothAdapter r0 = r0.f7931c     // Catch:{ all -> 0x003f }
            e.e.a.g.b r2 = r1.f8022b     // Catch:{ all -> 0x003f }
            r3 = r11
            boolean r0 = r0.startLeScan(r11, r2)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0034
            e.e.a.e.c r2 = e.e.a.e.c.STATE_SCANNING     // Catch:{ all -> 0x003f }
            goto L_0x0036
        L_0x0034:
            e.e.a.e.c r2 = e.e.a.e.c.STATE_IDLE     // Catch:{ all -> 0x003f }
        L_0x0036:
            r1.f8021a = r2     // Catch:{ all -> 0x003f }
            e.e.a.g.b r2 = r1.f8022b     // Catch:{ all -> 0x003f }
            r2.a(r0)     // Catch:{ all -> 0x003f }
            monitor-exit(r10)
            return
        L_0x003f:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.e.a.g.f.a(java.util.UUID[], java.lang.String[], java.lang.String, boolean, boolean, long, e.e.a.d.j):void");
    }
}
