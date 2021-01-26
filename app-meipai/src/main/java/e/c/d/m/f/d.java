package e.c.d.m.f;

import e.c.d.m.a.c;
import e.c.d.n.e;
import java.io.File;

/* compiled from: SpinPhotoPresenter */
public class d extends c<c> implements b {

    /* renamed from: b reason: collision with root package name */
    public String f6785b;

    public d(c cVar) {
        super(cVar);
    }

    public void a(String str) {
        this.f6785b = str;
    }

    public void start() {
        File[] i2 = e.i(this.f6785b);
        if (i2.length > 0) {
            ((c) this.f6403a).a(i2);
        }
    }
}
