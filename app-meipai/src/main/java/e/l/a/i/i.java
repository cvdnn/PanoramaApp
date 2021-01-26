package e.l.a.i;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipProfile.Builder;
import e.l.a.o.a;

/* compiled from: SipTest */
public class i {

    /* renamed from: b reason: collision with root package name */
    public static final String f8952b = a.a("5065726D697373696F6E");

    /* renamed from: c reason: collision with root package name */
    public static final String f8953c = a.a("3132372E302E302E31");

    /* renamed from: d reason: collision with root package name */
    public static final String f8954d;

    /* renamed from: a reason: collision with root package name */
    public Context f8955a;

    static {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = "70617373776F7264".getBytes();
        for (int i2 = 0; i2 < bytes.length; i2++) {
            sb.append(a.f8976a[(bytes[i2] & 240) >> 4]);
            sb.append(a.f8976a[bytes[i2] & 15]);
        }
        f8954d = sb.toString().trim();
    }

    public i(Context context) {
        this.f8955a = context;
    }

    public boolean a() throws Throwable {
        if (!SipManager.isApiSupported(this.f8955a)) {
            return true;
        }
        SipManager newInstance = SipManager.newInstance(this.f8955a);
        if (newInstance == null) {
            return true;
        }
        Builder builder = new Builder(f8952b, f8953c);
        builder.setPassword(f8954d);
        SipProfile build = builder.build();
        newInstance.open(build);
        newInstance.close(build.getUriString());
        return true;
    }
}
