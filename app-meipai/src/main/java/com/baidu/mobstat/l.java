package com.baidu.mobstat;

import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Environment;
import e.a.a.a.a;
import java.io.File;
import java.io.IOException;

public class l extends ContextWrapper {
    public l() {
        super(null);
    }

    public File getDatabasePath(String str) {
        File file = null;
        if (!"mounted".equals(bo.a())) {
            return null;
        }
        String a2 = a.a(a.a(Environment.getExternalStorageDirectory().getAbsolutePath()), File.separator, "backups/system");
        File file2 = new File(a2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(a.a(a.a(a2), File.separator, str));
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (IOException e2) {
                bb.c().b((Throwable) e2);
            }
        }
        if (file3.exists()) {
            file = file3;
        }
        return file;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i2, CursorFactory cursorFactory) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i2, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }
}
