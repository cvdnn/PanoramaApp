package com.arashivision.arvbmg.Applets;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo.Rect;
import com.arashivision.graphicpath.render.util.Stabilizer;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Quaternionfc;
import com.arashivision.insbase.joml.Vector3f;

public class FaceOff {
    public Quaternionf firstLeftQuat;
    public Quaternionf firstRightQuat;
    public Quaternionf lastDWQuat;
    public float mLastRatio = -1.0f;
    public boolean mMainRight;

    public static final class FaceOffInfo {
        public Vector3f mLeftVector3f;
        public MultiViewRectInfo mMultiViewRectInfo;
        public Vector3f mRightVector3f;
    }

    public static final class FaceOffInfo2 {
        public Vector3f mLeftVector3f;
        public MultiViewRectInfo2 mMultiViewRectInfo;
        public Vector3f mRightVector3f;
    }

    public static final class MultiViewRectInfo2 {
        public boolean mMainRight;
        public Rect mMainViewRect;
        public int multiViewMode;
        public Rect multiviewRect;
    }

    public FaceOff(Stabilizer stabilizer, double d2, double d3) {
        if (stabilizer != null) {
            Quaternionf quaternionf = new Quaternionf();
            Vector3f lenDirection = getLenDirection(stabilizer, d2, 2);
            StringBuilder sb = new StringBuilder();
            sb.append("FaceOff left first back srcTimeMs ");
            sb.append(d2);
            String str = " pitch ";
            sb.append(str);
            sb.append(lenDirection.x);
            String str2 = " yaw ";
            sb.append(str2);
            sb.append(lenDirection.y);
            String str3 = " roll ";
            sb.append(str3);
            sb.append(lenDirection.z);
            String sb2 = sb.toString();
            String str4 = BMGConstants.TAG;
            Log.i(str4, sb2);
            this.firstLeftQuat = quaternionf.rotateYXZ(lenDirection.y, lenDirection.x, lenDirection.z);
            Quaternionf quaternionf2 = new Quaternionf();
            Vector3f lenDirection2 = getLenDirection(stabilizer, d2, 0);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FaceOff right first front startTimeMs ");
            sb3.append(d2);
            sb3.append(str);
            sb3.append(lenDirection2.x);
            sb3.append(str2);
            sb3.append(lenDirection2.y);
            sb3.append(str3);
            sb3.append(lenDirection2.z);
            Log.i(str4, sb3.toString());
            this.firstRightQuat = quaternionf2.rotateYXZ(lenDirection2.y, lenDirection2.x, lenDirection2.z);
            Quaternionf quaternionf3 = new Quaternionf();
            Vector3f lenDirection3 = getLenDirection(stabilizer, d3, 1);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("FaceOff top last endTimeMs ");
            sb4.append(d3);
            sb4.append(str);
            sb4.append(lenDirection3.x);
            sb4.append(str2);
            sb4.append(lenDirection3.y);
            sb4.append(str3);
            sb4.append(lenDirection3.z);
            Log.i(str4, sb4.toString());
            this.lastDWQuat = quaternionf3.rotateYXZ(lenDirection3.y, lenDirection3.x, lenDirection3.z);
            if (((double) lenDirection3.y) > 0.0d) {
                this.mMainRight = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("stabilizer null");
    }

    private Vector3f QuatToEuler(Quaternionf quaternionf) {
        return quaternionf.getEulerAnglesYXZ(new Vector3f());
    }

    private Vector3f getLenDirection(Stabilizer stabilizer, double d2, int i2) {
        return stabilizer.getEulerAnglesForRenderCamera(d2, i2);
    }

    private MultiViewRectInfo getMultiviewInfo(float f2) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        float f3 = f2 * 0.25f;
        if (isMainLenRight()) {
            rect.mX = -0.25f + f3;
            rect.mY = 0.0f;
            rect.mWidth = 1.0f;
            rect.mHeight = 1.0f;
            rect2.mX = 0.25f - f3;
            rect2.mY = 0.0f;
            rect2.mWidth = 1.0f;
            rect2.mHeight = 1.0f;
        } else {
            rect2.mX = -0.25f + f3;
            rect2.mY = 0.0f;
            rect2.mWidth = 1.0f;
            rect2.mHeight = 1.0f;
            rect.mX = 0.25f - f3;
            rect.mY = 0.0f;
            rect.mWidth = 1.0f;
            rect.mHeight = 1.0f;
        }
        return new MultiViewRectInfo(rect, rect2, 4, isMainLenRight());
    }

    private MultiViewRectInfo2 getMultiviewInfo2(float f2) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        float f3 = f2 * 0.25f;
        if (isMainLenRight()) {
            rect.mX = -0.25f + f3;
            rect.mY = 0.0f;
            rect.mWidth = 1.0f;
            rect.mHeight = 1.0f;
            rect2.mX = 0.25f - f3;
            rect2.mY = 0.0f;
            rect2.mWidth = 1.0f;
            rect2.mHeight = 1.0f;
        } else {
            rect2.mX = -0.25f + f3;
            rect2.mY = 0.0f;
            rect2.mWidth = 1.0f;
            rect2.mHeight = 1.0f;
            rect.mX = 0.25f - f3;
            rect.mY = 0.0f;
            rect.mWidth = 1.0f;
            rect.mHeight = 1.0f;
        }
        MultiViewRectInfo2 multiViewRectInfo2 = new MultiViewRectInfo2();
        multiViewRectInfo2.multiviewRect = rect;
        multiViewRectInfo2.mMainViewRect = rect2;
        multiViewRectInfo2.multiViewMode = 4;
        multiViewRectInfo2.mMainRight = isMainLenRight();
        return multiViewRectInfo2;
    }

    private float getRatio(float f2) {
        return f2;
    }

    private boolean isMainLenRight() {
        return this.mMainRight;
    }

    public FaceOffInfo getFaceOffInfo(float f2) {
        FaceOffInfo faceOffInfo = new FaceOffInfo();
        if (this.lastDWQuat != null) {
            String str = "firstLeftQuat null";
            if (this.firstLeftQuat == null) {
                throw new IllegalArgumentException(str);
            } else if (this.firstRightQuat != null) {
                float ratio = getRatio(f2);
                int i2 = (((double) ratio) > 0.0d ? 1 : (((double) ratio) == 0.0d ? 0 : -1));
                String str2 = " ratio ";
                String str3 = BMGConstants.TAG;
                if (i2 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(ratio);
                    sb.append(" < 0.0");
                    Log.e(str3, sb.toString());
                    ratio = 0.0f;
                }
                if (((double) ratio) > 1.0d) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(ratio);
                    sb2.append(" > 1.0");
                    Log.e(str3, sb2.toString());
                    ratio = 1.0f;
                }
                if (((double) ratio) == 0.0d) {
                    this.mLastRatio = 0.0f;
                } else if (ratio <= this.mLastRatio) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" ratio less than last (");
                    sb3.append(ratio);
                    sb3.append("< ");
                    sb3.append(this.mLastRatio);
                    sb3.append(")");
                    Log.e(str3, sb3.toString());
                    ratio = this.mLastRatio;
                }
                double d2 = (double) ratio;
                int i3 = (d2 > 1.0d ? 1 : (d2 == 1.0d ? 0 : -1));
                if (i3 == 0) {
                    this.mLastRatio = -1.0f;
                } else {
                    this.mLastRatio = ratio;
                }
                if (d2 == 0.0d) {
                    faceOffInfo.mLeftVector3f = QuatToEuler(this.firstLeftQuat);
                    faceOffInfo.mRightVector3f = QuatToEuler(this.firstRightQuat);
                } else if (i3 == 0) {
                    faceOffInfo.mLeftVector3f = QuatToEuler(this.lastDWQuat);
                    faceOffInfo.mRightVector3f = QuatToEuler(this.lastDWQuat);
                } else {
                    faceOffInfo.mLeftVector3f = QuatToEuler(this.firstLeftQuat.slerp((Quaternionfc) this.lastDWQuat, ratio, new Quaternionf()));
                    faceOffInfo.mRightVector3f = QuatToEuler(this.firstRightQuat.slerp((Quaternionfc) this.lastDWQuat, ratio, new Quaternionf()));
                }
                faceOffInfo.mMultiViewRectInfo = getMultiviewInfo(ratio);
                return faceOffInfo;
            } else {
                throw new IllegalArgumentException(str);
            }
        } else {
            throw new IllegalArgumentException("lastDWQuat null");
        }
    }

    public FaceOffInfo2 getFaceOffInfo2(float f2) {
        FaceOffInfo2 faceOffInfo2 = new FaceOffInfo2();
        if (this.lastDWQuat != null) {
            String str = "firstLeftQuat null";
            if (this.firstLeftQuat == null) {
                throw new IllegalArgumentException(str);
            } else if (this.firstRightQuat != null) {
                float ratio = getRatio(f2);
                int i2 = (((double) ratio) > 0.0d ? 1 : (((double) ratio) == 0.0d ? 0 : -1));
                String str2 = " ratio ";
                String str3 = BMGConstants.TAG;
                if (i2 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(ratio);
                    sb.append(" < 0.0");
                    Log.e(str3, sb.toString());
                    ratio = 0.0f;
                }
                if (((double) ratio) > 1.0d) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(ratio);
                    sb2.append(" > 1.0");
                    Log.e(str3, sb2.toString());
                    ratio = 1.0f;
                }
                if (((double) ratio) == 0.0d) {
                    this.mLastRatio = 0.0f;
                } else if (ratio <= this.mLastRatio) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" ratio less than last (");
                    sb3.append(ratio);
                    sb3.append("< ");
                    sb3.append(this.mLastRatio);
                    sb3.append(")");
                    Log.e(str3, sb3.toString());
                    ratio = this.mLastRatio;
                }
                double d2 = (double) ratio;
                int i3 = (d2 > 1.0d ? 1 : (d2 == 1.0d ? 0 : -1));
                if (i3 == 0) {
                    this.mLastRatio = -1.0f;
                } else {
                    this.mLastRatio = ratio;
                }
                if (d2 == 0.0d) {
                    faceOffInfo2.mLeftVector3f = QuatToEuler(this.firstLeftQuat);
                    faceOffInfo2.mRightVector3f = QuatToEuler(this.firstRightQuat);
                } else if (i3 == 0) {
                    faceOffInfo2.mLeftVector3f = QuatToEuler(this.lastDWQuat);
                    faceOffInfo2.mRightVector3f = QuatToEuler(this.lastDWQuat);
                } else {
                    faceOffInfo2.mLeftVector3f = QuatToEuler(this.firstLeftQuat.slerp((Quaternionfc) this.lastDWQuat, ratio, new Quaternionf()));
                    faceOffInfo2.mRightVector3f = QuatToEuler(this.firstRightQuat.slerp((Quaternionfc) this.lastDWQuat, ratio, new Quaternionf()));
                }
                faceOffInfo2.mMultiViewRectInfo = getMultiviewInfo2(ratio);
                return faceOffInfo2;
            } else {
                throw new IllegalArgumentException(str);
            }
        } else {
            throw new IllegalArgumentException("lastDWQuat null");
        }
    }
}
