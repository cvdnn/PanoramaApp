package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class LineSegmentd {
    public double aX;
    public double aY;
    public double aZ;
    public double bX;
    public double bY;
    public double bZ;

    public LineSegmentd() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LineSegmentd.class != obj.getClass()) {
            return false;
        }
        LineSegmentd lineSegmentd = (LineSegmentd) obj;
        return Double.doubleToLongBits(this.aX) == Double.doubleToLongBits(lineSegmentd.aX) && Double.doubleToLongBits(this.aY) == Double.doubleToLongBits(lineSegmentd.aY) && Double.doubleToLongBits(this.aZ) == Double.doubleToLongBits(lineSegmentd.aZ) && Double.doubleToLongBits(this.bX) == Double.doubleToLongBits(lineSegmentd.bX) && Double.doubleToLongBits(this.bY) == Double.doubleToLongBits(lineSegmentd.bY) && Double.doubleToLongBits(this.bZ) == Double.doubleToLongBits(lineSegmentd.bZ);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.aX);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.aY);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.aZ);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.bX);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.bY);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.bZ);
        return (i6 * 31) + ((int) ((doubleToLongBits6 >>> 32) ^ doubleToLongBits6));
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public LineSegmentd(LineSegmentd lineSegmentd) {
        this.aX = lineSegmentd.aX;
        this.aY = lineSegmentd.aY;
        this.aZ = lineSegmentd.aZ;
        this.aX = lineSegmentd.bX;
        this.bY = lineSegmentd.bY;
        this.bZ = lineSegmentd.bZ;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.aX, a2, str);
        a.b(numberFormat, this.aY, a2, str);
        a.b(numberFormat, this.aZ, a2, ") - (");
        a.b(numberFormat, this.bX, a2, str);
        a.b(numberFormat, this.bY, a2, str);
        return a.a(numberFormat, this.bZ, a2, ")");
    }

    public LineSegmentd(Vector3dc vector3dc, Vector3dc vector3dc2) {
        this.aX = vector3dc.x();
        this.aY = vector3dc.y();
        this.aZ = vector3dc.z();
        this.bX = vector3dc2.x();
        this.bY = vector3dc2.y();
        this.bZ = vector3dc2.z();
    }

    public LineSegmentd(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.aX = d2;
        this.aY = d3;
        this.aZ = d4;
        this.bX = d5;
        this.bY = d6;
        this.bZ = d7;
    }
}
