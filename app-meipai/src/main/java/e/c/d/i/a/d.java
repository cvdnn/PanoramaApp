package e.c.d.i.a;

import android.bluetooth.BluetoothDevice;

import e.c.d.d.f.b.Notifier;

/* compiled from: lambda */
public final /* synthetic */ class d implements Notifier {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice bluetoothDevice;

    public /* synthetic */ d(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    public final void a(Object obj) {
        ((BleListener) obj).a(this.bluetoothDevice);
    }
}
