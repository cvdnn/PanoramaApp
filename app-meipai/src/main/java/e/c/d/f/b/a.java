package e.c.d.f.b;

import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao.Properties;
import e.c.d.f.d.d;
import i.b.b.j.f;
import i.b.b.j.h;
import java.util.List;

/* compiled from: PanoTaskDaoService */
public class a {

    /* renamed from: b reason: collision with root package name */
    public static volatile a f6060b;

    /* renamed from: a reason: collision with root package name */
    public PanoTaskDao f6061a;

    public static a c() {
        if (f6060b == null) {
            synchronized (a.class) {
                if (f6060b == null) {
                    f6060b = new a();
                }
            }
        }
        return f6060b;
    }

    public final PanoTaskDao a() {
        if (this.f6061a == null) {
            this.f6061a = e.c.d.f.a.c().a().f6071g;
        }
        return this.f6061a;
    }

    public List<d> b() {
        PanoTaskDao a2 = a();
        if (a2 != null) {
            f fVar = new f(a2);
            fVar.a(" DESC", Properties.CreateTime);
            fVar.a(Properties.Status.b(Integer.valueOf(1000)), new h[0]);
            return fVar.a();
        }
        throw null;
    }
}
