package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class AABBd {
    public double maxX = Double.NEGATIVE_INFINITY;
    public double maxY = Double.NEGATIVE_INFINITY;
    public double maxZ = Double.NEGATIVE_INFINITY;
    public double minX = Double.POSITIVE_INFINITY;
    public double minY = Double.POSITIVE_INFINITY;
    public double minZ = Double.POSITIVE_INFINITY;

    public AABBd() {
    }

    public AABBd correctBounds() {
        double d2 = this.minX;
        double d3 = this.maxX;
        if (d2 > d3) {
            this.minX = d3;
            this.maxX = d2;
        }
        double d4 = this.minY;
        double d5 = this.maxY;
        if (d4 > d5) {
            this.minY = d5;
            this.maxY = d4;
        }
        double d6 = this.minZ;
        double d7 = this.maxZ;
        if (d6 > d7) {
            this.minZ = d7;
            this.maxZ = d6;
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AABBd.class != obj.getClass()) {
            return false;
        }
        AABBd aABBd = (AABBd) obj;
        return Double.doubleToLongBits(this.maxX) == Double.doubleToLongBits(aABBd.maxX) && Double.doubleToLongBits(this.maxY) == Double.doubleToLongBits(aABBd.maxY) && Double.doubleToLongBits(this.maxZ) == Double.doubleToLongBits(aABBd.maxZ) && Double.doubleToLongBits(this.minX) == Double.doubleToLongBits(aABBd.minX) && Double.doubleToLongBits(this.minY) == Double.doubleToLongBits(aABBd.minY) && Double.doubleToLongBits(this.minZ) == Double.doubleToLongBits(aABBd.minZ);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.maxX);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.maxY);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.maxZ);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.minX);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.minY);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.minZ);
        return (i6 * 31) + ((int) ((doubleToLongBits6 >>> 32) ^ doubleToLongBits6));
    }

    public int intersectLineSegment(double d2, double d3, double d4, double d5, double d6, double d7, Vector2d vector2d) {
        double d8 = d2;
        Vector2d vector2d2 = vector2d;
        return Intersectiond.intersectLineSegmentAab(d2, d3, d4, d5, d6, d7, this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, vector2d2);
    }

    public boolean intersectRay(double d2, double d3, double d4, double d5, double d6, double d7, Vector2d vector2d) {
        double d8 = d2;
        Vector2d vector2d2 = vector2d;
        return Intersectiond.intersectRayAab(d2, d3, d4, d5, d6, d7, this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, vector2d2);
    }

    public AABBd setMax(double d2, double d3, double d4) {
        this.maxX = d2;
        this.maxY = d3;
        this.maxZ = d4;
        return this;
    }

    public AABBd setMin(double d2, double d3, double d4) {
        this.minX = d2;
        this.minY = d3;
        this.minZ = d4;
        return this;
    }

    public boolean testAABB(AABBd aABBd) {
        return this.maxX >= aABBd.minX && this.maxY >= aABBd.minY && this.maxZ >= aABBd.minZ && this.minX <= aABBd.maxX && this.minY <= aABBd.maxY && this.minZ <= aABBd.maxZ;
    }

    public boolean testPlane(double d2, double d3, double d4, double d5) {
        return Intersectiond.testAabPlane(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, d2, d3, d4, d5);
    }

    public boolean testPoint(double d2, double d3, double d4) {
        return d2 >= this.minX && d3 >= this.minY && d4 >= this.minZ && d2 <= this.maxX && d3 <= this.maxY && d4 <= this.maxZ;
    }

    public boolean testRay(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d2;
        return Intersectiond.testRayAab(d2, d3, d4, d5, d6, d7, this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    public boolean testSphere(double d2, double d3, double d4, double d5) {
        return Intersectiond.testAabSphere(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, d2, d3, d4, d5);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public AABBd union(double d2, double d3, double d4) {
        return union(d2, d3, d4, this);
    }

    public int intersectLineSegment(LineSegmentf lineSegmentf, Vector2d vector2d) {
        return Intersectiond.intersectLineSegmentAab(lineSegmentf, this, vector2d);
    }

    public boolean intersectRay(Rayd rayd, Vector2d vector2d) {
        return Intersectiond.intersectRayAab(rayd, this, vector2d);
    }

    public boolean testPlane(Planed planed) {
        return Intersectiond.testAabPlane(this, planed);
    }

    public boolean testPoint(Vector3dc vector3dc) {
        return testPoint(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public boolean testRay(Rayd rayd) {
        return Intersectiond.testRayAab(rayd, this);
    }

    public boolean testSphere(Spheref spheref) {
        return Intersectiond.testAabSphere(this, spheref);
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.minX, a2, str);
        a.b(numberFormat, this.minY, a2, str);
        a.b(numberFormat, this.minZ, a2, ") < (");
        a.b(numberFormat, this.maxX, a2, str);
        a.b(numberFormat, this.maxY, a2, str);
        return a.a(numberFormat, this.maxZ, a2, ")");
    }

    public AABBd union(Vector3dc vector3dc) {
        return union(vector3dc.x(), vector3dc.y(), vector3dc.z(), this);
    }

    public AABBd union(double d2, double d3, double d4, AABBd aABBd) {
        double d5 = this.minX;
        if (d5 >= d2) {
            d5 = d2;
        }
        aABBd.minX = d5;
        double d6 = this.minY;
        if (d6 >= d3) {
            d6 = d3;
        }
        aABBd.minY = d6;
        double d7 = this.minZ;
        if (d7 >= d4) {
            d7 = d4;
        }
        aABBd.minZ = d7;
        double d8 = this.maxX;
        if (d8 > d2) {
            d2 = d8;
        }
        aABBd.maxX = d2;
        double d9 = this.maxY;
        if (d9 > d3) {
            d3 = d9;
        }
        aABBd.maxY = d3;
        double d10 = this.maxZ;
        if (d10 > d4) {
            d4 = d10;
        }
        aABBd.maxZ = d4;
        return aABBd;
    }

    public AABBd(AABBd aABBd) {
        this.minX = aABBd.minX;
        this.minY = aABBd.minY;
        this.minZ = aABBd.minZ;
        this.maxX = aABBd.maxX;
        this.maxY = aABBd.maxY;
        this.maxZ = aABBd.maxZ;
    }

    public AABBd setMax(Vector3dc vector3dc) {
        return setMax(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public AABBd setMin(Vector3dc vector3dc) {
        return setMin(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public AABBd union(Vector3dc vector3dc, AABBd aABBd) {
        return union(vector3dc.x(), vector3dc.y(), vector3dc.z(), aABBd);
    }

    public AABBd union(AABBd aABBd) {
        return union(aABBd, this);
    }

    public AABBd union(AABBd aABBd, AABBd aABBd2) {
        double d2 = this.minX;
        double d3 = aABBd.minX;
        if (d2 >= d3) {
            d2 = d3;
        }
        aABBd2.minX = d2;
        double d4 = this.minY;
        double d5 = aABBd.minY;
        if (d4 >= d5) {
            d4 = d5;
        }
        aABBd2.minY = d4;
        double d6 = this.minZ;
        double d7 = aABBd.minZ;
        if (d6 >= d7) {
            d6 = d7;
        }
        aABBd2.minZ = d6;
        double d8 = this.maxX;
        double d9 = aABBd.maxX;
        if (d8 <= d9) {
            d8 = d9;
        }
        aABBd2.maxX = d8;
        double d10 = this.maxY;
        double d11 = aABBd.maxY;
        if (d10 <= d11) {
            d10 = d11;
        }
        aABBd2.maxY = d10;
        double d12 = this.maxZ;
        double d13 = aABBd.maxZ;
        if (d12 <= d13) {
            d12 = d13;
        }
        aABBd2.maxZ = d12;
        return aABBd2;
    }

    public AABBd(Vector3dc vector3dc, Vector3dc vector3dc2) {
        this.minX = vector3dc.x();
        this.minY = vector3dc.y();
        this.minZ = vector3dc.z();
        this.maxX = vector3dc2.x();
        this.maxY = vector3dc2.y();
        this.maxZ = vector3dc2.z();
    }

    public AABBd(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.minX = d2;
        this.minY = d3;
        this.minZ = d4;
        this.maxX = d5;
        this.maxY = d6;
        this.maxZ = d7;
    }
}
