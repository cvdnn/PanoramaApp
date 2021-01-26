package e.c.f.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.core.ApkInfo;
import e.c.f.c;
import e.c.f.f.g;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: D */
public final class a {

    /* renamed from: f reason: collision with root package name */
    public static a f6914f;

    /* renamed from: a reason: collision with root package name */
    public int f6915a = 5;

    /* renamed from: b reason: collision with root package name */
    public String f6916b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";

    /* renamed from: c reason: collision with root package name */
    public C0074a f6917c;

    /* renamed from: d reason: collision with root package name */
    public SQLiteDatabase f6918d;

    /* renamed from: e reason: collision with root package name */
    public Context f6919e;

    /* renamed from: e.c.f.d.a$a reason: collision with other inner class name */
    /* compiled from: D */
    public class C0074a extends SQLiteOpenHelper {
        public C0074a(Context context) {
            super(context, "tpgcc.db", null, a.this.f6915a);
            new StringBuilder().append(a.this.f6915a);
            c.a();
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.f6916b);
            } catch (Throwable unused) {
                c.d();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x005a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onUpgrade(android.database.sqlite.SQLiteDatabase r3, int r4, int r5) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
                java.lang.String r1 = "o="
                r0.<init>(r1)     // Catch:{ all -> 0x005e }
                r0.append(r4)     // Catch:{ all -> 0x005e }
                java.lang.String r1 = ", n="
                r0.append(r1)     // Catch:{ all -> 0x005e }
                r0.append(r5)     // Catch:{ all -> 0x005e }
                e.c.f.c.a()     // Catch:{ all -> 0x005e }
                r0 = 3
                if (r4 >= r0) goto L_0x0032
                if (r5 < r0) goto L_0x0032
                r3.beginTransaction()     // Catch:{ all -> 0x005e }
                java.lang.String r0 = "ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1"
                r3.execSQL(r0)     // Catch:{ all -> 0x0029 }
                r3.setTransactionSuccessful()     // Catch:{ all -> 0x0029 }
            L_0x0025:
                r3.endTransaction()     // Catch:{ all -> 0x005e }
                goto L_0x0032
            L_0x0029:
                e.c.f.c.d()     // Catch:{ all -> 0x002d }
                goto L_0x0025
            L_0x002d:
                r4 = move-exception
                r3.endTransaction()     // Catch:{ all -> 0x005e }
                throw r4     // Catch:{ all -> 0x005e }
            L_0x0032:
                r0 = 5
                if (r4 >= r0) goto L_0x004f
                if (r5 < r0) goto L_0x004f
                r3.beginTransaction()     // Catch:{ all -> 0x005e }
                java.lang.String r0 = "ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1"
                r3.execSQL(r0)     // Catch:{ all -> 0x0046 }
                r3.setTransactionSuccessful()     // Catch:{ all -> 0x0046 }
            L_0x0042:
                r3.endTransaction()     // Catch:{ all -> 0x005e }
                goto L_0x004f
            L_0x0046:
                e.c.f.c.d()     // Catch:{ all -> 0x004a }
                goto L_0x0042
            L_0x004a:
                r4 = move-exception
                r3.endTransaction()     // Catch:{ all -> 0x005e }
                throw r4     // Catch:{ all -> 0x005e }
            L_0x004f:
                r0 = 4
                if (r4 >= r0) goto L_0x005d
                if (r5 < r0) goto L_0x005d
                java.lang.String r4 = "drop table if exists tbch"
                r3.execSQL(r4)     // Catch:{ all -> 0x005a }
                return
            L_0x005a:
                e.c.f.c.d()     // Catch:{ all -> 0x005e }
            L_0x005d:
                return
            L_0x005e:
                e.c.f.c.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.C0074a.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
        }
    }

    public a(Context context) {
        c.a();
        this.f6919e = context.getApplicationContext();
        C0074a aVar = new C0074a(context.getApplicationContext());
        this.f6917c = aVar;
        try {
            this.f6918d = aVar.getWritableDatabase();
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            new StringBuilder("i=").append(f6914f);
            c.a();
            if (f6914f == null) {
                f6914f = new a(context);
            }
            aVar = f6914f;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (r2.isClosed() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r2 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r2.isClosed() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r2 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (r2.isClosed() == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.lang.String> b() {
        /*
            r10 = this;
            java.lang.String r0 = "'"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r10.f6918d     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = "pgn"
            r4 = 0
            java.lang.String r5 = "n=1"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0049
        L_0x0018:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x005a }
            if (r3 == 0) goto L_0x0049
            java.lang.String r3 = "k"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x005a }
            int r3 = r2.getInt(r3)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "v"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x005a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r5.<init>(r0)     // Catch:{ all -> 0x005a }
            r5.append(r4)     // Catch:{ all -> 0x005a }
            r5.append(r0)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005a }
            r1.put(r3, r4)     // Catch:{ all -> 0x005a }
            goto L_0x0018
        L_0x0049:
            if (r2 == 0) goto L_0x0066
            boolean r0 = r2.isClosed()     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x0066
        L_0x0051:
            r2.close()     // Catch:{ all -> 0x0055 }
            goto L_0x0066
        L_0x0055:
            e.c.f.c.d()
            goto L_0x0066
        L_0x0059:
            r2 = 0
        L_0x005a:
            e.c.f.c.d()     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x0066
            boolean r0 = r2.isClosed()     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x0066
            goto L_0x0051
        L_0x0066:
            return r1
        L_0x0067:
            r0 = move-exception
            if (r2 == 0) goto L_0x0077
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0077
            r2.close()     // Catch:{ all -> 0x0074 }
            goto L_0x0077
        L_0x0074:
            e.c.f.c.d()
        L_0x0077:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.b():java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r1.isClosed() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r1 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r1.isClosed() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r1 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        if (r1.isClosed() == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.lang.String> c() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.f6918d     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "pgn"
            r3 = 0
            java.lang.String r4 = "n=1"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0038
        L_0x0016:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "k"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x0049 }
            int r2 = r1.getInt(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0049 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0049 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0049 }
            goto L_0x0016
        L_0x0038:
            if (r1 == 0) goto L_0x0055
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x0055
        L_0x0040:
            r1.close()     // Catch:{ all -> 0x0044 }
            goto L_0x0055
        L_0x0044:
            e.c.f.c.d()
            goto L_0x0055
        L_0x0048:
            r1 = 0
        L_0x0049:
            e.c.f.c.d()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0055
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x0055
            goto L_0x0040
        L_0x0055:
            return r0
        L_0x0056:
            r0 = move-exception
            if (r1 == 0) goto L_0x0066
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0063 }
            if (r2 != 0) goto L_0x0066
            r1.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0066
        L_0x0063:
            e.c.f.c.d()
        L_0x0066:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.c():java.util.Map");
    }

    public final void d() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((ArrayList) a()).iterator();
            while (it.hasNext()) {
                ApkInfo apkInfo = (ApkInfo) it.next();
                if (!e.c.f.n.a.c(apkInfo.pkgPath) && g.f6981j != null && !g.f6981j.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            g gVar = g.f6978g;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ApkInfo apkInfo2 = (ApkInfo) it2.next();
                if (gVar != null) {
                    gVar.b(apkInfo2.packageName);
                }
                StringBuilder sb = new StringBuilder("k=");
                sb.append(apkInfo2.key);
                int delete = this.f6918d.delete("pgn", sb.toString(), null);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(apkInfo2.packageName);
                sb2.append(delete);
                c.a();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f6919e.getFilesDir().getCanonicalPath());
                sb3.append("/.");
                sb3.append(apkInfo2.key);
                e.c.f.n.a.d(sb3.toString());
                if (this.f6919e != null) {
                    e.c.f.n.a.d(this.f6919e.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r11.isClosed() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (r11 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r11.isClosed() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
        if (r11.isClosed() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f6918d     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch:{ all -> 0x0045 }
            r5.append(r11)     // Catch:{ all -> 0x0045 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0045 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0045 }
            if (r11 == 0) goto L_0x0035
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0035
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0046 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0046 }
            r2 = 1
            if (r0 != r2) goto L_0x0035
            r1 = r2
        L_0x0035:
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0052
        L_0x003d:
            r11.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0052
        L_0x0041:
            e.c.f.c.d()
            goto L_0x0052
        L_0x0045:
            r11 = 0
        L_0x0046:
            e.c.f.c.d()     // Catch:{ all -> 0x0053 }
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0052
            goto L_0x003d
        L_0x0052:
            return r1
        L_0x0053:
            r0 = move-exception
            if (r11 == 0) goto L_0x0063
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0063
            r11.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            e.c.f.c.d()
        L_0x0063:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.e(int):boolean");
    }

    public final void f(int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(-1));
            StringBuilder sb = new StringBuilder("k=");
            sb.append(i2);
            this.f6918d.update("pgn", contentValues, sb.toString(), null);
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r11.isClosed() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r11 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r11.isClosed() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r11 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r11.isClosed() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0043 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "pdld"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f6918d     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch:{ all -> 0x0042 }
            r5.append(r11)     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0042 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0042 }
            if (r11 == 0) goto L_0x0032
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0032
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0043 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0043 }
            r1 = r0
        L_0x0032:
            if (r11 == 0) goto L_0x004f
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x004f
        L_0x003a:
            r11.close()     // Catch:{ all -> 0x003e }
            goto L_0x004f
        L_0x003e:
            e.c.f.c.d()
            goto L_0x004f
        L_0x0042:
            r11 = 0
        L_0x0043:
            e.c.f.c.d()     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x004f
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x004f
            goto L_0x003a
        L_0x004f:
            return r1
        L_0x0050:
            r0 = move-exception
            if (r11 == 0) goto L_0x0060
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0060
            r11.close()     // Catch:{ all -> 0x005d }
            goto L_0x0060
        L_0x005d:
            e.c.f.c.d()
        L_0x0060:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.g(int):int");
    }

    public final void h(int i2) {
        new StringBuilder().append(i2);
        c.a();
        if (i2 > 0) {
            try {
                StringBuilder sb = new StringBuilder("k=");
                sb.append(i2);
                new StringBuilder().append(this.f6918d.delete("pgn", sb.toString(), null));
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0124 A[SYNTHETIC, Splitter:B:36:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0129 A[Catch:{ IOException -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0135 A[SYNTHETIC, Splitter:B:47:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013a A[Catch:{ IOException -> 0x013e }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0151 A[SYNTHETIC, Splitter:B:57:0x0151] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0169 A[Catch:{ all -> 0x017a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.baidu.sofire.core.ApkInfo r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0005
            return r0
        L_0x0005:
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
            int r3 = r11.initStatus
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "n"
            r2.put(r4, r3)
            java.lang.String r3 = r11.packageName
            java.lang.String r4 = "p"
            r2.put(r4, r3)
            java.lang.String r3 = r11.pkgPath
            java.lang.String r4 = "a"
            r2.put(r4, r3)
            java.lang.String r3 = r11.libPath
            java.lang.String r4 = "l"
            r2.put(r4, r3)
            java.lang.String r3 = r11.versionName
            java.lang.String r4 = "v"
            r2.put(r4, r3)
            java.lang.String r3 = r11.dexPath
            java.lang.String r4 = "apk"
            r2.put(r4, r3)
            int r3 = r11.apkParseSuc
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "ap"
            r2.put(r4, r3)
            java.lang.String r3 = r11.className
            java.lang.String r4 = "cl"
            r2.put(r4, r3)
            long r3 = r11.startTime
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "st"
            r2.put(r4, r3)
            int r3 = r11.duration
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "du"
            r2.put(r4, r3)
            java.lang.String r3 = r11.apkMD5
            java.lang.String r4 = "m5"
            r2.put(r4, r3)
            int r3 = r11.applicationTheme
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "th"
            r2.put(r4, r3)
            int r3 = r11.priority
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "pr"
            r2.put(r4, r3)
            android.content.pm.ActivityInfo[] r3 = r11.activities
            r4 = 0
            if (r3 == 0) goto L_0x0147
            if (r3 == 0) goto L_0x00f6
            int r5 = r3.length
            if (r5 <= 0) goto L_0x00f6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r5)
            r7 = 0
        L_0x008d:
            if (r7 >= r5) goto L_0x00f7
            r8 = r3[r7]
            if (r8 == 0) goto L_0x00f3
            e.c.f.f.b r8 = new e.c.f.f.b
            r8.<init>()
            r9 = r3[r7]
            int r9 = r9.configChanges
            r8.f6929h = r9
            r9 = r3[r7]
            int r9 = r9.flags
            r8.f6927f = r9
            r9 = r3[r7]
            int r9 = r9.labelRes
            r8.l = r9
            r9 = r3[r7]
            int r9 = r9.launchMode
            r8.f6923b = r9
            r9 = r3[r7]
            java.lang.CharSequence r9 = r9.nonLocalizedLabel
            if (r9 == 0) goto L_0x00c0
            r9 = r3[r7]
            java.lang.CharSequence r9 = r9.nonLocalizedLabel
            java.lang.String r9 = r9.toString()
            r8.m = r9
        L_0x00c0:
            r9 = r3[r7]
            java.lang.String r9 = r9.name
            r8.f6931j = r9
            r9 = r3[r7]
            java.lang.String r9 = r9.packageName
            r8.k = r9
            r9 = r3[r7]
            java.lang.String r9 = r9.permission
            r8.f6924c = r9
            r9 = r3[r7]
            int r9 = r9.screenOrientation
            r8.f6928g = r9
            r9 = r3[r7]
            int r9 = r9.softInputMode
            r8.f6930i = r9
            r9 = r3[r7]
            java.lang.String r9 = r9.targetActivity
            r8.f6926e = r9
            r9 = r3[r7]
            java.lang.String r9 = r9.taskAffinity
            r8.f6925d = r9
            r9 = r3[r7]
            int r9 = r9.theme
            r8.f6922a = r9
            r6.add(r8)
        L_0x00f3:
            int r7 = r7 + 1
            goto L_0x008d
        L_0x00f6:
            r6 = r4
        L_0x00f7:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0131, all -> 0x0120 }
            r3.<init>()     // Catch:{ IOException -> 0x0131, all -> 0x0120 }
            java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x011e, all -> 0x011c }
            r5.<init>(r3)     // Catch:{ IOException -> 0x011e, all -> 0x011c }
            r5.writeObject(r6)     // Catch:{ IOException -> 0x0133, all -> 0x0119 }
            r5.close()     // Catch:{ IOException -> 0x0133, all -> 0x0119 }
            r3.close()     // Catch:{ IOException -> 0x0133, all -> 0x0119 }
            byte[] r6 = r3.toByteArray()     // Catch:{ IOException -> 0x0133, all -> 0x0119 }
            r5.close()     // Catch:{ IOException -> 0x0115 }
            r3.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0142
        L_0x0115:
            e.c.f.c.d()
            goto L_0x0142
        L_0x0119:
            r11 = move-exception
            r4 = r5
            goto L_0x0122
        L_0x011c:
            r11 = move-exception
            goto L_0x0122
        L_0x011e:
            r5 = r4
            goto L_0x0133
        L_0x0120:
            r11 = move-exception
            r3 = r4
        L_0x0122:
            if (r4 == 0) goto L_0x0127
            r4.close()     // Catch:{ IOException -> 0x012d }
        L_0x0127:
            if (r3 == 0) goto L_0x0130
            r3.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0130
        L_0x012d:
            e.c.f.c.d()
        L_0x0130:
            throw r11
        L_0x0131:
            r3 = r4
            r5 = r3
        L_0x0133:
            if (r5 == 0) goto L_0x0138
            r5.close()     // Catch:{ IOException -> 0x013e }
        L_0x0138:
            if (r3 == 0) goto L_0x0141
            r3.close()     // Catch:{ IOException -> 0x013e }
            goto L_0x0141
        L_0x013e:
            e.c.f.c.d()
        L_0x0141:
            r6 = r4
        L_0x0142:
            java.lang.String r3 = "ac"
            r2.put(r3, r6)
        L_0x0147:
            int r3 = r11.key
            boolean r3 = r10.b(r3)
            java.lang.String r5 = "pgn"
            if (r3 == 0) goto L_0x0169
            android.database.sqlite.SQLiteDatabase r3 = r10.f6918d     // Catch:{ all -> 0x017a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            java.lang.String r7 = "k="
            r6.<init>(r7)     // Catch:{ all -> 0x017a }
            int r11 = r11.key     // Catch:{ all -> 0x017a }
            r6.append(r11)     // Catch:{ all -> 0x017a }
            java.lang.String r11 = r6.toString()     // Catch:{ all -> 0x017a }
            int r11 = r3.update(r5, r2, r11, r4)     // Catch:{ all -> 0x017a }
            long r0 = (long) r11     // Catch:{ all -> 0x017a }
            goto L_0x017a
        L_0x0169:
            java.lang.String r3 = "k"
            int r11 = r11.key     // Catch:{ all -> 0x017a }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x017a }
            r2.put(r3, r11)     // Catch:{ all -> 0x017a }
            android.database.sqlite.SQLiteDatabase r11 = r10.f6918d     // Catch:{ all -> 0x017a }
            long r0 = r11.insert(r5, r4, r2)     // Catch:{ all -> 0x017a }
        L_0x017a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.a(com.baidu.sofire.core.ApkInfo):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (r10.isClosed() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r10 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r10.isClosed() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        if (r10 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r10.isClosed() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int r10) {
        /*
            r9 = this;
            java.lang.String r1 = "pgn"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.f6918d     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ all -> 0x003b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch:{ all -> 0x003b }
            r3.append(r10)     // Catch:{ all -> 0x003b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003b }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003b }
            if (r10 == 0) goto L_0x002b
            int r0 = r10.getCount()     // Catch:{ all -> 0x003c }
            if (r0 <= 0) goto L_0x002b
            r0 = 1
            r8 = r0
        L_0x002b:
            if (r10 == 0) goto L_0x0048
            boolean r0 = r10.isClosed()     // Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x0048
        L_0x0033:
            r10.close()     // Catch:{ all -> 0x0037 }
            goto L_0x0048
        L_0x0037:
            e.c.f.c.d()
            goto L_0x0048
        L_0x003b:
            r10 = 0
        L_0x003c:
            e.c.f.c.d()     // Catch:{ all -> 0x0049 }
            if (r10 == 0) goto L_0x0048
            boolean r0 = r10.isClosed()     // Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x0048
            goto L_0x0033
        L_0x0048:
            return r8
        L_0x0049:
            r0 = move-exception
            if (r10 == 0) goto L_0x0059
            boolean r1 = r10.isClosed()     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0059
            r10.close()     // Catch:{ all -> 0x0056 }
            goto L_0x0059
        L_0x0056:
            e.c.f.c.d()
        L_0x0059:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.b(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r11.isClosed() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r11 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r11.isClosed() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r11 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r11.isClosed() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0043 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f6918d     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch:{ all -> 0x0042 }
            r5.append(r11)     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0042 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0042 }
            if (r11 == 0) goto L_0x0032
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0032
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0043 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0043 }
            r1 = r0
        L_0x0032:
            if (r11 == 0) goto L_0x004f
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x004f
        L_0x003a:
            r11.close()     // Catch:{ all -> 0x003e }
            goto L_0x004f
        L_0x003e:
            e.c.f.c.d()
            goto L_0x004f
        L_0x0042:
            r11 = 0
        L_0x0043:
            e.c.f.c.d()     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x004f
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x004f
            goto L_0x003a
        L_0x004f:
            return r1
        L_0x0050:
            r0 = move-exception
            if (r11 == 0) goto L_0x0060
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0060
            r11.close()     // Catch:{ all -> 0x005d }
            goto L_0x0060
        L_0x005d:
            e.c.f.c.d()
        L_0x0060:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.c(int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r11.isClosed() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (r11 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r11.isClosed() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
        if (r11.isClosed() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "u"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f6918d     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch:{ all -> 0x0045 }
            r5.append(r11)     // Catch:{ all -> 0x0045 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0045 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0045 }
            if (r11 == 0) goto L_0x0035
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0035
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0046 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0046 }
            r2 = 1
            if (r0 != r2) goto L_0x0035
            r1 = r2
        L_0x0035:
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0052
        L_0x003d:
            r11.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0052
        L_0x0041:
            e.c.f.c.d()
            goto L_0x0052
        L_0x0045:
            r11 = 0
        L_0x0046:
            e.c.f.c.d()     // Catch:{ all -> 0x0053 }
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0052
            goto L_0x003d
        L_0x0052:
            return r1
        L_0x0053:
            r0 = move-exception
            if (r11 == 0) goto L_0x0063
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0063
            r11.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            e.c.f.c.d()
        L_0x0063:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.d(int):boolean");
    }

    public final void b(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i3));
        try {
            StringBuilder sb = new StringBuilder("k=");
            sb.append(i2);
            this.f6918d.update("pgn", contentValues, sb.toString(), null);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public final void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(i3));
            StringBuilder sb = new StringBuilder("k=");
            sb.append(i2);
            this.f6918d.update("pgn", contentValues, sb.toString(), null);
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.baidu.sofire.core.ApkInfo] */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r11v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6, types: [com.baidu.sofire.core.ApkInfo] */
    /* JADX WARNING: type inference failed for: r1v50 */
    /* JADX WARNING: type inference failed for: r1v52 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v3
  assigns: []
  uses: []
  mth insns count: 166
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
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0199 A[SYNTHETIC, Splitter:B:39:0x0199] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.sofire.core.ApkInfo b(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.database.sqlite.SQLiteDatabase r2 = r10.f6918d     // Catch:{ all -> 0x0193 }
            java.lang.String r3 = "pgn"
            r4 = 0
            java.lang.String r5 = "p=?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ all -> 0x0193 }
            r0 = 0
            r6[r0] = r11     // Catch:{ all -> 0x0193 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0193 }
            if (r11 == 0) goto L_0x0183
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0180 }
            if (r2 == 0) goto L_0x0183
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x0180 }
            r2.<init>()     // Catch:{ all -> 0x0180 }
            java.lang.String r1 = "k"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0181 }
            r2.key = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "n"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0181 }
            r2.initStatus = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "p"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.packageName = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "a"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.pkgPath = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "l"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.libPath = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "v"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.versionName = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "apk"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.dexPath = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "ap"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0181 }
            r2.apkParseSuc = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "cl"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.className = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "th"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0181 }
            r2.applicationTheme = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "st"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            long r3 = r11.getLong(r1)     // Catch:{ all -> 0x0181 }
            r2.startTime = r3     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "du"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0181 }
            r2.duration = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "m5"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0181 }
            r2.apkMD5 = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "pr"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0181 }
            r2.priority = r1     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "ac"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x0181 }
            byte[] r1 = r11.getBlob(r1)     // Catch:{ all -> 0x0181 }
            if (r1 == 0) goto L_0x017e
            java.util.ArrayList r1 = e.c.f.f.a.a(r1)     // Catch:{ all -> 0x0181 }
            if (r1 == 0) goto L_0x017e
            int r3 = r1.size()     // Catch:{ all -> 0x0181 }
            if (r3 <= 0) goto L_0x017e
            android.content.pm.ActivityInfo[] r4 = new android.content.pm.ActivityInfo[r3]     // Catch:{ all -> 0x0181 }
            r2.activities = r4     // Catch:{ all -> 0x0181 }
        L_0x00ed:
            if (r0 >= r3) goto L_0x017e
            android.content.pm.ActivityInfo r4 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x0181 }
            r4.<init>()     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.f6922a     // Catch:{ all -> 0x0181 }
            r4.theme = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = r5.f6931j     // Catch:{ all -> 0x0181 }
            r4.name = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.f6929h     // Catch:{ all -> 0x0181 }
            r4.configChanges = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.f6927f     // Catch:{ all -> 0x0181 }
            r4.flags = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.l     // Catch:{ all -> 0x0181 }
            r4.labelRes = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.f6923b     // Catch:{ all -> 0x0181 }
            r4.launchMode = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = r5.m     // Catch:{ all -> 0x0181 }
            r4.nonLocalizedLabel = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = r5.k     // Catch:{ all -> 0x0181 }
            r4.packageName = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = r5.f6924c     // Catch:{ all -> 0x0181 }
            r4.permission = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.f6928g     // Catch:{ all -> 0x0181 }
            r4.screenOrientation = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            int r5 = r5.f6930i     // Catch:{ all -> 0x0181 }
            r4.softInputMode = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = r5.f6926e     // Catch:{ all -> 0x0181 }
            r4.targetActivity = r5     // Catch:{ all -> 0x0181 }
            java.lang.Object r5 = r1.get(r0)     // Catch:{ all -> 0x0181 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = r5.f6925d     // Catch:{ all -> 0x0181 }
            r4.taskAffinity = r5     // Catch:{ all -> 0x0181 }
            android.content.pm.ActivityInfo[] r5 = r2.activities     // Catch:{ all -> 0x0181 }
            r5[r0] = r4     // Catch:{ all -> 0x0181 }
            int r0 = r0 + 1
            goto L_0x00ed
        L_0x017e:
            r1 = r2
            goto L_0x0183
        L_0x0180:
            r2 = r1
        L_0x0181:
            r1 = r11
            goto L_0x0194
        L_0x0183:
            if (r11 == 0) goto L_0x01a7
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x018f }
            if (r0 != 0) goto L_0x01a7
            r11.close()     // Catch:{ all -> 0x018f }
            goto L_0x01a7
        L_0x018f:
            e.c.f.c.d()
            goto L_0x01a7
        L_0x0193:
            r2 = r1
        L_0x0194:
            e.c.f.c.d()     // Catch:{ all -> 0x01a8 }
            if (r1 == 0) goto L_0x01a6
            boolean r11 = r1.isClosed()     // Catch:{ all -> 0x01a3 }
            if (r11 != 0) goto L_0x01a6
            r1.close()     // Catch:{ all -> 0x01a3 }
            goto L_0x01a6
        L_0x01a3:
            e.c.f.c.d()
        L_0x01a6:
            r1 = r2
        L_0x01a7:
            return r1
        L_0x01a8:
            r11 = move-exception
            if (r1 == 0) goto L_0x01b8
            boolean r0 = r1.isClosed()     // Catch:{ all -> 0x01b5 }
            if (r0 != 0) goto L_0x01b8
            r1.close()     // Catch:{ all -> 0x01b5 }
            goto L_0x01b8
        L_0x01b5:
            e.c.f.c.d()
        L_0x01b8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.b(java.lang.String):com.baidu.sofire.core.ApkInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x008a, code lost:
        if (r1.isClosed() == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r1 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009e, code lost:
        if (r1.isClosed() == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a3, code lost:
        if (r1 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a9, code lost:
        if (r1.isClosed() == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ab, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0095 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.baidu.sofire.core.ApkInfo> a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.f6918d     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "pgn"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0084
        L_0x0015:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0084
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x0095 }
            r2.<init>()     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x0095 }
            r2.key = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0095 }
            r2.packageName = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0095 }
            r2.pkgPath = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0095 }
            r2.libPath = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0095 }
            r2.versionName = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "st"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0095 }
            r2.startTime = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "du"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x0095 }
            r2.duration = r3     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "pr"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0095 }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x0095 }
            r2.priority = r3     // Catch:{ all -> 0x0095 }
            r0.add(r2)     // Catch:{ all -> 0x0095 }
            goto L_0x0015
        L_0x0084:
            if (r1 == 0) goto L_0x00a1
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0090 }
            if (r2 != 0) goto L_0x00a1
        L_0x008c:
            r1.close()     // Catch:{ all -> 0x0090 }
            goto L_0x00a1
        L_0x0090:
            e.c.f.c.d()
            goto L_0x00a1
        L_0x0094:
            r1 = 0
        L_0x0095:
            e.c.f.c.d()     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x00a1
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0090 }
            if (r2 != 0) goto L_0x00a1
            goto L_0x008c
        L_0x00a1:
            return r0
        L_0x00a2:
            r0 = move-exception
            if (r1 == 0) goto L_0x00b2
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00af }
            if (r2 != 0) goto L_0x00b2
            r1.close()     // Catch:{ all -> 0x00af }
            goto L_0x00b2
        L_0x00af:
            e.c.f.c.d()
        L_0x00b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.a():java.util.List");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.baidu.sofire.core.ApkInfo] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3, types: [com.baidu.sofire.core.ApkInfo] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6, types: [com.baidu.sofire.core.ApkInfo] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v3
  assigns: []
  uses: []
  mth insns count: 165
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
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0190 A[SYNTHETIC, Splitter:B:36:0x0190] */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.sofire.core.ApkInfo a(int r10) {
        /*
            r9 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.f6918d     // Catch:{ all -> 0x018a }
            java.lang.String r2 = "pgn"
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            java.lang.String r5 = "k="
            r4.<init>(r5)     // Catch:{ all -> 0x018a }
            r4.append(r10)     // Catch:{ all -> 0x018a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x018a }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x018a }
            if (r1 == 0) goto L_0x017a
            boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x0177 }
            if (r2 == 0) goto L_0x017a
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x0177 }
            r2.<init>()     // Catch:{ all -> 0x0177 }
            r2.key = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "n"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x0178 }
            r2.initStatus = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "p"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.packageName = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "a"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.pkgPath = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "l"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.libPath = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "v"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.versionName = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "apk"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.dexPath = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "ap"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x0178 }
            r2.apkParseSuc = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "cl"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.className = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "th"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x0178 }
            r2.applicationTheme = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "st"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            long r3 = r1.getLong(r10)     // Catch:{ all -> 0x0178 }
            r2.startTime = r3     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "du"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x0178 }
            r2.duration = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "m5"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x0178 }
            r2.apkMD5 = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "pr"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x0178 }
            r2.priority = r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "ac"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x0178 }
            byte[] r10 = r1.getBlob(r10)     // Catch:{ all -> 0x0178 }
            if (r10 == 0) goto L_0x0175
            java.util.ArrayList r10 = e.c.f.f.a.a(r10)     // Catch:{ all -> 0x0178 }
            if (r10 == 0) goto L_0x0175
            int r0 = r10.size()     // Catch:{ all -> 0x0178 }
            if (r0 <= 0) goto L_0x0175
            android.content.pm.ActivityInfo[] r3 = new android.content.pm.ActivityInfo[r0]     // Catch:{ all -> 0x0178 }
            r2.activities = r3     // Catch:{ all -> 0x0178 }
            r3 = 0
        L_0x00e4:
            if (r3 >= r0) goto L_0x0175
            android.content.pm.ActivityInfo r4 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x0178 }
            r4.<init>()     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.f6922a     // Catch:{ all -> 0x0178 }
            r4.theme = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r5.f6931j     // Catch:{ all -> 0x0178 }
            r4.name = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.f6929h     // Catch:{ all -> 0x0178 }
            r4.configChanges = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.f6927f     // Catch:{ all -> 0x0178 }
            r4.flags = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.l     // Catch:{ all -> 0x0178 }
            r4.labelRes = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.f6923b     // Catch:{ all -> 0x0178 }
            r4.launchMode = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r5.m     // Catch:{ all -> 0x0178 }
            r4.nonLocalizedLabel = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r5.k     // Catch:{ all -> 0x0178 }
            r4.packageName = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r5.f6924c     // Catch:{ all -> 0x0178 }
            r4.permission = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.f6928g     // Catch:{ all -> 0x0178 }
            r4.screenOrientation = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            int r5 = r5.f6930i     // Catch:{ all -> 0x0178 }
            r4.softInputMode = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r5.f6926e     // Catch:{ all -> 0x0178 }
            r4.targetActivity = r5     // Catch:{ all -> 0x0178 }
            java.lang.Object r5 = r10.get(r3)     // Catch:{ all -> 0x0178 }
            e.c.f.f.b r5 = (e.c.f.f.b) r5     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r5.f6925d     // Catch:{ all -> 0x0178 }
            r4.taskAffinity = r5     // Catch:{ all -> 0x0178 }
            android.content.pm.ActivityInfo[] r5 = r2.activities     // Catch:{ all -> 0x0178 }
            r5[r3] = r4     // Catch:{ all -> 0x0178 }
            int r3 = r3 + 1
            goto L_0x00e4
        L_0x0175:
            r0 = r2
            goto L_0x017a
        L_0x0177:
            r2 = r0
        L_0x0178:
            r0 = r1
            goto L_0x018b
        L_0x017a:
            if (r1 == 0) goto L_0x019e
            boolean r10 = r1.isClosed()     // Catch:{ all -> 0x0186 }
            if (r10 != 0) goto L_0x019e
            r1.close()     // Catch:{ all -> 0x0186 }
            goto L_0x019e
        L_0x0186:
            e.c.f.c.d()
            goto L_0x019e
        L_0x018a:
            r2 = r0
        L_0x018b:
            e.c.f.c.d()     // Catch:{ all -> 0x019f }
            if (r0 == 0) goto L_0x019d
            boolean r10 = r0.isClosed()     // Catch:{ all -> 0x019a }
            if (r10 != 0) goto L_0x019d
            r0.close()     // Catch:{ all -> 0x019a }
            goto L_0x019d
        L_0x019a:
            e.c.f.c.d()
        L_0x019d:
            r0 = r2
        L_0x019e:
            return r0
        L_0x019f:
            r10 = move-exception
            if (r0 == 0) goto L_0x01af
            boolean r1 = r0.isClosed()     // Catch:{ all -> 0x01ac }
            if (r1 != 0) goto L_0x01af
            r0.close()     // Catch:{ all -> 0x01ac }
            goto L_0x01af
        L_0x01ac:
            e.c.f.c.d()
        L_0x01af:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.d.a.a(int):com.baidu.sofire.core.ApkInfo");
    }

    public final void a(String str) {
        new StringBuilder().append(str);
        c.a();
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f6918d.delete("pgn", "p=?", new String[]{str});
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    public final int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i3));
            StringBuilder sb = new StringBuilder("k=");
            sb.append(i2);
            return this.f6918d.update("pgn", contentValues, sb.toString(), null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void a(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(" v = ");
        sb.append(str);
        c.a();
        if (i2 > 0 && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb2 = new StringBuilder("k=");
                sb2.append(i2);
                sb2.append(" and v=?");
                this.f6918d.delete("pgn", sb2.toString(), new String[]{str});
            } catch (Throwable unused) {
                c.d();
            }
        }
    }
}
