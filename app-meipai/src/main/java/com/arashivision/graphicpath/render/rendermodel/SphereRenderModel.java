package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.util.CameraController;

public class SphereRenderModel extends RenderModel {
    public SphereRenderModel(RenderModelType renderModelType, BaseCameraController baseCameraController, boolean z, RenderLifecycle renderLifecycle) {
        this(createNativeWrap(renderModelType, baseCameraController, z), renderLifecycle);
    }

    public static native long createNativeWrap(RenderModelType renderModelType, BaseCameraController baseCameraController, boolean z);

    private native long nativeGetCameraController(boolean z);

    public CameraController getBuiltinCameraController() {
        BaseCameraController cameraController = getCameraController();
        if (cameraController instanceof CameraController) {
            return (CameraController) cameraController;
        }
        return null;
    }

    public BaseCameraController getCameraController() {
        long nativeGetCameraController = nativeGetCameraController(true);
        if (nativeGetCameraController != 0) {
            return new CameraController(nativeGetCameraController);
        }
        long nativeGetCameraController2 = nativeGetCameraController(false);
        if (nativeGetCameraController2 != 0) {
            return new BaseCameraController(nativeGetCameraController2, "BaseCameraController");
        }
        return null;
    }

    public SphereRenderModel(RenderModelType renderModelType, RenderLifecycle renderLifecycle) {
        this(createNativeWrap(renderModelType, null, true), renderLifecycle);
    }

    public SphereRenderModel(long j2, RenderLifecycle renderLifecycle) {
        super(j2, renderLifecycle);
    }
}
