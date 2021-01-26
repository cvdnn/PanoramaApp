package com.baidu.picapture.broadcastreceivers;

import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import e.c.d.i.a.b0;

public class BluetoothStatusReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            String str = "android.bluetooth.adapter.extra.STATE";
            if (intent.getIntExtra(str, -1) == 10) {
                b0 f2 = b0.impl();
                f2.stopScan(false);
                BluetoothGatt bluetoothGatt = f2.mBluetoothGatt;
                if (bluetoothGatt != null) {
                    bluetoothGatt.disconnect();
                }
            } else if (intent.getIntExtra(str, -1) == 12) {
                b0.impl().init();
            }
        }
    }
}
