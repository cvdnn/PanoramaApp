package com.baidu.picapture.common.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import e.c.d.d.b.a.C0063a;
import e.c.d.d.b.c;

public class IPCService extends Service {

    /* renamed from: a reason: collision with root package name */
    public final C0063a f1956a = new a(this);

    public class a extends C0063a {
        public a(IPCService iPCService) {
        }

        public void a(c cVar) {
            String str = cVar.f6000a;
            i.b.a.c.b().a((Object) cVar);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1956a;
    }
}
