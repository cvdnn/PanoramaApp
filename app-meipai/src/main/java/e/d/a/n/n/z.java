package e.d.a.n.n;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler */
public class z {

    /* renamed from: a reason: collision with root package name */
    public boolean f7534a;

    /* renamed from: b reason: collision with root package name */
    public final Handler f7535b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler */
    public static final class a implements Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((w) message.obj).b();
            return true;
        }
    }

    public synchronized void a(w<?> wVar, boolean z) {
        if (!this.f7534a) {
            if (!z) {
                this.f7534a = true;
                wVar.b();
                this.f7534a = false;
            }
        }
        this.f7535b.obtainMessage(1, wVar).sendToTarget();
    }
}
