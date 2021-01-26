package g;

import e.a.a.a.a;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* compiled from: Route */
public final class b0 {

    /* renamed from: a reason: collision with root package name */
    public final a f9144a;

    /* renamed from: b reason: collision with root package name */
    public final Proxy f9145b;

    /* renamed from: c reason: collision with root package name */
    public final InetSocketAddress f9146c;

    public b0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f9144a = aVar;
            this.f9145b = proxy;
            this.f9146c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public boolean a() {
        return this.f9144a.f9134i != null && this.f9145b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            if (b0Var.f9144a.equals(this.f9144a) && b0Var.f9145b.equals(this.f9145b) && b0Var.f9146c.equals(this.f9146c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f9146c.hashCode() + ((this.f9145b.hashCode() + ((this.f9144a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder a2 = a.a("Route{");
        a2.append(this.f9146c);
        a2.append("}");
        return a2.toString();
    }
}
