package com.arashivision.insta360.basemedia.ui.player.video;

import com.arashivision.graphicpath.render.engine.Transform;

public interface IPlayVideoParams {
    double[] getCustomizedPlayRange();

    int getLoadingBackgroundColor();

    int getLoadingImageResId();

    float getMuteBgmWhenSpeedMoreThan();

    Long getNetId();

    int getQueueMode();

    Integer getRenderBackgroundColor();

    float getRenderFps();

    int getRenderModelType();

    Transform getRestoreCameraTransform();

    double getRestorePlayPosition();

    boolean isApplyFlash();

    boolean isApplyMultiView();

    boolean isApplyProxy();

    boolean isApplyWatermark();

    boolean isAutoPlayAfterPrepared();

    boolean isForceVideoKeyFrameOnly();

    boolean isGestureDistanceChangeEnabled();

    boolean isGestureEnabled();

    boolean isGestureFovChangeEnabled();

    boolean isGestureHorizontalEnabled();

    boolean isGestureVerticalEnabled();

    boolean isGestureZoomEnabled();

    boolean isImageAutoScaleEnabled();

    boolean isLooping();

    boolean isNeedLoadGpsInfo();

    boolean isPlayRangeEnabled();

    boolean isResetViewAngleOnSeekComplete();

    boolean isUseTextureView();

    boolean isWithSwitchingAnimation();

    void setApplyFlash(boolean z);

    void setApplyMultiView(boolean z);

    void setApplyProxy(boolean z);

    void setApplyWatermark(boolean z);

    void setAutoPlayAfterPrepared(boolean z);

    void setCustomizedPlayRange(double[] dArr);

    void setForceVideoKeyFrameOnly(boolean z);

    void setGestureDistanceChangeEnabled(boolean z);

    void setGestureEnabled(boolean z);

    void setGestureFovChangeEnabled(boolean z);

    void setGestureHorizontalEnabled(boolean z);

    void setGestureVerticalEnabled(boolean z);

    void setGestureZoomEnabled(boolean z);

    void setImageAutoScaleEnabled(boolean z);

    void setLoadingBackgroundColor(int i2);

    void setLoadingImageResId(int i2);

    void setLooping(boolean z);

    void setMuteBgmWhenSpeedMoreThan(float f2);

    void setNeedLoadGpsInfo(boolean z);

    void setNetId(Long l);

    void setPlayRangeEnable(boolean z);

    void setQueueMode(int i2);

    void setRenderBackgroundColor(Integer num);

    void setRenderFps(float f2);

    void setRenderModelType(int i2);

    void setResetViewAngleOnSeekComplete(boolean z);

    void setRestoreCameraTransform(Transform transform);

    void setRestorePlayPosition(double d2);

    void setUseTextureView(boolean z);

    void setWithSwitchingAnimation(boolean z);
}
