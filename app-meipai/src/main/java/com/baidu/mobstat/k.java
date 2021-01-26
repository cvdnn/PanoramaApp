package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum k {
    AP_LIST(0) {
        public j a() {
            return new n();
        }
    },
    APP_LIST(1) {
        public j a() {
            return new q();
        }
    },
    APP_TRACE(2) {
        public j a() {
            return new r();
        }
    },
    APP_CHANGE(3) {
        public j a() {
            return new p();
        }
    },
    APP_APK(4) {
        public j a() {
            return new o();
        }
    };
    

    /* renamed from: f reason: collision with root package name */
    public int f1887f;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int c() {
        /*
            r3 = this;
            r0 = 0
            com.baidu.mobstat.j r0 = r3.a()     // Catch:{ Exception -> 0x0019 }
            boolean r1 = r0.a()     // Catch:{ Exception -> 0x0019 }
            if (r1 == 0) goto L_0x0013
            int r1 = r0.b()     // Catch:{ Exception -> 0x0019 }
            r0.close()
            return r1
        L_0x0013:
            r0.close()
            goto L_0x0024
        L_0x0017:
            r1 = move-exception
            goto L_0x0026
        L_0x0019:
            r1 = move-exception
            com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0017 }
            r2.b(r1)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0024
            goto L_0x0013
        L_0x0024:
            r0 = 0
            return r0
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            r0.close()
        L_0x002b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.k.c():int");
    }

    public abstract j a();

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<com.baidu.mobstat.i> a(int r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0033 }
            r0.<init>()     // Catch:{ all -> 0x0033 }
            r1 = 0
            com.baidu.mobstat.j r1 = r3.a()     // Catch:{ Exception -> 0x0020 }
            boolean r2 = r1.a()     // Catch:{ Exception -> 0x0020 }
            if (r2 != 0) goto L_0x0016
            r1.close()     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)
            return r0
        L_0x0016:
            java.util.ArrayList r0 = r1.a(r4, r5)     // Catch:{ Exception -> 0x0020 }
        L_0x001a:
            r1.close()     // Catch:{ all -> 0x0033 }
            goto L_0x002b
        L_0x001e:
            r4 = move-exception
            goto L_0x002d
        L_0x0020:
            r4 = move-exception
            com.baidu.mobstat.bb r5 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x001e }
            r5.b(r4)     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x002b
            goto L_0x001a
        L_0x002b:
            monitor-exit(r3)
            return r0
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ all -> 0x0033 }
        L_0x0032:
            throw r4     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.k.a(int, int):java.util.ArrayList");
    }

    public synchronized boolean b() {
        return c() == 0;
    }

    public String toString() {
        return String.valueOf(this.f1887f);
    }

    /* access modifiers changed from: public */
    k(int i2) {
        this.f1887f = i2;
    }

    public synchronized boolean b(int i2) {
        return c() >= i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        if (r2 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long a(long r5, java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = -1
            r2 = 0
            com.baidu.mobstat.j r2 = r4.a()     // Catch:{ Exception -> 0x0021 }
            boolean r3 = r2.a()     // Catch:{ Exception -> 0x0021 }
            if (r3 != 0) goto L_0x0013
            r2.close()     // Catch:{ all -> 0x0034 }
            monitor-exit(r4)
            return r0
        L_0x0013:
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0021 }
            long r0 = r2.a(r5, r7)     // Catch:{ Exception -> 0x0021 }
        L_0x001b:
            r2.close()     // Catch:{ all -> 0x0034 }
            goto L_0x002c
        L_0x001f:
            r5 = move-exception
            goto L_0x002e
        L_0x0021:
            r5 = move-exception
            com.baidu.mobstat.bb r6 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x001f }
            r6.b(r5)     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x002c
            goto L_0x001b
        L_0x002c:
            monitor-exit(r4)
            return r0
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ all -> 0x0034 }
        L_0x0033:
            throw r5     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.k.a(long, java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x005f, code lost:
        return 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004f A[SYNTHETIC, Splitter:B:35:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(java.util.ArrayList<java.lang.Long> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            if (r7 == 0) goto L_0x005e
            int r1 = r7.size()     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x000b
            goto L_0x005e
        L_0x000b:
            r1 = 0
            com.baidu.mobstat.j r1 = r6.a()     // Catch:{ Exception -> 0x0045 }
            boolean r2 = r1.a()     // Catch:{ Exception -> 0x0045 }
            if (r2 != 0) goto L_0x001b
            r1.close()     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return r0
        L_0x001b:
            int r2 = r7.size()     // Catch:{ Exception -> 0x0045 }
            r3 = r0
        L_0x0020:
            if (r0 >= r2) goto L_0x003f
            java.lang.Object r4 = r7.get(r0)     // Catch:{ Exception -> 0x003c }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x003c }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x003c }
            boolean r4 = r1.b(r4)     // Catch:{ Exception -> 0x003c }
            if (r4 != 0) goto L_0x0037
            r1.close()     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return r3
        L_0x0037:
            int r3 = r3 + 1
            int r0 = r0 + 1
            goto L_0x0020
        L_0x003c:
            r7 = move-exception
            r0 = r3
            goto L_0x0046
        L_0x003f:
            r1.close()     // Catch:{ all -> 0x005b }
            goto L_0x0053
        L_0x0043:
            r7 = move-exception
            goto L_0x0055
        L_0x0045:
            r7 = move-exception
        L_0x0046:
            com.baidu.mobstat.bb r2 = com.baidu.mobstat.bb.c()     // Catch:{ all -> 0x0043 }
            r2.b(r7)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ all -> 0x005b }
        L_0x0052:
            r3 = r0
        L_0x0053:
            monitor-exit(r6)
            return r3
        L_0x0055:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ all -> 0x005b }
        L_0x005a:
            throw r7     // Catch:{ all -> 0x005b }
        L_0x005b:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x005e:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.k.a(java.util.ArrayList):int");
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<java.lang.String> a(int r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0055 }
            r6.<init>()     // Catch:{ all -> 0x0055 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0055 }
            r7.<init>()     // Catch:{ all -> 0x0055 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0055 }
            r8.<init>()     // Catch:{ all -> 0x0055 }
            r5 = 500(0x1f4, float:7.0E-43)
            r0 = r9
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r10
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0055 }
            int r10 = r8.size()     // Catch:{ all -> 0x0055 }
            r0 = 0
            if (r10 == 0) goto L_0x0045
            int r10 = r6.size()     // Catch:{ all -> 0x0055 }
            if (r10 != 0) goto L_0x0045
            int r10 = r7.size()     // Catch:{ all -> 0x0055 }
            if (r10 != 0) goto L_0x0045
            java.lang.Object r10 = r8.get(r0)     // Catch:{ all -> 0x0055 }
            com.baidu.mobstat.i r10 = (com.baidu.mobstat.i) r10     // Catch:{ all -> 0x0055 }
            long r1 = r10.a()     // Catch:{ all -> 0x0055 }
            java.lang.String r10 = r10.b()     // Catch:{ all -> 0x0055 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0055 }
            r7.add(r1)     // Catch:{ all -> 0x0055 }
            r6.add(r10)     // Catch:{ all -> 0x0055 }
        L_0x0045:
            int r10 = r9.a(r7)     // Catch:{ all -> 0x0055 }
            int r1 = r6.size()     // Catch:{ all -> 0x0055 }
            if (r10 == r1) goto L_0x0053
            java.util.List r6 = r6.subList(r0, r10)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r9)
            return r6
        L_0x0055:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.k.a(int):java.util.List");
    }

    private int a(List<String> list, ArrayList<Long> arrayList, ArrayList<i> arrayList2, int i2, int i3) {
        int c2 = c();
        int i4 = 0;
        int i5 = 0;
        while (c2 > 0) {
            if (c2 < i3) {
                i3 = c2;
            }
            ArrayList a2 = a(i3, i5);
            if (i5 == 0 && a2.size() != 0) {
                arrayList2.add((i) a2.get(0));
            }
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                long a3 = iVar.a();
                String b2 = iVar.b();
                int length = b2.length() + i4;
                if (length > i2) {
                    break;
                }
                arrayList.add(Long.valueOf(a3));
                list.add(b2);
                i4 = length;
            }
            c2 -= i3;
            i5 += i3;
        }
        return i4;
    }
}
