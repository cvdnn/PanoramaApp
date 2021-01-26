package i.b.b;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import i.b.b.g.d;
import i.b.b.h.b;
import i.b.b.i.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: AbstractDao */
public abstract class a<T, K> {

    /* renamed from: a reason: collision with root package name */
    public final i.b.b.i.a f9787a;

    /* renamed from: b reason: collision with root package name */
    public final i.b.b.g.a f9788b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f9789c;

    /* renamed from: d reason: collision with root package name */
    public final i.b.b.h.a<K, T> f9790d;

    /* renamed from: e reason: collision with root package name */
    public final b<T> f9791e;

    /* renamed from: f reason: collision with root package name */
    public final e f9792f;

    /* renamed from: g reason: collision with root package name */
    public final int f9793g;

    public a(i.b.b.i.a aVar, c cVar) {
        this.f9787a = aVar;
        i.b.b.g.a aVar2 = aVar.f9812a;
        this.f9788b = aVar2;
        this.f9789c = aVar2.b() instanceof SQLiteDatabase;
        i.b.b.h.a<?, ?> aVar3 = aVar.f9821j;
        this.f9790d = aVar3;
        if (aVar3 instanceof b) {
            this.f9791e = (b) aVar3;
        } else {
            this.f9791e = null;
        }
        this.f9792f = aVar.f9820i;
        f fVar = aVar.f9818g;
        this.f9793g = fVar != null ? fVar.f9798a : -1;
    }

    public abstract T a(Cursor cursor, int i2);

    public abstract K a(T t, long j2);

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<T> a(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto L_0x000c
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        L_0x000c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            boolean r3 = r7 instanceof android.database.CrossProcessCursor
            r4 = 0
            if (r3 == 0) goto L_0x0049
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L_0x0049
            int r3 = r2.getNumRows()
            if (r3 != r0) goto L_0x002d
            i.b.b.i.b r7 = new i.b.b.i.b
            r7.<init>(r2)
            r3 = 1
            goto L_0x004a
        L_0x002d:
            java.lang.String r3 = "Window vs. result size: "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            int r5 = r2.getNumRows()
            r3.append(r5)
            java.lang.String r5 = "/"
            r3.append(r5)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            e.c.f.n.n.a(r3)
        L_0x0049:
            r3 = r4
        L_0x004a:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L_0x0086
            i.b.b.h.a<K, T> r5 = r6.f9790d
            if (r5 == 0) goto L_0x005c
            r5.lock()
            i.b.b.h.a<K, T> r5 = r6.f9790d
            r5.a(r0)
        L_0x005c:
            if (r3 != 0) goto L_0x0068
            if (r2 == 0) goto L_0x0068
            i.b.b.h.a<K, T> r0 = r6.f9790d     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0068
            r6.a(r7, r2, r1)     // Catch:{ all -> 0x007d }
            goto L_0x0075
        L_0x0068:
            java.lang.Object r0 = r6.a(r7, r4, r4)     // Catch:{ all -> 0x007d }
            r1.add(r0)     // Catch:{ all -> 0x007d }
            boolean r0 = r7.moveToNext()     // Catch:{ all -> 0x007d }
            if (r0 != 0) goto L_0x0068
        L_0x0075:
            i.b.b.h.a<K, T> r7 = r6.f9790d
            if (r7 == 0) goto L_0x0086
            r7.unlock()
            goto L_0x0086
        L_0x007d:
            r7 = move-exception
            i.b.b.h.a<K, T> r0 = r6.f9790d
            if (r0 == 0) goto L_0x0085
            r0.unlock()
        L_0x0085:
            throw r7
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.b.a.a(android.database.Cursor):java.util.List");
    }

    public abstract void a(SQLiteStatement sQLiteStatement, T t);

    public abstract void a(d dVar, T t);

    public final long b(T t, d dVar) {
        synchronized (dVar) {
            if (this.f9789c) {
                SQLiteStatement sQLiteStatement = dVar.f9804a;
                a(sQLiteStatement, t);
                long executeInsert = sQLiteStatement.executeInsert();
                return executeInsert;
            }
            a(dVar, t);
            long executeInsert2 = dVar.f9804a.executeInsert();
            return executeInsert2;
        }
    }

    public abstract K b(Cursor cursor, int i2);

    public abstract K b(T t);

    public long c(T t) {
        long j2;
        d b2 = this.f9792f.b();
        if (this.f9788b.d()) {
            j2 = b(t, b2);
        } else {
            this.f9788b.a();
            try {
                j2 = b(t, b2);
                this.f9788b.c();
            } finally {
                this.f9788b.e();
            }
        }
        if (j2 != -1) {
            a((K) a(t, j2), t, true);
        } else {
            Log.w("greenDAO", "Could not insert row (executeInsert returned -1)");
        }
        return j2;
    }

    public void d(T t) {
        a();
        d c2 = this.f9792f.c();
        if (this.f9788b.d()) {
            synchronized (c2) {
                if (this.f9789c) {
                    a(t, c2.f9804a, true);
                } else {
                    a(t, c2, true);
                }
            }
            return;
        }
        this.f9788b.a();
        try {
            synchronized (c2) {
                a(t, c2, true);
            }
            this.f9788b.c();
            this.f9788b.e();
        } catch (Throwable th) {
            this.f9788b.e();
            throw th;
        }
    }

    public final void a(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int numRows = cursorWindow.getNumRows() + cursorWindow.getStartPosition();
        int i2 = 0;
        while (true) {
            list.add(a(cursor, 0, false));
            int i3 = i2 + 1;
            if (i3 >= numRows) {
                this.f9790d.unlock();
                try {
                    CursorWindow window = cursor.moveToNext() ? ((CrossProcessCursor) cursor).getWindow() : null;
                    if (window != null) {
                        numRows = window.getNumRows() + window.getStartPosition();
                    } else {
                        return;
                    }
                } finally {
                    this.f9790d.lock();
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i2 = i3 + 1;
        }
    }

    public final T a(Cursor cursor, int i2, boolean z) {
        Object obj;
        Object obj2 = null;
        if (this.f9791e != null) {
            if (i2 != 0 && cursor.isNull(this.f9793g + i2)) {
                return null;
            }
            long j2 = cursor.getLong(this.f9793g + i2);
            b<T> bVar = this.f9791e;
            if (z) {
                obj = bVar.a(j2);
            } else {
                Reference reference = (Reference) bVar.f9805a.a(j2);
                if (reference != null) {
                    obj2 = reference.get();
                }
                obj = obj2;
            }
            if (obj != null) {
                return obj;
            }
            T a2 = a(cursor, i2);
            if (z) {
                this.f9791e.a(j2, a2);
            } else {
                this.f9791e.f9805a.a(j2, new WeakReference(a2));
            }
            return a2;
        } else if (this.f9790d != null) {
            Object b2 = b(cursor, i2);
            if (i2 != 0 && b2 == null) {
                return null;
            }
            i.b.b.h.a<K, T> aVar = this.f9790d;
            T a3 = z ? aVar.get(b2) : aVar.a(b2);
            if (a3 != null) {
                return a3;
            }
            T a4 = a(cursor, i2);
            a((K) b2, a4, z);
            return a4;
        } else if (i2 == 0 || b(cursor, i2) != null) {
            return a(cursor, i2);
        } else {
            return null;
        }
    }

    public void a(K k) {
        a();
        d a2 = this.f9792f.a();
        if (this.f9788b.d()) {
            synchronized (a2) {
                a(k, a2);
            }
        } else {
            this.f9788b.a();
            try {
                synchronized (a2) {
                    a(k, a2);
                }
                this.f9788b.c();
                this.f9788b.e();
            } catch (Throwable th) {
                this.f9788b.e();
                throw th;
            }
        }
        i.b.b.h.a<K, T> aVar = this.f9790d;
        if (aVar != null) {
            aVar.remove(k);
        }
    }

    public final void a(K k, d dVar) {
        if (k instanceof Long) {
            dVar.f9804a.bindLong(1, ((Long) k).longValue());
        } else if (k != null) {
            dVar.f9804a.bindString(1, k.toString());
        } else {
            throw new d("Cannot delete entity, key is null");
        }
        dVar.f9804a.execute();
    }

    public void a(T t, d dVar, boolean z) {
        a(dVar, t);
        int length = this.f9787a.f9815d.length + 1;
        Object b2 = b(t);
        if (b2 instanceof Long) {
            dVar.f9804a.bindLong(length, ((Long) b2).longValue());
        } else if (b2 != null) {
            dVar.f9804a.bindString(length, b2.toString());
        } else {
            throw new d("Cannot update entity without key - was it inserted before?");
        }
        dVar.f9804a.execute();
        a((K) b2, t, z);
    }

    public void a(T t, SQLiteStatement sQLiteStatement, boolean z) {
        a(sQLiteStatement, t);
        int length = this.f9787a.f9815d.length + 1;
        Object b2 = b(t);
        if (b2 instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) b2).longValue());
        } else if (b2 != null) {
            sQLiteStatement.bindString(length, b2.toString());
        } else {
            throw new d("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        a((K) b2, t, z);
    }

    public final void a(K k, T t, boolean z) {
        i.b.b.h.a<K, T> aVar = this.f9790d;
        if (aVar != null && k != null) {
            if (z) {
                aVar.put(k, t);
            } else {
                aVar.a(k, t);
            }
        }
    }

    public void a() {
        if (this.f9787a.f9816e.length != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            throw new d(e.a.a.a.a.a(sb, this.f9787a.f9813b, ") does not have a single-column primary key"));
        }
    }
}
