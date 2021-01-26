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

public class Vector4i implements Externalizable, Vector4ic {
    public static final long serialVersionUID = 1;
    public int w;
    public int x;
    public int y;
    public int z;

    public Vector4i() {
        this.w = 1;
    }

    public static long distanceSquared(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i2 - i6;
        int i11 = i3 - i7;
        int i12 = i4 - i8;
        int i13 = i5 - i9;
        return (long) ((i13 * i13) + (i12 * i12) + (i11 * i11) + (i10 * i10));
    }

    public static long lengthSquared(int i2, int i3, int i4, int i5) {
        return (long) ((i5 * i5) + (i4 * i4) + (i3 * i3) + (i2 * i2));
    }

    private Vector4i thisOrNew() {
        return this;
    }

    public Vector4i add(Vector4ic vector4ic) {
        return add(vector4ic, thisOrNew());
    }

    public double distance(Vector4ic vector4ic) {
        return distance(vector4ic.x(), vector4ic.y(), vector4ic.z(), vector4ic.w());
    }

    public int distanceSquared(Vector4ic vector4ic) {
        return distanceSquared(vector4ic.x(), vector4ic.y(), vector4ic.z(), vector4ic.w());
    }

    public Vector4i div(Vector4ic vector4ic) {
        return div(vector4ic, thisOrNew());
    }

    public int dot(Vector4ic vector4ic) {
        return (vector4ic.w() * this.w) + (vector4ic.z() * this.z) + (vector4ic.y() * this.y) + (vector4ic.x() * this.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector4i.class != obj.getClass()) {
            return false;
        }
        Vector4i vector4i = (Vector4i) obj;
        return this.x == vector4i.x && this.y == vector4i.y && this.z == vector4i.z && this.w == vector4i.w;
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
        if (i2 == 3) {
            return this.w;
        }
        throw new IllegalArgumentException();
    }

    public long gridDistance(Vector4ic vector4ic) {
        return (long) (Math.abs(vector4ic.w() - w()) + Math.abs(vector4ic.z() - z()) + Math.abs(vector4ic.y() - y()) + Math.abs(vector4ic.x() - x()));
    }

    public int hashCode() {
        return ((((((this.x + 31) * 31) + this.y) * 31) + this.z) * 31) + this.w;
    }

    public double length() {
        return Math.sqrt((double) lengthSquared());
    }

    public long lengthSquared() {
        return lengthSquared(this.x, this.y, this.z, this.w);
    }

    public Vector4i max(Vector4ic vector4ic) {
        return max(vector4ic, thisOrNew());
    }

    public int maxComponent() {
        int abs = Math.abs(this.x);
        int abs2 = Math.abs(this.y);
        int abs3 = Math.abs(this.z);
        int abs4 = Math.abs(this.w);
        if (abs >= abs2 && abs >= abs3 && abs >= abs4) {
            return 0;
        }
        if (abs2 < abs3 || abs2 < abs4) {
            return abs3 >= abs4 ? 2 : 3;
        }
        return 1;
    }

    public Vector4i min(Vector4ic vector4ic) {
        return min(vector4ic, thisOrNew());
    }

    public int minComponent() {
        int abs = Math.abs(this.x);
        int abs2 = Math.abs(this.y);
        int abs3 = Math.abs(this.z);
        int abs4 = Math.abs(this.w);
        if (abs < abs2 && abs < abs3 && abs < abs4) {
            return 0;
        }
        if (abs2 >= abs3 || abs2 >= abs4) {
            return abs3 < abs4 ? 2 : 3;
        }
        return 1;
    }

    public Vector4i mul(Vector4ic vector4ic) {
        return mul(vector4ic, thisOrNew());
    }

    public Vector4i negate() {
        return negate(thisOrNew());
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readInt();
        this.y = objectInput.readInt();
        this.z = objectInput.readInt();
        this.w = objectInput.readInt();
    }

    public Vector4i set(Vector4ic vector4ic) {
        if (vector4ic instanceof Vector4i) {
            MemUtil.INSTANCE.copy((Vector4i) vector4ic, this);
        } else {
            this.x = vector4ic.x();
            this.y = vector4ic.y();
            this.z = vector4ic.z();
            this.w = vector4ic.w();
        }
        return this;
    }

    public Vector4i setComponent(int i2, int i3) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = i3;
        } else if (i2 == 1) {
            this.y = i3;
        } else if (i2 == 2) {
            this.z = i3;
        } else if (i2 == 3) {
            this.w = i3;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector4i sub(Vector4ic vector4ic) {
        return sub(vector4ic, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public int w() {
        return this.w;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.x);
        objectOutput.writeInt(this.y);
        objectOutput.writeInt(this.z);
        objectOutput.writeInt(this.w);
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

    public Vector4i zero() {
        Vector4i thisOrNew = thisOrNew();
        MemUtil.INSTANCE.zero(thisOrNew);
        return thisOrNew;
    }

    public static double length(int i2, int i3, int i4, int i5) {
        return Math.sqrt((double) lengthSquared(i2, i3, i4, i5));
    }

    public Vector4i add(Vector4ic vector4ic, Vector4i vector4i) {
        return add(vector4ic.x(), vector4ic.y(), vector4ic.z(), vector4ic.w(), vector4i);
    }

    public double distance(int i2, int i3, int i4, int i5) {
        return Math.sqrt((double) distanceSquared(i2, i3, i4, i5));
    }

    public int distanceSquared(int i2, int i3, int i4, int i5) {
        int i6 = this.x - i2;
        int i7 = this.y - i3;
        int i8 = this.z - i4;
        int i9 = this.w - i5;
        return (i9 * i9) + (i8 * i8) + (i7 * i7) + (i6 * i6);
    }

    public Vector4i div(Vector4ic vector4ic, Vector4i vector4i) {
        vector4i.x = this.x / vector4ic.x();
        vector4i.y = this.y / vector4ic.y();
        vector4i.z = this.z / vector4ic.z();
        vector4i.w = this.w / vector4ic.w();
        return vector4i;
    }

    public long gridDistance(int i2, int i3, int i4, int i5) {
        return (long) (Math.abs(i5 - w()) + Math.abs(i4 - z()) + Math.abs(i3 - y()) + Math.abs(i2 - x()));
    }

    public Vector4i max(Vector4ic vector4ic, Vector4i vector4i) {
        vector4i.x = this.x > vector4ic.x() ? this.x : vector4ic.x();
        vector4i.y = this.y > vector4ic.y() ? this.y : vector4ic.y();
        vector4i.z = this.z > vector4ic.z() ? this.z : vector4ic.z();
        vector4i.w = this.w > vector4ic.w() ? this.w : vector4ic.w();
        return vector4i;
    }

    public Vector4i min(Vector4ic vector4ic, Vector4i vector4i) {
        vector4i.x = this.x < vector4ic.x() ? this.x : vector4ic.x();
        vector4i.y = this.y < vector4ic.y() ? this.y : vector4ic.y();
        vector4i.z = this.z < vector4ic.z() ? this.z : vector4ic.z();
        vector4i.w = this.w < vector4ic.w() ? this.w : vector4ic.w();
        return vector4i;
    }

    public Vector4i mul(Vector4ic vector4ic, Vector4i vector4i) {
        vector4i.x = vector4ic.x() * this.x;
        vector4i.y = vector4ic.y() * this.y;
        vector4i.z = vector4ic.z() * this.z;
        vector4i.w = vector4ic.w() * this.w;
        return vector4i;
    }

    public Vector4i negate(Vector4i vector4i) {
        vector4i.x = -this.x;
        vector4i.y = -this.y;
        vector4i.z = -this.z;
        vector4i.w = -this.w;
        return vector4i;
    }

    public Vector4i sub(int i2, int i3, int i4, int i5) {
        return sub(i2, i3, i4, i5, thisOrNew());
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a2.append(numberFormat.format((long) this.x));
        String str = " ";
        a2.append(str);
        a2.append(numberFormat.format((long) this.y));
        a2.append(str);
        a2.append(numberFormat.format((long) this.z));
        a2.append(str);
        a2.append(numberFormat.format((long) this.w));
        a2.append(")");
        return a2.toString();
    }

    public Vector4i(Vector4ic vector4ic) {
        if (vector4ic instanceof Vector4i) {
            MemUtil.INSTANCE.copy((Vector4i) vector4ic, this);
            return;
        }
        this.x = vector4ic.x();
        this.y = vector4ic.y();
        this.z = vector4ic.z();
        this.w = vector4ic.w();
    }

    public static double distance(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return Math.sqrt((double) distanceSquared(i2, i3, i4, i5, i6, i7, i8, i9));
    }

    public Vector4i add(int i2, int i3, int i4, int i5) {
        return add(i2, i3, i4, i5, thisOrNew());
    }

    public Vector4i sub(Vector4ic vector4ic, Vector4i vector4i) {
        return sub(vector4ic.x(), vector4ic.y(), vector4ic.z(), vector4ic.w(), vector4i);
    }

    public Vector4i add(int i2, int i3, int i4, int i5, Vector4i vector4i) {
        vector4i.x = this.x + i2;
        vector4i.y = this.y + i3;
        vector4i.z = this.z + i4;
        vector4i.w = this.w + i5;
        return vector4i;
    }

    public Vector4i sub(int i2, int i3, int i4, int i5, Vector4i vector4i) {
        vector4i.x = this.x - i2;
        vector4i.y = this.y - i3;
        vector4i.z = this.z - i4;
        vector4i.w = this.w - i5;
        return vector4i;
    }

    public Vector4i div(int i2) {
        return div((float) i2, thisOrNew());
    }

    public IntBuffer get(IntBuffer intBuffer) {
        return get(intBuffer.position(), intBuffer);
    }

    public Vector4i mul(int i2) {
        return mul(i2, thisOrNew());
    }

    public Vector4i div(float f2, Vector4i vector4i) {
        vector4i.x = (int) (((float) this.x) / f2);
        vector4i.y = (int) (((float) this.y) / f2);
        vector4i.z = (int) (((float) this.z) / f2);
        vector4i.w = (int) (((float) this.w) / f2);
        return vector4i;
    }

    public boolean equals(int i2, int i3, int i4, int i5) {
        if (this.x == i2 && this.y == i3 && this.z == i4 && this.w == i5) {
            return true;
        }
        return false;
    }

    public IntBuffer get(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.put(this, i2, intBuffer);
        return intBuffer;
    }

    public Vector4i mul(int i2, Vector4i vector4i) {
        vector4i.x = this.x * i2;
        vector4i.y = this.y * i2;
        vector4i.z = this.z * i2;
        vector4i.w = this.w * i2;
        return vector4i;
    }

    public Vector4i set(Vector3ic vector3ic, int i2) {
        return set(vector3ic.x(), vector3ic.y(), vector3ic.z(), i2);
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector4i set(Vector2ic vector2ic, int i2, int i3) {
        return set(vector2ic.x(), vector2ic.y(), i2, i3);
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector4i set(int i2) {
        MemUtil.INSTANCE.broadcast(i2, this);
        return this;
    }

    public Vector4i(Vector3ic vector3ic, int i2) {
        this(vector3ic.x(), vector3ic.y(), vector3ic.z(), i2);
    }

    public Vector4i set(int i2, int i3, int i4, int i5) {
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.w = i5;
        return this;
    }

    public Vector4i(Vector2ic vector2ic, int i2, int i3) {
        this(vector2ic.x(), vector2ic.y(), i2, i3);
    }

    public Vector4i(int i2) {
        MemUtil.INSTANCE.broadcast(i2, this);
    }

    public Vector4i(int i2, int i3, int i4, int i5) {
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.w = i5;
    }

    public Vector4i set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector4i set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector4i set(IntBuffer intBuffer) {
        return set(intBuffer.position(), intBuffer);
    }

    public Vector4i set(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.get(this, i2, intBuffer);
        return this;
    }

    public Vector4i(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector4i(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector4i(IntBuffer intBuffer) {
        this(intBuffer.position(), intBuffer);
    }

    public Vector4i(int i2, IntBuffer intBuffer) {
        MemUtil.INSTANCE.get(this, i2, intBuffer);
    }
}
