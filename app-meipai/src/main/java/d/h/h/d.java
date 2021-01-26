package d.h.h;

import android.os.Handler;
import d.h.h.c.C0037c;
import java.util.concurrent.Callable;

/* compiled from: SelfDestructiveThread */
public class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Callable f4867a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Handler f4868b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ C0037c f4869c;

    /* compiled from: SelfDestructiveThread */
    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Object f4870a;

        public a(Object obj) {
            this.f4870a = obj;
        }

        public void run() {
            d.this.f4869c.a(this.f4870a);
        }
    }

    public d(c cVar, Callable callable, Handler handler, C0037c cVar2) {
        this.f4867a = callable;
        this.f4868b = handler;
        this.f4869c = cVar2;
    }

    public void run() {
        Object obj;
        try {
            obj = this.f4867a.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f4868b.post(new a(obj));
    }
}
