package com.baidu.picapture.db.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.baidubce.services.bos.model.PartETag;
import e.c.d.f.d.b;
import e.c.d.f.d.e;
import e.c.d.f.d.f;
import e.c.d.f.d.g;
import i.b.b.a;
import i.b.b.g.d;
import java.util.Date;
import java.util.List;

public class UploadInfoDao extends a<g, String> {
    public static final String TABLENAME = "UPLOAD_INFO";

    /* renamed from: h reason: collision with root package name */
    public final f f1957h = new f();

    public static class Properties {
        public static final i.b.b.f BosId;
        public static final i.b.b.f CreateTime;
        public static final i.b.b.f FilePath;
        public static final i.b.b.f Md5;
        public static final i.b.b.f PartTags;
        public static final i.b.b.f Status;
        public static final i.b.b.f UploadId;

        static {
            i.b.b.f fVar = new i.b.b.f(0, String.class, "uploadId", true, "upload_id");
            UploadId = fVar;
            i.b.b.f fVar2 = new i.b.b.f(1, String.class, "bosId", false, "bos_id");
            BosId = fVar2;
            i.b.b.f fVar3 = new i.b.b.f(2, String.class, "filePath", false, "file_path");
            FilePath = fVar3;
            i.b.b.f fVar4 = new i.b.b.f(3, String.class, "md5", false, "MD5");
            Md5 = fVar4;
            i.b.b.f fVar5 = new i.b.b.f(4, String.class, "partTags", false, "part_tags");
            PartTags = fVar5;
            i.b.b.f fVar6 = new i.b.b.f(5, Integer.TYPE, "status", false, "STATUS");
            Status = fVar6;
            i.b.b.f fVar7 = new i.b.b.f(6, Date.class, "createTime", false, "create_time");
            CreateTime = fVar7;
        }
    }

    public UploadInfoDao(i.b.b.i.a aVar, b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(i.b.b.g.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"UPLOAD_INFO\" (\"upload_id\" TEXT PRIMARY KEY NOT NULL ,\"bos_id\" TEXT,\"file_path\" TEXT,\"MD5\" TEXT,\"part_tags\" TEXT,\"STATUS\" INTEGER NOT NULL ,\"create_time\" INTEGER);");
        aVar.a(sb.toString());
    }

    public static void dropTable(i.b.b.g.a aVar, boolean z) {
        StringBuilder a2 = e.a.a.a.a.a("DROP TABLE ");
        a2.append(z ? "IF EXISTS " : "");
        a2.append("\"UPLOAD_INFO\"");
        aVar.a(a2.toString());
    }

    public void a(SQLiteStatement sQLiteStatement, Object obj) {
        g gVar = (g) obj;
        sQLiteStatement.clearBindings();
        String str = gVar.f6089a;
        if (str != null) {
            sQLiteStatement.bindString(1, str);
        }
        String str2 = gVar.f6090b;
        if (str2 != null) {
            sQLiteStatement.bindString(2, str2);
        }
        String str3 = gVar.f6091c;
        if (str3 != null) {
            sQLiteStatement.bindString(3, str3);
        }
        String str4 = gVar.f6092d;
        if (str4 != null) {
            sQLiteStatement.bindString(4, str4);
        }
        List<PartETag> list = gVar.f6093e;
        if (list != null) {
            sQLiteStatement.bindString(5, this.f1957h.f6088a.a((Object) list));
        }
        sQLiteStatement.bindLong(6, (long) gVar.f6094f);
        Date date = gVar.f6095g;
        if (date != null) {
            sQLiteStatement.bindLong(7, date.getTime());
        }
    }

    public Object b(Object obj) {
        g gVar = (g) obj;
        if (gVar != null) {
            return gVar.f6089a;
        }
        return null;
    }

    public Object b(Cursor cursor, int i2) {
        int i3 = i2 + 0;
        if (cursor.isNull(i3)) {
            return null;
        }
        return cursor.getString(i3);
    }

    public void a(d dVar, Object obj) {
        g gVar = (g) obj;
        dVar.f9804a.clearBindings();
        String str = gVar.f6089a;
        if (str != null) {
            dVar.f9804a.bindString(1, str);
        }
        String str2 = gVar.f6090b;
        if (str2 != null) {
            dVar.f9804a.bindString(2, str2);
        }
        String str3 = gVar.f6091c;
        if (str3 != null) {
            dVar.f9804a.bindString(3, str3);
        }
        String str4 = gVar.f6092d;
        if (str4 != null) {
            dVar.f9804a.bindString(4, str4);
        }
        List<PartETag> list = gVar.f6093e;
        if (list != null) {
            dVar.f9804a.bindString(5, this.f1957h.f6088a.a((Object) list));
        }
        dVar.f9804a.bindLong(6, (long) gVar.f6094f);
        Date date = gVar.f6095g;
        if (date != null) {
            dVar.f9804a.bindLong(7, date.getTime());
        }
    }

    public Object a(Object obj, long j2) {
        return ((g) obj).f6089a;
    }

    public Object a(Cursor cursor, int i2) {
        List list;
        int i3 = i2 + 0;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i2 + 1;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i2 + 2;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i2 + 3;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i2 + 4;
        if (cursor.isNull(i7)) {
            list = null;
        } else {
            f fVar = this.f1957h;
            String string5 = cursor.getString(i7);
            if (fVar != null) {
                list = (List) fVar.f6088a.a(string5, new e(fVar).getType());
            } else {
                throw null;
            }
        }
        int i8 = cursor.getInt(i2 + 5);
        int i9 = i2 + 6;
        g gVar = new g(string, string2, string3, string4, list, i8, cursor.isNull(i9) ? null : new Date(cursor.getLong(i9)));
        return gVar;
    }
}
