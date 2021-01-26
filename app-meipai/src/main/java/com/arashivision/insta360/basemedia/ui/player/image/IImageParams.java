package com.arashivision.insta360.basemedia.ui.player.image;

import a.a.a.a.a.f.e.a;
import a.a.a.a.e.a.d;
import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.k.c;
import a.a.a.a.e.a.e.k.f;
import a.a.a.a.e.a.e.k.j;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import java.util.List;

public interface IImageParams extends d, f, c, j, b, Cloneable {
    void addReference(a aVar);

    boolean cancelStabilizer();

    /* bridge */ /* synthetic */ b clone();

    IImageParams clone();

    BMGStabilizer createStabilizer(boolean z);

    AssetInfo getAssetInfo();

    int getBeautyFilterLevel();

    float getBlendAngleRad();

    String getCacheCutSceneImagePath();

    String getCacheWorkThumbnailRootPath();

    int getCameraFacing();

    String getCameraType();

    Constraint getConstraint();

    int[] getConstraintRatio();

    int getCount();

    long getCreationTime();

    long getExtraInfoPos();

    FileType getFileType();

    int getFitMode();

    a.a.a.a.b.d getGps();

    double getGyroDelayTime();

    int getHeight();

    int getHeightOrigin();

    String getIdenticalKey();

    int getIndex();

    LogoInfo getLogoInfo();

    String getMediaOffset();

    String getName();

    String getOffsetForPlay();

    List<a.a.a.a.e.a.g.c> getOptimizationRunnableList();

    float getPowerPanoRotateYaw();

    int getRotateDegree();

    int[] getScreenRatio();

    String getSerial();

    BMGSingleGyroStabilizer getSingleStabilizer();

    int getStabType();

    BMGStabilizer getStabilizer();

    StabilizingType getStabilizingType();

    a.a.a.a.a.g.a getStyleFilter();

    float getStyleFilterIntensity();

    Transform getTransform();

    String getUrlForParse();

    String getUrlsForPlay();

    int getVRMode();

    a.a.a.a.e.a.g.f getWatermarkRectCalculator();

    String getWatermarkResourcesPath();

    int getWidth();

    int getWidthOrigin();

    a.a.a.a.b.f getWindowCropInfo();

    boolean hasGyroList();

    boolean hasOffsetForPlay();

    boolean hasThumbnail();

    boolean isColorAdjustEnabled();

    boolean isDualStream();

    boolean isDynamicStitch();

    boolean isHDRPhoto();

    boolean isImageFusion();

    boolean isIntervalShooting();

    boolean isLocal();

    boolean isLogoEnabled();

    boolean isPowerPanoMode();

    boolean isRotateEnabled();

    boolean isRotateScreenRatioEnabled();

    boolean isSelfie();

    boolean isUseStabilizerCache();

    boolean isValid();

    boolean isWatermarkEnabled();

    boolean isWideAngle();

    void loadExtraData();

    boolean loadStabilizer(a.a.a.a.a.e.a aVar);

    byte[] loadThumbnail();

    void removeReference(a aVar);

    void resetStabilizer();

    void setBeautyFilterLevel(int i2);

    void setBlendAngleRad(float f2);

    void setCacheCutSceneImagePath(String str);

    void setCacheWorkThumbnailRootPath(String str);

    void setCameraFacing(int i2);

    void setColorAdjustEnabled(boolean z);

    void setConstraint(Constraint constraint);

    void setConstraintRatio(int[] iArr);

    void setDynamicStitch(boolean z);

    void setFileType(FileType fileType);

    void setFitMode(int i2);

    void setImageFusion(boolean z);

    void setIndex(int i2);

    void setLogoEnabled(boolean z);

    void setLogoInfo(LogoInfo logoInfo);

    void setOffsetForPlay(String str);

    void setOptimizationRunnableList(List<a.a.a.a.e.a.g.c> list);

    void setPowerPanoMode(boolean z);

    void setPowerPanoRotateYaw(float f2);

    void setRotateDegree(int i2);

    void setRotateEnabled(boolean z);

    void setRotateScreenRatioEnabled(boolean z);

    void setScreenRatio(int[] iArr);

    void setSelfie(boolean z);

    void setStabType(int i2);

    void setStabilizerCacheRootPath(String str);

    void setStyleFilter(a.a.a.a.a.g.a aVar);

    void setStyleFilterIntensity(float f2);

    void setTransform(Transform transform);

    void setUrlsForPlay(String str);

    void setUseStabilizerCache(boolean z);

    void setVRMode(int i2);

    void setWatermarkEnabled(boolean z);

    void setWatermarkRectCalculator(a.a.a.a.e.a.g.f fVar);

    void setWatermarkResourcesPath(String str);

    void setWindowCropInfo(a.a.a.a.b.f fVar);

    void updateStabilizer(int i2);

    void updateStabilizerByFovAndDistanceIfNeeded();
}
