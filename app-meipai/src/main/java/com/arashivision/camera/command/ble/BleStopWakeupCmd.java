package com.arashivision.camera.command.ble;

import android.bluetooth.le.BluetoothLeAdvertiser;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a;
import e.e.a.a.C0102a;
import e.e.a.b.b;
import e.e.a.b.c;
import e.e.a.d.k;

public class BleStopWakeupCmd implements InstaCmdExe {
    public final k mBleStopWakeupCallback;

    public BleStopWakeupCmd(k kVar) {
        this.mBleStopWakeupCallback = kVar;
    }

    private void stopWakeup() {
        a aVar = C0102a.f7939a;
        k kVar = this.mBleStopWakeupCallback;
        c cVar = aVar.f7934f;
        BluetoothLeAdvertiser bluetoothLeAdvertiser = cVar.f7942a;
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.stopAdvertising(new b(cVar, kVar));
        }
    }

    public Object exeCmd(OneDriver oneDriver) {
        stopWakeup();
        return null;
    }
}
