package d.p;

import d.c.a.b.b.c;
import d.p.e.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map.Entry;

/* compiled from: LifecycleRegistry */
public class i extends e {

    /* renamed from: a reason: collision with root package name */
    public d.c.a.b.a<g, a> f5280a = new d.c.a.b.a<>();

    /* renamed from: b reason: collision with root package name */
    public b f5281b;

    /* renamed from: c reason: collision with root package name */
    public final WeakReference<h> f5282c;

    /* renamed from: d reason: collision with root package name */
    public int f5283d = 0;

    /* renamed from: e reason: collision with root package name */
    public boolean f5284e = false;

    /* renamed from: f reason: collision with root package name */
    public boolean f5285f = false;

    /* renamed from: g reason: collision with root package name */
    public ArrayList<b> f5286g = new ArrayList<>();

    /* compiled from: LifecycleRegistry */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public b f5287a;

        /* renamed from: b reason: collision with root package name */
        public f f5288b;

        public a(g gVar, b bVar) {
            this.f5288b = k.a((Object) gVar);
            this.f5287a = bVar;
        }

        public void a(h hVar, d.p.e.a aVar) {
            b b2 = i.b(aVar);
            this.f5287a = i.a(this.f5287a, b2);
            this.f5288b.onStateChanged(hVar, aVar);
            this.f5287a = b2;
        }
    }

    public i(h hVar) {
        this.f5282c = new WeakReference<>(hVar);
        this.f5281b = b.INITIALIZED;
    }

    public void a(d.p.e.a aVar) {
        a(b(aVar));
    }

    public final b b(g gVar) {
        d.c.a.b.a<g, a> aVar = this.f5280a;
        b bVar = null;
        Entry entry = aVar.f4527e.containsKey(gVar) ? ((c) aVar.f4527e.get(gVar)).f4535d : null;
        b bVar2 = entry != null ? ((a) entry.getValue()).f5287a : null;
        if (!this.f5286g.isEmpty()) {
            ArrayList<b> arrayList = this.f5286g;
            bVar = (b) arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f5281b, bVar2), bVar);
    }

    public final void a(b bVar) {
        if (this.f5281b != bVar) {
            this.f5281b = bVar;
            if (this.f5284e || this.f5283d != 0) {
                this.f5285f = true;
                return;
            }
            this.f5284e = true;
            b();
            this.f5284e = false;
        }
    }

    public static b b(d.p.e.a aVar) {
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return b.RESUMED;
                }
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return b.DESTROYED;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected event value ");
                        sb.append(aVar);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
            return b.STARTED;
        }
        return b.CREATED;
    }

    public void a(g gVar) {
        b bVar = this.f5281b;
        b bVar2 = b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = b.INITIALIZED;
        }
        a aVar = new a(gVar, bVar2);
        if (((a) this.f5280a.b(gVar, aVar)) == null) {
            h hVar = (h) this.f5282c.get();
            if (hVar != null) {
                boolean z = this.f5283d != 0 || this.f5284e;
                b b2 = b(gVar);
                this.f5283d++;
                while (aVar.f5287a.compareTo(b2) < 0 && this.f5280a.f4527e.containsKey(gVar)) {
                    this.f5286g.add(aVar.f5287a);
                    aVar.a(hVar, b(aVar.f5287a));
                    a();
                    b2 = b(gVar);
                }
                if (!z) {
                    b();
                }
                this.f5283d--;
            }
        }
    }

    public static d.p.e.a b(b bVar) {
        int ordinal = bVar.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return d.p.e.a.ON_CREATE;
        }
        if (ordinal == 2) {
            return d.p.e.a.ON_START;
        }
        if (ordinal == 3) {
            return d.p.e.a.ON_RESUME;
        }
        if (ordinal != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected state value ");
            sb.append(bVar);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0140 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r8 = this;
            java.lang.ref.WeakReference<d.p.h> r0 = r8.f5282c
            java.lang.Object r0 = r0.get()
            d.p.h r0 = (d.p.h) r0
            if (r0 == 0) goto L_0x0143
        L_0x000a:
            d.c.a.b.a<d.p.g, d.p.i$a> r1 = r8.f5280a
            int r2 = r1.f4531d
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0013
            goto L_0x002f
        L_0x0013:
            d.c.a.b.b$c<K, V> r1 = r1.f4528a
            java.lang.Object r1 = r1.getValue()
            d.p.i$a r1 = (d.p.i.a) r1
            d.p.e$b r1 = r1.f5287a
            d.c.a.b.a<d.p.g, d.p.i$a> r2 = r8.f5280a
            d.c.a.b.b$c<K, V> r2 = r2.f4529b
            java.lang.Object r2 = r2.getValue()
            d.p.i$a r2 = (d.p.i.a) r2
            d.p.e$b r2 = r2.f5287a
            if (r1 != r2) goto L_0x0031
            d.p.e$b r1 = r8.f5281b
            if (r1 != r2) goto L_0x0031
        L_0x002f:
            r1 = r3
            goto L_0x0032
        L_0x0031:
            r1 = r4
        L_0x0032:
            if (r1 != 0) goto L_0x0140
            r8.f5285f = r4
            d.p.e$b r1 = r8.f5281b
            d.c.a.b.a<d.p.g, d.p.i$a> r2 = r8.f5280a
            d.c.a.b.b$c<K, V> r2 = r2.f4528a
            java.lang.Object r2 = r2.getValue()
            d.p.i$a r2 = (d.p.i.a) r2
            d.p.e$b r2 = r2.f5287a
            int r1 = r1.compareTo(r2)
            if (r1 >= 0) goto L_0x00dc
            d.c.a.b.a<d.p.g, d.p.i$a> r1 = r8.f5280a
            d.c.a.b.b$b r2 = new d.c.a.b.b$b
            d.c.a.b.b$c<K, V> r5 = r1.f4529b
            d.c.a.b.b$c<K, V> r6 = r1.f4528a
            r2.<init>(r5, r6)
            java.util.WeakHashMap<d.c.a.b.b$f<K, V>, java.lang.Boolean> r1 = r1.f4530c
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.put(r2, r4)
        L_0x005e:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x00dc
            boolean r1 = r8.f5285f
            if (r1 != 0) goto L_0x00dc
            java.lang.Object r1 = r2.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getValue()
            d.p.i$a r4 = (d.p.i.a) r4
        L_0x0074:
            d.p.e$b r5 = r4.f5287a
            d.p.e$b r6 = r8.f5281b
            int r5 = r5.compareTo(r6)
            if (r5 <= 0) goto L_0x005e
            boolean r5 = r8.f5285f
            if (r5 != 0) goto L_0x005e
            d.c.a.b.a<d.p.g, d.p.i$a> r5 = r8.f5280a
            java.lang.Object r6 = r1.getKey()
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x005e
            d.p.e$b r5 = r4.f5287a
            int r6 = r5.ordinal()
            if (r6 == 0) goto L_0x00d6
            if (r6 == r3) goto L_0x00d0
            r7 = 2
            if (r6 == r7) goto L_0x00be
            r7 = 3
            if (r6 == r7) goto L_0x00bb
            r7 = 4
            if (r6 != r7) goto L_0x00a4
            d.p.e$a r5 = d.p.e.a.ON_PAUSE
            goto L_0x00c0
        L_0x00a4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected state value "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00bb:
            d.p.e$a r5 = d.p.e.a.ON_STOP
            goto L_0x00c0
        L_0x00be:
            d.p.e$a r5 = d.p.e.a.ON_DESTROY
        L_0x00c0:
            d.p.e$b r6 = b(r5)
            java.util.ArrayList<d.p.e$b> r7 = r8.f5286g
            r7.add(r6)
            r4.a(r0, r5)
            r8.a()
            goto L_0x0074
        L_0x00d0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x00d6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x00dc:
            d.c.a.b.a<d.p.g, d.p.i$a> r1 = r8.f5280a
            d.c.a.b.b$c<K, V> r1 = r1.f4529b
            boolean r2 = r8.f5285f
            if (r2 != 0) goto L_0x000a
            if (r1 == 0) goto L_0x000a
            d.p.e$b r2 = r8.f5281b
            java.lang.Object r1 = r1.getValue()
            d.p.i$a r1 = (d.p.i.a) r1
            d.p.e$b r1 = r1.f5287a
            int r1 = r2.compareTo(r1)
            if (r1 <= 0) goto L_0x000a
            d.c.a.b.a<d.p.g, d.p.i$a> r1 = r8.f5280a
            d.c.a.b.b$d r1 = r1.a()
        L_0x00fc:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x000a
            boolean r2 = r8.f5285f
            if (r2 != 0) goto L_0x000a
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            d.p.i$a r3 = (d.p.i.a) r3
        L_0x0112:
            d.p.e$b r4 = r3.f5287a
            d.p.e$b r5 = r8.f5281b
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L_0x00fc
            boolean r4 = r8.f5285f
            if (r4 != 0) goto L_0x00fc
            d.c.a.b.a<d.p.g, d.p.i$a> r4 = r8.f5280a
            java.lang.Object r5 = r2.getKey()
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x00fc
            d.p.e$b r4 = r3.f5287a
            java.util.ArrayList<d.p.e$b> r5 = r8.f5286g
            r5.add(r4)
            d.p.e$b r4 = r3.f5287a
            d.p.e$a r4 = b(r4)
            r3.a(r0, r4)
            r8.a()
            goto L_0x0112
        L_0x0140:
            r8.f5285f = r4
            return
        L_0x0143:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.p.i.b():void");
    }

    public final void a() {
        ArrayList<b> arrayList = this.f5286g;
        arrayList.remove(arrayList.size() - 1);
    }

    public static b a(b bVar, b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
