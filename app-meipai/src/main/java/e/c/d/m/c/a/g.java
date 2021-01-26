package e.c.d.m.c.a;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.m.a.c;

/* compiled from: HotSpotCapturePresenter */
public class g extends c<f> implements e {

    /* renamed from: b reason: collision with root package name */
    public String f6499b;

    /* renamed from: c reason: collision with root package name */
    public String f6500c;

    /* renamed from: d reason: collision with root package name */
    public int f6501d = 1;

    public g(f fVar) {
        super(fVar);
    }

    public void a(int i2, String str, String str2) {
        this.f6501d = i2;
        this.f6500c = str;
        this.f6499b = str2;
    }

    public void c() {
        ((f) this.f6403a).a(this.f6500c);
    }

    public void a(String str, int i2, String str2) {
        ThreadPoolService.post(new d(this, i2, str));
    }

    public /* synthetic */ void a(int i2, String str) {
        V v = this.f6403a;
        if (v != null) {
            if (i2 == -4) {
                ((f) v).e();
            } else if (i2 != 0) {
                ((f) v).f();
            } else {
                int i3 = this.f6501d;
                if (i3 == 1) {
                    ((f) v).a(this.f6499b, str);
                } else if (i3 == 3) {
                    ((f) v).k(str);
                }
            }
        }
    }

    public void a() {
        if (this.f6501d == 3) {
            ((f) this.f6403a).a();
        } else {
            ((f) this.f6403a).c();
        }
    }
}
