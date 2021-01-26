package d.p;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ViewModel */
public abstract class q {

    /* renamed from: a reason: collision with root package name */
    public final Map<String, Object> f5292a = new HashMap();

    public final void a() {
        Map<String, Object> map = this.f5292a;
        if (map != null) {
            synchronized (map) {
                for (Object next : this.f5292a.values()) {
                    if (next instanceof Closeable) {
                        try {
                            ((Closeable) next).close();
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
            }
        }
        b();
    }

    public void b() {
    }
}
