package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.text.NumberFormat;

public class Rectanglef {
    public float maxX;
    public float maxY;
    public float minX;
    public float minY;

    public Rectanglef() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rectanglef.class != obj.getClass()) {
            return false;
        }
        Rectanglef rectanglef = (Rectanglef) obj;
        return Float.floatToIntBits(this.maxX) == Float.floatToIntBits(rectanglef.maxX) && Float.floatToIntBits(this.maxY) == Float.floatToIntBits(rectanglef.maxY) && Float.floatToIntBits(this.minX) == Float.floatToIntBits(rectanglef.minX) && Float.floatToIntBits(this.minY) == Float.floatToIntBits(rectanglef.minY);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.minY) + a.a(this.minX, a.a(this.maxY, a.a(this.maxX, 31, 31), 31), 31);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Rectanglef(Rectanglef rectanglef) {
        this.minX = rectanglef.minX;
        this.minY = rectanglef.minY;
        this.maxX = rectanglef.maxX;
        this.maxY = rectanglef.maxY;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.minX, a2, str);
        a.b(numberFormat, (double) this.minY, a2, ") < (");
        a.b(numberFormat, (double) this.maxX, a2, str);
        return a.a(numberFormat, (double) this.maxY, a2, ")");
    }

    public Rectanglef(Vector2fc vector2fc, Vector2fc vector2fc2) {
        this.minX = vector2fc.x();
        this.minY = vector2fc.y();
        this.maxX = vector2fc2.x();
        this.maxY = vector2fc2.y();
    }

    public Rectanglef(float f2, float f3, float f4, float f5) {
        this.minX = f2;
        this.minY = f3;
        this.maxX = f4;
        this.maxY = f5;
    }
}
