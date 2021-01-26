package e.i.a.h.d;

import android.os.Message;
import e.i.a.h.d.j.a;

/* compiled from: RemitSyncToDBHelper */
public class k {

    /* renamed from: a reason: collision with root package name */
    public final j f8733a;

    /* renamed from: b reason: collision with root package name */
    public long f8734b = 1500;

    public k(a aVar) {
        this.f8733a = new j(aVar);
    }

    public void a(int i2) {
        this.f8733a.f8730a.removeMessages(i2);
        j jVar = this.f8733a;
        Message obtainMessage = jVar.f8730a.obtainMessage(-3);
        obtainMessage.arg1 = i2;
        jVar.f8730a.sendMessage(obtainMessage);
    }

    public boolean b(int i2) {
        return !this.f8733a.f8731b.contains(Integer.valueOf(i2));
    }
}
