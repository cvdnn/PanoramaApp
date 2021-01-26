package e.i.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.liulishuo.okdownload.OkDownloadProvider;
import e.i.a.h.c;
import e.i.a.h.d.g;
import e.i.a.h.g.b;
import e.i.a.h.j.a.C0126a;

/* compiled from: OkDownload */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: j reason: collision with root package name */
    public static volatile e f8663j;

    /* renamed from: a reason: collision with root package name */
    public final b f8664a;

    /* renamed from: b reason: collision with root package name */
    public final e.i.a.h.g.a f8665b;

    /* renamed from: c reason: collision with root package name */
    public final g f8666c;

    /* renamed from: d reason: collision with root package name */
    public final e.i.a.h.f.a.b f8667d;

    /* renamed from: e reason: collision with root package name */
    public final C0126a f8668e;

    /* renamed from: f reason: collision with root package name */
    public final e.i.a.h.j.g f8669f;

    /* renamed from: g reason: collision with root package name */
    public final e.i.a.h.h.g f8670g;

    /* renamed from: h reason: collision with root package name */
    public final Context f8671h;

    /* renamed from: i reason: collision with root package name */
    public b f8672i;

    /* compiled from: OkDownload */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public b f8673a;

        /* renamed from: b reason: collision with root package name */
        public e.i.a.h.g.a f8674b;

        /* renamed from: c reason: collision with root package name */
        public g f8675c;

        /* renamed from: d reason: collision with root package name */
        public e.i.a.h.f.a.b f8676d;

        /* renamed from: e reason: collision with root package name */
        public e.i.a.h.j.g f8677e;

        /* renamed from: f reason: collision with root package name */
        public e.i.a.h.h.g f8678f;

        /* renamed from: g reason: collision with root package name */
        public C0126a f8679g;

        /* renamed from: h reason: collision with root package name */
        public final Context f8680h;

        public a(Context context) {
            this.f8680h = context.getApplicationContext();
        }

        public e a() {
            if (this.f8673a == null) {
                this.f8673a = new b();
            }
            if (this.f8674b == null) {
                this.f8674b = new e.i.a.h.g.a();
            }
            if (this.f8675c == null) {
                this.f8675c = c.a(this.f8680h);
            }
            if (this.f8676d == null) {
                this.f8676d = c.a();
            }
            if (this.f8679g == null) {
                this.f8679g = new e.i.a.h.j.b.a();
            }
            if (this.f8677e == null) {
                this.f8677e = new e.i.a.h.j.g();
            }
            if (this.f8678f == null) {
                this.f8678f = new e.i.a.h.h.g();
            }
            e eVar = new e(this.f8680h, this.f8673a, this.f8674b, this.f8675c, this.f8676d, this.f8679g, this.f8677e, this.f8678f);
            eVar.f8672i = null;
            StringBuilder a2 = e.a.a.a.a.a("downloadStore[");
            a2.append(this.f8675c);
            a2.append("] connectionFactory[");
            a2.append(this.f8676d);
            a2.toString();
            return eVar;
        }
    }

    public e(Context context, b bVar, e.i.a.h.g.a aVar, g gVar, e.i.a.h.f.a.b bVar2, C0126a aVar2, e.i.a.h.j.g gVar2, e.i.a.h.h.g gVar3) {
        this.f8671h = context;
        this.f8664a = bVar;
        this.f8665b = aVar;
        this.f8666c = gVar;
        this.f8667d = bVar2;
        this.f8668e = aVar2;
        this.f8669f = gVar2;
        this.f8670g = gVar3;
        bVar.f8799i = c.a(gVar);
    }

    public static e a() {
        if (f8663j == null) {
            synchronized (e.class) {
                if (f8663j == null) {
                    if (OkDownloadProvider.f3542a != null) {
                        f8663j = new a(OkDownloadProvider.f3542a).a();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return f8663j;
    }
}
