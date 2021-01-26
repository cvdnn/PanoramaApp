package e.c.d.i.a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanSettings;
import android.os.ParcelUuid;
import com.baidu.picapture.hardware.ble.BleHistoryBean;
import com.baidu.picapture.hardware.ble.BleHistoryBean.DevicesBean;
import d.r.d.o;
import e.c.d.d.e.ThreadPoolService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

/* compiled from: BleAutoConnect */
public class w {

    /* renamed from: g reason: collision with root package name */
    public static volatile w f6138g;

    /* renamed from: a reason: collision with root package name */
    public List<String> f6139a;

    /* renamed from: b reason: collision with root package name */
    public List<BluetoothDevice> mBluetoothDeviceList = Collections.synchronizedList(new ArrayList());

    /* renamed from: c reason: collision with root package name */
    public boolean f6141c = false;

    /* renamed from: d reason: collision with root package name */
    public boolean f6142d = false;

    /* renamed from: e reason: collision with root package name */
    public BleListener f6143e = new a();

    /* renamed from: f reason: collision with root package name */
    public y f6144f = new c(this);

    /* compiled from: BleAutoConnect */
    public class a implements BleListener {
        public a() {
        }

        public void a(BluetoothDevice bluetoothDevice) {
            bluetoothDevice.getAddress();
            List<String> list = w.this.f6139a;
            if (list != null && list.contains(bluetoothDevice.getAddress())) {
                if (((String) w.this.f6139a.get(0)).compareToIgnoreCase(bluetoothDevice.getAddress()) == 0) {
                    bluetoothDevice.getAddress();
                    w.this.mBluetoothDeviceList.add(0, bluetoothDevice);
                    ThreadPoolService.post(new b(this));
                    return;
                }
                w.this.mBluetoothDeviceList.add(bluetoothDevice);
            }
        }

        public void b() {
            w wVar = w.this;
            BleHistoryRecord b2 = BleHistoryRecord.impl();
            BleHistoryBean bleHistoryBean = b2.bleHistoryBean;
            ArrayList arrayList = null;
            if (!(bleHistoryBean == null || bleHistoryBean.getLastAddress() == null || b2.bleHistoryBean.getLastAddress().isEmpty())) {
                List<DevicesBean> devices = b2.bleHistoryBean.getDevices();
                if (!devices.isEmpty()) {
                    arrayList = new ArrayList();
                    for (DevicesBean devicesBean : devices) {
                        if (devicesBean.getAddress().compareToIgnoreCase(b2.bleHistoryBean.getLastAddress()) == 0) {
                            arrayList.add(0, devicesBean.getAddress());
                        } else {
                            arrayList.add(devicesBean.getAddress());
                        }
                    }
                }
            }
            wVar.f6139a = arrayList;
        }

        public /* synthetic */ void c() {
            w.a(w.this);
        }

        public /* synthetic */ void d() {
            w.a(w.this);
        }

        public void a() {
            if (!w.this.mBluetoothDeviceList.isEmpty()) {
                w wVar = w.this;
                if (!wVar.f6142d && !wVar.f6141c) {
                    ThreadPoolService.post(new a(this));
                }
            }
        }
    }

    public static w c() {
        if (f6138g == null) {
            synchronized (w.class) {
                if (f6138g == null) {
                    f6138g = new w();
                }
            }
        }
        return f6138g;
    }

    public /* synthetic */ void a(String str, int i2) {
        if (i2 == 3) {
            ThreadPoolService.post(new v(this));
        } else if (i2 == 2) {
            this.f6142d = true;
            this.f6141c = false;
        }
    }

    public void b() {
        this.f6142d = false;
        this.f6141c = false;
        b0 f2 = b0.impl();
        BleListener bleListenerVar = this.f6143e;
        if (!f2.n.contains(bleListenerVar)) {
            f2.n.registerObserver(bleListenerVar);
        }
        b0.impl().registerObserver(this.f6144f);
        b0 f3 = b0.impl();
        if (!f3.f6109g && !f3.c()) {
            return;
        }
        if (!f3.bBluetoothAdapter.isEnabled()) {
            f3.n.observable(t.f6135a);
            return;
        }
        f3.stopScan(false);
        f3.f6110h = true;
        f3.gattSevice = "00001910-0000-1000-8000-00805f9b34fb";
        f3.mBluetoothDeviceMap.clear();
        f3.cancel();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Builder().setServiceUuid(ParcelUuid.fromString(f3.gattSevice)).build());
        f3.bluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().setScanMode(2).build(), f3.mScanCallback);
        f3.n.observable(u.f6136a);
        List<BluetoothDevice> connectedDevices = f3.bluetoothManager.getConnectedDevices(7);
        if (connectedDevices == null || connectedDevices.isEmpty()) {
            BluetoothGatt bluetoothGatt = f3.mBluetoothGatt;
            if (bluetoothGatt != null) {
                bluetoothGatt.disconnect();
                f3.mBluetoothGatt.close();
                f3.mBluetoothGatt = null;
            }
        } else {
            for (BluetoothDevice bluetoothDevice : connectedDevices) {
                if (f3.set.contains(bluetoothDevice.getAddress())) {
                    f3.mBluetoothDeviceMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
                    f3.n.observable(new s(bluetoothDevice));
                    f3.o.observable(new p(bluetoothDevice));
                    bluetoothDevice.getAddress();
                }
            }
        }
        TimerTask timerTask = f3.r;
        if (timerTask != null) {
            timerTask.cancel();
            f3.r = null;
        }
        c0 c0Var = new c0(f3);
        f3.r = c0Var;
        f3.mTimer.schedule(c0Var, (long) o.TARGET_SEEK_SCROLL_DISTANCE_PX);
    }

    public static /* synthetic */ void a(w wVar) {
        if (wVar.mBluetoothDeviceList.isEmpty()) {
            wVar.f6141c = false;
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) wVar.mBluetoothDeviceList.get(0);
        bluetoothDevice.getAddress();
        wVar.f6141c = true;
        b0.impl().connectGatt(bluetoothDevice.getAddress(),
                "0000fff1-0000-1000-8000-00805f9b34fb", 
                "0000fff4-0000-1000-8000-00805f9b34fb", o.TARGET_SEEK_SCROLL_DISTANCE_PX);
        wVar.mBluetoothDeviceList.remove(0);
    }

    public final void a() {
        if (this.mBluetoothDeviceList.isEmpty()) {
            this.f6141c = false;
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.mBluetoothDeviceList.get(0);
        bluetoothDevice.getAddress();
        this.f6141c = true;
        b0.impl().connectGatt(bluetoothDevice.getAddress(),
                "0000fff1-0000-1000-8000-00805f9b34fb",
                "0000fff4-0000-1000-8000-00805f9b34fb", o.TARGET_SEEK_SCROLL_DISTANCE_PX);
        this.mBluetoothDeviceList.remove(0);
    }
}
