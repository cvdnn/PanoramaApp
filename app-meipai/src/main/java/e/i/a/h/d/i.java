package e.i.a.h.d;

import com.liulishuo.okdownload.core.breakpoint.BreakpointStoreOnSQLite;
import e.i.a.c;
import e.i.a.h.d.j.a;
import java.io.IOException;

/* compiled from: RemitStoreOnSQLite */
public class i implements a, g {

    /* renamed from: a reason: collision with root package name */
    public final k f8726a = new k(this);

    /* renamed from: b reason: collision with root package name */
    public final BreakpointStoreOnSQLite f8727b;

    /* renamed from: c reason: collision with root package name */
    public final e f8728c;

    /* renamed from: d reason: collision with root package name */
    public final g f8729d;

    public i(BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        this.f8727b = breakpointStoreOnSQLite;
        this.f8729d = breakpointStoreOnSQLite.f3544b;
        this.f8728c = breakpointStoreOnSQLite.f3543a;
    }

    public c a(c cVar) throws IOException {
        if (this.f8726a.b(cVar.f8649b)) {
            return this.f8729d.a(cVar);
        }
        BreakpointStoreOnSQLite breakpointStoreOnSQLite = this.f8727b;
        c a2 = breakpointStoreOnSQLite.f3544b.a(cVar);
        breakpointStoreOnSQLite.f3543a.a(a2);
        return a2;
    }

    public boolean a() {
        return false;
    }

    public int b(c cVar) {
        return this.f8727b.f3544b.b(cVar);
    }

    public c b(int i2) {
        return null;
    }

    public boolean c(int i2) {
        return this.f8727b.f3544b.f8723f.contains(Integer.valueOf(i2));
    }

    public void d(int i2) {
        if (this.f8727b.f3544b != null) {
            k kVar = this.f8726a;
            kVar.f8733a.f8730a.removeMessages(i2);
            j jVar = kVar.f8733a;
            jVar.f8730a.sendEmptyMessageDelayed(i2, kVar.f8734b);
            return;
        }
        throw null;
    }

    public boolean e(int i2) {
        return this.f8727b.e(i2);
    }

    public void f(int i2) throws IOException {
        this.f8728c.a(i2);
        c cVar = this.f8729d.get(i2);
        if (cVar != null && cVar.f8707f.f8854a != null && cVar.e() > 0) {
            this.f8728c.a(cVar);
        }
    }

    public c get(int i2) {
        return (c) this.f8727b.f3544b.f8718a.get(i2);
    }

    public void remove(int i2) {
        this.f8729d.remove(i2);
        this.f8726a.a(i2);
    }

    public void a(c cVar, int i2, long j2) throws IOException {
        if (this.f8726a.b(cVar.f8702a)) {
            this.f8729d.a(cVar, i2, j2);
        } else {
            this.f8727b.a(cVar, i2, j2);
        }
    }

    public boolean a(c cVar) throws IOException {
        if (this.f8726a.b(cVar.f8702a)) {
            return this.f8729d.a(cVar);
        }
        return this.f8727b.a(cVar);
    }

    public void a(int i2, e.i.a.h.e.a aVar, Exception exc) {
        this.f8729d.a(i2, aVar, exc);
        if (aVar == e.i.a.h.e.a.COMPLETED) {
            this.f8726a.a(i2);
            return;
        }
        k kVar = this.f8726a;
        kVar.f8733a.f8730a.removeMessages(i2);
        try {
            if (!kVar.f8733a.f8731b.contains(Integer.valueOf(i2))) {
                kVar.f8733a.f8730a.sendEmptyMessage(i2);
            }
        } finally {
            kVar.f8733a.a(i2);
        }
    }

    public boolean a(int i2) {
        return this.f8727b.a(i2);
    }

    public c a(c cVar, c cVar2) {
        return this.f8727b.f3544b.a(cVar, cVar2);
    }

    public String a(String str) {
        return (String) this.f8727b.f3544b.f8719b.get(str);
    }
}
