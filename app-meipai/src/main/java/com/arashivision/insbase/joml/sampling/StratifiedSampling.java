package com.arashivision.insbase.joml.sampling;

import com.arashivision.insbase.joml.Random;

public class StratifiedSampling {
    public final Random rnd;

    public StratifiedSampling(long j2) {
        this.rnd = new Random(j2);
    }

    public void generateCentered(int i2, float f2, Callback2d callback2d) {
        float f3 = 0.5f * f2;
        float f4 = 1.0f - f2;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                float f5 = (float) i2;
                callback2d.onNewSample((((((float) i4) / f5) + (((this.rnd.nextFloat() * f4) + f3) / f5)) * 2.0f) - 1.0f, (((((float) i3) / f5) + (((this.rnd.nextFloat() * f4) + f3) / f5)) * 2.0f) - 1.0f);
            }
        }
    }

    public void generateRandom(int i2, Callback2d callback2d) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                float f2 = (float) i2;
                callback2d.onNewSample((((((float) i4) / f2) + (this.rnd.nextFloat() / f2)) * 2.0f) - 1.0f, (((((float) i3) / f2) + (this.rnd.nextFloat() / f2)) * 2.0f) - 1.0f);
            }
        }
    }
}
