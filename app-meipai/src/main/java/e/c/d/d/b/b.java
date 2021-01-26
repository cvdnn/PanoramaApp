package e.c.d.d.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import e.c.d.d.b.a.C0063a;

/* compiled from: IPCClient */
public class b {

    /* renamed from: c reason: collision with root package name */
    public static volatile b f5996c;

    /* renamed from: a reason: collision with root package name */
    public a f5997a;

    /* renamed from: b reason: collision with root package name */
    public ServiceConnection f5998b = new a();

    /* compiled from: IPCClient */
    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f5997a = C0063a.a(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f5997a = null;
        }
    }

    public static b a() {
        if (f5996c == null) {
            synchronized (b.class) {
                if (f5996c == null) {
                    f5996c = new b();
                }
            }
        }
        return f5996c;
    }
}
