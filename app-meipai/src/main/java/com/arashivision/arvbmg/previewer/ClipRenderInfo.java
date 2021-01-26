package com.arashivision.arvbmg.previewer;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.util.Stabilizer;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Vector3f;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.Map;

public class ClipRenderInfo implements Cloneable {
    public boolean enableTimeScaleCopySameFrame;
    public boolean mAsyncStitch;
    public BaseCameraController mBaseCameraController;
    public float mBlendAngleRad = -1.0f;
    public int mCameraFacing = -1;
    public boolean mColorAdjust;
    public int mContentMode = -1;
    public float mDenoiseLevel = 3.0f;
    public int mDynamicStitchAccuracyLevel = -1;
    public DynamicStitchType mDynamicStitchType = DynamicStitchType.OFF;
    public boolean mEnableDenoise;
    public boolean mEnableHDR;
    public boolean mEnableSuperNight;
    public FilterInfo[] mFilterInfos;
    public int mGyroType;
    public int mHdrLevel = 0;
    public float mHdrStrength = 0.3f;
    public int mHwAccelFlags = -1;
    public boolean mImageFusion;
    public int mImageLayout;
    public LogoInfo mLogoInfo;
    public int mMaxMotionBlurNum;
    public int mModelType;
    public MultiViewInfo mMultiViewInfo;
    public String mOffset;
    public Matrix4f mPlaneRotateMatrix;
    public int mPlaneRotationDegreee;
    public PlaneVisibleRect mPlaneVisibleRect;
    public int mPovMode = -1;
    public int mSphereSlices;
    public int mSphereStacks;
    public int mStabType;
    public Stabilizer mStabilizer;
    public StabilizingType mStabilizingType;
    public int mStitchInterval = -1;
    public int mSubStreamImageLayout = -1;
    public float mSuperNightNoiseLevel = 3.0f;
    public int mVRMode;

    public enum DynamicStitchType {
        OFF,
        IMAGE,
        VIDEO,
        TEMPLATE
    }

    public static class FilterInfo {
        public String mFilterName;
        public Map<String, Object> mFilterParams = new HashMap();

        public String getFilterName() {
            return this.mFilterName;
        }

        public Map<String, Object> getFilterParams() {
            return this.mFilterParams;
        }

        public void setFilterName(String str) {
            this.mFilterName = str;
        }

        public void setFilterParams(Map<String, Object> map) {
            this.mFilterParams = map;
        }
    }

    public static class Filters {

        public static class AlphaBlendParam {
            public static final String ALPHA_BLEND = "alpha blend";
            public static float ALPHA_MAX = 1.0f;
            public static float ALPHA_MIN = 0.0f;
            public static final String BG_IMAGE = "backgroundImage";
        }

        public static class BeautyParam {
            public static final String LEVEL = "level";
            public static int LEVEL_MAX = 5;
            public static int LEVEL_MIN;
        }

        public static class ColorControlFilterParam {
            public static final String BRIGHTNESS = "brightness";
            public static final String CONTRAST = "contrast";
            public static final String SATURATION = "saturation";
        }

        public static class FilterName {
            public static final String ALPHA_BLEND = "alpha blend";
            public static final String BEAUTIFY = "beautify";
            public static final String COLOR_CONTROL_FILTER = "color_control_filter";
            public static final String HEFE_FILTER = "hefe_filter";
            public static final String HUDSON_FILTER = "hudson_filter";
            public static final String IMAGE_BLEND_FILTER = "image_blend_filter";
            public static final String INKWELL_FILTER = "inkwell_filter";
            public static final String LUT_FILTER = "lut_filter";
            public static final String LUT_STYLE_FILTER = "lut_style_filter";
            public static final String OVERLAY_FILTER = "overlay_filter";
            public static final String RISE_FILTER = "rise_filter";
            public static final String SHARPNESS_FILTER = "sharpness_filter";
            public static final String SIERRA_FILTER = "sierra_filter";
            public static final String SKETCH_FILTER = "sketch_filter";
            public static final String SUTRO_FILTER = "sutro_filter";
            public static final String WALDEN_FILTER = "walden_filter";
            public static final String WATERMARK_FILTER = "watermark_filter";
            public static final String XPROII_FILTER = "xproii_filter";
        }

        public static class ImageBlendFilterParam {
            public static final String IMAGEBLEND_INFO = "imageblend_info";
        }

        public static class LutParam {
            public static final String LUT_DATA = "lut_data";
            public static final String LUT_DIMENSION = "lut_dimension";
        }

        public static class LutStyleParam {
            public static final String LUT_STYLE_DATA = "lut_style_data";
            public static final String LUT_STYLE_DIMENSION = "lut_style_dimension";
            public static final String LUT_STYLE_INTENSITY = "lut_style_intensity";
        }

        public static class OverlayFilterParam {
            public static final String OVERLAY_DATA = "overlay_data";
        }

        public static class SharpnessFilterParam {
            public static final String SHARPNESS = "sharpness";
        }

        public static class WaterMarkParam {
            public static final String WATERMARK_IMAGEASSET = "watermark_imageasset";
            public static final String WATERMARK_RECT = "watermark_rect";
        }
    }

    public static class HdrEffectLevel {
        public static final int NORMAL = 0;
        public static final int SOFT = 1;
    }

    public static class LogoInfo {
        public ImageAsset mLogoAsset;
        public Vector3f mLogoPosition;
        public float mLogoSize;

        public LogoInfo(Vector3f vector3f, float f2, ImageAsset imageAsset) {
            this.mLogoPosition = vector3f;
            this.mLogoSize = f2;
            this.mLogoAsset = imageAsset;
        }

        public ImageAsset getLogoAsset() {
            return this.mLogoAsset;
        }

        public Vector3f getLogoPosition() {
            return this.mLogoPosition;
        }

        public Float getLogoSize() {
            return Float.valueOf(this.mLogoSize);
        }

        public void setLogoAsset(ImageAsset imageAsset) {
            this.mLogoAsset = imageAsset;
        }

        public void setLogoPosition(Vector3f vector3f) {
            this.mLogoPosition = vector3f;
        }

        public void setLogoSize(Float f2) {
            this.mLogoSize = f2.floatValue();
        }
    }

    public static final class MultiViewInfo {
        public ClipRenderInfo mClipRenderInfo;
        public MultiViewRectInfo mMultiViewRectInfo;
    }

    public static final class PlaneVisibleRect {
        public float mRectBottom;
        public float mRectLeft;
        public float mRectRight;
        public float mRectTop;

        public void printInfo() {
            StringBuilder a2 = a.a("PlaneVisibleRect  (");
            a2.append(this.mRectLeft);
            String str = ",";
            a2.append(str);
            a2.append(this.mRectTop);
            a2.append(str);
            a2.append(this.mRectRight);
            a2.append(str);
            a2.append(this.mRectBottom);
            a2.append(")");
            Log.i(BMGConstants.TAG, a2.toString());
        }
    }

    public enum StabilizingType {
        DYNAMIC_VERTEX,
        NORMAL,
        NO
    }

    public static class VRMode {
        public static final int VR_LEFT_RIGHT = 1;
        public static final int VR_OFF = 0;
        public static final int VR_TOP_BOTTOM = 2;
    }

    public BaseCameraController getBaseCameraController() {
        return this.mBaseCameraController;
    }

    public float getBlendAngleRad() {
        return this.mBlendAngleRad;
    }

    public int getCameraFacing() {
        return this.mCameraFacing;
    }

    public int getContentMode() {
        return this.mContentMode;
    }

    public float getDenoiseLevel() {
        return this.mDenoiseLevel;
    }

    public int getDynamicStitchAccuracyLevel() {
        return this.mDynamicStitchAccuracyLevel;
    }

    public DynamicStitchType getDynamicStitchType() {
        return this.mDynamicStitchType;
    }

    public FilterInfo[] getFilterInfos() {
        return this.mFilterInfos;
    }

    public int getGyroType() {
        return this.mGyroType;
    }

    public int getHdrLevel() {
        return this.mHdrLevel;
    }

    public float getHdrStrength() {
        return this.mHdrStrength;
    }

    public int getHwAccelFlags() {
        return this.mHwAccelFlags;
    }

    public int getImageLayout() {
        return this.mImageLayout;
    }

    public LogoInfo getLogoInfo() {
        return this.mLogoInfo;
    }

    public int getMaxMotionBlurNum() {
        return this.mMaxMotionBlurNum;
    }

    public int getModelType() {
        return this.mModelType;
    }

    public MultiViewInfo getMultiViewInfo() {
        return this.mMultiViewInfo;
    }

    public String getOffset() {
        return this.mOffset;
    }

    public Matrix4f getPlaneRotateMatrix() {
        return this.mPlaneRotateMatrix;
    }

    public int getPlaneRotationDegreee() {
        return this.mPlaneRotationDegreee;
    }

    public PlaneVisibleRect getPlaneVisibleRect() {
        return this.mPlaneVisibleRect;
    }

    public int getPovMode() {
        return this.mPovMode;
    }

    public int getSphereSlices() {
        return this.mSphereSlices;
    }

    public int getSphereStacks() {
        return this.mSphereStacks;
    }

    public int getStabType() {
        return this.mStabType;
    }

    public Stabilizer getStabilizer() {
        return this.mStabilizer;
    }

    public StabilizingType getStabilizingType() {
        return this.mStabilizingType;
    }

    public int getStitchInterval() {
        return this.mStitchInterval;
    }

    public int getSubStreamImageLayout() {
        return this.mSubStreamImageLayout;
    }

    public float getSuperNightNoiseLevel() {
        return this.mSuperNightNoiseLevel;
    }

    public int getVRMode() {
        return this.mVRMode;
    }

    public boolean isAsyncStitch() {
        return this.mAsyncStitch;
    }

    public boolean isColorAdjust() {
        return this.mColorAdjust;
    }

    public boolean isEnableDenoise() {
        return this.mEnableDenoise;
    }

    public boolean isEnableHDR() {
        return this.mEnableHDR;
    }

    public boolean isEnableSuperNight() {
        return this.mEnableSuperNight;
    }

    public boolean isEnableTimeScaleCopySameFrame() {
        return this.enableTimeScaleCopySameFrame;
    }

    public boolean isImageFusion() {
        return this.mImageFusion;
    }

    public boolean isPreferDynamic() {
        return this.mStabilizingType == StabilizingType.DYNAMIC_VERTEX;
    }

    public void setAsyncStitch(boolean z) {
        this.mAsyncStitch = z;
    }

    public void setBaseCameraController(BaseCameraController baseCameraController) {
        this.mBaseCameraController = baseCameraController;
    }

    public void setBlendAngleRad(float f2) {
        this.mBlendAngleRad = f2;
    }

    public void setCameraFacing(int i2) {
        this.mCameraFacing = i2;
    }

    public void setColorAdjust(boolean z) {
        this.mColorAdjust = z;
    }

    public void setContentMode(int i2) {
        this.mContentMode = i2;
    }

    public void setDenoiseLevel(float f2) {
        this.mDenoiseLevel = f2;
    }

    public void setDynamicStitchAccuracyLevel(int i2) {
        this.mDynamicStitchAccuracyLevel = i2;
    }

    public void setDynamicStitchType(DynamicStitchType dynamicStitchType) {
        this.mDynamicStitchType = dynamicStitchType;
    }

    public void setEnableDenoise(boolean z) {
        this.mEnableDenoise = z;
    }

    public void setEnableHDR(boolean z) {
        this.mEnableHDR = z;
    }

    public void setEnableSuperNight(boolean z) {
        this.mEnableSuperNight = z;
    }

    public void setEnableTimeScaleCopySameFrame(boolean z) {
        this.enableTimeScaleCopySameFrame = z;
    }

    public void setFilterInfos(FilterInfo[] filterInfoArr) {
        this.mFilterInfos = filterInfoArr;
    }

    public void setGyroType(int i2) {
        this.mGyroType = i2;
    }

    public void setHdrLevel(int i2) {
        this.mHdrLevel = i2;
    }

    public void setHdrStrength(float f2) {
        this.mHdrStrength = f2;
    }

    public void setHwAccelFlags(int i2) {
        this.mHwAccelFlags = i2;
    }

    public void setImageFusion(boolean z) {
        this.mImageFusion = z;
    }

    public void setImageLayout(int i2) {
        this.mImageLayout = i2;
    }

    public void setLogoInfo(LogoInfo logoInfo) {
        this.mLogoInfo = logoInfo;
    }

    public void setMaxMotionBlurNum(int i2) {
        this.mMaxMotionBlurNum = i2;
    }

    public void setModelType(int i2) {
        this.mModelType = i2;
    }

    public void setMultiViewInfo(MultiViewInfo multiViewInfo) {
        this.mMultiViewInfo = multiViewInfo;
    }

    public void setOffset(String str) {
        this.mOffset = str;
    }

    public void setPlaneRotateMatrix(Matrix4f matrix4f) {
        this.mPlaneRotateMatrix = matrix4f;
    }

    public void setPlaneRotationDegreee(int i2) {
        this.mPlaneRotationDegreee = i2;
    }

    public void setPlaneVisibleRect(PlaneVisibleRect planeVisibleRect) {
        this.mPlaneVisibleRect = planeVisibleRect;
    }

    public void setPovMode(int i2) {
        this.mPovMode = i2;
    }

    public void setSphereSlices(int i2) {
        this.mSphereSlices = i2;
    }

    public void setSphereStacks(int i2) {
        this.mSphereStacks = i2;
    }

    public void setStabType(int i2) {
        this.mStabType = i2;
    }

    public void setStabilizer(Stabilizer stabilizer) {
        this.mStabilizer = stabilizer;
    }

    public void setStabilizingType(StabilizingType stabilizingType) {
        this.mStabilizingType = stabilizingType;
    }

    public void setStitchInterval(int i2) {
        this.mStitchInterval = i2;
    }

    public void setSubStreamImageLayout(int i2) {
        this.mSubStreamImageLayout = i2;
    }

    public void setSuperNightNoiseLevel(float f2) {
        this.mSuperNightNoiseLevel = f2;
    }

    public void setVRMode(int i2) {
        this.mVRMode = i2;
    }

    public ClipRenderInfo clone() {
        try {
            return (ClipRenderInfo) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
