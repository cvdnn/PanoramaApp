package i.b.a;

import java.util.logging.Level;

/* compiled from: BackgroundPoster */
public final class b implements Runnable, l {

    /* renamed from: a reason: collision with root package name */
    public final k f9721a = new k();

    /* renamed from: b reason: collision with root package name */
    public final c f9722b;

    /* renamed from: c reason: collision with root package name */
    public volatile boolean f9723c;

    public b(c cVar) {
        this.f9722b = cVar;
    }

    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f9721a.a(a2);
            if (!this.f9723c) {
                this.f9723c = true;
                this.f9722b.f9733j.execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                j a2 = this.f9721a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f9721a.a();
                        if (a2 == null) {
                            this.f9723c = false;
                            this.f9723c = false;
                            return;
                        }
                    }
                }
                this.f9722b.a(a2);
            } catch (InterruptedException e2) {
                try {
                    g gVar = this.f9722b.r;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append(Thread.currentThread().getName());
                    sb.append(" was interruppted");
                    gVar.a(level, sb.toString(), e2);
                    return;
                } finally {
                    this.f9723c = false;
                }
            }
        }
    }
}
