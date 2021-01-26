package com.arashivision.insbase.joml;

public class Random {
    public final Xorshiro128 rnd;

    public static final class Xorshiro128 {
        public static final boolean HAS_Long_rotateLeft = hasLongRotateLeft();
        public static final float INT_TO_FLOAT = Float.intBitsToFloat(864026624);
        public long _s0;
        public long _s1;
        public long state;

        public Xorshiro128(long j2) {
            this.state = j2;
            this._s0 = nextSplitMix64();
            this._s0 = nextSplitMix64();
        }

        public static boolean hasLongRotateLeft() {
            try {
                Long.class.getDeclaredMethod("rotateLeft", new Class[]{Long.TYPE, Integer.TYPE});
                return true;
            } catch (NoSuchMethodException unused) {
                return false;
            }
        }

        private int nextInt() {
            long j2 = this._s0;
            long j3 = this._s1;
            long j4 = j2 + j3;
            rotateLeft(j2, j3 ^ j2);
            return (int) (-1 & j4);
        }

        private long nextSplitMix64() {
            long j2 = this.state - 7046029254386353131L;
            this.state = j2;
            long j3 = (j2 ^ (j2 >>> 30)) * -4658895280553007687L;
            long j4 = (j3 ^ (j3 >>> 27)) * -7723592293110705685L;
            return j4 ^ (j4 >>> 31);
        }

        private void rotateLeft(long j2, long j3) {
            this._s0 = (rotl(j2, 55) ^ j3) ^ (j3 << 14);
            this._s1 = rotl(j3, 36);
        }

        public static long rotl(long j2, int i2) {
            if (HAS_Long_rotateLeft) {
                return rotl_JDK5(j2, i2);
            }
            return rotl_JDK4(j2, i2);
        }

        public static long rotl_JDK4(long j2, int i2) {
            return (j2 >>> (64 - i2)) | (j2 << i2);
        }

        public static long rotl_JDK5(long j2, int i2) {
            return Long.rotateLeft(j2, i2);
        }

        public final float nextFloat() {
            return ((float) (nextInt() >>> 8)) * INT_TO_FLOAT;
        }

        public final int nextInt(int i2) {
            return (int) ((((long) (nextInt() >>> 1)) * ((long) i2)) >> 31);
        }
    }

    public Random(long j2) {
        this.rnd = new Xorshiro128(j2);
    }

    public float nextFloat() {
        return this.rnd.nextFloat();
    }

    public int nextInt(int i2) {
        return this.rnd.nextInt(i2);
    }
}
