package com.arashivision.graphicpath.render.engine.animator;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insbase.nativeref.NativeObjectRef;
import e.a.a.a.a;
import java.nio.FloatBuffer;

public class Animator extends NativeObjectRef {
    public ValueDecoder mValueDecoder;
    public int mValueType;

    public static class InterpolatorType {
        public static final int ACCELERATE = 1;
        public static final int ACCELERATE_DECELERATE = 3;
        public static final int DECELERATE = 2;
        public static final int LINEAR = 0;
    }

    public interface ValueDecoder {
        Object[] decodeValue(Object obj);
    }

    public static class ValueType {
        public static final int FLOAT = 0;
        public static final int FLOAT_ARRAY_4 = 1;
    }

    static {
        RenderLibsLoader.load();
    }

    public Animator(int i2) {
        this(i2, null);
    }

    public static /* synthetic */ Object[] a(Object obj) {
        if (obj instanceof Transform) {
            FloatBuffer floatBuffer = ((Transform) obj).toFloatBuffer();
            return new Float[]{Float.valueOf(floatBuffer.get(0)), Float.valueOf(floatBuffer.get(1)), Float.valueOf(floatBuffer.get(2)), Float.valueOf(floatBuffer.get(3))};
        }
        throw new IllegalArgumentException(a.a("bad value type, expect Transform type, value: ", obj));
    }

    public static native long createNativeWrap(int i2);

    private Object[] decodeValue(Object obj) {
        ValueDecoder valueDecoder = this.mValueDecoder;
        if (valueDecoder != null) {
            return valueDecoder.decodeValue(obj);
        }
        int i2 = this.mValueType;
        if (i2 != 0) {
            if (i2 == 1) {
                String str = "expect float array size 4, currently: ";
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    if (fArr.length >= 4) {
                        return new Float[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]), Float.valueOf(fArr[3])};
                    }
                    StringBuilder a2 = a.a(str);
                    a2.append(fArr.length);
                    throw new IllegalArgumentException(a2.toString());
                } else if (obj instanceof Float[]) {
                    Float[] fArr2 = (Float[]) obj;
                    if (fArr2.length >= 4) {
                        return fArr2;
                    }
                    StringBuilder a3 = a.a(str);
                    a3.append(fArr2.length);
                    throw new IllegalArgumentException(a3.toString());
                }
            }
            StringBuilder a4 = a.a("value type not support: ");
            a4.append(this.mValueType);
            throw new IllegalArgumentException(a4.toString());
        } else if (obj instanceof Float) {
            return new Object[]{obj};
        } else if (obj instanceof Double) {
            return new Object[]{Float.valueOf(((Double) obj).floatValue())};
        } else {
            throw new IllegalArgumentException(a.a("bad value type type, expect Float, value is: ", obj));
        }
    }

    private native void nativeBeginWith(float f2, Object[] objArr);

    private native void nativeKeyframe(float f2, Object[] objArr, int i2, float f3);

    private native void nativeSetDuration(int i2);

    private native void nativeStart();

    public static Animator ofFloat() {
        return new Animator(0);
    }

    public static Animator ofTransform() {
        return new Animator(1, e.b.b.a.a.a.a.f5632a);
    }

    public Animator beginWith(float f2, Object obj) {
        nativeBeginWith(f2, decodeValue(obj));
        return this;
    }

    public int getValueType() {
        return this.mValueType;
    }

    public Animator keyframe(float f2, Object obj, TimeInterpolator timeInterpolator) {
        Object[] decodeValue = decodeValue(obj);
        if (timeInterpolator instanceof LinearInterpolator) {
            nativeKeyframe(f2, decodeValue, 0, 0.0f);
        } else if (timeInterpolator instanceof AccelerateInterpolator) {
            nativeKeyframe(f2, decodeValue, 1, 0.0f);
        } else if (timeInterpolator instanceof DecelerateInterpolator) {
            nativeKeyframe(f2, decodeValue, 2, ((DecelerateInterpolator) timeInterpolator).getFactor());
        } else if (timeInterpolator instanceof AccelerateDecelerateInterpolator) {
            nativeKeyframe(f2, decodeValue, 3, ((AccelerateDecelerateInterpolator) timeInterpolator).getFactor());
        }
        return this;
    }

    public Animator setDuration(int i2) {
        nativeSetDuration(i2);
        return this;
    }

    public Animator start() {
        nativeStart();
        return this;
    }

    public Animator(int i2, ValueDecoder valueDecoder) {
        super(createNativeWrap(i2), "Animator");
        this.mValueType = i2;
        this.mValueDecoder = valueDecoder;
    }
}
