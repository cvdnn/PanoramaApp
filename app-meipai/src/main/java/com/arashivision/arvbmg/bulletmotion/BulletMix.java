package com.arashivision.arvbmg.bulletmotion;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class BulletMix extends BMGNativeObjectRef {
    public boolean mIsRelease;

    public BulletMix() {
        this(createBulletObj());
    }

    public static native long createBulletObj();

    private native BulletDetectResult nativeDetectDace(long j2, float f2);

    private native BulletReadResult nativeReadFileandGyro(BulletMixInfo bulletMixInfo);

    private native void nativeRelease();

    private native void nativeSetBulletCallback();

    private native void nativeSetThreshold(float f2);

    public BulletDetectResult detectFace(long j2, float f2) {
        return nativeDetectDace(j2, f2);
    }

    public void finalize() throws Throwable {
        if (!this.mIsRelease) {
            nativeRelease();
            this.mIsRelease = true;
        }
        super.finalize();
    }

    public BulletReadResult readFileAndLoadGyro(BulletMixInfo bulletMixInfo) {
        return nativeReadFileandGyro(bulletMixInfo);
    }

    public void release() {
        nativeRelease();
    }

    public void setThreshold(float f2) {
        nativeSetThreshold(f2);
    }

    public BulletMix(long j2) {
        super(j2, "BulletMix");
    }
}
