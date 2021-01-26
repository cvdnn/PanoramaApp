package com.arashivision.arvbmg.trimjson;

public enum JsonTrimType {
    bigBoom(1),
    aiEditor(2),
    forword(3),
    protagonist(4),
    timeshift(5);
    
    public int value;

    /* access modifiers changed from: public */
    JsonTrimType(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
