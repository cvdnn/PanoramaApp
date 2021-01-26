package a.a.a.a.d;

import android.os.Handler;
import android.os.Looper;

public class b {

    /* renamed from: a reason: collision with root package name */
    public Handler f438a;

    /* renamed from: b reason: collision with root package name */
    public long f439b;

    /* renamed from: c reason: collision with root package name */
    public C0000b f440c;

    /* renamed from: d reason: collision with root package name */
    public boolean f441d;

    /* renamed from: e reason: collision with root package name */
    public boolean f442e;

    /* renamed from: f reason: collision with root package name */
    public Runnable f443f = new a();

    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public boolean f444a;

        public a() {
        }

        public void run() {
            synchronized (b.this) {
                try {
                    this.f444a = b.this.f441d;
                    if (b.this.f441d) {
                        b.this.f441d = false;
                        b.this.f442e = true;
                    }
                } finally {
                    while (true) {
                    }
                }
            }
            if (this.f444a) {
                b.this.f440c.a();
            }
        }
    }

    /* renamed from: a.a.a.a.d.b$b reason: collision with other inner class name */
    public interface C0000b {
        void a();
    }

    public b(Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        this.f438a = handler;
        this.f439b = 1000;
        this.f440c = null;
        this.f441d = false;
        this.f442e = false;
    }

    public void a() {
        synchronized (this) {
            this.f441d = false;
            this.f438a.removeCallbacks(this.f443f);
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f441d) {
                this.f438a.removeCallbacks(this.f443f);
                this.f438a.postDelayed(this.f443f, this.f439b);
            }
        }
    }

    public void c() {
        synchronized (this) {
            this.f438a.removeCallbacks(this.f443f);
            this.f438a.postDelayed(this.f443f, this.f439b);
            this.f441d = true;
            this.f442e = false;
        }
    }
}
