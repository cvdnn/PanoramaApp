package com.baidu.mobstat;

public class u {

    /* renamed from: a reason: collision with root package name */
    public static a f1903a;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.baidu.mobstat.a a(android.content.Context r4) {
        /*
            java.lang.Class<com.baidu.mobstat.u> r0 = com.baidu.mobstat.u.class
            monitor-enter(r0)
            com.baidu.mobstat.bb r1 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "getBPStretegyController begin"
            r1.a(r2)     // Catch:{ all -> 0x0058 }
            com.baidu.mobstat.a r1 = f1903a     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x0038
            java.lang.String r2 = "com.baidu.bottom.remote.BPStretegyController2"
            java.lang.Class r2 = com.baidu.mobstat.x.a(r4, r2)     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r2.newInstance()     // Catch:{ Exception -> 0x002d }
            com.baidu.mobstat.w r3 = new com.baidu.mobstat.w     // Catch:{ Exception -> 0x002d }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002d }
            com.baidu.mobstat.bb r1 = com.baidu.mobstat.bb.c()     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "Get BPStretegyController load remote class v2"
            r1.a(r2)     // Catch:{ Exception -> 0x002b }
            goto L_0x0037
        L_0x002b:
            r1 = move-exception
            goto L_0x0030
        L_0x002d:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L_0x0030:
            com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0058 }
            r2.a(r1)     // Catch:{ all -> 0x0058 }
        L_0x0037:
            r1 = r3
        L_0x0038:
            if (r1 != 0) goto L_0x0048
            com.baidu.mobstat.v r1 = new com.baidu.mobstat.v     // Catch:{ all -> 0x0058 }
            r1.<init>()     // Catch:{ all -> 0x0058 }
            com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "Get BPStretegyController load local class"
            r2.a(r3)     // Catch:{ all -> 0x0058 }
        L_0x0048:
            f1903a = r1     // Catch:{ all -> 0x0058 }
            com.baidu.mobstat.x.a(r4, r1)     // Catch:{ all -> 0x0058 }
            com.baidu.mobstat.bb r4 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "getBPStretegyController end"
            r4.a(r2)     // Catch:{ all -> 0x0058 }
            monitor-exit(r0)
            return r1
        L_0x0058:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.u.a(android.content.Context):com.baidu.mobstat.a");
    }

    public static synchronized void a() {
        synchronized (u.class) {
            f1903a = null;
        }
    }
}
