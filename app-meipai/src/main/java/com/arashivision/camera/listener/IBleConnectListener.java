package com.arashivision.camera.listener;

import android.bluetooth.BluetoothGatt;
import e.e.a.e.b;
import e.e.a.f.BleException;

public interface IBleConnectListener {
    void onConnectFail(b bVar, BleException aVar);

    void onConnectSuccess(b bVar, BluetoothGatt bluetoothGatt, int i2);

    void onDisConnected(boolean z, b bVar, BluetoothGatt bluetoothGatt, int i2);

    void onStartConnect();
}
