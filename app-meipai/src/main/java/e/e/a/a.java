package e.e.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.Handler;
import android.os.Looper;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.baidu.mobstat.Config;
import e.e.a.c.c;
import e.e.a.d.e;
import e.e.a.d.i;
import e.e.a.d.m;
import e.e.a.e.b;
import e.e.a.g.d;
import e.e.a.g.f;
import java.util.LinkedList;

@TargetApi(18)
/* compiled from: BleManager */
public class a {

    /* renamed from: a reason: collision with root package name */
    public Application f7929a;

    /* renamed from: b reason: collision with root package name */
    public d f7930b;

    /* renamed from: c reason: collision with root package name */
    public BluetoothAdapter f7931c;

    /* renamed from: d reason: collision with root package name */
    public c f7932d;

    /* renamed from: e reason: collision with root package name */
    public BluetoothLeAdvertiser f7933e;

    /* renamed from: f reason: collision with root package name */
    public e.e.a.b.c f7934f;

    /* renamed from: g reason: collision with root package name */
    public int f7935g = 7;

    /* renamed from: h reason: collision with root package name */
    public int f7936h = 5000;

    /* renamed from: i reason: collision with root package name */
    public int f7937i = 0;

    /* renamed from: j reason: collision with root package name */
    public long f7938j = Config.BPLUS_DELAY_TIME;
    public int k = 20;
    public long l = FragmentStateAdapter.GRACE_WINDOW_TIME_MS;

    /* renamed from: e.e.a.a$a reason: collision with other inner class name */
    /* compiled from: BleManager */
    public static class C0102a {

        /* renamed from: a reason: collision with root package name */
        public static final a f7939a = new a();
    }

    public void a(b bVar, String str, String str2, e eVar) {
        if (eVar != null) {
            e.e.a.c.a c2 = this.f7932d.c(bVar);
            if (c2 == null) {
                eVar.onNotifyFailure(new e.e.a.f.d("This device not connect!"));
                return;
            }
            e.e.a.c.b bVar2 = new e.e.a.c.b(c2);
            bVar2.a(str, str2);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bVar2.f7963c;
            if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
                eVar.onNotifyFailure(new e.e.a.f.d("this characteristic not support notify!"));
                return;
            }
            bVar2.a();
            eVar.setKey(str2);
            eVar.setHandler(bVar2.f7965e);
            bVar2.f7964d.a(str2, eVar);
            Handler handler = bVar2.f7965e;
            handler.sendMessageDelayed(handler.obtainMessage(17, eVar), (long) C0102a.f7939a.f7936h);
            BluetoothGatt bluetoothGatt = bVar2.f7961a;
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = bVar2.f7963c;
            if (bluetoothGatt == null || bluetoothGattCharacteristic2 == null) {
                bVar2.a();
                eVar.onNotifyFailure(new e.e.a.f.d("gatt or characteristic equal null"));
            } else if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true)) {
                bVar2.a();
                eVar.onNotifyFailure(new e.e.a.f.d("gatt setCharacteristicNotification fail"));
            } else {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic2.getDescriptor(bVar2.a("00002902-0000-1000-8000-00805f9b34fb"));
                if (descriptor == null) {
                    bVar2.a();
                    eVar.onNotifyFailure(new e.e.a.f.d("descriptor equals null"));
                    return;
                }
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                if (!bluetoothGatt.writeDescriptor(descriptor)) {
                    bVar2.a();
                    eVar.onNotifyFailure(new e.e.a.f.d("gatt writeDescriptor fail"));
                }
            }
        } else {
            throw new IllegalArgumentException("BleNotifyCallback can not be Null!");
        }
    }

    public void a(b bVar, String str, String str2, byte[] bArr, m mVar) {
        int i2;
        byte[] bArr2;
        if (mVar == null) {
            throw new IllegalArgumentException("BleWriteCallback can not be Null!");
        } else if (bArr == null) {
            String str3 = "data is Null!";
            e.e.a.h.a.a(str3);
            mVar.onWriteFailure(new e.e.a.f.d(str3));
        } else {
            int length = bArr.length;
            e.e.a.c.a c2 = this.f7932d.c(bVar);
            if (c2 == null) {
                mVar.onWriteFailure(new e.e.a.f.d("This device not connect!"));
            } else if (bArr.length > this.k) {
                e.e.a.c.d dVar = new e.e.a.c.d();
                dVar.f7971c = c2;
                dVar.f7972d = str;
                dVar.f7973e = str2;
                dVar.f7974f = bArr;
                dVar.f7976h = true;
                dVar.f7977i = 0;
                int i3 = C0102a.f7939a.k;
                dVar.f7975g = i3;
                dVar.f7978j = mVar;
                if (i3 >= 1) {
                    if (i3 > 20) {
                        e.e.a.h.a.c("Be careful: split count beyond 20! Ensure MTU higher than 23!");
                    }
                    LinkedList linkedList = new LinkedList();
                    if (bArr.length % i3 == 0) {
                        i2 = bArr.length / i3;
                    } else {
                        i2 = Math.round((float) ((bArr.length / i3) + 1));
                    }
                    if (i2 > 0) {
                        for (int i4 = 0; i4 < i2; i4++) {
                            if (i2 == 1 || i4 == i2 - 1) {
                                int length2 = bArr.length % i3 == 0 ? i3 : bArr.length % i3;
                                byte[] bArr3 = new byte[length2];
                                System.arraycopy(bArr, i4 * i3, bArr3, 0, length2);
                                bArr2 = bArr3;
                            } else {
                                bArr2 = new byte[i3];
                                System.arraycopy(bArr, i4 * i3, bArr2, 0, i3);
                            }
                            linkedList.offer(bArr2);
                        }
                    }
                    dVar.k = linkedList;
                    dVar.l = linkedList.size();
                    dVar.a();
                    return;
                }
                throw new IllegalArgumentException("split count should higher than 0!");
            } else {
                e.e.a.c.b bVar2 = new e.e.a.c.b(c2);
                bVar2.a(str, str2);
                bVar2.a(bArr, mVar, str2);
            }
        }
    }

    public BluetoothGatt a(b bVar, e.e.a.d.b bVar2) {
        if (bVar2 != null) {
            BluetoothAdapter bluetoothAdapter = this.f7931c;
            if (!(bluetoothAdapter != null && bluetoothAdapter.isEnabled())) {
                String str = "Bluetooth not enable!";
                e.e.a.h.a.a(str);
                bVar2.onConnectFail(bVar, new e.e.a.f.d(str));
                return null;
            }
            if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
                e.e.a.h.a.c("Be careful: currentThread is not MainThread!");
            }
            if (bVar != null && bVar.f7983a != null) {
                return this.f7932d.a(bVar).a(bVar, this.f7930b.f8016d, bVar2);
            }
            bVar2.onConnectFail(bVar, new e.e.a.f.d("Not Found Device Exception Occurred!"));
            return null;
        }
        throw new IllegalArgumentException("BleGattCallback can not be Null!");
    }

    public void a(i iVar) {
        if (iVar != null) {
            BluetoothAdapter bluetoothAdapter = this.f7931c;
            if (!(bluetoothAdapter != null && bluetoothAdapter.isEnabled())) {
                e.e.a.h.a.a("Bluetooth not enable!");
                iVar.onScanStarted(false);
                return;
            }
            d dVar = this.f7930b;
            f.b.f8023a.a(dVar.f8013a, dVar.f8014b, dVar.f8015c, dVar.f8017e, false, dVar.f8018f, iVar);
            return;
        }
        throw new IllegalArgumentException("BleScanCallback can not be Null!");
    }

    public void a() {
        c cVar = this.f7932d;
        if (cVar != null) {
            cVar.a();
        }
    }
}
