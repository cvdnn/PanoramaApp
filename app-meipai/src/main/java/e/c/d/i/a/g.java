package e.c.d.i.a;

import android.bluetooth.BluetoothGatt;
import e.c.d.d.f.b.Notifier;

/* compiled from: lambda */
public final /* synthetic */ class g implements Notifier {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f6121a;

    public /* synthetic */ g(BluetoothGatt bluetoothGatt) {
        this.f6121a = bluetoothGatt;
    }

    public final void a(Object obj) {
        ((y) obj).a(this.f6121a.getDevice().getAddress(), 2);
    }
}
