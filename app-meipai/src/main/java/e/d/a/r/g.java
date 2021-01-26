package e.d.a.r;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.baidu.mobstat.Config;
import e.d.a.f;
import e.d.a.n.n.l;
import e.d.a.n.n.r;
import e.d.a.n.n.w;
import e.d.a.r.h.h;
import e.d.a.r.i.c;
import e.d.a.t.j;
import e.d.a.t.k.d;
import e.d.a.t.k.d.b;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest */
public final class g<R> implements b, e.d.a.r.h.g, f {
    public static final boolean D = Log.isLoggable("Request", 2);
    public int A;
    public boolean B;
    public RuntimeException C;

    /* renamed from: a reason: collision with root package name */
    public final String f7865a;

    /* renamed from: b reason: collision with root package name */
    public final d f7866b;

    /* renamed from: c reason: collision with root package name */
    public final Object f7867c;

    /* renamed from: d reason: collision with root package name */
    public final d<R> f7868d;

    /* renamed from: e reason: collision with root package name */
    public final c f7869e;

    /* renamed from: f reason: collision with root package name */
    public final Context f7870f;

    /* renamed from: g reason: collision with root package name */
    public final e.d.a.d f7871g;

    /* renamed from: h reason: collision with root package name */
    public final Object f7872h;

    /* renamed from: i reason: collision with root package name */
    public final Class<R> f7873i;

    /* renamed from: j reason: collision with root package name */
    public final a<?> f7874j;
    public final int k;
    public final int l;
    public final f m;
    public final h<R> n;
    public final List<d<R>> o;
    public final c<? super R> p;
    public final Executor q;
    public w<R> r;
    public l.d s;
    public long t;
    public volatile l u;
    public a v;
    public Drawable w;
    public Drawable x;
    public Drawable y;
    public int z;

    /* compiled from: SingleRequest */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public g(Context context, e.d.a.d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, f fVar, h<R> hVar, d<R> dVar2, List<d<R>> list, c cVar, l lVar, c<? super R> cVar2, Executor executor) {
        e.d.a.d dVar3 = dVar;
        this.f7865a = D ? String.valueOf(super.hashCode()) : null;
        this.f7866b = new b();
        this.f7867c = obj;
        this.f7870f = context;
        this.f7871g = dVar3;
        this.f7872h = obj2;
        this.f7873i = cls;
        this.f7874j = aVar;
        this.k = i2;
        this.l = i3;
        this.m = fVar;
        this.n = hVar;
        this.f7868d = dVar2;
        this.o = list;
        this.f7869e = cVar;
        this.u = lVar;
        this.p = cVar2;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && dVar3.f7108h) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public boolean a() {
        boolean z2;
        synchronized (this.f7867c) {
            z2 = this.v == a.CLEARED;
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f7867c
            monitor-enter(r0)
            r4.e()     // Catch:{ all -> 0x00b9 }
            e.d.a.t.k.d r1 = r4.f7866b     // Catch:{ all -> 0x00b9 }
            r1.a()     // Catch:{ all -> 0x00b9 }
            long r1 = e.d.a.t.f.a()     // Catch:{ all -> 0x00b9 }
            r4.t = r1     // Catch:{ all -> 0x00b9 }
            java.lang.Object r1 = r4.f7872h     // Catch:{ all -> 0x00b9 }
            if (r1 != 0) goto L_0x003c
            int r1 = r4.k     // Catch:{ all -> 0x00b9 }
            int r2 = r4.l     // Catch:{ all -> 0x00b9 }
            boolean r1 = e.d.a.t.j.a(r1, r2)     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x0027
            int r1 = r4.k     // Catch:{ all -> 0x00b9 }
            r4.z = r1     // Catch:{ all -> 0x00b9 }
            int r1 = r4.l     // Catch:{ all -> 0x00b9 }
            r4.A = r1     // Catch:{ all -> 0x00b9 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r4.f()     // Catch:{ all -> 0x00b9 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            e.d.a.n.n.r r2 = new e.d.a.n.n.r     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00b9 }
            r4.a(r2, r1)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b9 }
            return
        L_0x003c:
            e.d.a.r.g$a r1 = r4.v     // Catch:{ all -> 0x00b9 }
            e.d.a.r.g$a r2 = e.d.a.r.g.a.RUNNING     // Catch:{ all -> 0x00b9 }
            if (r1 == r2) goto L_0x00b1
            e.d.a.r.g$a r1 = r4.v     // Catch:{ all -> 0x00b9 }
            e.d.a.r.g$a r2 = e.d.a.r.g.a.COMPLETE     // Catch:{ all -> 0x00b9 }
            if (r1 != r2) goto L_0x0051
            e.d.a.n.n.w<R> r1 = r4.r     // Catch:{ all -> 0x00b9 }
            e.d.a.n.a r2 = e.d.a.n.a.MEMORY_CACHE     // Catch:{ all -> 0x00b9 }
            r4.a(r1, r2)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b9 }
            return
        L_0x0051:
            e.d.a.r.g$a r1 = e.d.a.r.g.a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00b9 }
            r4.v = r1     // Catch:{ all -> 0x00b9 }
            int r1 = r4.k     // Catch:{ all -> 0x00b9 }
            int r2 = r4.l     // Catch:{ all -> 0x00b9 }
            boolean r1 = e.d.a.t.j.a(r1, r2)     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x0067
            int r1 = r4.k     // Catch:{ all -> 0x00b9 }
            int r2 = r4.l     // Catch:{ all -> 0x00b9 }
            r4.a(r1, r2)     // Catch:{ all -> 0x00b9 }
            goto L_0x006c
        L_0x0067:
            e.d.a.r.h.h<R> r1 = r4.n     // Catch:{ all -> 0x00b9 }
            r1.b(r4)     // Catch:{ all -> 0x00b9 }
        L_0x006c:
            e.d.a.r.g$a r1 = r4.v     // Catch:{ all -> 0x00b9 }
            e.d.a.r.g$a r2 = e.d.a.r.g.a.RUNNING     // Catch:{ all -> 0x00b9 }
            if (r1 == r2) goto L_0x0078
            e.d.a.r.g$a r1 = r4.v     // Catch:{ all -> 0x00b9 }
            e.d.a.r.g$a r2 = e.d.a.r.g.a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00b9 }
            if (r1 != r2) goto L_0x0091
        L_0x0078:
            e.d.a.r.c r1 = r4.f7869e     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x0085
            boolean r1 = r1.b(r4)     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r1 = 0
            goto L_0x0086
        L_0x0085:
            r1 = 1
        L_0x0086:
            if (r1 == 0) goto L_0x0091
            e.d.a.r.h.h<R> r1 = r4.n     // Catch:{ all -> 0x00b9 }
            android.graphics.drawable.Drawable r2 = r4.g()     // Catch:{ all -> 0x00b9 }
            r1.b(r2)     // Catch:{ all -> 0x00b9 }
        L_0x0091:
            boolean r1 = D     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x00af
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r1.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00b9 }
            long r2 = r4.t     // Catch:{ all -> 0x00b9 }
            double r2 = e.d.a.t.f.a(r2)     // Catch:{ all -> 0x00b9 }
            r1.append(r2)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b9 }
            r4.a(r1)     // Catch:{ all -> 0x00b9 }
        L_0x00af:
            monitor-exit(r0)     // Catch:{ all -> 0x00b9 }
            return
        L_0x00b1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00b9 }
            throw r1     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b9 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.r.g.b():void");
    }

    public boolean c() {
        boolean z2;
        synchronized (this.f7867c) {
            z2 = this.v == a.COMPLETE;
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r2 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r4.u.a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f7867c
            monitor-enter(r0)
            r4.e()     // Catch:{ all -> 0x0059 }
            e.d.a.t.k.d r1 = r4.f7866b     // Catch:{ all -> 0x0059 }
            r1.a()     // Catch:{ all -> 0x0059 }
            e.d.a.r.g$a r1 = r4.v     // Catch:{ all -> 0x0059 }
            e.d.a.r.g$a r2 = e.d.a.r.g.a.CLEARED     // Catch:{ all -> 0x0059 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            return
        L_0x0013:
            r4.e()     // Catch:{ all -> 0x0059 }
            e.d.a.t.k.d r1 = r4.f7866b     // Catch:{ all -> 0x0059 }
            r1.a()     // Catch:{ all -> 0x0059 }
            e.d.a.r.h.h<R> r1 = r4.n     // Catch:{ all -> 0x0059 }
            r1.a(r4)     // Catch:{ all -> 0x0059 }
            e.d.a.n.n.l$d r1 = r4.s     // Catch:{ all -> 0x0059 }
            r2 = 0
            if (r1 == 0) goto L_0x002a
            r1.a()     // Catch:{ all -> 0x0059 }
            r4.s = r2     // Catch:{ all -> 0x0059 }
        L_0x002a:
            e.d.a.n.n.w<R> r1 = r4.r     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0033
            e.d.a.n.n.w<R> r1 = r4.r     // Catch:{ all -> 0x0059 }
            r4.r = r2     // Catch:{ all -> 0x0059 }
            r2 = r1
        L_0x0033:
            e.d.a.r.c r1 = r4.f7869e     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0040
            boolean r1 = r1.e(r4)     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r1 = 0
            goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            if (r1 == 0) goto L_0x004c
            e.d.a.r.h.h<R> r1 = r4.n     // Catch:{ all -> 0x0059 }
            android.graphics.drawable.Drawable r3 = r4.g()     // Catch:{ all -> 0x0059 }
            r1.c(r3)     // Catch:{ all -> 0x0059 }
        L_0x004c:
            e.d.a.r.g$a r1 = e.d.a.r.g.a.CLEARED     // Catch:{ all -> 0x0059 }
            r4.v = r1     // Catch:{ all -> 0x0059 }
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0058
            e.d.a.n.n.l r0 = r4.u
            r0.a(r2)
        L_0x0058:
            return
        L_0x0059:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.r.g.clear():void");
    }

    public void d() {
        synchronized (this.f7867c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public final void e() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public final Drawable f() {
        if (this.y == null) {
            a<?> aVar = this.f7874j;
            Drawable drawable = aVar.o;
            this.y = drawable;
            if (drawable == null) {
                int i2 = aVar.p;
                if (i2 > 0) {
                    this.y = a(i2);
                }
            }
        }
        return this.y;
    }

    public final Drawable g() {
        if (this.x == null) {
            a<?> aVar = this.f7874j;
            Drawable drawable = aVar.f7861g;
            this.x = drawable;
            if (drawable == null) {
                int i2 = aVar.f7862h;
                if (i2 > 0) {
                    this.x = a(i2);
                }
            }
        }
        return this.x;
    }

    public final boolean h() {
        c cVar = this.f7869e;
        return cVar == null || !cVar.a().b();
    }

    public final void i() {
        c cVar = this.f7869e;
        if (cVar == null || cVar.b(this)) {
            Drawable drawable = null;
            if (this.f7872h == null) {
                drawable = f();
            }
            if (drawable == null) {
                if (this.w == null) {
                    a<?> aVar = this.f7874j;
                    Drawable drawable2 = aVar.f7859e;
                    this.w = drawable2;
                    if (drawable2 == null) {
                        int i2 = aVar.f7860f;
                        if (i2 > 0) {
                            this.w = a(i2);
                        }
                    }
                }
                drawable = this.w;
            }
            if (drawable == null) {
                drawable = g();
            }
            this.n.a(drawable);
        }
    }

    public boolean isRunning() {
        boolean z2;
        synchronized (this.f7867c) {
            if (this.v != a.RUNNING) {
                if (this.v != a.WAITING_FOR_SIZE) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final Drawable a(int i2) {
        Theme theme = this.f7874j.u;
        if (theme == null) {
            theme = this.f7870f.getTheme();
        }
        e.d.a.d dVar = this.f7871g;
        return e.d.a.n.p.e.a.a(dVar, dVar, i2, theme);
    }

    public void a(int i2, int i3) {
        Object obj;
        int i4;
        int i5 = i2;
        int i6 = i3;
        this.f7866b.a();
        Object obj2 = this.f7867c;
        synchronized (obj2) {
            try {
                if (D) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Got onSizeReady in ");
                    sb.append(e.d.a.t.f.a(this.t));
                    a(sb.toString());
                }
                if (this.v == a.WAITING_FOR_SIZE) {
                    this.v = a.RUNNING;
                    float f2 = this.f7874j.f7856b;
                    if (i5 != Integer.MIN_VALUE) {
                        i5 = Math.round(((float) i5) * f2);
                    }
                    this.z = i5;
                    if (i6 == Integer.MIN_VALUE) {
                        i4 = i6;
                    } else {
                        i4 = Math.round(f2 * ((float) i6));
                    }
                    this.A = i4;
                    if (D) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("finished setup for calling load in ");
                        sb2.append(e.d.a.t.f.a(this.t));
                        a(sb2.toString());
                    }
                    obj = obj2;
                    try {
                        try {
                            this.s = this.u.a(this.f7871g, this.f7872h, this.f7874j.l, this.z, this.A, this.f7874j.s, this.f7873i, this.m, this.f7874j.f7857c, this.f7874j.r, this.f7874j.m, this.f7874j.y, this.f7874j.q, this.f7874j.f7863i, this.f7874j.w, this.f7874j.z, this.f7874j.x, this, this.q);
                            if (this.v != a.RUNNING) {
                                this.s = null;
                            }
                            if (D) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("finished onSizeReady in ");
                                sb3.append(e.d.a.t.f.a(this.t));
                                a(sb3.toString());
                            }
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        while (true) {
                            break;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
                while (true) {
                    break;
                }
                throw th;
            }
        }
    }

    public void a(w<?> wVar, e.d.a.n.a aVar) {
        this.f7866b.a();
        w<?> wVar2 = null;
        try {
            synchronized (this.f7867c) {
                try {
                    this.s = null;
                    if (wVar == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive a Resource<R> with an object of ");
                        sb.append(this.f7873i);
                        sb.append(" inside, but instead got null.");
                        a(new r(sb.toString()), 5);
                        return;
                    }
                    Object obj = wVar.get();
                    if (obj != null) {
                        if (this.f7873i.isAssignableFrom(obj.getClass())) {
                            c cVar = this.f7869e;
                            if (!(cVar == null || cVar.c(this))) {
                                try {
                                    this.r = null;
                                    this.v = a.COMPLETE;
                                    this.u.a(wVar);
                                    return;
                                } catch (Throwable th) {
                                    wVar2 = wVar;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                a(wVar, obj, aVar);
                                return;
                            }
                        }
                    }
                    this.r = null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected to receive an object of ");
                    sb2.append(this.f7873i);
                    sb2.append(" but instead got ");
                    sb2.append(obj != null ? obj.getClass() : "");
                    sb2.append("{");
                    sb2.append(obj);
                    sb2.append("} inside Resource{");
                    sb2.append(wVar);
                    sb2.append("}.");
                    sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    a(new r(sb2.toString()), 5);
                    this.u.a(wVar);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (wVar2 != null) {
                this.u.a(wVar2);
            }
            throw th3;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(e.d.a.n.n.w<R> r11, R r12, e.d.a.n.a r13) {
        /*
            r10 = this;
            boolean r6 = r10.h()
            e.d.a.r.g$a r0 = e.d.a.r.g.a.COMPLETE
            r10.v = r0
            r10.r = r11
            e.d.a.d r11 = r10.f7871g
            int r11 = r11.f7109i
            r0 = 3
            if (r11 > r0) goto L_0x0064
            java.lang.String r11 = "Finished loading "
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r11)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f7872h
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.z
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.A
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.t
            double r0 = e.d.a.t.f.a(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r11)
        L_0x0064:
            r11 = 1
            r10.B = r11
            r7 = 0
            java.util.List<e.d.a.r.d<R>> r0 = r10.o     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x008c
            java.util.List<e.d.a.r.d<R>> r0 = r10.o     // Catch:{ all -> 0x00bf }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00bf }
            r9 = r7
        L_0x0073:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x008d
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00bf }
            e.d.a.r.d r0 = (e.d.a.r.d) r0     // Catch:{ all -> 0x00bf }
            java.lang.Object r2 = r10.f7872h     // Catch:{ all -> 0x00bf }
            e.d.a.r.h.h<R> r3 = r10.n     // Catch:{ all -> 0x00bf }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00bf }
            r9 = r9 | r0
            goto L_0x0073
        L_0x008c:
            r9 = r7
        L_0x008d:
            e.d.a.r.d<R> r0 = r10.f7868d     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00a1
            e.d.a.r.d<R> r0 = r10.f7868d     // Catch:{ all -> 0x00bf }
            java.lang.Object r2 = r10.f7872h     // Catch:{ all -> 0x00bf }
            e.d.a.r.h.h<R> r3 = r10.n     // Catch:{ all -> 0x00bf }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r13 = r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00bf }
            if (r13 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r11 = r7
        L_0x00a2:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b5
            e.d.a.r.i.c<? super R> r11 = r10.p     // Catch:{ all -> 0x00bf }
            e.d.a.r.i.a$a r11 = (e.d.a.r.i.a.C0099a) r11     // Catch:{ all -> 0x00bf }
            if (r11 == 0) goto L_0x00b3
            e.d.a.r.i.a<?> r11 = e.d.a.r.i.a.f7894a     // Catch:{ all -> 0x00bf }
            e.d.a.r.h.h<R> r13 = r10.n     // Catch:{ all -> 0x00bf }
            r13.a(r12, r11)     // Catch:{ all -> 0x00bf }
            goto L_0x00b5
        L_0x00b3:
            r11 = 0
            throw r11     // Catch:{ all -> 0x00bf }
        L_0x00b5:
            r10.B = r7
            e.d.a.r.c r11 = r10.f7869e
            if (r11 == 0) goto L_0x00be
            r11.d(r10)
        L_0x00be:
            return
        L_0x00bf:
            r11 = move-exception
            r10.B = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.r.g.a(e.d.a.n.n.w, java.lang.Object, e.d.a.n.a):void");
    }

    /* JADX INFO: finally extract failed */
    public final void a(r rVar, int i2) {
        boolean z2;
        this.f7866b.a();
        synchronized (this.f7867c) {
            if (rVar != null) {
                int i3 = this.f7871g.f7109i;
                if (i3 <= i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Load failed for ");
                    sb.append(this.f7872h);
                    sb.append(" with size [");
                    sb.append(this.z);
                    sb.append(Config.EVENT_HEAT_X);
                    sb.append(this.A);
                    sb.append("]");
                    Log.w("Glide", sb.toString(), rVar);
                    if (i3 <= 4) {
                        rVar.a("Glide");
                    }
                }
                this.s = null;
                this.v = a.FAILED;
                boolean z3 = true;
                this.B = true;
                try {
                    if (this.o != null) {
                        z2 = false;
                        for (d a2 : this.o) {
                            z2 |= a2.a(rVar, this.f7872h, this.n, h());
                        }
                    } else {
                        z2 = false;
                    }
                    if (this.f7868d == null || !this.f7868d.a(rVar, this.f7872h, this.n, h())) {
                        z3 = false;
                    }
                    if (!z2 && !z3) {
                        i();
                    }
                    this.B = false;
                    c cVar = this.f7869e;
                    if (cVar != null) {
                        cVar.a(this);
                    }
                } catch (Throwable th) {
                    this.B = false;
                    throw th;
                }
            } else {
                throw null;
            }
        }
    }

    public boolean a(b bVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        f fVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        f fVar2;
        int size2;
        b bVar2 = bVar;
        if (!(bVar2 instanceof g)) {
            return false;
        }
        synchronized (this.f7867c) {
            i2 = this.k;
            i3 = this.l;
            obj = this.f7872h;
            cls = this.f7873i;
            aVar = this.f7874j;
            fVar = this.m;
            size = this.o != null ? this.o.size() : 0;
        }
        g gVar = (g) bVar2;
        synchronized (gVar.f7867c) {
            i4 = gVar.k;
            i5 = gVar.l;
            obj2 = gVar.f7872h;
            cls2 = gVar.f7873i;
            aVar2 = gVar.f7874j;
            fVar2 = gVar.m;
            size2 = gVar.o != null ? gVar.o.size() : 0;
        }
        return i2 == i4 && i3 == i5 && j.a(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && fVar == fVar2 && size == size2;
    }

    public final void a(String str) {
        StringBuilder b2 = e.a.a.a.a.b(str, " this: ");
        b2.append(this.f7865a);
        Log.v("Request", b2.toString());
    }
}
