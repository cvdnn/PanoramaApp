package com.arashivision.onestream.Gyro;

public enum GyroType {
    Unknown(0),
    Air(1),
    One(2),
    One2(3),
    EVO3D_Z90(4),
    EVO3D_3D(5),
    OneR(6);
    
    public final int typeVar;

    /* access modifiers changed from: public */
    GyroType(int i2) {
        this.typeVar = i2;
    }

    public int value() {
        return this.typeVar;
    }
}
