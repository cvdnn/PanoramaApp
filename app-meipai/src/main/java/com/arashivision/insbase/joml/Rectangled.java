package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Rectangled {
    public double maxX;
    public double maxY;
    public double minX;
    public double minY;

    public Rectangled() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rectangled.class != obj.getClass()) {
            return false;
        }
        Rectangled rectangled = (Rectangled) obj;
        return Double.doubleToLongBits(this.maxX) == Double.doubleToLongBits(rectangled.maxX) && Double.doubleToLongBits(this.maxY) == Double.doubleToLongBits(rectangled.maxY) && Double.doubleToLongBits(this.minX) == Double.doubleToLongBits(rectangled.minX) && Double.doubleToLongBits(this.minY) == Double.doubleToLongBits(rectangled.minY);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.maxX);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.maxY);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.minX);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.minY);
        return (i4 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Rectangled(Rectangled rectangled) {
        this.minX = rectangled.minX;
        this.minY = rectangled.minY;
        this.maxX = rectangled.maxX;
        this.maxY = rectangled.maxY;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.minX, a2, str);
        a.b(numberFormat, this.minY, a2, ") < (");
        a.b(numberFormat, this.maxX, a2, str);
        return a.a(numberFormat, this.maxY, a2, ")");
    }

    public Rectangled(Vector2dc vector2dc, Vector2dc vector2dc2) {
        this.minX = vector2dc.x();
        this.minY = vector2dc.y();
        this.maxX = vector2dc2.x();
        this.maxY = vector2dc2.y();
    }

    public Rectangled(double d2, double d3, double d4, double d5) {
        this.minX = d2;
        this.minY = d3;
        this.maxX = d4;
        this.maxY = d5;
    }
}
