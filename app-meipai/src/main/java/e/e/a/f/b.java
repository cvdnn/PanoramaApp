package e.e.a.f;

import android.bluetooth.BluetoothGatt;
import e.a.a.a.a;

/* compiled from: ConnectException */
public class b extends a {

    /* renamed from: c reason: collision with root package name */
    public BluetoothGatt f7992c;

    /* renamed from: d reason: collision with root package name */
    public int f7993d;

    public b(BluetoothGatt bluetoothGatt, int i2) {
        super(101, "Gatt Exception Occurred! ");
        this.f7992c = bluetoothGatt;
        this.f7993d = i2;
    }

    public String toString() {
        StringBuilder a2 = a.a("ConnectException{gattStatus=");
        a2.append(this.f7993d);
        a2.append(", bluetoothGatt=");
        a2.append(this.f7992c);
        a2.append("} ");
        a2.append(super.toString());
        return a2.toString();
    }
}
