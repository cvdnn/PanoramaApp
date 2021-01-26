package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Circlef {
    public float r;
    public float x;
    public float y;

    public Circlef() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Circlef.class != obj.getClass()) {
            return false;
        }
        Circlef circlef = (Circlef) obj;
        return Float.floatToIntBits(this.r) == Float.floatToIntBits(circlef.r) && Float.floatToIntBits(this.x) == Float.floatToIntBits(circlef.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(circlef.y);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.y) + a.a(this.x, a.a(this.r, 31, 31), 31);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Circlef(Circlef circlef) {
        this.x = circlef.x;
        this.y = circlef.y;
        this.r = circlef.r;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.x, a2, str);
        a.b(numberFormat, (double) this.y, a2, str);
        return a.a(numberFormat, (double) this.r, a2, ")");
    }

    public Circlef(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.r = f4;
    }
}
