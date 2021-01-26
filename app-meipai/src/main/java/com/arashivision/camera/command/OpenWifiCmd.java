package com.arashivision.camera.command;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.arashivision.camera.listener.ICameraConnectionListener;
import com.arashivision.camera.strategy.ConnectStrategyImpl.HeartHandler;
import com.arashivision.onecamera.OneDriver;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class OpenWifiCmd implements InstaCmdExe {
    public static final String TAG = "com.arashivision.camera.command.OpenWifiCmd";
    public String mAddr;
    public ArrayList<ICameraConnectionListener> mCameraConnectionListeners;
    public boolean mHeartBeats;
    public HeartHandler mHeartHandler;
    public Handler mMainHandler;
    public short mPort;
    public int mToM;

    public OpenWifiCmd(int i2, String str, short s, boolean z, Handler handler, HeartHandler heartHandler, ArrayList<ICameraConnectionListener> arrayList) {
        this.mToM = i2;
        this.mAddr = str;
        this.mPort = s;
        this.mCameraConnectionListeners = arrayList;
        this.mMainHandler = handler;
        this.mHeartBeats = z;
        this.mHeartHandler = heartHandler;
    }

    private void notifyComplete(OneDriver oneDriver) {
        if (this.mHeartBeats) {
            oneDriver.sendWifiHearBeat();
            Message obtain = Message.obtain();
            obtain.what = 10;
            obtain.obj = oneDriver;
            this.mHeartHandler.sendMessageDelayed(obtain, 1500);
        }
        if (this.mCameraConnectionListeners != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    Iterator it = OpenWifiCmd.this.mCameraConnectionListeners.iterator();
                    while (it.hasNext()) {
                        ((ICameraConnectionListener) it.next()).onCameraConnect();
                    }
                }
            });
        }
    }

    private void notifyError(final int i2) {
        if (this.mCameraConnectionListeners != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    Iterator it = OpenWifiCmd.this.mCameraConnectionListeners.iterator();
                    while (it.hasNext()) {
                        ((ICameraConnectionListener) it.next()).onCameraError(i2);
                    }
                }
            });
        }
    }

    public Object exeCmd(OneDriver oneDriver) {
        Log.i(TAG, "start openwifi");
        int openWifi = oneDriver.openWifi(this.mToM, this.mAddr, this.mPort);
        if (openWifi != 0) {
            a.c("failed init wifi: ", openWifi, TAG);
            notifyError(openWifi);
            return Integer.valueOf(openWifi);
        }
        notifyComplete(oneDriver);
        Log.d(TAG, "open camera with wifi success");
        return Integer.valueOf(openWifi);
    }
}
