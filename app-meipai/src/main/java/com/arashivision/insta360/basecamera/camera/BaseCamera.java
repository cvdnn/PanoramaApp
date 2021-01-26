package com.arashivision.insta360.basecamera.camera;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import c.a.a.a.a.e;
import c.a.a.a.a.i.m;
import c.a.a.a.a.i.n;
import c.a.a.a.a.i.o;
import c.a.a.a.a.i.p;
import c.a.a.a.a.i.q;
import com.arashivision.camera.InstaCamera;
import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.camera.listener.ICameraConnectionListener;
import com.arashivision.camera.listener.ICameraLiveStateListener;
import com.arashivision.insta360.basecamera.CameraModule;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0147OooO0oO;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0148OooO0oo;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0149OooOO0o;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0150OooOOOo;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0152OooOOo0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0155OooOo0O;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0156OooOo0o;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0158OooOoO0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0159OooOoOO;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.ICaptureStatusChangedListener;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.OooOO0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.OooOO0O;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.OooOOO0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.OooOOOO;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.OooOo;
import com.arashivision.insta360.basecamera.camera.setting.StreamResolution;
import com.arashivision.insta360.basecamera.camera.setting.TimelapseParams;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.insta360.basecamera.util.CameraConstants.ErrorCode;
import com.arashivision.onecamera.AudioSource;
import com.arashivision.onecamera.InfoUpdateListener;
import com.arashivision.onecamera.OneCameraImplement;
import com.arashivision.onecamera.OneDriverInfo.Options;
import com.arashivision.onecamera.OneDriverInfo.RecordFormat;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.RecordType;
import com.arashivision.onecamera.StartCaptureWithoutStorage;
import com.arashivision.onecamera.StartStreamingParam;
import com.arashivision.onecamera.cameranotification.BTPeripheral;
import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.ConnectToBTPeripheral;
import com.arashivision.onecamera.camerarequest.DisconnectBTPeripheral;
import com.arashivision.onecamera.camerarequest.KeyTimePoint;
import com.arashivision.onecamera.camerarequest.ScanBTPeripheral;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onecamera.camerarequest.WifiInfo;
import com.arashivision.onecamera.cameraresponse.GetOptionsResp;
import com.arashivision.onecamera.render.RenderMethod;
import com.arashivision.onecamera.render.RenderMode;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.baidu.mobstat.Config;
import e.a.a.a.a;
import e.b.c.a.a.c;
import e.b.c.a.a.d;
import e.e.a.e.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BaseCamera {
    public static final String CAMERA_SERVICE_WIFI_AP_IP = "192.168.42.1";
    public static final CameraLogger OooOO0o = CameraLogger.getLogger(BaseCamera.class);
    public Handler OooO = new Handler(Looper.getMainLooper());
    public OooO0OO OooO00o;
    public BaseCameraController OooO0O0;
    public InstaCamera OooO0OO;
    public ConnectType OooO0Oo;
    public b OooO0o;
    public CameraStatus OooO0o0;
    public Boolean OooO0oO;
    public Long OooO0oo;
    public C0142OooO0Oo OooOO0;
    public Runnable OooOO0O = new d(this);

    public enum CameraStatus {
        IDLE,
        OPENING,
        CHECK_TYPE,
        SYNCING,
        FAKE_READY,
        READY,
        ERROR,
        CLOSING
    }

    public enum CaptureStatus {
        IDLE,
        STARTING,
        WORKING,
        STOPPING
    }

    public enum CaptureType {
        IDLE,
        NORMAL_CAPTURE,
        HDR_CAPTURE,
        NIGHT_SCENE,
        INTERVAL_SHOOTING,
        BURST,
        NORMAL_RECORD,
        HDR_RECORD,
        INTERVAL_RECORD,
        BULLET_TIME,
        TIMELAPSE,
        STATIC_TIMELAPSE,
        TIME_SHIFT,
        LIVE
    }

    public enum ConnectType {
        BLE,
        WIFI,
        USB
    }

    public class OooO00o implements ICameraConnectionListener {
        public OooO00o() {
        }

        public void onCameraConnect() {
            BaseCamera.OooOO0o.d("onCameraConnect");
            BaseCamera baseCamera = BaseCamera.this;
            if (baseCamera.OooO0o0 != CameraStatus.OPENING) {
                CameraLogger cameraLogger = BaseCamera.OooOO0o;
                StringBuilder a2 = a.a("onConnectComplete, but status is not match, status: ");
                a2.append(baseCamera.OooO0o0);
                cameraLogger.w(a2.toString());
                return;
            }
            baseCamera.OooO.removeCallbacks(baseCamera.OooOO0O);
            baseCamera.OooO.postDelayed(baseCamera.OooOO0O, FragmentStateAdapter.GRACE_WINDOW_TIME_MS);
            baseCamera.OooO0oo = Long.valueOf(baseCamera.OooO0OO.getOptionsSync(Arrays.asList(new String[]{"camera_type"})));
            baseCamera.OooO00o(CameraStatus.CHECK_TYPE, 0);
        }

        public void onCameraError(int i2) {
            a.a("onCameraError, error: ", i2, BaseCamera.OooOO0o);
            BaseCamera.this.OooO00o(CameraStatus.ERROR, i2);
            BaseCamera.this.OooO00o(true);
        }

        public void onCameraStateChange() {
            BaseCamera.OooOO0o.d("onCameraStateChange");
        }
    }

    public enum OooO0O0 {
        IDLE,
        GET_SN,
        AUTHORIZATION,
        SYNCING_OPTIONS,
        CHECKING,
        FAKE_READY,
        READY,
        CLOSING,
        ERROR
    }

    public interface OooO0OO {
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCamera$OooO0Oo reason: case insensitive filesystem */
    public interface C0142OooO0Oo {
        void OooO00o(CameraStatus cameraStatus, int i2);
    }

    public enum OooO0o {
        IDLE,
        STARTING,
        SCANNING
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCamera$OooO0o0 reason: case insensitive filesystem */
    public interface C0143OooO0o0 {
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCamera$OooO0oO reason: case insensitive filesystem */
    public enum C0144OooO0oO {
        IDLE,
        STARTING,
        WORKING
    }

    public enum PreviewStatus {
        IDLE,
        OPENING,
        OPENED
    }

    public BaseCamera(ConnectType connectType, OooO0OO oooO0OO) {
        this.OooO00o = oooO0OO;
        this.OooO0Oo = connectType;
        InstaCamera instance = InstaCamera.getInstance();
        this.OooO0OO = instance;
        instance.init(CameraModule.getApplication());
        OooO00o();
        OooO0o oooO0o = OooO0o.IDLE;
        C0144OooO0oO oooO0oO = C0144OooO0oO.IDLE;
        this.OooO0o0 = CameraStatus.IDLE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, int i3, Object obj) {
        if (this.OooO0o0 == CameraStatus.CHECK_TYPE) {
            CameraLogger cameraLogger = OooOO0o;
            StringBuilder a2 = a.a("onCameraInfo, type: ", i2, ", err: ", i3, ", obj: ");
            a2.append(obj);
            cameraLogger.d(a2.toString());
            if (i2 == 54) {
                GetOptionsResp getOptionsResp = (GetOptionsResp) obj;
                Long l = this.OooO0oo;
                if (l != null && l.longValue() == getOptionsResp.requestID) {
                    OooO00o(getOptionsResp.result.getCameraType());
                    return;
                }
                return;
            }
            return;
        }
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, i3, obj);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0() {
        if (!isReady()) {
            OooO00o(CameraStatus.ERROR, (int) ErrorCode.CAMERA_OPEN_TIME_OUT);
            OooO00o(false);
        }
    }

    public final void OooO00o() {
        this.OooO0OO.addConnectionListener(new OooO00o());
        this.OooO0OO.addCameraInfoListener(new e.b.c.a.a.b(this));
    }

    public final void OooO00o(CameraStatus cameraStatus, int i2) {
        CameraLogger cameraLogger = OooOO0o;
        StringBuilder sb = new StringBuilder();
        sb.append("changeCameraStatus, newStatus: [");
        sb.append(cameraStatus);
        sb.append("], oldStatus: [");
        sb.append(this.OooO0o0);
        sb.append("], connectType: [");
        sb.append(this.OooO0Oo);
        sb.append("]");
        cameraLogger.d(sb.toString());
        CameraStatus cameraStatus2 = this.OooO0o0;
        this.OooO0o0 = cameraStatus;
        C0142OooO0Oo oooO0Oo = this.OooOO0;
        if (oooO0Oo != null) {
            oooO0Oo.OooO00o(cameraStatus2, i2);
        }
    }

    public final void OooO00o(boolean z) {
        OooOO0o.d("destroy");
        CameraStatus cameraStatus = this.OooO0o0;
        if (cameraStatus != CameraStatus.IDLE) {
            CameraStatus cameraStatus2 = CameraStatus.CLOSING;
            if (cameraStatus != cameraStatus2) {
                OooO00o(cameraStatus2, 0);
                this.OooO.removeCallbacks(this.OooOO0O);
                BaseCameraController baseCameraController = this.OooO0O0;
                if (baseCameraController != null) {
                    baseCameraController.OooO0Oo();
                }
                if (!z && this.OooO0Oo == ConnectType.BLE) {
                    this.OooO0OO.disConnectBle();
                }
                this.OooO0OO.close();
                this.OooO0o = null;
                this.OooO0oO = null;
                OooO00o(CameraStatus.IDLE, 0);
            }
        }
    }

    public void beginOptionsTransaction() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            baseCameraController.Oooo0O0 = true;
            baseCameraController.Oooo0OO = null;
            baseCameraController.Oooo0o0.clear();
            baseCameraController.Oooo0o.clear();
        }
    }

    public void calibrateGyro(C0148OooO0oo oooO0oo) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            CalibrateGyro calibrateGyro = new CalibrateGyro();
            calibrateGyro.gyro_count = 100;
            baseCameraController.OooOO0.put(Long.valueOf(baseCameraController.OooO0O0.calibrateGyro(calibrateGyro)), oooO0oo);
        }
    }

    public void closeCameraWifi(OooOO0 oooOO0) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooO0OO != OooO0O0.IDLE) {
            baseCameraController.OooOO0.put(Long.valueOf(baseCameraController.OooO0O0.closeCameraWifi()), oooOO0);
        }
    }

    public void closePreviewStream() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0O0();
        }
    }

    public void commitOptionsTransaction() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0OO();
        }
    }

    public void connectBleRemoteControl(BTPeripheral bTPeripheral) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            ConnectToBTPeripheral connectToBTPeripheral = new ConnectToBTPeripheral();
            connectToBTPeripheral.peripheral = bTPeripheral;
            baseCameraController.OooO0O0.connectBT(connectToBTPeripheral);
            baseCameraController.OooOOO.postDelayed(baseCameraController.OoooOOO, 19000);
        }
    }

    public void deleteFileList(List<String> list, OooOO0O oooOO0O) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(oooOO0O, list);
        } else {
            oooOO0O.OooO0oO(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
        }
    }

    public void disconnectBle(BTPeripheral bTPeripheral) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            DisconnectBTPeripheral disconnectBTPeripheral = new DisconnectBTPeripheral();
            disconnectBTPeripheral.peripheral = bTPeripheral;
            baseCameraController.OooO0O0.disConnectBT(disconnectBTPeripheral);
        }
    }

    public void fetchAllOptions(C0149OooOO0o oooOO0o) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(oooOO0o);
        }
    }

    public void fetchOptions(List<String> list, C0149OooOO0o oooOO0o) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(list, oooOO0o);
        }
    }

    public void fetchPhotoOptions(int i2, C0149OooOO0o oooOO0o) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, oooOO0o);
        }
    }

    public void formatStorage(OooOOO0 oooOOO0) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            baseCameraController.OooOO0.put(Long.valueOf(baseCameraController.OooO0O0.ersaSDcard()), oooOOO0);
        }
    }

    public int getAEBCaptureNum(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO00o(i2);
        }
        return -1;
    }

    public long getActiveTime() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Long) baseCameraController.OooO00o(Options.ACTIVATE_TIME, Long.valueOf(-1))).longValue();
    }

    public int getAudioCodec() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOoO0;
        }
        return -1;
    }

    public int getBatteryLevel() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BATTERY_LEVEL, Integer.valueOf(0))).intValue();
    }

    public int getBleRemoteType() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BT_REMOTE_TYPE, Integer.valueOf(-1))).intValue();
    }

    public String getBleRemoteVersion() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return (String) baseCameraController.OooO00o(Options.BT_REMOTE_VERSION, null);
        }
        return null;
    }

    public int getBtnClickMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BUTTON_PRESS_CLICK, Integer.valueOf(-1))).intValue();
    }

    public int getBtnDoubleClickMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BUTTON_PRESS_DOUBLE_CLICK, Integer.valueOf(-1))).intValue();
    }

    public int getBtnShutdownClickMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BUTTON_PRESS_SHUTDOWN_CLICK, Integer.valueOf(-1))).intValue();
    }

    public int getBtnTripleClickMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BUTTON_PRESS_TRIPLE_CLICK, Integer.valueOf(-1))).intValue();
    }

    public String getCameraHost() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return "";
        }
        return baseCameraController.OooO0Oo.ordinal() != 1 ? "http://127.0.0.1:" : "http://192.168.42.1:";
    }

    public CameraStatus getCameraStatus() {
        return this.OooO0o0;
    }

    public String getCameraType() {
        BaseCameraController baseCameraController = this.OooO0O0;
        String str = "";
        return baseCameraController != null ? (String) baseCameraController.OooO00o("camera_type", str) : str;
    }

    public int getCaptureCount() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.Oooo00O;
        }
        return -1;
    }

    public CaptureStatus getCaptureStatus() {
        BaseCameraController baseCameraController = this.OooO0O0;
        return baseCameraController != null ? baseCameraController.getCaptureStatus() : CaptureStatus.IDLE;
    }

    public long getCaptureTime() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.Oooo00o;
        }
        return -1;
    }

    public CaptureType getCaptureType() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOoo0;
        }
        return CaptureType.IDLE;
    }

    public b getConnectDevice() {
        return this.OooO0o;
    }

    public ConnectType getConnectType() {
        return this.OooO0Oo;
    }

    public StreamResolution getCurFirstStreamResolution() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOo0o;
        }
        return null;
    }

    public StreamResolution getCurSecondStreamResolution() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.getCurSecondStreamResolution();
        }
        return null;
    }

    public int getExposureEV(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0O0(i2);
        }
        return -1;
    }

    public int getExposureMode(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO00o(i2, z);
        }
        return -1;
    }

    public String getFWVersion() {
        BaseCameraController baseCameraController = this.OooO0O0;
        String str = "";
        return baseCameraController != null ? (String) baseCameraController.OooO00o(Options.FIRMWAREREVISION, str) : str;
    }

    public void getFileExposureTimeData(String str, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 4, 0, 0, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileExtraMetaData(String str, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 1, 0, 0, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileGps(String str, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 7, 0, 0, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileGyroData(String str, long j2, long j3, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 3, j2, j3, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileInfoList(C0150OooOOOo oooOOOo) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(oooOOOo);
        } else {
            oooOOOo.OooO0O0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileList(int i2, int i3, int i4, C0152OooOOo0 oooOOo0) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, i3, i4, oooOOo0);
        } else {
            oooOOo0.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileThumbnail(String str, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 2, 0, 0, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileThumbnailExt(String str, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 5, 0, 0, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public void getFileTimelapseTimestamp(String str, OooOOOO oooOOOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, 6, 0, 0, oooOOOO);
        } else {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        }
    }

    public String getFirmwareUploadPath() {
        return this.OooO0O0 != null ? "/upload_fw" : "";
    }

    public int getFlicker(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0OO(i2);
        }
        return -1;
    }

    public boolean getFlowstateEnable(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0Oo(i2);
        }
        return false;
    }

    public int getFovType(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0o0(i2);
        }
        return -1;
    }

    public int getISO(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0O0(i2, z);
        }
        return 0;
    }

    public int getISOTopLimit(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0o(i2);
        }
        return 0;
    }

    public boolean getIsLog(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0oO(i2);
        }
        return false;
    }

    public boolean getIsRaw(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0oo(i2);
        }
        return false;
    }

    public String getMediaOffset() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0o();
        }
        return null;
    }

    public String getOriginalOffset() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return (String) baseCameraController.OooO00o(Options.ORIGIN_OFFSET, null);
        }
        return null;
    }

    public int getPhotoSelfTimer(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO(i2);
        }
        return -1;
    }

    public int getPhotoSize(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOO0(i2);
        }
        return -1;
    }

    public int getPort() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOO0;
        }
        return 0;
    }

    public int getPreviewNum() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOoO;
        }
        return -1;
    }

    public PreviewStatus getPreviewStatus() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOo0O;
        }
        return PreviewStatus.IDLE;
    }

    public int getRecordDurationS(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOO0O(i2);
        }
        return -1;
    }

    public RenderMode getRenderMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOoOO;
        }
        return null;
    }

    public StreamResolution getSecondStreamResolution() {
        StreamResolution[] values;
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return null;
        }
        int intValue = ((Integer) baseCameraController.OooO00o(Options.SECOND_STREAM_RES, Integer.valueOf(-1))).intValue();
        for (StreamResolution streamResolution : StreamResolution.values()) {
            if (streamResolution.valueInCamera == intValue) {
                return streamResolution;
            }
        }
        return null;
    }

    public String getSerial() {
        BaseCameraController baseCameraController = this.OooO0O0;
        String str = "";
        return baseCameraController != null ? (String) baseCameraController.OooO00o("serial_number", str) : str;
    }

    public double getShutter(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0OO(i2, z);
        }
        return 0.0d;
    }

    public boolean getSportModeEnable(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOO0o(i2);
        }
        return false;
    }

    public int getSportModeLevel(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOO0(i2);
        }
        return -1;
    }

    public int getStorageCardState() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooO0oO();
        }
        return -1;
    }

    public long getStorageFreeSpace() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        e.b bVar = baseCameraController.OooOO0O;
        if (bVar == null) {
            return -1;
        }
        HashMap<String, Object> hashMap = bVar.f1125a;
        String str = Options.STORAGE_FREE_SPACE;
        if (hashMap.get(str) != null) {
            return ((Long) baseCameraController.OooOO0O.f1125a.get(str)).longValue();
        }
        return -1;
    }

    public long getStorageTotalSpace() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        e.b bVar = baseCameraController.OooOO0O;
        if (bVar == null) {
            return -1;
        }
        HashMap<String, Object> hashMap = bVar.f1125a;
        String str = Options.STORAGE_TOTAL_SPACE;
        if (hashMap.get(str) != null) {
            return ((Long) baseCameraController.OooOO0O.f1125a.get(str)).longValue();
        }
        return -1;
    }

    public int getSubPhotoMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.PHOTO_SUB_MODE, Integer.valueOf(-1))).intValue();
    }

    public int getSubVideoMode() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.VIDEO_SUB_MODE, Integer.valueOf(-1))).intValue();
    }

    public TimelapseParams getTimelapseParams(int i2) {
        TimelapseParams timelapseParams;
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return new TimelapseParams();
        }
        e.b bVar = baseCameraController.OooOO0O;
        if (bVar == null) {
            timelapseParams = new TimelapseParams(0, 0, 0);
        } else {
            TimelapseOptionsInfo timelapseOptionsInfo = (TimelapseOptionsInfo) bVar.f1127c.get(Integer.valueOf(i2));
            timelapseParams = timelapseOptionsInfo != null ? new TimelapseParams(timelapseOptionsInfo.durationS, timelapseOptionsInfo.lapseTimeMs, timelapseOptionsInfo.accelerateFequency) : new TimelapseParams(0, 0, 0);
        }
        return timelapseParams;
    }

    public String getVR180SenorSerial() {
        BaseCameraController baseCameraController = this.OooO0O0;
        String str = "";
        return baseCameraController != null ? (String) baseCameraController.OooO00o(Options.SENSOR_SERIAL_VR180, str) : str;
    }

    public String getVR360Senor0Serial() {
        BaseCameraController baseCameraController = this.OooO0O0;
        String str = "";
        return baseCameraController != null ? (String) baseCameraController.OooO00o(Options.SENSOR0_SERIAL_VR360, str) : str;
    }

    public String getVR360Senor1Serial() {
        BaseCameraController baseCameraController = this.OooO0O0;
        String str = "";
        return baseCameraController != null ? (String) baseCameraController.OooO00o(Options.SENSOR1_SERIAL_VR360, str) : str;
    }

    public int getVideoBitrate() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o("video_bitrate", Integer.valueOf(-1))).intValue();
    }

    public int getVideoEncodeType() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        return ((Integer) baseCameraController.OooO00o(Options.VIDEO_ENCODE_TYPE, Integer.valueOf(-1))).intValue();
    }

    public c.a.a.a.a.a.a getVideoResolution() {
        BaseCameraController baseCameraController = this.OooO0O0;
        return baseCameraController != null ? baseCameraController.OooOO0O() : new c.a.a.a.a.a.a(0, 0, 0);
    }

    public int getVideoResolutionId(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOOO(i2);
        }
        return -1;
    }

    public int getWhiteBalance(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOOo(i2);
        }
        return -1;
    }

    public String getWifiChannelCountry() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return (String) baseCameraController.OooO00o(Options.WIFI_CH_COUNTY, "");
        }
        return null;
    }

    public WifiInfo getWifiInfo() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return null;
        }
        WifiInfo wifiInfo = new WifiInfo();
        String str = "";
        wifiInfo.setSsid((String) baseCameraController.OooO00o(Options.WIFI_SSID, str));
        wifiInfo.setPwd((String) baseCameraController.OooO00o(Options.WIFI_PWD, str));
        return wifiInfo;
    }

    public boolean isBulletTimeRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOO0o();
        }
        return false;
    }

    public boolean isBurstCapturing() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOO0();
        }
        return false;
    }

    public boolean isCameraWorking() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOO();
        }
        return false;
    }

    public boolean isCharging() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return false;
        }
        return ((Integer) baseCameraController.OooO00o(Options.BATTERY_POWER_TYPE, Integer.valueOf(0))).intValue() == 1;
    }

    public boolean isFakeReady() {
        return this.OooO0o0 == CameraStatus.FAKE_READY;
    }

    public boolean isHDRCapturing() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOOO();
        }
        return false;
    }

    public boolean isHDRRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOOo();
        }
        return false;
    }

    public boolean isIdle() {
        return this.OooO0o0 == CameraStatus.IDLE;
    }

    public boolean isIntervalRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOo0();
        }
        return false;
    }

    public boolean isIntervalShooting() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOo();
        }
        return false;
    }

    public boolean isMute() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return false;
        }
        return ((Boolean) baseCameraController.OooO00o(Options.MUTE, Boolean.valueOf(false))).booleanValue();
    }

    public boolean isNightSceneCapturing() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOOoo();
        }
        return false;
    }

    public boolean isNormalCapturing() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOo00();
        }
        return false;
    }

    public boolean isNormalRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOo0();
        }
        return false;
    }

    public boolean isReady() {
        return this.OooO0o0 == CameraStatus.READY;
    }

    public boolean isSelfie() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return false;
        }
        return ((Boolean) baseCameraController.OooO00o("is_selfie", Boolean.valueOf(false))).booleanValue();
    }

    public boolean isStaticTimelapseRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOo0o();
        }
        return false;
    }

    public boolean isTimeShiftRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOoO0();
        }
        return false;
    }

    public boolean isTimelapseRecording() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            return baseCameraController.OooOoO();
        }
        return false;
    }

    public void openCameraWifi(C0155OooOo0O oooOo0O) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooO0OO != OooO0O0.IDLE) {
            baseCameraController.OooOO0.put(Long.valueOf(baseCameraController.OooO0O0.openCameraWifi()), oooOo0O);
        }
    }

    public void openPreviewStream(StreamResolution streamResolution, StreamResolution streamResolution2, int i2, RenderMode renderMode, boolean z, int i3, boolean z2, String str) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            BaseCameraController.OoooOOo.d("startPreviewStream");
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOo0O != PreviewStatus.IDLE) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startPreviewStream, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", PreviewStatus: ");
                a2.append(baseCameraController.OooOo0O);
                cameraLogger.w(a2.toString());
                return;
            }
            baseCameraController.OooOo0o = streamResolution;
            baseCameraController.OooOo = streamResolution2;
            baseCameraController.OooOoO0 = i2;
            baseCameraController.OooOoO = i3;
            baseCameraController.OooOoOO = renderMode;
            baseCameraController.OooO0O0.setAudioSource(z ? AudioSource.AUDIO_CAMERA : AudioSource.AUDIO_NONE);
            StartStreamingParam startStreamingParam = new StartStreamingParam();
            startStreamingParam.setFirstVideoParam(baseCameraController.OooO00o(streamResolution));
            startStreamingParam.setSecVideoParam(baseCameraController.OooO00o(streamResolution2));
            startStreamingParam.setDualStream(z2);
            AudioParam audioParam = new AudioParam();
            audioParam.codec = i2;
            if (z) {
                audioParam.enable = true;
                audioParam.sampleRate = OneCameraImplement.AUDIO_SAMPLE_RATE_DEF;
                audioParam.bitrate = 128000;
            } else {
                audioParam.enable = false;
            }
            startStreamingParam.setAudioParam(audioParam);
            startStreamingParam.setPreviewNum(i3);
            startStreamingParam.setGyroType(baseCameraController.OooO0o0());
            startStreamingParam.setPreviewNum(i3);
            baseCameraController.OooO0O0.previewStream(startStreamingParam, str);
            PreviewStatus previewStatus = PreviewStatus.OPENING;
            baseCameraController.OooOo0O = previewStatus;
            C0156OooOo0o oooOo0o = baseCameraController.Oooo;
            if (oooOo0o != null) {
                oooOo0o.OooO00o(previewStatus, 0);
            }
        }
    }

    public void resetRecord() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.resetRecord();
        }
    }

    public void scanBleRemoteController() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            ScanBTPeripheral scanBTPeripheral = new ScanBTPeripheral();
            scanBTPeripheral.peripheral_type = 1;
            baseCameraController.OooO0O0.scanBT(scanBTPeripheral);
            baseCameraController.OooOOO.postDelayed(baseCameraController.o000oOoO, Config.BPLUS_DELAY_TIME);
        }
    }

    public void setAEBCaptureNum(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, i3);
        }
    }

    public void setActiveTime(long j2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(j2);
        }
    }

    public void setBleRemoteControllerListener(C0147OooO0oO oooO0oO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OoooO00 = oooO0oO;
        }
    }

    public void setBleRemoteVersion(String str) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0O0(str);
        }
    }

    public void setBtnClickMode(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOOo0(i2);
        }
    }

    public void setBtnDoubleClickMode(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOOo(i2);
        }
    }

    public void setBtnShutdownClickMode(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOOoo(i2);
        }
    }

    public void setBtnTripleClickMode(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOo00(i2);
        }
    }

    public void setCaptureStatusChangedListener(ICaptureStatusChangedListener iCaptureStatusChangedListener) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.Oooo0oo = iCaptureStatusChangedListener;
        }
    }

    public void setExposureEV(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0O0(i2, i3);
        }
    }

    public void setExposureOptions(int i2, int i3, int i4, double d2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, i3, i4, d2, z);
        }
    }

    public void setFileExtraMetaData(String str, byte[] bArr, OooOo oooOo) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, bArr, oooOo);
        } else {
            oooOo.OooO0O0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
        }
    }

    public void setFlicker(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0OO(i2, i3);
        }
    }

    public void setFlowstateEnable(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0Oo(i2, z);
        }
    }

    public void setFovType(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0Oo(i2, i3);
        }
    }

    public void setGpsData(byte[] bArr) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            baseCameraController.OooO0O0.setGPSData(bArr);
        }
    }

    public void setISOTopLimit(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0o0(i2, i3);
        }
    }

    public void setKeyTimeDetail(long j2, int i2, String str) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            KeyTimePoint keyTimePoint = new KeyTimePoint();
            keyTimePoint.timestamp = j2;
            keyTimePoint.pointType = i2;
            keyTimePoint.typeDetial = str;
            baseCameraController.OooO0O0.setKeyTimePoint(keyTimePoint);
        }
    }

    public void setLiveListener(ICameraLiveStateListener iCameraLiveStateListener, InfoUpdateListener infoUpdateListener) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.setCameraLiveListener(iCameraLiveStateListener, infoUpdateListener);
        }
    }

    public void setLog(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0o0(i2, z);
        }
    }

    public void setMediaOffset(String str) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0OO(str);
        }
    }

    public void setMute(boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(z);
        }
    }

    public void setOriginalOffset(String str) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0Oo(str);
        }
    }

    public void setPhotoSelfTimer(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0o(i2, i3);
        }
    }

    public void setPhotoSize(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0oO(i2, i3);
        }
    }

    public void setPipeline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            baseCameraController.OooO0O0.setPipeline(iCameraPreviewPipeline);
        }
    }

    public void setPreviewStatusChangedListener(C0156OooOo0o oooOo0o) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.Oooo = oooOo0o;
        }
    }

    public void setRaw(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0o(i2, z);
        }
    }

    public void setRecordDurationS(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0oo(i2, i3);
        }
    }

    public void setSerial(String str) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0o0(str);
        }
    }

    public void setSportModeEnable(int i2, boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO0oO(i2, z);
        }
    }

    public void setSportModeLevel(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO(i2, i3);
        }
    }

    public void setStandByMode(int i2, C0159OooOoOO oooOoOO) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, oooOoOO);
        }
    }

    public void setStreamEncode(boolean z) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null && baseCameraController.OooOo0O()) {
            baseCameraController.OooO0O0.setStreamEncode(z);
        }
    }

    public void setSubPhotoMode(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOo0(i2);
        }
    }

    public void setSubVideoMode(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOo0O(i2);
        }
    }

    public void setTimelapseParams(int i2, TimelapseParams timelapseParams) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(i2, timelapseParams);
        }
    }

    public void setVideoEncodeType(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOo0o(i2);
        }
    }

    public void setVideoResolution(c.a.a.a.a.a.a aVar) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(aVar);
        }
    }

    public void setVideoResolutionId(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOO0(i2, i3);
        }
    }

    public void setWakeUpBleListener(C0143OooO0o0 oooO0o0) {
    }

    public void setWhiteBalance(int i2, int i3) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooOO0O(i2, i3);
        }
    }

    public void setWifiChannelCountry(String str, C0158OooOoO0 oooOoO0) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.OooO00o(str, oooOoO0);
        }
    }

    public void startBulletTime() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startBulletTime, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startBulletTime");
                if (baseCameraController.OooOo()) {
                    baseCameraController.OooO0O0.startRecord(true, false, 2, null);
                } else {
                    baseCameraController.OooO0O0.startBulletTime();
                }
                baseCameraController.OooO00o(CaptureType.BULLET_TIME);
            }
        }
    }

    public void startBurstCapture(boolean z, byte[] bArr) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return;
        }
        if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
            CameraLogger cameraLogger = BaseCameraController.OoooOOo;
            StringBuilder a2 = a.a("startBurstCapture, but status not match, SyncStatus: ");
            a2.append(baseCameraController.OooO0OO);
            a2.append(", captureStatus: ");
            a2.append(baseCameraController.OooOoo);
            cameraLogger.w(a2.toString());
            return;
        }
        BaseCameraController.OoooOOo.d("startBurstCapture");
        TakePicture takePicture = new TakePicture();
        takePicture.mode = 3;
        takePicture.extra_metadata = bArr;
        takePicture.isRawEnable = z;
        baseCameraController.OooO0O0.tackPicture(takePicture);
        baseCameraController.OooOooO = true;
        baseCameraController.OooO00o(CaptureType.BURST);
    }

    public void startHDRCapture(int[] iArr, boolean z, byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startHDRCapture, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startHDRCapture");
                TakePicture takePicture = new TakePicture();
                takePicture.mode = 1;
                takePicture.aeb_ev_bias = iArr;
                takePicture.extra_metadata = bArr;
                takePicture.isRawEnable = z;
                baseCameraController.OooO0O0.tackPicture(takePicture);
                baseCameraController.OooOooO = true;
                baseCameraController.OooO00o(CaptureType.HDR_CAPTURE);
            }
        }
    }

    public void startHDRRecord() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startHDRRecord, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startHDRRecord");
                if (baseCameraController.OooOo()) {
                    baseCameraController.OooO0O0.startRecord(true, false, 3, null);
                } else {
                    baseCameraController.OooO0O0.startHdrCapture();
                }
                baseCameraController.OooO00o(CaptureType.HDR_RECORD);
            }
        }
    }

    public void startIntervalRecord(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startIntervalRecord, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startIntervalRecord");
                StartTimelapse startTimelapse = new StartTimelapse();
                startTimelapse.mode = 4;
                startTimelapse.extraData = bArr;
                baseCameraController.OooO0O0.startTimelapse(startTimelapse);
                baseCameraController.OooO00o(CaptureType.INTERVAL_RECORD);
            }
        }
    }

    public void startIntervalShooting(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startIntervalShooting, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startIntervalShooting");
                StartTimelapse startTimelapse = new StartTimelapse();
                startTimelapse.mode = 2;
                startTimelapse.extraData = bArr;
                baseCameraController.OooO0O0.startTimelapse(startTimelapse);
                baseCameraController.OooO00o(CaptureType.INTERVAL_SHOOTING);
            }
        }
    }

    public void startLive(int i2, int i3, int i4, int i5, String str, int i6, long j2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            StartCaptureWithoutStorage startCaptureWithoutStorage = new StartCaptureWithoutStorage();
            startCaptureWithoutStorage.mRecordType = RecordType.ReEncoded;
            startCaptureWithoutStorage.width = i2;
            startCaptureWithoutStorage.height = i3;
            startCaptureWithoutStorage.fps = i4;
            startCaptureWithoutStorage.bitrate = i5;
            startCaptureWithoutStorage.path = str;
            startCaptureWithoutStorage.format = RecordFormat.VIDEO_FORMAT_FLV;
            startCaptureWithoutStorage.cameraLiveRenderMode = i6;
            startCaptureWithoutStorage.networkId = j2;
            startCaptureWithoutStorage.renderMode = RenderMode.withGlRenderer(i6 == 3 ? RenderMethod.PlanarKeep : RenderMethod.DualFishEyeStitchingPlanar);
            baseCameraController.OooO0O0.updatePanoOffset(baseCameraController.OooO0o());
            baseCameraController.OooO0O0.setRecordType(RecordingType.ReEncoded);
            CameraLogger cameraLogger = BaseCameraController.OoooOOo;
            StringBuilder a2 = a.a("startCaptureWithoutStorage: mRecordType:ReEncoded, width:", i2, ", height:", i3, ", fps:");
            a2.append(i4);
            a2.append(", bitrate:");
            a2.append(i5);
            a2.append(", path:");
            a2.append(str);
            a2.append(", format:VIDEO_FORMAT_FLV, cameraLiveRenderMode:");
            a2.append(startCaptureWithoutStorage.cameraLiveRenderMode);
            a2.append(", renderMode:");
            a2.append(startCaptureWithoutStorage.renderMode);
            cameraLogger.i(a2.toString());
            ICameraLiveStateListener iCameraLiveStateListener = baseCameraController.OooO0oo;
            if (iCameraLiveStateListener != null) {
                baseCameraController.OooO0O0.setCameraLiveStateListener(iCameraLiveStateListener);
            }
            InfoUpdateListener infoUpdateListener = baseCameraController.OooO;
            if (infoUpdateListener != null) {
                baseCameraController.OooO0O0.setInfoUpdateListener(baseCameraController.OooOOO, infoUpdateListener);
            }
            baseCameraController.OooO0O0.startRecord(false, true, 1, startCaptureWithoutStorage);
        }
    }

    public void startNightScene(boolean z, byte[] bArr) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return;
        }
        if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
            CameraLogger cameraLogger = BaseCameraController.OoooOOo;
            StringBuilder a2 = a.a("startNightScene, but status not match, SyncStatus: ");
            a2.append(baseCameraController.OooO0OO);
            a2.append(", captureStatus: ");
            a2.append(baseCameraController.OooOoo);
            cameraLogger.w(a2.toString());
            return;
        }
        BaseCameraController.OoooOOo.d("startNightScene");
        TakePicture takePicture = new TakePicture();
        takePicture.mode = 4;
        takePicture.extra_metadata = bArr;
        takePicture.isRawEnable = z;
        baseCameraController.OooO0O0.tackPicture(takePicture);
        baseCameraController.OooOooO = true;
        baseCameraController.OooO00o(CaptureType.NIGHT_SCENE);
    }

    public void startNormalCapture(boolean z, byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startNormalCapture, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startNormalCapture");
                TakePicture takePicture = new TakePicture();
                takePicture.mode = 0;
                takePicture.extra_metadata = bArr;
                takePicture.isRawEnable = z;
                baseCameraController.OooO0O0.tackPicture(takePicture);
                baseCameraController.OooOooO = true;
                baseCameraController.OooO00o(CaptureType.NORMAL_CAPTURE);
            }
        }
    }

    public void startNormalRecord() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startNormalRecord, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startNormalRecord");
                baseCameraController.OooO0O0.startRecord(true, false, 1, null);
                baseCameraController.OooO00o(CaptureType.NORMAL_RECORD);
            }
        }
    }

    public void startStaticTimelapse() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startStaticTimelapse, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startStaticTimelapse");
                StartTimelapse startTimelapse = new StartTimelapse();
                startTimelapse.mode = 3;
                baseCameraController.OooO0O0.startTimelapse(startTimelapse);
                baseCameraController.OooO00o(CaptureType.STATIC_TIMELAPSE);
            }
        }
    }

    public void startTimeShift() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startTimeShift, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startTimeShift");
                baseCameraController.OooO0O0.startRecord(true, false, 4, null);
                baseCameraController.OooO00o(CaptureType.TIME_SHIFT);
            }
        }
    }

    public void startTimelapse() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0O() || baseCameraController.OooOOO()) {
                CameraLogger cameraLogger = BaseCameraController.OoooOOo;
                StringBuilder a2 = a.a("startTimelapse, but status not match, SyncStatus: ");
                a2.append(baseCameraController.OooO0OO);
                a2.append(", captureStatus: ");
                a2.append(baseCameraController.OooOoo);
                cameraLogger.w(a2.toString());
            } else {
                BaseCameraController.OoooOOo.d("startTimelapse");
                StartTimelapse startTimelapse = new StartTimelapse();
                startTimelapse.mode = 1;
                baseCameraController.OooO0O0.startTimelapse(startTimelapse);
                baseCameraController.OooO00o(CaptureType.TIMELAPSE);
            }
        }
    }

    public void stopBulletTime(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOO0o()) {
                BaseCameraController.OoooOOo.w("stopBulletTime, but is not bullet time record now");
            } else {
                BaseCameraController.OoooOOo.d("stopBulletTime");
                if (baseCameraController.OooOo()) {
                    baseCameraController.OooO0O0.stopRecord(2, bArr);
                } else {
                    baseCameraController.OooO0O0.stopBulletTime(bArr);
                }
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopHDRRecord(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOOOo()) {
                BaseCameraController.OoooOOo.w("stopHDRRecord, but is not hdr record now");
            } else {
                BaseCameraController.OoooOOo.d("stopHDRRecord");
                if (baseCameraController.OooOo()) {
                    baseCameraController.OooO0O0.stopRecord(3, bArr);
                } else {
                    baseCameraController.OooO0O0.stopHdrCapture(bArr);
                }
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopIntervalRecord() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOOo0()) {
                BaseCameraController.OoooOOo.w("stopIntervalRecord, but is not interval record now");
            } else {
                BaseCameraController.OoooOOo.d("stopIntervalRecord");
                StopTimelapse stopTimelapse = new StopTimelapse();
                stopTimelapse.mode = 4;
                baseCameraController.OooO0O0.stopTimelapse(stopTimelapse);
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopIntervalShooting() {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOOo()) {
                BaseCameraController.OoooOOo.w("stopIntervalShooting, but is not interval shooting now");
            } else {
                BaseCameraController.OoooOOo.d("stopIntervalShooting");
                StopTimelapse stopTimelapse = new StopTimelapse();
                stopTimelapse.mode = 2;
                baseCameraController.OooO0O0.stopTimelapse(stopTimelapse);
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopLive() {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController != null) {
            baseCameraController.stopLive();
        }
    }

    public void stopNormalRecord(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0()) {
                BaseCameraController.OoooOOo.w("stopNormalRecord, but is not normal record now");
            } else {
                BaseCameraController.OoooOOo.d("stopNormalRecord");
                baseCameraController.OooO0O0.stopRecord(1, bArr);
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopStaticTimelapse(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOo0o()) {
                BaseCameraController.OoooOOo.w("stopStaticTimelapse, but is not static timelapse now");
            } else {
                BaseCameraController.OoooOOo.d("stopStaticTimelapse");
                StopTimelapse stopTimelapse = new StopTimelapse();
                stopTimelapse.mode = 3;
                stopTimelapse.extraData = bArr;
                baseCameraController.OooO0O0.stopTimelapse(stopTimelapse);
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopTimeShift(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOoO0()) {
                BaseCameraController.OoooOOo.w("stopTimeShift, but is not bullet time record now");
            } else {
                BaseCameraController.OoooOOo.d("stopTimeShift");
                baseCameraController.OooO0O0.stopRecord(4, bArr);
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public void stopTimelapse(byte[] bArr) {
        if (isReady()) {
            BaseCameraController baseCameraController = this.OooO0O0;
            if (!baseCameraController.OooOoO()) {
                BaseCameraController.OoooOOo.w("stopTimelapse, but is not timelapse now");
            } else {
                BaseCameraController.OoooOOo.d("stopTimelapse");
                StopTimelapse stopTimelapse = new StopTimelapse();
                stopTimelapse.mode = 1;
                stopTimelapse.extraData = bArr;
                baseCameraController.OooO0O0.stopTimelapse(stopTimelapse);
                baseCameraController.OooOooO = true;
                baseCameraController.OooOoo0();
            }
        }
    }

    public int getVideoBitrate(int i2) {
        BaseCameraController baseCameraController = this.OooO0O0;
        if (baseCameraController == null) {
            return -1;
        }
        e.b bVar = baseCameraController.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) baseCameraController.OooOO0O.f1126b.get(Integer.valueOf(i2))).getVideoBitrate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(OooO0O0 oooO0O0, int i2) {
        if (this.OooO0o0 == CameraStatus.SYNCING) {
            if (oooO0O0 == OooO0O0.READY) {
                OooOO0o.d("camera controller sync success");
                OooO00o(CameraStatus.READY, 0);
            }
            if (oooO0O0 == OooO0O0.FAKE_READY) {
                OooOO0o.d("camera controller sync success without check");
                OooO00o(CameraStatus.FAKE_READY, 0);
            }
            if (oooO0O0 == OooO0O0.ERROR) {
                OooOO0o.d("camera controller sync error");
                OooO00o(CameraStatus.ERROR, i2);
                OooO00o(false);
            }
        }
    }

    public final void OooO00o(String str) {
        this.OooO.removeCallbacks(this.OooOO0O);
        com.arashivision.insta360.basecamera.camera.CameraManager.OooO00o oooO00o = (com.arashivision.insta360.basecamera.camera.CameraManager.OooO00o) this.OooO00o;
        List supportCamera = CameraManager.this.OooO0O0.getSupportCamera();
        BaseCameraController baseCameraController = (!supportCamera.contains(CameraType.AKIKO) || !TextUtils.equals(str, CameraType.AKIKO.type)) ? (!supportCamera.contains(CameraType.ONEX) || !TextUtils.equals(str, CameraType.ONEX.type)) ? (!supportCamera.contains(CameraType.ONEX2) || !TextUtils.equals(str, CameraType.ONEX2.type)) ? (!supportCamera.contains(CameraType.GO) || !TextUtils.equals(str, CameraType.GO.type)) ? (!supportCamera.contains(CameraType.NANOS) || !TextUtils.isEmpty(str)) ? null : new o() : new n() : new p() : new q() : new m();
        if (baseCameraController != null) {
            baseCameraController.setBaseCameraChangedCallback(CameraManager.this.OooO0OO);
        }
        this.OooO0O0 = baseCameraController;
        if (baseCameraController == null) {
            CameraLogger cameraLogger = OooOO0o;
            StringBuilder sb = new StringBuilder();
            sb.append("cameraController create from cameraType is empty! cameraType: ");
            sb.append(str);
            cameraLogger.e(sb.toString());
            OooO00o(CameraStatus.ERROR, 0);
            OooO00o(false);
            return;
        }
        CameraLogger cameraLogger2 = OooOO0o;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("get cameraType success, cameraType: ");
        sb2.append(str);
        cameraLogger2.d(sb2.toString());
        com.arashivision.insta360.basecamera.camera.CameraManager.OooO00o oooO00o2 = (com.arashivision.insta360.basecamera.camera.CameraManager.OooO00o) this.OooO00o;
        this.OooO0O0.OooOo00 = CameraManager.this.OooO0O0.getCameraCheckActivationList(str, oooO00o2.OooO00o);
        BaseCameraController baseCameraController2 = this.OooO0O0;
        baseCameraController2.OooO0Oo = this.OooO0Oo;
        baseCameraController2.OooO0O0 = this.OooO0OO;
        baseCameraController2.OooO00o = this;
        baseCameraController2.Oooo0oO = new c(this);
        BaseCameraController baseCameraController3 = this.OooO0O0;
        if (baseCameraController3 != null) {
            baseCameraController3.OooO0o0 = new c.a.a.a.a.b(baseCameraController3);
            baseCameraController3.OooO0o = new c.a.a.a.a.c(baseCameraController3);
            baseCameraController3.OooO0oO = new c.a.a.a.a.d(baseCameraController3);
            baseCameraController3.OooO0O0.addCameraRecordListener(baseCameraController3.OooO0o0);
            baseCameraController3.OooO0O0.addStillImageListener(baseCameraController3.OooO0o);
            baseCameraController3.OooO0O0.addTimelapseRecordListener(baseCameraController3.OooO0oO);
            BaseCameraController baseCameraController4 = this.OooO0O0;
            Boolean bool = this.OooO0oO;
            baseCameraController4.OooO0O0(bool == null ? false : bool.booleanValue());
            OooO00o(CameraStatus.SYNCING, 0);
            return;
        }
        throw null;
    }
}
