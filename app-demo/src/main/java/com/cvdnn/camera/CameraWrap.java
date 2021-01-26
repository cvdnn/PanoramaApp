package com.cvdnn.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.log.Log;
import android.view.Surface;

import static android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;
import static android.hardware.Camera.Parameters.FOCUS_MODE_AUTO;
import static android.hardware.Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE;
import static android.hardware.Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO;
import static android.view.Surface.ROTATION_0;
import static android.view.Surface.ROTATION_180;
import static android.view.Surface.ROTATION_90;

public final class CameraWrap {
    private static final String TAG = "CameraEngine";

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    /**
     * 相机数量为2则打开1,1则打开0，相机ID 1为前置，0为后置
     *
     * @return
     */
    public static int getCameras() {

        return Camera.getNumberOfCameras();
    }

    ///////////////////////////////////////
    //
    //
    ///////////////////////////////////////
    private final Builder mCameraBuilder;

    private Camera mCamera;
    private Camera.Size mPreviewSize;

    private int mAdditionalRotation;

    private CameraWrap(Builder builder) {
        mCameraBuilder = builder;
    }

    public synchronized CameraWrap start() {
        if (mCameraBuilder.cameraId != -1) {
            try {
                mCamera = Camera.open(mCameraBuilder.cameraId);

                int displayOrientation = getCameraOri(ROTATION_0);
                mCamera.setDisplayOrientation(displayOrientation);

                Camera.Parameters parameters = mCamera.getParameters();
//                parameters.setPreviewFormat(mCameraBuilder.imageFormat);

                mPreviewSize = setPreviewSize(parameters);
                setFocusMode(parameters);

                mCamera.setParameters(parameters);
                mCamera.setPreviewTexture(mCameraBuilder.surfaceTexture);

                if (mCameraBuilder.mUseBuffer) {
                    mCamera.addCallbackBuffer(mCameraBuilder.bytes);
                    mCamera.setPreviewCallbackWithBuffer(mCameraBuilder.previewCallback);
                } else {
                    mCamera.setPreviewCallback(mCameraBuilder.previewCallback);
                }

                mCamera.startPreview();
            } catch (Exception e) {
                android.util.Log.e(TAG, e.getMessage(), e);
            }
        }

        return this;
    }

    public synchronized void stop() {
        if (mCamera != null) {
            try {
                mCamera.setPreviewCallback(null);
                mCamera.setPreviewDisplay(null);
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            } catch (Exception e) {
                android.util.Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public synchronized void release() {
        stop();

        mPreviewSize = null;
    }

    public synchronized boolean isStopped() {

        return mCamera == null;
    }

    public Camera camera() {
        return mCamera;
    }

    public Camera.Size previewSize() {
        return mPreviewSize;
    }

    public Camera.Size findPreviewSize(java.util.List<Camera.Size> sizes) {
        if (sizes == null || sizes.size() == 0) {
            return mCamera.getParameters().getPreviewSize();
        }
        Presize presize = mCameraBuilder.presize;

        float pRatio = (float) presize.width / (float) presize.height;
        if (pRatio > 1) {
            pRatio = 1 / pRatio;
        }
        boolean isNormalRotate = (mAdditionalRotation % 180 == 0);

        Camera.Size bestSize = sizes.get(0);
        float br = bestSize.width / (float) bestSize.height;
        int area = bestSize.width * bestSize.height;
        for (Camera.Size s : sizes) {
            if (isNormalRotate) {
                float r = s.width / (float) s.height;
//                Log.d(TAG, String.format("尺寸: %d*%d, 偏差值: %.2f", s.width, s.height, Math.abs(r - pRatio)));

                int sa = s.width * s.height;
                if (Math.abs(r - pRatio) < Math.abs(br - pRatio) && sa > area) {
                    bestSize = s;
                    br = r;
                    area = sa;
                }
            } else {
                if (Math.abs((s.width / (float) s.height) - pRatio) < Math.abs(bestSize.width / (float) bestSize.height - pRatio)) {
                    bestSize = s;
                }
            }
        }

        return bestSize;
    }

    public int getCameraOri(int rotation) {
        int degrees = rotation * 90;
        switch (rotation) {
            case ROTATION_0:
                degrees = 0;
                break;
            case ROTATION_90:
                degrees = 90;
                break;
            case ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
            default:
                break;
        }
        mAdditionalRotation /= 90;
        mAdditionalRotation *= 90;
        degrees += mAdditionalRotation;
        int result;
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(mCameraBuilder.cameraId, info);
        if (info.facing == CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;
        } else {
            result = (info.orientation - degrees + 360) % 360;
        }

        return result;
    }

    private Camera.Size setPreviewSize(Camera.Parameters parameters) {
        //预览大小设置
        Camera.Size previewSize = parameters.getPreviewSize();
        java.util.List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 0) {
            previewSize = findPreviewSize(supportedPreviewSizes);
        }

//        parameters.setPreviewSize(previewSize.width, previewSize.height);
        parameters.setPreviewSize(previewSize.width, previewSize.height);

        return previewSize;
    }

    /**
     * 对焦模式设置
     *
     * @param parameters
     * @return
     */
    private CameraWrap setFocusMode(Camera.Parameters parameters) {
        java.util.List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.size() > 0) {
            if (supportedFocusModes.contains(FOCUS_MODE_CONTINUOUS_PICTURE)) {
                parameters.setFocusMode(FOCUS_MODE_CONTINUOUS_PICTURE);

            } else if (supportedFocusModes.contains(FOCUS_MODE_CONTINUOUS_VIDEO)) {
                parameters.setFocusMode(FOCUS_MODE_CONTINUOUS_VIDEO);

            } else if (supportedFocusModes.contains(FOCUS_MODE_AUTO)) {
                parameters.setFocusMode(FOCUS_MODE_AUTO);
            }
        }


        return this;
    }

    /////////////////////////////////////
    //
    //
    /////////////////////////////////////

    public static class Builder {
        private final int cameraId;

        private int imageFormat = ImageFormat.JPEG;

        private Presize presize;

        private Camera.Parameters parameters;
        private Camera.PreviewCallback previewCallback;

        private SurfaceTexture surfaceTexture;

        private boolean mUseBuffer;
        private byte[] bytes;

        public Builder(int id) {
            this.cameraId = id;
        }

        public Builder setSurfaceTexture(SurfaceTexture surfaceTexture) {
            this.surfaceTexture = surfaceTexture;

            return this;
        }

        public Builder setImageFormat(int format) {
            this.imageFormat = format;

            return this;
        }

        public Builder setPreviewCallback(Camera.PreviewCallback cb) {
            this.previewCallback = cb;

            mUseBuffer = false;

            return this;
        }

        public Builder setPreviewCallback(Camera.PreviewCallback cb, byte[] buffer) {
            this.previewCallback = cb;

            bytes = buffer;
            mUseBuffer = true;

            return this;
        }

        public Builder setPreviewSize(int w, int h) {
            presize = new Presize(w, h);

            return this;
        }

        public final CameraWrap build() {

            return new CameraWrap(this);
        }
    }

    public static class Presize {
        /**
         * Sets the dimensions for pictures.
         *
         * @param w the photo width (pixels)
         * @param h the photo height (pixels)
         */
        public Presize(int w, int h) {
            width = w;
            height = h;
        }

        /**
         * Compares {@code obj} to this size.
         *
         * @param obj the object to compare this size with.
         * @return {@code true} if the width and height of {@code obj} is the
         * same as those of this size. {@code false} otherwise.
         */
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Presize)) {
                return false;
            }
            Presize s = (Presize) obj;
            return width == s.width && height == s.height;
        }

        @Override
        public int hashCode() {
            return width * 32713 + height;
        }

        /** width of the picture */
        public int width;
        /** height of the picture */
        public int height;
    }
}
