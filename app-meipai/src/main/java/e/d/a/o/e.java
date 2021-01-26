package e.d.a.o;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import e.c.f.n.n;
import e.d.a.j.b;

/* compiled from: DefaultConnectivityMonitor */
public final class e implements c {

    /* renamed from: a reason: collision with root package name */
    public final Context f7805a;

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.o.c.a f7806b;

    /* renamed from: c reason: collision with root package name */
    public boolean f7807c;

    /* renamed from: d reason: collision with root package name */
    public boolean f7808d;

    /* renamed from: e reason: collision with root package name */
    public final BroadcastReceiver f7809e = new a();

    /* compiled from: DefaultConnectivityMonitor */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f7807c;
            eVar.f7807c = eVar.a(context);
            if (z != e.this.f7807c) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 3)) {
                    StringBuilder a2 = e.a.a.a.a.a("connectivity changed, isConnected: ");
                    a2.append(e.this.f7807c);
                    Log.d(str, a2.toString());
                }
                e eVar2 = e.this;
                ((b) eVar2.f7806b).a(eVar2.f7807c);
            }
        }
    }

    public e(Context context, e.d.a.o.c.a aVar) {
        this.f7805a = context.getApplicationContext();
        this.f7806b = aVar;
    }

    public void a() {
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        n.a(connectivityManager, "Argument must not be null");
        boolean z = true;
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return z;
        } catch (RuntimeException e2) {
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    public void b() {
        if (this.f7808d) {
            this.f7805a.unregisterReceiver(this.f7809e);
            this.f7808d = false;
        }
    }

    public void onStart() {
        if (!this.f7808d) {
            this.f7807c = a(this.f7805a);
            try {
                this.f7805a.registerReceiver(this.f7809e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f7808d = true;
            } catch (SecurityException e2) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Failed to register", e2);
                }
            }
        }
    }
}
