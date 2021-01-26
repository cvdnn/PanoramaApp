package e.l.a.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import e.l.a.b;

/* compiled from: RequestExecutor */
public final class d extends Thread implements e.l.a.h.c.a {

    /* renamed from: a reason: collision with root package name */
    public a f8932a;

    /* renamed from: b reason: collision with root package name */
    public c f8933b;

    /* renamed from: c reason: collision with root package name */
    public ServiceConnection f8934c = new a();

    /* compiled from: RequestExecutor */
    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.a(d.this, e.l.a.h.b.a.a(iBinder));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public d(a aVar) {
        this.f8932a = aVar;
    }

    public static /* synthetic */ void a(d dVar, b bVar) throws RemoteException {
        switch (dVar.f8932a.f8926b) {
            case 1:
                bVar.b(dVar.getName());
                return;
            case 2:
                bVar.a(dVar.getName(), dVar.f8932a.f8928d);
                return;
            case 3:
                bVar.g(dVar.getName());
                return;
            case 4:
                bVar.e(dVar.getName());
                return;
            case 5:
                bVar.c(dVar.getName());
                return;
            case 6:
                bVar.a(dVar.getName());
                return;
            case 7:
                bVar.d(dVar.getName());
                return;
            case 8:
                bVar.f(dVar.getName());
                return;
            default:
                return;
        }
    }

    public void run() {
        Context a2 = this.f8932a.f8925a.a();
        c cVar = new c(a2, this);
        this.f8933b = cVar;
        cVar.f8930a.registerReceiver(cVar, new IntentFilter(b.a(cVar.f8930a, getName())));
        Intent intent = new Intent();
        intent.setAction(b.a(a2, (String) null));
        intent.setPackage(a2.getPackageName());
        a2.bindService(intent, this.f8934c, 1);
    }

    public void a() {
        synchronized (this) {
            c cVar = this.f8933b;
            cVar.f8930a.unregisterReceiver(cVar);
            ((e.l.a.l.a) this.f8932a.f8927c).b();
            this.f8932a.f8925a.a().unbindService(this.f8934c);
            this.f8933b = null;
            this.f8932a = null;
        }
    }
}
