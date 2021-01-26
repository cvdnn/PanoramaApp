package e.e.a.f;

import e.a.a.a.a;

/* compiled from: GattException */
public class c extends a {

    /* renamed from: c reason: collision with root package name */
    public int f7994c;

    public c(int i2) {
        super(101, "Gatt Exception Occurred! ");
        this.f7994c = i2;
    }

    public String toString() {
        StringBuilder a2 = a.a("GattException{gattStatus=");
        a2.append(this.f7994c);
        a2.append("} ");
        a2.append(super.toString());
        return a2.toString();
    }
}
