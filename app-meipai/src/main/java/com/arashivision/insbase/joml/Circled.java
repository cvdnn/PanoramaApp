package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Circled {
    public double r;
    public double x;
    public double y;

    public Circled() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Circled.class != obj.getClass()) {
            return false;
        }
        Circled circled = (Circled) obj;
        return Double.doubleToLongBits(this.r) == Double.doubleToLongBits(circled.r) && Double.doubleToLongBits(this.x) == Double.doubleToLongBits(circled.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(circled.y);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.r);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.x);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.y);
        return (i3 * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Circled(Circled circled) {
        this.x = circled.x;
        this.y = circled.y;
        this.r = circled.r;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.x, a2, str);
        a.b(numberFormat, this.y, a2, str);
        return a.a(numberFormat, this.r, a2, ")");
    }

    public Circled(double d2, double d3, double d4) {
        this.x = d2;
        this.y = d3;
        this.r = d4;
    }
}
