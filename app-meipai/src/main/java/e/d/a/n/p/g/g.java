package e.d.a.n.p.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import e.c.f.n.n;
import e.d.a.i;
import e.d.a.j;
import e.d.a.n.f;
import e.d.a.n.l;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.k;
import e.d.a.r.e;
import e.d.a.r.h.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader */
public class g {

    /* renamed from: a reason: collision with root package name */
    public final e.d.a.m.a f7770a;

    /* renamed from: b reason: collision with root package name */
    public final Handler f7771b;

    /* renamed from: c reason: collision with root package name */
    public final List<b> f7772c;

    /* renamed from: d reason: collision with root package name */
    public final j f7773d;

    /* renamed from: e reason: collision with root package name */
    public final d f7774e;

    /* renamed from: f reason: collision with root package name */
    public boolean f7775f;

    /* renamed from: g reason: collision with root package name */
    public boolean f7776g;

    /* renamed from: h reason: collision with root package name */
    public boolean f7777h;

    /* renamed from: i reason: collision with root package name */
    public i<Bitmap> f7778i;

    /* renamed from: j reason: collision with root package name */
    public a f7779j;
    public boolean k;
    public a l;
    public Bitmap m;
    public a n;
    public int o;
    public int p;
    public int q;

    /* compiled from: GifFrameLoader */
    public static class a extends e.d.a.r.h.c<Bitmap> {

        /* renamed from: d reason: collision with root package name */
        public final Handler f7780d;

        /* renamed from: e reason: collision with root package name */
        public final int f7781e;

        /* renamed from: f reason: collision with root package name */
        public final long f7782f;

        /* renamed from: g reason: collision with root package name */
        public Bitmap f7783g;

        public a(Handler handler, int i2, long j2) {
            this.f7780d = handler;
            this.f7781e = i2;
            this.f7782f = j2;
        }

        public void a(Object obj, e.d.a.r.i.b bVar) {
            this.f7783g = (Bitmap) obj;
            this.f7780d.sendMessageAtTime(this.f7780d.obtainMessage(1, this), this.f7782f);
        }

        public void c(Drawable drawable) {
            this.f7783g = null;
        }
    }

    /* compiled from: GifFrameLoader */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader */
    public class c implements Callback {
        public c() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (i2 == 2) {
                g.this.f7773d.a((h<?>) (a) message.obj);
            }
            return false;
        }
    }

    public g(e.d.a.b bVar, e.d.a.m.a aVar, int i2, int i3, l<Bitmap> lVar, Bitmap bitmap) {
        d dVar = bVar.f7083a;
        j c2 = e.d.a.b.c(bVar.f7085c.getBaseContext());
        j c3 = e.d.a.b.c(bVar.f7085c.getBaseContext());
        if (c3 != null) {
            i<Bitmap> a2 = new i(c3.f7132a, c3, Bitmap.class, c3.f7133b).a((e.d.a.r.a<?>) j.l).a(((e) ((e) ((e) new e().a(k.f7435a)).b(true)).a(true)).a(i2, i3));
            this.f7772c = new ArrayList();
            this.f7773d = c2;
            Handler handler = new Handler(Looper.getMainLooper(), new c());
            this.f7774e = dVar;
            this.f7771b = handler;
            this.f7778i = a2;
            this.f7770a = aVar;
            a(lVar, bitmap);
            return;
        }
        throw null;
    }

    public void a(l<Bitmap> lVar, Bitmap bitmap) {
        String str = "Argument must not be null";
        n.a(lVar, str);
        n.a(bitmap, str);
        this.m = bitmap;
        this.f7778i = this.f7778i.a(new e().a(lVar, true));
        this.o = e.d.a.t.j.a(bitmap);
        this.p = bitmap.getWidth();
        this.q = bitmap.getHeight();
    }

    public final void a() {
        if (this.f7775f && !this.f7776g) {
            if (this.f7777h) {
                n.a(this.n == null, "Pending target must be null when starting from the first frame");
                this.f7770a.e();
                this.f7777h = false;
            }
            a aVar = this.n;
            if (aVar != null) {
                this.n = null;
                a(aVar);
                return;
            }
            this.f7776g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f7770a.c());
            this.f7770a.b();
            this.l = new a(this.f7771b, this.f7770a.f(), uptimeMillis);
            i a2 = this.f7778i.a((e.d.a.r.a<?>) (e) new e().a((f) new e.d.a.s.b(Double.valueOf(Math.random()))));
            a2.F = this.f7770a;
            a2.I = true;
            a2.a(this.l, null, a2, e.d.a.t.e.f7910a);
        }
    }

    public void a(a aVar) {
        this.f7776g = false;
        if (this.k) {
            this.f7771b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f7775f) {
            this.n = aVar;
        } else {
            if (aVar.f7783g != null) {
                Bitmap bitmap = this.m;
                if (bitmap != null) {
                    this.f7774e.a(bitmap);
                    this.m = null;
                }
                a aVar2 = this.f7779j;
                this.f7779j = aVar;
                int size = this.f7772c.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    ((b) this.f7772c.get(size)).a();
                }
                if (aVar2 != null) {
                    this.f7771b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            a();
        }
    }
}
