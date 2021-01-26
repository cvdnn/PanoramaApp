package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Sphered {
    public double r;
    public double x;
    public double y;
    public double z;

    public Sphered() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Sphered.class != obj.getClass()) {
            return false;
        }
        Sphered sphered = (Sphered) obj;
        return Double.doubleToLongBits(this.r) == Double.doubleToLongBits(sphered.r) && Double.doubleToLongBits(this.x) == Double.doubleToLongBits(sphered.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(sphered.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(sphered.z);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.r);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.x);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.y);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.z);
        return (i4 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Sphered(Sphered sphered) {
        this.x = sphered.x;
        this.y = sphered.y;
        this.z = sphered.z;
        this.r = sphered.r;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("[");
        String str = " ";
        a.b(numberFormat, this.x, a2, str);
        a.b(numberFormat, this.y, a2, str);
        a.b(numberFormat, this.z, a2, str);
        return a.a(numberFormat, this.r, a2, "]");
    }

    public Sphered(double d2, double d3, double d4, double d5) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        this.r = d5;
    }
}
