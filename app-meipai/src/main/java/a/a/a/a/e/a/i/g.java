package a.a.a.a.e.a.i;

import e.a.a.a.a;

public class g implements Comparable<g>, Cloneable {

    /* renamed from: a reason: collision with root package name */
    public double f610a;

    /* renamed from: b reason: collision with root package name */
    public double f611b;

    /* renamed from: c reason: collision with root package name */
    public double f612c;

    public String a() {
        StringBuilder a2 = a.a("{mStartTime: ");
        a2.append(this.f610a);
        a2.append(", mEndTime: ");
        a2.append(this.f611b);
        a2.append(", mSpeed: ");
        a2.append(this.f612c);
        a2.append("}");
        return a2.toString();
    }

    public Object clone() {
        return (g) super.clone();
    }

    public int compareTo(Object obj) {
        return (int) (this.f610a - ((g) obj).f610a);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f610a == gVar.f610a && this.f611b == gVar.f611b && this.f612c == gVar.f612c) {
            z = true;
        }
        return z;
    }

    public String toString() {
        return a();
    }
}
