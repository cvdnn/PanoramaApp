package e.i.a.h.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import e.i.a.h.i.h;
import java.io.IOException;

/* compiled from: BreakpointSQLiteHelper */
public class e extends SQLiteOpenHelper {
    public e(Context context) {
        super(context, "okdownload-breakpoint.db", null, 3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[Catch:{ all -> 0x004c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            android.database.sqlite.SQLiteDatabase r0 = r7.getWritableDatabase()
            android.content.ContentValues r1 = new android.content.ContentValues
            r2 = 2
            r1.<init>(r2)
            java.lang.String r2 = "url"
            r1.put(r2, r8)
            java.lang.String r2 = "filename"
            r1.put(r2, r9)
            java.lang.String r2 = r8.intern()
            monitor-enter(r2)
            r3 = 0
            java.lang.String r4 = "SELECT filename FROM okdownloadResponseFilename WHERE url = ?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x004f }
            r6 = 0
            r5[r6] = r8     // Catch:{ all -> 0x004f }
            android.database.Cursor r8 = r0.rawQuery(r4, r5)     // Catch:{ all -> 0x004f }
            boolean r4 = r8.moveToFirst()     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x0042
            java.lang.String r4 = "filename"
            int r4 = r8.getColumnIndex(r4)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r8.getString(r4)     // Catch:{ all -> 0x004c }
            boolean r9 = r9.equals(r4)     // Catch:{ all -> 0x004c }
            if (r9 != 0) goto L_0x0047
            java.lang.String r9 = "okdownloadResponseFilename"
            r0.replace(r9, r3, r1)     // Catch:{ all -> 0x004c }
            goto L_0x0047
        L_0x0042:
            java.lang.String r9 = "okdownloadResponseFilename"
            r0.insert(r9, r3, r1)     // Catch:{ all -> 0x004c }
        L_0x0047:
            r8.close()     // Catch:{ all -> 0x0056 }
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            return
        L_0x004c:
            r9 = move-exception
            r3 = r8
            goto L_0x0050
        L_0x004f:
            r9 = move-exception
        L_0x0050:
            if (r3 == 0) goto L_0x0055
            r3.close()     // Catch:{ all -> 0x0056 }
        L_0x0055:
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.d.e.a(java.lang.String, java.lang.String):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1 && i3 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i2 <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    public void a(c cVar) throws IOException {
        int b2 = cVar.b();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        int i2 = 0;
        while (true) {
            String str = " failed!";
            if (i2 < b2) {
                a a2 = cVar.a(i2);
                int i3 = cVar.f8702a;
                ContentValues contentValues = new ContentValues();
                contentValues.put("breakpoint_id", Integer.valueOf(i3));
                contentValues.put("block_index", Integer.valueOf(i2));
                contentValues.put("start_offset", Long.valueOf(a2.f8695a));
                contentValues.put("content_length", Long.valueOf(a2.f8696b));
                contentValues.put("current_offset", Long.valueOf(a2.a()));
                if (writableDatabase.insert("block", null, contentValues) != -1) {
                    i2++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert block ");
                    sb.append(a2);
                    sb.append(str);
                    throw new h(sb.toString());
                }
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("id", Integer.valueOf(cVar.f8702a));
                contentValues2.put("url", cVar.f8703b);
                contentValues2.put("etag", cVar.f8704c);
                contentValues2.put("parent_path", cVar.f8705d.getAbsolutePath());
                contentValues2.put("filename", cVar.f8707f.f8854a);
                contentValues2.put("task_only_parent_path", Integer.valueOf(cVar.f8709h ? 1 : 0));
                contentValues2.put("chunked", Integer.valueOf(cVar.f8710i ? 1 : 0));
                if (writableDatabase.insert("breakpoint", null, contentValues2) == -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert info ");
                    sb2.append(cVar);
                    sb2.append(str);
                    throw new h(sb2.toString());
                }
                return;
            }
        }
    }

    public void a(int i2) {
        getWritableDatabase().delete("breakpoint", "id = ?", new String[]{String.valueOf(i2)});
        getWritableDatabase().delete("block", "breakpoint_id = ?", new String[]{String.valueOf(i2)});
    }
}
