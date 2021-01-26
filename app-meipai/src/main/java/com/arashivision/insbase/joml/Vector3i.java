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

public class Vector3i implements Externalizable, Vector3ic {
    public static final long serialVersionUID = 1;
    public int x;
    public int y;
    public int z;

    public Vector3i() {
    }

    public static long distanceSquared(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i2 - i5;
        int i9 = i3 - i6;
        int i10 = i4 - i7;
        return (long) ((i10 * i10) + (i9 * i9) + (i8 * i8));
    }

    public static long lengthSquared(int i2, int i3, int i4) {
        return (long) ((i4 * i4) + (i3 * i3) + (i2 * i2));
    }

    private Vector3i thisOrNew() {
        return this;
    }

    public Vector3i add(Vector3ic vector3ic) {
        return add(vector3ic.x(), vector3ic.y(), vector3ic.z(), thisOrNew());
    }

    public double distance(Vector3ic vector3ic) {
        return distance(vector3ic.x(), vector3ic.y(), vector3ic.z());
    }

    public long distanceSquared(Vector3ic vector3ic) {
        return distanceSquared(vector3ic.x(), vector3ic.y(), vector3ic.z());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector3i.class != obj.getClass()) {
            return false;
        }
        Vector3i vector3i = (Vector3i) obj;
        return this.x == vector3i.x && this.y == vector3i.y && this.z == vector3i.z;
    }

    public int get(int i2) throws IllegalArgumentException {
        if (i2 == 0) {
            return this.x;
        }
        if (i2 == 1) {
            return this.y;
        }
        if (i2 == 2) {
            return this.z;
        }
        throw new IllegalArgumentException();
    }

    public long gridDistance(Vector3ic vector3ic) {
        return (long) (Math.abs(vector3ic.z() - z()) + Math.abs(vector3ic.y() - y()) + Math.abs(vector3ic.x() - x()));
    }

    public int hashCode() {
        return ((((this.x + 31) * 31) + this.y) * 31) + this.z;
    }

    public double length() {
        return Math.sqrt((double) lengthSquared());
    }

    public long lengthSquared() {
        return lengthSquared(this.x, this.y, this.z);
    }

    public Vector3i max(Vector3ic vector3ic) {
        return max(vector3ic, thisOrNew());
    }

    public int maxComponent() {
        float abs = (float) Math.abs(this.x);
        float abs2 = (float) Math.abs(this.y);
        float abs3 = (float) Math.abs(this.z);
        if (abs < abs2 || abs < abs3) {
            return abs2 >= abs3 ? 1 : 2;
        }
        return 0;
    }

    public Vector3i min(Vector3ic vector3ic) {
        return min(vector3ic, thisOrNew());
    }

    public int minComponent() {
        float abs = (float) Math.abs(this.x);
        float abs2 = (float) Math.abs(this.y);
        float abs3 = (float) Math.abs(this.z);
        if (abs >= abs2 || abs >= abs3) {
            return abs2 < abs3 ? 1 : 2;
        }
        return 0;
    }

    public Vector3i mul(int i2) {
        return mul(i2, thisOrNew());
    }

    public Vector3i negate() {
        return negate(thisOrNew());
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readInt();
        this.y = objectInput.readInt();
        this.z = objectInput.readInt();
    }

    public Vector3i set(Vector3ic vector3ic) {
        this.x = vector3ic.x();
        this.y = vector3ic.y();
        this.z = vector3ic.z();
        return this;
    }

    public Vector3i setComponent(int i2, int i3) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = i3;
        } else if (i2 == 1) {
            this.y = i3;
        } else if (i2 == 2) {
            this.z = i3;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector3i sub(Vector3ic vector3ic) {
        return sub(vector3ic.x(), vector3ic.y(), vector3ic.z(), thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.x);
        objectOutput.writeInt(this.y);
        objectOutput.writeInt(this.z);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int z() {
        return this.z;
    }

    public Vector3i zero() {
        return thisOrNew().set(0, 0, 0);
    }

    public Vector3i(int i2) {
        this(i2, i2, i2);
    }

    public static double length(int i2, int i3, int i4) {
        return Math.sqrt((double) lengthSquared(i2, i3, i4));
    }

    public Vector3i add(Vector3ic vector3ic, Vector3i vector3i) {
        vector3i.x = vector3ic.x() + this.x;
        vector3i.y = vector3ic.y() + this.y;
        vector3i.z = vector3ic.z() + this.z;
        return vector3i;
    }

    public double distance(int i2, int i3, int i4) {
        return Math.sqrt((double) distanceSquared(i2, i3, i4));
    }

    public long distanceSquared(int i2, int i3, int i4) {
        int i5 = this.x - i2;
        int i6 = this.y - i3;
        int i7 = this.z - i4;
        return (long) ((i7 * i7) + (i6 * i6) + (i5 * i5));
    }

    public long gridDistance(int i2, int i3, int i4) {
        return (long) (Math.abs(i4 - z()) + Math.abs(i3 - y()) + Math.abs(i2 - x()));
    }

    public Vector3i max(Vector3ic vector3ic, Vector3i vector3i) {
        vector3i.x = this.x > vector3ic.x() ? this.x : vector3ic.x();
        vector3i.y = this.y > vector3ic.y() ? this.y : vector3ic.y();
        vector3i.z = this.z > vector3ic.z() ? this.z : vector3ic.z();
        return vector3i;
    }

    public Vector3i min(Vector3ic vector3ic, Vector3i vector3i) {
        vector3i.x = this.x < vector3ic.x() ? this.x : vector3ic.x();
        vector3i.y = this.y < vector3ic.y() ? this.y : vector3ic.y();
        vector3i.z = this.z < vector3ic.z() ? this.z : vector3ic.z();
        return vector3i;
    }

    public Vector3i mul(int i2, Vector3i vector3i) {
        vector3i.x = this.x * i2;
        vector3i.y = this.y * i2;
        vector3i.z = this.z * i2;
        return vector3i;
    }

    public Vector3i negate(Vector3i vector3i) {
        vector3i.x = -this.x;
        vector3i.y = -this.y;
        vector3i.z = -this.z;
        return vector3i;
    }

    public Vector3i sub(Vector3ic vector3ic, Vector3i vector3i) {
        vector3i.x = this.x - vector3ic.x();
        vector3i.y = this.y - vector3ic.y();
        vector3i.z = this.z - vector3ic.z();
        return vector3i;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a2.append(numberFormat.format((long) this.x));
        String str = " ";
        a2.append(str);
        a2.append(numberFormat.format((long) this.y));
        a2.append(str);
        a2.append(numberFormat.format((long) this.z));
        a2.append(")");
        return a2.toString();
    }

    public Vector3i(int i2, int i3, int i4) {
        this.x = i2;
        this.y = i3;
        this.z = i4;
    }

    public static double distance(int i2, int i3, int i4, int i5, int i6, int i7) {
        return Math.sqrt((double) distanceSquared(i2, i3, i4, i5, i6, i7));
    }

    public Vector3i set(Vector3dc vector3dc) {
        return set((int) vector3dc.x(), (int) vector3dc.y(), (int) vector3dc.z());
    }

    public Vector3i add(int i2, int i3, int i4) {
        return add(i2, i3, i4, thisOrNew());
    }

    public IntBuffer get(IntBuffer intBuffer) {
        return get(intBuffer.position(), intBuffer);
    }

    public Vector3i mul(Vector3ic vector3ic) {
        return mul(vector3ic.x(), vector3ic.y(), vector3ic.z(), thisOrNew());
    }

    public Vector3i set(Vector2ic vector2ic, int i2) {
        return set(vector2ic.x(), vector2ic.y(), i2);
    }

    public Vector3i sub(int i2, int i3, int i4) {
        return sub(i2, i3, i4, thisOrNew());
    }

    public Vector3i add(int i2, int i3, int i4, Vector3i vector3i) {
        vector3i.x = this.x + i2;
        vector3i.y = this.y + i3;
        vector3i.z = this.z + i4;
        return vector3i;
    }

    public boolean equals(int i2, int i3, int i4) {
        if (this.x == i2 && this.y == i3 && this.z == i4) {
            return true;
        }
        return false;
    }

    public IntBuffer get(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.put(this, i2, intBuffer);
        return intBuffer;
    }

    public Vector3i mul(Vector3ic vector3ic, Vector3i vector3i) {
        vector3i.x = vector3ic.x() * this.x;
        vector3i.y = vector3ic.y() * this.y;
        vector3i.z = vector3ic.z() * this.z;
        return vector3i;
    }

    public Vector3i set(int i2) {
        return set(i2, i2, i2);
    }

    public Vector3i sub(int i2, int i3, int i4, Vector3i vector3i) {
        vector3i.x = this.x - i2;
        vector3i.y = this.y - i3;
        vector3i.z = this.z - i4;
        return vector3i;
    }

    public Vector3i(Vector3ic vector3ic) {
        this(vector3ic.x(), vector3ic.y(), vector3ic.z());
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector3i set(int i2, int i3, int i4) {
        this.x = i2;
        this.y = i3;
        this.z = i4;
        return this;
    }

    public Vector3i(Vector2ic vector2ic, int i2) {
        this(vector2ic.x(), vector2ic.y(), i2);
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector3i(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector3i mul(int i2, int i3, int i4) {
        return mul(i2, i3, i4, thisOrNew());
    }

    public Vector3i(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector3i mul(int i2, int i3, int i4, Vector3i vector3i) {
        vector3i.x = this.x * i2;
        vector3i.y = this.y * i3;
        vector3i.z = this.z * i4;
        return vector3i;
    }

    public Vector3i set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector3i set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector3i(IntBuffer intBuffer) {
        this(intBuffer.position(), intBuffer);
    }

    public Vector3i set(IntBuffer intBuffer) {
        return set(intBuffer.position(), intBuffer);
    }

    public Vector3i(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.get(this, i2, intBuffer);
    }

    public Vector3i set(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.get(this, i2, intBuffer);
        return this;
    }
}
