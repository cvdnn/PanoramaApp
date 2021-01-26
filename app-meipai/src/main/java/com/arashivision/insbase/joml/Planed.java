package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Planed {

    /* renamed from: a reason: collision with root package name */
    public double f1225a;

    /* renamed from: b reason: collision with root package name */
    public double f1226b;

    /* renamed from: c reason: collision with root package name */
    public double f1227c;

    /* renamed from: d reason: collision with root package name */
    public double f1228d;

    public Planed() {
    }

    public static Vector4d equationFromPoints(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, Vector4d vector4d) {
        Vector3d vector3d4 = vector3d;
        Vector3d vector3d5 = vector3d2;
        Vector3d vector3d6 = vector3d3;
        return equationFromPoints(vector3d4.x, vector3d4.y, vector3d4.z, vector3d5.x, vector3d5.y, vector3d5.z, vector3d6.x, vector3d6.y, vector3d6.z, vector4d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Planed.class != obj.getClass()) {
            return false;
        }
        Planed planed = (Planed) obj;
        return Double.doubleToLongBits(this.f1225a) == Double.doubleToLongBits(planed.f1225a) && Double.doubleToLongBits(this.f1226b) == Double.doubleToLongBits(planed.f1226b) && Double.doubleToLongBits(this.f1227c) == Double.doubleToLongBits(planed.f1227c) && Double.doubleToLongBits(this.f1228d) == Double.doubleToLongBits(planed.f1228d);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1225a);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f1226b);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f1227c);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f1228d);
        return (i4 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public Planed normalize() {
        return normalize(this);
    }

    public Planed set(double d2, double d3, double d4, double d5) {
        this.f1225a = d2;
        this.f1226b = d3;
        this.f1227c = d4;
        this.f1228d = d5;
        return this;
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Planed(Planed planed) {
        this.f1225a = planed.f1225a;
        this.f1226b = planed.f1226b;
        this.f1227c = planed.f1227c;
        this.f1228d = planed.f1228d;
    }

    public static Vector4d equationFromPoints(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d11 = d6 - d3;
        double d12 = d10 - d4;
        double d13 = d9 - d3;
        double d14 = d7 - d4;
        double d15 = d8 - d2;
        double d16 = d5 - d2;
        double d17 = (d11 * d12) - (d13 * d14);
        double d18 = (d14 * d15) - (d12 * d16);
        double d19 = (d16 * d13) - (d15 * d11);
        double d20 = -((d19 * d4) + (d18 * d3) + (d17 * d2));
        vector4d2.x = d17;
        vector4d2.y = d18;
        vector4d2.z = d19;
        vector4d2.w = d20;
        return vector4d2;
    }

    public Planed normalize(Planed planed) {
        double d2 = this.f1225a;
        double d3 = d2 * d2;
        double d4 = this.f1226b;
        double d5 = (d4 * d4) + d3;
        double d6 = this.f1227c;
        double e2 = a.e(d6, d6, d5, 1.0d);
        planed.f1225a = this.f1225a * e2;
        planed.f1226b = this.f1226b * e2;
        planed.f1227c = this.f1227c * e2;
        planed.f1228d = this.f1228d * e2;
        return planed;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("[");
        String str = " ";
        a.b(numberFormat, this.f1225a, a2, str);
        a.b(numberFormat, this.f1226b, a2, str);
        a.b(numberFormat, this.f1227c, a2, str);
        return a.a(numberFormat, this.f1228d, a2, "]");
    }

    public Planed(Vector3dc vector3dc, Vector3dc vector3dc2) {
        this.f1225a = vector3dc2.x();
        this.f1226b = vector3dc2.y();
        this.f1227c = vector3dc2.z();
        this.f1228d = ((vector3dc.x() * (-this.f1225a)) - (vector3dc.y() * this.f1226b)) - (vector3dc.z() * this.f1227c);
    }

    public Planed(double d2, double d3, double d4, double d5) {
        this.f1225a = d2;
        this.f1226b = d3;
        this.f1227c = d4;
        this.f1228d = d5;
    }
}
