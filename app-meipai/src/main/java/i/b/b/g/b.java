package i.b.b.g;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.UploadInfoDao;
import e.f.a.a.a.a;
import e.f.a.a.a.a.C0105a;
import i.b.b.d;
import i.b.b.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DatabaseOpenHelper */
public abstract class b extends SQLiteOpenHelper {
    public b(Context context, String str, CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c cVar = new c(sQLiteDatabase);
        Log.i("greenDAO", "Creating tables for schema version 2");
        UploadInfoDao.createTable(cVar, false);
        LocalTaskDao.createTable(cVar, false);
        PanoTaskDao.createTable(cVar, false);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Class[] clsArr;
        int i4;
        Class<Byte> cls;
        String str7;
        Class<Short> cls2;
        Class<Byte> cls3;
        Iterator it;
        String str8;
        String str9;
        String str10;
        c cVar = new c(sQLiteDatabase);
        int i5 = 3;
        Class[] clsArr2 = {LocalTaskDao.class, PanoTaskDao.class, UploadInfoDao.class};
        a.f8026a = new WeakReference<>(new e.c.d.f.c.a((e.c.d.f.c.b) this));
        Class<Byte> cls4 = Byte.class;
        Class<Short> cls5 = Short.class;
        Class<Integer> cls6 = Integer.class;
        Class<Long> cls7 = Long.class;
        int i6 = 0;
        while (true) {
            str = ",";
            str2 = ";";
            str3 = "MigrationHelper";
            str4 = "_TEMP";
            str5 = "Could not init DAOConfig";
            str6 = "TABLENAME";
            if (i6 >= i5) {
                break;
            }
            Class cls8 = clsArr2[i6];
            try {
                String str11 = (String) cls8.getField(str6).get(null);
                f[] a2 = i.b.b.i.a.a(cls8);
                int length = a2.length;
                String[] strArr = new String[length];
                Class[] clsArr3 = clsArr2;
                ArrayList arrayList = new ArrayList();
                str9 = str5;
                try {
                    ArrayList arrayList2 = new ArrayList();
                    int i7 = i6;
                    String str12 = str3;
                    int i8 = 0;
                    f fVar = null;
                    while (i8 < a2.length) {
                        f fVar2 = a2[i8];
                        f[] fVarArr = a2;
                        String str13 = fVar2.f9802e;
                        strArr[i8] = str13;
                        String str14 = str;
                        if (fVar2.f9801d) {
                            arrayList.add(str13);
                            fVar = fVar2;
                        } else {
                            arrayList2.add(str13);
                        }
                        i8++;
                        a2 = fVarArr;
                        str = str14;
                    }
                    String str15 = str;
                    String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    f fVar3 = ((String[]) arrayList.toArray(new String[arrayList.size()])).length == 1 ? fVar : null;
                    if (fVar3 != null) {
                        Class<?> cls9 = fVar3.f9799b;
                        if (!cls9.equals(Long.TYPE) && !cls9.equals(cls7) && !cls9.equals(Integer.TYPE) && !cls9.equals(cls6) && !cls9.equals(Short.TYPE) && !cls9.equals(cls5) && !cls9.equals(Byte.TYPE)) {
                            cls9.equals(cls4);
                        }
                    }
                    if (a.a(cVar, false, str11)) {
                        try {
                            String concat = str11.concat(str4);
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append("DROP TABLE IF EXISTS ");
                                sb.append(concat);
                                sb.append(str2);
                                cVar.a(sb.toString());
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("CREATE TEMPORARY TABLE ");
                                sb2.append(concat);
                                sb2.append(" AS SELECT * FROM `");
                                sb2.append(str11);
                                sb2.append("`;");
                                cVar.a(sb2.toString());
                                StringBuilder sb3 = new StringBuilder();
                                int i9 = 0;
                                while (i9 < length) {
                                    sb3.append(strArr[i9]);
                                    String str16 = str15;
                                    sb3.append(str16);
                                    i9++;
                                    str15 = str16;
                                }
                                if (sb3.length() > 0) {
                                    sb3.deleteCharAt(sb3.length() - 1);
                                }
                                sb3.toString();
                            } catch (SQLException e2) {
                                e = e2;
                                str10 = concat;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("【Failed to generate temp table】");
                                sb4.append(str10);
                                Log.e(str12, sb4.toString(), e);
                                i6 = i7 + 1;
                                clsArr2 = clsArr3;
                                i5 = 3;
                            }
                        } catch (SQLException e3) {
                            e = e3;
                            str10 = null;
                            StringBuilder sb42 = new StringBuilder();
                            sb42.append("【Failed to generate temp table】");
                            sb42.append(str10);
                            Log.e(str12, sb42.toString(), e);
                            i6 = i7 + 1;
                            clsArr2 = clsArr3;
                            i5 = 3;
                        }
                    }
                    i6 = i7 + 1;
                    clsArr2 = clsArr3;
                    i5 = 3;
                } catch (Exception e4) {
                    e = e4;
                    throw new d(str9, e);
                }
            } catch (Exception e5) {
                e = e5;
                str9 = str5;
                throw new d(str9, e);
            }
        }
        Class[] clsArr4 = clsArr2;
        String str17 = str;
        String str18 = str3;
        String str19 = str5;
        WeakReference<C0105a> weakReference = a.f8026a;
        C0105a aVar = weakReference != null ? (C0105a) weakReference.get() : null;
        if (aVar != null) {
            aVar.b(cVar, true);
            i4 = 0;
            aVar.a(cVar, false);
            clsArr = clsArr4;
        } else {
            i4 = 0;
            clsArr = clsArr4;
            a.a(cVar, "dropTable", true, clsArr);
            a.a(cVar, "createTable", false, clsArr);
        }
        int i10 = i4;
        while (i10 < 3) {
            Class cls10 = clsArr[i10];
            try {
                String str20 = (String) cls10.getField(str6).get(null);
                f[] a3 = i.b.b.i.a.a(cls10);
                String[] strArr3 = new String[a3.length];
                String str21 = str6;
                ArrayList arrayList3 = new ArrayList();
                Class[] clsArr5 = clsArr;
                ArrayList arrayList4 = new ArrayList();
                str7 = str19;
                int i11 = i10;
                int i12 = 0;
                f fVar4 = null;
                while (i12 < a3.length) {
                    try {
                        f fVar5 = a3[i12];
                        f[] fVarArr2 = a3;
                        String str22 = fVar5.f9802e;
                        strArr3[i12] = str22;
                        String[] strArr4 = strArr3;
                        if (fVar5.f9801d) {
                            arrayList3.add(str22);
                            fVar4 = fVar5;
                        } else {
                            arrayList4.add(str22);
                        }
                        i12++;
                        a3 = fVarArr2;
                        strArr3 = strArr4;
                    } catch (Exception e6) {
                        e = e6;
                        throw new d(str7, e);
                    }
                }
                String[] strArr5 = (String[]) arrayList4.toArray(new String[arrayList4.size()]);
                f fVar6 = ((String[]) arrayList3.toArray(new String[arrayList3.size()])).length == 1 ? fVar4 : null;
                if (fVar6 != null) {
                    Class<?> cls11 = fVar6.f9799b;
                    if (!cls11.equals(Long.TYPE) && !cls11.equals(cls7) && !cls11.equals(Integer.TYPE) && !cls11.equals(cls6) && !cls11.equals(Short.TYPE) && !cls11.equals(cls5) && !cls11.equals(Byte.TYPE)) {
                        cls11.equals(cls);
                    }
                }
                String concat2 = str20.concat(str4);
                if (!a.a(cVar, true, concat2)) {
                    cls3 = cls;
                    cls2 = cls5;
                } else {
                    try {
                        List a4 = e.f.a.a.a.a.b.a(cVar, str20);
                        List a5 = e.f.a.a.a.a.b.a(cVar, concat2);
                        ArrayList arrayList5 = new ArrayList(a4.size());
                        ArrayList arrayList6 = new ArrayList(a4.size());
                        Iterator it2 = a5.iterator();
                        while (true) {
                            cls3 = cls;
                            if (!it2.hasNext()) {
                                break;
                            }
                            try {
                                e.f.a.a.a.a.b bVar = (e.f.a.a.a.a.b) it2.next();
                                if (a4.contains(bVar)) {
                                    Iterator it3 = it2;
                                    StringBuilder sb5 = new StringBuilder();
                                    cls2 = cls5;
                                    try {
                                        sb5.append('`');
                                        sb5.append(bVar.f8028b);
                                        sb5.append('`');
                                        String sb6 = sb5.toString();
                                        arrayList6.add(sb6);
                                        arrayList5.add(sb6);
                                        it2 = it3;
                                        cls = cls3;
                                        cls5 = cls2;
                                    } catch (SQLException e7) {
                                        e = e7;
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("【Failed to restore data from temp table 】");
                                        sb7.append(concat2);
                                        Log.e(str18, sb7.toString(), e);
                                        i10 = i11 + 1;
                                        str6 = str21;
                                        clsArr = clsArr5;
                                        str19 = str7;
                                        cls4 = cls3;
                                        cls5 = cls2;
                                    }
                                } else {
                                    cls = cls3;
                                }
                            } catch (SQLException e8) {
                                e = e8;
                                cls2 = cls5;
                                StringBuilder sb72 = new StringBuilder();
                                sb72.append("【Failed to restore data from temp table 】");
                                sb72.append(concat2);
                                Log.e(str18, sb72.toString(), e);
                                i10 = i11 + 1;
                                str6 = str21;
                                clsArr = clsArr5;
                                str19 = str7;
                                cls4 = cls3;
                                cls5 = cls2;
                            }
                        }
                        cls2 = cls5;
                        Iterator it4 = a4.iterator();
                        while (it4.hasNext()) {
                            e.f.a.a.a.a.b bVar2 = (e.f.a.a.a.a.b) it4.next();
                            if (bVar2.f8030d && !a5.contains(bVar2)) {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append('`');
                                sb8.append(bVar2.f8028b);
                                sb8.append('`');
                                String sb9 = sb8.toString();
                                arrayList6.add(sb9);
                                if (bVar2.f8031e != null) {
                                    StringBuilder sb10 = new StringBuilder();
                                    it = it4;
                                    sb10.append("'");
                                    sb10.append(bVar2.f8031e);
                                    sb10.append("' AS ");
                                    str8 = sb10.toString();
                                } else {
                                    it = it4;
                                    str8 = "'' AS ";
                                }
                                StringBuilder sb11 = new StringBuilder();
                                sb11.append(str8);
                                sb11.append(sb9);
                                arrayList5.add(sb11.toString());
                                it4 = it;
                            }
                        }
                        if (arrayList6.size() != 0) {
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append("REPLACE INTO `");
                            sb12.append(str20);
                            sb12.append("` (");
                            sb12.append(TextUtils.join(str17, arrayList6));
                            sb12.append(") SELECT ");
                            sb12.append(TextUtils.join(str17, arrayList5));
                            sb12.append(" FROM ");
                            sb12.append(concat2);
                            sb12.append(str2);
                            cVar.a(sb12.toString());
                        }
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("DROP TABLE ");
                        sb13.append(concat2);
                        cVar.a(sb13.toString());
                    } catch (SQLException e9) {
                        e = e9;
                        cls3 = cls;
                        cls2 = cls5;
                        StringBuilder sb722 = new StringBuilder();
                        sb722.append("【Failed to restore data from temp table 】");
                        sb722.append(concat2);
                        Log.e(str18, sb722.toString(), e);
                        i10 = i11 + 1;
                        str6 = str21;
                        clsArr = clsArr5;
                        str19 = str7;
                        cls4 = cls3;
                        cls5 = cls2;
                    }
                }
                i10 = i11 + 1;
                str6 = str21;
                clsArr = clsArr5;
                str19 = str7;
                cls4 = cls3;
                cls5 = cls2;
            } catch (Exception e10) {
                e = e10;
                str7 = str19;
                throw new d(str7, e);
            }
        }
    }
}
