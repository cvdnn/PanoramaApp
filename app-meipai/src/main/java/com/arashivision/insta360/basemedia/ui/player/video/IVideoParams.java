package com.arashivision.insta360.basemedia.ui.player.video;

import a.a.a.a.e.a.d;
import a.a.a.a.e.a.e.k.a;
import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.k.c;
import a.a.a.a.e.a.e.k.e;
import a.a.a.a.e.a.e.k.f;
import a.a.a.a.e.a.e.k.g;
import a.a.a.a.e.a.e.k.h;
import a.a.a.a.e.a.e.k.i;
import a.a.a.a.e.a.e.k.j;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import java.util.List;

public interface IVideoParams extends d, f, j, b, g, c, a.a.a.a.e.a.e.k.d, h, a, i, e, Cloneable {
    void addReference(a.a.a.a.a.f.e.a aVar);

    boolean cancelStabilizer();

    /* bridge */ /* synthetic */ b clone();

    IVideoParams clone();

    boolean containsBgmData();

    boolean containsRecordListData();

    boolean containsSpeedSectionListData();

    boolean containsTrimEndData();

    boolean containsTrimStartData();

    BMGStabilizer createStabilizer(boolean z);

    List<a.a.a.a.a.b.a> getAAADataList();

    AssetInfo getAssetInfo();

    List<a.a.a.a.e.a.i.b> getAudioEffectList();

    int getBeautyFilterLevel();

    long getBgmDuration();

    long getBgmOffset();

    long[] getBgmRange();

    String getBgmUrl();

    float getBgmWeight();

    int getBitrate();

    float getBlendAngleRad();

    String getCacheCutSceneVideoPath();

    String getCacheVideoProxyRootPath();

    String getCacheWorkThumbnailRootPath();

    int getCameraFacing();

    String getCameraType();

    Constraint getConstraint();

    int[] getConstraintRatio();

    float getContrastIntensity();

    long getCreationTime();

    int getDenoiseLevel();

    double getDurationInMs();

    List<a.a.a.a.a.c.a> getExposureDataList();

    long[] getExtraInfoPos();

    FileType getFileType();

    long getFirstFrameTimeStamp();

    long getFirstGpsTimeStamp();

    long getFirstGpsTimeStampFormatted(List<a.a.a.a.a.a.a> list);

    int getFitMode();

    double getFps();

    int getFrameCount();

    a.a.a.a.b.d getGps();

    double getGyroDelayTime();

    int getHDREffectLevel();

    float getHDRStrength();

    int getHeight();

    int getHeightOrigin();

    String getIdenticalKey();

    LogoInfo getLogoInfo();

    String[] getLrvUrlsForPlay();

    a.a.a.a.a.d.a getLutFilter();

    String getMediaOffset();

    List<a.a.a.a.e.a.i.d> getMultiViewClipList();

    String getName();

    String getOffsetForPlay();

    List<a.a.a.a.e.a.g.c> getOptimizationRunnableList();

    a.a.a.a.e.a.l.f.a getRecordConverter();

    List<a.a.a.a.e.a.i.h> getRecordList();

    int getRotateDegree();

    int[] getScreenRatio();

    String getSerial();

    float getSharpnessIntensity();

    BMGSingleGyroStabilizer getSingleStabilizer();

    float getSourceVolume();

    double getSpeedFactor();

    List<a.a.a.a.e.a.i.g> getSpeedSectionList();

    int getStabType();

    BMGStabilizer getStabilizer();

    StabilizingType getStabilizingType();

    a.a.a.a.a.g.a getStyleFilter();

    float getStyleFilterIntensity();

    float getSuperNightDenoiseLevel();

    double getTrimEnd();

    double getTrimStart();

    String getUrlForParse();

    String[] getUrlsForPlay();

    int getVRMode();

    a.a.a.a.e.a.g.f getWatermarkRectCalculator();

    String getWatermarkResourcesPath();

    int getWidth();

    int getWidthOrigin();

    boolean hasAAAList();

    boolean hasAudio();

    boolean hasExposureList();

    boolean hasGpsList();

    boolean hasGyroList();

    boolean hasOffsetForPlay();

    boolean hasThumbnail();

    boolean hasThumbnailExt();

    boolean inputGyroBySegment();

    boolean isBulletTime();

    boolean isColorAdjustEnabled();

    boolean isDenoise();

    boolean isDrifterOptimize();

    boolean isDualStream();

    boolean isDynamicStitch();

    boolean isHDREnabled();

    boolean isHDRVideo();

    boolean isImageFusion();

    boolean isInstaMedia();

    boolean isLocal();

    boolean isLogoEnabled();

    boolean isMJpeg();

    boolean isMotionBlur();

    boolean isRotateEnabled();

    boolean isRotateScreenRatioEnabled();

    boolean isSelfie();

    boolean isSlowMo();

    boolean isSpeedSectionCopySameFrame();

    boolean isStabilizedInCamera();

    boolean isStabilizerLoaded();

    boolean isStaticTimeLapse();

    boolean isSuperNight();

    boolean isTimeLapse();

    boolean isUseStabilizerCache();

    boolean isValid();

    boolean isVideo();

    boolean isWatermarkEnabled();

    boolean isWideAngle();

    byte[] loadAAA();

    byte[] loadExposure();

    void loadExtraData();

    byte[] loadGps();

    boolean loadStabilizer(a.a.a.a.a.e.a aVar);

    byte[] loadThumbnail();

    byte[] loadThumbnailExt();

    void removeReference(a.a.a.a.a.f.e.a aVar);

    void resetStabilizer();

    void setAudioEffectList(List<a.a.a.a.e.a.i.b> list);

    void setBeautyFilterLevel(int i2);

    void setBgmDuration(long j2);

    void setBgmOffset(long j2);

    void setBgmRange(long[] jArr);

    void setBgmUrl(String str);

    void setBgmWeight(float f2);

    void setBlendAngleRad(float f2);

    void setCacheCutSceneVideoPath(String str);

    void setCacheVideoProxyRootPath(String str);

    void setCacheWorkThumbnailRootPath(String str);

    void setCameraFacing(int i2);

    void setColorAdjustEnabled(boolean z);

    void setConstraint(Constraint constraint);

    void setConstraintRatio(int[] iArr);

    void setContrastIntensity(float f2);

    void setDenoise(boolean z);

    void setDenoiseLevel(int i2);

    void setDrifterOptimize(boolean z);

    void setDurationInMs(double d2);

    void setDynamicStitch(boolean z);

    void setFileType(FileType fileType);

    void setFitMode(int i2);

    void setFps(double d2);

    void setFrameCount(int i2);

    void setHDREffectLevel(int i2);

    void setHDREnabled(boolean z);

    void setHDRStrength(float f2);

    void setImageFusion(boolean z);

    void setLogoEnabled(boolean z);

    void setLrvUrlsForPlay(String[] strArr);

    void setLutFilter(a.a.a.a.a.d.a aVar);

    void setMotionBlur(boolean z);

    void setMultiViewClipList(List<a.a.a.a.e.a.i.d> list);

    void setOffsetForPlay(String str);

    void setOptimizationRunnableList(List<a.a.a.a.e.a.g.c> list);

    void setRecordConverter(a.a.a.a.e.a.l.f.a aVar);

    void setRecordList(List<a.a.a.a.e.a.i.h> list);

    void setRotateDegree(int i2);

    void setRotateEnabled(boolean z);

    void setRotateScreenRatioEnabled(boolean z);

    void setScreenRatio(int[] iArr);

    void setSelfie(boolean z);

    void setSharpnessIntensity(float f2);

    void setSourceVolume(float f2);

    void setSpeedFactor(double d2);

    void setSpeedSectionCopySameFrame(boolean z);

    void setSpeedSectionList(List<a.a.a.a.e.a.i.g> list);

    void setStabType(int i2);

    void setStabilizerCacheRootPath(String str);

    void setStyleFilter(a.a.a.a.a.g.a aVar);

    void setStyleFilterIntensity(float f2);

    void setSuperNight(boolean z);

    void setSuperNightDenoiseLevel(float f2);

    void setTrimEnd(double d2);

    void setTrimStart(double d2);

    void setUrlsForPlay(String[] strArr);

    void setUseStabilizerCache(boolean z);

    void setVRMode(int i2);

    void setWatermarkEnabled(boolean z);

    void setWatermarkRectCalculator(a.a.a.a.e.a.g.f fVar);

    void setWatermarkResourcesPath(String str);

    void updateStabilizer(int i2);

    void updateStabilizerByFovAndDistanceIfNeeded();

    void updateStabilizerByFrameTimestampInMsForExport();

    void updateStabilizerByFrameTimestampInMsForPreview(PreviewerSource previewerSource, int i2);
}
