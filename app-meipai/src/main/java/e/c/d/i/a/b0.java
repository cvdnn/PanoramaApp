package e.c.d.i.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.text.TextUtils;
import com.baidu.picapture.App;
import com.baidu.picapture.hardware.ble.BleHistoryBean.DevicesBean;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.m.e.a.o;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BleManager */
public class b0 {
    public static volatile b0 w;

    /* renamed from: a reason: collision with root package name */
    public BluetoothManager bluetoothManager;

    /* renamed from: b reason: collision with root package name */
    public BluetoothAdapter bBluetoothAdapter;

    /* renamed from: c reason: collision with root package name */
    public BluetoothGatt mBluetoothGatt;

    /* renamed from: d reason: collision with root package name */
    public BluetoothLeScanner bluetoothLeScanner;

    /* renamed from: e reason: collision with root package name */
    public BluetoothGattCharacteristic bgcF1;

    /* renamed from: f reason: collision with root package name */
    public BluetoothGattCharacteristic bgcF4;

    /* renamed from: g reason: collision with root package name */
    public boolean f6109g = false;

    /* renamed from: h reason: collision with root package name */
    public boolean f6110h = false;

    /* renamed from: i reason: collision with root package name */
    public String gattSevice;

    /* renamed from: j reason: collision with root package name */
    public String gattServiceF1;
    public String gattServiceF4;
    public Map<String, BluetoothDevice> mBluetoothDeviceMap = new ConcurrentHashMap();
    public Set<String> set = new HashSet();
    public e.c.d.d.f.b<BleListener> n = new e.c.d.d.f.b<>();
    public e.c.d.d.f.b<y> o = new e.c.d.d.f.b<>();
    public e.c.d.d.f.b<z> p = new e.c.d.d.f.b<>();
    public Timer mTimer = new Timer();
    public TimerTask r;
    public TimerTask timerTask;
    public String gattAdress;
    public ScanCallback mScanCallback = new a();
    public BluetoothGattCallback mBluetoothGattCallback = new b();

    /* compiled from: BleManager */
    public class a extends ScanCallback {
        public a() {
        }

        public void onScanResult(int i2, ScanResult scanResult) {
            BluetoothDevice device = scanResult.getDevice();
            if (device != null && device.getName() != null && !device.getName().isEmpty() && device.getType() == 2 && b0.this.mBluetoothDeviceMap.get(device.getAddress()) == null) {
                b0 b0Var = b0.this;
                String address = device.getAddress();
                if (b0Var != null) {
                    ThreadPoolService.post(new j(b0Var, address));
                    String.format("[BleManager][onScanResult]find device, name:%s, address:%s", new Object[]{scanResult.getDevice().getName(), scanResult.getDevice().getAddress()});
                    b0.this.mBluetoothDeviceMap.put(device.getAddress(), device);
                    b0.this.n.observable(new d(device));
                    return;
                }
                throw null;
            }
        }
    }

    /* compiled from: BleManager */
    public class b extends BluetoothGattCallback {
        public b() {
        }

        public static /* synthetic */ void b(byte[] bArr, z zVar) {
            if (((e.c.d.m.e.a.u.a) zVar) == null) {
                throw null;
            }
        }

        public static /* synthetic */ void c(byte[] bArr, z zVar) {
            if (((e.c.d.m.e.a.u.a) zVar) == null) {
                throw null;
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            Arrays.toString(value);
            b0.this.p.observable(new i(value));
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            Arrays.toString(value);
            b0.this.p.observable(new h(value));
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            Arrays.toString(value);
            b0.this.p.observable(new f(value));
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                bluetoothGatt.getDevice().getAddress();
                BluetoothGatt bluetoothGatt2 = b0.this.mBluetoothGatt;
                if (bluetoothGatt2 != null) {
                    bluetoothGatt2.discoverServices();
                }
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                String address = bluetoothGatt.getDevice().getAddress();
                if (TextUtils.isEmpty(b0.this.gattAdress) || b0.this.gattAdress.compareToIgnoreCase(address) != 0) {
                    b0.this.o.observable(new e(address));
                    BluetoothGatt bluetoothGatt3 = b0.this.mBluetoothGatt;
                    if (bluetoothGatt3 != null) {
                        bluetoothGatt3.close();
                    }
                } else {
                    b0.this.gattAdress = "";
                }
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            b0.this.cancel();
            if (i2 == BluetoothGatt.GATT_SUCCESS) {
                BluetoothGattService bluetoothGattService = null;
                Iterator it = b0.this.mBluetoothGatt.getServices().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BluetoothGattService bluetoothGattService2 = (BluetoothGattService) it.next();
                    if (bluetoothGattService2.getUuid().toString().compareToIgnoreCase(b0.this.gattSevice) == 0) {
                        StringBuilder text = e.a.a.a.a.a("[BleManager][onServicesDiscovered]Service found! UUID:");
                        text.append(bluetoothGattService2.getUuid());
                        text.toString();
                        bluetoothGattService = bluetoothGattService2;
                        break;
                    }
                }
                if (bluetoothGattService == null) {
                    b0.a(b0.this, bluetoothGatt);
                    return;
                }
                b0 b0Var = b0.this;
                b0Var.bgcF1 = bluetoothGattService.getCharacteristic(UUID.fromString(b0Var.gattServiceF1));
                b0 b0Var2 = b0.this;
                b0Var2.bgcF4 = bluetoothGattService.getCharacteristic(UUID.fromString(b0Var2.gattServiceF4));
                b0 b0Var3 = b0.this;
                BluetoothGattCharacteristic bluetoothGattCharacteristic = b0Var3.bgcF4;
                boolean hasDevice = true;
                if (bluetoothGattCharacteristic != null) {
                    b0Var3.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                }
                b0 b0Var4 = b0.this;
                if (b0Var4.bgcF1 == null || b0Var4.bgcF4 == null) {
                    bluetoothGatt.getDevice().getAddress();
                    b0.a(b0.this, bluetoothGatt);
                } else {
                    b0Var4.o.observable(new g(bluetoothGatt));
                    BleHistoryRecord bleHistoryRecord = BleHistoryRecord.impl();
                    BluetoothDevice device = bluetoothGatt.getDevice();
                    bleHistoryRecord.bleHistoryBean.setLastAddress(device.getAddress());
                    String address = device.getAddress();
                    Iterator it2 = bleHistoryRecord.bleHistoryBean.getDevices().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((DevicesBean) it2.next()).getAddress().compareToIgnoreCase(address) == 0) {
                                break;
                            }
                        } else {
                            hasDevice = false;
                            break;
                        }
                    }
                    if (hasDevice) {
                        bleHistoryRecord.a();
                    } else {
                        DevicesBean devicesBean = new DevicesBean();
                        devicesBean.setAddress(device.getAddress());
                        devicesBean.setName(device.getName());
                        bleHistoryRecord.bleHistoryBean.getDevices().add(devicesBean);
                        bleHistoryRecord.a();
                    }
                }
            } else {
                b0.a(b0.this, bluetoothGatt);
            }
        }

        public static /* synthetic */ void a(byte[] bArr, z zVar) {
            e.c.d.m.e.a.u.a aVar = (e.c.d.m.e.a.u.a) zVar;
            if (aVar == null) {
                throw null;
            } else if (bArr[10] == 2) {
                ThreadPoolService.post(new o(aVar));
            }
        }
    }

    public static b0 impl() {
        if (w == null) {
            synchronized (b0.class) {
                if (w == null) {
                    w = new b0();
                }
            }
        }
        return w;
    }

    public void registerObserver(y yVar) {
        if (!this.o.contains(yVar)) {
            this.o.registerObserver(yVar);
        }
    }

    public void unregisterObserver(y yVar) {
        if (this.o.contains(yVar)) {
            this.o.unregisterObserver(yVar);
        }
    }

    public boolean c() {
        if (this.f6109g) {
            return true;
        }
        if (!init()) {
            return false;
        }
        this.f6109g = true;
        return true;
    }

    public final boolean init() {
        BluetoothManager bluetoothManager = (BluetoothManager) App.f1954b.getApplicationContext().getSystemService("bluetooth");
        this.bluetoothManager = bluetoothManager;
        if (bluetoothManager == null) {
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.bBluetoothAdapter = adapter;
        if (adapter == null || !adapter.isEnabled()) {
            return false;
        }
        this.bluetoothLeScanner = this.bBluetoothAdapter.getBluetoothLeScanner();
        this.mBluetoothGatt = null;
        return true;
    }

    public boolean e() {
        BluetoothAdapter bluetoothAdapter = this.bBluetoothAdapter;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public boolean b() {
        for (BluetoothDevice address : this.bluetoothManager.getConnectedDevices(7)) {
            if (this.set.contains(address.getAddress())) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timerTask = null;
        }
    }

    public final void stopScan(boolean z) {
        if (this.f6110h) {
            this.f6110h = false;
            TimerTask timerTask = this.r;
            if (timerTask != null) {
                timerTask.cancel();
                this.r = null;
            }
            if (this.bBluetoothAdapter.isEnabled()) {
                this.bluetoothLeScanner.stopScan(this.mScanCallback);
            }
            if (z) {
                this.n.contains(gattAdress.f6135a);
            }
        }
    }

    public void connectGatt(String str, String str2, String str3, int millis) {
        if (!this.bBluetoothAdapter.isEnabled()) {
            this.o.observable(new q(str));
            return;
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (!(bluetoothGatt == null || bluetoothGatt.getDevice() == null)) {
            String address = this.mBluetoothGatt.getDevice().getAddress();
            int connectionState = this.bluetoothManager.getConnectionState(this.mBluetoothGatt.getDevice(), 7);
            if (address.compareToIgnoreCase(str) == 0 && connectionState == 2) {
                this.o.observable(new m(address));
                return;
            }
            this.gattAdress = address;
            this.o.contains(new o(address));
            this.mBluetoothGatt.disconnect();
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.mBluetoothDeviceMap.get(str);
        if (bluetoothDevice == null) {
            this.o.observable(new r(str));
            return;
        }
        this.gattServiceF1 = str2;
        this.gattServiceF4 = str3;
        this.o.observable(new k(str));
        this.mBluetoothGatt = bluetoothDevice.connectGatt(App.f1954b.getApplicationContext(), true, this.mBluetoothGattCallback);
        cancel();
        MyTimerTask myTimerTaskVar = new MyTimerTask(this);
        this.timerTask = myTimerTaskVar;
        this.mTimer.schedule(myTimerTaskVar, (long) millis);
    }

    public static /* synthetic */ void a(b0 b0Var, BluetoothGatt bluetoothGatt) {
        if (b0Var != null) {
            b0Var.o.c(new l(bluetoothGatt.getDevice().getAddress()));
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            return;
        }
        throw null;
    }

    public /* synthetic */ void a(String str) {
        this.set.add(str);
    }
}
