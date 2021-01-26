package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Spheref {
    public float r;
    public float x;
    public float y;
    public float z;

    public Spheref() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Spheref.class != obj.getClass()) {
            return false;
        }
        Spheref spheref = (Spheref) obj;
        return Float.floatToIntBits(this.r) == Float.floatToIntBits(spheref.r) && Float.floatToIntBits(this.x) == Float.floatToIntBits(spheref.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(spheref.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(spheref.z);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.z) + a.a(this.y, a.a(this.x, a.a(this.r, 31, 31), 31), 31);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Spheref(Spheref spheref) {
        this.x = spheref.x;
        this.y = spheref.y;
        this.z = spheref.z;
        this.r = spheref.r;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("[");
        String str = " ";
        a.b(numberFormat, (double) this.x, a2, str);
        a.b(numberFormat, (double) this.y, a2, str);
        a.b(numberFormat, (double) this.z, a2, str);
        return a.a(numberFormat, (double) this.r, a2, "]");
    }

    public Spheref(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.r = f5;
    }
}
