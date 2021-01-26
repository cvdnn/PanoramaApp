package com.arashivision.algorithm;

import android.content.Context;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import java.util.List;

public class SmoothPoints extends BMGNativeObjectRef {
    public static final String TAG = "SmoothPoints";
    public Context mContext;

    public static class InsQuat {
        public float w;
        public float x;
        public float y;
        public float z;

        public InsQuat() {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 1.0f;
        }

        private void setW(float f2) {
            this.w = f2;
        }

        private void setX(float f2) {
            this.x = f2;
        }

        private void setY(float f2) {
            this.y = f2;
        }

        private void setZ(float f2) {
            this.z = f2;
        }

        public float getW() {
            return this.w;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public float getZ() {
            return this.z;
        }

        public InsQuat(float f2, float f3, float f4, float f5) {
            this.x = f2;
            this.y = f3;
            this.z = f4;
            this.w = f5;
        }
    }

    public static class Point {
        public float distance;
        public float fov;
        public float pitch;
        public float preRoll;
        public float roll;
        public double time;
        public float yaw;

        public Point() {
        }

        public float getDistance() {
            return this.distance;
        }

        public float getFov() {
            return this.fov;
        }

        public float getPitch() {
            return this.pitch;
        }

        public float getPreRoll() {
            return this.preRoll;
        }

        public float getRoll() {
            return this.roll;
        }

        public double getTime() {
            return this.time;
        }

        public float getYaw() {
            return this.yaw;
        }

        public void setDistance(float f2) {
            this.distance = f2;
        }

        public void setFov(float f2) {
            this.fov = f2;
        }

        public void setPitch(float f2) {
            this.pitch = f2;
        }

        public void setPreRoll(float f2) {
            this.preRoll = f2;
        }

        public void setRoll(float f2) {
            this.roll = f2;
        }

        public void setTime(double d2) {
            this.time = d2;
        }

        public void setYaw(float f2) {
            this.yaw = f2;
        }

        public Point(double d2, float f2, float f3, float f4, float f5, float f6, float f7) {
            this.time = d2;
            this.fov = f2;
            this.distance = f3;
            this.yaw = f4;
            this.pitch = f5;
            this.roll = f6;
            this.preRoll = f7;
        }
    }

    public SmoothPoints(Context context, List<Point> list) {
        this(createNativeWrap(list), context);
    }

    public static void averageSmoothKeepBothEnd(float[] fArr, int i2) {
        nativeAverageSmoothKeepBothEnd(fArr, i2);
    }

    public static native long createNativeWrap(List<Point> list);

    public static void movingAverageSmooth(float[] fArr, int i2) {
        nativeMovingAverageSmooth(fArr, i2);
    }

    public static native void nativeAverageSmoothKeepBothEnd(float[] fArr, int i2);

    private native Point nativeGetPoint(double d2);

    public static native void nativeMovingAverageSmooth(float[] fArr, int i2);

    private native void nativePrepare();

    public static native void nativeSetDebug(boolean z, int i2);

    public static native void nativeSmoothQuaternion(List<InsQuat> list, int i2);

    public static void setDebug(boolean z, int i2) {
        nativeSetDebug(z, i2);
    }

    public static void smoothQuaternion(List<InsQuat> list, int i2) {
        nativeSmoothQuaternion(list, i2);
    }

    public Point getPoint(double d2) {
        return nativeGetPoint(d2);
    }

    public void prepare() {
        nativePrepare();
    }

    public SmoothPoints(long j2, Context context) {
        super(j2, TAG);
        this.mContext = context;
    }
}
