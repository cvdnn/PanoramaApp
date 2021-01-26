package com.arashivision.onestream;

public enum RenderWay {
    DirectDecoding(0),
    PlanarKeep(1),
    DualFishEyeStitchingPlanar(2);
    
    public final int id;

    /* access modifiers changed from: public */
    RenderWay(int i2) {
        this.id = i2;
    }

    public int value() {
        return this.id;
    }
}
