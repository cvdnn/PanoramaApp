package com.arashivision.insbase.joml;

import e.a.a.a.a;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Matrix3x2dStack extends Matrix3x2d {
    public static final long serialVersionUID = 1;
    public int curr;
    public Matrix3x2d[] mats;

    public Matrix3x2dStack(int i2) {
        if (i2 >= 1) {
            this.mats = new Matrix3x2d[(i2 - 1)];
            int i3 = 0;
            while (true) {
                Matrix3x2d[] matrix3x2dArr = this.mats;
                if (i3 < matrix3x2dArr.length) {
                    matrix3x2dArr[i3] = new Matrix3x2d();
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("stackSize must be >= 1");
        }
    }

    public Matrix3x2dStack clear() {
        this.curr = 0;
        identity();
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Matrix3x2dStack) {
            Matrix3x2dStack matrix3x2dStack = (Matrix3x2dStack) obj;
            if (this.curr != matrix3x2dStack.curr) {
                return false;
            }
            for (int i2 = 0; i2 < this.curr; i2++) {
                if (!this.mats[i2].equals(matrix3x2dStack.mats[i2])) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (super.hashCode() * 31) + this.curr;
        for (int i2 = 0; i2 < this.curr; i2++) {
            hashCode = (hashCode * 31) + this.mats[i2].hashCode();
        }
        return hashCode;
    }

    public Matrix3x2dStack popMatrix() {
        int i2 = this.curr;
        if (i2 != 0) {
            Matrix3x2d[] matrix3x2dArr = this.mats;
            int i3 = i2 - 1;
            this.curr = i3;
            set((Matrix3x2dc) matrix3x2dArr[i3]);
            return this;
        }
        throw new IllegalStateException("already at the buttom of the stack");
    }

    public Matrix3x2dStack pushMatrix() {
        int i2 = this.curr;
        Matrix3x2d[] matrix3x2dArr = this.mats;
        if (i2 != matrix3x2dArr.length) {
            this.curr = i2 + 1;
            matrix3x2dArr[i2].set((Matrix3x2dc) this);
            return this;
        }
        StringBuilder a2 = a.a("max stack size of ");
        a2.append(this.curr + 1);
        a2.append(" reached");
        throw new IllegalStateException(a2.toString());
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        super.readExternal(objectInput);
        int readInt = objectInput.readInt();
        this.curr = readInt;
        this.mats = new Matrix3x2dStack[readInt];
        for (int i2 = 0; i2 < this.curr; i2++) {
            Matrix3x2d matrix3x2d = new Matrix3x2d();
            matrix3x2d.readExternal(objectInput);
            this.mats[i2] = matrix3x2d;
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);
        objectOutput.writeInt(this.curr);
        for (int i2 = 0; i2 < this.curr; i2++) {
            objectOutput.writeObject(this.mats[i2]);
        }
    }

    public Matrix3x2dStack() {
    }
}
