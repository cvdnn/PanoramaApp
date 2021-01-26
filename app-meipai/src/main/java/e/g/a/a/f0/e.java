package e.g.a.a.f0;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager */
public class e {

    /* renamed from: c reason: collision with root package name */
    public static e f8153c;

    /* renamed from: a reason: collision with root package name */
    public final Object f8154a = new Object();

    /* renamed from: b reason: collision with root package name */
    public final Handler f8155b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: SnackbarManager */
    public class a implements Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e.this.a((c) message.obj);
            return true;
        }
    }

    /* compiled from: SnackbarManager */
    public interface b {
        void a(int i2);
    }

    /* compiled from: SnackbarManager */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        public final WeakReference<b> f8157a;
    }

    public void a(b bVar) {
        synchronized (this.f8154a) {
        }
    }

    public void b(b bVar) {
        synchronized (this.f8154a) {
        }
    }

    public void a(c cVar) {
        synchronized (this.f8154a) {
            if (cVar == null || cVar == null) {
                b bVar = (b) cVar.f8157a.get();
                if (bVar != null) {
                    this.f8155b.removeCallbacksAndMessages(cVar);
                    bVar.a(2);
                }
            }
        }
    }
}
