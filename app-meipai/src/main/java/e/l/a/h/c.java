package e.l.a.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import e.l.a.b;

/* compiled from: Messenger */
public class c extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    public final Context f8930a;

    /* renamed from: b reason: collision with root package name */
    public final a f8931b;

    /* compiled from: Messenger */
    public interface a {
    }

    public c(Context context, a aVar) {
        this.f8930a = context;
        this.f8931b = aVar;
    }

    public static void a(Context context, String str) {
        context.sendBroadcast(new Intent(b.a(context, str)));
    }

    public void onReceive(Context context, Intent intent) {
        ((d) this.f8931b).a();
    }
}
