package com.deepai.paipai.support.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.deepai.paipai.sys.service.BlueToothServiceBle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"NewApi"})
public class MyReadSend {
    public static final String ACTION_DATA_AVAILABLE = "com.example.bluetooth.le.ACTION_DATA_AVAILABLE";
    public static final String ACTION_GATT_CONNECTED = "com.example.bluetooth.le.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_CONNECTING = "com.example.bluetooth.le.ACTION_GATT_CONNECTING";
    public static final String ACTION_GATT_DISCONNECTED = "com.example.bluetooth.le.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_NONE = "com.example.bluetooth.le.ACTION_GATT_NONE";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED";
    public static final int Device_Name = 24;
    public static final String EXTRA_DATA = "com.example.bluetooth.le.EXTRA_DATA";
    public static final int Message = 21;
    public static final int STATE_GATT_CONNECTED = 2;
    public static final int STATE_GATT_CONNECTING = 1;
    public static final int STATE_GATT_DISCONNECTED = 3;
    public static final int State_Change = 23;
    /* access modifiers changed from: private */
    public static final String TAG = MyReadSend.class.getSimpleName();
    public static final int UImsg = 22;
    private static final String UUID_KEY_DATA = "0000fff1-0000-1000-8000-00805f9b34fb";
    private static final String UUID_KEY_DATA_read = "0000fff4-0000-1000-8000-00805f9b34fb";
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    /* access modifiers changed from: private */
    public BluetoothGatt mBluetoothGatt;
    private BluetoothManager mBluetoothManager;
    /* access modifiers changed from: private */
    public int mConnectionState = 3;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == 2) {
                Log.i(MyReadSend.TAG, "Connected to GATT server.");
                Log.i(MyReadSend.TAG, "Attempting to start service discovery:" + MyReadSend.this.mBluetoothGatt.discoverServices());
                Log.e("TAG7777", "Attempting to start service discovery:");
            } else if (newState == 0) {
                String intentAction = MyReadSend.ACTION_GATT_DISCONNECTED;
                MyReadSend.this.mConnectionState = 3;
                Log.i(MyReadSend.TAG, "Disconnected from GATT server.");
                MyReadSend.this.broadcastUpdate(intentAction, null);
                Log.e("TAG8888", "Attempting to start service discovery:");
            }
        }

        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == 0) {
                String intentAction = MyReadSend.ACTION_GATT_CONNECTED;
                MyReadSend.this.mConnectionState = 2;
                MyReadSend.this.broadcastUpdate(intentAction, null);
                MyReadSend.this.broadcastUpdate(MyReadSend.ACTION_GATT_SERVICES_DISCOVERED, null);
            } else {
                Log.w("TAG88888899999", "onServicesDiscovered received: " + status);
            }
            Log.w("TAG88888899999", "onServicesDiscovered received: " + status);
        }

        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            if (status == 0) {
            }
        }

        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            MyReadSend.this.broadcastUpdate(MyReadSend.ACTION_DATA_AVAILABLE, characteristic);
            Log.e("read", "**********");
        }
    };
    private ArrayList<ArrayList<BluetoothGattCharacteristic>> mGattCharacteristics = new ArrayList<>();
    BluetoothGattCharacteristic mySendgattCharacteristics;
    public Context thisContext;

    public MyReadSend(Context context) {
        this.thisContext = context;
    }

    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            this.mBluetoothManager = (BluetoothManager) this.thisContext.getSystemService("bluetooth");
            if (this.mBluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
        if (this.mBluetoothAdapter != null) {
            return true;
        }
        Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public boolean connect(String address) {
        if (this.mBluetoothAdapter == null || address == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        } else if (this.mBluetoothDeviceAddress == null || !address.equals(this.mBluetoothDeviceAddress) || this.mBluetoothGatt == null) {
            BluetoothDevice device = this.mBluetoothAdapter.getRemoteDevice(address);
            if (device == null) {
                Log.w(TAG, "Device not found.  Unable to connect.");
                return false;
            }
            this.mBluetoothGatt = device.connectGatt(this.thisContext, false, this.mGattCallback);
            Log.d(TAG, "Trying to create a new connection.");
            this.mBluetoothDeviceAddress = address;
            this.mConnectionState = 1;
            broadcastUpdate(ACTION_GATT_CONNECTING, null);
            return true;
        } else {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (!this.mBluetoothGatt.connect()) {
                return false;
            }
            this.mConnectionState = 1;
            broadcastUpdate(ACTION_GATT_CONNECTING, null);
            return true;
        }
    }

    public void disconnect() {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            this.mBluetoothGatt.disconnect();
        }
    }

    public void close() {
        if (this.mBluetoothGatt != null) {
            this.mBluetoothGatt.close();
            this.mBluetoothGatt = null;
        }
    }

    public void readCharacteristic(BluetoothGattCharacteristic characteristic) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            this.mBluetoothGatt.readCharacteristic(characteristic);
        }
    }

    public void writeCharacteristic(BluetoothGattCharacteristic characteristic) {
        if (this.mBluetoothGatt != null) {
            this.mBluetoothGatt.writeCharacteristic(characteristic);
        }
    }

    public void writeBytes(byte[] thisBytes) {
        if (this.mySendgattCharacteristics != null) {
            this.mySendgattCharacteristics.setValue(thisBytes);
            writeCharacteristic(this.mySendgattCharacteristics);
            Log.i("MyReadSend-Send", "LENG    " + thisBytes.length);
        }
    }

    public void setCharacteristicNotification(BluetoothGattCharacteristic characteristic, boolean enabled) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            this.mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);
        }
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        if (this.mBluetoothGatt == null) {
            return null;
        }
        return this.mBluetoothGatt.getServices();
    }

    /* access modifiers changed from: private */
    public void broadcastUpdate(String action, BluetoothGattCharacteristic characteristic) {
        Intent intent = new Intent(action);
        if (ACTION_GATT_CONNECTING.equals(action)) {
            BlueToothServiceBle.isConnectOK = Boolean.valueOf(false);
            this.thisContext.sendBroadcast(intent);
            if (BlueToothServiceBle.myServiceHandler != null) {
                BlueToothServiceBle.myServiceHandler.obtainMessage(23, 1, -1).sendToTarget();
            }
        } else if (ACTION_GATT_CONNECTED.equals(action)) {
            BlueToothServiceBle.isConnectOK = Boolean.valueOf(true);
            this.thisContext.sendBroadcast(intent);
            if (BlueToothServiceBle.myServiceHandler != null) {
                BlueToothServiceBle.myServiceHandler.obtainMessage(23, 2, -1).sendToTarget();
            }
        } else if (ACTION_GATT_DISCONNECTED.equals(action)) {
            BlueToothServiceBle.isConnectOK = Boolean.valueOf(false);
            this.thisContext.sendBroadcast(intent);
            if (BlueToothServiceBle.myServiceHandler != null) {
                BlueToothServiceBle.myServiceHandler.obtainMessage(23, 3, -1).sendToTarget();
            }
        } else if (ACTION_GATT_SERVICES_DISCOVERED.equals(action)) {
            displayGattServices(getSupportedGattServices());
        } else if (ACTION_DATA_AVAILABLE.equals(action)) {
            byte[] data = characteristic.getValue();
            if (data != null && data.length > 0) {
                StringBuilder stringBuilder = new StringBuilder(data.length);
                for (byte byteChar : data) {
                    stringBuilder.append(String.format("%02X ", new Object[]{Byte.valueOf(byteChar)}));
                }
                intent.putExtra(EXTRA_DATA, new String(data) + "\n" + stringBuilder.toString());
                this.thisContext.sendBroadcast(intent);
                int bytes = data.length;
                if (BlueToothServiceBle.myServiceHandler != null) {
                    BlueToothServiceBle.myServiceHandler.obtainMessage(21, bytes, -1, data).sendToTarget();
                }
            }
        }
    }

    private void displayGattServices(List<BluetoothGattService> gattServices) {
        if (gattServices != null) {
            String str = "NAME";
            String str2 = "UUID";
            String unknownServiceString = "unknown_service";
            String unknownCharaString = "unknown_characteristic";
            ArrayList<HashMap<String, String>> gattServiceData = new ArrayList<>();
            ArrayList<ArrayList<HashMap<String, String>>> gattCharacteristicData = new ArrayList<>();
            this.mGattCharacteristics = new ArrayList();
            for (BluetoothGattService gattService : gattServices) {
                HashMap<String, String> currentServiceData = new HashMap<>();
                String uuid = gattService.getUuid().toString();
                currentServiceData.put("NAME", SampleGattAttributes.lookup(uuid, unknownServiceString));
                currentServiceData.put("UUID", uuid);
                gattServiceData.add(currentServiceData);
                ArrayList<HashMap<String, String>> gattCharacteristicGroupData = new ArrayList<>();
                List<BluetoothGattCharacteristic> gattCharacteristics = gattService.getCharacteristics();
                ArrayList<BluetoothGattCharacteristic> charas = new ArrayList<>();
                for (BluetoothGattCharacteristic gattCharacteristic : gattCharacteristics) {
                    charas.add(gattCharacteristic);
                    HashMap<String, String> currentCharaData = new HashMap<>();
                    String uuid2 = gattCharacteristic.getUuid().toString();
                    currentCharaData.put("NAME", SampleGattAttributes.lookup(uuid2, unknownCharaString));
                    currentCharaData.put("UUID", uuid2);
                    gattCharacteristicGroupData.add(currentCharaData);
                    if (gattCharacteristic.getUuid().toString().equals(UUID_KEY_DATA_read)) {
                        setCharacteristicNotification(gattCharacteristic, true);
                    }
                    if (gattCharacteristic.getUuid().toString().equals(UUID_KEY_DATA)) {
                        this.mySendgattCharacteristics = gattCharacteristic;
                    }
                }
                this.mGattCharacteristics.add(charas);
                gattCharacteristicData.add(gattCharacteristicGroupData);
            }
        }
    }
}
