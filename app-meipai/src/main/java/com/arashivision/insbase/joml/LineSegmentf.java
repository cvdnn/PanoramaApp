package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class LineSegmentf {
    public float aX;
    public float aY;
    public float aZ;
    public float bX;
    public float bY;
    public float bZ;

    public LineSegmentf() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LineSegmentf.class != obj.getClass()) {
            return false;
        }
        LineSegmentf lineSegmentf = (LineSegmentf) obj;
        return Float.floatToIntBits(this.aX) == Float.floatToIntBits(lineSegmentf.aX) && Float.floatToIntBits(this.aY) == Float.floatToIntBits(lineSegmentf.aY) && Float.floatToIntBits(this.aZ) == Float.floatToIntBits(lineSegmentf.aZ) && Float.floatToIntBits(this.bX) == Float.floatToIntBits(lineSegmentf.bX) && Float.floatToIntBits(this.bY) == Float.floatToIntBits(lineSegmentf.bY) && Float.floatToIntBits(this.bZ) == Float.floatToIntBits(lineSegmentf.bZ);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.bZ) + a.a(this.bY, a.a(this.bX, a.a(this.aZ, a.a(this.aY, a.a(this.aX, 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public LineSegmentf(LineSegmentf lineSegmentf) {
        this.aX = lineSegmentf.aX;
        this.aY = lineSegmentf.aY;
        this.aZ = lineSegmentf.aZ;
        this.aX = lineSegmentf.bX;
        this.bY = lineSegmentf.bY;
        this.bZ = lineSegmentf.bZ;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.aX, a2, str);
        a.b(numberFormat, (double) this.aY, a2, str);
        a.b(numberFormat, (double) this.aZ, a2, ") - (");
        a.b(numberFormat, (double) this.bX, a2, str);
        a.b(numberFormat, (double) this.bY, a2, str);
        return a.a(numberFormat, (double) this.bZ, a2, ")");
    }

    public LineSegmentf(Vector3fc vector3fc, Vector3fc vector3fc2) {
        this.aX = vector3fc.x();
        this.aY = vector3fc.y();
        this.aZ = vector3fc.z();
        this.bX = vector3fc2.x();
        this.bY = vector3fc2.y();
        this.bZ = vector3fc2.z();
    }

    public LineSegmentf(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.aX = f2;
        this.aY = f3;
        this.aZ = f4;
        this.bX = f5;
        this.bY = f6;
        this.bZ = f7;
    }
}
