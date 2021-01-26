package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.engine.OrthographicCamera;
import com.arashivision.insbase.joml.Matrix4f;

public class PlaneStitchingRenderModel extends RenderModel {
    public PlaneStitchingRenderModel(RenderModelType renderModelType, RenderLifecycle renderLifecycle) {
        this(createNativeWrap(renderModelType), renderLifecycle);
    }

    public static native long createNativeWrap(RenderModelType renderModelType);

    private native long nativeGetOrghographicCamera();

    private native void nativeSetSphereRotation(float[] fArr);

    public OrthographicCamera getOrthographicCamera() {
        long nativeGetOrghographicCamera = nativeGetOrghographicCamera();
        if (0 != nativeGetOrghographicCamera) {
            return new OrthographicCamera(nativeGetOrghographicCamera);
        }
        return null;
    }

    public void setSphereRotation(Matrix4f matrix4f) {
        nativeSetSphereRotation(matrix4f.get(new float[16]));
    }

    public PlaneStitchingRenderModel(long j2, RenderLifecycle renderLifecycle) {
        super(j2, renderLifecycle);
    }
}
