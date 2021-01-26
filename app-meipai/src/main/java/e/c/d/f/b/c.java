package e.c.d.f.b;

import com.baidu.picapture.db.tables.UploadInfoDao;
import e.c.d.f.a;

/* compiled from: UploadDaoService */
public class c {

    /* renamed from: b reason: collision with root package name */
    public static volatile c f6064b;

    /* renamed from: a reason: collision with root package name */
    public UploadInfoDao f6065a;

    public static c b() {
        if (f6064b == null) {
            synchronized (c.class) {
                if (f6064b == null) {
                    f6064b = new c();
                }
            }
        }
        return f6064b;
    }

    public final UploadInfoDao a() {
        if (this.f6065a == null) {
            this.f6065a = a.c().a().f6069e;
        }
        return this.f6065a;
    }
}
