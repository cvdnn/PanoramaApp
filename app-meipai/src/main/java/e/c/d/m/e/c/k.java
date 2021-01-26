package e.c.d.m.e.c;

import android.bluetooth.BluetoothDevice;
import e.c.d.m.e.c.r.a;

/* compiled from: lambda */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ a f6750a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f6751b;

    public /* synthetic */ k(a aVar, BluetoothDevice bluetoothDevice) {
        this.f6750a = aVar;
        this.f6751b = bluetoothDevice;
    }

    public final void run() {
        this.f6750a.b(this.f6751b);
    }
}
