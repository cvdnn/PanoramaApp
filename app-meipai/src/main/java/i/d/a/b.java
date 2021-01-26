package i.d.a;

import e.c.f.n.n;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Java7Nio2ApiPermissionsStrategy */
public class b implements e {

    /* renamed from: a reason: collision with root package name */
    public final Class<? extends Enum<?>> f9874a;

    /* renamed from: b reason: collision with root package name */
    public final Class<?> f9875b;

    /* renamed from: c reason: collision with root package name */
    public final Class<?> f9876c;

    /* renamed from: d reason: collision with root package name */
    public final Class<? extends Enum<?>> f9877d;

    /* renamed from: e reason: collision with root package name */
    public final Enum<?>[] f9878e;

    /* renamed from: f reason: collision with root package name */
    public final Method f9879f;

    /* renamed from: g reason: collision with root package name */
    public final Method f9880g;

    /* renamed from: h reason: collision with root package name */
    public final Method f9881h;

    /* renamed from: i reason: collision with root package name */
    public final Object f9882i;

    /* renamed from: j reason: collision with root package name */
    public final Object f9883j;
    public final Object k;
    public final Object l;
    public final Object m;
    public final Object n;
    public final Object o;
    public final Object p;
    public final Object q;

    public b() {
        Class<Object> cls = Object.class;
        if (((Set) n.a(n.a(n.a("java.nio.file.FileSystem", cls), "supportedFileAttributeViews", (Class<?>[]) new Class[0]), n.a(n.a(n.a("java.nio.file.FileSystems", cls), "getDefault", (Class<?>[]) new Class[0]), (Object) null, new Object[0]), new Object[0])).contains("posix")) {
            Class<? extends Enum<?>> a2 = n.a("java.nio.file.attribute.PosixFilePermission", Enum.class);
            this.f9874a = a2;
            Enum[] enumArr = (Enum[]) a2.getEnumConstants();
            this.f9882i = enumArr[0];
            this.f9883j = enumArr[1];
            this.k = enumArr[2];
            this.l = enumArr[3];
            this.m = enumArr[4];
            this.n = enumArr[5];
            this.o = enumArr[6];
            this.p = enumArr[7];
            this.q = enumArr[8];
            Class<? extends Enum<?>> a3 = n.a("java.nio.file.LinkOption", Enum.class);
            this.f9877d = a3;
            Enum<?>[] enumArr2 = (Enum[]) Array.newInstance(a3, 1);
            this.f9878e = enumArr2;
            enumArr2[0] = ((Enum[]) this.f9877d.getEnumConstants())[0];
            this.f9875b = n.a("java.nio.file.Files", cls);
            this.f9876c = n.a("java.nio.file.Path", cls);
            this.f9879f = n.a(File.class, "toPath", (Class<?>[]) new Class[0]);
            this.f9880g = n.a(this.f9875b, "setPosixFilePermissions", (Class<?>[]) new Class[]{this.f9876c, Set.class});
            this.f9881h = n.a(this.f9875b, "getPosixFilePermissions", (Class<?>[]) new Class[]{this.f9876c, this.f9878e.getClass()});
            return;
        }
        throw new g("File system does not support POSIX file attributes");
    }

    public d a(File file) {
        d dVar = new d();
        file.isDirectory();
        Set set = (Set) n.a(this.f9881h, (Object) null, n.a(this.f9879f, (Object) file, new Object[0]), this.f9878e);
        dVar.f9884a = set.contains(this.f9882i);
        dVar.f9885b = set.contains(this.f9883j);
        dVar.f9886c = set.contains(this.k);
        dVar.f9887d = set.contains(this.l);
        dVar.f9888e = set.contains(this.m);
        dVar.f9889f = set.contains(this.n);
        dVar.f9890g = set.contains(this.o);
        dVar.f9891h = set.contains(this.p);
        dVar.f9892i = set.contains(this.q);
        return dVar;
    }

    public void a(File file, d dVar) {
        HashSet hashSet = new HashSet();
        boolean z = dVar.f9884a;
        Object obj = this.f9882i;
        if (z) {
            hashSet.add(obj);
        }
        boolean z2 = dVar.f9884a;
        Object obj2 = this.f9882i;
        if (z2) {
            hashSet.add(obj2);
        }
        boolean z3 = dVar.f9885b;
        Object obj3 = this.f9883j;
        if (z3) {
            hashSet.add(obj3);
        }
        boolean z4 = dVar.f9886c;
        Object obj4 = this.k;
        if (z4) {
            hashSet.add(obj4);
        }
        boolean z5 = dVar.f9887d;
        Object obj5 = this.l;
        if (z5) {
            hashSet.add(obj5);
        }
        boolean z6 = dVar.f9888e;
        Object obj6 = this.m;
        if (z6) {
            hashSet.add(obj6);
        }
        boolean z7 = dVar.f9889f;
        Object obj7 = this.n;
        if (z7) {
            hashSet.add(obj7);
        }
        boolean z8 = dVar.f9890g;
        Object obj8 = this.o;
        if (z8) {
            hashSet.add(obj8);
        }
        boolean z9 = dVar.f9891h;
        Object obj9 = this.p;
        if (z9) {
            hashSet.add(obj9);
        }
        boolean z10 = dVar.f9892i;
        Object obj10 = this.q;
        if (z10) {
            hashSet.add(obj10);
        }
        n.a(this.f9880g, (Object) null, n.a(this.f9879f, (Object) file, new Object[0]), hashSet);
    }
}
