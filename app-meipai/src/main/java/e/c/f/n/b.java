package e.c.f.n;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import e.c.f.m.a;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: CtrlUtil */
public final class b {

    /* renamed from: b reason: collision with root package name */
    public static Lock f7046b = new ReentrantLock();

    /* renamed from: c reason: collision with root package name */
    public static b f7047c = null;

    /* renamed from: a reason: collision with root package name */
    public a f7048a;

    public b(Context context) {
        this.f7048a = new a(context);
    }

    public static b a(Context context) {
        b bVar = f7047c;
        if (bVar != null) {
            return bVar;
        }
        try {
            f7046b.lock();
            if (f7047c == null) {
                f7047c = new b(context);
            }
            return f7047c;
        } finally {
            f7046b.unlock();
        }
    }

    public final void b() {
        Message message = new Message();
        message.what = 2;
        this.f7048a.f7030a.sendMessage(message);
    }

    public final void a() {
        a aVar = this.f7048a;
        if (aVar.f7034e == null) {
            aVar.f7034e = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f7032c.getPackageName());
        sb.append(".permission.sofire.RECEIVE");
        aVar.f7032c.getApplicationContext().registerReceiver(aVar.f7034e, intentFilter, sb.toString(), null);
        Message message = new Message();
        message.what = 5;
        aVar.f7030a.sendMessage(message);
    }
}
