package com.arashivision.sdkcamera.camera;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.camera.listener.ICameraLiveStateListener;
import com.arashivision.insbase.autils.Network;
import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType;
import com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType;
import com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.ICaptureStatusChangedListener;
import com.arashivision.insta360.basecamera.camera.CameraManager;
import com.arashivision.insta360.basecamera.camera.CameraType;
import com.arashivision.insta360.basecamera.camera.setting.StreamResolution;
import com.arashivision.insta360.basecamera.camera.setting.TimelapseParams;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.insta360.basecamera.util.CameraMediaUtils;
import com.arashivision.onecamera.InfoUpdateListener;
import com.arashivision.onecamera.render.RenderMethod;
import com.arashivision.onecamera.render.RenderMode;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;
import com.arashivision.sdkcamera.camera.callback.ICameraOperateCallback;
import com.arashivision.sdkcamera.camera.callback.ICaptureStatusListener;
import com.arashivision.sdkcamera.camera.callback.ILiveStatusListener;
import com.arashivision.sdkcamera.camera.callback.IPreviewStatusListener;
import com.arashivision.sdkcamera.camera.live.LiveParamsBuilder;
import com.arashivision.sdkcamera.camera.resolution.PreviewStreamResolution;
import e.a.a.a.a;
import e.b.d.a.b;
import e.b.d.a.c;
import e.b.d.a.d;
import e.b.d.a.e;
import e.b.d.a.f;
import e.b.d.a.g;
import e.b.d.a.h;
import e.b.d.a.i;
import e.c.f.n.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InstaCameraManager {
    public static final int CAPTURE_TYPE_BULLET_TIME_RECORD = 1008;
    public static final int CAPTURE_TYPE_BURST_CAPTURE = 1007;
    public static final int CAPTURE_TYPE_HDR_CAPTURE = 1001;
    public static final int CAPTURE_TYPE_HDR_RECORD = 1004;
    public static final int CAPTURE_TYPE_IDLE = -1;
    public static final int CAPTURE_TYPE_INTERVAL_RECORD = 1010;
    public static final int CAPTURE_TYPE_INTERVAL_SHOOTING = 1002;
    public static final int CAPTURE_TYPE_NIGHT_SCENE_CAPTURE = 1006;
    public static final int CAPTURE_TYPE_NORMAL_CAPTURE = 1000;
    public static final int CAPTURE_TYPE_NORMAL_RECORD = 1003;
    public static final int CAPTURE_TYPE_STATIC_TIMELAPSE = 1011;
    public static final int CAPTURE_TYPE_TIMELAPSE = 1005;
    public static final int CAPTURE_TYPE_TIME_SHIFT_RECORD = 1009;
    public static final int CAPTURE_TYPE_UNKNOWN = 0;
    public static final int CONNECT_TYPE_NONE = -1;
    public static final int CONNECT_TYPE_USB = 1;
    public static final int CONNECT_TYPE_WIFI = 2;
    public static final int EXPOSURE_MODE_AUTO = 0;
    public static final int EXPOSURE_MODE_ISO_FIRST = 1;
    public static final int EXPOSURE_MODE_MANUAL = 3;
    public static final int EXPOSURE_MODE_SHUTTER_FIRST = 2;
    public static final int FOV_TYPE_LINEAR = 1;
    public static final int FOV_TYPE_NARROW = 3;
    public static final int FOV_TYPE_ULTRA_WIDE = 2;
    public static final int FOV_TYPE_WIDE = 0;
    public static final int FUNCTION_MODE_BULLETTIME = 4;
    public static final int FUNCTION_MODE_BURST = 5;
    public static final int FUNCTION_MODE_CAPTURE_NORMAL = 6;
    public static final int FUNCTION_MODE_HDR_CAPTURE = 8;
    public static final int FUNCTION_MODE_HDR_RECORD = 9;
    public static final int FUNCTION_MODE_INTERVAL_SHOOTING = 3;
    public static final int FUNCTION_MODE_NIGHT_SCENE = 13;
    public static final int FUNCTION_MODE_RECORD_NORMAL = 7;
    public static final int FUNCTION_MODE_TIMELAPSE = 2;
    public static final int FUNCTION_MODE_TIME_SHIFT = 12;
    public static final int PREVIEW_TYPE_LIVE = 2;
    public static final int PREVIEW_TYPE_NORMAL = 0;
    public static final int PREVIEW_TYPE_RECORD = 1;
    public static final int SHUTTER_MODE_FASTER = 2;
    public static final int SHUTTER_MODE_OFF = 0;
    public static final int SHUTTER_MODE_SPORT = 1;
    public static final int WHITE_BALANCE_2700K = 1;
    public static final int WHITE_BALANCE_4000K = 2;
    public static final int WHITE_BALANCE_5000K = 3;
    public static final int WHITE_BALANCE_6500K = 4;
    public static final int WHITE_BALANCE_7500K = 5;
    public static final int WHITE_BALANCE_AUTO = 0;

    /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
    public static final CameraLogger f254 = CameraLogger.getLogger(InstaCameraManager.class);

    /* renamed from: 肌緭 reason: contains not printable characters */
    public List<ICameraChangedCallback> f255 = new ArrayList();

    /* renamed from: com.arashivision.sdkcamera.camera.InstaCameraManager$刻槒唱镧詴 reason: contains not printable characters */
    public class C0005 implements InfoUpdateListener {

        /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
        public final /* synthetic */ Handler f256;

        /* renamed from: 肌緭 reason: contains not printable characters */
        public final /* synthetic */ ILiveStatusListener f257;

        public C0005(InstaCameraManager instaCameraManager, ILiveStatusListener iLiveStatusListener, Handler handler) {
            this.f257 = iLiveStatusListener;
            this.f256 = handler;
        }

        public void onCameraInfoNotify(int i2, int i3, Object obj) {
            CameraLogger cameraLogger = InstaCameraManager.f254;
            StringBuilder a2 = a.a("onLiveCameraInfoNotify  i: ", i2, "  i1: ", i3, "  o: ");
            a2.append(obj);
            cameraLogger.i(a2.toString());
        }

        public void onLivePushStarted(String str) {
            CameraLogger cameraLogger = InstaCameraManager.f254;
            StringBuilder sb = new StringBuilder();
            sb.append("onLivePushStarted  ");
            sb.append(str);
            cameraLogger.i(sb.toString());
            ILiveStatusListener iLiveStatusListener = this.f257;
            if (iLiveStatusListener != null) {
                Handler handler = this.f256;
                iLiveStatusListener.getClass();
                handler.post(new c(iLiveStatusListener));
            }
        }

        public void onRecordFpsUpdate(int i2) {
            CameraLogger cameraLogger = InstaCameraManager.f254;
            StringBuilder sb = new StringBuilder();
            sb.append("onLiveRecordFpsUpdate  ");
            sb.append(i2);
            cameraLogger.i(sb.toString());
            ILiveStatusListener iLiveStatusListener = this.f257;
            if (iLiveStatusListener != null) {
                this.f256.post(new i(iLiveStatusListener, i2));
            }
        }
    }

    /* renamed from: com.arashivision.sdkcamera.camera.InstaCameraManager$灞酞輀攼嵞漁綬迹 reason: contains not printable characters */
    public static class C0006 {

        /* renamed from: 肌緭 reason: contains not printable characters */
        public static InstaCameraManager f258 = new InstaCameraManager();
    }

    /* renamed from: com.arashivision.sdkcamera.camera.InstaCameraManager$肌緭 reason: contains not printable characters */
    public class C0007 implements ICameraLiveStateListener {

        /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
        public final /* synthetic */ Handler f259;

        /* renamed from: 肌緭 reason: contains not printable characters */
        public final /* synthetic */ ILiveStatusListener f260;

        /* renamed from: 葋申湋骶映鍮秄憁鎓羭 reason: contains not printable characters */
        public final /* synthetic */ BaseCamera f261;

        public C0007(InstaCameraManager instaCameraManager, ILiveStatusListener iLiveStatusListener, Handler handler, BaseCamera baseCamera) {
            this.f260 = iLiveStatusListener;
            this.f259 = handler;
            this.f261 = baseCamera;
        }

        public void onRecordComplete(RecordingType recordingType, String str) {
            CameraLogger cameraLogger = InstaCameraManager.f254;
            StringBuilder sb = new StringBuilder();
            sb.append("onLiveRecordComplete  recordingType: ");
            sb.append(recordingType);
            sb.append("  s: ");
            sb.append(str);
            cameraLogger.i(sb.toString());
            ILiveStatusListener iLiveStatusListener = this.f260;
            if (iLiveStatusListener != null) {
                Handler handler = this.f259;
                iLiveStatusListener.getClass();
                handler.post(new e(iLiveStatusListener));
            }
        }

        public void onRecordError(int i2, RecordingType recordingType, String str) {
            CameraLogger cameraLogger = InstaCameraManager.f254;
            StringBuilder sb = new StringBuilder();
            sb.append("onLiveRecordError  i: ");
            sb.append(i2);
            sb.append("  recordingType: ");
            sb.append(recordingType);
            sb.append("  s: ");
            sb.append(str);
            cameraLogger.i(sb.toString());
            this.f261.resetRecord();
            ILiveStatusListener iLiveStatusListener = this.f260;
            if (iLiveStatusListener != null) {
                Handler handler = this.f259;
                iLiveStatusListener.getClass();
                handler.post(new e.b.d.a.a(iLiveStatusListener));
            }
        }
    }

    /* renamed from: com.arashivision.sdkcamera.camera.InstaCameraManager$葋申湋骶映鍮秄憁鎓羭 reason: contains not printable characters */
    public class C0008 implements ICaptureStatusChangedListener {

        /* renamed from: 肌緭 reason: contains not printable characters */
        public final /* synthetic */ ICaptureStatusListener f262;

        public C0008(InstaCameraManager instaCameraManager, ICaptureStatusListener iCaptureStatusListener) {
            this.f262 = iCaptureStatusListener;
        }

        public void onCaptureCountChanged(int i2) {
            this.f262.onCaptureCountChanged(i2);
        }

        public void onCaptureStatusChanged(CaptureType captureType, CaptureStatus captureStatus, String[] strArr, Integer num) {
            int i2 = C0009.f263[captureStatus.ordinal()];
            if (i2 == 1) {
                this.f262.onCaptureStarting();
            } else if (i2 == 2) {
                this.f262.onCaptureWorking();
            } else if (i2 == 3) {
                this.f262.onCaptureStopping();
            } else if (i2 == 4) {
                if (strArr != null) {
                    String cameraHttpPrefix = InstaCameraManager.getInstance().getCameraHttpPrefix();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArr.length) {
                            break;
                        } else if (TextUtils.isEmpty(strArr[i3])) {
                            strArr = null;
                            break;
                        } else {
                            StringBuilder a2 = a.a(cameraHttpPrefix);
                            a2.append(strArr[i3]);
                            strArr[i3] = a2.toString();
                            i3++;
                        }
                    }
                }
                this.f262.onCaptureFinish(strArr);
            }
        }

        public void onCaptureTimeChanged(long j2) {
            this.f262.onCaptureTimeChanged(j2);
        }
    }

    /* renamed from: com.arashivision.sdkcamera.camera.InstaCameraManager$鞈鵚主瀭孩濣痠閕讠陲檓敐 reason: contains not printable characters */
    public static /* synthetic */ class C0009 {

        /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
        public static final /* synthetic */ int[] f263;

        /* renamed from: 肌緭 reason: contains not printable characters */
        public static final /* synthetic */ int[] f264;

        /* renamed from: 葋申湋骶映鍮秄憁鎓羭 reason: contains not printable characters */
        public static final /* synthetic */ int[] f265;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0030 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0036 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004a */
        static {
            /*
                com.arashivision.insta360.basecamera.camera.BaseCamera$PreviewStatus[] r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f265 = r0
                r1 = 1
                com.arashivision.insta360.basecamera.camera.BaseCamera$PreviewStatus r2 = com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus.OPENING     // Catch:{ NoSuchFieldError -> 0x000e }
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r2 = f265     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.arashivision.insta360.basecamera.camera.BaseCamera$PreviewStatus r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus.OPENED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2[r0] = r0     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r2 = 0
                r3 = 3
                int[] r4 = f265     // Catch:{ NoSuchFieldError -> 0x001d }
                com.arashivision.insta360.basecamera.camera.BaseCamera$PreviewStatus r5 = com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus.IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                r4[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus[] r4 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f263 = r4
                com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus r5 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus.STARTING     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r1] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r4 = f263     // Catch:{ NoSuchFieldError -> 0x0030 }
                com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus r5 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus.WORKING     // Catch:{ NoSuchFieldError -> 0x0030 }
                r4[r0] = r0     // Catch:{ NoSuchFieldError -> 0x0030 }
            L_0x0030:
                int[] r4 = f263     // Catch:{ NoSuchFieldError -> 0x0036 }
                com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus r5 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus.STOPPING     // Catch:{ NoSuchFieldError -> 0x0036 }
                r4[r3] = r3     // Catch:{ NoSuchFieldError -> 0x0036 }
            L_0x0036:
                int[] r3 = f263     // Catch:{ NoSuchFieldError -> 0x003d }
                com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus r4 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus.IDLE     // Catch:{ NoSuchFieldError -> 0x003d }
                r4 = 4
                r3[r2] = r4     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.arashivision.insta360.basecamera.camera.BaseCamera$ConnectType[] r2 = com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f264 = r2
                com.arashivision.insta360.basecamera.camera.BaseCamera$ConnectType r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType.USB     // Catch:{ NoSuchFieldError -> 0x004a }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x004a }
            L_0x004a:
                int[] r2 = f264     // Catch:{ NoSuchFieldError -> 0x0050 }
                com.arashivision.insta360.basecamera.camera.BaseCamera$ConnectType r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType.WIFI     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.sdkcamera.camera.InstaCameraManager.C0009.<clinit>():void");
        }
    }

    public static InstaCameraManager getInstance() {
        return C0006.f258;
    }

    /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
    public static /* synthetic */ void m46(BaseCamera baseCamera, IPreviewStatusListener iPreviewStatusListener, int i2) {
        if (i2 == 0) {
            baseCamera.fetchOptions(null, new d(baseCamera, iPreviewStatusListener));
            return;
        }
        CameraLogger cameraLogger = f254;
        StringBuilder sb = new StringBuilder();
        sb.append("Preview Opened, fetchPhotoOptions  Error ");
        sb.append(i2);
        cameraLogger.i(sb.toString());
        iPreviewStatusListener.onError();
    }

    /* renamed from: 肌緭 reason: contains not printable characters */
    public static /* synthetic */ void m50(IPreviewStatusListener iPreviewStatusListener, BaseCamera baseCamera, PreviewStatus previewStatus, int i2) {
        if (i2 == 0) {
            int i3 = C0009.f265[previewStatus.ordinal()];
            if (i3 == 1) {
                f254.i("Preview Opening");
                iPreviewStatusListener.onOpening();
            } else if (i3 != 2) {
                if (i3 == 3) {
                    f254.i("Preview Idle");
                    iPreviewStatusListener.onIdle();
                }
            } else if (CameraType.NANOS.type.equals(baseCamera.getCameraType()) || TextUtils.isEmpty(baseCamera.getCameraType())) {
                f254.i("Preview Opened, NanoS");
                iPreviewStatusListener.onOpened();
            } else {
                f254.i("Preview Opened, Waiting for fetchPhotoOptions");
                baseCamera.fetchPhotoOptions(1, new b(baseCamera, iPreviewStatusListener));
            }
        } else {
            CameraLogger cameraLogger = f254;
            StringBuilder sb = new StringBuilder();
            sb.append("Preview Error ");
            sb.append(i2);
            cameraLogger.i(sb.toString());
            iPreviewStatusListener.onError();
        }
    }

    public void beginSettingOptions() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.beginOptionsTransaction();
        }
    }

    public void calibrateGyro(ICameraOperateCallback iCameraOperateCallback) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            if (primaryActiveCamera.getConnectType() == ConnectType.WIFI) {
                primaryActiveCamera.calibrateGyro(new g(iCameraOperateCallback));
            } else if (iCameraOperateCallback != null) {
                iCameraOperateCallback.onCameraConnectError();
            }
        } else if (iCameraOperateCallback != null) {
            iCameraOperateCallback.onCameraConnectError();
        }
    }

    public void closeCamera() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            CameraManager.getInstance().destroyCamera(primaryActiveCamera);
        }
    }

    public void closePreviewStream() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            f254.i("ClosePreviewStream");
            primaryActiveCamera.setPipeline(null);
            primaryActiveCamera.closePreviewStream();
        }
    }

    public void commitSettingOptions() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.commitOptionsTransaction();
        }
    }

    public void formatStorage(ICameraOperateCallback iCameraOperateCallback) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.formatStorage(new h(iCameraOperateCallback));
        } else if (iCameraOperateCallback != null) {
            iCameraOperateCallback.onCameraConnectError();
        }
    }

    public int getAEBCaptureNum() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getAEBCaptureNum(8);
        }
        return -1;
    }

    public List<String> getAllUrlList() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || !primaryActiveCamera.isReady() || primaryActiveCamera.getStorageCardState() == 1) {
            return new ArrayList();
        }
        return CameraMediaUtils.getInstaFileList(primaryActiveCamera, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 2) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCameraConnectedType() {
        /*
            r2 = this;
            com.arashivision.insta360.basecamera.camera.CameraManager r0 = com.arashivision.insta360.basecamera.camera.CameraManager.getInstance()
            r1 = 0
            com.arashivision.insta360.basecamera.camera.BaseCamera r0 = r0.getPrimaryActiveCamera(r1)
            if (r0 == 0) goto L_0x001f
            int[] r1 = com.arashivision.sdkcamera.camera.InstaCameraManager.C0009.f264
            com.arashivision.insta360.basecamera.camera.BaseCamera$ConnectType r0 = r0.getConnectType()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x001e
            r1 = 2
            if (r0 == r1) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            return r1
        L_0x001f:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.sdkcamera.camera.InstaCameraManager.getCameraConnectedType():int");
    }

    public int getCameraCurrentBatteryLevel() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getBatteryLevel();
        }
        return 0;
    }

    public String getCameraHttpPrefix() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(primaryActiveCamera.getCameraHost());
        sb.append(primaryActiveCamera.getPort());
        return sb.toString();
    }

    public HashMap<String, byte[]> getCameraInfoMap() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || !primaryActiveCamera.isReady() || primaryActiveCamera.getStorageCardState() == 1) {
            return new HashMap<>();
        }
        return CameraMediaUtils.getFileInfoMap(primaryActiveCamera);
    }

    public String getCameraSerial() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        return primaryActiveCamera != null ? primaryActiveCamera.getSerial() : "";
    }

    public long getCameraStorageFreeSpace() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getStorageFreeSpace();
        }
        return 0;
    }

    public long getCameraStorageTotalSpace() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getStorageTotalSpace();
        }
        return 0;
    }

    public String getCameraType() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        return primaryActiveCamera != null ? primaryActiveCamera.getCameraType() : "";
    }

    public String getCameraVersion() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        return primaryActiveCamera != null ? primaryActiveCamera.getFWVersion() : "";
    }

    public int getCurrentCaptureType() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || !primaryActiveCamera.isCameraWorking()) {
            return -1;
        }
        if (primaryActiveCamera.isNormalCapturing()) {
            return 1000;
        }
        if (primaryActiveCamera.isHDRCapturing()) {
            return 1001;
        }
        if (primaryActiveCamera.isNightSceneCapturing()) {
            return 1006;
        }
        if (primaryActiveCamera.isIntervalShooting()) {
            return 1002;
        }
        if (primaryActiveCamera.isBurstCapturing()) {
            return CAPTURE_TYPE_BURST_CAPTURE;
        }
        if (primaryActiveCamera.isNormalRecording()) {
            return 1003;
        }
        if (primaryActiveCamera.isHDRRecording()) {
            return 1004;
        }
        if (primaryActiveCamera.isBulletTimeRecording()) {
            return CAPTURE_TYPE_BULLET_TIME_RECORD;
        }
        if (primaryActiveCamera.isTimeShiftRecording()) {
            return CAPTURE_TYPE_TIME_SHIFT_RECORD;
        }
        if (primaryActiveCamera.isIntervalRecording()) {
            return 1010;
        }
        if (primaryActiveCamera.isTimelapseRecording()) {
            return 1005;
        }
        if (primaryActiveCamera.isStaticTimelapseRecording()) {
            return 1011;
        }
        return 0;
    }

    public float getExposureEV(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return ((float) primaryActiveCamera.getExposureEV(i2)) / 10.0f;
        }
        return -1.0f;
    }

    public int getExposureMode(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getExposureMode(i2, m51(i2));
        }
        return -1;
    }

    public int getISO(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getISO(i2, m51(i2));
        }
        return -1;
    }

    public int getISOTopLimit(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getISOTopLimit(i2);
        }
        return -1;
    }

    public boolean getIsLogInCamera(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getIsLog(i2);
        }
        return false;
    }

    public boolean getIsRawInCamera(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getIsRaw(i2);
        }
        return false;
    }

    public String getMediaOffset() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        return primaryActiveCamera != null ? primaryActiveCamera.getMediaOffset() : "";
    }

    public List<String> getRawUrlList() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || !primaryActiveCamera.isReady() || primaryActiveCamera.getStorageCardState() == 1) {
            return new ArrayList();
        }
        return CameraMediaUtils.getInstaFileList(primaryActiveCamera, true);
    }

    public int getShutterMode(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getSportModeLevel(i2);
        }
        return -1;
    }

    public double getShutterSpeed(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getShutter(i2, m51(i2));
        }
        return -1.0d;
    }

    public List<PreviewStreamResolution> getSupportedPreviewStreamResolution(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return n.a(primaryActiveCamera).a(i2);
        }
        return new ArrayList();
    }

    public int getWhiteBalance(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return primaryActiveCamera.getWhiteBalance(i2);
        }
        return -1;
    }

    public boolean isCameraBeep() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            return !primaryActiveCamera.isMute();
        }
        return false;
    }

    public boolean isCameraCharging() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || !primaryActiveCamera.isCharging()) {
            return false;
        }
        return true;
    }

    public boolean isCameraSelfie() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || !primaryActiveCamera.isSelfie()) {
            return false;
        }
        return true;
    }

    public boolean isSdCardEnabled() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null || primaryActiveCamera.getStorageCardState() != 0) {
            return false;
        }
        return true;
    }

    public void openCamera(int i2) {
        if (i2 == 1) {
            CameraManager.getInstance().tryOpenCamera(ConnectType.USB);
        } else if (i2 == 2) {
            CameraManager.getInstance().tryOpenCamera(ConnectType.WIFI);
        }
    }

    public void registerCameraChangedCallback(ICameraChangedCallback iCameraChangedCallback) {
        synchronized (this) {
            if (!this.f255.contains(iCameraChangedCallback)) {
                this.f255.add(iCameraChangedCallback);
            }
        }
    }

    public void setAEBCaptureNum(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setAEBCaptureNum(8, i2);
        }
    }

    public void setCameraBeepSwitch(boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setMute(!z);
        }
    }

    public void setCaptureStatusListener(ICaptureStatusListener iCaptureStatusListener) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null) {
            return;
        }
        if (iCaptureStatusListener == null) {
            primaryActiveCamera.setCaptureStatusChangedListener(null);
        } else {
            primaryActiveCamera.setCaptureStatusChangedListener(new C0008(this, iCaptureStatusListener));
        }
    }

    public void setExposureEV(int i2, float f2) {
        if (f2 >= -4.0f && f2 <= 4.0f) {
            int i3 = (int) (f2 * 10.0f);
            BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
            if (primaryActiveCamera != null) {
                primaryActiveCamera.setExposureEV(1, i3);
                primaryActiveCamera.setExposureEV(i2, i3);
            }
        }
    }

    public void setExposureMode(int i2, int i3) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            boolean r1 = m51(i2);
            BaseCamera baseCamera = primaryActiveCamera;
            int i4 = i3;
            int iso = primaryActiveCamera.getISO(i2, r1);
            double shutter = primaryActiveCamera.getShutter(i2, r1);
            boolean z = r1;
            baseCamera.setExposureOptions(1, i4, iso, shutter, z);
            baseCamera.setExposureOptions(i2, i4, iso, shutter, z);
        }
    }

    public void setFovTypeToCamera(int i2, int i3) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setFovType(1, i3);
            primaryActiveCamera.setFovType(i2, i3);
        }
    }

    public void setFunctionModeToCamera(int i2) {
        boolean z = false;
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            if (i2 == 6 || i2 == 8 || i2 == 13 || i2 == 5 || i2 == 3) {
                z = true;
            }
            if (z) {
                primaryActiveCamera.setSubPhotoMode(i2);
            } else {
                primaryActiveCamera.setSubVideoMode(i2);
            }
        }
    }

    public void setHDRExposureEVStep(float f2) {
        if (f2 > 0.0f && f2 <= 4.0f) {
            int i2 = (int) (f2 * 10.0f);
            BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
            if (primaryActiveCamera != null) {
                primaryActiveCamera.setExposureEV(8, i2);
            }
        }
    }

    public void setISO(int i2, int i3) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            boolean r1 = m51(i2);
            BaseCamera baseCamera = primaryActiveCamera;
            int exposureMode = primaryActiveCamera.getExposureMode(i2, r1);
            int i4 = i3;
            double shutter = primaryActiveCamera.getShutter(i2, r1);
            boolean z = r1;
            baseCamera.setExposureOptions(1, exposureMode, i4, shutter, z);
            baseCamera.setExposureOptions(i2, exposureMode, i4, shutter, z);
        }
    }

    public void setISOTopLimit(int i2, int i3) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setISOTopLimit(1, i3);
            primaryActiveCamera.setISOTopLimit(i2, i3);
        }
    }

    public void setIntervalRecordTime(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setTimelapseParams(4, new TimelapseParams(Integer.MAX_VALUE, i2, 0));
        }
    }

    public void setIntervalShootingTime(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setTimelapseParams(2, new TimelapseParams(Integer.MAX_VALUE, i2, 0));
        }
    }

    public void setLogToCamera(int i2, boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setLog(1, z);
            primaryActiveCamera.setLog(i2, z);
        }
    }

    public void setNetIdToCamera(long j2) {
        Network.setNetIdForNativeLibs(j2);
    }

    public void setPhotoSizeToCamera(int i2, int i3, int i4) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null) {
            return;
        }
        if (i3 == 4 && i4 == 3) {
            primaryActiveCamera.setPhotoSize(1, 0);
            primaryActiveCamera.setPhotoSize(i2, 0);
        } else if (i3 == 3 && i4 == 2) {
            primaryActiveCamera.setPhotoSize(1, 0);
            primaryActiveCamera.setPhotoSize(i2, 0);
        } else if (i3 == 16 && i4 == 9) {
            primaryActiveCamera.setPhotoSize(1, 1);
            primaryActiveCamera.setPhotoSize(i2, 1);
        }
    }

    public void setPipeline(Object obj) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null && (obj instanceof ICameraPreviewPipeline)) {
            f254.i("Preview setPipeline");
            primaryActiveCamera.setPipeline((ICameraPreviewPipeline) obj);
        }
    }

    public void setPreviewStatusChangedListener(IPreviewStatusListener iPreviewStatusListener) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera == null) {
            return;
        }
        if (iPreviewStatusListener == null) {
            primaryActiveCamera.setPreviewStatusChangedListener(null);
        } else {
            primaryActiveCamera.setPreviewStatusChangedListener(new f(iPreviewStatusListener, primaryActiveCamera));
        }
    }

    public void setRawToCamera(int i2, boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setRaw(1, z);
            primaryActiveCamera.setRaw(i2, z);
        }
    }

    public void setResolutionToCamera(int i2, PreviewStreamResolution previewStreamResolution) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            StreamResolution fromResolution = StreamResolution.getFromResolution(previewStreamResolution.width, previewStreamResolution.height, previewStreamResolution.fps);
            if (fromResolution != null) {
                primaryActiveCamera.setVideoResolutionId(1, fromResolution.valueInCamera);
                primaryActiveCamera.setVideoResolutionId(i2, fromResolution.valueInCamera);
            }
        }
    }

    public void setShutterMode(int i2, int i3) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setSportModeLevel(1, i3);
            primaryActiveCamera.setSportModeLevel(i2, i3);
        }
    }

    public void setShutterSpeed(int i2, double d2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            boolean r1 = m51(i2);
            BaseCamera baseCamera = primaryActiveCamera;
            int exposureMode = primaryActiveCamera.getExposureMode(i2, r1);
            int iso = primaryActiveCamera.getISO(i2, r1);
            double d3 = d2;
            boolean z = r1;
            baseCamera.setExposureOptions(1, exposureMode, iso, d3, z);
            baseCamera.setExposureOptions(i2, exposureMode, iso, d3, z);
        }
    }

    public void setStaticTimeLapseInterval(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setTimelapseParams(3, new TimelapseParams(Integer.MAX_VALUE, i2, 0));
        }
    }

    public void setStreamEncode() {
        boolean z = false;
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            CameraLogger cameraLogger = f254;
            StringBuilder a2 = a.a("Preview setStreamEncode ");
            a2.append(primaryActiveCamera.getVideoEncodeType());
            cameraLogger.i(a2.toString());
            if (primaryActiveCamera.getVideoEncodeType() == 1) {
                z = true;
            }
            primaryActiveCamera.setStreamEncode(z);
        }
    }

    public void setTimeLapseInterval(int i2) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setTimelapseParams(1, new TimelapseParams(Integer.MAX_VALUE, i2, 0));
        }
    }

    public void setWhiteBalance(int i2, int i3) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.setWhiteBalance(1, i3);
            primaryActiveCamera.setWhiteBalance(i2, i3);
        }
    }

    public void startBulletTime() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startBulletTime();
        }
    }

    public void startBurstCapture(boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startBurstCapture(z, new byte[0]);
        }
    }

    public void startHDRCapture(boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            int exposureEV = (int) (getExposureEV(8) * 10.0f);
            int max = Math.max(getAEBCaptureNum(), 3);
            int max2 = Math.max(Math.abs(exposureEV), 3);
            int[] iArr = new int[max];
            iArr[0] = 0;
            int i2 = 1;
            while (true) {
                int i3 = (max - 1) / 2;
                if (i2 <= i3) {
                    int i4 = (i3 - i2) + 1;
                    iArr[i2] = (-max2) * i4;
                    iArr[max - i2] = i4 * max2;
                    i2++;
                } else {
                    primaryActiveCamera.startHDRCapture(iArr, z, new byte[0]);
                    return;
                }
            }
        }
    }

    public void startHDRRecord() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startHDRRecord();
        }
    }

    public void startIntervalRecord() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startIntervalRecord(new byte[0]);
        }
    }

    public void startIntervalShooting() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startIntervalShooting(new byte[0]);
        }
    }

    public void startLive(LiveParamsBuilder liveParamsBuilder, ILiveStatusListener iLiveStatusListener) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            primaryActiveCamera.setLiveListener(new C0007(this, iLiveStatusListener, handler, primaryActiveCamera), new C0005(this, iLiveStatusListener, handler));
            CameraLogger cameraLogger = f254;
            StringBuilder a2 = a.a("StartLive. Camera: ");
            a2.append(primaryActiveCamera.getCameraType());
            a2.append(", ");
            a2.append(liveParamsBuilder.toString());
            cameraLogger.i(a2.toString());
            primaryActiveCamera.startLive(liveParamsBuilder.getWidth(), liveParamsBuilder.getHeight(), liveParamsBuilder.getFps(), liveParamsBuilder.getBitrate(), liveParamsBuilder.getRtmp(), n.a(primaryActiveCamera).a(liveParamsBuilder.isPanorama()), liveParamsBuilder.getNetId());
        }
    }

    public void startNightScene(boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startNightScene(z, new byte[0]);
        }
    }

    public void startNormalCapture(boolean z) {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startNormalCapture(z, new byte[0]);
        }
    }

    public void startNormalRecord() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startNormalRecord();
        }
    }

    @Deprecated
    public void startPreviewStream() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            startPreviewStream(n.a(primaryActiveCamera).b());
        }
    }

    public void startStaticTimeLapse() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startStaticTimelapse();
        }
    }

    public void startTimeLapse() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startTimelapse();
        }
    }

    public void startTimeShift() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.startTimeShift();
        }
    }

    public void stopBulletTime() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopBulletTime(new byte[0]);
        }
    }

    public void stopHDRRecord() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopHDRRecord(new byte[0]);
        }
    }

    public void stopIntervalRecord() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopIntervalRecord();
        }
    }

    public void stopIntervalShooting() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopIntervalShooting();
        }
    }

    public void stopLive() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            f254.i("StopLive");
            primaryActiveCamera.stopLive();
            primaryActiveCamera.setLiveListener(null, null);
        }
    }

    public void stopNormalRecord() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopNormalRecord(new byte[0]);
        }
    }

    public void stopStaticTimeLapse() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopStaticTimelapse(new byte[0]);
        }
    }

    public void stopTimeLapse() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopTimelapse(new byte[0]);
        }
    }

    public void stopTimeShift() {
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            primaryActiveCamera.stopTimeShift(new byte[0]);
        }
    }

    public void unregisterCameraChangedCallback(ICameraChangedCallback iCameraChangedCallback) {
        synchronized (this) {
            this.f255.remove(iCameraChangedCallback);
        }
    }

    /* renamed from: 肌緭 reason: contains not printable characters */
    public final boolean m51(int i2) {
        return i2 == 7 || i2 == 9 || i2 == 4 || i2 == 2 || i2 == 12;
    }

    public void startPreviewStream(PreviewStreamResolution previewStreamResolution) {
        startPreviewStream(previewStreamResolution, 0);
    }

    /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
    public static /* synthetic */ void m47(ICameraOperateCallback iCameraOperateCallback, int i2) {
        if (i2 == 0) {
            iCameraOperateCallback.onSuccessful();
        } else {
            iCameraOperateCallback.onFailed();
        }
    }

    public void startPreviewStream(PreviewStreamResolution previewStreamResolution, int i2) {
        boolean z = false;
        BaseCamera primaryActiveCamera = CameraManager.getInstance().getPrimaryActiveCamera(false);
        if (primaryActiveCamera != null) {
            boolean z2 = i2 == 2;
            boolean z3 = i2 == 1;
            if (primaryActiveCamera.isNormalRecording() || primaryActiveCamera.isTimeShiftRecording() || primaryActiveCamera.isIntervalRecording() || primaryActiveCamera.isBulletTimeRecording() || primaryActiveCamera.isHDRRecording() || primaryActiveCamera.isTimelapseRecording() || primaryActiveCamera.isStaticTimelapseRecording()) {
                z = true;
            }
            boolean z4 = z3 | z;
            PreviewStreamResolution a2 = n.a(primaryActiveCamera).a();
            CameraLogger cameraLogger = f254;
            StringBuilder a3 = a.a("StartPreviewStream. Camera: ");
            a3.append(primaryActiveCamera.getCameraType());
            a3.append(", FirstRes: ");
            a3.append(previewStreamResolution);
            a3.append(", SecondRes: ");
            a3.append(a2);
            a3.append(", isLive: ");
            a3.append(z2);
            a3.append(", isForRecord: ");
            a3.append(z4);
            cameraLogger.i(a3.toString());
            primaryActiveCamera.openPreviewStream(StreamResolution.getFromResolution(previewStreamResolution.width, previewStreamResolution.height, previewStreamResolution.fps), StreamResolution.getFromResolution(a2.width, a2.height, a2.fps), z2 ? 1 : 0, z2 ? RenderMode.withGlRenderer(RenderMethod.PlanarKeep) : RenderMode.directDecoding(), z2, z4 ? 1 : 0, false, primaryActiveCamera.getMediaOffset());
        }
    }

    /* renamed from: 肌緭 reason: contains not printable characters */
    public static /* synthetic */ void m48(BaseCamera baseCamera, IPreviewStatusListener iPreviewStatusListener, int i2) {
        if (i2 != 0) {
            CameraLogger cameraLogger = f254;
            StringBuilder sb = new StringBuilder();
            sb.append("Preview Opened, fetchPhotoOptions  Error1 ");
            sb.append(i2);
            cameraLogger.i(sb.toString());
            iPreviewStatusListener.onError();
        } else if (baseCamera.getPreviewStatus() == PreviewStatus.OPENED) {
            f254.i("Preview Opened, fetchPhotoOptions Success");
            iPreviewStatusListener.onOpened();
        } else {
            f254.i("Preview Opened, But idle after fetchPhotoOptions");
            iPreviewStatusListener.onIdle();
        }
    }

    /* renamed from: 肌緭 reason: contains not printable characters */
    public static /* synthetic */ void m49(ICameraOperateCallback iCameraOperateCallback, int i2) {
        if (i2 == 0) {
            if (iCameraOperateCallback != null) {
                iCameraOperateCallback.onSuccessful();
            }
        } else if (iCameraOperateCallback != null) {
            iCameraOperateCallback.onFailed();
        }
    }
}
