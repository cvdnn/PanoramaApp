package e.c.d.l.b;

import com.baidubce.AbstractBceClient;
import g.t;
import g.u;

/* compiled from: HttpService */
public class b {

    /* renamed from: b reason: collision with root package name */
    public static final t f6372b = t.a(AbstractBceClient.DEFAULT_CONTENT_TYPE);

    /* renamed from: c reason: collision with root package name */
    public static volatile b f6373c;

    /* renamed from: a reason: collision with root package name */
    public u f6374a;

    public static b a() {
        if (f6373c == null) {
            synchronized (b.class) {
                if (f6373c == null) {
                    f6373c = new b();
                }
            }
        }
        return f6373c;
    }
}
