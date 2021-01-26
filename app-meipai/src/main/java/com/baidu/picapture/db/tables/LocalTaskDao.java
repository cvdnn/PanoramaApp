package com.baidu.picapture.db.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import e.c.d.f.d.b;
import e.c.d.f.d.c;
import i.b.b.a;
import i.b.b.f;
import i.b.b.g.d;
import java.util.Date;

public class LocalTaskDao extends a<c, String> {
    public static final String TABLENAME = "LOCAL_TASK";

    public static class Properties {
        public static final f CreateTime;
        public static final f PackageId;
        public static final f PhotoCount;
        public static final f Status;
        public static final f TaskId;
        public static final f TaskName;
        public static final f Uid;
        public static final f UploadId;
        public static final f ZipMD5;

        static {
            f fVar = new f(0, String.class, "taskId", true, "task_id");
            TaskId = fVar;
            f fVar2 = new f(1, String.class, "packageId", false, "package_id");
            PackageId = fVar2;
            f fVar3 = new f(2, String.class, "uploadId", false, "upload_id");
            UploadId = fVar3;
            f fVar4 = new f(3, String.class, "uid", false, "uid");
            Uid = fVar4;
            f fVar5 = new f(4, String.class, "taskName", false, "task_name");
            TaskName = fVar5;
            f fVar6 = new f(5, Integer.TYPE, "status", false, "status");
            Status = fVar6;
            f fVar7 = new f(6, Date.class, "createTime", false, "create_time");
            CreateTime = fVar7;
            f fVar8 = new f(7, Integer.TYPE, "photoCount", false, "photo_count");
            PhotoCount = fVar8;
            f fVar9 = new f(8, String.class, "zipMD5", false, "zip_md5");
            ZipMD5 = fVar9;
        }
    }

    public LocalTaskDao(i.b.b.i.a aVar, b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(i.b.b.g.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"LOCAL_TASK\" (\"task_id\" TEXT PRIMARY KEY NOT NULL ,\"package_id\" TEXT,\"upload_id\" TEXT,\"uid\" TEXT,\"task_name\" TEXT,\"status\" INTEGER NOT NULL ,\"create_time\" INTEGER,\"photo_count\" INTEGER NOT NULL ,\"zip_md5\" TEXT);");
        aVar.a(sb.toString());
    }

    public static void dropTable(i.b.b.g.a aVar, boolean z) {
        StringBuilder a2 = e.a.a.a.a.a("DROP TABLE ");
        a2.append(z ? "IF EXISTS " : "");
        a2.append("\"LOCAL_TASK\"");
        aVar.a(a2.toString());
    }

    public void a(SQLiteStatement sQLiteStatement, Object obj) {
        c cVar = (c) obj;
        sQLiteStatement.clearBindings();
        String str = cVar.f6072a;
        if (str != null) {
            sQLiteStatement.bindString(1, str);
        }
        String str2 = cVar.f6073b;
        if (str2 != null) {
            sQLiteStatement.bindString(2, str2);
        }
        String str3 = cVar.f6074c;
        if (str3 != null) {
            sQLiteStatement.bindString(3, str3);
        }
        String str4 = cVar.f6075d;
        if (str4 != null) {
            sQLiteStatement.bindString(4, str4);
        }
        String str5 = cVar.f6076e;
        if (str5 != null) {
            sQLiteStatement.bindString(5, str5);
        }
        sQLiteStatement.bindLong(6, (long) cVar.f6077f);
        Date date = cVar.f6078g;
        if (date != null) {
            sQLiteStatement.bindLong(7, date.getTime());
        }
        sQLiteStatement.bindLong(8, (long) cVar.f6079h);
        String str6 = cVar.f6080i;
        if (str6 != null) {
            sQLiteStatement.bindString(9, str6);
        }
    }

    public Object b(Object obj) {
        c cVar = (c) obj;
        if (cVar != null) {
            return cVar.f6072a;
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
        c cVar = (c) obj;
        dVar.f9804a.clearBindings();
        String str = cVar.f6072a;
        if (str != null) {
            dVar.f9804a.bindString(1, str);
        }
        String str2 = cVar.f6073b;
        if (str2 != null) {
            dVar.f9804a.bindString(2, str2);
        }
        String str3 = cVar.f6074c;
        if (str3 != null) {
            dVar.f9804a.bindString(3, str3);
        }
        String str4 = cVar.f6075d;
        if (str4 != null) {
            dVar.f9804a.bindString(4, str4);
        }
        String str5 = cVar.f6076e;
        if (str5 != null) {
            dVar.f9804a.bindString(5, str5);
        }
        dVar.f9804a.bindLong(6, (long) cVar.f6077f);
        Date date = cVar.f6078g;
        if (date != null) {
            dVar.f9804a.bindLong(7, date.getTime());
        }
        dVar.f9804a.bindLong(8, (long) cVar.f6079h);
        String str6 = cVar.f6080i;
        if (str6 != null) {
            dVar.f9804a.bindString(9, str6);
        }
    }

    public Object a(Object obj, long j2) {
        return ((c) obj).f6072a;
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
        int i7 = i2 + 4;
        String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = cursor.getInt(i2 + 5);
        int i9 = i2 + 6;
        Date date = cursor.isNull(i9) ? null : new Date(cursor.getLong(i9));
        int i10 = cursor.getInt(i2 + 7);
        int i11 = i2 + 8;
        c cVar = new c(string, string2, string3, string4, string5, i8, date, i10, cursor.isNull(i11) ? null : cursor.getString(i11));
        return cVar;
    }
}
