package com.deepai.paipai.support.ble;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.deepai.paipai.sys.service.BlueToothServiceBle;

public class MyReadSendBle {
    public static Context myContext;
    public static boolean myDialogBoolean = true;
    public static Intent myIntent;
    public static Dialog thisDialog = null;
    private final Handler mHandler;

    public MyReadSendBle(Context context, Handler myHandler) {
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 21:
                        Log.i("MyService", "ReadBuf******" + msg.arg1 + "***" + (((byte[]) msg.obj)[10] & 255));
                        return;
                    case 23:
                        switch (msg.arg1) {
                            case 1:
                                Log.i("lanya", "STATE_CONNECTING");
                                byte[] bArr = new byte[3];
                                return;
                            case 2:
                                Log.i("lanya", "STATE_CONNECTED");
                                byte[] bArr2 = new byte[3];
                                return;
                            case 3:
                                byte[] bArr3 = new byte[3];
                                Log.i("lanya", "STATE_NONE");
                                return;
                            default:
                                return;
                        }
                    default:
                        return;
                }
            }
        };
        myContext = context;
        if (myIntent == null) {
            myIntent = new Intent();
            myIntent.setClass(myContext, BlueToothServiceBle.class);
        }
        BlueToothServiceBle.myServiceHandler = myHandler;
    }

    public MyReadSendBle(Context context, Handler myHandler, Dialog dialog) {
        this(context, myHandler);
        thisDialog = dialog;
    }

    public void SendByte(byte[] mysendbyte) {
        myIntent.putExtra("mybyte", mysendbyte);
        myContext.startService(myIntent);
    }

    public static void Stop() {
        if (myIntent != null) {
            myContext.stopService(myIntent);
        }
    }
}
