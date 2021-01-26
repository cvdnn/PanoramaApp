package e.e.a.d;

import e.e.a.f.BleException;

/* compiled from: BleNotifyCallback */
public abstract class e extends BleException {
    public abstract void onCharacteristicChanged(byte[] bArr);

    public abstract void onNotifyFailure(BleException aVar);

    public abstract void onNotifySuccess();
}
