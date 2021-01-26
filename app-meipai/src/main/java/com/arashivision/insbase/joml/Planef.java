package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Planef {

    /* renamed from: a reason: collision with root package name */
    public float f1229a;

    /* renamed from: b reason: collision with root package name */
    public float f1230b;

    /* renamed from: c reason: collision with root package name */
    public float f1231c;

    /* renamed from: d reason: collision with root package name */
    public float f1232d;

    public Planef() {
    }

    public static Vector4f equationFromPoints(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector4f vector4f) {
        return equationFromPoints(vector3f.x, vector3f.y, vector3f.z, vector3f2.x, vector3f2.y, vector3f2.z, vector3f3.x, vector3f3.y, vector3f3.z, vector4f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Planef.class != obj.getClass()) {
            return false;
        }
        Planef planef = (Planef) obj;
        return Float.floatToIntBits(this.f1229a) == Float.floatToIntBits(planef.f1229a) && Float.floatToIntBits(this.f1230b) == Float.floatToIntBits(planef.f1230b) && Float.floatToIntBits(this.f1231c) == Float.floatToIntBits(planef.f1231c) && Float.floatToIntBits(this.f1232d) == Float.floatToIntBits(planef.f1232d);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1232d) + a.a(this.f1231c, a.a(this.f1230b, a.a(this.f1229a, 31, 31), 31), 31);
    }

    public Planef normalize() {
        return normalize(this);
    }

    public Planef set(float f2, float f3, float f4, float f5) {
        this.f1229a = f2;
        this.f1230b = f3;
        this.f1231c = f4;
        this.f1232d = f5;
        return this;
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Planef(Planef planef) {
        this.f1229a = planef.f1229a;
        this.f1230b = planef.f1230b;
        this.f1231c = planef.f1231c;
        this.f1232d = planef.f1232d;
    }

    public static Vector4f equationFromPoints(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Vector4f vector4f) {
        float f11 = f6 - f3;
        float f12 = f10 - f4;
        float f13 = f9 - f3;
        float f14 = f7 - f4;
        float f15 = f8 - f2;
        float f16 = f5 - f2;
        float f17 = (f11 * f12) - (f13 * f14);
        float f18 = (f14 * f15) - (f12 * f16);
        float f19 = (f16 * f13) - (f15 * f11);
        float f20 = f4 * f19;
        float f21 = -(f20 + (f3 * f18) + (f2 * f17));
        vector4f.x = f17;
        vector4f.y = f18;
        vector4f.z = f19;
        vector4f.w = f21;
        return vector4f;
    }

    public Planef normalize(Planef planef) {
        float f2 = this.f1229a;
        float f3 = f2 * f2;
        float f4 = this.f1230b;
        float f5 = (f4 * f4) + f3;
        float f6 = this.f1231c;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f6 * f6) + f5)));
        planef.f1229a = this.f1229a * sqrt;
        planef.f1230b = this.f1230b * sqrt;
        planef.f1231c = this.f1231c * sqrt;
        planef.f1232d = this.f1232d * sqrt;
        return planef;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("[");
        String str = " ";
        a.b(numberFormat, (double) this.f1229a, a2, str);
        a.b(numberFormat, (double) this.f1230b, a2, str);
        a.b(numberFormat, (double) this.f1231c, a2, str);
        return a.a(numberFormat, (double) this.f1232d, a2, "]");
    }

    public Planef(Vector3fc vector3fc, Vector3fc vector3fc2) {
        this.f1229a = vector3fc2.x();
        this.f1230b = vector3fc2.y();
        this.f1231c = vector3fc2.z();
        this.f1232d = ((vector3fc.x() * (-this.f1229a)) - (vector3fc.y() * this.f1230b)) - (vector3fc.z() * this.f1231c);
    }

    public Planef(float f2, float f3, float f4, float f5) {
        this.f1229a = f2;
        this.f1230b = f3;
        this.f1231c = f4;
        this.f1232d = f5;
    }
}
