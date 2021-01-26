package a.a.a.a.a.f.e;

import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.work.Work;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class b {

    /* renamed from: c reason: collision with root package name */
    public static b f385c;

    /* renamed from: d reason: collision with root package name */
    public static final MediaLogger f386d = MediaLogger.getLogger(b.class);

    /* renamed from: a reason: collision with root package name */
    public ConcurrentHashMap<Work, List<a>> f387a = new ConcurrentHashMap<>();

    /* renamed from: b reason: collision with root package name */
    public List<a> f388b = Collections.synchronizedList(new ArrayList());

    public interface a {
        void IL1Iii(Work work, int i2);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f385c == null) {
                f385c = new b();
            }
            bVar = f385c;
        }
        return bVar;
    }

    public synchronized void a(Work work, a aVar) {
        if (work == null || aVar == null) {
            f386d.e("addReference, but params are null");
            return;
        }
        List list = (List) this.f387a.get(work);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList());
            this.f387a.put(work, list);
        }
        list.add(aVar);
        for (a IL1Iii : this.f388b) {
            IL1Iii.IL1Iii(work, list.size());
        }
        MediaLogger mediaLogger = f386d;
        StringBuilder sb = new StringBuilder();
        sb.append("work: ");
        sb.append(Arrays.toString(work.getUrlsForPlay()));
        sb.append(" reference count is increased to: ");
        sb.append(list.size());
        mediaLogger.d(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.arashivision.insta360.basemedia.model.work.Work r4, a.a.a.a.a.f.e.a r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x0064
            if (r5 != 0) goto L_0x0006
            goto L_0x0064
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap<com.arashivision.insta360.basemedia.model.work.Work, java.util.List<a.a.a.a.a.f.e.a>> r0 = r3.f387a     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x006d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0062
            r0.remove(r5)     // Catch:{ all -> 0x006d }
            java.util.List<a.a.a.a.a.f.e.b$a> r5 = r3.f388b     // Catch:{ all -> 0x006d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x006d }
        L_0x0019:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x006d }
            a.a.a.a.a.f.e.b$a r1 = (a.a.a.a.a.f.e.b.a) r1     // Catch:{ all -> 0x006d }
            int r2 = r0.size()     // Catch:{ all -> 0x006d }
            r1.IL1Iii(r4, r2)     // Catch:{ all -> 0x006d }
            goto L_0x0019
        L_0x002d:
            com.arashivision.insta360.basemedia.log.MediaLogger r5 = f386d     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "work: "
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String[] r2 = r4.getUrlsForPlay()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = java.util.Arrays.toString(r2)     // Catch:{ all -> 0x006d }
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r2 = " reference count is decreased to: "
            r1.append(r2)     // Catch:{ all -> 0x006d }
            int r2 = r0.size()     // Catch:{ all -> 0x006d }
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006d }
            r5.d(r1)     // Catch:{ all -> 0x006d }
            int r5 = r0.size()     // Catch:{ all -> 0x006d }
            if (r5 != 0) goto L_0x0062
            java.util.concurrent.ConcurrentHashMap<com.arashivision.insta360.basemedia.model.work.Work, java.util.List<a.a.a.a.a.f.e.a>> r5 = r3.f387a     // Catch:{ all -> 0x006d }
            r5.remove(r4)     // Catch:{ all -> 0x006d }
        L_0x0062:
            monitor-exit(r3)
            return
        L_0x0064:
            com.arashivision.insta360.basemedia.log.MediaLogger r4 = f386d     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "removeReference, but params are null"
            r4.e(r5)     // Catch:{ all -> 0x006d }
            monitor-exit(r3)
            return
        L_0x006d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.f.e.b.b(com.arashivision.insta360.basemedia.model.work.Work, a.a.a.a.a.f.e.a):void");
    }
}
