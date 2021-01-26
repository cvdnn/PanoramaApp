package com.baidu.pass.biometrics.face.liveness.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import java.util.ArrayList;
import java.util.List;

public class CameraInterface {
    public static final int CAMERA_TYPE_LIVENESS = 3;
    public static final int DEFAULT_PREVIEW_HEIGHT = 480;
    public static final int DEFAULT_PREVIEW_WIDTH = 640;
    public static final float MAX_DIFF_MATCH_PREVIEW_SCALE = 0.2f;
    public static final String TAG = "CameraInterface";
    public static int cameraId = -1;
    public Camera camera;
    public int displayRotation;
    public String flashMode = "off";
    public boolean isFrontCamera = true;
    public SurfaceHolder mSurfaceHolder;
    public CameraSize previewSize;

    public static class CameraSize {
        public int height;
        public int width;

        public CameraSize(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }
    }

    private CameraSize getMinMatchPreviewSize(Activity activity, Parameters parameters) {
        CameraSize cameraSize = this.previewSize;
        if (cameraSize != null) {
            return cameraSize;
        }
        List supportedPreviewSizes = getSupportedPreviewSizes(activity, parameters);
        this.previewSize = new CameraSize(DEFAULT_PREVIEW_WIDTH, 480);
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return this.previewSize;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        CameraSize cameraSize2 = new CameraSize(defaultDisplay.getWidth(), PassBioDisplayUtil.getNavigationBarHeight(activity) + defaultDisplay.getHeight());
        float f2 = ((float) cameraSize2.height) / ((float) cameraSize2.width);
        CameraSize cameraSize3 = this.previewSize;
        float f3 = (float) (cameraSize3.width / cameraSize3.height);
        for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
            CameraSize cameraSize4 = (CameraSize) supportedPreviewSizes.get(i2);
            float abs = Math.abs((((float) cameraSize4.width) / ((float) cameraSize4.height)) - f2);
            if (abs < f3) {
                this.previewSize = cameraSize4;
                f3 = abs;
            }
        }
        return this.previewSize;
    }

    @TargetApi(5)
    private List<CameraSize> getSupportedPreviewSizes(Activity activity, Parameters parameters) {
        List supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        CameraSize cameraSize = new CameraSize(defaultDisplay.getWidth(), PassBioDisplayUtil.getNavigationBarHeight(activity) + defaultDisplay.getHeight());
        int i2 = 153600;
        int i3 = 921600;
        int i4 = cameraSize.width;
        int i5 = cameraSize.height;
        if ((i4 * i5) / 4 > 921600) {
            i3 = 2073600;
            i2 = (i4 * i5) / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < supportedPreviewSizes.size(); i6++) {
            Size size = (Size) supportedPreviewSizes.get(i6);
            int i7 = size.width;
            int i8 = size.height;
            if (i7 * i8 >= i2 && i7 * i8 <= i3) {
                arrayList.add(new CameraSize(i7, i8));
            }
        }
        return arrayList;
    }

    @TargetApi(9)
    public boolean doOpenCamera(Activity activity, int i2) {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.stopPreview();
            this.camera.release();
            this.camera = null;
        }
        if (getCameraNum() == 1) {
            this.isFrontCamera = false;
        }
        if (this.isFrontCamera) {
            cameraId = 1;
        } else {
            cameraId = 0;
        }
        try {
            this.camera = Camera.open(cameraId);
            setCameraParam(activity);
            return true;
        } catch (Throwable th) {
            Log.e(th);
            Camera camera3 = this.camera;
            if (camera3 != null) {
                camera3.release();
                this.camera = null;
            }
            return false;
        }
    }

    public void doStartPreview(Activity activity, SurfaceHolder surfaceHolder) {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            try {
                this.mSurfaceHolder = surfaceHolder;
                camera2.setPreviewDisplay(surfaceHolder);
                this.camera.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public synchronized void doStopCamera() {
        try {
            if (this.mSurfaceHolder != null) {
                this.mSurfaceHolder.getSurface().release();
            }
            if (this.camera != null) {
                this.camera.setPreviewCallback(null);
                this.camera.stopPreview();
                this.camera.release();
                this.camera = null;
            }
            this.isFrontCamera = true;
        } catch (Exception e2) {
            Log.e(e2);
        }
        return;
    }

    @TargetApi(9)
    public int getCameraNum() {
        return Camera.getNumberOfCameras();
    }

    public CameraSize getPreviewSize() {
        if (this.previewSize == null) {
            this.previewSize = new CameraSize(DEFAULT_PREVIEW_WIDTH, 480);
        }
        return this.previewSize;
    }

    public boolean isFrontCamera() {
        if (getCameraNum() == 1) {
            this.isFrontCamera = false;
        }
        return this.isFrontCamera;
    }

    @TargetApi(8)
    public void setCameraParam(Activity activity) {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            Parameters parameters = camera2.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            int i2 = 0;
            setPictureSize(parameters, setPreviewSize(activity, parameters, false));
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else if (rotation == 3) {
                    i2 = HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE;
                }
            }
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(cameraId, cameraInfo);
            if (cameraInfo.facing == 1) {
                int i3 = (cameraInfo.orientation + i2) % 360;
                this.displayRotation = i3;
                this.displayRotation = (360 - i3) % 360;
            } else {
                this.displayRotation = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            this.camera.setDisplayOrientation(this.displayRotation);
            String str = "continuous-video";
            if (parameters.getSupportedFocusModes().contains(str)) {
                parameters.setFocusMode(str);
            }
            String str2 = "off";
            if (parameters.getSupportedFlashModes() == null) {
                this.flashMode = str2;
            } else if (this.isFrontCamera) {
                this.flashMode = str2;
                parameters.setFlashMode(str2);
            } else {
                parameters.setFlashMode(this.flashMode);
            }
            this.camera.setParameters(parameters);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if ((r7 * r8) < 5000000) goto L_0x0037;
     */
    @android.annotation.TargetApi(5)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPictureSize(android.hardware.Camera.Parameters r12, com.baidu.pass.biometrics.face.liveness.camera.CameraInterface.CameraSize r13) {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto L_0x000b
            int r1 = r13.width
            float r1 = (float) r1
            int r13 = r13.height
            float r13 = (float) r13
            float r1 = r1 / r13
            goto L_0x000c
        L_0x000b:
            r1 = r0
        L_0x000c:
            java.util.List r13 = r12.getSupportedPictureSizes()
            if (r13 != 0) goto L_0x0013
            return
        L_0x0013:
            int r2 = r13.size()
            r3 = 0
            r4 = 0
            r5 = r4
        L_0x001a:
            if (r3 >= r2) goto L_0x0069
            java.lang.Object r6 = r13.get(r3)
            android.hardware.Camera$Size r6 = (android.hardware.Camera.Size) r6
            if (r5 != 0) goto L_0x0025
            goto L_0x0037
        L_0x0025:
            int r7 = r6.width
            int r8 = r5.width
            if (r7 < r8) goto L_0x0038
            int r8 = r6.height
            int r9 = r5.height
            if (r8 < r9) goto L_0x0038
            int r7 = r7 * r8
            r8 = 5000000(0x4c4b40, float:7.006492E-39)
            if (r7 >= r8) goto L_0x0038
        L_0x0037:
            r5 = r6
        L_0x0038:
            int r7 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0066
            int r7 = r6.width
            float r7 = (float) r7
            int r8 = r6.height
            float r8 = (float) r8
            float r7 = r7 / r8
            float r7 = r7 - r1
            float r7 = java.lang.Math.abs(r7)
            r8 = 1041865114(0x3e19999a, float:0.15)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0066
            int r7 = r6.width
            int r8 = r6.height
            int r9 = r7 * r8
            r10 = 7000000(0x6acfc0, float:9.809089E-39)
            if (r9 >= r10) goto L_0x0066
            if (r4 != 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            int r9 = r4.width
            if (r7 <= r9) goto L_0x0066
            int r7 = r4.height
            if (r8 <= r7) goto L_0x0066
        L_0x0065:
            r4 = r6
        L_0x0066:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x0069:
            if (r4 != 0) goto L_0x006c
            r4 = r5
        L_0x006c:
            int r13 = r4.width
            int r0 = r4.height
            r12.setPictureSize(r13, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.face.liveness.camera.CameraInterface.setPictureSize(android.hardware.Camera$Parameters, com.baidu.pass.biometrics.face.liveness.camera.CameraInterface$CameraSize):void");
    }

    public void setPreviewCallback(PreviewCallback previewCallback) {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.setPreviewCallback(previewCallback);
        }
    }

    public CameraSize setPreviewSize(Activity activity, Parameters parameters, boolean z) {
        CameraSize minMatchPreviewSize = getMinMatchPreviewSize(activity, parameters);
        parameters.setPreviewSize(minMatchPreviewSize.width, minMatchPreviewSize.height);
        return minMatchPreviewSize;
    }

    public void startPreview() {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.startPreview();
        }
    }

    public void stopPreview() {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.stopPreview();
        }
    }
}
