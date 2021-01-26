package com.deepai.paipai.support.ble;

import android.content.Context;
import android.util.Log;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.support.camera.CameraConstants;
import com.deepai.paipai.sys.service.BlueToothServiceBle;
import java.util.Arrays;

public class MyBle {
    public static String[] SERVICE_UUID_STRS = {"00001801-0000-1000-8000-00805f9b34fb", "00001800-0000-1000-8000-00805f9b34fb", "0000180a-0000-1000-8000-00805f9b34fb", "00001910-0000-1000-8000-00805f9b34fb"};
    public static final int SetAuto1 = 2;
    public static final int SetPhoto = 1;
    public static final int SetReset = 5;
    public static final int SetVideo = 0;
    public static final int getZhuangTai = 6;
    public static byte[] mySendbyte = {17, 1, 85, 1, 2, 0, 0, 0, 17, -120, -120, -120, 0, 0, 0, 13, 10};

    public static void startServiceSendBytes(MyReadSendBle myReadSendBle) {
        mySendbyte[5] = 15;
        mySendbyte[6] = 0;
        myReadSendBle.SendByte(mySendbyte);
    }

    public static void startRun(Boolean isShowToast, Context context, MyReadSendBle myReadSendBle, int leiXingByte, int suduByte, int gengXinByte) {
        if (context != null && myReadSendBle != null && isConnectOK(isShowToast, context).booleanValue()) {
            mySendbyte[5] = (byte) leiXingByte;
            mySendbyte[6] = (byte) suduByte;
            mySendbyte[7] = (byte) gengXinByte;
            myReadSendBle.SendByte(mySendbyte);
            if (leiXingByte == 2) {
                Log.d("auto1 byte", "send " + Arrays.toString(mySendbyte));
            }
        }
    }

    public static void startPhoto(Boolean isShowToast, Context context, MyReadSendBle myReadSendBle) {
        int moShi = 0;
        switch (CameraConstants.videoMode) {
            case 18:
                moShi = 0;
                break;
            case 36:
                moShi = 1;
                break;
            case 72:
                moShi = 2;
                break;
        }
        startRun(isShowToast, context, myReadSendBle, 1, (byte) moShi, 1);
    }

    public static void startAuto1(Boolean isShowToast, Context context, MyReadSendBle myReadSendBle) {
        int moShi = 0;
        switch (CameraConstants.videoMode) {
            case 18:
                moShi = 0;
                break;
            case 36:
                moShi = 1;
                break;
            case 72:
                moShi = 2;
                break;
        }
        startRun(isShowToast, context, myReadSendBle, 2, (byte) moShi, 1);
    }

    public static Boolean isConnectOK(Boolean isShowToast, Context context) {
        if (context == null) {
            return Boolean.valueOf(false);
        }
        if (BlueToothServiceBle.isConnectOK.booleanValue()) {
            return Boolean.valueOf(true);
        }
        if (isShowToast.booleanValue()) {
            ToastFactory.getToast(context, (int) R.string.ble_reconnect).show();
        }
        return Boolean.valueOf(false);
    }
}
