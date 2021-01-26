package e.e.a.f;

import java.io.Serializable;

/* compiled from: BleException */
public abstract class BleException implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public int f7990a;

    /* renamed from: b reason: collision with root package name */
    public String f7991b;

    public BleException(int i2, String str) {
        this.f7990a = i2;
        this.f7991b = str;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("BleException { code=");
        a2.append(this.f7990a);
        a2.append(", description='");
        a2.append(this.f7991b);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
