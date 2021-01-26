package com.arashivision.insbase.joml;

import e.a.a.a.a;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Matrix3x2fStack extends Matrix3x2f {
    public static final long serialVersionUID = 1;
    public int curr;
    public Matrix3x2f[] mats;

    public Matrix3x2fStack(int i2) {
        if (i2 >= 1) {
            this.mats = new Matrix3x2f[(i2 - 1)];
            int i3 = 0;
            while (true) {
                Matrix3x2f[] matrix3x2fArr = this.mats;
                if (i3 < matrix3x2fArr.length) {
                    matrix3x2fArr[i3] = new Matrix3x2f();
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("stackSize must be >= 1");
        }
    }

    public Matrix3x2fStack clear() {
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
        if (obj instanceof Matrix3x2fStack) {
            Matrix3x2fStack matrix3x2fStack = (Matrix3x2fStack) obj;
            if (this.curr != matrix3x2fStack.curr) {
                return false;
            }
            for (int i2 = 0; i2 < this.curr; i2++) {
                if (!this.mats[i2].equals(matrix3x2fStack.mats[i2])) {
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

    public Matrix3x2fStack popMatrix() {
        int i2 = this.curr;
        if (i2 != 0) {
            Matrix3x2f[] matrix3x2fArr = this.mats;
            int i3 = i2 - 1;
            this.curr = i3;
            set((Matrix3x2fc) matrix3x2fArr[i3]);
            return this;
        }
        throw new IllegalStateException("already at the buttom of the stack");
    }

    public Matrix3x2fStack pushMatrix() {
        int i2 = this.curr;
        Matrix3x2f[] matrix3x2fArr = this.mats;
        if (i2 != matrix3x2fArr.length) {
            this.curr = i2 + 1;
            matrix3x2fArr[i2].set((Matrix3x2fc) this);
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
        this.mats = new Matrix3x2fStack[readInt];
        for (int i2 = 0; i2 < this.curr; i2++) {
            Matrix3x2f matrix3x2f = new Matrix3x2f();
            matrix3x2f.readExternal(objectInput);
            this.mats[i2] = matrix3x2f;
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);
        objectOutput.writeInt(this.curr);
        for (int i2 = 0; i2 < this.curr; i2++) {
            objectOutput.writeObject(this.mats[i2]);
        }
    }

    public Matrix3x2fStack() {
    }
}