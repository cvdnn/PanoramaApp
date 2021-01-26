package com.deepai.paipai.sys.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.deepai.paipai.support.ble.MyReadSend;
import com.deepai.paipai.support.utils.AppSP;

public class BlueToothServiceBle extends Service {
    public static final int CONNECTED = 1;
    public static final String DeviceName = null;
    public static boolean MicOrMusicBoolean = true;
    public static final String TOAST = null;
    static final int audioEncoding = 2;
    static final int channelConfiguration = 2;
    public static int delayTimeInt = 75;
    static final int frequency = 44100;
    public static Boolean isConnectOK = Boolean.valueOf(false);
    private static byte[] mBytes;
    public static int micLingMingDuInt = 50;
    public static boolean musicOnOffBoolen = false;
    public static final byte[] myKaiJiByte = {0, 0, 0, 8, 0, 0, 13, 10};
    public static Handler myServiceHandler = null;
    public static boolean zhiDongDaKaiBoFangQiBoolena = true;
    boolean ServiceBoolean = true;
    String addString;
    BluetoothDevice device = null;
    private int fftgeshu = 8;
    private BluetoothAdapter mBluetoothAdapter = null;
    private String mDeviceName;
    private final Handler mHandler = new Handler() {
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
                            if (BlueToothServiceBle.this.ServiceBoolean) {
                            }
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
    private float[] mPoints;
    boolean myMusicBool = false;
    MyReadSend myReadSend;
    boolean mySendBool;
    boolean mySendBoolTime = false;
    byte[] mySendByte;
    public boolean mySendOkBoolean = false;
    int mySendTimeInt = 0;
    int myShuInt = 0;
    byte[] mybyteTemp;
    int myr;
    boolean myreadBool = false;
    public int thisLen = 0;
    byte[] thisMybuf = new byte[1024];
    long thisReadTIme;

    private class MyLianYaLianJieThread extends Thread {
        private MyLianYaLianJieThread() {
        }

        public void run() {
            try {
                Thread.sleep(1000);
                if (BlueToothServiceBle.this.myReadSend != null) {
                    BlueToothServiceBle.this.myReadSend = null;
                    BlueToothServiceBle.this.myReadSend = new MyReadSend(BlueToothServiceBle.this);
                    BlueToothServiceBle.this.myReadSend.connect(BlueToothServiceBle.this.addString);
                }
                Log.i("BluetoothService", "自动连接蓝牙——MyService线程ID：" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class MySendThread extends Thread {
        private MySendThread() {
        }

        public void run() {
            while (BlueToothServiceBle.this.mySendBool) {
                if (BlueToothServiceBle.this.mySendBoolTime) {
                    try {
                        Thread.sleep(20);
                        BlueToothServiceBle.this.mySendTimeInt++;
                        if (BlueToothServiceBle.this.mySendTimeInt > 5) {
                            BlueToothServiceBle.this.mySendBoolTime = false;
                            Log.i("MyTcpUdpService", "OK-MySend-Len=" + BlueToothServiceBle.this.mySendByte.length);
                            if (BlueToothServiceBle.this.myReadSend != null) {
                                BlueToothServiceBle.this.myReadSend.writeBytes(BlueToothServiceBle.this.mybyteTemp);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void onCreate() {
        this.myreadBool = true;
        Log.i("BlueToothService", "onCreate");
        if (this.myReadSend == null) {
            this.myReadSend = new MyReadSend(this);
            Log.i("lanyalianjie", "new");
            if (!this.myReadSend.initialize()) {
                Log.e("SERVICE", "ERR");
            } else {
                this.addString = (String) AppSP.getBleAddress(this, "no");
                this.myReadSend.connect(this.addString);
            }
        }
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            this.mySendByte = intent.getByteArrayExtra("mybyte");
            sendMessage(this.mySendByte);
        }
        Log.i("BlueToothService", "onStartCommand");
        return 1;
    }

    private void sendMessage(byte[] command) {
        this.mybyteTemp = command;
        if (this.myReadSend != null) {
            this.myReadSend.writeBytes(this.mybyteTemp);
        }
        this.mySendBoolTime = true;
        this.mySendTimeInt = 0;
    }

    public void onDestroy() {
        this.mySendBool = false;
        this.myreadBool = false;
        this.myMusicBool = false;
        this.ServiceBoolean = false;
        if (this.myReadSend != null) {
            this.myReadSend.close();
            this.myReadSend = null;
        }
        Log.i("BlueToothService", "onDestroy");
        super.onDestroy();
    }
}
