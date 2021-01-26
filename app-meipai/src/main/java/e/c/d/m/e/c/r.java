package e.c.d.m.e.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.text.TextUtils;
import com.baidu.picapture.model.device.DeviceInfo;
import d.r.d.o;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.a.BleListener;
import e.c.d.i.a.b0;
import e.c.d.i.a.n;
import e.c.d.i.a.w;
import e.c.d.i.a.y;
import e.c.d.m.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: SpinDevicePresenter */
public class r extends c<q> implements p {

    /* renamed from: b reason: collision with root package name */
    public String f6758b;

    /* renamed from: c reason: collision with root package name */
    public int f6759c = -1;

    /* renamed from: d reason: collision with root package name */
    public List<DeviceInfo> f6760d = new ArrayList();

    /* renamed from: e reason: collision with root package name */
    public boolean f6761e = false;

    /* renamed from: f reason: collision with root package name */
    public boolean f6762f = false;

    /* renamed from: g reason: collision with root package name */
    public ScheduledFuture<?> f6763g;

    /* renamed from: h reason: collision with root package name */
    public BleListener f6764h = new a();

    /* renamed from: i reason: collision with root package name */
    public y f6765i = new l(this);

    /* compiled from: SpinDevicePresenter */
    public class a implements BleListener {
        public a() {
        }

        public void a(BluetoothDevice bluetoothDevice) {
            ThreadPoolService.post(new k(this, bluetoothDevice));
        }

        public void b() {
            ThreadPoolService.post(new i(this));
        }

        public /* synthetic */ void c() {
            r rVar = r.this;
            V v = rVar.f6403a;
            if (v != null) {
                ((q) v).f(!rVar.f6760d.isEmpty());
            }
        }

        public /* synthetic */ void d() {
            V v = r.this.f6403a;
            if (v != null) {
                ((q) v).W();
            }
        }

        public void a() {
            ThreadPoolService.post(new j(this));
        }

        public /* synthetic */ void b(BluetoothDevice bluetoothDevice) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setName(bluetoothDevice.getName());
            deviceInfo.setAddress(bluetoothDevice.getAddress());
            r.this.f6760d.add(deviceInfo);
            V v = r.this.f6403a;
            if (v != null) {
                ((q) v).v();
                r rVar = r.this;
                ((q) rVar.f6403a).b(rVar.f6760d);
            }
        }
    }

    public r(q qVar) {
        super(qVar);
    }

    public void E() {
        this.f6761e = false;
        if (this.f6762f) {
            this.f6762f = false;
            this.f6763g = ThreadPoolService.schedule(new o(this), 500, TimeUnit.MILLISECONDS);
        }
    }

    public /* synthetic */ void F() {
        ThreadPoolService.post(new n(this));
    }

    public /* synthetic */ void G() {
        V v = this.f6403a;
        if (v != null) {
            ((q) v).b();
        }
    }

    public /* synthetic */ void a(String str, int i2) {
        ThreadPoolService.post(new m(this, str, i2));
    }

    public /* synthetic */ void b(String str, int i2) {
        if (this.f6403a != null) {
            Iterator it = this.f6760d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DeviceInfo deviceInfo = (DeviceInfo) it.next();
                if (deviceInfo.getAddress().compareToIgnoreCase(str) == 0) {
                    if (i2 == 1) {
                        deviceInfo.setDeviceStatus(1);
                    } else if (i2 == 2) {
                        this.f6758b = str;
                        deviceInfo.setDeviceStatus(2);
                    } else if (i2 == 0) {
                        deviceInfo.setDeviceStatus(0);
                    } else {
                        deviceInfo.setDeviceStatus(3);
                        if (TextUtils.isEmpty(this.f6758b) || !this.f6758b.equalsIgnoreCase(str)) {
                            ((q) this.f6403a).C();
                        }
                        this.f6758b = "";
                    }
                    ((q) this.f6403a).b(this.f6760d);
                }
            }
            if (!TextUtils.isEmpty(this.f6758b)) {
                int i3 = this.f6759c;
                if (i3 != 6 && i3 != 7) {
                    return;
                }
                if (this.f6761e) {
                    this.f6762f = true;
                } else {
                    ((q) this.f6403a).b();
                }
            }
        }
    }

    public void c(int i2) {
        this.f6759c = i2;
        b0 f2 = b0.impl();
        BleListener bleListenerVar = this.f6764h;
        if (!f2.n.contains(bleListenerVar)) {
            f2.n.registerObserver(bleListenerVar);
        }
        b0.impl().registerObserver(this.f6765i);
        w.c().b();
    }

    public void d(String str) {
        b0 f2 = b0.impl();
        BluetoothGatt bluetoothGatt = f2.mBluetoothGatt;
        if (bluetoothGatt != null && bluetoothGatt.getDevice() != null) {
            String address = f2.mBluetoothGatt.getDevice().getAddress();
            int connectionState = f2.bluetoothManager.getConnectionState(f2.mBluetoothGatt.getDevice(), 7);
            if (address.compareToIgnoreCase(str) == 0 && connectionState == 2) {
                f2.o.observable(new n(address));
                f2.mBluetoothGatt.disconnect();
                f2.gattAdress = "";
            }
        }
    }

    public void e() {
        super.e();
        ScheduledFuture<?> scheduledFuture = this.f6763g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f6763g = null;
        }
        this.f6760d.clear();
        b0 f2 = b0.impl();
        BleListener bleListenerVar = this.f6764h;
        if (f2.n.contains(bleListenerVar)) {
            f2.n.unregisterObserver(bleListenerVar);
        }
        b0.impl().unregisterObserver(this.f6765i);
    }

    public void v() {
        this.f6761e = true;
        ((q) this.f6403a).H();
    }

    public void z() {
        this.f6760d.clear();
        w.c().b();
    }

    public void a(DeviceInfo deviceInfo) {
        boolean z;
        if (b0.impl().e()) {
            b0 f2 = b0.impl();
            if (f2 != null) {
                ArrayList arrayList = new ArrayList();
                for (BluetoothDevice address : f2.bluetoothManager.getConnectedDevices(7)) {
                    arrayList.add(address.getAddress());
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((String) it.next()).equalsIgnoreCase(deviceInfo.getAddress())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    ((q) this.f6403a).g(deviceInfo.getAddress());
                    return;
                }
                w c2 = w.c();
                if (c2 != null) {
                    b0 f3 = b0.impl();
                    BleListener bleListenerVar = c2.f6143e;
                    if (f3.n.contains(bleListenerVar)) {
                        f3.n.unregisterObserver(bleListenerVar);
                    }
                    b0.impl().unregisterObserver(c2.f6144f);
                    b0.impl().connectGatt(deviceInfo.getAddress(), "0000fff1-0000-1000-8000-00805f9b34fb", "0000fff4-0000-1000-8000-00805f9b34fb", o.TARGET_SEEK_SCROLL_DISTANCE_PX);
                    return;
                }
                throw null;
            }
            throw null;
        }
        ((q) this.f6403a).g();
    }
}
