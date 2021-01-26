package e.c.d.m.e.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import e.c.b.e.Utils;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.a.b0;
import e.c.d.i.a.z;
import e.c.d.m.a.c;
import e.c.d.n.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: SpinCapturePresenter */
public class u extends c<SpinCaptureContact> implements s {

    /* renamed from: b reason: collision with root package name */
    public int f6681b = 0;

    /* renamed from: c reason: collision with root package name */
    public int f6682c = 18;

    /* renamed from: d reason: collision with root package name */
    public String f6683d;

    /* renamed from: e reason: collision with root package name */
    public Boolean f6684e = Boolean.valueOf(true);

    /* renamed from: f reason: collision with root package name */
    public Boolean f6685f = Boolean.valueOf(false);

    /* renamed from: g reason: collision with root package name */
    public Timer f6686g;

    /* renamed from: h reason: collision with root package name */
    public TimerTask f6687h;

    /* renamed from: i reason: collision with root package name */
    public int f6688i = 0;

    /* renamed from: j reason: collision with root package name */
    public List<e.c.d.m.i.g.d.a> arrayList = new ArrayList();
    public int k = 0;
    public ScheduledFuture<?> l;
    public boolean m = false;
    public boolean n = false;
    public z o = new a();

    /* compiled from: SpinCapturePresenter */
    public class a implements z {
        public a() {
        }

        public /* synthetic */ void a() {
            u uVar = u.this;
            TimerTask timerTask = uVar.f6687h;
            if (timerTask != null) {
                timerTask.cancel();
                uVar.f6687h = null;
            }
            if (uVar.f6688i != 0) {
                uVar.f6688i = 3;
                if (e.f()) {
                    V v = uVar.f6403a;
                    if (v != null) {
                        ((SpinCaptureContact) v).i(true);
                    }
                } else if (!uVar.n) {
                    uVar.G();
                }
            }
        }
    }

    public u(SpinCaptureContact tVar) {
        super(tVar);
    }

    public void C() {
        int i2 = this.f6688i;
        if (i2 == 1 || i2 == 2) {
            this.n = true;
            ((SpinCaptureContact) this.f6403a).D();
            return;
        }
        if (this.f6681b == 0) {
            g();
        } else {
            ((SpinCaptureContact) this.f6403a).S();
        }
    }

    public /* synthetic */ void F() {
        ThreadPoolService.post(new c(this));
    }

    public final void G() {
        this.f6688i = 1;
        if (!this.m) {
            ((SpinCaptureContact) this.f6403a).a(String.format("%s/%02d.jpg", new Object[]{e.k(this.f6683d), Integer.valueOf(this.f6681b)}));
            ((SpinCaptureContact) this.f6403a).a(true);
            ((SpinCaptureContact) this.f6403a).i(false);
        }
    }

    public void a(Bundle bundle) {
        this.f6683d = bundle.getString("task_id", "");
        this.f6682c = bundle.getInt(Config.EXCEPTION_MEMORY_TOTAL, 36);
        this.f6685f = Boolean.valueOf(bundle.getBoolean("is_shown_capture_guide", false));
        this.f6684e = Boolean.valueOf(bundle.getBoolean("show_guide", true));
    }

    public void b(Bundle bundle) {
        bundle.putString("task_id", this.f6683d);
        bundle.putInt(Config.EXCEPTION_MEMORY_TOTAL, this.f6682c);
        bundle.putBoolean("is_shown_capture_guide", this.f6685f.booleanValue());
        bundle.putBoolean("show_guide", this.f6684e.booleanValue());
    }

    public void c() {
        if (this.f6681b == 0) {
            ((SpinCaptureContact) this.f6403a).i();
            b0 f2 = b0.impl();
            z zVar = this.o;
            if (!f2.p.contains(zVar)) {
                f2.p.registerObserver(zVar);
            }
            ((SpinCaptureContact) this.f6403a).setCircleProgressBar(this.f6681b, this.f6682c);
            if (this.k == 1) {
                e.b("is_show_spin_focus_pop", false, true);
            }
        }
        G();
    }

    public void d() {
        this.m = true;
        ScheduledFuture<?> scheduledFuture = this.l;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.l = null;
        }
    }

    public void e() {
        super.e();
        Timer timer = this.f6686g;
        if (timer != null) {
            timer.cancel();
        }
        ScheduledFuture<?> scheduledFuture = this.l;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.l = null;
        }
        b0 f2 = b0.impl();
        z zVar = this.o;
        if (f2.p.contains(zVar)) {
            f2.p.unregisterObserver(zVar);
        }
    }

    public void f(int i2) {
        if (i2 != 1 || !e.a("is_show_spin_focus_pop", true, true)) {
            V v = this.f6403a;
            if (v != null) {
                ((SpinCaptureContact) v).b(false);
            }
        } else {
            V v2 = this.f6403a;
            if (v2 != null) {
                ((SpinCaptureContact) v2).b(true);
            }
        }
        this.k = i2;
        e.b("is_capture_manual", i2 == 1, true);
        for (int i3 = 0; i3 < this.arrayList.size(); i3++) {
            if (i3 == i2) {
                ((e.c.d.m.i.g.d.a) this.arrayList.get(i3)).f6804b = true;
            } else {
                ((e.c.d.m.i.g.d.a) this.arrayList.get(i3)).f6804b = false;
            }
        }
        V v3 = this.f6403a;
        if (v3 != null) {
            ((SpinCaptureContact) v3).G();
        }
    }

    public void g() {
        ((SpinCaptureContact) this.f6403a).a();
    }

    public void i() {
        Boolean valueOf = Boolean.valueOf(!this.f6684e.booleanValue());
        this.f6684e = valueOf;
        ((SpinCaptureContact) this.f6403a).d(valueOf.booleanValue());
    }

    public void init() {
        this.f6686g = new Timer();
        this.k = e.f() ? 1 : 0;
        e.c.d.m.i.g.d.a aVar = new e.c.d.m.i.g.d.a(App.f1954b.getString(R.string.automatic_shoot), e.f());
        boolean z = true;
        e.c.d.m.i.g.d.a aVar2 = new e.c.d.m.i.g.d.a(App.f1954b.getString(R.string.manual_shoot), !e.f());
        this.arrayList.add(aVar);
        this.arrayList.add(aVar2);
        ((SpinCaptureContact) this.f6403a).a(this.arrayList, e.f() ? 1 : 0);
        int i2 = e.h().getInt("round_total_count", -1);
        this.f6682c = i2;
        if (i2 < 0) {
            this.f6682c = 36;
        }
        SpinCaptureContact tVar = (SpinCaptureContact) this.f6403a;
        if (this.f6682c != 36) {
            z = false;
        }
        tVar.g(z);
        ((SpinCaptureContact) this.f6403a).M();
    }

    public void l() {
        this.m = false;
        if (this.f6688i == 0) {
            if (TextUtils.isEmpty(this.f6683d)) {
                String k2 = Utils.k();
                this.f6683d = k2;
                ArrayList arrayList = new ArrayList();
                arrayList.add(e.j(k2));
                arrayList.add(e.k(k2));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e.b((String) it.next());
                }
            }
            if (e.a("ignore_capture_guide", true)) {
                ((SpinCaptureContact) this.f6403a).T();
            } else if (!this.f6685f.booleanValue()) {
                this.f6685f = Boolean.valueOf(true);
                ((SpinCaptureContact) this.f6403a).a0();
            }
            ((SpinCaptureContact) this.f6403a).d(this.f6684e.booleanValue());
            ((SpinCaptureContact) this.f6403a).M();
            this.f6681b = 0;
            this.f6688i = 0;
        } else if (!e.f() && this.f6688i == 1) {
            this.l = ThreadPoolService.schedule(new r(this), 500, TimeUnit.MILLISECONDS);
        }
    }

    public void s() {
        if (this.k == 1) {
            e.b("is_show_spin_focus_pop", false, true);
        }
    }

    public void x() {
        this.n = false;
        int i2 = this.f6688i;
        if (i2 == 0) {
            ((SpinCaptureContact) this.f6403a).d(this.f6683d);
        } else if (i2 == 3 && !e.f()) {
            G();
        }
    }

    public void a(String str, int i2, String str2) {
        ThreadPoolService.post(new q(this, i2, str));
    }

    public /* synthetic */ void writeCharacteristic(int i2, String str) {
        V v = this.f6403a;
        if (v != null) {
            if (i2 == -4) {
                ((SpinCaptureContact) v).e();
            } else if (i2 != 0) {
                ((SpinCaptureContact) v).f();
            } else {
                File file = new File(str);
                int i3 = -1;
                if (file.exists()) {
                    String name = file.getName();
                    int indexOf = name.indexOf(46);
                    if (indexOf >= 0) {
                        try {
                            i3 = Integer.parseInt(name.substring(0, indexOf));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                int i4 = this.f6681b;
                if (i3 == i4) {
                    int i5 = i4 + 1;
                    this.f6681b = i5;
                    ((SpinCaptureContact) this.f6403a).setCircleProgressBar(i5, this.f6682c);
                    ((SpinCaptureContact) this.f6403a).a(false);
                    if (this.f6681b >= this.f6682c) {
                        this.f6681b = 0;
                        if (this.f6688i == 1) {
                            ((SpinCaptureContact) this.f6403a).d(this.f6683d);
                            this.f6683d = "";
                        }
                        this.f6688i = 0;
                    } else {
                        this.f6688i = 2;
                    }
                    TimerTask timerTask = this.f6687h;
                    if (timerTask != null) {
                        timerTask.cancel();
                        this.f6687h = null;
                    }
                    v vVar = new v(this);
                    this.f6687h = vVar;
                    this.f6686g.schedule(vVar, (long) 5000);
                    int i6 = this.f6682c;
                    byte[] bytes = new byte[17];
                    bytes[0] = 17;
                    bytes[1] = 1;
                    bytes[2] = 0;
                    bytes[3] = 0;
                    bytes[4] = 0;
                    bytes[5] = 7;
                    if (i6 == 72) {
                        bytes[6] = 1;
                    } else if (i6 == 36) {
                        bytes[6] = 2;
                    } else {
                        bytes[6] = 4;
                    }
                    bytes[7] = 0;
                    bytes[8] = 0;
                    bytes[9] = 0;
                    bytes[10] = 0;
                    bytes[11] = 0;
                    bytes[12] = 0;
                    bytes[13] = 0;
                    bytes[14] = 0;
                    bytes[15] = 13;
                    bytes[16] = 10;
                    b0 f2 = b0.impl();
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = f2.bgcF1;
                    if (!(bluetoothGattCharacteristic == null || f2.mBluetoothGatt == null)) {
                        bluetoothGattCharacteristic.setValue(bytes);
                        f2.mBluetoothGatt.writeCharacteristic(f2.bgcF1);
                        Arrays.toString(bytes);
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        int i2 = z ? 36 : 18;
        this.f6682c = i2;
        e.h().edit().putInt("round_total_count", i2).apply();
    }
}
