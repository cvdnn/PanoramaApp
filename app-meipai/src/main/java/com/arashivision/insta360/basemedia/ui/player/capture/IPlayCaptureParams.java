package com.arashivision.insta360.basemedia.ui.player.capture;

public interface IPlayCaptureParams {
    CameraRenderSurfaceInfo getCameraRenderSurfaceInfo();

    int getLiveRenderModelType();

    String[] getMultiViewTrackModelPaths();

    int getRenderModelType();

    boolean isApplyMultiView();

    boolean isApplyWatermark();

    boolean isAutoRotateEnable();

    boolean isCopyVideoHwaccel();

    boolean isGestureEnabled();

    boolean isGestureHorizontalEnabled();

    boolean isGestureVerticalEnabled();

    boolean isGestureZoomEnabled();

    boolean isNeedInitMultiView();

    boolean isOnlyStitchSurfaceRender();

    boolean isStabilizeEnabled();

    boolean isWithSwitchingAnimation();

    void setApplyMultiView(boolean z);

    void setApplyWatermark(boolean z);

    void setAutoRotateEnable(boolean z);

    void setCameraRenderSurfaceInfo(CameraRenderSurfaceInfo cameraRenderSurfaceInfo);

    void setCopyVideoHwaccel(boolean z);

    void setGestureEnabled(boolean z);

    void setGestureHorizontalEnabled(boolean z);

    void setGestureVerticalEnabled(boolean z);

    void setGestureZoomEnabled(boolean z);

    void setLiveRenderModelType(int i2);

    void setNeedInitMultiView(boolean z);

    void setOnlyStitchSurfaceRender(boolean z);

    void setRenderModelType(int i2);

    void setStabilizeEnabled(boolean z);

    void setWithSwitchingAnimation(boolean z);
}
