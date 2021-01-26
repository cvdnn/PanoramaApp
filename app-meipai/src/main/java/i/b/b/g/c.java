package i.b.b.g;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: StandardDatabase */
public class c implements a {

    /* renamed from: a reason: collision with root package name */
    public final SQLiteDatabase f9803a;

    public c(SQLiteDatabase sQLiteDatabase) {
        this.f9803a = sQLiteDatabase;
    }

    public Cursor a(String str, String[] strArr) {
        return this.f9803a.rawQuery(str, strArr);
    }

    public d b(String str) {
        return new d(this.f9803a.compileStatement(str));
    }

    public void c() {
        this.f9803a.setTransactionSuccessful();
    }

    public boolean d() {
        return this.f9803a.isDbLockedByCurrentThread();
    }

    public void e() {
        this.f9803a.endTransaction();
    }

    public void a(String str) throws SQLException {
        this.f9803a.execSQL(str);
    }

    public Object b() {
        return this.f9803a;
    }

    public void a() {
        this.f9803a.beginTransaction();
    }
}
