package e.e.a.g;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import e.e.a.d.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(18)
/* compiled from: BleScanPresenter */
public abstract class b implements LeScanCallback {

    /* renamed from: a reason: collision with root package name */
    public String[] f7997a;

    /* renamed from: b reason: collision with root package name */
    public String f7998b;

    /* renamed from: c reason: collision with root package name */
    public boolean f7999c;

    /* renamed from: d reason: collision with root package name */
    public boolean f8000d;

    /* renamed from: e reason: collision with root package name */
    public long f8001e;

    /* renamed from: f reason: collision with root package name */
    public j f8002f;

    /* renamed from: g reason: collision with root package name */
    public List<e.e.a.e.b> f8003g = new ArrayList();

    /* renamed from: h reason: collision with root package name */
    public Handler f8004h = new Handler(Looper.getMainLooper());

    /* renamed from: i reason: collision with root package name */
    public HandlerThread f8005i;

    /* renamed from: j reason: collision with root package name */
    public Handler f8006j;
    public boolean k;

    /* compiled from: BleScanPresenter */
    public class a implements Runnable {
        public a(b bVar) {
        }

        public void run() {
            e.e.a.g.f.b.f8023a.a();
        }
    }

    /* renamed from: e.e.a.g.b$b reason: collision with other inner class name */
    /* compiled from: BleScanPresenter */
    public class C0104b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ e.e.a.e.b f8007a;

        public C0104b(e.e.a.e.b bVar) {
            this.f8007a = bVar;
        }

        public void run() {
            b bVar = b.this;
            e.e.a.e.b bVar2 = this.f8007a;
            j jVar = f.this.f8022b.f8002f;
            if (jVar != null) {
                jVar.onScanning(bVar2);
            }
        }
    }

    /* compiled from: BleScanPresenter */
    public class c implements Runnable {
        public c(b bVar) {
        }

        public void run() {
            e.e.a.g.f.b.f8023a.a();
        }
    }

    /* compiled from: BleScanPresenter */
    public class d implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ boolean f8009a;

        public d(boolean z) {
            this.f8009a = z;
        }

        public void run() {
            b bVar = b.this;
            boolean z = this.f8009a;
            j jVar = f.this.f8022b.f8002f;
            if (jVar != null) {
                jVar.onScanStarted(z);
            }
        }
    }

    /* compiled from: BleScanPresenter */
    public static final class e extends Handler {

        /* renamed from: a reason: collision with root package name */
        public final WeakReference<b> f8011a;

        public e(Looper looper, b bVar) {
            super(looper);
            this.f8011a = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            String[] strArr;
            b bVar = (b) this.f8011a.get();
            if (bVar != null && message.what == 0) {
                e.e.a.e.b bVar2 = (e.e.a.e.b) message.obj;
                if (bVar2 != null) {
                    bVar.f8004h.post(new a(bVar, bVar2));
                    if (TextUtils.isEmpty(bVar.f7998b)) {
                        String[] strArr2 = bVar.f7997a;
                        if (strArr2 == null || strArr2.length < 1) {
                            bVar.a(bVar2);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(bVar.f7998b) || bVar.f7998b.equalsIgnoreCase(bVar2.b())) {
                        String[] strArr3 = bVar.f7997a;
                        if (strArr3 != null && strArr3.length > 0) {
                            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                            for (String str : bVar.f7997a) {
                                String c2 = bVar2.c();
                                if (c2 == null) {
                                    c2 = "";
                                }
                                if (bVar.f7999c) {
                                    if (!c2.contains(str)) {
                                    }
                                } else if (!c2.equals(str)) {
                                }
                                atomicBoolean.set(true);
                            }
                            if (!atomicBoolean.get()) {
                                return;
                            }
                        }
                        bVar.a(bVar2);
                    }
                }
            }
        }
    }

    public void a(String[] strArr, String str, boolean z, boolean z2, long j2, j jVar) {
        this.f7997a = strArr;
        this.f7998b = str;
        this.f7999c = z;
        this.f8000d = z2;
        this.f8001e = j2;
        this.f8002f = jVar;
        HandlerThread handlerThread = new HandlerThread(b.class.getSimpleName());
        this.f8005i = handlerThread;
        handlerThread.start();
        this.f8006j = new e(this.f8005i.getLooper(), this);
        this.k = true;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        if (bluetoothDevice != null && this.k) {
            Message obtainMessage = this.f8006j.obtainMessage();
            obtainMessage.what = 0;
            e.e.a.e.b bVar = new e.e.a.e.b(bluetoothDevice, i2, bArr, System.currentTimeMillis());
            obtainMessage.obj = bVar;
            this.f8006j.sendMessage(obtainMessage);
        }
    }

    public final void a(e.e.a.e.b bVar) {
        if (this.f8000d) {
            StringBuilder a2 = e.a.a.a.a.a("devices detected  ------  name:");
            a2.append(bVar.c());
            a2.append("  mac:");
            a2.append(bVar.b());
            a2.append("  Rssi:");
            a2.append(bVar.f7985c);
            a2.append("  scanRecord:");
            a2.append(e.e.a.h.c.a(bVar.f7984b, false));
            e.e.a.h.a.b(a2.toString());
            this.f8003g.add(bVar);
            this.f8004h.post(new a(this));
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (e.e.a.e.b bVar2 : this.f8003g) {
            if (bVar2.f7983a.equals(bVar.f7983a)) {
                atomicBoolean.set(true);
            }
        }
        if (!atomicBoolean.get()) {
            StringBuilder a3 = e.a.a.a.a.a("device detected  ------  name: ");
            a3.append(bVar.c());
            a3.append("  mac: ");
            a3.append(bVar.b());
            a3.append("  Rssi: ");
            a3.append(bVar.f7985c);
            a3.append("  scanRecord: ");
            a3.append(e.e.a.h.c.a(bVar.f7984b, true));
            e.e.a.h.a.b(a3.toString());
            this.f8003g.add(bVar);
            this.f8004h.post(new C0104b(bVar));
        }
    }

    public final void a(boolean z) {
        this.f8003g.clear();
        this.f8004h.removeCallbacksAndMessages(null);
        this.f8006j.removeCallbacksAndMessages(null);
        if (z && this.f8001e > 0) {
            this.f8004h.postDelayed(new c(this), this.f8001e);
        }
        this.f8004h.post(new d(z));
    }
}
