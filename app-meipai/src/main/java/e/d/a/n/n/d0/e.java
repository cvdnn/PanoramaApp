package e.d.a.n.n.d0;

import android.util.Log;
import e.d.a.l.a;
import e.d.a.n.f;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper */
public class e implements a {

    /* renamed from: a reason: collision with root package name */
    public final k f7350a;

    /* renamed from: b reason: collision with root package name */
    public final File f7351b;

    /* renamed from: c reason: collision with root package name */
    public final long f7352c;

    /* renamed from: d reason: collision with root package name */
    public final c f7353d = new c();

    /* renamed from: e reason: collision with root package name */
    public a f7354e;

    @Deprecated
    public e(File file, long j2) {
        this.f7351b = file;
        this.f7352c = j2;
        this.f7350a = new k();
    }

    public final synchronized a a() throws IOException {
        if (this.f7354e == null) {
            this.f7354e = a.a(this.f7351b, 1, 1, this.f7352c);
        }
        return this.f7354e;
    }

    public File a(f fVar) {
        String a2 = this.f7350a.a(fVar);
        String str = "DiskLruCacheWrapper";
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(a2);
            sb.append(" for for Key: ");
            sb.append(fVar);
            Log.v(str, sb.toString());
        }
        try {
            e.d.a.l.a.e a3 = a().a(a2);
            if (a3 != null) {
                return a3.f7169a[0];
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, "Unable to get from disk cache", e2);
            return null;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(e.d.a.n.f r6, e.d.a.n.n.d0.a.b r7) {
        /*
            r5 = this;
            java.lang.String r0 = "DiskLruCacheWrapper"
            e.d.a.n.n.d0.k r1 = r5.f7350a
            java.lang.String r1 = r1.a(r6)
            e.d.a.n.n.d0.c r2 = r5.f7353d
            r2.a(r1)
            r2 = 2
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0030
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "Put: Obtained: "
            r2.append(r3)     // Catch:{ all -> 0x0099 }
            r2.append(r1)     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = " for for Key: "
            r2.append(r3)     // Catch:{ all -> 0x0099 }
            r2.append(r6)     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0099 }
            android.util.Log.v(r0, r6)     // Catch:{ all -> 0x0099 }
        L_0x0030:
            e.d.a.l.a r6 = r5.a()     // Catch:{ IOException -> 0x008b }
            e.d.a.l.a$e r2 = r6.a(r1)     // Catch:{ IOException -> 0x008b }
            if (r2 == 0) goto L_0x0040
        L_0x003a:
            e.d.a.n.n.d0.c r6 = r5.f7353d
            r6.b(r1)
            return
        L_0x0040:
            r2 = -1
            e.d.a.l.a$c r6 = r6.a(r1, r2)     // Catch:{ IOException -> 0x008b }
            if (r6 == 0) goto L_0x0074
            r2 = 0
            java.io.File r2 = r6.a(r2)     // Catch:{ all -> 0x006b }
            e.d.a.n.n.f r7 = (e.d.a.n.n.f) r7     // Catch:{ all -> 0x006b }
            e.d.a.n.d<DataType> r3 = r7.f7388a     // Catch:{ all -> 0x006b }
            DataType r4 = r7.f7389b     // Catch:{ all -> 0x006b }
            e.d.a.n.h r7 = r7.f7390c     // Catch:{ all -> 0x006b }
            boolean r7 = r3.a(r4, r2, r7)     // Catch:{ all -> 0x006b }
            if (r7 == 0) goto L_0x0063
            e.d.a.l.a r7 = e.d.a.l.a.this     // Catch:{ all -> 0x006b }
            r2 = 1
            r7.a(r6, r2)     // Catch:{ all -> 0x006b }
            r6.f7159c = r2     // Catch:{ all -> 0x006b }
        L_0x0063:
            boolean r7 = r6.f7159c     // Catch:{ IOException -> 0x008b }
            if (r7 != 0) goto L_0x003a
            r6.a()     // Catch:{ IOException -> 0x003a }
            goto L_0x003a
        L_0x006b:
            r7 = move-exception
            boolean r2 = r6.f7159c     // Catch:{ IOException -> 0x008b }
            if (r2 != 0) goto L_0x0073
            r6.a()     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            throw r7     // Catch:{ IOException -> 0x008b }
        L_0x0074:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x008b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008b }
            r7.<init>()     // Catch:{ IOException -> 0x008b }
            java.lang.String r2 = "Had two simultaneous puts for: "
            r7.append(r2)     // Catch:{ IOException -> 0x008b }
            r7.append(r1)     // Catch:{ IOException -> 0x008b }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x008b }
            r6.<init>(r7)     // Catch:{ IOException -> 0x008b }
            throw r6     // Catch:{ IOException -> 0x008b }
        L_0x008b:
            r6 = move-exception
            r7 = 5
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch:{ all -> 0x0099 }
            if (r7 == 0) goto L_0x003a
            java.lang.String r7 = "Unable to put to disk cache"
            android.util.Log.w(r0, r7, r6)     // Catch:{ all -> 0x0099 }
            goto L_0x003a
        L_0x0099:
            r6 = move-exception
            e.d.a.n.n.d0.c r7 = r5.f7353d
            r7.b(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.d0.e.a(e.d.a.n.f, e.d.a.n.n.d0.a$b):void");
    }
}
