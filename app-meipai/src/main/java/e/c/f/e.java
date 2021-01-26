package e.c.f;

import android.content.Context;
import e.c.f.n.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileDeleteObserverUtils */
public final class e {

    /* renamed from: a reason: collision with root package name */
    public static Map<String, g> f6921a = new HashMap();

    public static void a(Context context, int i2, File file, File file2) {
        if (file != null) {
            try {
                if (a.a(file)) {
                    if (!a.a(file2)) {
                        a.a(file, file2);
                    }
                    StringBuilder sb = new StringBuilder("f=");
                    sb.append(file);
                    sb.append(", b=");
                    sb.append(file2);
                    c.a();
                    if (!f6921a.containsKey(file.getAbsolutePath())) {
                        g gVar = new g(context, i2, file.getAbsolutePath(), file2.getAbsolutePath());
                        gVar.startWatching();
                        f6921a.put(file.getAbsolutePath(), gVar);
                    }
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r2) {
        /*
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "f="
            r0.<init>(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r2.getAbsolutePath()     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            e.c.f.c.a()     // Catch:{ all -> 0x0043 }
            java.util.Map<java.lang.String, e.c.f.g> r0 = f6921a     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r2.getAbsolutePath()     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0043 }
            e.c.f.g r0 = (e.c.f.g) r0     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0042
            r0.stopWatching()     // Catch:{ all -> 0x0043 }
            java.util.Map<java.lang.String, e.c.f.g> r1 = f6921a     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0043 }
            r1.remove(r2)     // Catch:{ all -> 0x0043 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r0.f6993b     // Catch:{ all -> 0x003f }
            r2.<init>(r0)     // Catch:{ all -> 0x003f }
            boolean r0 = r2.exists()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0042
            r2.delete()     // Catch:{ all -> 0x003f }
            goto L_0x0042
        L_0x003f:
            e.c.f.c.d()     // Catch:{ all -> 0x0043 }
        L_0x0042:
            return
        L_0x0043:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.e.a(java.io.File):void");
    }
}
