package e.c.d.i.a;

import android.bluetooth.BluetoothDevice;
import e.c.d.d.f.b.Notifier;

/* compiled from: lambda */
public final /* synthetic */ class s implements Notifier {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f6134a;

    public /* synthetic */ s(BluetoothDevice bluetoothDevice) {
        this.f6134a = bluetoothDevice;
    }

    public final void a(Object obj) {
        ((BleListener) obj).a(this.f6134a);
    }
}
