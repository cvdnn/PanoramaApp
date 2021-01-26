package com.arashivision.insbase.joml.sampling;

import com.arashivision.insbase.joml.Random;

public class UniformSampling {

    public static class Disk {
        public final Random rnd;

        public Disk(long j2, int i2, Callback2d callback2d) {
            this.rnd = new Random(j2);
            generate(i2, callback2d);
        }

        private void generate(int i2, Callback2d callback2d) {
            for (int i3 = 0; i3 < i2; i3++) {
                float sqrt = (float) Math.sqrt((double) this.rnd.nextFloat());
                double nextFloat = (double) (this.rnd.nextFloat() * 2.0f * 3.1415927f);
                callback2d.onNewSample(((float) Math.sin_roquen_9(1.5707963267948966d + nextFloat)) * sqrt, sqrt * ((float) Math.sin_roquen_9(nextFloat)));
            }
        }
    }

    public static class Sphere {
        public final Random rnd;

        public Sphere(long j2, int i2, Callback3d callback3d) {
            this.rnd = new Random(j2);
            generate(i2, callback3d);
        }

        public void generate(int i2, Callback3d callback3d) {
            int i3 = 0;
            while (i3 < i2) {
                float nextFloat = (this.rnd.nextFloat() * 2.0f) - 1.0f;
                float nextFloat2 = (this.rnd.nextFloat() * 2.0f) - 1.0f;
                float f2 = nextFloat * nextFloat;
                float f3 = nextFloat2 * nextFloat2;
                float f4 = f2 + f3;
                if (f4 < 1.0f) {
                    float sqrt = (float) Math.sqrt((1.0d - ((double) f2)) - ((double) f3));
                    callback3d.onNewSample(nextFloat * 2.0f * sqrt, nextFloat2 * 2.0f * sqrt, 1.0f - (f4 * 2.0f));
                    i3++;
                }
            }
        }
    }
}
