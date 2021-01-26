package e.e.a.d;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import e.e.a.f.BleException;

@TargetApi(18)
/* compiled from: BleGattCallback */
public abstract class b extends BluetoothGattCallback {
    public abstract void onConnectFail(e.e.a.e.b bVar, BleException aVar);

    public abstract void onConnectSuccess(e.e.a.e.b bVar, BluetoothGatt bluetoothGatt, int i2);

    public abstract void onDisConnected(boolean z, e.e.a.e.b bVar, BluetoothGatt bluetoothGatt, int i2);

    public abstract void onStartConnect();
}
