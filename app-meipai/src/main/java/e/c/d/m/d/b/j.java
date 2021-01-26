package e.c.d.m.d.b;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.c.r.a;

/* compiled from: PanoramaGuidePresenter */
public class j implements a<Boolean> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ k f6648a;

    public j(k kVar) {
        this.f6648a = kVar;
    }

    public void a(Object obj, int i2) {
        if (((Boolean) obj).booleanValue()) {
            ThreadPoolService.post(new f(this));
        }
    }

    public /* synthetic */ void a() {
        V v = this.f6648a.f6403a;
        if (v != null) {
            ((i) v).q();
        }
    }
}
