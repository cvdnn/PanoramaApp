package i.d.a.j;

import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* compiled from: ExtraFieldUtils */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final Map<f, Class<?>> f9907a = new ConcurrentHashMap();

    static {
        Class<a> cls = a.class;
        try {
            f9907a.put(((d) cls.newInstance()).a(), cls);
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls);
            sb.append(" doesn't implement ZipExtraField");
            throw new RuntimeException(sb.toString());
        } catch (InstantiationException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls);
            sb2.append(" is not a concrete class");
            throw new RuntimeException(sb2.toString());
        } catch (IllegalAccessException unused3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls);
            sb3.append("'s no-arg constructor is not public");
            throw new RuntimeException(sb3.toString());
        }
    }

    public static d a(f fVar) throws InstantiationException, IllegalAccessException {
        Class cls = (Class) f9907a.get(fVar);
        if (cls != null) {
            return (d) cls.newInstance();
        }
        c cVar = new c();
        cVar.f9908a = fVar;
        return cVar;
    }

    public static List<d> a(byte[] bArr) throws ZipException {
        ArrayList arrayList = new ArrayList();
        if (bArr == null) {
            return arrayList;
        }
        int i2 = 0;
        while (i2 <= bArr.length - 4) {
            f fVar = new f(bArr, i2);
            int a2 = f.a(bArr, i2 + 2);
            int i3 = i2 + 4;
            if (i3 + a2 <= bArr.length) {
                try {
                    d a3 = a(fVar);
                    a3.a(bArr, i3, a2);
                    arrayList.add(a3);
                    i2 += a2 + 4;
                } catch (InstantiationException e2) {
                    throw new ZipException(e2.getMessage());
                } catch (IllegalAccessException e3) {
                    throw new ZipException(e3.getMessage());
                }
            } else {
                StringBuilder a4 = a.a("bad extra field starting at ", i2, ".  Block length of ", a2, " bytes exceeds remaining data of ");
                a4.append((bArr.length - i2) - 4);
                a4.append(" bytes.");
                throw new ZipException(a4.toString());
            }
        }
        return arrayList;
    }

    public static byte[] a(List<d> list) {
        int size = list.size() * 4;
        for (d b2 : list) {
            size += b2.b().f9911a;
        }
        byte[] bArr = new byte[size];
        int i2 = 0;
        for (d dVar : list) {
            System.arraycopy(dVar.a().a(), 0, bArr, i2, 2);
            System.arraycopy(dVar.b().a(), 0, bArr, i2 + 2, 2);
            byte[] c2 = dVar.c();
            System.arraycopy(c2, 0, bArr, i2 + 4, c2.length);
            i2 += c2.length + 4;
        }
        return bArr;
    }
}
