package e.e.a.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import e.e.a.a.C0102a;
import e.e.a.d.d;
import e.e.a.d.e;
import e.e.a.d.BleReadCallback;
import e.e.a.d.g;
import e.e.a.d.m;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

@TargetApi(18)
/* compiled from: BleBluetooth */
public class a {

    /* renamed from: a reason: collision with root package name */
    public e.e.a.d.b f7943a;

    /* renamed from: b reason: collision with root package name */
    public g f7944b;

    /* renamed from: c reason: collision with root package name */
    public d f7945c;

    /* renamed from: d reason: collision with root package name */
    public HashMap<String, e> f7946d = new HashMap<>();

    /* renamed from: e reason: collision with root package name */
    public HashMap<String, e.e.a.d.c> f7947e = new HashMap<>();

    /* renamed from: f reason: collision with root package name */
    public HashMap<String, m> f7948f = new HashMap<>();

    /* renamed from: g reason: collision with root package name */
    public HashMap<String, BleReadCallback> f7949g = new HashMap<>();

    /* renamed from: h reason: collision with root package name */
    public b f7950h;

    /* renamed from: i reason: collision with root package name */
    public boolean f7951i = false;

    /* renamed from: j reason: collision with root package name */
    public e.e.a.e.b f7952j;
    public BluetoothGatt k;
    public c l = new c(Looper.getMainLooper());
    public int m = 0;
    public BluetoothGattCallback n = new C0103a();

    /* renamed from: e.e.a.c.a$a reason: collision with other inner class name */
    /* compiled from: BleBluetooth */
    public class C0103a extends BluetoothGattCallback {
        public C0103a() {
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            for (Entry value : a.this.f7946d.entrySet()) {
                Object value2 = value.getValue();
                if (value2 instanceof e) {
                    e eVar = (e) value2;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(eVar.getKey())) {
                        Handler handler = eVar.getHandler();
                        if (handler != null) {
                            Message obtainMessage = handler.obtainMessage();
                            obtainMessage.what = 19;
                            obtainMessage.obj = eVar;
                            Bundle bundle = new Bundle();
                            bundle.putByteArray("notify_value", bluetoothGattCharacteristic.getValue());
                            obtainMessage.setData(bundle);
                            handler.sendMessage(obtainMessage);
                        }
                    }
                }
            }
            for (Entry value3 : a.this.f7947e.entrySet()) {
                Object value4 = value3.getValue();
                if (value4 instanceof e.e.a.d.c) {
                    e.e.a.d.c cVar = (e.e.a.d.c) value4;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(cVar.getKey())) {
                        Handler handler2 = cVar.getHandler();
                        if (handler2 != null) {
                            Message obtainMessage2 = handler2.obtainMessage();
                            obtainMessage2.what = 35;
                            obtainMessage2.obj = cVar;
                            Bundle bundle2 = new Bundle();
                            bundle2.putByteArray("indicate_value", bluetoothGattCharacteristic.getValue());
                            obtainMessage2.setData(bundle2);
                            handler2.sendMessage(obtainMessage2);
                        }
                    }
                }
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
            for (Entry value : a.this.f7949g.entrySet()) {
                Object value2 = value.getValue();
                if (value2 instanceof BleReadCallback) {
                    BleReadCallback fVar = (BleReadCallback) value2;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(fVar.getKey())) {
                        Handler handler = fVar.getHandler();
                        if (handler != null) {
                            Message obtainMessage = handler.obtainMessage();
                            obtainMessage.what = 66;
                            obtainMessage.obj = fVar;
                            Bundle bundle = new Bundle();
                            bundle.putInt("read_status", i2);
                            bundle.putByteArray("read_value", bluetoothGattCharacteristic.getValue());
                            obtainMessage.setData(bundle);
                            handler.sendMessage(obtainMessage);
                        }
                    }
                }
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
            for (Entry value : a.this.f7948f.entrySet()) {
                Object value2 = value.getValue();
                if (value2 instanceof m) {
                    m mVar = (m) value2;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(mVar.getKey())) {
                        Handler handler = mVar.getHandler();
                        if (handler != null) {
                            Message obtainMessage = handler.obtainMessage();
                            obtainMessage.what = 50;
                            obtainMessage.obj = mVar;
                            Bundle bundle = new Bundle();
                            bundle.putInt("write_status", i2);
                            bundle.putByteArray("write_value", bluetoothGattCharacteristic.getValue());
                            obtainMessage.setData(bundle);
                            handler.sendMessage(obtainMessage);
                        }
                    }
                }
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onConnectionStateChange(bluetoothGatt, i2, i3);
            StringBuilder sb = new StringBuilder();
            sb.append("BluetoothGattCallback：onConnectionStateChange \nstatus: ");
            sb.append(i2);
            sb.append(10);
            sb.append("newState: ");
            sb.append(i3);
            sb.append(10);
            sb.append("currentThread: ");
            sb.append(Thread.currentThread().getId());
            e.e.a.h.a.b(sb.toString());
            a aVar = a.this;
            aVar.k = bluetoothGatt;
            aVar.l.removeMessages(7);
            if (i3 == 2) {
                Message obtainMessage = a.this.l.obtainMessage();
                obtainMessage.what = 4;
                a.this.l.sendMessageDelayed(obtainMessage, 500);
            } else if (i3 == 0) {
                a aVar2 = a.this;
                b bVar = aVar2.f7950h;
                if (bVar == b.CONNECT_CONNECTING) {
                    Message obtainMessage2 = aVar2.l.obtainMessage();
                    obtainMessage2.what = 1;
                    obtainMessage2.obj = new e.e.a.e.a(i2);
                    a.this.l.sendMessage(obtainMessage2);
                } else if (bVar == b.CONNECT_CONNECTED) {
                    Message obtainMessage3 = aVar2.l.obtainMessage();
                    obtainMessage3.what = 2;
                    e.e.a.e.a aVar3 = new e.e.a.e.a(i2);
                    a aVar4 = a.this;
                    aVar3.f7982b = aVar4.f7951i;
                    obtainMessage3.obj = aVar3;
                    aVar4.l.sendMessage(obtainMessage3);
                }
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
            for (Entry value : a.this.f7946d.entrySet()) {
                Object value2 = value.getValue();
                if (value2 instanceof e) {
                    e eVar = (e) value2;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(eVar.getKey())) {
                        Handler handler = eVar.getHandler();
                        if (handler != null) {
                            Message obtainMessage = handler.obtainMessage();
                            obtainMessage.what = 18;
                            obtainMessage.obj = eVar;
                            Bundle bundle = new Bundle();
                            bundle.putInt("notify_status", i2);
                            obtainMessage.setData(bundle);
                            handler.sendMessage(obtainMessage);
                        }
                    }
                }
            }
            for (Entry value3 : a.this.f7947e.entrySet()) {
                Object value4 = value3.getValue();
                if (value4 instanceof e.e.a.d.c) {
                    e.e.a.d.c cVar = (e.e.a.d.c) value4;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(cVar.getKey())) {
                        Handler handler2 = cVar.getHandler();
                        if (handler2 != null) {
                            Message obtainMessage2 = handler2.obtainMessage();
                            obtainMessage2.what = 34;
                            obtainMessage2.obj = cVar;
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("indicate_status", i2);
                            obtainMessage2.setData(bundle2);
                            handler2.sendMessage(obtainMessage2);
                        }
                    }
                }
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onMtuChanged(bluetoothGatt, i2, i3);
            d dVar = a.this.f7945c;
            if (dVar != null) {
                Handler handler = dVar.getHandler();
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 98;
                    obtainMessage.obj = a.this.f7945c;
                    Bundle bundle = new Bundle();
                    bundle.putInt("mtu_status", i3);
                    bundle.putInt("mtu_value", i2);
                    obtainMessage.setData(bundle);
                    handler.sendMessage(obtainMessage);
                }
            }
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onReadRemoteRssi(bluetoothGatt, i2, i3);
            g gVar = a.this.f7944b;
            if (gVar != null) {
                Handler handler = gVar.getHandler();
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 82;
                    obtainMessage.obj = a.this.f7944b;
                    Bundle bundle = new Bundle();
                    bundle.putInt("rssi_status", i3);
                    bundle.putInt("rssi_value", i2);
                    obtainMessage.setData(bundle);
                    handler.sendMessage(obtainMessage);
                }
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            super.onServicesDiscovered(bluetoothGatt, i2);
            StringBuilder sb = new StringBuilder();
            sb.append("BluetoothGattCallback：onServicesDiscovered \nstatus: ");
            sb.append(i2);
            sb.append(10);
            sb.append("currentThread: ");
            sb.append(Thread.currentThread().getId());
            e.e.a.h.a.b(sb.toString());
            a aVar = a.this;
            aVar.k = bluetoothGatt;
            if (i2 == 0) {
                Message obtainMessage = aVar.l.obtainMessage();
                obtainMessage.what = 6;
                obtainMessage.obj = new e.e.a.e.a(i2);
                a.this.l.sendMessage(obtainMessage);
                return;
            }
            Message obtainMessage2 = aVar.l.obtainMessage();
            obtainMessage2.what = 5;
            a.this.l.sendMessage(obtainMessage2);
        }
    }

    /* compiled from: BleBluetooth */
    public enum b {
        CONNECT_IDLE,
        CONNECT_CONNECTING,
        CONNECT_CONNECTED,
        CONNECT_FAILURE,
        CONNECT_DISCONNECT
    }

    /* compiled from: BleBluetooth */
    public final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.d();
                    a.this.f();
                    a.this.b();
                    a aVar = a.this;
                    if (aVar.m < C0102a.f7939a.f7937i) {
                        StringBuilder a2 = e.a.a.a.a.a("Connect fail, try reconnect ");
                        a2.append(C0102a.f7939a.f7938j);
                        a2.append(" millisecond later");
                        e.e.a.h.a.a(a2.toString());
                        a aVar2 = a.this;
                        aVar2.m++;
                        Message obtainMessage = aVar2.l.obtainMessage();
                        obtainMessage.what = 3;
                        a.this.l.sendMessageDelayed(obtainMessage, C0102a.f7939a.f7938j);
                        return;
                    }
                    aVar.f7950h = b.CONNECT_FAILURE;
                    C0102a.f7939a.f7932d.c(aVar);
                    int i2 = ((e.e.a.e.a) message.obj).f7981a;
                    a aVar3 = a.this;
                    e.e.a.d.b bVar = aVar3.f7943a;
                    if (bVar != null) {
                        bVar.onConnectFail(aVar3.f7952j, new e.e.a.f.b(aVar3.k, i2));
                        return;
                    }
                    return;
                case 2:
                    a aVar4 = a.this;
                    aVar4.f7950h = b.CONNECT_DISCONNECT;
                    C0102a.f7939a.f7932d.b(aVar4);
                    a.this.c();
                    a.this.f();
                    a.this.b();
                    a.this.h();
                    a.this.g();
                    a.this.a();
                    a.this.l.removeCallbacksAndMessages(null);
                    e.e.a.e.a aVar5 = (e.e.a.e.a) message.obj;
                    boolean z = aVar5.f7982b;
                    int i3 = aVar5.f7981a;
                    a aVar6 = a.this;
                    e.e.a.d.b bVar2 = aVar6.f7943a;
                    if (bVar2 != null) {
                        bVar2.onDisConnected(z, aVar6.f7952j, aVar6.k, i3);
                        return;
                    }
                    return;
                case 3:
                    a aVar7 = a.this;
                    aVar7.a(aVar7.f7952j, false, aVar7.f7943a, aVar7.m);
                    return;
                case 4:
                    a aVar8 = a.this;
                    BluetoothGatt bluetoothGatt = aVar8.k;
                    if (bluetoothGatt == null) {
                        Message obtainMessage2 = aVar8.l.obtainMessage();
                        obtainMessage2.what = 5;
                        a.this.l.sendMessage(obtainMessage2);
                        return;
                    } else if (!bluetoothGatt.discoverServices()) {
                        Message obtainMessage3 = a.this.l.obtainMessage();
                        obtainMessage3.what = 5;
                        a.this.l.sendMessage(obtainMessage3);
                        return;
                    } else {
                        return;
                    }
                case 5:
                    a.this.d();
                    a.this.f();
                    a.this.b();
                    a aVar9 = a.this;
                    aVar9.f7950h = b.CONNECT_FAILURE;
                    C0102a.f7939a.f7932d.c(aVar9);
                    a aVar10 = a.this;
                    e.e.a.d.b bVar3 = aVar10.f7943a;
                    if (bVar3 != null) {
                        bVar3.onConnectFail(aVar10.f7952j, new e.e.a.f.d("GATT discover services exception occurred!"));
                        return;
                    }
                    return;
                case 6:
                    a aVar11 = a.this;
                    aVar11.f7950h = b.CONNECT_CONNECTED;
                    aVar11.f7951i = false;
                    C0102a.f7939a.f7932d.c(aVar11);
                    C0102a.f7939a.f7932d.a(a.this);
                    int i4 = ((e.e.a.e.a) message.obj).f7981a;
                    a aVar12 = a.this;
                    e.e.a.d.b bVar4 = aVar12.f7943a;
                    if (bVar4 != null) {
                        bVar4.onConnectSuccess(aVar12.f7952j, aVar12.k, i4);
                        return;
                    }
                    return;
                case 7:
                    a.this.d();
                    a.this.f();
                    a.this.b();
                    a aVar13 = a.this;
                    aVar13.f7950h = b.CONNECT_FAILURE;
                    C0102a.f7939a.f7932d.c(aVar13);
                    a aVar14 = a.this;
                    e.e.a.d.b bVar5 = aVar14.f7943a;
                    if (bVar5 != null) {
                        bVar5.onConnectFail(aVar14.f7952j, new e.e.a.f.e());
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public a(e.e.a.e.b bVar) {
        this.f7952j = bVar;
    }

    public synchronized void a(e.e.a.d.b bVar) {
        this.f7943a = bVar;
    }

    public final synchronized void b() {
        if (this.k != null) {
            this.k.close();
        }
    }

    public synchronized void c() {
        this.f7951i = true;
        d();
    }

    public final synchronized void d() {
        if (this.k != null) {
            this.k.disconnect();
        }
    }

    public String e() {
        return this.f7952j.a();
    }

    public final synchronized void f() {
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
            if (!(method == null || this.k == null)) {
                boolean booleanValue = ((Boolean) method.invoke(this.k, new Object[0])).booleanValue();
                StringBuilder sb = new StringBuilder();
                sb.append("refreshDeviceCache, is success:  ");
                sb.append(booleanValue);
                e.e.a.h.a.b(sb.toString());
            }
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exception occur while refreshing device: ");
            sb2.append(e2.getMessage());
            e.e.a.h.a.b(sb2.toString());
            e2.printStackTrace();
        }
        return;
    }

    public synchronized void g() {
        this.f7945c = null;
    }

    public synchronized void h() {
        this.f7944b = null;
    }

    public synchronized void a(String str, e eVar) {
        this.f7946d.put(str, eVar);
    }

    public synchronized void a(String str, m mVar) {
        this.f7948f.put(str, mVar);
    }

    public synchronized void a() {
        if (this.f7946d != null) {
            this.f7946d.clear();
        }
        if (this.f7947e != null) {
            this.f7947e.clear();
        }
        if (this.f7948f != null) {
            this.f7948f.clear();
        }
        if (this.f7949g != null) {
            this.f7949g.clear();
        }
    }

    public synchronized BluetoothGatt a(e.e.a.e.b bVar, boolean z, e.e.a.d.b bVar2) {
        return a(bVar, z, bVar2, 0);
    }

    public synchronized BluetoothGatt a(e.e.a.e.b bVar, boolean z, e.e.a.d.b bVar2, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("connect device: ");
        sb.append(bVar.c());
        sb.append("\nmac: ");
        sb.append(bVar.b());
        sb.append("\nautoConnect: ");
        sb.append(z);
        sb.append("\ncurrentThread: ");
        sb.append(Thread.currentThread().getId());
        sb.append("\nconnectCount:");
        sb.append(i2 + 1);
        e.e.a.h.a.b(sb.toString());
        if (i2 == 0) {
            this.m = 0;
        }
        a(bVar2);
        this.f7950h = b.CONNECT_CONNECTING;
        BluetoothGatt connectGatt = bVar.f7983a.connectGatt(C0102a.f7939a.f7929a, z, this.n, 2);
        this.k = connectGatt;
        if (connectGatt != null) {
            if (this.f7943a != null) {
                this.f7943a.onStartConnect();
            }
            Message obtainMessage = this.l.obtainMessage();
            obtainMessage.what = 7;
            this.l.sendMessageDelayed(obtainMessage, C0102a.f7939a.l);
        } else {
            d();
            f();
            b();
            this.f7950h = b.CONNECT_FAILURE;
            C0102a.f7939a.f7932d.c(this);
            if (this.f7943a != null) {
                this.f7943a.onConnectFail(bVar, new e.e.a.f.d("GATT connect exception occurred!"));
            }
        }
        return this.k;
    }
}
