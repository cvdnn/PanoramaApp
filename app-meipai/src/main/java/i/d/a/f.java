package i.d.a;

import java.io.File;

/* compiled from: ZTFilePermissionsUtil */
public class f {

    /* renamed from: a reason: collision with root package name */
    public static final e f9893a = new a();

    /* renamed from: b reason: collision with root package name */
    public static final e f9894b;

    /* compiled from: ZTFilePermissionsUtil */
    public static class a implements e {
        public d a(File file) {
            return null;
        }

        public void a(File file, d dVar) {
        }
    }

    static {
        e eVar;
        e eVar2 = null;
        try {
            eVar = (e) b.class.newInstance();
        } catch (Exception unused) {
            eVar = null;
        }
        if (eVar == null) {
            try {
                eVar2 = (e) a.class.newInstance();
            } catch (Exception unused2) {
            }
            eVar = eVar2;
        }
        if (eVar == null) {
            eVar = f9893a;
        }
        f9894b = eVar;
    }

    public static int a(d dVar) {
        return a(dVar.f9890g, 4) | a(dVar.f9886c, 64) | 0 | a(dVar.f9889f, 8) | a(dVar.f9892i, 1) | a(dVar.f9885b, 128) | a(dVar.f9888e, 16) | a(dVar.f9891h, 2) | a(dVar.f9884a, 256) | a(dVar.f9887d, 32);
    }

    public static int a(boolean z, int i2) {
        if (z) {
            return i2;
        }
        return 0;
    }

    public static d a(int i2) {
        d dVar = new d();
        boolean z = true;
        dVar.f9886c = (i2 & 64) > 0;
        dVar.f9889f = (i2 & 8) > 0;
        dVar.f9892i = (i2 & 1) > 0;
        dVar.f9885b = (i2 & 128) > 0;
        dVar.f9888e = (i2 & 16) > 0;
        dVar.f9891h = (i2 & 2) > 0;
        dVar.f9884a = (i2 & 256) > 0;
        dVar.f9887d = (i2 & 32) > 0;
        if ((i2 & 4) <= 0) {
            z = false;
        }
        dVar.f9890g = z;
        return dVar;
    }
}
