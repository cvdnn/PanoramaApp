package e.c.f.f;

import java.io.Serializable;

/* compiled from: ActivityInfoArray */
public final class a implements Serializable {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0022 A[SYNTHETIC, Splitter:B:18:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0027 A[Catch:{ IOException -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<e.c.f.f.b> a(byte[] r3) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x001e }
            r1.<init>(r3)     // Catch:{ all -> 0x001e }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ all -> 0x001c }
            r3.<init>(r1)     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = r3.readObject()     // Catch:{ all -> 0x0020 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0020 }
            r3.close()     // Catch:{ IOException -> 0x0018 }
            r1.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            e.c.f.c.d()
        L_0x001b:
            return r2
        L_0x001c:
            r3 = r0
            goto L_0x0020
        L_0x001e:
            r3 = r0
            r1 = r3
        L_0x0020:
            if (r3 == 0) goto L_0x0025
            r3.close()     // Catch:{ IOException -> 0x002b }
        L_0x0025:
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002e
        L_0x002b:
            e.c.f.c.d()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.a.a(byte[]):java.util.ArrayList");
    }
}
