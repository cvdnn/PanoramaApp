package com.deepai.paipai.support.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.AttributeSet;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Toast;
import com.baidu.location.b.l;
import com.deepai.paipai.support.camera.CameraContainer.TakePictureListener;
import com.deepai.paipai.support.file.FileOperateUtil;
import com.deepai.paipai.support.file.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CameraView extends SurfaceView implements CameraOperation {
    public static final String TAG = "CameraView";
    private Callback callback = new Callback() {
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                if (CameraView.this.mCamera == null) {
                    CameraView.this.openCamera();
                }
                CameraView.this.setCameraParameters();
                CameraView.this.mCamera.setPreviewDisplay(CameraView.this.getHolder());
            } catch (Exception e) {
                Toast.makeText(CameraView.this.getContext(), "打开相机失败", 0).show();
                Log.e(CameraView.TAG, e.getMessage());
            }
            CameraView.this.mCamera.startPreview();
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            CameraView.this.updateCameraOrientation();
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            CameraView.this.stopRecord();
            if (CameraView.this.mCamera != null) {
                CameraView.this.mCamera.stopPreview();
                CameraView.this.mCamera.release();
                CameraView.this.mCamera = null;
            }
        }
    };
    public Camera mCamera;
    private final Context mContext;
    private FlashMode mFlashMode = FlashMode.ON;
    public boolean mIsFrontCamera;
    private MediaRecorder mMediaRecorder;
    /* access modifiers changed from: private */
    public int mOrientation = 0;
    private Parameters mParameters;
    private String mRecordPath = null;
    private int mZoom = 0;
    private int maxSize = 200;

    public enum FlashMode {
        ON,
        OFF,
        AUTO,
        TORCH
    }

    public CameraView(Context context) {
        super(context);
        this.mContext = context;
        getHolder().addCallback(this.callback);
        openCamera();
        this.mIsFrontCamera = false;
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        getHolder().addCallback(this.callback);
        openCamera();
        this.mIsFrontCamera = false;
    }

    /* access modifiers changed from: protected */
    public boolean isRecording() {
        return this.mMediaRecorder != null;
    }

    public boolean startRecord() {
        if (this.mCamera == null) {
            openCamera();
        }
        if (this.mCamera == null) {
            return false;
        }
        if (this.mMediaRecorder == null) {
            this.mMediaRecorder = new MediaRecorder();
        } else {
            this.mMediaRecorder.reset();
        }
        this.mParameters = this.mCamera.getParameters();
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setVideoSource(1);
        this.mMediaRecorder.setAudioSource(1);
        this.mMediaRecorder.setProfile(CamcorderProfile.get(5));
        this.mMediaRecorder.setOrientationHint(90);
        File directory = new File(FileOperateUtil.getFolderPath(getContext(), 3, "test"));
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            Log.e("Save 3gp", "****************");
            this.mMediaRecorder.setOutputFile(new File(FileUtils.getVideoFileName()).getAbsolutePath());
            this.mMediaRecorder.prepare();
            this.mMediaRecorder.start();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Bitmap stopRecord() {
        try {
            if (this.mMediaRecorder != null) {
                this.mMediaRecorder.stop();
                this.mMediaRecorder.reset();
                this.mMediaRecorder.release();
                this.mMediaRecorder = null;
            }
            if (!(this.mParameters == null || this.mCamera == null)) {
                this.mCamera.reconnect();
                this.mCamera.stopPreview();
                this.mCamera.setParameters(this.mParameters);
                this.mCamera.startPreview();
                this.mParameters = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void stopCamera() {
        if (this.mCamera != null) {
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public ByteArrayOutputStream compress(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, baos);
        int options = 99;
        while (baos.toByteArray().length / 1024 > this.maxSize) {
            options -= 3;
            if (options < 0) {
                break;
            }
            Log.i(TAG, (baos.toByteArray().length / 1024) + "");
            baos.reset();
            bitmap.compress(CompressFormat.JPEG, options, baos);
        }
        return baos;
    }

    public void switchCamera() {
        this.mIsFrontCamera = !this.mIsFrontCamera;
        openCamera();
        if (this.mCamera != null) {
            setCameraParameters();
            updateCameraOrientation();
            try {
                this.mCamera.setPreviewDisplay(getHolder());
                this.mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean openCamera() {
        if (this.mCamera != null) {
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
        if (this.mIsFrontCamera) {
            CameraInfo cameraInfo = new CameraInfo();
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    try {
                        this.mCamera = Camera.open(i);
                    } catch (Exception e) {
                        this.mCamera = null;
                        return false;
                    }
                }
            }
        } else {
            try {
                this.mCamera = Camera.open();
            } catch (Exception e2) {
                this.mCamera = null;
                return false;
            }
        }
        return true;
    }

    public FlashMode getFlashMode() {
        return this.mFlashMode;
    }

    public void setFlashMode(FlashMode flashMode) {
        if (this.mCamera != null) {
            this.mFlashMode = flashMode;
            Parameters parameters = this.mCamera.getParameters();
            switch (flashMode) {
                case ON:
                    parameters.setFlashMode("on");
                    break;
                case AUTO:
                    parameters.setFlashMode("auto");
                    break;
                case TORCH:
                    parameters.setFlashMode("torch");
                    break;
                default:
                    parameters.setFlashMode(l.cW);
                    break;
            }
            this.mCamera.setParameters(parameters);
        }
    }

    public void takePicture(PictureCallback callback2, TakePictureListener listener) {
        this.mCamera.takePicture(null, null, callback2);
    }

    /* access modifiers changed from: protected */
    public void onFocus(Point point, AutoFocusCallback callback2) {
        if (this.mCamera != null) {
            Parameters parameters = this.mCamera.getParameters();
            parameters.setFocusMode("auto");
            if (parameters.getMaxNumFocusAreas() <= 0) {
                this.mCamera.autoFocus(callback2);
                return;
            }
            List<Area> areas = new ArrayList<>();
            int left = point.x - 300;
            int top = point.y - 300;
            int right = point.x + 300;
            int bottom = point.y + 300;
            if (left < -1000) {
                left = -1000;
            }
            if (top < -1000) {
                top = -1000;
            }
            if (right > 1000) {
                right = 1000;
            }
            if (bottom > 1000) {
                bottom = 1000;
            }
            areas.add(new Area(new Rect(left, top, right, bottom), 100));
            parameters.setFocusAreas(areas);
            try {
                this.mCamera.setParameters(parameters);
                this.mCamera.autoFocus(callback2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getMaxZoom() {
        if (this.mCamera == null) {
            return -1;
        }
        Parameters parameters = this.mCamera.getParameters();
        if (!parameters.isZoomSupported()) {
            return -1;
        }
        if (parameters.getMaxZoom() <= 40) {
            return parameters.getMaxZoom();
        }
        return 40;
    }

    public void setZoom(int zoom) {
        Parameters parameters;
        if (this.mCamera != null) {
            if (this.mParameters != null) {
                parameters = this.mParameters;
            } else {
                parameters = this.mCamera.getParameters();
            }
            if (parameters.isZoomSupported()) {
                parameters.setZoom(zoom);
                this.mCamera.setParameters(parameters);
                this.mZoom = zoom;
            }
        }
    }

    public int getZoom() {
        return this.mZoom;
    }

    /* access modifiers changed from: private */
    public void setCameraParameters() {
        Size size;
        Parameters parameters = this.mCamera.getParameters();
        List<Size> sizeList = parameters.getSupportedPreviewSizes();
        if (sizeList.size() > 0) {
            Collections.sort(sizeList, new Comparator<Size>() {
                public int compare(Size lhs, Size rhs) {
                    return (rhs.width * rhs.height) - (lhs.width * lhs.height);
                }
            });
            Size cameraSize = (Size) sizeList.get(0);
            Iterator it = sizeList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Size size2 = (Size) it.next();
                if (size2.width * size2.height <= 921600) {
                    cameraSize = size2;
                    break;
                }
            }
            parameters.setPreviewSize(cameraSize.width, cameraSize.height);
        }
        List<Size> sizeList2 = parameters.getSupportedPictureSizes();
        if (sizeList2.size() > 0) {
            Collections.sort(sizeList2, new Comparator<Size>() {
                public int compare(Size lhs, Size rhs) {
                    return (rhs.width * rhs.height) - (lhs.width * lhs.height);
                }
            });
            Size cameraSize2 = (Size) sizeList2.get(sizeList2.size() - 1);
            Iterator it2 = sizeList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                size = (Size) it2.next();
                if (size.width * size.height > 900000 && size.width * size.height <= 5000000) {
                    if (((double) (((float) size.width) / ((float) size.height))) == 0.5625d || ((double) (((float) size.height) / ((float) size.width))) == 0.5625d) {
                        cameraSize2 = size;
                    }
                }
            }
            cameraSize2 = size;
            parameters.setPictureSize(cameraSize2.width, cameraSize2.height);
        }
        parameters.setPictureFormat(256);
        parameters.setJpegQuality(100);
        parameters.setJpegThumbnailQuality(100);
        parameters.setFocusMode("continuous-picture");
        this.mCamera.setParameters(parameters);
        setFlashMode(this.mFlashMode);
        setZoom(this.mZoom);
    }

    private void startOrientationChangeListener() {
        new OrientationEventListener(getContext()) {
            public void onOrientationChanged(int rotation) {
                int rotation2;
                if ((rotation >= 0 && rotation <= 45) || rotation > 315) {
                    rotation2 = 0;
                } else if (rotation > 45 && rotation <= 135) {
                    rotation2 = 90;
                } else if (rotation > 135 && rotation <= 225) {
                    rotation2 = 180;
                } else if (rotation <= 225 || rotation > 315) {
                    rotation2 = 0;
                } else {
                    rotation2 = 270;
                }
                if (rotation2 != CameraView.this.mOrientation) {
                    CameraView.this.mOrientation = rotation2;
                    CameraView.this.updateCameraOrientation();
                }
            }
        }.enable();
    }

    /* access modifiers changed from: private */
    public void updateCameraOrientation() {
        if (this.mCamera != null) {
            Parameters parameters = this.mCamera.getParameters();
            int rotation = this.mOrientation + 90 == 360 ? 0 : this.mOrientation + 90;
            if (this.mIsFrontCamera) {
                if (rotation == 90) {
                    rotation = 270;
                } else if (rotation == 270) {
                    rotation = 90;
                }
            }
            parameters.setRotation(rotation);
            this.mCamera.setDisplayOrientation(90);
            this.mCamera.setParameters(parameters);
        }
    }

    public void setCameraDisplayOrientation(Activity activity, int cameraId) {
        int result;
        CameraInfo info = new CameraInfo();
        Camera.getCameraInfo(cameraId, info);
        int degrees = 0;
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
                degrees = 0;
                break;
            case 1:
                degrees = 90;
                break;
            case 2:
                degrees = 180;
                break;
            case 3:
                degrees = 270;
                break;
        }
        if (info.facing == 1) {
            result = (360 - ((info.orientation + degrees) % 360)) % 360;
        } else {
            result = ((info.orientation - degrees) + 360) % 360;
        }
        this.mCamera.setDisplayOrientation(result);
    }

    public void releaseCamera() {
        if (this.mCamera != null) {
            this.mCamera.release();
            this.mCamera = null;
        }
    }
}
