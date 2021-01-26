package e.c.d.f.d;

import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.UploadInfoDao;
import i.b.b.c;
import i.b.b.h.d;
import i.b.b.i.a;
import java.util.Map;

/* compiled from: DaoSession */
public class b extends c {

    /* renamed from: b reason: collision with root package name */
    public final a f6066b;

    /* renamed from: c reason: collision with root package name */
    public final a f6067c;

    /* renamed from: d reason: collision with root package name */
    public final a f6068d;

    /* renamed from: e reason: collision with root package name */
    public final UploadInfoDao f6069e;

    /* renamed from: f reason: collision with root package name */
    public final LocalTaskDao f6070f;

    /* renamed from: g reason: collision with root package name */
    public final PanoTaskDao f6071g;

    public b(i.b.b.g.a aVar, d dVar, Map<Class<? extends i.b.b.a<?, ?>>, a> map) {
        super(aVar);
        a aVar2 = (a) map.get(UploadInfoDao.class);
        if (aVar2 != null) {
            a aVar3 = new a(aVar2);
            this.f6066b = aVar3;
            aVar3.a(dVar);
            a aVar4 = (a) map.get(LocalTaskDao.class);
            if (aVar4 != null) {
                a aVar5 = new a(aVar4);
                this.f6067c = aVar5;
                aVar5.a(dVar);
                a aVar6 = (a) map.get(PanoTaskDao.class);
                if (aVar6 != null) {
                    a aVar7 = new a(aVar6);
                    this.f6068d = aVar7;
                    aVar7.a(dVar);
                    this.f6069e = new UploadInfoDao(this.f6066b, this);
                    this.f6070f = new LocalTaskDao(this.f6067c, this);
                    this.f6071g = new PanoTaskDao(this.f6068d, this);
                    UploadInfoDao uploadInfoDao = this.f6069e;
                    this.f9796a.put(g.class, uploadInfoDao);
                    LocalTaskDao localTaskDao = this.f6070f;
                    this.f9796a.put(c.class, localTaskDao);
                    PanoTaskDao panoTaskDao = this.f6071g;
                    this.f9796a.put(d.class, panoTaskDao);
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }
}
