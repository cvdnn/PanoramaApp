package com.arashivision.arvbmg.render.camera;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Matrix4fc;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Quaternionfc;
import com.arashivision.insbase.joml.Vector3f;
import e.g.c.a.a.a;

public class HeadTrackerController {
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 270;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 0;
    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 90;
    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 180;
    public static final String TAG = "HeadTrackerController";
    public static int sEnableCounter;
    public static int sInstanceCounter;
    public int TRANSITION_COUNTER = 0;
    public float TRANSITION_PERCENT = 0.1f;
    public int mAnimationFrequency = -1;
    public Callback mCallback;
    public Quaternionf mCameraQuaternion = new Quaternionf();
    public Context mContext;
    public double mCurrentHTPitch;
    public double mCurrentHTRoll;
    public Quaternionf mCurrentQuaternion = new Quaternionf();
    public int mDefaultOrientation;
    public boolean mEnabled = false;
    public a mHeadTracker;
    public boolean mHeadTrackerEnabled = false;
    public float[] mHeadViewMatrix = new float[16];
    public Matrix4f mHeadViewMatrix4 = new Matrix4f();
    public double mLockPitchAngle = -1.0d;
    public double mLockRollAngle = -1.0d;
    public boolean mNeedLockPitchRoll = false;
    public boolean mNeedLockRoll = true;
    public OrientationEventListener mOrientationEventListener;

    public interface Callback {
        int getCurrentScreenOrientation();
    }

    public HeadTrackerController(Context context, int i2) {
        this.mDefaultOrientation = i2;
        this.mContext = context;
        if (this.mHeadTracker == null) {
            this.mHeadTracker = new a(context.getApplicationContext());
        }
        sInstanceCounter++;
    }

    private Matrix4f convertMatrix(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = new Matrix4f(0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        matrix4f.mulLocal(matrix4f2.invert());
        Matrix4f matrix4f3 = new Matrix4f(-matrix4f.m21(), matrix4f.m11(), matrix4f.m01(), 0.0f, matrix4f.m20(), -matrix4f.m10(), -matrix4f.m00(), 0.0f, -matrix4f.m22(), matrix4f.m12(), matrix4f.m02(), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        return matrix4f3;
    }

    private void handleOrientationLock() {
        if (this.mCameraQuaternion != null) {
            Quaternionf quaternionf = new Quaternionf();
            quaternionf.set((Quaternionfc) this.mCameraQuaternion);
            Vector3f eulerAnglesYXZ = quaternionf.getEulerAnglesYXZ(new Vector3f());
            this.mCurrentHTPitch = -(((double) eulerAnglesYXZ.z) - 1.5707963267948966d);
            this.mCurrentHTRoll = (double) eulerAnglesYXZ.x;
            if (this.mNeedLockPitchRoll) {
                quaternionf = new Quaternionf().rotateYXZ(eulerAnglesYXZ.y(), (float) this.mLockPitchAngle, (float) this.mLockRollAngle);
            } else if (this.mNeedLockRoll) {
                quaternionf = new Quaternionf().rotateYXZ(eulerAnglesYXZ.y(), (float) (-(((double) eulerAnglesYXZ.z) - 1.5707963267948966d)), (float) this.mLockRollAngle);
            }
            this.mCameraQuaternion.set((Quaternionfc) quaternionf);
        }
    }

    private void startTracking() {
        if (!this.mHeadTrackerEnabled) {
            a aVar = this.mHeadTracker;
            if (aVar != null) {
                this.mHeadTrackerEnabled = true;
                aVar.a();
                sEnableCounter++;
            }
        }
    }

    private void stopTracking() {
        if (this.mHeadTrackerEnabled && this.mHeadTracker != null) {
            this.mHeadTrackerEnabled = false;
            int i2 = sEnableCounter - 1;
            sEnableCounter = i2;
            if (i2 != 0) {
                Log.e("oldtrack", "stopTracking sEnableCounter not 0");
            }
            a aVar = this.mHeadTracker;
            if (aVar != null && sEnableCounter == 0) {
                aVar.b();
            }
            this.mCurrentQuaternion = new Quaternionf();
        }
    }

    private void update() {
        updateHeadTracker();
        int i2 = this.TRANSITION_COUNTER;
        if (i2 > 0) {
            this.TRANSITION_COUNTER = i2 - 1;
            Quaternionf slerp = new Quaternionf().set((Quaternionfc) this.mCurrentQuaternion).slerp(this.mCameraQuaternion, this.TRANSITION_PERCENT);
            Vector3f eulerAnglesYXZ = slerp.getEulerAnglesYXZ(new Vector3f());
            this.mCurrentHTPitch = Math.toDegrees(-(((double) eulerAnglesYXZ.z) - 1.5707963267948966d));
            this.mCurrentHTRoll = Math.toDegrees((double) eulerAnglesYXZ.x);
            if (this.mNeedLockPitchRoll) {
                slerp = new Quaternionf().rotateYXZ(eulerAnglesYXZ.y(), (float) this.mCurrentHTPitch, (float) this.mLockRollAngle);
            } else if (this.mNeedLockRoll) {
                slerp = new Quaternionf().rotateYXZ(eulerAnglesYXZ.y(), (float) (-(((double) eulerAnglesYXZ.z) - 1.5707963267948966d)), (float) this.mLockRollAngle);
            }
            this.mCurrentQuaternion = slerp;
            return;
        }
        this.mCurrentQuaternion = this.mCameraQuaternion;
    }

    private void updateHeadTracker() {
        this.mHeadTracker.a(this.mHeadViewMatrix, 0);
        this.mHeadViewMatrix4.set(this.mHeadViewMatrix);
        Matrix4f convertMatrix = convertMatrix(this.mHeadViewMatrix4);
        this.mHeadViewMatrix4 = convertMatrix;
        this.mCameraQuaternion.setFromNormalized((Matrix4fc) convertMatrix);
        int i2 = this.mDefaultOrientation;
        Callback callback = this.mCallback;
        if (callback != null) {
            i2 = callback.getCurrentScreenOrientation();
        }
        if (i2 == 90) {
            Matrix4f matrix4f = this.mCameraQuaternion.get(new Matrix4f());
            matrix4f.rotate((float) Math.toRadians(90.0d), 0.0f, 0.0f, 1.0f);
            this.mCameraQuaternion.setFromNormalized((Matrix4fc) matrix4f);
        } else if (i2 == 180) {
            Matrix4f matrix4f2 = this.mCameraQuaternion.get(new Matrix4f());
            matrix4f2.rotate((float) Math.toRadians(180.0d), 0.0f, 0.0f, 1.0f);
            this.mCameraQuaternion.setFromNormalized((Matrix4fc) matrix4f2);
        } else if (i2 == 270) {
            Matrix4f matrix4f3 = this.mCameraQuaternion.get(new Matrix4f());
            matrix4f3.rotate((float) Math.toRadians(270.0d), 0.0f, 0.0f, 1.0f);
            this.mCameraQuaternion.setFromNormalized((Matrix4fc) matrix4f3);
        }
        handleOrientationLock();
    }

    public void destroy() {
        int i2 = sInstanceCounter - 1;
        sInstanceCounter = i2;
        String str = TAG;
        if (i2 == 0) {
            try {
                if (this.mHeadTracker != null) {
                    this.mHeadTracker.b();
                    this.mHeadTracker = null;
                }
            } catch (Throwable th) {
                Log.e(str, th.getMessage());
            }
        } else {
            Log.e("oldtrack", "destroy when sInstanceCounter not 0");
            try {
                if (this.mHeadTracker != null) {
                    this.mHeadTracker.b();
                    this.mHeadTracker = null;
                }
            } catch (Throwable th2) {
                Log.e(str, th2.getMessage());
            }
        }
        this.mCameraQuaternion = null;
        this.mHeadViewMatrix4 = null;
        this.mHeadViewMatrix = null;
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.mOrientationEventListener = null;
    }

    public double getCurrentPitchOfHeadTrackerOrientation() {
        return this.mCurrentHTPitch;
    }

    public double getCurrentRollOfHeadTrackerOrientation() {
        return this.mCurrentHTRoll;
    }

    public Quaternionf getQuaternion() {
        if (this.mEnabled) {
            update();
        } else {
            Log.d(TAG, "HeaderTrackerController is not enable");
        }
        return this.mCurrentQuaternion;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void lockPitchRoll(double d2, double d3) {
        this.mNeedLockPitchRoll = true;
        this.mLockRollAngle = d3;
        this.mLockPitchAngle = d2;
    }

    public void lockRoll(double d2) {
        this.mNeedLockRoll = true;
        this.mLockRollAngle = d2;
    }

    public void reset() {
        this.TRANSITION_COUNTER = this.mAnimationFrequency;
    }

    public void resetHeadTracker() {
        a aVar = this.mHeadTracker;
        if (aVar != null && this.mHeadTrackerEnabled) {
            aVar.b();
        }
        a aVar2 = new a(this.mContext);
        this.mHeadTracker = aVar2;
        if (this.mHeadTrackerEnabled) {
            aVar2.a();
        }
    }

    public void setAnimationFrequency(int i2) {
        this.mAnimationFrequency = i2;
        if (this.TRANSITION_COUNTER == -1) {
            this.TRANSITION_COUNTER = i2;
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setEnabled(boolean z) {
        if (z && !this.mEnabled) {
            reset();
            startTracking();
        } else if (this.mEnabled && !z) {
            stopTracking();
        }
        this.mEnabled = z;
    }

    public void unlockPitchRoll() {
        this.mNeedLockPitchRoll = false;
    }

    public void unlockRoll() {
        this.mNeedLockRoll = false;
    }
}
