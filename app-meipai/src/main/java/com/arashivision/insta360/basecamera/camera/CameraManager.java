package com.arashivision.insta360.basecamera.camera;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeAdvertiser;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import c.a.a.a.a.f;
import c.a.a.a.a.g;
import com.arashivision.insta360.basecamera.CameraModule;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CameraStatus;
import com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType;
import com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0OO;
import com.arashivision.insta360.basecamera.camera.check.ICameraCheck;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import e.b.c.a.a.a1;
import e.b.c.a.a.c1;
import e.e.a.a;
import e.e.a.a.C0102a;
import e.e.a.c.c;
import e.e.a.g.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CameraManager {
    public static final CameraLogger OooO0Oo = CameraLogger.getLogger(CameraManager.class);
    public static CameraManager OooO0o0;
    public ArrayList<BaseCamera> OooO00o = new ArrayList<>();
    public IConfiguration OooO0O0;
    public f OooO0OO;

    public interface IConfiguration {
        List<ICameraCheck> getCameraCheckActivationList(String str, ConnectType connectType);

        List<CameraType> getSupportCamera();

        boolean onOpenCamera(ConnectType connectType, List<BaseCamera> list);
    }

    public class OooO00o implements OooO0OO {
        public final /* synthetic */ ConnectType OooO00o;

        public OooO00o(ConnectType connectType) {
            this.OooO00o = connectType;
        }
    }

    public class OooO0O0 implements g {
        public OooO0O0(CameraManager cameraManager) {
        }
    }

    public CameraManager() {
        a aVar = C0102a.f7939a;
        Application application = CameraModule.getApplication();
        if (aVar.f7929a == null && application != null) {
            aVar.f7929a = application;
            if (application.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                BluetoothManager bluetoothManager = (BluetoothManager) aVar.f7929a.getSystemService("bluetooth");
            }
            aVar.f7931c = BluetoothAdapter.getDefaultAdapter();
            aVar.f7932d = new c();
            aVar.f7930b = new d();
            BluetoothLeAdvertiser bluetoothLeAdvertiser = aVar.f7931c.getBluetoothLeAdvertiser();
            aVar.f7933e = bluetoothLeAdvertiser;
            aVar.f7934f = new e.e.a.b.c(bluetoothLeAdvertiser);
        }
        OooO00o(ConnectType.BLE);
    }

    public static /* synthetic */ int OooO00o(BaseCamera baseCamera, BaseCamera baseCamera2) {
        return baseCamera.getConnectType().ordinal() - baseCamera2.getConnectType().ordinal();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void OooO00o(BaseCamera baseCamera, CameraStatus cameraStatus, int i2) {
        if (baseCamera.isIdle()) {
            this.OooO00o.remove(baseCamera);
        } else if (!this.OooO00o.contains(baseCamera)) {
            this.OooO00o.add(baseCamera);
        }
        f fVar = this.OooO0OO;
        if (fVar != null) {
            fVar.onCameraStatusChanged(baseCamera, cameraStatus, i2);
        }
    }

    public static CameraManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new CameraManager();
        }
        return OooO0o0;
    }

    public final BaseCamera OooO00o(ConnectType connectType) {
        BaseCamera baseCamera = new BaseCamera(connectType, new OooO00o(connectType));
        baseCamera.OooOO0 = new a1(this, baseCamera);
        return baseCamera;
    }

    public void destroyCamera(ConnectType connectType) {
        BaseCamera cameraByConnectType = getCameraByConnectType(connectType);
        if (cameraByConnectType != null) {
            destroyCamera(cameraByConnectType);
        }
    }

    public void destroyCamera(BaseCamera baseCamera) {
        if (baseCamera != null) {
            baseCamera.OooO00o(false);
        }
    }

    public List<BaseCamera> getAllActiveCamera() {
        return getAllActiveCamera(false);
    }

    public List<BaseCamera> getAllActiveCamera(boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.OooO00o.iterator();
        while (it.hasNext()) {
            BaseCamera baseCamera = (BaseCamera) it.next();
            if (baseCamera.isReady() || (z && baseCamera.isFakeReady())) {
                arrayList.add(baseCamera);
            }
        }
        return arrayList;
    }

    public g getBleConnectDelegate() {
        return new OooO0O0(this);
    }

    public BaseCamera getCameraByConnectType(ConnectType connectType) {
        Iterator it = this.OooO00o.iterator();
        while (it.hasNext()) {
            BaseCamera baseCamera = (BaseCamera) it.next();
            if (baseCamera.getConnectType() == connectType) {
                return baseCamera;
            }
        }
        return null;
    }

    public BaseCamera getPrimaryActiveCamera(boolean z) {
        ArrayList arrayList;
        List<BaseCamera> allActiveCamera = getAllActiveCamera();
        if (z) {
            arrayList = new ArrayList(allActiveCamera);
        } else {
            arrayList = new ArrayList();
            for (BaseCamera baseCamera : allActiveCamera) {
                if (baseCamera.getConnectType() != ConnectType.BLE) {
                    arrayList.add(baseCamera);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (BaseCamera) Collections.max(arrayList, c1.f5646a);
    }

    public void setBaseCameraChangedCallback(f fVar) {
        this.OooO0OO = fVar;
    }

    public void setConfiguration(IConfiguration iConfiguration) {
        this.OooO0O0 = iConfiguration;
    }

    public void tryOpenCamera(ConnectType connectType) {
        Iterator it = this.OooO00o.iterator();
        while (it.hasNext()) {
            if (((BaseCamera) it.next()).getConnectType() == connectType) {
                CameraLogger cameraLogger = OooO0Oo;
                StringBuilder sb = new StringBuilder();
                sb.append("tryOpenCamera, but already has camera connect by this type, type: ");
                sb.append(connectType);
                cameraLogger.d(sb.toString());
                return;
            }
        }
        if (this.OooO0O0.onOpenCamera(connectType, this.OooO00o)) {
            BaseCamera OooO00o2 = OooO00o(connectType);
            int ordinal = connectType.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (!OooO00o2.isIdle()) {
                        CameraLogger cameraLogger2 = BaseCamera.OooOO0o;
                        StringBuilder a2 = e.a.a.a.a.a("openUsb, but is not idle, status: ");
                        a2.append(OooO00o2.OooO0o0);
                        cameraLogger2.w(a2.toString());
                    } else {
                        BaseCamera.OooOO0o.d("openUsb");
                        OooO00o2.OooO0OO.openUsb(CameraModule.getApplication());
                        OooO00o2.OooO.postDelayed(OooO00o2.OooOO0O, FragmentStateAdapter.GRACE_WINDOW_TIME_MS);
                        OooO00o2.OooO00o(CameraStatus.OPENING, 0);
                    }
                }
            } else if (!OooO00o2.isIdle()) {
                CameraLogger cameraLogger3 = BaseCamera.OooOO0o;
                StringBuilder a3 = e.a.a.a.a.a("openWifi, but is not idle, status: ");
                a3.append(OooO00o2.OooO0o0);
                cameraLogger3.w(a3.toString());
            } else {
                BaseCamera.OooOO0o.d("openWifi");
                OooO00o2.OooO0OO.openWifi(5000, BaseCamera.CAMERA_SERVICE_WIFI_AP_IP, 6666, true);
                OooO00o2.OooO.postDelayed(OooO00o2.OooOO0O, FragmentStateAdapter.GRACE_WINDOW_TIME_MS);
                OooO00o2.OooO00o(CameraStatus.OPENING, 0);
            }
        }
    }
}
