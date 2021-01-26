package com.arashivision.arvbmg.render.lottie.data;

import android.util.Log;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.EffectData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.EffectData.Type;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.PathBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.PointBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.ScaleBezierData;
import com.arashivision.arvbmg.render.lottie.utils.BezierDataUtils;
import java.util.ArrayList;
import java.util.List;

public class CompositionData {
    public int mFrameRate;
    public int mHeight;
    public List<LayerData> mLayerList;
    public int mMaxFrame;
    public int mMinFrame;
    public String mName;
    public String mVersion;
    public int mWidth;

    private BezierKeyFrame getBezierKeyFrameTakeEffect(List<BezierKeyFrame> list, float f2) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (f2 >= ((((float) ((BezierKeyFrame) list.get(i3)).getStartFrame()) * 1.0f) - ((float) getMinFrame())) / ((float) (getMaxFrame() - getMinFrame())) && f2 <= ((((float) ((BezierKeyFrame) list.get(i3)).getEndFrame()) * 1.0f) - ((float) getMinFrame())) / ((float) (getMaxFrame() - getMinFrame()))) {
                return (BezierKeyFrame) list.get(i3);
            }
            if (f2 >= ((((float) ((BezierKeyFrame) list.get(i3)).getEndFrame()) * 1.0f) - ((float) getMinFrame())) / ((float) (getMaxFrame() - getMinFrame()))) {
                i2 = i3;
            }
        }
        Log.w("CompositionData", "can't find BezierKeyFrameTakeEffect, use nearest BezierKeyFrame instead");
        return (BezierKeyFrame) list.get(i2);
    }

    private float getProgressInTakeEffectByProgressInAll(BezierKeyFrame bezierKeyFrame, float f2) {
        if (!bezierKeyFrame.isNeedAnimation()) {
            return 0.0f;
        }
        float startFrame = ((((float) bezierKeyFrame.getStartFrame()) * 1.0f) - ((float) getMinFrame())) / ((float) (getMaxFrame() - getMinFrame()));
        return (f2 - startFrame) / ((((((float) bezierKeyFrame.getEndFrame()) * 1.0f) - ((float) getMinFrame())) / ((float) (getMaxFrame() - getMinFrame()))) - startFrame);
    }

    public boolean containsEffectData() {
        if (getLayerList().size() < 2 || (((LayerData) getLayerList().get(0)).getEffectList().size() <= 0 && ((LayerData) getLayerList().get(1)).getEffectList().size() <= 0)) {
            return false;
        }
        return true;
    }

    public boolean containsMaskData() {
        if (getLayerList().size() < 2 || (((LayerData) getLayerList().get(0)).getMaskList().size() <= 0 && ((LayerData) getLayerList().get(1)).getMaskList().size() <= 0)) {
            return false;
        }
        return true;
    }

    public boolean containsTransformData() {
        if (getLayerList().size() < 2 || (((LayerData) getLayerList().get(0)).getShapeList().size() <= 0 && ((LayerData) getLayerList().get(1)).getShapeList().size() <= 0)) {
            return false;
        }
        return true;
    }

    public FloatBezierData getEffectGaussianBlurriness(int i2, float f2) {
        List effectList = ((LayerData) getLayerList().get(i2)).getEffectList();
        if (effectList != null && effectList.size() > 0) {
            for (int i3 = 0; i3 < effectList.size(); i3++) {
                if (((EffectData) effectList.get(i3)).getType() == Type.Gaussian) {
                    BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((EffectData) effectList.get(i3)).getGaussianBlurriness(), f2);
                    if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
                        return (FloatBezierData) bezierKeyFrameTakeEffect.getDefaultData();
                    }
                    return BezierDataUtils.getCurrentFloat(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, f2)));
                }
            }
        }
        return null;
    }

    public IntBezierData getEffectGaussianDimensions(int i2, float f2) {
        List effectList = ((LayerData) getLayerList().get(i2)).getEffectList();
        if (effectList != null && effectList.size() > 0) {
            for (int i3 = 0; i3 < effectList.size(); i3++) {
                if (((EffectData) effectList.get(i3)).getType() == Type.Gaussian) {
                    BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((EffectData) effectList.get(i3)).getGaussianDimensions(), f2);
                    if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
                        return (IntBezierData) bezierKeyFrameTakeEffect.getDefaultData();
                    }
                    return BezierDataUtils.getCurrentInt(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, f2)));
                }
            }
        }
        return null;
    }

    public FloatBezierData getEffectRadialAmount(int i2, float f2) {
        List effectList = ((LayerData) getLayerList().get(i2)).getEffectList();
        if (effectList != null && effectList.size() > 0) {
            for (int i3 = 0; i3 < effectList.size(); i3++) {
                if (((EffectData) effectList.get(i3)).getType() == Type.Radial) {
                    BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((EffectData) effectList.get(i3)).getRadialAmount(), f2);
                    if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
                        return (FloatBezierData) bezierKeyFrameTakeEffect.getDefaultData();
                    }
                    return BezierDataUtils.getCurrentFloat(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, f2)));
                }
            }
        }
        return null;
    }

    public PointBezierData getEffectRadialCenter(int i2, float f2) {
        List effectList = ((LayerData) getLayerList().get(i2)).getEffectList();
        if (effectList != null && effectList.size() > 0) {
            for (int i3 = 0; i3 < effectList.size(); i3++) {
                if (((EffectData) effectList.get(i3)).getType() == Type.Radial) {
                    BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((EffectData) effectList.get(i3)).getRadialCenter(), f2);
                    if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
                        return (PointBezierData) bezierKeyFrameTakeEffect.getDefaultData();
                    }
                    return BezierDataUtils.getCurrentPoint(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, f2)));
                }
            }
        }
        return null;
    }

    public IntBezierData getEffectRadialType(int i2, float f2) {
        List effectList = ((LayerData) getLayerList().get(i2)).getEffectList();
        if (effectList != null && effectList.size() > 0) {
            for (int i3 = 0; i3 < effectList.size(); i3++) {
                if (((EffectData) effectList.get(i3)).getType() == Type.Radial) {
                    BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((EffectData) effectList.get(i3)).getRadialType(), f2);
                    if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
                        return (IntBezierData) bezierKeyFrameTakeEffect.getDefaultData();
                    }
                    return BezierDataUtils.getCurrentInt(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, f2)));
                }
            }
        }
        return null;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public List<LayerData> getLayerList() {
        return this.mLayerList;
    }

    public List<FloatBezierData> getMaskExpansion(int i2, float f2) {
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        List maskList = ((LayerData) getLayerList().get(i2)).getMaskList();
        if (maskList == null || maskList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < maskList.size(); i3++) {
            BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((MaskData) ((LayerData) getLayerList().get(i2)).getMaskList().get(0)).getExpansion(), max);
            if (bezierKeyFrameTakeEffect.isNeedAnimation()) {
                arrayList.add(BezierDataUtils.getCurrentFloat(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max))));
            } else {
                arrayList.add((FloatBezierData) bezierKeyFrameTakeEffect.getDefaultData());
            }
        }
        return arrayList;
    }

    public List<FloatBezierData> getMaskOpacity(int i2, float f2) {
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        List maskList = ((LayerData) getLayerList().get(i2)).getMaskList();
        if (maskList == null || maskList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < maskList.size(); i3++) {
            BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((MaskData) ((LayerData) getLayerList().get(i2)).getMaskList().get(0)).getOpacity(), max);
            if (bezierKeyFrameTakeEffect.isNeedAnimation()) {
                arrayList.add(BezierDataUtils.getCurrentFloat(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max))));
            } else {
                arrayList.add((FloatBezierData) bezierKeyFrameTakeEffect.getDefaultData());
            }
        }
        return arrayList;
    }

    public List<PathBezierData> getMaskShape(int i2, float f2) {
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        List maskList = ((LayerData) getLayerList().get(i2)).getMaskList();
        if (maskList == null || maskList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < maskList.size(); i3++) {
            BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((MaskData) maskList.get(i3)).getMaskShape(), max);
            if (bezierKeyFrameTakeEffect.isNeedAnimation()) {
                arrayList.add(BezierDataUtils.getCurrentPath(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max))));
            } else {
                arrayList.add((PathBezierData) bezierKeyFrameTakeEffect.getDefaultData());
            }
        }
        return arrayList;
    }

    public int getMaxFrame() {
        return this.mMaxFrame;
    }

    public int getMinFrame() {
        return this.mMinFrame;
    }

    public String getName() {
        return this.mName;
    }

    public PointBezierData getTransformAnchorByProgress(int i2, float f2) {
        List shapeList = ((LayerData) getLayerList().get(i2)).getShapeList();
        if (shapeList == null || shapeList.size() <= 0) {
            return null;
        }
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((ShapeData) shapeList.get(0)).getAnchor(), max);
        if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
            return (PointBezierData) bezierKeyFrameTakeEffect.getDefaultData();
        }
        return BezierDataUtils.getCurrentPoint(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max)));
    }

    public FloatBezierData getTransformOpacityByProgress(int i2, float f2) {
        List shapeList = ((LayerData) getLayerList().get(i2)).getShapeList();
        if (shapeList == null || shapeList.size() <= 0) {
            return null;
        }
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((ShapeData) shapeList.get(0)).getOpacity(), max);
        if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
            return (FloatBezierData) bezierKeyFrameTakeEffect.getDefaultData();
        }
        return BezierDataUtils.getCurrentFloat(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max)));
    }

    public PointBezierData getTransformPositionByProgress(int i2, float f2) {
        List shapeList = ((LayerData) getLayerList().get(i2)).getShapeList();
        if (shapeList == null || shapeList.size() <= 0) {
            return null;
        }
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((ShapeData) shapeList.get(0)).getPosition(), max);
        if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
            return (PointBezierData) bezierKeyFrameTakeEffect.getDefaultData();
        }
        return BezierDataUtils.getCurrentPoint(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max)));
    }

    public FloatBezierData getTransformRotationByProgress(int i2, float f2) {
        List shapeList = ((LayerData) getLayerList().get(i2)).getShapeList();
        if (shapeList == null || shapeList.size() <= 0) {
            return null;
        }
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((ShapeData) shapeList.get(0)).getRotation(), max);
        if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
            return (FloatBezierData) bezierKeyFrameTakeEffect.getDefaultData();
        }
        return BezierDataUtils.getCurrentFloat(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max)));
    }

    public ScaleBezierData getTransformScaleByProgress(int i2, float f2) {
        List shapeList = ((LayerData) getLayerList().get(i2)).getShapeList();
        if (shapeList == null || shapeList.size() <= 0) {
            return null;
        }
        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
        BezierKeyFrame bezierKeyFrameTakeEffect = getBezierKeyFrameTakeEffect(((ShapeData) shapeList.get(0)).getScale(), max);
        if (!bezierKeyFrameTakeEffect.isNeedAnimation()) {
            return (ScaleBezierData) bezierKeyFrameTakeEffect.getDefaultData();
        }
        return BezierDataUtils.getCurrentScale(bezierKeyFrameTakeEffect, BezierDataUtils.getBezierProgress(bezierKeyFrameTakeEffect.getOutTangent(), bezierKeyFrameTakeEffect.getInTangent(), getProgressInTakeEffectByProgressInAll(bezierKeyFrameTakeEffect, max)));
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setFrameRate(int i2) {
        this.mFrameRate = i2;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
    }

    public void setLayerList(List<LayerData> list) {
        this.mLayerList = list;
    }

    public void setMaxFrame(int i2) {
        this.mMaxFrame = i2;
    }

    public void setMinFrame(int i2) {
        this.mMinFrame = i2;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public void setWidth(int i2) {
        this.mWidth = i2;
    }
}
