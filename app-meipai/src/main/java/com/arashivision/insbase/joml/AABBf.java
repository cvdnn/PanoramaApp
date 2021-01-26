package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class AABBf {
    public float maxX = Float.NEGATIVE_INFINITY;
    public float maxY = Float.NEGATIVE_INFINITY;
    public float maxZ = Float.NEGATIVE_INFINITY;
    public float minX = Float.POSITIVE_INFINITY;
    public float minY = Float.POSITIVE_INFINITY;
    public float minZ = Float.POSITIVE_INFINITY;

    public AABBf() {
    }

    public AABBf correctBounds() {
        float f2 = this.minX;
        float f3 = this.maxX;
        if (f2 > f3) {
            this.minX = f3;
            this.maxX = f2;
        }
        float f4 = this.minY;
        float f5 = this.maxY;
        if (f4 > f5) {
            this.minY = f5;
            this.maxY = f4;
        }
        float f6 = this.minZ;
        float f7 = this.maxZ;
        if (f6 > f7) {
            this.minZ = f7;
            this.maxZ = f6;
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AABBf.class != obj.getClass()) {
            return false;
        }
        AABBf aABBf = (AABBf) obj;
        return Float.floatToIntBits(this.maxX) == Float.floatToIntBits(aABBf.maxX) && Float.floatToIntBits(this.maxY) == Float.floatToIntBits(aABBf.maxY) && Float.floatToIntBits(this.maxZ) == Float.floatToIntBits(aABBf.maxZ) && Float.floatToIntBits(this.minX) == Float.floatToIntBits(aABBf.minX) && Float.floatToIntBits(this.minY) == Float.floatToIntBits(aABBf.minY) && Float.floatToIntBits(this.minZ) == Float.floatToIntBits(aABBf.minZ);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.minZ) + a.a(this.minY, a.a(this.minX, a.a(this.maxZ, a.a(this.maxY, a.a(this.maxX, 31, 31), 31), 31), 31), 31);
    }

    public int intersectLineSegment(float f2, float f3, float f4, float f5, float f6, float f7, Vector2f vector2f) {
        return Intersectionf.intersectLineSegmentAab(f2, f3, f4, f5, f6, f7, this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, vector2f);
    }

    public boolean intersectRay(float f2, float f3, float f4, float f5, float f6, float f7, Vector2f vector2f) {
        return Intersectionf.intersectRayAab(f2, f3, f4, f5, f6, f7, this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, vector2f);
    }

    public AABBf setMax(float f2, float f3, float f4) {
        this.maxX = f2;
        this.maxY = f3;
        this.maxZ = f4;
        return this;
    }

    public AABBf setMin(float f2, float f3, float f4) {
        this.minX = f2;
        this.minY = f3;
        this.minZ = f4;
        return this;
    }

    public boolean testAABB(AABBf aABBf) {
        return this.maxX >= aABBf.minX && this.maxY >= aABBf.minY && this.maxZ >= aABBf.minZ && this.minX <= aABBf.maxX && this.minY <= aABBf.maxY && this.minZ <= aABBf.maxZ;
    }

    public boolean testPlane(float f2, float f3, float f4, float f5) {
        return Intersectionf.testAabPlane(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, f2, f3, f4, f5);
    }

    public boolean testPoint(float f2, float f3, float f4) {
        return f2 >= this.minX && f3 >= this.minY && f4 >= this.minZ && f2 <= this.maxX && f3 <= this.maxY && f4 <= this.maxZ;
    }

    public boolean testRay(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Intersectionf.testRayAab(f2, f3, f4, f5, f6, f7, this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    public boolean testSphere(float f2, float f3, float f4, float f5) {
        return Intersectionf.testAabSphere(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, f2, f3, f4, f5);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public AABBf union(float f2, float f3, float f4) {
        return union(f2, f3, f4, this);
    }

    public int intersectLineSegment(LineSegmentf lineSegmentf, Vector2f vector2f) {
        return Intersectionf.intersectLineSegmentAab(lineSegmentf, this, vector2f);
    }

    public boolean intersectRay(Rayf rayf, Vector2f vector2f) {
        return Intersectionf.intersectRayAab(rayf, this, vector2f);
    }

    public boolean testPlane(Planef planef) {
        return Intersectionf.testAabPlane(this, planef);
    }

    public boolean testPoint(Vector3fc vector3fc) {
        return testPoint(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public boolean testRay(Rayf rayf) {
        return Intersectionf.testRayAab(rayf, this);
    }

    public boolean testSphere(Spheref spheref) {
        return Intersectionf.testAabSphere(this, spheref);
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.minX, a2, str);
        a.b(numberFormat, (double) this.minY, a2, str);
        a.b(numberFormat, (double) this.minZ, a2, ") < (");
        a.b(numberFormat, (double) this.maxX, a2, str);
        a.b(numberFormat, (double) this.maxY, a2, str);
        return a.a(numberFormat, (double) this.maxZ, a2, ")");
    }

    public AABBf union(Vector3fc vector3fc) {
        return union(vector3fc.x(), vector3fc.y(), vector3fc.z(), this);
    }

    public AABBf union(float f2, float f3, float f4, AABBf aABBf) {
        float f5 = this.minX;
        if (f5 >= f2) {
            f5 = f2;
        }
        aABBf.minX = f5;
        float f6 = this.minY;
        if (f6 >= f3) {
            f6 = f3;
        }
        aABBf.minY = f6;
        float f7 = this.minZ;
        if (f7 >= f4) {
            f7 = f4;
        }
        aABBf.minZ = f7;
        float f8 = this.maxX;
        if (f8 > f2) {
            f2 = f8;
        }
        aABBf.maxX = f2;
        float f9 = this.maxY;
        if (f9 > f3) {
            f3 = f9;
        }
        aABBf.maxY = f3;
        float f10 = this.maxZ;
        if (f10 > f4) {
            f4 = f10;
        }
        aABBf.maxZ = f4;
        return aABBf;
    }

    public AABBf(AABBf aABBf) {
        this.minX = aABBf.minX;
        this.minY = aABBf.minY;
        this.minZ = aABBf.minZ;
        this.maxX = aABBf.maxX;
        this.maxY = aABBf.maxY;
        this.maxZ = aABBf.maxZ;
    }

    public AABBf setMax(Vector3fc vector3fc) {
        return setMax(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public AABBf setMin(Vector3fc vector3fc) {
        return setMin(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public AABBf union(Vector3fc vector3fc, AABBf aABBf) {
        return union(vector3fc.x(), vector3fc.y(), vector3fc.z(), aABBf);
    }

    public AABBf union(AABBf aABBf) {
        return union(aABBf, this);
    }

    public AABBf union(AABBf aABBf, AABBf aABBf2) {
        float f2 = this.minX;
        float f3 = aABBf.minX;
        if (f2 >= f3) {
            f2 = f3;
        }
        aABBf2.minX = f2;
        float f4 = this.minY;
        float f5 = aABBf.minY;
        if (f4 >= f5) {
            f4 = f5;
        }
        aABBf2.minY = f4;
        float f6 = this.minZ;
        float f7 = aABBf.minZ;
        if (f6 >= f7) {
            f6 = f7;
        }
        aABBf2.minZ = f6;
        float f8 = this.maxX;
        float f9 = aABBf.maxX;
        if (f8 <= f9) {
            f8 = f9;
        }
        aABBf2.maxX = f8;
        float f10 = this.maxY;
        float f11 = aABBf.maxY;
        if (f10 <= f11) {
            f10 = f11;
        }
        aABBf2.maxY = f10;
        float f12 = this.maxZ;
        float f13 = aABBf.maxZ;
        if (f12 <= f13) {
            f12 = f13;
        }
        aABBf2.maxZ = f12;
        return aABBf2;
    }

    public AABBf(Vector3fc vector3fc, Vector3fc vector3fc2) {
        this.minX = vector3fc.x();
        this.minY = vector3fc.y();
        this.minZ = vector3fc.z();
        this.maxX = vector3fc2.x();
        this.maxY = vector3fc2.y();
        this.maxZ = vector3fc2.z();
    }

    public AABBf(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.minX = f2;
        this.minY = f3;
        this.minZ = f4;
        this.maxX = f5;
        this.maxY = f6;
        this.maxZ = f7;
    }
}
