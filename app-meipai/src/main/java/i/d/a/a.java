package i.d.a;

import e.c.f.n.n;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: Java6FileApiPermissionsStrategy */
public class a implements e {

    /* renamed from: a reason: collision with root package name */
    public final Method f9870a = n.a(File.class, "canExecute", (Class<?>[]) new Class[0]);

    /* renamed from: b reason: collision with root package name */
    public final Method f9871b;

    /* renamed from: c reason: collision with root package name */
    public final Method f9872c;

    /* renamed from: d reason: collision with root package name */
    public final Method f9873d;

    public a() throws g {
        Class cls = Boolean.TYPE;
        this.f9871b = n.a(File.class, "setExecutable", (Class<?>[]) new Class[]{cls, cls});
        Class cls2 = Boolean.TYPE;
        this.f9873d = n.a(File.class, "setReadable", (Class<?>[]) new Class[]{cls2, cls2});
        Class cls3 = Boolean.TYPE;
        this.f9872c = n.a(File.class, "setWritable", (Class<?>[]) new Class[]{cls3, cls3});
    }

    public d a(File file) {
        d dVar = new d();
        file.isDirectory();
        if (((Boolean) n.a(this.f9870a, (Object) file, new Object[0])).booleanValue()) {
            dVar.f9886c = true;
        }
        if (file.canWrite()) {
            dVar.f9885b = true;
            if (file.isDirectory()) {
                dVar.f9888e = true;
                dVar.f9891h = true;
            }
        }
        if (file.canRead()) {
            dVar.f9884a = true;
            dVar.f9887d = true;
            dVar.f9890g = true;
        }
        return dVar;
    }

    public void a(File file, d dVar) {
        ((Boolean) n.a(this.f9871b, (Object) file, Boolean.valueOf(dVar.f9886c), Boolean.valueOf(!dVar.f9889f && !dVar.f9892i))).booleanValue();
        ((Boolean) n.a(this.f9872c, (Object) file, Boolean.valueOf(dVar.f9885b), Boolean.valueOf(!dVar.f9888e && !dVar.f9891h))).booleanValue();
        ((Boolean) n.a(this.f9873d, (Object) file, Boolean.valueOf(dVar.f9884a), Boolean.valueOf(!dVar.f9887d && !dVar.f9890g))).booleanValue();
    }
}
