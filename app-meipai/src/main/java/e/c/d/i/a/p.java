package e.c.d.i.a;

import android.bluetooth.BluetoothDevice;
import e.c.d.d.f.b.Notifier;

/* compiled from: lambda */
public final /* synthetic */ class p implements Notifier {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f6131a;

    public /* synthetic */ p(BluetoothDevice bluetoothDevice) {
        this.f6131a = bluetoothDevice;
    }

    public final void a(Object obj) {
        ((y) obj).a(this.f6131a.getAddress(), 2);
    }
}
