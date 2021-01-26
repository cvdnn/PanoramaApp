package i.b.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost */
public final class j {

    /* renamed from: d reason: collision with root package name */
    public static final List<j> f9755d = new ArrayList();

    /* renamed from: a reason: collision with root package name */
    public Object f9756a;

    /* renamed from: b reason: collision with root package name */
    public q f9757b;

    /* renamed from: c reason: collision with root package name */
    public j f9758c;

    public j(Object obj, q qVar) {
        this.f9756a = obj;
        this.f9757b = qVar;
    }

    public static j a(q qVar, Object obj) {
        synchronized (f9755d) {
            int size = f9755d.size();
            if (size <= 0) {
                return new j(obj, qVar);
            }
            j jVar = (j) f9755d.remove(size - 1);
            jVar.f9756a = obj;
            jVar.f9757b = qVar;
            jVar.f9758c = null;
            return jVar;
        }
    }

    public static void a(j jVar) {
        jVar.f9756a = null;
        jVar.f9757b = null;
        jVar.f9758c = null;
        synchronized (f9755d) {
            if (f9755d.size() < 10000) {
                f9755d.add(jVar);
            }
        }
    }
}
