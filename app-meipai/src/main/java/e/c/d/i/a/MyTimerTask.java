package e.c.d.i.a;

import java.util.TimerTask;

/* compiled from: BleManager */
public class MyTimerTask extends TimerTask {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ b0 f6118a;

    public MyTimerTask(b0 b0Var) {
        this.f6118a = b0Var;
    }

    public void run() {
        b0 b0Var = this.f6118a;
        b0.a(b0Var, b0Var.mBluetoothGatt);
        this.f6118a.mBluetoothGatt = null;
    }
}
