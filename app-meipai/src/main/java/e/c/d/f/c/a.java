package e.c.d.f.c;

import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.UploadInfoDao;
import e.f.a.a.a.a.C0105a;

/* compiled from: DBOpenHelper */
public class a implements C0105a {
    public a(b bVar) {
    }

    public void a(i.b.b.g.a aVar, boolean z) {
        UploadInfoDao.createTable(aVar, z);
        LocalTaskDao.createTable(aVar, z);
        PanoTaskDao.createTable(aVar, z);
    }

    public void b(i.b.b.g.a aVar, boolean z) {
        UploadInfoDao.dropTable(aVar, z);
        LocalTaskDao.dropTable(aVar, z);
        PanoTaskDao.dropTable(aVar, z);
    }
}
