package e.e.a.d;

import e.e.a.f.BleException;

/* compiled from: BleIndicateCallback */
public abstract class c extends BleException {
    public abstract void a();

    public abstract void a(BleException aVar);

    public abstract void onCharacteristicChanged(byte[] bArr);
}
