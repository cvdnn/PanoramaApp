package e.c.f.h;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.pass.http.b;
import com.baidu.sofire.ac.F;
import e.c.f.c;

/* compiled from: ReportDb */
public final class a {

    /* renamed from: d reason: collision with root package name */
    public static long f7002d;

    /* renamed from: e reason: collision with root package name */
    public static a f7003e;

    /* renamed from: a reason: collision with root package name */
    public C0076a f7004a;

    /* renamed from: b reason: collision with root package name */
    public SQLiteDatabase f7005b;

    /* renamed from: c reason: collision with root package name */
    public Context f7006c;

    /* renamed from: e.c.f.h.a$a reason: collision with other inner class name */
    /* compiled from: ReportDb */
    public class C0076a extends SQLiteOpenHelper {
        public C0076a(a aVar, Context context) {
            super(context, "d.db", null, 3);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i2 <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }
    }

    public a(Context context) {
        this.f7006c = context;
        this.f7004a = new C0076a(this, context);
        String str = "leroadcfg";
        try {
            context.getSharedPreferences(str, 4).edit();
            context.getSharedPreferences(str, 4).edit();
            context.getSharedPreferences("re_po_rt", 4).edit();
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
        try {
            this.f7005b = this.f7004a.getWritableDatabase();
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f7003e == null) {
                f7003e = new a(context);
            }
            aVar = f7003e;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r11 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r11 != null) goto L_0x001f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            java.lang.String r4 = "b=?"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ all -> 0x0027 }
            r9 = 0
            r5[r9] = r11     // Catch:{ all -> 0x0027 }
            android.database.sqlite.SQLiteDatabase r1 = r10.f7005b     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "c"
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0027 }
            if (r11 == 0) goto L_0x001d
            int r1 = r11.getCount()     // Catch:{ all -> 0x0028 }
            if (r1 <= 0) goto L_0x001d
            r0 = r9
        L_0x001d:
            if (r11 == 0) goto L_0x002e
        L_0x001f:
            r11.close()     // Catch:{ Exception -> 0x0023 }
            goto L_0x002e
        L_0x0023:
            e.c.f.c.d()
            goto L_0x002e
        L_0x0027:
            r11 = 0
        L_0x0028:
            e.c.f.c.d()     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x002e
            goto L_0x001f
        L_0x002e:
            return r0
        L_0x002f:
            r0 = move-exception
            if (r11 == 0) goto L_0x0039
            r11.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0039
        L_0x0036:
            e.c.f.c.d()
        L_0x0039:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.h.a.b(java.lang.String):boolean");
    }

    public final long a(e.c.f.j.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.f1946a, aVar.f7015b);
        contentValues.put("c", Integer.valueOf(aVar.f7016c));
        contentValues.put("d", Long.valueOf(aVar.f7018e));
        contentValues.put("e", Integer.valueOf(aVar.f7020g));
        contentValues.put("g", Integer.valueOf(aVar.f7019f));
        contentValues.put("f", Integer.valueOf(aVar.f7021h));
        contentValues.put("i", Integer.valueOf(aVar.f7022i));
        contentValues.put("j", aVar.f7023j);
        String str = aVar.f7017d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception unused) {
            c.d();
        }
        contentValues.put("h", str);
        try {
            return this.f7005b.insert("r", null, contentValues);
        } catch (Throwable unused2) {
            c.d();
            return -1;
        }
    }

    public final long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.f1946a, str);
        try {
            return this.f7005b.insert("c", null, contentValues);
        } catch (Throwable unused) {
            c.d();
            return -1;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:23|22|24|25|26|27|28|29|30|31|32|35|36|50) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        e.c.f.c.d();
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r8.f7005b.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        f7002d = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0080 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.List<java.lang.Integer> r9) {
        /*
            r8 = this;
            r0 = -1
            android.database.sqlite.SQLiteDatabase r1 = r8.f7005b     // Catch:{ all -> 0x0057 }
            r1.beginTransaction()     // Catch:{ all -> 0x0057 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0057 }
            r1 = r0
        L_0x000b:
            boolean r2 = r9.hasNext()     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r9.next()     // Catch:{ all -> 0x0056 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0056 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r3 = r8.f7005b     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = "r"
            java.lang.String r5 = "a=?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0030 }
            r7 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0030 }
            r6[r7] = r2     // Catch:{ all -> 0x0030 }
            int r1 = r3.delete(r4, r5, r6)     // Catch:{ all -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            e.c.f.c.d()     // Catch:{ all -> 0x0056 }
            r1 = r0
        L_0x0034:
            if (r1 > 0) goto L_0x000b
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0056 }
            f7002d = r2     // Catch:{ all -> 0x0056 }
            goto L_0x000b
        L_0x003d:
            android.database.sqlite.SQLiteDatabase r9 = r8.f7005b     // Catch:{ all -> 0x0056 }
            r9.setTransactionSuccessful()     // Catch:{ all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r9 = r8.f7005b     // Catch:{ all -> 0x0048 }
            r9.endTransaction()     // Catch:{ all -> 0x0048 }
            goto L_0x0078
        L_0x0048:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004f }
            f7002d = r2     // Catch:{ all -> 0x004f }
            goto L_0x0052
        L_0x004f:
            e.c.f.c.d()
        L_0x0052:
            e.c.f.c.d()
            goto L_0x0078
        L_0x0056:
            r0 = r1
        L_0x0057:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005e }
            f7002d = r1     // Catch:{ all -> 0x005e }
            goto L_0x0061
        L_0x005e:
            e.c.f.c.d()     // Catch:{ all -> 0x0079 }
        L_0x0061:
            e.c.f.c.d()     // Catch:{ all -> 0x0079 }
            android.database.sqlite.SQLiteDatabase r9 = r8.f7005b     // Catch:{ all -> 0x006a }
            r9.endTransaction()     // Catch:{ all -> 0x006a }
            goto L_0x0077
        L_0x006a:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0071 }
            f7002d = r1     // Catch:{ all -> 0x0071 }
            goto L_0x0074
        L_0x0071:
            e.c.f.c.d()
        L_0x0074:
            e.c.f.c.d()
        L_0x0077:
            r1 = r0
        L_0x0078:
            return r1
        L_0x0079:
            r9 = move-exception
            android.database.sqlite.SQLiteDatabase r0 = r8.f7005b     // Catch:{ all -> 0x0080 }
            r0.endTransaction()     // Catch:{ all -> 0x0080 }
            goto L_0x008d
        L_0x0080:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
            f7002d = r0     // Catch:{ all -> 0x0087 }
            goto L_0x008a
        L_0x0087:
            e.c.f.c.d()
        L_0x008a:
            e.c.f.c.d()
        L_0x008d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.h.a.a(java.util.List):int");
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v12, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v8, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x014d, code lost:
        if (r7 == 0) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0150, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x015b, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x015f, code lost:
        if (r7 != 0) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0165, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0168, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0143 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0152 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v4
  assigns: []
  uses: []
  mth insns count: 128
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
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079 A[SYNTHETIC, Splitter:B:15:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c A[Catch:{ Exception -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a6 A[Catch:{ Exception -> 0x0152 }, LOOP:0: B:20:0x00a6->B:28:0x0146, LOOP_START] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<e.c.f.j.a> a(int r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            android.content.Context r0 = r1.f7006c
            java.lang.String r6 = "leroadcfg"
            r7 = 0
            r8 = 4
            android.content.SharedPreferences r9 = r0.getSharedPreferences(r6, r8)     // Catch:{ all -> 0x002d }
            r9.edit()     // Catch:{ all -> 0x002d }
            android.content.SharedPreferences r6 = r0.getSharedPreferences(r6, r8)     // Catch:{ all -> 0x002d }
            r6.edit()     // Catch:{ all -> 0x002d }
            java.lang.String r6 = "re_po_rt"
            android.content.SharedPreferences r6 = r0.getSharedPreferences(r6, r8)     // Catch:{ all -> 0x002d }
            r6.edit()     // Catch:{ all -> 0x002b }
            goto L_0x0035
        L_0x002b:
            r0 = move-exception
            goto L_0x002f
        L_0x002d:
            r0 = move-exception
            r6 = r7
        L_0x002f:
            r0.getMessage()
            e.c.f.c.c()
        L_0x0035:
            r0 = 3
            java.lang.String r8 = "re_net_wt"
            int r0 = r6.getInt(r8, r0)
            r8 = 3600000(0x36ee80, float:5.044674E-39)
            int r0 = r0 * r8
            java.lang.String r8 = "(d <= ("
            r9 = 2
            if (r2 != r9) goto L_0x0057
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            r0.append(r4)
            java.lang.String r4 = "-e*3600000) or e=0 )"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            goto L_0x0072
        L_0x0057:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r8)
            r10.append(r4)
            java.lang.String r8 = "-e*3600000) or e=0 ) and (g!=2 or d<="
            r10.append(r8)
            long r11 = (long) r0
            long r4 = r4 - r11
            r10.append(r4)
            java.lang.String r0 = ")"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
        L_0x0072:
            r13 = r0
            java.lang.String r17 = "d desc"
            r0 = 100
            if (r2 != r9) goto L_0x008c
            android.database.sqlite.SQLiteDatabase r10 = r1.f7005b     // Catch:{ Exception -> 0x0152 }
            java.lang.String r11 = "r"
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r18 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x0152 }
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0152 }
        L_0x008a:
            r7 = r0
            goto L_0x00a4
        L_0x008c:
            java.lang.String r2 = "up_nu_li"
            int r0 = r6.getInt(r2, r0)     // Catch:{ Exception -> 0x0152 }
            android.database.sqlite.SQLiteDatabase r10 = r1.f7005b     // Catch:{ Exception -> 0x0152 }
            java.lang.String r11 = "r"
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r18 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x0152 }
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0152 }
            goto L_0x008a
        L_0x00a4:
            if (r7 == 0) goto L_0x014d
        L_0x00a6:
            boolean r0 = r7.moveToNext()     // Catch:{ Exception -> 0x0152 }
            if (r0 == 0) goto L_0x014d
            e.c.f.j.a r0 = new e.c.f.j.a     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "a"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7014a = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "b"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7015b = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "c"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7016c = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "d"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            long r4 = r7.getLong(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7018e = r4     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "g"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7019f = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "e"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7020g = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "f"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7021h = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "i"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7022i = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "j"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0152 }
            r0.f7023j = r2     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = "h"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0152 }
            com.baidu.sofire.ac.F r4 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ Exception -> 0x0143 }
            r5 = 0
            byte[] r5 = android.util.Base64.decode(r2, r5)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r6 = "xVOTuxgN3lkRN2v4"
            java.lang.String r8 = "utf-8"
            byte[] r6 = r6.getBytes(r8)     // Catch:{ Exception -> 0x0143 }
            byte[] r4 = r4.ad(r5, r6)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0143 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0143 }
            r2 = r5
            goto L_0x0146
        L_0x0143:
            e.c.f.c.d()     // Catch:{ Exception -> 0x0152 }
        L_0x0146:
            r0.f7017d = r2     // Catch:{ Exception -> 0x0152 }
            r3.add(r0)     // Catch:{ Exception -> 0x0152 }
            goto L_0x00a6
        L_0x014d:
            if (r7 == 0) goto L_0x015e
            goto L_0x0157
        L_0x0150:
            r0 = move-exception
            goto L_0x015f
        L_0x0152:
            e.c.f.c.d()     // Catch:{ all -> 0x0150 }
            if (r7 == 0) goto L_0x015e
        L_0x0157:
            r7.close()     // Catch:{ Exception -> 0x015b }
            goto L_0x015e
        L_0x015b:
            e.c.f.c.d()
        L_0x015e:
            return r3
        L_0x015f:
            if (r7 == 0) goto L_0x0168
            r7.close()     // Catch:{ Exception -> 0x0165 }
            goto L_0x0168
        L_0x0165:
            e.c.f.c.d()
        L_0x0168:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.h.a.a(int):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r12v5, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r12v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r12v15, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r12v20 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: type inference failed for: r12v23 */
    /* JADX WARNING: type inference failed for: r12v24 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:28|29|48) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0143, code lost:
        if (r10 == 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0146, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0151, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0155, code lost:
        if (r10 != 0) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x015b, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015e, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0139 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0148 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v8
  assigns: []
  uses: []
  mth insns count: 125
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
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c A[Catch:{ Exception -> 0x0148 }, LOOP:0: B:22:0x009c->B:30:0x013c, LOOP_START] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<e.c.f.j.a> a(boolean r12, int r13) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            long r1 = java.lang.System.currentTimeMillis()
            if (r12 == 0) goto L_0x001f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r3 = "(d < ("
            r12.<init>(r3)
            r12.append(r1)
            java.lang.String r1 = "-f*3600000) and f!= 0)"
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            goto L_0x0031
        L_0x001f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r3 = "d<="
            r12.<init>(r3)
            r3 = 259200000(0xf731400, double:1.280618154E-315)
            long r1 = r1 - r3
            r12.append(r1)
            java.lang.String r12 = r12.toString()
        L_0x0031:
            r4 = r12
            java.lang.String r8 = "d desc"
            r12 = 2
            r10 = 0
            if (r13 != r12) goto L_0x0048
            android.database.sqlite.SQLiteDatabase r1 = r11.f7005b     // Catch:{ Exception -> 0x0148 }
            java.lang.String r2 = "r"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r9 = "100"
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0148 }
        L_0x0046:
            r10 = r12
            goto L_0x009a
        L_0x0048:
            android.content.Context r12 = r11.f7006c     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "leroadcfg"
            r1 = 4
            android.content.SharedPreferences r2 = r12.getSharedPreferences(r13, r1)     // Catch:{ all -> 0x0067 }
            r2.edit()     // Catch:{ all -> 0x0067 }
            android.content.SharedPreferences r13 = r12.getSharedPreferences(r13, r1)     // Catch:{ all -> 0x0067 }
            r13.edit()     // Catch:{ all -> 0x0067 }
            java.lang.String r13 = "re_po_rt"
            android.content.SharedPreferences r12 = r12.getSharedPreferences(r13, r1)     // Catch:{ all -> 0x0067 }
            r12.edit()     // Catch:{ all -> 0x0065 }
            goto L_0x0070
        L_0x0065:
            r13 = move-exception
            goto L_0x006a
        L_0x0067:
            r12 = move-exception
            r13 = r12
            r12 = r10
        L_0x006a:
            r13.getMessage()     // Catch:{ Exception -> 0x0148 }
            e.c.f.c.c()     // Catch:{ Exception -> 0x0148 }
        L_0x0070:
            java.lang.String r13 = "up_nu_li"
            r1 = 100
            int r12 = r12.getInt(r13, r1)     // Catch:{ Exception -> 0x0148 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0148 }
            java.lang.String r1 = " 3g limit"
            r13.<init>(r1)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r1 = java.lang.Integer.toString(r12)     // Catch:{ Exception -> 0x0148 }
            r13.append(r1)     // Catch:{ Exception -> 0x0148 }
            e.c.f.c.a()     // Catch:{ Exception -> 0x0148 }
            android.database.sqlite.SQLiteDatabase r1 = r11.f7005b     // Catch:{ Exception -> 0x0148 }
            java.lang.String r2 = "r"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r9 = java.lang.Integer.toString(r12)     // Catch:{ Exception -> 0x0148 }
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0148 }
            goto L_0x0046
        L_0x009a:
            if (r10 == 0) goto L_0x0143
        L_0x009c:
            boolean r12 = r10.moveToNext()     // Catch:{ Exception -> 0x0148 }
            if (r12 == 0) goto L_0x0143
            e.c.f.j.a r12 = new e.c.f.j.a     // Catch:{ Exception -> 0x0148 }
            r12.<init>()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "a"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7014a = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "b"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7015b = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "c"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7016c = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "d"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            long r1 = r10.getLong(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7018e = r1     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "g"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7019f = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "e"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7020g = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "f"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7021h = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "i"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7022i = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "j"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x0148 }
            r12.f7023j = r13     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = "h"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x0148 }
            com.baidu.sofire.ac.F r1 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ Exception -> 0x0139 }
            r2 = 0
            byte[] r2 = android.util.Base64.decode(r13, r2)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = "xVOTuxgN3lkRN2v4"
            java.lang.String r4 = "utf-8"
            byte[] r3 = r3.getBytes(r4)     // Catch:{ Exception -> 0x0139 }
            byte[] r1 = r1.ad(r2, r3)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0139 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0139 }
            r13 = r2
            goto L_0x013c
        L_0x0139:
            e.c.f.c.d()     // Catch:{ Exception -> 0x0148 }
        L_0x013c:
            r12.f7017d = r13     // Catch:{ Exception -> 0x0148 }
            r0.add(r12)     // Catch:{ Exception -> 0x0148 }
            goto L_0x009c
        L_0x0143:
            if (r10 == 0) goto L_0x0154
            goto L_0x014d
        L_0x0146:
            r12 = move-exception
            goto L_0x0155
        L_0x0148:
            e.c.f.c.d()     // Catch:{ all -> 0x0146 }
            if (r10 == 0) goto L_0x0154
        L_0x014d:
            r10.close()     // Catch:{ Exception -> 0x0151 }
            goto L_0x0154
        L_0x0151:
            e.c.f.c.d()
        L_0x0154:
            return r0
        L_0x0155:
            if (r10 == 0) goto L_0x015e
            r10.close()     // Catch:{ Exception -> 0x015b }
            goto L_0x015e
        L_0x015b:
            e.c.f.c.d()
        L_0x015e:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.h.a.a(boolean, int):java.util.List");
    }
}
