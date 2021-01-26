package com.arashivision.insbase.joml.sampling;

import com.arashivision.insbase.joml.Random;
import com.arashivision.insbase.joml.Vector2f;
import java.util.ArrayList;

public class PoissonSampling {

    public static class Disk {
        public final float cellSize;
        public final float diskRadius;
        public final float diskRadiusSquared;
        public final Vector2f[] grid;
        public final float minDist;
        public final float minDistSquared;
        public final int numCells;
        public final ArrayList processList = new ArrayList();
        public final Random rnd;

        public Disk(long j2, float f2, float f3, int i2, Callback2d callback2d) {
            this.diskRadius = f2;
            this.diskRadiusSquared = f2 * f2;
            this.minDist = f3;
            this.minDistSquared = f3 * f3;
            this.rnd = new Random(j2);
            float sqrt = f3 / ((float) Math.sqrt(2.0d));
            this.cellSize = sqrt;
            int i3 = ((int) ((f2 * 2.0f) / sqrt)) + 1;
            this.numCells = i3;
            this.grid = new Vector2f[(i3 * i3)];
            compute(i2, callback2d);
        }

        private void compute(int i2, Callback2d callback2d) {
            float nextFloat;
            float nextFloat2;
            do {
                nextFloat = (this.rnd.nextFloat() * 2.0f) - 1.0f;
                nextFloat2 = (this.rnd.nextFloat() * 2.0f) - 1.0f;
            } while ((nextFloat2 * nextFloat2) + (nextFloat * nextFloat) > 1.0f);
            Vector2f vector2f = new Vector2f(nextFloat, nextFloat2);
            this.processList.add(vector2f);
            callback2d.onNewSample(vector2f.x, vector2f.y);
            insert(vector2f);
            while (!this.processList.isEmpty()) {
                int nextInt = this.rnd.nextInt(this.processList.size());
                Vector2f vector2f2 = (Vector2f) this.processList.get(nextInt);
                boolean z = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        break;
                    }
                    float nextFloat3 = this.rnd.nextFloat() * 6.2831855f;
                    double nextFloat4 = (double) ((this.rnd.nextFloat() + 1.0f) * this.minDist);
                    double d2 = (double) nextFloat3;
                    float sin_roquen_9 = (float) (Math.sin_roquen_9(1.5707963267948966d + d2) * nextFloat4);
                    float f2 = sin_roquen_9 + vector2f2.x;
                    float sin_roquen_92 = ((float) (Math.sin_roquen_9(d2) * nextFloat4)) + vector2f2.y;
                    if ((sin_roquen_92 * sin_roquen_92) + (f2 * f2) <= this.diskRadiusSquared && !searchNeighbors(f2, sin_roquen_92)) {
                        callback2d.onNewSample(f2, sin_roquen_92);
                        Vector2f vector2f3 = new Vector2f(f2, sin_roquen_92);
                        this.processList.add(vector2f3);
                        insert(vector2f3);
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    this.processList.remove(nextInt);
                }
            }
        }

        private void insert(Vector2f vector2f) {
            float f2 = vector2f.y;
            float f3 = this.diskRadius;
            float f4 = f2 + f3;
            float f5 = this.cellSize;
            int i2 = (int) ((vector2f.x + f3) / f5);
            this.grid[(((int) (f4 / f5)) * this.numCells) + i2] = vector2f;
        }

        private boolean searchNeighbors(float f2, float f3) {
            float f4 = this.diskRadius;
            float f5 = f3 + f4;
            float f6 = this.cellSize;
            int i2 = (int) (f5 / f6);
            int i3 = (int) ((f4 + f2) / f6);
            if (this.grid[(this.numCells * i2) + i3] != null) {
                return true;
            }
            int max = Math.max(0, i3 - 1);
            int min = Math.min(i3 + 1, this.numCells - 1);
            int min2 = Math.min(i2 + 1, this.numCells - 1);
            for (int max2 = Math.max(0, i2 - 1); max2 <= min2; max2++) {
                for (int i4 = max; i4 <= min; i4++) {
                    Vector2f vector2f = this.grid[(this.numCells * max2) + i4];
                    if (vector2f != null) {
                        float f7 = vector2f.x - f2;
                        float f8 = vector2f.y - f3;
                        if ((f8 * f8) + (f7 * f7) < this.minDistSquared) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
