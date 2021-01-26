package com.arashivision.onecamera.cameranotification;

import android.util.Log;
import e.a.a.a.a;

public class BTPeripheral {
    public byte[] mac_addr;
    public String name;

    private byte[] getMac_addr() {
        return this.mac_addr;
    }

    private String getName() {
        return this.name;
    }

    private void setMac_addr(byte[] bArr) {
        StringBuilder a2 = a.a(" mac len ");
        a2.append(bArr.length);
        Log.d("BTPeripheral", a2.toString());
        this.mac_addr = bArr;
    }

    private void setName(String str) {
        this.name = str;
    }
}
