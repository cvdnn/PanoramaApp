package e.i.a.h.h;

import e.i.a.c;
import e.i.a.e;
import e.i.a.h.d.g;
import e.i.a.h.f.a.C0121a;
import e.i.a.h.k.d;
import e.i.a.h.k.f.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DownloadChain */
public class f implements Runnable {
    public static final ExecutorService q;

    /* renamed from: a reason: collision with root package name */
    public final int f8840a;

    /* renamed from: b reason: collision with root package name */
    public final c f8841b;

    /* renamed from: c reason: collision with root package name */
    public final e.i.a.h.d.c f8842c;

    /* renamed from: d reason: collision with root package name */
    public final d f8843d;

    /* renamed from: e reason: collision with root package name */
    public final List<e.i.a.h.k.c> f8844e = new ArrayList();

    /* renamed from: f reason: collision with root package name */
    public final List<d> f8845f = new ArrayList();

    /* renamed from: g reason: collision with root package name */
    public int f8846g = 0;

    /* renamed from: h reason: collision with root package name */
    public int f8847h = 0;

    /* renamed from: i reason: collision with root package name */
    public long f8848i;

    /* renamed from: j reason: collision with root package name */
    public volatile e.i.a.h.f.a f8849j;
    public long k;
    public volatile Thread l;
    public final e.i.a.h.g.a m;
    public final g n;
    public final AtomicBoolean o = new AtomicBoolean(false);
    public final Runnable p = new a();

    /* compiled from: DownloadChain */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f.this.f();
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.i.a.h.c.a("OkDownload Cancel Block", false));
        q = threadPoolExecutor;
    }

    public f(int i2, c cVar, e.i.a.h.d.c cVar2, d dVar, g gVar) {
        this.f8840a = i2;
        this.f8841b = cVar;
        this.f8843d = dVar;
        this.f8842c = cVar2;
        this.n = gVar;
        this.m = e.a().f8665b;
    }

    public void a() {
        long j2 = this.k;
        if (j2 != 0) {
            this.m.f8757a.fetchProgress(this.f8841b, this.f8840a, j2);
            this.k = 0;
        }
    }

    public synchronized e.i.a.h.f.a b() throws IOException {
        if (!this.f8843d.b()) {
            if (this.f8849j == null) {
                String str = this.f8843d.f8822a;
                if (str == null) {
                    str = this.f8842c.f8703b;
                }
                this.f8849j = e.a().f8667d.a(str);
            }
        } else {
            throw e.i.a.h.i.c.f8856a;
        }
        return this.f8849j;
    }

    public e.i.a.h.j.f c() {
        return this.f8843d.a();
    }

    public C0121a d() throws IOException {
        if (!this.f8843d.b()) {
            List<e.i.a.h.k.c> list = this.f8844e;
            int i2 = this.f8846g;
            this.f8846g = i2 + 1;
            return ((e.i.a.h.k.c) list.get(i2)).b(this);
        }
        throw e.i.a.h.i.c.f8856a;
    }

    public long e() throws IOException {
        if (!this.f8843d.b()) {
            List<d> list = this.f8845f;
            int i2 = this.f8847h;
            this.f8847h = i2 + 1;
            return ((d) list.get(i2)).a(this);
        }
        throw e.i.a.h.i.c.f8856a;
    }

    public synchronized void f() {
        if (this.f8849j != null) {
            this.f8849j.release();
            StringBuilder sb = new StringBuilder();
            sb.append("release connection ");
            sb.append(this.f8849j);
            sb.append(" task[");
            sb.append(this.f8841b.f8649b);
            sb.append("] block[");
            sb.append(this.f8840a);
            sb.append("]");
            sb.toString();
        }
        this.f8849j = null;
    }

    public void g() {
        q.execute(this.p);
    }

    public void h() throws IOException {
        e.i.a.h.g.a aVar = e.a().f8665b;
        e.i.a.h.k.e eVar = new e.i.a.h.k.e();
        e.i.a.h.k.a aVar2 = new e.i.a.h.k.a();
        this.f8844e.add(eVar);
        this.f8844e.add(aVar2);
        this.f8844e.add(new b());
        this.f8844e.add(new e.i.a.h.k.f.a());
        this.f8846g = 0;
        C0121a d2 = d();
        if (!this.f8843d.b()) {
            aVar.f8757a.fetchStart(this.f8841b, this.f8840a, this.f8848i);
            e.i.a.h.k.b bVar = new e.i.a.h.k.b(this.f8840a, d2.b(), c(), this.f8841b);
            this.f8845f.add(eVar);
            this.f8845f.add(aVar2);
            this.f8845f.add(bVar);
            this.f8847h = 0;
            aVar.f8757a.fetchEnd(this.f8841b, this.f8840a, e());
            return;
        }
        throw e.i.a.h.i.c.f8856a;
    }

    public void run() {
        if (!this.o.get()) {
            this.l = Thread.currentThread();
            try {
                h();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.o.set(true);
                g();
                throw th;
            }
            this.o.set(true);
            g();
            return;
        }
        throw new IllegalAccessError("The chain has been finished!");
    }
}
