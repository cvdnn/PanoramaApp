package com.arashivision.insbase.joml.sampling;

import com.arashivision.insbase.joml.Math;
import java.nio.FloatBuffer;

public class Convolution {
    public static void gaussianKernel(int i2, int i3, float f2, FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        if ((i2 & 1) == 0) {
            throw new IllegalArgumentException("rows must be an odd number");
        } else if ((i3 & 1) == 0) {
            throw new IllegalArgumentException("cols must be an odd number");
        } else if (floatBuffer2 != null) {
            int i4 = i2 * i3;
            if (floatBuffer.remaining() >= i4) {
                float f3 = 0.0f;
                int position = floatBuffer.position();
                int i5 = i2 - 1;
                int i6 = 0;
                for (int i7 = (-i5) / 2; i7 <= i5 / 2; i7++) {
                    int i8 = i3 - 1;
                    int i9 = (-i8) / 2;
                    while (i9 <= i8 / 2) {
                        int i10 = i6;
                        double d2 = (double) f2;
                        float exp = (float) Math.exp(((double) (-((i9 * i9) + (i7 * i7)))) / ((2.0d * d2) * d2));
                        floatBuffer2.put(position + i10, exp);
                        f3 += exp;
                        i9++;
                        i6 = i10 + 1;
                    }
                    float f4 = f2;
                    int i11 = i6;
                }
                for (int i12 = 0; i12 < i4; i12++) {
                    int i13 = position + i12;
                    floatBuffer2.put(i13, floatBuffer2.get(i13) / f3);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("dest must have at least ");
            sb.append(i4);
            sb.append(" remaining values");
            throw new IllegalArgumentException(sb.toString());
        } else {
            throw new IllegalArgumentException("dest must not be null");
        }
    }

    public static void gaussianKernel(int i2, int i3, float f2, float[] fArr) {
        float[] fArr2 = fArr;
        if ((i2 & 1) == 0) {
            throw new IllegalArgumentException("rows must be an odd number");
        } else if ((i3 & 1) == 0) {
            throw new IllegalArgumentException("cols must be an odd number");
        } else if (fArr2 != null) {
            int i4 = i2 * i3;
            if (fArr2.length >= i4) {
                float f3 = 0.0f;
                int i5 = i2 - 1;
                int i6 = 0;
                for (int i7 = (-i5) / 2; i7 <= i5 / 2; i7++) {
                    int i8 = i3 - 1;
                    int i9 = (-i8) / 2;
                    while (i9 <= i8 / 2) {
                        double d2 = (double) f2;
                        float exp = (float) Math.exp(((double) (-((i9 * i9) + (i7 * i7)))) / ((2.0d * d2) * d2));
                        fArr2[i6] = exp;
                        f3 += exp;
                        i9++;
                        i6++;
                    }
                    float f4 = f2;
                }
                for (int i10 = 0; i10 < i4; i10++) {
                    fArr2[i10] = fArr2[i10] / f3;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("dest must have at least ");
            sb.append(i4);
            sb.append(" remaining values");
            throw new IllegalArgumentException(sb.toString());
        } else {
            throw new IllegalArgumentException("dest must not be null");
        }
    }
}
