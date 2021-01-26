package com.arashivision.graphicpath.render.util;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.base.SphereViewMode;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.engine.animator.Animator;
import java.nio.FloatBuffer;

public class CameraController extends BaseCameraController {
    public TouchInputTransformListener mTouchInputTransformListener;

    public interface TouchInputTransformListener {
        void onTouchInputTransform(Transform transform);
    }

    static {
        RenderLibsLoader.load();
    }

    public CameraController() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    private native void nativeSetTransform(float[] fArr);

    private synchronized void notifyTouchInputTransform(FloatBuffer floatBuffer) {
        if (this.mTouchInputTransformListener != null) {
            this.mTouchInputTransformListener.onTouchInputTransform(new Transform().fromFloatBuffer(floatBuffer));
        }
    }

    public synchronized void setOnTouchInputTransformListener(TouchInputTransformListener touchInputTransformListener) {
        this.mTouchInputTransformListener = touchInputTransformListener;
    }

    public void setTransform(Transform transform) {
        nativeSetTransform(transform.toFloatArray());
    }

    public native void setTransformAnimator(Animator animator);

    public native void setViewMode(SphereViewMode sphereViewMode);

    public native void stopAllAnimations();

    public native void stopPinchAnimator();

    public native void stopScroller();

    public native void stopTransformAnimator();

    public CameraController(long j2) {
        super(j2, "SphereCameraController");
    }
}
