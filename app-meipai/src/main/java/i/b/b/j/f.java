package i.b.b.j;

import android.database.Cursor;
import i.b.b.a;
import i.b.b.i.d;
import i.b.b.j.h.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: QueryBuilder */
public class f<T> {

    /* renamed from: a reason: collision with root package name */
    public final g<T> f9856a;

    /* renamed from: b reason: collision with root package name */
    public StringBuilder f9857b;

    /* renamed from: c reason: collision with root package name */
    public final List<Object> f9858c = new ArrayList();

    /* renamed from: d reason: collision with root package name */
    public final List<d<T, ?>> f9859d = new ArrayList();

    /* renamed from: e reason: collision with root package name */
    public final a<T, ?> f9860e;

    /* renamed from: f reason: collision with root package name */
    public final String f9861f;

    /* renamed from: g reason: collision with root package name */
    public String f9862g;

    public f(a<T, ?> aVar) {
        this.f9860e = aVar;
        String str = "T";
        this.f9861f = str;
        this.f9856a = new g<>(aVar, str);
        this.f9862g = " COLLATE NOCASE";
    }

    public f<T> a(h hVar, h... hVarArr) {
        g<T> gVar = this.f9856a;
        if (gVar != null) {
            if (hVar instanceof b) {
                gVar.a(((b) hVar).f9868d);
            }
            gVar.f9864b.add(hVar);
            for (h hVar2 : hVarArr) {
                if (hVar2 instanceof b) {
                    gVar.a(((b) hVar2).f9868d);
                }
                gVar.f9864b.add(hVar2);
            }
            return this;
        }
        throw null;
    }

    public final void a(String str, i.b.b.f... fVarArr) {
        for (i.b.b.f fVar : fVarArr) {
            StringBuilder sb = this.f9857b;
            if (sb == null) {
                this.f9857b = new StringBuilder();
            } else if (sb.length() > 0) {
                this.f9857b.append(",");
            }
            StringBuilder sb2 = this.f9857b;
            this.f9856a.a(fVar);
            sb2.append(this.f9861f);
            sb2.append('.');
            sb2.append('\'');
            sb2.append(fVar.f9802e);
            sb2.append('\'');
            if (String.class.equals(fVar.f9799b)) {
                String str2 = this.f9862g;
                if (str2 != null) {
                    this.f9857b.append(str2);
                }
            }
            this.f9857b.append(str);
        }
    }

    public List<T> a() {
        i.b.b.i.a aVar = this.f9860e.f9787a;
        StringBuilder sb = new StringBuilder(d.a(aVar.f9813b, this.f9861f, aVar.f9815d, false));
        String str = this.f9861f;
        this.f9858c.clear();
        for (d dVar : this.f9859d) {
            sb.append(" JOIN ");
            sb.append(dVar.f9849b.f9787a.f9813b);
            sb.append(' ');
            sb.append(dVar.f9852e);
            sb.append(" ON ");
            d.a(sb, dVar.f9848a, dVar.f9850c);
            sb.append('=');
            d.a(sb, dVar.f9852e, dVar.f9851d);
        }
        boolean z = !this.f9856a.f9864b.isEmpty();
        String str2 = " WHERE ";
        if (z) {
            sb.append(str2);
            this.f9856a.a(sb, str, this.f9858c);
        }
        for (d dVar2 : this.f9859d) {
            if (!dVar2.f9853f.f9864b.isEmpty()) {
                if (!z) {
                    sb.append(str2);
                    z = true;
                } else {
                    sb.append(" AND ");
                }
                dVar2.f9853f.a(sb, dVar2.f9852e, this.f9858c);
            }
        }
        StringBuilder sb2 = this.f9857b;
        if (sb2 != null && sb2.length() > 0) {
            sb.append(" ORDER BY ");
            sb.append(this.f9857b);
        }
        String sb3 = sb.toString();
        a<T, ?> aVar2 = this.f9860e;
        Object[] array = this.f9858c.toArray();
        int length = array.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = array[i2];
            if (obj != null) {
                strArr[i2] = obj.toString();
            } else {
                strArr[i2] = null;
            }
        }
        e.b bVar = new e.b(aVar2, sb3, strArr, -1, -1);
        e eVar = (e) bVar.a();
        if (eVar == null) {
            throw null;
        } else if (Thread.currentThread() == eVar.f9843e) {
            Cursor a2 = eVar.f9839a.f9788b.a(eVar.f9841c, eVar.f9842d);
            a<T, ?> aVar3 = eVar.f9840b.f9797a;
            if (aVar3 != null) {
                try {
                    return aVar3.a(a2);
                } finally {
                    a2.close();
                }
            } else {
                throw null;
            }
        } else {
            throw new i.b.b.d("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }
}
