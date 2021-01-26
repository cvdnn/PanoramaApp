package com.yanzhenjie.permission.bridge;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import e.l.a.m.b;
import e.l.a.m.c;

public class BridgeService extends Service {

    /* renamed from: a reason: collision with root package name */
    public e.l.a.h.b.a f3975a = new a();

    public class a extends e.l.a.h.b.a {

        /* renamed from: a reason: collision with root package name */
        public c f3976a = new b(BridgeService.this);

        public a() {
        }

        public void a(String str, String[] strArr) throws RemoteException {
            BridgeActivity.a(this.f3976a, str, strArr);
        }

        public void b(String str) throws RemoteException {
            BridgeActivity.b(this.f3976a, str);
        }

        public void c(String str) throws RemoteException {
            BridgeActivity.a(this.f3976a, str);
        }

        public void d(String str) throws RemoteException {
            BridgeActivity.d(this.f3976a, str);
        }

        public void e(String str) throws RemoteException {
            BridgeActivity.f(this.f3976a, str);
        }

        public void f(String str) throws RemoteException {
            BridgeActivity.g(this.f3976a, str);
        }

        public void g(String str) throws RemoteException {
            BridgeActivity.c(this.f3976a, str);
        }

        public void a(String str) throws RemoteException {
            BridgeActivity.e(this.f3976a, str);
        }
    }

    public IBinder onBind(Intent intent) {
        e.l.a.h.b.a aVar = this.f3975a;
        if (aVar != null) {
            return aVar;
        }
        throw null;
    }
}
