package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieTransform;

public final class LottiePanoTransformAnimation {
    public PanoLottieTransformInfo mPanoLottieTransformInfo;
    public TransformPoints[] mTransformPointIn;
    public TransformPoints[] mTransformPointOut;

    public static final class PanoLottieTransformInfo {
        public float mEndRatio;
        public LottieTransform mLottieTransform;
        public float mStartRatio;
    }

    public static class TransformPoints {
        public float distance;
        public float fov;
        public float pitch;
        public float ratio;
        public float roll;
        public float yaw;
    }
}
