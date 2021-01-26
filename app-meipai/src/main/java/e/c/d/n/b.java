package e.c.d.n;

import java.io.File;
import java.util.Comparator;

/* compiled from: lambda */
public final /* synthetic */ class b implements Comparator {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ b f6873a = new b();

    private /* synthetic */ b() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((File) obj).getName().compareTo(((File) obj2).getName());
    }
}
