package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Rayf {
    public float dX;
    public float dY;
    public float dZ;
    public float oX;
    public float oY;
    public float oZ;

    public Rayf() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rayf.class != obj.getClass()) {
            return false;
        }
        Rayf rayf = (Rayf) obj;
        return Float.floatToIntBits(this.dX) == Float.floatToIntBits(rayf.dX) && Float.floatToIntBits(this.dY) == Float.floatToIntBits(rayf.dY) && Float.floatToIntBits(this.dZ) == Float.floatToIntBits(rayf.dZ) && Float.floatToIntBits(this.oX) == Float.floatToIntBits(rayf.oX) && Float.floatToIntBits(this.oY) == Float.floatToIntBits(rayf.oY) && Float.floatToIntBits(this.oZ) == Float.floatToIntBits(rayf.oZ);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.oZ) + a.a(this.oY, a.a(this.oX, a.a(this.dZ, a.a(this.dY, a.a(this.dX, 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Rayf(Rayf rayf) {
        this.oX = rayf.oX;
        this.oY = rayf.oY;
        this.oZ = rayf.oZ;
        this.dX = rayf.dX;
        this.dY = rayf.dY;
        this.dZ = rayf.dZ;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.oX, a2, str);
        a.b(numberFormat, (double) this.oY, a2, str);
        a.b(numberFormat, (double) this.oZ, a2, ") -> (");
        a.b(numberFormat, (double) this.dX, a2, str);
        a.b(numberFormat, (double) this.dY, a2, str);
        return a.a(numberFormat, (double) this.dZ, a2, ")");
    }

    public Rayf(Vector3fc vector3fc, Vector3fc vector3fc2) {
        this.oX = vector3fc.x();
        this.oY = vector3fc.y();
        this.oZ = vector3fc.z();
        this.dX = vector3fc2.x();
        this.dY = vector3fc2.y();
        this.dZ = vector3fc2.z();
    }

    public Rayf(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.oX = f2;
        this.oY = f3;
        this.oZ = f4;
        this.dX = f5;
        this.dY = f6;
        this.dZ = f7;
    }
}
