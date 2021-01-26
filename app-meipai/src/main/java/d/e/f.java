package d.e;

import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: LruCache */
public class f<K, V> {

    /* renamed from: a reason: collision with root package name */
    public final LinkedHashMap<K, V> f4574a;

    /* renamed from: b reason: collision with root package name */
    public int f4575b;

    /* renamed from: c reason: collision with root package name */
    public int f4576c;

    /* renamed from: d reason: collision with root package name */
    public int f4577d;

    /* renamed from: e reason: collision with root package name */
    public int f4578e;

    /* renamed from: f reason: collision with root package name */
    public int f4579f;

    /* renamed from: g reason: collision with root package name */
    public int f4580g;

    public f(int i2) {
        if (i2 > 0) {
            this.f4576c = i2;
            this.f4574a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public void a(int i2) {
        if (i2 > 0) {
            synchronized (this) {
                this.f4576c = i2;
            }
            b(i2);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.IllegalStateException(r0.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r3) {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            int r0 = r2.f4575b     // Catch:{ all -> 0x0069 }
            if (r0 < 0) goto L_0x004a
            java.util.LinkedHashMap<K, V> r0 = r2.f4574a     // Catch:{ all -> 0x0069 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0011
            int r0 = r2.f4575b     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x004a
        L_0x0011:
            int r0 = r2.f4575b     // Catch:{ all -> 0x0069 }
            if (r0 <= r3) goto L_0x0048
            java.util.LinkedHashMap<K, V> r0 = r2.f4574a     // Catch:{ all -> 0x0069 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x001e
            goto L_0x0048
        L_0x001e:
            java.util.LinkedHashMap<K, V> r0 = r2.f4574a     // Catch:{ all -> 0x0069 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0069 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0069 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0069 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0069 }
            r0.getValue()     // Catch:{ all -> 0x0069 }
            java.util.LinkedHashMap<K, V> r0 = r2.f4574a     // Catch:{ all -> 0x0069 }
            r0.remove(r1)     // Catch:{ all -> 0x0069 }
            int r0 = r2.f4575b     // Catch:{ all -> 0x0069 }
            int r0 = r0 + -1
            r2.f4575b = r0     // Catch:{ all -> 0x0069 }
            int r0 = r2.f4578e     // Catch:{ all -> 0x0069 }
            int r0 = r0 + 1
            r2.f4578e = r0     // Catch:{ all -> 0x0069 }
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            goto L_0x0000
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            return
        L_0x004a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r0.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.Class r1 = r2.getClass()     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0069 }
            r0.append(r1)     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0069 }
            r3.<init>(r0)     // Catch:{ all -> 0x0069 }
            throw r3     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.f.b(int):void");
    }

    public final synchronized String toString() {
        int i2;
        i2 = this.f4579f + this.f4580g;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f4576c), Integer.valueOf(this.f4579f), Integer.valueOf(this.f4580g), Integer.valueOf(i2 != 0 ? (this.f4579f * 100) / i2 : 0)});
    }

    public final V a(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.f4574a.get(k);
                if (v != null) {
                    this.f4579f++;
                    return v;
                }
                this.f4580g++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f4577d++;
            this.f4575b++;
            put = this.f4574a.put(k, v);
            if (put != null) {
                this.f4575b--;
            }
        }
        b(this.f4576c);
        return put;
    }
}
