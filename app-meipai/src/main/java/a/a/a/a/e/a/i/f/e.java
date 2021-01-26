package a.a.a.a.e.a.i.f;

import e.a.a.a.a;
import java.io.Serializable;

public class e implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public float f602a;

    /* renamed from: b reason: collision with root package name */
    public float f603b;

    /* renamed from: c reason: collision with root package name */
    public double f604c;

    /* renamed from: d reason: collision with root package name */
    public float f605d;

    /* renamed from: e reason: collision with root package name */
    public float f606e;

    /* renamed from: f reason: collision with root package name */
    public float f607f;

    /* renamed from: g reason: collision with root package name */
    public float f608g;

    /* renamed from: h reason: collision with root package name */
    public double[] f609h;

    public e clone() {
        e eVar = new e();
        eVar.f605d = this.f605d;
        eVar.f606e = this.f606e;
        eVar.f607f = this.f607f;
        eVar.f608g = this.f608g;
        eVar.f602a = this.f602a;
        eVar.f603b = this.f603b;
        eVar.f609h = this.f609h;
        eVar.f604c = this.f604c;
        return eVar;
    }

    public String toString() {
        StringBuilder a2 = a.a("StatePoint at ");
        a2.append(this.f604c);
        a2.append(", yaw: ");
        a2.append(this.f605d);
        a2.append(" pitch: ");
        a2.append(this.f606e);
        a2.append(" roll: ");
        a2.append(this.f607f);
        a2.append(" preRoll: ");
        a2.append(this.f608g);
        a2.append(" fov: ");
        a2.append(this.f602a);
        a2.append(" distance: ");
        a2.append(this.f603b);
        return a2.toString();
    }
}
