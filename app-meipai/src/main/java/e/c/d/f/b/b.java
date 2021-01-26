package e.c.d.f.b;

import com.baidu.picapture.db.tables.LocalTaskDao;
import e.c.d.f.a;
import e.c.d.f.d.c;

/* compiled from: SpinTaskDaoService */
public class b {

    /* renamed from: b reason: collision with root package name */
    public static volatile b f6062b;

    /* renamed from: a reason: collision with root package name */
    public LocalTaskDao f6063a;

    public static b b() {
        if (f6062b == null) {
            synchronized (b.class) {
                if (f6062b == null) {
                    f6062b = new b();
                }
            }
        }
        return f6062b;
    }

    public final LocalTaskDao a() {
        if (this.f6063a == null) {
            this.f6063a = a.c().a().f6070f;
        }
        return this.f6063a;
    }

    public void a(c cVar) {
        a().d(cVar);
    }
}
