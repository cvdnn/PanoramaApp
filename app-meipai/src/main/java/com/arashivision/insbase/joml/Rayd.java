package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Rayd {
    public double dX;
    public double dY;
    public double dZ;
    public double oX;
    public double oY;
    public double oZ;

    public Rayd() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rayd.class != obj.getClass()) {
            return false;
        }
        Rayd rayd = (Rayd) obj;
        return Double.doubleToLongBits(this.dX) == Double.doubleToLongBits(rayd.dX) && Double.doubleToLongBits(this.dY) == Double.doubleToLongBits(rayd.dY) && Double.doubleToLongBits(this.dZ) == Double.doubleToLongBits(rayd.dZ) && Double.doubleToLongBits(this.oX) == Double.doubleToLongBits(rayd.oX) && Double.doubleToLongBits(this.oY) == Double.doubleToLongBits(rayd.oY) && Double.doubleToLongBits(this.oZ) == Double.doubleToLongBits(rayd.oZ);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.dX);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.dY);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.dZ);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.oX);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.oY);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.oZ);
        return (i6 * 31) + ((int) ((doubleToLongBits6 >>> 32) ^ doubleToLongBits6));
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Rayd(Rayd rayd) {
        this.oX = rayd.oX;
        this.oY = rayd.oY;
        this.oZ = rayd.oZ;
        this.dX = rayd.dX;
        this.dY = rayd.dY;
        this.dZ = rayd.dZ;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.oX, a2, str);
        a.b(numberFormat, this.oY, a2, str);
        a.b(numberFormat, this.oZ, a2, ") -> (");
        a.b(numberFormat, this.dX, a2, str);
        a.b(numberFormat, this.dY, a2, str);
        return a.a(numberFormat, this.dZ, a2, ")");
    }

    public Rayd(Vector3dc vector3dc, Vector3dc vector3dc2) {
        this.oX = vector3dc.x();
        this.oY = vector3dc.y();
        this.oZ = vector3dc.z();
        this.dX = vector3dc2.x();
        this.dY = vector3dc2.y();
        this.dZ = vector3dc2.z();
    }

    public Rayd(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.oX = d2;
        this.oY = d3;
        this.oZ = d4;
        this.dX = d5;
        this.dY = d6;
        this.dZ = d7;
    }
}
