package com.arashivision.ble;

import com.arashivision.ble.OneBleImplement.OneBleIOCallbacks;
import e.a.a.a.a;

public class OneBleIO {
    public long mNativeInstance;
    public OneBleIOCallbacks mOneBleIOCallbacks;

    public OneBleIO(OneBleIOCallbacks oneBleIOCallbacks) {
        this.mOneBleIOCallbacks = oneBleIOCallbacks;
    }

    private native int nativePutData(byte[] bArr);

    private native void nativeSetBleState(int i2);

    private void write(byte[] bArr) {
        StringBuilder a2 = a.a("write mBytes ");
        a2.append(bArr.length);
        e.e.a.h.a.b(a2.toString());
        OneBleIOCallbacks oneBleIOCallbacks = this.mOneBleIOCallbacks;
        if (oneBleIOCallbacks != null) {
            oneBleIOCallbacks.onWrite(bArr);
        }
    }

    public int putData(byte[] bArr) {
        return nativePutData(bArr);
    }

    public void setBleErr(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setBleErr ");
        sb.append(i2);
        e.e.a.h.a.b(sb.toString());
        nativeSetBleState(i2);
    }
}
