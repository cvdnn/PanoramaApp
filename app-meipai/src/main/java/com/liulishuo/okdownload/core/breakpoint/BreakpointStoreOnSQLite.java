package com.liulishuo.okdownload.core.breakpoint;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import e.i.a.h.d.a;
import e.i.a.h.d.c;
import e.i.a.h.d.e;
import e.i.a.h.d.f;
import e.i.a.h.d.g;
import e.i.a.h.d.i;
import java.io.IOException;

public class BreakpointStoreOnSQLite implements g {

    /* renamed from: a reason: collision with root package name */
    public final e f3543a;

    /* renamed from: b reason: collision with root package name */
    public final f f3544b;

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Throwable, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0, types: [java.lang.Throwable, java.lang.String[], android.database.Cursor]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [?[OBJECT, ARRAY], java.lang.String[], java.lang.Throwable, ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor]
  mth insns count: 122
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141  */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BreakpointStoreOnSQLite(android.content.Context r22) {
        /*
            r21 = this;
            r1 = r21
            r21.<init>()
            e.i.a.h.d.e r0 = new e.i.a.h.d.e
            android.content.Context r2 = r22.getApplicationContext()
            r0.<init>(r2)
            r1.f3543a = r0
            e.i.a.h.d.f r2 = new e.i.a.h.d.f
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
            java.lang.String r6 = "SELECT * FROM breakpoint"
            android.database.Cursor r6 = r0.rawQuery(r6, r5)     // Catch:{ all -> 0x0138 }
        L_0x0027:
            boolean r7 = r6.moveToNext()     // Catch:{ all -> 0x0134 }
            if (r7 == 0) goto L_0x0036
            e.i.a.h.d.d r7 = new e.i.a.h.d.d     // Catch:{ all -> 0x0134 }
            r7.<init>(r6)     // Catch:{ all -> 0x0134 }
            r3.add(r7)     // Catch:{ all -> 0x0134 }
            goto L_0x0027
        L_0x0036:
            java.lang.String r7 = "SELECT * FROM block"
            android.database.Cursor r7 = r0.rawQuery(r7, r5)     // Catch:{ all -> 0x0134 }
        L_0x003c:
            boolean r0 = r7.moveToNext()     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x004b
            e.i.a.h.d.b r0 = new e.i.a.h.d.b     // Catch:{ all -> 0x0131 }
            r0.<init>(r7)     // Catch:{ all -> 0x0131 }
            r4.add(r0)     // Catch:{ all -> 0x0131 }
            goto L_0x003c
        L_0x004b:
            r6.close()
            r7.close()
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x005a:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00b9
            java.lang.Object r6 = r3.next()
            e.i.a.h.d.d r6 = (e.i.a.h.d.d) r6
            e.i.a.h.d.c r13 = new e.i.a.h.d.c
            int r8 = r6.f8711a
            java.lang.String r9 = r6.f8712b
            java.io.File r10 = new java.io.File
            java.lang.String r7 = r6.f8714d
            r10.<init>(r7)
            java.lang.String r11 = r6.f8715e
            boolean r12 = r6.f8716f
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            java.lang.String r7 = r6.f8713c
            r13.f8704c = r7
            boolean r6 = r6.f8717g
            r13.f8710i = r6
            java.util.Iterator r6 = r4.iterator()
        L_0x0087:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b3
            java.lang.Object r7 = r6.next()
            e.i.a.h.d.b r7 = (e.i.a.h.d.b) r7
            int r8 = r7.f8698a
            int r9 = r13.f8702a
            if (r8 != r9) goto L_0x0087
            e.i.a.h.d.a r8 = new e.i.a.h.d.a
            long r9 = r7.f8699b
            long r11 = r7.f8700c
            long r14 = r7.f8701d
            r19 = r14
            r14 = r8
            r15 = r9
            r17 = r11
            r14.<init>(r15, r17, r19)
            java.util.List<e.i.a.h.d.a> r7 = r13.f8708g
            r7.add(r8)
            r6.remove()
            goto L_0x0087
        L_0x00b3:
            int r6 = r13.f8702a
            r0.put(r6, r13)
            goto L_0x005a
        L_0x00b9:
            e.i.a.h.d.e r3 = r1.f3543a
            if (r3 == 0) goto L_0x0130
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = "SELECT * FROM taskFileDirty"
            android.database.Cursor r3 = r3.rawQuery(r6, r5)     // Catch:{ all -> 0x0129 }
        L_0x00cc:
            boolean r6 = r3.moveToNext()     // Catch:{ all -> 0x0126 }
            if (r6 == 0) goto L_0x00e4
            java.lang.String r6 = "id"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ all -> 0x0126 }
            int r6 = r3.getInt(r6)     // Catch:{ all -> 0x0126 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0126 }
            r4.add(r6)     // Catch:{ all -> 0x0126 }
            goto L_0x00cc
        L_0x00e4:
            r3.close()
            e.i.a.h.d.e r3 = r1.f3543a
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r7 = "SELECT * FROM okdownloadResponseFilename"
            android.database.Cursor r5 = r3.rawQuery(r7, r5)     // Catch:{ all -> 0x011f }
        L_0x00f8:
            boolean r3 = r5.moveToNext()     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x0116
            java.lang.String r3 = "url"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r7 = "filename"
            int r7 = r5.getColumnIndex(r7)     // Catch:{ all -> 0x011f }
            java.lang.String r7 = r5.getString(r7)     // Catch:{ all -> 0x011f }
            r6.put(r3, r7)     // Catch:{ all -> 0x011f }
            goto L_0x00f8
        L_0x0116:
            r5.close()
            r2.<init>(r0, r4, r6)
            r1.f3544b = r2
            return
        L_0x011f:
            r0 = move-exception
            if (r5 == 0) goto L_0x0125
            r5.close()
        L_0x0125:
            throw r0
        L_0x0126:
            r0 = move-exception
            r5 = r3
            goto L_0x012a
        L_0x0129:
            r0 = move-exception
        L_0x012a:
            if (r5 == 0) goto L_0x012f
            r5.close()
        L_0x012f:
            throw r0
        L_0x0130:
            throw r5
        L_0x0131:
            r0 = move-exception
            r5 = r7
            goto L_0x0135
        L_0x0134:
            r0 = move-exception
        L_0x0135:
            r2 = r5
            r5 = r6
            goto L_0x013a
        L_0x0138:
            r0 = move-exception
            r2 = r5
        L_0x013a:
            if (r5 == 0) goto L_0x013f
            r5.close()
        L_0x013f:
            if (r2 == 0) goto L_0x0144
            r2.close()
        L_0x0144:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.okdownload.core.breakpoint.BreakpointStoreOnSQLite.<init>(android.content.Context):void");
    }

    public c a(e.i.a.c cVar) throws IOException {
        c a2 = this.f3544b.a(cVar);
        this.f3543a.a(a2);
        return a2;
    }

    public boolean a() {
        return false;
    }

    public int b(e.i.a.c cVar) {
        return this.f3544b.b(cVar);
    }

    public c b(int i2) {
        return null;
    }

    public boolean c(int i2) {
        return this.f3544b.f8723f.contains(Integer.valueOf(i2));
    }

    public g createRemitSelf() {
        return new i(this);
    }

    public void d(int i2) {
        if (this.f3544b == null) {
            throw null;
        }
    }

    public boolean e(int i2) {
        if (!this.f3544b.e(i2)) {
            return false;
        }
        this.f3543a.getWritableDatabase().delete("taskFileDirty", "id = ?", new String[]{String.valueOf(i2)});
        return true;
    }

    public c get(int i2) {
        return (c) this.f3544b.f8718a.get(i2);
    }

    public void remove(int i2) {
        this.f3544b.remove(i2);
        this.f3543a.a(i2);
    }

    public void a(c cVar, int i2, long j2) throws IOException {
        this.f3544b.a(cVar, i2, j2);
        long a2 = ((a) cVar.f8708g.get(i2)).a();
        e eVar = this.f3543a;
        if (eVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_offset", Long.valueOf(a2));
            eVar.getWritableDatabase().update("block", contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(cVar.f8702a), Integer.toString(i2)});
            return;
        }
        throw null;
    }

    public boolean a(c cVar) throws IOException {
        boolean a2 = this.f3544b.a(cVar);
        e eVar = this.f3543a;
        SQLiteDatabase writableDatabase = eVar.getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase2 = eVar.getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT id FROM breakpoint WHERE id =");
            sb.append(cVar.f8702a);
            sb.append(" LIMIT 1");
            cursor = writableDatabase2.rawQuery(sb.toString(), null);
            if (cursor.moveToNext()) {
                eVar.a(cVar.f8702a);
                eVar.a(cVar);
                writableDatabase.setTransactionSuccessful();
            }
            cursor.close();
            writableDatabase.endTransaction();
            String str = cVar.f8707f.f8854a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("update ");
            sb2.append(cVar);
            e.i.a.h.c.a("BreakpointStoreOnSQLite", sb2.toString());
            if (cVar.f8709h && str != null) {
                this.f3543a.a(cVar.f8703b, str);
            }
            return a2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public void a(int i2, e.i.a.h.e.a aVar, Exception exc) {
        this.f3544b.a(i2, aVar, exc);
        if (aVar == e.i.a.h.e.a.COMPLETED) {
            this.f3543a.a(i2);
        }
    }

    public boolean a(int i2) {
        if (!this.f3544b.a(i2)) {
            return false;
        }
        SQLiteDatabase writableDatabase = this.f3543a.getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", Integer.valueOf(i2));
        writableDatabase.insert("taskFileDirty", null, contentValues);
        return true;
    }

    public c a(e.i.a.c cVar, c cVar2) {
        return this.f3544b.a(cVar, cVar2);
    }

    public String a(String str) {
        return (String) this.f3544b.f8719b.get(str);
    }
}
