package i.b.b.i;

import i.b.b.d;
import i.b.b.f;
import i.b.b.h.b;
import i.b.b.h.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DaoConfig */
public final class a implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    public final i.b.b.g.a f9812a;

    /* renamed from: b reason: collision with root package name */
    public final String f9813b;

    /* renamed from: c reason: collision with root package name */
    public final f[] f9814c;

    /* renamed from: d reason: collision with root package name */
    public final String[] f9815d;

    /* renamed from: e reason: collision with root package name */
    public final String[] f9816e;

    /* renamed from: f reason: collision with root package name */
    public final String[] f9817f;

    /* renamed from: g reason: collision with root package name */
    public final f f9818g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f9819h;

    /* renamed from: i reason: collision with root package name */
    public final e f9820i;

    /* renamed from: j reason: collision with root package name */
    public i.b.b.h.a<?, ?> f9821j;

    public a(i.b.b.g.a aVar, Class<? extends i.b.b.a<?, ?>> cls) {
        this.f9812a = aVar;
        try {
            f fVar = null;
            this.f9813b = (String) cls.getField("TABLENAME").get(null);
            f[] a2 = a(cls);
            this.f9814c = a2;
            this.f9815d = new String[a2.length];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z = false;
            f fVar2 = null;
            for (int i2 = 0; i2 < a2.length; i2++) {
                f fVar3 = a2[i2];
                String str = fVar3.f9802e;
                this.f9815d[i2] = str;
                if (fVar3.f9801d) {
                    arrayList.add(str);
                    fVar2 = fVar3;
                } else {
                    arrayList2.add(str);
                }
            }
            this.f9817f = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.f9816e = strArr;
            if (strArr.length == 1) {
                fVar = fVar2;
            }
            this.f9818g = fVar;
            this.f9820i = new e(aVar, this.f9813b, this.f9815d, this.f9816e);
            if (this.f9818g != null) {
                Class<?> cls2 = this.f9818g.f9799b;
                if (cls2.equals(Long.TYPE) || cls2.equals(Long.class) || cls2.equals(Integer.TYPE) || cls2.equals(Integer.class) || cls2.equals(Short.TYPE) || cls2.equals(Short.class) || cls2.equals(Byte.TYPE) || cls2.equals(Byte.class)) {
                    z = true;
                }
                this.f9819h = z;
                return;
            }
            this.f9819h = false;
        } catch (Exception e2) {
            throw new d("Could not init DAOConfig", e2);
        }
    }

    public static f[] a(Class<? extends i.b.b.a<?, ?>> cls) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("$Properties");
        Field[] declaredFields = Class.forName(sb.toString()).getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 9) == 9) {
                Object obj = field.get(null);
                if (obj instanceof f) {
                    arrayList.add((f) obj);
                }
            }
        }
        f[] fVarArr = new f[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            int i2 = fVar.f9798a;
            if (fVarArr[i2] == null) {
                fVarArr[i2] = fVar;
            } else {
                throw new d("Duplicate property ordinals");
            }
        }
        return fVarArr;
    }

    public Object clone() throws CloneNotSupportedException {
        return new a(this);
    }

    public void a(i.b.b.h.d dVar) {
        if (dVar == i.b.b.h.d.None) {
            this.f9821j = null;
        } else if (dVar != i.b.b.h.d.Session) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported type: ");
            sb.append(dVar);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f9819h) {
            this.f9821j = new b();
        } else {
            this.f9821j = new c();
        }
    }

    public a(a aVar) {
        this.f9812a = aVar.f9812a;
        this.f9813b = aVar.f9813b;
        this.f9814c = aVar.f9814c;
        this.f9815d = aVar.f9815d;
        this.f9816e = aVar.f9816e;
        this.f9817f = aVar.f9817f;
        this.f9818g = aVar.f9818g;
        this.f9820i = aVar.f9820i;
        this.f9819h = aVar.f9819h;
    }
}
