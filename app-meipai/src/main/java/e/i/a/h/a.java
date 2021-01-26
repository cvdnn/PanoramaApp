package e.i.a.h;

import java.io.File;

/* compiled from: IdentifiedTask */
public abstract class a {

    /* renamed from: a reason: collision with root package name */
    public static final File f8690a = new File("");

    public abstract String a();

    public boolean a(a aVar) {
        boolean z = false;
        if (!e().equals(aVar.e())) {
            return false;
        }
        if (!e().equals("") && !c().equals(f8690a)) {
            if (d().equals(aVar.d())) {
                return true;
            }
            if (!c().equals(aVar.c())) {
                return false;
            }
            String a2 = a();
            String a3 = aVar.a();
            if (!(a3 == null || a2 == null || !a3.equals(a2))) {
                z = true;
            }
        }
        return z;
    }

    public abstract int b();

    public abstract File c();

    public abstract File d();

    public abstract String e();
}
