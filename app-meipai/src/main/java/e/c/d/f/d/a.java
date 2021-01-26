package e.c.d.f.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.UploadInfoDao;
import i.b.b.b;

/* compiled from: DaoMaster */
public class a extends b {

    /* renamed from: e.c.d.f.d.a$a reason: collision with other inner class name */
    /* compiled from: DaoMaster */
    public static abstract class C0066a extends i.b.b.g.b {
        public C0066a(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 2);
        }
    }

    public a(i.b.b.g.a aVar) {
        super(aVar, 2);
        Class<UploadInfoDao> cls = UploadInfoDao.class;
        this.f9795b.put(cls, new i.b.b.i.a(this.f9794a, cls));
        Class<LocalTaskDao> cls2 = LocalTaskDao.class;
        this.f9795b.put(cls2, new i.b.b.i.a(this.f9794a, cls2));
        Class<PanoTaskDao> cls3 = PanoTaskDao.class;
        this.f9795b.put(cls3, new i.b.b.i.a(this.f9794a, cls3));
    }
}
