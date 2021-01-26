package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class m extends SQLiteOpenHelper {

    /* renamed from: a reason: collision with root package name */
    public String f1888a;

    /* renamed from: b reason: collision with root package name */
    public SQLiteDatabase f1889b;

    public m(Context context, String str) throws SQLiteException {
        super(context, ".confd", null, 1);
        this.f1888a = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.database.sqlite.SQLiteDatabase r0 = r3.f1889b     // Catch:{ all -> 0x0034 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r2
            goto L_0x0013
        L_0x0009:
            android.database.sqlite.SQLiteDatabase r0 = r3.f1889b     // Catch:{ all -> 0x0034 }
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0007
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x0024
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ NullPointerException -> 0x001c }
            r3.f1889b = r0     // Catch:{ NullPointerException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "db path is null"
            r0.<init>(r1)     // Catch:{ all -> 0x0034 }
            throw r0     // Catch:{ all -> 0x0034 }
        L_0x0024:
            android.database.sqlite.SQLiteDatabase r0 = r3.f1889b     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            android.database.sqlite.SQLiteDatabase r0 = r3.f1889b     // Catch:{ all -> 0x0034 }
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r1 = r2
        L_0x0032:
            monitor-exit(r3)
            return r1
        L_0x0034:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.m.a():boolean");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0, types: [java.lang.String[], android.database.Cursor]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor, java.lang.String[]]
  mth insns count: 23
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b() {
        /*
            r4 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.f1889b     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r2.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "SELECT COUNT(*) FROM "
            r2.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r4.f1888a     // Catch:{ all -> 0x0031 }
            r2.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0031 }
            android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch:{ all -> 0x0031 }
            r1 = 0
            if (r0 == 0) goto L_0x002b
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x002b
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x0031 }
            r0.close()
            return r1
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.close()
        L_0x0030:
            return r1
        L_0x0031:
            r1 = move-exception
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.m.b():int");
    }

    public synchronized void close() {
        super.close();
        if (this.f1889b != null) {
            this.f1889b.close();
            this.f1889b = null;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f1889b = sQLiteDatabase;
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void a(String str) {
        getWritableDatabase().execSQL(str);
    }

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.f1889b.query(this.f1888a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public long a(String str, ContentValues contentValues) {
        return this.f1889b.insert(this.f1888a, str, contentValues);
    }

    public int a(String str, String[] strArr) {
        return this.f1889b.delete(this.f1888a, str, strArr);
    }
}
