package com.cvdnn.panorama;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.content.pm.PackageManager;
import android.reflect.Clazz;

/**
 * TODO
 */
public final class BluetoothWrapper {
    public final Application app;
    public final Context context;

    private final BluetoothAdapter mBluetoothAdapter;
    private final BluetoothLeScanner mBluetoothLeScanner;

    private String mBluetoothAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattService mBluetoothGattService;
    private BluetoothGattCharacteristic mSendCharacteristic, mReceiveCharacteristic;

    public BluetoothWrapper() {
        app = Clazz.invoke("android.app.ActivityThread", "currentApplication");
        context = app.getApplicationContext();

        // Initializes a Bluetooth adapter.
        // For API level 18 and above, get a reference to BluetoothAdapter through BluetoothManager.
//        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
//        mBluetoothAdapter = bluetoothManager.getAdapter();

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
    }

    public void scan() {

    }

    public boolean hasBleFeature() {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }

    public boolean isEnabled() {
        return mBluetoothAdapter != null && mBluetoothAdapter.isEnabled();
    }


    public void onDestroy() {
        BleEngine.disconnect(mBluetoothGatt);
        mBluetoothGatt = BleEngine.close(mBluetoothGatt);
    }
}
