package com.arashivision.insbase.joml.sampling;

import com.arashivision.insbase.joml.Random;

public class SpiralSampling {
    public final Random rnd;

    public SpiralSampling(long j2) {
        this.rnd = new Random(j2);
    }

    public void createEquiAngle(float f2, int i2, int i3, Callback2d callback2d) {
        for (int i4 = 0; i4 < i3; i4++) {
            float f3 = (((float) (i4 * i2)) * 6.2831855f) / ((float) i3);
            float f4 = (((float) i4) * f2) / ((float) (i3 - 1));
            callback2d.onNewSample(((float) Math.sin_roquen_9((double) (1.5707964f + f3))) * f4, ((float) Math.sin_roquen_9((double) f3)) * f4);
        }
    }

    public void createEquiAngle(float f2, int i2, int i3, float f3, Callback2d callback2d) {
        float f4 = f2 / ((float) i2);
        for (int i4 = 0; i4 < i3; i4++) {
            float f5 = (((float) (i4 * i2)) * 6.2831855f) / ((float) i3);
            float nextFloat = (((this.rnd.nextFloat() * 2.0f) - 1.0f) * f4 * f3) + ((((float) i4) * f2) / ((float) (i3 - 1)));
            callback2d.onNewSample(((float) Math.sin_roquen_9((double) (1.5707964f + f5))) * nextFloat, ((float) Math.sin_roquen_9((double) f5)) * nextFloat);
        }
    }
}
