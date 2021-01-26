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
import java.nio.IntBuffer;
import java.text.NumberFormat;

public class Vector2i implements Externalizable, Vector2ic {
    public static final long serialVersionUID = 1;
    public int x;
    public int y;

    public Vector2i() {
    }

    public static long distanceSquared(int i2, int i3, int i4, int i5) {
        int i6 = i2 - i4;
        int i7 = i3 - i5;
        return (long) ((i7 * i7) + (i6 * i6));
    }

    public static long lengthSquared(int i2, int i3) {
        return (long) ((i3 * i3) + (i2 * i2));
    }

    private Vector2i thisOrNew() {
        return this;
    }

    public Vector2i add(Vector2ic vector2ic) {
        return add(vector2ic, thisOrNew());
    }

    public double distance(Vector2ic vector2ic) {
        return Math.sqrt((double) distanceSquared(vector2ic));
    }

    public long distanceSquared(Vector2ic vector2ic) {
        int x2 = this.x - vector2ic.x();
        int y2 = this.y - vector2ic.y();
        return (long) ((y2 * y2) + (x2 * x2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector2i.class != obj.getClass()) {
            return false;
        }
        Vector2i vector2i = (Vector2i) obj;
        return this.x == vector2i.x && this.y == vector2i.y;
    }

    public int get(int i2) throws IllegalArgumentException {
        if (i2 == 0) {
            return this.x;
        }
        if (i2 == 1) {
            return this.y;
        }
        throw new IllegalArgumentException();
    }

    public long gridDistance(Vector2ic vector2ic) {
        return (long) (Math.abs(vector2ic.y() - y()) + Math.abs(vector2ic.x() - x()));
    }

    public int hashCode() {
        return ((this.x + 31) * 31) + this.y;
    }

    public double length() {
        return Math.sqrt((double) lengthSquared());
    }

    public long lengthSquared() {
        return lengthSquared(this.x, this.y);
    }

    public Vector2i max(Vector2ic vector2ic) {
        return max(vector2ic, thisOrNew());
    }

    public int maxComponent() {
        return Math.abs(this.x) >= Math.abs(this.y) ? 0 : 1;
    }

    public Vector2i min(Vector2ic vector2ic) {
        return min(vector2ic, thisOrNew());
    }

    public int minComponent() {
        return Math.abs(this.x) < Math.abs(this.y) ? 0 : 1;
    }

    public Vector2i mul(int i2) {
        return mul(i2, thisOrNew());
    }

    public Vector2i negate() {
        return negate(thisOrNew());
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readInt();
        this.y = objectInput.readInt();
    }

    public Vector2i set(int i2) {
        return set(i2, i2);
    }

    public Vector2i setComponent(int i2, int i3) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = i3;
        } else if (i2 == 1) {
            this.y = i3;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector2i sub(Vector2ic vector2ic) {
        return sub(vector2ic, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.x);
        objectOutput.writeInt(this.y);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public Vector2i zero() {
        return thisOrNew().set(0, 0);
    }

    public Vector2i(int i2) {
        this.x = i2;
        this.y = i2;
    }

    public static double length(int i2, int i3) {
        return Math.sqrt((double) lengthSquared(i2, i3));
    }

    public Vector2i add(Vector2ic vector2ic, Vector2i vector2i) {
        vector2i.x = vector2ic.x() + this.x;
        vector2i.y = vector2ic.y() + this.y;
        return vector2i;
    }

    public double distance(int i2, int i3) {
        return Math.sqrt((double) distanceSquared(i2, i3));
    }

    public long gridDistance(int i2, int i3) {
        return (long) (Math.abs(i3 - y()) + Math.abs(i2 - x()));
    }

    public Vector2i max(Vector2ic vector2ic, Vector2i vector2i) {
        vector2i.x = this.x > vector2ic.x() ? this.x : vector2ic.x();
        vector2i.y = this.y > vector2ic.y() ? this.y : vector2ic.y();
        return vector2i;
    }

    public Vector2i min(Vector2ic vector2ic, Vector2i vector2i) {
        vector2i.x = this.x < vector2ic.x() ? this.x : vector2ic.x();
        vector2i.y = this.y < vector2ic.y() ? this.y : vector2ic.y();
        return vector2i;
    }

    public Vector2i mul(int i2, Vector2i vector2i) {
        vector2i.x = this.x * i2;
        vector2i.y = this.y * i2;
        return vector2i;
    }

    public Vector2i negate(Vector2i vector2i) {
        vector2i.x = -this.x;
        vector2i.y = -this.y;
        return vector2i;
    }

    public Vector2i set(int i2, int i3) {
        this.x = i2;
        this.y = i3;
        return this;
    }

    public Vector2i sub(Vector2ic vector2ic, Vector2i vector2i) {
        vector2i.x = this.x - vector2ic.x();
        vector2i.y = this.y - vector2ic.y();
        return vector2i;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a2.append(numberFormat.format((long) this.x));
        a2.append(" ");
        a2.append(numberFormat.format((long) this.y));
        a2.append(")");
        return a2.toString();
    }

    public static double distance(int i2, int i3, int i4, int i5) {
        return Math.sqrt((double) distanceSquared(i2, i3, i4, i5));
    }

    public long distanceSquared(int i2, int i3) {
        int i4 = this.x - i2;
        int i5 = this.y - i3;
        return (long) ((i5 * i5) + (i4 * i4));
    }

    public Vector2i add(int i2, int i3) {
        return add(i2, i3, thisOrNew());
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector2i mul(Vector2ic vector2ic) {
        return mul(vector2ic, thisOrNew());
    }

    public Vector2i set(Vector2ic vector2ic) {
        return set(vector2ic.x(), vector2ic.y());
    }

    public Vector2i sub(int i2, int i3) {
        return sub(i2, i3, thisOrNew());
    }

    public Vector2i(int i2, int i3) {
        this.x = i2;
        this.y = i3;
    }

    public Vector2i add(int i2, int i3, Vector2i vector2i) {
        vector2i.x = this.x + i2;
        vector2i.y = this.y + i3;
        return vector2i;
    }

    public boolean equals(int i2, int i3) {
        if (this.x == i2 && this.y == i3) {
            return true;
        }
        return false;
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector2i mul(Vector2ic vector2ic, Vector2i vector2i) {
        vector2i.x = vector2ic.x() * this.x;
        vector2i.y = vector2ic.y() * this.y;
        return vector2i;
    }

    public Vector2i set(Vector2dc vector2dc) {
        return set((int) vector2dc.x(), (int) vector2dc.y());
    }

    public Vector2i sub(int i2, int i3, Vector2i vector2i) {
        vector2i.x = this.x - i2;
        vector2i.y = this.y - i3;
        return vector2i;
    }

    public IntBuffer get(IntBuffer intBuffer) {
        return get(intBuffer.position(), intBuffer);
    }

    public Vector2i set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public IntBuffer get(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.put(this, i2, intBuffer);
        return intBuffer;
    }

    public Vector2i mul(int i2, int i3) {
        return mul(i2, i3, thisOrNew());
    }

    public Vector2i set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector2i(Vector2ic vector2ic) {
        this.x = vector2ic.x();
        this.y = vector2ic.y();
    }

    public Vector2i mul(int i2, int i3, Vector2i vector2i) {
        vector2i.x = this.x * i2;
        vector2i.y = this.y * i3;
        return vector2i;
    }

    public Vector2i set(IntBuffer intBuffer) {
        return set(intBuffer.position(), intBuffer);
    }

    public Vector2i set(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.get(this, i2, intBuffer);
        return this;
    }

    public Vector2i(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector2i(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector2i(IntBuffer intBuffer) {
        this(intBuffer.position(), intBuffer);
    }

    public Vector2i(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.get(this, i2, intBuffer);
    }
}
