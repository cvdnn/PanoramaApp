package e.f.a.a.a;

import android.database.Cursor;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MigrationHelper */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static WeakReference<C0105a> f8026a;

    /* renamed from: e.f.a.a.a.a$a reason: collision with other inner class name */
    /* compiled from: MigrationHelper */
    public interface C0105a {
        void a(i.b.b.g.a aVar, boolean z);

        void b(i.b.b.g.a aVar, boolean z);
    }

    /* compiled from: MigrationHelper */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public int f8027a;

        /* renamed from: b reason: collision with root package name */
        public String f8028b;

        /* renamed from: c reason: collision with root package name */
        public String f8029c;

        /* renamed from: d reason: collision with root package name */
        public boolean f8030d;

        /* renamed from: e reason: collision with root package name */
        public String f8031e;

        /* renamed from: f reason: collision with root package name */
        public boolean f8032f;

        public static /* synthetic */ List a(i.b.b.g.a aVar, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("PRAGMA table_info(`");
            sb.append(str);
            sb.append("`)");
            Cursor a2 = aVar.a(sb.toString(), null);
            if (a2 == null) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            while (a2.moveToNext()) {
                b bVar = new b();
                boolean z = false;
                bVar.f8027a = a2.getInt(0);
                bVar.f8028b = a2.getString(1);
                bVar.f8029c = a2.getString(2);
                bVar.f8030d = a2.getInt(3) == 1;
                bVar.f8031e = a2.getString(4);
                if (a2.getInt(5) == 1) {
                    z = true;
                }
                bVar.f8032f = z;
                arrayList.add(bVar);
            }
            a2.close();
            return arrayList;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj != null && b.class == obj.getClass() && this.f8028b.equals(((b) obj).f8028b));
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("TableInfo{cid=");
            a2.append(this.f8027a);
            a2.append(", name='");
            e.a.a.a.a.a(a2, this.f8028b, '\'', ", type='");
            e.a.a.a.a.a(a2, this.f8029c, '\'', ", notnull=");
            a2.append(this.f8030d);
            a2.append(", dfltValue='");
            e.a.a.a.a.a(a2, this.f8031e, '\'', ", pk=");
            a2.append(this.f8032f);
            a2.append('}');
            return a2.toString();
        }
    }

    public static boolean a(i.b.b.g.a aVar, boolean z, String str) {
        int i2;
        boolean z2 = false;
        if (aVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            Cursor a2 = aVar.a(e.a.a.a.a.a("SELECT COUNT(*) FROM `", z ? "sqlite_temp_master" : "sqlite_master", "` WHERE type = ? AND name = ?"), new String[]{"table", str});
            if (a2 != null) {
                if (a2.moveToFirst()) {
                    i2 = a2.getInt(0);
                    a2.close();
                    if (i2 > 0) {
                        z2 = true;
                    }
                    return z2;
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            i2 = 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static void a(i.b.b.g.a aVar, String str, boolean z, Class<? extends i.b.b.a<?, ?>>... clsArr) {
        if (clsArr.length >= 1) {
            try {
                for (Class<? extends i.b.b.a<?, ?>> declaredMethod : clsArr) {
                    declaredMethod.getDeclaredMethod(str, new Class[]{i.b.b.g.a.class, Boolean.TYPE}).invoke(null, new Object[]{aVar, Boolean.valueOf(z)});
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
    }
}
