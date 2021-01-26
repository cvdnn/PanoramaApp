package com.arashivision.onestream;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

public class ArrayUtils {
    public static double[] concatAllDouble(double[]... dArr) {
        int i2 = 0;
        for (double[] length : dArr) {
            i2 += length.length;
        }
        double[] copyOf = Arrays.copyOf(dArr[0], i2);
        int length2 = dArr[0].length;
        for (int i3 = 1; i3 < r0; i3++) {
            System.arraycopy(dArr[i3], 0, copyOf, length2, dArr[i3].length);
            length2 += dArr[i3].length;
        }
        return copyOf;
    }

    public static float[] concatAllFloat(float[]... fArr) {
        int i2 = 0;
        for (float[] length : fArr) {
            i2 += length.length;
        }
        float[] copyOf = Arrays.copyOf(fArr[0], i2);
        int length2 = fArr[0].length;
        for (int i3 = 1; i3 < r0; i3++) {
            System.arraycopy(fArr[i3], 0, copyOf, length2, fArr[i3].length);
            length2 += fArr[i3].length;
        }
        return copyOf;
    }

    public static int[] concatAllInt(int[]... iArr) {
        int i2 = 0;
        for (int[] length : iArr) {
            i2 += length.length;
        }
        int[] copyOf = Arrays.copyOf(iArr[0], i2);
        int length2 = iArr[0].length;
        for (int i3 = 1; i3 < r0; i3++) {
            System.arraycopy(iArr[i3], 0, copyOf, length2, iArr[i3].length);
            length2 += iArr[i3].length;
        }
        return copyOf;
    }

    public static float[] convertDoublesToFloats(double[] dArr, float[] fArr) {
        if (!(dArr == null || fArr == null)) {
            for (int i2 = 0; i2 < dArr.length; i2++) {
                fArr[i2] = (float) dArr[i2];
            }
        }
        return fArr;
    }

    public static double[] convertFloatsToDoubles(float[] fArr, double[] dArr) {
        if (!(fArr == null || dArr == null)) {
            for (int i2 = 0; i2 < fArr.length; i2++) {
                dArr[i2] = (double) fArr[i2];
            }
        }
        return dArr;
    }

    public static double[] getDoubleArrayFromBuffer(DoubleBuffer doubleBuffer) {
        if (doubleBuffer.hasArray()) {
            return doubleBuffer.array();
        }
        doubleBuffer.rewind();
        double[] dArr = new double[doubleBuffer.capacity()];
        doubleBuffer.get(dArr);
        return dArr;
    }

    public static float[] getFloatArrayFromBuffer(FloatBuffer floatBuffer) {
        if (floatBuffer.hasArray()) {
            return floatBuffer.array();
        }
        floatBuffer.rewind();
        float[] fArr = new float[floatBuffer.capacity()];
        floatBuffer.get(fArr);
        return fArr;
    }

    public static int[] getIntArrayFromBuffer(Buffer buffer) {
        if (buffer.hasArray()) {
            return (int[]) buffer.array();
        }
        buffer.rewind();
        int[] iArr = new int[buffer.capacity()];
        if (buffer instanceof IntBuffer) {
            ((IntBuffer) buffer).get(iArr);
        } else if (buffer instanceof ShortBuffer) {
            int i2 = 0;
            while (buffer.hasRemaining()) {
                iArr[i2] = ((ShortBuffer) buffer).get();
                i2++;
            }
        }
        return iArr;
    }

    public static float[] convertDoublesToFloats(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        float[] fArr = new float[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            fArr[i2] = (float) dArr[i2];
        }
        return fArr;
    }

    public static double[] convertFloatsToDoubles(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        double[] dArr = new double[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            dArr[i2] = (double) fArr[i2];
        }
        return dArr;
    }
}
