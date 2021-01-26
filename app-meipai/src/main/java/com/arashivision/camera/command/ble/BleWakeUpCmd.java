package com.arashivision.camera.command.ble;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.util.Log;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import e.e.a.a;
import e.e.a.a.C0102a;
import e.e.a.b.c;
import e.e.a.d.l;
import java.util.UUID;

public class BleWakeUpCmd implements InstaCmdExe {
    public static final String TAG = "com.arashivision.camera.command.ble.BleWakeUpCmd";
    public final l mBleWakeUpListener;
    public final String mDeviceName;
    public final byte mTxPowser;
    public final int mode;

    public BleWakeUpCmd(int i2, String str, byte b2, l lVar) {
        this.mode = i2;
        this.mDeviceName = str;
        this.mTxPowser = b2;
        this.mBleWakeUpListener = lVar;
    }

    private void sendWakeUpCmd() {
        a aVar = C0102a.f7939a;
        int i2 = this.mode;
        String str = this.mDeviceName;
        byte b2 = this.mTxPowser;
        l lVar = this.mBleWakeUpListener;
        if (aVar != null) {
            String a2 = e.a.a.a.a.a("ble wakeup name = ", str);
            if (e.e.a.h.a.f8024a && a2 != null) {
                Log.d("FastBle", a2);
            }
            c cVar = aVar.f7934f;
            if (cVar.f7942a != null) {
                try {
                    Builder builder = new Builder();
                    builder.setTxPowerLevel(3);
                    builder.setAdvertiseMode(0);
                    builder.setConnectable(false);
                    builder.setTimeout(0);
                    AdvertiseSettings build = builder.build();
                    new AdvertiseData.Builder().setIncludeDeviceName(true);
                    StringBuilder sb = new StringBuilder();
                    sb.append("094F5242-4954-09FF-0F00-");
                    char[] charArray = SapiDataEncryptor.f3003a.toCharArray();
                    StringBuilder sb2 = new StringBuilder();
                    byte[] bytes = str.getBytes();
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        sb2.append(charArray[(bytes[i3] & 240) >> 4]);
                        sb2.append(charArray[bytes[i3] & 15]);
                    }
                    sb.append(sb2.toString().trim());
                    cVar.f7942a.startAdvertising(build, c.a(i2, UUID.fromString(sb.toString()), 1, 0, b2), new e.e.a.b.a(cVar, lVar));
                } catch (Exception e2) {
                    StringBuilder a3 = e.a.a.a.a.a("Fail to setup BleService ");
                    a3.append(e2.getLocalizedMessage());
                    e.e.a.h.a.a(a3.toString());
                }
            }
        } else {
            throw null;
        }
    }

    public Object exeCmd(OneDriver oneDriver) {
        sendWakeUpCmd();
        return null;
    }
}
