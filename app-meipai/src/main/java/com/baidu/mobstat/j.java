package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;

public abstract class j implements Closeable {

    /* renamed from: a reason: collision with root package name */
    public m f1880a;

    public j(String str, String str2) {
        l lVar = new l();
        this.f1880a = new m(lVar, str);
        File databasePath = lVar.getDatabasePath(".confd");
        if (databasePath != null && databasePath.canWrite()) {
            a(str2);
        }
    }

    private void a(String str) {
        this.f1880a.a(str);
    }

    public abstract long a(String str, String str2);

    public abstract ArrayList<i> a(int i2, int i3);

    public int b() {
        return this.f1880a.b();
    }

    public abstract boolean b(long j2);

    public synchronized void close() {
        try {
            this.f1880a.close();
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
        }
        return;
    }

    public synchronized boolean a() {
        try {
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            return false;
        }
        return this.f1880a.a();
    }

    public Cursor a(String str, int i2, int i3) {
        m mVar = this.f1880a;
        String a2 = a.a(str, " desc");
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append(", ");
        sb.append(i2);
        return mVar.a(null, null, null, null, null, a2, sb.toString());
    }

    public Cursor a(String str, String str2, String str3, int i2) {
        String a2 = a.a(str, "=? ");
        String[] strArr = {str2};
        m mVar = this.f1880a;
        String a3 = a.a(str3, " desc");
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("");
        return mVar.a(null, a2, strArr, null, null, a3, sb.toString());
    }

    public long a(ContentValues contentValues) {
        return this.f1880a.a((String) null, contentValues);
    }

    public boolean a(long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j2);
        sb.append("");
        if (this.f1880a.a("_id=? ", new String[]{sb.toString()}) > 0) {
            return true;
        }
        return false;
    }
}
