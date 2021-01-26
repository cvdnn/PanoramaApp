package e.e.a.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import e.e.a.a.C0102a;
import e.e.a.d.d;
import e.e.a.d.BleReadCallback;
import e.e.a.d.g;
import e.e.a.d.m;
import e.e.a.f.BleException;
import e.e.a.f.c;
import e.e.a.f.e;
import java.util.UUID;

@TargetApi(18)
/* compiled from: BleConnector */
public class b {

    /* renamed from: a reason: collision with root package name */
    public BluetoothGatt f7961a;

    /* renamed from: b reason: collision with root package name */
    public BluetoothGattService f7962b;

    /* renamed from: c reason: collision with root package name */
    public BluetoothGattCharacteristic f7963c;

    /* renamed from: d reason: collision with root package name */
    public a f7964d;

    /* renamed from: e reason: collision with root package name */
    public Handler f7965e = new a(Looper.getMainLooper());

    /* compiled from: BleConnector */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 49) {
                m mVar = (m) message.obj;
                if (mVar != null) {
                    mVar.onWriteFailure(new e());
                }
            } else if (i2 == 50) {
                b.this.b();
                m mVar2 = (m) message.obj;
                Bundle data = message.getData();
                int i3 = data.getInt("write_status");
                byte[] byteArray = data.getByteArray("write_value");
                if (mVar2 == null) {
                    return;
                }
                if (i3 == 0) {
                    mVar2.onWriteSuccess(1, 1, byteArray);
                } else {
                    mVar2.onWriteFailure(new c(i3));
                }
            } else if (i2 == 65) {
                BleReadCallback fVar = (BleReadCallback) message.obj;
                if (fVar != null) {
                    fVar.onError((BleException) new e());
                }
            } else if (i2 == 66) {
                b.this.f7965e.removeMessages(65);
                BleReadCallback fVar2 = (BleReadCallback) message.obj;
                Bundle data2 = message.getData();
                int i4 = data2.getInt("read_status");
                byte[] byteArray2 = data2.getByteArray("read_value");
                if (fVar2 == null) {
                    return;
                }
                if (i4 == 0) {
                    fVar2.onReceive(byteArray2);
                } else {
                    fVar2.onError((BleException) new c(i4));
                }
            } else if (i2 == 81) {
                g gVar = (g) message.obj;
                if (gVar != null) {
                    gVar.a((BleException) new e());
                }
            } else if (i2 == 82) {
                b.this.f7965e.removeMessages(81);
                g gVar2 = (g) message.obj;
                Bundle data3 = message.getData();
                int i5 = data3.getInt("rssi_status");
                int i6 = data3.getInt("rssi_value");
                if (gVar2 == null) {
                    return;
                }
                if (i5 == 0) {
                    gVar2.a(i6);
                } else {
                    gVar2.a((BleException) new c(i5));
                }
            } else if (i2 == 97) {
                d dVar = (d) message.obj;
                if (dVar != null) {
                    dVar.a((BleException) new e());
                }
            } else if (i2 != 98) {
                switch (i2) {
                    case 17:
                        e.e.a.d.e eVar = (e.e.a.d.e) message.obj;
                        if (eVar != null) {
                            eVar.onNotifyFailure(new e());
                            return;
                        }
                        return;
                    case 18:
                        b.this.a();
                        e.e.a.d.e eVar2 = (e.e.a.d.e) message.obj;
                        int i7 = message.getData().getInt("notify_status");
                        if (eVar2 == null) {
                            return;
                        }
                        if (i7 == 0) {
                            eVar2.onNotifySuccess();
                            return;
                        } else {
                            eVar2.onNotifyFailure(new c(i7));
                            return;
                        }
                    case 19:
                        e.e.a.d.e eVar3 = (e.e.a.d.e) message.obj;
                        byte[] byteArray3 = message.getData().getByteArray("notify_value");
                        if (eVar3 != null) {
                            eVar3.onCharacteristicChanged(byteArray3);
                            return;
                        }
                        return;
                    default:
                        switch (i2) {
                            case 33:
                                e.e.a.d.c cVar = (e.e.a.d.c) message.obj;
                                if (cVar != null) {
                                    cVar.a(new e());
                                    return;
                                }
                                return;
                            case 34:
                                b.this.f7965e.removeMessages(33);
                                e.e.a.d.c cVar2 = (e.e.a.d.c) message.obj;
                                int i8 = message.getData().getInt("indicate_status");
                                if (cVar2 == null) {
                                    return;
                                }
                                if (i8 == 0) {
                                    cVar2.a();
                                    return;
                                } else {
                                    cVar2.a(new c(i8));
                                    return;
                                }
                            case 35:
                                e.e.a.d.c cVar3 = (e.e.a.d.c) message.obj;
                                byte[] byteArray4 = message.getData().getByteArray("indicate_value");
                                if (cVar3 != null) {
                                    cVar3.onCharacteristicChanged(byteArray4);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                }
            } else {
                b.this.f7965e.removeMessages(97);
                d dVar2 = (d) message.obj;
                Bundle data4 = message.getData();
                int i9 = data4.getInt("mtu_status");
                int i10 = data4.getInt("mtu_value");
                if (dVar2 == null) {
                    return;
                }
                if (i9 == 0) {
                    dVar2.a(i10);
                } else {
                    dVar2.a((BleException) new c(i9));
                }
            }
        }
    }

    public b(a aVar) {
        this.f7964d = aVar;
        this.f7961a = aVar.k;
    }

    public b a(String str, String str2) {
        UUID a2 = a(str);
        UUID a3 = a(str2);
        if (a2 != null) {
            BluetoothGatt bluetoothGatt = this.f7961a;
            if (bluetoothGatt != null) {
                this.f7962b = bluetoothGatt.getService(a2);
            }
        }
        BluetoothGattService bluetoothGattService = this.f7962b;
        if (!(bluetoothGattService == null || a3 == null)) {
            this.f7963c = bluetoothGattService.getCharacteristic(a3);
        }
        return this;
    }

    public void b() {
        this.f7965e.removeMessages(49);
    }

    public final UUID a(String str) {
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }

    public void a(byte[] bArr, m mVar, String str) {
        if (bArr == null || bArr.length <= 0) {
            if (mVar != null) {
                mVar.onWriteFailure(new e.e.a.f.d("the data to be written is empty"));
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f7963c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            if (mVar != null) {
                mVar.onWriteFailure(new e.e.a.f.d("this characteristic not support write!"));
            }
            return;
        }
        if (this.f7963c.setValue(bArr)) {
            if (mVar != null) {
                b();
                mVar.setKey(str);
                mVar.setHandler(this.f7965e);
                this.f7964d.a(str, mVar);
                Handler handler = this.f7965e;
                handler.sendMessageDelayed(handler.obtainMessage(49, mVar), (long) C0102a.f7939a.f7936h);
            }
            if (!this.f7961a.writeCharacteristic(this.f7963c)) {
                b();
                if (mVar != null) {
                    mVar.onWriteFailure(new e.e.a.f.d("gatt writeCharacteristic fail"));
                }
            }
        } else if (mVar != null) {
            mVar.onWriteFailure(new e.e.a.f.d("Updates the locally stored value of this characteristic fail"));
        }
    }

    public void a() {
        this.f7965e.removeMessages(17);
    }
}
