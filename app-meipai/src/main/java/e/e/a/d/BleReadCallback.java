package e.e.a.d;

import e.e.a.f.BleException;

/* compiled from: BleReadCallback */
public abstract class BleReadCallback extends BleException {
    public BleReadCallback(int i2, String str) {
        super(i2, str);
    }

    public abstract void onError(BleException aVar);

    public abstract void onReceive(byte[] bArr);
}
