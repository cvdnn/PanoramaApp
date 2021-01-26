package e.c.d.m.d.a;

import com.arashivision.sdkmedia.work.WorkWrapper;
import e.c.d.i.c.l;
import e.c.d.i.c.r;
import e.c.d.l.a.b.a;
import e.c.d.n.e;

/* compiled from: PanoramaCapturePresenter */
public class s0 implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ r0 f6572a;

    public s0(r0 r0Var) {
        this.f6572a = r0Var;
    }

    public void a(String[] strArr, int i2) {
        if (i2 == 0) {
            this.f6572a.o = new WorkWrapper(strArr);
            r0 r0Var = this.f6572a;
            if (r0Var != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.c());
                sb.append("/hdr.jpg");
                String sb2 = sb.toString();
                r.f6218b.f6219a.execute(new l(r0Var.o, sb2, new n(r0Var, sb2)));
                return;
            }
            throw null;
        }
        this.f6572a.F();
    }
}
