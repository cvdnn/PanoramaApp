package e.c.d.f;

import com.baidu.picapture.App;
import e.c.d.f.d.b;
import i.b.b.g.c;
import i.b.b.h.d;

/* compiled from: DBManager */
public class a {

    /* renamed from: b reason: collision with root package name */
    public static volatile a f6058b;

    /* renamed from: a reason: collision with root package name */
    public b f6059a;

    public static a c() {
        if (f6058b == null) {
            synchronized (a.class) {
                if (f6058b == null) {
                    f6058b = new a();
                }
            }
        }
        return f6058b;
    }

    public b a() {
        if (this.f6059a == null) {
            b();
        }
        return this.f6059a;
    }

    public void b() {
        e.c.d.f.d.a aVar = new e.c.d.f.d.a(new c(new e.c.d.f.c.b(App.f1954b, "PICAPTURE", null).getWritableDatabase()));
        this.f6059a = new b(aVar.f9794a, d.Session, aVar.f9795b);
    }
}
