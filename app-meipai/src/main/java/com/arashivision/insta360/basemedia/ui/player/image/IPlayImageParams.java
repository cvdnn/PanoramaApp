package com.arashivision.insta360.basemedia.ui.player.image;

import com.arashivision.graphicpath.render.engine.Transform;

public interface IPlayImageParams {
    int getRenderModelType();

    Transform getRestoreCameraTransform();

    boolean isApplyWatermark();

    boolean isGestureEnabled();

    boolean isGestureHorizontalEnabled();

    boolean isGestureVerticalEnabled();

    boolean isGestureZoomEnabled();

    boolean isWithSwitchingAnimation();

    void setApplyWatermark(boolean z);

    void setGestureEnabled(boolean z);

    void setGestureHorizontalEnabled(boolean z);

    void setGestureVerticalEnabled(boolean z);

    void setGestureZoomEnabled(boolean z);

    void setRenderModelType(int i2);

    void setRestoreCameraTransform(Transform transform);

    void setWithSwitchingAnimation(boolean z);
}
