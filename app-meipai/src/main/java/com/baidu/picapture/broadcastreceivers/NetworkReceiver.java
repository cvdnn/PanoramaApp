package com.baidu.picapture.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import android.util.Log;

public class NetworkReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        String str = "network-state";
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("newState", 0);
            StringBuilder sb = new StringBuilder();
            sb.append("wifiState = ");
            sb.append(intExtra);
            Log.i(str, sb.toString());
        }
        String str2 = "networkInfo";
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra(str2);
            if (parcelableExtra != null) {
                if (((NetworkInfo) parcelableExtra).getState() == State.CONNECTED) {
                    z = true;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isConnected:");
                sb2.append(z);
                Log.i(str, sb2.toString());
            }
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra(str2);
            if (networkInfo != null) {
                String str3 = "WIFI网络";
                String str4 = "";
                String str5 = "3G网络数据";
                if (State.CONNECTED != networkInfo.getState() || !networkInfo.isAvailable()) {
                    StringBuilder sb3 = new StringBuilder();
                    int type = networkInfo.getType();
                    if (type == 0) {
                        str3 = str5;
                    } else if (type != 1) {
                        str3 = str4;
                    }
                    sb3.append(str3);
                    sb3.append("断开");
                    Log.i(str, sb3.toString());
                } else if (networkInfo.getType() == 1 || networkInfo.getType() == 0) {
                    StringBuilder sb4 = new StringBuilder();
                    int type2 = networkInfo.getType();
                    if (type2 == 0) {
                        str3 = str5;
                    } else if (type2 != 1) {
                        str3 = str4;
                    }
                    sb4.append(str3);
                    sb4.append("连上");
                    Log.i(str, sb4.toString());
                }
            }
        }
    }
}
