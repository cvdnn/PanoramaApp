package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.MemUtil;
import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.NumberFormat;

public class Vector2f implements Externalizable, Vector2fc {
    public static final long serialVersionUID = 1;
    public float x;
    public float y;

    public Vector2f() {
    }

    public static float distanceSquared(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (f7 * f7) + (f6 * f6);
    }

    public static float lengthSquared(float f2, float f3) {
        return (f3 * f3) + (f2 * f2);
    }

    private Vector2f thisOrNew() {
        return this;
    }

    public Vector2f add(Vector2fc vector2fc) {
        return add(vector2fc, thisOrNew());
    }

    public float angle(Vector2fc vector2fc) {
        float y2 = (vector2fc.y() * this.y) + (vector2fc.x() * this.x);
        return (float) Math.atan2((double) ((vector2fc.y() * this.x) - (vector2fc.x() * this.y)), (double) y2);
    }

    public Vector2f ceil() {
        return ceil(thisOrNew());
    }

    public float distance(Vector2fc vector2fc) {
        return distance(vector2fc.x(), vector2fc.y());
    }

    public float distanceSquared(Vector2fc vector2fc) {
        return distanceSquared(vector2fc.x(), vector2fc.y());
    }

    public float dot(Vector2fc vector2fc) {
        return (vector2fc.y() * this.y) + (vector2fc.x() * this.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector2f.class != obj.getClass()) {
            return false;
        }
        Vector2f vector2f = (Vector2f) obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(vector2f.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(vector2f.y);
    }

    public Vector2f floor() {
        return floor(thisOrNew());
    }

    public Vector2f fma(Vector2fc vector2fc, Vector2fc vector2fc2) {
        return fma(vector2fc, vector2fc2, thisOrNew());
    }

    public float get(int i2) throws IllegalArgumentException {
        if (i2 == 0) {
            return this.x;
        }
        if (i2 == 1) {
            return this.y;
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return Float.floatToIntBits(this.y) + a.a(this.x, 31, 31);
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y);
    }

    public float length() {
        return (float) Math.sqrt((double) lengthSquared());
    }

    public float lengthSquared() {
        return lengthSquared(this.x, this.y);
    }

    public Vector2f lerp(Vector2fc vector2fc, float f2) {
        return lerp(vector2fc, f2, thisOrNew());
    }

    public Vector2f max(Vector2fc vector2fc) {
        return max(vector2fc, thisOrNew());
    }

    public int maxComponent() {
        return Math.abs(this.x) >= Math.abs(this.y) ? 0 : 1;
    }

    public Vector2f min(Vector2fc vector2fc) {
        return min(vector2fc, thisOrNew());
    }

    public int minComponent() {
        return Math.abs(this.x) < Math.abs(this.y) ? 0 : 1;
    }

    public Vector2f mul(float f2) {
        return mul(f2, thisOrNew());
    }

    public Vector2f mulDirection(Matrix3x2fc matrix3x2fc) {
        return mulDirection(matrix3x2fc, thisOrNew());
    }

    public Vector2f mulPosition(Matrix3x2fc matrix3x2fc) {
        return mulPosition(matrix3x2fc, thisOrNew());
    }

    public Vector2f negate() {
        return negate(thisOrNew());
    }

    public Vector2f normalize() {
        return normalize(thisOrNew());
    }

    public Vector2f perpendicular() {
        return set(this.y, this.x * -1.0f);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readFloat();
        this.y = objectInput.readFloat();
    }

    public Vector2f round() {
        return ceil(thisOrNew());
    }

    public Vector2f set(float f2) {
        return set(f2, f2);
    }

    public Vector2f setComponent(int i2, float f2) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = f2;
        } else if (i2 == 1) {
            this.y = f2;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector2f sub(Vector2fc vector2fc) {
        return sub(vector2fc, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.x);
        objectOutput.writeFloat(this.y);
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public Vector2f zero() {
        return thisOrNew().set(0.0f, 0.0f);
    }

    public Vector2f(float f2) {
        this(f2, f2);
    }

    public static float length(float f2, float f3) {
        return (float) Math.sqrt((double) lengthSquared(f2, f3));
    }

    public Vector2f add(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.x = vector2fc.x() + this.x;
        vector2f.y = vector2fc.y() + this.y;
        return vector2f;
    }

    public Vector2f ceil(Vector2f vector2f) {
        vector2f.x = Math.ceil(this.x);
        vector2f.y = Math.ceil(this.y);
        return vector2f;
    }

    public float distance(float f2, float f3) {
        float f4 = this.x - f2;
        float f5 = this.y - f3;
        return (float) Math.sqrt((double) ((f5 * f5) + (f4 * f4)));
    }

    public float distanceSquared(float f2, float f3) {
        float f4 = this.x - f2;
        float f5 = this.y - f3;
        return (f5 * f5) + (f4 * f4);
    }

    public Vector2f floor(Vector2f vector2f) {
        vector2f.x = Math.floor(this.x);
        vector2f.y = Math.floor(this.y);
        return vector2f;
    }

    public Vector2f fma(float f2, Vector2fc vector2fc) {
        return fma(f2, vector2fc, thisOrNew());
    }

    public Vector2f lerp(Vector2fc vector2fc, float f2, Vector2f vector2f) {
        vector2f.x = a.e(vector2fc.x(), this.x, f2, this.x);
        vector2f.y = a.e(vector2fc.y(), this.y, f2, this.y);
        return vector2f;
    }

    public Vector2f max(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.x = this.x > vector2fc.x() ? this.x : vector2fc.x();
        vector2f.y = this.y > vector2fc.y() ? this.y : vector2fc.y();
        return vector2f;
    }

    public Vector2f min(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.x = this.x < vector2fc.x() ? this.x : vector2fc.x();
        vector2f.y = this.y < vector2fc.y() ? this.y : vector2fc.y();
        return vector2f;
    }

    public Vector2f mul(float f2, Vector2f vector2f) {
        vector2f.x = this.x * f2;
        vector2f.y = this.y * f2;
        return vector2f;
    }

    public Vector2f mulDirection(Matrix3x2fc matrix3x2fc, Vector2f vector2f) {
        vector2f.set((matrix3x2fc.m10() * this.y) + (matrix3x2fc.m00() * this.x), (matrix3x2fc.m11() * this.y) + (matrix3x2fc.m01() * this.x));
        return vector2f;
    }

    public Vector2f mulPosition(Matrix3x2fc matrix3x2fc, Vector2f vector2f) {
        vector2f.set(matrix3x2fc.m20() + (matrix3x2fc.m10() * this.y) + (matrix3x2fc.m00() * this.x), matrix3x2fc.m21() + (matrix3x2fc.m11() * this.y) + (matrix3x2fc.m01() * this.x));
        return vector2f;
    }

    public Vector2f negate(Vector2f vector2f) {
        vector2f.x = -this.x;
        vector2f.y = -this.y;
        return vector2f;
    }

    public Vector2f normalize(Vector2f vector2f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f4 * f4) + f3)));
        vector2f.x = this.x * sqrt;
        vector2f.y = this.y * sqrt;
        return vector2f;
    }

    public Vector2f round(Vector2f vector2f) {
        vector2f.x = (float) Math.round(this.x);
        vector2f.y = (float) Math.round(this.y);
        return vector2f;
    }

    public Vector2f set(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        return this;
    }

    public Vector2f sub(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.x = this.x - vector2fc.x();
        vector2f.y = this.y - vector2fc.y();
        return vector2f;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a.b(numberFormat, (double) this.x, a2, " ");
        return a.a(numberFormat, (double) this.y, a2, ")");
    }

    public Vector2f(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public Vector2f fma(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2f vector2f) {
        vector2f.x = (vector2fc2.x() * vector2fc.x()) + this.x;
        vector2f.y = (vector2fc2.y() * vector2fc.y()) + this.y;
        return vector2f;
    }

    public Vector2f add(float f2, float f3) {
        return add(f2, f3, thisOrNew());
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector2f mul(float f2, float f3) {
        return mul(f2, f3, thisOrNew());
    }

    public Vector2f set(Vector2fc vector2fc) {
        return set(vector2fc.x(), vector2fc.y());
    }

    public Vector2f sub(float f2, float f3) {
        return sub(f2, f3, thisOrNew());
    }

    public static float distance(float f2, float f3, float f4, float f5) {
        return (float) Math.sqrt((double) distanceSquared(f2, f3, f4, f5));
    }

    public Vector2f add(float f2, float f3, Vector2f vector2f) {
        vector2f.x = this.x + f2;
        vector2f.y = this.y + f3;
        return vector2f;
    }

    public boolean equals(Vector2fc vector2fc, float f2) {
        if (this == vector2fc) {
            return true;
        }
        return vector2fc != null && Runtime.equals(this.x, vector2fc.x(), f2) && Runtime.equals(this.y, vector2fc.y(), f2);
    }

    public Vector2f fma(float f2, Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.x = (vector2fc.x() * f2) + this.x;
        vector2f.y = (vector2fc.y() * f2) + this.y;
        return vector2f;
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector2f mul(float f2, float f3, Vector2f vector2f) {
        vector2f.x = this.x * f2;
        vector2f.y = this.y * f3;
        return vector2f;
    }

    public Vector2f normalize(float f2) {
        return normalize(f2, thisOrNew());
    }

    public Vector2f set(Vector2ic vector2ic) {
        return set((float) vector2ic.x(), (float) vector2ic.y());
    }

    public Vector2f sub(float f2, float f3, Vector2f vector2f) {
        vector2f.x = this.x - f2;
        vector2f.y = this.y - f3;
        return vector2f;
    }

    public Vector2f(Vector2fc vector2fc) {
        this.x = vector2fc.x();
        this.y = vector2fc.y();
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public Vector2f normalize(float f2, Vector2f vector2f) {
        float f3 = this.x;
        float f4 = f3 * f3;
        float f5 = this.y;
        float sqrt = ((float) (1.0d / Math.sqrt((double) ((f5 * f5) + f4)))) * f2;
        vector2f.x = this.x * sqrt;
        vector2f.y = this.y * sqrt;
        return vector2f;
    }

    public Vector2f set(Vector2dc vector2dc) {
        return set((float) vector2dc.x(), (float) vector2dc.y());
    }

    public boolean equals(float f2, float f3) {
        if (Float.floatToIntBits(this.x) == Float.floatToIntBits(f2) && Float.floatToIntBits(this.y) == Float.floatToIntBits(f3)) {
            return true;
        }
        return false;
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Vector2f mul(Vector2fc vector2fc) {
        return mul(vector2fc, thisOrNew());
    }

    public Vector2f set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector2f mul(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.x = vector2fc.x() * this.x;
        vector2f.y = vector2fc.y() * this.y;
        return vector2f;
    }

    public Vector2f set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector2f(Vector2ic vector2ic) {
        this.x = (float) vector2ic.x();
        this.y = (float) vector2ic.y();
    }

    public Vector2f set(FloatBuffer floatBuffer) {
        return set(floatBuffer.position(), floatBuffer);
    }

    public Vector2f set(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, i2, floatBuffer);
        return this;
    }

    public Vector2f(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector2f(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector2f(FloatBuffer floatBuffer) {
        this(floatBuffer.position(), floatBuffer);
    }

    public Vector2f(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, i2, floatBuffer);
    }
}
