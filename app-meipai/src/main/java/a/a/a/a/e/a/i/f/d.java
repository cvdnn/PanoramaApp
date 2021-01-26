package a.a.a.a.e.a.i.f;

import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: a reason: collision with root package name */
    public List<c> f601a = new ArrayList();

    public synchronized e a(double d2, boolean z) {
        int i2 = -1;
        int i3 = 0;
        while (i3 < this.f601a.size() && d2 >= ((e) ((c) this.f601a.get(i3)).f597a.get(0)).f604c) {
            if (d2 <= ((e) ((c) this.f601a.get(i3)).f597a.get(((c) this.f601a.get(i3)).f597a.size() - 1)).f604c && (z || !(this.f601a.get(i3) instanceof g))) {
                i2 = i3;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return ((c) this.f601a.get(i2)).a(d2);
    }

    public synchronized void a() {
        this.f601a.clear();
    }

    public synchronized void a(List<c> list) {
        a();
        this.f601a.addAll(list);
    }

    public synchronized e b(double d2, boolean z) {
        double c2 = c(d2, z);
        if (c2 < 0.0d) {
            return null;
        }
        return a(c2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        return -1.0d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized double c(double r4, boolean r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<a.a.a.a.e.a.i.f.c> r0 = r3.f601a     // Catch:{ all -> 0x0036 }
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r0 == 0) goto L_0x0034
            int r0 = r0.size()     // Catch:{ all -> 0x0036 }
            if (r0 > 0) goto L_0x000e
            goto L_0x0034
        L_0x000e:
            r0 = 1
            int r6 = r3.a(r4, r6, r0)     // Catch:{ all -> 0x0036 }
            if (r6 >= 0) goto L_0x0017
            monitor-exit(r3)
            return r1
        L_0x0017:
            java.util.List<a.a.a.a.e.a.i.f.c> r1 = r3.f601a     // Catch:{ all -> 0x0036 }
            java.lang.Object r6 = r1.get(r6)     // Catch:{ all -> 0x0036 }
            a.a.a.a.e.a.i.f.c r6 = (a.a.a.a.e.a.i.f.c) r6     // Catch:{ all -> 0x0036 }
            java.util.List<a.a.a.a.e.a.i.f.e> r6 = r6.f597a     // Catch:{ all -> 0x0036 }
            int r1 = r6.size()     // Catch:{ all -> 0x0036 }
            int r1 = r1 - r0
            java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x0036 }
            a.a.a.a.e.a.i.f.e r6 = (a.a.a.a.e.a.i.f.e) r6     // Catch:{ all -> 0x0036 }
            double r0 = r6.f604c     // Catch:{ all -> 0x0036 }
            double r4 = java.lang.Math.min(r4, r0)     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)
            return r4
        L_0x0034:
            monitor-exit(r3)
            return r1
        L_0x0036:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.i.f.d.c(double, boolean):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        if (r8 >= ((a.a.a.a.e.a.i.f.e) r10.get(r10.size() - 1)).f604c) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(double r8, boolean r10, boolean r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.List<a.a.a.a.e.a.i.f.c> r0 = r7.f601a     // Catch:{ all -> 0x0067 }
            r1 = -1
            if (r0 == 0) goto L_0x0065
            int r0 = r0.size()     // Catch:{ all -> 0x0067 }
            if (r0 > 0) goto L_0x000d
            goto L_0x0065
        L_0x000d:
            r0 = 0
            r2 = r0
            r3 = r1
        L_0x0010:
            java.util.List<a.a.a.a.e.a.i.f.c> r4 = r7.f601a     // Catch:{ all -> 0x0067 }
            int r4 = r4.size()     // Catch:{ all -> 0x0067 }
            if (r2 >= r4) goto L_0x0040
            java.util.List<a.a.a.a.e.a.i.f.c> r4 = r7.f601a     // Catch:{ all -> 0x0067 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0067 }
            a.a.a.a.e.a.i.f.c r4 = (a.a.a.a.e.a.i.f.c) r4     // Catch:{ all -> 0x0067 }
            java.util.List<a.a.a.a.e.a.i.f.e> r4 = r4.f597a     // Catch:{ all -> 0x0067 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x0067 }
            a.a.a.a.e.a.i.f.e r4 = (a.a.a.a.e.a.i.f.e) r4     // Catch:{ all -> 0x0067 }
            double r4 = r4.f604c     // Catch:{ all -> 0x0067 }
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0040
            if (r10 != 0) goto L_0x003a
            java.util.List<a.a.a.a.e.a.i.f.c> r4 = r7.f601a     // Catch:{ all -> 0x0067 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0067 }
            boolean r4 = r4 instanceof a.a.a.a.e.a.i.f.g     // Catch:{ all -> 0x0067 }
            if (r4 != 0) goto L_0x0040
        L_0x003a:
            int r3 = r2 + 1
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0010
        L_0x0040:
            if (r11 != 0) goto L_0x0063
            if (r3 <= r1) goto L_0x0063
            java.util.List<a.a.a.a.e.a.i.f.c> r10 = r7.f601a     // Catch:{ all -> 0x0067 }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ all -> 0x0067 }
            a.a.a.a.e.a.i.f.c r10 = (a.a.a.a.e.a.i.f.c) r10     // Catch:{ all -> 0x0067 }
            java.util.List<a.a.a.a.e.a.i.f.e> r10 = r10.f597a     // Catch:{ all -> 0x0067 }
            int r11 = r10.size()     // Catch:{ all -> 0x0067 }
            int r11 = r11 + -1
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x0067 }
            a.a.a.a.e.a.i.f.e r10 = (a.a.a.a.e.a.i.f.e) r10     // Catch:{ all -> 0x0067 }
            double r10 = r10.f604c     // Catch:{ all -> 0x0067 }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            monitor-exit(r7)
            if (r8 >= 0) goto L_0x0062
            return r3
        L_0x0062:
            return r1
        L_0x0063:
            monitor-exit(r7)
            return r3
        L_0x0065:
            monitor-exit(r7)
            return r1
        L_0x0067:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.i.f.d.a(double, boolean, boolean):int");
    }
}
