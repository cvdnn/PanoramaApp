package com.arashivision.camera.command;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import com.arashivision.ble.OneBleImplement.OneBleIOCallbacks;
import com.arashivision.camera.InstaCameraState;
import com.arashivision.camera.listener.IBleConnectListener;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a.C0102a;
import e.e.a.d.b;
import e.e.a.d.e;
import e.e.a.d.m;
import e.e.a.f.BleException;
import java.util.Iterator;

public class BleConnectCmd implements InstaCmdExe, OneBleIOCallbacks {
    public static final int BLE_WRITE_MAX_LEN = 20;
    public static final String SID = "be80";
    public static final String TAG = "com.arashivision.camera.command.BleConnectCmd";
    public b bleCallBack = new b() {
        public void onConnectFail(e.e.a.e.b bVar, BleException aVar) {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onConnectFail(bVar, aVar);
            }
        }

        public void onConnectSuccess(e.e.a.e.b bVar, BluetoothGatt bluetoothGatt, int i2) {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onConnectSuccess(bVar, bluetoothGatt, i2);
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    if (bluetoothGattService.getUuid().toString().contains("be80")) {
                        Iterator it = bluetoothGattService.getCharacteristics().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) it.next();
                            if ((bluetoothGattCharacteristic.getProperties() & 8) > 0) {
                                String access$100 = BleConnectCmd.TAG;
                                StringBuilder a2 = e.a.a.a.a.a("service = ");
                                a2.append(bluetoothGattService.getUuid());
                                a2.append(",getProperties ");
                                a2.append(bluetoothGattCharacteristic.getProperties());
                                a2.append(",uuid");
                                a2.append(bluetoothGattCharacteristic.getUuid());
                                Log.d(access$100, a2.toString());
                                BleConnectCmd.this.mWriteCharacteristic = bluetoothGattCharacteristic;
                                if (BleConnectCmd.this.mHeartBeats) {
                                    C0102a.f7939a.a(bVar, bluetoothGattCharacteristic.getService().getUuid().toString(), bluetoothGattCharacteristic.getUuid().toString(), new e() {
                                        public void onCharacteristicChanged(byte[] bArr) {
                                            BleConnectCmd.this.mOneDrvier.putData(bArr);
                                        }

                                        public void onNotifyFailure(BleException aVar) {
                                            String access$100 = BleConnectCmd.TAG;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("notify error ");
                                            sb.append(aVar);
                                            Log.d(access$100, sb.toString());
                                        }

                                        public void onNotifySuccess() {
                                            Log.d(BleConnectCmd.TAG, "notify success");
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
                InstaCameraState.create().changeState(2);
            }
        }

        public void onDisConnected(boolean z, e.e.a.e.b bVar, BluetoothGatt bluetoothGatt, int i2) {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onDisConnected(z, bVar, bluetoothGatt, i2);
            }
        }

        public void onStartConnect() {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onStartConnect();
            }
        }
    };
    public final IBleConnectListener bleConnectListener;
    public final e.e.a.a bleManager;
    public final e.e.a.e.b mBleDevice;
    public boolean mHeartBeats;
    public final OneDriver mOneDrvier;
    public BluetoothGattCharacteristic mWriteCharacteristic;

    public BleConnectCmd(e.e.a.e.b bVar, boolean z, IBleConnectListener iBleConnectListener, OneDriver oneDriver) {
        this.mBleDevice = bVar;
        this.bleConnectListener = iBleConnectListener;
        this.mOneDrvier = oneDriver;
        this.mHeartBeats = z;
        this.bleManager = C0102a.f7939a;
    }

    public Object exeCmd(OneDriver oneDriver) {
        BluetoothGatt a2 = this.bleManager.a(this.mBleDevice, this.bleCallBack);
        oneDriver.openBle(this);
        return a2;
    }

    public void onWrite(byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mWriteCharacteristic;
        if (bluetoothGattCharacteristic != null) {
            C0102a.f7939a.a(this.mBleDevice, bluetoothGattCharacteristic.getService().getUuid().toString(), this.mWriteCharacteristic.getUuid().toString(), bArr, new m() {
                public void onWriteFailure(BleException aVar) {
                    String access$100 = BleConnectCmd.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("write error ");
                    sb.append(aVar);
                    Log.d(access$100, sb.toString());
                }

                public void onWriteSuccess(int i2, int i3, byte[] bArr) {
                    String access$100 = BleConnectCmd.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("write success total ");
                    sb.append(i3);
                    sb.append(",current ");
                    sb.append(i2);
                    Log.d(access$100, sb.toString());
                }
            });
        }
    }
}
