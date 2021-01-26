package com.arashivision.insta360.basecamera.camera;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import c.a.a.a.a.e.b;
import c.a.a.a.a.f;
import c.a.a.a.a.h.a;
import com.arashivision.camera.InstaCamera;
import com.arashivision.camera.listener.ICameraLiveStateListener;
import com.arashivision.camera.listener.ICameraRecordListener;
import com.arashivision.camera.listener.ITimelapseListener;
import com.arashivision.camera.listener.OnStillImageListener;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType;
import com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType;
import com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus;
import com.arashivision.insta360.basecamera.camera.check.ICameraCheck;
import com.arashivision.insta360.basecamera.camera.setting.StreamResolution;
import com.arashivision.insta360.basecamera.camera.setting.TimelapseParams;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.insta360.basecamera.util.CameraConstants.ErrorCode;
import com.arashivision.onecamera.InfoUpdateListener;
import com.arashivision.onecamera.OneDriverInfo;
import com.arashivision.onecamera.Options;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.cameranotification.BTPeripheral;
import com.arashivision.onecamera.cameranotification.NotificationCaptureStopped;
import com.arashivision.onecamera.cameranotification.NotificatoinConnectedToPeripheral;
import com.arashivision.onecamera.cameranotification.NotificatoinDisconnectedPeripheral;
import com.arashivision.onecamera.cameranotification.NotificatoinDiscoverBTPeripheral;
import com.arashivision.onecamera.cameranotification.NotifyAuthenticateState;
import com.arashivision.onecamera.cameranotification.NotifyTimelapseState;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;
import com.arashivision.onecamera.camerarequest.DeleteFiles;
import com.arashivision.onecamera.camerarequest.GetFileExtra;
import com.arashivision.onecamera.camerarequest.GetFileList;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.GyroOptionIndexRange;
import com.arashivision.onecamera.camerarequest.GyroOptionTimeRange;
import com.arashivision.onecamera.camerarequest.SetFileExtra;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onecamera.cameraresponse.CalibrateGyroResp;
import com.arashivision.onecamera.cameraresponse.CameraCaptureStatus;
import com.arashivision.onecamera.cameraresponse.CheckAuthorizationResp;
import com.arashivision.onecamera.cameraresponse.CloseCameraWifiResp;
import com.arashivision.onecamera.cameraresponse.DeleteFilesResp;
import com.arashivision.onecamera.cameraresponse.EraseSdcardResp;
import com.arashivision.onecamera.cameraresponse.FileInfo;
import com.arashivision.onecamera.cameraresponse.GetCurrentCaptureStatusResp;
import com.arashivision.onecamera.cameraresponse.GetFileExtraResp;
import com.arashivision.onecamera.cameraresponse.GetFileInfoListResp;
import com.arashivision.onecamera.cameraresponse.GetFileListResp;
import com.arashivision.onecamera.cameraresponse.GetOptionsResp;
import com.arashivision.onecamera.cameraresponse.GetPhotographyOptionsResp;
import com.arashivision.onecamera.cameraresponse.GetTimelapseOptionsResp;
import com.arashivision.onecamera.cameraresponse.OpenCameraWifiResp;
import com.arashivision.onecamera.cameraresponse.SetFileExtraResp;
import com.arashivision.onecamera.cameraresponse.SetOptionsResp;
import com.arashivision.onecamera.cameraresponse.SetPhotographyOptionsResp;
import com.arashivision.onecamera.cameraresponse.SetStandbyResp;
import com.arashivision.onecamera.cameraresponse.SetTimelapseOptionsResp;
import com.arashivision.onecamera.render.RenderMode;
import com.arashivision.onestream.Gyro.GyroType;
import e.b.c.a.a.a0;
import e.b.c.a.a.b0;
import e.b.c.a.a.b1;
import e.b.c.a.a.c0;
import e.b.c.a.a.d0;
import e.b.c.a.a.d1;
import e.b.c.a.a.e;
import e.b.c.a.a.e0;
import e.b.c.a.a.f0;
import e.b.c.a.a.g;
import e.b.c.a.a.g0;
import e.b.c.a.a.h;
import e.b.c.a.a.h0;
import e.b.c.a.a.i;
import e.b.c.a.a.i0;
import e.b.c.a.a.j;
import e.b.c.a.a.j0;
import e.b.c.a.a.k;
import e.b.c.a.a.k0;
import e.b.c.a.a.l;
import e.b.c.a.a.l0;
import e.b.c.a.a.m;
import e.b.c.a.a.m0;
import e.b.c.a.a.n;
import e.b.c.a.a.n0;
import e.b.c.a.a.o;
import e.b.c.a.a.o0;
import e.b.c.a.a.p;
import e.b.c.a.a.p0;
import e.b.c.a.a.q;
import e.b.c.a.a.q0;
import e.b.c.a.a.r;
import e.b.c.a.a.r0;
import e.b.c.a.a.s;
import e.b.c.a.a.s0;
import e.b.c.a.a.t;
import e.b.c.a.a.t0;
import e.b.c.a.a.u;
import e.b.c.a.a.u0;
import e.b.c.a.a.v;
import e.b.c.a.a.v0;
import e.b.c.a.a.w;
import e.b.c.a.a.w0;
import e.b.c.a.a.x;
import e.b.c.a.a.x0;
import e.b.c.a.a.y;
import e.b.c.a.a.y0;
import e.b.c.a.a.z;
import e.b.c.a.a.z0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public abstract class BaseCameraController implements a {
    public static final CameraLogger OoooOOo = CameraLogger.getLogger(BaseCameraController.class);
    public InfoUpdateListener OooO;
    public BaseCamera OooO00o;
    public InstaCamera OooO0O0;
    public com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0 OooO0OO = com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE;
    public ConnectType OooO0Oo;
    public OnStillImageListener OooO0o;
    public ICameraRecordListener OooO0o0;
    public ITimelapseListener OooO0oO;
    public ICameraLiveStateListener OooO0oo;
    public HashMap<Long, OooO0o> OooOO0 = new HashMap<>();
    public b OooOO0O;
    public String OooOO0o;
    public Handler OooOOO = new Handler(Looper.getMainLooper());
    public int OooOOO0;
    public boolean OooOOOO = false;
    public boolean OooOOOo = false;
    public boolean OooOOo = false;
    public boolean OooOOo0 = false;
    public boolean OooOOoo;
    public StreamResolution OooOo = null;
    public int OooOo0;
    public List<ICameraCheck> OooOo00;
    public PreviewStatus OooOo0O = PreviewStatus.IDLE;
    public StreamResolution OooOo0o = null;
    public int OooOoO = -1;
    public int OooOoO0 = -1;
    public RenderMode OooOoOO = null;
    public CaptureStatus OooOoo = CaptureStatus.IDLE;
    public CaptureType OooOoo0 = CaptureType.IDLE;
    public boolean OooOooO;
    public String[] OooOooo;
    public C0156OooOo0o Oooo;
    public long Oooo0 = -1;
    public Integer Oooo000;
    public int Oooo00O = 0;
    public long Oooo00o = 0;
    public boolean Oooo0O0;
    public Options Oooo0OO;
    public HashMap<Integer, TimelapseOptionsInfo> Oooo0o = new HashMap<>();
    public HashMap<Integer, PhotoOptions> Oooo0o0 = new HashMap<>();
    public C0160OooOoo Oooo0oO;
    public ICaptureStatusChangedListener Oooo0oo;
    public C0154OooOo0 OoooO;
    public f OoooO0;
    public C0147OooO0oO OoooO00;
    public C0154OooOo0 OoooO0O;
    public Runnable OoooOO0 = new C0146OooO0o0();
    public Runnable OoooOOO = new g(this);
    public Runnable o000oOoO = new u(this);

    public interface ICaptureStatusChangedListener {
        void onCaptureCountChanged(int i2);

        void onCaptureStatusChanged(CaptureType captureType, CaptureStatus captureStatus, String[] strArr, Integer num);

        void onCaptureTimeChanged(long j2);
    }

    public interface OooO extends OooO0o {
        void OooO00o(int i2, int i3);
    }

    public class OooO00o implements C0153OooOOoo {
        public final /* synthetic */ int[] OooO00o;
        public final /* synthetic */ int[] OooO0O0;
        public final /* synthetic */ C0154OooOo0 OooO0OO;

        public OooO00o(int[] iArr, int[] iArr2, C0154OooOo0 oooOo0) {
            this.OooO00o = iArr;
            this.OooO0O0 = iArr2;
            this.OooO0OO = oooOo0;
        }

        public void OooO00o(int i2, PhotoOptions photoOptions) {
            BaseCameraController baseCameraController = BaseCameraController.this;
            if (baseCameraController.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.SYNCING_OPTIONS) {
                if (i2 == 0) {
                    int[] iArr = this.OooO00o;
                    iArr[0] = iArr[0] + 1;
                    int i3 = iArr[0];
                    int[] iArr2 = this.OooO0O0;
                    if (i3 < iArr2.length) {
                        baseCameraController.OooO00o(iArr2[iArr[0]], (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) this);
                    } else {
                        baseCameraController.OooOOOo = true;
                        BaseCameraController.this.OooO00o(this.OooO0OO);
                    }
                } else {
                    baseCameraController.OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, 0);
                }
            }
        }
    }

    public class OooO0O0 implements OooOo00 {
        public final /* synthetic */ int[] OooO00o;
        public final /* synthetic */ int[] OooO0O0;
        public final /* synthetic */ C0154OooOo0 OooO0OO;

        public OooO0O0(int[] iArr, int[] iArr2, C0154OooOo0 oooOo0) {
            this.OooO00o = iArr;
            this.OooO0O0 = iArr2;
            this.OooO0OO = oooOo0;
        }

        public void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo) {
            BaseCameraController baseCameraController = BaseCameraController.this;
            if (baseCameraController.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.SYNCING_OPTIONS) {
                if (i2 == 0) {
                    int[] iArr = this.OooO00o;
                    iArr[0] = iArr[0] + 1;
                    int i3 = iArr[0];
                    int[] iArr2 = this.OooO0O0;
                    if (i3 < iArr2.length) {
                        baseCameraController.OooO00o(iArr2[iArr[0]], (OooOo00) this);
                    } else {
                        baseCameraController.OooOOo0 = true;
                        BaseCameraController.this.OooO00o(this.OooO0OO);
                    }
                } else {
                    baseCameraController.OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, 0);
                }
            }
        }
    }

    public class OooO0OO implements C0151OooOOo {
        public final /* synthetic */ int[] OooO00o;
        public final /* synthetic */ List OooO0O0;
        public final /* synthetic */ int OooO0OO;
        public final /* synthetic */ C0151OooOOo OooO0Oo;

        public OooO0OO(int[] iArr, List list, int i2, C0151OooOOo oooOOo) {
            this.OooO00o = iArr;
            this.OooO0O0 = list;
            this.OooO0OO = i2;
            this.OooO0Oo = oooOOo;
        }

        public void OooO00o(int i2, Options options) {
            C0151OooOOo oooOOo;
            CameraLogger cameraLogger = BaseCameraController.OoooOOo;
            StringBuilder a2 = e.a.a.a.a.a("syncOptions, errorCode: ", i2, ", index: ");
            a2.append(this.OooO00o[0]);
            a2.append(" - ");
            a2.append(this.OooO00o[1]);
            cameraLogger.d(a2.toString());
            if (i2 == 0) {
                List list = this.OooO0O0;
                int[] iArr = this.OooO00o;
                for (String a3 : list.subList(iArr[0], iArr[1])) {
                    a.a.a.a.b.a.a(BaseCameraController.this.OooOO0O.f1125a, options, a3);
                }
                if (this.OooO00o[1] < this.OooO0O0.size()) {
                    int[] iArr2 = this.OooO00o;
                    iArr2[0] = iArr2[1];
                    iArr2[1] = Math.min(iArr2[1] + this.OooO0OO, this.OooO0O0.size());
                    BaseCameraController baseCameraController = BaseCameraController.this;
                    HashMap<Long, OooO0o> hashMap = baseCameraController.OooOO0;
                    InstaCamera instaCamera = baseCameraController.OooO0O0;
                    List list2 = this.OooO0O0;
                    int[] iArr3 = this.OooO00o;
                    hashMap.put(Long.valueOf(instaCamera.getOptionsSync(list2.subList(iArr3[0], iArr3[1]))), this);
                    return;
                }
                oooOOo = this.OooO0Oo;
                if (oooOOo == null) {
                    return;
                }
            } else {
                oooOOo = this.OooO0Oo;
                if (oooOOo == null) {
                    return;
                }
            }
            oooOOo.OooO00o(i2, null);
        }
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooO0Oo reason: case insensitive filesystem */
    public class C0145OooO0Oo implements C0153OooOOoo {
        public final /* synthetic */ int OooO00o;
        public final /* synthetic */ int[] OooO0O0;
        public final /* synthetic */ List OooO0OO;
        public final /* synthetic */ int OooO0Oo;
        public final /* synthetic */ C0153OooOOoo OooO0o0;

        public C0145OooO0Oo(int i2, int[] iArr, List list, int i3, C0153OooOOoo oooOOoo) {
            this.OooO00o = i2;
            this.OooO0O0 = iArr;
            this.OooO0OO = list;
            this.OooO0Oo = i3;
            this.OooO0o0 = oooOOoo;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c3, code lost:
            r5 = r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void OooO00o(int r9, com.arashivision.onecamera.PhotoOptions r10) {
            /*
                r8 = this;
                com.arashivision.insta360.basecamera.log.CameraLogger r0 = com.arashivision.insta360.basecamera.camera.BaseCameraController.OoooOOo
                java.lang.String r1 = "syncPhotoOptions, errorCode: "
                java.lang.String r2 = ", funcMode: "
                java.lang.StringBuilder r1 = e.a.a.a.a.a(r1, r9, r2)
                int r2 = r8.OooO00o
                r1.append(r2)
                java.lang.String r2 = ", index: "
                r1.append(r2)
                int[] r2 = r8.OooO0O0
                r3 = 0
                r2 = r2[r3]
                r1.append(r2)
                java.lang.String r2 = " - "
                r1.append(r2)
                int[] r2 = r8.OooO0O0
                r4 = 1
                r2 = r2[r4]
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.d(r1)
                if (r9 != 0) goto L_0x0314
                com.arashivision.insta360.basecamera.camera.BaseCameraController r0 = com.arashivision.insta360.basecamera.camera.BaseCameraController.this
                c.a.a.a.a.e$b r0 = r0.OooOO0O
                int r1 = r8.OooO00o
                java.util.HashMap<java.lang.Integer, com.arashivision.onecamera.PhotoOptions> r0 = r0.f1126b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.Object r0 = r0.get(r1)
                com.arashivision.onecamera.PhotoOptions r0 = (com.arashivision.onecamera.PhotoOptions) r0
                if (r0 != 0) goto L_0x005a
                com.arashivision.insta360.basecamera.camera.BaseCameraController r0 = com.arashivision.insta360.basecamera.camera.BaseCameraController.this
                c.a.a.a.a.e$b r0 = r0.OooOO0O
                int r1 = r8.OooO00o
                com.arashivision.onecamera.PhotoOptions r2 = new com.arashivision.onecamera.PhotoOptions
                r2.<init>()
                java.util.HashMap<java.lang.Integer, com.arashivision.onecamera.PhotoOptions> r0 = r0.f1126b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.put(r1, r2)
            L_0x005a:
                java.util.List r0 = r8.OooO0OO
                int[] r1 = r8.OooO0O0
                r2 = r1[r3]
                r1 = r1[r4]
                java.util.List r0 = r0.subList(r2, r1)
                java.util.Iterator r0 = r0.iterator()
            L_0x006a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x02cc
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                com.arashivision.insta360.basecamera.camera.BaseCameraController r2 = com.arashivision.insta360.basecamera.camera.BaseCameraController.this
                c.a.a.a.a.e$b r2 = r2.OooOO0O
                int r5 = r8.OooO00o
                java.util.HashMap<java.lang.Integer, com.arashivision.onecamera.PhotoOptions> r2 = r2.f1126b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r2 = r2.get(r5)
                com.arashivision.onecamera.PhotoOptions r2 = (com.arashivision.onecamera.PhotoOptions) r2
                r5 = -1
                int r6 = r1.hashCode()
                switch(r6) {
                    case -1847462625: goto L_0x01b9;
                    case -1781844801: goto L_0x01ae;
                    case -1571105471: goto L_0x01a4;
                    case -1301072550: goto L_0x0199;
                    case -1182816058: goto L_0x018e;
                    case -1048125855: goto L_0x0183;
                    case -979631837: goto L_0x0178;
                    case -978301484: goto L_0x016d;
                    case -771931656: goto L_0x0162;
                    case -566947070: goto L_0x0158;
                    case -260664062: goto L_0x014c;
                    case -230491182: goto L_0x0141;
                    case -65446462: goto L_0x0135;
                    case 103672: goto L_0x012a;
                    case 229284108: goto L_0x011e;
                    case 432892657: goto L_0x0113;
                    case 576238444: goto L_0x0107;
                    case 648162385: goto L_0x00fc;
                    case 738950403: goto L_0x00f1;
                    case 763973450: goto L_0x00e5;
                    case 892245796: goto L_0x00d9;
                    case 977977427: goto L_0x00cd;
                    case 991499417: goto L_0x00c2;
                    case 1534343436: goto L_0x00b6;
                    case 1606905228: goto L_0x00aa;
                    case 1612103325: goto L_0x009e;
                    case 1924434857: goto L_0x0092;
                    default: goto L_0x0090;
                }
            L_0x0090:
                goto L_0x01c4
            L_0x0092:
                java.lang.String r6 = "video_bitrate"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 24
                goto L_0x01c3
            L_0x009e:
                java.lang.String r6 = "preview_sport_mode_enable"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 15
                goto L_0x01c3
            L_0x00aa:
                java.lang.String r6 = "manual_meter_weights"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 8
                goto L_0x01c3
            L_0x00b6:
                java.lang.String r6 = "aeb_capture_num"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 19
                goto L_0x01c3
            L_0x00c2:
                java.lang.String r6 = "meter_mode"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 7
                goto L_0x01c3
            L_0x00cd:
                java.lang.String r6 = "video_iso_top_limit"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 16
                goto L_0x01c3
            L_0x00d9:
                java.lang.String r6 = "log_mode_enable"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 11
                goto L_0x01c3
            L_0x00e5:
                java.lang.String r6 = "raw_capture_type"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 17
                goto L_0x01c3
            L_0x00f1:
                java.lang.String r6 = "channel"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r5 = r3
                goto L_0x01c4
            L_0x00fc:
                java.lang.String r6 = "brightness"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r5 = r4
                goto L_0x01c4
            L_0x0107:
                java.lang.String r6 = "fov_type"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 25
                goto L_0x01c3
            L_0x0113:
                java.lang.String r6 = "exposure_bias"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 6
                goto L_0x01c3
            L_0x011e:
                java.lang.String r6 = "photo_size_id"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 22
                goto L_0x01c3
            L_0x012a:
                java.lang.String r6 = "hue"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 4
                goto L_0x01c3
            L_0x0135:
                java.lang.String r6 = "record_duration"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 21
                goto L_0x01c3
            L_0x0141:
                java.lang.String r6 = "saturation"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 3
                goto L_0x01c3
            L_0x014c:
                java.lang.String r6 = "preview_sport_level"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 20
                goto L_0x01c3
            L_0x0158:
                java.lang.String r6 = "contrast"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 2
                goto L_0x01c3
            L_0x0162:
                java.lang.String r6 = "flicker"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 10
                goto L_0x01c3
            L_0x016d:
                java.lang.String r6 = "still_exposure_options-program"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 12
                goto L_0x01c3
            L_0x0178:
                java.lang.String r6 = "preview_mctf_enable"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 14
                goto L_0x01c3
            L_0x0183:
                java.lang.String r6 = "video_exposure_options-program"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 13
                goto L_0x01c3
            L_0x018e:
                java.lang.String r6 = "white_balance"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 9
                goto L_0x01c3
            L_0x0199:
                java.lang.String r6 = "record_resolution"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 23
                goto L_0x01c3
            L_0x01a4:
                java.lang.String r6 = "sharpness"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 5
                goto L_0x01c3
            L_0x01ae:
                java.lang.String r6 = "photo_self_timer"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 18
                goto L_0x01c3
            L_0x01b9:
                java.lang.String r6 = "flowstate_enable"
                boolean r1 = r1.equals(r6)
                if (r1 == 0) goto L_0x01c4
                r1 = 26
            L_0x01c3:
                r5 = r1
            L_0x01c4:
                switch(r5) {
                    case 0: goto L_0x02c3;
                    case 1: goto L_0x02ba;
                    case 2: goto L_0x02b1;
                    case 3: goto L_0x02a8;
                    case 4: goto L_0x029f;
                    case 5: goto L_0x0296;
                    case 6: goto L_0x028d;
                    case 7: goto L_0x0284;
                    case 8: goto L_0x027b;
                    case 9: goto L_0x0272;
                    case 10: goto L_0x0269;
                    case 11: goto L_0x0260;
                    case 12: goto L_0x024f;
                    case 13: goto L_0x023e;
                    case 14: goto L_0x0235;
                    case 15: goto L_0x022c;
                    case 16: goto L_0x0223;
                    case 17: goto L_0x021a;
                    case 18: goto L_0x0211;
                    case 19: goto L_0x0208;
                    case 20: goto L_0x01ff;
                    case 21: goto L_0x01f6;
                    case 22: goto L_0x01ed;
                    case 23: goto L_0x01e4;
                    case 24: goto L_0x01db;
                    case 25: goto L_0x01d2;
                    case 26: goto L_0x01c9;
                    default: goto L_0x01c7;
                }
            L_0x01c7:
                goto L_0x006a
            L_0x01c9:
                boolean r1 = r10.getFlowStateEnable()
                r2.setFlowStateEnable(r1)
                goto L_0x006a
            L_0x01d2:
                int r1 = r10.getFovType()
                r2.setFovType(r1)
                goto L_0x006a
            L_0x01db:
                int r1 = r10.getVideoBitrate()
                r2.setVideoBitrate(r1)
                goto L_0x006a
            L_0x01e4:
                int r1 = r10.getVideoResolution()
                r2.setVideoResolution(r1)
                goto L_0x006a
            L_0x01ed:
                int r1 = r10.getPhotoSize()
                r2.setPhotoSize(r1)
                goto L_0x006a
            L_0x01f6:
                int r1 = r10.getRecordDuration()
                r2.setRecordDuration(r1)
                goto L_0x006a
            L_0x01ff:
                int r1 = r10.getPreviewSportLevel()
                r2.setPreviewSportLevel(r1)
                goto L_0x006a
            L_0x0208:
                int r1 = r10.getAEBCaptureNum()
                r2.setAEBCaptureNum(r1)
                goto L_0x006a
            L_0x0211:
                int r1 = r10.getPhotoSelfTimer()
                r2.setPhotoSelfTimer(r1)
                goto L_0x006a
            L_0x021a:
                int r1 = r10.getRawCaptureType()
                r2.setRawCaptureType(r1)
                goto L_0x006a
            L_0x0223:
                int r1 = r10.getVideoISOTopLimit()
                r2.setVideoISOTopLimit(r1)
                goto L_0x006a
            L_0x022c:
                boolean r1 = r10.getPreviewSportModeModeEnable()
                r2.setPreviewSportModeModeEnable(r1)
                goto L_0x006a
            L_0x0235:
                boolean r1 = r10.getPreviewMctfEnable()
                r2.setPreviewMctfEnable(r1)
                goto L_0x006a
            L_0x023e:
                int r1 = r10.getVideoExposureOptionProgram()
                int r5 = r10.getVideoExposureOptionISO()
                double r6 = r10.getVideoExposureOptionShutter()
                r2.setVideoExposureOption(r1, r5, r6)
                goto L_0x006a
            L_0x024f:
                int r1 = r10.getStillExposureOptionProgram()
                int r5 = r10.getStillExposureOptionISO()
                double r6 = r10.getStillExposureOptionShutter()
                r2.setStillExposureOption(r1, r5, r6)
                goto L_0x006a
            L_0x0260:
                boolean r1 = r10.getLogModeEnable()
                r2.setLogModeEnable(r1)
                goto L_0x006a
            L_0x0269:
                int r1 = r10.getFlicker()
                r2.setFlicker(r1)
                goto L_0x006a
            L_0x0272:
                int r1 = r10.getWhiteBalance()
                r2.setWhiteBalance(r1)
                goto L_0x006a
            L_0x027b:
                int[] r1 = r10.getAEManualMeterWeight()
                r2.setAEManualMeterWeight(r1)
                goto L_0x006a
            L_0x0284:
                int r1 = r10.getAEMeterMode()
                r2.setAEMeterMode(r1)
                goto L_0x006a
            L_0x028d:
                int r1 = r10.getExposureBias()
                r2.setExposureBias(r1)
                goto L_0x006a
            L_0x0296:
                int r1 = r10.getSharpness()
                r2.setSharpness(r1)
                goto L_0x006a
            L_0x029f:
                int r1 = r10.getHue()
                r2.setHue(r1)
                goto L_0x006a
            L_0x02a8:
                int r1 = r10.getSaturation()
                r2.setSaturation(r1)
                goto L_0x006a
            L_0x02b1:
                int r1 = r10.getContrast()
                r2.setContrast(r1)
                goto L_0x006a
            L_0x02ba:
                int r1 = r10.getBrightness()
                r2.setBrightness(r1)
                goto L_0x006a
            L_0x02c3:
                int r1 = r10.getChannel()
                r2.setChannel(r1)
                goto L_0x006a
            L_0x02cc:
                int[] r10 = r8.OooO0O0
                r10 = r10[r4]
                java.util.List r0 = r8.OooO0OO
                int r0 = r0.size()
                if (r10 >= r0) goto L_0x030f
                int[] r9 = r8.OooO0O0
                r10 = r9[r4]
                r9[r3] = r10
                r10 = r9[r4]
                int r0 = r8.OooO0Oo
                int r10 = r10 + r0
                java.util.List r0 = r8.OooO0OO
                int r0 = r0.size()
                int r10 = java.lang.Math.min(r10, r0)
                r9[r4] = r10
                com.arashivision.insta360.basecamera.camera.BaseCameraController r9 = com.arashivision.insta360.basecamera.camera.BaseCameraController.this
                java.util.HashMap<java.lang.Long, com.arashivision.insta360.basecamera.camera.BaseCameraController$OooO0o> r10 = r9.OooOO0
                com.arashivision.camera.InstaCamera r9 = r9.OooO0O0
                int r0 = r8.OooO00o
                java.util.List r1 = r8.OooO0OO
                int[] r2 = r8.OooO0O0
                r3 = r2[r3]
                r2 = r2[r4]
                java.util.List r1 = r1.subList(r3, r2)
                long r0 = r9.getPhotoOptionsAsync(r0, r1)
                java.lang.Long r9 = java.lang.Long.valueOf(r0)
                r10.put(r9, r8)
                goto L_0x031c
            L_0x030f:
                com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOOoo r10 = r8.OooO0o0
                if (r10 == 0) goto L_0x031c
                goto L_0x0318
            L_0x0314:
                com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOOoo r10 = r8.OooO0o0
                if (r10 == 0) goto L_0x031c
            L_0x0318:
                r0 = 0
                r10.OooO00o(r9, r0)
            L_0x031c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basecamera.camera.BaseCameraController.C0145OooO0Oo.OooO00o(int, com.arashivision.onecamera.PhotoOptions):void");
        }
    }

    public interface OooO0o {
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooO0o0 reason: case insensitive filesystem */
    public class C0146OooO0o0 implements Runnable {
        public C0146OooO0o0() {
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            BaseCameraController baseCameraController = BaseCameraController.this;
            long j2 = (currentTimeMillis - baseCameraController.Oooo0) + baseCameraController.Oooo00o;
            baseCameraController.Oooo00o = j2;
            baseCameraController.Oooo0 = currentTimeMillis;
            ICaptureStatusChangedListener iCaptureStatusChangedListener = baseCameraController.Oooo0oo;
            if (iCaptureStatusChangedListener != null) {
                iCaptureStatusChangedListener.onCaptureTimeChanged(j2);
            }
            BaseCameraController.this.OooOOO.postDelayed(this, 50);
        }
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooO0oO reason: case insensitive filesystem */
    public interface C0147OooO0oO {
        void OooO00o(int i2, BTPeripheral bTPeripheral);

        void OooO00o(int i2, BTPeripheral[] bTPeripheralArr);

        void OooO0O0(int i2, BTPeripheral bTPeripheral);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooO0oo reason: case insensitive filesystem */
    public interface C0148OooO0oo extends OooO0o {
        void OooO0o0(int i2);
    }

    public interface OooOO0 extends OooO0o {
        void OooOO0(int i2);
    }

    public interface OooOO0O extends OooO0o {
        void OooO0oO(int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOO0o reason: case insensitive filesystem */
    public interface C0149OooOO0o {
        void OooO00o(int i2);
    }

    public interface OooOOO extends OooO0o {
        void OooO00o(int i2, CameraCaptureStatus cameraCaptureStatus);
    }

    public interface OooOOO0 extends OooO0o {
        void OooO0oo(int i2);
    }

    public interface OooOOOO extends OooO0o {
        void OooO00o(int i2, byte[] bArr);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOOOo reason: case insensitive filesystem */
    public interface C0150OooOOOo extends OooO0o {
        void OooO0O0(int i2, List<FileInfo> list);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOOo reason: case insensitive filesystem */
    public interface C0151OooOOo extends OooO0o {
        void OooO00o(int i2, Options options);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOOo0 reason: case insensitive filesystem */
    public interface C0152OooOOo0 extends OooO0o {
        void OooO00o(int i2, List<String> list);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOOoo reason: case insensitive filesystem */
    public interface C0153OooOOoo extends OooO0o {
        void OooO00o(int i2, PhotoOptions photoOptions);
    }

    public interface OooOo extends OooO0o {
        void OooO0O0(int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOo0 reason: case insensitive filesystem */
    public interface C0154OooOo0 {
        void OooO00o();
    }

    public interface OooOo00 extends OooO0o {
        void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOo0O reason: case insensitive filesystem */
    public interface C0155OooOo0O extends OooO0o {
        void OooO00o(int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOo0o reason: case insensitive filesystem */
    public interface C0156OooOo0o {
        void OooO00o(PreviewStatus previewStatus, int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOoO reason: case insensitive filesystem */
    public interface C0157OooOoO extends OooO0o {
        void OooO0Oo(int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOoO0 reason: case insensitive filesystem */
    public interface C0158OooOoO0 extends OooO0o {
        void OooO0o(int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOoOO reason: case insensitive filesystem */
    public interface C0159OooOoOO extends OooO0o {
        void OooO(int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOoo reason: case insensitive filesystem */
    public interface C0160OooOoo {
        void OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0 oooO0O0, int i2);
    }

    /* renamed from: com.arashivision.insta360.basecamera.camera.BaseCameraController$OooOoo0 reason: case insensitive filesystem */
    public interface C0161OooOoo0 extends OooO0o {
        void OooO0OO(int i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, int i3, Options options) {
        if (i3 == 0) {
            int OooO0oO2 = OooO0oO();
            if (i2 != OooO0oO2) {
                f fVar = this.OoooO0;
                if (fVar != null) {
                    fVar.onCameraSDCardStateChanged(this.OooO00o, i2, OooO0oO2);
                }
            }
            f fVar2 = this.OoooO0;
            if (fVar2 != null) {
                fVar2.onCameraStorageChanged(this.OooO00o);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, Options options) {
        if (i2 == 0) {
            f fVar = this.OoooO0;
            if (fVar != null) {
                fVar.onCameraBatteryLow(this.OooO00o);
            }
        }
    }

    public static /* synthetic */ void OooO00o(C0149OooOO0o oooOO0o, int i2, Options options) {
        if (oooOO0o != null) {
            oooOO0o.OooO00o(i2);
        }
    }

    public static /* synthetic */ void OooO00o(C0149OooOO0o oooOO0o, int i2, PhotoOptions photoOptions) {
        if (oooOO0o != null) {
            oooOO0o.OooO00o(i2);
        }
    }

    public static /* synthetic */ void OooO00o(C0159OooOoOO oooOoOO, int i2) {
        if (oooOoOO != null) {
            oooOoOO.OooO(i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(NotificatoinConnectedToPeripheral notificatoinConnectedToPeripheral, int i2, Options options) {
        C0147OooO0oO oooO0oO = this.OoooO00;
        if (oooO0oO != null) {
            oooO0oO.OooO0O0(0, notificatoinConnectedToPeripheral.peripheral);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(Integer num, boolean[] zArr, int i2) {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("set transaction photo options result, errorCode: ");
        sb.append(i2);
        sb.append(", funcMode: ");
        sb.append(num);
        cameraLogger.d(sb.toString());
        if (i2 != 0 && OooOo0O() && !zArr[0]) {
            zArr[0] = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(boolean[] zArr, int i2) {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("set transaction options result, errorCode: ");
        sb.append(i2);
        cameraLogger.d(sb.toString());
        if (i2 != 0 && OooOo0O() && !zArr[0]) {
            zArr[0] = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(int i2, Options options) {
        if (i2 == 0) {
            f fVar = this.OoooO0;
            if (fVar != null) {
                fVar.onCameraBatteryUpdate(this.OooO00o);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(Integer num, boolean[] zArr, int i2) {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("set transaction timelapse options result, errorCode: ");
        sb.append(i2);
        sb.append(", timelapseMode: ");
        sb.append(num);
        cameraLogger.d(sb.toString());
        if (i2 != 0 && OooOo0O() && !zArr[0]) {
            zArr[0] = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooOOO(int i2, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setVideoEncodeType failed, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.VIDEO_ENCODE_TYPE, Integer.valueOf(i2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oooo00O() {
        C0147OooO0oO oooO0oO = this.OoooO00;
        if (oooO0oO != null) {
            oooO0oO.OooO00o((int) ErrorCode.CAMERA_SCAN_BLE_REMOTE_CONTROL_TIME_OUT, (BTPeripheral[]) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oooo00o() {
        C0147OooO0oO oooO0oO = this.OoooO00;
        if (oooO0oO != null) {
            oooO0oO.OooO0O0(ErrorCode.CAMERA_CONNECT_BLE_REMOTE_CONTROL_TIME_OUT, null);
        }
    }

    public int OooO(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return 0;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getPhotoSelfTimer();
    }

    public abstract List<String> OooO();

    public final VideoParam OooO00o(StreamResolution streamResolution) {
        VideoParam videoParam = new VideoParam();
        videoParam.bitrate = streamResolution.bitrate;
        videoParam.fps = streamResolution.fps;
        videoParam.height = streamResolution.height;
        videoParam.width = streamResolution.width;
        videoParam.enableGyro = true;
        return videoParam;
    }

    public final void OooO00o() {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.CHECKING) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder a2 = e.a.a.a.a.a("checkNext, but status not match, syncStatus: ");
            a2.append(this.OooO0OO);
            cameraLogger.d(a2.toString());
            return;
        }
        if (this.OooOo0 + 1 < this.OooOo00.size()) {
            int i2 = this.OooOo0 + 1;
            this.OooOo0 = i2;
            ((ICameraCheck) this.OooOo00.get(i2)).startCheck(this.OooO00o, this);
        } else {
            C0154OooOo0 oooOo0 = this.OoooO;
            if (oooOo0 != null) {
                oooOo0.OooO00o();
            }
        }
    }

    public synchronized void OooO00o(int i2, int i3, int i4, C0152OooOOo0 oooOOo0) {
        if (!OooOo0O()) {
            oooOOo0.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
            return;
        }
        GetFileList getFileList = new GetFileList();
        getFileList.media_type = i2;
        getFileList.limit = i4;
        getFileList.start = i3;
        this.OooOO0.put(Long.valueOf(this.OooO0O0.getFileList(getFileList)), oooOOo0);
    }

    public final void OooO00o(int i2, int i3, Object obj) {
        String str;
        CameraLogger cameraLogger;
        Runnable runnable;
        Handler handler;
        int i4;
        com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0 oooO0O0;
        CameraLogger cameraLogger2 = OoooOOo;
        StringBuilder a2 = e.a.a.a.a.a("onCameraInfoNotify, type: ", i2, ", error: ", i3, ", obj: ");
        a2.append(obj);
        cameraLogger2.d(a2.toString());
        if (i2 == 2) {
            OoooOOo.d("response: BATTERY_UPDATE");
            OooOooO();
        } else if (i2 == 3) {
            OoooOOo.d("response: BATTERY_LOW");
            OooOoo();
        } else if (i2 == 5 || i2 == 6) {
            OoooOOo.d("response: STORAGE_UPDATE");
            Oooo000();
        } else if (i2 != 50) {
            if (i2 == 51) {
                cameraLogger = OoooOOo;
                str = "response: STOP_LIVE_STREAM";
            } else if (i2 == 64) {
                OoooOOo.d("response: ERASE_SD_CARD");
                OooO0o oooO0o = (OooO0o) this.OooOO0.remove(Long.valueOf(((EraseSdcardResp) obj).requestID));
                Oooo000();
                if (oooO0o instanceof OooOOO0) {
                    ((OooOOO0) oooO0o).OooO0oo(i3);
                    return;
                }
                return;
            } else if (i2 == 65) {
                OoooOOo.d("response: CALIBRATE_GYRO");
                OooO0o oooO0o2 = (OooO0o) this.OooOO0.remove(Long.valueOf(((CalibrateGyroResp) obj).requestID));
                if (oooO0o2 instanceof C0148OooO0oo) {
                    ((C0148OooO0oo) oooO0o2).OooO0o0(i3);
                    return;
                }
                return;
            } else if (i2 == 69) {
                OoooOOo.d("response: OPEN_CAMERA_WIFI");
                OpenCameraWifiResp openCameraWifiResp = (OpenCameraWifiResp) obj;
                OooO0o oooO0o3 = (OooO0o) this.OooOO0.remove(Long.valueOf(openCameraWifiResp.getRequestID()));
                if (oooO0o3 instanceof C0155OooOo0O) {
                    ((C0155OooOo0O) oooO0o3).OooO00o(openCameraWifiResp.getErrorCode());
                    return;
                }
                return;
            } else if (i2 == 70) {
                OoooOOo.d("response: CLOSE_CAMERA_WIFI");
                CloseCameraWifiResp closeCameraWifiResp = (CloseCameraWifiResp) obj;
                OooO0o oooO0o4 = (OooO0o) this.OooOO0.remove(Long.valueOf(closeCameraWifiResp.getRequestID()));
                if (oooO0o4 instanceof OooOO0) {
                    ((OooOO0) oooO0o4).OooOO0(closeCameraWifiResp.getErrorCode());
                    return;
                }
                return;
            } else if (i2 != 72) {
                if (i2 == 73) {
                    OoooOOo.d("response: SCAN_BT");
                    if (i3 != 0) {
                        C0147OooO0oO oooO0oO = this.OoooO00;
                        if (oooO0oO != null) {
                            oooO0oO.OooO00o(i3, (BTPeripheral[]) null);
                        }
                    } else {
                        return;
                    }
                } else if (i2 == 80) {
                    OoooOOo.d("response: NOTIFY_AUTHORIZATION");
                    int state = ((NotifyAuthenticateState) obj).getState();
                    if (state != 0) {
                        if (state == 1) {
                            oooO0O0 = com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR;
                            i4 = ErrorCode.CAMERA_BLE_CONNECT_FAIL_FOR_AUTHORIZATION_UNAUTHORIZED;
                        } else if (state == 2) {
                            oooO0O0 = com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR;
                            i4 = ErrorCode.CAMERA_BLE_CONNECT_FAIL_FOR_AUTHORIZATION_BUSY;
                        }
                        OooO00o(oooO0O0, i4);
                    } else {
                        C0154OooOo0 oooOo0 = this.OoooO0O;
                        if (oooOo0 != null) {
                            oooOo0.OooO00o();
                        }
                    }
                    f fVar = this.OoooO0;
                    if (fVar != null) {
                        fVar.onCameraAuthorizationStateChanged(this.OooO00o, state);
                        return;
                    }
                    return;
                } else if (i2 != 81) {
                    switch (i2) {
                        case 8:
                            OoooOOo.d("response: RECORD_STOPPED");
                            NotificationCaptureStopped notificationCaptureStopped = (NotificationCaptureStopped) obj;
                            if (OooOo0() || OooOOOo() || OooOO0o() || OooOOo0() || OooOoO() || OooOo0o() || OooOoO0()) {
                                this.OooOooo = OooO00o(notificationCaptureStopped.mVideo.uri);
                                this.Oooo000 = Integer.valueOf(ErrorCode.CAMERA_RECORD_INNER_STOP);
                                OooOoOO();
                                return;
                            }
                            return;
                        case 17:
                            cameraLogger = OoooOOo;
                            str = "response: NOTIFICATION_BT_REMOTE_VER_UPDATED";
                            break;
                        case 53:
                            OoooOOo.d("response: SET_OPTIONS");
                            OooO0o oooO0o5 = (OooO0o) this.OooOO0.remove(Long.valueOf(((SetOptionsResp) obj).requestID));
                            if (oooO0o5 instanceof C0158OooOoO0) {
                                ((C0158OooOoO0) oooO0o5).OooO0o(i3);
                                return;
                            }
                            return;
                        case 54:
                            OoooOOo.d("response: GET_OPTIONS");
                            GetOptionsResp getOptionsResp = (GetOptionsResp) obj;
                            OooO0o oooO0o6 = (OooO0o) this.OooOO0.remove(Long.valueOf(getOptionsResp.requestID));
                            if (oooO0o6 instanceof C0151OooOOo) {
                                ((C0151OooOOo) oooO0o6).OooO00o(i3, getOptionsResp.result);
                                return;
                            }
                            return;
                        case 55:
                            OoooOOo.d("response: SET_PHOTOGRAPHY_OPTIONS");
                            OooO0o oooO0o7 = (OooO0o) this.OooOO0.remove(Long.valueOf(((SetPhotographyOptionsResp) obj).requestID));
                            if (oooO0o7 instanceof C0157OooOoO) {
                                ((C0157OooOoO) oooO0o7).OooO0Oo(i3);
                                return;
                            }
                            return;
                        case 56:
                            OoooOOo.d("response: GET_PHOTOGRAPHY_OPTIONS");
                            GetPhotographyOptionsResp getPhotographyOptionsResp = (GetPhotographyOptionsResp) obj;
                            OooO0o oooO0o8 = (OooO0o) this.OooOO0.remove(Long.valueOf(getPhotographyOptionsResp.requestID));
                            if (oooO0o8 instanceof C0153OooOOoo) {
                                ((C0153OooOOoo) oooO0o8).OooO00o(i3, getPhotographyOptionsResp.result);
                                return;
                            }
                            return;
                        case 57:
                            OoooOOo.d("response: GET_FILE_EXTRA");
                            GetFileExtraResp getFileExtraResp = (GetFileExtraResp) obj;
                            OooO0o oooO0o9 = (OooO0o) this.OooOO0.remove(Long.valueOf(getFileExtraResp.requestID));
                            if (oooO0o9 instanceof OooOOOO) {
                                ((OooOOOO) oooO0o9).OooO00o(i3, getFileExtraResp.extraData);
                                return;
                            }
                            return;
                        case 58:
                            OoooOOo.d("response: DELETE_FILES");
                            OooO0o oooO0o10 = (OooO0o) this.OooOO0.remove(Long.valueOf(((DeleteFilesResp) obj).requestID));
                            if (oooO0o10 instanceof OooOO0O) {
                                ((OooOO0O) oooO0o10).OooO0oO(i3);
                                return;
                            }
                            return;
                        case 59:
                            OoooOOo.d("response: GET_FILE_LIST");
                            GetFileListResp getFileListResp = (GetFileListResp) obj;
                            OooO0o oooO0o11 = (OooO0o) this.OooOO0.remove(Long.valueOf(getFileListResp.requestID));
                            if (oooO0o11 instanceof C0152OooOOo0) {
                                ((C0152OooOOo0) oooO0o11).OooO00o(i3, getFileListResp.mUriList);
                                return;
                            }
                            return;
                        case 60:
                            OoooOOo.d("response: SET_FILE_EXTRA");
                            OooO0o oooO0o12 = (OooO0o) this.OooOO0.remove(Long.valueOf(((SetFileExtraResp) obj).requestID));
                            if (oooO0o12 instanceof OooOo) {
                                ((OooOo) oooO0o12).OooO0O0(i3);
                                return;
                            }
                            return;
                        case 61:
                            OoooOOo.d("response: GET_TIMELAPSE_OPTIONS");
                            GetTimelapseOptionsResp getTimelapseOptionsResp = (GetTimelapseOptionsResp) obj;
                            OooO0o oooO0o13 = (OooO0o) this.OooOO0.remove(Long.valueOf(getTimelapseOptionsResp.requestID));
                            if (oooO0o13 instanceof OooOo00) {
                                ((OooOo00) oooO0o13).OooO00o(i3, getTimelapseOptionsResp.timelapse_options);
                                return;
                            }
                            return;
                        case 62:
                            OoooOOo.d("response: SET_TIMELAPSE_OPTIONS");
                            OooO0o oooO0o14 = (OooO0o) this.OooOO0.remove(Long.valueOf(((SetTimelapseOptionsResp) obj).requestID));
                            if (oooO0o14 instanceof C0161OooOoo0) {
                                ((C0161OooOoo0) oooO0o14).OooO0OO(i3);
                                return;
                            }
                            return;
                        case 95:
                            OoooOOo.d("response: SET_STANDBY_MODE");
                            SetStandbyResp setStandbyResp = (SetStandbyResp) obj;
                            OooO0o oooO0o15 = (OooO0o) this.OooOO0.remove(Long.valueOf(setStandbyResp.requestID));
                            if (oooO0o15 instanceof C0159OooOoOO) {
                                ((C0159OooOoOO) oooO0o15).OooO(setStandbyResp.errorCode);
                                return;
                            }
                            return;
                        case 96:
                            OoooOOo.d("response: CAM_TEMPERATURE_VALUE");
                            f fVar2 = this.OoooO0;
                            if (fVar2 != null) {
                                fVar2.onCameraTemperatureChanged(this.OooO00o);
                                return;
                            }
                            return;
                        default:
                            switch (i2) {
                                case 12:
                                    OoooOOo.d("response: BT_DISCOVER_PERIPHERAL");
                                    NotificatoinDiscoverBTPeripheral notificatoinDiscoverBTPeripheral = (NotificatoinDiscoverBTPeripheral) obj;
                                    C0147OooO0oO oooO0oO2 = this.OoooO00;
                                    if (oooO0oO2 != null) {
                                        oooO0oO2.OooO00o(i3, notificatoinDiscoverBTPeripheral.peripherals);
                                        break;
                                    }
                                    break;
                                case 13:
                                    OoooOOo.d("response: BT_CONNECTED_TO_PERIPHERAL");
                                    OooO00o(Arrays.asList(new String[]{OneDriverInfo.Options.BT_REMOTE_TYPE}), (C0151OooOOo) new r0(this, (NotificatoinConnectedToPeripheral) obj));
                                    handler = this.OooOOO;
                                    runnable = this.OoooOOO;
                                    break;
                                case 14:
                                    OoooOOo.d("response: BT_DISCONNECTED_PERIPHERAL");
                                    NotificatoinDisconnectedPeripheral notificatoinDisconnectedPeripheral = (NotificatoinDisconnectedPeripheral) obj;
                                    C0147OooO0oO oooO0oO3 = this.OoooO00;
                                    if (oooO0oO3 != null) {
                                        oooO0oO3.OooO00o(0, notificatoinDisconnectedPeripheral.peripheral);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i2) {
                                        case 76:
                                            OoooOOo.d("response: GET_FILEINFO_LIST");
                                            GetFileInfoListResp getFileInfoListResp = (GetFileInfoListResp) obj;
                                            OooO0o oooO0o16 = (OooO0o) this.OooOO0.remove(Long.valueOf(getFileInfoListResp.requestID));
                                            if (oooO0o16 instanceof C0150OooOOOo) {
                                                ((C0150OooOOOo) oooO0o16).OooO0O0(i3, getFileInfoListResp.mFileInfoList);
                                                return;
                                            }
                                            return;
                                        case 77:
                                            OoooOOo.d("response: CAMERA_STATUS_NOTIFY");
                                            CameraCaptureStatus cameraCaptureStatus = (CameraCaptureStatus) obj;
                                            if (cameraCaptureStatus.state != 8) {
                                                OooO00o(cameraCaptureStatus);
                                                return;
                                            } else if (OooOo0O()) {
                                                OooO00o((C0149OooOO0o) null);
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 78:
                                            OoooOOo.d("response: CHECK_AUTHORIZATION");
                                            CheckAuthorizationResp checkAuthorizationResp = (CheckAuthorizationResp) obj;
                                            OooO0o oooO0o17 = (OooO0o) this.OooOO0.remove(Long.valueOf(checkAuthorizationResp.getRequestID()));
                                            if (oooO0o17 instanceof OooO) {
                                                ((OooO) oooO0o17).OooO00o(i3, checkAuthorizationResp.getState());
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
                } else {
                    OoooOOo.d("response: NOTIFY_TIMELAPSE_STATUS_UPDATE");
                    NotifyTimelapseState notifyTimelapseState = (NotifyTimelapseState) obj;
                    if (OooOOo()) {
                        this.Oooo00O = notifyTimelapseState.getInterval_count();
                        Oooo000();
                        ICaptureStatusChangedListener iCaptureStatusChangedListener = this.Oooo0oo;
                        if (iCaptureStatusChangedListener != null) {
                            iCaptureStatusChangedListener.onCaptureCountChanged(this.Oooo00O);
                            return;
                        }
                        return;
                    }
                    return;
                }
                handler = this.OooOOO;
                runnable = this.o000oOoO;
                handler.removeCallbacks(runnable);
                return;
            } else {
                OoooOOo.d("response: GET_CURRENT_CAPTURE_STATUS");
                GetCurrentCaptureStatusResp getCurrentCaptureStatusResp = (GetCurrentCaptureStatusResp) obj;
                OooO0o oooO0o18 = (OooO0o) this.OooOO0.remove(Long.valueOf(getCurrentCaptureStatusResp.requestID));
                if (oooO0o18 instanceof OooOOO) {
                    ((OooOOO) oooO0o18).OooO00o(i3, getCurrentCaptureStatusResp.status);
                    return;
                }
                return;
            }
            cameraLogger.d(str);
        } else {
            OoooOOo.d("response: START_LIVE_STREAM");
            PreviewStatus previewStatus = this.OooOo0O;
            if (i3 != 0) {
                PreviewStatus previewStatus2 = PreviewStatus.IDLE;
                if (previewStatus != previewStatus2) {
                    this.OooOo0O = previewStatus2;
                    this.OooOo0o = null;
                    this.OooOo = null;
                    C0156OooOo0o oooOo0o = this.Oooo;
                    if (oooOo0o != null) {
                        oooOo0o.OooO00o(previewStatus2, i3);
                    }
                }
            } else if (previewStatus == PreviewStatus.OPENING) {
                PreviewStatus previewStatus3 = PreviewStatus.OPENED;
                this.OooOo0O = previewStatus3;
                C0156OooOo0o oooOo0o2 = this.Oooo;
                if (oooOo0o2 != null) {
                    oooOo0o2.OooO00o(previewStatus3, i3);
                }
            }
        }
    }

    public void OooO00o(int i2, C0149OooOO0o oooOO0o) {
        OooO00o(i2, (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) new e.b.c.a.a.a(oooOO0o));
    }

    public void OooO00o(int i2, OooOo00 oooOo00) {
        GetTimelapseOptions getTimelapseOptions = new GetTimelapseOptions();
        getTimelapseOptions.mode = i2;
        this.OooOO0.put(Long.valueOf(this.OooO0O0.getTimelapseOptionAsync(getTimelapseOptions)), new m(this, i2, oooOo00));
    }

    public void OooO00o(int i2, C0159OooOoOO oooOoOO) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setSyncStandByMode(i2)), new d1(oooOoOO));
        }
    }

    public void OooO00o(long j2, TimeZone timeZone) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Options options = new Options();
            options.setLocalTime(j2);
            options.setTimezoneSecodeFromGMT(timeZone.getRawOffset() / 1000);
            this.OooO0O0.setOptionAsync(options);
        }
    }

    public final void OooO00o(CaptureType captureType) {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyCaptureStarting, captureType: ");
        sb.append(captureType);
        cameraLogger.d(sb.toString());
        this.OooOoo0 = captureType;
        CaptureStatus captureStatus = CaptureStatus.STARTING;
        this.OooOoo = captureStatus;
        this.OooOooo = null;
        this.Oooo000 = null;
        ICaptureStatusChangedListener iCaptureStatusChangedListener = this.Oooo0oo;
        if (iCaptureStatusChangedListener != null) {
            iCaptureStatusChangedListener.onCaptureStatusChanged(captureType, captureStatus, null, null);
        }
    }

    public final void OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0 oooO0O0, int i2) {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("changeCameraSyncStatus, newCameraSyncStatus: [");
        sb.append(oooO0O0);
        sb.append("], oldCameraSyncStatus: [");
        sb.append(this.OooO0OO);
        sb.append("], connectType: [");
        sb.append(this.OooO0Oo);
        sb.append("]");
        cameraLogger.d(sb.toString());
        this.OooO0OO = oooO0O0;
        C0160OooOoo oooOoo = this.Oooo0oO;
        if (oooOoo != null) {
            oooOoo.OooO00o(oooO0O0, i2);
        }
    }

    public synchronized void OooO00o(OooOO0O oooOO0O, List<String> list) {
        if (!OooOo0O()) {
            oooOO0O.OooO0oO(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
            return;
        }
        DeleteFiles deleteFiles = new DeleteFiles();
        deleteFiles.mDeleteUris = list;
        this.OooOO0.put(Long.valueOf(this.OooO0O0.deleteFileList(deleteFiles)), oooOO0O);
    }

    public void OooO00o(C0149OooOO0o oooOO0o) {
    }

    public synchronized void OooO00o(C0150OooOOOo oooOOOo) {
        if (!OooOo0O()) {
            oooOOOo.OooO0O0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
        } else {
            this.OooOO0.put(Long.valueOf(this.OooO0O0.getFileInfoList()), oooOOOo);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        OooO00o(r3, (java.lang.Integer) null, (java.lang.Integer) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        OooO00o(r0, java.lang.Integer.valueOf(r3.capture_time * 1000), (java.lang.Integer) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OooO00o(com.arashivision.onecamera.cameraresponse.CameraCaptureStatus r3) {
        /*
            r2 = this;
            int r0 = r3.state
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0035;
                case 2: goto L_0x0032;
                case 3: goto L_0x0026;
                case 4: goto L_0x0020;
                case 5: goto L_0x001d;
                case 6: goto L_0x0006;
                case 7: goto L_0x001a;
                case 8: goto L_0x0006;
                case 9: goto L_0x0017;
                case 10: goto L_0x0014;
                case 11: goto L_0x0011;
                case 12: goto L_0x000e;
                case 13: goto L_0x000b;
                case 14: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x006f
        L_0x0008:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.NIGHT_SCENE
            goto L_0x0022
        L_0x000b:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.TIME_SHIFT
            goto L_0x0037
        L_0x000e:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.INTERVAL_RECORD
            goto L_0x0037
        L_0x0011:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.STATIC_TIMELAPSE
            goto L_0x0037
        L_0x0014:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.BURST
            goto L_0x0022
        L_0x0017:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.HDR_RECORD
            goto L_0x0037
        L_0x001a:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.BULLET_TIME
            goto L_0x0037
        L_0x001d:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.HDR_CAPTURE
            goto L_0x0022
        L_0x0020:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r3 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.NORMAL_CAPTURE
        L_0x0022:
            r2.OooO00o(r3, r1, r1)
            goto L_0x006f
        L_0x0026:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.INTERVAL_SHOOTING
            int r3 = r3.capture_time
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.OooO00o(r0, r1, r3)
            goto L_0x006f
        L_0x0032:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.TIMELAPSE
            goto L_0x0037
        L_0x0035:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureType r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType.NORMAL_RECORD
        L_0x0037:
            int r3 = r3.capture_time
            int r3 = r3 * 1000
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.OooO00o(r0, r3, r1)
            goto L_0x006f
        L_0x0043:
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus r3 = r2.OooOoo
            com.arashivision.insta360.basecamera.camera.BaseCamera$CaptureStatus r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus.IDLE
            if (r3 == r0) goto L_0x006f
            com.arashivision.insta360.basecamera.camera.BaseCamera$PreviewStatus r3 = r2.OooOo0O
            com.arashivision.insta360.basecamera.camera.BaseCamera$PreviewStatus r0 = com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus.OPENED
            if (r3 != r0) goto L_0x0068
            boolean r3 = r2.OooOo00()
            if (r3 != 0) goto L_0x006f
            boolean r3 = r2.OooOOOO()
            if (r3 != 0) goto L_0x006f
            boolean r3 = r2.OooOOoo()
            if (r3 != 0) goto L_0x006f
            boolean r3 = r2.OooOOO0()
            if (r3 == 0) goto L_0x0068
            goto L_0x006f
        L_0x0068:
            boolean r3 = r2.OooOooO
            if (r3 != 0) goto L_0x006f
            r2.OooOoOO()
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basecamera.camera.BaseCameraController.OooO00o(com.arashivision.onecamera.cameraresponse.CameraCaptureStatus):void");
    }

    public final synchronized void OooO00o(String str, int i2, long j2, long j3, OooOOOO oooOOOO) {
        if (!OooOo0O()) {
            oooOOOO.OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
            return;
        }
        GetFileExtra getFileExtra = new GetFileExtra();
        getFileExtra.uri = str;
        getFileExtra.extra_type = i2;
        getFileExtra.mGyroOptionIndexRange = new GyroOptionIndexRange();
        GyroOptionTimeRange gyroOptionTimeRange = new GyroOptionTimeRange();
        gyroOptionTimeRange.start = j2;
        gyroOptionTimeRange.duration = j3;
        getFileExtra.mGyroOptionTimeRange = gyroOptionTimeRange;
        this.OooOO0.put(Long.valueOf(this.OooO0O0.getFileExtra(getFileExtra)), oooOOOO);
    }

    public synchronized void OooO00o(String str, byte[] bArr, OooOo oooOo) {
        if (OooOo0O()) {
            SetFileExtra setFileExtra = new SetFileExtra();
            setFileExtra.data = bArr;
            setFileExtra.extra_type = 1;
            setFileExtra.uri = str;
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setFileExtra(setFileExtra)), oooOo);
        }
    }

    public void OooO00o(List<String> list, C0149OooOO0o oooOO0o) {
        if (list == null) {
            list = a.a.a.a.b.a.c();
        }
        OooO00o(list, (C0151OooOOo) new b1(oooOO0o));
    }

    public final String[] OooO00o(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "_00_";
        String str3 = "_10_";
        if (!str.contains("VID_") || !str.contains(str3)) {
            if (str.contains("LRV_")) {
                str = str.replace("LRV", "VID").replace("_01_", str2).replace("_11_", str3);
            }
            return new String[]{str};
        }
        return new String[]{str.replace(str3, str2), str};
    }

    public int OooO0O0(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getExposureBias();
    }

    public void OooO0O0() {
        OoooOOo.d("closePreviewStream");
        if (this.OooOo0O == PreviewStatus.IDLE) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder a2 = e.a.a.a.a.a("closePreviewStream, but status not match, SyncStatus: ");
            a2.append(this.OooO0OO);
            a2.append(", PreviewStatus: ");
            a2.append(this.OooOo0O);
            cameraLogger.w(a2.toString());
            return;
        }
        this.OooO0O0.closePreviewStream();
        PreviewStatus previewStatus = PreviewStatus.IDLE;
        this.OooOo0O = previewStatus;
        this.OooOo0o = null;
        this.OooOo = null;
        C0156OooOo0o oooOo0o = this.Oooo;
        if (oooOo0o != null) {
            oooOo0o.OooO00o(previewStatus, 0);
        }
    }

    public int OooO0OO(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getFlicker();
    }

    public void OooO0OO() {
        if (OooOo0O() && this.Oooo0O0) {
            boolean[] zArr = {false};
            Options options = this.Oooo0OO;
            if (options != null) {
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new t(this, zArr));
            }
            for (Integer num : this.Oooo0o0.keySet()) {
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(num.intValue(), (PhotoOptions) this.Oooo0o0.get(num))), new e(this, num, zArr));
            }
            for (Integer num2 : this.Oooo0o.keySet()) {
                TimelapseOptionsInfo timelapseOptionsInfo = (TimelapseOptionsInfo) this.Oooo0o.get(num2);
                SetTimelapseOptions setTimelapseOptions = new SetTimelapseOptions();
                setTimelapseOptions.mode = num2.intValue();
                setTimelapseOptions.timelapse_options = timelapseOptionsInfo;
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setTimelapseOptionsASync(setTimelapseOptions)), new u0(this, num2, zArr));
            }
            this.Oooo0O0 = false;
            this.Oooo0OO = null;
            this.Oooo0o0.clear();
            this.Oooo0o.clear();
        }
    }

    public synchronized void OooO0Oo() {
        OoooOOo.d("destroy");
        com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0 oooO0O0 = this.OooO0OO;
        if (oooO0O0 != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0 oooO0O02 = com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.CLOSING;
            if (oooO0O0 != oooO0O02) {
                this.OooOooO = false;
                OooO00o(oooO0O02, 0);
                this.OooO0O0.setPipeline(null);
                this.OooO0O0.removeCameraReocrdListener(this.OooO0o0);
                this.OooO0O0.removeStillImageListener(this.OooO0o);
                this.OooO0O0.removeTimelapseRecordListener(this.OooO0oO);
                if (oooO0O0 == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.AUTHORIZATION) {
                    this.OooO0O0.cancelAuthorization();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                OooO0O0();
                if (OooOOO()) {
                    OoooOOo.d("when destroy, camera is working, treat as finish directly");
                    OooOoOO();
                }
                for (OooO0o oooO0o : this.OooOO0.values()) {
                    if (oooO0o instanceof OooOOO) {
                        ((OooOOO) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof C0151OooOOo) {
                        ((C0151OooOOo) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof C0158OooOoO0) {
                        ((C0158OooOoO0) oooO0o).OooO0o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof C0153OooOOoo) {
                        ((C0153OooOOoo) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof C0157OooOoO) {
                        ((C0157OooOoO) oooO0o).OooO0Oo(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof OooOo00) {
                        ((OooOo00) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof C0161OooOoo0) {
                        ((C0161OooOoo0) oooO0o).OooO0OO(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof C0148OooO0oo) {
                        ((C0148OooO0oo) oooO0o).OooO0o0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof OooOOO0) {
                        ((OooOOO0) oooO0o).OooO0oo(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof C0152OooOOo0) {
                        ((C0152OooOOo0) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof C0150OooOOOo) {
                        ((C0150OooOOOo) oooO0o).OooO0O0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof OooOO0O) {
                        ((OooOO0O) oooO0o).OooO0oO(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof OooOOOO) {
                        ((OooOOOO) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, null);
                    }
                    if (oooO0o instanceof OooOo) {
                        ((OooOo) oooO0o).OooO0O0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof OooO) {
                        ((OooO) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION, -1);
                    }
                    if (oooO0o instanceof C0159OooOoOO) {
                        ((C0159OooOoOO) oooO0o).OooO(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof C0155OooOo0O) {
                        ((C0155OooOo0O) oooO0o).OooO00o(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                    if (oooO0o instanceof OooOO0) {
                        ((OooOO0) oooO0o).OooOO0(ErrorCode.CAMERA_DISCONNECT_DURING_OPERATION);
                    }
                }
                this.OooOO0.clear();
                this.OooOOO.removeCallbacks(this.o000oOoO);
                this.OooOOO.removeCallbacks(this.OoooOOO);
                if (this.OooOO0o != null) {
                    if (c.a.a.a.a.e.f1120b == null) {
                        c.a.a.a.a.e.f1120b = new c.a.a.a.a.e();
                    }
                    c.a.a.a.a.e eVar = c.a.a.a.a.e.f1120b;
                    String str = this.OooOO0o;
                    c.a.a.a.a.e.a aVar = (c.a.a.a.a.e.a) eVar.f1121a.get(str);
                    if (aVar != null) {
                        int i2 = aVar.f1122a - 1;
                        aVar.f1122a = i2;
                        if (i2 == 0) {
                            eVar.f1121a.remove(str);
                        }
                    }
                }
                OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE, 0);
                return;
            }
        }
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("destroy, but syncStatus has already been ");
        sb.append(this.OooO0OO);
        cameraLogger.d(sb.toString());
    }

    public int OooO0o(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getVideoISOTopLimit();
    }

    public String OooO0o() {
        return (String) OooO00o(OneDriverInfo.Options.MEDIA_OFFSET, (T) null);
    }

    public int OooO0o0(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getFovType();
    }

    public abstract GyroType OooO0o0();

    public boolean OooO0oO(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return false;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getLogModeEnable();
    }

    public boolean OooO0oo(int i2) {
        b bVar = this.OooOO0O;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        if (((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) != null && ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getRawCaptureType() == 1) {
            z = true;
        }
        return z;
    }

    public abstract int[] OooO0oo();

    public int OooOO0(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getPhotoSize();
    }

    public abstract int[] OooOO0();

    public int OooOO0O(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return 0;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getRecordDuration();
    }

    public c.a.a.a.a.a.a OooOO0O() {
        Integer valueOf = Integer.valueOf(0);
        return new c.a.a.a.a.a.a(((Integer) OooO00o(OneDriverInfo.Options.VIDEO_RESULUTION_FPS, (T) valueOf)).intValue(), ((Integer) OooO00o(OneDriverInfo.Options.VIDEO_RESULUTION_WIDTH, (T) valueOf)).intValue(), ((Integer) OooO00o(OneDriverInfo.Options.VIDEO_RESULUTION_HEIGHT, (T) valueOf)).intValue());
    }

    public boolean OooOO0o() {
        return OooOOO() && this.OooOoo0 == CaptureType.BULLET_TIME;
    }

    public boolean OooOO0o(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return false;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getPreviewSportModeModeEnable();
    }

    public final PhotoOptions OooOOO(int i2) {
        PhotoOptions photoOptions = (PhotoOptions) this.Oooo0o0.get(Integer.valueOf(i2));
        if (photoOptions != null) {
            return photoOptions;
        }
        PhotoOptions photoOptions2 = new PhotoOptions();
        this.Oooo0o0.put(Integer.valueOf(i2), photoOptions2);
        return photoOptions2;
    }

    public boolean OooOOO() {
        return this.OooOoo != CaptureStatus.IDLE;
    }

    public int OooOOO0(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getPreviewSportLevel();
    }

    public boolean OooOOO0() {
        return OooOOO() && this.OooOoo0 == CaptureType.BURST;
    }

    public int OooOOOO(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getVideoResolution();
    }

    public boolean OooOOOO() {
        return OooOOO() && this.OooOoo0 == CaptureType.HDR_CAPTURE;
    }

    public int OooOOOo(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getWhiteBalance();
    }

    public boolean OooOOOo() {
        return OooOOO() && this.OooOoo0 == CaptureType.HDR_RECORD;
    }

    public void OooOOo(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.BUTTON_PRESS_DOUBLE_CLICK;
            long intValue = (long) ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setDoubleint(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new t0(this, intValue));
        }
    }

    public boolean OooOOo() {
        return OooOOO() && this.OooOoo0 == CaptureType.INTERVAL_SHOOTING;
    }

    public void OooOOo0(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.BUTTON_PRESS_CLICK;
            long intValue = (long) ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setClickint(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new h0(this, intValue));
        }
    }

    public boolean OooOOo0() {
        return OooOOO() && this.OooOoo0 == CaptureType.INTERVAL_RECORD;
    }

    public void OooOOoo(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.BUTTON_PRESS_SHUTDOWN_CLICK;
            long intValue = (long) ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setShutdownClickint(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new n(this, intValue));
        }
    }

    public boolean OooOOoo() {
        return OooOOO() && this.OooOoo0 == CaptureType.NIGHT_SCENE;
    }

    public abstract boolean OooOo();

    public void OooOo0(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.PHOTO_SUB_MODE;
            int intValue = ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setSubPhotoMode(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new p0(this, intValue));
        }
    }

    public boolean OooOo0() {
        return OooOOO() && this.OooOoo0 == CaptureType.NORMAL_RECORD;
    }

    public void OooOo00(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.BUTTON_PRESS_TRIPLE_CLICK;
            long intValue = (long) ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setTripleint(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new q0(this, intValue));
        }
    }

    public boolean OooOo00() {
        return OooOOO() && this.OooOoo0 == CaptureType.NORMAL_CAPTURE;
    }

    public void OooOo0O(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.VIDEO_SUB_MODE;
            int intValue = ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setSubVideoMode(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new s0(this, intValue));
        }
    }

    public boolean OooOo0O() {
        return this.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.READY;
    }

    public void OooOo0o(int i2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Integer valueOf = Integer.valueOf(-1);
            String str = OneDriverInfo.Options.VIDEO_ENCODE_TYPE;
            int intValue = ((Integer) OooO00o(str, (T) valueOf)).intValue();
            this.OooOO0O.f1125a.put(str, Integer.valueOf(i2));
            Options options = new Options();
            options.setVideoEncodeType(i2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new w0(this, intValue));
        }
    }

    public boolean OooOo0o() {
        return OooOOO() && this.OooOoo0 == CaptureType.STATIC_TIMELAPSE;
    }

    public boolean OooOoO() {
        return OooOOO() && this.OooOoo0 == CaptureType.TIMELAPSE;
    }

    public boolean OooOoO0() {
        return OooOOO() && this.OooOoo0 == CaptureType.TIME_SHIFT;
    }

    public final void OooOoOO() {
        this.OooOooO = false;
        if (this.OooOoo == CaptureStatus.IDLE) {
            OoooOOo.w("notifyCaptureFinish, but is already idle");
            return;
        }
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder a2 = e.a.a.a.a.a("notifyCaptureFinish, captureType: ");
        a2.append(this.OooOoo0);
        cameraLogger.d(a2.toString());
        CaptureStatus captureStatus = this.OooOoo;
        CaptureStatus captureStatus2 = CaptureStatus.IDLE;
        if (captureStatus != captureStatus2) {
            this.OooOoo = captureStatus2;
            ICaptureStatusChangedListener iCaptureStatusChangedListener = this.Oooo0oo;
            if (iCaptureStatusChangedListener != null) {
                iCaptureStatusChangedListener.onCaptureStatusChanged(this.OooOoo0, captureStatus2, this.OooOooo, this.Oooo000);
            }
        }
        this.OooOoo0 = CaptureType.IDLE;
        this.OooOooo = null;
        this.Oooo000 = null;
        this.Oooo00o = 0;
        this.Oooo00O = 0;
        this.OooOOO.removeCallbacks(this.OoooOO0);
        this.Oooo0 = -1;
        f fVar = this.OoooO0;
        if (fVar != null) {
            fVar.onCameraCaptureFinish(this.OooO00o, this.OooOoo0);
        }
        Oooo000();
    }

    public void OooOoo() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new String[]{OneDriverInfo.Options.BATTERY_LEVEL, OneDriverInfo.Options.BATTERY_POWER_TYPE, OneDriverInfo.Options.BATTERY_SCALE});
        OooO00o((List<String>) arrayList, (C0151OooOOo) new y0(this));
    }

    public final void OooOoo0() {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder a2 = e.a.a.a.a.a("notifyCaptureStopping, captureType: ");
        a2.append(this.OooOoo0);
        cameraLogger.d(a2.toString());
        this.OooOoo = CaptureStatus.STOPPING;
        this.OooOOO.removeCallbacks(this.OoooOO0);
        this.Oooo0 = -1;
        ICaptureStatusChangedListener iCaptureStatusChangedListener = this.Oooo0oo;
        if (iCaptureStatusChangedListener != null) {
            iCaptureStatusChangedListener.onCaptureStatusChanged(this.OooOoo0, this.OooOoo, null, null);
        }
    }

    public void OooOooO() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new String[]{OneDriverInfo.Options.BATTERY_LEVEL, OneDriverInfo.Options.BATTERY_POWER_TYPE, OneDriverInfo.Options.BATTERY_SCALE});
        OooO00o((List<String>) arrayList, (C0151OooOOo) new k0(this));
    }

    public abstract void OooOooo();

    public void Oooo000() {
        if (OooOo0O()) {
            HashMap<String, Object> hashMap = this.OooOO0O.f1125a;
            String str = OneDriverInfo.Options.STORAGE_CARD_STATE;
            if (hashMap.get(str) != null) {
                OooO00o(Arrays.asList(new String[]{OneDriverInfo.Options.STORAGE_TOTAL_SPACE, OneDriverInfo.Options.STORAGE_FREE_SPACE, str}), (C0151OooOOo) new j(this, ((Integer) this.OooOO0O.f1125a.get(str)).intValue()));
            }
        }
    }

    public CaptureStatus getCaptureStatus() {
        return this.OooOoo;
    }

    public StreamResolution getCurSecondStreamResolution() {
        return this.OooOo;
    }

    /* renamed from: onCheckFail */
    public void OooOo(int i2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            OoooOOo.d("onCheckFail, but is not main thread, post to main thread");
            this.OooOOO.post(new o(this, i2));
            return;
        }
        OoooOOo.d("onCheckFail");
        OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, i2);
    }

    /* renamed from: onCheckSuccess */
    public void Oooo0() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            OoooOOo.d("onCheckSuccess, but is not main thread, post to main thread");
            this.OooOOO.post(new l(this));
            return;
        }
        OoooOOo.d("onCheckSuccess");
        OooO00o();
    }

    public void resetRecord() {
        this.OooO0O0.resetRecord();
    }

    public void setBaseCameraChangedCallback(f fVar) {
        this.OoooO0 = fVar;
    }

    public void setCameraLiveListener(ICameraLiveStateListener iCameraLiveStateListener, InfoUpdateListener infoUpdateListener) {
        this.OooO0oo = iCameraLiveStateListener;
        this.OooO = infoUpdateListener;
    }

    public void stopLive() {
        this.OooO0O0.stopLive();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0o(int i2, int i3, int i4) {
        if (i4 != 0) {
            e.a.a.a.a.a("setWhiteBalance fail, errorCode: ", i4, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setWhiteBalance(i3);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0o0(long j2, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setBtnTripleClickMode failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.BUTTON_PRESS_TRIPLE_CLICK, Long.valueOf(j2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooOO0o(int i2, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setSubPhotoMode failed, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.PHOTO_SUB_MODE, Integer.valueOf(i2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooOOO0(int i2, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setSubVideoMode failed, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.VIDEO_SUB_MODE, Integer.valueOf(i2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooOOOO(int i2, int i3) {
        if (this.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.AUTHORIZATION) {
            if (i2 != 0) {
                CameraLogger cameraLogger = OoooOOo;
                StringBuilder sb = new StringBuilder();
                sb.append("checkAuthorization error, errorCode: ");
                sb.append(i2);
                cameraLogger.e(sb.toString());
                OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, 0);
            } else if (i3 == 0) {
                C0154OooOo0 oooOo0 = this.OoooO0O;
                if (oooOo0 != null) {
                    oooOo0.OooO00o();
                }
            } else if (i3 == 1) {
                f fVar = this.OoooO0;
                if (fVar != null) {
                    fVar.onCameraAuthorizationStateChanged(this.OooO00o, i3);
                }
            } else if (i3 == 2) {
                OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, (int) ErrorCode.CAMERA_BLE_CONNECT_FAIL_FOR_AUTHORIZATION_BUSY);
            }
        }
    }

    public void OooO(int i2, int i3) {
        if (OooOo0O()) {
            int OooOOO02 = OooOOO0(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setPreviewSportLevel(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setPreviewSportLevel(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setPreviewSportLevel(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new h(this, i2, OooOOO02));
            }
        }
    }

    public int OooO0O0(int i2, boolean z) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return 0;
        }
        if (z) {
            return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getVideoExposureOptionISO();
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getStillExposureOptionISO();
    }

    public double OooO0OO(int i2, boolean z) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return 0.0d;
        }
        if (z) {
            return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getVideoExposureOptionShutter();
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getStillExposureOptionShutter();
    }

    public int OooO0oO() {
        b bVar = this.OooOO0O;
        if (bVar == null) {
            return -1;
        }
        HashMap<String, Object> hashMap = bVar.f1125a;
        String str = OneDriverInfo.Options.STORAGE_CARD_STATE;
        if (hashMap.get(str) != null) {
            return ((Integer) this.OooOO0O.f1125a.get(str)).intValue();
        }
        return -1;
    }

    public void OooO0oo(int i2, int i3) {
        if (OooOo0O()) {
            Integer valueOf = Integer.valueOf(OooOO0O(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setRecordDuration(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setRecordDuration(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setRecordDuration(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new m0(this, i2, valueOf));
            }
        }
    }

    public void OooOO0(int i2, int i3) {
        if (OooOo0O()) {
            int OooOOOO2 = OooOOOO(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setVideoResolution(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setVideoResolution(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setVideoResolution(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new j0(this, i2, OooOOOO2));
            }
        }
    }

    public void OooOO0O(int i2, int i3) {
        if (OooOo0O()) {
            int OooOOOo2 = OooOOOo(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setWhiteBalance(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setWhiteBalance(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setWhiteBalance(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new o0(this, i2, OooOOOo2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0o0(int i2, Integer num, int i3) {
        if (i3 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setRecordDuration fail, errorCode: ");
            sb.append(i3);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setRecordDuration(num.intValue());
            }
        }
    }

    public void OooO0o(int i2, int i3) {
        if (OooOo0O()) {
            OooO(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setPhotoSelfTimer(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setPhotoSelfTimer(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setPhotoSelfTimer(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new f0(this, i2, i3));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0o0(int i2, int i3, int i4) {
        if (i4 != 0) {
            e.a.a.a.a.a("setVideoResolutionId fail, errorCode: ", i4, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setVideoResolution(i3);
            }
        }
    }

    public void OooO0o(int i2, boolean z) {
        if (OooOo0O()) {
            Boolean valueOf = Boolean.valueOf(OooO0oo(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setRawCaptureType(z ? 1 : 0);
            if (this.Oooo0O0) {
                OooOOO(i2).setRawCaptureType(z);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setRawCaptureType(z);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new y(this, i2, valueOf));
            }
        }
    }

    public void OooO0oO(int i2, int i3) {
        if (OooOo0O()) {
            Integer valueOf = Integer.valueOf(OooOO0(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setPhotoSize(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setPhotoSize(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setPhotoSize(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new q(this, i2, valueOf));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(long j2, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setBtnClickMode failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.BUTTON_PRESS_CLICK, Long.valueOf(j2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0OO(long j2, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setBtnDoubleClickMode failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.BUTTON_PRESS_DOUBLE_CLICK, Long.valueOf(j2));
            }
        }
    }

    public boolean OooO0Oo(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return false;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getFlowStateEnable();
    }

    public void OooO0o0(int i2, int i3) {
        if (OooOo0O()) {
            Integer valueOf = Integer.valueOf(OooO0o(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setVideoISOTopLimit(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setVideoISOTopLimit(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setVideoISOTopLimit(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new z0(this, i2, valueOf));
            }
        }
    }

    public void OooO0oO(int i2, boolean z) {
        if (OooOo0O()) {
            Boolean valueOf = Boolean.valueOf(OooOO0o(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setPreviewSportModeModeEnable(z);
            if (this.Oooo0O0) {
                OooOOO(i2).setPreviewSportModeModeEnable(z);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setPreviewSportModeModeEnable(z);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new c0(this, i2, valueOf));
            }
        }
    }

    public final void OooO00o(C0154OooOo0 oooOo0) {
        if (this.OooOOOO && this.OooOOOo && this.OooOOo0 && this.OooOOo) {
            oooOo0.OooO00o();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(int i2, Integer num, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setExposureEV fail, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setExposureBias(num.intValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0OO(int i2, Integer num, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setISOTopLimit fail, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setVideoISOTopLimit(num.intValue());
            }
        }
    }

    public void OooO0o0(int i2, boolean z) {
        if (OooOo0O()) {
            Boolean valueOf = Boolean.valueOf(OooO0oO(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setLogModeEnable(z);
            if (this.Oooo0O0) {
                OooOOO(i2).setLogModeEnable(z);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setLogModeEnable(z);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new s(this, i2, valueOf));
            }
        }
    }

    public int OooO00o(int i2) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getAEBCaptureNum();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(int i2, int i3, int i4) {
        if (i4 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setFovType fail, errorCode: ");
            sb.append(i4);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setFovType(i3);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0OO(String str, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setOriginalOffset failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.ORIGIN_OFFSET, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0Oo(long j2, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setBtnShutdownClickMode failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.BUTTON_PRESS_SHUTDOWN_CLICK, Long.valueOf(j2));
            }
        }
    }

    public void OooO0o0(String str) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            String str2 = "serial_number";
            String str3 = (String) OooO00o(str2, (T) "");
            this.OooOO0O.f1125a.put(str2, str);
            Options options = new Options();
            options.setSN(str);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new l0(this, str3));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(String str, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setMediaOffset failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.MEDIA_OFFSET, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0OO(int i2, int i3, int i4) {
        if (i4 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setPhotoSelfTimer fail, errorCode: ");
            sb.append(i4);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setPhotoSelfTimer(i3);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0Oo(int i2, Integer num, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setPhotoSize fail, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setPhotoSize(num.intValue());
            }
        }
    }

    public int OooO00o(int i2, boolean z) {
        b bVar = this.OooOO0O;
        if (bVar == null || ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))) == null) {
            return -1;
        }
        if (z) {
            return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getVideoExposureOptionProgram();
        }
        return ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).getStillExposureOptionProgram();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0O0(int i2, Boolean bool, int i3) {
        if (i3 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setPluginCaptureRaw fail, errorCode: ");
            sb.append(i3);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setRawCaptureType(bool.booleanValue() ? 1 : 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0OO(int i2, Boolean bool, int i3) {
        if (i3 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setSportModeEnable fail, errorCode: ");
            sb.append(i3);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setPreviewSportModeModeEnable(bool.booleanValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0Oo(String str, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setSerial failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put("serial_number", str);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0OO(int i2, Options options) {
        if (this.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.GET_SN) {
            if (i2 != 0) {
                OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, 0);
                return;
            }
            this.OooOO0o = options.getSN();
            if (c.a.a.a.a.e.f1120b == null) {
                c.a.a.a.a.e.f1120b = new c.a.a.a.a.e();
            }
            c.a.a.a.a.e eVar = c.a.a.a.a.e.f1120b;
            c.a.a.a.a.e.a aVar = (c.a.a.a.a.e.a) eVar.f1121a.get(this.OooOO0o);
            if (aVar == null) {
                aVar = new c.a.a.a.a.e.a();
            }
            aVar.f1122a++;
            b bVar = aVar.f1123b;
            this.OooOO0O = bVar;
            a.a.a.a.b.a.a(bVar.f1125a, options, OneDriverInfo.Options.FIRMWAREREVISION);
            OooOooo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO0Oo(int i2, int i3, int i4) {
        if (i4 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setSportModeLevel fail, errorCode: ");
            sb.append(i4);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setPreviewSportLevel(i3);
            }
        }
    }

    public void OooO0O0(String str) {
        if (OooOo0O()) {
            String str2 = OneDriverInfo.Options.BT_REMOTE_VERSION;
            String str3 = (String) OooO00o(str2, (T) null);
            this.OooOO0O.f1125a.put(str2, str);
            Options options = new Options();
            options.setRemoteVersion(str);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new r(this, str3));
        }
    }

    public void OooO0Oo(int i2, boolean z) {
        if (OooOo0O()) {
            boolean OooO0Oo2 = OooO0Oo(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setFlowStateEnable(z);
            if (this.Oooo0O0) {
                OooOOO(i2).setFlowStateEnable(z);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setFlowStateEnable(z);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new v0(this, i2, OooO0Oo2));
            }
        }
    }

    public final <T> T OooO00o(String str, T t) {
        b bVar = this.OooOO0O;
        if (bVar == null) {
            return t;
        }
        HashMap<String, Object> hashMap = bVar.f1125a;
        return hashMap.get(str) != null ? hashMap.get(str) : t;
    }

    public void OooO0O0(int i2, int i3) {
        if (OooOo0O()) {
            Integer valueOf = Integer.valueOf(OooO0O0(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setExposureBias(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setExposureBias(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setExposureBias(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new g0(this, i2, valueOf));
            }
        }
    }

    public void OooO0Oo(int i2, int i3) {
        if (OooOo0O()) {
            int OooO0o02 = OooO0o0(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setFovType(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setFovType(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setFovType(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new e0(this, i2, OooO0o02));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, Integer num, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setAEBCaptureNum fail, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setAEBCaptureNum(num.intValue());
            }
        }
    }

    public void OooO0O0(C0154OooOo0 oooOo0) {
        OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.CHECKING, 0);
        this.OoooO = oooOo0;
        this.OooOo0 = -1;
        OooO00o();
    }

    public void OooO0Oo(String str) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            String str2 = OneDriverInfo.Options.ORIGIN_OFFSET;
            String str3 = (String) OooO00o(str2, (T) null);
            this.OooOO0O.f1125a.put(str2, str);
            Options options = new Options();
            options.setOriginOffset(str);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new e.b.c.a.a.f(this, str3));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(long j2, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setActiveTime failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.ACTIVATE_TIME, Long.valueOf(j2));
            }
        }
    }

    public final void OooO0O0(boolean z) {
        this.OooOOoo = z;
        this.OooOOO0 = this.OooO0Oo == ConnectType.USB ? this.OooO0O0.getPort() : 80;
        this.OooOO0.put(Long.valueOf(this.OooO0O0.getOptionsSync(Arrays.asList(new String[]{"serial_number", OneDriverInfo.Options.FIRMWAREREVISION}))), new b0(this));
        OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.GET_SN, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(String str, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setBleRemoteVersion failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.BT_REMOTE_VERSION, str);
            }
        }
    }

    public void OooO0Oo(C0154OooOo0 oooOo0) {
        OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.SYNCING_OPTIONS, 0);
        this.OooOOOO = false;
        this.OooOOOo = false;
        this.OooOOo0 = false;
        this.OooOOo = false;
        List OooO2 = OooO();
        int[] OooO0oo2 = OooO0oo();
        int[] OooOO02 = OooOO0();
        if (!OooO2.isEmpty()) {
            OooO00o((List<String>) a.a.a.a.b.a.c(), (C0151OooOOo) new x0(this, oooOo0));
        } else {
            this.OooOOOO = true;
        }
        if (OooO0oo2.length != 0) {
            int[] iArr = {0};
            OooO00o(OooO0oo2[iArr[0]], (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) new OooO00o(iArr, OooO0oo2, oooOo0));
        } else {
            this.OooOOOo = true;
        }
        if (OooOO02.length != 0) {
            int[] iArr2 = {0};
            OooO00o(OooOO02[iArr2[0]], (OooOo00) new OooO0O0(iArr2, OooOO02, oooOo0));
        } else {
            this.OooOOo0 = true;
        }
        this.OooOO0.put(Long.valueOf(this.OooO0O0.getCaptureStatus()), new n0(this, oooOo0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(boolean z, int i2, int i3, int i4, double d2, int i5) {
        if (i5 != 0) {
            e.a.a.a.a.a("setExposureOptions fail, errorCode: ", i5, OoooOOo);
            if (z) {
                ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setVideoExposureOption(i3, i4, d2);
                return;
            }
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setVideoExposureOption(i3, i4, d2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setStillExposureOption(i3, i4, d2);
        }
    }

    public void OooO0OO(int i2, int i3) {
        if (OooOo0O()) {
            int OooO0OO2 = OooO0OO(i2);
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setFlicker(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setFlicker(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setFlicker(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new x(this, i2, OooO0OO2));
            }
        }
    }

    public void OooO0OO(String str) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            String OooO0o2 = OooO0o();
            this.OooOO0O.f1125a.put(OneDriverInfo.Options.MEDIA_OFFSET, str);
            Options options = new Options();
            options.setMediaOffset(str);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new v(this, OooO0o2));
        }
    }

    public void OooO0OO(C0154OooOo0 oooOo0) {
        String str;
        OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.AUTHORIZATION, 0);
        this.OoooO0O = oooOo0;
        k kVar = new k(this);
        CheckAuthorization checkAuthorization = new CheckAuthorization();
        StringBuilder a2 = e.a.a.a.a.a("35");
        a2.append(Build.BOARD.length() % 10);
        a2.append(Build.BRAND.length() % 10);
        a2.append(Build.CPU_ABI.length() % 10);
        a2.append(Build.DEVICE.length() % 10);
        a2.append(Build.DISPLAY.length() % 10);
        a2.append(Build.HOST.length() % 10);
        a2.append(Build.ID.length() % 10);
        a2.append(Build.MANUFACTURER.length() % 10);
        a2.append(Build.MODEL.length() % 10);
        a2.append(Build.PRODUCT.length() % 10);
        a2.append(Build.TAGS.length() % 10);
        a2.append(Build.TYPE.length() % 10);
        a2.append(Build.USER.length() % 10);
        String sb = a2.toString();
        try {
            str = new UUID((long) sb.hashCode(), (long) Build.SERIAL.hashCode()).toString();
        } catch (Exception unused) {
            str = new UUID((long) sb.hashCode(), (long) -905839116).toString();
        }
        checkAuthorization.uniqueId = str;
        this.OooOO0.put(Long.valueOf(this.OooO0O0.checkAuthorization(checkAuthorization)), kVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, int i3, int i4) {
        if (i4 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setFlicker fail, errorCode: ");
            sb.append(i4);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setFlicker(i3);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, boolean z, int i3) {
        if (i3 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setFlowstateEnable fail, errorCode: ");
            sb.append(i3);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setFlowStateEnable(z);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, Boolean bool, int i3) {
        if (i3 != 0) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder sb = new StringBuilder();
            sb.append("setPluginRecordLog fail, errorCode: ");
            sb.append(i3);
            cameraLogger.e(sb.toString());
            b bVar = this.OooOO0O;
            if (bVar != null) {
                ((PhotoOptions) bVar.f1126b.get(Integer.valueOf(i2))).setLogModeEnable(bool.booleanValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(boolean z, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setMute failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.MUTE, Boolean.valueOf(z));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo, int i3) {
        if (i3 != 0) {
            e.a.a.a.a.a("setTimelapseParams fail, errorCode: ", i3, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1127c.put(Integer.valueOf(i2), timelapseOptionsInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(c.a.a.a.a.a.a aVar, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setVideoResolution failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.VIDEO_RESULUTION_FPS, Integer.valueOf(aVar.f1114a));
                this.OooOO0O.f1125a.put(OneDriverInfo.Options.VIDEO_RESULUTION_WIDTH, Integer.valueOf(aVar.f1115b));
                this.OooOO0O.f1125a.put(OneDriverInfo.Options.VIDEO_RESULUTION_HEIGHT, Integer.valueOf(aVar.f1116c));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(String str, C0158OooOoO0 oooOoO0, int i2) {
        if (i2 != 0) {
            e.a.a.a.a.a("setWifiChannelCountry failed, errorCode: ", i2, OoooOOo);
            b bVar = this.OooOO0O;
            if (bVar != null) {
                bVar.f1125a.put(OneDriverInfo.Options.WIFI_CH_COUNTY, str);
            }
        }
        if (oooOoO0 != null) {
            oooOoO0.OooO0o(i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(C0154OooOo0 oooOo0, int i2, Options options) {
        if (this.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.SYNCING_OPTIONS) {
            if (i2 == 0) {
                this.OooOOOO = true;
                OooO00o(oooOo0);
            } else {
                OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(C0154OooOo0 oooOo0, int i2, CameraCaptureStatus cameraCaptureStatus) {
        if (this.OooO0OO == com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.SYNCING_OPTIONS) {
            if (i2 == 0) {
                OooO00o(cameraCaptureStatus);
                this.OooOOo = true;
                OooO00o(oooOo0);
            } else {
                OooO00o(com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.ERROR, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(int i2, OooOo00 oooOo00, int i3, TimelapseOptionsInfo timelapseOptionsInfo) {
        CameraLogger cameraLogger = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("syncTimelapseOptions, errorCode: ");
        sb.append(i3);
        cameraLogger.d(sb.toString());
        if (i3 == 0) {
            this.OooOO0O.f1127c.put(Integer.valueOf(i2), timelapseOptionsInfo);
        }
        if (oooOo00 != null) {
            oooOo00.OooO00o(i3, timelapseOptionsInfo);
        }
    }

    public final void OooO00o(CaptureType captureType, Integer num, Integer num2) {
        if (this.OooOoo == CaptureStatus.WORKING) {
            CameraLogger cameraLogger = OoooOOo;
            StringBuilder a2 = e.a.a.a.a.a("notifyCaptureWorking, but is already working. curCaptureType: ");
            a2.append(this.OooOoo0);
            a2.append(", newCaptureType: ");
            a2.append(captureType);
            cameraLogger.w(a2.toString());
            return;
        }
        CameraLogger cameraLogger2 = OoooOOo;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyCaptureWorking, captureType: ");
        sb.append(captureType);
        cameraLogger2.d(sb.toString());
        this.OooOoo0 = captureType;
        this.OooOoo = CaptureStatus.WORKING;
        if (num != null) {
            this.Oooo00o = (long) num.intValue();
            this.Oooo0 = System.currentTimeMillis();
            this.OooOOO.postDelayed(this.OoooOO0, 50);
        } else {
            this.Oooo00o = 0;
        }
        this.Oooo00O = num2 != null ? num2.intValue() : 0;
        ICaptureStatusChangedListener iCaptureStatusChangedListener = this.Oooo0oo;
        if (iCaptureStatusChangedListener != null) {
            iCaptureStatusChangedListener.onCaptureStatusChanged(this.OooOoo0, this.OooOoo, null, null);
        }
    }

    public void OooO00o(int i2, int i3) {
        if (OooOo0O()) {
            Integer valueOf = Integer.valueOf(OooO00o(i2));
            ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setAEBCaptureNum(i3);
            if (this.Oooo0O0) {
                OooOOO(i2).setAEBCaptureNum(i3);
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setAEBCaptureNum(i3);
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions)), new a0(this, i2, valueOf));
            }
        }
    }

    public synchronized void OooO00o(long j2) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            long longValue = ((Long) OooO00o(OneDriverInfo.Options.ACTIVATE_TIME, (T) Long.valueOf(-1))).longValue();
            this.OooOO0O.f1125a.put(OneDriverInfo.Options.ACTIVATE_TIME, Long.valueOf(j2));
            Options options = new Options();
            options.setActiveTime(j2);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new i0(this, longValue));
        }
    }

    public void OooO00o(int i2, int i3, int i4, double d2, boolean z) {
        if (OooOo0O()) {
            int OooO00o2 = OooO00o(i2, z);
            int OooO0O02 = OooO0O0(i2, z);
            double OooO0OO2 = OooO0OO(i2, z);
            if (z) {
                ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setVideoExposureOption(i3, i4, d2);
            } else {
                ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setVideoExposureOption(i3, i4, d2);
                ((PhotoOptions) this.OooOO0O.f1126b.get(Integer.valueOf(i2))).setStillExposureOption(i3, i4, d2);
            }
            if (this.Oooo0O0) {
                PhotoOptions OooOOO2 = OooOOO(i2);
                OooOOO2.setVideoExposureOption(i3, i4, d2);
                if (!z) {
                    OooOOO2.setStillExposureOption(i3, i4, d2);
                }
            } else {
                PhotoOptions photoOptions = new PhotoOptions();
                photoOptions.setVideoExposureOption(i3, i4, d2);
                if (!z) {
                    photoOptions.setStillExposureOption(i3, i4, d2);
                }
                HashMap<Long, OooO0o> hashMap = this.OooOO0;
                Long valueOf = Long.valueOf(this.OooO0O0.setPhotoOptionsSync(i2, photoOptions));
                d0 d0Var = new d0(this, z, i2, OooO00o2, OooO0O02, OooO0OO2);
                hashMap.put(valueOf, d0Var);
            }
        }
    }

    public void OooO00o(boolean z) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            Boolean valueOf = Boolean.valueOf(false);
            String str = OneDriverInfo.Options.MUTE;
            boolean booleanValue = ((Boolean) OooO00o(str, (T) valueOf)).booleanValue();
            this.OooOO0O.f1125a.put(str, Boolean.valueOf(z));
            Options options = new Options();
            options.setMute(z);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new w(this, booleanValue));
        }
    }

    public void OooO00o(int i2, TimelapseParams timelapseParams) {
        b bVar = this.OooOO0O;
        if (bVar != null) {
            if (this.Oooo0O0) {
                TimelapseOptionsInfo timelapseOptionsInfo = (TimelapseOptionsInfo) this.Oooo0o.get(Integer.valueOf(i2));
                if (timelapseOptionsInfo == null) {
                    timelapseOptionsInfo = new TimelapseOptionsInfo();
                    this.Oooo0o.put(Integer.valueOf(i2), timelapseOptionsInfo);
                }
                timelapseOptionsInfo.accelerateFequency = timelapseParams.mAccelerateFequency;
                timelapseOptionsInfo.durationS = timelapseParams.mDurationS;
                timelapseOptionsInfo.lapseTimeMs = timelapseParams.mIntervalMs;
                this.OooOO0O.f1127c.put(Integer.valueOf(i2), timelapseOptionsInfo);
            } else {
                TimelapseOptionsInfo timelapseOptionsInfo2 = (TimelapseOptionsInfo) bVar.f1127c.get(Integer.valueOf(i2));
                TimelapseOptionsInfo timelapseOptionsInfo3 = new TimelapseOptionsInfo();
                timelapseOptionsInfo3.accelerateFequency = timelapseParams.mAccelerateFequency;
                timelapseOptionsInfo3.durationS = timelapseParams.mDurationS;
                timelapseOptionsInfo3.lapseTimeMs = timelapseParams.mIntervalMs;
                this.OooOO0O.f1127c.put(Integer.valueOf(i2), timelapseOptionsInfo3);
                SetTimelapseOptions setTimelapseOptions = new SetTimelapseOptions();
                setTimelapseOptions.mode = i2;
                setTimelapseOptions.timelapse_options = timelapseOptionsInfo3;
                this.OooOO0.put(Long.valueOf(this.OooO0O0.setTimelapseOptionsASync(setTimelapseOptions)), new z(this, i2, timelapseOptionsInfo2));
            }
        }
    }

    public void OooO00o(c.a.a.a.a.a.a aVar) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            c.a.a.a.a.a.a OooOO0O2 = OooOO0O();
            this.OooOO0O.f1125a.put(OneDriverInfo.Options.VIDEO_RESULUTION_FPS, Integer.valueOf(aVar.f1114a));
            this.OooOO0O.f1125a.put(OneDriverInfo.Options.VIDEO_RESULUTION_WIDTH, Integer.valueOf(aVar.f1115b));
            this.OooOO0O.f1125a.put(OneDriverInfo.Options.VIDEO_RESULUTION_HEIGHT, Integer.valueOf(aVar.f1116c));
            Options options = new Options();
            options.setVideoResolution(aVar.f1114a, aVar.f1115b, aVar.f1116c);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new i(this, OooOO0O2));
        }
    }

    public void OooO00o(String str, C0158OooOoO0 oooOoO0) {
        if (this.OooO0OO != com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0.IDLE) {
            String str2 = OneDriverInfo.Options.WIFI_CH_COUNTY;
            String str3 = (String) OooO00o(str2, (T) "");
            this.OooOO0O.f1125a.put(str2, str);
            Options options = new Options();
            options.setWifiChannelCounty(str);
            this.OooOO0.put(Long.valueOf(this.OooO0O0.setOptionAsync(options)), new p(this, str3, oooOoO0));
        }
    }

    public void OooO00o(List<String> list, C0151OooOOo oooOOo) {
        int i2 = this.OooO0Oo == ConnectType.BLE ? 20 : Integer.MAX_VALUE;
        int[] iArr = {0, Math.min(i2, list.size())};
        HashMap<Long, OooO0o> hashMap = this.OooOO0;
        Long valueOf = Long.valueOf(this.OooO0O0.getOptionsSync(list.subList(iArr[0], iArr[1])));
        OooO0OO oooO0OO = new OooO0OO(iArr, list, i2, oooOOo);
        hashMap.put(valueOf, oooO0OO);
    }

    public void OooO00o(int i2, List<String> list, C0153OooOOoo oooOOoo) {
        int i3 = this.OooO0Oo == ConnectType.BLE ? 20 : Integer.MAX_VALUE;
        int[] iArr = {0, Math.min(i3, list.size())};
        HashMap<Long, OooO0o> hashMap = this.OooOO0;
        Long valueOf = Long.valueOf(this.OooO0O0.getPhotoOptionsAsync(i2, list.subList(iArr[0], iArr[1])));
        C0145OooO0Oo oooO0Oo = new C0145OooO0Oo(i2, iArr, list, i3, oooOOoo);
        hashMap.put(valueOf, oooO0Oo);
    }
}
