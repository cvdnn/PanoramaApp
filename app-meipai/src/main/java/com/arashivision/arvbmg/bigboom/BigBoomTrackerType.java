package com.arashivision.arvbmg.bigboom;

public enum BigBoomTrackerType {
    NormalBigBoomTracker(1),
    StereoGraphicBigBoomTracker(2);
    
    public int value;

    /* access modifiers changed from: public */
    BigBoomTrackerType(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
