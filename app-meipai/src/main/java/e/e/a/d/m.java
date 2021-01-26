package e.e.a.d;

import e.e.a.f.BleException;

/* compiled from: BleWriteCallback */
public abstract class m extends BleException {
    public abstract void onWriteFailure(BleException aVar);

    public abstract void onWriteSuccess(int i2, int i3, byte[] bArr);
}
