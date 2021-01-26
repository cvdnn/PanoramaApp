package e.c.d.i.c;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import g.a0;
import g.t;
import g.u;
import g.x.a;
import g.y;
import g.z;

/* compiled from: SphericalCameraChecker */
public class s {

    /* renamed from: b reason: collision with root package name */
    public static final s f6220b = new s();

    /* renamed from: a reason: collision with root package name */
    public u f6221a;

    public boolean a() {
        String str = "application/json";
        y create = y.create(t.a(str), "");
        a aVar = new a();
        aVar.a("http://192.168.42.1/osc/state");
        aVar.a(Constants.HTTP_POST, create);
        aVar.a("Content-Type", str);
        aVar.a("Accept", str);
        aVar.a("X-XSRF-Protected", "1");
        CharSequence charSequence = null;
        try {
            z d2 = this.f6221a.a(aVar.a()).d();
            a0 a0Var = d2.f9620g;
            CharSequence string = a0Var != null ? a0Var.string() : null;
            if (d2.f9616c == 200 && string != null) {
                charSequence = string;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return !TextUtils.isEmpty(charSequence);
    }
}
