package i.b.a;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SubscriberMethod */
public class o {

    /* renamed from: a reason: collision with root package name */
    public final Method f9764a;

    /* renamed from: b reason: collision with root package name */
    public final ThreadMode f9765b;

    /* renamed from: c reason: collision with root package name */
    public final Class<?> f9766c;

    /* renamed from: d reason: collision with root package name */
    public final int f9767d;

    /* renamed from: e reason: collision with root package name */
    public final boolean f9768e;

    /* renamed from: f reason: collision with root package name */
    public String f9769f;

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.f9764a = method;
        this.f9765b = threadMode;
        this.f9766c = cls;
        this.f9767d = i2;
        this.f9768e = z;
    }

    public final synchronized void a() {
        if (this.f9769f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f9764a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f9764a.getName());
            sb.append('(');
            sb.append(this.f9766c.getName());
            this.f9769f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f9769f.equals(oVar.f9769f);
    }

    public int hashCode() {
        return this.f9764a.hashCode();
    }
}
