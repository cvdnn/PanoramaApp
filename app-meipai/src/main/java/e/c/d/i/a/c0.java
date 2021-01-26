package e.c.d.i.a;

import java.util.TimerTask;

/* compiled from: BleManager */
public class c0 extends TimerTask {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ b0 f6116a;

    public c0(b0 b0Var) {
        this.f6116a = b0Var;
    }

    public void run() {
        this.f6116a.stopScan(true);
    }
}
