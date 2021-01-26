package d.q.a;

import d.p.h;
import d.p.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager */
public abstract class a {
    public static <T extends h & u> a a(T t) {
        return new b(t, ((u) t).getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
