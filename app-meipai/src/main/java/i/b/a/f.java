package i.b.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster */
public class f extends Handler implements l {

    /* renamed from: a reason: collision with root package name */
    public final k f9749a = new k();

    /* renamed from: b reason: collision with root package name */
    public final int f9750b;

    /* renamed from: c reason: collision with root package name */
    public final c f9751c;

    /* renamed from: d reason: collision with root package name */
    public boolean f9752d;

    public f(c cVar, Looper looper, int i2) {
        super(looper);
        this.f9751c = cVar;
        this.f9750b = i2;
    }

    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f9749a.a(a2);
            if (!this.f9752d) {
                this.f9752d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                j a2 = this.f9749a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f9749a.a();
                        if (a2 == null) {
                            this.f9752d = false;
                            this.f9752d = false;
                            return;
                        }
                    }
                }
                this.f9751c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f9750b));
            if (sendMessage(obtainMessage())) {
                this.f9752d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.f9752d = false;
            throw th;
        }
    }
}
