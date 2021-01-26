package com.baidu.picapture.db.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import e.c.d.f.d.b;
import e.c.d.f.d.d;
import i.b.b.a;
import i.b.b.f;
import java.util.Date;

public class PanoTaskDao extends a<d, String> {
    public static final String TABLENAME = "PANO_TASK";

    public static class Properties {
        public static final f BosUrl;
        public static final f CreateTime;
        public static final f Status;
        public static final f TaskId;
        public static final f TaskName;
        public static final f Uid;
        public static final f UploadId;

        static {
            f fVar = new f(0, String.class, "taskId", true, "task_id");
            TaskId = fVar;
            f fVar2 = new f(1, String.class, "uploadId", false, "upload_id");
            UploadId = fVar2;
            f fVar3 = new f(2, String.class, "uid", false, "uid");
            Uid = fVar3;
            f fVar4 = new f(3, String.class, "taskName", false, "task_name");
            TaskName = fVar4;
            f fVar5 = new f(4, Integer.TYPE, "status", false, "status");
            Status = fVar5;
            f fVar6 = new f(5, Date.class, "createTime", false, "create_time");
            CreateTime = fVar6;
            f fVar7 = new f(6, String.class, "bosUrl", false, "bos_url");
            BosUrl = fVar7;
        }
    }

    public PanoTaskDao(i.b.b.i.a aVar, b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(i.b.b.g.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"PANO_TASK\" (\"task_id\" TEXT PRIMARY KEY NOT NULL ,\"upload_id\" TEXT,\"uid\" TEXT,\"task_name\" TEXT,\"status\" INTEGER NOT NULL ,\"create_time\" INTEGER,\"bos_url\" TEXT);");
        aVar.a(sb.toString());
    }

    public static void dropTable(i.b.b.g.a aVar, boolean z) {
        StringBuilder a2 = e.a.a.a.a.a("DROP TABLE ");
        a2.append(z ? "IF EXISTS " : "");
        a2.append("\"PANO_TASK\"");
        aVar.a(a2.toString());
    }

    public void a(SQLiteStatement sQLiteStatement, Object obj) {
        d dVar = (d) obj;
        sQLiteStatement.clearBindings();
        String str = dVar.f6081a;
        if (str != null) {
            sQLiteStatement.bindString(1, str);
        }
        String str2 = dVar.f6082b;
        if (str2 != null) {
            sQLiteStatement.bindString(2, str2);
        }
        String str3 = dVar.f6083c;
        if (str3 != null) {
            sQLiteStatement.bindString(3, str3);
        }
        String str4 = dVar.f6084d;
        if (str4 != null) {
            sQLiteStatement.bindString(4, str4);
        }
        sQLiteStatement.bindLong(5, (long) dVar.f6085e);
        Date date = dVar.f6086f;
        if (date != null) {
            sQLiteStatement.bindLong(6, date.getTime());
        }
        String str5 = dVar.f6087g;
        if (str5 != null) {
            sQLiteStatement.bindString(7, str5);
        }
    }

    public Object b(Object obj) {
        d dVar = (d) obj;
        if (dVar != null) {
            return dVar.f6081a;
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

    public void a(i.b.b.g.d dVar, Object obj) {
        d dVar2 = (d) obj;
        dVar.f9804a.clearBindings();
        String str = dVar2.f6081a;
        if (str != null) {
            dVar.f9804a.bindString(1, str);
        }
        String str2 = dVar2.f6082b;
        if (str2 != null) {
            dVar.f9804a.bindString(2, str2);
        }
        String str3 = dVar2.f6083c;
        if (str3 != null) {
            dVar.f9804a.bindString(3, str3);
        }
        String str4 = dVar2.f6084d;
        if (str4 != null) {
            dVar.f9804a.bindString(4, str4);
        }
        dVar.f9804a.bindLong(5, (long) dVar2.f6085e);
        Date date = dVar2.f6086f;
        if (date != null) {
            dVar.f9804a.bindLong(6, date.getTime());
        }
        String str5 = dVar2.f6087g;
        if (str5 != null) {
            dVar.f9804a.bindString(7, str5);
        }
    }

    public Object a(Object obj, long j2) {
        return ((d) obj).f6081a;
    }

    public Object a(Cursor cursor, int i2) {
        int i3 = i2 + 0;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i2 + 1;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i2 + 2;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i2 + 3;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = cursor.getInt(i2 + 4);
        int i8 = i2 + 5;
        int i9 = i2 + 6;
        d dVar = new d(string, string2, string3, string4, i7, cursor.isNull(i8) ? null : new Date(cursor.getLong(i8)), cursor.isNull(i9) ? null : cursor.getString(i9));
        return dVar;
    }
}
