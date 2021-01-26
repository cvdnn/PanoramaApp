package e.d.a.n.n;

import android.util.Log;
import d.h.j.c;
import e.d.a.n.h;
import e.d.a.n.p.h.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath */
public class j<DataType, ResourceType, Transcode> {

    /* renamed from: a reason: collision with root package name */
    public final Class<DataType> f7430a;

    /* renamed from: b reason: collision with root package name */
    public final List<? extends e.d.a.n.j<DataType, ResourceType>> f7431b;

    /* renamed from: c reason: collision with root package name */
    public final e<ResourceType, Transcode> f7432c;

    /* renamed from: d reason: collision with root package name */
    public final c<List<Throwable>> f7433d;

    /* renamed from: e reason: collision with root package name */
    public final String f7434e;

    /* compiled from: DecodePath */
    public interface a<ResourceType> {
    }

    public j(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends e.d.a.n.j<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, c<List<Throwable>> cVar) {
        this.f7430a = cls;
        this.f7431b = list;
        this.f7432c = eVar;
        this.f7433d = cVar;
        StringBuilder a2 = e.a.a.a.a.a("Failed DecodePath{");
        a2.append(cls.getSimpleName());
        String str = "->";
        a2.append(str);
        a2.append(cls2.getSimpleName());
        a2.append(str);
        a2.append(cls3.getSimpleName());
        a2.append("}");
        this.f7434e = a2.toString();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r0v5, types: [e.d.a.n.n.w, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v6, types: [e.d.a.n.n.w] */
    /* JADX WARNING: type inference failed for: r0v7, types: [e.d.a.n.n.v<Z>, e.d.a.n.n.v] */
    /* JADX WARNING: type inference failed for: r11v14, types: [e.d.a.n.n.e] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r1v10, types: [e.d.a.n.n.w] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.d.a.n.n.w<Transcode> a(e.d.a.n.m.e<DataType> r11, int r12, int r13, e.d.a.n.h r14, e.d.a.n.n.j.a<ResourceType> r15) throws e.d.a.n.n.r {
        /*
            r10 = this;
            d.h.j.c<java.util.List<java.lang.Throwable>> r0 = r10.f7433d
            java.lang.Object r0 = r0.a()
            java.lang.String r1 = "Argument must not be null"
            e.c.f.n.n.a(r0, r1)
            java.util.List r0 = (java.util.List) r0
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r0
            e.d.a.n.n.w r11 = r2.a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x011c }
            d.h.j.c<java.util.List<java.lang.Throwable>> r12 = r10.f7433d
            r12.a(r0)
            e.d.a.n.n.i$b r15 = (e.d.a.n.n.i.b) r15
            e.d.a.n.n.i r12 = e.d.a.n.n.i.this
            e.d.a.n.a r13 = r15.f7411a
            r15 = 0
            if (r12 == 0) goto L_0x011b
            java.lang.Object r0 = r11.get()
            java.lang.Class r8 = r0.getClass()
            e.d.a.n.a r0 = e.d.a.n.a.RESOURCE_DISK_CACHE
            if (r13 == r0) goto L_0x0044
            e.d.a.n.n.h<R> r0 = r12.f7401a
            e.d.a.n.l r0 = r0.b(r8)
            e.d.a.d r1 = r12.f7408h
            int r2 = r12.l
            int r3 = r12.m
            e.d.a.n.n.w r1 = r0.a(r1, r11, r2, r3)
            r7 = r0
            r0 = r1
            goto L_0x0046
        L_0x0044:
            r0 = r11
            r7 = r15
        L_0x0046:
            boolean r1 = r11.equals(r0)
            if (r1 != 0) goto L_0x004f
            r11.b()
        L_0x004f:
            e.d.a.n.n.h<R> r11 = r12.f7401a
            e.d.a.d r11 = r11.f7393c
            e.d.a.h r11 = r11.f7102b
            e.d.a.q.f r11 = r11.f7123d
            java.lang.Class r1 = r0.c()
            e.d.a.n.k r11 = r11.a(r1)
            r1 = 0
            r2 = 1
            if (r11 == 0) goto L_0x0065
            r11 = r2
            goto L_0x0066
        L_0x0065:
            r11 = r1
        L_0x0066:
            if (r11 == 0) goto L_0x008b
            e.d.a.n.n.h<R> r11 = r12.f7401a
            e.d.a.d r11 = r11.f7393c
            e.d.a.h r11 = r11.f7102b
            e.d.a.q.f r11 = r11.f7123d
            java.lang.Class r15 = r0.c()
            e.d.a.n.k r15 = r11.a(r15)
            if (r15 == 0) goto L_0x0081
            e.d.a.n.h r11 = r12.o
            e.d.a.n.c r11 = r15.a(r11)
            goto L_0x008d
        L_0x0081:
            e.d.a.h$d r11 = new e.d.a.h$d
            java.lang.Class r12 = r0.c()
            r11.<init>(r12)
            throw r11
        L_0x008b:
            e.d.a.n.c r11 = e.d.a.n.c.NONE
        L_0x008d:
            e.d.a.n.n.h<R> r3 = r12.f7401a
            e.d.a.n.f r4 = r12.x
            java.util.List r3 = r3.c()
            int r5 = r3.size()
            r6 = r1
        L_0x009a:
            if (r6 >= r5) goto L_0x00af
            java.lang.Object r9 = r3.get(r6)
            e.d.a.n.o.n$a r9 = (e.d.a.n.o.n.a) r9
            e.d.a.n.f r9 = r9.f7578a
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x00ac
            r1 = r2
            goto L_0x00af
        L_0x00ac:
            int r6 = r6 + 1
            goto L_0x009a
        L_0x00af:
            r1 = r1 ^ r2
            e.d.a.n.n.k r3 = r12.n
            boolean r13 = r3.a(r1, r13, r11)
            if (r13 == 0) goto L_0x0114
            if (r15 == 0) goto L_0x0106
            int r13 = r11.ordinal()
            if (r13 == 0) goto L_0x00f0
            if (r13 != r2) goto L_0x00d9
            e.d.a.n.n.y r11 = new e.d.a.n.n.y
            e.d.a.n.n.h<R> r13 = r12.f7401a
            e.d.a.d r13 = r13.f7393c
            e.d.a.n.n.c0.b r2 = r13.f7101a
            e.d.a.n.f r3 = r12.x
            e.d.a.n.f r4 = r12.f7409i
            int r5 = r12.l
            int r6 = r12.m
            e.d.a.n.h r9 = r12.o
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x00f9
        L_0x00d9:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Unknown strategy: "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        L_0x00f0:
            e.d.a.n.n.e r11 = new e.d.a.n.n.e
            e.d.a.n.f r13 = r12.x
            e.d.a.n.f r1 = r12.f7409i
            r11.<init>(r13, r1)
        L_0x00f9:
            e.d.a.n.n.v r0 = e.d.a.n.n.v.a(r0)
            e.d.a.n.n.i$c<?> r12 = r12.f7406f
            r12.f7413a = r11
            r12.f7414b = r15
            r12.f7415c = r0
            goto L_0x0114
        L_0x0106:
            e.d.a.h$d r11 = new e.d.a.h$d
            java.lang.Object r12 = r0.get()
            java.lang.Class r12 = r12.getClass()
            r11.<init>(r12)
            throw r11
        L_0x0114:
            e.d.a.n.p.h.e<ResourceType, Transcode> r11 = r10.f7432c
            e.d.a.n.n.w r11 = r11.a(r0, r14)
            return r11
        L_0x011b:
            throw r15
        L_0x011c:
            r11 = move-exception
            d.h.j.c<java.util.List<java.lang.Throwable>> r12 = r10.f7433d
            r12.a(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.j.a(e.d.a.n.m.e, int, int, e.d.a.n.h, e.d.a.n.n.j$a):e.d.a.n.n.w");
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("DecodePath{ dataClass=");
        a2.append(this.f7430a);
        a2.append(", decoders=");
        a2.append(this.f7431b);
        a2.append(", transcoder=");
        a2.append(this.f7432c);
        a2.append('}');
        return a2.toString();
    }

    public final w<ResourceType> a(e.d.a.n.m.e<DataType> eVar, int i2, int i3, h hVar, List<Throwable> list) throws r {
        int size = this.f7431b.size();
        w<ResourceType> wVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            e.d.a.n.j jVar = (e.d.a.n.j) this.f7431b.get(i4);
            try {
                if (jVar.a(eVar.a(), hVar)) {
                    wVar = jVar.a(eVar.a(), i2, i3, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                String str = "DecodePath";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(jVar);
                    Log.v(str, sb.toString(), e2);
                }
                list.add(e2);
            }
            if (wVar != null) {
                break;
            }
        }
        if (wVar != null) {
            return wVar;
        }
        throw new r(this.f7434e, (List<Throwable>) new ArrayList<Throwable>(list));
    }
}
