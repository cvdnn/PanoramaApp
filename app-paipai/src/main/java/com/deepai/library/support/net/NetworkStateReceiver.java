package com.deepai.library.support.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.deepai.library.support.net.NetWorkUtil.NetType;
import java.util.ArrayList;

public class NetworkStateReceiver extends BroadcastReceiver {
    private static final String ANDROID_NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String ZW_ANDROID_NET_CHANGE_ACTION = "zw.android.net.conn.CONNECTIVITY_CHANGE";
    private static ArrayList<NetChangeObserver> netChangeObserverArrayList = new ArrayList<>();
    private static NetType netType;
    private static Boolean networkAvailable = Boolean.valueOf(false);
    private static BroadcastReceiver receiver;

    private static BroadcastReceiver getReceiver() {
        if (receiver == null) {
            receiver = new NetworkStateReceiver();
        }
        return receiver;
    }

    public void onReceive(Context context, Intent intent) {
        receiver = this;
        if (intent.getAction().equalsIgnoreCase(ANDROID_NET_CHANGE_ACTION) || intent.getAction().equalsIgnoreCase(ZW_ANDROID_NET_CHANGE_ACTION)) {
            if (!NetWorkUtil.isNetworkAvailable(context)) {
                networkAvailable = Boolean.valueOf(false);
            } else {
                netType = NetWorkUtil.getAPNType(context);
                networkAvailable = Boolean.valueOf(true);
            }
            notifyObserver();
        }
    }

    public static void registerNetworkStateReceiver(Context mContext) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ZW_ANDROID_NET_CHANGE_ACTION);
        filter.addAction(ANDROID_NET_CHANGE_ACTION);
        mContext.getApplicationContext().registerReceiver(getReceiver(), filter);
    }

    public static void checkNetworkState(Context mContext) {
        Intent intent = new Intent();
        intent.setAction(ZW_ANDROID_NET_CHANGE_ACTION);
        mContext.sendBroadcast(intent);
    }

    public static void unRegisterNetworkStateReceiver(Context mContext) {
        if (receiver != null) {
            try {
                mContext.getApplicationContext().unregisterReceiver(receiver);
            } catch (Exception e) {
            }
        }
    }

    public static Boolean isNetworkAvailable() {
        return networkAvailable;
    }

    public static NetType getAPNType() {
        return netType;
    }

    private void notifyObserver() {
        for (int i = 0; i < netChangeObserverArrayList.size(); i++) {
            NetChangeObserver observer = (NetChangeObserver) netChangeObserverArrayList.get(i);
            if (observer != null) {
                if (isNetworkAvailable().booleanValue()) {
                    observer.onConnect(netType);
                } else {
                    observer.onDisConnect();
                }
            }
        }
    }

    public static void registerObserver(NetChangeObserver observer) {
        if (netChangeObserverArrayList == null) {
            netChangeObserverArrayList = new ArrayList<>();
        }
        netChangeObserverArrayList.add(observer);
    }

    public static void removeRegisterObserver(NetChangeObserver observer) {
        if (netChangeObserverArrayList != null) {
            netChangeObserverArrayList.remove(observer);
        }
    }
}
