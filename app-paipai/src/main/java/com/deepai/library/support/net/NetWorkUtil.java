package com.deepai.library.support.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.util.Locale;

public class NetWorkUtil {

    public static class APNNet {
        public static String CMNET = "cmnet";
        public static String CMWAP = "cmwap";
        public static String CTNET = "ctnet";
        public static String CTWAP = "ctwap";
        public static String GNET_3 = "3gnet";
        public static String GWAP_3 = "3gwap";
        public static String UNINET = "uninet";
        public static String UNIWAP = "uniwap";
    }

    public enum NetType {
        WIFI,
        CMNET,
        CMWAP,
        noneNet,
        GWAP_3,
        GNET_3,
        UNIWAP,
        UNINET,
        CTWAP,
        CTNET
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] info = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        if (info != null) {
            for (NetworkInfo state : info) {
                if (state.getState() == State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            NetworkInfo mNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            NetworkInfo mWiFiNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isMobileConnected(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo mMobileNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (mMobileNetworkInfo != null) {
            return mMobileNetworkInfo.isAvailable();
        }
        return false;
    }

    public static int getConnectedType(Context context) {
        if (context != null) {
            NetworkInfo mNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }

    public static NetType getAPNType(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null) {
            return NetType.noneNet;
        }
        int nType = networkInfo.getType();
        if (nType == 0) {
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.CMNET)) {
                return NetType.CMNET;
            }
            if (networkInfo.getExtraInfo().toUpperCase(Locale.getDefault()).equals(APNNet.CMWAP)) {
                return NetType.CMWAP;
            }
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.GNET_3)) {
                return NetType.GNET_3;
            }
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.GWAP_3)) {
                return NetType.GWAP_3;
            }
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.UNIWAP)) {
                return NetType.UNIWAP;
            }
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.UNINET)) {
                return NetType.UNINET;
            }
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.CTNET)) {
                return NetType.CTNET;
            }
            if (networkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals(APNNet.CTWAP)) {
                return NetType.CTNET;
            }
        } else if (nType == 1) {
            return NetType.WIFI;
        }
        return NetType.noneNet;
    }
}
